package kr.green.test.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.green.test.pagination.Criteria;
import kr.green.test.pagination.PageMaker;
import kr.green.test.service.BoardService;
import kr.green.test.service.MemberService;
import kr.green.test.service.PageMakerService;
import kr.green.test.utils.UploadFileUtils;
import kr.green.test.vo.BoardVO;
import kr.green.test.vo.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	@Autowired
	PageMakerService pageMakerService;
	@Resource
	private String uploadPath;
	
	
	@RequestMapping(value="/board/list", method=RequestMethod.GET)
	public ModelAndView boardListGet(ModelAndView mv, Criteria cri) {
		mv.setViewName("/board/list");

		String valid = "I";
		int displayPageNum = 2;
		ArrayList<BoardVO> list = boardService.getBoardList(cri, valid);
		int totalCount = boardService.getTotalCount(cri,valid);
		PageMaker pm = pageMakerService.getPageMaker(displayPageNum,cri,totalCount);
		//System.out.println(pm);
		mv.addObject("list", list);
		mv.addObject("pageMaker", pm);
	    return mv;
	}
	
	@RequestMapping(value="/board/register", method=RequestMethod.GET)
	public ModelAndView boardRegisterGet(ModelAndView mv) {
		mv.setViewName("/board/register");
	    return mv;
	}
	
	@RequestMapping(value="/board/register", method=RequestMethod.POST)
	public String boardRegisterPost(BoardVO bVO, MultipartFile file2) throws IOException, Exception {
		//System.out.println(bVO);
		
		String file = UploadFileUtils.uploadFile(uploadPath, file2.getOriginalFilename(), file2.getBytes());
		bVO.setFile(file);
		boardService.registerBoard(bVO);
	    return "redirect:/board/list";
	}
	
	@RequestMapping(value="/board/display", method=RequestMethod.GET)
	public ModelAndView boardDisplayGet(ModelAndView mv, Integer num, Criteria cri) {
		BoardVO board = boardService.getBoard(num);
		
		board = boardService.increaseViews(board); //-??????????????????????????????????
		
		mv.setViewName("/board/display");
		mv.addObject("board", board);
		mv.addObject("cri", cri);
	    return mv;
	}
	
	@RequestMapping(value="/board/modify", method=RequestMethod.GET)
	public ModelAndView boardModifyGet(ModelAndView mv, Integer num, Criteria cri, HttpServletRequest r) {
		
		boolean isWriter = boardService.isWriter(num,r);
		BoardVO board;
		if(isWriter) {
			 board = boardService.getBoard(num);
			 mv.setViewName("/board/modify");
		}else{
			 board = null;
			 mv.setViewName("redirect:/board/list");
		}
		
		mv.addObject("board", board);
		mv.addObject("cri", cri);
	    return mv;
	}
	
	@RequestMapping(value="/board/modify", method=RequestMethod.POST)
	public String boardModifyPost(BoardVO bVO) {
		//System.out.println(bVO);
		boardService.modifyBoard(bVO);
		return "redirect:/board/display";
	}
	
	@RequestMapping(value="/board/delete", method=RequestMethod.GET)
	public ModelAndView boardDeleteGet(ModelAndView mv, Integer num, HttpServletRequest r) {
		if(boardService.isWriter(num, r))
			boardService.deleteBoard(num);
		mv.setViewName("redirect:/board/list");
	    return mv;
	}
	
	@ResponseBody
	@RequestMapping(value="/board/download")
	public ResponseEntity<byte[]> downloadFile(String fileName)throws Exception{
	    InputStream in = null;
	    ResponseEntity<byte[]> entity = null;
	    try{
	        String FormatName = fileName.substring(fileName.lastIndexOf(".")+1);
	        HttpHeaders headers = new HttpHeaders();
	        in = new FileInputStream(uploadPath+fileName);

	        fileName = fileName.substring(fileName.indexOf("_")+1);
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	        headers.add("Content-Disposition",  "attachment; filename=\"" 
				+ new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
	        entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers,HttpStatus.CREATED);
	    }catch(Exception e) {
	        e.printStackTrace();
	        entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
	    }finally {
	        in.close();
	    }
	    return entity;
	}
	
	

	
}
