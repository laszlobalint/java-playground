package com.company.javapractice.Merchandise;

import com.company.javapractice.Merchandise.StoreHouse.BadQuality;

public interface Merchandise {

    boolean stillGood() throws BadQuality;
}
