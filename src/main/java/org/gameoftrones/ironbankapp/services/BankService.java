package org.gameoftrones.ironbankapp.services;

import lombok.RequiredArgsConstructor;
import org.gameoftrones.ironbankapp.data.Bank;
import org.gameoftrones.ironbankapp.data.MoneyDao;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Evgeny Borisov
 */
@Service
@Transactional
@RequiredArgsConstructor
public class BankService {
    private final MoneyDao moneyDao;
    private final ProphetService prophetService;

    @EventListener(ContextRefreshedEvent.class)
    public void initBankBalance() {
        moneyDao.save(new Bank());
    }


    public long loan(String name, long amount) {
        Bank bank = moneyDao.findAll().iterator().next();
        if (bank.getAmount() < amount || prophetService.willNotSurvive(name)) {
            return -1;
        } else {
            bank.setAmount(bank.getAmount() - amount);
            return bank.getAmount();
        }
    }


}
