package model.Manager;

import model.User.MenuCategory;
import model.User.MenuCategoryRepository;

import java.util.List;

public class Test {
    public static void test(){
        List<MenuCategory> cafeEspressolist = MenuCategoryRepository.cafeEspressolist;
    }

    public static void main(String[] args) {
        test();
//        MenuCategoryRepository.cafeEspressolist
//        List<MenuCategory> allMenuCategoryList = new ArrayList<>();
//        allMenuCategoryList.addAll(cafeEspressolist);
//        allMenuCategoryList.addAll(cafeLattelist);
//        allMenuCategoryList.addAll(cafeSmoothielist);
//        allMenuCategoryList.addAll(cafeAdelist);
//        System.out.println(allMenuCategoryList);
    }
}

