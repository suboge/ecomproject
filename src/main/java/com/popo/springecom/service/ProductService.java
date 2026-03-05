package com.popo.springecom.service;

import com.popo.springecom.model.Product;
import com.popo.springecom.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;


    @Cacheable(value = "productsAll")
    public List<Product> getAllProducts() {

        return productRepo.findAll();

    }

    @Cacheable(value = "product", key = "#id")
    public Product getProductById(int id) {
        return productRepo.findById(id).orElse(new Product(-1));
    }

    @CacheEvict(value = {"product", "productsAll"}, allEntries = true)
    public Product addOrUpdateProduct(Product product, MultipartFile image) throws IOException {
        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());
        return productRepo.save(product);
    }

    @CacheEvict(value = {"product", "productsAll"}, allEntries = true)
    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {
        return productRepo.searchProducts(keyword);
    }


//    public Product updateProduct(Product product, MultipartFile image) throws IOException {
//        product.setImageName(image.getOriginalFilename());
//        product.setImageType(image.getContentType());
//        product.setImageData(image.getBytes());
//        return productRepo.save(product);
//
//    }
}
