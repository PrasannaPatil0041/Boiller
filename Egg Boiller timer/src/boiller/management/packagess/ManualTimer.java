package boiller.management.packagess;
import java.awt.event.*;
import javax.swing.*;

public class ManualTimer {
    private Timer timer;
    private int counter =600;
    private JLabel label;

    public ManualTimer(JLabel imp_JLabel) {
        this.label=imp_JLabel;

        timer=new Timer(1000,new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(counter>0){
                    counter--;
                    label.setText("Time left is "+ counter+" sec");
                }else{
                    timer.stop();
                    label.setText("Eggs are boiled");
                }
            }
        });
    }

    
    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public int getTimeLeft() {
        return counter;
    }
}
