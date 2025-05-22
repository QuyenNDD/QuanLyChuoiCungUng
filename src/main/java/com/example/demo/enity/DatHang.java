package com.example.demo.enity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "DatHang", schema = "dbo", catalog = "QL_CCU")
public class DatHang {
    @Id
    @Column(name = "MasoDDH", nullable = false)
    private String masoDDH;

    @Column(name = "NGAY", nullable = false)
    private LocalDate ngay;

    @Column(name = "NhaCC", nullable = false)
    private String nhaCC;

    @Column(name = "MANV", nullable = false)
    @ManyToOne
    private NhanVien maNV;

    @Column(name = "MAKHO")
    @ManyToOne
    private Kho maKho;

    @Column(name = "rowguid", columnDefinition = "uniqueidentifier")
    private UUID rowguid;
}
