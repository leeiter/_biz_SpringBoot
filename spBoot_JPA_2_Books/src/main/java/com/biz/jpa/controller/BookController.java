package com.biz.jpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.jpa.domain.BookVO;
import com.biz.jpa.service.BookService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/book")
@Controller
public class BookController {
	
	private final BookService bService;
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String books(Model model) {
		model.addAttribute("book", new BookVO());
		return "bookform";
	}

	// @ResponseBody
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String book(BookVO bookVO) {
		log.debug(bookVO.toString());
		BookVO vo = bService.save(bookVO);
		return "redirect:/book/pagelist";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String bookList(Model model) {
		List<BookVO> bookList = bService.selectAll();
		model.addAttribute("bookList", bookList);
		return "layout";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(String id, Model model) {
		long bookId = 0;
		try {
			bookId = Long.valueOf(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Optional<BookVO> bookVO = bService.findById(bookId);
		model.addAttribute("book", bookVO.get());
		return "bookform";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(BookVO bookVO) {
		BookVO vo = bService.save(bookVO);
		return "redirect:/book/pagelist";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String id) {
		long bookId = 0;
		try {
			bookId = Long.valueOf(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		bService.delete(bookId);
		return "redirect:/book/pagelist";
	}
	
	// @ResponseBody
	@RequestMapping(value = "/pagelist", method = RequestMethod.GET)
	public String getPageList(@PageableDefault Pageable page, Model model) {
		Page<BookVO> bookList = bService.getPageList(page);
		model.addAttribute("bookList", bookList);
		return "booklist";
	}

}
