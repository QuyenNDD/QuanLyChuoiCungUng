package com.example.demo.enity.IdClass;

import java.util.Objects;

public class CTPXId {
    private String maPX;
    private String mavt;

    public CTPXId() {}

    public CTPXId(String maPX, String mavt) {
        this.maPX = maPX;
        this.mavt = mavt;
    }

    // Getter/Setter nếu cần

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CTPNId)) return false;
        CTPXId that = (CTPXId) o;
        return Objects.equals(maPX, that.maPX) &&
                Objects.equals(mavt, that.mavt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maPX, mavt);
    }
}
