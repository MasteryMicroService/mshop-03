package com.mastery.mshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mastery.mshop.domain.Goods;
import com.mastery.mshop.domain.PageUtil;






public interface GoodsDao {
	 List<Goods> selectAll();
	 int deleteOne(String gid);
	 Goods selectById(String gid);
	 int updateOne(Goods goods);
	 int insertOne(Goods goods);
	 
	 List<Goods> selectGoods(@Param("start")int start, @Param("limits")int limits);
}
