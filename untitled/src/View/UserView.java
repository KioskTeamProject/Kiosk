package View;

import Controller.ManagerMenuController;
import Controller.UserController;
import model.Manager.MembershipCard;
import model.Repository;
import model.User.MenuCategory;


import java.util.List;
import java.util.stream.Collectors;

import static model.Manager.util.Utility.input;
import static model.Manager.util.Utility.makeLine;
import static model.Repository.saleList;

public class UserView {
    public static UserController user;
    public MembershipCard userCard;
    public static ManagerMenuController MMC;
    static {
        user = new UserController();
        MMC = new ManagerMenuController();
    }


    public void UserMemberShip(){

        // 시리얼 번호를 입력받아 접속
        System.out.println();
        System.out.println("\u001B[33m====== STAR BUCKS Membership Order ======\u001B[0m");
        System.out.println("스마트 오더를 이용해주셔서 감사합니다");
        while (true) {
            String userSerialLogin = input("Serial 번호를 입력해주세요 :");
            userCard = user.checkSerialNumber(userSerialLogin);
            if (userCard != null) {
                System.out.printf("\n\u001B[34m%s님\u001B[0m 안녕하세요.현재 잔액은\u001B[34m %d\u001B[0m입니다. ",
                        userCard.getMemberShipName(), userCard.getMemberShipAmount());
                break;
            } else {
                System.out.println("\u001B[31mSerial 번호가 틀립니다 다시 확인해주세요\u001B[0m");
            }
        }
        pointCharge();
    }



    // 주문하기
    public void userOrder(){
        // 메뉴 화면
        while (true){
            System.out.println("\u001B[33m====== STAR BUCKS Membership Order ======\u001B[0m");
            System.out.println("\u001B[36m# 1.\u001B[0m 메뉴 보기");
            System.out.println("\u001B[36m# 2.\u001B[0m 이전으로 가기");
            System.out.println("\u001B[36m# 3.\u001B[0m 장바구니 가기");
            String inputUserMenuChoise = input(">>");
            switch (inputUserMenuChoise){
                case "1":
                    mainOrder();
                    break;
                case "2":
//                    UserMemberShip(); // 시리얼 넘버 입력으로 넘어감
                    pointCharge();
                    break;
                case "3":
                    viewCart();
                    break;
                default:
                    makeLine();
                    makeLine();
                    System.out.println(" \u001B[31m잘못된 입력입니다 \u001B[0m\n");
            }
        }
    }

    // 메뉴 보기
    public void mainOrder() {
        while (true) {
            // 카테고리 선택
            System.out.println("\u001B[33m====== STAR BUCKS Membership Order ======\u001B[0m");
//            System.out.println(); 오늘의 메뉴 추가
            System.out.println("\u001B[36m# 1.\u001B[0m 에스프레소");
            System.out.println("\u001B[36m# 2.\u001B[0m 라떼");
            System.out.println("\u001B[36m# 3.\u001B[0m 스무디");
            System.out.println("\u001B[36m# 4.\u001B[0m 티");
            System.out.println("\u001B[36m# 5.\u001B[0m 장바구니로 가기");
            System.out.println("\u001B[36m# 0.\u001B[0m 이전으로 가기");
            System.out.println("\u001B[33m============================\u001B[0m");
            System.out.println("메뉴 카테고리 번호를 입력해주세요");
            String inputNum = input(">>");

            switch (inputNum){
                case "1":
                    System.out.println("\u001B[33m\n======== Cafe Menu ========\u001B[0m");
                    user.menuCategories(inputNum).stream().forEach(x -> System.out.println(x.getMenuName()+" "+x.getMenuPrice()+"원"));
                    break;
                case "2":
                    System.out.println("\u001B[33m\n======== Cafe Menu ========\u001B[0m");
                    user.menuCategories(inputNum).stream().forEach(x -> System.out.println(x.getMenuName()+" "+x.getMenuPrice()+"원"));
                    break;
                case "3":
                    System.out.println("\u001B[33m\n======== Cafe Menu ========\u001B[0m");
                    user.menuCategories(inputNum).stream().forEach(x -> System.out.println(x.getMenuName()+" "+x.getMenuPrice()+"원"));
                    break;
                case "4":
                    System.out.println("\u001B[33m\n======== Cafe Menu ========\u001B[0m");
                    user.menuCategories(inputNum).stream().forEach(x -> System.out.println(x.getMenuName()+" "+x.getMenuPrice()+"원"));
                    break;
                case "5":
                    viewCart();
                    break;
                case "0":
                    continue;
                default:
                    System.out.println("\u001B[31m잘못된 입력입니다\u001B[0m");
                    continue;
            }
            subOrder(inputNum);

        }
    }

