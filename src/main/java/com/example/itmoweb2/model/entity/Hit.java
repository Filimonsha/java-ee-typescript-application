package com.example.itmoweb2.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Builder(toBuilder = true)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name = "hit")
public class Hit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long hitId;

    private double hitX;

    private double hitY;

    private double hitR;

    private Date hitCurrentTime;

    private Date hitExecutionTime;

    private boolean areaHit;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
