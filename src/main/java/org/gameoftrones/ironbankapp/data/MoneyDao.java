package org.gameoftrones.ironbankapp.data;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
public interface MoneyDao extends CrudRepository<Bank,Integer> {
}
