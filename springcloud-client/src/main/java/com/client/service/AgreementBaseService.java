package com.client.service;

import com.client.mybatis.mapper.AgreementBaseMapper;
import com.client.mybatis.domain.AgreementBase;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageInterceptor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.util.List;

@Named
public class AgreementBaseService {

	@Autowired
	AgreementBaseMapper agreementBaseMapper;

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
}
