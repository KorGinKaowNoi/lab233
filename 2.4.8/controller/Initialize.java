package controller;

import model.CurrencyModel;
import model.MyCurrency;

import java.util.ArrayList;

public class Initialize {
    public static void initialize_app(){
        MyCurrency currency = new MyCurrency("PHP");
        ArrayList<CurrencyModel> c_list = FetchData.fetch_range(currency.getShortCode(),6);
        currency.setHistorical(c_list);
        currency.setCurrent(c_list.get(c_list.size()-1));
        ArrayList<MyCurrency> currencies = new ArrayList<>();
        currencies.add(currency);
        launcher.setCurrency(currencies);
    }
}
