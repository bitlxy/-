package com.Zhuangyuan.fyx;

import ExploreAndFight.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class jl���� extends JLabel {
    jl����(int x) {
        this.setVisible(false);
        this.setBounds(55 + 20, 20 + 50 + 40 * (x), 500, 40);
        this.setFont(new Font("΢���ź�", Font.PLAIN, 20));
        this.setForeground(Color.white);
        this.setBackground(Color.CYAN);
    }
}

class Jb���� extends JButton {
    Jb����(String A) {
        this.setVisible(false);
        this.setText(A);
        this.setFont(new Font("", Font.PLAIN, 24));
        this.setForeground(Color.white);
        this.setFocusPainted(false);//����ѡ��
        this.setBackground(Color.lightGray);
        this.setBorderPainted(false);
        this.setOpaque(false);

    }
}

public class Jpane���� extends JPanel implements ActionListener {
    public static String name[] = {"ð����", "��ʦ", "����", "��ʦ", "սʿ", "������", "Ӷ��", "����ð����", "ѩ��սʿ"};
    public static JButton toJP01 = new JButton("->");
    public static JLabel jl��ʾ = new JLabel();
    public static int ����[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static int ���� = 0;
    public static int flag[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static JButton jbȷ�� = new Jb�˵�("����");
    public static JLabel jl����[] = {new jl����(0), new jl����(1), new jl����(2), new jl����(3), new jl����(4), new jl����(5), new jl����(6), new jl����(7), new jl����(8),};
    //ð��0;��ʦ1������2����ʦ3��սʿ4��������5��Ӷ��6������7,ѩ��8��һ��9
    public static JButton jb0_1[][] = {
            {new Jb����("-"), new Jb����("+")},
            {new Jb����("-"), new Jb����("+")},
            {new Jb����("-"), new Jb����("+")},
            {new Jb����("-"), new Jb����("+")},
            {new Jb����("-"), new Jb����("+")},
            {new Jb����("-"), new Jb����("+")},
            {new Jb����("-"), new Jb����("+")},
            {new Jb����("-"), new Jb����("+")},
            {new Jb����("-"), new Jb����("+")},
    };
    public static JButton jbʳ��[] = {new Jb�˵�("-"), new Jb�˵�("+")};
    public static JLabel jlʳ�� = new JLabel();
    public static int ������С = 50 + Jpane����.level���� * 50;
    public static int ʳ��;

    Jpane����() {
        this.setBackground(Color.lightGray);
        this.setVisible(false);
        this.setLayout(null);
        this.setSize(Zhuangyuan.frameWidth, Zhuangyuan.frameHeight);
        toJP01.setBounds(Zhuangyuan.frameWidth - 95, 5, 70, 60);
        this.add(toJP01);
        toJP01.setFont(new Font("΢���ź�", Font.BOLD, 30));
        toJP01.setForeground(Color.white);
        toJP01.setFocusPainted(false);//����ѡ��
        toJP01.setBackground(Color.DARK_GRAY);
        toJP01.setBorderPainted(false);

        jl��ʾ.setFont(new Font("΢���ź�", Font.PLAIN, 16));
        jl��ʾ.setForeground(Color.white);
        jl��ʾ.setBounds(Zhuangyuan.frameWidth / 2 + 75, Zhuangyuan.frameHeight / 2 - 260, 500, 50);
        this.add(jl��ʾ);
        jlʳ��.setFont(new Font("΢���ź�", Font.PLAIN, 16));
        jlʳ��.setForeground(Color.white);
        jlʳ��.setBounds(Zhuangyuan.frameWidth / 2 + 90, Zhuangyuan.frameHeight / 2 - 100, 500, 50);
        this.add(jlʳ��);
        jbʳ��[0].setBounds(Zhuangyuan.frameWidth / 2 + 35, Zhuangyuan.frameHeight / 2 - 100, 50, 50);
        jbʳ��[1].setBounds(Zhuangyuan.frameWidth / 2 + 230, Zhuangyuan.frameHeight / 2 - 100, 50, 50);
        this.add(jbʳ��[0]);
        this.add(jbʳ��[1]);
        jbʳ��[0].addActionListener(this);
        jbʳ��[1].addActionListener(this);
        jbʳ��[0].setOpaque(false);
        jbʳ��[1].setOpaque(false);
        jbȷ��.setFont(new Font("΢���ź�", Font.BOLD, 35));
        jbȷ��.setForeground(Color.white);
        jbȷ��.setBounds(Zhuangyuan.frameWidth / 2 + 110, Zhuangyuan.frameHeight / 2 - 200, 121, 75);
        this.add(jbȷ��);
        jbȷ��.addActionListener(this);


        for (int i = 0; i <= 8; i++) {
            jb0_1[i][0].setBounds(0 + 20, 50 + 20 + 40 * (i), 50, 50);
            jb0_1[i][1].setBounds(175 + 50, 50 + 20 + 40 * (i), 50, 50);

        }
        for (int i = 0; i <= 8; i++) {
            this.add(jl����[i]);
            this.add(jb0_1[i][0]);
            this.add(jb0_1[i][1]);
            jb0_1[i][0].addActionListener(this);
            jb0_1[i][1].addActionListener(this);
        }


        if (������С <= Zhuangyuan.jtlist[4]) {
            ʳ�� = ������С;
        } else {
            ʳ�� = Zhuangyuan.jtlist[4];
        }
        ��ӡð����();
    }

    //    public static int cal=0;
//    public static ExploreView exploreView=new ExploreView();
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbȷ��) {
            if (���� <= 0) {
                Zhuangyuan.myjscPane.add(new Jlabeltool("û�а��Ź�Ӷ����"));
                Zhuangyuan.addlenth();
                return;
            } else if (ʳ�� <= 0) {
                Zhuangyuan.myjscPane.add(new Jlabeltool("û��Я�����"));
                Zhuangyuan.addlenth();
                return;
            }
            ExploreView.exploreView = new ExploreView();
            ExploreView.exploreView.chushihuaExploreView();
            ExploreView.exploreView.showView();
            ZhuangyaunMain.mainjf.setVisible(false);
            return;
        }
        if (e.getSource() == jbʳ��[0]) {
            if (ʳ�� > 0) {
                ʳ��--;
            } else return;
        }
        if (e.getSource() == jbʳ��[1]) {
            if (ʳ�� >= Zhuangyuan.jtlist[4]) {
                Zhuangyuan.myjscPane.add(new Jlabeltool("ʳ�ﲻ����"));
                Zhuangyuan.addlenth();
                return;
            }
            if (������С > ʳ��) {
                ʳ��++;
            } else return;
        }

        for (int i = 0; i <= 8; i++) {
            int id = flag[i];
            if (e.getSource() == jb0_1[i][0]) {
                if (����[id] > 0) {
                    ����[id]--;
                    ����--;
                } else break;
            }
            if (e.getSource() == jb0_1[i][1]) {
                if (���� >= 3) {
                    Zhuangyuan.myjscPane.add(new Jlabeltool("������"));
                    Zhuangyuan.addlenth();
                    break;
                }
                if (����[id] < Zhuangyuan.shuliangð����[id]) {
                    ����[id]++;
                    ����++;
                } else break;
            }
        }
        ��ӡð����();

    }

