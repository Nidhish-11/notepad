import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
class Notepad implements ActionListener,ItemListener
{
	int start,end,size,lno,is,ie;
	JFrame f,f1,f2,f3,f4;
	JTextField t1,t2,t3,tg,t4,t5,t6,t7,t8,t9,t10,t11;
	JLabel l5=new JLabel("AaBbYyZz");
	JButton b1,b2,b3,b4,b5,b6,b7,b8;
	JTextArea t;
	JMenuBar j;
	JMenu j1,j2,j3,j4,j5;
	JMenuItem j11,j12,j13,j14,j15,j16,j17,j21,j22,j23,j24,j25,j26,j27,j28,j29,j291,j292,j31,j32,j41,j51,j52;
	Dimension ss;
	JFileChooser jfc;
	FileReader fr;
	FileWriter fw;
	BufferedReader br;
	BufferedWriter bw;
	File file;
	String line,clip,face,style,str,filen;
	StringBuilder sb,sb1;
	List li1,li2,li3;
	Font font;
	Choice c2,c3;
	ButtonGroup bg;
	JRadioButton rb1,rb2;
	Notepad()
	{	
		ss=Toolkit.getDefaultToolkit().getScreenSize();
		f=new JFrame("Notepad");
		f.setLayout(null);
		f.setBounds(0,0,500,ss.height);
		t=new JTextArea();
		t.setBounds(0,20,ss.width-20,ss.height-20);
		f.add(t);
		t.setFont(new Font("Arial",Font.PLAIN,12));
		j=new JMenuBar();
		j.setBounds(0,0,ss.width,20);
		f.add(j);
		j1=new JMenu("File");
		j.add(j1);
		j11=new JMenuItem("New");
		j1.add(j11);
		j11.addActionListener(this);
		j12=new JMenuItem("Open");
		j1.add(j12);
		j12.addActionListener(this);
		j13=new JMenuItem("Save");
		j1.add(j13);
		j13.addActionListener(this);
		j14=new JMenuItem("Save As");
		j1.add(j14);
		j15=new JMenuItem("Page Setup");
		j1.add(j15);
		j15.addActionListener(this);
		j16=new JMenuItem("Print");
		j1.add(j16);
		j17=new JMenuItem("Exit");
		j1.add(j17);
		j17.addActionListener(this);
		j2=new JMenu("Edit");
		j.add(j2);
		j21=new JMenuItem("Undo");
		j2.add(j21);
		j22=new JMenuItem("Cut");
		j2.add(j22);
		j22.addActionListener(this);
		j23=new JMenuItem("Copy");
		j2.add(j23);
		j23.addActionListener(this);
		j24=new JMenuItem("Paste");
		j2.add(j24);
		j24.addActionListener(this);
		j25=new JMenuItem("Delete");
		j2.add(j25);
		j25.addActionListener(this);
		j26=new JMenuItem("Find");
		j2.add(j26);
		j27=new JMenuItem("Find Next");
		j2.add(j27);
		j28=new JMenuItem("Replace");
		j2.add(j28);
		j28.addActionListener(this);
		j29=new JMenuItem("Go To");
		j2.add(j29);
		j29.addActionListener(this);
		j291=new JMenuItem("Select All");
		j2.add(j291);
		j292=new JMenuItem("Time/Date");
		j2.add(j292);
		j3=new JMenu("Format");
		j.add(j3);
		j31=new JMenuItem("Word Wrap");
		j3.add(j31);
		j31.addActionListener(this);
		j32=new JMenuItem("Font");
		j3.add(j32);
		j32.addActionListener(this);
		j4=new JMenu("View");
		j.add(j4);
		j41=new JMenuItem("Status Bar");
		j4.add(j41);
		j5=new JMenu("Help");
		j.add(j5);
		j51=new JMenuItem("View Help");
		j5.add(j51);
		j52=new JMenuItem("About Notepad");
		j5.add(j52);
		j24.setEnabled(false);
		l5.setFont(new Font("Arial",Font.PLAIN,12));
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		Object ob=e.getSource();
		if(ob==j11)
		t.setText(null);
		else if(ob==j12)
		{
			t.setText(null);
			try
			{
				jfc=new JFileChooser("E:/Nidhish/");
				jfc.showOpenDialog(null);
				file=jfc.getSelectedFile();
				fr=new FileReader(file);
				br=new BufferedReader(fr);
				for(;(line=br.readLine())!=null;)
				{
					//System.out.print(line+"\n");
					t.append(line+"\n");
				}
				br.close();
			}
			catch(Exception e1)
			{}
		}
		else if(ob==j13)
		{
			try
			{
				jfc=new JFileChooser("E:/Nidhish/");
				jfc.showSaveDialog(null);
				File file1=jfc.getSelectedFile();
				filen=(file1.getName())+".txt";
				fw=new FileWriter(filen);
				bw=new BufferedWriter(fw);
				bw.write(t.getText());
				bw.close();
			}
			catch(Exception e1)
			{}
		}
		else if(ob==j15)
		{
			pagesetup();
		}
		else if(ob==j22)
		{
			clip=t.getSelectedText();
			//t.setText(t.getText().replace(clip,""));
			start=t.getSelectionStart();
			end=t.getSelectionEnd();
			sb=new StringBuilder(t.getText());
			sb.replace(start,end,"");
			t.setText(sb.toString());
		}
		else if(ob==j23)
		clip=t.getSelectedText();
		else if(ob==j24)
		{
			start=t.getSelectionStart();
			end=t.getSelectionEnd();
			sb=new StringBuilder(t.getText());
			sb.replace(start,end,clip);
			t.setText(sb.toString());
		}
		else if(ob==j25)
		{
			start=t.getSelectionStart();
			end=t.getSelectionEnd();
			sb=new StringBuilder(t.getText());
			sb.delete(start,end);
			t.setText(sb.toString());
		}
		else if(ob==j28)
		{
			//System.out.print(t.getCaretPosition());
			ie=t.getCaretPosition();
			replace();
		}
		else if(ob==j29)
		{
			gotoline();
		}
		else if(ob==31)
		{
			t.setWrapStyleWord(true);
		}
		else if(ob==j32)
		{
			font();
		}
		else if(ob==j17)
		System.exit(0);
		if(ob==b2)
		{
			f1.dispose();
		}
		else if(ob==b1)
		{
			face=t1.getText();
			size=Integer.parseInt(t3.getText());
			style=t2.getText();
			if(style.equals("Regular")==true)
			t.setFont(new Font(face,Font.PLAIN,size));
			else if(style.equals("Italic")==true)
			t.setFont(new Font(face,Font.ITALIC,size));
			else if(style.equals("Bold")==true)
			t.setFont(new Font(face,Font.BOLD,size));
			else
			t.setFont(new Font(face,Font.BOLD + Font.ITALIC,size));
			f1.dispose();
		}
		if(ob==b8)
		{
			f3.dispose();
		}
		else if(ob==b5)
		{
			t.setCaretPosition(ie);
			t.select(t.getCaretPosition(),t.getText().length());
			String str=t.getSelectedText();
			is=t.getCaretPosition()+str.indexOf(t4.getText());
			ie=is+t4.getText().length();
			if(str.indexOf(t4.getText())==-1)
			JOptionPane.showMessageDialog(null,t4.getText()+" not found!");
			else
			{
				t.requestFocus();
				t.select(is,ie);
			}
		}
		else if(ob==b6)
		{
			t.select(t.getCaretPosition(),t.getText().length());
			str=t.getSelectedText();
			is=t.getCaretPosition()+str.indexOf(t4.getText());
			ie=is+t4.getText().length();
			if(str.indexOf(t4.getText())==-1)
			JOptionPane.showMessageDialog(null,t4.getText()+" not found!");
			else
			{
				t.requestFocus();
				t.select(is,ie);
				sb1=new StringBuilder(t.getText());
				sb1.replace(t.getSelectionStart(),t.getSelectionEnd(),t5.getText());
				t.setText(sb1.toString());
			}
			t.setCaretPosition(ie);
		}
		else if(ob==b7)
		{
			do
			{
				t.select(t.getCaretPosition(),t.getText().length());
				str=t.getSelectedText();
				is=t.getCaretPosition()+str.indexOf(t4.getText());
				ie=is+t4.getText().length();
				if(str.indexOf(t4.getText())==-1)
				break;
				else
				{
					t.requestFocus();
					t.select(is,ie);
					sb1=new StringBuilder(t.getText());
					sb1.replace(t.getSelectionStart(),t.getSelectionEnd(),t5.getText());
					t.setText(sb1.toString());
					t.setCaretPosition(ie);
				}
			}while(str.indexOf(t4.getText())!=-1);
		}
		if(ob==b4)
		{
			f2.dispose();
		}
		else if(ob==b3)
		{
			lno=Integer.parseInt(tg.getText());
			t.setCaretPosition(2);
			f2.dispose();
		}
		if(clip!=null)
		j24.setEnabled(true);
	}
	public void font()
	{
		font=t.getFont();
		Label l1,l2,l3,l4;
		f1=new JFrame("Font");
		f1.setSize(450,500);
		f1.setLayout(null);
		f1.setVisible(true);
		l1=new Label("Font:");
		l1.setBounds(10,15,30,10);
		f1.add(l1);
		l2=new Label("Font style:");
		l2.setBounds(200,15,60,15);
		f1.add(l2);
		l3=new Label("Size:");
		l3.setBounds(350,15,30,10);
		f1.add(l3);
		t1=new JTextField();
		t1.setBounds(10,30,160,23);
		f1.add(t1);
		t1.setText(font.getName());
		t2=new JTextField();
		t2.setBounds(200,30,120,23);
		f1.add(t2);
		if(font.getStyle()==0)
		t2.setText("Regular");
		else if(font.getStyle()==2)
		t2.setText("Italic");
		else if(font.getStyle()==1)
		t2.setText("Bold");
		else
		t2.setText("Bold Italic");
		t3=new JTextField();
		t3.setBounds(350,30,70,23);
		f1.add(t3);
		t3.setText(Integer.toString(font.getSize()));
		li1=new List();
		li1.setBounds(10,53,160,100);
		li1.add("Agency FB");
		li1.add("ALGERIAN");
		li1.add("Arial");
		li1.add("Arial Rounded MT");
		li1.add("Arial Unicode US");
		li1.add("Baskerville Old Face");
		li1.add("Bauhaus 93");
		li1.add("Bell MT");
		li1.add("Berlin Sans FB");
		f1.add(li1);
		li1.addItemListener(this);
		li2=new List();
		li2.setBounds(200,53,120,100);
		li2.add("Regular");
		li2.add("Italic");
		li2.add("Bold");
		li2.add("Bold Italic");
		f1.add(li2);
		li2.addItemListener(this);
		li3=new List();
		li3.setBounds(350,53,70,100);
		li3.add("8");
		li3.add("9");
		li3.add("10");
		li3.add("11");
		li3.add("12");
		li3.add("14");
		li3.add("16");
		li3.add("18");
		li3.add("20");
		li3.add("22");
		li3.add("24");
		li3.add("26");
		li3.add("28");
		li3.add("36");
		li3.add("48");
		li3.add("72");
		f1.add(li3);
		li3.addItemListener(this);
		l4=new Label("Sample");
		l4.setBounds(210,173,50,15);
		f1.add(l4);
		l5.setBounds(210,190,170,100);
		f1.add(l5);
		l5.setHorizontalAlignment(SwingConstants.CENTER);
		//l5.setBackground(Color.red);
		b1=new JButton("OK");
		b1.setBounds(250,410,75,25);
		f1.add(b1);
		b1.addActionListener(this);
		b2=new JButton("Cancel");
		b2.setBounds(330,410,80,25);
		f1.add(b2);
		b2.addActionListener(this);
	}
	public void gotoline()
	{
		f2=new JFrame("Go To Line");
		f2.setSize(260,140);
		f2.setLayout(null);
		Label l1=new Label("Line number:");
		l1.setBounds(10,20,90,15);
		f2.add(l1);
		tg=new JTextField();
		tg.setBounds(13,40,215,23);
		f2.add(tg);
		b3=new JButton("Go To");
		b3.setBounds(58,75,80,20);
		f2.add(b3);
		b3.addActionListener(this);
		b4=new JButton("Cancel");
		b4.setBounds(148,75,80,20);
		f2.add(b4);
		b4.addActionListener(this);
		f2.setVisible(true);
	}
	public void replace()
	{
		Label l1,l2;
		f3=new JFrame("Replace");
		f3.setLayout(null);
		f3.setSize(380,200);
		f3.setVisible(true);
		l1=new Label("Find what:");
		l1.setBounds(10,15,60,15);
		f3.add(l1);
		t4=new JTextField();
		t4.setBounds(100,15,150,20);
		f3.add(t4);
		t5=new JTextField();
		t5.setBounds(100,40,150,20);
		f3.add(t5);
		l2=new Label("Replace with:");
		l2.setBounds(10,40,80,15);
		f3.add(l2);
		b5=new JButton("Find Next");
		b5.setBounds(260,15,100,20);
		f3.add(b5);
		b5.addActionListener(this);
		b6=new JButton("Replace");
		b6.setBounds(260,40,100,20);
		f3.add(b6);
		b6.addActionListener(this);
		b7=new JButton("Replace All");
		b7.setBounds(260,65,100,20);
		f3.add(b7);
		b7.addActionListener(this);
		b8=new JButton("Cancel");
		b8.setBounds(260,90,100,20);
		f3.add(b8);
		b8.addActionListener(this);
	}
	public void pagesetup()
	{
		f4=new JFrame("Page Setup");
		f4.setSize(550,350);
		f4.setLayout(null);
		f4.setVisible(true);
		Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
		l1=new Label("Paper");
		l1.setBounds(10,10,50,15);
		f4.add(l1);
		l2=new Label("Size:");
		l2.setBounds(15,40,50,15);
		f4.add(l2);
		c2=new Choice();
		c2.setBounds(100,40,285,15);
		c2.add("A3");
		c2.add("A4");
		c2.add("Letter");
		f4.add(c2);
		l3=new Label("Source:");
		l3.setBounds(15,70,50,15);
		f4.add(l3);
		c3=new Choice();
		c3.setBounds(100,70,285,15);
		c3.add("Automatically Select");
		f4.add(c3);
		l4=new Label("Orientation");
		l4.setBounds(10,110,80,15);
		f4.add(l4);
		rb1=new JRadioButton("Portrait");
		rb1.setBounds(15,140,80,15);
		f4.add(rb1);
		rb2=new JRadioButton("Landscape");
		rb2.setBounds(15,170,100,15);
		f4.add(rb2);
		bg=new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
		l5=new Label("Margins (inches)");
		l5.setBounds(140,110,120,15);
		f4.add(l5);
		l6=new Label("Left:");
		l6.setBounds(145,140,50,15);
		f4.add(l6);
		t6=new JTextField();
		t6.setBounds(215,140,40,20);
		f4.add(t6);
		l7=new Label("Top:");
		l7.setBounds(145,170,50,15);
		f4.add(l7);
		t7=new JTextField();
		t7.setBounds(215,170,40,20);
		f4.add(t7);
		l8=new Label("Right:");
		l8.setBounds(275,140,50,15);
		f4.add(l8);
		t8=new JTextField();
		t8.setBounds(345,140,40,20);
		f4.add(t8);
		l9=new Label("Bottom:");
		l9.setBounds(275,170,50,15);
		f4.add(l9);
		t9=new JTextField();
		t9.setBounds(345,170,40,20);
		f4.add(t9);
		l10=new Label("Header:");
		l10.setBounds(10,210,50,15);
		f4.add(l10);
		t10=new JTextField();
		t10.setBounds(90,210,300,20);
		f4.add(t10);
		l11=new Label("Footer:");
		l11.setBounds(10,240,50,15);
		f4.add(l11);
		t11=new JTextField();
		t11.setBounds(90,240,300,20);
		f4.add(t11);
		l12=new Label("Preview");
		l12.setBounds(400,10,50,15);
		f4.add(l12);
	}
	public void itemStateChanged(ItemEvent e)
	{
		Object ob=e.getSource();
		if(ob==li1)
		t1.setText(li1.getSelectedItem());
		else if(ob==li2)
		t2.setText(li2.getSelectedItem());
		else if(ob==li3)
		t3.setText(li3.getSelectedItem());
		if(t2.getText().equals("Regular")==true)
		l5.setFont(new Font(t1.getText(),Font.PLAIN,Integer.parseInt(t3.getText())));
		else if(t2.getText().equals("Bold")==true)
		l5.setFont(new Font(t1.getText(),Font.BOLD,Integer.parseInt(t3.getText())));
		else if(t2.getText().equals("Italic")==true)
		l5.setFont(new Font(t1.getText(),Font.ITALIC,Integer.parseInt(t3.getText())));
		else
		l5.setFont(new Font(t1.getText(),Font.BOLD + Font.ITALIC,Integer.parseInt(t3.getText())));
	}
	public static void main(String z[])
	{
		new Notepad();
	}
}
