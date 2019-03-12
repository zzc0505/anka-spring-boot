package ${basePackageModel};

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<#if dataType=="comn">
import com.anka.base.model.BaseModel;
<#elseif dataType=="tree">
import com.anka.base.model.BaseTree;
</#if>
/**
 * @Description:${reMarks!''}(${claszName})模型对象
 * @author AnkaRebirth
 * @version ${version}
 */
public class ${claszName} extends <#if dataType=="comn">BaseModel<${claszName}><#elseif dataType=="tree">BaseTree<${claszName}></#if> {

<#if columns??>
<#list columns as cols>
	<#if cols_index==0>
	/** ${cols.remarks!''} */
	@Id
	private ${cols.javaType} ${cols.javaNameLo};
	<#else>
	/** ${cols.remarks!''} */
	private ${cols.javaType} ${cols.javaNameLo};
	</#if>
</#list>
</#if>

<#if columns??>
<#list columns as cols>
	public ${cols.javaType} get${cols.javaNameUp}() {
		return ${cols.javaNameLo};
	}
	public void set${cols.javaNameUp}(${cols.javaType} ${cols.javaNameLo}) {
		this.${cols.javaNameLo} = ${cols.javaNameLo};
	}
</#list>
</#if>	

	@Override
	public String toString() {
		StringBuffer bf = new StringBuffer();
		<#if columns??>
		<#list columns as cols>
		<#if cols_index % 3==0>
		bf.append("\n");
		</#if>
		bf.append("${cols.javaNameLo}(${cols.remarks!''}):").append(${cols.javaNameLo}+" ");
		</#list>
		</#if>
		return bf.toString();
	}
	
}
