package com.example.demo.ui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class FormChinh {
    @FXML
    private TabPane tabPane;
    @FXML private MenuItem btnNhanVien, btnVatTu, btnKho;
    @FXML private MenuItem btnDonDatHang, btnPhieuNhap, btnPhieuXuat;
    @FXML private MenuItem btnHoatDongNhanVien, btnTongHopNhapXuat, btnDonHangKhongPhieuNhap;
    @FXML private MenuItem btnChiTietNhapXuat, btnDanhSachVatTu, btnDanhSachNhanVien;
    @FXML private MenuItem btnDangNhap, btnDangXuat, btnLapTaiKhoan, btnThoat;
    @FXML private Menu menuNhapXuat, menuBaoCao;

    @FXML private Label MANHANVIEN, HOTEN, NHOM;

    private final HashMap<String, Tab> openTabs = new HashMap<>();

    @FXML
    private void initialize() {
        btnDangXuat.setDisable(true);
        btnLapTaiKhoan.setDisable(true);
    }

    @FXML
    private void handleDangNhap() {
        // Ví dụ mở form đăng nhập bằng Stage riêng
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo/FormDangNhap.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Đăng nhập");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleDangXuat() {
        btnDangNhap.setDisable(false);
        btnDangXuat.setDisable(true);
        btnLapTaiKhoan.setDisable(true);

        // 3. Ẩn các menu quyền riêng
        menuNhapXuat.setVisible(false);
        menuBaoCao.setVisible(false);

        // 4. Xóa các tab đang mở
        tabPane.getTabs().clear();
        openTabs.clear();

        // 5. Reset thông tin
        MANHANVIEN.setText("MÃ NHÂN VIÊN:");
        HOTEN.setText("HỌ TÊN:");
        NHOM.setText("VAI TRÒ:");

        // 6. Mở lại FormDangNhap dưới dạng Stage mới
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("\\demo\\src\\main\\resources\\com\\example\\demo\\FormDangNhap.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Đăng nhập");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL); // Đợi đăng nhập xong
            stage.showAndWait(); // Chờ người dùng đăng nhập lại
            // Nếu đăng nhập lại thành công, controller của FormDangNhap có thể gọi lại FormChinh để cập nhật thông tin
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Hàm được gọi từ form đăng nhập sau khi đăng nhập thành công
    public void setThongTinNguoiDung(String maNV, String hoTen, String nhom, boolean laTruongNhom) {
        MANHANVIEN.setText("Mã nhân viên: " + maNV);
        HOTEN.setText("Họ tên: " + hoTen);
        NHOM.setText("Vai trò: " + nhom);
        btnDangNhap.setDisable(true);
        btnDangXuat.setDisable(false);
        btnLapTaiKhoan.setDisable(!laTruongNhom);
    }

    private void openTab(String title, String fxmlPath) {
        if (openTabs.containsKey(title)) {
            tabPane.getSelectionModel().select(openTabs.get(title));
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Pane content = loader.load();
            Tab tab = new Tab(title, content);
            tab.setOnClosed(e -> openTabs.remove(title));
            tabPane.getTabs().add(tab);
            tabPane.getSelectionModel().select(tab);
            openTabs.put(title, tab);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Các hàm mở form
    @FXML private void openNhanVien() { openTab("Nhân viên", "/com/example/demo/FormNhanVien.fxml"); }
    @FXML private void openVatTu()    { openTab("Vật tư", "/com/example/demo/FormVatTu.fxml"); }
    @FXML private void openKho()      { openTab("Kho", "/com/example/demo/FormKho.fxml"); }
    @FXML private void openDonDatHang() { openTab("Đơn đặt hàng", "/com/example/demo/ui/FormDDH.fxml"); }
    @FXML private void openPhieuNhap()  { openTab("Phiếu nhập", "/com/example/demo/ui/FormPN.fxml"); }
    @FXML private void openPhieuXuat()  { openTab("Phiếu xuất", "/com/example/demo/ui/FormPX.fxml"); }

    @FXML private void openHoatDongNhanVien()     { openTab("Hoạt động nhân viên", "/com/example/demo/ui/Report_HDNV.fxml"); }
    @FXML private void openTongHopNhapXuat()      { openTab("Tổng hợp nhập/xuất", "/com/example/demo/ui/Report_THNX.fxml"); }
    @FXML private void openDonHangKhongPN()       { openTab("ĐH không có PN", "/com/example/demo/ui/Report_DHKPN.fxml"); }
    @FXML private void openChiTietNhapXuat()      { openTab("Chi tiết nhập/xuất", "/com/example/demo/ui/Report_CTNX.fxml"); }
    @FXML private void openDanhSachVatTu()        { openTab("DS vật tư", "/com/example/demo/ui/Report_VT.fxml"); }
    @FXML private void openDanhSachNhanVien()     { openTab("DS nhân viên", "/com/example/demo/ui/Report_NV.fxml"); }
    @FXML private void openTaoTaiKhoan()          {openTab("Tạo tài khoản", "/com/example/demo/ui/FormLapTaiKhoan.fxml");}
    @FXML
    private void handleThoat() {
        System.exit(0);
    }
}
