package com.biz.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

// JPA를 사용하기 위한 DB 설정
@Entity
@Table(name = "tbl_users", schema = "spBoot")
public class UserVO {
	
	/*
	 * Generator 값을 auto로 설정하면
	 * JPA가 임의로 table을 생성하고
	 * sequence를 만들어서 주입하도록 설정이 된다.
	 * 
	 * DBMS에 관계없이 자동 생성 칼럼의 값을 주입하는 방식
	 * 
	 * 오라클처럼 AUTO INCERMENT 옵션이 없는 DBMS에서 사용
	 * @GeneratedValue(strategy = GenerationType.SEQUENCE)
	 * 
	 * DBMS에 관계없이 사용하는 방법 : AUTO로 설정을 하면
	 * TABLE 속성과 같게 작동된다.
	 * @GeneratedValue(strategy = GenerationType.TABLE)
	 * 
	 * AUTO INCEREMENT 기능이 있는 DBMS : MySQL, MSSQL, MariaDB 등
	 * @GeneratedValue(strategy = GenerationType.IDENTITY)
	 * 
	 * MySQL을 사용할 때는 AUTO 옵션보다는 IDENTITY를 사용하자.
	 */
	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String username;
	private String password;
	private String email;
	private String phone;
	private String address;

}
