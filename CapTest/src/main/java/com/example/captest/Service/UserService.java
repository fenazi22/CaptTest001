package com.example.captest.Service;

import com.example.captest.Model.User;
import com.example.captest.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private  final UserRepository userRepository;

//ArrayList<User>users=new ArrayList<>();

public List<User> getUsers(){
    return userRepository.findAll();
}



    public char addUsers(User user) {

    //        for (int i = 0; i <users.size() ; i++) {
//            if (users.get(i).getId().equals(user.getId())|| users.get(i).getUsername().equals(user.getUsername()) || users.get(i).getEmail().equals(user.getEmail()))
//                return 'k';
//        }

         if (user.getRole() == null || user.getEmail() == null || user.getPassword() == null || user.getUsername() == null || user.getBalance() == 0) {
            return 'b';
        }else  {
            userRepository.save(user);
            return 'a';
        }



    }


    public char updateUser(Integer id ,User user){
        User user1=userRepository.getReferenceById(id);
        if (user1==null){
            return 'b';
        }
        user1.setBalance(user.getBalance());
        user1.setRole(user.getRole());
        user1.setId(user.getId());
        user1.setEmail(user.getEmail());
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
            userRepository.save(user1);
            return 'a';

//        for (int i = 0; i <users.size() ; i++) {
//            if (users.get(i).getId().equals(id)){
//                users.set(i,user);
//                return 'a';
//            }else{
//                return 'b';
//            }
//        }
//return 'c';

}



public char deleteUser(Integer id){
    User user=userRepository.getById(id);
    if (user==null){
        return 'b';
    }else {
        userRepository.delete(user);
        return 'a';
    }

//    for (int i = 0; i <users.size() ; i++) {
//        if (users.get(i).getId().equals(id)){
//            users.remove(i);
//            return 'a';
//        }else {
//            return 'b';
//        }
//    }
//return 'c';
}


}
