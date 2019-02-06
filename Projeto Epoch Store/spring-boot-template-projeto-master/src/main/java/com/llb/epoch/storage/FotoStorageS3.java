package com.llb.epoch.storage;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;

@Profile("storage-s3")
@Component
public class FotoStorageS3 implements FotoStorage{
	
	@Autowired
	private AmazonS3 s3Client;
	
	@Override
	public String salvar(MultipartFile foto, String nomeFoto){
		try {
			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setContentType(foto.getContentType());
			metadata.setContentLength(foto.getSize());
			s3Client.putObject("epoch", nomeFoto, foto.getInputStream(), metadata);
		} catch (AmazonClientException | IOException ex) {
			throw new RuntimeException("Erro salvando arquivo no S3!", ex);
		}
		return nomeFoto;
	}
	
	@Override
	public String getUrl(String nomeFoto) {
		return "http://localhost:9444/s3/epoch/" + nomeFoto + "?noAuth=true";
	}
}
