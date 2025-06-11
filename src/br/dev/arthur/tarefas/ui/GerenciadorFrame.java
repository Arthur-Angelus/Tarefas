package br.dev.arthur.tarefas.ui;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GerenciadorFrame {

	private JButton btnFuncionario;
	private JButton btnTarefas;
	
	public void TarefaFrame(JFrame pai) {
		criarTela(pai);
	}
	
	private void criarTela(JFrame pai) {
		JFrame telaGerenciador = new JFrame("Gerenciador");
		telaGerenciador.setSize(335, 120);
		telaGerenciador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaGerenciador.setLayout(null);
		telaGerenciador.setResizable(false);
		telaGerenciador.setLocationRelativeTo(null);
		
		btnFuncionario = new JButton("Funcionários");
		btnFuncionario.setBounds(20, 20, 120, 40);

		btnTarefas = new JButton("Tarefas");
		btnTarefas.setBounds(180, 20, 120, 40);
		
		Container painel = telaGerenciador.getContentPane();
		
		painel.add(btnFuncionario);
		painel.add(btnTarefas);
		
		telaGerenciador.setVisible(true);
	
	}
}
