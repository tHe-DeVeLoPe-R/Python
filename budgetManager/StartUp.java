import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StartUp extends JFrame {
	JLabel heading , line1 , line2 , line3 , line4 , developer , 
	required , normalRequired , createLabel ;
	JButton create , pass , exit;
	Container window = getContentPane();
   public void startUp() {
	   
	   
	   setLayout(null);
	   setResizable(false);
	   window.setBackground(new Color(170 , 150 , 190));
	   setBounds(-10 , 0 , 1900 , 800);
	  
	   heading = new JLabel("WELCOME TO BUDGET MANAGER");
	   heading.setBounds(500, 20, 500, 50);
	   heading.setFont(new Font(Font.SANS_SERIF , Font.BOLD , 20 ));
	  // heading.setForeground(new Color(100 , 255 , 100));
	   window.add(heading);
	   
	   line1 = new JLabel("This Windows Application is built in java . Using this you can Create and "
	   		+ "manage your budget in an easy and simple way specially if you are a student");
	   line1.setBounds(200 , 150 , 1000 , 20);
	   line1.setFont(new Font(Font.SANS_SERIF , Font.BOLD , 13));
	  window.add(line1);
	  
	  line2 = new JLabel("and you are living in a hostel. ");
	  line2.setBounds(200 , 170 , 1000 , 20);
	  line2.setFont(new Font(Font.SANS_SERIF , Font.BOLD , 13));
	  window.add(line2);
	  
	  
	  line3 = new JLabel("OK FOR FIRST TIME LET'S BEGIN BY CREATING SOME NECESSARY FILES THAT WILL BE USED AS"
	  		+ " YOUR DATA BASE. ");
	  line3.setBounds(200 , 200 , 1000 , 20);
	  line3.setFont(new Font(Font.SANS_SERIF , Font.BOLD , 13));
	  line3.setForeground(Color.white);
	  window.add(line3);
	  
	  line4 = new JLabel("DON'T WORRY YOUR FILES WILL BE SECURE IN YOUR SYSTEM WE CANNOT SEE YOUR"
	  		+ " DATA IT IS ONLY FOR YOU .... ");
		  line4.setBounds(200 , 220 , 1500 , 20);
		  line4.setFont(new Font(Font.SANS_SERIF , Font.BOLD , 13));
		  line4.setForeground(Color.white);
		  window.add(line4);
		  
	    createLabel = new JLabel("");
	    createLabel.setBounds(500 , 360 , 200 , 20);
	    window.add(createLabel);
	 
		create = new JButton("Create Files");
		create.setBounds(500 , 330 , 150 , 30 );
		window.add(create);
		
		 required = new JLabel("*click if you are using application for first time");
		  required.setBounds(670 , 333 , 500 , 15);
		  required.setFont(new Font(Font.DIALOG , Font.BOLD , 13));
		  required.setForeground(Color.RED);
		  window.add(required);
		  
		create.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean check;
			
				check = FileCreater.fileCheck();
				
				if(check == true) {
					FileCreater.Visuals();
					normalRequired.setText("*click for normal use");
					required.setText("Files created successfully");
				}else {
					required.setText("Files are already created");
				}
				
				//dispose();
										
				
			}
			
		});
		
		
		  
		 normalRequired = new JLabel("*click for normal use");
		  normalRequired.setBounds(670 , 400 , 300 , 15);
		  normalRequired.setFont(new Font(Font.DIALOG , Font.BOLD , 13));
		  normalRequired.setForeground(Color.yellow);
		  window.add(normalRequired);
		  
		pass = new JButton("Already Created");
		pass.setBounds(500 , 390 , 150 , 30 );
		window.add(pass);
		
		pass.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean check = true;
				
				try {
					FileReader write = new FileReader("user.txt");
					write.read();
					write.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					check = false;
				}
				if(check == false) {
					normalRequired.setText("Please Create Files first");
				}else {
					
					Home home = new Home();
					home.home();
					dispose();
					
				}
				
			}
		});
		exit = new JButton("Exit");
		exit.setBounds(200 , 600 , 100 , 30 );
		window.add(exit);
		
		 exit.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					
				}
				   
			   });
		 
		 developer = new JLabel("About developer ?");
				  developer.setBounds(1000 , 600 , 200 , 20);
				  developer.setFont(new Font(Font.SANS_SERIF , Font.BOLD , 13));
				  developer.setForeground(Color.BLUE);
				  window.add(developer);
	  setDefaultCloseOperation(EXIT_ON_CLOSE);
	  
	  setVisible(true);
   }
}
