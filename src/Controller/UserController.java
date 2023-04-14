package Controller;

import model.Manager.MembershipCard;
import model.User.MenuCategory;

import java.util.ArrayList;
import java.util.List;

import static model.Repository.*;

public class UserController {

    // 시리얼 번호를 입력 받아서 해당 멤버쉽카드 정보를 반환하는 기능
    public MembershipCard checkSerialNumber(String inputSerialNumber){
        for (MembershipCard membershipCard : card) {
            if(membershipCard.getMemberShipSerial().equals(inputSerialNumber)){
                return membershipCard;
            }
        }
        return null;
    }

    // 충전금액을 입력하면 충전해주고 현재잔액을 반환하는 기능
    public void pointCharge(MembershipCard userCard, String inputNum) {
        switch (inputNum){
            case "1":
                userCard.setMemberShipAmount(userCard.getMemberShipAmount()+10000);
                break;
            case "2":
                userCard.setMemberShipAmount(userCard.getMemberShipAmount()+20000);
                break;
            case "3":
                userCard.setMemberShipAmount(userCard.getMemberShipAmount()+30000);
                break;
        }
    }

    // 카테고리를 입력받아 해당 카테고리를 반환해주는 기능
    public List<MenuCategory> menuCategories(String inputNum){
        switch (inputNum){
            case "1":
                return cafeEspressolist;
            case "2":
                return cafeLattelist;
            case "3":
                return cafeSmoothielist;
            case "4":
                return cafeAdelist;
        }
        return null;
    }



    // menuCart 에 해당 값 저장
    // 사용자가 선택한 메뉴를 가져와서 카트에 담는 기능
        ArrayList<String> menuCart = new ArrayList<>();
    public boolean menuCartIn(String menuinput) {
        boolean espressoList = cafeEspressolist.stream()
                .anyMatch(menu -> menu.getMenuName().equals(menuinput));
        boolean latteList = cafeLattelist.stream()
                .anyMatch(menu -> menu.getMenuName().equals(menuinput));
        boolean smoothieList = cafeSmoothielist.stream()
                .anyMatch(menu -> menu.getMenuName().equals(menuinput));
        boolean adeList = cafeAdelist.stream()
                .anyMatch(menu -> menu.getMenuName().equals(menuinput));
        if (espressoList) {
            for (int i = 0; i < cafeEspressolist.size(); i++) {
                int indexOf = cafeEspressolist.get(i).getMenuName().indexOf(menuinput);
                if (indexOf == 0) {
                    menuCart.add(menuinput);
                    return true;
                }
            }
        } else if (latteList) {
            for (int i = 0; i < cafeLattelist.size(); i++) {
                int indexOf = cafeLattelist.get(i).getMenuName().indexOf(menuinput);
                if (indexOf == 0) {
                    menuCart.add(menuinput);
                    return true;
                }
            }
        } else if (smoothieList) {
            for (int i = 0; i < cafeSmoothielist.size(); i++) {
                int indexOf = cafeSmoothielist.get(i).getMenuName().indexOf(menuinput);
                if (indexOf == 0) {
                    menuCart.add(menuinput);
                    return true;
                }
            }
        } else if (adeList) {
            for (int i = 0; i < cafeAdelist.size(); i++) {
                int indexOf = cafeAdelist.get(i).getMenuName().indexOf(menuinput);
                if (indexOf == 0) {
                    menuCart.add(menuinput);
                    return true;
                }
            }
        }
        return false;
    }

    public void menuOption(boolean cartIn, String optionchoice) {
        if(optionchoice.equals("y")){
            menuCart.add()
        }
    }


    //메뉴를 선택 받으면 ice를 선택할지 hot을 선택할지 고르는 기능


    // 메뉴 상태 옵션을 입력받아 장바구니에 담는 기능 , 장바구니에 담은 걸 반환하는 기능

    // 장바구니 객체를 입력받고 삭제할 메뉴 번호를 입력받아서 삭제해주는 장바구니 객체를 반환하는 기능

    // 결제 후 최종영수증 출력해주는 기능

    // 장바구니 입력받아서 결제하는 기능(영수증)

}






