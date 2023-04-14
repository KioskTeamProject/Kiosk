package View;

import Controller.ManagerMenuController;
import Controller.UserController;
import model.Manager.MembershipCard;
import model.User.MenuCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static model.Manager.util.Utility.input;
import static model.Manager.util.Utility.makeLine;

public class UserView {
    public static UserController user;
    public MembershipCard userCard;
    public MenuCategory mc;
    public ManagerMenuController MMC;

    static {
        user = new UserController();

    }


    // 시작
    public void start() {

        while (true) {

            UserLogin();
            UserChoice();
//            UserChoice();
            break;

        }

    }

    // 로그인 기능
    public void UserLogin() {
        while (true) {
            String userSerialLogin = input("Serial 번호를 입력해주세요 :");
            userCard = user.checkSerialNumber(userSerialLogin);
            if (userCard != null) {
                System.out.printf("%s님 안녕하세요. 현재 잔액은 %d 입니다. ",
                        userCard.getMemberShipName(), userCard.getMemberShipAmount());
                break;
            } else {
                System.out.println("Serial 번호가 틀립니다 다시 확인해주세요");
            }
        }
    }

    // 카드충전 or 주문하기 선택
    public void UserChoice() {
        while (true) {
            System.out.println("\n1.카드충전하기 2.메뉴선택하기");
            String userChoice = input("\n>>");
            switch (userChoice) {
                case "1":
                    memberShipCardCharge();
                    break;
                case "2":
                    userOrder();
                    break;
                default:
                    System.out.println("번호를 다시 입력해주세요");
            }
        }
    }


    //카드 충전
    public void memberShipCardCharge() {
        while (true) {
            System.out.println("충전하실 금액을 선택해주세요");
            System.out.println("# 1. 10000원");
            System.out.println("# 2. 20000원");
            System.out.println("# 3. 30000원");
            String chargeNum = input("\n#번호를 입력해주세요 : ");
            if (chargeNum.equals("1") || chargeNum.equals("2") || chargeNum.equals("3")) {
                user.pointCharge(userCard, chargeNum);
                System.out.printf("충전이 완료되었습니다 충전 후 잔액은 %d 입니다", userCard.getMemberShipAmount());
                break;
            } else System.out.println("잘못 입력하셨습니다.");

        }
    }

    //주문하기
    public void userOrder() {
        while (true) {
            while (true) {
                makeLine();
                System.out.println("메뉴를 입력해주세요");
                System.out.println("# 0. 뒤로가기");
                System.out.println("# 1. 에스프레소");
                System.out.println("# 2. 라떼");
                System.out.println("# 3. 스무디");
                System.out.println("# 4. 티");
                makeLine();
                String inputNum = input(">>");
                if (inputNum.equals("0")) {
                    UserChoice();
                    break;
                } else if (inputNum.equals("1") || inputNum.equals("2") || inputNum.equals("3") ||
                        inputNum.equals("4")) {
                    List<MenuCategory> menuCategoryList = user.menuCategories(inputNum);
                    List<String> collect = menuCategoryList.stream().map(d -> d.getMenuName()).collect(Collectors.toList());
                    for (int i = 0; i < collect.size(); i++) {
                        System.out.println(i + 1 + ". " + collect.get(i));
                    }
                    break;
                } else {
                    System.out.println("번호를 다시 입력해주세요");
                    userOrder();
                    continue;
                }
            }

            while (true) {
                System.out.println("메뉴를 입력해주세요. 뒤로가실려면 0번을 입력해주세요\n");
                String menuinput = input(">>\n");
                ArrayList<MenuCategory> userCart = user.serchedMenu(menuinput);
                if (menuinput.equals("0")) {
                    userOrder();
                    break;
                }


//                    String optionchoice = input("[핫]/[아이스] 입력해주세요\n");
//                    String option1 = user.menuOption(optionchoice);
//                    if (option1.equals("핫")) {
//                        if (optionchoice.equals("핫")) {
//                            System.out.println("핫 옵션이 선택되었습니다");
//                            break;
//                        } else if (option1.equals("아이스")) {
//                            System.out.println("아이스 옵션이 선택되었습니다");
//                            break;
//                        } else {
//                            System.out.println("옵션을 다시 입력해주세요");
//                            continue;
//                        }
//                    }
                    String optionchoice2 = input(mc.getOptionMenuName() + "옵션을 추가할까요?[y/n]\n");


//                        userCard.getMemberShipAmount()


            }
//


        }


    }

// 카테고리를 입력받아 해당 카테고리를 반환해주는 기능

// 메뉴 상태 옵션을 입력받아 장바구니에 담는 기능 , 장바구니에 담은 걸 반환하는 기능

// 장바구니 객체를 입력받고 삭제할 메뉴 번호를 입력받아서 삭제해주는 장바구니 객체를 반환하는 기능

// 결제 후 최종영수증 출력해주는 기능

// 장바구니 입력받아서 결제하는 기능(영수증)

}







