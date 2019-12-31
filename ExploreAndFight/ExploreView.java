package ExploreAndFight;

import com.Zhuangyuan.fyx.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ExploreView extends JFrame {
    public static int PX = 200;
    public static int PY = 50;
    public static Image ocupy = (new ImageIcon("src/map/ocupy.jpg")).getImage();
    public static Image chuansong = (new ImageIcon("src/map/chuansong.jpg")).getImage();
    public static Image bingkuai=(new ImageIcon("src/map/冰块(已去底).jpg")).getImage();
    private int mianbao;//面包数量
    private JLabel label_Background1;
    private JLabel label_Background2;
    //    private JButton huicheng;
    private JLabel changjing;
    private DrawExploreView drawExploreView;
    private Panel panel;
    private Panel rule;
    private JTextArea hint;
    private Actor actor;
    private Monster monster;
    private Beibao beiBao;
    ImageIcon mapBackground;
    public static int[][] map1 = {//地图大小25*25
            {0, 0, 9, 0, 0, 0, 0,-2, 0, 0, 5,12, 5, 0, 0,-2, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0,-2, 0, 0, 5, 5, 5, 0, 0,-2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 9, 0, 0, 0, 0, 0,-2, 0, 0, 0, 0, 0, 0, 0,-2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0,-2,-2,-2,-2, 5,-2,-2,-2,-2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0,10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 4, 0, 6, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 7, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 4, 0, 6, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0,11, 0, 0, 0, 0, 0},
            {9,-2,-2,-2,-2,-2,-2,-2, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},//aaaa
            {0, 0, 0, 8, 0, 0, 0,-2, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 8, 4, 8, 0, 0,-2, 0, 0, 1, 0, 1, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 4, 2, 4, 8, 0,-2, 0, 0, 0, 0,11,-9,11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 8, 4, 8, 0, 0,-2, 0, 0, 0, 1, 0,11, 0, 3, 0,10, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 8, 0, 9, 0,-2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0,-2,-2,-2,-2,-2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 8, 0, 9, 0, 0, 0, 0, 0, 0,-2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-2, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 9, 9, 9, 0, 0, 0, 0, 0, 9, 0,-2, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 9,13, 9, 0, 0, 0, 0, 0, 0,10,-2, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
    };
    public static int[][] map11 = {//地图中的面包数量
            {0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 5, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},//aaaa
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
    };
    public static int[][] map12 = {//地图中的木材数量
            {0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 5, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},//aaaa
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
    };

    public void chuShiHuaActor() {
        int[] a = new int[Jpane出征.人数 + 1];
        a[0] = Jpane出征.人数;
        int cal = 1;
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j < Jpane出征.出征[i]; j++) {
                a[cal] = i + 1;
                cal++;
            }
        }
        actor = new Actor(13, 13, a);
    }

    public ExploreView() {
        this.setUndecorated(true);
    }

    public void chushihuaExploreView() {
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                if (map1[i][j] != 0) {
                    map11[i][j] = 5;
                    map12[i][j] = 6;
                }
                ;
            }
        }
        chuShiHuaActor();
        this.mianbao = Jpane出征.食物;
        beiBao = new Beibao(mianbao);
        drawExploreView = new DrawExploreView(actor, monster, beiBao);
        mapBackground = new ImageIcon("src/map/map_11.jpg");
        changjing = new JLabel(" 极寒之地\n", JLabel.CENTER);
        panel = new Panel();
        rule = new Panel();
        hint = new JTextArea("    操作方式\n↑:向上移动\n←:向左移动\n→:向右移动\n↓:向下移动\n\nB:打开或关闭背包\n\nESC:退出游戏\n\n提示1:请不要随意点击此方框否则可能出现bug\n提示2:用完面包就会挂掉(身上所有物品和雇佣兵消失),请及时回城补给");

    }

    //主方法
    public static ExploreView exploreView;
