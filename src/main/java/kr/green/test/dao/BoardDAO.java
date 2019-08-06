package kr.green.test.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.test.pagination.Criteria;
import kr.green.test.vo.BoardVO;

public interface BoardDAO {
	public ArrayList<BoardVO> selectBoardList(@Param("cri")Criteria cri, @Param("valid")String valid);

	public int selectCountBoardList(@Param("cri")Criteria cri, @Param("valid")String valid);

	public void insertBoard(@Param("board")BoardVO bVO);

	public BoardVO selectBoard(@Param("num")Integer num);

	public void updateBoard(@Param("board")BoardVO bVO);

}
