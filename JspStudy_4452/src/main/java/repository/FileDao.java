package repository;

import java.util.ArrayList;

import repository.file.FileEntity;

public interface FileDao {
	public int uploadFile(ArrayList<String> fileList);
	public ArrayList<FileEntity> getImgListALL();
}
