package com.Zhuangyuan.fyx;


import sun.misc.JavaLangAccess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

class Jb02 extends JButton {
    Jb02(String A) {
        this.setText(A);
        this.setFont(new Font("", Font.PLAIN, 24));
        this.setForeground(Color.white);
//         炼金.setContentAreaFilled(false);//消除背景
        this.setFocusPainted(false);//消除选择
        this.setBackground(Color.lightGray);
        this.setBorderPainted(false);
        this.setOpaque(false);

    }
}

class Jlab02 extends JLabel {
    Jlab02(String A, int x, int y, int with, int high) {

        this.setFont(new Font("微软雅黑", Font.PLAIN, 24));
        this.setText(A);
        this.setForeground(Color.red);
        this.setBounds(x, y, with, high);

    }
}

public class Jp02 extends JPanel implements ActionListener {
    public JButton 木材l = new Jb02("-");
    public JButton 木材2 = new Jb02("+");
    public JButton 铁1 = new Jb02("-");
    public JButton 铁2 = new Jb02("+");
    public JButton 秘银1 = new Jb02("-");
    public JButton 秘银2 = new Jb02("+");
    public JButton 食物1 = new Jb02("-");
    public JButton 食物2 = new Jb02("+");

    public JLabel jl000;
    public JLabel jl001;
    public JLabel jl002;
    public JLabel jl003;
    public static JLabel 工匠jl = new myJtext();
    public static int 工作[] = {0, 0, 0, 0};
    //    食物，木材，铁，秘银
    public static int 工匠 = 30 - 工作[3] - 工作[1] - 工作[2] - 工作[0];

    //    食物，木材，铁，秘银
    public static JButton toJP01 = new JButton("<-");

//    public int outwork = 工匠;


    public static Thread t工匠;
    public static Thread t采集;
    public int t工匠CD = 10, t采集CD = 10;
    public JLabel jl工作倒计时 = new Jlab02("下次收获" + t工匠CD + "秒", Zhuangyuan.frameWidth / 2 + 70, Zhuangyuan.frameHeight / 4 - 100 + 130, 200, 170);
    public JLabel jl采集倒计时 = new Jlab02("CD中", 70 + 50, 250, 200, 170);
    JButton 采集 = new JButton("采集");
    public static int post[] = {0, 0, 0, 0, 0, 0};
    public static int x[] = {0, 0, 0, 0, 0, 0};
    //金币  木材  铁 秘银 食物  石头
    public JLabel JL食物 = new myJtext();
    public JLabel JL木材 = new myJtext();
    public JLabel JL铁 = new myJtext();
    public JLabel JL秘银 = new myJtext();


