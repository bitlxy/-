package ExploreAndFight;

import javax.swing.*;
import java.awt.*;
import com.Zhuangyuan.fyx.*;
//怪物信息
public class Monster {
    //怪物编号
    private int id;
    //怪物生命值
    private int HP;
    //怪物攻击力
    private int atk;
    //怪物攻击速度
    private int atkcd;
    //是否存活
    private boolean live = true;
    private boolean death;
    //怪物坐标
    private int x;
    private int y;
    //怪物图片
    private Image img;
    //定义怪物信息
    int[][] monsterList={
            /*0id 1hp  2atk    3atkcd*/
            {1,    5,    1,    5},//野猪
            {2,    9,    2,    4},//哥布林工头
            {3,    6,    1,    4},//强盗
            {4,    5,    1,    5},//哥布林苦工
            {5,    4,    2,    5},//骷髅射手
            {6,    4,    2,    4},//学徒
            {7,    8,    3,    4},//魔导师
            {8,    8,    3,    6},//雪人
            {9,    7,    2,    5},//雪狼
            {10,   3,    1,    3},//惊恐的青年
            {11,   6,    2,    3},//蛇
            {12,   18,   3,    4},//冰霜幼龙
            {13,   15,   5,    4},//雪人酋长
    };

    public Monster(int id){
        this.id=id;
        this.HP=monsterList[id-1][1];
        this.atk=monsterList[id-1][2];
        this.atkcd=monsterList[id-1][3];

    }

    public void setImage(){
        switch (id){
            case 1:{
                img=(new ImageIcon("src/monster/野猪(已去底).png")).getImage();
                break;
            }
            case 2:{
                img=(new ImageIcon("src/monster/哥布林工头(已去底).png")).getImage();
                break;
            }
            case 3:{
                img=(new ImageIcon("src/monster/强盗(已去底).png")).getImage();
                break;
            }
            case 4:{
                img=(new ImageIcon("src/monster/哥布林苦工1(已去底).jpg")).getImage();
                break;
            }
            case 5:{
                img=(new ImageIcon("src/monster/骷髅射手(已去底).png")).getImage();
                break;
            }
            case 6:{
                img=(new ImageIcon("src/monster/学徒(已去底).png")).getImage();
                break;
            }
            case 7:{
                img=(new ImageIcon("src/monster/魔导师(已去底).png")).getImage();
                break;
            }
            case 8:{
                img=(new ImageIcon("src/monster/雪人(已去底).png")).getImage();
                break;
            }
            case 9:{
                img=(new ImageIcon("src/monster/雪狼10.jpg")).getImage();
                break;
            }
            case 10:{
                img=(new ImageIcon("src/monster/惊恐的青年(已去底).png")).getImage();
                break;
            }
            case 11:{
                img=(new ImageIcon("src/monster/蛇(已去底).png")).getImage();
                break;
            }
            case 12:{
                img=(new ImageIcon("src/monster/冰霜幼龙1(已去底).png")).getImage();
                break;
            }
            case 13:{
                img=(new ImageIcon("src/monster/雪人酋长(已去底).png")).getImage();
                break;
            }
        }
    }

    public Image getImg(){
        return img;
    }

    //获取相关数据
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x){
        this.x=x;
    }

    public void setY(int y){
        this.y=y;
    }

    public boolean isLive(){
        return live;
    }

    public int getMonsterId(){
        return id;
    }

    public void setHP(int HP){
        this.HP=HP;
    }

    public int getAtk(){
        return atk;
    }

    public int getAtkcd(){
        return atkcd;
    }

    public int getHP(){
        return HP;
    }

    public void setLocation(int x,int y){
        this.x=x;
        this.y=y;
    }

    public void setid(int id){
        this.id=id;
    }

    public String getMonsterName(){
        switch (getMonsterId()){
            case 1:
                return "野猪";
            case 2:
                return "哥布林工头";
            case 3:
                return "强盗";
            case 4:
                return "哥布林苦工";
            case 5:
                return "哥布林射手";
            case 6:
                return "学徒";
            case 7:
                return "魔导师";
            case 8:
                return "雪人";
            case 9:
                return "雪狼";
            case 10:
                return "惊恐的青年";
            case 11:
                return "蛇";
            case 12:
                return "冰霜幼龙";
            case 13:
                return "雪人酋长";
        }
        return "";
    }

    public String getDescribtion(){
        switch(id){
            case 1:
                return "一头强壮的野猪朝你发起了冲锋";
            case 2:
                return "看起来他是这群哥布林的老大，起码他的肌肉是最发达的";
            case 3:
                return "一伙强盗挡住了你的去路，要你留下买路财";
            case 4:
                return "矮小而丑陋的哥布林，手上拿着铁钳";
            case 5:
                return "一个手持弩机的哥布林瞄准了你";
            case 6:
                return "一个法术学徒生疏地吟唱这魔法";
            case 7:
                return "他是保护这个魔法泉的导师，如果你想使用这里的水，必须要击败他";
            case 8:
                return "一个身材高大的怪物出现了，似乎是传说中的雪人";
            case 9:
                return "一匹银色毛皮的雪狼，与冰雪融为一体";
            case 10:
                return "一个青年拿着木棍朝你冲了过来";
            case 11:
                return "一条蛇吐着信朝示威";
            case 12:
                return "一匹威风凛凛的幼龙，她似乎是幼龙们的首领";
            case 13:
                return "雪人部落的酋长，比其他的雪人还要高大";
        }
        return "";
    }


    public void monsterDataCheck(){
        if(HP<=0){
            live=false;
        }
    }

}

