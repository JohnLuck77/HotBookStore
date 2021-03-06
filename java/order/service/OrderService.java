package order.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import book.bean.BookDTO;
import order.bean.ViewCartDTO;

public interface OrderService {

	public String addToCart(Map<String, String> map);

	public List<ViewCartDTO> getCart(String memId);
	public List<ViewCartDTO> getCartInCookies();

	public List<BookDTO> getBooksInCart(List<ViewCartDTO> cart_list);

	public String removeCart(String book_id);
	public ModelAndView loadCart(ModelAndView model);

	public ModelAndView verify(ModelAndView model, String receipt_id);
	
	public void addCheckout(List<Map<String, String>> list);
	public void addCheckout_all();
	public void checkoutDirect(List<Map<String, String>> list);
	
	public ModelAndView admin_order_list(ModelAndView mav, Map<String, Object> map);

	public void loadOrder(ModelAndView model, Map<String, Object> map);
	public void loadOrder(ModelAndView mav, String order_id);

	public void loadPoint(ModelAndView model, int pg);
	public void getPoint(ModelAndView model);

	public void admin_order_proceed(ModelAndView mav, Map<String, Object> map);

}
