package model.Manager;

import Controller.ManagerMenuController;
import model.User.MenuCategory;
import model.User.MenuCategoryRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static model.Repository.*;
import static model.Repository.cafeAdelist;

public class Test {
    public static void test() {
        List<MenuCategory> cafeEspressolist = MenuCategoryRepository.cafeEspressolist;
    }

    public static void main(String[] args) {
      ManagerMenuController mmc = new ManagerMenuController();


        String[] strings = mmc.todayMenu();
        System.out.println(strings[1]);

    }
}