//    public static void main(String[] args) {
//        exploreView.showView();
//    }

    public void showView() {
        this.setFocusable(true);
        creatBeiJing();
        JTextArea shuoming = new JTextArea();
        shuoming.setLineWrap(true);
        shuoming.setFont(new Font("楷体", 0, 18));
        shuoming.setForeground(Color.red);
        shuoming.setBounds(0, 40, 130, 200);
        shuoming.setText("长夜无眠,\n寒冬侵袭,\n锤炼灵魂与神智之地。\n\n\n任务目标:杀死冰霜幼龙和雪人酋长。");
        shuoming.setBackground(new Color(4, 8, 128));
        changjing.setFont(new Font("宋体", 1, 18));
        changjing.setForeground(Color.RED);
        changjing.setBounds(0, 0, 130, 30);
        drawExploreView.setBackground(null);
        drawExploreView.setBounds(0, 0, DrawExploreView.EXPLORE_WIDTH * DrawExploreView.EXPLORE_NUMBER, DrawExploreView.EXPLORE_HEIGHT * DrawExploreView.EXPLORE_NUMBER);
        panel.setLayout(null);
        panel.setBackground(new Color(4, 8, 128));
        panel.setBounds(DrawExploreView.EXPLORE_WIDTH * DrawExploreView.EXPLORE_NUMBER + 40, 0, 150, DrawExploreView.EXPLORE_HEIGHT * DrawExploreView.EXPLORE_NUMBER);
        rule.setBackground(new Color(25, 88, 128));
        rule.setBounds(0, DrawExploreView.ACTOR_CENTER - 10, 150, 1);
        hint.setFont(new Font("楷体", 0, 16));//设置字体，0正常，1粗体
        hint.setBounds(10, DrawExploreView.ACTOR_CENTER, 130, 1000);
        hint.setBackground(new Color(123, 128, 128));
        hint.setForeground(Color.GREEN);
        hint.setLineWrap(true);
        panel.add(rule);
        panel.add(hint);
        panel.add(changjing);
        panel.add(shuoming);
        this.setTitle("UndergroundCastle-1.0");
        this.setSize(DrawExploreView.EXPLORE_WIDTH * DrawExploreView.EXPLORE_NUMBER + 210, DrawExploreView.EXPLORE_HEIGHT * DrawExploreView.EXPLORE_NUMBER);
        this.setLocation(PX, PY);
        this.setLayout(null);
        this.setBackground(null);
        this.add(drawExploreView);
        this.add(panel);
        this.addKeyListener(new ExploreControl(actor, drawExploreView, beiBao));
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        this.setVisible(true);
        this.requestFocus();
    }

    public void creatBeiJing() {
        label_Background1 = new JLabel(mapBackground);
        this.getLayeredPane().add(label_Background1, new Integer(Integer.MIN_VALUE));
        label_Background1.setBounds(DrawExploreView.ACTOR_CENTER - DrawExploreView.EXPLORE_NUMBER * DrawExploreView.EDGE_LEN, DrawExploreView.ACTOR_CENTER - DrawExploreView.EXPLORE_NUMBER * DrawExploreView.EDGE_LEN, (2 * DrawExploreView.EDGE_LEN + 1) * DrawExploreView.EXPLORE_NUMBER, (2 * DrawExploreView.EDGE_LEN + 1) * DrawExploreView.EXPLORE_NUMBER);
//        label_Background2=new JLabel(mapBackground);
//        this.getLayeredPane().add(label_Background2,new Integer(Integer.MIN_VALUE));
//        label_Background2.setBounds(0,300,800,800);
        Container container = this.getContentPane();
        ((JPanel) container).setOpaque(false);
    }

}

class ExploreControl implements KeyListener {
    private Actor actor;
    DrawExploreView drawExploreView;
    Beibao beibao;

    public ExploreControl(Actor actor, DrawExploreView drawExploreView, Beibao beibao) {
        this.drawExploreView = drawExploreView;
        this.actor = actor;
        this.beibao = beibao;
    }

    public void keyReleased(KeyEvent ke) {
        switch (ke.getKeyCode()) {
            case KeyEvent.VK_UP:
                actor.setDirection(0);
                break;
            case KeyEvent.VK_RIGHT:
                actor.setDirection(1);
                break;
            case KeyEvent.VK_DOWN:
                actor.setDirection(2);
                break;
            case KeyEvent.VK_LEFT:
                actor.setDirection(3);
                break;
            case KeyEvent.VK_B:
                beibao.setVisible(true);
                return;
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
            default: {
                System.out.println("没有此按键");
                return;
            }
        }

        actor.actorMove();
        if(ExploreView.map1[actor.getLocationx()][actor.getlocationy()]==-2){
            switch (actor.getDirection()){
                case 0:{
                    actor.setDirection(2);
                    break;
                }
                case 1:{
                    actor.setDirection(3);
                    break;
                }
                case 2:{
                    actor.setDirection(0);
                    break;
                }
                case 3:{
                    actor.setDirection(1);
                    break;
                }
            }
            actor.actorMove();
        }
        beibao.updateinfo();
        drawExploreView.repaint();//按下按键后立刻重画，在重画的方法里面已经不包含角色的移动，因此重画之前需要角色移动
    }

