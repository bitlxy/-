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
//         ����.setContentAreaFilled(false);//��������
        this.setFocusPainted(false);//����ѡ��
        this.setBackground(Color.lightGray);
        this.setBorderPainted(false);
        this.setOpaque(false);

    }
}

class Jlab02 extends JLabel {
    Jlab02(String A, int x, int y, int with, int high) {

        this.setFont(new Font("΢���ź�", Font.PLAIN, 24));
        this.setText(A);
        this.setForeground(Color.red);
        this.setBounds(x, y, with, high);

    }
}

public class Jp02 extends JPanel implements ActionListener {
    public JButton ľ��l = new Jb02("-");
    public JButton ľ��2 = new Jb02("+");
    public JButton ��1 = new Jb02("-");
    public JButton ��2 = new Jb02("+");
    public JButton ����1 = new Jb02("-");
    public JButton ����2 = new Jb02("+");
    public JButton ʳ��1 = new Jb02("-");
    public JButton ʳ��2 = new Jb02("+");

    public JLabel jl000;
    public JLabel jl001;
    public JLabel jl002;
    public JLabel jl003;
    public static JLabel ����jl = new myJtext();
    public static int ����[] = {0, 0, 0, 0};
    //    ʳ�ľ�ģ���������
    public static int ���� = 30 - ����[3] - ����[1] - ����[2] - ����[0];

    //    ʳ�ľ�ģ���������
    public static JButton toJP01 = new JButton("<-");

//    public int outwork = ����;


    public static Thread t����;
    public static Thread t�ɼ�;
    public int t����CD = 10, t�ɼ�CD = 10;
    public JLabel jl��������ʱ = new Jlab02("�´��ջ�" + t����CD + "��", Zhuangyuan.frameWidth / 2 + 70, Zhuangyuan.frameHeight / 4 - 100 + 130, 200, 170);
    public JLabel jl�ɼ�����ʱ = new Jlab02("CD��", 70 + 50, 250, 200, 170);
    JButton �ɼ� = new JButton("�ɼ�");
    public static int post[] = {0, 0, 0, 0, 0, 0};
    public static int x[] = {0, 0, 0, 0, 0, 0};
    //���  ľ��  �� ���� ʳ��  ʯͷ
    public JLabel JLʳ�� = new myJtext();
    public JLabel JLľ�� = new myJtext();
    public JLabel JL�� = new myJtext();
    public JLabel JL���� = new myJtext();


