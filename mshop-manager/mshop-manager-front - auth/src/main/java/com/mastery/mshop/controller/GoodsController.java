package com.mastery.mshop.controller;

import java.util.Date;
import java.util.UUID;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mastery.mshop.domain.PageUtil;

/**
 * 
 * Created by cr on 171215.
 *
 */
@RestController
@FeignClient(value = "mshop-manager-back-auth")
public interface GoodsController {
	@RequestMapping("/goods/list")
	public PageUtil selectAll(@RequestParam(value = "page") int page,@RequestParam(value = "rows") int rows);

	@RequestMapping(value = "/goods/delete", method = RequestMethod.POST)
	public int deleteOne(@RequestParam(value = "id") String gid, Model model);
	@RequestMapping(value = "/goods/selectOne")
	public ModelAndView selectOne(@RequestParam(value = "id") String gid, Model model);

	@RequestMapping(value = "/goods/updateOne", method = RequestMethod.POST)
	public int updateOne(@RequestParam("id") String id, @RequestParam("title") String title,
			@RequestParam("price") Long price,
			@RequestParam("num") int num, @RequestParam("barcode") String barcode, Model model);

	@RequestMapping(value = "/goods/insertOne", method = RequestMethod.POST)
	public int insertOne(@RequestParam("title") String title, 
			@RequestParam("price") long price, @RequestParam("num") int num,
			@RequestParam("barcode") String barcode, Model model);
}
