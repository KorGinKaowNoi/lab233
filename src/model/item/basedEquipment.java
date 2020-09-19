package model.item;

import javafx.scene.input.DataFormat;

import java.io.Serializable;


public class basedEquipment implements Serializable {
    public static final DataFormat DATA_FORMAT = new DataFormat("src.model.item.basedEquipment");
    protected String name;
    protected String imgPath;
    public String getName(){return name;}
    public String getImgPath(){return imgPath;}
    public void setImgPath(String imgPath){
        this.imgPath =imgPath;
    }
}
