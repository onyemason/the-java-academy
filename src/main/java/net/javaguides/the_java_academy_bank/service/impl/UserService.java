package net.javaguides.the_java_academy_bank.service.impl;

import net.javaguides.the_java_academy_bank.dto.*;

public interface UserService {
   BankResponse createAccount(UserRequest userRequest);

   void delete(Long id);
   BankResponse balanceEnquiry(EnquiryRequest request);

   String nameEnquiry(EnquiryRequest request);

   BankResponse creditAccount(CreditDebitRequest request);
   BankResponse debitAccount(CreditDebitRequest request);
   BankResponse transfer(TransferRequest request);
   BankResponse login(LoginDto loginDto);

}
