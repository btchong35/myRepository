package com.moon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.moon.utils.BaseController;
import com.moon.entity.Auctionroom;
import com.moon.service.AuctionroomService;

@Controller
@RequestMapping("/moon/Auctionroom")
public class AuctionroomController extends BaseController {
	@Autowired
	private AuctionroomService auctionroomService;

}