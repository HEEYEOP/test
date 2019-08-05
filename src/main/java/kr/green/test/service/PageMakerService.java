package kr.green.test.service;

import kr.green.test.pagination.Criteria;
import kr.green.test.pagination.PageMaker;

public interface PageMakerService {

	PageMaker getPageMaker(int displayPageNum, Criteria cri, int totalCount);

}
