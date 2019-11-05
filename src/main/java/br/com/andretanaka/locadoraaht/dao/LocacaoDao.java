package br.com.andretanaka.locadoraaht.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.andretanaka.locadoraaht.entity.LocacaoEntity;

/*
 * by Andre Hiroshi Tanaka
 * andrehtgti2@gmail.com
 * www.andretanaka.com.br
 * 
 */

@Repository
public interface LocacaoDao extends JpaRepository<LocacaoEntity, Long>{

	@Query(value="SELECT * FROM LOCACAO WHERE NOME LIKE ?1", nativeQuery=true)
	public List<LocacaoEntity> findByName(String nome);
	
	@Query(value="DELETE FROM LOCACAO WHERE NOME LIKE ?1", nativeQuery=true)
	public void deleteByName(String nome);
	//15:52:34	DELETE FROM LOCACAO WHERE NOME LIKE 'hiroshi'	
	//Error Code: 1175. You are using safe update mode and you tried to update a table 
	//without a WHERE that uses a KEY column.  To disable safe mode, 
	//toggle the option in Preferences -> SQL Editor and reconnect.	0.016 sec

	
	
}


/*

application.properties:

spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.hibernate.ddl-auto = update
spring.datasource.url = jdbc:mysql://localhost:3306/locadoraaht?useSSL=false&useTimezone=true&serverTimezone=UTC
spring.datasource.username = root
spring.datasource.password = admin

spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest

*/