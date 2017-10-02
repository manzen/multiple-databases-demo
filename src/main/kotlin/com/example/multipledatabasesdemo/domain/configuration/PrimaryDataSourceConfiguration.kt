package com.example.multipledatabasesdemo.domain.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import javax.persistence.EntityManagerFactory
import javax.sql.DataSource

@Configuration
@EnableJpaRepositories(
  basePackages = arrayOf("com.example.multipledatabasesdemo.domain.repository.primary"),
  entityManagerFactoryRef = "primaryEntityManager",
  transactionManagerRef = "primaryTransactionManager")
class PrimaryDataSourceConfiguration {

  @Bean
  @Primary
  @ConfigurationProperties(prefix = "spring.datasource.primary")
  fun primaryProperties(): DataSourceProperties {
    return DataSourceProperties()
  }

  @Bean
  @Primary
  @Autowired
  fun primaryDataSource(@Qualifier("primaryProperties") properties: DataSourceProperties): DataSource {
    return properties.initializeDataSourceBuilder().build()
  }

  @Bean
  @Primary
  @Autowired
  fun primaryEntityManager(builder: EntityManagerFactoryBuilder, @Qualifier("primaryDataSource") dataSource: DataSource): LocalContainerEntityManagerFactoryBean {
    return builder.dataSource(dataSource)
      .packages("com.example.multipledatabasesdemo.domain.model.primary")
      .persistenceUnit("primary")
      .build()
  }

  @Bean
  @Primary
  @Autowired
  fun primaryTransactionManager(@Qualifier("primaryEntityManager") primaryEntityManager: EntityManagerFactory): JpaTransactionManager {
    return JpaTransactionManager(primaryEntityManager)
  }
}