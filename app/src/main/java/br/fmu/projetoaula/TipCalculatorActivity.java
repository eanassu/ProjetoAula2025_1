package br.fmu.projetoaula;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.NumberFormat;

public class TipCalculatorActivity extends AppCompatActivity {

    private EditText editTextValor;
    private TextView textViewValor;
    private TextView textViewPorcentagem;
    private TextView textViewGorjeta;
    private TextView textViewTotal;
    private SeekBar seekBar;
    private double valor;
    private double porcentagem;
    private NumberFormat currencyFormat =
            NumberFormat.getCurrencyInstance();
    private NumberFormat porcentagemFormat =
            NumberFormat.getPercentInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tip_calculator);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editTextValor = findViewById(R.id.editTextValor);
        textViewValor = findViewById(R.id.textViewValor);
        textViewPorcentagem = findViewById(R.id.textViewPorcentagem);
        textViewGorjeta = findViewById(R.id.textViewGorjeta);
        textViewTotal = findViewById(R.id.textViewTotal);
        seekBar = findViewById(R.id.seekBar);
        editTextValor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int valorInt;
                try {
                    valorInt =
                      Integer.parseInt(editTextValor.getText().toString());
                } catch( NumberFormatException e ) {
                    valorInt = 0;
                }
                valor = valorInt/100.0;
                atualizarValores();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = progress/100.0;
                atualizarValores();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    private void atualizarValores() {
        textViewValor.setText(currencyFormat.format(valor));
        double gorjeta = valor * porcentagem;
        double total = valor + gorjeta;
        textViewPorcentagem.setText(porcentagemFormat.format(porcentagem));
        textViewGorjeta.setText(currencyFormat.format(gorjeta));
        textViewTotal.setText(currencyFormat.format(total));
    }
}