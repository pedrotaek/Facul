package br.com.alg_crpt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Criptografar {
	
	public int tamanho;
	public String conteudo;
	public int chave;
	public File arquivoCriptografado;
	
	public Criptografar(String conteudo, int chave, File arquivo) {
		setConteudo(conteudo);
		setChave(chave);
		setArquivoCriptografado(arquivo);
		env_criptografar(getConteudo(), arquivo, getChave());
	}
	
	public File env_criptografar(String conteudo, File arquivo, int chave) {
		
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		try {

			fw = new FileWriter(arquivo);
			bw = new BufferedWriter(fw);
			for(int i = 0; i < conteudo.length(); i++) {
				char c = conteudo.charAt(i);
				//criptografia adotada
				bw.write(((int) c + chave) % 256);
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {
				ex.printStackTrace();
			}
	}
		return null;
	}
	
	public void env_descriptografar(String conteudo) {
		
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			fw = new FileWriter(getArquivoCriptografado());
			bw = new BufferedWriter(fw);
			for(int i = 0; i < conteudo.length(); i++) {
				char c = conteudo.charAt(i);
				//criptografia adotada
				bw.write((((int) c) - chave) % 256);
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}

	public File getArquivoCriptografado() {
		return arquivoCriptografado;
	}

	public void setArquivoCriptografado(File arquivo) {
		this.arquivoCriptografado = arquivo;
	}
}
