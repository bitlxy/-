package com.Zhuangyuan.fyx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Jlѵ�� extends JLabel {
    Jlѵ��(int i) {
        this.setBounds(170, 70 + 45 * (i - 1), 500, 44);
        this.setFont(new Font("΢���ź�", Font.PLAIN, 16));
        this.setForeground(Color.white);
        this.setBackground(Color.WHITE);
    }
}

class Jldialog extends JLabel {
    Jldialog(int i) {
        if (i == 1) {
            this.setBounds(100, 0, 500, 60);
            this.setForeground(Color.red);
        } else {
            this.setBounds(20, 0 + 60 * (i - 1), 500, 44);
            this.setForeground(Color.BLACK);
        }
        this.setFont(new Font("΢���ź�", Font.PLAIN, 16));
        this.setForeground(Color.BLACK);
        this.setBackground(Color.WHITE);
    }
}

class chooseJdialog extends JDialog implements ActionListener {

    public static JButton jbѡ��[] = {new Jb�˵�(""), new Jb�˵�(""), new Jb�˵�(""), new Jb�˵�(""), new Jb�˵�(""), new Jb�˵�(""), new Jb�˵�(""), new Jb�˵�(""), new Jb�˵�(""), new Jb�˵�("")};
    public static int i;
    public  Container con = getContentPane();
    public chooseJdialog(JFrame frame) {
        super( frame, "ѡ�����תְ·��", true);
//        this.setUndecorated(true);
        setLayout(null);
        setVisible(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int) (screenSize.getWidth() / 2) - 100, 200, 300, 390);
        setBackground(Color.WHITE);

        for(int m=1;m<=8;m++){
            con.add(jbѡ��[m]);
            jbѡ��[m].addActionListener(this);
            jbѡ��[m].setVisible(false);
        }

    }
    public static void ����()
    {
        for(int m=1;m<=8;m++){
            jbѡ��[m].setVisible(false);
        }


        if(i==8){
            jbѡ��[8].setVisible(true);
            jbѡ��[8].setText("ѩ��սʿ");
            JpaneXunlian.jDialogChoose.setSize(200,140);
            jbѡ��[8].setBounds(0,0,200,100);

        }
        else {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            JpaneXunlian.jDialogChoose.setBounds((int) (screenSize.getWidth() / 2) - 100, 300, 200, 390);
            for(int m=1;m<=7;m++)
            {
                jbѡ��[m].setVisible(true);
                jbѡ��[m].setText(JpaneXunlian.name[m]);
                jbѡ��[m].setBounds(0,0+(m-1)*50,200,50);
            }
        }
        JpaneXunlian.jDialogChoose.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JpaneXunlian.jDialogChoose.setVisible(false);
        for(int m=1;m<=8;m++)
        {
            if(e.getSource()==jbѡ��[m])
            {JpaneXunlian.jDialogChoose.setVisible(false);
                JpaneXunlian.��������(m);
                System.out.println("�����ɹ�");
                return;
            }
        }
        return;
    }
}

class zhaomuJDialog extends JDialog implements ActionListener {
    public static JLabel dialogJL[] = {new Jldialog(0), new Jldialog(1), new Jldialog(2), new Jldialog(3),};
    public static JButton yES = new Jb�˵�("ȷ��");
    public static JButton nO = new Jb�˵�("ȡ��");
    public static JPanel jpDialog = new JPanel();
    public static int name;



    public zhaomuJDialog(JFrame frame) {
        super(frame, "ȷ��", true);
        this.setUndecorated(true);
        Container con = getContentPane();
        setLayout(null);
        setVisible(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int) (screenSize.getWidth() / 2) - 100, 200, 350, 270);
//        setLocation((int) (screenSize.getWidth() - Zhuangyuan.frameWidth) / 2, 200);
//        setSize(400, 244);
        setBackground(Color.WHITE);

        jpDialog.setSize(400, 244);
        jpDialog.setBackground(Color.lightGray);
        jpDialog.setLayout(null);
        jpDialog.setVisible(true);
        for (int i = 1; i <= 3; i++) {
            dialogJL[i].setText(i + "");
            con.add(dialogJL[i]);
        }


