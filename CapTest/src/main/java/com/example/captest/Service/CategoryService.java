package com.example.captest.Service;

import com.example.captest.Model.Category;
import com.example.captest.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class CategoryService {

    private final CategoryRepository categoryRepository;
  //  ArrayList<Category>categories=new ArrayList<>();
    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }


    public char addCategory(Category category){

        if (category.getName()==null ||category.getId()==null){
            return 'b';
        }else {
            categoryRepository.save(category);
            return 's';
        }

    }

    public  char updateCategory(Integer id ,Category category){
        Category oldCategory=categoryRepository.getById(id);
            if (oldCategory==null){
                return 'b';
            }
        oldCategory.setId(category.getId());
            oldCategory.setName(category.getName());
        categoryRepository.save(category);
        return 'a';
//        for (int i = 0; i <categories.size() ; i++) {
//            if (categories.get(i).getId().equals(id)){
//                categories.set(i,category);
//                return 'a';
//            }
//            return 'b';
//        }
//        return 'c';

    }



    public  char deleteCategory(Integer id){
    Category category1=categoryRepository.getReferenceById(id);
if (category1==null){
    return 'b';
}
categoryRepository.delete(category1);
return 'a';

//        for (int i = 0; i <categories.size() ; i++) {
//            if (categories.get(i).getId().equals(id)){
//                categories.remove(i);
//                return 'a';
//            }
//            return 'b';
//        }
//        return 'c';

    }

}
