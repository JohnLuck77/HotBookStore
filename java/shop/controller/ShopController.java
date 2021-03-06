package shop.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import book.bean.BookDTO_list;
import order.service.OrderService;
import shop.service.ShopService;

@Controller
public class ShopController {
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "getBooks", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getBooks(@RequestParam String pg, ModelAndView model) {
		List<BookDTO_list> list = shopService.getBookList(pg);
		model.addObject("book_list", list);
		model.setViewName("jsonView");
		return model;
	}
	
	@RequestMapping(value = {"shop-grid", "search"}, method = RequestMethod.GET)
	public ModelAndView shop_grid(@RequestParam(required = false) Map<String, Object> map, ModelAndView model) {
		orderService.loadCart(model);
		model.setViewName("/shop-grid");
		return shopService.getBooks(model, map);
	}
	
//	@RequestMapping(value = "search", method = RequestMethod.GET)
//	public ModelAndView search(@RequestParam Map<String, Object> map, ModelAndView model) {
//		orderService.loadCart(model);
//		model.setViewName("/shop-grid");
//		return shopService.getBooks(model, map);
//	}
	
	@RequestMapping(value = "wishlist", method = RequestMethod.GET)
	public ModelAndView wishlist(ModelAndView model) {
		orderService.loadCart(model);
		model.setViewName("/wishlist");
		return shopService.getWishlist(model);
	}
	
	@ResponseBody
	@RequestMapping(value = "wishlist", method = RequestMethod.POST)
	public String addWishlist(ModelAndView model, @RequestParam String book_id) {
		return shopService.addWishlist(model, book_id);
	}
	
	@ResponseBody
	@RequestMapping(value = "wishlist/{book_id}", method = RequestMethod.DELETE)
	public String removeFromWishlist(@PathVariable String book_id) {
		return shopService.removeFromWishlist(book_id);
	}
}
