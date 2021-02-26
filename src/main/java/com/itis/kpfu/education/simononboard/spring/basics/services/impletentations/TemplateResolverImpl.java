package com.itis.kpfu.education.simononboard.spring.basics.services.impletentations;

import com.itis.kpfu.education.simononboard.spring.basics.services.interfaces.TemplateResolver;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User:  SimonOnBoard
 * Project:  spring-basic-course
 * Package:  com.itis.kpfu.education.simononboard.spring.basics.services.impletentations
 * Date:  26.02.2021
 * Time:  22:19
 */

@Service
@RequiredArgsConstructor
public class TemplateResolverImpl implements TemplateResolver {
    private final Configuration configuration;

    @Override
    public void process(String name, Map<String, String> root, Writer writer) {
        try {
            Template t = configuration.getTemplate(name);
            t.process(root, writer);
        } catch (IOException | TemplateException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public String process(String name, Map<String, String> root) {
        try {
            Template t = configuration.getTemplate(name);
            return FreeMarkerTemplateUtils.processTemplateIntoString(t, root);
        } catch (IOException | TemplateException e) {
            throw new IllegalStateException(e);
        }
    }
}
