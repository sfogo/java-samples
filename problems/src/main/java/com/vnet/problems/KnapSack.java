package com.vnet.problems;

import com.vnet.common.VException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

public class KnapSack {
    @Getter
    @AllArgsConstructor
    static class Item {
        private final String name;
        private final int weight;
        private final int profit;

        void validate() {
            if (StringUtils.isEmpty(name)) {
                throw new VException("Invalid name:" + name);
            }
            if (weight < 0) {
                throw new VException("Invalid weight:" + weight);
            }
            if (profit < 0) {
                throw new VException("Invalid profit:" + profit);
            }
        }
    }

    public int maximize(final int capacity, final Item[] items) {
        if (capacity < 0) {
            throw new VException("Invalid capacity:" + capacity);
        }
        for (final Item item : items) {
            item.validate();
        }
        return maxProfit(capacity, items, 0);
    }

    private int maxProfit(final int capacity, final Item[] items, final int index) {
        if (capacity <= 0 || index < 0 || index >= items.length) {
            return 0;
        }

        return Math.max(
                items[index].weight > capacity ? 0 : items[index].profit + maxProfit(capacity - items[index].weight, items, index+1),
                maxProfit(capacity, items, index+1));
    }
}
