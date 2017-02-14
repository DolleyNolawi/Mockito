package first.mockito.com.Stub.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import first.mockito.com.Mymockito.TodoBusinessImpl;
import first.mockito.com.Stub.TodoServiceStub;

public class TodoBusinessImplStubTest {

	@Test
	public void testRetrivedRelatedToSpringStub() {
		TodoServiceStub todoServiceStub = new TodoServiceStub();		
		TodoBusinessImpl businessTodo = new TodoBusinessImpl(todoServiceStub);
		
		List<String> alist = businessTodo.retrieveTodosRelatedToSpring("user");
		for(String a: alist){
			System.out.println(a.toString());
		}
		assertEquals(2, alist.size());
		assertEquals(alist.get(0), "learn Spring");
		assertEquals(alist.get(1), "learn Spring mvc");
	}

}
