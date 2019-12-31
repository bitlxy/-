package com.Zhuangyuan.fyx;

import ExploreAndFight.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class jl出征 extends JLabel {
    jl出征(int x) {
        this.setVisible(false);
        this.setBounds(55 + 20, 20 + 50 + 40 * (x), 500, 40);
        this.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        this.setForeground(Color.white);
        this.setBackground(Color.CYAN);
    }
}

class Jb出征 extends JButton {
    Jb出征(String A) {
        this.setVisible(false);
        this.setText(A);
        this.setFont(new Font("", Font.PLAIN, 24));
        this.setForeground(Color.white);
        this.setFocusPainted(false);//消除选择
        this.setBackground(Color.lightGray);
        this.setBorderPainted(false);
        this.setOpaque(false);

    }
}

public class Jpane出征 extends JPanel implements ActionListener {
    public static String name[] = {"冒险者", "牧师", "盗贼", "巫师", "战士", "弓箭手", "佣兵", "龙裔冒险者", "雪人战士"};
    public static JButton toJP01 = new JButton("->");
    public static JLabel jl显示 = new JLabel();
    public static int 出征[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static int 人数 = 0;
    public static int flag[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static JButton jb确认 = new Jb菜单("出征");
    public static JLabel jl出征[] = {new jl出征(0), new jl出征(1), new jl出征(2), new jl出征(3), new jl出征(4), new jl出征(5), new jl出征(6), new jl出征(7), new jl出征(8),};
    //冒险0;牧师1，盗贼2，巫师3，战士4，弓箭手5，佣兵6，龙裔7,雪人8；一共9
    public static JButton jb0_1[][] = {
            {new Jb出征("-"), new Jb出征("+")},
            {new Jb出征("-"), new Jb出征("+")},
            {new Jb出征("-"), new Jb出征("+")},
            {new Jb出征("-"), new Jb出征("+")},
            {new Jb出征("-"), new Jb出征("+")},
            {new Jb出征("-"), new Jb出征("+")},
            {new Jb出征("-"), new Jb出征("+")},
            {new Jb出征("-"), new Jb出征("+")},
            {new Jb出征("-"), new Jb出征("+")},
    };
    public static JButton jb食物[] = {new Jb菜单("-"), new Jb菜单("+")};
    public static JLabel jl食物 = new JLabel();
    public static int 背包大小 = 50 + Jpane制作.level背包 * 50;
    public static int 食物;

    Jpane出征() {
        this.setBackground(Color.lightGray);
        this.setVisible(false);
        this.setLayout(null);
        this.setSize(Zhuangyuan.frameWidth, Zhuangyuan.frameHeight);
        toJP01.setBounds(Zhuangyuan.frameWidth - 95, 5, 70, 60);
        this.add(toJP01);
        toJP01.setFont(new Font("微软雅黑", Font.BOLD, 30));
        toJP01.setForeground(Color.white);
        toJP01.setFocusPainted(false);//消除选择
        toJP01.setBackground(Color.DARK_GRAY);
        toJP01.setBorderPainted(false);

        jl显示.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        jl显示.setForeground(Color.white);
        jl显示.setBounds(Zhuangyuan.frameWidth / 2 + 75, Zhuangyuan.frameHeight / 2 - 260, 500, 50);
        this.add(jl显示);
        jl食物.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        jl食物.setForeground(Color.white);
        jl食物.setBounds(Zhuangyuan.frameWidth / 2 + 90, Zhuangyuan.frameHeight / 2 - 100, 500, 50);
        this.add(jl食物);
        jb食物[0].setBounds(Zhuangyuan.frameWidth / 2 + 35, Zhuangyuan.frameHeight / 2 - 100, 50, 50);
        jb食物[1].setBounds(Zhuangyuan.frameWidth / 2 + 230, Zhuangyuan.frameHeight / 2 - 100, 50, 50);
        this.add(jb食物[0]);
        this.add(jb食物[1]);
        jb食物[0].addActionListener(this);
        jb食物[1].addActionListener(this);
        jb食物[0].setOpaque(false);
        jb食物[1].setOpaque(false);
        jb确认.setFont(new Font("微软雅黑", Font.BOLD, 35));
        jb确认.setForeground(Color.white);
        jb确认.setBounds(Zhuangyuan.frameWidth / 2 + 110, Zhuangyuan.frameHeight / 2 - 200, 121, 75);
        this.add(jb确认);
        jb确认.addActionListener(this);


        for (int i = 0; i <= 8; i++) {
            jb0_1[i][0].setBounds(0 + 20, 50 + 20 + 40 * (i), 50, 50);
            jb0_1[i][1].setBounds(175 + 50, 50 + 20 + 40 * (i), 50, 50);

        }
        for (int i = 0; i <= 8; i++) {
            this.add(jl出征[i]);
            this.add(jb0_1[i][0]);
            this.add(jb0_1[i][1]);
            jb0_1[i][0].addActionListener(this);
            jb0_1[i][1].addActionListener(this);
        }


        if (背包大小 <= Zhuangyuan.jtlist[4]) {
            食物 = 背包大小;
        } else {
            食物 = Zhuangyuan.jtlist[4];
        }
        打印冒险者();
    }

    //    public static int cal=0;
//    public static ExploreView exploreView=new ExploreView();
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb确认) {
            if (人数 <= 0) {
                Zhuangyuan.myjscPane.add(new Jlabeltool("没有安排雇佣兵！"));
                Zhuangyuan.addlenth();
                return;
            } else if (食物 <= 0) {
                Zhuangyuan.myjscPane.add(new Jlabeltool("没有携带面包"));
                Zhuangyuan.addlenth();
                return;
            }
            ExploreView.exploreView = new ExploreView();
            ExploreView.exploreView.chushihuaExploreView();
            ExploreView.exploreView.showView();
            ZhuangyaunMain.mainjf.setVisible(false);
            return;
        }
        if (e.getSource() == jb食物[0]) {
            if (食物 > 0) {
                食物--;
            } else return;
        }
        if (e.getSource() == jb食物[1]) {
            if (食物 >= Zhuangyuan.jtlist[4]) {
                Zhuangyuan.myjscPane.add(new Jlabeltool("食物不够了"));
                Zhuangyuan.addlenth();
                return;
            }
            if (背包大小 > 食物) {
                食物++;
            } else return;
        }

        for (int i = 0; i <= 8; i++) {
            int id = flag[i];
            if (e.getSource() == jb0_1[i][0]) {
                if (出征[id] > 0) {
                    出征[id]--;
                    人数--;
                } else break;
            }
            if (e.getSource() == jb0_1[i][1]) {
                if (人数 >= 3) {
                    Zhuangyuan.myjscPane.add(new Jlabeltool("马车满了"));
                    Zhuangyuan.addlenth();
                    break;
                }
                if (出征[id] < Zhuangyuan.shuliang冒险者[id]) {
                    出征[id]++;
                    人数++;
                } else break;
            }
        }
        打印冒险者();

    }

