package com.Zhuangyuan.fyx;


import java.awt.*;
import java.security.PrivateKey;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class myJScrollPane extends JPanel {


    public static int len = 1;
    public myJScrollPane() {
        this.add(new Jlabeltool("你来到了地下城堡"));
        this.add(new Jlabeltool("这里有着庞大的炼金阵"));
        this.add(new Jlabeltool("这里百废待兴，工人们等着你的指挥"));
        this.add(new Jlabeltool("商店里售卖资源和各种勇者勋章"));
        this.add(new Jlabeltool("你的冒险者在训练营里等待命令"));
        this.setVisible(true);
        this.setLayout(new GridLayout(999999,1, 5, 10));
        this.setBackground(Color.darkGray);
//        for (int i = 0; i < 100; i++) {
//            this.add(new JLabel("laaaaaaaa\n"));
//        }
//        this.setBounds(0, 500, 100, 0);

    }


}


