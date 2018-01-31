package fr.lez.ddd;

public abstract class Entity<ID extends EntityId> {

    private final ID id;

    protected Entity(ID id) {
        this.id = ObjectUtils.requireNotNull(id);
    }

    public ID getId() {
        return this.id;
    }

}
