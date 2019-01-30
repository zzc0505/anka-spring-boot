package ${basePackageController};

import ${basePackageService}.${claszName}Service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
* @Description: ${reMarks!''}(${claszName}Controller)控制层
* @author ${author}
* @date ${date}
* @version ${version}
*/
@Controller
@RequestMapping("/${baseRequestMapping}")
public class ${claszName}Controller {

    @Resource
    private ${claszName}Service ${className}Service;

}