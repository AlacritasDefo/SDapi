package controller;

import java.util.List;

public class Menu {
    private List<MenuItem> items;

    public void print(){
        for (int i = 0; i <items.size(); i++){
            System.out.println((i+1) + ". " + items.get(i).getLable());
        }
    }
    public Menu(List<MenuItem> items){
        this.items = items;
    }

    public boolean execute(int option) {
        option = option -1 ;
        if (option >= 0 && option < items.size()) {
            MenuItem menuItem = items.get(option);
            menuItem.getAction().run();
            return true;
        } else {
            return false;
        }
    }
}
