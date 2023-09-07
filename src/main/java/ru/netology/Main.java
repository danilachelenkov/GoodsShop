package ru.netology;

public class Main {
    public static void main(String[] args) {
        Printable onConsole = new OnConsole();
        Storehouse storehouse = new Storehouse(true);

        storehouse.put(new Goods("Пирожки", 1.25, "Баба Нюра", Goods.GoodsType.BAKERY));

        Store store = new Store(storehouse);

        store.showAllOfGoods(onConsole);

        onConsole.show("\nПоиск по названию товара");
        store.SearchInStore("Пирожки", GoodsSearch.AttributeSearchType.NAME).stream().forEach(System.out::println);
        store.SearchInStore("Кефир", GoodsSearch.AttributeSearchType.NAME).stream().forEach(System.out::println);

        onConsole.show("\nПоиск по цене товара. Ищем все что больше равно");
        store.SearchInStore(1.5, GoodsSearch.AttributeSearchType.PRICE).stream().forEach(System.out::println);

    }
}