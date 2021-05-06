package Business;



import javax.swing.JFrame;
import Views.ekran1;




public class MainGui extends JFrame{

 
        
     public static void main(String[]args){
         
        MainGui ekran = new MainGui();
        ekran.setResizable(false);
        ekran.setFocusable(false);       
        ekran.setSize(500,600);
        ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
        ekran1 e =new ekran1();                    
        e.setFocusable(true);             
        ekran.add(e);       
        ekran.setVisible(true);
  
       
        
     } 
    }
 