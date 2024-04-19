package com.hana.app.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "item") // db에 테이블 생성, alias로 엔티티간 인식이 편하게!
@Table(name = "t_item")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED) // 같은 패키지 하위 객체
@Builder
@ToString
@Getter
public class ItemEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int id;
    // 데이터베이스의 특성을 탈 수 있으니 columnDefinition 속성이 존재하는 것
    // length, columDefinition 중 하나면 쓰면 됨
    @Column(nullable = false, unique = true, length = 30)
    private String name;
    @Column(nullable = false, columnDefinition = "int default 0")
    private int price;


    // 기본적으로 entity 안에 선언한 변수들은 테이블의 컬럼으로 만들어짐
    // 따라서 관계 설정할 때는 Persistence entity에 이런 타입을 쓸 수 없다고 나옴! 그래서 관계설정을 해주면 빨간줄이 없어진다!!!

    @ManyToOne
    @JoinColumn(name = "cate_id")
    // ManytoOne --> 기본이 EAGER. 따라서 아이템 조회할 때 나옴!
    private CateEntity cate;
}