    private void subOrder(String inputnum1) {
        System.out.println("\u001B[33m============================\u001B[0m");
        while (true) {
            System.out.println("\n메뉴를 텍스트로 입력 해주세요");
            String inputNum2 = input(">>");
            List<MenuCategory> menuCategoryList = user.menuCategories(inputnum1);
            String menuName = user.menuReturn(inputnum1, inputNum2).getOptionMenuName();
            List<String> collect = menuCategoryList.stream().map(d -> d.getMenuName()).collect(Collectors.toList());
            if (collect.stream().anyMatch(d -> d.contains(inputNum2)) && menuCategoryList.stream().anyMatch(d->d.getStatus().contains("ice"))) {
//                System.out.println(menuName); // text == 샷추가 / 옵션이름
                System.out.println("선택하신 메뉴의 추가옵션 \u001B[35m["+menuName+"]\u001B[0m\n");
                System.out.println("옵션을 추가하시겠습니까 ?");
                System.out.println("\u001B[36m# 1.\u001B[0m 추가 \u001B[36m# 2.\u001B[0m 추가안함");
                subOrder2(inputnum1, inputNum2 ,"1");
                //  System.out.println(UserController.cartList.get(0).toString());
            }else if(collect.stream().anyMatch(d -> d.contains(inputNum2)) && menuCategoryList.stream().anyMatch(d->d.getStatus().contains("all"))) {
                System.out.println("HOT/ICE 번호로 선택해주세요");
                System.out.println("\u001B[36m# 1.\u001B[0m ICE\n\u001B[36m# 2.\u001B[0m HOT");
                String inputNum = input(">>");
                switch (inputNum){
                    case "1":
                    case "2":
                        System.out.println("선택하신 메뉴의 추가옵션\u001B[35m["+menuName+"]\u001B[0m\n");
                        System.out.println("옵션을 추가하시겠습니까 ?");
                        System.out.println("\u001B[36m# 1.\u001B[0m 추가\n\u001B[36m# 2.\u001B[0m 추가안함");
                        subOrder2(inputnum1, inputNum2, inputNum);
                        //  System.out.println(UserController.cartList.get(0).toString());
                }
            }else{
                System.out.println("\u001B[31m메뉴 이름을 다시 입력해주세요\u001B[0m");
            }
        }
    }



    //마지막 옵션

    /**
     *
     * @param menuCategoryNumber 메뉴 카테고리 번호 1.에스프레소 2.라떼 3.스모디 4.에이드
     * @param menuName 선택한 메뉴 이름
     * @param choiceOption 번호 1.핫 2.아이스
     */
    private void subOrder2(String menuCategoryNumber, String menuName, String choiceOption) {

        String inputNum = input(">>");
        switch (inputNum) {
            case "1":
            case "2":
                user.LastOrder(menuCategoryNumber, menuName, choiceOption, inputNum);
               //주문 후 주문한 메뉴를 보여주는
//                menuCategoryNumber.toString();
                System.out.println(menuName+"가 성공적으로 장바구니에 추가되었습니다");
                //System.out.println(UserController.cartList.get(0).toString()); //test
                ResultPage();
                break;
            default:
                makeLine();
                makeLine();
                System.out.println("\u001B[31m잘못된 입력입니다\u001B[0m");
        }
    }

    private void ResultPage() {
        while (true) {
            System.out.println("\n\u001B[36m# 1.\u001B[0m 장바구니 \n\u001B[36m# 2.\u001B[0m 결제하기\n\u001B[36m# 3.\u001B[0m 메뉴추가");
            String inputNum = input(">>");
            switch (inputNum){
                case "1":
                    viewCart();
                    break;
                case "2":
                    payment();
                    UserMemberShip();
//                    break;
                case "3":
                    mainOrder();
                    break;
                default:
                    System.out.println("\u001B[31m잘못된 입력입니다\u001B[0m");
            }
        }
    }

