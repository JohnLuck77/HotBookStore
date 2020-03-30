package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import order.service.OrderService;

@Controller
public class IndexController {
	@Autowired
	OrderService orderService;
	

	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	public ModelAndView index1(ModelAndView mav) {
		orderService.loadCart(mav);
		mav.setViewName("/index0");
		return mav;
	}
	
	
	
}
