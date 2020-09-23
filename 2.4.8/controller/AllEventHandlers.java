package controller;

import javafx.scene.control.TextInputDialog;
import model.CurrencyModel;
import model.MyCurrency;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

public class AllEventHandlers {
    public static void onRefresh() {
        try{
            launcher.refreshPane();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void onAdd(){
        try{
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Add currency");
            dialog.setContentText("Currency code: ");
            dialog.setHeaderText(null);
            dialog.setGraphic(null);
            Optional<String> code = dialog.showAndWait();
            if(code.isPresent()){
                ArrayList<MyCurrency> currency_list = launcher.getCurrency();
                MyCurrency c = new MyCurrency(code.get());
                ArrayList<CurrencyModel> c_list = FetchData.fetch_range(c.getShortCode(),6);
                c.setHistorical(c_list);
                c.setCurrent(c_list.get(c_list.size()-1));
                currency_list.add(c);
                launcher.setCurrency(currency_list);
                launcher.refreshPane();
            }
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }
    }

    public static void onDelete(String shortCode) {
        try{
            ArrayList<MyCurrency> currency_list = launcher.getCurrency();
            int index =-1;
            for(int i=0;i<currency_list.size();i++){
                if(currency_list.get(i).getShortCode().equals(shortCode)){
                    index =i;
                    break;
                }
            }
            if(index!=-1){
                currency_list.remove(index);
                launcher.setCurrency(currency_list);
                launcher.refreshPane();
            }
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }
    }

    public static void onWatch(String shortCode) {
        try {
            ArrayList<MyCurrency> currency_list = launcher.getCurrency();
            int index= -1;
            for(int i=0;i<currency_list.size();i++){
                if(currency_list.get(i).getShortCode().equals(shortCode)){
                    index =i;
                    break;
                }
            }
            if(index!=-1){
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Add Watch");
                dialog.setContentText("Rate: ");
                dialog.setHeaderText(null);
                dialog.setGraphic(null);
                Optional<String> retrieveRate = dialog.showAndWait();
                if(retrieveRate.isPresent()){
                    double rate =Double.parseDouble(retrieveRate.get());
                    currency_list.get(index).setWatch(true);
                    currency_list.get(index).setWatchRate(rate);
                    launcher.setCurrency(currency_list);
                    launcher.refreshPane();
                }
                launcher.setCurrency(currency_list);
                launcher.refreshPane();
            }
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }
    }
}
