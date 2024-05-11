package io.aws.spring.mysql;


import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController



@RequestMapping(path = "/demo")
public class MainController {

    @Autowired
    private userRepository UserRepository;

    @PostMapping(path = "/add")
    public @ResponseBody user addNewUser(@RequestParam String name,@RequestParam String email)
    {
        user springUser=new user();
        springUser.setEmail(email);
        springUser.setName(name);
        UserRepository.save(springUser);
        return springUser;
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<user> getAllUsers()
    {
        return UserRepository.findAll();
    }



}
