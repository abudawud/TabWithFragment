package project.envoss.com.calculatorbalok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import project.envoss.com.calculatorbalok.models.Book;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView detail = findViewById(R.id.detail);

        Book book = getIntent().getParcelableExtra("extra");

        detail.setText("Judul : " + book.getTitle() +
                        "\nPenulis : " + book.getAuthor() +
                        "\nPenerbit : " + book.getPenerbit() +
                        "\nTahun Terbit : " + book.getTahun());
    }
}
