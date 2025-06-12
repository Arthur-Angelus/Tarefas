package br.dev.arthur.tarefas.model;

import java.time.LocalDate;

import br.dev.arthur.tarefas.utils.Utils;

public class Tarefas {

	private String nome;
	private String descricao;
	private String codigo;
	private Funcionario responsavel;
	private LocalDate dataInicio;
	private int prazo;
	private LocalDate dataEntrega;
	private Status status;
	
	public Tarefas(String nome) {
		setCodigo(Utils.gerarUUID8());
		setResponsavel(responsavel);
	}
	
	public Tarefas(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
		this.codigo = Utils.gerarUUID8();
	}
	
	public Tarefas(Funcionario responsavel) {
		this.responsavel = responsavel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Funcionario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Funcionario responsavel) {
		this.responsavel = responsavel;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public int getPrazo() {
		return prazo;
	}

	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}

	public LocalDate getDataPrevistaEntrega() {
		return dataInicio.plusDays(prazo);
		
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Status getStatus() {
		
		LocalDate hoje = LocalDate.now();
		hoje.isAfter(dataEntrega);
		
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public String toString() {
		return codigo + "," + nome + "," + descricao + "," + responsavel + 
				"," + dataInicio + "," + prazo + 
				"," + dataEntrega + "," + status + "\n";
	}


}
