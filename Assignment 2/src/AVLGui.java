import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

/**
 * Displays a user interface that uses both search apps
 */
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
		frame = new JFrame();
		frame.setTitle("Loadshedding App ("+mode+")");
		frame.setBounds(100, 100, 640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//menu
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
		
		//main content pane
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
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setToolTipText("");
		btnSearch.setBounds(336, 10, 89, 23);
		frame.getContentPane().add(btnSearch);
		btnSearch.addActionListener(this);

		JButton btnSearchAll = new JButton("Search All");
		btnSearchAll.setToolTipText("");
		btnSearchAll.setBounds(435, 10, 109, 23);
		frame.getContentPane().add(btnSearchAll);
		btnSearchAll.addActionListener(this);

		txtPleaseEnterThe = new JTextField();
		txtPleaseEnterThe.setHorizontalAlignment(SwingConstants.CENTER);
		txtPleaseEnterThe.setText("Please enter the stage, date and time respectively.");
		txtPleaseEnterThe.setBackground(SystemColor.inactiveCaptionBorder);
		txtPleaseEnterThe.setColumns(10);
		txtPleaseEnterThe.setBounds(10, 52, 616, 30);
		frame.getContentPane().add(txtPleaseEnterThe);
		
		viewAreas = new JTextArea();
		viewAreas.setBounds(10, 113, 606, 297);
		viewAreas.setEditable(false);
		PrintStream printStream = new PrintStream(new CustomOutputStream(viewAreas));
		System.setOut(printStream);
		System.setErr(printStream);
		frame.getContentPane().add(viewAreas);

		JScrollPane scroll = new JScrollPane();
		viewAreas.add(scroll);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

	}
	
	/**
	 * Performs actions implemented
	 */
	public void actionPerformed(ActionEvent e) {
		String buttonStr = e.getActionCommand();

		if (buttonStr.equals("AVL")){
			mode = "AVL";
			frame.setTitle("Loadshedding App ("+mode+")");
		}
		else if (buttonStr.equals("BST")){
			mode = "BST";
			frame.setTitle("Loadshedding App ("+mode+")");
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
					bs.printAreas(stage, date, time);

				} else if (buttonStr.equals("Search All")) {
					bs.printAllAreas();

				}
			break;
		}

	}
}
