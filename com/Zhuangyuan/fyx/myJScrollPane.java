package com.Zhuangyuan.fyx;


import java.awt.*;
import java.security.PrivateKey;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class myJScrollPane extends JPanel {


    public static int len = 1;
    public myJScrollPane() {
        this.add(new Jlabeltool("�������˵��³Ǳ�"));
        this.add(new Jlabeltool("���������Ӵ��������"));
        this.add(new Jlabeltool("����ٷϴ��ˣ������ǵ������ָ��"));
        this.add(new Jlabeltool("�̵���������Դ�͸�������ѫ��"));
        this.add(new Jlabeltool("���ð������ѵ��Ӫ��ȴ�����"));
        this.setVisible(true);
        this.setLayout(new GridLayout(999999,1, 5, 10));
        this.setBackground(Color.darkGray);
//        for (int i = 0; i < 100; i++) {
//            this.add(new JLabel("laaaaaaaa\n"));
//        }
//        this.setBounds(0, 500, 100, 0);

    }


}


