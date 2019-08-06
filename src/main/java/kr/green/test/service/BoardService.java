package kr.green.test.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import kr.green.test.pagination.Criteria;
import kr.green.test.vo.BoardVO;

public interface BoardService {
	public ArrayList<BoardVO> getBoardList(Criteria cri, String valid);

	public int getTotalCount(Criteria cri, String valid);

	public void registerBoard(BoardVO bVO);

	public BoardVO getBoard(Integer num);

	public void modifyBoard(BoardVO bVO);

	public boolean isWriter(Integer num, HttpServletRequest r);


}
