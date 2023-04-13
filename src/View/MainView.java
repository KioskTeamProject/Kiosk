package View;

import Controller.ManagerMenuController;
import Controller.MembershipCardController;
import model.Manager.Manager;

import static model.Manager.util.Utility.*;

public class MainView {
    public static Manager manager;
    public static MembershipCardController manageCard;
    public static ManagerMenuController manageMenu;

    static {
        manager = new Manager();
        manageCard = new MembershipCardController();
        manageMenu = new ManagerMenuController();

    }

    public static void main(String[] args) {
        managerStart();
    }


    private static void managerStart() {
        managerLogin();
        System.out.println("[관리자 계정으로 로그인하셨습니다.]");
        while (true) {
            choiceManageMenu();
            String managerInputNum = input(">> 메뉴를 선택해주세요 : ");
            switch (managerInputNum) {
                case "1":
//                    System.out.println(manageMenu.viewAllMenu());
                    addMenu();
                    break;
                case "2":
                    deleteMenu();
                    break;
                case "3":
                    System.out.println(manageMenu.viewAllMenu());
                    break;

                case "4":
                    todayMenu();
                    break;

                case "5":
                    accountBook();
                    break;
                case "6":
                    membershipCard();
                    break;
                case "7":
                    System.exit(0); //나중에 수정하기
                    break;
                default:
                    System.out.println("잘못입력하셨습니다. 다시 입력해주세요");
            }
        }
    }


    //------------------------------------------------------------------------
    //1.메뉴추가
    private static void addMenu() {
        System.out.println("[*****메뉴 추가*****]");
        System.out.println("카테고리를 선택해주세요");
        System.out.println("[1.에스프레소], [2.라떼], [3.프라페&스무디], [4.티&에이드]");
        String selectCategory = input(">>");
        String menuName = input("추가할 메뉴명 : ");
        int menuPrice = Integer.parseInt(input("가격 : "));
        String optionMenuName = input("옵션 : ");
        boolean addResult = manageMenu.managerAddMenu(selectCategory, menuName, menuPrice, optionMenuName);
        if (addResult) {
            System.out.println("메뉴 추가에 성공하였습니다.");
        } else {
            System.out.println("메뉴 추가에 실패하였습니다. 초기화면으로 돌아갑니다.");
        }
    }

    //2.메뉴 삭제
    private static void deleteMenu() {
        System.out.println("[*****메뉴 삭제*****]");
        System.out.println(manageMenu.viewAllMenu());
        String deleteMenuName = input("삭제할 메뉴명을 입력해주세요 : ");
        boolean deleteResult = manageMenu.managerDeleteMenu(deleteMenuName);
        if (deleteResult) {
            System.out.println("삭제에 성공했습니다.");
        } else {
            System.out.println("일치하는 메뉴명이 없습니다.");
        }
    }

    //3.오늘의 메뉴
    private static void todayMenu() {
        String[] todayMenu = manageMenu.todayMenu();
        String todayMenuName = todayMenu[0];
        String todayMenuDiscount = todayMenu[1];
        System.out.printf("오늘의 메뉴는 [%s]이며, 할인율은 [%s%%]입니다.\n", todayMenuName, todayMenuDiscount);
    }

    //4.가계부
    private static void accountBook() {
    }

    //5.카드 관리
    private static void membershipCard() {
        while (true) {
            System.out.println("1.카드 추가");
            System.out.println("2.카드 삭제");
            System.out.println("3.카드 전체 조회");
            System.out.println("4.처음으로 돌아가기");
            String inputCardNum = input(">>");
            switch (inputCardNum) {
                case "1":
                    addCardMember();
                    break;
                case "2":
                    deleteCardMember();
                    break;
                case "3":
                    System.out.println(manageCard.viewAllMember());
                    break;
                case "4":
                    return;
                default:
                    System.out.println("정확한 번호를 입력해주세요.");
            }

        }

    }


    //5-1.카드 멤버 추가하기
    private static void addCardMember() {
        while (true) {
            String memberShipSerial = input("시리얼 번호 : ");
            int memberShipAmount = Integer.parseInt(input("금액 : "));
            String memberShipName = input("이름 : ");
            //Serial중복 검사
            boolean registered = manageCard.isRegistered(memberShipSerial);
            if (!registered) {
                manageCard.addMember(memberShipSerial, memberShipAmount, memberShipName);
                System.out.printf("[%s]님이 추가되었습니다.\n", memberShipName);
                break;
            } else {
                System.out.println("중복된 시리얼 번호입니다. 다시 입력해주세요!");
            }
        }
    }
    //5-2.카드 멤버 삭제하기
    private static void deleteCardMember() {
        while (true) {
            String deleteSerial = input("삭제할 카드의 시리얼 번호 : ");

            boolean resultDelete = manageCard.deleteMember(deleteSerial);
            if (resultDelete) {
                System.out.println("성공적으로 삭제되었습니다!");
                System.out.println("[현재 카드 현황]");
                System.out.println(manageCard.viewAllMember());
                break;
            } else {
                System.out.println("삭제에 실패했습니다. 정확한 번호를 입력해주세요.");
            }
        }
    }
    //----------------------------------------------------------------------
    //첫 진입 화면
    private static void choiceManageMenu() {
        System.out.println("1. 메뉴 추가");
        System.out.println("2. 메뉴 삭제");
        System.out.println("3. 메뉴 조회");
        System.out.println("4. 오늘의 메뉴 선택");
        System.out.println("5. 가계 수입");
        System.out.println("6. 카드 관리");
        System.out.println("7. 처음 화면으로");
    }

    //매니저 로그인 검사
    private static void managerLogin() {
        while (true) {
            String inputManagerId = input("관리자 아이디를 입력해주세요 : ");
            String inputManagerPw = input("관리자 비밀번호를 입력해주세요 : ");
            if (inputManagerId.equals(manager.getManagerId()) &&
                    inputManagerPw.equals(manager.getManagerPw())) {
                System.out.println("관리자 로그인에 성공했습니다.");
                break;
            } else {
                System.out.println("로그인에 실패했습니다.");
            }
        }
    }
}
