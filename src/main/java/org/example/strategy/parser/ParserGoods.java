package org.example.strategy.parser;

import java.util.List;
import org.example.model.Goods;

public interface ParserGoods<T extends Goods> {
    List<T> parse(List<String[]> input);
}
