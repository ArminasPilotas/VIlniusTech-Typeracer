package model;

import java.io.IOException;

public class SentenceGenerator {
    private final String searchKeyBegin="result res-sentence'><b>1.&nbsp;&nbsp;";
    private final String searchKeyEnd="</b></p></p></li></ul></div>";
    private final URLConnection urlConnection=new URLConnection();
    private static SentenceGenerator instance;

    public static SentenceGenerator getInstance() throws IOException {
        if(instance==null){
            instance=new SentenceGenerator();
        }
        return instance;
    }
    private SentenceGenerator() throws  IOException{
    }
    public String generateSentence(){
        String html=urlConnection.getHtmlContent();
        if(html==null){
            System.out.println("Failed to generate HTML");
        }
        String sentence=substringSentence(html);
        return decodeHtml(sentence);
    }

    private String decodeHtml(String sentence){
        return sentence.replaceAll("&quot","").trim();
    }
    private String substringSentence(String sentence){
        int beginindex=sentence.indexOf(searchKeyBegin)+searchKeyBegin.length();
        int endindex=sentence.indexOf(searchKeyEnd);
        return sentence.substring(beginindex,endindex);
    }
}
