package com.Zhuangyuan.fyx;

import sun.misc.JavaLangAccess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Comparator;

//
//                     ����.setBounds(30,50+30,121,75);
//                    ����.setBounds(30,130+30,121,75);
//                    �̵�.setBounds(30,210+30,121,75);
class jpane����Button extends JButton {
    jpane����Button(String name) {
        this.setText(name);
        this.setFont(new Font("΢���ź�", Font.BOLD, 16));
        this.setForeground(Color.white);
        this.setFocusPainted(false);//����ѡ��
        this.setBackground(Color.black);
        this.setBorderPainted(false);
    }
}

class myjl extends JLabel {
    myjl(int i) {
        this.setBounds(180, 70 + 45 * (i - 1), 500, 44);
        this.setFont(new Font("΢���ź�", Font.PLAIN, 16));
        this.setForeground(Color.white);
        this.setBackground(Color.WHITE);

    }
}

public class Jpane���� extends JPanel implements ActionListener {


    public static JButton toJP01 = new jpane����Button("<-");
    public static JButton do��Ӫ = new jpane����Button("��Ӫ");
    public static JButton do�̵� = new jpane����Button("�̵�");
    public static JButton doѵ��Ӫ = new jpane����Button("ѵ��Ӫ");

    public JLabel jl�̵� = new myjl(2);
    public JLabel jl��Ӫ = new myjl(1);
    public JLabel jlѵ��Ӫ = new myjl(3);

    public JLabel jl��Ӫcost = new JLabel("                 " + "���컨��:" + Zhuangyuan.cost��Ӫ[Zhuangyuan.number����[1]][0] + "ľ��" + Zhuangyuan.cost��Ӫ[Zhuangyuan.number����[1]][1] + "ʯͷ");

    Jpane����() {
        this.setBackground(Color.darkGray);
        this.setVisible(false);
        this.setLayout(null);
        this.setSize(Zhuangyuan.frameWidth, Zhuangyuan.frameHeight);

        this.add(toJP01);
        toJP01.setFont(new Font("΢���ź�", Font.BOLD, 30));
        toJP01.setForeground(Color.white);
        toJP01.setFocusPainted(false);//����ѡ��
        toJP01.setBackground(Color.DARK_GRAY);
        toJP01.setBorderPainted(false);
        jl��Ӫcost.setFont(new Font("΢���ź�", Font.PLAIN, 16));
        jl��Ӫcost.setForeground(Color.white);
        jl��Ӫcost.setBackground(Color.WHITE);

        toJP01.setBounds(5, 5, 70, 60);

        do��Ӫ.setBounds(80, 70, 90, 44);
        do�̵�.setBounds(80, 70 + 45, 90, 44);
        doѵ��Ӫ.setBounds(80, 70 + 90, 90, 44);
        jl��Ӫcost.setBounds(180, 70, 500, 44);
        this.add(do�̵�);
        this.add(do��Ӫ);
        this.add(doѵ��Ӫ);
        this.add(jl�̵�);
        this.add(jl��Ӫ);
        this.add(jlѵ��Ӫ);
        this.add(jl��Ӫcost);

        ������Ϣ();
        ��ӡ��Ϣ();
        do��Ӫ.addActionListener(this);
        doѵ��Ӫ.addActionListener(this);
        do�̵�.addActionListener(this);


    }
//    public static int number����[] = {0, 0, 0, 0};
    //    0 ��լn���̵�0-1��ѵ��0-1��
//public static int[] jtlist = {100, 100, 100, 0, 100, 10};
    //���  ľ��  �� ���� ʳ��  ʯͷ

