package ru.job4j.baranov.generic;

public abstract class AbstractStore<T extends Base> implements Store<T> {
    private SimpleList<String> ids;
    private SimpleList<T> items;

    public AbstractStore(int size) {
        ids = new SimpleList<>(size);
        items = new SimpleList<>(size);
    }

    @Override
    public void add(T model) {
        ids.add(model.getId());
        items.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = ids.indexOf(id);
        boolean indexInArray = index >= 0;
        if (indexInArray) {
            ids.set(index, model.getId());
            items.set(index, model);
        }
        return indexInArray;
    }

    @Override
    public boolean delete(String id) {
        int index = ids.indexOf(id);
        boolean indexInArray = index >= 0;
        if (indexInArray) {
            ids.delete(index);
            items.delete(index);
        }
        return indexInArray;
    }

    @Override
    public T findById(String id) {
        int index = ids.indexOf(id);
        if (index >= 0) {
            return items.get(index);
        } else {
            return null;
        }
    }
}
