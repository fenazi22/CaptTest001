package com.example.captest.Controller;

import com.example.captest.Model.Merchant;
import com.example.captest.Model.MerchantStock;
import com.example.captest.Service.MerchantService;
import com.example.captest.Service.MerchantStockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/capt/merchstock")
@RequiredArgsConstructor
public class MerchantStockController {

private  final MerchantStockService merchantStockService;

@GetMapping("/get")
    public ResponseEntity getmerchantStock(){
    return  ResponseEntity.status(HttpStatus.OK).body(merchantStockService.getmerchantStock());
}


@PostMapping("/add")
    public ResponseEntity addmerchantStock(@Valid @RequestBody MerchantStock merchantStock, Errors errors){
    if (errors.hasErrors()){
        String message=errors.getFieldError().getDefaultMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }
    char isAdd=merchantStockService.addmerchantStock(merchantStock);
//    if (isAdd=='a'){
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("your input ID or name before");
//
//    }
    if (isAdd=='b'){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Must be id or name not null");

    }
    if (isAdd=='c'){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Successfully added :| ");

    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sorry NOT_FOUND ");


}




    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchant(@PathVariable Integer id, @Valid @RequestBody MerchantStock merchantStock, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        char isUpdated= merchantStockService.updatemerchantStock(id, merchantStock);

        if (isUpdated=='a'){
            return ResponseEntity.status(HttpStatus.OK).body("updated successfully ");

        }
        if (isUpdated=='b'){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("cannot found this ID ");

        }
//        if (isUpdated=='c'){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sorry NOT_FOUND ");
//
//        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sorry NOT_FOUND ");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchant(@PathVariable Integer id){


        char isUpdate= merchantStockService.deletemerchantStock(id);
        if (isUpdate=='a'){
            return ResponseEntity.status(HttpStatus.OK).body("Successfully Deleted :|");
        }
        if (isUpdate=='b'){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Sorry Not found ID");
        }
//        if (isUpdate=='c'){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Sorry Not found ID");
//        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sorry Not Found");
    }


}
