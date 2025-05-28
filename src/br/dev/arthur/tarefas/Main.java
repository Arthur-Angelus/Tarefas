package br.dev.arthur.tarefas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import br.dev.arthur.tarefas.dao.FuncionarioDAO;
import br.dev.arthur.tarefas.model.Funcionario;
import br.dev.arthur.tarefas.model.Status;
import br.dev.arthur.tarefas.model.Tarefa;
import br.dev.arthur.tarefas.utils.Utils;

public class Main {

	public static void main(String[] args) {
		
		Funcionario funcionario = new Funcionario("Thomas Turbando", "Programador");
		funcionario.setSetor("Tecnologia da Informação");
		funcionario.setSalario(6987.98);
		
		FuncionarioDAO dao = new FuncionarioDAO(funcionario);
		dao.gravar();
		
		//testarLeituraEscritaArquivo();
		
	}

	@SuppressWarnings("unused")
	private static void testarLeituraEscritaArquivo() {
		String so = System.getProperty("os.name");
		System.out.println(so);
		
		String caminho = "/users/25132783/projetoTarefas/tarefas";
		
		FileReader fr = null;
		BufferedReader br = null;
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fr = new FileReader(caminho);
			br = new BufferedReader(fr);
			
			fw = new FileWriter(caminho, true);
			bw = new BufferedWriter(fw);
			
			bw.append("\nArthur");
			bw.flush();
			
			String linha = br.readLine();
			
		while (linha != null) {
				System.out.println(linha);
				linha = br.readLine();
			}
			
		} catch (FileNotFoundException erro) {
			System.out.println("arquivo não encontrado!");
		}catch (IOException erro) {
			System.out.println("o arquivo está protegido para leitura!");
		}catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
	}

}
