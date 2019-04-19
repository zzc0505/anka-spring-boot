package ${basePackageModel};

import java.util.Date;

import javax.persistence.Id;

<#if columns??>
import com.anka.base.annotation.FCMD;
import com.anka.base.annotation.FCMD.CMM;
</#if>
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
	/** ${cols.remarks!''} */
	<#if cols_index==0&&cols.javaNameLo?last_index_of("Uuid")!=-1>
	@Id
	@FCMD(fieldName="${cols.javaNameLo}",type=CMM.UUID)
	<#elseif cols.javaNameLo?last_index_of("Name")!=-1||cols.javaNameLo?last_index_of("Title")!=-1>
	@FCMD(fieldName="${cols.javaNameLo}",type=CMM.TEXT)
	<#elseif cols.javaNameLo?last_index_of("Status")!=-1>
	@FCMD(fieldName="${cols.javaNameLo}",type=CMM.STATUS)
	<#elseif cols.javaNameLo?last_index_of("Ord")!=-1>
	@FCMD(fieldName="${cols.javaNameLo}",type=CMM.ORDER)
	<#elseif cols.javaNameLo?last_index_of("Cdate")!=-1>
	@FCMD(fieldName="${cols.javaNameLo}",type=CMM.CDATE)
	<#elseif cols.javaNameLo?last_index_of("Udate")!=-1>
	@FCMD(fieldName="${cols.javaNameLo}",type=CMM.UDATE)
	</#if>
	private ${cols.javaType} ${cols.javaNameLo};
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