    private void viewCart() {
        System.out.println("\u001B[33m\n======== Shopping Cart ========\u001B[0m");
        int i = 0;
        if(UserController.cartList.size() > 0){
            List<MenuCategory> cartList = UserController.cartList;
            for (MenuCategory menuCategory : cartList) {
                i++;
                System.out.println(i+". "+menuCategory.toString());
            }

        }else {
            System.out.println("\n\u001B[31m\n현재 장바구니가 비어있습니다\u001B[0m \n2번을 눌러서 주문을 해주세요.");
        }
        while (true) {
            System.out.println("\u001B[33m============================\u001B[0m");
            System.out.println("\n\u001B[36m# 1.\u001B[0m 결제하기 \u001B[36m# 2.\u001B[0m 메뉴추가  \u001B[36m# 3.\u001B[0m 메뉴취소");
            String inputNum = input(">>");
            switch (inputNum) {
                case "1":
                    payment();
                    UserMemberShip();
//                    break;
                case "2":
                    mainOrder();
                    break;
                case "3":
                    System.out.println("취소 할 메뉴의 번호를 입력해주세요");
                    String inputNum1 = input(">>");
                    deleteCart(inputNum1);
                    break;
                default:
                    System.out.println("\u001B[0m잘못된 입력입니다\u001B[0m");
            }
        }

    }

    // 카드충전 or 주문하기
    public void pointCharge(){
        out: while (true) {
            System.out.println("\n\u001B[36m# 1.\u001B[0m 카드충전하기  \u001B[36m# 2.\u001B[0m 메뉴선택하기");
            String userChoice = input(">>");
            switch (userChoice) {
                case "1":
                    memberShipCardCharge();
                    continue;
                case "2":
                    userOrder();
                    break out;
                default:
                    makeLine();
                    makeLine();
                    System.out.println("\u001B[31m번호를 다시 입력해주세요\u001B[0m");
            }
        }

    }

    //카드 충전하는 기능
    public void memberShipCardCharge() {
        while (true) {
            System.out.println("\n충전하실 금액을 선택해주세요");
            System.out.println("\u001B[36m# 1.\u001B[0m 10000원");
            System.out.println("\u001B[36m# 2.\u001B[0m 20000원");
            System.out.println("\u001B[36m# 3.\u001B[0m 30000원");
            String chargeNum = input("\n#번호를 입력해주세요 : ");
            if (chargeNum.equals("1") || chargeNum.equals("2") || chargeNum.equals("3")) {
                user.pointCharge(userCard, chargeNum);
                System.out.printf("\n충전이 완료되었습니다 충전 후 잔액은 %d 입니다", userCard.getMemberShipAmount());
                break;
            } else
                makeLine();
            makeLine();
            System.out.println("\u001B[31m잘못 입력하셨습니다.\u001B[0m\n");

        }
    }
    // 가격계산 0414 3:22
    private void payment() {

        int sum = 0;
        List<MenuCategory> cartList = UserController.cartList;
        System.out.println("\u001B[33m\n======== Payment Screen ========\u001B[0m");
        for (MenuCategory menuCategory : cartList) {
            sum += menuCategory.getMenuPrice();
            sum += menuCategory.getOptionMenuPrice();
            System.out.println(menuCategory.getStatus()+menuCategory.getMenuName()+"["+menuCategory.getOptionMenuName()+"]"+(menuCategory.getOptionMenuPrice()+menuCategory.getMenuPrice())+"원");
        }
        System.out.println("\t\t\t\t \u001B[35m총 결제금액:\u001B[0m"+sum); // 장바구니 총금액
//        System.out.println("\t\t\t \u001B[35m결제 후 남은금액:\u001B[0m"+userCard.getMemberShipAmount()); // 결제 후 남은금액
        System.out.println("\u001B[33m=================================\u001B[0m");
        if(sum > userCard.getMemberShipAmount()){
            System.out.println("\n잔액이 부족합니다");
        }else {
            userCard.setMemberShipAmount(userCard.getMemberShipAmount() - sum);
            // 결제가 완료되면 영수증을 저장소의 saleList에 저장
            List<MenuCategory> receiptLlist = Repository.saleList;
            List<MenuCategory> cartList1 = UserController.cartList;
            for (MenuCategory menuCategory : cartList1) {
                receiptLlist.add(menuCategory);
            }
        }
//        System.out.println(userCard.getMemberShipAmount()); // 잔액
    }
    // 번호입력하면 해당 메뉴 삭제
    private void deleteCart(String inputNum){
        int n = Integer.parseInt(inputNum);
        UserController.cartList.remove(n-1);
        payment();
    }

}