package boiller.management.packagess;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class HomePages extends JFrame {
     
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
        add(image);


        setVisible(true);

    }
    public static void main(String[] args) {
        new HomePages();
    }
}