    public static void ����ʳ��() {
        ������С = 50 + Jpane����.level���� * Jpane����.level���� * 50;
        if (������С <= Zhuangyuan.jtlist[4]) {
            ʳ�� = ������С;
        } else {
            ʳ�� = Zhuangyuan.jtlist[4];
        }
        jlʳ��.setText("Я��ʳ�" + ʳ�� + "/" + ������С);

    }

    public static void ��ӡð����() {
        if (ʳ�� > Zhuangyuan.jtlist[4]) {
            ʳ�� = Zhuangyuan.jtlist[4];
        }
        jlʳ��.setText("Я��ʳ�" + ʳ�� + "/" + ������С);
        for (int x = 0; x <= 8; x++) {
            flag[x] = 0;
            jl����[x].setVisible(false);
            jb0_1[x][0].setVisible(false);
            jb0_1[x][1].setVisible(false);
        }
        int id;
        int p = 0;
        for (id = 0; id <= 8; id++) {
            if (Zhuangyuan.shuliangð����[id] >= 1) {
                jl����[p].setVisible(true);
                jb0_1[p][0].setVisible(true);
                jb0_1[p][1].setVisible(true);
                jl����[p].setText(name[id] + ":" + ����[id] + "/" + Zhuangyuan.shuliangð����[id]);
                if (id == 0) {
                    jl����[p].setForeground(Color.ORANGE);
                }
                if (id >= 1 && id <= 6) {
                    jl����[p].setForeground(Color.red);
                }
                if (id == 7 || id == 8) {
                    jl����[p].setForeground(Color.RED);
                }
                flag[p] = id;
                p++;
            } else continue;
        }
        jl��ʾ.setText("��ѡ��:" + ���� + "�ˣ�����ѡ��" + (3 - ����) + "��");
    }
}
