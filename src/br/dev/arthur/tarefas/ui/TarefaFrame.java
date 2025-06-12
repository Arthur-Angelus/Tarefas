package br.dev.arthur.tarefas.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.dev.arthur.tarefas.dao.FuncionarioDAO;
import br.dev.arthur.tarefas.dao.TarefasDAO;
import br.dev.arthur.tarefas.model.Funcionario;
import br.dev.arthur.tarefas.model.Tarefas;
import br.dev.arthur.tarefas.utils.Utils;

public class TarefaFrame {
	
	private JLabel labelCodigo;
	private JLabel labelNome;
	private JLabel labelDescricao;
	private JLabel labelResponsavel;
	private JLabel labelDataInicio;
	private JLabel labeDataEntrega;
	private JLabel labelPrazo;
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextField txtDescricao;
	private JTextField txtResponsavel;
	private JTextField txtDataInicio;
	private JTextField txtDataEntrega;
	private JTextField txtPrazo;
	private JButton btnSalvar;
	private JButton btnSair;
	
	public TarefaFrame(JFrame pai) {
		criarTela(pai);
	}
	
	private void criarTela(JFrame pai) {
		JDialog telaTarefa = new JDialog(pai,"Cadastro Tarefas", true);
		telaTarefa.setSize(500, 500);
		telaTarefa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		telaTarefa.setLayout(null);
		telaTarefa.setResizable(false);
		telaTarefa.setLocationRelativeTo(null);
		
		Container painel = telaTarefa.getContentPane();
		
		labelCodigo = new JLabel("Codigo");
		labelCodigo.setBounds(10, 20, 150, 30);
		txtCodigo = new JTextField();
		txtCodigo.setBounds(10, 50, 150, 30);
		txtCodigo.setEnabled(false);
		txtCodigo.setText(Utils.gerarUUID8());
		
		
		labelNome = new JLabel("Nome:");
		labelNome.setBounds(10, 85, 150, 30);
		txtNome = new JTextField();
		txtNome.setBounds(10, 115, 350, 30);
		
		labelDescricao = new JLabel("Descricao:");
		labelDescricao.setBounds(10, 150, 150, 30);
		txtDescricao = new JTextField();
		txtDescricao.setBounds(10, 180, 250, 30);
		
		labelResponsavel = new JLabel("Responsavel:");
		labelResponsavel.setBounds(10, 215, 150, 30);
		txtResponsavel = new JTextField();
		txtResponsavel.setBounds(10, 245, 200, 30);
		
		labelPrazo = new JLabel("Prazo:");
		labelPrazo.setBounds(10, 280, 150, 30);
		txtPrazo = new JTextField();
		txtPrazo.setBounds(10, 310, 150, 30);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 380, 200, 40);
		btnSalvar.setOpaque(true);
		btnSalvar.setBackground(Color.GREEN);
		btnSalvar.setBorderPainted(false);
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(220, 380, 120, 40);
		btnSair.setOpaque(true);
		btnSair.setBackground(Color.RED);
		btnSair.setBorderPainted(false);
		
		painel.add(labelCodigo);
		painel.add(txtCodigo);
		painel.add(labelNome);
		painel.add(txtNome);
		painel.add(labelDescricao);
		painel.add(txtDescricao);
		painel.add(labelResponsavel);
		painel.add(txtResponsavel);
		painel.add(labelPrazo);
		painel.add(txtPrazo);
		painel.add(btnSalvar);
		painel.add(btnSair);
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Tarefas t = new Tarefas(txtNome.getText());
				t.setCodigo(txtCodigo.getText());
				t.setDescricao(txtDescricao.getText());
				t.setResponsavel(txtResponsavel.getText());
				int prazo = (int) Double.parseDouble(txtPrazo.getText());
				t.setPrazo(prazo);
				
				TarefasDAO dao = new TarefasDAO(t);
				boolean sucesso = dao.gravar();
				
				if (sucesso) {
					JOptionPane.showMessageDialog(telaTarefa, "Tarefa gravada com sucesso!");
					limparFormulario();
				} else {
					JOptionPane.showMessageDialog(telaTarefa, "Ocorreu um erro na gravação. FAZ O L!!!\nTente novamente.\nSe o problema persistir entre em contaro com o suporte.");
				}
				
				
				
			}
		});
		
		btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(telaTarefa, "Sair do sistema seu covarde?", "Atenção maricas", JOptionPane.YES_NO_OPTION);
				
				if (resposta == 0) {
				JOptionPane.showMessageDialog(telaTarefa, "É uma bichona mesmo");
				telaTarefa.dispose();
				
				}
			}
		});
		
		telaTarefa.setVisible(true);
	}
	
	private void limparFormulario() {
		txtCodigo.setText(Utils.gerarUUID8());
		txtNome.setText(null);
		txtDescricao.setText(null);
		txtResponsavel.setText(null);
		txtPrazo.setText(null);
		txtNome.requestFocus();
	}
	

}
