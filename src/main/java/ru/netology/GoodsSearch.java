package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class GoodsSearch {
    private Storehouse storehouse;
    public GoodsSearch(Storehouse storehouse) {
        this.storehouse = (Storehouse) storehouse;
    }

    public List<QuantityGoods> Search(Object searchValue, AttributeSearchType typeSerach) {
        List<QuantityGoods> list;

        switch (typeSerach) {
            case NAME -> list = this.storehouse.storehouseSet.stream().filter(
                    x -> x.getGoods().name.contains((String) searchValue)).toList();
            case MANUFACTURE -> list = this.storehouse.storehouseSet.stream().filter(
                    x -> x.getGoods().manufacturer.contains((String) searchValue)).toList();
           /* case PRICE -> list = this.storehouse.storehouseSet.stream().filter(
                    x -> (x.getGoods().price - (Double) searchValue) >= 0.01).toList();*/
            case PRICE -> list = this.storehouse.storehouseSet.stream().filter(
                    x -> (x.getGoods().price >= (Double) searchValue)).toList();
            default -> list = new ArrayList<>();
        }
        ;

        return list;
    }

    public enum AttributeSearchType {
        PRICE,
        NAME,
        MANUFACTURE
    }

}
