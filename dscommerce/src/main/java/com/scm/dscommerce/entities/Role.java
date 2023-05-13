package com.scm.dscommerce.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

// Relacionamento muitos para muitos
@Entity // para que minha entiti possa ser mapeada em uma tabela no Banco de Dados H2
@Table(name = "tb_ROLE") // para personalizar o nome da tabelo no Banco de Dados H2
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto implementação no Banco de Dados relacional
    private Long id;
    private String autority;
}
    public Category(Long id, String  autority) {
        this.id = id;
        this.nome =  autority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return  autority;
    }

    public void setNome(String nome) {
        this.nome =  autority;
    }


}
