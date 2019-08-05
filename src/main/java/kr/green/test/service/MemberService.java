package kr.green.test.service;

import kr.green.test.vo.MemberVO;

public interface MemberService {

	MemberVO getMember(String id);

	MemberVO signin(MemberVO loginInfo);

}
