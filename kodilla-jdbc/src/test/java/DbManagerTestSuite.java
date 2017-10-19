import org.junit.Assert;
import org.junit.Test;

/*
Exercise 12.6
Zadanie: aktywni użytkownicy

Stwórz test wyświetlający użytkowników, którzy posiadają co najmniej dwa posty. Użyj do tego zapytania SQL
korzystającego ze złączenia tabel USERS oraz POSTS, grupującego uzyskane wyniki według użytkowników, a następnie
 odfiltrowującego tylko tych użytkowników, którzy mają co najmniej dwa posty.

Aby zrealizować zadanie:

W zestawie testów DbManagerTestSuite utwórz nowy test o nazwie testSelectUsersAndPosts()
Przygotuj sobie w MySQL Workbenchu zapytanie zwracające imiona i nazwiska użytkowników, którzy opublikowali co najmniej
 dwa posty
W teście testSelectUsersAndPosts() napisz kod tworzący przygotowane w kroku nr 2. zapytanie
Wyświetl w pętli imiona i nazwiska użytkowników, którzy opublikowali co najmniej dwa posty
Na końcu testu stwórz asercję sprawdzającą czy ilość rekordów zwrócona przez zapytanie jest zgodna ze stanem faktycznym
 w bazie danych
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManagerTestSuite {
    @Test
    public void testConnect() throws SQLException {
        //Given
        //When
        DbManager dbManager = DbManager.getInstance();
        //Then
        Assert.assertNotNull(dbManager.getConnection());
    }

    @Test
    public void testSelectUsers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        Assert.assertEquals(5, counter);
    }

    @Test
    public void testSelectUsersAndPosts() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = String.join(" ",
                "SELECT U.ID, U.FIRSTNAME, U.LASTNAME, COUNT(*) AS TASKS"
                , "FROM USERS U, TASKS T"
                , "WHERE U.ID = T.USER_ID_ASSIGNEDTO"
                , "GROUP BY T.USER_ID_ASSIGNEDTO"
                , "HAVING COUNT(TASKS) >= 2"
                , "ORDER BY U.FIRSTNAME, U.LASTNAME");

        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        // I remember, that we don't like println in Test but Exercise demand it...
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        Assert.assertEquals(5, counter);
    }
}
