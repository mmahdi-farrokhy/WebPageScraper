package mmf;

import com.opencsv.CSVWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String BASE_URL = "https://www.t4f.ir/search/type-escape-room?page=";
    private static final int TOTAL_PAGES = 32;

    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        List<String[]> records = new ArrayList<>();
        records.add(new String[]{"Title", "City", "Difficulty", "Scare Level", "Link"});

        for (int i = 1; i <= TOTAL_PAGES; i++) {
            driver.get(BASE_URL + i);
            Thread.sleep(3000); // wait for JS to render

            Document doc = Jsoup.parse(driver.getPageSource());
            Elements cards = doc.select("article.flex.gap-4.w-full"); // Matches the <article> container



            for (Element card : cards) {
                String title = card.select("h3.Text_h3__UWp9b").text(); // <h3> with specific class
                String address = card.select("div.flex.justify-start.gap-1 > span.text-xs").first().text();
                String difficulty = card.select("div.flex.items-center.gap-1 > span.text-xs").first().text();
                String genre = card.select("div.flex.justify-start.gap-1 > span.text-xs").get(1).text();
                String link = card.select("a[href^='/fun/']").attr("href");

                records.add(new String[]{title, address, difficulty, genre, link});
            }

            System.out.println("Page " + i + " scraped.");
        }

        driver.quit();

        try (CSVWriter writer = new CSVWriter(
                new OutputStreamWriter(new FileOutputStream("t4f_scenarios.csv"), StandardCharsets.UTF_8))) {
            writer.writeAll(records);
        }

        System.out.println("✅ Data saved to t4f_scenarios.csv");
    }
}