package ExploreAndFight;

import javax.swing.*;
import java.awt.*;
import com.Zhuangyuan.fyx.*;
//������Ϣ
public class Monster {
    //������
    private int id;
    //��������ֵ
    private int HP;
    //���﹥����
    private int atk;
    //���﹥���ٶ�
    private int atkcd;
    //�Ƿ���
    private boolean live = true;
    private boolean death;
    //��������
    private int x;
    private int y;
    //����ͼƬ
    private Image img;
    //���������Ϣ
    int[][] monsterList={
            /*0id 1hp  2atk    3atkcd*/
            {1,    5,    1,    5},//Ұ��
            {2,    9,    2,    4},//�粼�ֹ�ͷ
            {3,    6,    1,    4},//ǿ��
            {4,    5,    1,    5},//�粼�ֿ๤
            {5,    4,    2,    5},//��������
            {6,    4,    2,    4},//ѧͽ
            {7,    8,    3,    4},//ħ��ʦ
            {8,    8,    3,    6},//ѩ��
            {9,    7,    2,    5},//ѩ��
            {10,   3,    1,    3},//���ֵ�����
            {11,   6,    2,    3},//��
            {12,   18,   3,    4},//��˪����
            {13,   15,   5,    4},//ѩ������
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
                img=(new ImageIcon("src/monster/Ұ��(��ȥ��).png")).getImage();
                break;
            }
            case 2:{
                img=(new ImageIcon("src/monster/�粼�ֹ�ͷ(��ȥ��).png")).getImage();
                break;
            }
            case 3:{
                img=(new ImageIcon("src/monster/ǿ��(��ȥ��).png")).getImage();
                break;
            }
            case 4:{
                img=(new ImageIcon("src/monster/�粼�ֿ๤1(��ȥ��).jpg")).getImage();
                break;
            }
            case 5:{
                img=(new ImageIcon("src/monster/��������(��ȥ��).png")).getImage();
                break;
            }
            case 6:{
                img=(new ImageIcon("src/monster/ѧͽ(��ȥ��).png")).getImage();
                break;
            }
            case 7:{
                img=(new ImageIcon("src/monster/ħ��ʦ(��ȥ��).png")).getImage();
                break;
            }
            case 8:{
                img=(new ImageIcon("src/monster/ѩ��(��ȥ��).png")).getImage();
                break;
            }
            case 9:{
                img=(new ImageIcon("src/monster/ѩ��10.jpg")).getImage();
                break;
            }
            case 10:{
                img=(new ImageIcon("src/monster/���ֵ�����(��ȥ��).png")).getImage();
                break;
            }
            case 11:{
                img=(new ImageIcon("src/monster/��(��ȥ��).png")).getImage();
                break;
            }
            case 12:{
                img=(new ImageIcon("src/monster/��˪����1(��ȥ��).png")).getImage();
                break;
            }
            case 13:{
                img=(new ImageIcon("src/monster/ѩ������(��ȥ��).png")).getImage();
                break;
            }
        }
    }

    public Image getImg(){
        return img;
    }

    //��ȡ�������
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
                return "Ұ��";
            case 2:
                return "�粼�ֹ�ͷ";
            case 3:
                return "ǿ��";
            case 4:
                return "�粼�ֿ๤";
            case 5:
                return "�粼������";
            case 6:
                return "ѧͽ";
            case 7:
                return "ħ��ʦ";
            case 8:
                return "ѩ��";
            case 9:
                return "ѩ��";
            case 10:
                return "���ֵ�����";
            case 11:
                return "��";
            case 12:
                return "��˪����";
            case 13:
                return "ѩ������";
        }
        return "";
    }

    public String getDescribtion(){
        switch(id){
            case 1:
                return "һͷǿ׳��Ұ���㷢���˳��";
            case 2:
                return "������������Ⱥ�粼�ֵ��ϴ��������ļ���������";
            case 3:
                return "һ��ǿ����ס�����ȥ·��Ҫ��������·��";
            case 4:
                return "��С����ª�ĸ粼�֣�����������ǯ";
            case 5:
                return "һ���ֳ�����ĸ粼����׼����";
            case 6:
                return "һ������ѧͽ�����������ħ��";
            case 7:
                return "���Ǳ������ħ��Ȫ�ĵ�ʦ���������ʹ�������ˮ������Ҫ������";
            case 8:
                return "һ����ĸߴ�Ĺ�������ˣ��ƺ��Ǵ�˵�е�ѩ��";
            case 9:
                return "һƥ��ɫëƤ��ѩ�ǣ����ѩ��Ϊһ��";
            case 10:
                return "һ����������ľ��������˹���";
            case 11:
                return "һ���������ų�ʾ��";
            case 12:
                return "һƥ�������ݵ����������ƺ��������ǵ�����";
            case 13:
                return "ѩ�˲������������������ѩ�˻�Ҫ�ߴ�";
        }
        return "";
    }


    public void monsterDataCheck(){
        if(HP<=0){
            live=false;
        }
    }

}

