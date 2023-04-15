package Controller;

import model.Manager.MembershipCard;
import model.User.MenuCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static model.Repository.*;

public class UserController {

    // 시리얼 번호를 입력 받아서 해당 멤버쉽카드 정보를 반환하는 기능
    public MembershipCard checkSerialNumber(String inputSerialNumber) {
        for (MembershipCard membershipCard : card) {
            if (membershipCard.getMemberShipSerial().equals(inputSerialNumber)) {
                return membershipCard;
            }
        }
        return null;
    }

    // 충전금액을 입력하면 충전해주고 현재잔액을 반환하는 기능
    public void pointCharge(MembershipCard userCard, String inputNum) {
        switch (inputNum) {
            case "1":
                userCard.setMemberShipAmount(userCard.getMemberShipAmount() + 10000);
                break;
            case "2":
                userCard.setMemberShipAmount(userCard.getMemberShipAmount() + 20000);
                break;
            case "3":
                userCard.setMemberShipAmount(userCard.getMemberShipAmount() + 30000);
                break;
        }
    }

    // 카테고리를 입력받아 해당 카테고리를 반환해주는 기능
    public List<MenuCategory> menuCategories(String inputNum) {
        switch (inputNum) {
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

    // 사용자가 선택한 메뉴를 가져와서 카테고리 리스트에 있는지 확인하는기능


    // 핫 & 아이스를 고른걸 반환해주는 기능
    String orderChoiceOption;
    public String menuOption(String optionchoice) {
        if (optionchoice.equals("핫")) {
            orderChoiceOption = "핫";
        } else if (optionchoice.equals("아이스")) {
            orderChoiceOption = "아이스";
        } else
            orderChoiceOption = null;
        return optionchoice;
    }

    // 사용자가 선택한 메뉴를 담는 리스트
    static ArrayList<MenuCategory> UserOrderCart = new ArrayList<>();
    //사용자가 입력한 메뉴를 검색해서 담아주는 기능
    public ArrayList<MenuCategory> serchedMenu(String menuinput) {
        for (MenuCategory userMenu : allCafeMenuList) {
            if(userMenu.getMenuName().equals(menuinput)){
              UserOrderCart.add(userMenu);
            }else {
                UserOrderCart.add(null);
            }
        }
        return UserOrderCart;
    }


    // 메뉴 상태 옵션을 입력받아 장바구니에 담는 기능 , 장바구니에 담은 걸 반환하는 기능

    // 장바구니 객체를 입력받고 삭제할 메뉴 번호를 입력받아서 삭제해주는 장바구니 객체를 반환하는 기능

    // 결제 후 최종영수증 출력해주는 기능

    // 장바구니 입력받아서 결제하는 기능(영수증)


}






