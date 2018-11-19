package project.envoss.com.calculatorbalok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import project.envoss.com.calculatorbalok.models.Book;

public class BookActivity extends AppCompatActivity implements View.OnClickListener {
    private List<Book> bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        TextView book1, book2, book3, book4, book5;

        book1 = findViewById(R.id.book_1);
        book2 = findViewById(R.id.book_2);
        book3 = findViewById(R.id.book_3);
        book4 = findViewById(R.id.book_4);
        book5 = findViewById(R.id.book_5);

        book1.setOnClickListener(this);
        book2.setOnClickListener(this);
        book3.setOnClickListener(this);
        book4.setOnClickListener(this);
        book5.setOnClickListener(this);

        prepareData();
        book1.setText(bookList.get(0).getTitle());
        book2.setText(bookList.get(1).getTitle());
        book3.setText(bookList.get(2).getTitle());
        book4.setText(bookList.get(3).getTitle());
        book5.setText(bookList.get(4).getTitle());
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, DetailActivity.class);

        switch (view.getId()){
            case R.id.book_1:{
                intent.putExtra("extra", bookList.get(0));
                break;
            }

            case R.id.book_2:{
                intent.putExtra("extra", bookList.get(1));
                break;
            }

            case R.id.book_3:{
                intent.putExtra("extra", bookList.get(2));
                break;
            }

            case R.id.book_4:{
                intent.putExtra("extra", bookList.get(3));
                break;
            }

            case R.id.book_5:{
                intent.putExtra("extra", bookList.get(4));
                break;
            }
        }

        startActivity(intent);
    }

    private void prepareData(){
        bookList = new ArrayList<>();

        bookList.add(new Book(
                "Seribu Satu Cahaya Bintang Di Langit",
                "Abu Zubair",
                "Pena Grafika",
                2018
        ));

        bookList.add(new Book(
                "Setetes Air Di Luasnya Samudra Dunia",
                "Thalhah bin Ubaidillah",
                "Ilmu Grafika",
                2018
        ));

        bookList.add(new Book(
                "Diantara Dedaunan Yang Jatuh Di Luasnya Hutan",
                "Abu Abdillah",
                "Pustaka Abu Zubair",
                2018
        ));

        bookList.add(new Book(
                "Diantara Tetesan Hujan Yang Jatuh Membasahi Bumi",
                "Abu Umar",
                "Zubair Grafika",
                2019
        ));

        bookList.add(new Book(
                "Tumpukan Buku Yang Sudah Dilupakan Untuk Dibaca",
                "Abdullah bin Thalhah",
                "Pena Grafika",
                2017
        ));
    }
}
