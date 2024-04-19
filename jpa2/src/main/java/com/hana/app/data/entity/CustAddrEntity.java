package com.hana.app.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "custaddr") // db에 테이블 생성, alias로 엔티티간 인식이 편하게!
@Table(name = "t_custaddr")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED) // 같은 패키지 하위 객체
@Builder
@ToString(exclude = "cust") // toString에만 빠지는거지 실제 객체 아이디 값은 들어감
@Getter
public class CustAddrEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "custaddr_id")
    private int id;
    private String addr;

    @ManyToOne(fetch = FetchType.LAZY) // 느슨하게..~ cartEntity를 조회할 때 custEntity 정보 안들어옴
    @JoinColumn(name = "cust_id")
    private CustEntity cust;

}
