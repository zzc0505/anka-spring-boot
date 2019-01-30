package ${basePackageModel};

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.anka.base.model.BaseModel;

/**
 * @Description:${reMarks!''}(${claszName})模型对象
 * @author AnkaRebirth
 * @version ${version}
 */
public class ${claszName} extends BaseModel<${claszName}> {

<#if columns??>
<#list columns as cols>
	<#if cols_index==0>
	/** ${cols.remarks!''} */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "SELECT UPPER(REPLACE(UUID(),'-',''))")
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
		bf.append("${cols.javaNameLo}(${cols.remarks!''}):").append(${cols.javaNameLo});
		</#list>
		</#if>
		return bf.toString();
	}
	
}
