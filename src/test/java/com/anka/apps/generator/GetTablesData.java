package com.anka.apps.generator;

import java.sql.DatabaseMetaData;
import java.sql.JDBCType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.Assert;

public class GetTablesData {

	public static List<Map<String, Object>> getTablesData(String tableName, DatabaseMetaData data,
			String BASE_PACKAGE, String SERVICE_PACKAGE, String SERVICE_IMPL_PACKAGE, String MODEL_PACKAGE,
			String DAO_PACKAGE, String CONTROLLER_PACKAGE) throws SQLException {
		System.out.println(data.getDriverName());
		System.out.println(data.getURL());
		System.out.println(data.getUserName());
		System.out.println("");
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		/**
		 * 获取给定类别中使用的表的描述。 方法原型:ResultSet getTables(String catalog,String
		 * schemaPattern,String tableNamePattern,String[] types); catalog -
		 * 表所在的类别名称;""表示获取没有类别的列,null表示获取所有类别的列。 schema -
		 * 表所在的模式名称(oracle中对应于Tablespace);""表示获取没有模式的列,null标识获取所有模式的列;
		 * 可包含单字符通配符("_"),或多字符通配符("%"); tableNamePattern -
		 * 表名称;可包含单字符通配符("_"),或多字符通配符("%"); types - 表类型数组;
		 * "TABLE"、"VIEW"、"SYSTEM TABLE"、"GLOBAL TEMPORARY"、"LOCAL
		 * TEMPORARY"、"ALIAS" 和 "SYNONYM";
		 * null表示包含所有的表类型;可包含单字符通配符("_"),或多字符通配符("%");
		 */
		ResultSet rs = data.getTables(null, null, tableName == "" ? null : tableName, new String[] { "TABLE" });
		while (rs.next()) {
			System.out.println("表名：" + rs.getString("TABLE_NAME").toUpperCase());
			System.out.println("表类型：" + rs.getString("TABLE_TYPE"));
			System.out.println("表所属数据库：" + rs.getString("TABLE_CAT"));
			System.out.println("表备注：" + rs.getString("REMARKS"));
			Map<String, Object> map = getDateMap(rs.getString("TABLE_NAME").toUpperCase(), rs.getString("REMARKS"),
					data, BASE_PACKAGE, SERVICE_PACKAGE, SERVICE_IMPL_PACKAGE, MODEL_PACKAGE,
					DAO_PACKAGE, CONTROLLER_PACKAGE);
			list.add(map);
		}
		rs.close();
		return list;
	}

	/**
	 * 封装表数据
	 * 
	 * @param tableName
	 *            表名
	 * @param reMarks
	 *            表备注
	 * @param data
	 *            DatabaseMetaData data 对象
	 * @return Map<String, Object> 封装表信息数据
	 * @throws SQLException
	 */
	private static Map<String, Object> getDateMap(String tableName, String reMarks, DatabaseMetaData data,
			String BASE_PACKAGE, String SERVICE_PACKAGE, String SERVICE_IMPL_PACKAGE, String MODEL_PACKAGE,
			String DAO_PACKAGE, String CONTROLLER_PACKAGE) throws SQLException {
		Assert.hasText(tableName, "表名称不能为空！");
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		map.put("tableName", tableName);
		map.put("claszName", GeneratorUtils.underlineCamel(tableName, false));
		map.put("className", GeneratorUtils.underlineCamel(tableName, true));
		map.put("reMarks", reMarks);
		map.put("author", "AnkaRebirth");
		map.put("date", new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
		map.put("version", "1.0.0");
		map.put("basePackage", BASE_PACKAGE);
		map.put("basePackageService", SERVICE_PACKAGE);
		map.put("basePackageServiceImpl", SERVICE_IMPL_PACKAGE);
		map.put("basePackageModel", MODEL_PACKAGE);
		map.put("basePackageDao", DAO_PACKAGE);
		map.put("basePackageController", CONTROLLER_PACKAGE);
		map.put("baseRequestMapping", GeneratorUtils.underlineCamel(tableName, true));
		/**
		 * 获取可在指定类别中使用的表列的描述。 方法原型:ResultSet getColumns(String catalog,String
		 * schemaPattern,String tableNamePattern,String columnNamePattern)
		 * catalog - 表所在的类别名称;""表示获取没有类别的列,null表示获取所有类别的列。 schema -
		 * 表所在的模式名称(oracle中对应于Tablespace);""表示获取没有模式的列,null标识获取所有模式的列;
		 * 可包含单字符通配符("_"),或多字符通配符("%"); tableNamePattern -
		 * 表名称;可包含单字符通配符("_"),或多字符通配符("%"); columnNamePattern - 列名称;
		 * ""表示获取列名为""的列(当然获取不到);null表示获取所有的列;可包含单字符通配符("_"),或多字符通配符("%");
		 */
		ResultSet cols = data.getColumns(null, "%", tableName, "%");
		while (cols.next()) {
			System.out.println("字段名：" + cols.getString("COLUMN_NAME") + "------ JAVA名："
					+ GeneratorUtils.underlineCamel(cols.getString("COLUMN_NAME"), false) + "------" + "类型："
					+ cols.getString("TYPE_NAME") + "------" + "长度：" + cols.getString("COLUMN_SIZE") + "------" + "备注："
					+ cols.getString("REMARKS"));
			Map<String, String> col = new HashMap<String, String>();
			col.put("columnName", cols.getString("COLUMN_NAME"));
			col.put("javaNameUp", GeneratorUtils.underlineCamel(cols.getString("COLUMN_NAME"), false));
			col.put("javaNameLo", GeneratorUtils.underlineCamel(cols.getString("COLUMN_NAME"), true));
			Assert.hasText(GeneratorUtils.jdbcTojava(cols.getInt("DATA_TYPE")),
					"未能获取到对应的java变量类型，请检查【" + cols.getString("COLUMN_NAME") + "】数据库中对应类型！");
			col.put("javaType", GeneratorUtils.jdbcTojava(cols.getInt("DATA_TYPE")));
			col.put("jdbcType", GeneratorUtils.getJdbcTypeSame(JDBCType.valueOf(cols.getInt("DATA_TYPE")).getName()));
			col.put("remarks", cols.getString("REMARKS"));
			list.add(col);
		}
		cols.close();
		map.put("columns", list);
		return map;

	}
}
