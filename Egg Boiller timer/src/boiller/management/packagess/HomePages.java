package boiller.management.packagess;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class HomePages extends JFrame implements ActionListener {
    
    JButton start,stop,Restart;
    ManualTimer Timer;
    HomePages(){

        setSize(500,700);
        setLocation(300,50);

        setLayout(null);
        //setBackground(Color.GRAY);
        getContentPane().setBackground(Color.white);
    
        JLabel header = new JLabel("Timer to Boil Egg");
        header.setBounds(0, 0, 500, 50);
        header.setFont(new Font("Arial",Font.BOLD,22));
        header.setOpaque(true); 
        header.setForeground(Color.yellow);
        header.setBackground(Color.black);
        header.setHorizontalAlignment(SwingConstants.CENTER);
        add(header);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/egg.png"));
        Image i2=i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 30, 500, 300);
        image.setHorizontalAlignment(SwingConstants.CENTER);
       // BufferedImage rotatedImage = ImageUtils.rotateImage(image, 45);
        add(image);
        

        JLabel Times= new JLabel("");
        Times.setBounds(0, 340, 500, 60);
        Times.setFont(new Font("Arial", Font.BOLD, 40));
        Times.setHorizontalAlignment(SwingConstants.CENTER);
        add(Times);

        Timer= new ManualTimer(Times,image);
        
        start = new JButton("Start");
        start.addActionListener(this);
        start.setBounds(20, 450, 200, 40);
        start.setFont(new Font("Arial",Font.BOLD,16));
        start.setOpaque(true); 
        start.setForeground(Color.yellow);
        start.setBackground(Color.black);
        start.setHorizontalAlignment(SwingConstants.CENTER);
        add(start);

        stop = new JButton("Stop");
        stop.setBounds(250, 450, 200, 40);
        stop.addActionListener(this);
        stop.setFont(new Font("Arial",Font.BOLD,16));
        stop.setOpaque(true); 
        stop.setForeground(Color.yellow);
        stop.setBackground(Color.black);
        stop.setHorizontalAlignment(SwingConstants.CENTER);
        add(stop);

        Restart = new JButton("Restart");
        Restart.addActionListener(this);
        Restart.setBounds(160, 530, 200, 40);
        Restart.setFont(new Font("Arial",Font.BOLD,16));
        Restart.setOpaque(true); 
        Restart.setForeground(Color.yellow);
        Restart.setBackground(Color.black);
        Restart.setHorizontalAlignment(SwingConstants.CENTER);
        add(Restart);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==start){
          Timer.start();
       }else if(ae.getSource()==stop){
           Timer.stop();
       }else if(ae.getSource()==Restart){
            Timer.Restart();
       }
    }
    public static void main(String[] args) {
        new HomePages();
    }
}
