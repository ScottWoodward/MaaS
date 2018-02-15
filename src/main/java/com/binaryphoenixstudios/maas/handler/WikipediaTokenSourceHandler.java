package com.binaryphoenixstudios.maas.handler;

import com.binaryphoenixstudios.maas.dto.TokenDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.stanford.nlp.simple.Document;
import edu.stanford.nlp.simple.Sentence;
import org.jsoup.Jsoup;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WikipediaTokenSourceHandler extends AbstractTokenSourceHandler implements TokenSourceHandler
{
	@Override
	public List<TokenDTO> getTokens(List<String> sources, int numberOfPreviousDependantTokens)
	{
		List<TokenDTO> tokens = new ArrayList<>();
		for(String source : sources)
		{
			//Get the JSON from Wikipedia's API and pull out the body HTML from the JSON.
			String html = getHtmlFromWikipedia(source);
			
			//Parse the HTML to text.
			org.jsoup.nodes.Document document = Jsoup.parse(html);
			//Remove the references
			document.select("#References").remove();
			document.select("#References").remove();
			document.select(".reference").remove();
			document.select(".references-column-width").remove();
			document.select(".navbox").remove();
			String text = document.text();
			
			//Tokenize the text.
			List<Sentence> sentences = new Document(text).sentences();
			sentences.stream().forEach(System.out::println);
			//Convert it into our tokens.
		}
		return tokens;
	}
	
	protected String getHtmlFromWikipedia(String source)
	{
		String html = null;
		try
		{
			URL url = new URL("https://en.wikipedia.org/w/api.php?action=parse&format=json&page=batman");
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
