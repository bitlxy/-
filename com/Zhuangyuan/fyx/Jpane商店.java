package com.Zhuangyuan.fyx;

import kotlin.Lazy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Jpane�̵� extends JPanel implements ActionListener {
    public static String name���ײ���[] = {"", "����֮��", "̰��֮��", "ѧ��֮��", "����֮��", "����֮��", "��Լ֮��", "��֮��"};
    public static String name���׽��ײ��� = "����ѩ��";
    public static int buy���ײ��ϼ۸�[] = {0, 50, 100, 150, 200, 300, 500, 0};
    public static JButton toJP01 = new JButton("<-");
    public static JButton jb1 = new Jb�˵�("ľ��x10");
    public static JButton jb2 = new Jb�˵�("��x10");
    public static JButton jb3 = new Jb�˵�("����x10");
    public static JButton jb4 = new Jb�˵�("ʳ��x10");
    public static JButton jb5 = new Jb�˵�("ʯͷx10");
    public static JButton jbb1 = new Jb�˵�(name���ײ���[1]);
    public static JButton jbb2 = new Jb�˵�(name���ײ���[2]);
    public static JButton jbb3 = new Jb�˵�(name���ײ���[3]);
    public static JButton jbb4 = new Jb�˵�(name���ײ���[4]);
    public static JButton jbb5 = new Jb�˵�(name���ײ���[5]);
    public static JButton jbb6 = new Jb�˵�(name���ײ���[6]);


    Jpane�̵�() {
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

        ��ӡ��Ϣ();
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

    //public static int buy��Դ�۸�[] = {0, 20, 30, 100, 10, 10};
//// ����ң�   ľ�� 1 ��2 ����3 ʳ�� 4 ʯͷ5   ʮ��һ��
//    public static int[] jtlist = {100, 100, 100, 0, 100, 10};
//                              ���  ľ��  �� ���� ʳ��  ʯͷ
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb1) {
            if (Zhuangyuan.jtlist[0] < Zhuangyuan.buy��Դ�۸�[1]) {
                Zhuangyuan.myjscPane.add(new Jlabeltool("Ǯ����"));
                Zhuangyuan.addlenth();
            } else {
                Zhuangyuan.jtlist[0] -= Zhuangyuan.buy��Դ�۸�[1];
                Zhuangyuan.jtlist[1]+=10;
                Zhuangyuan.myjscPane.add(new Jlabeltool("����ɹ�����ǰ���" + Zhuangyuan.jtlist[1]));
                Zhuangyuan.addlenth();
            }
        }
        else if (e.getSource() == jb2) {
            if (Zhuangyuan.jtlist[0] < Zhuangyuan.buy��Դ�۸�[2]) {
                Zhuangyuan.myjscPane.add(new Jlabeltool("Ǯ����"));
                Zhuangyuan.addlenth();
            } else {
                Zhuangyuan.jtlist[0] -= Zhuangyuan.buy��Դ�۸�[2];Zhuangyuan.jtlist[2]+=10;
                Zhuangyuan.myjscPane.add(new Jlabeltool("����ɹ�����ǰ���" + Zhuangyuan.jtlist[2]));
                Zhuangyuan.addlenth();
            }
        }
       else  if (e.getSource() == jb3) {
            if (Zhuangyuan.jtlist[0] < Zhuangyuan.buy��Դ�۸�[3]) {
                Zhuangyuan.myjscPane.add(new Jlabeltool("Ǯ����"));
                Zhuangyuan.addlenth();
            } else {
                Zhuangyuan.jtlist[0] -= Zhuangyuan.buy��Դ�۸�[3];Zhuangyuan.jtlist[3]+=10;
                Zhuangyuan.myjscPane.add(new Jlabeltool("����ɹ�����ǰ���" + Zhuangyuan.jtlist[3]));
                Zhuangyuan.addlenth();
            }
        }
        else if (e.getSource() == jb4) {
            if (Zhuangyuan.jtlist[0] < Zhuangyuan.buy��Դ�۸�[4]) {
                Zhuangyuan.myjscPane.add(new Jlabeltool("Ǯ����"));
                Zhuangyuan.addlenth();
            } else {
                Zhuangyuan.jtlist[0] -= Zhuangyuan.buy��Դ�۸�[4];Zhuangyuan.jtlist[4]+=10;
                Zhuangyuan.myjscPane.add(new Jlabeltool("����ɹ�����ǰ���" + Zhuangyuan.jtlist[4]));
                Zhuangyuan.addlenth();
            }
        }
       else  if (e.getSource() == jb5) {
            if (Zhuangyuan.jtlist[0] < Zhuangyuan.buy��Դ�۸�[5]) {
                Zhuangyuan.myjscPane.add(new Jlabeltool("Ǯ����"));
                Zhuangyuan.addlenth();
            } else {
                Zhuangyuan.jtlist[0] -= Zhuangyuan.buy��Դ�۸�[5];Zhuangyuan.jtlist[5]+=10;
                Zhuangyuan.myjscPane.add(new Jlabeltool("����ɹ�����ǰ���" + Zhuangyuan.jtlist[5]));
                Zhuangyuan.addlenth();
            }
        }
        else  if (e.getSource() == jbb1) {
            if (Zhuangyuan.jtlist[0] < buy���ײ��ϼ۸�[1]) {
                Zhuangyuan.myjscPane.add(new Jlabeltool("Ǯ����"));
                Zhuangyuan.addlenth();
            } else {
                Zhuangyuan.jtlist[0] -= buy���ײ��ϼ۸�[1];Zhuangyuan.shuliangһ�׽��ײ���[1]++;
                Zhuangyuan.myjscPane.add(new Jlabeltool("��ʦ��ѫ�£���ӵ�У�" + Zhuangyuan.shuliangһ�׽��ײ���[1]));
                Zhuangyuan.addlenth();
            }
        }
        else  if (e.getSource() == jbb2) {
            if (Zhuangyuan.jtlist[0] < buy���ײ��ϼ۸�[2]) {
                Zhuangyuan.myjscPane.add(new Jlabeltool("Ǯ����"));
                Zhuangyuan.addlenth();
            } else {
                Zhuangyuan.jtlist[0] -= buy���ײ��ϼ۸�[2];Zhuangyuan.shuliangһ�׽��ײ���[2]++;
                Zhuangyuan.myjscPane.add(new Jlabeltool("����֤֮����ӵ�У�" + Zhuangyuan.shuliangһ�׽��ײ���[2]));
                Zhuangyuan.addlenth();
            }
        }
        else  if (e.getSource() == jbb3) {
            if (Zhuangyuan.jtlist[0] < buy���ײ��ϼ۸�[3]) {
                Zhuangyuan.myjscPane.add(new Jlabeltool("Ǯ����"));
                Zhuangyuan.addlenth();
            } else {
                Zhuangyuan.jtlist[0] -= buy���ײ��ϼ۸�[3];Zhuangyuan.shuliangһ�׽��ײ���[3]++;
                Zhuangyuan.myjscPane.add(new Jlabeltool("��ʦ��ѫ�£���ӵ�У�" + Zhuangyuan.shuliangһ�׽��ײ���[3]));
                Zhuangyuan.addlenth();
            }
        }
        else  if (e.getSource() == jbb4) {
            if (Zhuangyuan.jtlist[0] < buy���ײ��ϼ۸�[4]) {
                Zhuangyuan.myjscPane.add(new Jlabeltool("Ǯ����"));
                Zhuangyuan.addlenth();
            } else {
                Zhuangyuan.jtlist[0] -= buy���ײ��ϼ۸�[4];Zhuangyuan.shuliangһ�׽��ײ���[4]++;
                Zhuangyuan.myjscPane.add(new Jlabeltool("սʿ��ѫ�£���ӵ�У�" + Zhuangyuan.shuliangһ�׽��ײ���[4]));
                Zhuangyuan.addlenth();
            }
        }
        else  if (e.getSource() == jbb5) {
            if (Zhuangyuan.jtlist[0] < buy���ײ��ϼ۸�[5]) {
                Zhuangyuan.myjscPane.add(new Jlabeltool("Ǯ����"));
                Zhuangyuan.addlenth();
            } else {
                Zhuangyuan.jtlist[0] -= buy���ײ��ϼ۸�[5];Zhuangyuan.shuliangһ�׽��ײ���[5]++;
                Zhuangyuan.myjscPane.add(new Jlabeltool("�����ֵ�ѫ�£���ӵ�У�" + Zhuangyuan.shuliangһ�׽��ײ���[5]));
                Zhuangyuan.addlenth();
            }
        }
        else  if (e.getSource() == jbb6) {
            if (Zhuangyuan.jtlist[0] < buy���ײ��ϼ۸�[6]) {
                Zhuangyuan.myjscPane.add(new Jlabeltool("Ǯ����"));
                Zhuangyuan.addlenth();
            } else {
                Zhuangyuan.jtlist[0] -= buy���ײ��ϼ۸�[6];Zhuangyuan.shuliangһ�׽��ײ���[6]++;
                Zhuangyuan.myjscPane.add(new Jlabeltool("Ӷ����ѫ�£���ӵ�У�" + Zhuangyuan.shuliangһ�׽��ײ���[6]));
                Zhuangyuan.addlenth();
            }
        }
        else{
            return;
        }



    }

    public void ��ӡ��Ϣ() {
        int i;
        for (i = 1; i <= 5; i++) {
            this.add(new Jl�˵�("�۸�:" + Zhuangyuan.buy��Դ�۸�[i], 180, 70 + 45 * (i - 1), 500, 44));
        }
        for (i = 1; i <= 6; i++) {
            this.add(new Jl�˵�("�۸�:" + buy���ײ��ϼ۸�[i], Zhuangyuan.frameWidth / 2 + 120, 70 + 45 * (i - 1), 500, 44));
        }
    }
}
