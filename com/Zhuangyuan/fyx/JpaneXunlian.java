package com.Zhuangyuan.fyx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Jl训练 extends JLabel {
    Jl训练(int i) {
        this.setBounds(170, 70 + 45 * (i - 1), 500, 44);
        this.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        this.setForeground(Color.white);
        this.setBackground(Color.WHITE);
    }
}

class Jldialog extends JLabel {
    Jldialog(int i) {
        if (i == 1) {
            this.setBounds(100, 0, 500, 60);
            this.setForeground(Color.red);
        } else {
            this.setBounds(20, 0 + 60 * (i - 1), 500, 44);
            this.setForeground(Color.BLACK);
        }
        this.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        this.setForeground(Color.BLACK);
        this.setBackground(Color.WHITE);
    }
}

class chooseJdialog extends JDialog implements ActionListener {

    public static JButton jb选择[] = {new Jb菜单(""), new Jb菜单(""), new Jb菜单(""), new Jb菜单(""), new Jb菜单(""), new Jb菜单(""), new Jb菜单(""), new Jb菜单(""), new Jb菜单(""), new Jb菜单("")};
    public static int i;
    public  Container con = getContentPane();
    public chooseJdialog(JFrame frame) {
        super( frame, "选择你的转职路线", true);
//        this.setUndecorated(true);
        setLayout(null);
        setVisible(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int) (screenSize.getWidth() / 2) - 100, 200, 300, 390);
        setBackground(Color.WHITE);

        for(int m=1;m<=8;m++){
            con.add(jb选择[m]);
            jb选择[m].addActionListener(this);
            jb选择[m].setVisible(false);
        }

    }
    public static void 更新()
    {
        for(int m=1;m<=8;m++){
            jb选择[m].setVisible(false);
        }


        if(i==8){
            jb选择[8].setVisible(true);
            jb选择[8].setText("雪人战士");
            JpaneXunlian.jDialogChoose.setSize(200,140);
            jb选择[8].setBounds(0,0,200,100);

        }
        else {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            JpaneXunlian.jDialogChoose.setBounds((int) (screenSize.getWidth() / 2) - 100, 300, 200, 390);
            for(int m=1;m<=7;m++)
            {
                jb选择[m].setVisible(true);
                jb选择[m].setText(JpaneXunlian.name[m]);
                jb选择[m].setBounds(0,0+(m-1)*50,200,50);
            }
        }
        JpaneXunlian.jDialogChoose.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JpaneXunlian.jDialogChoose.setVisible(false);
        for(int m=1;m<=8;m++)
        {
            if(e.getSource()==jb选择[m])
            {JpaneXunlian.jDialogChoose.setVisible(false);
                JpaneXunlian.跳出弹窗(m);
                System.out.println("跳出成功");
                return;
            }
        }
        return;
    }
}

class zhaomuJDialog extends JDialog implements ActionListener {
    public static JLabel dialogJL[] = {new Jldialog(0), new Jldialog(1), new Jldialog(2), new Jldialog(3),};
    public static JButton yES = new Jb菜单("确认");
    public static JButton nO = new Jb菜单("取消");
    public static JPanel jpDialog = new JPanel();
    public static int name;



    public zhaomuJDialog(JFrame frame) {
        super(frame, "确认", true);
        this.setUndecorated(true);
        Container con = getContentPane();
        setLayout(null);
        setVisible(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int) (screenSize.getWidth() / 2) - 100, 200, 350, 270);
//        setLocation((int) (screenSize.getWidth() - Zhuangyuan.frameWidth) / 2, 200);
//        setSize(400, 244);
        setBackground(Color.WHITE);

        jpDialog.setSize(400, 244);
        jpDialog.setBackground(Color.lightGray);
        jpDialog.setLayout(null);
        jpDialog.setVisible(true);
        for (int i = 1; i <= 3; i++) {
            dialogJL[i].setText(i + "");
            con.add(dialogJL[i]);
        }


        yES.setBounds(20, 200, 70, 44);
        nO.setBounds(250, 200, 70, 44);
        yES.addActionListener(this);
        nO.addActionListener(this);
        con.add(yES);
        con.add(nO);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==nO)
        {
            JpaneXunlian.jDialog弹窗.setVisible(false);
        }
        if(e.getSource()==yES){
            JpaneXunlian.升级(name);
            JpaneXunlian.jDialog弹窗.setVisible(false);
            JpaneXunlian.录入冒险者();
        }
    }

}

