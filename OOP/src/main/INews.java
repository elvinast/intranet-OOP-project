package main;

import java.util.Date;

public interface INews {

	News createNews(Faculties faculty, String title, String text, Date date);
}
