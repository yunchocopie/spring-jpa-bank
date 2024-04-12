package com.example.bank.account;

import com.example.bank._core.errors.exception.Exception403;
import com.example.bank._core.errors.exception.Exception404;
import com.example.bank.history.History;
import com.example.bank.history.HistoryRepository;
import com.example.bank.user.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final HistoryRepository historyRepository;

    public AccountResponse.MainDTO 계좌목록보기(int userId){
        List<Account> accountList = accountRepository.findByUserId(userId);
        return new AccountResponse.MainDTO(accountList);
    }

    public AccountResponse.DetailDTO 계좌상세보기(int number, SessionUser sessionUser){
        Account account = accountRepository.findByNumber(number)
                .orElseThrow(() -> new Exception404("조회하신 계좌가 존재하지 않습니다"));

        if(account.getUser().getId() != sessionUser.getId()){
            throw new Exception403("해당 계좌를 조회할 권한이 없습니다");
        }

        List<History> historyList = historyRepository.findBySenderOrReceiver(number);
        return new AccountResponse.DetailDTO(account, historyList, number);
    }
}