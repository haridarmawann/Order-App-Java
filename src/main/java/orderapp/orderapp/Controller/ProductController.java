package orderapp.orderapp.Controller;

import orderapp.orderapp.Helper.ResponseBody;
import orderapp.orderapp.Helper.Utils;
import orderapp.orderapp.Model.Category;
import orderapp.orderapp.Model.Product;
import orderapp.orderapp.Service.CategoryService;
import orderapp.orderapp.Service.ProductService;
import orderapp.orderapp.storage.StorageService;
import org.apache.commons.io.FilenameUtils;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    private final CategoryService categoryService;

    private final StorageService storageService;

    protected Utils utils = new Utils();

    private final Environment environment;

    public ProductController(ProductService productService, StorageService storageService, CategoryService categoryService,Environment environment) {
        this.productService = productService;
        this.storageService = storageService;
        this.categoryService = categoryService;
        this.environment = environment;
    }

    @GetMapping
    public ResponseEntity<ResponseBody> getAllProduct() {
        try {
            List<Product> products = productService.findAll();
            List<Product> productsList = new ArrayList<>();
            String baseUrl = utils.baseUrl(environment);
            for(Product item : products){
                String imageLink = baseUrl+"/uploads/media/product/"+item.getImages();
                item.setImages(imageLink);
                productsList.add(item);
            }
            ResponseBody responseBody = new ResponseBody(200, "Product Data Successfully Retrieved",productsList );
            return new ResponseEntity<>(responseBody, HttpStatus.OK);
        } catch (Exception e) {
            ResponseBody response = new ResponseBody(500, e.getMessage(), null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody> FindProductById(@PathVariable String id) {
        try {

            Optional<Product> product = productService.findById(id);
            if (product.isPresent()) {
                ResponseBody responseBody = new ResponseBody(200, id + " Product Data Successfully Retrieved", product);
                return new ResponseEntity<>(responseBody, HttpStatus.OK);
            } else {
                ResponseBody responseBody = new ResponseBody(404, "Product Data Tidak Ditemukan", product);
                return new ResponseEntity<>(responseBody, HttpStatus.NOT_FOUND);
            }


        } catch (Exception e) {
            ResponseBody response = new ResponseBody(500, e.getMessage(), null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping
    public ResponseEntity<ResponseBody> addProduct(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam Float price,
            @RequestParam String categoryId,
            @RequestParam Integer qty,
            @RequestParam MultipartFile image
    ) {
        String imageFilename = null;
        try {
            Category category = categoryService.findById(categoryId)
                    .orElseThrow(() -> new Exception("Category not found"));

            List<Product> product = new ArrayList<>();
            if (image != null) {
                String filetype = FilenameUtils.getExtension(image.getOriginalFilename());
                imageFilename = "Product-"+ utils.generateRandomString(4) + "." + filetype;
                storageService.saveFile(image, imageFilename, "/media/products");
            }
            Product data = new Product(name, description, category,price, qty,imageFilename);
            productService.save(data);
            ResponseBody responseBody = new ResponseBody(200, "Product data is succesfully Add", data);
            return new ResponseEntity<>(responseBody, HttpStatus.OK);
        } catch (Exception e) {
            ResponseBody responseBody = new ResponseBody(404, "Product data is not found", null);
            return new ResponseEntity<>(responseBody, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBody>edit_quantity(@PathVariable("id") String id,
                                                     @RequestParam Integer qty){
        try{
            Optional<Product> product = productService.findById(id);
            if (product.isPresent()) {
                Product _product = product.get();
                _product.setQty(qty);

                Product product1 = productService.save(_product);
                ResponseBody responseBody = new ResponseBody(200    , "product quantity updated", product1);
                return new ResponseEntity<>(responseBody, HttpStatus.OK);
            }else {
                ResponseBody responseBody = new ResponseBody(400, "product id " + id + " is not exist",null);
                return new ResponseEntity<>(responseBody, HttpStatus.NOT_FOUND  );
            }
        }catch (Exception e){
            ResponseBody response = new ResponseBody(500, e.getMessage(), null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
