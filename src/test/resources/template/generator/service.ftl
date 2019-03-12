package ${basePackageService};

import ${basePackageModel}.${claszName};
<#if dataType=="comn">
import com.anka.base.service.CrudBaseService;
<#elseif dataType=="tree">
import com.anka.base.service.TreeBaseService;
</#if>
/**
* @Description: ${reMarks!''}(${claszName}Service)接口
* @author ${author}
* @date ${date}
* @version ${version}
*/
public interface ${claszName}Service extends <#if dataType=="comn">CrudBaseService<${claszName}><#elseif dataType=="tree">TreeBaseService<${claszName}></#if> {
	
}
