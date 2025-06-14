package br.dev.arthur.tarefas.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.dev.arthur.tarefas.dao.FuncionarioDAO;
import br.dev.arthur.tarefas.model.Funcionario;

public class FuncionarioListaFrame {
	
	private JLabel labelTitulo;
	private JButton btnNovo;
	private JButton btnSair;
	private DefaultTableModel model;
	private JTable tabelaFuncionarios;
	private JScrollPane scrollFuncionarios;
	private String[] colunas = {"CÓDIGO", "NOME FUNCIONÁRIO", "CARGO"};
	
	public FuncionarioListaFrame() {
		criarTela();
	}

	private void criarTela() {
		JFrame telaFuncionarioLista = new JFrame("Lista de Funcionários");
		telaFuncionarioLista.setSize(700, 500);
		telaFuncionarioLista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaFuncionarioLista.setLayout(null);
		telaFuncionarioLista.setLocationRelativeTo(null);
		telaFuncionarioLista.setResizable(false);
		
		Container painel = telaFuncionarioLista.getContentPane();
		
		labelTitulo = new JLabel("Cadastro de Funcionários");
		labelTitulo.setBounds(10, 10, 500, 40);
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 32));
		labelTitulo.setForeground(Color.red);
		
		model = new DefaultTableModel(colunas, 100);
		tabelaFuncionarios = new JTable(model);
		scrollFuncionarios = new JScrollPane(tabelaFuncionarios);
		scrollFuncionarios.setBounds(10, 70, 680, 300);
		
		btnNovo = new JButton("Novo Funcionario");
		btnNovo.setBounds(150, 380, 200, 50);
		
		btnNovo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(telaFuncionarioLista, "Criar novo funcionario?", "Atenção maricas", JOptionPane.YES_NO_OPTION);
				
				if (resposta == 0) {
					JOptionPane.showMessageDialog(telaFuncionarioLista, "Não vacila");
					new FuncionarioFrame(telaFuncionarioLista);
					carregarDadosTabela();
				}
				
				if (resposta == 1) {
					JOptionPane.showMessageDialog(telaFuncionarioLista, "Ta com medo?");
					System.exit(JFrame.EXIT_ON_CLOSE);
				}
			}
		});
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(370, 380, 200, 50);
		
		btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(telaFuncionarioLista, "Sair do sistema seu covarde?", "Atenção maricas", JOptionPane.YES_NO_OPTION);
				
				if (resposta == 0) {
				JOptionPane.showMessageDialog(telaFuncionarioLista, "É uma bichona mesmo");
				System.exit(JFrame.EXIT_ON_CLOSE);
				
				}
			}
		});
		
		carregarDadosTabela();
		
		painel.add(labelTitulo);
		painel.add(scrollFuncionarios);
		painel.add(btnNovo);
		painel.add(btnSair);
		
		telaFuncionarioLista.setVisible(true);
	}
	
	private void carregarDadosTabela() {
		
		List<Funcionario> funcionarios = new ArrayList<>();
		
		FuncionarioDAO dao = new FuncionarioDAO(null);
		funcionarios = dao.getFuncionarios();
		
		int i = 0;
		
		Object[][] dados = new Object[funcionarios.size()][3];
		
		for(Funcionario f : funcionarios) {
			dados[i][0] = f.getMatricula();
			dados[i][1] = f.getNome();
			dados[i][2] = f.getCargo();
			i++;
		}
		
		model.setDataVector(dados, colunas);
		
		
		
	}

}
