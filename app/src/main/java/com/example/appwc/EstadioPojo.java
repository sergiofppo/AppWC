package com.example.appwc; // Lembre-se de verificar se o nome do pacote está correto

public class EstadioPojo {

    // Atributos baseados nas colunas da tabela
    private int id;
    private int codigoEstadioEnum;
    private String nome;
    private String local;
    private String descricao;
    private String dataFundacao;
    private Integer capacidade;
    private String imagem;
    private String linkMaps;

    // Construtor vazio padronizado
    public EstadioPojo() {
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getCodigoEstadioEnum() { return codigoEstadioEnum; }
    public void setCodigoEstadioEnum(int codigoEstadioEnum) { this.codigoEstadioEnum = codigoEstadioEnum; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getLocal() { return local; }
    public void setLocal(String local) { this.local = local; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getDataFundacao() { return dataFundacao; }
    public void setDataFundacao(String dataFundacao) { this.dataFundacao = dataFundacao; }

    public Integer getCapacidade() { return capacidade; }
    public void setCapacidade(Integer capacidade) { this.capacidade = capacidade; }

    public String getImagem() { return imagem; }
    public void setImagem(String imagem) { this.imagem = imagem; }

    public String getLinkMaps() { return linkMaps; }
    public void setLinkMaps(String linkMaps) { this.linkMaps = linkMaps; }
}