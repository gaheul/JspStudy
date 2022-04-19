package web.service;

import java.util.ArrayList;

import repository.FileDao;
import repository.file.FileEntity;
import web.dto.FileResponseDto;

public class FileServiceImpl implements FileService {
	private FileDao fileDao;
	
	public FileServiceImpl(FileDao fileDao) {
		this.fileDao = fileDao;
	}
	
	@Override
	public boolean uploadFile(ArrayList<String> fileList) {
		return fileDao.uploadFile(fileList) > 0;
	}
	
	@Override
	public ArrayList<FileResponseDto> getImgListAll() {
		ArrayList<FileEntity> imgList = fileDao.getImgListALL();
		ArrayList<FileResponseDto> fileResponseDtos = new ArrayList<FileResponseDto>();
		for(FileEntity entity : imgList) {
			fileResponseDtos.add(entity.toDto()); //entity를 dto로 변환
		}
		
		return fileResponseDtos;
	}
}
