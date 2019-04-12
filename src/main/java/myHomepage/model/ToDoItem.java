package myHomepage.model;

import java.awt.*;

public abstract class ToDoItem {
    boolean check;
    String name;

    public void setCheck(boolean check) {
        this.check = check;
    }

    public String getName() {
        return name;
    }
}
