package repository.user;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User { //db의 정보를 담고있는 entity클래스
	private int user_code;
	private String username;
	private String password;
	private String name;
	private String email;
	private LocalDateTime create_date;
	private LocalDateTime update_date;
}
