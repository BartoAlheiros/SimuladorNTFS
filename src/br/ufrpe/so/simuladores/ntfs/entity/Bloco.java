package br.ufrpe.so.simuladores.ntfs.entity;

import java.io.File;
import java.io.IOException;

public class Bloco {
	private String nomeBloco; 
	
	public Bloco(String nomeBloco) {
		this.nomeBloco = nomeBloco;
	}
	
	public File criaBloco() throws IOException {
		File f = new File("D:\\eclipse-workspace\\MiniSimuladorSistemaArquivosNTFS\\arquivos\\" + nomeBloco + ".arq");
		return f;
	}
}
