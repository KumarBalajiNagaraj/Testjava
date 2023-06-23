package com.example.controller;

import com.example.model.Basket;
import com.example.model.FruitStall;
import com.example.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FruitController {
    private final FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping("/pelle-kajsa")
    public String getPelleKajsaFruitStall() {
        FruitStall optimalFruitStall = fruitService.findOptimalFruitStall();

        if (optimalFruitStall == null) {
            return "No suitable fruit stall found for Pelle and Kajsa.";
        }

        double totalPrice = optimalFruitStall.getPearPrice();
        Basket individualPrices = new Basket(
                optimalFruitStall.getCherryPrice(),
                optimalFruitStall.getPeachPrice(),
                optimalFruitStall.getPearPrice()
        );

        return "Pelle and Kajsa should stop at " + optimalFruitStall.getName() +
                " to minimize the overall cost.\n" +
                "Total Price: " + totalPrice + "\n" +
                "Individual Basket Prices: " + individualPrices;
    }

    @GetMapping("/friend")
    public String getFriendFruitCombination() {
        List<FruitStall> fruitStalls = fruitService.getAllFruitStalls();
        FruitStall chosenFruitStall = fruitService.findOptimalFruitStall();
        Basket friendCombination = fruitService.findFriendFruitCombination(fruitStalls, chosenFruitStall);

        return "Friend can buy the following fruit combination:\n" +
                "Fruit Stall: " + chosenFruitStall.getName() + "\n" +
                "Basket Size: " + friendCombination;
    }
}
