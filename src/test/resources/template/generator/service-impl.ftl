package ${basePackageServiceImpl};

import ${basePackageDao}.${claszName}Mapper;
import ${basePackageModel}.${claszName};
import ${basePackageService}.${claszName}Service;
import com.anka.base.service.CrudBaseServiceSupport;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @Description: ${reMarks!''}(${claszName}Service)接口实现类
* @author ${author}
* @date ${date}
* @version ${version}
*/
@Service
public class ${claszName}ServiceImpl extends CrudBaseServiceSupport<${claszName}> implements ${claszName}Service {

    @Resource
    private ${claszName}Mapper ${className}Mapper;
    

}