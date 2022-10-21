package main.java;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.*;

import main.java.hero.Hero;		

public class Window implements ActionListener, ListSelectionListener {
	
	private JFrame frame;
	private JButton btnNewHero, 
					btnCreateHero,
					btnCancelCreateHero,
					btnLoadHero,
					btnNorth,
					btnEast,
					btnSouth,
					btnWest,
					btnFight,
					btnRun;
	private JTextField inputNameHero;
	private JComboBox<String> heroConboBox;
	private CaretListener validateInputNameHero;
	private JList<Hero> heroList;
	private JTextArea statHero;
	private Border border;
	private Map<String, ImageIcon> imgClass;
	private JLabel usingImgDescription, usingImgStat;

	public Window(Vector<Hero> heros, Vector<String> classHero) {
		frame = new JFrame();
		btnNewHero = new JButton("New Hero");
		btnCreateHero = new JButton("Create");
		btnCancelCreateHero = new JButton("Cancel");
		btnLoadHero = new JButton("Load");
		inputNameHero = new JTextField();
		heroConboBox = new JComboBox<String>(classHero);
		validateInputNameHero = new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				JTextField text = (JTextField)e.getSource();
				String tmp = text.getText();
				if (tmp.length() == 0)
					btnCreateHero.setEnabled(false);
				else
					btnCreateHero.setEnabled(true);
			}
		};
		btnCreateHero.setEnabled(false);
		inputNameHero.addCaretListener(validateInputNameHero);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		heroList = new JList<Hero>(heros);
		heroList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		statHero = new JTextArea();
		border = BorderFactory.createLineBorder(Color.BLACK);
    	statHero.setBorder(border);
		statHero.setEditable(false);
		btnLoadHero.setEnabled(false);

		btnNorth = new JButton("North");
		btnEast = new JButton("East");
		btnSouth = new JButton("South");
		btnWest = new JButton("West");

		btnFight = new JButton("Fight");
		btnRun = new JButton("Run");

		btnNorth.setEnabled(false);
		btnSouth.setEnabled(false);
		btnWest.setEnabled(false);
		btnEast.setEnabled(false);;

		btnFight.setEnabled(false);
		btnRun.setEnabled(false);

		imgClass = new HashMap<String, ImageIcon>();

		getAllImg(classHero);

		usingImgStat = new JLabel();
		usingImgDescription = new JLabel();
	}

	private void clearFrame(String title, int width, int height) {
		frame.getContentPane().removeAll();
 		frame.repaint();
		frame.setSize(width, height);
		frame.setVisible(true);
		frame.setTitle(title);
		frame.setLayout(null);
	}

	public void mainMenu() {
		clearFrame("Main menu", 500, 500);
		
		JPanel panel = (JPanel)frame.getContentPane();
		JScrollPane scrollPane = new JScrollPane();
		JLabel herosLabel = new JLabel("HEROS");
		JLabel statLabel = new JLabel("STATS");

		panel.add(btnNewHero);
		scrollPane.setViewportView(heroList);
		panel.add(scrollPane);
		panel.add(herosLabel);
		panel.add(statHero);
		panel.add(statLabel);
		panel.add(btnLoadHero);
		panel.add(usingImgStat);

		btnNewHero.setBounds(0, 0, 100, 30);
		btnNewHero.addActionListener(this);

		btnLoadHero.setBounds(100, 0, 100, 30);
		btnLoadHero.addActionListener(this);

		herosLabel.setBounds(90, 22, 200, 50);
		scrollPane.setBounds(10, 60, 200, 400);

		statLabel.setBounds(320, 22, 200, 50);
		statHero.setBounds(220, 60, 270, 210);

		usingImgStat.setBounds(250, 260, 200, 200);

		heroList.addListSelectionListener(this);
	}

	private ImageIcon getImg(String name, int width, int height) {
		ImageIcon warlock = new ImageIcon(getClass().getClassLoader().getResource(name));
		Image img = warlock.getImage();
		Image newimg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return (new ImageIcon(newimg));
	}

	private void getAllImg(Vector<String> classHero) {
		for (String classNameHero : classHero) {
			imgClass.put(classNameHero,
						getImg(classNameHero.toLowerCase() + ".jpg",
								200,
								200));
		}
	}

	private void createHero() {
		clearFrame("Create Hero", 400, 400);

		JLabel nameLabel = new JLabel("Name:");
		JLabel classNameLabel = new JLabel("Class:");
		JPanel panel = (JPanel)frame.getContentPane();
		String item = heroConboBox.getSelectedItem().toString();
		
		usingImgDescription.setIcon(imgClass.get(item));

		panel.add(btnCreateHero);
		panel.add(nameLabel);
		panel.add(inputNameHero);
		panel.add(heroConboBox);
		panel.add(classNameLabel);
		panel.add(btnCancelCreateHero);
		panel.add(usingImgDescription);

		nameLabel.setBounds(10, 30, 80, 30);
		inputNameHero.setBounds(90, 30, 300, 30);

		classNameLabel.setBounds(10, 60, 80, 30);
		heroConboBox.setBounds(90, 60, 300, 30);

		btnCreateHero.setBounds(75, 330, 100, 30);
		btnCancelCreateHero.setBounds(215, 330, 100, 30);

		usingImgDescription.setBounds(100, 105, 200, 200);
	
		btnCreateHero.addActionListener(this);
		btnCancelCreateHero.addActionListener(this);
		heroConboBox.addActionListener(this);
	}

	private void cardGame() {
		clearFrame("Game", 520, 750);

		JPanel panel = (JPanel)frame.getContentPane();
		JScrollPane scrollPane = new JScrollPane();

		panel.add(scrollPane);
		panel.add(btnNorth);
		panel.add(btnEast);
		panel.add(btnSouth);
		panel.add(btnWest);
		panel.add(btnFight);
		panel.add(btnRun);

		// scrollPane.setViewportView(ITENM);
		// int sizeMap = currentHero.getSizeMap();

		scrollPane.setBounds(10, 10, 500, 500);

		btnNorth.setBounds(70, 550, 100, 30);
		btnSouth.setBounds(70, 650, 100, 30);
		btnWest.setBounds(20, 600, 100, 30);
		btnEast.setBounds(120, 600, 100, 30);

		btnFight.setBounds(360, 570, 100, 30);
		btnRun.setBounds(300, 630, 100, 30);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelCreateHero)
			mainMenu();
		else if (e.getSource() == btnNewHero)
			createHero();
		else if (e.getSource() == btnCreateHero) {
			String name = inputNameHero.getText();
			String className = (String)heroConboBox.getSelectedItem();
			if (!Utils.addHero(name, className))
				return ;
			inputNameHero.setText("");
			mainMenu();
		} else if (e.getSource() == btnLoadHero) {
			cardGame();
		} else if (e.getSource() == heroConboBox) {
			String item = heroConboBox.getSelectedItem().toString();
			usingImgDescription.setIcon(imgClass.get(item));
			System.out.println(item);
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getSource() == heroList) {
			Hero hero = heroList.getSelectedValue();
			statHero.selectAll();
    		statHero.replaceSelection("");
			statHero.append(hero.getStat());
			btnLoadHero.setEnabled(true);
			Game.currentHero = hero;
			usingImgStat.setIcon(imgClass.get(hero.getClassName()));
		}
	}

}
