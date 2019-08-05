package kr.green.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.test.service.MemberService;
import kr.green.test.vo.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView mainGet(ModelAndView mv) throws Exception{
	    mv.setViewName("/main/home");
	    mv.addObject("setHeader", "타일즈");
	    return mv;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String mainPost(MemberVO loginInfo) throws Exception{
	    //System.out.println(loginInfo);
	    MemberVO user = memberService.signin(loginInfo);
	    System.out.println(user);
		return "redirect:/";
	}

	
}
