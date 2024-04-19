package com.hana.app.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "cust") // db에 테이블 생성, alias로 엔티티간 인식이 편하게!
@Table(name = "t_cust")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED) // 같은 패키지 하위 객체
@Builder
@ToString
@Getter
public class CustEntity extends BaseEntity {
    @Id
    @Column(name = "cust_id", length = 30)
    private String id;
    @Column(nullable = false, columnDefinition = "varchar(60)")
    private String pwd;
    @Column(nullable = false, columnDefinition = "varchar(30)")
    private String name;

    // cust 정보를 조회할 때 custInfo 까지 같이 조회하고싶다 ---> 포함
    // 이렇게 부르면 @ToString이 중복 호출. 따라서 두 중 하나의 엔티티에서 ToString을 빼주면 된다.
    // ----> CustInfoEntity의 @ToString(exclude = "cust")
    @OneToOne(mappedBy = "cust")
    private CustInfoEntity custinfo;
}
