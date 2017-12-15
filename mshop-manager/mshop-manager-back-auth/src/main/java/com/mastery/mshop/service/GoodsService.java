package com.mastery.mshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastery.mshop.domain.Goods;
import com.mastery.mshop.domain.PageUtil;


public interface GoodsService {

	public List<Goods> selectAll();

	public int deleteOne(String gid);

	public Goods selectById(String uid);

	public int insertOne(Goods goods);

	public int updateOne(Goods goods);

	List<Goods> selectGoods(int page, int rows);

}
