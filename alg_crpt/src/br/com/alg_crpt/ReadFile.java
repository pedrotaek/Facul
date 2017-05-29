package br.com.alg_crpt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class ReadFile {

	//ATRIBUTOS PARA COLOCAR O CONTEUDO DO ARQUIVO
	public char conteudo;
	public int chave;
	public Criptografar cripto;
	
	public static void main(String[] args) {

		//cria objeto ReadFile para utilizar seus metodos
		ReadFile rf = new ReadFile();
		rf.menuUsuario();
	}
	
	public void msgBoasVindas() {
		System.out.println("Entrando na função de boas vindas...");
		System.out.println("**************************************");
		System.out.println("Leitor de arquivo");
		System.out.println("**************************************");
	}
	
	public void menuUsuario() {
		msgBoasVindas();
		System.out.println("Entrando na função de menu usuario");
		
		System.out.println("1. Criptografar"
							+ "\n2. Descriptografar"
							+ "\n3. Ler Arquivo"
							+ "\n0. Sair");
		
		int opcao = 0;
		try {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha a opção desejada:\n\n1. Criptografar\n2. Descriptografar\n3. Ler Arquivo\n0. Sair\n\n"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Informe uma opção válida","Alerta",JOptionPane.WARNING_MESSAGE);
		}
		
		switch (opcao) {
		case 1:
			criptografar();
			menuUsuario();
			break;
		case 2:
			descriptografar();
			menuUsuario();
			break;
		case 3:
			lerArquivo();
			menuUsuario();
			break;
		case 0:
			sair();
			break;
		default:
			JOptionPane.showMessageDialog(null,"Informe um arquivo válido","Alerta",JOptionPane.WARNING_MESSAGE);
			menuUsuario();
			break;
		}
	}
	
	public void criptografar() {
		int chave = 0;
		try {
			chave = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a chave para criptografar o arquivo:"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Informe um arquivo válido","Alerta",JOptionPane.WARNING_MESSAGE);
		}
		System.out.println("Chave informada: " + chave);
		//obtem o arquivo de origem 
		File arquivo1 = readOriginFile(), arquivo2 = readDestinyFile();
		cripto = new Criptografar(readContent(arquivo1), chave, arquivo2);
		JOptionPane.showMessageDialog(null,"Arquivo " + arquivo1.getName() + " criptografado com sucesso em " + cripto.getArquivoCriptografado().getName(),"Alerta",JOptionPane.WARNING_MESSAGE);
	}
	
	public void descriptografar() {
		cripto.env_descriptografar(readContent(cripto.arquivoCriptografado));
		JOptionPane.showMessageDialog(null,"Arquivo destino " + cripto.getArquivoCriptografado().getName() + " descriptografado com sucesso.","Alerta",JOptionPane.WARNING_MESSAGE);
	}
	
	public void lerArquivo() {
		String input = JOptionPane.showInputDialog(null, "Informe o arquivo que gostaria de exibir o conteúdo:");
		File f = null;
		
		try {
			f = new File(input);
		} catch (NullPointerException e) {
			System.out.println(msgNenhmArquivoEncontrado());;
		}
		JOptionPane.showMessageDialog(null,"O conteúdo do arquivo  " + f.getName() + " é:\n\n\n" + readContent(f),"Conteúdo do arquivo",JOptionPane.WARNING_MESSAGE);
	}
	
	public void sair() {
		System.gc();
		System.out.println("Saindo da aplicação!!!");
	}
	
	
	public File readOriginFile() {

		String input = JOptionPane.showInputDialog(null, "Informe o arquivo de origem:");
		File f = null;
		
		try {
			f = new File(input);
		} catch (NullPointerException e) {
			System.out.println(msgNenhmArquivoEncontrado());;
		}
		return f;
	}
	
	public String msgNenhmArquivoEncontrado() {
		return "Nenhum Arquivo Encontrado.";
	}
	
	public File readDestinyFile() {
		String input = JOptionPane.showInputDialog(null, "Informe o arquivo de destino:");
		File f = new File(input);
		return f;
	}
	
	public String readContent(File file) {
		
		String conteudo = "";
		FileReader fileReader = null;
		BufferedReader br = null;
				
		try {
			String line = null;
			fileReader = new FileReader(file.getAbsoluteFile());
			br = new BufferedReader(fileReader); 
			
			 while ((line = br.readLine()) != null) {
			      conteudo += line;
			 }
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println(msgNenhmArquivoEncontrado());;
		} finally {

			try {

				if (br != null)
					br.close();

				if (fileReader != null)
					fileReader.close();

			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return conteudo;
	}
}
