package com.Zhuangyuan.fyx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class Zhuangyuan extends JFrame implements ActionListener {
    public static int ����һ��=0;
    public static int frameWidth = 600;
    public static int frameHeight = 800;

    public static Thread t����;
    public int ����cd = 0;
    JButton ���� = new JButton("����");
    JButton ���� = new JButton("����");
    JButton �̵� = new JButton("�̵�");
    JButton ���� = new JButton("����");
    JButton ѵ�� = new JButton("ѵ��");
    JButton ToJP02 = new JButton("->");
    JButton ToJP03 = new JButton("<-");
    Container con = getContentPane();


    public static int[] jtlist = {9999 , 99999, 0, 0, 0, 99999};
    //���  ľ��  �� ���� ʳ��  ʯͷ
    //����Ϊ���칦�ܡ�
    public static int number����[] = {0, 0, 0, 0};
    // 0   ��լn���̵�0-1��ѵ��0-1��
    public static int cost��Ӫ[][] = {
            {10, 10}, {100, 50}, {300, 150}, {500, 300}, {750,400},{1000, 500}, {1200,700},{1500,1000},{2000,1500},{3000,2000},{4000,3000},{5000, 4000},{5000, 4000},{5000, 4000},{5000, 4000},{5000, 4000}, {10000, 50000}
            //ľ�ģ�ʯͷ
    };

    public static int cost����ѵ��Ӫ[][]={{},{},{50,100},{100,200}};

    //����Ϊ�̵깦��
    public static int buy��Դ�۸�[] = {0, 20, 50, 100, 10, 10};
    // ����ң�   ľ�� 1 ��2 ����3 ʳ�� 4 ʯͷ5   ʮ��һ��
    public static int buyһ�׽��ײ��ϼ۸�[] = {0, 100, 100, 100, 200, 300, 500, 0};

    public static int shuliangһ�׽��ײ���[] = {0, 0, 0, 0, 0, 0, 0, 0};
    public static int shuliang���׽��ײ��� = 0;
    //��ʦ1������2����ʦ3��սʿ4��������5��Ӷ��6������7,�����ѩ���򲻵���
    //����Ϊ�������ܣ�ѵ������
    public static int shuliang��Ʒһ�ײ���[]={0, 0, 0, 0, 1, 1, 1, 1};
    public static int shuliang��Ʒ���ײ���=1;
    public static int shuliangð����[]={0,0,0,0,0,0,0,0,0};

    public  static JPanel jp01 = new JPanel();
    JPanel jp02 = new Jp02();
    public static JPanel jp����=new Jpane����();
    public static JPanel jp�̵�=new Jpane�̵�();
    public static JPanel jp����=new Jpane����();
    public static JPanel jpѵ��Ӫ=new JpaneXunlian();
    public static JPanel jp����=new Jpane����();

    public static JPanel myjscPane = new myJScrollPane();
    public static JScrollPane jScrollPane = new JScrollPane(myjscPane);
    public static JScrollBar jsbar=jScrollPane.getVerticalScrollBar();
    public static int jsbarValue=0;

    public static JLabel jt1 = new myJtext();
    public static JLabel jt2 = new myJtext();
    public static JLabel jt3 = new myJtext();
    public static JLabel jt4 = new myJtext();
    public static JLabel jt5 = new myJtext();
    public static JLabel �ֿ� = new myJtext();
    public static JLabel jt6 = new myJtext();

//    public static ImageIcon BGbutton=new ImageIcon("picture/jb1.jpg");
    public static ImageIcon bgimage2=new ImageIcon("picture/bg2.jpg");
    public static ImageIcon bgimage = new ImageIcon("picture/bg1_����.jpg");
    public static ImageIcon bgimage3=new ImageIcon("picture/bg3.jpg");
    public Zhuangyuan() {
        super("��ӭ�������³Ǳ�");
        jp01.repaint();
        setVisible(true);
        setLayout(null);
        setBackground(Color.lightGray);

//        jp01.paint();
        jp01.setBounds(0,0,frameWidth, frameHeight);
        jp01.setBackground(Color.lightGray);
        jp01.setLayout(null);

//        ToJP02.setIcon(BGbutton);
        ToJP02.setFont(new Font("΢���ź�", Font.BOLD, 30));
        ToJP02.setForeground(Color.white);
//         ����.setContentAreaFilled(false);//��������
        ToJP02.setFocusPainted(false);//����ѡ��
        ToJP02.setBackground(Color.darkGray);
        ToJP02.setBorderPainted(false);



        ToJP03.setFont(new Font("΢���ź�", Font.BOLD, 30));
        ToJP03.setForeground(Color.white);
//         ����.setContentAreaFilled(false);//��������
        ToJP03.setFocusPainted(false);//����ѡ��
        ToJP03.setBackground(Color.darkGray);
        ToJP03.setBorderPainted(false);


//


        jScrollPane.setVisible(true);
        JLabel jltoolmen = new JLabel();
        jltoolmen.setFont(new Font("΢���ź�", Font.PLAIN, 16));
        jltoolmen.setForeground(Color.white);
        jltoolmen.setText("�������Բ鿴������Ϣ");
        myjscPane.add(jltoolmen);

        jScrollPane.setBounds(0, 510, Zhuangyuan.frameWidth, Zhuangyuan.frameHeight - 550);
        con.add(jScrollPane);


        �ֿ�.setText("�ֿ�");
        �ֿ�.setFont(new Font("΢���ź�", Font.BOLD, 32));
        JLabel jt�ָ��� = new JLabel("---------------------------");
        jt�ָ���.setFont(new Font("΢���ź�", Font.PLAIN, 32));
        jt1.setText("��ң� " + jtlist[0]);
        jt2.setText("ľ�ģ� " + jtlist[1]);
        jt3.setText("���� " + jtlist[2]);
        jt4.setText("������ " + jtlist[3]);
        jt5.setText("ʳ� " + jtlist[4]);
        jt6.setText("ʯͷ�� " + jtlist[5]);

        ����.setFont(new Font("΢���ź�", Font.BOLD, 30));
        ����.setForeground(Color.white);
//         ����.setContentAreaFilled(false);//��������
        ����.setFocusPainted(false);//����ѡ��
        ����.setBackground(Color.BLACK);
        ����.setBorderPainted(false);

        ����.setFont(new Font("΢���ź�", Font.BOLD, 30));
        ����.setForeground(Color.white);
//        ����.setContentAreaFilled(false);//��������
        ����.setFocusPainted(false);//����ѡ��
        ����.setBackground(Color.BLACK);
        ����.setBorderPainted(false);

        �̵�.setFont(new Font("΢���ź�", Font.BOLD, 30));
        �̵�.setForeground(Color.white);
//        �̵�.setContentAreaFilled(false);//��������
        �̵�.setFocusPainted(false);//����ѡ��
        �̵�.setBackground(Color.BLACK);
        �̵�.setBorderPainted(false);

        ѵ��.setFont(new Font("΢���ź�", Font.BOLD, 30));
        ѵ��.setForeground(Color.white);
//        ѵ��.setContentAreaFilled(false);//��������
        ѵ��.setFocusPainted(false);//����ѡ��
        ѵ��.setBackground(Color.BLACK);
        ѵ��.setBorderPainted(false);

        ����.setFont(new Font("΢���ź�", Font.BOLD, 30));
        ����.setForeground(Color.white);
//        ����.setContentAreaFilled(false);//��������
        ����.setFocusPainted(false);//����ѡ��
        ����.setBackground(Color.BLACK);
        ����.setBorderPainted(false);


        ����.setBounds(30, 50 + 30, 121, 75);
        ����.setBounds(30, 130 + 30, 121, 75);
        �̵�.setBounds(30, 210 + 30, 121, 75);
        ѵ��.setBounds(30, 370 + 30, 121, 75);
        ����.setBounds(30, 290 + 30, 121, 75);
        ToJP02.setBounds(frameWidth - 95, 5, 70, 60);
        ToJP03.setBounds(5, 5, 70, 60);
        jt�ָ���.setBounds(frameWidth / 2, 50 + 60, frameWidth / 2, 20);
        jt5.setBounds(frameWidth / 2 + 175, 100 + 60, frameWidth / 2, 30);
        jt1.setBounds(frameWidth / 2 + 175, 70 + 60, frameWidth / 2, 30);
        jt6.setBounds(frameWidth / 2 + 175, 130 + 60, frameWidth / 2, 30);
        jt2.setBounds(frameWidth / 2 + 175, 160 + 60, frameWidth / 2, 30);
        jt3.setBounds(frameWidth / 2 + 175, 190 + 60, frameWidth / 2, 30);
        jt4.setBounds(frameWidth / 2 + 175, 220 + 60, frameWidth / 2, 30);
        �ֿ�.setBounds(frameWidth / 2 + 175, 40 + 30, frameWidth / 2, 50);

        ����.addActionListener(this);
        ToJP03.addActionListener(this);
        ToJP02.addActionListener(this);
        Jp02.toJP01.addActionListener(this);
        Jpane����.toJP01.addActionListener(this);
        Jpane�̵�.toJP01.addActionListener(this);
        JpaneXunlian.toJP01.addActionListener(this);
        Jpane����.toJP01.addActionListener(this);
        Jpane����.toJP01.addActionListener(this);
        ����.addActionListener(this);
        �̵�.addActionListener(this);
        ѵ��.addActionListener(this);
        ����.addActionListener(this);


        jp01.add(jt1);
        jp01.add(ToJP02);
        jp01.add(ToJP03);
        jp01.add(jt2);
        jp01.add(jt3);
        jp01.add(jt4);
        jp01.add(jt5);
        jp01.add(jt6);
        jp01.add(jt�ָ���);
        jp01.add(�ֿ�);
        jp01.add(����);
        jp01.add(����);
        jp01.add(�̵�);
        jp01.add(ѵ��);
        jp01.add(����);

        jp01.setVisible(true);
        con.add(jp01);
        con.add(jp02);
        con.add(jp����);
        con.add(jpѵ��Ӫ);
        con.add(jp����);
        con.add(jp�̵�);
        con.add(jp����);


        t���� = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (����cd == 1) {
                        Random rand = new Random();
                        int rand���=3+rand.nextInt(5);
                        jtlist[0]+=rand���;
                        myjscPane.add(new Jlabeltool("���+"+rand���));
                        jt1.setText("��ң� " + jtlist[0]);
                        Zhuangyuan.addlenth();
                        ����cd = 0;
                    }
                }
            }
        });
        t����.start();

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
        jp����.add(lb3,new Integer(Integer.MIN_VALUE));
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
        jp����.add(bg3,new  Integer(Integer.MIN_VALUE));
        bg3.setBounds(0,-40,bgimage.getIconWidth(),bgimage.getIconHeight());
        jp����.setOpaque(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ����) {
            ����cd = 1;
        }
       else if (e.getSource() == ToJP02) {

           if(����һ��==0)
           {   Zhuangyuan.myjscPane.add(new Jlabeltool("�����ǹ��������ĵط�"));
            addlenth();
            Zhuangyuan.myjscPane.add(new Jlabeltool("����԰������ǵĹ���"));
            addlenth();
            Zhuangyuan.myjscPane.add(new Jlabeltool("��ľ����������һ��ʳ��"));
            addlenth();
            Zhuangyuan.myjscPane.add(new Jlabeltool("�����������������������������"));
            addlenth();
            ����һ��=1;
           }

            jp02.setVisible(true);
            jp01.setVisible(false);
        }
       else if(e.getSource()==ToJP03){
           Jpane����.����ʳ��();
           jp����.setVisible(true);
           jp01.setVisible(false);
        }
       else if(e.getSource()==����){
           jp����.setVisible(true);
            jp01.setVisible(false);
        }
        else if(e.getSource()==����){
            jp����.setVisible(true);
            jp01.setVisible(false);
            myjscPane.add(new Jlabeltool("��ǰӵ�У�"));
            addlenth();
            for(int i=1;i<=6;i++)
            {
                addlenth();
                myjscPane.add(new Jlabeltool(Jpane�̵�.name���ײ���[i]+":"+shuliangһ�׽��ײ���[i]+"  "+Jpane����.nameһ��[i]+":"+Zhuangyuan.shuliang��Ʒһ�ײ���[i]));
            }
//            myjscPane.add(new Jlabeltool(Jpane�̵�.name���׽��ײ���+":"+shuliang���׽��ײ���));
        }
       else if(e.getSource()==�̵�){
           if(number����[2]>=1){
               jp�̵�.setVisible(true);
               jp01.setVisible(false);
           }
           else{
               myjscPane.add(new Jlabeltool("�Ǳ��ﻹû���̵�"));
               addlenth();
           }
        }
        else if(e.getSource()==ѵ��){
            if(number����[3]>=1){
                jpѵ��Ӫ.setVisible(true);
                jp01.setVisible(false);
            }
            else{
                myjscPane.add(new Jlabeltool("�Ǳ��ﻹû��ѵ��Ӫ"));
                addlenth();
            }
        }
        else if (e.getSource() == Jp02.toJP01||e.getSource()==Jpane����.toJP01||e.getSource()==Jpane�̵�.toJP01||e.getSource()== JpaneXunlian.toJP01||e.getSource()==Jpane����.toJP01||e.getSource()==Jpane����.toJP01) {
            jt1.setText("��ң� " + jtlist[0]);
            jt2.setText("ľ�ģ� " + jtlist[1]);
            jt3.setText("���� " + jtlist[2]);
            jt4.setText("������ " + jtlist[3]);
            jt5.setText("ʳ� " + jtlist[4]);
            jt6.setText("ʯͷ�� " + jtlist[5]);
            jp����.setVisible(false);
            jp����.setVisible(false);
            jp�̵�.setVisible(false);
            jpѵ��Ӫ.setVisible(false);
            jp����.setVisible(false);
            jp02.setVisible(false);
            jp01.setVisible(true);
        }


    }
    public static void addlenth(){
        Zhuangyuan.jsbar.setValue(Zhuangyuan.jsbarValue);
        Zhuangyuan.jsbarValue+=32;
    }

}
