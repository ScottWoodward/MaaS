package com.binaryphoenixstudios.maas.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class WikipediaTokenSourceHandler extends AbstractTokenSourceHandler implements TokenSourceHandler
{
	@Override
	protected List<String> getStringsFromSource(String source)
	{
		List<String> strings = new ArrayList<>();
		String html = getHtmlFromWikipedia(source);
		//Parse the HTML to text.
		Document document = Jsoup.parse(html);
		//Remove the references
		document.select(".reference *").remove();
		List<Element> elements = document.getElementsByTag("p");

		for (Element element : elements)
		{
			strings.add(element.text());
		}
		return strings;
	}

	protected String getHtmlFromWikipedia(String source)
	{
		String html = null;
		try
		{
			URL url = new URL("https://en.wikipedia.org/w/api.php?action=parse&format=json&page=" + source);
			Map<String, Object> rawData = new ObjectMapper().readValue(url, Map.class);
			Map<String, Object> parseData = (Map) rawData.get("parse");
			Map<String, Object> textData = (Map) parseData.get("text");
			html = (String) textData.get("*");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return html;
	}
}
