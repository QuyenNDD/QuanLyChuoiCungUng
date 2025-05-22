package com.example.demo.enity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "NhanVien", schema = "dbo", catalog = "QL_CCU")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NhanVien {
    @Id
    @Column(name = "MANV", nullable = false)
    private int maNv;

    @Column(name = "HO")
    private String ho;

    @Column(name = "TEN")
    private String ten;

    @Column(name = "DIACHI")
    private String diaChi;

    @Column(name = "NGAYSINH")
    private String ngaySinh;

    @Column(name = "LUONG")
    private String luong;

    @Column(name = "MACN")
    @ManyToOne
    private ChiNhanh maCN;

    @Column(name = "TrangThaiXoa")
    private int trangThaiXoa;

    @Column(name = "rowguid", columnDefinition = "uniqueidentifier")
    private UUID rowguid;
}
