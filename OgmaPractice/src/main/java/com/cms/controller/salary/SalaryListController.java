package com.cms.controller.salary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cms.controller.base.ControllerBase;
import com.cms.entity.salary.SalaryBean;
import com.cms.form.salary.SalaryForm;
import com.cms.service.salary.SalaryListService;
import com.exception.BusinessException;

@Controller //表示这是一个Controller
@RequestMapping(value = "/salary/SalaryList") //将前端的内容映射到后端? 连接前后端 建立联系
public class SalaryListController extends ControllerBase {

	@Autowired //还是不理解  调用service方法?并new一个对象?
	SalaryListService service;

	/**
	 * 練習画面の初期化処理
	 */
	@RequestMapping(method = RequestMethod.GET)  //指定method执行get方法?
	public String init(Model model) {

		model.addAttribute("form", new SalaryForm());  //调用modle新建一个form
		
		//github*test用
		System.out.println("test");
		
		return "/salary/SalaryList"; //返回到画面
	}

	/**
	 * データ検索
	 */
	@RequestMapping(params = "select", method = RequestMethod.POST)
	public String select(@ModelAttribute("form") SalaryForm form, Model model) { //为什么返回的是string?

		try {
			
			List<SalaryBean> ret = service.select(form);
			form.setResults(ret);

		} catch (BusinessException e) {
			System.out.println(e);
			//エラーメッセージを設定する
			form.setErrorMessage(e.getMessage());
		} 
		model.addAttribute("form", form);
	    
		return "/salary/SalaryList";
	}
}