package br.ufrpe.so.simuladores.ntfs.entity;

import java.io.File;
import java.io.IOException;

public class Bloco {
	/* Arquivo do qual este bloco faz parte. */ 
	private String nomeArquivo; 
	private String nomeBloco;
	boolean disponivel;
	
	public Bloco() {
		
	}
	
	public Bloco(String nomeArquivo, String nomeBloco) {
		this.nomeArquivo = nomeArquivo;
		this.nomeBloco = nomeBloco;
	}
	
	public File criaBloco() throws IOException {
		File f = new File("D:\\eclipse-workspace\\MiniSimuladorSistemaArquivosNTFS\\arquivos\\" + nomeBloco + ".arq");
		return f;
	}

	public void setNomeBloco(String nomeBloco) {
		this.nomeBloco = nomeBloco;
	}

	public void aloca(String nomeArquivo, String nomeBloco) {
		if (this.disponivel) {
			this.disponivel = false;
			this.nomeArquivo = nomeArquivo;
			this.nomeBloco = nomeBloco;
		}
	}
}
