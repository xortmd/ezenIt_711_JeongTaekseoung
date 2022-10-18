package user;

import java.util.ArrayList;

public class UserDao {
	
	private ArrayList<UserDto> list;
	
	private UserDao() {
		this.list = new ArrayList<UserDto>();
	}
	
	private static UserDao instance = new UserDao();
	
	public static UserDao getInsetance() {
		return instance;
	}
	
	// CRUD
	// 1. CREATE(add)
	public boolean checkDupl(String id) {
		boolean dupl = false;
		
		for(UserDto user : this.list) {
			if(id.equals(user.getId()))
				dupl = true;
		}
		
		return dupl;
	}
	
	public boolean addUser(String name, String id, String password) {
		if(!checkDupl(id)) {
			UserDto user = new UserDto(name, id, password);
			this.list.add(user);
			return true;
		}
		return false;
	}
	
	public boolean addUser(UserDto user) {
		if(!checkDupl(user.getId())) {
			this.list.add(user);
			return true;
		}
		return false;
	}
	
	// 2. READ(get)
	public UserDto getUser(String id) {
		UserDto result = null;
		
		for(UserDto user : this.list) {
			if(id.equals(user.getId())) {
				UserDto userDto = new UserDto(user.getName(), user.getId(), user.getPassword());
				result = userDto;
			}
		}
		
		return result;
	}
	
	public ArrayList<UserDto> getUserAll() {
		ArrayList<UserDto> result = new ArrayList<>();
		
		for(UserDto user : this.list) {
			result.add(user);
		}
		
		return result;
	}
	
	// 3. UPDATE(set)
	public void setUser(UserDto userDto) {
		
		int index = -1;
		for(int i = 0; i < this.list.size(); i++)
			if(userDto.getId().equals(this.list.get(i).getId()))
				index = i;
		
		if(index != -1)
			this.list.set(index, userDto);
	}
	
	public void setUser(String name, String id, String password) {
		UserDto user = getUser(id);
		if(user != null) {
			user.setName(name);
			user.setPassword(password);
			setUser(user);
		}
	}
	
	// 4. DELETE(remove)
	public ArrayList<UserDto> removeUser(String id, String password) {
		UserDto user = getUser(id);
		if(user != null && user.getPassword().equals(password))
			this.list.remove(user);
		
		return this.list;
	}
}
