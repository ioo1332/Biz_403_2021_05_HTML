package com.honjal.honjal.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.honjal.honjal.model.CommentVO;

public interface CommentService {
	public List<CommentVO> selectAll(CommentVO commentVO);
	
	public void insert(CommentVO commentVO);
	
	public void update(CommentVO contentVO);
	
	public void delete(Integer content_num);
	
	
	
}
