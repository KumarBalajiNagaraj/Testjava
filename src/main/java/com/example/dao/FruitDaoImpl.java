package com.example.dao;

import com.example.model.FruitStall;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FruitDaoImpl implements FruitDao {
    @Override
    public List<FruitStall> getAllFruitStalls() {
        List<FruitStall> fruitStalls = new ArrayList<>();
        // Here you can load the data from fruits.yaml or use hardcoded values
        // For simplicity, let's use hardcoded values

        fruitStalls.add(new FruitStall("Stall 1", 5.0, 4.0, 3.0, true, true, true));
        fruitStalls.add(new FruitStall("Stall 2", 6.0, 3.5, 3.5, true, false, true));
        fruitStalls.add(new FruitStall("Stall 3", 5.5, 3.0, 4.0, false, true, true));
        fruitStalls.add(new FruitStall("Stall 4", 4.5, 4.5, 3.5, true, false, false));

        return fruitStalls;
    }
}
