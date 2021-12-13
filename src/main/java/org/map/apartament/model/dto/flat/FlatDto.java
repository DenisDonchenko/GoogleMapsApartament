package org.map.apartament.model.dto.flat;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@Getter
@Setter
public class FlatDto {

    private Integer rooms;

    private Double square;

    private String description;

    private String address;

    private String latitude;

    private String longitude;

    private ArrayList<MultipartFile> photos;

    public FlatDto(Integer rooms, Double square,
                   String description, String address, String latitude, String longitude, ArrayList<MultipartFile> photos) {
        this.rooms = rooms;
        this.square = square;
        this.description = description;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.photos = photos;
    }

}
