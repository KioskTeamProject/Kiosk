package model.User;
import java.util.List;
import java.util.Objects;
public class MenuCategory {
    private String menuName;
    private int menuPrice;
    private String optionMenuName;
    private int optionMenuPrice;

    public MenuCategory(List<MenuCategory> cafeEspressolist) {
    }

    public MenuCategory(String menuName, int menuPrice, String optionMenuName) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.optionMenuName = optionMenuName;
        this.optionMenuPrice = 500;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public int getOptionMenuPrice() {
        return optionMenuPrice;
    }

    public void setOptionMenuPrice(int optionMenuPrice) {
        this.optionMenuPrice = optionMenuPrice;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getOptionMenuName() {
        return optionMenuName;
    }

    public void setOptionMenuName(String optionMenuName) {
        this.optionMenuName = optionMenuName;
    }

    @Override
    public String toString() {
        return "MenuCategory{" +
                "menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", optionMenuName='" + optionMenuName + '\'' +
                ", optionMenuPrice=" + optionMenuPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuCategory that = (MenuCategory) o;
        return menuPrice == that.menuPrice && optionMenuPrice == that.optionMenuPrice && Objects.equals(menuName, that.menuName) && Objects.equals(optionMenuName, that.optionMenuName);
    }
}
