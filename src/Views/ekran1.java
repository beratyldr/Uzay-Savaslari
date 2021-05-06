package Views;


import Logic.Klavye;
import Logic.Klavye;
import Logic.Olaylar;
import Logic.Olaylar;
import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;




    

 public class ekran1 extends JPanel {
        
        Olaylar a;        
        Klavye k;
        
        Image arkaplan,gameover;
        public boolean oyunDurumu = false;
        public int gecen_sure=0;
        public int can=100;        
        public BufferedImage uzaymekigi,image4; 
        public BufferedImage image1,image2,image3;              
        public ArrayList<Ates> atesler =new ArrayList<>(); 
        public ArrayList<dusmanAtesi> atesler1 =new ArrayList<>(); 
        public int yuksek_skor=0;
        public int skor=0;
        public int uzaygemisiY=465;
        public int atesdirY=4;
        public int atesdusmanY=1;       
        public int dusmanhizi=1;
        public int uzaygemisiX=150;
        public int uzaygemisiyonu=15;
        public int dusmanY=-20;
        public int dusmanX=0;       
        public int dusmanY1=-20;
        public int dusmanX1=0;
        public int dusmanY2=-20;
        public int dusmanX2=0;
        public int dusmanY3=-20;
        public int dusmanX3=0;        
        public int b=0;
        JButton ac,bir,iki;
        
        public ekran1(){
              
                if(oyunDurumu==false){                                
                add(getAc());
                add(getBir());
                add(getIki());
                setLayout(null);
                ac.setBounds(0,0, 150, 50);
                bir.setBounds(0,50, 150, 50);
                iki.setBounds(0,100, 150, 50);                             
                }
                
                arkaplan = new ImageIcon("a.jpg").getImage();
                gameover=new ImageIcon("gameover.jpg").getImage();
            
            try {
                
                uzaymekigi =ImageIO.read(new FileImageInputStream(new File("uzaymekiği.png")));          
                image1 =ImageIO.read(new FileImageInputStream(new File("dusman.png")));          
                image2 =ImageIO.read(new FileImageInputStream(new File("ates.png")));
                image3 =ImageIO.read(new FileImageInputStream(new File("düsmanatesi.png")));                
            }
            catch (IOException ex) { 
                Logger.getLogger(ekran1.class.getName()).log(Level.SEVERE, null, ex);
            }   
            
            addActionListener(getA());
            addKeyListener(getK());
                
        }

    
       

  
    
        
        
            @Override
   protected void paintComponent(Graphics g) {
   // TODO Auto-generated method stub   
    super.paintComponent(g); 
    int baslangicx=0;
    int baslangicy=0;
    int bitisx=500;
    int bitisy=600;
 
    if(oyunDurumu){

    if(can<0){
        
        g.drawImage(gameover, baslangicx, baslangicy,bitisx,bitisy, null);     
        can=100;
        oyunDurumu = false;
    }
    else
        g.drawImage(arkaplan, baslangicx, baslangicy,bitisx,bitisy, null);
        
  }
    if(b==1 && oyunDurumu==false){    
        getAc().setVisible(true);
        getBir().setVisible(true);
        getIki().setVisible(true);
        g.drawImage(gameover, baslangicx, baslangicy,bitisx,bitisy, null);} 
 }
   
       /**
      *
      * @param g
       */
     @Override
       public void paint(Graphics g) {
         super.paint(g); //To change body of generated methods, choose Tools | Templates.
          
         
         if(oyunDurumu)
       {
        gecen_sure+=5;
        g.drawImage(uzaymekigi,uzaygemisiX,uzaygemisiY,uzaymekigi.getWidth(),uzaymekigi.getHeight(),this);
        g.drawImage(image1,dusmanX,dusmanY,image1.getWidth(),image1.getHeight(),this);
        g.drawImage(image1,dusmanX1,dusmanY1,image1.getWidth(),image1.getHeight(),this);
        g.drawImage(image1,dusmanX2,dusmanY2,image1.getWidth(),image1.getHeight(),this);
        g.drawImage(image1,dusmanX3,dusmanY3,image1.getWidth(),image1.getHeight(),this);        
        g.setColor(Color.ORANGE); 
         
         
                  
         if(dusmanY==1){
            dusmanX = (int)(Math.random()*20)*20;}          
         if(dusmanY1==1){
            dusmanX1 = (int)(Math.random()*20)*20;}
         if(dusmanY2==1){
            dusmanX2 = (int)(Math.random()*20)*20;} 
         if(dusmanY3==1){
            dusmanX3 = (int)(Math.random()*20)*20;}
         
         
         
          g.setColor(Color.RED);
        
         for(Ates ates:atesler) {
            g.drawImage(image2,ates.getX(),ates.getY(),image2.getWidth(),image2.getHeight(),this);
            };
         
           for(dusmanAtesi ates1:atesler1) {
            g.drawImage(image3,ates1.getX(),ates1.getY(),image3.getWidth(),image3.getHeight(),this);
            };
        
    
        g.setColor(Color.white);
        g.setFont(new Font("serif",Font.BOLD,12));
        g.drawString("Skor="+skor,440,40);     
        g.drawString("HEALTH="+(can),420,60);       
        g.dispose();
        if(carpismaVarmi()){        
        }               
    }
    }
        
        public boolean carpismaVarmi(){
            for(Ates ates:atesler){
              if(new Rectangle(ates.getX(),ates.getY(),18,20).intersects(new Rectangle(dusmanX,dusmanY,25,25))){
                    dusmanY=0;
                    atesler.remove(ates);
                    dusmanX = (int)(Math.random()*20)*20; 
                    skor++;                  
                    can+=5; 
                    
            }  
              if (new Rectangle(ates.getX(),ates.getY(),18,20).intersects(new Rectangle(dusmanX1,dusmanY1,25,25))){
                    dusmanY1=0;
                    atesler.remove(ates);
                    dusmanX1 = (int)(Math.random()*20)*20;                       
                    skor++;                  
                    can+=5; 
                    
              }
              if (new Rectangle(ates.getX(),ates.getY(),18,20).intersects(new Rectangle(dusmanX2,dusmanY2,25,25))){
                    dusmanY2=0;
                    atesler.remove(ates);
                    dusmanX2 = (int)(Math.random()*20)*20;                       
                    skor++;                  
                    can+=5; 
                    
              }
              if (new Rectangle(ates.getX(),ates.getY(),18,20).intersects(new Rectangle(dusmanX3,dusmanY3,25,25))){
                    dusmanY3=0;
                    atesler.remove(ates);
                    dusmanX3 = (int)(Math.random()*20)*20;                       
                    skor++;                  
                    can+=5; 
                    
              }      
              
            }
            
            for(dusmanAtesi ates1:atesler1){
            if (new Rectangle(ates1.getX(),ates1.getY(),20,20).intersects(new Rectangle(uzaygemisiX,uzaygemisiY,uzaymekigi.getWidth(),uzaymekigi.getHeight()))){                                                                   
                    can-=20; 
                    atesler1.remove(ates1); 
                    return true; 
              }               
            }
            return false;
        
        }
 public JButton getAc() {
        if (ac == null) {
            ac = new JButton();
            ac.setBackground(Color.yellow);                      
            ac.addActionListener(getA());
            ac.setText("Zorluk seviyesi 1 ");
        }
        return ac;
    }

    public void setAc(JButton ac) {
        this.ac = ac;
    }
    public JButton getBir() {
        if (bir == null) {
            bir = new JButton();
            bir.setBackground(Color.yellow);                      
            bir.addActionListener(getA());
            bir.setText("Zorluk seviyesi 2 ");
        }
        return bir;
    }

    public void setBir(JButton bir) {
        this.bir = bir;
    }
    public JButton getIki() {
        if (iki == null) {
            iki = new JButton();
            iki.setBackground(Color.yellow);                      
            iki.addActionListener(getA());
            iki.setText("Zorluk seviyesi 3 ");
        }
        return iki;
    }

    public void setIki(JButton iki) {
        this.iki = iki;
    }
    public Olaylar getA() {
        if (a== null) {
            a = new Olaylar(this);
        }
        return a;
    }

    public void setA(Olaylar a) {
        this.a = a;
    }

    
    public Klavye getK() {
        if (k== null) {
          k = new Klavye(this);
        }
        return k;
    }

    public void setK(Klavye k) {
        this.k = k;
    }

    
      
}
