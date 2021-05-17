/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.gui.control;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.emp.gl.actions.Actions;
import org.emp.gl.core.lookup.Lookup;

/**
 *
 * @author Achraf	
 */
public class GuiControl {
    
    JFrame f;
    JButton mode, increment, config;    
    //MyWatch watch;
    Actions action;
 
    public GuiControl(){
        this.action = Lookup.getInstance().getService(Actions.class);
        init();
    }
    public void init() {
        this.f=new JFrame("Gui Control");
        this.f.setSize(600,200);  
        this.f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       
        
        this.mode=new JButton();  
        this.increment=new JButton();  
        this.config=new JButton();  

        this.mode.setBounds(150,50,100,50);
        this.increment.setBounds(250,50,100,50);
        this.config.setBounds(350,50,100,50);

        this.f.add(mode);
        this.f.add(increment);
        this.f.add(config);
        
        this.mode.setText(String.valueOf("Mode"));
        this.increment.setText(String.valueOf("Increment"));
        this.config.setText(String.valueOf("Config"));
        
        this.f.setLayout(null);
        this.f.setVisible(true);
        
        config.addActionListener(e -> this.action.doConfig());
        increment.addActionListener(e -> this.action.doIncrement());
        mode.addActionListener(e -> this.action.doMode());
        
    }
    
        

}
