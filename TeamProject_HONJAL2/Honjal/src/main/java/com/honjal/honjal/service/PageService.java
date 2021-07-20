package com.honjal.honjal.service;

import com.honjal.honjal.model.PageDTO;

public interface PageService {
	public PageDTO makePagination(int totalContents, int clickPage);
}
