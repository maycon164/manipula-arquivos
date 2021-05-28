package view;

import java.io.IOException;

import controller.ArquivosController;
import iController.IArquivosController;

public class View {

	public static void main(String[] args) {
		IArquivosController arqController = new ArquivosController();
		String dir = "C:\\Windows";
		String path = "C:\\Users\\maycon\\Documents";
		String name = "teste.txt";
		
		try {
			//arqController.readDir(dir);
			//arqController.createFile(path, name);
			//arqController.readFile(path, name);
			arqController.openFile(path, name);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
