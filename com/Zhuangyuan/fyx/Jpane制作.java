package com.Zhuangyuan.fyx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Jl���� extends JLabel {
    Jl����(int i, int x, int y) {
        this.setText("���ģ��� " + x + "  ���� " + y + " תְ����:" + "��" + Jpane�̵�.name���ײ���[i] + "��");
        this.setBounds(190, 70 + 45 * (i - 1), 500, 44);
        this.setFont(new Font("΢���ź�", Font.PLAIN, 16));
        this.setForeground(Color.white);
        this.setBackground(Color.WHITE);
    }
}
class Jl���� extends JLabel {
    Jl����(int i, int x, int y) {
        this.setText("���ģ��� " + x + "  ���� " + y);
        this.setBounds(190, 70 + 45 * (i - 1), 500, 44);
        this.setFont(new Font("΢���ź�", Font.PLAIN, 16));
        this.setForeground(Color.white);
        this.setBackground(Color.WHITE);
    }
}

////����Ϊ�������ܣ�ѵ������
//public static int shuliangһ�׽��ײ���[] = {0, 0, 0, 0, 0, 0, 0, 0};
//public static int zhizuoһ�׽��ײ���[][] = {
//        {0, 0}, {100, 50}, {100, 50}, {100, 50}, {100, 50}, {100, 50}, {100, 50}, {200, 200},
//        };// �������������
////��ʦ1������2����ʦ3��սʿ4��������5��Ӷ��6������7
//public static int zhizuo���׽��ײ���[] = {500, 250};
//public static int shuliang���׽��ײ��� = 0;
////ѩ��սʿ
//public static String nameһ�׽��ײ���[] = {"", "ʥ��", "С��������", "����", "ն�ֽ�", "���빭��", "��ҩǹ", "����"};
//public static String name���׽��ײ��� = "ѩ������";
public class Jpane���� extends JPanel implements ActionListener {
    public static String nameһ��[] = {"", "����", "С��������", "ħ��", "ն�ֽ�", "���빭��", "��ҩǹ", "����"};
    public static String name���� = "ѩ������";
    public static int costһ��[][] = {{0, 0}, {100, 50}, {150, 100}, {200, 100}, {300, 150}, {300, 150}, {400, 300}, {500, 500}, {0, 0}
    };// �������������
    public static int cost����[] = {1000, 1000};

    public static JButton toJP01 = new jpane����Button("<-");
    public static JButton jb����[] = {new Jb�˵�(""), new Jb�˵�(nameһ��[1]), new Jb�˵�(nameһ��[2]), new Jb�˵�(nameһ��[3]), new Jb�˵�(nameһ��[4]), new Jb�˵�(nameһ��[5]), new Jb�˵�(nameһ��[6]), new Jb�˵�(nameһ��[7])};
    public static JButton jbѩ������ = new Jb�˵�(name����);
    public static JLabel jl����[] = {new JLabel(), new Jl����(1, costһ��[1][0], costһ��[1][1]), new Jl����(2, costһ��[2][0], costһ��[2][1]), new Jl����(3, costһ��[3][0], costһ��[3][1]), new Jl����(4, costһ��[4][0], costһ��[4][1]), new Jl����(5, costһ��[5][0], costһ��[5][1]), new Jl����(6, costһ��[6][0], costһ��[6][1]), new Jl����(7, costһ��[7][0], costһ��[7][1])};
    public static JLabel jlѩ�� = new Jl�˵�("���ģ���" + cost����[0] + " ���� " + cost����[1] + " תְ����:" + "��" + Jpane�̵�.name���׽��ײ��� + "��", 190, 70 + 45 * 7, 500, 44);
    public static JButton jb����=new Jb�˵�("��������");
    public static int level����=0;
    public String name����[]={"�޲���","��ë��","LV"};
//    1,2,3,��
    public static int cost����[][]={{50,200},{300,500},{500,500}};
    public static JLabel jl����=new Jl����(9,cost����[level����][0],cost����[level����][1]);

