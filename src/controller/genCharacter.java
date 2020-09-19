package controller;

import model.Charecter.basedChar;
import model.Charecter.magicalCharacter;
import model.Charecter.physicalCharacter;

import java.util.Random;

public class genCharacter {
    public static basedChar setUpChar(){
        basedChar character;
        Random rand = new Random();
        int type= rand.nextInt(2)+1;
        int baseDef = rand.nextInt(50)+1;
        int baseRes = rand.nextInt(50)+1;
        if(type==1){
            character =new magicalCharacter("magicalCharacter1","assets/wizard.png",baseDef,baseRes);
        }else{
            character = new physicalCharacter("physicalCharacter","assets/knight.png",baseDef,baseRes);
        }
        return character;
    }
}
