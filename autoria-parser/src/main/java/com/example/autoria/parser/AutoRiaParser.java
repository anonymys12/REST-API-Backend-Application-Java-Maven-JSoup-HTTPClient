package com.example.autoria.parser;

import com.example.autoria.model.Car;
import com.example.autoria.util.HttpUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AutoRiaParser {

    private static final String BASE_URL = "https://auto.ria.com/uk/car/peugeot/406/";

    public List<Car> parseAllPages() {
        List<Car> allCars = new ArrayList<>();
        int page = 0;
        boolean hasNext = true;

        while (hasNext) {
            page++;
            String url = BASE_URL + "?page=" + page;
            System.out.println("Parsing page " + page);

            try {
                String html = HttpUtil.getHtml(url);
                Document doc = Jsoup.parse(html);

                Elements items = doc.select("section.ticket-item");
                if (items.isEmpty()) {
                    hasNext = false;
                    break;
                }

                for (Element item : items) {
                    String title = item.select("div.ticket-title > a").text();
                    String price = item.select("div.price-ticket > span").text();
                    String region = item.select("div.address").text();
                    String link = item.select("div.ticket-title > a").attr("href");

                    int year = 0;
                    for (String part : title.split(" ")) {
                        if (part.matches("\\d{4}")) {
                            year = Integer.parseInt(part);
                            break;
                        }
                    }

                    allCars.add(new Car("Peugeot", "406", year, price, region, link));
                }

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                hasNext = false;
            }
        }

        return allCars;
    }
}