    public Jp02() {
        post[4] = 工作[0];
        post[1] = 工作[1];
        post[2] = 工作[2];
        post[3] = 工作[3];

        Zhuangyuan.jScrollPane.setVisible(true);
        jl工作倒计时.setForeground(Color.black);
        jl工作倒计时.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        jl工作倒计时.setForeground(Color.white);
        jl采集倒计时.setForeground(Color.black);
        jl采集倒计时.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        jl采集倒计时.setForeground(Color.white);
        this.setBackground(Color.lightGray);
        this.setVisible(false);
        this.setLayout(null);
        this.setSize(Zhuangyuan.frameWidth, Zhuangyuan.frameHeight);

        toJP01.setFont(new Font("微软雅黑", Font.BOLD, 30));
        toJP01.setForeground(Color.white);
//         炼金.setContentAreaFilled(false);//消除背景
        toJP01.setFocusPainted(false);//消除选择
        toJP01.setBackground(Color.darkGray);
        toJP01.setBorderPainted(false);
        toJP01.setBounds(5, 5, 70, 60);


        采集.setFont(new Font("微软雅黑", Font.BOLD, 30));
        采集.setForeground(Color.white);
//         炼金.setContentAreaFilled(false);//消除背景
        采集.setFocusPainted(false);//消除选择
        采集.setBackground(Color.BLACK);
        采集.setBorderPainted(false);
        采集.setFont(new Font("微软雅黑", Font.BOLD, 40));
        采集.setBounds(70, 200, 150, 90);


        工匠jl.setText("剩余工匠：" + 工匠);
        工匠jl.setBounds(70, 100, 200, 100);

        this.add(JL木材);
        this.add(JL食物);
        this.add(JL铁);
        this.add(JL秘银);


        this.add(采集);
        this.add(工匠jl);
        this.add(toJP01);

        this.add(jl采集倒计时);
        this.add(jl工作倒计时);
        this.add(木材l);
        this.add(木材2);
        this.add(食物1);
        this.add(食物2);
        this.add(铁1);
        this.add(铁2);
        this.add(秘银1);
        this.add(秘银2);
        this.add(new Jlab02("面包工", Zhuangyuan.frameWidth / 2 + 5, Zhuangyuan.frameHeight / 4 - 100, 100, 50));
        食物1.setBounds(Zhuangyuan.frameWidth / 2 + 110, Zhuangyuan.frameHeight / 4 - 100, 50, 50);
        this.add(jl000 = new Jlab02(Jp02.工作[0] + "", Zhuangyuan.frameWidth / 2 + 175, Zhuangyuan.frameHeight / 4 - 100, 50, 50));
        食物2.setBounds(Zhuangyuan.frameWidth / 2 + 210, Zhuangyuan.frameHeight / 4 - 100, 50, 50);

        this.add(new Jlab02("伐木工", Zhuangyuan.frameWidth / 2 + 5, Zhuangyuan.frameHeight / 4 - 100 + 50, 100, 50));
        木材l.setBounds(Zhuangyuan.frameWidth / 2 + 110, Zhuangyuan.frameHeight / 4 - 100 + 50, 50, 50);
        this.add(jl001 = new Jlab02(Jp02.工作[1] + "", Zhuangyuan.frameWidth / 2 + 175, Zhuangyuan.frameHeight / 4 - 100 + 50, 50, 50));
        木材2.setBounds(Zhuangyuan.frameWidth / 2 + 210, Zhuangyuan.frameHeight / 4 - 100 + 50, 50, 50);

        this.add(new Jlab02("矿工", Zhuangyuan.frameWidth / 2 + 5, Zhuangyuan.frameHeight / 4 - 100 + 100, 100, 50));
        铁1.setBounds(Zhuangyuan.frameWidth / 2 + 110, Zhuangyuan.frameHeight / 4 - 100 + 100, 50, 50);
        this.add(jl002 = new Jlab02(Jp02.工作[2] + "", Zhuangyuan.frameWidth / 2 + 175, Zhuangyuan.frameHeight / 4 - 100 + 100, 50, 50));
        铁2.setBounds(Zhuangyuan.frameWidth / 2 + 210, Zhuangyuan.frameHeight / 4 - 100 + 100, 50, 50);

        this.add(new Jlab02("秘银匠", Zhuangyuan.frameWidth / 2 + 5, Zhuangyuan.frameHeight / 4 - 100 + 150, 100, 50));
        秘银1.setBounds(Zhuangyuan.frameWidth / 2 + 110, Zhuangyuan.frameHeight / 4 - 100 + 150, 50, 50);
        this.add(jl003 = new Jlab02(Jp02.工作[3] + "", Zhuangyuan.frameWidth / 2 + 175, Zhuangyuan.frameHeight / 4 - 100 + 150, 50, 50));
        秘银2.setBounds(Zhuangyuan.frameWidth / 2 + 210, Zhuangyuan.frameHeight / 4 - 100 + 150, 50, 50);

        JLabel JL上次收获 = new myJtext();
        JL上次收获.setText("上次收获");
        JL食物.setText("食物： " + x[4]);
        JL木材.setText("木材： " + x[1]);
        JL铁.setText("铁： " + x[2]);
        JL秘银.setText("秘银： " + x[3]);
        this.add(JL上次收获);
        JL上次收获.setBounds(Zhuangyuan.frameWidth / 2 + 70, Zhuangyuan.frameHeight / 4 - 100 + 130 + 30, 200, 170);
        JL食物.setBounds(Zhuangyuan.frameWidth / 2 + 70, Zhuangyuan.frameHeight / 4 - 100 + 130 + 60, 200, 170);
        JL木材.setBounds(Zhuangyuan.frameWidth / 2 + 70, Zhuangyuan.frameHeight / 4 - 100 + 130 + 90, 200, 170);
        JL铁.setBounds(Zhuangyuan.frameWidth / 2 + 70, Zhuangyuan.frameHeight / 4 - 100 + 130 + 120, 200, 170);
        JL秘银.setBounds(Zhuangyuan.frameWidth / 2 + 70, Zhuangyuan.frameHeight / 4 - 100 + 130 + 150, 200, 170);

        木材l.addActionListener(this);
        木材2.addActionListener(this);
        食物1.addActionListener(this);
        食物2.addActionListener(this);
        铁1.addActionListener(this);
        铁2.addActionListener(this);
        秘银1.addActionListener(this);
        秘银2.addActionListener(this);
        采集.addActionListener(this);

        t工匠 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    t工匠CD--;
                    jl工作倒计时.setText("下次收获" + t工匠CD + "秒");
                    if (t工匠CD <= 0) {

                        传输资源();
                        t工匠CD = 3;
                    }
                }
            }
        });

        t采集 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (t采集CD > 0) {
                        t采集CD--;
                    } else {
                        jl采集倒计时.setText("可采集");
                    }
                }
            }
        });


        t采集.start();
        t工匠.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //post[]金币  木材  铁 秘银 食物  石头
        if (e.getSource() == 采集) {
            Random rand = new Random();
            if (t采集CD <= 0) {
                int i1,i5;
                i1 = 100 + rand.nextInt(200);
                i5 = 50 + rand.nextInt(200);
                jl采集倒计时.setText("CD中");
                Zhuangyuan.myjscPane.add(new Jlabeltool("收集到" + i1 + "木材"));
                Zhuangyuan.myjscPane.add(new Jlabeltool("收集到" + i5 + "石头"));
                Zhuangyuan.jtlist[1] += i1;
                Zhuangyuan.jtlist[5] += i5;
                Zhuangyuan.addlenth();
                Zhuangyuan.addlenth();
                t采集CD = 5;
            }
        } else if (e.getSource() == 食物1) {
//            System.out.println(工作[0]);
            if (工作[0] > 0) {
                工匠++;
                工作[0]--;
            }
        } else if (e.getSource() == 木材l) {
            if (工作[1] > 0) {
                工匠++;
                工作[1]--;
            }
        } else if (e.getSource() == 铁1) {
            if (工作[2] > 0) {
                工匠++;
                工作[2]--;
            }
        } else if (e.getSource() == 秘银1) {
            if (工作[3] > 0) {
                工匠++;
                工作[3]--;
            }
        } else if (e.getSource() == 食物2) {
            if (工匠 > 0) {
                工作[0]++;
                工匠--;
            }
        } else if (e.getSource() == 木材2) {
            if (工匠 > 0) {
                工作[1]++;
                工匠--;
            }
        } else if (e.getSource() == 铁2) {
            if (工匠 > 0) {
                工作[2]++;
                工匠--;
            }
        } else if (e.getSource() == 秘银2) {
            if (工匠 > 0) {
                工作[3]++;
                工匠--;
            }
        }

        post[4] = 工作[0];
        post[1] = 工作[1];
        post[2] = 工作[2];
        post[3] = 工作[3];
