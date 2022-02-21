package com.tma.accountservice.service;

import com.tma.accountservice.entity.Account;
import com.tma.accountservice.model.AccountDTO;
import com.tma.accountservice.repository.AccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class AccountServiceImp implements AccountService{

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void add(AccountDTO accountDTO) {
        Account account = modelMapper.map(accountDTO, Account.class);

        accountRepository.save(account);

        accountDTO.setId(account.getId());
    }

    @Override
    public void update(AccountDTO accountDTO) {
        Account account = accountRepository.getById(accountDTO.getId());

        if (account != null){
            modelMapper.typeMap(AccountDTO.class, Account.class)
                    .addMappings(mapper -> mapper.skip(Account::setPassword)).map(accountDTO, account);
            accountRepository.save(account);
        }
    }

    @Override
    public void updatePassword(AccountDTO accountDTO) {
        Account account = accountRepository.getById(accountDTO.getId());

        if (account != null){

            accountRepository.save(account);
        }
    }

    @Override
    public void delete(Long id) {
        Account account = accountRepository.getById(id);
        if (account != null){
            accountRepository.delete(account);
        }
    }

    @Override
    public List<AccountDTO> getALl() {
        List<AccountDTO> accountDTOList = new ArrayList<>();

        accountRepository.findAll().forEach((account) -> {
            accountDTOList.add(modelMapper.map(account, AccountDTO.class));
        });

        return accountDTOList;
    }

    @Override
    public AccountDTO getOne(Long id) {
        Account account = accountRepository.getById(id);

        if (account != null){
            AccountDTO accountDTO = modelMapper.map(account, AccountDTO.class);
            return accountDTO;
        }

        return null;
    }
}
