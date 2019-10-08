package br.com.alura.agenda2;

import android.app.Application;

import br.com.alura.agenda2.dao.AlunoDAO;
import br.com.alura.agenda2.model.Aluno;

@SuppressWarnings("WeakerAccess")
public class AgendaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunosDeTeste();
    }

    private void criaAlunosDeTeste() {
        AlunoDAO dao = new AlunoDAO();
        dao.salva(new Aluno("Derek", "333444555", "pijasdas@sdoe.com"));
        dao.salva(new Aluno("Nathalia", "33333333", "das@sdoe.com"));
    }
}
