package com.example.multipledatabasesdemo.domain.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import javax.persistence.EntityManagerFactory
import javax.sql.DataSource

@Configuration
@EnableJpaRepositories(
  basePackages = arrayOf("com.example.multipledatabasesdemo.domain.repository.secondary"),
  entityManagerFactoryRef = "secondaryEntityManager",
  transactionManagerRef = "secondaryTransactionManager")
class SecondaryDataSourceConfiguration {

  @Bean
  @ConfigurationProperties(prefix = "spring.datasource.secondary")
  fun secondaryProperties(): DataSourceProperties {
    return DataSourceProperties()
  }

  @Bean
  @Autowired
  fun secondaryDataSource(@Qualifier("secondaryProperties") properties: DataSourceProperties): DataSource {
    return properties.initializeDataSourceBuilder().build()
  }

  @Bean
  @Autowired
  fun secondaryEntityManager(builder: EntityManagerFactoryBuilder, @Qualifier("secondaryDataSource") dataSource: DataSource): LocalContainerEntityManagerFactoryBean {
    return builder.dataSource(dataSource)
      .packages("com.example.multipledatabasesdemo.domain.model.secondary")
      .persistenceUnit("secondary")
      .build()
  }

  @Bean
  @Autowired
  fun secondaryTransactionManager(@Qualifier("secondaryEntityManager") secondaryEntityManager: EntityManagerFactory): JpaTransactionManager {
    return JpaTransactionManager(secondaryEntityManager)
  }
}