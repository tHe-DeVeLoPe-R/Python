import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class LoadComponents extends JFrame{
	JProgressBar progress = new JProgressBar(0 , 100);
	JLabel heading , belowLine;
    Container window = getContentPane();
	public void components() {
		 
		   setLayout(null);
		   setResizable(false);
		   window.setBackground(new Color(170 , 150 , 190));
		   setBounds(-10 , 0 , 1900 , 800);
		   
		   progress.setBounds(200 , 300 , 800 , 15);
		   progress.setFont(new Font(Font.DIALOG , Font.BOLD , 13));
		   progress.setStringPainted(true);
		   window.add(progress);
		   
		   heading = new JLabel("BUDGET MANAGER IS SETTING ENVIRONMENT");
		   heading.setBounds(400, 20, 500, 50);
		   heading.setFont(new Font(Font.SANS_SERIF , Font.BOLD , 20 ));
		   window.add(heading);
		   
		   belowLine = new JLabel("");
		   belowLine.setBounds(400, 330, 1000, 50);
		   belowLine.setFont(new Font(Font.DIALOG_INPUT , Font.BOLD , 20 ));
		   window.add(belowLine);
		  
		   setVisible(true);
		   int i = 0;
		   while(i<=100) {
			  progress.setValue(i);
			if(i<30) {
				 belowLine.setText("Importing Classes...");
			}
			if(i>30 && i<60) {
				 belowLine.setText("Loading Components...");
			}
			if(i>60 && i<80) {
				 belowLine.setText("Invoking Methods...");
			}
			if(i>80 && i<98) {
				 belowLine.setText("Almost Done...");
			}
			   try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   i = i+1;
			   if(i == 100) {
				   progress.setString("process completed :)");
				   belowLine.setText("Wait We Are Moving You to Start Screen...");
				   try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				   
				   StartUp obj = new StartUp();
				   obj.startUp();
				   this.dispose();
				   
				    
			   }
		   }
		  
		   

		 // progressBar();
		   setDefaultCloseOperation(EXIT_ON_CLOSE);
		  
	}
}
