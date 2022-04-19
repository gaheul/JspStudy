package web.service;

import java.util.ArrayList;

import web.dto.FileResponseDto;

public interface FileService {
	public boolean uploadFile(ArrayList<String> fileList);
	public ArrayList<FileResponseDto> getImgListAll();
}
