package com.honjal.honjal.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.ui.Model;

import com.honjal.honjal.model.BestContentVO;
import com.honjal.honjal.model.ContentListDTO;
import com.honjal.honjal.model.ContentVO;
import com.honjal.honjal.model.GoodVO;

public interface ContentService {
	
	public ContentVO findByIdContent(Integer content_num);
	// 글번호로 글찾기
	
	public void insert(ContentVO contentVO) throws Exception;
	// 글쓰기
	
	public void update(ContentVO contentVO) throws Exception;
	// 글수정
	
	public void delete(Integer content_num) throws Exception;
	// 글삭제
	
	
	public List<ContentListDTO> contentMenuAllPage(String board_code, int pageNum, Model model);
	// 페이지네이션 적용된 메뉴별 글 리스트 (각 게시판에서 사용)
	
	public int checkGood(GoodVO goodVO);
	
	public void insertGood(GoodVO goodVO);
	// 추천
	public void deleteGood(GoodVO goodVO);
	// 추천 취소
	public int getGood(Integer content_num);
	// 추천수 조회
	
	 
	public List<BestContentVO> bestContent();
	public List<ContentListDTO> infoContent();
	// 조회수
	public int view_count(ContentVO contentVO);
	
	public void addReply(ContentVO contentVO) throws Exception;
	public void reply_count(ContentVO contentVO);

}
