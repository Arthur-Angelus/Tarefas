package br.dev.arthur.tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.arthur.tarefas.factory.ArquivoFuncionarioFactory;
import br.dev.arthur.tarefas.factory.ArquivoTarefasFactory;
import br.dev.arthur.tarefas.model.Funcionario;
import br.dev.arthur.tarefas.model.Tarefas;

public class TarefasDAO {
	
	private Tarefas tarefa;
	private ArquivoTarefasFactory ff = new ArquivoTarefasFactory();
	
	public void TarefaDAO(Tarefas tarefa, Funcionario funcionario) {
		this.tarefa = tarefa;
	}
	
	public boolean gravar() {
		
		try {
			BufferedWriter bw = ff.getBw();
			bw.write(tarefa.toString());
			bw.flush();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}
	
	public List<Tarefas> getTarefas() {
		
		List<Tarefas> tarefas = new ArrayList<Tarefas>();
		FuncionarioDAO dao = new FuncionarioDAO(null);
		
		try {
			BufferedReader br = ff.getBr();
			
			String linha = "";
			
			while (linha != null) {
				
				linha = br.readLine();
				
				if(linha != null) {
					String[] tarefasVetor = linha.split(",");
					Tarefas tarefa = new Tarefas(linha);
					tarefa.setCodigo(tarefasVetor[0]);
					tarefa.setNome(tarefasVetor[1]); 
					tarefa.setDescricao(tarefasVetor[2]); 
					tarefa.setResponsavel(tarefasVetor[3]); 
					tarefa.setPrazo((int) Double.parseDouble(tarefasVetor[4]));
					tarefa.add(tarefa);
				}
			}
			
			return tarefas;
			
		} catch (IOException e) {
			e.printStackTrace();
			
			return null;
		}
		
		
		
	}

}
