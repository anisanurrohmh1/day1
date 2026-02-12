//package com.mega.demo.controller;
//
//import com.mega.demo.dto.PageResponse;
//import com.mega.demo.dto.ProductRequest;
//import com.mega.demo.dto.ProductResponse;
//import com.mega.demo.service.ProductService;
//import org.springframework.data.domain.Sort;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/products")
//public class ProductController {
//
//    private final ProductService service;
//
//    public ProductController(ProductService service) {
//        this.service = service;
//    }
//
//    @PostMapping
//    public ProductResponse create(@RequestBody ProductRequest req) {
//        return service.create(req);
//    }
//
//    @GetMapping
//    public PageResponse<ProductResponse> getAll(
//            @RequestParam(required = false) String name,
//            @RequestParam(required = false) String branchId,
//            @RequestParam(required = false) Double priceMin,
//            @RequestParam(required = false) Double priceMax,
//
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size,
//            @RequestParam(defaultValue = "name") String sortBy,
//            @RequestParam(defaultValue = "ASC") Sort.Direction direction
//    ) {
//        return service.findAll(
//                name,
//                branchId,
//                priceMin,
//                priceMax,
//                page,
//                size,
//                sortBy,
//                direction
//        );
//    }
//
//    @GetMapping("/{id}")
//    public ProductResponse getById(@PathVariable String id) {
//        return service.findById(id);
//    }
//}
