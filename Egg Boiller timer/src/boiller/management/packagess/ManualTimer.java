package boiller.management.packagess;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

public class ManualTimer {
    private Timer timer;
    private int counter =600;
    private JLabel label;
    private JLabel image;
    private int min=counter/60;
    private int sec=counter%60;

    public ManualTimer(JLabel imp_JLabel,JLabel img) {
        this.label=imp_JLabel;
        this.image=img;
        timer=new Timer(1000,new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(counter>0){
                    counter--;
                    min=counter/60;
                    sec=counter%60;
                    label.setText("Time left is "+min+" min "+sec+" sec");
                }else{

                    timer.stop();
                    ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/BrokenEgg.png"));
                    Image i2= i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
                    ImageIcon i3= new ImageIcon(i2);

                    image.setIcon(i3);
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
    
    public void Restart(){
        timer.stop();
        counter=600;
        label.setText("");
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/egg.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);

        image.setIcon(i3);
    }
}
