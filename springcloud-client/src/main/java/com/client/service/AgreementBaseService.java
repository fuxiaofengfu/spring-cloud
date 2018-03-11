package com.client.service;

import com.client.mybatis.domain.AppInfo;
import com.client.mybatis.mapper.AgreementBaseMapper;
import com.client.mybatis.domain.AgreementBase;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Named;
import java.util.List;

@Named
public class AgreementBaseService {

	@Autowired
	AgreementBaseMapper agreementBaseMapper;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("secondJdbcTemplate")
	JdbcTemplate jdbcTemplate1;

	public List<AgreementBase> getAll() {
		List<AgreementBase> all = agreementBaseMapper.selectAll();
		return all;
	}

	public PageInfo<AgreementBase> getPageAll(int pageSize,int pageNo) {

		PageHelper.startPage(pageNo,pageSize);
		List<AgreementBase> list = agreementBaseMapper.selectAll();
		PageInfo<AgreementBase> agreementBasePageInfo = new PageInfo<>(list);
		return agreementBasePageInfo;
	}

	public List<AppInfo> getAppInfo(){
		String sql = "select * from app_info";
		List<AppInfo> result = jdbcTemplate1.query(sql, new BeanPropertyRowMapper(AppInfo.class));
		return result;
	}

	public List<AgreementBase> findAll(){

		String sql = "select * from agreement_base";

		return jdbcTemplate.query(sql,new BeanPropertyRowMapper(AgreementBase.class));
	}
}
