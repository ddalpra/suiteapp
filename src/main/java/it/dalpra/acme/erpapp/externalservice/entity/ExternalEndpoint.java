package it.dalpra.acme.erpapp.externalservice.entity;

import it.dalpra.acme.erpapp.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "webservice_endpoints")
@Getter
@Setter
public class ExternalEndpoint extends BaseEntity{
    @Column(nullable = false, unique = true)
    private String serviceName;
    @Column(nullable = false)
    private String uri;
    @Column
    private String description;
    @Column
    private boolean enable=true;
}
