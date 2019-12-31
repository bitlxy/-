package ExploreAndFight;
import com.Zhuangyuan.fyx.*;
public class Mercenary {
    //��Ӷ�����
    private int id;
    //��Ӷ������ֵ
    private int HP;
    //��Ӷ��������
    private int atk;
    //��Ӷ�������ٶ�
    private int atkcd;
    //�Ƿ���
    private boolean live = true;
    private boolean death;
    //��Ӷ���Ǽ�
    private int level;
    //�����Ӷ����Ϣ
    int[][] mercenaryList={
            /*1id  2�Ǽ�  3hp  4atk  5atkcd */
            {1,     0,     5,     1,     5},//ð����
            {2,     1,     4,     5,     2},//��ʦ
            {3,     1,     4,     1,     1},//����
            {4,     1,     3,     6,     3},//��ʦ
            {5,     1,     6,     3,     3},//սʿ
            {6,     1,     4,     3,     5},//������
            {7,     1,     6,     4,     3},//Ӷ��
            {8,     1,     10,    3,     4},//����ð����
            {9,     2,     10,    8,     3},//ѩ��սʿ
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
                return "ð����";
            case 2:
                return "��ʦ";
            case 3:
                return "����";
            case 4:
                return "��ʦ";
            case 5:
                return "սʿ";
            case 6:
                return "������";
            case 7:
                return "Ӷ��";
            case 8:
                return "����ð����";
            case 9:
                return "ѩ��սʿ";
        }
        return "";
    }

    public void mercenaryDataCheck(){
        if(HP<=0){
            this.live=false;
        }
    }
}

