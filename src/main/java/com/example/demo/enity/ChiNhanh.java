package com.example.demo.enity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ChiNhanh", schema = "dbo", catalog = "QL_CCU")
public class ChiNhanh {
    @Id
    @Column(name = "MACN")
    private String maCN;

    @Column(name = "ChiNhanh")
    private String chiNhanh;

    @Column(name = "DIACHI")
    private String diaChi;

    @Column(name = "SoDT")
    private String soDT;
}
