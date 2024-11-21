package cn.msa.museum.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.msa.museum.MsaMuseumApplication;

@RestController
@RequestMapping("/test")
public class LoggerController {
    private static final Logger logger = LoggerFactory.getLogger(MsaMuseumApplication.class);

    @RequestMapping("/logger")
    public String print() {
        logger.info("this is a test log");
        return "logger test";
    }

    public static void main(String[] args) {
        SpringApplication.run(LoggerController.class, args);
        LoggerController.logger.info("{} + {} = {}", 1, 1, 9);
    }
}
