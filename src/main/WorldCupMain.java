package main;

import action.WorldCupAction;
import exception.WCNumberException;
import model.WorldCupModel;

import java.util.List;
import java.util.Scanner;

public class WorldCupMain {

    public static void main(String[] args) {
        WorldCupAction worldCupAction = new WorldCupAction();
        boolean isLoop = true;
        List<WorldCupModel> worldCupList = null;
        while (isLoop) {
            try {
                System.out.println(">>>>> Vui lòng chọn menu ban muon su dung ben duoi [1-6]:");
                System.out.println("Khi chọn 1: Nhập các DoiBong.\n" +
                        "Khi chọn 2: Hiển thị thông tin các DoiBong đã nhập.\n" +
                        "Khi chọn 3:Nhập vào MaDB và hiển thị thông tin DoiBong có MaDB đó.\n" +
                        "Khi chọn 4: Nhập vào MaDB và xóa đội bóng đó. \n" +
                        "Khi chọn 5: Sắp xếp giảm dần theo số lần vô địch WorldCup.\n" +
                        "Khi chọn 6: Thoát khỏi hệ thống");
                System.out.println("_____________________________");
                int chon = new Scanner(System.in).nextInt();

                if (chon < 1 || chon > 6) {
                    throw new WCNumberException("[THONG BAO] - VUI LONG CHON MENU TU 1 - 6");
                }

                switch (chon) {
                    case 1:
                        System.out.println("Nhap so lan nhap cac doi bong WC:");
                        int soLanNhap = new Scanner(System.in).nextInt();
                        worldCupList = worldCupAction.inputData(soLanNhap);
                        break;
                    case 2:
                        if (WorldCupAction.isNullOrEmpty(worldCupList)) {
                            System.err.println(" >>>Ban vui long chon menu [1] de nhap thong tin doi bong, hien tai list doi bong dang khong co!");
                        } else {
                            System.out.println(">>> Thong tin da nhap:");
                            worldCupAction.showData(worldCupList);
                        }
                        break;
                    case 3:
                        if (WorldCupAction.isNullOrEmpty(worldCupList)) {
                            System.err.println(">>> Ban vui long chon menu [1] de nhap thong tin doi bong, hien tai list doi bong dang khong co!");
                        } else {
                            System.out.println("Vui long nhap ma doi bong de tim kiem:");
                            String maDB = new Scanner(System.in).nextLine();
                            System.out.println(maDB);
                            WorldCupModel worldCupModel = worldCupAction.findByMaDB(worldCupList, maDB);
                            if (worldCupModel == null) {
                                System.err.println(">>> Khong tim thay doi bong voi ma :" + maDB);
                            } else {
                                System.out.println(">>> Tim thay doi bong voi ma :" + maDB);
                                System.out.println(worldCupModel);
                            }
                        }
                        break;
                    case 4:
                        if (WorldCupAction.isNullOrEmpty(worldCupList)) {
                            System.err.println(">>> Ban vui long chon menu [1] de nhap thong tin doi bong, hien tai list doi bong dang khong co!");
                        } else {
                            System.out.println("Vui long nhap ma doi bong de xoa:");
                            String maDB = new Scanner(System.in).nextLine();
                            List<WorldCupModel> worldCupRemovedList = worldCupAction.removeMaDb(worldCupList, maDB);
                            if (worldCupRemovedList.size() == worldCupList.size()) {
                                System.err.println(">>> Khong tim thay doi bong voi ma :" + maDB + " de xoa!");
                            } else {
                                System.out.println(">>> Da xoa, thong tin hien tai cac doi bong:");
                                System.out.println(worldCupRemovedList);
                            }
                        }
                        break;
                    case 5:
                        if (WorldCupAction.isNullOrEmpty(worldCupList)) {
                            System.err.println(" >>>Ban vui long chon menu [1] de nhap thong tin doi bong, hien tai list doi bong dang khong co!");
                        } else {
                            System.out.println(">>> Da sap xep cac doi bong:");
                            worldCupAction.sortDescBySoLanVoDich(worldCupList);
                            worldCupAction.showData(worldCupList);
                        }
                        break;
                    default:
                        isLoop = false;
                        System.out.println("_____________________");
                        System.out.println("Good bye!");
                        System.out.println("_____________________");
                        break;
                }
            } catch (NumberFormatException e) {
                System.err.println("[THONG BAO] - VUI LONG NHAP KIEU SO [INTEGER]!");
            } catch (WCNumberException e) {
                System.err.println(e.getMessage());
            } catch (Exception e) {
                System.err.println("[THONG BAO] - CO LOI TRONG QUA TRINH XU LY, VUI LONG CHON VA NHAP LAI!");
            }
        }
    }


}
