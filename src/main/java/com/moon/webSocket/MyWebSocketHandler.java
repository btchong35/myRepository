package com.moon.webSocket;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

import com.alibaba.fastjson.JSON;
import com.moon.entity.Product;
import com.moon.model.BidModel;
import com.moon.model.MyMsg;
import com.moon.model.SysUser;
import com.moon.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MyWebSocketHandler extends TextWebSocketHandler {

    private Map<String, List<WebSocketSession>> clientsMap =new ConcurrentSkipListMap<String,List<WebSocketSession>>();

    //pid-出价记录记录表
    private Map<String, BidModel> bidInfoMap =new ConcurrentSkipListMap<>();

    @Autowired
    ProductService productService;

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        String pid= (String) session.getAttributes().get("pid");
        //查找对应pid的session集合
        List<WebSocketSession> list= clientsMap.get(pid);
        //从集合中删除当前session
        for(WebSocketSession e:list){
            if(e==session){
                list.remove(e);
                break;
            }
        }
        //更新map
        clientsMap.replace(pid, list);
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String pid= (String) session.getAttributes().get("pid");
        //pid不存在则添加，存在则替换
        if(!clientsMap.containsKey(pid)){
            List<WebSocketSession> list=new ArrayList<>();
            list.add(session);
            clientsMap.put(pid, list);
        }else{
            List<WebSocketSession> list= clientsMap.get(pid);
            list.add(session);
            clientsMap.replace(pid, list);
        }

    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("bidInfoMap="+bidInfoMap.toString());
        //当前用户
        SysUser user = (SysUser) session.getAttributes().get("user");
        //商品pid
        String pid= (String) session.getAttributes().get("pid");
        //当前出价
        Double bidprice=Double.parseDouble(message.getPayload());

        Double topPrice=0.0;
        Product product=productService.getProductMapper().selectByPrimaryKey(Integer.parseInt(pid));
        //判断商品是否为当前用户所有，是则不能出价
        if(product.getOwnername().equals(user.getAccount())){
            MyMsg myMsg1=new MyMsg("system",user.getAccount(),"不能对自己的商品出价！",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            System.out.println("myMsg1="+JSON.toJSONString(myMsg1));
            session.sendMessage(new TextMessage(JSON.toJSONString(myMsg1)));
        //出价时间大于截止时间，禁止出价
        }else if(new Date().compareTo(product.getEnddate())>0){
            MyMsg myMsg2=new MyMsg("system",user.getAccount(),"已超过截止时间，无法竞拍！",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            System.out.println("myMsg2="+JSON.toJSONString(myMsg2));
            session.sendMessage(new TextMessage(JSON.toJSONString(myMsg2)));
        }else {
            //如果没有出价记录，则把起拍价格放入map中
            BidModel bm=bidInfoMap.get(pid);
            if(bm==null){
                bidInfoMap.put(pid, new BidModel(user.getAccount(), product.getStartprice(), new Date()));
            }
            Double stepPrice=product.getStepprice();
            Double startPrice=bidInfoMap.get(pid).getPrice();
            //判断出价是否符合要求，符合放入map并且打印
            if(bidprice>startPrice&&((bidprice-startPrice)%stepPrice==0)){
                BidModel bidModel=new BidModel(user.getAccount(), bidprice, new Date());
                bidInfoMap.replace(pid, bidModel);
                List<WebSocketSession> list=clientsMap.get(pid);
                for(WebSocketSession e:list){
                    MyMsg myMsg3=new MyMsg(user.getAccount(), "所有人", message.getPayload(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                    e.sendMessage(new TextMessage(JSON.toJSONString(myMsg3)));

                }
            }else{
                //不符合直接提示
                MyMsg myMsg4=new MyMsg("system", user.getAccount(), "出价不符合规则，请重新出价", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                session.sendMessage(new TextMessage(JSON.toJSONString(myMsg4)));
            }
        }

    }

}
