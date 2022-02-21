package com.tma.accountservice.service;

import com.tma.accountservice.model.AccountDTO;

import java.util.List;

public interface AccountService {

    void add(AccountDTO accountDTO);

    void update(AccountDTO accountDTO);

    void updatePassword(AccountDTO accountDTO);

    void delete(Long id);

    List<AccountDTO> getALl();

    AccountDTO getOne(Long id);

}
