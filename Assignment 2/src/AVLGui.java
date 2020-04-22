import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

public class AVLGui extends JFrame implements ActionListener{

	public JFrame frame;
   
	private JTextField stageTextField;
	private JTextField dateTextField;
	private JTextField timeTextField;
   
	private JTextArea viewAreas;
	private JTextField txtPleaseEnterThe;
   
	private String stage;
	private String date;
	private String time;

	private String mode = "AVL";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
      try {
			AVLGui window = new AVLGui();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public AVLGui() {
      super("Loadshedding App");
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		stageTextField = new JTextField();
		stageTextField.setBounds(10, 11, 84, 20);
		frame.getContentPane().add(stageTextField);
		stageTextField.setColumns(10);
		
		dateTextField = new JTextField();
		dateTextField.setColumns(10);
		dateTextField.setBounds(104, 11, 84, 20);
		frame.getContentPane().add(dateTextField);
		
		timeTextField = new JTextField();
		timeTextField.setColumns(10);
		timeTextField.setBounds(198, 11, 84, 20);
		frame.getContentPane().add(timeTextField);
		
		viewAreas = new JTextArea();
		viewAreas.setBounds(10, 78, 394, 123);
		viewAreas.setEditable(false);
		PrintStream printStream = new PrintStream(new CustomOutputStream(viewAreas));
		System.setOut(printStream);
		System.setErr(printStream);
		frame.getContentPane().add(viewAreas);
		
		txtPleaseEnterThe = new JTextField();
		txtPleaseEnterThe.setHorizontalAlignment(SwingConstants.CENTER);
		txtPleaseEnterThe.setText("Please enter the stage, date and time respectively.");
		txtPleaseEnterThe.setBackground(SystemColor.inactiveCaptionBorder);
		txtPleaseEnterThe.setColumns(10);
		txtPleaseEnterThe.setBounds(10, 42, 394, 20);
		frame.getContentPane().add(txtPleaseEnterThe);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setToolTipText("");
		btnNewButton.setBounds(292, 10, 89, 23);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		final JMenu searchMethod = new JMenu("Search Method");
		
		JMenuItem useAVL = new JMenuItem("AVL");
		searchMethod.add(useAVL);
		useAVL.addActionListener(this);
		
		JMenuItem useBST = new JMenuItem("BST");
		searchMethod.add(useBST);
		useBST.addActionListener(this);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(searchMethod);
		frame.setJMenuBar(menuBar);
	}
	
	public void actionPerformed(ActionEvent e) {
		String buttonStr = e.getActionCommand();

		if (buttonStr.equals("AVL")){
			mode = "AVL";
		}
		else if (buttonStr.equals("BST")){
			mode = "BST";
		}
      
		switch (mode) {
			case "AVL":
				LSAVL ls = new LSAVL ();
				ls.makeTree("/home/sachin/Desktop/CSC2001F/CS-A2/Assignment 2/data/original.txt");
				if (buttonStr.equals("Search")) {
					stage = stageTextField.getText();
					date = dateTextField.getText();
					time = timeTextField.getText();
					ls.printAreas(stage, date, time);
					// viewAreas.setText("Stage " + stage + " loadshedding \nDay " + date + ", " + time + ":00\n" 
					// 					+ ls.displayAreas(stage, date, time)
					// );
				} else if (buttonStr.equals("Search All")) {
					ls.printAllAreas();

				}
			break;

			case "BST":
				LSBST bs = new LSBST ();
				bs.makeTree("/home/sachin/Desktop/CSC2001F/CS-A2/Assignment 2/data/original.txt");
				if (buttonStr.equals("Search")) {
					stage = stageTextField.getText();
					date = dateTextField.getText();
					time = timeTextField.getText();
					viewAreas.setText("Stage " + stage + " loadshedding \nDay " + date + ", " + time + ":00\n" 
										+ bs.displayAreas(stage, date, time)
					);
				
			}
			break;
      }

	}
}
