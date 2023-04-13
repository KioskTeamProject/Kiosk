package View;

import Controller.UserController;
import model.Manager.MembershipCard;
import model.Manager.util.Utility;

import static model.Manager.util.Utility.input;
import static model.Manager.util.Utility.makeLine;

public class UserView {
   public static UserController user;
   public MembershipCard memberCard;
   static {
       user = new UserController();
//       userCard = new MembershipCard();
   }


    // 시작
    public void start() {

        while (true){
         // 사용자가 시리얼 번호를 입력하고 로그인하는 기능
            MembershipCard userSerialCard = UserLogin();
            Userchoice(userSerialCard);

        }

    }

            // 사용자가 시리얼 번호를 입력하고 로그인하는 기능
            // 시리얼 번호를 입력 받아서 해당 멤버쉽카드 정보를 반환하는 기능
            public MembershipCard UserLogin() {
              while (true){
                makeLine();
                String userSerialLogin = input("Serial 번호를 입력해주세요 : ");
                MembershipCard userCard = user.checkSerialNumber(userSerialLogin);
                if (userCard != null) {
                    makeLine();
                    System.out.printf("\n%s님 안녕하세요. 현재 잔액은 %d 입니다\n.",
                            userCard.getMemberShipName(),userCard.getMemberShipAmount());
                  makeLine();
                  this.memberCard = memberCard;
                  return userCard;
                }else {
                    System.out.println("Serial 번호가 틀립니다 다시 확인해주세요");
                }
              }
            }

    public void Userchoice(MembershipCard membershipCard) {
//        String userChoice = input("\n>> 1.카드충전하기 2.메뉴선택하기");
//        if(userChoice.equals("1")){
//            System.out.println("==== 카드 충전하기 =====");
//            System.out.println("#1. 10000원 #2. 20000원 #3.30000원");
//            String pointCharge = input("\n >> 충전금액을 선택해주세요 ");
//            user.pointCharge(membershipCard.get);
            System.out.println(memberCard.getMemberShipName());
            }
        }
//
//    }


    // 충전금액을 입력하면 충전해주고 현재잔액을 반환하는 기능

    // 카테고리를 입력받아 해당 카테고리를 반환해주는 기능

    // 메뉴 상태 옵션을 입력받아 장바구니에 담는 기능 , 장바구니에 담은 걸 반환하는 기능

    // 장바구니 객체를 입력받고 삭제할 메뉴 번호를 입력받아서 삭제해주는 장바구니 객체를 반환하는 기능

    // 결제 후 최종영수증 출력해주는 기능
    // 주문한 정보 :
    // shoppingCart 객체 : 주문한 정보를 담는다.
    // shoppingCart에 담은 객체를 반환 받기.
    // 장바구니 입력받아서 결제하는 기능(영수증)

