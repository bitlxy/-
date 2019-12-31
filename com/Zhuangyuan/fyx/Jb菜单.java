package com.Zhuangyuan.fyx;

import javax.swing.*;
import java.awt.*;

//
//                     炼金.setBounds(30,50+30,121,75);
//                    建造.setBounds(30,130+30,121,75);
//                    商店.setBounds(30,210+30,121,75);
public class Jb菜单 extends JButton{
    Jb菜单(String name){
        this.setText(name);
        this.setFont(new Font("微软雅黑", Font.BOLD, 16));
        this.setForeground(Color.white);
        this.setFocusPainted(false);//消除选择
        this.setBackground(Color.black);
        this.setBorderPainted(false);

    }
}

