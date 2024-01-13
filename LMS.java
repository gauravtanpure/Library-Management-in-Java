import java.awt.*;
import java.lang.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JTable.*;
import javax.swing.table.DefaultTableModel;


public class LMS implements ActionListener,KeyListener,MouseListener
{
	
	
	static JFrame category;
	static JFrame logf ,bookF ,studF,issuF,rtnF;
	static JFrame menu;
	static JButton b4,b5,b6,b7,b8;
	static JButton b9,b10,b11,b12;
	static JButton b13,b14,b15,b16;
	static JButton b17,b18,b19,b20,b25;
	static JButton b21,b22,b23,b24,nabu,nabobu,pribu,retri,retriB,btnlog,cfb;
	static Font f1,f2,f3;
	static JPanel p,p1,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13;
	static JTable jt , jt1 ,jt2,jt3,jt4,jt5,jt6,jt7,jt8;
	static JComboBox cb1;
	static JTextField tf2,tf3,tf4,tf5,tf6,tfun;
	static JTextField tf7,tf8,tf9,tf10;
	static JTextField tf11,tf12,tf13,tf14,tf16;
	static JTextField tf17,tf18,tf19,tf20,tfrd;

	static JTextArea ta1;
	static JTextField dbbo,dbna,dbpri,dbisda,dbrtnda;
	static JLabel lrs,rslt;
	
	
	
	//static JDateChooser datechooser1;
	/*
	   *********************************************************************************
	*/
	
	//Driver function
	

