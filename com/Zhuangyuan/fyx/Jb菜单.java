package com.Zhuangyuan.fyx;

import javax.swing.*;
import java.awt.*;

//
//                     ����.setBounds(30,50+30,121,75);
//                    ����.setBounds(30,130+30,121,75);
//                    �̵�.setBounds(30,210+30,121,75);
public class Jb�˵� extends JButton{
    Jb�˵�(String name){
        this.setText(name);
        this.setFont(new Font("΢���ź�", Font.BOLD, 16));
        this.setForeground(Color.white);
        this.setFocusPainted(false);//����ѡ��
        this.setBackground(Color.black);
        this.setBorderPainted(false);

    }
}

