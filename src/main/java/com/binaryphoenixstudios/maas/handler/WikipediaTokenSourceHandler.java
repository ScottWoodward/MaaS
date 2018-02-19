package com.binaryphoenixstudios.maas.handler;

import com.binaryphoenixstudios.maas.dto.TokenDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.stanford.nlp.simple.Document;
import edu.stanford.nlp.simple.Sentence;
import org.jsoup.Jsoup;
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
	public List<TokenDTO> getTokens(String source, int numberOfPreviousDependantTokens)
	{
		List<TokenDTO> tokens = new ArrayList<>();
		//Get the JSON from Wikipedia's API and pull out the body HTML from the JSON.
		String html = getHtmlFromWikipedia(source);
		
		//Parse the HTML to text.
		org.jsoup.nodes.Document document = Jsoup.parse(html);
		//Remove the references
		document.select(".reference *").remove();
		List<Element> elements = document.getElementsByTag("p");
		
		List<Sentence> sentences = new ArrayList<>();
		
		for (Element element : elements)
		{
			sentences.addAll(new Document(element.text()).sentences());
		}
		
		for (Sentence sentence : sentences)
		{
			tokens.addAll(convertStringsToTokens(sentence.words(), numberOfPreviousDependantTokens));
			
		}
		
		return tokens;
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
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return html;
	}
}
