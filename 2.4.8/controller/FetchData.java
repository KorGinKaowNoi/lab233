package controller;

import model.CurrencyModel;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class FetchData {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static ArrayList<CurrencyModel> fetch_range(String src, int n){
        String dateEnd = LocalDate.now().format(formatter);
        String dateStart = LocalDate.now().minusDays(n).format(formatter);
        String apiKey = "d07c6a9abebb7924e70d";
        String url_str = String.format("https://free.currconv.com/api/v7/convert?q=%s_THB&compact=ultra&date=%s&endDate=%s&apiKey=%s",src,dateStart,dateEnd,apiKey);
        ArrayList<CurrencyModel> hisList = new ArrayList<>();
        String retrieveJSON =null;
        try{
            retrieveJSON = IOUtils.toString(new URL(url_str), Charset.defaultCharset());
        }catch (MalformedURLException e){
            System.out.println("Encounter MalformedUrlException");
        }catch (IOException e){
            System.out.println("Encounter IOException");
        }
        JSONObject jsonObject = new JSONObject(retrieveJSON).getJSONObject(String.format("%s_THB",src));
        Iterator keysToCopyIterator = jsonObject.keys();
        while(keysToCopyIterator.hasNext()){
            String key = (String) keysToCopyIterator.next();
            Double rate = Double.parseDouble(jsonObject.get(key).toString());
            hisList.add(new CurrencyModel(rate,key));
        }
        hisList.sort(Comparator.comparing(CurrencyModel::getTimeStamp));
        return  hisList;
    }
}
