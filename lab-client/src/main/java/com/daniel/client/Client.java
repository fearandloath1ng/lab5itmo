package com.daniel.client;

import com.daniel.client.managers.CollectionManager;

public final class Client {
    private Client() {
        throw new UnsupportedOperationException("This is an utility class and can not be instantiated");
    }

    public static void main(String[] args) {
        CollectionManager collectionManager = new CollectionManager(System.getenv("Collection"));
        collectionManager.run();
    }
}
