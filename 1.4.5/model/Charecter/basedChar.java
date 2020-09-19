package model.Charecter;
import model.item.Armor;
import model.item.Weapon;
public class basedChar {
    protected String name,imgPath;
    protected DamageType type;
    protected Integer fullHp,baseDef,basePow,basedRes;
    protected Integer hp,power,defense,resistance;
    protected Weapon weapon;
    protected Armor armor;
    public String getName(){return name;}
    public String getImgPath(){return imgPath;}
    public Integer getFullHp(){return fullHp;}
    public Integer getHp(){return hp;}
    public Integer getPower(){return power;}
    public Integer getDefense(){return defense;}
    public Integer getResistance(){return resistance;}
    public DamageType getType(){return type;}
    public void equipWeapon(Weapon w){
        this.weapon =w;
        this.power = this.basePow+w.getPower();
    }
    public void equipArmor(Armor a){
        this.armor =a;
        this.defense = this.baseDef+a.getDefence();
        this.resistance =this.basedRes+a.getResistance();
    }

    @Override
    public String toString(){return name;}
}
