package repository;

import repository.user.User;

public interface UserDao {
	public int UpdataUserByUserCode(User user);
	public int updatePasswordByUserCode(int userCode,String password); //비밀번호 변경
	public int deleteUser(int userCode);
}
