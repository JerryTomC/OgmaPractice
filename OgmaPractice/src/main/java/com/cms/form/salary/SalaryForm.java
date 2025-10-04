package com.cms.form.salary;

import java.util.List;

import com.cms.entity.salary.SalaryBean;
import com.cms.form.BaseForm;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalaryForm extends BaseForm{
	
	//社員ID
	private String employeeId;
	//給料年月
	private String salaryMonth;
	
	private List<SalaryBean> results;
}