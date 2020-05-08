package com.moon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.moon.entity.Auctionroom;
import com.moon.dao.AuctionroomMapper;

@Transactional
@Service
public class AuctionroomService {
	@Autowired
	private AuctionroomMapper auctionroomMapper;

	public AuctionroomMapper getAuctionroomMapper() {
		return auctionroomMapper;
	}

}