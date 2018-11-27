package Dominio.Entidades;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "subtipo_servico")
public class SubtipoServico {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "nome", length = 50)
    private String nome;

    @Column(name = "fk_tipo_servico")
    private int fkTipoServico;

    @ManyToMany(mappedBy = "subtiposServico")
    private Collection<Servico> servicos = new ArrayList<Servico>();

    public SubtipoServico() {}

    public SubtipoServico(String nome, int fkTipoServico) {
        setId(id);
        setNome(nome);
        setFkTipoServico(fkTipoServico);
    }

    public SubtipoServico(int id, String nome, int fkTipoServico) {
        setId(id);
        setNome(nome);
        setFkTipoServico(fkTipoServico);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getFkTipoServico() {
        return fkTipoServico;
    }

    public void setFkTipoServico(int fkTipoServico) {
        this.fkTipoServico = fkTipoServico;
    }

//    public SubtipoServico(int fkServico, int fkSubtipoServico) {
//        this.setFkServico(fkServico);
//        this.setFkSubtipoServico(fkSubtipoServico);
//    }
//
//    public SubtipoServico(int id, int fkServico, int fkSubtipoServico) {
//        this.setId(id);
//        this.setFkServico(fkServico);
//        this.setFkSubtipoServico(fkSubtipoServico);
//    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
