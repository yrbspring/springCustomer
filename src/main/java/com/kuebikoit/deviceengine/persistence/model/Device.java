package com.kuebikoit.deviceengine.persistence.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@ToString
public class Device implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @EqualsAndHashCode.Include
    private String hostname;
    private String ip;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date lasUpdateDate;
    private String vulnerability;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
}
