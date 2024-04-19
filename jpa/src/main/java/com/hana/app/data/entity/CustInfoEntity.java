package com.hana.app.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "custinfo")
@Table(name="db_custinfo")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
@ToString(exclude = "cust")
//@ToString(exclude = "CustEntity")
public class CustInfoEntity {
    @Id
    @Column(name="custinfo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 아이디 값 자동 증가. mysql의 auto_increment
    private Long id;
//    @OneToOne
    @OneToOne() // 단독
//    @OneToOne(fetch = FetchType.EAGER) // 연관 컬럼 전부
    @JoinColumn(name="cust_id")
    private CustEntity cust;

    private String addr;
    private int age;
}
