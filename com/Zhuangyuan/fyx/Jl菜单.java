package com.Zhuangyuan.fyx;

import javax.swing.*;
import java.awt.*;

public class Jl�˵� extends JLabel {
    Jl�˵�(String Text,int x,int y,int width,int high){
        this.setBounds(x,y,width,high);
        this.setText(Text);
        this.setFont(new Font("΢���ź�", Font.PLAIN, 16));
        this.setForeground(Color.white);
        this.setBackground(Color.WHITE);
    }
}
