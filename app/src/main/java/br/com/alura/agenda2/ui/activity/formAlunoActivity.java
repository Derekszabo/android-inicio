package br.com.alura.agenda2.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import br.com.alura.agenda2.R;
import br.com.alura.agenda2.dao.AlunoDAO;
import br.com.alura.agenda2.model.Aluno;

import static br.com.alura.agenda2.ui.activity.ConstantesActivities.CHAVE_ALUNO;


public class formAlunoActivity extends AppCompatActivity {

    private static final String TITULO_APPBAR_NOVO_ALUNO = "Novo aluno";
    private static final String TITULO_APPBAR_EDITA_ALUNO = "Edita aluno";
    private EditText campoNome;
    private EditText campoTel;
    private EditText campoEmail;
    final AlunoDAO dao = new AlunoDAO();
    private Aluno aluno;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_aluno);
        inicializacaoDosCampos();
        carregaAluno();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_form_aluno_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.activity_form_aluno_menu_salvar) {
            finalizaForm();
        }
        return super.onOptionsItemSelected(item);
    }

    private void carregaAluno() {
        Intent dados = getIntent();
        if (dados.hasExtra(CHAVE_ALUNO)) {
            aluno = (Aluno) dados.getSerializableExtra(CHAVE_ALUNO);
            preencheCampos();
            setTitle(TITULO_APPBAR_EDITA_ALUNO);
        } else {
            aluno = new Aluno();
            setTitle(TITULO_APPBAR_NOVO_ALUNO);
        }
    }

    private void preencheCampos() {
        campoNome.setText(aluno.getNome());
        campoTel.setText(aluno.getTel());
        campoEmail.setText(aluno.getEmail());
    }


    private void finalizaForm() {
        preencheAluno();
        if (aluno.temIdValido()) {
            dao.edita(aluno);
        } else {
            dao.salva(aluno);
        }
        finish();
    }

    private void inicializacaoDosCampos() {
        campoNome = findViewById(R.id.activity_form_aluno_nome);
        campoTel = findViewById(R.id.activity_form_aluno_tel);
        campoEmail = findViewById(R.id.activity_form_aluno_email);
    }

    private void salva(Aluno aluno) {
        dao.salva(aluno);
        finish();
    }

    private void preencheAluno() {
        String nome = campoNome.getText().toString();
        String tel = campoTel.getText().toString();
        String email = campoEmail.getText().toString();

        aluno.setNome(nome);
        aluno.setTel(tel);
        aluno.setEmail(email);
    }

}
