package action;

import model.WorldCupModel;

import java.util.*;

public class WorldCupAction {

    public List<WorldCupModel> inputData(int n) {
        List<WorldCupModel> worldCupList = new ArrayList<>();
        WorldCupModel worldCupModel;
        Scanner input = new Scanner(System.in);
        for (int i = 1; i <= n; i++) {
            System.out.println("Nhap ma doi bong:");
            String maDb = input.nextLine();
            System.out.println("Nhap ten doi bong:");
            String tenDoiBong = input.nextLine();
            System.out.println("Nhap HLV truong doi bong:");
            String hlvTruong = input.nextLine();
            System.out.println("Nhap so lan vo dich cua doi bong:");
            int soLanVoDich = Integer.parseInt(input.nextLine());
            worldCupModel = new WorldCupModel(maDb, tenDoiBong, hlvTruong, soLanVoDich);
            worldCupList.add(worldCupModel);
        }
        return worldCupList;
    }

    public void showData(List<WorldCupModel> worldCupList) {
        for (WorldCupModel worldCupModel : worldCupList) {
            System.out.println(worldCupModel);
        }
    }

    public WorldCupModel findByMaDB(List<WorldCupModel> worldCupList, String maDB) {
        for (WorldCupModel worldCupModel : worldCupList) {
            if (maDB.equals(worldCupModel.getMaDB())) {
                return worldCupModel;
            }
        }
        return null;
    }

    public List<WorldCupModel> removeMaDb(List<WorldCupModel> worldCupList, String maDB) {
        Iterator<WorldCupModel> wcIterator = worldCupList.iterator();
        while (wcIterator.hasNext()) {
            WorldCupModel currentItem = wcIterator.next();
            if (currentItem.getMaDB().equals(maDB)) {
                wcIterator.remove();
                break;
            }
        }
        return worldCupList;
    }

    public List<WorldCupModel> sortDescBySoLanVoDich(List<WorldCupModel> worldCupList) {
        Collections.sort(worldCupList, new Comparator<WorldCupModel>() {
            @Override
            public int compare(WorldCupModel o1, WorldCupModel o2) {
                return o2.getSoLanVoDich() - o1.getSoLanVoDich();
            }
        });
        return worldCupList;
    }

    public static boolean isNullOrEmpty(List<WorldCupModel> worldCupList) {
        if (worldCupList == null || worldCupList.size() == 0) {
            return true;
        }
        return false;
    }

    public void displayInvalid(List<WorldCupModel> worldCupList) {
        if (WorldCupAction.isNullOrEmpty(worldCupList)) {
            System.err.println("Ban vui long chon menu [1] de nhap thong tin doi bong, hien tai list doi bong dang khong co!");
        }
    }
}
