package com.hana.app.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "cust") // alias
// 무조건 primary key를 잡아야 함. entity는 함부로 변경되서는 안된다.
// accessibility를 신경써야 함
@Table(name = "db_cust") // entity를 생성할 때의 테이블 명칭 부여
@Getter
@ToString(exclude = "custAddrEntityList")
// @Data 어노테이션은 자동으로 setter 기능도 들어가기 대문에 builder, getter, tostring 의존성을 부여
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class CustEntity {
    @Id
    @Column(name="cust_id", length = 30)
    private String id;
    @Column(length = 60, nullable = false)
    private String pwd;
    @Column(length = 50, nullable = false)
    private String name;

    // COMPOSITION!! 고객은 고객정보를 갖고 있다. (반드시!)
    // Aggreation: 고객은 고객정보를 가질 수도 있고 안 가질 수도 있다. (반드시는 아님)

    // 이 경우는 composition
    @OneToOne(mappedBy = "cust") // 호환성 - composition / aggregation
    private CustInfoEntity custInfo;

    @OneToMany(mappedBy = "cust")
    @Builder.Default
    private List<CustAddrEntity> custAddrEntityList = new ArrayList<CustAddrEntity>();

}
