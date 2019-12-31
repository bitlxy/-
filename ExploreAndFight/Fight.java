package ExploreAndFight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import com.Zhuangyuan.fyx.*;
public class Fight extends JFrame {//战斗
    Monster monster;
    Mercenary mercenary[];
    private static Thread thread1;
    private static Thread thread2;
    private MonsterThread mt1;
    private MercenaryThread mt2;
    DrawMonsterFightView drawMonsterFightView;
    DrawMercenaryFightView drawMercenaryFightView;
    ImageIcon fightBackground;
    JLabel label1;
    DrawExploreView drawExploreView;
    public Fight(Monster monster, Mercenary mercenary[],DrawExploreView drawExploreView) {
        this.monster = monster;
        this.mercenary = mercenary;
        this.drawExploreView=drawExploreView;
        this.setUndecorated(true);
    }

    public void creatJieMian() throws AWTException {
        this.setLayout(null);
        creatBackground();
        creatMercenaryJieMian();
        creatMonsterJieMian();
        drawMonsterFightView = new DrawMonsterFightView(monster,mercenary);
        drawMonsterFightView.setLayout(null);
        drawMercenaryFightView=new DrawMercenaryFightView(monster,mercenary);
        drawMercenaryFightView.setLayout(null);
        drawMonsterFightView.setBackground(Color.PINK);
        drawMonsterFightView.setBounds(0, 0, 500, 50);
        drawMonsterFightView.setVisible(true);
        drawMercenaryFightView.setBackground(Color.PINK);
        drawMercenaryFightView.setBounds(0,250,500,50);
        drawMercenaryFightView.setVisible(true);
        mt1 = new MonsterThread(drawMonsterFightView,this);
        mt2 = new MercenaryThread(drawMercenaryFightView);
        thread1 = new Thread(mt1);
        thread2 = new Thread(mt2);
        this.add(drawMonsterFightView);
        this.add(drawMercenaryFightView);
        this.setBounds(ExploreView.PX, ExploreView.PY, 500, 500);
        this.setVisible(true);
        thread1.start();
        thread2.start();
    }

    public void creatBackground(){
        this.fightBackground=new ImageIcon("src/map/fightBackground1.jpg");
        label1=new JLabel(fightBackground);
        this.getLayeredPane().add(label1,new Integer(Integer.MIN_VALUE));
        label1.setBounds(0,0,500,500);
        Container container=this.getContentPane();
        ((JPanel)container).setOpaque(false);
    }

    public void creatMonsterJieMian(){
        String monsterName = monster.getMonsterName();
        JLabel label1 = new JLabel("1");
        label1.setText(monsterName);
        label1.setBackground(Color.RED);
        label1.setFont(new Font("楷体",Font.PLAIN,35));
        label1.setBounds(100,50,200,50);
        this.add(label1);
    }

    public void creatMercenaryJieMian(){
        switch (mercenary[0].getId()){
            case 1:{
                String mercenaryName=mercenary[1].getMercenaryName();
                JLabel label1=new JLabel();
                label1.setText(mercenaryName);
                label1.setFont(new Font("楷体",0,25));
                label1.setBounds(200,300,100,63);
                this.add(label1);
                break;
            }
            case 2:{
                String[] mercenaryName=new String[10];
                mercenaryName[1]=mercenary[1].getMercenaryName();
                mercenaryName[2]=mercenary[2].getMercenaryName();
                JLabel label1=new JLabel();
                label1.setText(mercenaryName[1]);
                label1.setFont(new Font("楷体",0,25));
                label1.setBounds(100,300,100,63);
                JLabel label2=new JLabel();
                label2.setText(mercenaryName[2]);
                label2.setFont(new Font("楷体",0,25));
                label2.setBounds(300,300,100,63);
                this.add(label1);
                this.add(label2);
                break;
            }
            case 3:{
//                String[] mercenaryName=new String[10];
                JLabel label1=new JLabel();
                label1.setText(mercenary[1].getMercenaryName());
                label1.setFont(new Font("楷体",0,25));
                JLabel label2=new JLabel();
                label2.setText(mercenary[2].getMercenaryName());
                label2.setFont(new Font("楷体",0,25));
                JLabel label3=new JLabel();
                label3.setText(mercenary[3].getMercenaryName());
                label3.setFont(new Font("楷体",0,25));
//                for(int i=1;i<=3;i++){
//                    mercenaryName[i]=mercenary[i].getMercenaryName();
//                    labels[i].setText(mercenaryName[i]);
//                    labels[i].setFont(new Font("楷体",0,25));
//                }
                label1.setBounds(80,300,100,63);
                label2.setBounds(200,300,100,63);
                label3.setBounds(320,300,100,63);
                this.add(label1);
                this.add(label2);
                this.add(label3);
                break;
            }
        }
    }

