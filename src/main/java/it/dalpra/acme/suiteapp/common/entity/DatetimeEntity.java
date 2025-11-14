package it.dalpra.acme.suiteapp.common.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class DatetimeEntity {
    
    @CreationTimestamp
    @Column(name = "creation_date", updatable = false, nullable = false)
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name = "updated_date", nullable = false)
    private LocalDateTime modificationDate;

    @Column(name = "creation_user", updatable = false)
    private String creationUser;

    @Column(name = "updated_user")
    private String modificationUser;

    @Column(name="status", nullable = false)
    private ActiveStatus status = ActiveStatus.ENABLE;
}
