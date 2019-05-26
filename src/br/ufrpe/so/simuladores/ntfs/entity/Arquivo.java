package br.ufrpe.so.simuladores.ntfs.entity;

public class Arquivo {
	Volume volume;
	String nomeArquivo;
	
	public Arquivo(String nomeArquivo, Volume volume) {
		this.volume = volume;
		this.nomeArquivo = nomeArquivo;
	}
	
	/**
	 * Aloca o arquivo na unidade de disco.
	 * 
	 * @param tam
	 *            tamanho do arquivo cuja lista de blocos é retornada.
	 * @return ponteiro para a lista de blocos do arquivo criado.
	 */
	public void aloca() {
		/* Blocos ainda disponíveis para alocacão.*/
		Bloco[] blocos = this.volume.getBlocsDisp();
		
	}
}
