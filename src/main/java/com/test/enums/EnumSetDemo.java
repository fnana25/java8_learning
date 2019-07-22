package com.test.enums;

import com.test.enums.enums.FontConstant;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

/**
 * Demo class
 *
 * @author fengna
 * @date 2019/7/22
 */
public class EnumSetDemo {

    public static void main(String[] args) {
        EnumSet<FontConstant> enumSet = EnumSet.of(FontConstant.Blod,FontConstant.Italilc);
        showEnumSet(enumSet);
        System.out.println("---------------");

        showEnumSet(EnumSet.complementOf(enumSet));
        System.out.println("---------------");

        EnumSet<FontConstant> enumSet1 = EnumSet.noneOf(FontConstant.class);
        enumSet1.add(FontConstant.Blod);
        enumSet1.add(FontConstant.Italilc);
        showEnumSet(enumSet1);
        System.out.println("---------------");

        List<FontConstant> enumList = new ArrayList<>(3);
        enumList.add(FontConstant.Blod);
        enumList.add(FontConstant.Italilc);
        enumList.add(FontConstant.Plain);
        showEnumSet(EnumSet.copyOf(enumList));
        System.out.println("---------------");


    }

    private static void showEnumSet(EnumSet<FontConstant> enumSet) {

        for (Iterator<FontConstant> iterator = enumSet.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }
    }
}
