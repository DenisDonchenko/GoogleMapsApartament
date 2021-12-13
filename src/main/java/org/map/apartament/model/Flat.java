package org.map.apartament.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "flat")
public class Flat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "rooms")
    private Integer rooms;

    @Column(name = "square")
    private Double square;

    @Column(name = "description")
    private String description;

    @Column(name = "address")
    private String address;

    @OneToOne
    @JoinColumn(name = "coordinates_id", nullable = false)
    private Coordinates coordinates;

    @OneToMany(mappedBy = "flat", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Photo> photo;

}