	public static void main(String args[]) 
	{
		menu = new JFrame("menu");
		menu.setVisible(true);
		menu.setLocation(500,50);
		menu.setLayout(null);
		menu.setSize(400,650);
		
		
		JLabel head1 = new JLabel("Library Management System");
	    head1.setBounds(40,5,400,200);
	    f1=new Font("Times New Roman",Font.BOLD,25);
		f2=new Font("Italic",Font.BOLD,25);
		f3=new Font("Times New Roman",Font.BOLD,90);
	    

	    b4 = new JButton("BOOK");
	    b4.setBounds(120,170,150,30);
	
	    JButton b5 = new JButton("STUDENTS");
	    b5.setBounds(120,240,150,30);
	
	    b6 = new JButton("ISSUE BOOK");
	    b6.setBounds(120,310,150,30);
	
	    b7 = new JButton("RETURN BOOK");
	    b7.setBounds(120,380,150,30);
	
	    b8 = new JButton("CLOSE");
	    b8.setBounds(120,450,150,30);
	
		
		head1.setFont(f1);
	    menu.add(head1);
	   // menu.add(b1);
	    //menu.add(b2);
	    //menu.add(b3);
	    menu.add(b4);
	    menu.add(b5);
	    menu.add(b6);
	    menu.add(b7);
	    menu.add(b8);
		
		LMS l1 = new LMS();
		
		b4.addActionListener(l1);
		
		b5.addActionListener(l1);
		
		b6.addActionListener(l1);
		
		b7.addActionListener(l1);
		
		b8.addActionListener(l1);
		
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	

	/*
	   *********************************************************************************
	*/
	
	// book method
	
	public void bookmtd1()
	{
		bookF = new JFrame("books");
		bookF.setVisible(true);
		bookF.setLocation(200,80);
		bookF.setLayout(null);
		bookF.setSize(1000,600); 
		
		JLabel l8 = new JLabel("Books Information");
		l8.setBounds(400,5,250,20);	
		l8.setFont(f1);
		
		
		p6 = new JPanel();
		p6.setLayout(null);
		p6.setBackground(Color.black);
		p6.setSize(959,500);
		p6.setLocation(10,50);
		
		
		p7 = new JPanel();
		p7.setLayout(null);
		p7.setBackground(new Color(102,0,50));
		p7.setBounds(10,10,949,480);
		
        try
		{
          Class.forName("oracle.jdbc.driver.OracleDriver");
		  Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
		  Statement stmt=conn.createStatement();
		  ResultSet rs=stmt.executeQuery("select * from booklms");
		  
		  int rows = 0;
		  while(rs.next())
		  {
			  rows = rows+1;
		  }
		  
		  Statement stmt1=conn.createStatement();
		  ResultSet rs1=stmt.executeQuery("select * from booklms");
		   
		   
		  String cols3[]={"NAME","CATEGORY","ID","PRICE","AUTHOR"};
		
		  String Data3[][]=new String[rows][5];
		  int i = -1;
		  while(rs1.next())
		  {
			  i = i+1;
			  for(int k = 0;k<5;k++)
			  {
				String str1 = rs1.getString(1);
                String str2 = rs1.getString(2);  
                String str3 = rs1.getString(3);  
                String str4 = rs1.getString(4);  
                String str5 = rs1.getString(5);  
				
				Data3[i][k] = str1;
				k=k+1;
				Data3[i][k] = str2;
				k=k+1;
				Data3[i][k] = str3;
				k=k+1;
				Data3[i][k] = str4;
				k=k+1;
				Data3[i][k] = str5;
				k=k+1;
			  }
		  }
		  
		
		  jt3 =new JTable(Data3,cols3);         

		 rs.close();
		  stmt.close(); 
		}
		catch(Exception b)
		{
			System.out.println(b);
		}
		
		   int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		  int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		
		  JScrollPane sp3=new JScrollPane(jt3,v,h);
		  sp3.setBounds(580,150,350,300); 
		bookF.add(sp3);
		bookF.add(p6);
		

		

		JLabel bname = new JLabel("Name:");
		bname.setForeground(Color.yellow);
		bname.setBounds(50,20,80,20);
		bname.setFont(f1);
		
		tf2 = new JTextField();
		tf2.setBounds(200,20,200,30);
		
		//
		
		JLabel c = new JLabel("Category:");
		c.setForeground(Color.yellow);
		c.setBounds(50,70,200,20);
		c.setFont(f1);
		
		tf3 = new JTextField();
		tf3.setBounds(200,70,200,30);
		
		//
		
		JLabel id = new JLabel("Id:");
		id.setForeground(Color.yellow);
		id.setBounds(50,120,200,20);
		id.setFont(f1);
		
		tf4 = new JTextField();
		tf4.setBounds(200,120,200,30);
		
		JLabel price = new JLabel("Price:");
		price.setForeground(Color.yellow);
		price.setBounds(50,170,200,20);
		price.setFont(f1);
		
		tf5 = new JTextField();
		tf5.setBounds(200,170,200,30);
		
		JLabel auth = new JLabel("Author:");
		auth.setForeground(Color.yellow);
		auth.setBounds(50,220,200,20);
		auth.setFont(f1);
		
		tf6 = new JTextField();
		tf6.setBounds(200,220,200,30);
		
		b13 = new JButton("AddB");
		b13.setBounds(40,300,100,50);
		
		b14 = new JButton("UpdateB");
		b14.setBounds(240,300,100,50);
		
		b15 = new JButton("DeleteB");
		b15.setBounds(440,300,100,50);
		
		b16 = new JButton("BackB");
		b16.setBounds(100,380,150,50);
		
		retriB = new JButton("RetriveB");
		retriB.setBounds(300,380,150,50);
		
		JLabel avbo = new JLabel("Available Books : ");
		avbo.setForeground(Color.yellow);
		avbo.setBounds(570,30,500,40);
		avbo.setFont(f1);
		
		b13.addActionListener(this);
		b14.addActionListener(this);
		jt3.addMouseListener(this);
		b15.addActionListener(this);
		b16.addActionListener(this);
		retriB.addActionListener(this);
		
		p6.add(p7);
        p7.add(bname);
		p7.add(tf2);
		p7.add(c);
		p7.add(tf3);
		p7.add(id);
		p7.add(tf4);
		p7.add(price);
		p7.add(tf5);
	
		
		p7.add(auth);
		p7.add(tf6);
		p7.add(b13);
		p7.add(b14);
		p7.add(b15);
		p7.add(b16);
		p7.add(retriB);
		
        p7.add(avbo);
		
		
	}
	
		
	/*
	   *********************************************************************************
	*/
	
	// students method
	
	public void studmtd1()
	{
		studF = new JFrame("student");
		studF.setVisible(true);
		studF.setLocation(200,80);
		studF.setLayout(null);
		studF.setSize(1000,600); 
		
		JLabel l9 = new JLabel("Students");
		l9.setBounds(400,5,250,20);	
		
		p8 = new JPanel();
		p9 = new JPanel();
		 
		 try
		{
          Class.forName("oracle.jdbc.driver.OracleDriver");
		  Connection conn2=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
		  Statement stmt2=conn2.createStatement();
		  ResultSet rs2=stmt2.executeQuery("select * from studentlms");
		  
		  int rows = 0;
		  while(rs2.next())
		  {
			  rows = rows+1;
		  }
		  
		  Statement stmt3=conn2.createStatement();
		  ResultSet rs3=stmt2.executeQuery("select * from studentlms");
		   
		  String cols4[]={"NAME","ADDRESS","ID","PHONENO","EMAIL"};
		
		  String Data4[][]=new String[rows][5];
		   
		   int i = -1;
		  while(rs3.next())
		  {
			  i = i+1;
			  for(int k = 0;k<5;k++)
			  {
				String str6 = rs3.getString(1);
                String str7 = rs3.getString(2);  
                String str8 = rs3.getString(3);  
                String str9 = rs3.getString(4);  
                String str10 = rs3.getString(5);  
				
				Data4[i][k] = str6;
				k=k+1;
				Data4[i][k] = str7;
				k=k+1;
				Data4[i][k] = str8;
				k=k+1;
				Data4[i][k] = str9;
				k=k+1;
				Data4[i][k] = str10;
				k=k+1;
			  }
		  }
               jt4 =new JTable(Data4,cols4);         
		     	 rs2.close();
		       stmt2.close();
        }  		  		  
		
		
		catch(Exception se)
		{
			System.out.println(se);
		}
		

		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		
		JScrollPane sp4=new JScrollPane(jt4,v,h);
		sp4.setBounds(580,150,380,300);   
		studF.add(sp4);
		studF.add(p8);
		
		p8.setBackground(Color.black);
		p8.setSize(959,500);
		p8.setLocation(10,50);
		p8.setLayout(null);
		
		p9.setBackground(new Color(102,0,50));
		//p1.setSize(500,300);
		p9.setBounds(10,10,949,480);
		
		JLabel sname = new JLabel("Name:");
		sname.setForeground(Color.yellow);
		sname.setBounds(50,20,80,20);
		sname.setFont(f1);
		
		tf7 = new JTextField();
		tf7.setBounds(200,20,200,30);
		
		//
		
		JLabel addr = new JLabel("Address:");
		addr.setForeground(Color.yellow);
		addr.setBounds(50,60,200,20);
		addr.setFont(f1);
		
		ta1 = new JTextArea();
		ta1.setBounds(200,60,200,50);
		
		//
		
		JLabel id = new JLabel("Id:");
	    id.setForeground(Color.yellow);
		id.setBounds(50,120,200,20);
		id.setFont(f1);
		
		tf8 = new JTextField();
		tf8.setBounds(200,120,200,30);
		//
		JLabel Pno = new JLabel("Phone No.:");
		Pno.setForeground(Color.yellow);
		Pno.setBounds(50,180,200,20);
		Pno.setFont(f1);
		
		tf9 = new JTextField();
		tf9.setBounds(200,180,200,30);
		
		JLabel eid = new JLabel("Email Id :");
		eid.setForeground(Color.yellow);
		eid.setBounds(50,240,200,20);
		eid.setFont(f1);
		
		tf10 = new JTextField();
		tf10.setBounds(200,240,200,30);
		/*
		JLabel borr = new JLabel("*********Borrow Book*********");
		borr.setBounds(100,170,500,20);
		borr.setFont(f1);
		
		JLabel boname = new JLabel("Name:");
		boname.setBounds(50,220,200,20);
		boname.setFont(f1);
		
		tf9 = new JTextField();
		tf9.setBounds(200,220,200,30);
		
		//***************date***********
		
		JLabel ret = new JLabel("*********Return Book*********");
		ret.setBounds(100,320,500,20);
		ret.setFont(f1);
		
		JLabel rename = new JLabel("Name:");
		rename.setBounds(50,370,200,20);
	    rename.setFont(f1);
		
		tf10 = new JTextField();
		tf10.setBounds(200,370,200,30);
		
		//***************date***********
		*/
		
		b13 = new JButton("AddS");
		b13.setBounds(40,300,100,50);
		
		b14 = new JButton("UpdateS");
		b14.setBounds(240,300,100,50);
		
		b15 = new JButton("DeleteS");
		b15.setBounds(440,300,100,50);
		
		b16 = new JButton("BackS");
		b16.setBounds(150,380,150,50);
		
		retri = new JButton("RetriveS");
		retri.setBounds(360,380,150,50);
		
		JLabel avstu = new JLabel("    Available Students :       ");
		avstu.setForeground(Color.yellow);
		avstu.setBounds(570,30,500,40);
		avstu.setFont(f1);
		
		b13.addActionListener(this);
		b14.addActionListener(this);
		jt4.addMouseListener(this);
		retri.addActionListener(this);
		b16.addActionListener(this);
		b15.addActionListener(this);
		p8.add(p9);
        p9.setLayout(null);
		p9.add(sname);
		p9.add(tf7);
		p9.add(addr);
		p9.add(ta1);
		p9.add(id);
		p9.add(tf8);
		p9.add(Pno);
		p9.add(tf9);
		p9.add(eid);
		p9.add(tf10);
		p9.add(b13);
		p9.add(retri);
		
		p9.add(b14);
		p9.add(b15);
		p9.add(b16);
		p9.add(avstu);
		//p9.add(tf10);
		
        l9.setFont(f1);
        studF.add(l9);
		
	}
	
		
	/*
	   *********************************************************************************
	*/
	
	// ISSUE BOOK method
	
	public void issumtd()
	{
		issuF = new JFrame("issue book");
		issuF.setVisible(true);
		issuF.setLocation(200,80);
		issuF.setLayout(null);
		issuF.setSize(1000,600); 
		
		JLabel l10 = new JLabel("ISSUE BOOK");
		l10.setBounds(400,5,250,20);
        l10.setFont(f3);		
		l10.setForeground(Color.black);
		
		
		p10 = new JPanel(); //5
		p11= new JPanel();
		 
      try
		{
          Class.forName("oracle.jdbc.driver.OracleDriver");
		  Connection conn2=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
		  Statement stmt2=conn2.createStatement();
		  ResultSet rs2=stmt2.executeQuery("select * from issuebooklms");
		  
		  int rows = 0;
		  while(rs2.next())
		  {
			  rows = rows+1;
		  }
		  
		  Statement stmt3=conn2.createStatement();
		  ResultSet rs3=stmt2.executeQuery("select * from issuebooklms");
		   
		   
		 
		   String cols5[]={"STDID","STDNAME","BOOKID","BNAME","BPRICE","ISSDATE","RETDATE"};
		
		   String Data5[][]=new String[rows][7];
		   
		   int i = -1;
		  while(rs3.next())
		  {
			  i = i+1;
			  for(int k = 0;k<7;k++)
			  {
				String str21 = rs3.getString(1);
                String str22= rs3.getString(2);  
                String str23= rs3.getString(3);  
                String str24= rs3.getString(4);  
                String str25 = rs3.getString(5);
                String str26 = rs3.getString(6);
                String str27 = rs3.getString(7);				
				
				Data5[i][k] = str21;
				k=k+1;
				Data5[i][k] = str22;
				k=k+1;
				Data5[i][k] = str23;
				k=k+1;
				Data5[i][k] = str24;
				k=k+1;
				Data5[i][k] = str25;
				k=k+1;
				Data5[i][k] = str26;
				k=k+1;
				
				Data5[i][k] = str27;
				k=k+1;
			  }
		  }
               jt5 =new JTable(Data5,cols5);         
		     	 rs2.close();
		       stmt2.close();
        }  		  		  
		
		
		
		catch(Exception se)
		{
			System.out.println(se);
		}
		
		
		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		
		JScrollPane sp5=new JScrollPane(jt5,v,h);
		sp5.setBounds(580,150,380,300);   
		issuF.add(sp5);
		issuF.add(p10);
		
		p10.setBackground(Color.black);
		p10.setSize(959,500);
		p10.setLocation(10,50);
		p10.setLayout(null);
		
		p11.setBackground(new Color(102,0,50));
		//p1.setSize(500,300);
		p11.setBounds(10,10,949,480);
		
		JLabel rec = new JLabel("***RECORDS***");
		rec.setBounds(640,30,500,40);
		rec.setFont(f1);
		rec.setForeground(Color.yellow);
		
		JLabel issid = new JLabel("Student Id :");
		issid.setBounds(50,20,180,20);
		issid.setFont(f1);
		issid.setForeground(Color.yellow);
		

		tf11 = new JTextField();
		tf11.setBounds(250,20,200,30);
		//
		
		JLabel issna = new JLabel("Student Name :");
		issna.setBounds(50,60,180,20);
		issna.setFont(f1);
		issna.setForeground(Color.yellow);
		
		dbna = new JTextField();
		dbna.setBounds(250,60,200,30);
		dbna.setEditable(false);
		
		
		//
		
		JLabel issboid = new JLabel("Book Id :");
		issboid.setBounds(50,100,180,20);
		issboid.setFont(f1);
		issboid.setForeground(Color.yellow);
		
		tf13 = new JTextField();
		tf13.setBounds(250,100,200,30);
		
		//
		
		JLabel sd = new JLabel("Book Name :");
		sd.setBounds(50,140,180,20);
		sd.setFont(f1);
		sd.setForeground(Color.yellow);
		
		dbbo = new JTextField();
		dbbo.setBounds(250,140,180,30);
		dbbo.setEditable(false);
	    
		
		//
		
		JLabel isspri = new JLabel("Price :");
		isspri.setBounds(50,180,180,20);
		isspri.setFont(f1);
		isspri.setForeground(Color.yellow);
		
		dbpri = new JTextField();
		dbpri.setBounds(250,180,180,30);
		//dbpri.setEditable(false);
		
	
		
		JLabel issdat = new JLabel("Issue Date :");
		issdat.setBounds(50,220,180,20);
		issdat.setFont(f1);
		issdat.setForeground(Color.yellow);
		
		dbisda = new JTextField();
		dbisda.setBounds(250,220,200,30);
		
		//SimpleDateFormat issdate = new SimpleDateFormat("yyyy-MM-dd");
		
		JLabel rtndat = new JLabel("Return Date :");
		rtndat.setBounds(50,260,180,20);
		rtndat.setFont(f1);
		rtndat.setForeground(Color.yellow);
		
		dbrtnda = new JTextField();
		dbrtnda.setBounds(250,260,200,30);
		
		b17 = new JButton("AddI");
		b17.setBounds(40,360,100,50);
		
		b18 = new JButton("UpdateI");
		b18.setBounds(240,360,100,50);
		
		
		b20 = new JButton("BackI");
		b20.setBounds(430,360,100,50);
		
		b25 = new JButton("DeleteI");
		b25.setBounds(190,430,200,50);
		
		
		b17.addActionListener(this);
		dbna.addKeyListener(this);
		dbbo.addKeyListener(this);
		dbpri.addKeyListener(this);
        b20.addActionListener(this);
		b25.addActionListener(this);
		
		
		p10.add(p11);
        p11.setLayout(null);
		p11.add(issid);
		p11.add(tf11);
		p11.add(issna);
		p11.add(dbna);
		p11.add(issboid);
		p11.add(tf13);
		p11.add(sd);
		p11.add(dbbo);
		p11.add(isspri);
		p11.add(dbpri);
		p11.add(rec);
		p11.add(issdat);
		
		p11.add(dbisda);
		
		p11.add(dbrtnda);
		//p11.add(issdate);
		
		p11.add(rtndat);
		p11.add(b17);
		p11.add(b18);
		//p11.add(b19);
		p11.add(b20);
		p11.add(b25);
		
        l10.setFont(f1);
        issuF.add(l10);
		
	}
	
	/*
	   *********************************************************************************
	*/
	
	// RETURN BOOK method
	
	public void rtnmtd()
	{
		rtnF = new JFrame("return book");
		rtnF.setVisible(true);
		rtnF.setLocation(200,80);
		rtnF.setLayout(null);
		rtnF.setSize(1000,600); 
		
		JLabel l11 = new JLabel("RETURN BOOK");
		l11.setBounds(400,5,250,20);	
		
		p12 = new JPanel();
		p13= new JPanel();
		
		 try
		{
          Class.forName("oracle.jdbc.driver.OracleDriver");
		  Connection conn2=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
		  Statement stmt2=conn2.createStatement();
		  ResultSet rs2=stmt2.executeQuery("select * from returnbooklms");
		  
		  int rows = 0;
		  while(rs2.next())
		  {
			  rows = rows+1;
		  }
		  
		  Statement stmt3=conn2.createStatement();
		  ResultSet rs3=stmt2.executeQuery("select * from returnbooklms");
		 
		  String cols6[]={"STUDENTID","BOOKNAME","RETURNDATE"};
		
		  String Data6[][]= new String[rows][3];
		  
		   int i = -1;
		  while(rs3.next())
		  {
			  i = i+1;
			  for(int k = 0;k<3;k++)
			  {
				String a = rs3.getString(1);
                String b= rs3.getString(2);  
                String c= rs3.getString(3);  
               				
				
				Data6[i][k] = a;
				k=k+1;
				Data6[i][k] = b;
				k=k+1;
				Data6[i][k] = c;
				k=k+1;
				
			  }
		  }
		  jt6 =new JTable(Data6,cols6);
               rs2.close();
		       stmt2.close();		  
		
		}
		catch(Exception se1)
		{
			System.out.println(se1);
		}
		
		
		     

		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		
		JScrollPane sp6=new JScrollPane(jt6,v,h);
		sp6.setBounds(580,150,380,300);   
		rtnF.add(sp6);
		rtnF.add(p12);
		
		p12.setBackground(Color.black);
		p12.setSize(959,500);
		p12.setLocation(10,50);
		p12.setLayout(null);
		
		p13.setBackground(new Color(102,0,50));
		//p1.setSize(500,300);
		p13.setBounds(10,10,940,480);
		
		JLabel sid = new JLabel("Student Id:");
		sid.setBounds(50,20,180,20);
		sid.setFont(f1);
		sid.setForeground(Color.yellow);
		
		tf17 = new JTextField();
		tf17.setBounds(250,20,200,30);
		
		JLabel rtnboo = new JLabel("Book Name:");
		rtnboo.setBounds(50,80,180,20);
		rtnboo.setFont(f1);
		rtnboo.setForeground(Color.yellow);
		
		
		tf18 = new JTextField();
		tf18.setBounds(250,80,200,30);
		tf18.setEditable(false);
		
		JLabel rtndat = new JLabel("Return Date:");
		rtndat.setBounds(50,140,180,20);
		rtndat.setFont(f1);
		rtndat.setForeground(Color.yellow);
		
		tfrd = new JTextField();
		tfrd.setBounds(250,140,200,30);
		
		tf18.addKeyListener(this);
		
		b21 = new JButton("RETURN");
		b21.setBounds(40,290,100,50);
		
		b22 = new JButton("UpdateR");
		b22.setBounds(180,290,100,50);
		
		b23 = new JButton("BackR");
		b23.setBounds(360,290,100,50);
		
		
		b23.addActionListener(this);
		b21.addActionListener(this);
		
		p12.add(p13);
        p13.setLayout(null);
		
		p13.add(sid);
		p13.add(tf17);
		
		p13.add(rtnboo);
		p13.add(tf18);
		
		p13.add(rtndat);
		p13.add(tfrd);
		
		p13.add(b21);
		//p13.add(b22);
		p13.add(b23);
		
        l11.setFont(f1);
        rtnF.add(l11);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String button=e.getActionCommand();
		
		
		if(button.equals("BOOK"))
		{
			bookmtd1();
		}
		
		if(button.equals("STUDENTS"))
		{
			studmtd1();
		}
		
		if(button.equals("ISSUE BOOK"))
		{
			issumtd();
		}
		
	    if(button.equals("RETURN BOOK"))
		{
			rtnmtd();
		}
		
		if(button.equals("CLOSE"))
		{
			menu.dispose();
		}
		
		// ************************ books ****************
		
		if(button.equals("AddB"))
	{
			
			String Bname = tf2.getText();
			String Bcat = tf3.getText();
			String Bid = tf4.getText();
			String Bpri = tf5.getText();
			String Baut = tf6.getText();
			
			String q = "insert into booklms(NAME,CATEGORY,ID,PRICE,AUTHOR)values(?,?,?,?,?)";
		
	    try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
		    PreparedStatement stmt = conn.prepareStatement(q);
			
			stmt.setString(1,Bname);
			stmt.setString(2,Bcat);
			stmt.setString(3,Bid);
			stmt.setString(4,Bpri);
			stmt.setString(5,Baut);
			
			int k = stmt.executeUpdate();
			
			if(k == 1)
			{
				JOptionPane.showMessageDialog(null,"book added");
				
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");
				tf5.setText("");
				tf6.setText("");
				
				bookmtd1();
				conn.close();
			}
		}
		catch(Exception ase)
		{
			System.out.println(ase);
		}
		
	}
	
	//
	
	if(button.equals("DeleteB"))
		{
			try
		    {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		   
			
			String del = JOptionPane.showInputDialog(null,"enter id");
			
			int id2 = Integer.parseInt(del);
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
             Statement stmt1 = conn.createStatement(); 
			ResultSet rs = stmt1.executeQuery("select * from booklms");
			
			 PreparedStatement stmt = conn.prepareStatement("delete from booklms where ID = ?");
			 stmt.setInt(1,id2);
			 int x = stmt.executeUpdate();
			 
			 JOptionPane.showMessageDialog(null,"row deleted");
			 
			 bookmtd1();
		    }
			catch(Exception db)
			{
				System.out.println(db);
			}
			 
		}	
		
		
		//******************update book *********
		
		
		if(button.equals("RetriveB"))
		{
			try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Register Succesfully");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
			//System.out.println("update-Connection Succesfully!!!!");
			Statement stmt1=con.createStatement();
			ResultSet rs=stmt1.executeQuery("select * from BOOKLMS");
			String updateid=JOptionPane.showInputDialog(null,"Enter ID of book which you want to update");
		    int up1=Integer.parseInt(updateid);
			 while(rs.next())    
						{ 
								String name =rs.getString(1);
								String cat=rs.getString(2);
								int id=rs.getInt(3);							
								int pri=rs.getInt(4);							
								String aut=rs.getString(5);						
								//System.out.println(name);
								//System.out.println(add);
								//System.out.println(id);
								//System.out.println(phno);
								//System.out.println(email);
								if(up1==id)
								{ 
									//System.out.println("debugg "+id1);
									tf2.setText(name);
									tf3.setText(cat);
									tf4.setText(Integer.toString(id));
									tf5.setText(Integer.toString(pri));
								    tf6.setText(aut);
							     }
								
						}
         }
		catch(Exception re)
		{
			System.out.println(re);
		}
			
		}
		
