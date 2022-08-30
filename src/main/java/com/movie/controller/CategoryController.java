package com.movie.controller;


import com.movie.dto.CategoryDto;
import com.movie.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // Create  Category
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory( @Valid  @RequestBody CategoryDto categoryDto){
        return new ResponseEntity<CategoryDto>(this.categoryService.createCategory(categoryDto),HttpStatus.CREATED);
    }

    //Update Category By ID
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable Integer id, @RequestBody CategoryDto categoryDto){
        return new ResponseEntity<CategoryDto>(this.categoryService.updateCategory(id,categoryDto),HttpStatus.OK);
    }
    // Get All Categories
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategory(){
        return new ResponseEntity<List<CategoryDto>>(this.categoryService.getAllCategory(),HttpStatus.OK);
    }

    //Get Category By Id
    @GetMapping("/{id}")
    public  ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer id){
        return new ResponseEntity<>(this.categoryService.getCategoryById(id),HttpStatus.OK);
    }

    //Delete Category By ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategor(@PathVariable Integer id){
        this.categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
