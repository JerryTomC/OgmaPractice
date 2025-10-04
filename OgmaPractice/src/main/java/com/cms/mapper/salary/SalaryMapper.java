package com.cms.mapper.salary;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cms.entity.salary.SalaryBean;

/**
 * 練習１ Mapper
 */
@Mapper
public interface SalaryMapper {

	
	/**
	 * ユーザー情報検索
	 * 
	 * @param user 検索用リクエストデータ
	 * @return ユーザー情報
	 */
	List<SalaryBean> select(SalaryBean bean);


}