package com.scm.dscommerce.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

// Relacionamento muitos para muitos
@Entity // para que minha entiti possa ser mapeada em uma tabela no Banco de Dados H2
@Table(name = "tb_role") // para personalizar o nome da tabelo no Banco de Dados H2
public class Role implements GrantedAuthority{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto implementação no Banco de Dados relacional
    private Long id;
    private String authority;
}
    public Category(Long id, String  authority) {
        this.id = id;
        this.nome =  authority;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
@Override
    public String getNome() {
        return  authority;
    }

    public void setNome(String nome) {
        this.nome =  authority;
    }


}
