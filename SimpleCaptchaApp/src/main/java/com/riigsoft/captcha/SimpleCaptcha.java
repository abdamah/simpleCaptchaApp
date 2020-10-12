package com.riigsoft.captcha;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

import cn.apiclub.captcha.Captcha;
import cn.apiclub.captcha.backgrounds.FlatColorBackgroundProducer;
import cn.apiclub.captcha.backgrounds.GradiatedBackgroundProducer;
import cn.apiclub.captcha.backgrounds.SquigglesBackgroundProducer;
import cn.apiclub.captcha.backgrounds.TransparentBackgroundProducer;
import cn.apiclub.captcha.noise.CurvedLineNoiseProducer;
import cn.apiclub.captcha.text.producer.ChineseTextProducer;
import cn.apiclub.captcha.text.producer.DefaultTextProducer;

public class SimpleCaptcha {

	// 1. Create Captcha
	public static Captcha createCaptcha(int width, int height) {
		return new Captcha.Builder(width, height)
				.addBackground(new GradiatedBackgroundProducer(Color.BLUE, Color.GREEN))
				.addText(new DefaultTextProducer()).addNoise(new CurvedLineNoiseProducer(Color.RED, 3.5f)).build();
	}
	// 2. create Image of Captcha

	public static void createImage(Captcha captcha) {
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			ImageIO.write(captcha.getImage(), "png", os);
			FileOutputStream fos = new FileOutputStream("D:/captcha/captcha.png");
			fos.write(os.toByteArray());
			fos.flush();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
