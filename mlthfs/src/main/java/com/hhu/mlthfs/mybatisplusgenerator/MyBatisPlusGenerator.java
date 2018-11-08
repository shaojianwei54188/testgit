package com.hhu.mlthfs.mybatisplusgenerator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.OracleTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class MyBatisPlusGenerator {

    public static void main(String[] args) {
        //1. 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setActiveRecord(true) // 是否支持AR模式
                .setAuthor("HHU") // 作者
                .setOutputDir("E:\\mlthfs\\src\\main\\java") // 生成路径
                .setFileOverride(true)  // 文件覆盖
                .setEnableCache(false)// XML 二级缓存
                .setServiceName("%sService")  // 设置生成的service接口的名字的首字母是否为I
                .setMapperName("%sDao")
                // IEmployeeService
                .setBaseResultMap(true)
                .setBaseColumnList(true) ;

        //2. 数据源配置
        DataSourceConfig dbConfig  = new DataSourceConfig();
        dbConfig.setDbType(DbType.ORACLE)
                .setTypeConvert(new OracleTypeConvert(){
                    // 自定义数据库表字段类型转换【可选】
                    @Override
                    public DbColumnType processTypeConvert(String fieldType) {
                        return super.processTypeConvert(fieldType);
                    }
                })
                .setDriverName("oracle.jdbc.driver.OracleDriver")
                .setUrl("jdbc:oracle:thin:@192.168.1.102:1521:mlthfs")
                .setUsername("hhudba")
                .setPassword("Jttqbchhu611611");

        //3. 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setTablePrefix(new String[]{"sys_","ST_"})
                .setNaming(NamingStrategy.underline_to_camel)
//                .setInclude(new String[] {"sys_user"})
//                .setInclude(new String[] {"sys_role"})
//                .setInclude(new String[] {"basicinfo"})
//                .setInclude(new String[] {"climate_name"})
//                .setInclude(new String[] {"climate_index"})
//                .setInclude(new String[] {"ST_RVAV_R"})
//                .setInclude(new String[] {"ST_RSVRAV_R"})
//                .setInclude(new String[] {"sys_menu"})
//                .setInclude(new String[] {"plan_info"})
//                .setInclude(new String[] {"plan_assess_index"})
//                .setInclude(new String[] {"forecast_result"})
//                .setInclude(new String[] {"selected_factors"})
//                .setInclude(new String[] {"train_result"})
//                .setInclude(new String[] {"test_result"})
//                .setInclude(new String[] {"FORECAST_DATA_RESULT"})
//                .setInclude(new String[] {"FORECAST_release_RESULT"})
                .setInclude(new String[] {"HISTORY_Q_DATA"})


                .setCapitalMode(true);

        //4. 包名策略配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.hhu.mlthfs")
                .setEntity("model")
                .setController("controller")
                .setMapper("mapper")
                .setXml("mapper")
                .setService("service")
                .setServiceImpl("service.impl");

        //5. 整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig)
                .setDataSource(dbConfig)
                .setPackageInfo(pkConfig)
                .setStrategy(strategyConfig);
        //6. 执行
        autoGenerator.execute();

    }


}
