/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Views.ekran1;
import Views.Ates;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Berat
 */
public class Klavye implements KeyListener {
    ekran1 oyn;
    
    
    public Klavye(ekran1 oyn) {
        this.oyn=oyn;    
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int c=ke.getKeyCode();
       
            switch (c) {
                case KeyEvent.VK_LEFT:
                    if(oyn.uzaygemisiX<=0){
                        oyn.uzaygemisiX=0;
                    }
                    else {
                        oyn.uzaygemisiX-=oyn.uzaygemisiyonu;
                    }                            
                    break;
                    
                case KeyEvent.VK_RIGHT:
                    if(oyn.uzaygemisiX>=440){
                        oyn.uzaygemisiX=440;
                    }
                    else{
                        oyn.uzaygemisiX+=oyn.uzaygemisiyonu;
                    }        break;
                case KeyEvent.VK_UP:
                    if(oyn.uzaygemisiY<=150){
                        oyn.uzaygemisiY=150;
                    }
                    else{
                        oyn.uzaygemisiY-=20;
                    }        break;
                case KeyEvent.VK_DOWN:
                    if(oyn.uzaygemisiY>=465){
                        oyn.uzaygemisiY=465;
                    }
                    else{
                        oyn.uzaygemisiY+=20;
                    }        break;
              
                    default:
                    break;
            }
            if(c==KeyEvent.VK_SPACE){
                
              oyn.atesler.add(new Ates(oyn.uzaygemisiX+15,oyn.uzaygemisiY-15));
         
              if(oyn.can<0)
             {
                      
             if(oyn.skor>oyn.yuksek_skor)           
                oyn.yuksek_skor=oyn.skor;          
            
                oyn.dusmanhizi=1;    
                oyn.can=100;            
              
            }
            else if(oyn.oyunDurumu == false && oyn.b==1)
            {       
                    
                
                    
                    String message ="Yüksek Skor="+oyn.yuksek_skor+"\nSkor="+oyn.skor+
                            "\nAtış Hakkınız Kalmadı"+
                            "\nGecen Sure:"+oyn.gecen_sure/1000.0+"saniye";
                   JOptionPane.showMessageDialog(oyn, message);
                    oyn.getAc().setVisible(false);
                    oyn.getBir().setVisible(false); 
                    oyn.getIki().setVisible(false);
                 oyn.oyunDurumu = true;                       
                 oyn.skor=0;
                 oyn.can=100;
                 oyn.dusmanY=0;oyn.dusmanY1=0;oyn.dusmanY2=0;oyn.dusmanY3=0;                 
            }
         
           }   
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
    
  

    
}
