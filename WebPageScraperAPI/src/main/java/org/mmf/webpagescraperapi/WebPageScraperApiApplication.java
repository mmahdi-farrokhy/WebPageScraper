package org.mmf.webpagescraperapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class WebPageScraperApiApplication {
    public static void main(String[] args) throws InterruptedException, IOException {
        SpringApplication.run(WebPageScraperApiApplication.class, args);
    }
}
