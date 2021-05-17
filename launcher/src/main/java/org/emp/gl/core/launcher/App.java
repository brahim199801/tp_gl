package org.emp.gl.core.launcher;

import org.emp.gl.actions.Actions;
import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.gui.control.GuiControl;
import org.emp.gl.gui.display.GuiDisplay;
import org.emp.gl.state.Watch;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;
import org.emp.gl.timer.service.impl.withdelegation.TimerServiceImplWithDelegation;

/**
 * Hello world!
 *
 */
public class App {

    // ce code nous permettra d'enregistrer les service que notre application utilsiera 
    // lors de l'execution
    static {
        Watch watch = new Watch();
        Lookup.getInstance().register(TimerServiceImplWithDelegation.class,watch );
        Lookup.getInstance().register(Actions.class, watch);
        
    }

    public static void main(String[] args) {

        testDuTimeService();
    }


    private static void testDuTimeService() {

        TimerServiceImplWithDelegation ts = Lookup.getInstance().getService(TimerServiceImplWithDelegation.class);
        
        
        //ts.addTimeChangeListener(new AfficheurHeureSurConsole());
      /*for(int i=0;i<20;i++){
        ts.addTimeChangeListener(new CompteARebour(5 + (int)(Math.random() * 10)));
        ts.addTimeChangeListener(new AfficheurHeureSurConsole());
          }*/
      ts.addTimeChangeListener(new GuiDisplay(ts.getDixiemeDeSeconde(),ts.getSecondes(),ts.getMinutes(),ts.getHeures()));
      GuiControl c = new GuiControl();

      

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
