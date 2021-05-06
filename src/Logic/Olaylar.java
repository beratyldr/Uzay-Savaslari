/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Views.dusmanAtesi;
import Views.ekran1;
import Views.Ates;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.Timer;
/**
 *
 * @author Berat
 */
public class Olaylar implements ActionListener{
      
    ekran1 o=null;
    Timer timer=new Timer(10,this);
    
    public Olaylar(ekran1 o) {
        timer.start();
        this.o=o;
    }

    public ekran1 getO() {
        
        o=new ekran1();       
        return o;
    }

    public void setO(ekran1 o) {
        this.o = o;
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == o.getAc()){
           o.dusmanhizi=1;
           o.b=1;              
           o.can=100;
           o.oyunDurumu=true;
           o.getAc().setVisible(false);
           o.getBir().setVisible(false);
           o.getIki().setVisible(false);
           o.requestFocus(false);
      
       }
        if (e.getSource() == o.getBir()){
           o.dusmanhizi=2;
           o.b=1;            
           o.can=100;
           o.oyunDurumu=true;
           o.getAc().setVisible(false);
           o.getBir().setVisible(false);
           o.getIki().setVisible(false);
           o.requestFocus(false);
      
       }
        if (e.getSource() == o.getIki()){
           o.dusmanhizi=3;
           o.b=1;                               
           o.oyunDurumu=true;
           o.can=100;
           o.getAc().setVisible(false);
           o.getBir().setVisible(false);
           o.getIki().setVisible(false);
           o.requestFocus(false);
      
       }
        
        
        for(Ates ates: o.atesler ){        
            ates.setY(ates.getY()-(o.atesdirY));}
        
       
            
        
       
        
        if(o.dusmanY==50){      
            o.atesler1.add(new dusmanAtesi(o.dusmanX+10,o.dusmanY+10));}        
        for(dusmanAtesi ates1:o.atesler1 ){        
            ates1.setY(ates1.getY()+(o.atesdusmanY));
        }
        if(o.dusmanY1==40){      
            o.atesler1.add(new dusmanAtesi(o.dusmanX1+10,o.dusmanY1+10));}        
        for(dusmanAtesi ates1:o.atesler1 ){        
            ates1.setY(ates1.getY()+(o.atesdusmanY));
        }
        if(o.dusmanY2==60){      
            o.atesler1.add(new dusmanAtesi(o.dusmanX2+10,o.dusmanY2+10));}        
        for(dusmanAtesi ates1:o.atesler1 ){        
            ates1.setY(ates1.getY()+(o.atesdusmanY));
        }
        if(o.dusmanY3==30){      
            o.atesler1.add(new dusmanAtesi(o.dusmanX3+10,o.dusmanY3+10));}        
        for(dusmanAtesi ates1:o.atesler1 ){        
            ates1.setY(ates1.getY()+(o.atesdusmanY));
        }
        
      
        o.dusmanY+=o.dusmanhizi;    
        o.dusmanY1+=o.dusmanhizi;
        o.dusmanY2+=o.dusmanhizi+1;
        o.dusmanY3+=o.dusmanhizi;               
        if(o.dusmanY>=480){
           o.can-=5;
           o.dusmanY=-15;
       }
        if(o.dusmanY1>=480){
           o.can-=5;
           o.dusmanY1=-15;
       }
        if(o.dusmanY2>=480){
           o.can-=5;
           o.dusmanY2=-15;
       }
        if(o.dusmanY3>=480){
           o.can-=5;
           o.dusmanY3=-15;
       }
        
       o.repaint();
   
    }

    
}
