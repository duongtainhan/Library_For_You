package android.dienty.foryou.ReadNews;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TypePage {
    private List<FeedItem> feedItemList = new ArrayList<>();

    public List<FeedItem> getPageVnExpress(String urlRss) {
        feedItemList.clear();
        try {
            Document doc = Jsoup.connect(urlRss).get();
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
    public List<FeedItem> getPageDanTri(String urlRss) {
        feedItemList.clear();
        try {
            Document doc = Jsoup.connect(urlRss).get();
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
    public List<FeedItem> getPage24H(String urlRss) {
        feedItemList.clear();
        try {
            Document doc = Jsoup.connect(urlRss).get();
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
                else {
                    description = item.select("description").html();
                    document = Jsoup.parse(description);
                    imageUrl = document.select("img").get(0).attr("src");
                    descrizione = Jsoup.parse(description.replaceAll("(?i)<br[^>]*>", "br2n")).text();
                    descriptionMain = descrizione.replaceAll("br2n", "\n");

                    if (!imageUrl.isEmpty())
                        feedItemList.add(new FeedItem(title, descriptionMain, pubDate, imageUrl, link));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return feedItemList;
    }
    public List<FeedItem> getPageKenh14(String urlRss) {
        feedItemList.clear();
        try {
            Document doc = Jsoup.connect(urlRss).get();
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
    public List<FeedItem> getPageVietNam(String urlRss)
    {
        feedItemList.clear();
        try {
            Document doc = Jsoup.connect(urlRss).get();
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
    public List<FeedItem> getPageNgoiSao(String urlRss)
    {
        feedItemList.clear();
        try {
            Document doc = Jsoup.connect(urlRss).get();
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
                    imageUrl = imageUrl.replaceAll("80_50", "200_113");
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
    public List<FeedItem> getPageGenk(String urlRss)
    {
        feedItemList.clear();
        try {
            Document doc = Jsoup.connect(urlRss).get();
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
