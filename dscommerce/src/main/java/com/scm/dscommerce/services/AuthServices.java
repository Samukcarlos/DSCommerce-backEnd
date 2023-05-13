package com.scm.dscommerce.services;
@Service
public class AuthService{

    @Autowired
    private  UserService{
    }
}

    public void validateSelforAdmin(long userId){
        User me = userService.authenticated();
        if(!me.hasRole("ROLE_ADIMIN")&& !me.getId().equals(userId)){
            throw, new ForbiddenExeption("Acces denied");
    }

}