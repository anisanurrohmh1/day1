package com.mega.demo.service;

import com.mega.demo.dto.BranchResponse;
import com.mega.demo.dto.PageResponse;
import com.mega.demo.dto.ProductRequest;
import com.mega.demo.dto.ProductResponse;
import com.mega.demo.entity.Branch;
import com.mega.demo.entity.Product;
import com.mega.demo.repository.BranchRepository;
import com.mega.demo.repository.ProductRepository;
import com.mega.demo.spesification.ProductSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

    private final ProductRepository productRepo;
    private final BranchRepository branchRepo;

    public ProductService(ProductRepository productRepo, BranchRepository branchRepo) {
        this.productRepo = productRepo;
        this.branchRepo = branchRepo;
    }

    public ProductResponse create(ProductRequest req) {
        Branch branch = branchRepo.findById(req.branchId())
                .orElseThrow(() -> new RuntimeException("Branch not found"));

        Product product = productRepo.save(
                new Product(req.name(), req.price(), branch)
        );

        return toResponse(product);
    }

    public PageResponse<ProductResponse> findAll(
            String name,
            String branchId,
            Double priceMin,
            Double priceMax,
            int page,
            int size,
            String sortBy,
            Sort.Direction direction
    ) {
        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(direction, sortBy)
        );

        Specification<Product> spec = Specification
                .where(ProductSpecification.nameLike(name))
                .and(ProductSpecification.branchIdEqual(branchId))
                .and(ProductSpecification.priceMin(priceMin))
                .and(ProductSpecification.priceMax(priceMax));

        Page<Product> result = productRepo.findAll(spec, pageable);

        return new PageResponse<>(
                result.getContent()
                        .stream()
                        .map(this::toResponse)
                        .toList(),
                result.getNumber(),
                result.getSize(),
                result.getTotalElements(),
                result.getTotalPages()
        );
    }

    public ProductResponse findById(String id) {
        return productRepo.findById(id)
                .map(this::toResponse)
                .orElse(null);
    }

    private ProductResponse toResponse(Product p) {
        return new ProductResponse(
                p.getId(),
                p.getName(),
                p.getPrice(),
                new BranchResponse(
                        p.getBranch().getId(),
                        p.getBranch().getName(),
                        p.getBranch().getAddress()
                )
        );
    }
}
