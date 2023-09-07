package ru.netology;

import java.util.Iterator;
import java.util.List;

public class Store {
    protected Storehouse storehouse;

    public Store(Storehouse storehouse) {
        if (storehouse == null) {
            this.storehouse = new Storehouse(true);
        } else {
            this.storehouse = storehouse;
        }
    }

    public void showAllOfGoods(Printable viewer) {
        for (QuantityGoods item : storehouse.getStorehouse()) {
            viewer.show(item.toString());
        }
    }

    public List<QuantityGoods> SearchInStore(Object obj, GoodsSearch.AttributeSearchType searchType) {
        return new GoodsSearch(storehouse).Search(obj, searchType);
    }

    public boolean buyGoods(Goods goods) {
        return true;

    }

    //SOLID_3 Liskov substitution principle
    //Метод для поверки состояния склада, если состояние false, то необходимо запускать формирование отчета
    //который сформирует позиции которые закончились на складе и магазин должен их заказать
    //В классе Cart данный метод играет роль формирования общего чека покупки
    public boolean check() {
       if(Storehouse.isEmpty){
           return false;
       }
       return true;
    }

    public boolean returnGoods(Goods goods) {
        return true;
    }
}
