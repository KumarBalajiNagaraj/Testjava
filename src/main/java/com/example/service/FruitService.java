package com.example.service;

import com.example.model.Basket;
import com.example.model.FruitStall;

import java.util.List;

public interface FruitService {
    FruitStall findOptimalFruitStall();
    Basket findFriendFruitCombination(List<FruitStall> fruitStalls, FruitStall chosenFruitStall);
    List<FruitStall> getAllFruitStalls(); // Added method declaration
}