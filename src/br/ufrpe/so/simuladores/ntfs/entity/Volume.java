package br.ufrpe.so.simuladores.ntfs.entity;

public class Volume {
	String nomeVolume;
	Bloco[] blocos;
	
	/**/
	public Volume(String nomeVolume, int tamListaBlocos) {
		this.nomeVolume = nomeVolume;
		blocos = new Bloco[tamListaBlocos];
	}

	public Bloco[] getBlocsDisp() {
		Bloco[] disponiveis = null;
		
		for (int i = 0; i < blocos.length; i++) {
			if (blocos[i].disponivel) {
				disponiveis = addListaDisp(disponiveis, blocos[i]);
			}
		}
		return null;
	}
	
	/**
	 * Atualiza lista de blocos disponíveis.
	 * 
	 * @param listaAtual
	 *            Ponteiro para a lista de blocos disponíveis no momento.
	          
	 * @return ponteiro para a lista de blocos ainda disponíveis no volume.
	 */
	public Bloco[] addListaDisp(Bloco[] listaAtual, Bloco novoBloco) {
		Bloco[] novaLista = null;
		
		if (listaAtual == null) {
			novaLista = new Bloco[1];
		}else {
			novaLista = new Bloco[listaAtual.length + 1];
		}
		
		for (int i = 0; i < novaLista.length; i++) {
			if (i <= listaAtual.length) {
				novaLista[i] = listaAtual[i];
			}else {
				novaLista[i] = novoBloco;
			}
			
		}
		
		return novaLista;
	}

}
