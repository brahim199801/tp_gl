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
public class NormaleAction  implements Actions{
    
    Watch mywatch;

    NormaleAction(Watch mwatch){
        this.mywatch = mwatch;
    }

    @Override
    public void doConfig() {
        this.mywatch.ChangeAction(new RegleSecondeAction(this.mywatch));
    }

    @Override
    public void doMode() {
        //Rien A Faire
    }

    @Override
    public void doIncrement() {
        //Rien A Faire
    }
    
}
