package com.scm.dscommerce.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity // para que minha entiti possa ser mapeada em uma tabela no Banco de Dados H2
@Table(name = "tb_user") // para personalizar o nome da tabelo no Banco de Dados H2
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto implementação no Banco de Dados relacional
    private Long id;
    private String nome;
    @Column(unique = true) // Fazendo com que email também não seja repitido no DB.
    private String email;
    private String phone;
    private LocalDate birthDate;
    private String password;
    @OneToMany(mappedBy = "client") // mapeamento muitos para um. inclui na tabela Order um campo na chave estrangeira
    private List<Order> orders = new ArrayList<>(); // lado do "um para muintos" como são muitos precisa de uma lista.
    // na classe User tenho uma lista de orders.
    public User(){

    }

    public User(Long id, String nome, String email, String phone, LocalDate birthDate, String password) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() { // Para acessar a lista, NUNCA FAZER ser DE COLEÇÃO, LISTA
        return orders;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", birthDate=" + birthDate +
                ", password='" + password + '\'' +
                '}';
    }
}
