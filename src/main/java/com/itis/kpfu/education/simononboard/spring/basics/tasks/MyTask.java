package com.itis.kpfu.education.simononboard.spring.basics.tasks;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.Callable;

public class MyTask implements Callable<String> {
    private volatile Thread executorThread;
    private final String senderName;
    private final String subject;
    private final String html;
    private final String mail;
    private final JavaMailSender mailSender;

    public MyTask(String senderName, String subject, String html, String mail, JavaMailSender mailSender) {
        this.senderName = senderName;
        this.subject = subject;
        this.html = html;
        this.mail = mail;
        this.mailSender = mailSender;
    }

    @Override
    public String call() {
        executorThread = Thread.currentThread(); // not getCurrentThread()
        MimeMessagePreparator message = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());
            messageHelper.setFrom(senderName);
            messageHelper.setTo(mail);
            messageHelper.setSubject(subject);
            messageHelper.setText(html, true);
        };
        mailSender.send(message);
        return "done";
    }

    public Thread getExecutorThread() {
        return executorThread;
    }
}