    public void keyPressed(KeyEvent arg0) {
    }

    public void keyTyped(KeyEvent arg0) {
    }
}

class DrawExploreView extends JPanel {
    //探索界面的宽度高度
    public static final int EXPLORE_WIDTH = 15;
    public static final int EXPLORE_HEIGHT = 15;
    public static final int EXPLORE_NUMBER = 60;
    public static final int ACTOR_CENTER = 370;
    public static final int EDGE_LEN = 4;
    private Actor actor;
    private Beibao beibao;
    private Monster monster;

    //创建时的初始化
    public DrawExploreView(Actor actor, Monster monster, Beibao beibao) {
        this.actor = actor;
        this.beibao = beibao;
        this.monster = monster;
        this.setOpaque(false);
    }

    //重写paint以便repaint
    public void paint(Graphics g) {
//        super.paint(g);
        drawBlack(g);
        this.drawActor(g);
        this.drawMonster(g);
        this.drawFriends(g);
        g.setColor(Color.black);
        this.drawEdge(g);
        try {
            this.meetAll();
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("(" + actor.getLocationx() + "," + actor.getlocationy() + ")");
    }

    public void meetAll() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        if (ExploreView.map1[actor.getLocationx()][actor.getlocationy()] >= 1) {//碰到了怪物
            new FightPreConfirm(this, ExploreView.map1[actor.getLocationx()][actor.getlocationy()], actor).setVisible(true);
        }
        if (ExploreView.map1[actor.getLocationx()][actor.getlocationy()] == -1) {//碰到了补给站
            new BuJiPreConfirm(this, actor, beibao).setVisible(true);
        }
        if (ExploreView.map1[actor.getLocationx()][actor.getlocationy()] == -9) {//碰到了传送门
            new ChuanSong(beibao).setVisible(true);
        }
    }

    public void drawMonster(Graphics g) {
        for (int i = -EDGE_LEN; i <= +EDGE_LEN; i++) {//画出actor周围格的怪物
            for (int j = -EDGE_LEN; j <= +EDGE_LEN; j++) {
                if (i + actor.getLocationx() < 0 || i + actor.getLocationx() > 24 || j + actor.getlocationy() < 0 || j + actor.getlocationy() > 24) {
                    g.setColor(Color.BLACK);
                    g.fillRect(ACTOR_CENTER + i * EXPLORE_NUMBER, ACTOR_CENTER + j * EXPLORE_NUMBER, EXPLORE_NUMBER, EXPLORE_NUMBER);
                } else if (ExploreView.map1[i + actor.getLocationx()][j + actor.getlocationy()] >= 1) {
//                    g.setColor(Color.red);
//                    g.fillRect(260 + i * EXPLORE_NUMBER, 260 + j * EXPLORE_NUMBER, EXPLORE_NUMBER, EXPLORE_NUMBER);
                    monster = new Monster(ExploreView.map1[i + actor.getLocationx()][j + actor.getlocationy()]);
                    monster.setImage();
                    g.drawImage(monster.getImg(), ACTOR_CENTER + i * EXPLORE_NUMBER, ACTOR_CENTER + j * EXPLORE_NUMBER, EXPLORE_NUMBER, EXPLORE_NUMBER, this);
                }
            }
        }
    }

