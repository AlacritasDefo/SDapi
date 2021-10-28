package controller;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MenuItem {
    private String lable;
    private Runnable action;

}
