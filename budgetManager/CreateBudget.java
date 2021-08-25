import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class CreateBudget extends JFrame {
  JLabel heading , total , food , stat , other , detail , warning;
  JTextField totalValue , foodValue , statValue , otherValue;
  JButton create , back , exit ;
  Container window = getContentPane();
  Cursor cursor = new Cursor(Cursor.TEXT_CURSOR);
  File ftotal = new File("total.txt");
  public void components() {
	  setLayout(null);
	   setResizable(false);
	   window.setBackground(new Color(170 , 150 , 190));
	   setBounds(-10 , 0 , 1900 , 800);
	  
	   heading = new JLabel("CREATE YOUR BUDGET HERE");
	   heading.setBounds(500, 20, 500, 50);
	   heading.setFont(new Font(Font.MONOSPACED , Font.BOLD , 20 ));
	   window.add(heading);
	   
	   detail = new JLabel("=> Total is the total budget/amount you have for this month"
	   		+ "   => Food , stationery , others are the amounts you want to assign to food , "
	   		+ " stationery and others respectively from  total amount. ");
	   detail.setBounds(50 , 90 , 1500 , 20);
	   detail.setFont(new Font(Font.DIALOG , Font.BOLD , 13));
	   window.add(detail);
	   
	   total = new JLabel("Enter Total Amount You Have For This Month : ");
	   total.setBounds(200 , 160 , 500 , 20);
	   total.setFont(new Font(Font.DIALOG , Font.BOLD , 13));
	   window.add(total);
	   
	   totalValue = new JTextField();
	   totalValue.setBounds(500 , 160 , 160 , 23);
	   totalValue.setBorder(null);
	   totalValue.setFont(new Font(Font.DIALOG , Font.PLAIN, 13));
	   totalValue.setCursor(cursor);
	   totalValue.setText("0");
	   window.add(totalValue);
	   
	   food = new JLabel("How many percent of total you wanted for food : ");
	   food.setBounds(190 , 220 , 500 , 20);
	   food.setFont(new Font(Font.DIALOG , Font.BOLD , 13));
	   window.add(food);
	   
	   foodValue = new JTextField();
	   foodValue.setBounds(500 , 220 , 160 , 23);
	   foodValue.setBorder(null);
	   foodValue.setFont(new Font(Font.DIALOG , Font.PLAIN, 13));
	   foodValue.setCursor(cursor);
	   foodValue.setText("0");
	   window.add(foodValue);
	   
	   stat = new JLabel("How many percent of total you wanted for stat. : ");
	   stat.setBounds(190 , 280 , 500 , 20);
	   stat.setFont(new Font(Font.DIALOG , Font.BOLD , 13));
	   window.add(stat);
	   
	   statValue = new JTextField();
	   statValue.setBounds(500 , 280 , 160 , 23);
	   statValue.setBorder(null);
	   statValue.setFont(new Font(Font.DIALOG , Font.PLAIN, 13));
	   statValue.setCursor(cursor);
	   statValue.setText("0");
	   window.add(statValue);
	   
	   warning = new JLabel("warning amount is the amount after which you will start"
	   		+ " recieving warning notifications. For examples if you have set warning amount 100"
	   		+ " then when you are left with amount less than 100 you will recieve notifications about this");
	   
	   warning.setForeground(Color.white);
	   warning.setBounds(10 , 50 , 1700 , 25 );
	   window.add(warning);
	   
	   other = new JLabel("How many percent of total you wanted for other. : ");
	   other.setBounds(190 , 340 , 500 , 20);
	   other.setFont(new Font(Font.DIALOG , Font.BOLD , 13));
	   window.add(other);
	   
	   otherValue = new JTextField();
	   otherValue.setBounds(500 , 340 , 160 , 23);
	   otherValue.setBorder(null);
	   otherValue.setFont(new Font(Font.DIALOG , Font.PLAIN, 13));
	   otherValue.setCursor(cursor);
	   otherValue.setText("0");
	   window.add(otherValue);
	   
	   create = new JButton("Click to Create");
	   create.setBounds(500 , 400 , 130 , 30);
	   create.setBackground(Color.WHITE);
	   create.setCursor(new Cursor(Cursor.HAND_CURSOR));
	   //create.setBorder(null);
	   window.add(create);
	   
	   create.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			warnings();		
			String thresh_hold;
	thresh_hold = JOptionPane.showInputDialog("Set warning value if not then enter 0: ");
	try {
		FileWriter thresh = new FileWriter("thr.txt");
		if(thresh_hold == " ") {
			thresh.write("0");
		}else {
			thresh.write(thresh_hold);
		}
		
		thresh.close();
		
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
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
				 Home obj = new Home();
				   obj.home();
				dispose();
									
			}
			   
		   });
	   
	   
	   setDefaultCloseOperation(EXIT_ON_CLOSE);
	   setVisible(true);
	  
  }
  
  public void warnings() {
	
	  double getFood , getStat , getOther , getTotal;
	  double intFood , intStat , intOther , intTotal;
	  
	  try {
		  getFood = Integer.parseInt(foodValue.getText());
		  getTotal  = Integer.parseInt(totalValue.getText());
		  getStat  = Integer.parseInt(statValue.getText());
		  getOther  = Integer.parseInt(otherValue.getText());
		  double sum = getFood+getStat+getOther;
				  
		  intFood  = Double.valueOf(foodValue.getText())/100 *(getTotal);
		  intStat  = Double.valueOf(statValue.getText())/100 * (getTotal);
		  intOther  = Double.valueOf(otherValue.getText())/100 * (getTotal);
		 
		 		  
		  if(sum !=100) {
			
			  JOptionPane.showMessageDialog(this, "Warning Wrong percentages entered"
			  		+ " Sum of assigned percentages should be equal to 100", "Alert" , 
			  		JOptionPane.WARNING_MESSAGE);
				    
		  }else if(intFood <0 || intStat <0 || intOther<0 || getTotal<0) {
		JOptionPane.showMessageDialog(this, "Warning!! negative values are not allowed"
					  , "Alert" , JOptionPane.WARNING_MESSAGE);
		  }else {
		  try {
			  
			 			  
			  FileWriter ftotal = new FileWriter("total.txt"); 
			  ftotal.write(String.valueOf(getTotal));
			  ftotal.close();
			  
			  FileWriter frstat = new FileWriter("statRem.txt");
			  frstat.write("0");
			  frstat.close();
			  
			  FileWriter fstat = new FileWriter("stat.txt"); 
			  fstat.write(String.valueOf(intStat));
			  fstat.close();
			  
			  
			  FileWriter frother = new FileWriter("otherRem.txt");
			  frother.write("0");
			  frother.close();
			  
			  FileWriter fother = new FileWriter("others.txt"); 
			  fother.write(String.valueOf(intOther));
			  fother.close();
			  
			  FileWriter frfood = new FileWriter("foodRem.txt");
			  frfood.write("0");
			  frfood.close();
			  
			  FileWriter ffood = new FileWriter("food.txt"); 
			  ffood.write(String.valueOf(intFood));
			  ffood.close();
			  
			  
			  
			JOptionPane.showMessageDialog(this, "Congrats!   Budget Created Successfully :)");
		  }catch(IOException e) {
			  JOptionPane.showMessageDialog(this, "!!!!!!   Files Not Found");
		  }
		   
		  }
		  
	  }catch(NumberFormatException e) {
		  JOptionPane.showMessageDialog(this, "Do not use special chracters in input"
		  		+ " only use (0-9) , do not use % sign only enter values" , "Alert" ,
		  		JOptionPane.WARNING_MESSAGE);
		  
	  } 
	 
	  	  
  }
}
