package com.example.bank.account;

import com.example.bank._core.utils.ApiUtil;
import com.example.bank.user.SessionUser;
import com.example.bank.user.UserRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AccountController {
    private final AccountService accountService;
    private final HttpSession session;

    @PutMapping("/api/transfer")
    public ResponseEntity<?> transfer(@RequestBody AccountRequest.TransferDTO reqDTO){
        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
        AccountResponse.TransferDTO respDTO = accountService.계좌이체(reqDTO, sessionUser);
        return ResponseEntity.ok(new ApiUtil(respDTO));
    }

    @GetMapping("/api/accounts")
    public ResponseEntity<?> accountList(){
        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
        AccountResponse.MainDTO respDTO = accountService.계좌목록보기(sessionUser.getId());
        return ResponseEntity.ok(new ApiUtil(respDTO));
    }
}