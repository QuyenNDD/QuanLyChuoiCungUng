package com.example.demo.enity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "PhieuXuat", schema = "dbo", catalog = "QL_CCU")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhieuXuat {
    @Id
    @Column(name = "MAPX", nullable = false)
    private String maPX;

    @Column(name = "NGAY", nullable = false)
    private LocalDate ngay;

    @Column(name = "HOTENKH", nullable = false)
    private String hoTenKH;

    @ManyToOne
    @Column(name = "MANV", nullable = false)
    private NhanVien maNV;

    @ManyToOne
    @Column(name = "MAKHO")
    private Kho maKho;

    @Column(name = "rowguid", columnDefinition = "uniqueidentifier")
    private UUID rowguid;
}
