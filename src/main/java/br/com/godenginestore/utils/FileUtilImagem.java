package br.com.godenginestore.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUtilImagem {
	public void salvarImagem(String path, MultipartFile imagem) {
		File file = new File(path);
		try {
			FileUtils.writeByteArrayToFile(file, imagem.getBytes());
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}
