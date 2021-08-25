
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class ShowReport extends JFrame {
JLabel heading , foodHeading , statHeading , otherHeading ,  foodLabel1 , foodLabel2
, statLabel1 , statLabel2 , otherLabel1 , otherLabel2 , status;
JLabel f1Result , f2Result , s1Result , s2Result , o1Result , o2Result , statusResult
 , total , extra , expensed;
JButton exit , back;
Container window = getContentPane();

public void component() {
	 setLayout(null);
	   setResizable(false);
	   window.setBackground(new Color(170 , 150 , 190));
	   setBounds(-10 , 0 , 1900 , 800);
	  
	   heading = new JLabel("HERE IS YOUR SYSTEM GENERATED REPORT");
	   heading.setBounds(500, 20, 500, 50);
	   heading.setFont(new Font(Font.MONOSPACED , Font.BOLD , 20 ));
	   window.add(heading);
	   
	   foodHeading = new JLabel("FOOD:");
	   foodHeading.setBounds(170, 100, 150, 50);
	   foodHeading.setFont(new Font(Font.MONOSPACED , Font.BOLD , 20 ));
	   window.add(foodHeading);
	   
	   foodLabel1 = new JLabel("Total you have had for food : ");
	   foodLabel1.setBounds(200 , 150 , 330 , 20);
	   foodLabel1.setFont(new Font(Font.DIALOG_INPUT , Font.ITALIC , 15));
	   
	   foodLabel1.setForeground(Color.WHITE);
	   window.add(foodLabel1);
	   
	   f1Result = new JLabel("result");
	   f1Result.setBounds(550 , 150 , 100, 20);
	   window.add(f1Result);
	   
	   foodLabel2 = new JLabel("Total you have expensed in food : ");
	   foodLabel2.setBounds(200 , 190 , 330 , 20);
	   foodLabel2.setFont(new Font(Font.DIALOG_INPUT , Font.PLAIN , 15));
	   
	   foodLabel2.setForeground(Color.WHITE);
	   window.add(foodLabel2);
	   

	   f2Result = new JLabel("result");
	   f2Result.setBounds(550 , 190 , 100, 20);
	   window.add(f2Result);
	   
	   double t = 0;
	   try {
		FileReader food = new FileReader("food.txt");
		Scanner s0 = new Scanner(food);
		double f = s0.nextDouble();
		
		FileReader stat = new FileReader("stat.txt");
		Scanner s1 = new Scanner(stat);
		double s = s1.nextDouble();
		
		FileReader other = new FileReader("others.txt");
		Scanner s2 = new Scanner(other);
		double o = s2.nextDouble();
		
		t = f+s+o;
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	   total = new JLabel("Total Was :      "+t);
	   total.setBounds(900 , 195 , 250 , 20);
	   total.setFont(new Font(Font.SANS_SERIF , Font.BOLD , 20));
	   window.add(total);
	   
	   
	   double e = 0;
	   try {
		FileReader foodex = new FileReader("foodRem.txt");
		Scanner s100 = new Scanner(foodex);
		double ef = s100.nextDouble();
		
		FileReader statex = new FileReader("statRem.txt");
		Scanner s200 = new Scanner(statex);
		double es = s200.nextDouble();
		
		FileReader otherex = new FileReader("otherRem.txt");
		Scanner s300 = new Scanner(otherex);
		double eo = s300.nextDouble();
		
		e = ef+es+eo;
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	   
	   expensed = new JLabel("Expensed :      "+e);
	   expensed.setBounds(900 , 235 , 250 , 20);
	   expensed.setFont(new Font(Font.SANS_SERIF , Font.BOLD , 20));
	   window.add(expensed);
	   
	   double extras = e-t;
	   extra = new JLabel("Extras :      "+extras);
	   extra.setBounds(900 , 285 , 200 , 20);
	   extra.setFont(new Font(Font.SANS_SERIF , Font.BOLD , 20));
	   window.add(extra);
	   if(extras <0) {
		   double saved = t-e;
		   extra.setText("Saved :     "+saved);
	   }
		  
	   
	   statHeading = new JLabel("STATIONERY:");
	   statHeading.setBounds(170, 215, 150, 50);
	   statHeading.setFont(new Font(Font.MONOSPACED , Font.BOLD , 20 ));
	   window.add(statHeading);
	   
	   statLabel1 = new JLabel("Total you have had for stationery : ");
	   statLabel1.setBounds(200 , 255 , 330 , 20);
	   statLabel1.setFont(new Font(Font.DIALOG_INPUT , Font.ITALIC , 15));
	   
	   statLabel1.setForeground(Color.WHITE);
	   window.add(statLabel1);
	   

	   s1Result = new JLabel("result");
	   s1Result.setBounds(550 , 255 , 100, 20);
	   window.add(s1Result);
	   
	   statLabel2 = new JLabel("Total you have expensed in stationery : ");
	   statLabel2.setBounds(200 , 295 , 360 , 20);
	   statLabel2.setFont(new Font(Font.DIALOG_INPUT , Font.PLAIN , 15));
	   
	   statLabel2.setForeground(Color.WHITE);
	   window.add(statLabel2);
	   
	   

	   s2Result = new JLabel("result");
	   s2Result.setBounds(570 , 295 , 100, 20);
	   window.add(s2Result);
	   
	   
	   otherHeading = new JLabel("OTHERS:");
	   otherHeading.setBounds(170, 325, 150, 50);
	   otherHeading.setFont(new Font(Font.MONOSPACED , Font.BOLD , 20 ));
	   window.add(otherHeading);
	   
	   
	   otherLabel1 = new JLabel("Total you have had for other : ");
	   otherLabel1.setBounds(200 , 385 , 330 , 20);
	   otherLabel1.setFont(new Font(Font.DIALOG_INPUT , Font.ITALIC , 15));
	   
	   otherLabel1.setForeground(Color.WHITE);
	   window.add(otherLabel1);
	   

	   o1Result = new JLabel("result");
	   o1Result.setBounds(550 , 385 , 100, 20);
	   window.add(o1Result);
	   
	   otherLabel2 = new JLabel("Total you have expensed in other : ");
	   otherLabel2.setBounds(200 , 420 , 330 , 20);
	   otherLabel2.setFont(new Font(Font.DIALOG_INPUT , Font.ITALIC , 15));
	   
	   otherLabel2.setForeground(Color.WHITE);
	   window.add(otherLabel2);
	   

	   o2Result = new JLabel("result");
	   o2Result.setBounds(550 , 420 , 100, 20);
	   window.add(o2Result);
	   
	   status = new JLabel("Management Status : ");
	   status.setBounds(400 , 500 , 330 , 30);
	   status.setFont(new Font(Font.SANS_SERIF , Font.BOLD , 25));
	   
	   window.add(status);
	   

	   statusResult = new JLabel("result");
	   statusResult.setBounds(670 , 505 , 100, 20);
	   window.add(statusResult);
	   
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
	   setValues();
	   setDefaultCloseOperation(EXIT_ON_CLOSE);
	   setVisible(true);
}
public void setValues() {
	try {
		FileReader fileFood = new FileReader("food.txt") ;
		  Scanner scanner0 = new Scanner(fileFood);
		  double result = scanner0.nextDouble();
		  f1Result.setText(String.valueOf(result));
		  //fileFood.close();
		  
		  FileReader fileFoodRem = new FileReader("foodRem.txt") ;
		  Scanner scanner1 = new Scanner(fileFoodRem);
		  double result1 = scanner1.nextDouble();
		  f2Result.setText(String.valueOf(result1));
		  
		  FileReader fileStat = new FileReader("stat.txt") ;
		  Scanner scanner2 = new Scanner(fileStat);
		  double result2 = scanner2.nextDouble();
		  s1Result.setText(String.valueOf(result2));
		  
		  FileReader fileStatRem = new FileReader("statRem.txt") ;
		  Scanner scanner3 = new Scanner(fileStatRem);
		  double result3 = scanner3.nextDouble();
		  s2Result.setText(String.valueOf(result3));
		  
		  FileReader fileOther = new FileReader("others.txt") ;
		  Scanner scanner4 = new Scanner(fileOther);
		  double result4 = scanner4.nextDouble();
		  o1Result.setText(String.valueOf(result4));
		  
		  FileReader fileOtherRem = new FileReader("otherRem.txt") ;
		  Scanner scanner5 = new Scanner(fileOtherRem);
		  double result5 = scanner5.nextDouble();
		  o2Result.setText(String.valueOf(result5));
		  
		  double assigned , expensed;
		  assigned = result + result2 + result4 ;
		  expensed = result1+result3+result5;
		  if( assigned > expensed  || assigned == expensed ) {
			  statusResult.setText("GOOD");
			  statusResult.setFont(new Font(Font.SANS_SERIF , Font.BOLD , 15));
		  }else {
			  statusResult.setText("NOT GOOD");
			  statusResult.setFont(new Font(Font.SANS_SERIF , Font.BOLD , 15));
		  }
		 
		
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
