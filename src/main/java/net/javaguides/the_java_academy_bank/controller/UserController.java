package net.javaguides.the_java_academy_bank.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.javaguides.the_java_academy_bank.dto.*;
import net.javaguides.the_java_academy_bank.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@Tag(name = "User Account Management APIs" )
public class UserController {
  @Autowired
  UserService userService;
  @Operation(
          summary = "Create New User Account",
          description = "Creating a new user and assigning an account ID"
  )
  @ApiResponse(
          responseCode = "201",
          description = "Http Status 201 CREATED"

  )



    @PostMapping("/create-account")
   public BankResponse createAccount(@RequestBody UserRequest userRequest){
       return  userService.createAccount(userRequest);
   }
   @PostMapping("/login")
   public BankResponse login(@RequestBody LoginDto loginDto){
      return userService.login(loginDto);
   }
   @DeleteMapping("/{id}")
   public ResponseEntity<String> deleteAccount(@PathVariable ("id") Long id){
      userService.delete(id);
      return ResponseEntity.ok("Account is deleted Successfully");
   }
    @Operation(
            summary = "Balance Enquiry",
            description = "Given an account Number, check how much the user has"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 200 SUCCESS"

    )
   @GetMapping("/balanceEnquiry")
    public BankResponse balanceEnquiry(@RequestBody EnquiryRequest request){
      return userService.balanceEnquiry(request);
   }
   @GetMapping("/nameEnquiry")
    public String nameEnquiry (@RequestBody EnquiryRequest request){
      return userService.nameEnquiry(request);
   }
   @PostMapping("/credit")
    public BankResponse creditAccount(@RequestBody CreditDebitRequest request){
      return userService.creditAccount(request);
   }
   @PostMapping("/debit")
   public BankResponse debitAccount(@RequestBody CreditDebitRequest request){
      return userService.debitAccount(request);
   }
   @PostMapping("/transfer")
    public  BankResponse transfer(@RequestBody TransferRequest request){
      return userService.transfer(request);
   }
}
