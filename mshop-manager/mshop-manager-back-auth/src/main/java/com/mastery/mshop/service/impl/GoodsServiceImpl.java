package com.mastery.mshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastery.mshop.dao.GoodsDao;
import com.mastery.mshop.domain.Goods;
import com.mastery.mshop.domain.PageUtil;
import com.mastery.mshop.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {
	@Autowired
    private GoodsDao goodsDao;
	
	public List<Goods> selectAll(){
        return goodsDao.selectAll();
    }

	@Override
	public int deleteOne(String gid) {
		// TODO Auto-generated method stub
		return goodsDao.deleteOne(gid);
	}

	@Override
	public Goods selectById(String gid) {
		// TODO Auto-generated method stub
		return goodsDao.selectById(gid);
	}

	@Override
	public int insertOne(Goods goods) {
		// TODO Auto-generated method stub
		return goodsDao.insertOne(goods);
	}

	@Override
	public int updateOne(Goods goods) {
		// TODO Auto-generated method stub
		return goodsDao.updateOne(goods);
	}

	public List<Goods> selectGoods(int page, int rows) {
		int start = (page-1)*rows;
		List<Goods> li = goodsDao.selectGoods(start, rows);
		return li;
	}
}