    public void drawBlack(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, EXPLORE_NUMBER * EXPLORE_WIDTH, ACTOR_CENTER - EXPLORE_NUMBER * EDGE_LEN);
        g.fillRect(0, 0, ACTOR_CENTER - EXPLORE_NUMBER * EDGE_LEN, EXPLORE_NUMBER * EXPLORE_WIDTH);
        g.fillRect(0, ACTOR_CENTER + (EDGE_LEN + 1) * EXPLORE_NUMBER, EXPLORE_NUMBER * EXPLORE_WIDTH, ACTOR_CENTER);
        g.fillRect(ACTOR_CENTER + (EDGE_LEN + 1) * EXPLORE_NUMBER, 0, ACTOR_CENTER, EXPLORE_NUMBER * EXPLORE_WIDTH);
    }

    public void drawFriends(Graphics g) {
        for (int i = -EDGE_LEN; i <= EDGE_LEN; i++) {
            for (int j = -EDGE_LEN; j <= EDGE_LEN; j++) {
                if (i + actor.getLocationx() < 0 || i + actor.getLocationx() > 24 || j + actor.getlocationy() < 0 || j + actor.getlocationy() > 24) {
                    g.setColor(Color.BLACK);
                    g.fillRect(ACTOR_CENTER + i * EXPLORE_NUMBER, ACTOR_CENTER + j * EXPLORE_NUMBER, EXPLORE_NUMBER, EXPLORE_NUMBER);
                } else if (ExploreView.map1[i + actor.getLocationx()][j + actor.getlocationy()] == -1) {
                    g.drawImage(ExploreView.ocupy, ACTOR_CENTER + i * EXPLORE_NUMBER, ACTOR_CENTER + j * EXPLORE_NUMBER, EXPLORE_NUMBER, EXPLORE_NUMBER, this);
//                    g.setColor(Color.GREEN);
//                    g.fillRect(ACTOR_CENTER+i*EXPLORE_NUMBER,ACTOR_CENTER+j*EXPLORE_NUMBER,EXPLORE_NUMBER,EXPLORE_NUMBER);
                } else if (ExploreView.map1[i + actor.getLocationx()][j + actor.getlocationy()] == -9) {
                    g.drawImage(ExploreView.chuansong, ACTOR_CENTER + i * EXPLORE_NUMBER, ACTOR_CENTER + j * EXPLORE_NUMBER, EXPLORE_NUMBER, EXPLORE_NUMBER, this);
                }
                else if(ExploreView.map1[i + actor.getLocationx()][j + actor.getlocationy()] == -2){
                    g.drawImage(ExploreView.bingkuai, ACTOR_CENTER + i * EXPLORE_NUMBER, ACTOR_CENTER + j * EXPLORE_NUMBER, EXPLORE_NUMBER, EXPLORE_NUMBER, this);
                }
            }
        }
    }

    public void drawEdge(Graphics g) {
        for (int i = -EDGE_LEN; i <= EDGE_LEN; i++) {//划出边界线
            if ((i + actor.getLocationx() == 0) && (actor.getlocationy() >= EDGE_LEN && actor.getlocationy() <= (24 - EDGE_LEN))) {
                g.drawLine(ACTOR_CENTER + i * EXPLORE_NUMBER, ACTOR_CENTER - EXPLORE_NUMBER * EDGE_LEN, ACTOR_CENTER + i * EXPLORE_NUMBER, ACTOR_CENTER + EXPLORE_NUMBER * (EDGE_LEN + 1));
            } else if ((i + actor.getLocationx() == 0) && actor.getlocationy() < EDGE_LEN) {
                g.drawLine(ACTOR_CENTER + i * EXPLORE_NUMBER, ACTOR_CENTER - EXPLORE_NUMBER * actor.getlocationy(), ACTOR_CENTER + i * EXPLORE_NUMBER, ACTOR_CENTER + EXPLORE_NUMBER * (EDGE_LEN + 1));
            } else if ((i + actor.getLocationx() == 0) && actor.getlocationy() > (24 - EDGE_LEN)) {
                g.drawLine(ACTOR_CENTER + i * EXPLORE_NUMBER, ACTOR_CENTER - EXPLORE_NUMBER * EDGE_LEN, ACTOR_CENTER + i * EXPLORE_NUMBER, ACTOR_CENTER + EXPLORE_NUMBER * (25 - actor.getlocationy()));
            } else if ((i + actor.getLocationx() == 24) && (actor.getlocationy() >= EDGE_LEN && actor.getlocationy() <= (24 - EDGE_LEN))) {
                g.drawLine(ACTOR_CENTER + (i + 1) * EXPLORE_NUMBER, ACTOR_CENTER - EXPLORE_NUMBER * EDGE_LEN, ACTOR_CENTER + (i + 1) * EXPLORE_NUMBER, ACTOR_CENTER + EXPLORE_NUMBER * (EDGE_LEN + 1));
            } else if ((i + actor.getLocationx() == 24) && actor.getlocationy() < EDGE_LEN) {
                g.drawLine(ACTOR_CENTER + (i + 1) * EXPLORE_NUMBER, ACTOR_CENTER - EXPLORE_NUMBER * actor.getlocationy(), ACTOR_CENTER + (i + 1) * EXPLORE_NUMBER, ACTOR_CENTER + EXPLORE_NUMBER * (EDGE_LEN + 1));
            } else if ((i + actor.getLocationx() == 24) && actor.getlocationy() > (24 - EDGE_LEN)) {
                g.drawLine(ACTOR_CENTER + (i + 1) * EXPLORE_NUMBER, ACTOR_CENTER - EXPLORE_NUMBER * EDGE_LEN, ACTOR_CENTER + (i + 1) * EXPLORE_NUMBER, ACTOR_CENTER + EXPLORE_NUMBER * (25 - actor.getlocationy()));
            }
        }
        for (int j = -EDGE_LEN; j <= EDGE_LEN; j++) {//划出边界线
            if ((j + actor.getlocationy() == 0) && (actor.getLocationx() >= EDGE_LEN && actor.getLocationx() <= (24 - EDGE_LEN))) {//如果边界线出现在视野中
                g.drawLine(ACTOR_CENTER - EXPLORE_NUMBER * EDGE_LEN, ACTOR_CENTER + j * EXPLORE_NUMBER, ACTOR_CENTER + EXPLORE_NUMBER * (EDGE_LEN + 1), ACTOR_CENTER + j * EXPLORE_NUMBER);
            } else if ((j + actor.getlocationy() == 0) && (actor.getLocationx() < EDGE_LEN)) {
                g.drawLine(ACTOR_CENTER - EXPLORE_NUMBER * actor.getLocationx(), ACTOR_CENTER + j * EXPLORE_NUMBER, ACTOR_CENTER + EXPLORE_NUMBER * 9, ACTOR_CENTER + j * EXPLORE_NUMBER);
            } else if ((j + actor.getlocationy() == 0) && (actor.getLocationx() > (24 - EDGE_LEN))) {
                g.drawLine(ACTOR_CENTER - EXPLORE_NUMBER * EDGE_LEN, ACTOR_CENTER + j * EXPLORE_NUMBER, ACTOR_CENTER + EXPLORE_NUMBER * (25 - actor.getLocationx()), ACTOR_CENTER + j * EXPLORE_NUMBER);
            } else if ((j + actor.getlocationy() == 24) && (actor.getLocationx() >= EDGE_LEN && actor.getLocationx() <= (24 - EDGE_LEN))) {//如果边界线出现在视野中
                g.drawLine(ACTOR_CENTER - EXPLORE_NUMBER * EDGE_LEN, ACTOR_CENTER + (j + 1) * EXPLORE_NUMBER, ACTOR_CENTER + EXPLORE_NUMBER * (EDGE_LEN + 1), ACTOR_CENTER + (j + 1) * EXPLORE_NUMBER);
            } else if ((j + actor.getlocationy() == 24) && (actor.getLocationx() < EDGE_LEN)) {
                g.drawLine(ACTOR_CENTER - EXPLORE_NUMBER * actor.getLocationx(), ACTOR_CENTER + (j + 1) * EXPLORE_NUMBER, ACTOR_CENTER + EXPLORE_NUMBER * (EDGE_LEN + 1), ACTOR_CENTER + (j + 1) * EXPLORE_NUMBER);
            } else if ((j + actor.getlocationy() == 24) && (actor.getLocationx() > (24 - EDGE_LEN))) {
                g.drawLine(ACTOR_CENTER - EXPLORE_NUMBER * EDGE_LEN, ACTOR_CENTER + (j + 1) * EXPLORE_NUMBER, ACTOR_CENTER + EXPLORE_NUMBER * (25 - actor.getLocationx()), ACTOR_CENTER + (j + 1) * EXPLORE_NUMBER);
            }
        }
    }

    //画Actor
    public void drawActor(Graphics g) {
        actor.checkImage();
        g.drawImage(actor.getImage(), ACTOR_CENTER, ACTOR_CENTER, EXPLORE_NUMBER, EXPLORE_NUMBER, this);
//        g.fillOval(260, 260, EXPLORE_NUMBER, EXPLORE_NUMBER);
    }


}