    //    public static int cost��Ӫ[][] = {
//            {10, 10}, {100, 50}, {300, 150}, {500, 300}, {1000, 500}, {5000, 2500}, {10000, 50000}
//            //ľ�ģ�ʯͷ
//    };
//    public static int cost����ѵ��Ӫ[][]={{},{},{50,100},{100,200}};
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == do�̵�) {
            if (Zhuangyuan.number����[2] == 1) {
                Zhuangyuan.myjscPane.add(new Jlabeltool("�Ǳ����Ѿ����̵���"));
            } else if (Zhuangyuan.jtlist[1] < Zhuangyuan.cost����ѵ��Ӫ[2][0] || Zhuangyuan.jtlist[5] < Zhuangyuan.cost����ѵ��Ӫ[2][1]) {
                Zhuangyuan.myjscPane.add(new Jlabeltool("��Դ����"));
            } else {

                Zhuangyuan.jtlist[1] -= Zhuangyuan.cost����ѵ��Ӫ[2][0];
                Zhuangyuan.jtlist[5] -= Zhuangyuan.cost����ѵ��Ӫ[2][1];
                Zhuangyuan.number����[2] = 1;
                Zhuangyuan.myjscPane.add(new Jlabeltool("����ɹ�"));
            }
        } else if (e.getSource() == doѵ��Ӫ) {
            if (Zhuangyuan.number����[3] == 1) {
                Zhuangyuan.myjscPane.add(new Jlabeltool("�Ǳ����Ѿ���ѵ��Ӫ��"));
            } else if (Zhuangyuan.jtlist[1] < Zhuangyuan.cost����ѵ��Ӫ[3][0] || Zhuangyuan.jtlist[5] < Zhuangyuan.cost����ѵ��Ӫ[3][1]) {
                Zhuangyuan.myjscPane.add(new Jlabeltool("��Դ����"));
            } else {
                Zhuangyuan.jtlist[1] -= Zhuangyuan.cost����ѵ��Ӫ[3][0];
                Zhuangyuan.jtlist[5] -= Zhuangyuan.cost����ѵ��Ӫ[3][1];
                Zhuangyuan.number����[3] = 1;
                Zhuangyuan.myjscPane.add(new Jlabeltool("����ɹ�"));
            }
        } else if (e.getSource() == do��Ӫ) {
            if(Zhuangyuan.number����[1]>12){
                Zhuangyuan.myjscPane.add(new Jlabeltool("�Ѵ�����"));


            }
            else if (Zhuangyuan.jtlist[1] < Zhuangyuan.cost��Ӫ[Zhuangyuan.number����[1]][0] || Zhuangyuan.jtlist[5] < Zhuangyuan.cost��Ӫ[Zhuangyuan.number����[1]][1]) {
                Zhuangyuan.myjscPane.add(new Jlabeltool("��Դ����"));
            } else {
                Zhuangyuan.jtlist[1] -= Zhuangyuan.cost��Ӫ[Zhuangyuan.number����[1]][0];
                Zhuangyuan.jtlist[5] -= Zhuangyuan.cost��Ӫ[Zhuangyuan.number����[1]][1];
                Zhuangyuan.number����[1]++;
                Jp02.���� += 20;
                Jp02.����jl.setText("ʣ�๤����" + Jp02.����);
                Zhuangyuan.myjscPane.add(new Jlabeltool("����ɹ�"));
            }
        }
        else {
            return;
        }
        Zhuangyuan.addlenth();
        ������Ϣ();

    }

    public void ��ӡ��Ϣ() {
        int i;
        for (i = 2; i <= 3; i++) {
            this.add(new Jl�˵�("                 " + "���컨��:" + Zhuangyuan.cost����ѵ��Ӫ[i][0] + "ľ��" + Zhuangyuan.cost����ѵ��Ӫ[i][1] + "ʯͷ", 180, 70 + 45 * (i - 1), 500, 44));
        }
    }

    public void ������Ϣ() {
        jl�̵�.setText("��ӵ�У�" + Zhuangyuan.number����[2]);
        jl��Ӫ.setText("��ӵ�У�" + Zhuangyuan.number����[1]);
        jlѵ��Ӫ.setText("��ӵ�У�" + Zhuangyuan.number����[3]);
        if(Zhuangyuan.number����[1]<=12)
        jl��Ӫcost.setText("                 " + "���컨��:" + Zhuangyuan.cost��Ӫ[Zhuangyuan.number����[1]][0] + "ľ��" + Zhuangyuan.cost��Ӫ[Zhuangyuan.number����[1]][1] + "ʯͷ");
        else
            jl��Ӫcost.setText("                 " + "����������");

    }
}