    public static void 更新食物() {
        背包大小 = 50 + Jpane制作.level背包 * Jpane制作.level背包 * 50;
        if (背包大小 <= Zhuangyuan.jtlist[4]) {
            食物 = 背包大小;
        } else {
            食物 = Zhuangyuan.jtlist[4];
        }
        jl食物.setText("携带食物：" + 食物 + "/" + 背包大小);

    }

    public static void 打印冒险者() {
        if (食物 > Zhuangyuan.jtlist[4]) {
            食物 = Zhuangyuan.jtlist[4];
        }
        jl食物.setText("携带食物：" + 食物 + "/" + 背包大小);
        for (int x = 0; x <= 8; x++) {
            flag[x] = 0;
            jl出征[x].setVisible(false);
            jb0_1[x][0].setVisible(false);
            jb0_1[x][1].setVisible(false);
        }
        int id;
        int p = 0;
        for (id = 0; id <= 8; id++) {
            if (Zhuangyuan.shuliang冒险者[id] >= 1) {
                jl出征[p].setVisible(true);
                jb0_1[p][0].setVisible(true);
                jb0_1[p][1].setVisible(true);
                jl出征[p].setText(name[id] + ":" + 出征[id] + "/" + Zhuangyuan.shuliang冒险者[id]);
                if (id == 0) {
                    jl出征[p].setForeground(Color.ORANGE);
                }
                if (id >= 1 && id <= 6) {
                    jl出征[p].setForeground(Color.red);
                }
                if (id == 7 || id == 8) {
                    jl出征[p].setForeground(Color.RED);
                }
                flag[p] = id;
                p++;
            } else continue;
        }
        jl显示.setText("已选择:" + 人数 + "人，还可选择" + (3 - 人数) + "人");
    }
}
