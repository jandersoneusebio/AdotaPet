package actions;

import javax.swing.*;

import frames.LoginFrame;

public class Actions{
	
	LoginFrame login = new LoginFrame();
	
	
	void sair() {
		int op = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "AdotaPet", JOptionPane.YES_NO_OPTION);
		if (op == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	
}