class Actor {
    //Actor的方向 0上1右2下3左
    private Image img = (new ImageIcon("src/actor/Character/actor_d.png")).getImage();
    private int direction = 0;
    private int locationx;
    private int locationy;
    private boolean outedge = false;
    public int mercenaryId[] = {3, 3, 4, 5};//雇佣兵初始化,其中下标0处的值表示雇佣兵的个数，之后就是各个雇佣兵的id
//    private ExploreView exploreView;

    //actor初始化
    public Actor(int x, int y, int mercenaryId[]) {
        this.locationx = x;
        this.locationy = y;
        this.mercenaryId = mercenaryId;
//        this.exploreView = exploreView;
    }

    //设置角色位置
    public void setLocation(int x, int y) {
        this.locationx = x;
        this.locationy = y;
    }

    public void checkImage() {//图像修正
        switch (direction) {
            case 0:
                img = (new ImageIcon("src/actor/actor_u.png")).getImage();
                break;
            case 1:
                img = (new ImageIcon("src/actor/actor_r.png")).getImage();
                break;
            case 2:
                img = (new ImageIcon("src/actor/actor_d.png")).getImage();
                break;
            case 3:
                img = (new ImageIcon("src/actor/actor_l.png")).getImage();
                break;
        }
    }

    public Image getImage() {
        return img;
    }

