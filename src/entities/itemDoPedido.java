package entities;

public class itemDoPedido {

    private Integer quantidade;
    private Double preco;

    private Produto produto;

    public itemDoPedido(Integer quantidade, Double preco, Produto protduto) {
        this.quantidade = quantidade;
        this.preco = preco;
        this.produto = protduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Produto getProtduto() {
        return produto;
    }

    public void setProtduto(Produto protduto) {
        this.produto = protduto;
    }

    public double subTotal() {
        return preco * quantidade;
    }

    public String toString() {
        return produto.getNome()
                + ", R$"
                + String.format("%.2f", preco)
                + ", Quantidade: "
                + quantidade
                + ", Subtotal: $"
                + String.format("%.2f", subTotal());
    }

}