		if(button.equals("UpdateB"))
		{
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//System.out.println("Driver Register Succesfully");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
				//System.out.println("update-Connection Succesfully");
				
				Statement stmt1=con.createStatement();
				
				String name1=tf2.getText();
				String cat1=tf3.getText();
				int id1=Integer.parseInt(tf4.getText());
				int pri1=Integer.parseInt(tf5.getText());
				String aut1=tf6.getText();
				
				PreparedStatement pstmt=con.prepareStatement("update BOOKLMS set NAME=?,CATEGORY=?,PRICE=?,AUTHOR=? where ID=?");
				pstmt.setString(1,name1);
				pstmt.setString(2,cat1);
				pstmt.setInt(3,pri1);
				pstmt.setString(4,aut1);
				pstmt.setInt(5,id1);
			    pstmt.executeUpdate();
				
				JOptionPane.showMessageDialog(null,"Record Updated successfully!!!");
				//System.out.println("Row Updated Successfully!!!");
				
				bookmtd1();
			   }
			   
			   catch(Exception ub)
			   {
				 System.out.println(ub);  
			   }
			
		}
		if(button.equals("BackB"))
		{
			bookF.dispose();
			
		}
		
		// ************************ students ****************
		
		if(button.equals("AddS"))
	{
			String Sname = tf7.getText();
			String Saddress = ta1.getText();
			String Sid = tf8.getText();
			String Spho = tf9.getText();
			String Semail = tf10.getText();
			
			String q1 = "insert into studentlms(NAME,ADDRESS,ID,PHONENO,EMAIL)values(?,?,?,?,?)";
		
	    try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
		    PreparedStatement stmt1 = conn1.prepareStatement(q1);
			
			stmt1.setString(1,Sname);
			stmt1.setString(2,Saddress);
			stmt1.setString(3,Sid);
			stmt1.setString(4,Spho);
			stmt1.setString(5,Semail);
			
			int S = stmt1.executeUpdate();
			
			if(S == 1)
			{
				JOptionPane.showMessageDialog(null,"student added");
				
				tf7.setText("");
				ta1.setText("");
				tf8.setText("");
				tf9.setText("");
				tf10.setText("");
				
				studmtd1();
				conn1.close();
			}
		}
		
		catch(Exception ase1)
		{
			System.out.println(ase1);
		}
	}
	
	if(button.equals("RetriveS"))
	{
		try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("Driver Register Succesfully");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
			//System.out.println("update-Connection Succesfully!!!!");
			Statement stmt1=con.createStatement();
			ResultSet rs=stmt1.executeQuery("select * from StudentLMS");
			String updateid=JOptionPane.showInputDialog(null,"                   Enter ID of Student which you want to update        ");
		    int up1=Integer.parseInt(updateid);
			 while(rs.next())    
						{ 
								String name =rs.getString(1);
								String add=rs.getString(2);
								int id=rs.getInt(3);							
								long phno=rs.getLong(4);							
								String email=rs.getString(5);						
								//System.out.println(name);
								//System.out.println(add);
								//System.out.println(id);
								//System.out.println(phno);
								//System.out.println(email);
								if(up1==id)
								{ 
									//System.out.println("debugg "+id1);
									tf7.setText(name);
									ta1.setText(add);
									tf8.setText(Integer.toString(id));
									tf9.setText(Long.toString(phno));
								    tf10.setText(email);
							     }
								
						}
         }
		catch(Exception re)
		{
			System.out.println(re);
		}
		
	
	}
	
	if(button.equals("UpdateS"))
		{
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("Driver Register Succesfully");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
				//System.out.println("update-Connection Succesfully");
				
				Statement stmt1=con.createStatement();
				
				String name1=tf7.getText();
				String add1=ta1.getText();
				int id1=Integer.parseInt(tf8.getText());
				long phno1=Long.parseLong(tf9.getText());
				String eid1=tf10.getText();
				
				PreparedStatement pstmt=con.prepareStatement("update STUDENTLMS set NAME=?,ADDRESS=?,PHONENO=?,EMAIL=? where ID=?");
				pstmt.setString(1,name1);
				pstmt.setString(2,add1);
				pstmt.setLong(3,phno1);
				pstmt.setString(4,eid1);
				pstmt.setInt(5,id1);
			    pstmt.executeUpdate();
				
				JOptionPane.showMessageDialog(null,"Record Updated successfully!!!");
				//System.out.println("Row Updated Successfully!!!");
				
				studmtd1();
			   }
			   
			   catch(Exception us)
			   {
				 System.out.println(us);  
			   }
			
		}
	
	if(button.equals("BackS"))
		{
			studF.dispose();
			
		}
		
		
		if(button.equals("DeleteS"))
		{
			try
		    {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		   
			
			String del = JOptionPane.showInputDialog(null,"enter id");
			
			int id2 = Integer.parseInt(del);
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
             Statement stmt1 = conn.createStatement(); 
			ResultSet rs = stmt1.executeQuery("select * from studentlms");
			
			 PreparedStatement stmt = conn.prepareStatement("delete from studentlms where ID = ?");
			 stmt.setInt(1,id2);
			 int x = stmt.executeUpdate();
			 
			 JOptionPane.showMessageDialog(null,"row deleted");
			 
			 studmtd1();
		    }
			catch(Exception ds)
			{
				System.out.println(ds);
			}
			
		}
	
	// ************************ issue book ****************
	if(button.equals("AddI"))
		{
			
		    String isid = tf11.getText();
			String isna = dbna.getText();
			String isboid = tf13.getText();
			String isbona = dbbo.getText();
			String ispri = dbpri.getText();
			String isda = dbisda.getText();
			String rtnda = dbrtnda.getText();
			
			String q2 = "insert into issuebooklms(STUDENTID,SNAME,BOOKID,BNAME,BPRICE,ISSDATE,RETDATE)values(?,?,?,?,?,?,?)";
		
	    try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn2=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
		    PreparedStatement stmt2 = conn2.prepareStatement(q2);
			
			stmt2.setString(1,isid);
			stmt2.setString(2,isna);
			stmt2.setString(3,isboid);
			stmt2.setString(4,isbona);
			stmt2.setString(5,ispri);
			stmt2.setString(6,isda);
			stmt2.setString(7,rtnda);
			
			int I = stmt2.executeUpdate();
			
			if(I == 1)
			{
				JOptionPane.showMessageDialog(null,"student added");
				
				tf11.setText("");
				dbna.setText("");
				tf13.setText("");
				dbbo.setText("");
				dbpri.setText("");
				dbisda.setText("");
				dbrtnda.setText("");
				
				issumtd();
				conn2.close();
			}
		}
		
		catch(Exception ase2)
		{
			System.out.println(ase2);
		} 
		  
	  }
	  
	  if(button.equals("BackI"))
		{
			issuF.dispose();
			
		}
		
		
		 if(button.equals("DeleteI"))
		{
			try
		    {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		   
			
			String del = JOptionPane.showInputDialog(null,"enter id");
			
			int id2 = Integer.parseInt(del);
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
             Statement stmt1 = conn.createStatement(); 
			ResultSet rs = stmt1.executeQuery("select * from issuebooklms");
			
			 PreparedStatement stmt = conn.prepareStatement("delete from issuebooklms where STUDENTID = ?");
			 stmt.setInt(1,id2);
			 int x = stmt.executeUpdate();
			 
			 JOptionPane.showMessageDialog(null,"row deleted");
			 
			 issumtd();
		    }
			catch(Exception di)
			{
				System.out.println(di); 
				
			}
			
		}
		// ************************ return book ****************
		
		if(button.equals("RETURN"))
		{
			String rtnid = tf17.getText();
			String rtnna = tf18.getText();
			String rtndt = tfrd.getText();
			
			
			String q2 = "insert into returnbooklms(STUDENTID ,BNAME ,RETDATE )values(?,?,?)";
		
	    try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn2=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
		    PreparedStatement stmt2 = conn2.prepareStatement(q2);
			
			stmt2.setString(1,rtnid);
			stmt2.setString(2,rtnna);
			stmt2.setString(3,rtndt);
			
			
			int I = stmt2.executeUpdate();
			
			if(I == 1)
			{
				JOptionPane.showMessageDialog(null,"BOOK RETURNED");
				
				tf17.setText("");
				tf18.setText("");
				tfrd.setText("");
				
				
				rtnmtd();
				conn2.close();
			}
		}
		
		catch(Exception ase2)
		{
			System.out.println(ase2);
		} 
		  
			
		}
		
		
	 if(button.equals("BackR"))
		{
			rtnF.dispose();
			
		}	
  }	
  
  public void keyPressed(KeyEvent na)
  {
	  if(na.getKeyCode() == KeyEvent.VK_ENTER)
	  {
		  String isid = tf11.getText();
		  
		  String q3 = "select * from studentlms where ID = ?";
		
	    try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn3=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
		    PreparedStatement stmt3 = conn3.prepareStatement(q3);
			
			stmt3.setString(1,isid);
			
			
			ResultSet rs4 = stmt3.executeQuery();
			
			if(rs4.next() == false)
			{
				JOptionPane.showMessageDialog(null,"student id not found");
			}
			else
			{
				String mname = rs4.getString("NAME");
				dbna.setText(mname.trim());
			}
		}
		
		catch(Exception ase3)
		{
			System.out.println(ase3);
		}
	  }
	  
	  ///
	  
	  if(na.getKeyCode() == KeyEvent.VK_F5)
	  {
		  String isboid = tf13.getText();
		 // String ispri = tf5.getText();
		  
		  String q4 = "select NAME , PRICE from booklms where ID = ?";
		
	    try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn4=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
		    PreparedStatement stmt4 = conn4.prepareStatement(q4);
			
		      stmt4.setString(1,isboid);
			 // stmt4.setString(2,ispri);
			
			
			
			
			ResultSet rs6 = stmt4.executeQuery();
			
			if(rs6.next() == false)
			{
				JOptionPane.showMessageDialog(null,"book id not found");
			}
			else
				
			{
				String mboo = rs6.getString("NAME");
				dbbo.setText(mboo.trim());
				
				//String mbopri = rs6.getString("PRICE");
				//dbpri.setText(mbopri);
			}
		}
		
		catch(Exception ase4)
		{
			System.out.println(ase4);
		}
	  } 
	  //
	  
	  if(na.getKeyCode() == KeyEvent.VK_SPACE)
	  {
		  String rtsid = tf17.getText();
		 //String ispri = dbpri.getText();
		  
		  String q5 = "select * from issuebooklms where STUDENTID = ?";
		
	    try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn5=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
		    PreparedStatement stmt5 = conn5.prepareStatement(q5);
			
		      stmt5.setString(1,rtsid);
			  //stmt5.setString(5,ispri);
			
			
			
			
			ResultSet rs7 = stmt5.executeQuery();
			
			if(rs7.next() == false)
			{
				JOptionPane.showMessageDialog(null,"book id not found");
			}
			else
			{
				String rtnboo = rs7.getString("BNAME");
				tf18.setText(rtnboo.trim());
				
				//String mbopri = rs7.getString("PRICE");
				//dbpri.setText(mbopri.trim());
			}
		}
		
		catch(Exception ase4)
		{
			System.out.println(ase4);
		}
	  } 
	  
	  // return fatch
	  
	  if(na.getKeyCode() == KeyEvent.VK_F4)
	  {
		  String rtid = tf17.getText();
		  
		  String q3 = "select * from issuebooklms where STUDENTID  = ?";
		
	    try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn3=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
		    PreparedStatement stmt3 = conn3.prepareStatement(q3);
			
			stmt3.setString(1,rtid);
			
			
			ResultSet rs4 = stmt3.executeQuery();
			
			if(rs4.next() == false)
			{
				JOptionPane.showMessageDialog(null,"student id not found");
			}
			else
			{
				String mname1 = rs4.getString("SNAME");
				tf18.setText(mname1.trim());
			}
		}
		
		catch(Exception ase3)
		{
			System.out.println(ase3);
		}
	  }
	   
	  
  }
   public void keyReleased(KeyEvent na)
  {
	 
  }
  
  
  
  /////////
  
  public void keyTyped(KeyEvent na)
  {
	
  }
  
  
	
