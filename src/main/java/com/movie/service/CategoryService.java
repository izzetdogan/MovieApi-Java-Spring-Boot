package com.movie.service;

import com.movie.dto.CategoryDto;
import com.movie.model.Category;
import com.movie.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    //Create Category
    public CategoryDto createCategory(CategoryDto categoryDto){
        Category category = this.toCategory(categoryDto);
        Category savedOne = this.categoryRepository.save(category);
        return this.toCategoryDto(savedOne);
    }


    //Update  Category By ID
    public CategoryDto updateCategory(Integer id, CategoryDto categoryDto){
        Category category = this.categoryRepository.findById(id).orElseThrow(()-> new RuntimeException( id+"id not found"));
        category.setCategoryTitle(categoryDto.getCategoryTitle());

        Category savedOne = this.categoryRepository.save(category);
        return this.toCategoryDto(savedOne);

    }


    // Get Al Categories
    public List<CategoryDto> getAllCategory(){
        List<Category> categories = this.categoryRepository.findAll();

        List<CategoryDto> categoryDtos = categories.stream()
                .map((cat) -> toCategoryDto(cat)).collect(Collectors.toList());

        return categoryDtos;
    }


    //Get Category By ID
    public CategoryDto getCategoryById(Integer id) {
        Category category= this.categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("bulunamado"));
        return toCategoryDto(category);
    }

    //DElete Category By ID

    public void deleteCategory(Integer id){
        Category category = this.categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("ther is no id" +id));
        this.categoryRepository.delete(category);
    }



    private Category toCategory(CategoryDto categoryDto){
        Category category = new Category();
        category.setCategoryId(categoryDto.getCategoryId());
        category.setCategoryTitle(categoryDto.getCategoryTitle());

        return category;
    }

    private CategoryDto toCategoryDto(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryTitle(category.getCategoryTitle());
        categoryDto.setCategoryId(category.getCategoryId());

        return categoryDto;

    }


}
