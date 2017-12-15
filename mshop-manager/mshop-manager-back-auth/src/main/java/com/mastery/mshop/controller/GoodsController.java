package com.mastery.mshop.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mastery.mshop.domain.Goods;
import com.mastery.mshop.domain.PageUtil;
import com.mastery.mshop.service.GoodsService;

@RestController
public class GoodsController {
	@Autowired
	private GoodsService goodsService;

//	@RequestMapping("/goods/list")
//	public List selectAll() {
//		List<Goods> goods = goodsService.selectAll();
//		return goods;
//	}
	@RequestMapping("/goods/list")
	public PageUtil selectAll(@RequestParam(value = "page") int page,@RequestParam(value = "rows") int rows) {
		PageUtil pu = new PageUtil();
		List<Goods> goodsAll = goodsService.selectAll();
		List<Goods> goods = goodsService.selectGoods(page, rows);
		pu.setRows(goods);
		pu.setTotal(goodsAll.size());
		return pu;
	}
	@RequestMapping(value = "/goods/delete", method = RequestMethod.POST)
	public int deleteOne(@RequestParam(value = "id") String gid, Model model) {
		int temp = goodsService.deleteOne(gid);
		return temp;
	}

	@RequestMapping(value = "/goods/selectOne")
	public ModelAndView selectOne(@RequestParam(value = "id") String gid, Model model) {
		Goods goods = goodsService.selectById(gid);
		System.out.println(goods.getTitle());
		model.addAttribute("OneGoods", goods);
		return new ModelAndView("update");
	}

	@RequestMapping(value = "/goods/updateOne", method = RequestMethod.POST)
	public int updateOne(@RequestParam("id") String id, @RequestParam("title") String title,
			@RequestParam("price") Long price,
			@RequestParam("num") int num, @RequestParam("barcode") String barcode, Model model) {
		Goods goods = new Goods();
		goods.setId(id);
		goods.setTitle(title);
		goods.setPrice(price);
		goods.setNum(num);
		goods.setBarcode(barcode);
		goods.setCreated(new Date());
		int temp = goodsService.updateOne(goods);
		return temp;
	}

	@RequestMapping(value = "/goods/insertOne", method = RequestMethod.POST)
	public int insertOne(@RequestParam("title") String title, 
			@RequestParam("price") long price, @RequestParam("num") int num,
			@RequestParam("barcode") String barcode, Model model) {
		Goods goods = new Goods();
		String t = UUID.randomUUID().toString().replaceAll("-", "");
		goods.setId(t);
		goods.setTitle(title);
		goods.setPrice(price);
		goods.setNum(num);
		goods.setBarcode(barcode);
		goods.setCreated(new Date());
		int temp = goodsService.insertOne(goods);
		return temp;
	}

}
