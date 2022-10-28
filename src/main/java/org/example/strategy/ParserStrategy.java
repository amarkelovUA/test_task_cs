package org.example.strategy;

import org.example.strategy.parser.ParserGoods;

public interface ParserStrategy {
    ParserGoods<?> getParser(Class clazz);
}
