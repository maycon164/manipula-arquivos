package controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import iController.IArquivosController;

public class ArquivosController implements IArquivosController {

	public ArquivosController() {
	}

	@Override
	public void readDir(String path) throws IOException {
		File file = new File(path);

		if (file.exists() && file.isDirectory()) {
			File[] files = file.listFiles();
						
			for (File f : files) {
				System.out.println((f.isDirectory()? "<DIR>": "     ") + "\t" + f.getName());
			}
			
		}else {
			
			throw new IOException("Diretorio Invalido");
		}
	}

	@Override
	public void createFile(String path, String name) throws IOException {
		File dir = new File(path);
		File arq = new File(path, name + ".txt");
		if(dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			
			if(arq.exists()) {
				existe = true;
			}
			String conteudo = geraConteudo();
			FileWriter fileWriter = new FileWriter(arq, existe);
			PrintWriter print = new PrintWriter(fileWriter);
			print.write(conteudo);
			print.flush();
			print.close();
			fileWriter.close();
			
		}else {
			throw new IOException("Diretorio Invalido");
		}
	}

	private String geraConteudo() {
		StringBuffer buffer = new StringBuffer();
		String linha = "";
		
		while (!linha.equalsIgnoreCase("fim")) {
			linha = JOptionPane.showInputDialog(null, "DIGITE UMA FRASE: ", "Entrada de Texto", JOptionPane.INFORMATION_MESSAGE);
			
			if(!linha.equalsIgnoreCase("fim")) {
				buffer.append(linha + "\n");
			}
		}
		
		return buffer.toString();
	}

	@Override
	public void readFile(String path, String name) throws IOException {
		 	File arq = new File(path, name);
	
		 	if(arq.exists() && arq.isFile()) {
		 		FileInputStream stream = new FileInputStream(arq);
		 		InputStreamReader leitor = new InputStreamReader(stream);
		 		BufferedReader buffer = new BufferedReader(leitor);
		 		String linha = buffer.readLine();
		 		while(linha != null) {
		 			System.out.println(linha);
		 			linha = buffer.readLine();
		 		}
		 		buffer.close();
		 		leitor.close();
		 		stream.close();
		 	}else {
		 		throw new IOException("Arquivo Invalido");
		 	}	
	}

	@Override
	public void openFile(String path, String name) throws IOException {
		File file = new File(path, name);
		
		if(file.exists() && file.isFile()) {
			Desktop desk = Desktop.getDesktop();
			desk.open(file);
		}else {
	 		throw new IOException("Arquivo Invalido");
	 	}	
	}

}
