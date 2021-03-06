package book.dao;

import java.util.List;
import java.util.Map;

import book.bean.BookDTO;

public interface BookAdminDAO {

	public void insertBook(BookDTO bookDTO);

	public List<BookDTO> getAdminBookList(Map<String, Object> map);

	public int getBookListTotalA();

	public void bookModify(BookDTO bookDTO);

	public void admin_bookDelete(Map<String, String[]> map);

}