        yES.setBounds(20, 200, 70, 44);
        nO.setBounds(250, 200, 70, 44);
        yES.addActionListener(this);
        nO.addActionListener(this);
        con.add(yES);
        con.add(nO);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==nO)
        {
            JpaneXunlian.jDialog����.setVisible(false);
        }
        if(e.getSource()==yES){
            JpaneXunlian.����(name);
            JpaneXunlian.jDialog����.setVisible(false);
            JpaneXunlian.¼��ð����();
        }
    }

}

public class JpaneXunlian extends JPanel implements ActionListener {

    public static JDialog jDialog����=new zhaomuJDialog(null);
    public static JDialog jDialogChoose=new chooseJdialog(null);

    public static JButton toJP01 = new JButton("<-");

    public static int[][] mercenaryList = {
            /*1id  2�Ǽ�  3hp  4atk  5atkcd */
            {1, 0, 5, 1, 5},//ð����
            {2, 1, 4, 5, 2},//��ʦ
            {3, 1, 4, 1, 1},//����
            {4, 1, 3, 6, 3},//��ʦ
            {5, 1, 6, 3, 3},//սʿ
            {6, 1, 4, 3, 5},//������
            {7, 1, 6, 4, 3},//Ӷ��
            {8, 1, 10, 3, 4},//����ð����
            {9, 2, 10, 8, 3},//ѩ��սʿ
    };
    public static JButton ��ļ = new JButton("��ļ");

