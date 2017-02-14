package first.mockito.com.Stub;

import java.util.Arrays;
import java.util.List;

import first.mockito.com.Mymockito.TodoService;

public class TodoServiceStub implements TodoService{

	public List<String> retrieveTodos(String user) {		
		return Arrays.asList("learn Spring" , "learn Hibernate" , "learn Spring mvc");
	}

	public void deleteTodo(String todo) {
		// TODO Auto-generated method stub
		
	}

}
