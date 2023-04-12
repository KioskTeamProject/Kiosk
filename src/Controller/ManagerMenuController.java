package Controller;

import model.User.MenuCategory;

import static model.Repository.*;

import java.util.ArrayList;
import java.util.List;

public class ManagerMenuController {
    /**
     * 1. 메뉴 추가
     *
     * @param selectCategory : 메뉴 추가 버튼에서 카테고리 입력
     *                       menuName, menuPrice, optionMenuName : 생성자
     * @return : boolean
     */
    public boolean managerAddMenu(String selectCategory, String menuName, int menuPrice, String optionMenuName) {
        switch (selectCategory) {
            case "1":
                boolean add =
                        cafeEspressolist.add(new MenuCategory(menuName, menuPrice, optionMenuName));
                return true;
            case "2":
                cafeLattelist.add(new MenuCategory(menuName, menuPrice, optionMenuName));
                return true;
            case "3":
                cafeSmoothielist.add(new MenuCategory(menuName, menuPrice, optionMenuName));
                return true;
            case "4":
                cafeAdelist.add(new MenuCategory(menuName, menuPrice, optionMenuName));
                return true;
            default:
                return false;
        }
    }

    /**
     * 1+a. 전체 메뉴 출력
     *
     * @return : <List> allMenuCategoryList
     */
    public List viewAllMenu() {
        List<List> allMenuCategoryList = new ArrayList<>();
        allMenuCategoryList.add(cafeEspressolist);
        allMenuCategoryList.add(cafeLattelist);
        allMenuCategoryList.add(cafeSmoothielist);
        allMenuCategoryList.add(cafeAdelist);
        return allMenuCategoryList;
    }

