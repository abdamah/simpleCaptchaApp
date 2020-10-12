package com.riigsoft.test;

import com.riigsoft.captcha.SimpleCaptcha;


public class SimpleCaptchaTest {

	public static void main(String[] args) {
		SimpleCaptcha.createImage(SimpleCaptcha.createCaptcha(200, 80));
		
		
		System.out.println("Simple Captcha Created !!!");
	}

}
