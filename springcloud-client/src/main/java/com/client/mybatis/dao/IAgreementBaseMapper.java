package com.client.mybatis.dao;

import com.client.mybatis.domain.AgreementBase;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IAgreementBaseMapper {


	@Select("select * from roles where user_id=#{userId}")
	@Results(
			{
					@Result(id = true, column = "role_id", property = "roleId"),
					@Result(column = "rolename", property = "rolename"),
					@Result(column = "privilege", property = "privilege_id"),
					@Result(column = "description",property = "description")
			})
	List<AgreementBase> findByAgreementBaseId(int userId);


	@Select("select * from agreement_base")
	@Results(
	{
	@Result(id = true, column = "user_id", property = "userId"),
	@Result(column = "name", property = "name"),
	@Result(column = "email", property = "email"),
	@Result(property = "roles", column = "user_id",
			many = @Many(select = "com.client.mybatis.AgreementBaseMapper.findByAgreementBaseId"))
	})
	public List<AgreementBase> findAll();

}
