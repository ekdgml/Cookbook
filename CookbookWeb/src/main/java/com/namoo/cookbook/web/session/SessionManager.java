package com.namoo.cookbook.web.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 로그인 세션을 관리하는 클래스
 * 
 * @author kosta-18
 *
 */
public class SessionManager {
	//
	private static final String LOGIN_ID="namoouser";
	private static final String PASSWORD="namoouser";
	
	private HttpSession session;
	
	//-----------------------------------------------------------------------------------------------------------------
	//constructor
	
	/**
	 * 생성자
	 * @param req
	 */
	public SessionManager(HttpServletRequest req) {
		//
		session = req.getSession();
	 }
	
	//------------------------------------------------------------------------------------------------------------------
	
	/**
	 * 로그인하기
	 * 
	 * @param userId
	 * @param password
	 * @return
	 */
	public boolean login(String userId, String password) {
		//
		if (LOGIN_ID.equals(userId) && PASSWORD.equals(password)) {
			session.setAttribute("loginId", userId);
			return true;
		} else {
			session.invalidate();
			return false;
		}
	}
	
	/**
	 * 로그아웃하기
	 */
	public void logout() {
		//
		session.invalidate();
	}
	
	/**
	 * 로그인 여부 확인하기
	 * @return
	 */
	public boolean isLogin() {
		//
		return session.getAttribute("loginId") != null ? true : false;
	}
}
