package fr.lez.ddd;

public abstract class Entity<ID extends EntityId> {

    private final ID id;

    protected Entity(ID id) {
        this.id = ObjectUtils.requireNotNull(id);
    }

    public final ID getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entity<?> entity = (Entity<?>) o;

        return id.equals(entity.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
