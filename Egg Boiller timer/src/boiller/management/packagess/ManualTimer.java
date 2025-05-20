package boiller.management.packagess;
import java.awt.Image;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class ManualTimer {
    private Timer timer;
    private int counter =10;
    private JLabel label;
    private JLabel image;
    private int min=counter/60;
    private int sec=counter%60;
    Clip clip;

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

                    makeSound();
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
        clip.stop();
    }

    public int getTimeLeft() {
        return counter;
    }
    
    public void Restart(){
        timer.stop();
        counter=600;
        clip.stop();
        label.setText("");
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/egg.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);

        image.setIcon(i3);
    }

    public void makeSound(){
        try {
            File soundFile= new File("C:\\Users\\prasa\\Downloads\\sample-15s.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            System.out.println("File exists: " + soundFile.exists());
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
