package com.sparta.board.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass//상속했을때 밑에 애들을 쓸수있게
public abstract class Timestamped {

    @CreationTimestamp
    private LocalDateTime createTime;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

}
