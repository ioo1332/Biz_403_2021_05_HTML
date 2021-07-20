package com.honjal.honjal.dao.ext;

import com.honjal.honjal.dao.GenericDao;
import com.honjal.honjal.model.ContentVO;
import com.honjal.honjal.model.GoodVO;

public interface ContentGoodDao extends GenericDao<ContentVO, Integer>{

	public int checkGood(GoodVO goodVO);
	
	public void insertGood(GoodVO goodVO);
	public void insertUpGood(GoodVO goodVO);
	
	public void deleteGood(GoodVO goodVO);
	public void deleteUpGood(GoodVO goodVO);
	
	public int getGood(Integer content_num);
	
	
	
	
}
