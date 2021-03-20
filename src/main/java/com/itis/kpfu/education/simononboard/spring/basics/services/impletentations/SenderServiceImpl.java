package com.itis.kpfu.education.simononboard.spring.basics.services.impletentations;

import com.itis.kpfu.education.simononboard.spring.basics.services.interfaces.SenderService;
import com.itis.kpfu.education.simononboard.spring.basics.tasks.MyTask;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;


@Service
@RequiredArgsConstructor
public class SenderServiceImpl implements SenderService {
    private final JavaMailSender mailSender;
    private final ExecutorService executorService;

    @Value("${sender.name}")
    private String senderName;

    @Override
    public void sendMessage(String subject, String mail, String html) {
        MyTask callable = new MyTask(senderName, subject, html, mail, mailSender);
        try {
            Future<String> task = executorService.submit(callable);
            System.out.println(task.get());
        } catch (InterruptedException | ExecutionException e) {
            StackTraceElement[] stack = callable.getExecutorThread().getStackTrace();
            for (StackTraceElement element : stack) {
                System.out.println(element);
            }
        }
    }
}
