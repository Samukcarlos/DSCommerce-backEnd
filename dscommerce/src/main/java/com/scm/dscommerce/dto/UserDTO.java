package com.scm.dscommerce.dto;

public class UserDTO {
    private Long id;
    private String nome;
    private String email;
    private String phone;
    private LocalDate birthDate;
    private List<String>roles = new ArrayList<>();

    public UserDTO(Long id, String nome, String email, String phone, LocalDate birthDate) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
    }
    public UserDTO(User entity) {
        id = entity.getID();
        nome = entity.getnome();
        email = entity.getemail();
        phone = entity.getphone();
        birthDate = entity.getbirthDate();
        for (GrantedAuthority role : entity.getAuthorities()){
            roles.add(role.getAuthority());
        }
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}