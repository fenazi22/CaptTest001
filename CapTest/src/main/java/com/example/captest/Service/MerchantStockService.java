package com.example.captest.Service;

import com.example.captest.Model.Merchant;
import com.example.captest.Model.MerchantStock;
import com.example.captest.Model.MerchantStock;
import com.example.captest.Repository.MerchantStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantStockService {
    
    ArrayList<MerchantStock>merchantStocks=new ArrayList<>();

     private final MerchantStockRepository merchantStockRepository;


    public List<MerchantStock> getmerchantStock(){
        return merchantStockRepository.findAll();
    }



    public char addmerchantStock(MerchantStock merchantStock){

//        for (int i = 0; i <merchantStocks.size() ; i++) {
//            if (merchantStocks.get(i).getId().equals(merchantStock.getId()) || merchantStocks.get(i).getProductid().equals(merchantStock.getProductid()) || merchantStocks.get(i).getMerchantid().equals(merchantStock.getMerchantid()));
//            return 'a';
//        }
        if (merchantStock.getId()==null || merchantStock.getStock()==0 || merchantStock.getProductid()==null || merchantStock.getMerchantid()==null){
            return 'b';
        }else {
            merchantStockRepository.save(merchantStock);
            return 'c';

        }
    }




    public char updatemerchantStock(Integer id , MerchantStock merchantStock){
        MerchantStock merchantStock1=merchantStockRepository.getReferenceById(id);
            if (merchantStock1==null){
                return 'b';
            }

            merchantStock1.setId(merchantStock.getId());
            merchantStock1.setProductid(merchantStock.getProductid());
            merchantStock1.setMerchantid(merchantStock.getMerchantid());
            merchantStock1.setStock(merchantStock.getStock());
            merchantStockRepository.save(merchantStock1);
            return 'a';

//        for (int i = 0; i <merchantStocks.size() ; i++) {
//            if (merchantStocks.get(i).getId().equals(id)){
//                merchantStocks.set(i,merchantStock);
//                return 'a';
//            }else{
//                return 'b';
//            }
//        }
//        return 'c';
    }






    public char deletemerchantStock(Integer id){

        MerchantStock merchantStock=merchantStockRepository.getById(id);
        if (merchantStock==null){
            return 'b';
        }else{
        merchantStockRepository.delete(merchantStock);
        return 'a';
        }

        //        for (int i = 0; i <merchantStocks.size() ; i++) {
//            if (merchantStocks.get(i).getId().equals(id)){
//                merchantStocks.remove(i);
//                return 'a';
//            }else {
//                return 'b';
//            }
//        }
//        return 'c';

    }
    









}
