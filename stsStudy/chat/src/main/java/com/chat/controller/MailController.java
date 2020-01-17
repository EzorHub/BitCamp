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
import org.springframework.web.bind.annotation.ResponseBody;

import com.chat.dao.BitMemberDao;
import com.chat.vo.BitMemberVo;

@Controller
public class MailController {

	@Autowired
	private BitMemberDao bitdao;

	public void setBitdao(BitMemberDao bitdao) {
		this.bitdao = bitdao;
	}

	@Autowired
//	private MailSender javaMailSender;
	private JavaMailSender javaMailSender;

	// 의존관계설정
	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	
	@RequestMapping("/mailPay.do")
	public String mailPay() {
		String r = "";
		SimpleMailMessage msg = new SimpleMailMessage();
		try {
			msg.setSubject("요금명세서");
			msg.setFrom("zo0313zo@gmail.com");		
			
			List<BitMemberVo> list = bitdao.listAll();
			for(BitMemberVo b : list) {
				msg.setTo(b.getEmail());
				msg.setText("이번달 요금은 "+b.getPay()+"입니다.");
				javaMailSender.send(msg);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return r;
	}

	// 요청
	
	@RequestMapping("/mail.do")
	public String mail() {
		String str = "";
		List<BitMemberVo> list = bitdao.listAll();
		System.out.println(list.size());
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		for (BitMemberVo m : list) {
					
			try {
				// javaMailSender.send(mailMessage);

				javaMailSender.send(new MimeMessagePreparator() {
					public void prepare(MimeMessage mimeMessage) throws MessagingException {
						MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
						//message.setFrom("bsy62305@naver.com"); //네이버
						message.setFrom("zo0313zo@gmail.com");						
						message.setTo(m.getEmail());
						//message.setTo("bsy62305@naver.com");
						message.setSubject("[bitMember]과금내역이메일 안내");
						message.setText("이번달 "+m.getId()+"님의 요금내역은 다음과 같습니다."+
								 "\n -------------------------------------"+
								"["+m.getPay() +"원]"+
								 "\n ------------------------------------- \n"
								 + "이용해주셔서 감사합니다.", true);
						


						message.addInline("cuties", new ClassPathResource("com/chat/img/cuties.jpg"));
						// message.addAttachment("myDocument.pdf", new
						// ClassPathResource("doc/myDocument.pdf"));
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return str;
	}

}
