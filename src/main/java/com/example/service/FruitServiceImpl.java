// FruitServiceImpl.java
package com.example.service;

import com.example.dao.FruitDao;
import com.example.model.Basket;
import com.example.model.FruitStall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FruitServiceImpl implements FruitService {
    private final FruitDao fruitDao;

    @Autowired
    public FruitServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public FruitStall findOptimalFruitStall() {
        List<FruitStall> fruitStalls = getAllFruitStalls();

        List<FruitStall> availableFruitStalls = fruitStalls.stream()
                .filter(FruitStall::isHasPear)
                .collect(Collectors.toList());

        double minPrice = Double.MAX_VALUE;
        FruitStall optimalFruitStall = null;

        for (FruitStall fruitStall : availableFruitStalls) {
            double pearPrice = fruitStall.getPearPrice();

            // Check if the fruit stall has cherry or peach
            if (fruitStall.hasCherry() || fruitStall.hasPeach()) {
                double otherFruitPrice = Math.min(fruitStall.getCherryPrice(), fruitStall.getPeachPrice());
                double totalPrice = pearPrice + otherFruitPrice;

                if (totalPrice < minPrice) {
                    minPrice = totalPrice;
                    optimalFruitStall = fruitStall;
                }
            }
        }

        return optimalFruitStall;
    }


    @Override
    public Basket findFriendFruitCombination(List<FruitStall> fruitStalls, FruitStall chosenFruitStall) {
        List<FruitStall> remainingFruitStalls = fruitStalls.stream()
                .filter(fs -> !fs.equals(chosenFruitStall))
                .collect(Collectors.toList());

        FruitStall friendFruitStall = remainingFruitStalls.get(0);
        double cherryPrice = friendFruitStall.getCherryPrice();
        double peachPrice = friendFruitStall.getPeachPrice();
        double pearPrice = friendFruitStall.getPearPrice();

        List<Basket> combinations = new ArrayList<>();

        if (friendFruitStall.hasCherry()) {
            combinations.add(new Basket(cherryPrice, 0, pearPrice));
            combinations.add(new Basket(cherryPrice, peachPrice, 0));
        }

        if (friendFruitStall.hasPeach()) {
            combinations.add(new Basket(0, peachPrice, pearPrice));
        }

        return combinations.get(0); // Assuming only one combination is selected
    }


    @Override
    public List<FruitStall> getAllFruitStalls() {
        return fruitDao.getAllFruitStalls();
    }
}
