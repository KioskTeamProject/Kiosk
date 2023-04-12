package model.Manager;

import java.util.Objects;

public class MembershipCard {
    private String memberShipSerial; //시리얼 번호
    private int memberShipAmount; //잔액
    private String memberShipName; //닉네임

    public MembershipCard() {
    }

    public MembershipCard(String memberShipSerial, int memberShipAmount, String memberShipName) {
        this.memberShipSerial = memberShipSerial;
        this.memberShipAmount = memberShipAmount;
        this.memberShipName = memberShipName;
    }

    public String getMemberShipSerial() {
        return memberShipSerial;
    }

    public void setMemberShipSerial(String memberShipSerial) {
        this.memberShipSerial = memberShipSerial;
    }

    public int getMemberShipAmount() {
        return memberShipAmount;
    }

    public void setMemberShipAmount(int memberShipAmount) {
        this.memberShipAmount = memberShipAmount;
    }

    public String getMemberShipName() {
        return memberShipName;
    }

    public void setMemberShipName(String memberShipName) {
        this.memberShipName = memberShipName;
    }

    @Override
    public String toString() {
        return "membershipCard{" +
                "memberShipSerial='" + memberShipSerial + '\'' +
                ", memberShipAmount='" + memberShipAmount + '\'' +
                ", memberShipName='" + memberShipName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MembershipCard that = (MembershipCard) o;
        return Objects.equals(memberShipSerial, that.memberShipSerial) && Objects.equals(memberShipAmount, that.memberShipAmount) && Objects.equals(memberShipName, that.memberShipName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberShipSerial, memberShipAmount, memberShipName);
    }
}
