package com.llb.epoch.storage;

import static java.nio.file.FileSystems.getDefault;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Profile("storage-local")
@Component
public class FotoStorageLocal implements FotoStorage, FotoReader{
	
	private Path local;
	
	public FotoStorageLocal() {
		this.local = getDefault().getPath(System.getenv("HOME"), ".epochfotos");
		try {
			Files.createDirectories(this.local);
		}catch(IOException ex) {
			throw new RuntimeException("Erro ao criar pasta para salvar imagens", ex);
		}
	}
	
	@Override
	public String salvar(MultipartFile foto, String nomeFoto) {
		try {
			foto.transferTo(new File(this.local.toAbsolutePath().toString() + getDefault().getSeparator() + nomeFoto));
		}catch (IOException ex) {
			throw new RuntimeException("Erro ao salvar a foto", ex);
		}
		return nomeFoto;
	}

	@Override
	public String getUrl(String nomeFoto) {
		return "http://localhost:8080/fotos/" + nomeFoto;
	}

	@Override
	public byte[] recuperar(String nome) {
		try {
			return Files.readAllBytes(this.local.resolve(nome));
		} catch (IOException ex) {
			throw new RuntimeException("Erro ao recuperar a foto", ex);
		}
	}

}
