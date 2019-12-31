package ExploreAndFight;
import com.Zhuangyuan.fyx.*;
public class Mercenary {
    //雇佣兵编号
    private int id;
    //雇佣兵生命值
    private int HP;
    //雇佣兵攻击力
    private int atk;
    //雇佣兵攻击速度
    private int atkcd;
    //是否存活
    private boolean live = true;
    private boolean death;
    //雇佣兵星级
    private int level;
    //定义雇佣兵信息
    int[][] mercenaryList={
            /*1id  2星级  3hp  4atk  5atkcd */
            {1,     0,     5,     1,     5},//冒险者
            {2,     1,     4,     5,     2},//牧师
            {3,     1,     4,     1,     1},//盗贼
            {4,     1,     3,     6,     3},//巫师
            {5,     1,     6,     3,     3},//战士
            {6,     1,     4,     3,     5},//弓箭手
            {7,     1,     6,     4,     3},//佣兵
            {8,     1,     10,    3,     4},//龙裔冒险者
            {9,     2,     10,    8,     3},//雪人战士
    };

    public  Mercenary(int id){
        this.id=id;
        this.level=mercenaryList[id-1][1];
        this.HP=mercenaryList[id-1][2];
        this.atk=mercenaryList[id-1][3];
        this.atkcd=mercenaryList[id-1][4];
    }

    public int getHP(){
        return HP;
    }

    public int getAtk(){
        return atk;
    }

    public int getAtkcd(){
        return atkcd;
    }

    public int getId(){
        return id;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public boolean isLive(){
        return live;
    }

    public String getMercenaryName(){
        switch (getId()){
            case 1:
                return "冒险者";
            case 2:
                return "牧师";
            case 3:
                return "盗贼";
            case 4:
                return "巫师";
            case 5:
                return "战士";
            case 6:
                return "弓箭手";
            case 7:
                return "佣兵";
            case 8:
                return "龙裔冒险者";
            case 9:
                return "雪人战士";
        }
        return "";
    }

    public void mercenaryDataCheck(){
        if(HP<=0){
            this.live=false;
        }
    }
}

