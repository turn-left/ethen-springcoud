package com.ethen.app.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MagicBean {

    public MagicBean() {
        System.err.println("**************************************************************"
                + "\nMagicBean has been created. metadata~~~~~~~~" +
                "\n**************************************************************");
    }

    public int length;
    public int height;
}
