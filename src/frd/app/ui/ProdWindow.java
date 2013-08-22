package frd.app.ui;

import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import frd.app.ui.components.CancelButton;
import frd.db.ProductManager;
import frd.model.Product;

public class ProdWindow extends JDialog{

	JLabel title = new JLabel("Productos");
	JButton cancel = new CancelButton(this);

	public ProdWindow(){
		
		getContentPane().setLayout(new GridLayout(3,1));
		getContentPane().add(title);

		String[] columnNames = {"ID","NOMBRE","DESCRIPCION"};
		Object[][] rowData = null;

		try {
			List<Product> products = ProductManager.getProducts();
			rowData = new Object[products.size()][3];
			int i = 0;
			for( Product u : products ){
				rowData[i][0] = u.getId();
				rowData[i][1] = u.getName();
				rowData[i][2] = u.getLots();
				rowData[i++][3] = u.getDescription();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JTable table = new JTable(rowData, columnNames);
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane);
		getContentPane().add(cancel);
		setSize(300, 400);
		setVisible(true);
	}
}
