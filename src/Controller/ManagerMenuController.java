package Controller;

import model.User.MenuCategory;
import static model.Repository.*;
import java.util.ArrayList;
import java.util.List;

public class ManagerMenuController {
       /**
     * 1. 메뉴 추가
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
     * @param menuName : 메뉴명만 받아서 for문으로 리스트 삭제
     * @return
     */
    public boolean managerDeleteMenu(String menuName) {
        for (int i = 0; i < cafeAdelist.size(); i++) {
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
        }
        return false;
    }

    /**
     * 3.오늘의 메뉴
     */
    public void todayMenu() {
        //새로운 배열을 만들어 모든 메뉴 넣기
        List<MenuCategory> allMenuCategoryList = new ArrayList<>();
        allMenuCategoryList.addAll(cafeEspressolist);
        allMenuCategoryList.addAll(cafeLattelist);
        allMenuCategoryList.addAll(cafeSmoothielist);
        allMenuCategoryList.addAll(cafeAdelist);

        //Math.ramdom() * (y -x +1) + x
        //배열의 총 합을 구한 후 0~배열의수 -1까지 랜덤 숫자 반환
        //if 20개면 0~19
        //할인율 1~10%까지
        int randomDiscountNum = (int)(Math.random() * 10) + 1;
        int randomMenuNum = (int)(Math.random() * allMenuCategoryList.size());
        String randomMenu = allMenuCategoryList.get(randomMenuNum).getMenuName();
//        if(cafe)
        //랜덤숫자(길이)만큼 출력 -> 이름을 반환 -> 그 이름에 맞는 메뉴를 찾고 setPrice;

        }
    }



