/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.timer.service.impl.withdelegation;
import java.beans.PropertyChangeSupport;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;
/**
 *
 * @author Achraf
 */
public class TimerServiceImplWithDelegation extends TimerTask implements TimerService{
    
    public int dixiemeDeSeconde;
    public int minutes;
    public int secondes;
    public int heures;
    
    
    
    public TimerServiceImplWithDelegation() {
        Timer timer = new Timer();

        LocalTime localTime = LocalTime.now();

        secondes = localTime.getSecond();
        minutes = localTime.getMinute();
        heures = localTime.getHour();
        dixiemeDeSeconde = localTime.getNano() / 100000000;

        timer.scheduleAtFixedRate(this, 100, 100);
    }

    @Override
    public void run() {
        timeChanged();
        System.out.println(heures+":"+minutes+":"+secondes+":"+dixiemeDeSeconde);
    }
    
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    
    @Override
    public void addTimeChangeListener(TimerChangeListener pl) {
        pcs.addPropertyChangeListener(pl);
    }

    @Override
    public void removeTimeChangeListener(TimerChangeListener pl) {
        pcs.removePropertyChangeListener(pl);
    }
    
    @Override
    public int getMinutes() {
        return minutes;
    }

    @Override
    public int getHeures() {
        return heures;
    }

    @Override
    public int getSecondes() {
        return secondes;
    }

    @Override
    public int getDixiemeDeSeconde() {
        return dixiemeDeSeconde;
    }
    
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void setHeures(int heures) {
        this.heures = heures;
    }

    public void setSecondes(int secondes) {
         this.secondes = secondes;
    }

    public void setDixiemeDeSeconde(int dixiemeDeSeconde) {
        this.dixiemeDeSeconde = dixiemeDeSeconde;
    }
    
    public void IncMinutes() {
        int oldValue = this.minutes;
        this.minutes++;
        pcs.firePropertyChange(TimerChangeListener.MINUTE_PROP, oldValue, minutes);
    }

    public void IncHeures() {
        int oldValue = this.heures;
        this.heures++;
        pcs.firePropertyChange(TimerChangeListener.HEURE_PROP, oldValue, heures);
    }

    public void IncSecondes() {
        int oldValue = this.secondes;
        this.secondes++;
        pcs.firePropertyChange(TimerChangeListener.SECONDE_PROP, oldValue, secondes);
    }

    public void IncDixiemeDeSeconde() {
        int oldValue = this.dixiemeDeSeconde;
        this.dixiemeDeSeconde++;
        pcs.firePropertyChange(TimerChangeListener.DIXEME_DE_SECONDE_PROP, oldValue, dixiemeDeSeconde);

    }
    

    private void timeChanged() {
        updateDixiemeDeSecode();
    }

    private void updateDixiemeDeSecode() {
        int oldValue = dixiemeDeSeconde;
        dixiemeDeSeconde = (dixiemeDeSeconde + 1) % 10;

        // informer les listeners ! 
        pcs.firePropertyChange(TimerChangeListener.DIXEME_DE_SECONDE_PROP, oldValue, dixiemeDeSeconde);

        if (dixiemeDeSeconde == 0) {
            updateSecode();
        }
    }

    private void updateSecode() {
        int oldValue = secondes;
        secondes = (secondes + 1) % 60;
        
        pcs.firePropertyChange(TimerChangeListener.SECONDE_PROP, oldValue, secondes);
        
        
        if (secondes == 0) {
            updateMinutes();
        }
    }

    private void updateMinutes() {
        int oldValue = minutes;
        minutes = (minutes + 1) % 60;

        pcs.firePropertyChange(TimerChangeListener.MINUTE_PROP, oldValue, minutes);
        

        if (minutes == 0) {
            updateHeures();
        }
    }

    private void updateHeures() {
        int oldValue = heures;
        heures = (heures + 1) % 24;
        
        pcs.firePropertyChange(TimerChangeListener.HEURE_PROP, oldValue, heures);
       
    }

}
