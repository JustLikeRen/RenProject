//package kr.bit.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import kr.bit.model.GestVo;
//import kr.bit.service.GestService;
//
//@Controller
//public class GestCotroller {
//	
//	@Autowired
//	private GestService service;
//	
//	@RequestMapping("/")
//	public String list(Model model) {
//		List<GestVo> list=service.gestList();
//		model.addAttribute("GestList",list);
//		return "home";
//	}
	
//	@RequestMapping("/read")
//	public String read(Model model2) {
//		GestVo read = service.read();
//		model2.addAttribute("Read", read);
//		return "read";
//	}
//}
