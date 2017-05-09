package br.com.alg_crpt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class LerArquivo {
	
	public static void main(String[] args) {
		LerArquivo la = new LerArquivo();
		File fOrigem = la.readOriginFile();
		//File fDestino = la.readDestinyFile();
		
		//ler conteudo do arquivo de origem
		la.readContent(fOrigem);
	}
	
	public File readOriginFile() {
		String input = JOptionPane.showInputDialog(null, "Informe o arquivo de origem:");
		File f = new File(input);
		return f;
	}
	
	public File readDestinyFile() {
		String input = JOptionPane.showInputDialog(null, "Informe o arquivo de destino:");
		File f = new File(input);
		return f;
	}
	
	public String readContent(File file) {

		try {
			FileReader fileReader = new FileReader(file.getAbsoluteFile());
			BufferedReader br = new BufferedReader(fileReader);
			String line = null;
			
			 while ((line = br.readLine()) != null) {
			      System.out.println(line);
			 }
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
