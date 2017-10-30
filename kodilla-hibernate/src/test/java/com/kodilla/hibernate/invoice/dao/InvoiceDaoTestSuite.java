package com.kodilla.hibernate.invoice.dao;


/*
Exercise 13.3
adanie: Nagłówki faktur oraz ich pozycje
Celem zadania jest stworzenie encji reprezentującej nagłówki faktur, a także pozycje faktury. Pozycje będą posiadały
również relację do listy towarów. Aby zrealizować zadanie:

W katalogu src/main/java utwórz pakiet com.kodilla.hibernate.invoice
W utworzonym pakiecie stwórz klasę reprezentującą pozycję asortymentu sklepu o nazwie Product (powinna zawierać
pola: int id, String name), a następnie zrób z niej encję i dopisz kontroler repozytorium (w podpakiecie dao)
W utworzonym pakiecie stwórz klasę reprezentującą pozycję faktury o nazwie Item (powinna zawierać pola: int id,
Product product, BigDecimal price, int quantity, BigDecimal value). Zrób z niej encję (zauważ, że występuje tu
relacja N:1 z encją Product). Napisz kontroler repozytorium (w podpakiecie dao)
W utworzonym pakiecie stwórz klasę reprezentującą nagłówek faktury o nazwie Invoice (powinna zawierać pola: int id,
String number, List<Item> items). Utwórz z niej encję - zauważ, że występuje tu relacja 1:N z encją Item.
Napisz kontroler repozytorium (w podpakiecie dao)
W katalogu src/test/java utwórz pakiet com.kodilla.hibernate.invoice.dao
W utworzonym pakiecie stwórz zestaw testów InvoiceDaoTestSuite
Napisz test o nazwie testInvoiceDaoSave(), który sprawdza czy faktura z kilkoma pozycjami zapisuje się poprawnie w bazie danych
Pamiętaj, że test musi być idempotentny (musi zostawiać bazę danych w stanie takim, w jakim ją zastał - bez nowych wpisów)
 */

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    InvoiceDao invoiceDao;

    @Autowired
    ProductDao productDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product("Scissors");
        Product product2 = new Product("Pencil");
        Product product3 = new Product("Ruler");

        Item item1 = new Item(new BigDecimal(10.2), 2);
        Item item2 = new Item(new BigDecimal(8.1), 3);
        Item item3 = new Item(new BigDecimal(2), 3);
        Item item4 = new Item(new BigDecimal(5), 1);

        Invoice invoice = new Invoice("One");

        //3 new lines
        productDao.save(product1);
        productDao.save(product2);
        productDao.save(product3);

        //Set PRODUCT_ID in ITEM table
        item1.setProductList(product1);
        item2.setProductList(product2);
        item3.setProductList(product3);
        item4.setProductList(product1);

        //Set INVOICE_ID in ITEM table
        item1.setInvoiceList(invoice);
        item2.setInvoiceList(invoice);
        item3.setInvoiceList(invoice);
        item4.setInvoiceList(invoice);

        //Create items in ITEM table
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);
        invoice.getItems().add(item4);

        //4 new lines
        product1.getItems().add(item1);
        product1.getItems().add(item4);
        product2.getItems().add(item2);
        product3.getItems().add(item3);

        //When
        invoiceDao.save(invoice);
        int id = invoice.getId();
        int id_p1 = product1.getId();
        int id_p2 = product2.getId();
        int id_p3 = product3.getId();

        //Then
        Assert.assertEquals(4, invoice.getItems().size());

        //CleanUp
        invoiceDao.delete(id);
        productDao.delete(id_p1);
        productDao.delete(id_p2);
        productDao.delete(id_p3);

    }
}
