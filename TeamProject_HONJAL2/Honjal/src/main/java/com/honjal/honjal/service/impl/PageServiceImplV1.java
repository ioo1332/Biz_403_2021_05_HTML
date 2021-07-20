package com.honjal.honjal.service.impl;

import org.springframework.stereotype.Service;

import com.honjal.honjal.model.PageDTO;
import com.honjal.honjal.service.PageService;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
// Setter 꼭 써야하나
@Service("pageServiceV1")
public class PageServiceImplV1 implements PageService {
	
	protected int contentsPerPage = 10;
	protected int navsPerPage = 10;

	@Override
	public PageDTO makePagination(int totalContents, int intPageNum) {

		if(totalContents < 1) {
			PageDTO pageDTO = PageDTO.builder().startPage(1).endPage(1).totalPages(1).offset(0).limit(0).build();
			return pageDTO;
		};
		// 이해 필요 : 굳이 있어야 되나
		// 수정 -> 게시판에 글이 하나도 없으면 null이 반환돼버리고 오류가 뜬다
		
		int totalPages = (int)Math.ceil((double)totalContents / (double) this.contentsPerPage);
		// 이해 필요 : Math.ceil() 아닌가
		// 총페이지수 = 총글수를 페이지당표시할글수로 나누고 반올림
		
		log.debug("totalPages {}", totalPages);
		
		int startPage = intPageNum - (intPageNum%10) + 1;
		// 페이지nav의 제일 앞(왼쪽) 페이지 번호 = 클릭한페이지에서 표시하는 페이지의 수를 절반으로 나눈 걸 뺌
		// 수정 -> 선택한 페이지의 일의자리 숫자를 빼고 1을 더함
//		startPage = startPage < 1 ? 1 : startPage;
		// startPage가 1보다 작으면 1로 설정한다 (0페이지,마이너스페이지는 없으니까)
		
		int endPage = startPage + 9;
		// 페이지nav의 제일 뒤(오른쪽) 페이지 변호 = startPage에 표시하는페이지수-1 한 값을 더함
		// 수정 -> 제일 왼쪽 페이지 번호 + 9
		endPage = endPage > totalPages ? totalPages : endPage;
		// endPage가 총페이지수 숫자보다 크면 총페이지수를 endPage로
		
		int offset = (intPageNum - 1) * this.contentsPerPage;
		// 이해 필요 : 뒷부분 연산은 지금 클릭한 페이지의 전페이지까지의 글개수아닌가
		// 꽉찬페이지까지의 글개수 = 클릭한 페이지의 이전페이지 숫자에 한 페이지당 보이는 글 개수를 곱한 값
		
		
		int limit = offset + this.contentsPerPage;
		// (임시초기화) 끝페이지에 남는 글수 = 꽉찬페이지까지의글개수 + 한 페이지당 글 개수
		limit = limit > totalContents ? totalContents : limit;
		// (제대로값넣음) 끝페이지에 남는 글수 = 전체글수보다 크다면 전체 글 수로, 아니면 그대로
		
		PageDTO pageDTO = PageDTO.builder().totalPages(totalPages).startPage(startPage).endPage(endPage).offset(offset).limit(limit).build();
		
		return pageDTO;
	}

}
