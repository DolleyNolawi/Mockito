package first.mockito.com.MokitoTest;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.verify;

import first.mockito.com.Mymockito.TodoBusinessImpl;
import first.mockito.com.Mymockito.TodoService;

public class TodoBusinessImplMockitoTest {

	@Test
    public void usingMockito() {
        TodoService todoService = mock(TodoService.class);
        
        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Dance");
        
        when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);
        
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
        List<String> todos = todoBusinessImpl
                .retrieveTodosRelatedToSpring("Ranga");
        assertEquals(2, todos.size());
    }
	
	@Test
    public void usingMockito_withEmptylist() {
        TodoService todoService = mock(TodoService.class);        
        List<String> allTodos = Arrays.asList();        
        when(todoService.retrieveTodos("dum")).thenReturn(allTodos);
        
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
        List<String> todos = todoBusinessImpl
                .retrieveTodosRelatedToSpring("dum");
        assertEquals(0, todos.size());
    }
	
	@Test
    public void usingMockito_DeleteTodo_UsingBDD() {
        TodoService todoService = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Dance");
        //Given
        given(todoService.retrieveTodos("user")).willReturn(todos);
        
        TodoBusinessImpl todoBimpl = new TodoBusinessImpl(todoService);
        
        //When
        todoBimpl.deleteToDosNotRelatedToSpring("user");
        //Then
        verify(todoService).deleteTodo("Learn to Dance");
        
        verify(todoService, Mockito.never()).deleteTodo("Learn Spring MVC");
        
        verify(todoService, Mockito.times(1)).deleteTodo("Learn to Dance");
    }
}