    public Color getScreenPixel(int x,int y) throws AWTException{
        Robot rb=null;
        rb=new Robot();
        Toolkit tk=Toolkit.getDefaultToolkit();
        Dimension di=tk.getScreenSize();
        Rectangle rec=new Rectangle(0,0,di.width,di.height);
        BufferedImage bi=rb.createScreenCapture(rec);
        int pixelColor=bi.getRGB(x,y);
        Color color=new Color(16777216+pixelColor);
        return color;
    }
}

class MonsterThread implements Runnable {
    private DrawMonsterFightView drawMonsterFightView;
    private Fight fight;
    public MonsterThread(DrawMonsterFightView drawFightView,Fight fight) {
        this.drawMonsterFightView = drawFightView;
        this.fight=fight;

    }

    public void run() {
        int cal=0;
        double cd1=0;
        while (true) {
            cal++;
            cd1+=30.0/(drawMonsterFightView.getMonster().getAtkcd());
//            cd2+=30.0/(drawFightView.getMercenary().getAtkcd());
            if(Math.abs(cd1-300)<0.1) cd1=0;
//            if(Math.abs(cd2-300)<0.1) cd2=0;
            drawMonsterFightView.setcd1(cd1);
//            drawFightView.setcd2(cd2);
            if((cal)%(drawMonsterFightView.getMonster().getAtkcd()*10)==0) {
                drawMonsterFightView.getMercenary().setHP(drawMonsterFightView.getMercenary().getHP() - drawMonsterFightView.getMonster().getAtk());
            }
//            if((cal)%(drawFightView.getMercenary().getAtkcd()*10)==0){
//                drawFightView.getMonster().setHP(drawFightView.getMonster().getHP()-drawFightView.getMercenary().getAtk());
//            }
            drawMonsterFightView.repaint();
            drawMonsterFightView.getMonster().monsterDataCheck();
//            drawFightView.getMercenary().mercenaryDataCheck();
            if (!drawMonsterFightView.getMercenary().isLive()) {
                System.out.println("你挂了");break;
            }
            if(!drawMonsterFightView.getMonster().isLive()){
                System.out.println("你赢了");
                ExploreView.map1[fight.monster.getX()][fight.monster.getY()]=-1;
                xuanZe();
                break;
            }
            System.out.println(cal);
            try {
                Thread.sleep(100 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void xuanZe(){
        JLabel label=new JLabel("胜利");
        label.setForeground(Color.red);
        label.setFont(new Font("华文行楷",0,45));
        label.setBounds(200,100,100,63);
        JButton button1=new JButton("确认");
        button1.setFont(new Font("华文行楷",0,30));
        button1.setBounds(200,180,100,63);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fight.setVisible(false);
                fight.drawExploreView.repaint();
                if(drawMonsterFightView.monster.getMonsterId()==13){
                    Beibao.youlongcailiao=1;
                }
                if(drawMonsterFightView.monster.getMonsterId()==12){
                    Beibao.xuerencailiao=1;
                }
            }
        });
        fight.add(label);
        fight.add(button1);
        fight.repaint();
    }
}

class MercenaryThread implements Runnable {
    private DrawMercenaryFightView drawMercenaryFightView;
    public MercenaryThread(DrawMercenaryFightView drawMercenaryFightView) {
        this.drawMercenaryFightView = drawMercenaryFightView;
    }

