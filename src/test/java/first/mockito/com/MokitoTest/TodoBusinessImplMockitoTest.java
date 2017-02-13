package first.mockito.com.MokitoTest;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

}
