package com.cms.service.salary;

import java.util.List;

import com.cms.entity.salary.SalaryBean;
import com.cms.form.salary.SalaryForm;
import com.exception.BusinessException;

public interface SalaryListService {

	public List<SalaryBean> select(SalaryForm form) throws BusinessException;

}
