package com.mega.demo.spesification;


import com.mega.demo.entity.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {

    public static Specification<Product> nameLike(String name) {
        return (root, query, cb) ->
                name == null ? null :
                        cb.like(
                                cb.lower(root.get("name")),
                                "%" + name.toLowerCase() + "%"
                        );
    }

    public static Specification<Product> branchIdEqual(String branchId) {
        return (root, query, cb) ->
                branchId == null ? null :
                        cb.equal(
                                root.get("branch").get("id"),
                                branchId
                        );
    }

    public static Specification<Product> priceMin(Double min) {
        return (root, query, cb) ->
                min == null ? null :
                        cb.greaterThanOrEqualTo(root.get("price"), min);
    }

    public static Specification<Product> priceMax(Double max) {
        return (root, query, cb) ->
                max == null ? null :
                        cb.lessThanOrEqualTo(root.get("price"), max);
    }
}