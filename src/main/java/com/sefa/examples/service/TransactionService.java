package com.sefa.examples.service;

import com.sefa.examples.model.Transaction;
import com.sefa.examples.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    protected Transaction save (Transaction transaction){
        return transactionRepository.save(transaction);
    }
}
