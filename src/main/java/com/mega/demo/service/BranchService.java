package com.mega.demo.service;

import com.mega.demo.dto.BranchRequest;
import com.mega.demo.dto.BranchResponse;
import com.mega.demo.entity.Branch;
import com.mega.demo.repository.BranchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {

    private final BranchRepository repository;

    public BranchService(BranchRepository repository) {
        this.repository = repository;
    }

    public BranchResponse create(BranchRequest req) {
        Branch branch = repository.save(
                new Branch(req.name(), req.address())
        );
        return toResponse(branch);
    }

    public List<BranchResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public BranchResponse findById(String id) {
        return repository.findById(id)
                .map(this::toResponse)
                .orElse(null);
    }

    private BranchResponse toResponse(Branch b) {
        return new BranchResponse(
                b.getId(),
                b.getName(),
                b.getAddress()
        );
    }
}