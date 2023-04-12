package model.Manager;

import Controller.ManagerMenuController;
import Controller.MembershipCardController;

import java.util.List;

import static model.Manager.util.Utility.*;

public class ViewTest {
    public static Manager manager;
    public static MembershipCardController manageCard;
    public static ManagerMenuController manageMenu;

    static {
        manager = new Manager();
        manageCard = new MembershipCardController();
        manageMenu = new ManagerMenuController();

    }

    public static void main(String[] args) {
        start();
    }


    private static void start() {
        managerLogin();
        System.out.println("[관리자 계정으로 로그인하셨습니다.]");
        choiceManageMenu();
        String managerInputNum = input(">> 메뉴를 선택해주세요.");
        switch (managerInputNum) {

            case "1" :
                AddMenu();
                break;
            case "2" :

                deleteMenu();
                break;
                 /*
            case "3" :
                TodayMenu();
                break;
            case "4" :
                AccountBook();
                break;

             */
            case "5":
                MembershipCard();
                break;
            case "6":
                System.exit(0);
                break;
            default:
                System.out.println("잘못입력하셨습니다. 다시 입력해주세요");
        }
    }

    private static void deleteMenu() {
        System.out.println("[*****메뉴 삭제*****]");
        String deleteMenuName = input("삭제할 메뉴명을 입력해주세요 : ");
        boolean deleteResult = manageMenu.managerDeleteMenu(deleteMenuName);
            if (deleteResult){
                System.out.println("삭제에 성공했습니다.");
            }else {
                System.out.println("일치하는 메뉴명이 없습니다.");
            }
    }

    private static void AddMenu() {
        System.out.println("[*****메뉴 추가*****]");
        System.out.println("카테고리를 선택해주세요");
        System.out.println("[1.에스프레소], [2.라떼], [3.프라페&스무디], [4.티&에이드]");
        String selectCategory = input(">>");
        String menuName = input("추가할 메뉴명 : ");
        int menuPrice = Integer.parseInt(input("가격 : "));
        String optionMenuName = input("옵션 : ");
        boolean addResult = manageMenu.managerAddMenu(selectCategory, menuName, menuPrice, optionMenuName);
        if (addResult){
            System.out.println("메뉴 추가에 성공하였습니다.");
        }else {
            System.out.println("메뉴 추가에 실패하였습니다. 초기화면으로 돌아갑니다.");
        }
    }

    //1.메뉴 추가
    //----------------------------------------------------------------------
    //5.카드 관리
    private static void MembershipCard() {
        while (true) {
            System.out.println("1.카드 추가");
            System.out.println("2.카드 삭제");
            System.out.println("3.카드 전체 조회");
            System.out.println("4.처음으로 돌아가기");
            String inputCardNum = input(">>");
            switch (inputCardNum) {
                case "1":
                    while (true) {
                        String memberShipSerial = input("시리얼 번호 : ");
                        int memberShipAmount = Integer.parseInt(input("금액 : "));
                        String memberShipName = input("이름 : ");
                        //현재 카드현황을 가져오기
                        List<MembershipCard> viewMembershipCards = manageCard.viewAllMember();
                        //Serial중복 검사
                        for (int i = 0; i < viewMembershipCards.size(); i++) {
                            if (!viewMembershipCards.get(i).getMemberShipSerial().equals(memberShipSerial)) {
                                manageCard.addMember(memberShipSerial, memberShipAmount, memberShipName);
                                System.out.printf("[%s]님이 추가되었습니다.\n", memberShipName);
                                break;
                            } else {
                                System.out.println("중복된 시리얼 번호입니다. 다시 입력해주세요!");
                            }
                            break;
                        }
                        break;
                    }
                    break; // 오류 수정해야함

                case "2":
                    while (true) {
                        String deleteSerial = input("삭제할 카드의 시리얼 번호 : ");

                        if (manageCard.isRegistered(deleteSerial)) {
                            manageCard.deleteMember(deleteSerial);
                            System.out.println("성공적으로 삭제되었습니다!");
                            System.out.println("[현재 카드 현황]");
                            System.out.println(manageCard.viewAllMember());
                            break;
                        } else {
                            System.out.println("삭제에 실패했습니다. 정확한 번호를 입력해주세요.");
                        }
                    }
                    break;
                case "3":
                    System.out.println(manageCard.viewAllMember());
                    break;
                case "4":
                    //오류 수정해야함
                    break;
                default:
                    System.out.println("정확한 번호를 입력해주세요.");
            }

        }
    }

    //----------------------------------------------------------------------
    private static void choiceManageMenu() {
        System.out.println("1. 메뉴 추가");
        System.out.println("2. 메뉴 삭제");
        System.out.println("3. 오늘의 메뉴 선택");
        System.out.println("4. 가계 수입");
        System.out.println("5. 카드 관리");
        System.out.println("6. 처음 화면으로");
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
