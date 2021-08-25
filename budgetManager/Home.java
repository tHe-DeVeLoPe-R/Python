import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Home extends JFrame{
 JLabel heading , talk , b1Label , b2Label , b3Label , line1 , line2;
 JButton newBudget , addExpenses , showReport , back , exit;
 Container window = getContentPane();
	public void home() {

		   
		   setLayout(null);
		   setResizable(false);
		   window.setBackground(new Color(170 , 150 , 190));
		   setBounds(-10 , 0 , 1900 , 800);
		  
		   heading = new JLabel("BUDGET MANAGER HOME SCREEN");
		   heading.setBounds(500, 20, 500, 50);
		   heading.setFont(new Font(Font.SANS_SERIF , Font.BOLD , 20 ));
		  // heading.setForeground(new Color(100 , 255 , 100));
		   window.add(heading);
		   
		   line1 = new JLabel("Here you can create budget , you can check report for your budget"
		   		+ " , you can add daily expenses to your budget.");
			   line1.setBounds(200 , 100 , 1000 , 20);
			   line1.setFont(new Font(Font.SANS_SERIF , Font.BOLD , 13));
			  window.add(line1);
			  
			  
		   talk = new JLabel("LET'S CHOOSE OPTION AND MOVE FORWARD...");
		   talk.setBounds(500 , 150 , 350 , 20);
		   talk.setFont(new Font(Font.DIALOG_INPUT , Font.BOLD , 15));
		   talk.setForeground(Color.DARK_GRAY);
		   window.add(talk);
		   
		   newBudget = new JButton("Create new Budget");
		   newBudget.setBounds(250 , 220 , 150 , 35);
		   window.add(newBudget);
		   
		   newBudget.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CreateBudget create = new CreateBudget();
				create.components();
				
				dispose();
				
			}
			   
		   });
		   
		   b1Label = new JLabel("*if already created previous will be set to"
		   		+ " '0' and new will be created");
		   b1Label.setFont(new Font(Font.DIALOG , Font.BOLD , 13));
		   b1Label.setForeground(Color.RED);
		   b1Label.setBounds(480 , 222 , 1000 , 20);
		   window.add(b1Label);
		   
		   addExpenses = new JButton("Add Expenses");
		   addExpenses.setBounds(250 , 320 , 150 , 35);
		   window.add(addExpenses);
		   
		   addExpenses.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				AddExpenses add = new AddExpenses();
				add.components();
				dispose();
				
			}
			   
		   });
		   
		   b2Label = new JLabel("*add your today's expenses");
		   b2Label.setFont(new Font(Font.DIALOG , Font.BOLD , 13));
		   b2Label.setForeground(Color.RED);
		   b2Label.setBounds(480 , 322 , 200 , 20);
		   window.add(b2Label);
		   
		   
		   showReport = new JButton("Show Report");
		   showReport.setBounds(250 , 410 , 150 , 35);
		   window.add(showReport);
		   
		   b3Label = new JLabel("*Your report will be displayed");
		   b3Label.setFont(new Font(Font.DIALOG , Font.BOLD , 13));
		   b3Label.setForeground(Color.RED);
		   b3Label.setBounds(480 , 412 , 300 , 20);
		   window.add(b3Label);
		   
		   showReport.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				ShowReport report = new ShowReport();
				report.component();
				dispose();
			}
			   
		   });
		   exit = new JButton("Exit");
		   exit .setBounds(900 , 600 , 90 , 25);
		   window.add(exit );
		   
		   exit.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					
				}
				   
			   });
		   
		   back = new JButton("Back");
		   back .setBounds(200 , 600 , 90 , 25);
		   window.add(back );
		   
		   back.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					 StartUp obj = new StartUp();
					   obj.startUp();
					dispose();
										
				}
				   
			   });
		   
		   setDefaultCloseOperation(EXIT_ON_CLOSE);
		   setVisible(true);
	}
}