    public static JButton jbѵ��[] = {new Jb�˵�(""), new Jb�˵�(""), new Jb�˵�(""), new Jb�˵�(""), new Jb�˵�(""), new Jb�˵�(""), new Jb�˵�(""), new Jb�˵�(""), new Jb�˵�(""), new Jb�˵�("")};
    public static int ID[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static JLabel jlѵ��[] = {new Jlѵ��(1), new Jlѵ��(2), new Jlѵ��(3), new Jlѵ��(4), new Jlѵ��(5), new Jlѵ��(6), new Jlѵ��(7), new Jlѵ��(8), new Jlѵ��(9)};
    public static int flagjb[] = {-1, -1, -1, -1, -1, -1, -1, -1, -1};
    public static String name[] = {"ð����", "��ʦ", "����", "��ʦ", "սʿ", "������", "Ӷ��", "����ð����", "ѩ��սʿ"};

    JpaneXunlian() {
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

        ��ļ.setBounds(Zhuangyuan.frameWidth / 2 - 50, 5, 100, 61);
        this.add(��ļ);
        ��ļ.setFont(new Font("΢���ź�", Font.BOLD, 30));
        ��ļ.setForeground(Color.white);
        ��ļ.setFocusPainted(false);//����ѡ��
        ��ļ.setBackground(Color.DARK_GRAY);
        ��ļ.setBorderPainted(false);

        for (int i = 0; i <= 8; i++) {
            this.add(jlѵ��[i]);
            this.add(jbѵ��[i]);
//            jbѵ��[i].setText("����ð����");
            jbѵ��[i].setBackground(Color.DARK_GRAY);
            jbѵ��[i].setForeground(Color.ORANGE);
            jbѵ��[i].setVisible(false);
            jbѵ��[i].setBounds(30, 70 + 45 * (i), 130, 44);
            jbѵ��[i].addActionListener(this);

        }
        ¼��ð����();
        ��ļ.addActionListener(this);
    }


    public static void ��������(int i) {

        if (i == 0) {
            zhaomuJDialog.dialogJL[1].setText("��ļһ��" + name[0] + "?");
        }
        else zhaomuJDialog.dialogJL[1].setText("����Ϊ��" + name[i]);
        zhaomuJDialog.dialogJL[2].setText("����ֵ" + mercenaryList[i][2] + " ������" + mercenaryList[i][3] + " �������" + mercenaryList[i][4]);
        if(i<=7&&i>=1)zhaomuJDialog.dialogJL[3].setText("���ģ�"+Jpane����.nameһ��[i]);
        if(i==8)zhaomuJDialog.dialogJL[3].setText("���ģ�"+Jpane����.name����);
        if(i==0)zhaomuJDialog.dialogJL[3].setText("���Ľ��100");
        zhaomuJDialog.name=i;
        jDialog����.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int leixing = 100;
        if (e.getSource() == ��ļ) {
            ��������(0);
        }
        else {

            for (int i = 0; i <= 8; i++) {

                if (e.getSource() == jbѵ��[i]) {
                    leixing = flagjb[i];
                    System.out.println("����Ϊ��" + leixing);
                    if (leixing == 0) {

                        chooseJdialog.i = 0;chooseJdialog.����();
                    }
                    else if (leixing == 4) {
                        chooseJdialog.i = 8;chooseJdialog.����();
                    }
                    else {
                        Zhuangyuan.myjscPane.add(new Jlabeltool("��ְҵ�Ѵﵽ��߼�"));
                        Zhuangyuan.addlenth();
                    }
                }
            }
        }

    }

    public static void ����(int i)
    {
        //��ʦ1������2����ʦ3��սʿ4��������5��Ӷ��6������7,�����ѩ���򲻵���
        String taici[]={"","���׳ɹ����Ҵ�����������ϣ��",
                "���׳ɹ������ǲ���֪���Լ�����ô����",
                "���׳ɹ����Ҿ���ħ���Ļ���",
                "���׳ɹ������ף�����",
                "���׳ɹ�������ϵ��һ��֮��",
                "���׳ɹ���Ҫô��ǮҪô����",
                "���׳ɹ���������յİ���������֮��"};
        if(i==0){
            if(Zhuangyuan.jtlist[0]>=100){
                Zhuangyuan.jtlist[0]-=100;
                Zhuangyuan.myjscPane.add(new Jlabeltool("��ļ�ɹ���ð����+1"));
                Zhuangyuan.shuliangð����[0]++;
                Zhuangyuan.addlenth();
            }
            else{
                Zhuangyuan.myjscPane.add(new Jlabeltool("Ǯ����"));
                Zhuangyuan.addlenth();
            }
        }
        else if(i==8)
        {
            if(Zhuangyuan.shuliang��Ʒ���ײ���>=1)
            {
                Zhuangyuan.myjscPane.add(new Jlabeltool("���׳ɹ���ѩ��֪������ô����"));
                Zhuangyuan.addlenth();
                Zhuangyuan.shuliangð����[4]--;
                Zhuangyuan.shuliangð����[8]++;
            }
            else{
                Zhuangyuan.myjscPane.add(new Jlabeltool("���ϲ���"));
                Zhuangyuan.addlenth();
            }
        }

        else if(Zhuangyuan.shuliang��Ʒһ�ײ���[i]>=1) {
            Zhuangyuan.myjscPane.add(new Jlabeltool(taici[i]));
            Zhuangyuan.shuliang��Ʒһ�ײ���[i]--;
            Zhuangyuan.shuliangð����[0]--;
            Zhuangyuan.shuliangð����[i]++;
            Zhuangyuan.addlenth();
        }
        else{
            Zhuangyuan.myjscPane.add(new Jlabeltool("���ϲ���"));
            Zhuangyuan.addlenth();
        }
    }
    public static void ¼��ð����() {
        for (int x = 0; x <= 8; x++) {
            flagjb[x] = 0;
            jbѵ��[x].setVisible(false);
            jlѵ��[x].setVisible(false);
        }
        int id;
        int p = 0;
        for (id = 0; id <= 8; id++) {
            if (Zhuangyuan.shuliangð����[id] >= 1) {
                jbѵ��[p].setVisible(true);
                jlѵ��[p].setVisible(true );
                jbѵ��[p].setText(name[id]);
                jlѵ��[p].setText("���ƣ�" + Zhuangyuan.shuliangð����[id] + " �� " + " ����ֵ" + mercenaryList[id][2] + " ������" + mercenaryList[id][3] + " �������" + mercenaryList[id][4]);
                if(id==0)
                {jbѵ��[p].setForeground(Color.ORANGE);
                }
                if (id >= 1 && id <= 6) {
                    jbѵ��[p].setForeground(Color.red);
                }
                if (id == 7 || id == 8) {
                    jbѵ��[p].setForeground(Color.RED);
                }
                flagjb[p] = id;
                p++;
            } else continue;
        }
    }
}
