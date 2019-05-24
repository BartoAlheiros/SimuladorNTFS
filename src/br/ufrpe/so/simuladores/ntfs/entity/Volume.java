package br.ufrpe.so.simuladores.ntfs.entity;

public class Volume {
	Bloco[] listaBlocos;
	
	/**/
	public Volume(int tamListaBlocos) {
		listaBlocos = new Bloco[tamListaBlocos];
	}
	
}
