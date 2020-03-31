package com.songoda.skyblock.levelling.rework.calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.songoda.core.compatibility.CompatibleMaterial;
import org.bukkit.Material;

public final class CalculatorRegistry {

    private CalculatorRegistry() {

    }

    private static final Map<CompatibleMaterial, List<Calculator>> calculators = new HashMap<>();

    public static void registerCalculator(Calculator calculator, CompatibleMaterial to) {

        List<Calculator> list = calculators.get(to);

        if (list == null) {
            list = new ArrayList<>();
            calculators.put(to, list);
        }

        list.add(calculator);
    }

    public static List<Calculator> getCalculators(CompatibleMaterial type) {
        return calculators.get(type);
    }

}
