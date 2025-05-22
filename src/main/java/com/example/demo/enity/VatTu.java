package com.example.demo.enity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "Vattu", schema = "dbo", catalog = "QL_CCU")
public class VatTu {
    @Id
    @Column(name = "MAVT", nullable = false)
    private String maVT;

    @Column(name = "TENVT", nullable = false)
    private String tenVT;

    @Column(name = "DVT", nullable = false)
    private String dVT;

    @Column(name = "SOLUONGTON", nullable = false)
    private String soLuongTon;

    @Column(name = "rowguid", columnDefinition = "uniqueidentifier")
    private UUID rowguid;
}
