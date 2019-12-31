package com.Zhuangyuan.fyx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Jl制作 extends JLabel {
    Jl制作(int i, int x, int y) {
        this.setText("消耗：铁 " + x + "  秘银 " + y + " 转职材料:" + "“" + Jpane商店.name进阶材料[i] + "”");
        this.setBounds(190, 70 + 45 * (i - 1), 500, 44);
        this.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        this.setForeground(Color.white);
        this.setBackground(Color.WHITE);
    }
}
class Jl背包 extends JLabel {
    Jl背包(int i, int x, int y) {
        this.setText("消耗：铁 " + x + "  秘银 " + y);
        this.setBounds(190, 70 + 45 * (i - 1), 500, 44);
        this.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        this.setForeground(Color.white);
        this.setBackground(Color.WHITE);
    }
}

////以下为制作功能，训练功能
//public static int shuliang一阶进阶材料[] = {0, 0, 0, 0, 0, 0, 0, 0};
//public static int zhizuo一阶进阶材料[][] = {
//        {0, 0}, {100, 50}, {100, 50}, {100, 50}, {100, 50}, {100, 50}, {100, 50}, {200, 200},
//        };// 所需的铁和秘银
////牧师1，盗贼2，巫师3，战士4，弓箭手5，佣兵6，龙裔7
//public static int zhizuo二阶进阶材料[] = {500, 250};
//public static int shuliang二阶进阶材料 = 0;
////雪人战士
//public static String name一阶进阶材料[] = {"", "圣经", "小刀与披风", "法杖", "斩钢剑", "弓与弓箭", "火药枪", "龙鳞"};
//public static String name二阶进阶材料 = "雪制铠甲";
public class Jpane制作 extends JPanel implements ActionListener {
    public static String name一级[] = {"", "手杖", "小刀与披风", "魔戒", "斩钢剑", "弓与弓箭", "火药枪", "龙鳞"};
    public static String name二级 = "雪制铠甲";
    public static int cost一级[][] = {{0, 0}, {100, 50}, {150, 100}, {200, 100}, {300, 150}, {300, 150}, {400, 300}, {500, 500}, {0, 0}
    };// 所需的铁和秘银
    public static int cost二级[] = {1000, 1000};

    public static JButton toJP01 = new jpane建造Button("<-");
    public static JButton jb制作[] = {new Jb菜单(""), new Jb菜单(name一级[1]), new Jb菜单(name一级[2]), new Jb菜单(name一级[3]), new Jb菜单(name一级[4]), new Jb菜单(name一级[5]), new Jb菜单(name一级[6]), new Jb菜单(name一级[7])};
    public static JButton jb雪人制作 = new Jb菜单(name二级);
    public static JLabel jl消耗[] = {new JLabel(), new Jl制作(1, cost一级[1][0], cost一级[1][1]), new Jl制作(2, cost一级[2][0], cost一级[2][1]), new Jl制作(3, cost一级[3][0], cost一级[3][1]), new Jl制作(4, cost一级[4][0], cost一级[4][1]), new Jl制作(5, cost一级[5][0], cost一级[5][1]), new Jl制作(6, cost一级[6][0], cost一级[6][1]), new Jl制作(7, cost一级[7][0], cost一级[7][1])};
    public static JLabel jl雪人 = new Jl菜单("消耗：铁" + cost二级[0] + " 秘银 " + cost二级[1] + " 转职材料:" + "“" + Jpane商店.name二阶进阶材料 + "”", 190, 70 + 45 * 7, 500, 44);
    public static JButton jb背包=new Jb菜单("升级背包");
    public static int level背包=0;
    public String name背包[]={"棉布包","羊毛包","LV"};
//    1,2,3,级
    public static int cost背包[][]={{50,200},{300,500},{500,500}};
    public static JLabel jl背包=new Jl背包(9,cost背包[level背包][0],cost背包[level背包][1]);

    Jpane制作() {
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

        for (int i = 1; i <= 7; i++) {
            jb制作[i].setBounds(60, 70 + 45 * (i - 1), 120, 44);
            jb制作[i].addActionListener(this);
            this.add(jb制作[i]);
            this.add(jl消耗[i]);
        }
        jb背包.setBounds(60, 70 + 45 * (9 - 1), 120, 44);
        this.add(jb背包);

        this.add(jb雪人制作);
        this.add(jl雪人);
        this.add(jl背包);
        jb雪人制作.setBounds(60, 70 + 315, 120, 44);
        jb雪人制作.addActionListener(this);
        jb背包.addActionListener(this);

    }

    //    public static int[] jtlist = {100, 100, 100, 0, 100, 10};
//    //金币  木材  铁 秘银 食物  石头
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 1; i <= 7; i++) {
            if (e.getSource() == jb制作[i]) {
                if (Zhuangyuan.jtlist[2] < cost一级[i][0] || Zhuangyuan.jtlist[3] < cost一级[i][1] || Zhuangyuan.shuliang一阶进阶材料[i] < 1) {
                    Zhuangyuan.myjscPane.add(new Jlabeltool("材料不够"));
                    Zhuangyuan.addlenth();
                } else {
                    Zhuangyuan.jtlist[2] -= cost一级[i][0];
                    Zhuangyuan.jtlist[3] -= cost一级[i][1];
                    Zhuangyuan.shuliang一阶进阶材料[i]--;
                    Zhuangyuan.shuliang成品一阶材料[i]++;
                    Zhuangyuan.myjscPane.add(new Jlabeltool("当前拥有"+name一级[i]+Zhuangyuan.shuliang成品一阶材料[i]));
                    Zhuangyuan.addlenth();
                }
                break;
            }
        }

        if(e.getSource()==jb雪人制作){
            if(Zhuangyuan.jtlist[2] < cost二级[0] || Zhuangyuan.jtlist[3] < cost二级[1] || Zhuangyuan.shuliang二阶进阶材料<1){
                Zhuangyuan.myjscPane.add(new Jlabeltool("材料不够"));
                Zhuangyuan.addlenth();
            }
            else{
                Zhuangyuan.jtlist[2] -= cost二级[0];
                Zhuangyuan.jtlist[3] -= cost二级[1];
                Zhuangyuan.shuliang二阶进阶材料--;
                Zhuangyuan.shuliang成品二阶材料++;
                Zhuangyuan.myjscPane.add(new Jlabeltool("当前拥有"+name二级+Zhuangyuan.shuliang成品二阶材料));
                Zhuangyuan.addlenth();

            }
        }
        if(e.getSource()==jb背包){
            if(level背包>=3) {
                jl背包.setText("已升至满级");
                return;
            }
            if(Zhuangyuan.jtlist[2] < cost背包[level背包][0] || Zhuangyuan.jtlist[3] < cost背包[level背包][1]){
                Zhuangyuan.myjscPane.add(new Jlabeltool("材料不够"));
                Zhuangyuan.addlenth();
            }
            else{
                Zhuangyuan.jtlist[2] -= cost背包[level背包][0] ;
                Zhuangyuan.jtlist[3] -= cost背包[level背包][1];
                level背包++;
                if(level背包<3)
                jl背包.setText("消耗：铁 " +  cost背包[level背包][0] + "  秘银 " +  cost背包[level背包][1]);
                else jl背包.setText("已升至满级");
                Zhuangyuan.myjscPane.add(new Jlabeltool("成功升级为"+name背包[level背包-1]));
                Zhuangyuan.addlenth();


            }

        }

    }
}
