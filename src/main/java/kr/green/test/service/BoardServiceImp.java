package kr.green.test.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.test.dao.BoardDAO;
import kr.green.test.pagination.Criteria;
import kr.green.test.vo.BoardVO;
import kr.green.test.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	BoardDAO boardDao;
	
	@Override
	public ArrayList<BoardVO> getBoardList(Criteria cri, String valid) {
		return boardDao.selectBoardList(cri, valid);
	}

	@Override
	public int getTotalCount(Criteria cri, String valid) {
		
		return boardDao.selectCountBoardList(cri, valid);
	}

	@Override
	public void registerBoard(BoardVO bVO) {
		boardDao.insertBoard(bVO);
		
		
	}

	@Override
	public BoardVO getBoard(Integer num) {
		return boardDao.selectBoard(num);
	}

	@Override
	public void modifyBoard(BoardVO bVO) {
		BoardVO tmp = boardDao.selectBoard(bVO.getNum());
		bVO.setValid(tmp.getValid());
		bVO.setViews(tmp.getViews());
		
		boardDao.updateBoard(bVO);
	}

	@Override
	public boolean isWriter(Integer num, HttpServletRequest r) {
		BoardVO board = boardDao.selectBoard(num);
		MemberVO user =(MemberVO)(r.getSession().getAttribute("user"));
		if(board != null && board.getWriter().equals(user.getId())) {
			return true;
		}

		return false;
	}

	@Override
	public void deleteBoard(Integer num) {
		BoardVO board = boardDao.selectBoard(num);
		if(board == null)
			return;
		board.setValid("D");
		boardDao.updateBoard(board);
	}

	@Override
	public BoardVO increaseViews(BoardVO board) {
		int views = board.getViews();
		board.setViews(views+1);
		boardDao.updateBoard(board);
		return board;
		
	}

}
