//package com.school42.swingy.window;
//
//import java.awt.Point;
//
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableModel;
//
//import com.school42.swingy.Main;
//
//import java.awt.Dimension;
//
//public class Card extends AbstractWidgetWindow {
//
//	private JPanel _panel = (JPanel)getContentPane();
//	private JScrollPane _scrollPane = null;
//	private DefaultTableModel _model = null;
//	private String [][] _map = null;
//	private JTable _table = null;
//
//	public Card(Point pos, Dimension size) {
//		super("Card", 500, 500);
//		placeRightUp(pos, size);
//
//		newGame();
//
//		setVisible(true);
//	}
//
//	public void newGame() {
//		_scrollPane = new JScrollPane();
//		_model = new DefaultTableModel();
//		_map = new String [Main.getSizeMap()][Main.getSizeMap()];
//		_table = new JTable(_model);
//
//		_panel.add(_scrollPane);
//
//		_table.setTableHeader(null);
//
//		for (int i = 0; i < Main.getSizeMap(); i++) {
//			_model.addColumn(i);
//		}
//		for (int i = 0; i < Main.getSizeMap(); i++) {
//			_table.getColumnModel().getColumn(i).setPreferredWidth(100);
//			_model.addRow(_map[i]);
//		}
//
//		_table.setRowHeight(100);
//
//		_table.setEnabled(false);
//
//		update();
//
//		_scrollPane.setViewportView(_table);
//
//		_scrollPane.setBounds(0, 0, 500, 500);
//	}
//
//	public void update() {
//		for (int y = 0; y < Main.getSizeMap(); y++) {
//			for (int x = 0; x < Main.getSizeMap(); x++) {
//				if (Main.getCurrentHero().getPoint().getX() == x
//					&& Main.getCurrentHero().getPoint().getY() == y)
//				{
//					_table.setValueAt("(" + x + "," + y + ") Your Here", y, x);
//				}
//				else {
//					_table.setValueAt("(" + x + "," + y + ")", y, x);
//				}
//			}
//		}
//	}
//
//}
