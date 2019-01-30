<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${basePackageDao}.${claszName}Mapper">
	<resultMap type="${claszName}" id="fieldMapper">
		<#if columns??>
		<#list columns as cols>
		<#if cols.columnName?ends_with('_UNID') || cols_index==0>
		<id property="${cols.javaNameLo}" column="${cols.columnName}" jdbcType="${cols.jdbcType}"/><!--${cols.remarks!''}-->
		<#else>
		<result property="${cols.javaNameLo}" column="${cols.columnName}" jdbcType="${cols.jdbcType}"/><!--${cols.remarks!''}-->
		</#if>
		</#list>
		</#if>
	</resultMap>
	
	<sql id="field">
		<#if columns??>
		<#list columns as cols>
		${cols.columnName}<#if cols_has_next>,</#if>
		</#list>
		</#if>
	</sql>
	
</mapper>