    //获取角色位置
    public int getLocationx() {
        return locationx;
    }

    public int getlocationy() {
        return locationy;
    }

    //角色移动方向
    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getDirection(){
        return  direction;
    }
    //Actor移动，注意，此处的坐标是角色相对于map中的下标位置，不是图中的实际像素位置
    public void actorMove() {
        switch (direction) {
            case 0:
                if (this.locationy == 0) break;
                this.locationy -= 1;
                break;
            case 1:
                if (this.locationx == 24) break;
                this.locationx += 1;
                break;
            case 2:
                if (this.locationy == 24) break;
                this.locationy += 1;
                break;
            case 3:
                if (this.locationx == 0) break;
                this.locationx -= 1;
                break;
        }
    }

    //判断是否越界
    public void actorRunInterface() {

        if (this.getLocationx() < 0 || this.getlocationy() < 0 || this.getLocationx() > 24 || this.getlocationy() > 24) {
            this.outedge = true;
        }
    }

    public boolean isMeeting() {
        if (ExploreView.map1[locationx][locationy] == 1) {
            return true;
        } else {
            return false;
        }
    }
}

class BuJiPreConfirm extends JFrame {
    Actor actor;
    Beibao beibao;
    private int mianbaonum;
    private int mucai;
    JLabel label;
    ImageIcon imageIcon;

    public BuJiPreConfirm(DrawExploreView drawExploreView, Actor actor, Beibao beibao) {
        this.actor = actor;
        this.beibao = beibao;
        this.creatBackground();
        this.creatMianbao();
        this.creatMucai();
        this.creatGoaway();
        this.setLayout(null);
        this.setBounds(ExploreView.PX, ExploreView.PY, 230, 400);
        this.setUndecorated(true);
    }

    public void creatMucai() {
        this.mucai = ExploreView.map12[actor.getLocationx()][actor.getlocationy()];
        JLabel label1 = new JLabel("木材:" + this.mucai);
        label1.setFont(new Font("华文行楷", Font.BOLD, 26));
        label1.setBounds(0, 70, 130, 63);
        JButton button1 = new JButton("获取");
        button1.setForeground(Color.red);
        button1.setBounds(130, 70, 100, 63);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                beibao.setMuCai(mucai);
                mucai = ExploreView.map12[actor.getLocationx()][actor.getlocationy()] = 0;
                label1.setText("木材:" + mucai);
                repaint();
            }
        });
        this.add(button1);
        this.add(label1);
    }

    public void creatGoaway() {//设置离开按钮
        JButton button2 = new JButton("离开");
        button2.setForeground(Color.red);
        button2.setBounds(130, 337, 100, 63);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        this.add(button2);
    }

    public void creatMianbao() {//设置面包
        this.mianbaonum = ExploreView.map11[actor.getLocationx()][actor.getlocationy()];
        JLabel label1 = new JLabel("面包:" + this.mianbaonum);
        label1.setFont(new Font("华文行楷", Font.BOLD, 26));
        label1.setBounds(0, 0, 130, 63);
        JButton button1 = new JButton("获取");
        button1.setForeground(Color.red);
        button1.setBounds(130, 0, 100, 63);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                beibao.setMianBao(mianbaonum);
                mianbaonum = ExploreView.map11[actor.getLocationx()][actor.getlocationy()] = 0;
                label1.setText("面包:" + mianbaonum);
                repaint();
            }
        });
        this.add(button1);
        this.add(label1);
    }

    public void creatBackground() {
        imageIcon = new ImageIcon("src/map/beiBao1.jpg");
        label = new JLabel(imageIcon);
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
        label.setBounds(0, 0, 500, 500);
        Container container = this.getContentPane();
        ((JPanel) container).setOpaque(false);
    }
}

