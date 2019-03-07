import org.apache.log4j.BasicConfigurator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created by dima.
 * Creation date 07.03.19.
 */
public class HtmlParser {
    public static void main(String[] args) throws IOException {
        BasicConfigurator.configure();
        findElementInCustomPage("/home/dima/htmlparser/pages/sample-2-container-and-clone.html");
    }

    private static Logger log = LoggerFactory.getLogger(HtmlParser.class);

    private static Element findButtonByIdInOriginPage() throws IOException {
        File originPage = new File("/home/dima/htmlparser/pages/sample-0-origin.html");
        Document doc = Jsoup.parse(originPage, "UTF-8");
        return doc.getElementById("make-everything-ok-button");
    }

    private static void findButtonNameInCustomPage(Element elementInOriginPage, Document document) {
        if (elementInOriginPage != null && document != null) {
            String buttonName = elementInOriginPage.text();
            Elements allElements = document.getAllElements();
            Elements elementsMatchingOwnText = document.getElementsMatchingOwnText(buttonName);

            if (allElements.text().contains(buttonName)) {
                if (log.isInfoEnabled()) {
                    log.info("This page contain such button(s)");
                    log.info(String.valueOf(elementsMatchingOwnText));
                }
            } else {
                if (log.isInfoEnabled()) {
                    log.info("This page don't contain such button(s)");
                }
            }
        }
    }

    private static void findElementInCustomPage(String pageToScan) throws IOException {
        if (pageToScan != null) {
            File customPage = new File(pageToScan);
            Document document = Jsoup.parse(customPage, "UTF-8");
            Element elementInOriginPage = findButtonByIdInOriginPage();
            findButtonNameInCustomPage(elementInOriginPage, document);
        }
    }
}
