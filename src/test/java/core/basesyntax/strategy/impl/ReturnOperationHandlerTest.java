package core.basesyntax.strategy.impl;

import static org.junit.Assert.assertEquals;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationStrategy;
import org.junit.Before;
import org.junit.Test;

public class ReturnOperationHandlerTest {
    private OperationStrategy operationStrategy;
    private FruitTransaction fruitTransaction;

    @Before
    public void setUp() {
        Storage.FRUITS_MAP.put("cherry", 10);
        operationStrategy = new OperationStrategyImpl();
        fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation.RETURN);
        fruitTransaction.setFruit("cherry");
        fruitTransaction.setQuantity(15);
    }

    @Test
    public void validClass() {
        assertEquals(operationStrategy
                        .getOperation(FruitTransaction.Operation.RETURN).getClass(),
                ReturnOperationHandler.class);
    }

    @Test
    public void validData() {
        operationStrategy.getOperation(FruitTransaction.Operation.RETURN)
                .operate(fruitTransaction);
        Integer actual = Storage.FRUITS_MAP.get("cherry");
        assertEquals(25, Integer.parseInt(String.valueOf(actual)));
    }
}