/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.state;

import org.emp.gl.actions.Actions;
import org.emp.gl.actions.doConfigAction;
import org.emp.gl.actions.doIncrementAction;
import org.emp.gl.actions.doModeAction;
import org.emp.gl.timer.service.impl.withdelegation.TimerServiceImplWithDelegation;

/**
 *
 * @author Achraf
 */
public class Watch extends TimerServiceImplWithDelegation implements Actions{
    
    Actions action;
    public Watch(){
        super();
        this.action = new NormaleAction(this);
    }
    
    public void ChangeAction(Actions action){
        this.action = action;
    }
    
    public void doConfig(){
        this.action.doConfig();
    }
    public void doMode(){
        this.action.doMode();
    }
    public void doIncrement(){
        this.action.doIncrement();
    }
    
    

}

    


 
    
    
    
