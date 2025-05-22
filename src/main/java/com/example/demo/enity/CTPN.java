package com.example.demo.enity;

import com.example.demo.enity.IdClass.CTPNId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "CTPN", schema = "dbo", catalog = "QL_CCU")
@IdClass(CTPNId.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CTPN {
    @Id
    @Column(name = "MAPN")
    private String mapn;

    @Id
    @Column(name = "MAVT")
    private String mavt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MAPN", referencedColumnName = "MAPN", insertable = false, updatable = false)
    private PhieuNhap phieuNhap;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MAVT", referencedColumnName = "MAVT", insertable = false, updatable = false)
    private VatTu vatTu;

    @Column(name = "SOLUONG")
    private int soLuong;

    @Column(name = "DONGIA")
    private Double donGia;

    @Column(name = "rowguid", columnDefinition = "uniqueidentifier")
    private UUID rowguid;
}
