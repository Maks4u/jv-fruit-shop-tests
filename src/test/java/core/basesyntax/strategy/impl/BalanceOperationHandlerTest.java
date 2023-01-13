package core.basesyntax.strategy.impl;

import static org.junit.Assert.assertEquals;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationStrategy;
import org.junit.Before;
import org.junit.Test;

public class BalanceOperationHandlerTest {
    private OperationStrategy operationStrategy;
    private FruitTransaction fruitTransaction;

    @Before
    public void setUp() {
        operationStrategy = new OperationStrategyImpl();
        fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation.BALANCE);
        fruitTransaction.setFruit("cherry");
        fruitTransaction.setQuantity(15);
    }

    @Test
    public void validClass() {
        assertEquals(operationStrategy
                .getOperation(FruitTransaction.Operation.BALANCE).getClass(),
                BalanceOperationHandler.class);
    }

    @Test
    public void validData() {
        operationStrategy.getOperation(FruitTransaction.Operation.BALANCE)
                .operate(fruitTransaction);
        Integer actual = Storage.FRUITS_MAP.get("cherry");
        assertEquals(15, Integer.parseInt(String.valueOf(actual)));
    }
}