//        System.out.println(工匠);
//        System.out.println(工作[0] + 工作[1] + 工作[2] + 工作[3]);
        jl000.setText(post[4] + "");
        jl001.setText(post[1] + "");
        jl002.setText(post[2] + "");
        jl003.setText(post[3] + "");


        工匠jl.setText("剩余工匠：" + 工匠);

    }

    public void 传输资源() {
        //金币  木材  铁 秘银 食物  石头
        x[4] = post[4] - post[1] - 2 * post[2] - 5 * post[3] ;
        System.out.println(x[4]);
        if ((Zhuangyuan.jtlist[4] + x[4]) > 0) {
//            System.out.println("ok");
            for (int i = 1; i <= 3; i++) {
                x[i] = post[i];
            }
        } else {
            x[4] = post[4];
            x[1]=0;
            x[2]=0;
            x[3]=0;
        }
        for (int i = 1; i <= 4; i++) {
            Zhuangyuan.jtlist[i] += x[i];
        }
        JL食物.setText("食物： " + x[4]);
        JL木材.setText("木材： " + x[1]);
        JL铁.setText("铁： " + x[2]);
        JL秘银.setText("秘银： " + x[3]);
//        Zhuangyuan.myjscPane.add(new Jlabeltool("工匠收获"+x[4]+"食物"));
//        Zhuangyuan.myjscPane.add(new Jlabeltool("工匠收获"+x[1]+"木材"));
//        Zhuangyuan.myjscPane.add(new Jlabeltool("工匠收获"+x[2]+"铁"));
//        Zhuangyuan.myjscPane.add(new Jlabeltool("工匠收获"+x[3]+"秘银"));
        Zhuangyuan.jt1.setText("金币： " + Zhuangyuan.jtlist[0]);
        Zhuangyuan.jt2.setText("木材： " + Zhuangyuan.jtlist[1]);
        Zhuangyuan.jt3.setText("铁： " + Zhuangyuan.jtlist[2]);
        Zhuangyuan.jt4.setText("秘银： " + Zhuangyuan.jtlist[3]);
        Zhuangyuan.jt5.setText("食物： " + Zhuangyuan.jtlist[4]);
        Zhuangyuan.jt6.setText("石头： " + Zhuangyuan.jtlist[5]);
        Jpane出征.打印冒险者();
    }
}