    public Jp02() {
        post[4] = ����[0];
        post[1] = ����[1];
        post[2] = ����[2];
        post[3] = ����[3];

        Zhuangyuan.jScrollPane.setVisible(true);
        jl��������ʱ.setForeground(Color.black);
        jl��������ʱ.setFont(new Font("΢���ź�", Font.PLAIN, 16));
        jl��������ʱ.setForeground(Color.white);
        jl�ɼ�����ʱ.setForeground(Color.black);
        jl�ɼ�����ʱ.setFont(new Font("΢���ź�", Font.PLAIN, 16));
        jl�ɼ�����ʱ.setForeground(Color.white);
        this.setBackground(Color.lightGray);
        this.setVisible(false);
        this.setLayout(null);
        this.setSize(Zhuangyuan.frameWidth, Zhuangyuan.frameHeight);

        toJP01.setFont(new Font("΢���ź�", Font.BOLD, 30));
        toJP01.setForeground(Color.white);
//         ����.setContentAreaFilled(false);//��������
        toJP01.setFocusPainted(false);//����ѡ��
        toJP01.setBackground(Color.darkGray);
        toJP01.setBorderPainted(false);
        toJP01.setBounds(5, 5, 70, 60);


        �ɼ�.setFont(new Font("΢���ź�", Font.BOLD, 30));
        �ɼ�.setForeground(Color.white);
//         ����.setContentAreaFilled(false);//��������
        �ɼ�.setFocusPainted(false);//����ѡ��
        �ɼ�.setBackground(Color.BLACK);
        �ɼ�.setBorderPainted(false);
        �ɼ�.setFont(new Font("΢���ź�", Font.BOLD, 40));
        �ɼ�.setBounds(70, 200, 150, 90);


        ����jl.setText("ʣ�๤����" + ����);
        ����jl.setBounds(70, 100, 200, 100);

        this.add(JLľ��);
        this.add(JLʳ��);
        this.add(JL��);
        this.add(JL����);


        this.add(�ɼ�);
        this.add(����jl);
        this.add(toJP01);

        this.add(jl�ɼ�����ʱ);
        this.add(jl��������ʱ);
        this.add(ľ��l);
        this.add(ľ��2);
        this.add(ʳ��1);
        this.add(ʳ��2);
        this.add(��1);
        this.add(��2);
        this.add(����1);
        this.add(����2);
        this.add(new Jlab02("�����", Zhuangyuan.frameWidth / 2 + 5, Zhuangyuan.frameHeight / 4 - 100, 100, 50));
        ʳ��1.setBounds(Zhuangyuan.frameWidth / 2 + 110, Zhuangyuan.frameHeight / 4 - 100, 50, 50);
        this.add(jl000 = new Jlab02(Jp02.����[0] + "", Zhuangyuan.frameWidth / 2 + 175, Zhuangyuan.frameHeight / 4 - 100, 50, 50));
        ʳ��2.setBounds(Zhuangyuan.frameWidth / 2 + 210, Zhuangyuan.frameHeight / 4 - 100, 50, 50);

        this.add(new Jlab02("��ľ��", Zhuangyuan.frameWidth / 2 + 5, Zhuangyuan.frameHeight / 4 - 100 + 50, 100, 50));
        ľ��l.setBounds(Zhuangyuan.frameWidth / 2 + 110, Zhuangyuan.frameHeight / 4 - 100 + 50, 50, 50);
        this.add(jl001 = new Jlab02(Jp02.����[1] + "", Zhuangyuan.frameWidth / 2 + 175, Zhuangyuan.frameHeight / 4 - 100 + 50, 50, 50));
        ľ��2.setBounds(Zhuangyuan.frameWidth / 2 + 210, Zhuangyuan.frameHeight / 4 - 100 + 50, 50, 50);

        this.add(new Jlab02("��", Zhuangyuan.frameWidth / 2 + 5, Zhuangyuan.frameHeight / 4 - 100 + 100, 100, 50));
        ��1.setBounds(Zhuangyuan.frameWidth / 2 + 110, Zhuangyuan.frameHeight / 4 - 100 + 100, 50, 50);
        this.add(jl002 = new Jlab02(Jp02.����[2] + "", Zhuangyuan.frameWidth / 2 + 175, Zhuangyuan.frameHeight / 4 - 100 + 100, 50, 50));
        ��2.setBounds(Zhuangyuan.frameWidth / 2 + 210, Zhuangyuan.frameHeight / 4 - 100 + 100, 50, 50);

        this.add(new Jlab02("������", Zhuangyuan.frameWidth / 2 + 5, Zhuangyuan.frameHeight / 4 - 100 + 150, 100, 50));
        ����1.setBounds(Zhuangyuan.frameWidth / 2 + 110, Zhuangyuan.frameHeight / 4 - 100 + 150, 50, 50);
        this.add(jl003 = new Jlab02(Jp02.����[3] + "", Zhuangyuan.frameWidth / 2 + 175, Zhuangyuan.frameHeight / 4 - 100 + 150, 50, 50));
        ����2.setBounds(Zhuangyuan.frameWidth / 2 + 210, Zhuangyuan.frameHeight / 4 - 100 + 150, 50, 50);

        JLabel JL�ϴ��ջ� = new myJtext();
        JL�ϴ��ջ�.setText("�ϴ��ջ�");
        JLʳ��.setText("ʳ� " + x[4]);
        JLľ��.setText("ľ�ģ� " + x[1]);
        JL��.setText("���� " + x[2]);
        JL����.setText("������ " + x[3]);
        this.add(JL�ϴ��ջ�);
        JL�ϴ��ջ�.setBounds(Zhuangyuan.frameWidth / 2 + 70, Zhuangyuan.frameHeight / 4 - 100 + 130 + 30, 200, 170);
        JLʳ��.setBounds(Zhuangyuan.frameWidth / 2 + 70, Zhuangyuan.frameHeight / 4 - 100 + 130 + 60, 200, 170);
        JLľ��.setBounds(Zhuangyuan.frameWidth / 2 + 70, Zhuangyuan.frameHeight / 4 - 100 + 130 + 90, 200, 170);
        JL��.setBounds(Zhuangyuan.frameWidth / 2 + 70, Zhuangyuan.frameHeight / 4 - 100 + 130 + 120, 200, 170);
        JL����.setBounds(Zhuangyuan.frameWidth / 2 + 70, Zhuangyuan.frameHeight / 4 - 100 + 130 + 150, 200, 170);

        ľ��l.addActionListener(this);
        ľ��2.addActionListener(this);
        ʳ��1.addActionListener(this);
        ʳ��2.addActionListener(this);
        ��1.addActionListener(this);
        ��2.addActionListener(this);
        ����1.addActionListener(this);
        ����2.addActionListener(this);
        �ɼ�.addActionListener(this);

        t���� = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    t����CD--;
                    jl��������ʱ.setText("�´��ջ�" + t����CD + "��");
                    if (t����CD <= 0) {

                        ������Դ();
                        t����CD = 3;
                    }
                }
            }
        });

        t�ɼ� = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (t�ɼ�CD > 0) {
                        t�ɼ�CD--;
                    } else {
                        jl�ɼ�����ʱ.setText("�ɲɼ�");
                    }
                }
            }
        });


        t�ɼ�.start();
        t����.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //post[]���  ľ��  �� ���� ʳ��  ʯͷ
        if (e.getSource() == �ɼ�) {
            Random rand = new Random();
            if (t�ɼ�CD <= 0) {
                int i1,i5;
                i1 = 100 + rand.nextInt(200);
                i5 = 50 + rand.nextInt(200);
                jl�ɼ�����ʱ.setText("CD��");
                Zhuangyuan.myjscPane.add(new Jlabeltool("�ռ���" + i1 + "ľ��"));
                Zhuangyuan.myjscPane.add(new Jlabeltool("�ռ���" + i5 + "ʯͷ"));
                Zhuangyuan.jtlist[1] += i1;
                Zhuangyuan.jtlist[5] += i5;
                Zhuangyuan.addlenth();
                Zhuangyuan.addlenth();
                t�ɼ�CD = 5;
            }
        } else if (e.getSource() == ʳ��1) {
//            System.out.println(����[0]);
            if (����[0] > 0) {
                ����++;
                ����[0]--;
            }
        } else if (e.getSource() == ľ��l) {
            if (����[1] > 0) {
                ����++;
                ����[1]--;
            }
        } else if (e.getSource() == ��1) {
            if (����[2] > 0) {
                ����++;
                ����[2]--;
            }
        } else if (e.getSource() == ����1) {
            if (����[3] > 0) {
                ����++;
                ����[3]--;
            }
        } else if (e.getSource() == ʳ��2) {
            if (���� > 0) {
                ����[0]++;
                ����--;
            }
        } else if (e.getSource() == ľ��2) {
            if (���� > 0) {
                ����[1]++;
                ����--;
            }
        } else if (e.getSource() == ��2) {
            if (���� > 0) {
                ����[2]++;
                ����--;
            }
        } else if (e.getSource() == ����2) {
            if (���� > 0) {
                ����[3]++;
                ����--;
            }
        }

        post[4] = ����[0];
        post[1] = ����[1];
        post[2] = ����[2];
        post[3] = ����[3];