public class JpaneXunlian extends JPanel implements ActionListener {

    public static JDialog jDialog弹窗=new zhaomuJDialog(null);
    public static JDialog jDialogChoose=new chooseJdialog(null);

    public static JButton toJP01 = new JButton("<-");

    public static int[][] mercenaryList = {
            /*1id  2星级  3hp  4atk  5atkcd */
            {1, 0, 5, 1, 5},//冒险者
            {2, 1, 4, 5, 2},//牧师
            {3, 1, 4, 1, 1},//盗贼
            {4, 1, 3, 6, 3},//巫师
            {5, 1, 6, 3, 3},//战士
            {6, 1, 4, 3, 5},//弓箭手
            {7, 1, 6, 4, 3},//佣兵
            {8, 1, 10, 3, 4},//龙裔冒险者
            {9, 2, 10, 8, 3},//雪人战士
    };
    public static JButton 招募 = new JButton("招募");

    public static JButton jb训练[] = {new Jb菜单(""), new Jb菜单(""), new Jb菜单(""), new Jb菜单(""), new Jb菜单(""), new Jb菜单(""), new Jb菜单(""), new Jb菜单(""), new Jb菜单(""), new Jb菜单("")};
    public static int ID[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static JLabel jl训练[] = {new Jl训练(1), new Jl训练(2), new Jl训练(3), new Jl训练(4), new Jl训练(5), new Jl训练(6), new Jl训练(7), new Jl训练(8), new Jl训练(9)};
    public static int flagjb[] = {-1, -1, -1, -1, -1, -1, -1, -1, -1};
    public static String name[] = {"冒险者", "牧师", "盗贼", "巫师", "战士", "弓箭手", "佣兵", "龙裔冒险者", "雪人战士"};

    JpaneXunlian() {
        this.setBackground(Color.darkGray);
        this.setVisible(false);
        this.setLayout(null);
        this.setSize(Zhuangyuan.frameWidth, Zhuangyuan.frameHeight);
        toJP01.setBounds(5, 5, 70, 60);
        this.add(toJP01);
        toJP01.setFont(new Font("微软雅黑", Font.BOLD, 30));
        toJP01.setForeground(Color.white);
        toJP01.setFocusPainted(false);//消除选择
        toJP01.setBackground(Color.DARK_GRAY);
        toJP01.setBorderPainted(false);

        招募.setBounds(Zhuangyuan.frameWidth / 2 - 50, 5, 100, 61);
        this.add(招募);
        招募.setFont(new Font("微软雅黑", Font.BOLD, 30));
        招募.setForeground(Color.white);
        招募.setFocusPainted(false);//消除选择
        招募.setBackground(Color.DARK_GRAY);
        招募.setBorderPainted(false);

        for (int i = 0; i <= 8; i++) {
            this.add(jl训练[i]);
            this.add(jb训练[i]);
//            jb训练[i].setText("龙裔冒险者");
            jb训练[i].setBackground(Color.DARK_GRAY);
            jb训练[i].setForeground(Color.ORANGE);
            jb训练[i].setVisible(false);
            jb训练[i].setBounds(30, 70 + 45 * (i), 130, 44);
            jb训练[i].addActionListener(this);

        }
        录入冒险者();
        招募.addActionListener(this);
    }


    public static void 跳出弹窗(int i) {

        if (i == 0) {
            zhaomuJDialog.dialogJL[1].setText("招募一个" + name[0] + "?");
        }
        else zhaomuJDialog.dialogJL[1].setText("升级为：" + name[i]);
        zhaomuJDialog.dialogJL[2].setText("生命值" + mercenaryList[i][2] + " 攻击力" + mercenaryList[i][3] + " 攻击间隔" + mercenaryList[i][4]);
        if(i<=7&&i>=1)zhaomuJDialog.dialogJL[3].setText("消耗："+Jpane制作.name一级[i]);
        if(i==8)zhaomuJDialog.dialogJL[3].setText("消耗："+Jpane制作.name二级);
        if(i==0)zhaomuJDialog.dialogJL[3].setText("消耗金币100");
        zhaomuJDialog.name=i;
        jDialog弹窗.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int leixing = 100;
        if (e.getSource() == 招募) {
            跳出弹窗(0);
        }
        else {

            for (int i = 0; i <= 8; i++) {

                if (e.getSource() == jb训练[i]) {
                    leixing = flagjb[i];
                    System.out.println("类型为：" + leixing);
                    if (leixing == 0) {

                        chooseJdialog.i = 0;chooseJdialog.更新();
                    }
                    else if (leixing == 4) {
                        chooseJdialog.i = 8;chooseJdialog.更新();
                    }
                    else {
                        Zhuangyuan.myjscPane.add(new Jlabeltool("该职业已达到最高级"));
                        Zhuangyuan.addlenth();
                    }
                }
            }
        }

    }

    public static void 升级(int i)
    {
        //牧师1，盗贼2，巫师3，战士4，弓箭手5，佣兵6，龙裔7,龙裔和雪人买不到；
        String taici[]={"","进阶成功，我带来了生命与希望",
                "进阶成功，他们不会知道自己是怎么死的",
                "进阶成功，我就是魔法的化身",
                "进阶成功，叠甲，过！",
                "进阶成功，万物系于一箭之上",
                "进阶成功，要么拿钱要么拿命",
                "进阶成功，我乃天空的霸主，暗鳞之龙"};
        if(i==0){
            if(Zhuangyuan.jtlist[0]>=100){
                Zhuangyuan.jtlist[0]-=100;
                Zhuangyuan.myjscPane.add(new Jlabeltool("招募成功，冒险者+1"));
                Zhuangyuan.shuliang冒险者[0]++;
                Zhuangyuan.addlenth();
            }
            else{
                Zhuangyuan.myjscPane.add(new Jlabeltool("钱不够"));
                Zhuangyuan.addlenth();
            }
        }
        else if(i==8)
        {
            if(Zhuangyuan.shuliang成品二阶材料>=1)
            {
                Zhuangyuan.myjscPane.add(new Jlabeltool("进阶成功，雪人知道该怎么做！"));
                Zhuangyuan.addlenth();
                Zhuangyuan.shuliang冒险者[4]--;
                Zhuangyuan.shuliang冒险者[8]++;
            }
            else{
                Zhuangyuan.myjscPane.add(new Jlabeltool("材料不足"));
                Zhuangyuan.addlenth();
            }
        }

        else if(Zhuangyuan.shuliang成品一阶材料[i]>=1) {
            Zhuangyuan.myjscPane.add(new Jlabeltool(taici[i]));
            Zhuangyuan.shuliang成品一阶材料[i]--;
            Zhuangyuan.shuliang冒险者[0]--;
            Zhuangyuan.shuliang冒险者[i]++;
            Zhuangyuan.addlenth();
        }
        else{
            Zhuangyuan.myjscPane.add(new Jlabeltool("材料不足"));
            Zhuangyuan.addlenth();
        }
    }
    public static void 录入冒险者() {
        for (int x = 0; x <= 8; x++) {
            flagjb[x] = 0;
            jb训练[x].setVisible(false);
            jl训练[x].setVisible(false);
        }
        int id;
        int p = 0;
        for (id = 0; id <= 8; id++) {
            if (Zhuangyuan.shuliang冒险者[id] >= 1) {
                jb训练[p].setVisible(true);
                jl训练[p].setVisible(true );
                jb训练[p].setText(name[id]);
                jl训练[p].setText("共计：" + Zhuangyuan.shuliang冒险者[id] + " 名 " + " 生命值" + mercenaryList[id][2] + " 攻击力" + mercenaryList[id][3] + " 攻击间隔" + mercenaryList[id][4]);
                if(id==0)
                {jb训练[p].setForeground(Color.ORANGE);
                }
                if (id >= 1 && id <= 6) {
                    jb训练[p].setForeground(Color.red);
                }
                if (id == 7 || id == 8) {
                    jb训练[p].setForeground(Color.RED);
                }
                flagjb[p] = id;
                p++;
            } else continue;
        }
    }
}
