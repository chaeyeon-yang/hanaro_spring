package com.hana.app.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

// builder는 객체를 생성할 때 사용.. 날짜 같은 경우는 자동생성이므로 의존성 주입 x
@Getter
@ToString
@MappedSuperclass // 엔티티의 상위 클래스
@EntityListeners(AuditingEntityListener.class) // 데이터베이스에 생성되는 엔티티가 아니다
public class BaseEntity {
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Setter
    private LocalDateTime updatedAt;
}
