package com.hana.app.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "custinfo") // db에 테이블 생성, alias로 엔티티간 인식이 편하게!
@Table(name = "t_custinfo")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED) // 같은 패키지 하위 객체
@Builder
@ToString(exclude = "cust")
@Getter
public class CustInfoEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "custinfo_id")
    private int id;
    @Column(nullable = false, columnDefinition = "int default 1")
    private int age;

    // custInfo 조회 시 cust도 같이 조회하지만!!!(객체안에 들어있지만) 출력에만 안나오는것임!!!!!!!!!!!!!!!
    @OneToOne // EAGER. custInfo를 조회할 때 custEntity도 반드시 조회가 된다!
    @JoinColumn(name = "cust_id")
    private CustEntity cust;
}
