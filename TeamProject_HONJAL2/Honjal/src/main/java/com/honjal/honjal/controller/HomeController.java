package com.honjal.honjal.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.honjal.honjal.model.BestContentVO;
import com.honjal.honjal.model.ContentListDTO;
import com.honjal.honjal.service.ContentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class HomeController {
	
	protected final ContentService contentService;
	
	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public String home(Model model,
						@RequestParam(value="pageNum", required=false, defaultValue="1") String pageNum) {

		int intPageNum = Integer.valueOf(pageNum);
		if(intPageNum > 0) {
			model.addAttribute("PAGE_NUM", intPageNum);
		}
		contentService.contentMenuAllPage("", intPageNum, model);
		
		List<BestContentVO> bList = contentService.bestContent();
		model.addAttribute("BESTLIST", bList);
		
		List<ContentListDTO> iList = contentService.infoContent();
		model.addAttribute("INFOLIST", iList);
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		String curDate = sd.format(date);
		model.addAttribute("TODAY", curDate);
		
		return "home";
	}
	
	
}