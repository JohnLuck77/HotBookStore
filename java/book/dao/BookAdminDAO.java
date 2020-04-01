package book.dao;

import java.util.List;
import java.util.Map;

import book.bean.BookDTO;

public interface BookAdminDAO {

	public void insertBook(BookDTO bookDTO);

	public List<BookDTO> getAdminBookList(Map<String, Integer> map);

	public int getBookListTotalA();

	public void bookModify(Map<String, String> map);

	public void admin_bookDelete(Map<String, String[]> map);

}
