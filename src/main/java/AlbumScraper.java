import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class AlbumScraper {
    public static void main(String[] args) {
        getAlbumArtURL("spice girls");
    }

    public static String getAlbumArtURL(String query) {
        try {
            String url = " https://www.discogs.com/search/?q=" + query + "&type=all";
            Document doc = Jsoup.connect(url).get();

            Elements albumCovers = doc.select(".thumbnail_center");
            Element span = albumCovers.get(0);
            Element img = span.child(0);
            String src = img.attr("data-src");
            System.out.println(src);
            return src;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            return "/Users/amycohen/codefellows/401/lab-amy/10-album-art-server/src/main/resources/no-record-found.jpg";
        }
        return "/Users/amycohen/codefellows/401/lab-amy/10-album-art-server/src/main/resources/no-record-found.jpg";
    }
}
