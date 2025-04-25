package net.javaguides.the_java_academy_bank.service.impl;

import net.javaguides.the_java_academy_bank.dto.TransactionDto;
import net.javaguides.the_java_academy_bank.entity.Transaction;

public interface TransactionService {
    void saveTransaction(TransactionDto transactionDto);
}