//        System.out.println(����);
//        System.out.println(����[0] + ����[1] + ����[2] + ����[3]);
        jl000.setText(post[4] + "");
        jl001.setText(post[1] + "");
        jl002.setText(post[2] + "");
        jl003.setText(post[3] + "");


        ����jl.setText("ʣ�๤����" + ����);

    }

    public void ������Դ() {
        //���  ľ��  �� ���� ʳ��  ʯͷ
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
        JLʳ��.setText("ʳ� " + x[4]);
        JLľ��.setText("ľ�ģ� " + x[1]);
        JL��.setText("���� " + x[2]);
        JL����.setText("������ " + x[3]);
//        Zhuangyuan.myjscPane.add(new Jlabeltool("�����ջ�"+x[4]+"ʳ��"));
//        Zhuangyuan.myjscPane.add(new Jlabeltool("�����ջ�"+x[1]+"ľ��"));
//        Zhuangyuan.myjscPane.add(new Jlabeltool("�����ջ�"+x[2]+"��"));
//        Zhuangyuan.myjscPane.add(new Jlabeltool("�����ջ�"+x[3]+"����"));
        Zhuangyuan.jt1.setText("��ң� " + Zhuangyuan.jtlist[0]);
        Zhuangyuan.jt2.setText("ľ�ģ� " + Zhuangyuan.jtlist[1]);
        Zhuangyuan.jt3.setText("���� " + Zhuangyuan.jtlist[2]);
        Zhuangyuan.jt4.setText("������ " + Zhuangyuan.jtlist[3]);
        Zhuangyuan.jt5.setText("ʳ� " + Zhuangyuan.jtlist[4]);
        Zhuangyuan.jt6.setText("ʯͷ�� " + Zhuangyuan.jtlist[5]);
        Jpane����.��ӡð����();
    }
}
