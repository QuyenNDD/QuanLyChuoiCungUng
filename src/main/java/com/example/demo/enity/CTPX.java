package com.example.demo.enity;

import com.example.demo.enity.IdClass.CTPXId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "CTPX", schema = "dbo", catalog = "QL_CCU")
@IdClass(CTPXId.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CTPX {
    @Id
    @Column(name = "MAPX")
    private String mapx;

    @Id
    @Column(name = "MAVT")
    private String mavt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MAPX", referencedColumnName = "MAPX", insertable = false, updatable = false)
    private PhieuXuat phieuXuat;

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
