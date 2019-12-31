package com.Zhuangyuan.fyx;

import sun.misc.JavaLangAccess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Comparator;

//
//                     炼金.setBounds(30,50+30,121,75);
//                    建造.setBounds(30,130+30,121,75);
//                    商店.setBounds(30,210+30,121,75);
class jpane建造Button extends JButton {
    jpane建造Button(String name) {
        this.setText(name);
        this.setFont(new Font("微软雅黑", Font.BOLD, 16));
        this.setForeground(Color.white);
        this.setFocusPainted(false);//消除选择
        this.setBackground(Color.black);
        this.setBorderPainted(false);
    }
}

class myjl extends JLabel {
    myjl(int i) {
        this.setBounds(180, 70 + 45 * (i - 1), 500, 44);
        this.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        this.setForeground(Color.white);
        this.setBackground(Color.WHITE);

    }
}

public class Jpane建造 extends JPanel implements ActionListener {


    public static JButton toJP01 = new jpane建造Button("<-");
    public static JButton do民营 = new jpane建造Button("民营");
    public static JButton do商店 = new jpane建造Button("商店");
    public static JButton do训练营 = new jpane建造Button("训练营");

    public JLabel jl商店 = new myjl(2);
    public JLabel jl民营 = new myjl(1);
    public JLabel jl训练营 = new myjl(3);

    public JLabel jl民营cost = new JLabel("                 " + "建造花费:" + Zhuangyuan.cost民营[Zhuangyuan.number建造[1]][0] + "木材" + Zhuangyuan.cost民营[Zhuangyuan.number建造[1]][1] + "石头");

    Jpane建造() {
        this.setBackground(Color.darkGray);
        this.setVisible(false);
        this.setLayout(null);
        this.setSize(Zhuangyuan.frameWidth, Zhuangyuan.frameHeight);

        this.add(toJP01);
        toJP01.setFont(new Font("微软雅黑", Font.BOLD, 30));
        toJP01.setForeground(Color.white);
        toJP01.setFocusPainted(false);//消除选择
        toJP01.setBackground(Color.DARK_GRAY);
        toJP01.setBorderPainted(false);
        jl民营cost.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        jl民营cost.setForeground(Color.white);
        jl民营cost.setBackground(Color.WHITE);

        toJP01.setBounds(5, 5, 70, 60);

        do民营.setBounds(80, 70, 90, 44);
        do商店.setBounds(80, 70 + 45, 90, 44);
        do训练营.setBounds(80, 70 + 90, 90, 44);
        jl民营cost.setBounds(180, 70, 500, 44);
        this.add(do商店);
        this.add(do民营);
        this.add(do训练营);
        this.add(jl商店);
        this.add(jl民营);
        this.add(jl训练营);
        this.add(jl民营cost);

        更新信息();
        打印信息();
        do民营.addActionListener(this);
        do训练营.addActionListener(this);
        do商店.addActionListener(this);


    }
//    public static int number建造[] = {0, 0, 0, 0};
    //    0 民宅n，商店0-1，训练0-1；
//public static int[] jtlist = {100, 100, 100, 0, 100, 10};
    //金币  木材  铁 秘银 食物  石头

    //    public static int cost民营[][] = {
//            {10, 10}, {100, 50}, {300, 150}, {500, 300}, {1000, 500}, {5000, 2500}, {10000, 50000}
//            //木材，石头
//    };
//    public static int cost作坊训练营[][]={{},{},{50,100},{100,200}};
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == do商店) {
            if (Zhuangyuan.number建造[2] == 1) {
                Zhuangyuan.myjscPane.add(new Jlabeltool("城堡里已经有商店了"));
            } else if (Zhuangyuan.jtlist[1] < Zhuangyuan.cost作坊训练营[2][0] || Zhuangyuan.jtlist[5] < Zhuangyuan.cost作坊训练营[2][1]) {
                Zhuangyuan.myjscPane.add(new Jlabeltool("资源不足"));
            } else {

                Zhuangyuan.jtlist[1] -= Zhuangyuan.cost作坊训练营[2][0];
                Zhuangyuan.jtlist[5] -= Zhuangyuan.cost作坊训练营[2][1];
                Zhuangyuan.number建造[2] = 1;
                Zhuangyuan.myjscPane.add(new Jlabeltool("建造成功"));
            }
        } else if (e.getSource() == do训练营) {
            if (Zhuangyuan.number建造[3] == 1) {
                Zhuangyuan.myjscPane.add(new Jlabeltool("城堡里已经有训练营了"));
            } else if (Zhuangyuan.jtlist[1] < Zhuangyuan.cost作坊训练营[3][0] || Zhuangyuan.jtlist[5] < Zhuangyuan.cost作坊训练营[3][1]) {
                Zhuangyuan.myjscPane.add(new Jlabeltool("资源不足"));
            } else {
                Zhuangyuan.jtlist[1] -= Zhuangyuan.cost作坊训练营[3][0];
                Zhuangyuan.jtlist[5] -= Zhuangyuan.cost作坊训练营[3][1];
                Zhuangyuan.number建造[3] = 1;
                Zhuangyuan.myjscPane.add(new Jlabeltool("建造成功"));
            }
        } else if (e.getSource() == do民营) {
            if(Zhuangyuan.number建造[1]>12){
                Zhuangyuan.myjscPane.add(new Jlabeltool("已达上限"));


            }
            else if (Zhuangyuan.jtlist[1] < Zhuangyuan.cost民营[Zhuangyuan.number建造[1]][0] || Zhuangyuan.jtlist[5] < Zhuangyuan.cost民营[Zhuangyuan.number建造[1]][1]) {
                Zhuangyuan.myjscPane.add(new Jlabeltool("资源不足"));
            } else {
                Zhuangyuan.jtlist[1] -= Zhuangyuan.cost民营[Zhuangyuan.number建造[1]][0];
                Zhuangyuan.jtlist[5] -= Zhuangyuan.cost民营[Zhuangyuan.number建造[1]][1];
                Zhuangyuan.number建造[1]++;
                Jp02.工匠 += 20;
                Jp02.工匠jl.setText("剩余工匠：" + Jp02.工匠);
                Zhuangyuan.myjscPane.add(new Jlabeltool("建造成功"));
            }
        }
        else {
            return;
        }
        Zhuangyuan.addlenth();
        更新信息();

    }

    public void 打印信息() {
        int i;
        for (i = 2; i <= 3; i++) {
            this.add(new Jl菜单("                 " + "建造花费:" + Zhuangyuan.cost作坊训练营[i][0] + "木材" + Zhuangyuan.cost作坊训练营[i][1] + "石头", 180, 70 + 45 * (i - 1), 500, 44));
        }
    }

    public void 更新信息() {
        jl商店.setText("已拥有：" + Zhuangyuan.number建造[2]);
        jl民营.setText("已拥有：" + Zhuangyuan.number建造[1]);
        jl训练营.setText("已拥有：" + Zhuangyuan.number建造[3]);
        if(Zhuangyuan.number建造[1]<=12)
        jl民营cost.setText("                 " + "建造花费:" + Zhuangyuan.cost民营[Zhuangyuan.number建造[1]][0] + "木材" + Zhuangyuan.cost民营[Zhuangyuan.number建造[1]][1] + "石头");
        else
            jl民营cost.setText("                 " + "已升至满级");

    }
}
