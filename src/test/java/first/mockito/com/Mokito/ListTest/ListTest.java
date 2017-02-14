package first.mockito.com.Mokito.ListTest;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.CoreMatchers.is;

import java.awt.List;
import java.util.ArrayList;

import org.junit.Test;

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
	
	
	//test for exceptions 
	@Test(expected = RuntimeException.class)
	public void test_ListGetMethod() {
		List listMock = mock(List.class);				
		when(listMock.getSelectedItem()).thenThrow(new RuntimeException("Something went wrong"));
		listMock.getSelectedItem();
	}
	
	//BDD Behavioral Driven Development 
	public void test_UsingBDD() {
		//Given
		ArrayList<String> listMock = mock(ArrayList.class);		
		given(listMock.get(anyInt())).willReturn("Meron");
		
		//When 
		String fristElement = listMock.get(0);
		
		//Then
		assertThat(fristElement , is("Meron"));		
	}
	

}
