/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.gui.display;

import java.awt.Color;
import java.beans.PropertyChangeEvent;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.emp.gl.timer.service.TimerChangeListener;

/**
 *
 * @author Achraf
 */
public class GuiDisplay implements TimerChangeListener{
    
    public GuiDisplay(int ms, int s, int m, int h){
        
        this.init(ms, s, m, h);
    }
    
    JFrame f;  
    JPanel p;
    JLabel dixsec, sec, min, hour;
    String timeString = "";  
      

    public void init(int ms, int s, int m, int h){

        
        this.f=new JFrame("Gui Display");
        this.f.setSize(600,200);
        this.f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.p=new JPanel();
        this.p.setBackground(Color.BLUE);
        
        this.dixsec=new JLabel();  
        this.sec=new JLabel();  
        this.min=new JLabel();  
        this.hour=new JLabel();

        this.dixsec.setBounds(400,50,100,50);
        this.sec.setBounds(300,50,100,50);
        this.min.setBounds(200,50,100,50);
        this.hour.setBounds(100,50,100,50);

        this.f.add(dixsec);
        this.f.add(sec);
        this.f.add(min);
        this.f.add(hour);
        
        this.hour.setText(String.valueOf(h));
        this.min.setText(String.valueOf(m));
        this.sec.setText(String.valueOf(s));
        this.dixsec.setText(String.valueOf(ms));
        
        this.f.setLayout(null);
        this.f.setVisible(true);
         
    }  

    @Override
    public void propertyChange(String propertyName, Object oldValue, Object newValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        if(evt.getPropertyName().equals(TimerChangeListener.DIXEME_DE_SECONDE_PROP)){
            this.dixsec.setText(evt.getNewValue().toString());
        }
        
        if(evt.getPropertyName().equals(TimerChangeListener.SECONDE_PROP)){
            this.sec.setText(evt.getNewValue().toString());
            

        }
        
        if(evt.getPropertyName().equals(TimerChangeListener.MINUTE_PROP)){
            this.min.setText(evt.getNewValue().toString());
            
        }
        
        if(evt.getPropertyName().equals(TimerChangeListener.HEURE_PROP)){
            this.hour.setText(evt.getNewValue().toString());
            
        }
    }




    
    
    
}
