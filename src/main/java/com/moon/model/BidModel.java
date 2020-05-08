package com.moon.model;

import java.util.Date;

/**
 * 功能描述:<br>
 * 〈存储出价记录〉
 *
 * @author Administrator
 * @create 2020/5/3
 * @since 1.0.0
 */
public class BidModel {

    private String account;
    private Double price;
    private Date bidDate;

    public String getAccount() {
        return account;
    }

    public Double getPrice() {
        return price;
    }

    public Date getBidDate() {
        return bidDate;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setBidDate(Date bidDate) {
        this.bidDate = bidDate;
    }

    @Override
    public String toString() {
        return "BidModel{" +
                "account='" + account + '\'' +
                ", price=" + price +
                ", bidDate=" + bidDate +
                '}';
    }

    public BidModel(String account, Double price, Date bidDate) {
        this.account = account;
        this.price = price;
        this.bidDate = bidDate;
    }

    public BidModel() {
    }
}