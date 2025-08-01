package org.mmf.webpagescraperapi.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.mmf.webpagescraperapi.domain.EscapeRoomScenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Time4FunEscapeRoomScraper implements WebScraper {
    private static final String BASE_URL = "https://www.t4f.ir/search/type-escape-room?page=";
    private static final int TOTAL_PAGES = 32;
    public static final String SCENARIO_CARD_SELECTOR = "article.flex.gap-4.w-full";
    public static final String SCENARIO_TITLE_SELECTOR = "h3.Text_h3__UWp9b";
    public static final String SCENARIO_ADDRESS_SELECTOR = "div.flex.justify-start.gap-1 > span.text-xs";
    public static final String SCENARIO_DIFFICULTY_SELECTOR = "div.flex.items-center.gap-1 > span.text-xs";
    public static final String SCENARIO_GENRES_SELECTOR = "div.flex.justify-start.gap-1 > span.text-xs";
    public static final String SCENARIO_LINK_SELECTOR = "a[href^='/fun/']";

    @Override
    public List<EscapeRoomScenario> getEscapeRoomScenarios() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        List<EscapeRoomScenario> scenarios = new ArrayList<>();

        for (int i = 1; i <= TOTAL_PAGES; i++) {
            driver.get(BASE_URL + i);
            Thread.sleep(3000);

            Document doc = Jsoup.parse(driver.getPageSource());
            Elements cards = doc.select(SCENARIO_CARD_SELECTOR);


            for (Element card : cards) {
                String title = card.select(SCENARIO_TITLE_SELECTOR).text(); // <h3> with specific class
                String address = card.select(SCENARIO_ADDRESS_SELECTOR).first().text();
                String difficulty = card.select(SCENARIO_DIFFICULTY_SELECTOR).first().text();
                String genre = card.select(SCENARIO_GENRES_SELECTOR).get(1).text();
                String link = card.select(SCENARIO_LINK_SELECTOR).attr("href");

                Elements allElements = card.getAllElements();
                Element imageElement = allElements.get(12);
                String imageUrl = imageElement.attributes().get("src");

                scenarios.add(new EscapeRoomScenario(title, address, difficulty, genre, link, imageUrl));
            }

            System.out.println("Page " + i + " scraped.");
        }

        driver.quit();
        return scenarios;
    }
}
