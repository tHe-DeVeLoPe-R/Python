import java.awt.*;
import java.awt.event.*;

import java.io.*;
import java.util.*;

import javax.swing.*;

public class AddExpenses extends JFrame{
 JLabel heading , addFood , addStat , addOther;
 JButton add , exit , back;
 JTextField getFood , getStat , getOther;
 Container window = getContentPane();
 Cursor cursor = new Cursor(Cursor.TEXT_CURSOR);
 public void components() {
	 setLayout(null);
	   setResizable(false);
	   window.setBackground(new Color(170 , 150 , 190));
	   setBounds(-10 , 0 , 1900 , 800);
	  
	   heading = new JLabel("ADD YOUR EXPENSES HERE");
	   heading.setBounds(500, 20, 500, 50);
	   heading.setFont(new Font(Font.MONOSPACED , Font.BOLD , 20 ));
	   window.add(heading);
	  
	 	   
	   addFood = new JLabel("How many percent of total you wanted for food : ");
	   addFood.setBounds(190 , 220 , 500 , 20);
	   addFood.setFont(new Font(Font.DIALOG , Font.BOLD , 13));
	   window.add(addFood);
	   
	   getFood = new JTextField();
	   getFood.setBounds(500 , 220 , 160 , 23);
	   getFood.setBorder(null);
	   getFood.setFont(new Font(Font.DIALOG , Font.PLAIN, 13));
	   getFood.setCursor(cursor);
	   getFood.setText("0");
	   window.add(getFood);
	   
	   addStat = new JLabel("How many percent of total you wanted for stat. : ");
	   addStat.setBounds(190 , 280 , 500 , 20);
	   addStat.setFont(new Font(Font.DIALOG , Font.BOLD , 13));
	   window.add(addStat);
	   
	   getStat = new JTextField();
	   getStat.setBounds(500 , 280 , 160 , 23);
	   getStat.setBorder(null);
	   getStat.setFont(new Font(Font.DIALOG , Font.PLAIN, 13));
	   getStat.setCursor(cursor);
	   getStat.setText("0");
	   window.add(getStat);
	   
	   addOther = new JLabel("How many percent of total you wanted for other. : ");
	   addOther.setBounds(190 , 340 , 500 , 20);
	   addOther.setFont(new Font(Font.DIALOG , Font.BOLD , 13));
	   window.add(addOther);
	   
	   getOther = new JTextField();
	   getOther.setBounds(500 , 340 , 160 , 23);
	   getOther.setBorder(null);
	   getOther.setFont(new Font(Font.DIALOG , Font.PLAIN, 13));
	   getOther.setCursor(cursor);
	   getOther.setText("0");
	   window.add(getOther);
	   
	   add = new JButton("Click to Add");
	   add.setBounds(500 , 400 , 130 , 30);
	   add.setBackground(Color.WHITE);
	   add.setCursor(new Cursor(Cursor.HAND_CURSOR));
	   //create.setBorder(null);
	   window.add(add);
	   
	   add.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			adder();
			
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
 
 public void adder() {
	 
	 double food , stat , other;
	  double intFood , intStat , intOther , intTotal;
	  
	  try {
		  food = Integer.parseInt(getFood.getText());
		  stat  = Integer.parseInt(getStat.getText());
		  other  = Integer.parseInt(getOther.getText());
				  
		 		  
	    if(food <0 || stat <0 || other<0) {
		JOptionPane.showMessageDialog(this, "Warning!! negative values are not allowed"
					  , "Alert" , JOptionPane.WARNING_MESSAGE);
		  }else {
		  try {
			  
			  //----------- HANDLING STATIONERY ----------
			  
			  FileReader fileStat = new FileReader("stat.txt") ;
			  Scanner scanner0 = new Scanner(fileStat);
			  double dataStat = scanner0.nextDouble();
			  fileStat.close();
		      
			  
			  FileReader fileStatRem = new FileReader("statRem.txt");
			  Scanner scanner1 = new Scanner(fileStatRem);
			  double data1 = scanner1.nextDouble();
			  fileStatRem.close();
		      double newData = data1 + stat;
		     
		      if(newData > dataStat)   {
	    		  
	  JOptionPane.showMessageDialog(this, "WARNING!!  YOU ARE OVER-EXPENSING IN STATIONERY SESSION "
	  		+ " NO AMOUNT LEFT IN THIS SESSION Extra WILL BE CONSIDER AS EXTRAS" , 
			  "Alert" ,JOptionPane.WARNING_MESSAGE);
		      } else {
		    	  FileReader thd = new FileReader("thr.txt");
		    	  Scanner scan = new Scanner(thd);
		    	  double thold0 = scan.nextDouble();
		    	  
		    	  if(dataStat - newData <= thold0){
		    		  double left = dataStat-newData;
		    JOptionPane.showMessageDialog(this, "WARNING!!  "+ left+"Rs. AMOUNT IN STATIONERY"
		    		+ " SESSION IS LEFT" , "Alert" ,JOptionPane.WARNING_MESSAGE);
		    	  }
		      }
		    	 		    			  
		    FileWriter fstat = new FileWriter("statRem.txt"); 
		    	    fstat.write(String.valueOf(newData));
		    		    	  fstat.close(); 
	  
		    	  	    		
		    	  
	    	  
		    	  
	
			  // HANDLING OTHER ----------------
		      
		      FileReader fileOther = new FileReader("others.txt") ;
			  Scanner scanner2 = new Scanner(fileOther);
			  double dataOther = scanner2.nextDouble();
			  fileOther.close();
		      
			  
			  FileReader fileOtherRem = new FileReader("otherRem.txt");
			  Scanner scanner3 = new Scanner(fileOtherRem);
			  double data2 = scanner3.nextDouble();
			  fileOtherRem.close();
		      double newData1 = data2 + other;
		     
		      if(newData1 > dataOther)   {
	    		  
	 JOptionPane.showMessageDialog(this, "WARNING!!  YOU ARE OVER-EXPENSING IN OTHER'S SESSION "
			+ " NO AMOUNT LEFT IN THIS SESSION Extra WILL BE CONSIDER AS EXTRAS" , 
		  "Alert" ,JOptionPane.WARNING_MESSAGE);
		    			     
		      } else {
		    	  FileReader thd = new FileReader("thr.txt");
		    	  Scanner scan = new Scanner(thd);
		    	  double thold = scan.nextDouble();
		    	  
		    	  if(dataOther - newData1 <= thold){
		    		  double left1 = dataOther-newData1;
		    JOptionPane.showMessageDialog(this, "WARNING!!  "+ left1+"Rs. AMOUNT IN OTHERS"
		    		+ " SESSION IS LEFT" , "Alert" ,JOptionPane.WARNING_MESSAGE);
		    	  }		
		      }
		    	  	    			  
		    FileWriter fother = new FileWriter("otherRem.txt"); 
		    	    fother.write(String.valueOf(newData1));
		    		    	  fother.close(); 
	  
		    	  		    		
		    	  
	    	  
		    	 
			  // HANDLING FOOD SESSION -----------------
		      
		      FileReader fileFood = new FileReader("food.txt") ;
			  Scanner scanner4 = new Scanner(fileFood);
			  double dataFood = scanner4.nextDouble();
			  fileFood.close();
		      
			  
			  FileReader fileFoodRem = new FileReader("foodRem.txt");
			  Scanner scanner5 = new Scanner(fileFoodRem);
			  double data3 = scanner5.nextDouble();
			  
		      double newData3 = data3 + food;
		     
		      if(newData3 > dataFood)   {
	    		  
	  JOptionPane.showMessageDialog(this, "WARNING!!  YOU ARE OVER-EXPENSING IN FOOD SESSION "
	  		+ " NO AMOUNT LEFT IN THIS SESSION Extra WILL BE CONSIDER AS EXTRAS" , 
		    	  "Alert" ,JOptionPane.WARNING_MESSAGE);
		    			      }  
		      else {
		    	  FileReader thd = new FileReader("thr.txt");
		    	  Scanner scan = new Scanner(thd);
		    	  double thold1 = scan.nextDouble();
					/*
					 * System.out.println("new data = "+newData3);
					 * System.out.println("thr = "+thold1); double x = dataFood - newData3;
					 * System.out.println("new data minus = "+x);
					 */
		    	  if(dataFood - newData3 <= thold1){
		    		  double left2 = dataFood-newData3;
		    JOptionPane.showMessageDialog(this, "WARNING!!  "+ left2+"Rs. AMOUNT IN FOOD"
		    		+ " SESSION IS LEFT" , "Alert" ,JOptionPane.WARNING_MESSAGE);
		    	  }	
		      }
		    	  		    			  
		    FileWriter ffood = new FileWriter("foodRem.txt"); 
		    	    ffood.write(String.valueOf(newData3));
		    		    	  ffood.close(); 
	  
		    			    		
		    	  
	    	  
			  
			  
			JOptionPane.showMessageDialog(this, " Request completed Successfully :)");
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
