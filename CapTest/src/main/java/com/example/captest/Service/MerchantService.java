package com.example.captest.Service;

import com.example.captest.Model.Merchant;
import com.example.captest.Model.MerchantStock;
import com.example.captest.Repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantService {

    private  final MerchantRepository merchantRepository;
    ArrayList<Merchant>merchants=new ArrayList<>();

    public List<Merchant> getMerchant(){
        return merchantRepository.findAll();
    }



    public char addMerchant(Merchant merchant){



//        for (int i = 0; i <merchants.size() ; i++) {
//            if (merchants.get(i).getId().equals(merchant.getId()) || merchants.get(i).getName().equals(merchant.getName()));
//            return 'a';
//        }


     if (merchant.getId()==null || merchant.getName()==null ){
         return 'b';
        }else {
         merchantRepository.save(merchant);
         return 'c';
     }

}




    public char updateMerchant(Integer id , Merchant merchant){
        Merchant merchant1=merchantRepository.getById(id);
        if (merchant1==null){
            return 'b';
        }

            merchant1.setId(merchant.getId());
            merchant1.setName(merchant.getName());
            merchantRepository.save(merchant1);
        return 'a';


//        for (int i = 0; i <merchants.size() ; i++) {
//            if (merchants.get(i).getId().equals(id)){
//                merchants.set(i,merchant);
//                return 'a';
//            }else{
//                return 'b';
//            }
//        }
//        return 'c';

}





    public char deleteMerchant(Integer id){
    Merchant merchant =merchantRepository.getReferenceById(id);
if (merchant==null){
return'b';
}
merchantRepository.delete(merchant);
return 'a';
    }
//        for (int i = 0; i <merchants.size() ; i++) {
//            if (merchants.get(i).getId().equals(id)){
//                merchants.remove(i);
//                return 'a';
//            }else {
//                return 'b';
//            }
//        }
//        return 'c';
//    }




}
