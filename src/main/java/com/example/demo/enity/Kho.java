package com.example.demo.enity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Kho", schema = "dbo", catalog = "QL_CCU")
public class Kho {
    @Id
    @Column(name = "MAKHO", nullable = false)
    private String maKho;

    @Column(name = "TENKHO", nullable = false)
    private String tenKho;

    @Column(name = "DIACHI")
    private String diaChi;

    @Column(name = "MACN")
    @ManyToOne
    private ChiNhanh maCN;

    @Column(name = "rowguid", columnDefinition = "uniqueidentifier")
    private UUID rowguid;
}
