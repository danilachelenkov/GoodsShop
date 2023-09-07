package ru.netology;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Storehouse implements Shopper {
    public Set<QuantityGoods> storehouseSet;
    public static boolean isEmpty;

    public Storehouse(boolean fillDefaultGoods) {
        if (storehouseSet == null) {
            storehouseSet = new HashSet<>();
        }
        if (fillDefaultGoods)
            fillToDefaultGoods();
    }

    public Set<QuantityGoods> getStorehouse() {
        if (storehouseSet == null || storehouseSet.size() == 0) {
            throw new IllegalStateException("Cклад товаров пустой.");
        }
        return storehouseSet;
    }

    //SOLID_1 (Single Responsibility principle)
    //создан отдельный класс для хранения продуктов - СКЛАД
    // методы заполнения товарами магазина определены в классе описывающем склад.
    @Override
    public boolean put(Goods goods) {
        return doTransit(goods, true); //DRY
    }

    @Override
    public boolean returnGoods(Goods goods) {
        return doTransit(goods, false);//DRY
    }

    public boolean fillSets(Set<QuantityGoods> quantityGoodsList) {
        return this.storehouseSet.addAll(quantityGoodsList);
    }

    private boolean doTransit(Goods goods, boolean direct) {

        Optional<QuantityGoods> optQGoods = storehouseSet.stream().filter(x -> x.getGoods().equals(goods)).findFirst();
        if (optQGoods.isPresent()) {
            if (direct) {
                optQGoods.get().setCount(optQGoods.get().getCount() + 1);
            } else {
                optQGoods.get().setCount(optQGoods.get().getCount() - 1);
                if (optQGoods.get().getCount() == 0) {
                    isEmpty = true;
                }
            }
        } else {
            if (!direct) {
                throw new IllegalStateException("Товара нет на складе, вернуть нечего.");
            }
            storehouseSet.add(new QuantityGoods(goods, 1));
        }

        return true;
    }

    private void fillToDefaultGoods() {
        storehouseSet.add(new QuantityGoods(new Goods("Пирожки", 1.25, "Баба Нюра", Goods.GoodsType.BAKERY), 15));
        storehouseSet.add(new QuantityGoods(new Goods("Пирожки", 1.25, "Баба Нюра", Goods.GoodsType.BAKERY), 16));
        storehouseSet.add(new QuantityGoods(new Goods("Кефир", 6.18, "Простоквашино", Goods.GoodsType.DAIRY), 56));
        storehouseSet.add(new QuantityGoods(new Goods("Батон", 2.19, "Коломенский", Goods.GoodsType.BAKERY), 179));
        storehouseSet.add(new QuantityGoods(new Goods("Сыр", 7.59, "Брест-Литовский", Goods.GoodsType.DAIRY), 73));
        storehouseSet.add(new QuantityGoods(new Goods("Квас", 0.59, "Лидский", null), 200));
    }
}
