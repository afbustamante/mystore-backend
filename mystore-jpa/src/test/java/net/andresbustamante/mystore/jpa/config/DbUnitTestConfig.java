package net.andresbustamante.mystore.jpa.config;

import javax.sql.DataSource;

import org.dbunit.dataset.datatype.IDataTypeFactory;
import org.dbunit.ext.h2.H2DataTypeFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.springtestdbunit.bean.DatabaseConfigBean;
import com.github.springtestdbunit.bean.DatabaseDataSourceConnectionFactoryBean;

/**
 * Test configuration for DBUnit.
 */
@Configuration
public class DbUnitTestConfig {

    /**
     * DBUnit data type factory bean using H2 Database.
     *
     * @return Data type factory bean using H2
     */
    @Bean
    public IDataTypeFactory dbUnitDataTypeFactory() {
        return new H2DataTypeFactory();
    }

    /**
     * DB config bean using DBUnit data type factory for PostgreSQL.
     *
     * @return Database config bean
     */
    @Bean
    public DatabaseConfigBean dbUnitDatabaseConfig() {
        DatabaseConfigBean databaseConfigBean = new DatabaseConfigBean();
        databaseConfigBean.setDatatypeFactory(dbUnitDataTypeFactory());
        databaseConfigBean.setAllowEmptyFields(true);
        return databaseConfigBean;
    }

    /**
     * Connection factory bean for DBUnit.
     *
     * @param dataSource Injected datasource for testing
     * @return Connection factory for DBUnit
     */
    @Bean
    public DatabaseDataSourceConnectionFactoryBean dbUnitDatabaseConnection(final DataSource dataSource) {
        DatabaseDataSourceConnectionFactoryBean dbUnitDatabaseConnectionFactory =
                new DatabaseDataSourceConnectionFactoryBean();
        dbUnitDatabaseConnectionFactory.setDatabaseConfig(dbUnitDatabaseConfig());
        dbUnitDatabaseConnectionFactory.setDataSource(dataSource);
        dbUnitDatabaseConnectionFactory.setTransactionAware(true);
        return dbUnitDatabaseConnectionFactory;
    }
}
