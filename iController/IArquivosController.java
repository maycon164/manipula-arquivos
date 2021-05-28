package iController;

import java.io.IOException;

public interface IArquivosController {

	void readDir(String path) throws IOException;
	void createFile(String path, String name) throws IOException;
	void readFile(String path, String name) throws IOException;
	void openFile(String path, String name) throws IOException;
}
