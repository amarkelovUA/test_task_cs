package org.example.strategy;

import java.util.Map;
import lombok.AllArgsConstructor;
import org.example.model.Goods;
import org.example.strategy.parser.ParserGoods;

@AllArgsConstructor
public class ParserStrategyImpl implements ParserStrategy {
    private final Map<Class<? extends Goods>, ParserGoods<? extends Goods>> parserMap;

    @Override
    public ParserGoods<?> getParser(Class clazz) {
        return parserMap.get(clazz);
    }
}
