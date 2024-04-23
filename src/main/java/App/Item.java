package App;

public class Item {
    private String _jogo;
    private String _categoria;
    private double _avaliacao;

    public Item(String jogo, String categoria, double avaliacao){
        this._jogo = jogo;
        this._avaliacao = avaliacao;
        this._categoria = categoria;
    }

    public String getJogo() {
        return _jogo;
    }

    public void setJogo(String _jogo) {
        this._jogo = _jogo;
    }

    public String getCategoria() {
        return _categoria;
    }

    public void setCategoria(String _categoria) {
        this._categoria = _categoria;
    }

    public double getAvaliacao() {
        return _avaliacao;
    }

    public void getAvaliacao(double _avalidacao) {
        this._avaliacao = _avalidacao;
    }

    @Override
    public String toString(){
        return this._jogo + "," + this._categoria + "," + this._avaliacao;
    }
}
