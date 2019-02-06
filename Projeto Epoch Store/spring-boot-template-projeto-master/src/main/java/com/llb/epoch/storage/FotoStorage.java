package com.llb.epoch.storage;

import org.springframework.web.multipart.MultipartFile;

public interface FotoStorage {
	public String salvar(MultipartFile foto, String nomeFoto);
	public String getUrl(String nomeFoto);
}
