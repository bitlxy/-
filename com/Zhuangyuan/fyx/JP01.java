package com.Zhuangyuan.fyx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JP01 extends JPanel  {
    private Image bgimg=(new ImageIcon("src/Mybg.jpg")).getImage();
    JP01(){

    }
     public void paint(Graphics g){
        super.paint(g);
        g.drawImage(bgimg,0,0,Zhuangyuan.frameWidth,Zhuangyuan.frameHeight,null);

    }

}
