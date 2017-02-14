package first.mockito.com.Mymockito;

import java.util.List;

public interface TodoService {
	public List<String> retrieveTodos(String user);
	public void deleteTodo(String todo);
}
