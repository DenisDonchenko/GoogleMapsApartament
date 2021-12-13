package org.map.apartament.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "photo")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "photo")
    private byte[] photo;

    @ManyToOne
    @JoinColumn(name = "flat_id", nullable = false)
    private Flat flat;
}
