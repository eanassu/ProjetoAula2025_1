package br.fmu.projetoaula;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNumero1;
    private EditText editTextNumero2;
    private EditText editTextSoma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editTextNumero1 = findViewById(R.id.editTextNumero1);
        editTextNumero2 = findViewById(R.id.editTextNumero2);
        editTextSoma = findViewById(R.id.editTextSoma);
    }

    public void somar(View view) {
        int x = Integer.parseInt(editTextNumero1.getText().toString());
        int y = Integer.parseInt(editTextNumero2.getText().toString());
        int soma = x + y;
        editTextSoma.setText(Integer.toString(soma));
    }

    public void abrirOutra(View view) {
        int x = Integer.parseInt(editTextNumero1.getText().toString());
        int y = Integer.parseInt(editTextNumero2.getText().toString());
        int soma = x + y;
        Intent intent = new Intent(this, NovaActivity.class);
        intent.putExtra("soma", soma);
        startActivity(intent);
    }

    public void abrirGorjeta(View view) {
        Intent intent = new Intent(this, TipCalculatorActivity.class);
        startActivity(intent);
    }

    public void testeBD(View view) {
        Intent intent = new Intent(this, DatabaseActivity.class);
        startActivity(intent);
    }
}











