package org.gameoftrones.ironbankapp.controllers;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.gameoftrones.ironbankapp.services.BankService;
import org.gameoftrones.ironbankapp.data.Message;
import org.gameoftrones.ironbankapp.data.Person;
import org.springframework.web.bind.annotation.*;

/**
 * @author Evgeny Borisov
 */
@RestController
@RequestMapping("/iron-bank")
@RequiredArgsConstructor
public class IronBankController {
    private final BankService bankService;

    @GetMapping("/ping")
    public String ping() {
        return "Game of Thrones is UP!!!";
    }

    @PostMapping("/person")
    @SneakyThrows
    public Message takePerson(@RequestBody Person person) {
        System.out.println("person = " + person);

        return Message.builder().author("Uknown").content("thank you").build();

    }

    @GetMapping("/loan")
    public String loan(@RequestParam("amount") Long amount,@RequestParam("name") String name) {
        long leftMoney = bankService.loan(name, amount);
        if (leftMoney == -1) {
            return "Loan is not allowed, you will not survive the winter, or we don't have enought money, or we just don't like you!!";
        }
        return "loan was accepted, money left: " + leftMoney;
    }















}
