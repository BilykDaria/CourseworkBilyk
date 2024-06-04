package com.coursework1;

import com.coursework1.DAOs.AuthorsDAO;
import com.coursework1.DAOs.BooksDAO;
import com.coursework1.DAOs.GuestsDAO;
import com.coursework1.Models.Author;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import static com.coursework1.Models.Guest.Role.ADMIN;

@WebListener
public class Listener implements ServletContextListener {

    private BooksDAO booksDataBase;
    private GuestsDAO guestsDataBase;
    private AuthorsDAO authorsDataBase;

    @Override
    public void contextInitialized(ServletContextEvent context) {

        booksDataBase = new BooksDAO();
        authorsDataBase = new AuthorsDAO();
        guestsDataBase = new GuestsDAO();

        guestsDataBase.createUser("dasha", "dasha");
        guestsDataBase.createUser("admin", "111", ADMIN);

        Author author1 = authorsDataBase.addAuthor("Тарас Шевченко", "Тара́с Григо́рович Шевче́нко (25 лютого (9 березня) " +
                "1814, с. Моринці, Київська губернія, Російська імперія (нині Звенигородський район, Черкаська область, Україна)" +
                " — 26 лютого (10 березня) 1861, Санкт-Петербург, Російська імперія) — український поет, прозаїк, мислитель, " +
                "живописець, гравер, етнограф, громадський діяч. Національний герой і символ України. Діяч українського " +
                "національного руху, член Кирило-Мефодіївського братства. Академік Імператорської академії мистецтв (1860).",
                "Україна", 46);

        Author author2 = authorsDataBase.addAuthor("Оноре де Бальзак", "Народився 20 травня 1799 року в Турі," +
                        "Франція, помер 18 серпня 1850 року. Відомий французький письменник, один з найвидатніших представників реалізму.",
                "Франція", 51);

        Author author3 = authorsDataBase.addAuthor("Марк Твен", "Народився 30 листопада 1835 року у Флориді, США, помер" +
                        " 21 квітня 1910 року. Відомий американський письменник, гуморист і сатирик.",
                "США", 74);

        Author author4 = authorsDataBase.addAuthor("Чарльз Діккенс", "Народився 7 лютого 1812 року в Портсмуті," +
                        " помер 9 червня 1870 року. Він був одним з найвизначніших англійських романістів вікторіанської епохи.",
                "Англія", 58);

        Author author5 = authorsDataBase.addAuthor("Джейн Остін", "Народилася 16 грудня 1775 року в Стівентоні," +
                        " Англія, померла 18 липня 1817 року. Вона була однією з найвизначніших англійських письменниць," +
                        " відомих своїми романами про життя англійського дворянства.",
                "Англія", 41);

        Author author6 = authorsDataBase.addAuthor("Джордж Еліот", "Справжнє ім'я - Мері Енн Еванс. Народилася" +
                        " 22 листопада 1819 року в Нейнітчі, Англія, померла 22 грудня 1880 року. Вона була англійською письменницею," +
                        " відомою своїми реалістичними романами про сільське життя.",
                "Англія", 61);

        Author author7 = authorsDataBase.addAuthor("Гюстав Флобер", "Народився 12 грудня 1821 року в Руані, Франція," +
                        "помер 8 травня 1880 року. Відомий французький письменник, один з основоположників літературного реалізму.",
                "Франція", 58);

        booksDataBase.addBook("Кобзар", author1, "«Кобза́р» — назва першої книги-збірки поетичних творів Тараса " +
                "Шевченка 1840 року. У наш час під назвою «Кобзар» видають повне зібрання українських поезій Шевченка з додатком " +
                "двох російських поем «Тризна (Безталанний)» та «Сліпа»." );
        booksDataBase.addBook("Гайдамаки", author1, "Історична поема про повстання гайдамаків проти польського " +
                "панування у XVIII столітті, яка підкреслює прагнення українців до свободи." );
        booksDataBase.addBook("Батько Горіо", author2, "Роман про старого чоловіка, який жертвує всім заради своїх невдячних дочок." );
        booksDataBase.addBook("Виховання почуттів", author7, "Роман про юнака Фредеріка Моро, який переживає складні любовні і політичні перипетії у Франції XIX століття." );
        booksDataBase.addBook("Олівер Твіст", author4, "Роман про сироту Олівера Твіста, який зіштовхується з жорстокістю і несправедливістю Лондона, але зрештою знаходить своє місце в житті." );
        booksDataBase.addBook("Великі сподівання", author4, "Розповідь про юного Піпа, який отримує можливість піднятися вгору по соціальній драбині завдяки таємничому благодійнику." );
        booksDataBase.addBook("Девід Копперфільд", author4, "Автобіографічний роман про життя юнака Девіда Копперфільда, який переживає багато труднощів і пригод, перш ніж знайти своє місце в житті." );
        booksDataBase.addBook("Міддлмарч", author6, "Роман про життя і моральні дилеми жителів вигаданого англійського містечка Міддлмарч." );
        booksDataBase.addBook("Сайлас Марнер", author6, "Роман про вигнанця Сайласа Марнера, який знаходить нове життя і щастя, усиновивши маленьку дівчинку." );
        booksDataBase.addBook("Адам Бід", author6, "Роман про кохання і соціальні конфлікти в англійському селі." );
        booksDataBase.addBook("Пригоди Тома Сойєра", author3, "Роман про пригоди хлопчика Тома Сойєра на берегах річки Міссісіпі." );
        booksDataBase.addBook("Гордість і упередження", author5, "Роман про Елізабет Беннет і її стосунки з містером Дарсі, що включає соціальні і моральні теми." );
        booksDataBase.addBook("Янкі з Коннектикуту при дворі короля Артура", author3, "Сучасний американець потрапляє в середньовічну Англію і намагається використати свої знання для покращення життя." );

        context.getServletContext().setAttribute("guestsDataBase", guestsDataBase);
        context.getServletContext().setAttribute("booksDataBase", booksDataBase);
        context.getServletContext().setAttribute("authorsDataBase", authorsDataBase);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        guestsDataBase = null;
        authorsDataBase = null;
        booksDataBase = null;
    }
}