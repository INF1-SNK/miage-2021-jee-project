package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dao.StoreStockDAO;
import fr.pantheonsorbonne.ufr27.miage.dto.StoreStockDTO;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class StoreStockServiceImpl implements StoreStockService {

    @Inject
    StoreStockDAO storeStock;


    @Override
    public StoreStockDTO getStockFromProductByID(int id) {
        return new StoreStockDTO(1, storeStock.getAmmountOfProducts(id));
    }
}