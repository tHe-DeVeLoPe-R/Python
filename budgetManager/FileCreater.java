import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;  

public class FileCreater extends JFrame {

static File file1 = new File("total.txt");
static File file3 = new File("food.txt");
static File file2 = new File("stat.txt");
static File file4 = new File("others.txt");
static File file5 = new File("totalRem.txt");
static File file6 = new File("foodRem.txt");
static File file7 = new File("statRem.txt");
static File file8 = new File("otherRem.txt");
static File file9 = new File("thr.txt");

static File check = new File("user.txt");
static boolean result;
static boolean existance1;
static boolean existance2;
static boolean existance3;
static boolean existance4;
static boolean existance5;
static boolean existance6;
static boolean existance7;
static boolean existance8;
static boolean existance; 
public static boolean fileCheck() {
	
	
		try {
			existance1 = file1.createNewFile();
			
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			existance2 = file2.createNewFile();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			existance3 = file3.createNewFile();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			existance4 = file4.createNewFile();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			existance5 = file5.createNewFile();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			existance6 = file6.createNewFile();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			existance7 = file7.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			existance8 = file8.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(existance1 && existance2 && existance2 && existance4 && existance5 && 
				existance6 && existance7 && existance8) {
			existance = true;
		}else {
			existance = false;
		}
	
	return existance;
	
}
public static void Visuals() {

	  
	   //--------------- file 1 ------------
		  try {
			 
				  FileWriter writeTotal = new FileWriter(file1);
				  writeTotal.write("0");
				  writeTotal.close();
			 
		  }catch(IOException e) {
			  System.out.print("catched");
		  }
		  
		  //---------- file2 -------
		  
		  try {
			 
				  
				  FileWriter writeStat = new FileWriter("stat.txt");
				  writeStat.write("0");
				  writeStat.close();
			  
		  }catch(IOException e) {
			  System.out.print("catched");
		  }

		//--------------- file 3 ------------
		  try {
			  
				  FileWriter writeFood = new FileWriter("food.txt");
				  writeFood.write("0");
				  writeFood.close();
			 
		  }catch(IOException e) {
			  System.out.print("catched");
		  }
		  
		//--------------- file 4 ------------
		  try {
			
				  FileWriter writeOther = new FileWriter("others.txt");
				  writeOther.write("0");
			      writeOther.close();
		  }catch(IOException e) {
			  System.out.print("catched");
		  }
		  
		//--------------- file 5 ------------
		  try {
			 
				  FileWriter writeTotalRem = new FileWriter("totalRem.txt");
				  writeTotalRem.write("0");
				  writeTotalRem.close();
			
		  }catch(IOException e) {
			  System.out.print("catched");
		  }
		  
		//--------------- file 6 ------------
		  try {
			 
				  
				  FileWriter writeFoodRem = new FileWriter("foodRem.txt");
				  writeFoodRem.write("0");
				  writeFoodRem.close();
			  
		  }catch(IOException e) {
			  System.out.print("catched");
		  }
		  
		//--------------- file 7 ------------
		  try {
			  
				  FileWriter writeStatRem = new FileWriter("statRem.txt");
				  writeStatRem.write("0");
				  writeStatRem.close();
			  
		  }catch(IOException e) {
			  System.out.print("catched");
		  }
		  
		//--------------- file 8 ------------
		  try {
			  
			  
				  FileWriter writeOtherRem = new FileWriter("otherRem.txt");
				  writeOtherRem.write("0");
				  writeOtherRem.close();
			 
		  }catch(IOException e) {
			  System.out.print("catched");
		  }
		  
		//--------------- file 9 ------------
		  try {
			
			  
				  FileWriter writethr = new FileWriter("thr.txt");
				  writethr.write("0");
				  writethr.close();
			 
		  }catch(IOException e) {
			  System.out.print("catched");
		  }
		  
		  //------------- user ----------
		  
		  try {
			  
				  FileWriter addUser = new FileWriter("user.txt");
				  addUser.write("true");
				  addUser.close();
			 
		  }catch(IOException e) {
			  System.out.print("catched");
		  }
	
		
}


}
