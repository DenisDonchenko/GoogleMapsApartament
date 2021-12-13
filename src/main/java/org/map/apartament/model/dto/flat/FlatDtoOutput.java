package org.map.apartament.model.dto.flat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class FlatDtoOutput {

    private Integer rooms;

    private Double square;

    private String description;

    private String address;

    private String latitude;

    private String longitude;

    private Set<String> photos;

}