    Jpane����() {
        this.setBackground(Color.darkGray);
        this.setVisible(false);
        this.setLayout(null);
        this.setSize(Zhuangyuan.frameWidth, Zhuangyuan.frameHeight);
        toJP01.setBounds(5, 5, 70, 60);
        this.add(toJP01);
        toJP01.setFont(new Font("΢���ź�", Font.BOLD, 30));
        toJP01.setForeground(Color.white);
        toJP01.setFocusPainted(false);//����ѡ��
        toJP01.setBackground(Color.DARK_GRAY);
        toJP01.setBorderPainted(false);

        for (int i = 1; i <= 7; i++) {
            jb����[i].setBounds(60, 70 + 45 * (i - 1), 120, 44);
            jb����[i].addActionListener(this);
            this.add(jb����[i]);
            this.add(jl����[i]);
        }
        jb����.setBounds(60, 70 + 45 * (9 - 1), 120, 44);
        this.add(jb����);

        this.add(jbѩ������);
        this.add(jlѩ��);
        this.add(jl����);
        jbѩ������.setBounds(60, 70 + 315, 120, 44);
        jbѩ������.addActionListener(this);
        jb����.addActionListener(this);

    }

    //    public static int[] jtlist = {100, 100, 100, 0, 100, 10};
//    //���  ľ��  �� ���� ʳ��  ʯͷ
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 1; i <= 7; i++) {
            if (e.getSource() == jb����[i]) {
                if (Zhuangyuan.jtlist[2] < costһ��[i][0] || Zhuangyuan.jtlist[3] < costһ��[i][1] || Zhuangyuan.shuliangһ�׽��ײ���[i] < 1) {
                    Zhuangyuan.myjscPane.add(new Jlabeltool("���ϲ���"));
                    Zhuangyuan.addlenth();
                } else {
                    Zhuangyuan.jtlist[2] -= costһ��[i][0];
                    Zhuangyuan.jtlist[3] -= costһ��[i][1];
                    Zhuangyuan.shuliangһ�׽��ײ���[i]--;
                    Zhuangyuan.shuliang��Ʒһ�ײ���[i]++;
                    Zhuangyuan.myjscPane.add(new Jlabeltool("��ǰӵ��"+nameһ��[i]+Zhuangyuan.shuliang��Ʒһ�ײ���[i]));
                    Zhuangyuan.addlenth();
                }
                break;
            }
        }

        if(e.getSource()==jbѩ������){
            if(Zhuangyuan.jtlist[2] < cost����[0] || Zhuangyuan.jtlist[3] < cost����[1] || Zhuangyuan.shuliang���׽��ײ���<1){
                Zhuangyuan.myjscPane.add(new Jlabeltool("���ϲ���"));
                Zhuangyuan.addlenth();
            }
            else{
                Zhuangyuan.jtlist[2] -= cost����[0];
                Zhuangyuan.jtlist[3] -= cost����[1];
                Zhuangyuan.shuliang���׽��ײ���--;
                Zhuangyuan.shuliang��Ʒ���ײ���++;
                Zhuangyuan.myjscPane.add(new Jlabeltool("��ǰӵ��"+name����+Zhuangyuan.shuliang��Ʒ���ײ���));
                Zhuangyuan.addlenth();

            }
        }
        if(e.getSource()==jb����){
            if(level����>=3) {
                jl����.setText("����������");
                return;
            }
            if(Zhuangyuan.jtlist[2] < cost����[level����][0] || Zhuangyuan.jtlist[3] < cost����[level����][1]){
                Zhuangyuan.myjscPane.add(new Jlabeltool("���ϲ���"));
                Zhuangyuan.addlenth();
            }
            else{
                Zhuangyuan.jtlist[2] -= cost����[level����][0] ;
                Zhuangyuan.jtlist[3] -= cost����[level����][1];
                level����++;
                if(level����<3)
                jl����.setText("���ģ��� " +  cost����[level����][0] + "  ���� " +  cost����[level����][1]);
                else jl����.setText("����������");
                Zhuangyuan.myjscPane.add(new Jlabeltool("�ɹ�����Ϊ"+name����[level����-1]));
                Zhuangyuan.addlenth();


            }

        }

    }
}
