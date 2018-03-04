/**
 * Copyright (c) 2018-2028 - huawei
 */
package com.client.mybatis.mapper;

import com.client.mybatis.domain.AgreementBase;

import java.util.List;

public interface AgreementBaseMapper {
	int insert(AgreementBase record);

	List<AgreementBase> selectAll();
}