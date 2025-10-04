package com.cms.service.salary;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.entity.salary.SalaryBean;
import com.cms.form.salary.SalaryForm;
import com.cms.mapper.salary.SalaryMapper;
import com.exception.BusinessException;

/**
 * 社員情報取得サービス
 */
@Service
public class SalaryListServiceImpl implements SalaryListService {
	
	@Autowired     
	SalaryMapper mapper;
	
	@Override
	public List<SalaryBean> select(SalaryForm form) throws BusinessException {
		
		//业务逻辑在service书写
		SalaryBean inputParam = new SalaryBean();
		
		if(StringUtils.isNoneEmpty(form.getEmployeeId())) {
			inputParam.setEmployeeId(form.getEmployeeId());
		}		
		if(StringUtils.isNoneEmpty(form.getSalaryMonth())) {
			inputParam.setSalaryMonth(form.getSalaryMonth().replace("-", ""));
         }
		
		List<SalaryBean> result = mapper.select(inputParam);
		
		if(result.size() == 0) {
			throw new BusinessException("検索結果がありません。");
		}
		return result;
	}
	}