import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.*;
import java.sql.*;
public class Home extends JFrame {
	JLabel heading , developer;
	Connection con;
	Statement run ;
	static String name;
	static String number;
	static String preName;
	JButton add , edit , delete  , display , exit;
	Container window = getContentPane();

	public static void main(String[] args) {
		Home home = new Home();
		home.guiComponents();
	}

	void guiComponents() {
		setLayout(null);
		setResizable(false);
		window.setBackground(new Color(170 , 150 , 190));
		setBounds(-10 , 0 , 1900 , 800);

		heading = new JLabel("JAVA PHONE BOOK :)");
		heading.setBounds(500, 20, 500, 50);
		heading.setFont(new Font(Font.DIALOG_INPUT , Font.BOLD , 35));
		//heading.setFont(new Font(Font.MONOSPACED , Font.BOLD , 20 ));
		window.add(heading);

		developer = new JLabel(" About Developer ?");
		developer.setBounds(520, 80, 500, 50);
		developer.setFont(new Font(Font.DIALOG_INPUT , Font.BOLD , 15));
		//developer.setFont(new Font(Font.MONOSPACED , Font.BOLD , 13 ));
		developer.setForeground(Color.BLUE);
		window.add(developer);

		add = new JButton("ADD      NEW     CONTACT");
		add.setBounds(400 , 200 , 500 , 40);
		add.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add.setFont(new Font(Font.DIALOG_INPUT , Font.BOLD , 15));
		add.setBorder(null);
		add.setFocusPainted(false);
		window.add(add);

		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				name = JOptionPane.showInputDialog("Enter name below: ");
				name = name.toLowerCase();
				number = JOptionPane.showInputDialog("Enter number below: ");
				addContact();

			}

		});

		edit = new JButton("EDIT    EXISTING     CONTACT");
		edit.setBounds(400 , 300 , 500 , 40);
		edit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		edit.setFont(new Font(Font.DIALOG_INPUT , Font.BOLD , 15));
		edit.setBorder(null);
		edit.setFocusPainted(false);
		window.add(edit);

		edit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				preName= JOptionPane.showInputDialog("Enter name of contact which you want to update: ");


				boolean found = editContact();
				if(found == true) {
					name = JOptionPane.showInputDialog("Enter new name below: (if do not want to change name write the previous one)");
					name = name.toLowerCase();
					number = JOptionPane.showInputDialog("Enter new number below:  (if do not want to change number write the previous one)");

					String query1 = "update phone_record set c_name = '"+name+"' , p_number = '"+number+"' where c_name = '"+preName+"';";
					try {
						int rows= run.executeUpdate(query1);

						if(rows > 0) {
							JOptionPane.showInternalMessageDialog(window, "contact updated");
						}else {
							JOptionPane.showInternalMessageDialog(window , "something error occured");
						}

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}

		});

		delete = new JButton("DELETE    EXISTING     CONTACT");
		delete.setBounds(400 , 400 , 500 , 40);
		delete.setCursor(new Cursor(Cursor.HAND_CURSOR));
		delete.setFont(new Font(Font.DIALOG_INPUT , Font.BOLD , 15));
		delete.setBorder(null);
		delete.setFocusPainted(false);
		window.add(delete);

		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				name = JOptionPane.showInputDialog("Enter name below: ");
				name = name.toLowerCase();

				deleteContact();

			}

		});

		display = new JButton("SEARCH   CONTACT   LIST");
		display.setBounds(400 , 500 , 500 , 40);
		display.setCursor(new Cursor(Cursor.HAND_CURSOR));
		display.setFont(new Font(Font.DIALOG_INPUT , Font.BOLD , 15));
		display.setBorder(null);
		display.setFocusPainted(false);
		window.add(display);

		display.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				name = JOptionPane.showInputDialog("Enter name below: ");
				name = name.toLowerCase();

				displayContact();

			}

		});

		exit = new JButton("EXIT    JAVA    PHONEBOOK");
		exit.setBounds(400 , 600 , 500 , 40);
		exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		exit.setFont(new Font(Font.DIALOG_INPUT , Font.BOLD , 15));
		exit.setBorder(null);
		exit.setFocusPainted(false);
		window.add(exit);


		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();

			}

		});

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	void databaseControl() {

		String url = "jdbc:mysql://localhost:3306/phonebook";
		String user = "root";
		String pass = "root";
		Connection con;

		try {

			Class.forName("com.mysql.jdbc.Driver");


		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		try {

			con = DriverManager.getConnection(url, user, pass);
			run = con.createStatement();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}


	void addContact() {
		databaseControl();
		boolean check0 = true , check1 = true , reCheck1 = true , reCheck2 = true;
		if(number.length() !=11 && number.length() !=13) {

			JOptionPane.showMessageDialog(this, "Wrong number entered length should be 11 or 13");
			check0 = false;
		}else {

			for(int i=0;i<number.length();i++) {
				if(number.charAt(i)-48 >=0 && number.charAt(i)-48<=56 || number.charAt(i) == 43) {
					check1 = true;
				}else {
					check1 = false;
					break;

				}


			}

		}

		if(check1 == false) {
			JOptionPane.showMessageDialog(this, "Wrong number entered you can only use (+ , 0-9 letters) ");
		}

		if(check0 == true && check1 == true) {
			String duplicateNameCheck = "select * from phone_record where c_name = '"+name+"'";
			String duplicateNumberCheck = "select * from phone_record where p_number = '"+number+"'";
			try {
				ResultSet array = run.executeQuery(duplicateNameCheck);

				while(array.next()) {

					if(array.getInt("sr_no")>0) {
						JOptionPane.showMessageDialog(this, "name already exists");
						reCheck1 = false;
						break;
					}

				}

				ResultSet array2 = run.executeQuery(duplicateNumberCheck);
				while(array2.next()) {

					if(array2.getInt("sr_no")>0) {
						JOptionPane.showMessageDialog(this, "number already exists");
						reCheck2 = false;
						break;
					}

				}

				if(reCheck1 == true && reCheck2 == true) {
					String query = "insert into phone_record (c_name , p_number)values('"+name+"' , '"+number+"')";
					int rows = run.executeUpdate(query);
					JOptionPane.showMessageDialog(this, "contact added successfully");
				}

			} 


			catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}


		}
	}


	boolean editContact() {
		databaseControl();

		boolean found = false;
		String query0 = "select * from phone_record where c_name = '"+preName+"'";
		try {
			ResultSet array = run.executeQuery(query0);

			while(array.next()) {
				if(array.getInt("sr_no") > 0) {
					found = true;
					break;					
				}
			}
			if(found == false) {
				JOptionPane.showMessageDialog(this, "contact against this name  not found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		return found;
	}


	void deleteContact() {
		databaseControl();
		String query = "DELETE  FROM phone_record where c_name = '"+name+"'";
		try {
			int rows = run.executeUpdate(query);
			if(rows == 0) {
				JOptionPane.showMessageDialog(this, "unable to delete no record found against this name");
			}else {
				JOptionPane.showMessageDialog(this, "contact deleted successfully!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	void displayContact() {
		databaseControl();
		boolean display = false;
		String sql = "select * from phone_record where c_name = '"+name+"'";

		try {
			ResultSet structure = run.executeQuery(sql);

			while(structure.next()) {

				if(structure.getInt("sr_no") > 0) {

					display = true;
					break;

				}
			}

			if(display == true) {

				JOptionPane.showMessageDialog(window ,"contact found:"+"\n\nNAME  :  "+structure.getString("c_name")+"\nNUMBER  :  "+structure.getString("p_number")+"\n\n--------------- congrats ----------------\n");

			}else {
				JOptionPane.showMessageDialog(window, "contact not found against given name");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
