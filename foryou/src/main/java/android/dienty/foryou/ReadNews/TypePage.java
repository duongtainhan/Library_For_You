package android.dienty.foryou.ReadNews;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TypePage {
    private String urlRss;
    private List<FeedItem> feedItemList = new ArrayList<>();

    public TypePage(String urlRss) {
        this.urlRss = urlRss;
    }

    public String getUrlRss() {
        return urlRss;
    }

    public List<FeedItem> getAllItems() {
        try {
            Document doc = Jsoup.connect(getUrlRss()).get();
            Elements elements = doc.select("item");
            for (Element item : elements) {
                String title = item.select("title").text();
                String link = item.select("link").text();
                String description = item.select("description").text();
                String pubDate = item.select("pubDate").text();
                Document document = Jsoup.parse(description);
                String imageUrl = "";
                try {
                    imageUrl = document.select("img").get(0).attr("src");
                } catch (Exception ex) {
                }

                String descrizione = Jsoup.parse(description.replaceAll("(?i)<br[^>]*>", "br2n")).text();
                String descriptionMain = descrizione.replaceAll("br2n", "\n");
                if (!imageUrl.isEmpty())
                    feedItemList.add(new FeedItem(title, descriptionMain, pubDate, imageUrl, link));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return feedItemList;
    }
}
