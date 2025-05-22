package com.example.demo.enity.IdClass;

import java.io.Serializable;
import java.util.Objects;

public class CTDDHId implements Serializable {
    private String masoDDH;
    private String mavt;

    public CTDDHId() {}

    public CTDDHId(String masoDDH, String mavt) {
        this.masoDDH = masoDDH;
        this.mavt = mavt;
    }

    // Getter/Setter nếu cần

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CTDDHId)) return false;
        CTDDHId that = (CTDDHId) o;
        return Objects.equals(masoDDH, that.masoDDH) &&
                Objects.equals(mavt, that.mavt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(masoDDH, mavt);
    }
}
