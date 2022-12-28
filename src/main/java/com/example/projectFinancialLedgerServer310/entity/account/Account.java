package com.example.projectFinancialLedgerServer310.entity.account;

import jakarta.persistence.*;
import lombok.*;


//@Entity : DB Table에 저장할 하나의 튜플로 정의하겠다는 어노테이션 (클래스의 필드가 곧 컬럼)
//@Table : 테이블의 속성을 정의하는 어노테이션 (name:테이블 이름을 정의)
//@AllArgsConstructor : 생성자를 만듬 (단, 모든 필드값이 정의된 오버로딩)
//@NoArgsConstructor : 생성자를 만듬 (단, 모든 필드값이 없는 오버로딩)
//@Getter / @Setter : 필드값을 조회/수정하는 메서드를 자동생성 (ex) public String getName()...)
@Entity
@Table(name = "signup_list")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Account {

    //@Id : PK(primary key) : 기본키 : Table의 튜플 하나하나를 식별할 수 있는 컬럼 (값이 중복x)
    // Java로 따지면, 인스턴스 마다 식별할 수 있는 필드(=Index)
    //@GeneratedValue : 데이터 자동 생성 (튜플을 식별할 수 있도록 index값을 자동 생성)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String input_id;

    //@Column : 컬럼의 속성 넣기 (length : 크기, nullable : null값 허용)
    @Column(length = 200, nullable = false)
    private String pw;

    @Column(length = 200, nullable = false)
    private String name;

    @Column(length = 200, nullable = false)
    private String email;

    public Account(String input_id, String pw, String name, String email) {
        this.input_id = input_id;
        this.pw = pw;
        this.name = name;
        this.email = email;
    }
}
