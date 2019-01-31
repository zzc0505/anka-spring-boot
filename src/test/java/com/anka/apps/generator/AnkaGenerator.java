package com.anka.apps.generator;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
/**
 * @Description 代码生成器，基于Freemarker 2.3.28
 * Jar包依赖由Maven代理。只要有依赖包，本生成器可以单独拿出使用
 * @author AnkaRebirth
 * @date 2019-01-25 23:44
 * @version 1.0.0
 */
public class AnkaGenerator {

	// private static final String driver = "oracle.jdbc.OracleDriver";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/anka?serverTimezone=GMT%2B8";
	private static final String USER_NAME = "root";
	private static final String PASS_WORD = "123456";

	// 表名称，不限大小写，可包含单字符通配符("_"),或多字符通配符("%");
	private static final String TALBE_NAME = "core_orginaze";
	// 项目基础包名称，根据自己公司的项目修改
	private static final String BASE_PACKAGE = "com.anka.apps";
	// Model所在包
	private static final String MODEL_PACKAGE = BASE_PACKAGE + ".model";
	// Dao所在包
	private static final String DAO_PACKAGE = BASE_PACKAGE + ".mapper";
	// Service所在包
	private static final String SERVICE_PACKAGE = BASE_PACKAGE + ".service";
	// ServiceImpl所在包
	private static final String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".impl";
	// Controller所在包
	private static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".controller";
	// java文件路径
	private static final String JAVA_PATH = "src/main/java";
	// resource文件路径
	private static final String RESOURCES_PATH = "src/main/resources";
	// mapper所在路径
	private static final String MAPPER_PATH = "/mapper/";
	// 模板位置
    private static final String TEMPLATE_FILE_PATH = "src/test/resources/template/generator";
    
	public static void main(String[] args) throws SQLException {
		Connection con = JDBCConnection.INSTANCE.getConnection(DRIVER, URL, USER_NAME, PASS_WORD);
		DatabaseMetaData data = con.getMetaData();
		System.out.println(data.getDriverName());
		System.out.println(data.getURL());
		System.out.println(data.getUserName());
		System.out.println("");
		List<Map<String, Object>> list = GetTablesData.getTablesData(TALBE_NAME,
				data, BASE_PACKAGE, SERVICE_PACKAGE, SERVICE_IMPL_PACKAGE, MODEL_PACKAGE,
				DAO_PACKAGE, CONTROLLER_PACKAGE);
		GeneratorUtils.closeConnection(con);
		System.out.println("生成表"+list.size()+"个！SUCCESS");
		//==================================代码生成主体部分==================================
		for (Map<String, Object> map : list) {
			/** Model 生成*/
			genModel(map, GeneratorUtils.packageConvertPath(MODEL_PACKAGE));
			
			/** Mapper 生成  */
			genMapper(map,MAPPER_PATH);
			
			/** Dao 生成  */
			genDao(map, GeneratorUtils.packageConvertPath(DAO_PACKAGE));
			
			/** Service 生成 */
			genService(map, GeneratorUtils.packageConvertPath(SERVICE_PACKAGE));
			
			/** ServiceImpl 生成 */
			genServiceImpl(map, GeneratorUtils.packageConvertPath(SERVICE_IMPL_PACKAGE));
			
			/** Controller 生成*/
			genController(map, GeneratorUtils.packageConvertPath(CONTROLLER_PACKAGE));
		}
		//==================================代码生成主体部分==================================
	}
	/**
	 * 生成Model
	 * @param tableData
	 * @param PACKAGE_PATH_MODEL
	 */
	private static void genModel(Map<String, Object> tableData, String PACKAGE_PATH_MODEL) {
		String path = JAVA_PATH + PACKAGE_PATH_MODEL + tableData.get("claszName") + ".java";
		GeneratorUtils.generatorCode(tableData, path, "model.ftl", TEMPLATE_FILE_PATH);
	}
	/**
	 * 生成Mapper
	 * @param tableData
	 */
	private static void genMapper(Map<String, Object> tableData,String MAPPER_PATH) {
		String path = RESOURCES_PATH + MAPPER_PATH + tableData.get("claszName") + "Mapper.xml";
		GeneratorUtils.generatorCode(tableData, path, "mapper.ftl", TEMPLATE_FILE_PATH);
	}
	/**
	 * 生成Dao
	 * @param tableData
	 * @param PACKAGE_PATH_DAO
	 */
	private static void genDao(Map<String, Object> tableData,  String PACKAGE_PATH_DAO) {
		String path = JAVA_PATH + PACKAGE_PATH_DAO + tableData.get("claszName") + "Mapper.java";
		GeneratorUtils.generatorCode(tableData, path, "dao.ftl", TEMPLATE_FILE_PATH);
	}
	/**
	 * 生成Service
	 * @param tableData
	 * @param PACKAGE_PATH_SERVICE
	 */
	private static void genService(Map<String, Object> tableData, String PACKAGE_PATH_SERVICE) {
		String path = JAVA_PATH + PACKAGE_PATH_SERVICE + tableData.get("claszName") + "Service.java";
		GeneratorUtils.generatorCode(tableData, path, "service.ftl", TEMPLATE_FILE_PATH);
	}
	/**
	 * 生成ServiceImpl
	 * @param tableData
	 * @param PACKAGE_PATH_SERVICE_IMPL
	 */
	private static void genServiceImpl(Map<String, Object> tableData, String PACKAGE_PATH_SERVICE_IMPL) {
		String path = JAVA_PATH + PACKAGE_PATH_SERVICE_IMPL + tableData.get("claszName") + "ServiceImpl.java";
		GeneratorUtils.generatorCode(tableData, path, "service-impl.ftl", TEMPLATE_FILE_PATH);
	}
	/**
	 * 生成Controller
	 * @param tableData
	 * @param PACKAGE_PATH_CONTROLLER
	 */
	private static void genController(Map<String, Object> tableData, String PACKAGE_PATH_CONTROLLER) {
		String path = JAVA_PATH + PACKAGE_PATH_CONTROLLER + tableData.get("claszName") + "Controller.java";
		GeneratorUtils.generatorCode(tableData, path, "controller.ftl", TEMPLATE_FILE_PATH);
	}
}