    /**
     * 2. 메뉴 삭제
     * @param menuName : 메뉴명만 받아서 true,false확인 후 for문으로 해당 메뉴 삭제
     * @return
     */
    public boolean managerDeleteMenu(String menuName) {
        boolean espressoResult = cafeEspressolist.stream()
                .anyMatch(menu -> menu.getMenuName().equals(menuName));
        boolean latteResult = cafeLattelist.stream()
                .anyMatch(menu -> menu.getMenuName().equals(menuName));
        boolean smoothieResult = cafeSmoothielist.stream()
                .anyMatch(menu -> menu.getMenuName().equals(menuName));
        boolean adeResult = cafeAdelist.stream()
                .anyMatch(menu -> menu.getMenuName().equals(menuName));

        if (espressoResult) {
            for (int i = 0; i < cafeEspressolist.size(); i++) {
                int indexOf = cafeEspressolist.get(i).getMenuName().indexOf(menuName);
                if (indexOf == 0) {
                    cafeEspressolist.remove(i);
                    return true;
                }
            }
        } else if (latteResult) {
            for (int i = 0; i < cafeLattelist.size(); i++) {
                int indexOf = cafeLattelist.get(i).getMenuName().indexOf(menuName);
                if (indexOf == 0) {
                    cafeLattelist.remove(i);
                    return true;
                }
            }
        } else if (smoothieResult) {
            for (int i = 0; i < cafeSmoothielist.size(); i++) {
                int indexOf = cafeSmoothielist.get(i).getMenuName().indexOf(menuName);
                if (indexOf == 0) {
                    cafeSmoothielist.remove(i);
                    return true;
                }
            }
        } else if (adeResult) {
            for (int i = 0; i < cafeAdelist.size(); i++) {
                int indexOf = cafeAdelist.get(i).getMenuName().indexOf(menuName);
                if (indexOf == 0) {
                    cafeAdelist.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 3.오늘의 메뉴
     */
    public static String[] todayMenu() {
        List<MenuCategory> allMenuCategoryList = new ArrayList<>();
        allMenuCategoryList.addAll(cafeEspressolist);
        allMenuCategoryList.addAll(cafeLattelist);
        allMenuCategoryList.addAll(cafeSmoothielist);
        allMenuCategoryList.addAll(cafeAdelist);

        //Math.ramdom() * (y -x +1) + x

        //할인율 1~20%까지
        int randomDiscountNum = (int) (Math.random() * 20) + 1;
        int randomMenuNum = (int) (Math.random() * allMenuCategoryList.size());
        //랜덤숫자(길이)만큼 출력 -> 이름을 반환 -> 그 이름에 맞는 메뉴를 찾고 setPrice;
        String randomMenu = allMenuCategoryList.get(randomMenuNum).getMenuName();
        //오늘의 메뉴와 할인율을 String으로 반환
        String[] randomResult = {randomMenu, String.valueOf(randomDiscountNum)};

        /**
         * 각 배열에 randomMenu와 같은 메뉴명이 있는지 확인
         * 각각의 boolean을 받아 setMenuPrice실행
         */
        boolean espressoResult = cafeEspressolist.stream()
                .anyMatch(menu -> menu.getMenuName().equals(randomMenu));
        boolean latteResult = cafeLattelist.stream()
                .anyMatch(menu -> menu.getMenuName().equals(randomMenu));
        boolean smoothieResult = cafeSmoothielist.stream()
                .anyMatch(menu -> menu.getMenuName().equals(randomMenu));
        boolean adeResult = cafeAdelist.stream()
                .anyMatch(menu -> menu.getMenuName().equals(randomMenu));

        if (espressoResult) {
            for (int i = 0; i < cafeEspressolist.size(); i++) {
                int indexOf = cafeEspressolist.get(i).getMenuName().indexOf(randomMenu);
                if (indexOf == 0) {
                    cafeEspressolist
                            .get(i).setMenuPrice((int) (cafeEspressolist.get(i).getMenuPrice() - (cafeEspressolist.get(i).getMenuPrice() * (randomDiscountNum*0.01))));
                }
            }
        } else if (latteResult) {
            for (int i = 0; i < cafeLattelist.size(); i++) {
                int indexOf = cafeLattelist.get(i).getMenuName().indexOf(randomMenu);
                if (indexOf == 0) {
                    cafeLattelist
                            .get(i).setMenuPrice((int) (cafeLattelist.get(i).getMenuPrice() - (cafeLattelist.get(i).getMenuPrice() * (randomDiscountNum*0.01))));
                }
            }
        } else if (smoothieResult) {
            for (int i = 0; i < cafeSmoothielist.size(); i++) {
                int indexOf = cafeSmoothielist.get(i).getMenuName().indexOf(randomMenu);
                if (indexOf == 0) {
                    cafeSmoothielist
                            .get(i).setMenuPrice((int) (cafeSmoothielist.get(i).getMenuPrice() - (cafeSmoothielist.get(i).getMenuPrice() * (randomDiscountNum*0.01))));
                }
            }
        } else if (adeResult) {
            for (int i = 0; i < cafeAdelist.size(); i++) {
                int indexOf = cafeAdelist.get(i).getMenuName().indexOf(randomMenu);
                if (indexOf == 0) {
                    cafeAdelist
                            .get(i).setMenuPrice((int) (cafeAdelist.get(i).getMenuPrice() - (cafeAdelist.get(i).getMenuPrice() * (randomDiscountNum*0.01))));
                }
            }
        }
        return randomResult;
    }

 /*
            if (cafeEspressolist.get(i).getMenuName().equals(menuName)) {
                cafeEspressolist.remove(i);
                return true;
            } else if (cafeLattelist.get(i).getMenuName().equals(menuName)) {
                cafeLattelist.remove(i);
                return true;
            } else if (cafeSmoothielist.get(i).getMenuName().equals(menuName)) {
                cafeSmoothielist.remove(i);
                return true;
            } else if (cafeAdelist.get(i).getMenuName().equals(menuName)) {
                cafeAdelist.remove(i);
                return true;
            }
             */
}



