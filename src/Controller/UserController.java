package Controller;

import model.Manager.MembershipCard;

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
    public void pointCharge(String pointCharge) {

    }


    // 카테고리를 입력받아 해당 카테고리를 반환해주는 기능

    // 메뉴 상태 옵션을 입력받아 장바구니에 담는 기능 , 장바구니에 담은 걸 반환하는 기능

    // 장바구니 객체를 입력받고 삭제할 메뉴 번호를 입력받아서 삭제해주는 장바구니 객체를 반환하는 기능

    // 결제 후 최종영수증 출력해주는 기능

    // 장바구니 입력받아서 결제하는 기능(영수증)

}
