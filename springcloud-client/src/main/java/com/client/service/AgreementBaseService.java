package com.client.service;

import com.client.mybatis.mapper.AgreementBaseMapper;
import com.client.mybatis.domain.AgreementBase;
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
}
