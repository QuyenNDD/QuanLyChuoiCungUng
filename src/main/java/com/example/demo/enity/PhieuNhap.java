package com.example.demo.enity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "PhieuNhap", schema = "dbo", catalog = "QL_CCU")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhieuNhap {
    @Id
    @Column(name = "MAPN", nullable = false)
    private String maPN;

    @Column(name = "NGAY", nullable = false)
    private LocalDate ngay;

    @Column(name = "MasoDDH", nullable = false)
    @ManyToOne()
    private DatHang datHang;

    @ManyToOne
    @Column(name = "MANV", nullable = false)
    private NhanVien nhanVien;

    @ManyToOne
    @Column(name = "MAKHO", nullable = false)
    private Kho kho;

    @Column(name = "rowguid", columnDefinition = "uniqueidentifier")
    private UUID rowguid;
}
