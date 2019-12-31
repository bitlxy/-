package com.Zhuangyuan.fyx;

import kotlin.Lazy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Jpane商店 extends JPanel implements ActionListener {
    public static String name进阶材料[] = {"", "治愈之心", "贪婪之心", "学术之心", "荣誉之心", "自由之心", "契约之心", "龙之心"};
    public static String name二阶进阶材料 = "大大大雪球";
    public static int buy进阶材料价格[] = {0, 50, 100, 150, 200, 300, 500, 0};
    public static JButton toJP01 = new JButton("<-");
    public static JButton jb1 = new Jb菜单("木材x10");
    public static JButton jb2 = new Jb菜单("铁x10");
    public static JButton jb3 = new Jb菜单("秘银x10");
    public static JButton jb4 = new Jb菜单("食物x10");
    public static JButton jb5 = new Jb菜单("石头x10");
    public static JButton jbb1 = new Jb菜单(name进阶材料[1]);
    public static JButton jbb2 = new Jb菜单(name进阶材料[2]);
    public static JButton jbb3 = new Jb菜单(name进阶材料[3]);
    public static JButton jbb4 = new Jb菜单(name进阶材料[4]);
    public static JButton jbb5 = new Jb菜单(name进阶材料[5]);
    public static JButton jbb6 = new Jb菜单(name进阶材料[6]);


    Jpane商店() {
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

        打印信息();
        this.add(jb1);
        this.add(jb2);
        this.add(jb3);
        this.add(jb4);
        this.add(jb5);
        this.add(jbb1);
        this.add(jbb2);
        this.add(jbb3);
        this.add(jbb4);
        this.add(jbb5);
        this.add(jbb6);
        jb1.setBounds(60, 70, 100, 44);
        jb2.setBounds(60, 70 + 45, 100, 44);
        jb3.setBounds(60, 70 + 90, 100, 44);
        jb4.setBounds(60, 70 + 135, 100, 44);
        jb5.setBounds(60, 70 + 180, 100, 44);

        jbb1.setBounds(Zhuangyuan.frameWidth / 2, 70, 100, 44);
        jbb2.setBounds(Zhuangyuan.frameWidth / 2, 70 + 45, 100, 44);
        jbb3.setBounds(Zhuangyuan.frameWidth / 2, 70 + 90, 100, 44);
        jbb4.setBounds(Zhuangyuan.frameWidth / 2, 70 + 135, 100, 44);
        jbb5.setBounds(Zhuangyuan.frameWidth / 2, 70 + 180, 100, 44);
        jbb6.setBounds(Zhuangyuan.frameWidth / 2, 70 + 225, 100, 44);

        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);
        jb5.addActionListener(this);
        jbb1.addActionListener(this);
        jbb2.addActionListener(this);
        jbb3.addActionListener(this);
        jbb4.addActionListener(this);
        jbb5.addActionListener(this);
        jbb6.addActionListener(this);

    }

    //public static int buy资源价格[] = {0, 20, 30, 100, 10, 10};
