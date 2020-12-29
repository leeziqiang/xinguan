package com.lee.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;




import java.util.Scanner;

// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class CodeGenerator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
//        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(scanner("请输入你的项目路径") + "/src/main/java");
        gc.setAuthor("ZiqiangLee");
        //生成后是否打开资源管理器
        gc.setOpen(false);
        gc.setFileOverride(false);//重新生成时，是否自动覆盖文件
        gc.setServiceName("%sService");//%s 占位符，mp生成service层代码，默认接口名称第一个字母是有I
        //设置主键生成策略,自动增长
        gc.setIdType(IdType.AUTO);
        //设置Date的类型,使用java.util.date
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true);// 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/xinguan?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=Asia/Shanghai");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setDbType(DbType.MYSQL);//使用MYSQL数据库

        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(null);//scanner("请输入模块名")
        pc.setParent("com.lee");
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service.imp");
        pc.setEntity("entity");
        pc.setMapper("mapper");
//        pc.setXml("mapper.xml");
        mpg.setPackageInfo(pc);


        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //设置哪些表需要自动生成
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        //实体类驼峰命名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //列名驼峰命名
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");

        strategy.setEntityLombokModel(true);//使用lombok
        //设置controller的api风格 ，使用@RestController风格
        strategy.setRestControllerStyle(true);
//        // 公共父类
//        strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
//        // 写于父类中的公共字段
//        strategy.setSuperEntityColumns("id");
        //驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
        //忽略表中生成实体类的前缀
        strategy.setTablePrefix("tb_");

        mpg.setStrategy(strategy);
//        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}
