package com.chat.controller;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletWebRequest;

import com.chat.dao.BitMemberDao;
import com.chat.vo.BitMemberVo;

@Controller
public class MailController2 {
	
	@Autowired
	private BitMemberDao bitdao;
	public void setBitdao(BitMemberDao bitdao) {
		this.bitdao = bitdao;
	}
	
	@Autowired
//	private MailSender javaMailSender;
	private JavaMailSender javaMailSender;
	//의존관계설정
	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	//요청
	/*
	 * @RequestMapping("/mail.do") public String mail() { String str ="";
	 * List<BitMemberVo> list = bitdao.listAll(); SimpleMailMessage mailMessage =
	 * new SimpleMailMessage(); mailMessage.setSubject("enable어쩌구실험");
	 * mailMessage.setFrom("bsy62305@naver.com");
	 * mailMessage.setText("안뇽 난 도린이라고행"); //mailMessage.setTo("msb9876@naver.com");
	 * mailMessage.setTo("kyahkim@naver.com"); try {
	 * //javaMailSender.send(mailMessage);
	 * 
	 * javaMailSender.send(new MimeMessagePreparator() { public void
	 * prepare(MimeMessage mimeMessage) throws MessagingException {
	 * MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true,
	 * "UTF-8"); message.setFrom("bsy62305@naver.com"); //
	 * message.setTo("msb9876@naver.com"); message.setTo("kyahkim@naver.com");
	 * message.setSubject("빵양 안뇽~"); message.setText("이거 폭탄이지롱^^", true);
	 * 
	 * message.addInline("homer", new ClassPathResource("com/chat/img/homer.jpg"));
	 * //message.addAttachment("myDocument.pdf", new
	 * ClassPathResource("doc/myDocument.pdf")); } }); }catch (Exception e) {
	 * e.printStackTrace(); } return str; }
	 */
	
	

}
