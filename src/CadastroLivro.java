import java.time.LocalDate;
import java.util.List;

public class CadastroLivro extends CadastroAutor{
    public String titulo;
    public CadastroAutor autor;
    public float preco;
    public LocalDate dataLancamento;

    public int VerificarTempoLanc(int idadeLivro) {
        return idadeLivro;
    };
}
