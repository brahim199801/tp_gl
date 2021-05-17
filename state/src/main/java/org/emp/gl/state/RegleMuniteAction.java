/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.state;

import org.emp.gl.actions.Actions;

/**
 *
 * @author Achraf
 */
public class RegleMuniteAction implements Actions{
    
    Watch mywatch;

    RegleMuniteAction(Watch mywatch){
        this.mywatch = mywatch;
    }

    @Override
    public void doConfig() {
        this.mywatch.ChangeAction(new NormaleAction(this.mywatch));
    }

    @Override
    public void doMode() {
        this.mywatch.ChangeAction(new RegleHeureAction(this.mywatch));
    }

    @Override
    public void doIncrement() {
        this.mywatch.IncMinutes();
    }
    
}
