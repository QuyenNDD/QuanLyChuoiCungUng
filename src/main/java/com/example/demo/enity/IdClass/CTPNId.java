package com.example.demo.enity.IdClass;

import java.io.Serializable;
import java.util.Objects;

public class CTPNId implements Serializable {
    private String maPN;
    private String mavt;

    public CTPNId() {}

    public CTPNId(String maPN, String mavt) {
        this.maPN = maPN;
        this.mavt = mavt;
    }

    // Getter/Setter nếu cần

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CTPNId)) return false;
        CTPNId that = (CTPNId) o;
        return Objects.equals(maPN, that.maPN) &&
                Objects.equals(mavt, that.mavt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maPN, mavt);
    }
}