//************ mouse event**********


	public void mouseClicked(MouseEvent me)
	{
		
	  try
		{
	//JOptionPane.showMessageDialog(null,"mouse clicked");
	
	 //jt7 =jt4.getModel();
	  
	  String[] cona = {"NAME","ADDRESS","ID","PHONENO","EMAIL"};
	  
	  DefaultTableModel b =new DefaultTableModel();
	 
	  jt4.setModel(b);
	  
	 // int selectIndex = jt4.getSelectedRow();
	  
	  //tf7.setText(jt4.getValueAt(selectIndex,0).toString());
	  
	  String NAME = "";
	  String ADDRESS = "";
	  int ID ;
	  int PHONENO ;
	  String EMAIL = "";
	  
	  String[] rowData = new String[5];
	  
	   Class.forName("oracle.jdbc.driver.OracleDriver");
	   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
	  Statement pst = con.createStatement();
	   String q="select * from studentlms";
	   ResultSet rs = pst.executeQuery(q);
	   
	    b.setColumnIdentifiers(cona);
		
		while (rs.next())
		{
			NAME = rs.getString(1);
			ADDRESS = rs.getString(2);
			ID = rs.getInt(3);
			PHONENO = rs.getInt(4);
			EMAIL = rs.getString(5);
			
			
			 b.addRow(new Object[]{NAME, ADDRESS, ID,PHONENO,EMAIL});
		}
	   
	  /*
	  jt8 =(JTable)jt4.getModel();
	  
	  int selectIndex = jt4.getSelectedRow();
	  
	  tf7.setText(jt8.getValueAt(selectIndex,0).toString());
	  
	  */
	  con.close();
		}
		
		catch(Exception e)
		{
		   System.out.println(e);	
		}
	}

	public void mouseEntered(MouseEvent me)
	{
	
	}

	public void mouseExited(MouseEvent me)
	{
	
	}

	public void mousePressed(MouseEvent me)
	{
	
	}
	public void mouseReleased(MouseEvent me)
	{
	
	}	
		
}

