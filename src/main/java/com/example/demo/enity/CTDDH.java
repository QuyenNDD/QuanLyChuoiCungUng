package com.example.demo.enity;

import com.example.demo.enity.IdClass.CTDDHId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "CTDDH", schema = "dbo", catalog = "QL_CCU")
@IdClass(CTDDHId.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CTDDH {
    @Id
    @Column(name = "MasoDDH")
    private String masoDDH;

    @Id
    @Column(name = "MAVT")
    private String maVT;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MasoDDH", referencedColumnName = "MasoDDH", insertable = false, updatable = false)
    private DatHang datHang;

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
