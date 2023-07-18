package orderapp.orderapp.Controller;

import orderapp.orderapp.Helper.ResponseBody;
import orderapp.orderapp.Model.Category;
import orderapp.orderapp.Model.Product;
import orderapp.orderapp.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<ResponseBody> getAllCategory() {
    try {
        List<Category> categoryList = categoryService.findAll();
        if (categoryList.isEmpty()){
            ResponseBody responseBody = new ResponseBody(404, "Category Is not exist",null);
            return new ResponseEntity<>(responseBody, HttpStatus.NOT_FOUND);
        }
        ResponseBody responseBody = new ResponseBody(200, "Category Data Successfully Retrieved",categoryList );
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }catch (Exception e){
        ResponseBody response = new ResponseBody(500, e.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<ResponseBody> AddCategory(
            @RequestParam String name,
            @RequestParam String description
    ) {
        try {
            Category data = new Category(name, description);
            categoryService.save(data);
            ResponseBody responseBody = new ResponseBody(200, "Category data is succesfully Add", data);
            return new ResponseEntity<>(responseBody, HttpStatus.OK);
        } catch (Exception e) {
            ResponseBody response = new ResponseBody(500, e.getMessage(), null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