//// （金币）   木材 1 铁2 秘银3 食物 4 石头5   十个一组
//    public static int[] jtlist = {100, 100, 100, 0, 100, 10};
//                              金币  木材  铁 秘银 食物  石头
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb1) {
            if (Zhuangyuan.jtlist[0] < Zhuangyuan.buy资源价格[1]) {
                Zhuangyuan.myjscPane.add(new Jlabeltool("钱不够"));
                Zhuangyuan.addlenth();
            } else {
                Zhuangyuan.jtlist[0] -= Zhuangyuan.buy资源价格[1];
                Zhuangyuan.jtlist[1]+=10;
                Zhuangyuan.myjscPane.add(new Jlabeltool("购买成功，当前库存" + Zhuangyuan.jtlist[1]));
                Zhuangyuan.addlenth();
            }
        }
        else if (e.getSource() == jb2) {
            if (Zhuangyuan.jtlist[0] < Zhuangyuan.buy资源价格[2]) {
                Zhuangyuan.myjscPane.add(new Jlabeltool("钱不够"));
                Zhuangyuan.addlenth();
            } else {
                Zhuangyuan.jtlist[0] -= Zhuangyuan.buy资源价格[2];Zhuangyuan.jtlist[2]+=10;
                Zhuangyuan.myjscPane.add(new Jlabeltool("购买成功，当前库存" + Zhuangyuan.jtlist[2]));
                Zhuangyuan.addlenth();
            }
        }
       else  if (e.getSource() == jb3) {
            if (Zhuangyuan.jtlist[0] < Zhuangyuan.buy资源价格[3]) {
                Zhuangyuan.myjscPane.add(new Jlabeltool("钱不够"));
                Zhuangyuan.addlenth();
            } else {
                Zhuangyuan.jtlist[0] -= Zhuangyuan.buy资源价格[3];Zhuangyuan.jtlist[3]+=10;
                Zhuangyuan.myjscPane.add(new Jlabeltool("购买成功，当前库存" + Zhuangyuan.jtlist[3]));
                Zhuangyuan.addlenth();
            }
        }
        else if (e.getSource() == jb4) {
            if (Zhuangyuan.jtlist[0] < Zhuangyuan.buy资源价格[4]) {
                Zhuangyuan.myjscPane.add(new Jlabeltool("钱不够"));
                Zhuangyuan.addlenth();
            } else {
                Zhuangyuan.jtlist[0] -= Zhuangyuan.buy资源价格[4];Zhuangyuan.jtlist[4]+=10;
                Zhuangyuan.myjscPane.add(new Jlabeltool("购买成功，当前库存" + Zhuangyuan.jtlist[4]));
                Zhuangyuan.addlenth();
            }
        }
       else  if (e.getSource() == jb5) {
            if (Zhuangyuan.jtlist[0] < Zhuangyuan.buy资源价格[5]) {
                Zhuangyuan.myjscPane.add(new Jlabeltool("钱不够"));
                Zhuangyuan.addlenth();
            } else {
                Zhuangyuan.jtlist[0] -= Zhuangyuan.buy资源价格[5];Zhuangyuan.jtlist[5]+=10;
                Zhuangyuan.myjscPane.add(new Jlabeltool("购买成功，当前库存" + Zhuangyuan.jtlist[5]));
                Zhuangyuan.addlenth();
            }
        }
        else  if (e.getSource() == jbb1) {
            if (Zhuangyuan.jtlist[0] < buy进阶材料价格[1]) {
                Zhuangyuan.myjscPane.add(new Jlabeltool("钱不够"));
                Zhuangyuan.addlenth();
            } else {
                Zhuangyuan.jtlist[0] -= buy进阶材料价格[1];Zhuangyuan.shuliang一阶进阶材料[1]++;
                Zhuangyuan.myjscPane.add(new Jlabeltool("牧师的勋章，已拥有：" + Zhuangyuan.shuliang一阶进阶材料[1]));
                Zhuangyuan.addlenth();
            }
        }
        else  if (e.getSource() == jbb2) {
            if (Zhuangyuan.jtlist[0] < buy进阶材料价格[2]) {
                Zhuangyuan.myjscPane.add(new Jlabeltool("钱不够"));
                Zhuangyuan.addlenth();
            } else {
                Zhuangyuan.jtlist[0] -= buy进阶材料价格[2];Zhuangyuan.shuliang一阶进阶材料[2]++;
                Zhuangyuan.myjscPane.add(new Jlabeltool("盗贼之证，已拥有：" + Zhuangyuan.shuliang一阶进阶材料[2]));
                Zhuangyuan.addlenth();
            }
        }
        else  if (e.getSource() == jbb3) {
            if (Zhuangyuan.jtlist[0] < buy进阶材料价格[3]) {
                Zhuangyuan.myjscPane.add(new Jlabeltool("钱不够"));
                Zhuangyuan.addlenth();
            } else {
                Zhuangyuan.jtlist[0] -= buy进阶材料价格[3];Zhuangyuan.shuliang一阶进阶材料[3]++;
                Zhuangyuan.myjscPane.add(new Jlabeltool("巫师的勋章，已拥有：" + Zhuangyuan.shuliang一阶进阶材料[3]));
                Zhuangyuan.addlenth();
            }
        }
        else  if (e.getSource() == jbb4) {
            if (Zhuangyuan.jtlist[0] < buy进阶材料价格[4]) {
                Zhuangyuan.myjscPane.add(new Jlabeltool("钱不够"));
                Zhuangyuan.addlenth();
            } else {
                Zhuangyuan.jtlist[0] -= buy进阶材料价格[4];Zhuangyuan.shuliang一阶进阶材料[4]++;
                Zhuangyuan.myjscPane.add(new Jlabeltool("战士的勋章，已拥有：" + Zhuangyuan.shuliang一阶进阶材料[4]));
                Zhuangyuan.addlenth();
            }
        }
        else  if (e.getSource() == jbb5) {
            if (Zhuangyuan.jtlist[0] < buy进阶材料价格[5]) {
                Zhuangyuan.myjscPane.add(new Jlabeltool("钱不够"));
                Zhuangyuan.addlenth();
            } else {
                Zhuangyuan.jtlist[0] -= buy进阶材料价格[5];Zhuangyuan.shuliang一阶进阶材料[5]++;
                Zhuangyuan.myjscPane.add(new Jlabeltool("弓箭手的勋章，已拥有：" + Zhuangyuan.shuliang一阶进阶材料[5]));
                Zhuangyuan.addlenth();
            }
        }
        else  if (e.getSource() == jbb6) {
            if (Zhuangyuan.jtlist[0] < buy进阶材料价格[6]) {
                Zhuangyuan.myjscPane.add(new Jlabeltool("钱不够"));
                Zhuangyuan.addlenth();
            } else {
                Zhuangyuan.jtlist[0] -= buy进阶材料价格[6];Zhuangyuan.shuliang一阶进阶材料[6]++;
                Zhuangyuan.myjscPane.add(new Jlabeltool("佣兵的勋章，已拥有：" + Zhuangyuan.shuliang一阶进阶材料[6]));
                Zhuangyuan.addlenth();
            }
        }
        else{
            return;
        }



    }

    public void 打印信息() {
        int i;
        for (i = 1; i <= 5; i++) {
            this.add(new Jl菜单("价格:" + Zhuangyuan.buy资源价格[i], 180, 70 + 45 * (i - 1), 500, 44));
        }
        for (i = 1; i <= 6; i++) {
            this.add(new Jl菜单("价格:" + buy进阶材料价格[i], Zhuangyuan.frameWidth / 2 + 120, 70 + 45 * (i - 1), 500, 44));
        }
    }
}
