package scrap;

import java.io.IOException;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class app {

	public static void main(String[] args) {
		try {
		Document doc = Jsoup.connect("https://www.indeed.com/jobs?q=developer&l=Detroit%2C+MI").userAgent("mozilla/17.0").get();
		Elements temp = doc.select("h2.title");
		Elements link = doc.select("h2.title > a");
		String url = link.attr("href");
		int i=0;
		for(Element resultsBody:temp)
		{
			i++;
			System.out.println(i+" "+resultsBody.getElementsByTag("a").first().text());
			System.out.println("https://www.indeed.com"+url);
			// Elements s = resultsBody.getElementsByTag("a");
			// System.out.println(s);
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
	}

}
