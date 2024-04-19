package com.hana.app.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "cate") // db에 테이블 생성, alias로 엔티티간 인식이 편하게!
@Table(name = "t_cate")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED) // 같은 패키지 하위 객체
@Builder
@ToString
@Getter
public class CateEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cate_id")
    private int id;
    @Column(nullable = false, unique = true, length = 50, columnDefinition = "varchar(30)")
    private String name;
}
