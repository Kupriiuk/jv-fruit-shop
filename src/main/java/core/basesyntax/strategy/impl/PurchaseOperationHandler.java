package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {

    @Override
    public void apply(Transaction transaction) {
        Fruit fruit = transaction.getFruit();
        Integer currentQuantity = Storage.getStorage().get(fruit);
        if (currentQuantity >= transaction.getQuantity()) {
            Storage.getStorage().put(fruit, currentQuantity - transaction.getQuantity());
        }
    }
}