    public void run() {
        int cal=0;
        double[] cd=new double[]{0.0,0.0,0.0,0.0};
        while (true) {
            cal++;
            for(int i=1;i<=drawMercenaryFightView.getMercenary()[0].getId();i++){
                cd[i]+=10.0/(drawMercenaryFightView.getMercenary()[i].getAtkcd());
                if(Math.abs(cd[i]-100)<0.1) cd[i]=0;
            }
            drawMercenaryFightView.setcd(cd);
            for(int i=1;i<=drawMercenaryFightView.getMercenary()[0].getId();i++){
                if((cal)%(drawMercenaryFightView.getMercenary()[i].getAtkcd()*10)==0){
                    drawMercenaryFightView.getMonster().setHP(drawMercenaryFightView.getMonster().getHP()- drawMercenaryFightView.getMercenary()[i].getAtk());
                }
            }
            drawMercenaryFightView.repaint();
            drawMercenaryFightView.getMercenary()[0].mercenaryDataCheck();
            if (!drawMercenaryFightView.getMercenary()[0].isLive()) {
                System.out.println("你挂了");break;
            }
            if(!drawMercenaryFightView.getMonster().isLive()){
                break;
            }
            System.out.println(cal);
            try {
                Thread.sleep(100 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class DrawMonsterFightView extends JPanel {
    Monster monster;
    private int monsterChuShiHp;
    Image iBuffer;
    Graphics gBuffer;
    private double cd1;
    Mercenary[] mercenaries;
    ImageIcon imageIcon;
    JLabel label;
    String hp;
    public DrawMonsterFightView(Monster monster,Mercenary[] mercenaries) {//初始化战斗界面
        this.setLayout(null);
        this.monster = monster;
        this.monsterChuShiHp=monster.getHP();
        this.mercenaries=mercenaries;
        this.setBackground();
    }

    public void setBackground(){
        imageIcon=new ImageIcon("src/map/fightBackground1.jpg");
        label=new JLabel(imageIcon);
        label.setBounds(0,0,500,200);
        this.add(label);
        this.setOpaque(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        this.drawXueTiao(g);
        this.drawJiNeng(g);
    }

    public Monster getMonster(){
        return monster;
    }

    public Mercenary getMercenary(){
        return mercenaries[0];
    }

    public void drawXueTiao(Graphics g){
        g.drawRect(100, 0, 300, 20);
        g.setColor(Color.red);
        g.fillRect(100, 0, monster.getHP() *300/ monsterChuShiHp, 20);
        hp=monster.getHP()+"/"+monsterChuShiHp;
        g.drawString(hp,420,20);
    }

    public void drawJiNeng(Graphics g){
        g.setColor(Color.BLACK);
        g.drawRect(100,20,300,10);
        g.setColor(Color.GRAY);
        g.fillRect(100,20,(int)cd1,10);
    }

    public void update(Graphics g) {//双缓存
        if (iBuffer == null) {
            iBuffer = createImage(this.getSize().width,this.getSize().height);
            gBuffer = iBuffer.getGraphics();
        }
        gBuffer.setColor(getBackground());
        gBuffer.fillRect(0, 0, this.getSize().width,this.getSize().height);
        paint(gBuffer);
        g.drawImage(iBuffer, 0, 0, this);
    }

    public void setcd1(double cd1){
        this.cd1=cd1;
    }

}

class DrawMercenaryFightView extends JPanel{
    Mercenary mercenary[];
    private int mercenaryChuShiHp;
    Image iBuffer;
    Graphics gBuffer;
    private double[] cd;
    private int CDLEN=100;
    Monster monster;
    ImageIcon imageIcon;
    JLabel label;
    String hp;
    public DrawMercenaryFightView(Monster monster,Mercenary mercenary[]) {//初始化战斗界面
        this.mercenary = mercenary;
        for(int i=1;i<=mercenary[0].getId();i++){
            this.mercenaryChuShiHp+=mercenary[i].getHP();
        }
        mercenary[0].setHP(mercenaryChuShiHp);
        this.monster=monster;
        this.setBackground();
    }

    public void setBackground(){
        imageIcon=new ImageIcon("src/map/fightBackground1.jpg");
        label=new JLabel(imageIcon);
        label.setBounds(0,0,500,200);
        this.add(label);
        this.setOpaque(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        this.drawXueTiao(g);
        this.drawJiNeng(g);
    }

    public Monster getMonster() {
        return monster;
    }

    public Mercenary[] getMercenary(){
        return mercenary;
    }

    public void drawXueTiao(Graphics g){
        g.setColor(Color.black);
        g.drawRect(100, 20, 300, 20);
        g.setColor(Color.red);
        g.fillRect(100, 20, mercenary[0].getHP()*300/ mercenaryChuShiHp, 20);
        hp=mercenary[0].getHP()+"/"+mercenaryChuShiHp;
        g.drawString(hp,420,30);
    }

    public void drawJiNeng(Graphics g){
        switch (mercenary[0].getId()){
            case 1:{
                g.setColor(Color.BLACK);
                g.drawRect(200,40,CDLEN,10);
                g.setColor(Color.GRAY);
                g.fillRect(200,40,(int)cd[1],10);
                break;
            }
            case 2:{
                g.setColor(Color.BLACK);
                g.drawRect(100,40,CDLEN,10);
                g.drawRect(300,40,CDLEN,10);
                g.setColor(Color.GRAY);
                g.fillRect(100,40,(int)cd[1],10);
                g.fillRect(300,40,(int)cd[2],10);
                break;
            }
            case 3:{
                g.setColor(Color.BLACK);
                g.drawRect(80,40,CDLEN,10);
                g.drawRect(200,40,CDLEN,10);
                g.drawRect(320,40,CDLEN,10);
                g.setColor(Color.GRAY);
                g.fillRect(80,40,(int)cd[1],10);
                g.fillRect(200,40,(int)cd[2],10);
                g.fillRect(320,40,(int)cd[3],10);
                break;
            }
        }
    }

    public void update(Graphics g) {//双缓存
        if (iBuffer == null) {
            iBuffer = createImage(this.getSize().width,this.getSize().height);
            gBuffer = iBuffer.getGraphics();
        }
        gBuffer.setColor(getBackground());
        gBuffer.fillRect(0, 0, this.getSize().width,this.getSize().height);
        paint(gBuffer);
        g.drawImage(iBuffer, 0, 0, this);
    }

    public void setcd(double[] cd){
        this.cd=cd;
    }
}
