package org.gameoftrones.ironbankapp.services;

import org.gameofthrones.ironstarter.ConditionalOnProduction;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */
@Service
@ConditionalOnProduction
public class ProdService {
    @Scheduled(fixedDelay = 1000)
    public void doWork(){
        System.out.println("PROD SERVICE IS WORKING");
    }
}
