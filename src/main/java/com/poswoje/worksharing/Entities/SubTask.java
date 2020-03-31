package com.poswoje.worksharing.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Table
public class SubTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Date deadline;

    @Column(nullable = false)
    private boolean done;

    @ManyToOne
    private TaskPriority taskPriority;

    @ManyToOne
    private MainTask mainTask;

    //User reserved for
}