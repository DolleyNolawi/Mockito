package first.mockito.com.Mokito.ListTest;

import static org.junit.Assert.*;

import java.awt.List;

import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ListTest {
	
	@Test
	public void test_GetItemList() {
		List listMock = mock(List.class);				
		when(listMock.getItemCount()).thenReturn(2);
		
		assertEquals(2 , listMock.getItemCount());
		
		//no matter how many times we call the method it will return the same result 
		assertEquals(2 , listMock.getItemCount());
		assertEquals(2 , listMock.getItemCount());
	}
	
	
	//to return multiple mock values
	@Test
	public void test_returnMultipleValues() {
		List listMock = mock(List.class);				
		when(listMock.getItemCount()).thenReturn(2).thenReturn(3);
	
		assertEquals(2 , listMock.getItemCount());
		assertEquals(3 , listMock.getItemCount());
	}

}