class FightPreConfirm extends JFrame {
    Actor actor;
    public static Monster monster;
    DrawExploreView drawExploreView;
    ImageIcon imageIcon;
    JLabel label;

    public FightPreConfirm(DrawExploreView drawExploreView, int monsterId, Actor actor) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        monster = new Monster(monsterId);
        monster.setX(actor.getLocationx());
        monster.setY(actor.getlocationy());
        this.actor = actor;
        this.drawExploreView = drawExploreView;
        Container container = getContentPane();
        container.setLayout(null);
        JTextArea label1 = new JTextArea(monster.getDescribtion());
        label1.setBounds(0, 0, 500, 100);
        label1.setFont(new Font("华文行楷", 0, 30));
        label1.setForeground(Color.red);
        label1.setLineWrap(true);
        label1.setOpaque(false);
        JButton button1 = new JButton("战斗");
        JButton button2 = new JButton("逃跑");
        button1.setForeground(Color.red);
        ;
        button2.setForeground(Color.red);
        button1.setMargin(new Insets(0, 0, 0, 0));
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");//按钮UI
        button1.setBounds(50, 150, 100, 63);
        button2.setBounds(300, 150, 100, 63);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Mercenary[] mercenary = new Mercenary[10];
                mercenary[0] = new Mercenary(actor.mercenaryId[0]);//雇佣兵0的id储存之后所有雇佣兵的数量
                for (int i = 1; i <= actor.mercenaryId[0]; i++) {
                    mercenary[i] = new Mercenary(actor.mercenaryId[i]);
                }
                try {
                    new Fight(FightPreConfirm.monster, mercenary, drawExploreView).creatJieMian();
                } catch (AWTException ex) {
                    ex.printStackTrace();
                }
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setBounds(ExploreView.PX, ExploreView.PY, 500, 230);
        container.add(label1);
        container.add(button1);
        container.add(button2);
        this.setUndecorated(true);
        creatBackground();
    }

    public void creatBackground() {
        imageIcon = new ImageIcon("src/map/preconfirm.jpg");
        label = new JLabel(imageIcon);
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
        label.setBounds(0, -100, 500, 500);
        Container container = this.getContentPane();
        ((JPanel) container).setOpaque(false);
    }
}

class Beibao extends JFrame {
    private int mianbao;
    private int mucai = 0;
    private int xueRenYinJi;
    JLabel label_mianbao;
    JLabel label_mucai;
    JLabel label_youlong;
    JLabel label_xuerenqiuzhang;
    ImageIcon imageIcon;
    JLabel label;
    public static int youlongcailiao = 0;
    public static int xuerencailiao = 0;

    public Beibao(int mianbao) {
        this.creatBackground();
        this.mianbao = mianbao;
        this.setLayout(null);
        this.setBounds(ExploreView.PX, ExploreView.PY, 200, 340);
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_B:
                        dispose();
                }
            }
        });
        this.setUndecorated(true);
        this.creatMianBao();
        this.creatMucai();
        this.creatZhuanZhiCaiLiao();
    }

    public void creatMucai() {
        label_mucai = new JLabel("木材:" + this.mucai);
        label_mucai.setFont(new Font("华文行楷", Font.BOLD, 26));
        label_mucai.setBounds(0, 90, 500, 60);
        this.add(label_mucai);
    }

    public void creatMianBao() {
        label_mianbao = new JLabel("面包:" + this.mianbao);
        label_mianbao.setFont(new Font("华文行楷", Font.BOLD, 26));
        label_mianbao.setBounds(0, 0, 500, 60);
        JLabel hint = new JLabel();
        hint.setFont(new Font("华文行楷", 0, 17));
        hint.setBounds(0, 300, 200, 31);
        hint.setText("提示:用完面包就会挂掉");
//        this.add(hint);
        this.add(label_mianbao);
    }

    public void creatZhuanZhiCaiLiao() {
        label_youlong=new JLabel("龙之心:"+youlongcailiao);
        label_youlong.setFont(new Font("华文行楷", Font.BOLD, 26));
        label_youlong.setBounds(0, 180, 500, 60);
        this.add(label_youlong);
        label_xuerenqiuzhang=new JLabel("大大大雪球:"+xuerencailiao);
        label_xuerenqiuzhang.setFont(new Font("华文行楷", Font.BOLD, 26));
        label_xuerenqiuzhang.setBounds(0, 270, 500, 60);
        this.add(label_xuerenqiuzhang);
    }

    public void updateinfo(){
        xiaoHao();
        label_youlong.setText("龙之心:"+youlongcailiao);
        label_xuerenqiuzhang.setText("大大大雪球:"+xuerencailiao);
    }

    public void xiaoHao() {
        this.mianbao--;
        label_mianbao.setText("面包:" + this.mianbao);
        if (mianbao < 0) {
            for (int i = 0; i <= 8; i++) {
                Zhuangyuan.shuliang冒险者[i] -= Jpane出征.出征[i];
                Jpane出征.出征[i] = 0;
//                System.out.println("数量"+Zhuangyuan.shuliang冒险者[i]);
            }
            Jpane出征.打印冒险者();
            JpaneXunlian.录入冒险者();
            Zhuangyuan.jp出征.setVisible(false);
            Zhuangyuan.jp01.setVisible(true);

            ExploreView.exploreView.setVisible(false);
            ZhuangyaunMain.mainjf.setVisible(true);
            Zhuangyuan.myjscPane.add(new Jlabeltool("你的冒险队消失在黑暗中..."));
            Zhuangyuan.addlenth();
        }
    }

    public void setMianBao(int num) {
        this.mianbao += num;
    }

    public void creatBackground() {
        imageIcon = new ImageIcon("src/map/beiBao1.jpg");
        label = new JLabel(imageIcon);
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
        label.setBounds(0, 0, 500, 500);
        Container container = this.getContentPane();
        ((JPanel) container).setOpaque(false);
    }

    public void setMuCai(int mucai) {
        this.mucai += mucai;
        label_mucai.setText("木材:" + this.mucai);
    }

    public int getMianbao() {
        return mianbao;
    }

    public int getMucai() {
        return mucai;
    }
}

