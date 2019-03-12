package ${basePackageServiceImpl};

import ${basePackageDao}.${claszName}Mapper;
import ${basePackageModel}.${claszName};
import ${basePackageService}.${claszName}Service;
<#if dataType=="comn">
import com.anka.base.service.CrudBaseServiceSupport;
<#elseif dataType=="tree">
import com.anka.base.service.TreeBaseServiceSupport;
</#if>
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @Description: ${reMarks!''}(${claszName}Service)接口实现类
* @author ${author}
* @date ${date}
* @version ${version}
*/
@Service
public class ${claszName}ServiceImpl extends <#if dataType=="comn">CrudBaseServiceSupport<${claszName}><#elseif dataType=="tree">TreeBaseServiceSupport<${claszName}></#if> implements ${claszName}Service {

    @Resource
    private ${claszName}Mapper ${className}Mapper;
    

}