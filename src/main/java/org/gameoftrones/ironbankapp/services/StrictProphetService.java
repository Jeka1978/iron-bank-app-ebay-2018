package org.gameoftrones.ironbankapp.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */
@Service
@Profile("WINTER_IS_HERE")
public class StrictProphetService implements ProphetService {
    @Override
    public boolean willNotSurvive(String name) {
        return !name.toLowerCase().contains("lanister");
    }
}
