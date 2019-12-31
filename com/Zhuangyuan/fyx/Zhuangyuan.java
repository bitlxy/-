package com.Zhuangyuan.fyx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class Zhuangyuan extends JFrame implements ActionListener {
    public static int 出现一次=0;
    public static int frameWidth = 600;
    public static int frameHeight = 800;

    public static Thread t炼金;
    public int 炼金cd = 0;
    JButton 炼金 = new JButton("炼金");
    JButton 建造 = new JButton("建造");
    JButton 商店 = new JButton("商店");
    JButton 制作 = new JButton("制作");
    JButton 训练 = new JButton("训练");
    JButton ToJP02 = new JButton("->");
    JButton ToJP03 = new JButton("<-");
    Container con = getContentPane();


    public static int[] jtlist = {9999 , 99999, 0, 0, 0, 99999};
    //金币  木材  铁 秘银 食物  石头
    //以下为建造功能、
    public static int number建造[] = {0, 0, 0, 0};
    // 0   民宅n，商店0-1，训练0-1；
    public static int cost民营[][] = {
            {10, 10}, {100, 50}, {300, 150}, {500, 300}, {750,400},{1000, 500}, {1200,700},{1500,1000},{2000,1500},{3000,2000},{4000,3000},{5000, 4000},{5000, 4000},{5000, 4000},{5000, 4000},{5000, 4000}, {10000, 50000}
            //木材，石头
    };

    public static int cost作坊训练营[][]={{},{},{50,100},{100,200}};

    //以下为商店功能
    public static int buy资源价格[] = {0, 20, 50, 100, 10, 10};
    // （金币）   木材 1 铁2 秘银3 食物 4 石头5   十个一组
    public static int buy一阶进阶材料价格[] = {0, 100, 100, 100, 200, 300, 500, 0};

    public static int shuliang一阶进阶材料[] = {0, 0, 0, 0, 0, 0, 0, 0};
    public static int shuliang二阶进阶材料 = 0;
    //牧师1，盗贼2，巫师3，战士4，弓箭手5，佣兵6，龙裔7,龙裔和雪人买不到；
    //以下为制作功能，训练功能
    public static int shuliang成品一阶材料[]={0, 0, 0, 0, 1, 1, 1, 1};
    public static int shuliang成品二阶材料=1;
    public static int shuliang冒险者[]={0,0,0,0,0,0,0,0,0};

    public  static JPanel jp01 = new JPanel();
    JPanel jp02 = new Jp02();
    public static JPanel jp建造=new Jpane建造();
    public static JPanel jp商店=new Jpane商店();
    public static JPanel jp制作=new Jpane制作();
    public static JPanel jp训练营=new JpaneXunlian();
    public static JPanel jp出征=new Jpane出征();

    public static JPanel myjscPane = new myJScrollPane();
    public static JScrollPane jScrollPane = new JScrollPane(myjscPane);
    public static JScrollBar jsbar=jScrollPane.getVerticalScrollBar();
    public static int jsbarValue=0;

    public static JLabel jt1 = new myJtext();
    public static JLabel jt2 = new myJtext();
    public static JLabel jt3 = new myJtext();
    public static JLabel jt4 = new myJtext();
    public static JLabel jt5 = new myJtext();
    public static JLabel 仓库 = new myJtext();
    public static JLabel jt6 = new myJtext();

//    public static ImageIcon BGbutton=new ImageIcon("picture/jb1.jpg");
    public static ImageIcon bgimage2=new ImageIcon("picture/bg2.jpg");
    public static ImageIcon bgimage = new ImageIcon("picture/bg1_副本.jpg");
    public static ImageIcon bgimage3=new ImageIcon("picture/bg3.jpg");
    public Zhuangyuan() {
        super("欢迎来到地下城堡");
        jp01.repaint();
        setVisible(true);
        setLayout(null);
        setBackground(Color.lightGray);

//        jp01.paint();
        jp01.setBounds(0,0,frameWidth, frameHeight);
        jp01.setBackground(Color.lightGray);
        jp01.setLayout(null);

//        ToJP02.setIcon(BGbutton);
        ToJP02.setFont(new Font("微软雅黑", Font.BOLD, 30));
        ToJP02.setForeground(Color.white);
//         炼金.setContentAreaFilled(false);//消除背景
        ToJP02.setFocusPainted(false);//消除选择
        ToJP02.setBackground(Color.darkGray);
        ToJP02.setBorderPainted(false);



        ToJP03.setFont(new Font("微软雅黑", Font.BOLD, 30));
        ToJP03.setForeground(Color.white);
//         炼金.setContentAreaFilled(false);//消除背景
        ToJP03.setFocusPainted(false);//消除选择
        ToJP03.setBackground(Color.darkGray);
        ToJP03.setBorderPainted(false);


//


        jScrollPane.setVisible(true);
        JLabel jltoolmen = new JLabel();
        jltoolmen.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        jltoolmen.setForeground(Color.white);
        jltoolmen.setText("鼠标滚轮以查看更多信息");
        myjscPane.add(jltoolmen);

        jScrollPane.setBounds(0, 510, Zhuangyuan.frameWidth, Zhuangyuan.frameHeight - 550);
        con.add(jScrollPane);


        仓库.setText("仓库");
        仓库.setFont(new Font("微软雅黑", Font.BOLD, 32));
        JLabel jt分割线 = new JLabel("---------------------------");
        jt分割线.setFont(new Font("微软雅黑", Font.PLAIN, 32));
        jt1.setText("金币： " + jtlist[0]);
        jt2.setText("木材： " + jtlist[1]);
        jt3.setText("铁： " + jtlist[2]);
        jt4.setText("秘银： " + jtlist[3]);
        jt5.setText("食物： " + jtlist[4]);
        jt6.setText("石头： " + jtlist[5]);

        炼金.setFont(new Font("微软雅黑", Font.BOLD, 30));
        炼金.setForeground(Color.white);
//         炼金.setContentAreaFilled(false);//消除背景
        炼金.setFocusPainted(false);//消除选择
        炼金.setBackground(Color.BLACK);
        炼金.setBorderPainted(false);

        建造.setFont(new Font("微软雅黑", Font.BOLD, 30));
        建造.setForeground(Color.white);
//        建造.setContentAreaFilled(false);//消除背景
        建造.setFocusPainted(false);//消除选择
        建造.setBackground(Color.BLACK);
        建造.setBorderPainted(false);

        商店.setFont(new Font("微软雅黑", Font.BOLD, 30));
        商店.setForeground(Color.white);
//        商店.setContentAreaFilled(false);//消除背景
        商店.setFocusPainted(false);//消除选择
        商店.setBackground(Color.BLACK);
        商店.setBorderPainted(false);

        训练.setFont(new Font("微软雅黑", Font.BOLD, 30));
        训练.setForeground(Color.white);
//        训练.setContentAreaFilled(false);//消除背景
        训练.setFocusPainted(false);//消除选择
        训练.setBackground(Color.BLACK);
        训练.setBorderPainted(false);

        制作.setFont(new Font("微软雅黑", Font.BOLD, 30));
        制作.setForeground(Color.white);
//        制作.setContentAreaFilled(false);//消除背景
        制作.setFocusPainted(false);//消除选择
        制作.setBackground(Color.BLACK);
        制作.setBorderPainted(false);


        炼金.setBounds(30, 50 + 30, 121, 75);
        建造.setBounds(30, 130 + 30, 121, 75);
        商店.setBounds(30, 210 + 30, 121, 75);
        训练.setBounds(30, 370 + 30, 121, 75);
        制作.setBounds(30, 290 + 30, 121, 75);
        ToJP02.setBounds(frameWidth - 95, 5, 70, 60);
        ToJP03.setBounds(5, 5, 70, 60);
        jt分割线.setBounds(frameWidth / 2, 50 + 60, frameWidth / 2, 20);
        jt5.setBounds(frameWidth / 2 + 175, 100 + 60, frameWidth / 2, 30);
        jt1.setBounds(frameWidth / 2 + 175, 70 + 60, frameWidth / 2, 30);
        jt6.setBounds(frameWidth / 2 + 175, 130 + 60, frameWidth / 2, 30);
        jt2.setBounds(frameWidth / 2 + 175, 160 + 60, frameWidth / 2, 30);
        jt3.setBounds(frameWidth / 2 + 175, 190 + 60, frameWidth / 2, 30);
        jt4.setBounds(frameWidth / 2 + 175, 220 + 60, frameWidth / 2, 30);
        仓库.setBounds(frameWidth / 2 + 175, 40 + 30, frameWidth / 2, 50);

        炼金.addActionListener(this);
        ToJP03.addActionListener(this);
        ToJP02.addActionListener(this);
        Jp02.toJP01.addActionListener(this);
        Jpane建造.toJP01.addActionListener(this);
        Jpane商店.toJP01.addActionListener(this);
        JpaneXunlian.toJP01.addActionListener(this);
        Jpane制作.toJP01.addActionListener(this);
        Jpane出征.toJP01.addActionListener(this);
        建造.addActionListener(this);
        商店.addActionListener(this);
        训练.addActionListener(this);
        制作.addActionListener(this);


        jp01.add(jt1);
        jp01.add(ToJP02);
        jp01.add(ToJP03);
        jp01.add(jt2);
        jp01.add(jt3);
        jp01.add(jt4);
        jp01.add(jt5);
        jp01.add(jt6);
        jp01.add(jt分割线);
        jp01.add(仓库);
        jp01.add(炼金);
        jp01.add(制作);
        jp01.add(商店);
        jp01.add(训练);
        jp01.add(建造);

        jp01.setVisible(true);
        con.add(jp01);
        con.add(jp02);
        con.add(jp建造);
        con.add(jp训练营);
        con.add(jp制作);
        con.add(jp商店);
        con.add(jp出征);


        t炼金 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (炼金cd == 1) {
                        Random rand = new Random();
                        int rand金币=3+rand.nextInt(5);
                        jtlist[0]+=rand金币;
                        myjscPane.add(new Jlabeltool("金币+"+rand金币));
                        jt1.setText("金币： " + jtlist[0]);
                        Zhuangyuan.addlenth();
                        炼金cd = 0;
                    }
                }
            }
        });
        t炼金.start();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();


        setBounds((int) (screenSize.getWidth() - frameWidth) / 2, 0, frameWidth, frameHeight);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//        jp01.repaint();
        creatBackground();


    }


    public void creatBackground(){
        ImageIcon lb1_image1=new ImageIcon("picture/lb1.jpg");
        ImageIcon lb2_image1=new ImageIcon("picture/lb2.jpg");
        ImageIcon lb3_image1=new ImageIcon("picture/lb3.jpg");
        JLabel lb1=new JLabel(lb1_image1);
        JLabel lb2=new JLabel(lb2_image1);
        JLabel lb3=new JLabel(lb3_image1);
        jp01.add(lb1,new Integer(Integer.MIN_VALUE));
        jp02.add(lb2,new Integer(Integer.MIN_VALUE));
        jp出征.add(lb3,new Integer(Integer.MIN_VALUE));
        lb1.setBounds(frameWidth/2-100,-15,lb1_image1.getIconWidth(),lb1_image1.getIconHeight());
        lb2.setBounds(frameWidth/2-105,-10,lb2_image1.getIconWidth(),lb2_image1.getIconHeight());
        lb3.setBounds(frameWidth/2-105,5,lb3_image1.getIconWidth(),lb3_image1.getIconHeight());

        JLabel bglabel=new JLabel(bgimage);
        jp01.add(bglabel,new Integer(Integer.MIN_VALUE));
        bglabel.setBounds(0,-20,bgimage.getIconWidth(),bgimage.getIconHeight());
//        lb1.setBounds(frameWidth/2-105,5,lb1_image1.getIconWidth(),lb1_image1.getIconHeight());
        jp01.setOpaque(true);

        JLabel bg2=new JLabel(bgimage2);
        jp02.add(bg2,new  Integer(Integer.MIN_VALUE));
        bg2.setBounds(0,-1,bgimage.getIconWidth(),bgimage.getIconHeight());
        jp02.setOpaque(true);
        JLabel bg3=new JLabel(bgimage3);
        jp出征.add(bg3,new  Integer(Integer.MIN_VALUE));
        bg3.setBounds(0,-40,bgimage.getIconWidth(),bgimage.getIconHeight());
        jp出征.setOpaque(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == 炼金) {
            炼金cd = 1;
        }
       else if (e.getSource() == ToJP02) {

           if(出现一次==0)
           {   Zhuangyuan.myjscPane.add(new Jlabeltool("这里是工匠工作的地方"));
            addlenth();
            Zhuangyuan.myjscPane.add(new Jlabeltool("你可以安排他们的工作"));
            addlenth();
            Zhuangyuan.myjscPane.add(new Jlabeltool("伐木工工作消耗一个食物"));
            addlenth();
            Zhuangyuan.myjscPane.add(new Jlabeltool("铁匠消耗两个，而秘银匠消耗五个"));
            addlenth();
            出现一次=1;
           }

            jp02.setVisible(true);
            jp01.setVisible(false);
        }
       else if(e.getSource()==ToJP03){
           Jpane出征.更新食物();
           jp出征.setVisible(true);
           jp01.setVisible(false);
        }
       else if(e.getSource()==建造){
           jp建造.setVisible(true);
            jp01.setVisible(false);
        }
        else if(e.getSource()==制作){
            jp制作.setVisible(true);
            jp01.setVisible(false);
            myjscPane.add(new Jlabeltool("当前拥有："));
            addlenth();
            for(int i=1;i<=6;i++)
            {
                addlenth();
                myjscPane.add(new Jlabeltool(Jpane商店.name进阶材料[i]+":"+shuliang一阶进阶材料[i]+"  "+Jpane制作.name一级[i]+":"+Zhuangyuan.shuliang成品一阶材料[i]));
            }
//            myjscPane.add(new Jlabeltool(Jpane商店.name二阶进阶材料+":"+shuliang二阶进阶材料));
        }
       else if(e.getSource()==商店){
           if(number建造[2]>=1){
               jp商店.setVisible(true);
               jp01.setVisible(false);
           }
           else{
               myjscPane.add(new Jlabeltool("城堡里还没有商店"));
               addlenth();
           }
        }
        else if(e.getSource()==训练){
            if(number建造[3]>=1){
                jp训练营.setVisible(true);
                jp01.setVisible(false);
            }
            else{
                myjscPane.add(new Jlabeltool("城堡里还没有训练营"));
                addlenth();
            }
        }
        else if (e.getSource() == Jp02.toJP01||e.getSource()==Jpane建造.toJP01||e.getSource()==Jpane商店.toJP01||e.getSource()== JpaneXunlian.toJP01||e.getSource()==Jpane制作.toJP01||e.getSource()==Jpane出征.toJP01) {
            jt1.setText("金币： " + jtlist[0]);
            jt2.setText("木材： " + jtlist[1]);
            jt3.setText("铁： " + jtlist[2]);
            jt4.setText("秘银： " + jtlist[3]);
            jt5.setText("食物： " + jtlist[4]);
            jt6.setText("石头： " + jtlist[5]);
            jp建造.setVisible(false);
            jp制作.setVisible(false);
            jp商店.setVisible(false);
            jp训练营.setVisible(false);
            jp出征.setVisible(false);
            jp02.setVisible(false);
            jp01.setVisible(true);
        }


    }
    public static void addlenth(){
        Zhuangyuan.jsbar.setValue(Zhuangyuan.jsbarValue);
        Zhuangyuan.jsbarValue+=32;
    }

}
