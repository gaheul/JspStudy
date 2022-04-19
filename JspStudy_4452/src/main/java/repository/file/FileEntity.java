package repository.file;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import web.dto.FileResponseDto;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FileEntity {
	private int file_code;
	private String file_name;
	private LocalDateTime create_date;
	private LocalDateTime update_date;
	
	public FileResponseDto toDto() {//toDto -> dto로 변환
		return FileResponseDto.builder()
				.fileCode(file_code)
				.fileName(file_name)
				.createDate(create_date)
				.updateDate(update_date)
				.build();
	}
}
