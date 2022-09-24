package com.cakmak.SpringEmailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class SpringEmailSenderApplication {
	@Autowired
	private EmailSenderService senderService;

	public static void main(String[] args) {
		SpringApplication.run(SpringEmailSenderApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
		senderService.sendSimpleEmail("tr.mehmetcakmak@gmail.com",
				"This is email body",
				"This is email subject");

	}
}
