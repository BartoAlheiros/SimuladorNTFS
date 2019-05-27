package br.ufrpe.so.simuladores.ntfs.entity;

import java.io.File;
import java.io.IOException;

public class Bloco {
	/* Arquivo do qual este bloco faz parte. */ 
	public String nomeArquivo; 
	public String nome;
	boolean disponivel;
	
	public Bloco() {
		
	}
	
	public Bloco(String nomeArquivo, String nomeBloco) {
		this.nomeArquivo = nomeArquivo;
		this.nome = nomeBloco;
	}
	
	public File criaBloco() throws IOException {
		File f = new File("D:\\eclipse-workspace\\MiniSimuladorSistemaArquivosNTFS\\arquivos\\" + nome + ".arq");
		return f;
	}

	public void aloca(String nomeArquivo, String nomeBloco) {
		if (this.disponivel) {
			this.disponivel = false;
			this.nomeArquivo = nomeArquivo;
			this.nome = nomeBloco;
		}
	}
}