class ChuanSong extends JFrame {
    //    JPanel panel1 = new JPanel();
//    JPanel panel2 = new JPanel();
    Beibao beibao;

    public ChuanSong(Beibao beibao) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        this.beibao = beibao;
        setLayout(null);
//        panel1.setBounds(0, 0, 300, 510);
//        add(panel1);
//        add(panel2);
//        panel1.setVisible(true);
        setBounds(ExploreView.PX, ExploreView.PY, 300, 510);
        setUndecorated(true);
        creatHuiCheng();
        creatExit();
        creatBackground();
        creatChangJing();
    }

    public void creatChangJing() {

    }

    //    public static int[] jtlist = {9999 , 99999, 0, 0, 0, 99999};
//    //金币  木材  铁 秘银 食物  石头
    public void creatHuiCheng() {
        JButton button_huicheng = new JButton("回城");
        button_huicheng.setBounds(0, 0, 100, 63);
        button_huicheng.setFont(new Font("华文行楷", Font.BOLD, 26));
        button_huicheng.setForeground(Color.red);
        button_huicheng.setMargin(new Insets(0, 0, 0, 0));
        button_huicheng.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Zhuangyuan.jtlist[1] += beibao.getMucai();
                Zhuangyuan.jtlist[4] += beibao.getMianbao();
                Zhuangyuan.shuliang一阶进阶材料[7] = beibao.youlongcailiao;
                Zhuangyuan.shuliang二阶进阶材料 = beibao.xuerencailiao;
                ExploreView.exploreView.setVisible(false);
                JpaneXunlian.录入冒险者();
                Zhuangyuan.jp出征.setVisible(false);
                Zhuangyuan.jp01.setVisible(true);
                ExploreView.exploreView.setVisible(false);
                ZhuangyaunMain.mainjf.setVisible(true);
                Zhuangyuan.myjscPane.add(new Jlabeltool("你的冒险队回来了"));
                Zhuangyuan.addlenth();
            }
        });
        add(button_huicheng);
    }

    public void creatExit() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        JButton button_exit = new JButton("离开");
        button_exit.setBounds(0, 440, 100, 63);
        button_exit.setFont(new Font("华文行楷", Font.BOLD, 26));
        button_exit.setForeground(Color.red);
        button_exit.setMargin(new Insets(0, 0, 0, 0));
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        button_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(button_exit);
    }

    public void creatBackground() {
        ImageIcon imageIcon;
        JLabel label;
        imageIcon = new ImageIcon("src/map/beiBao1.jpg");
        label = new JLabel(imageIcon);
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
        label.setBounds(0, 0, 500, 540);
        Container container = this.getContentPane();
        ((JPanel) container).setOpaque(false);
    }
}