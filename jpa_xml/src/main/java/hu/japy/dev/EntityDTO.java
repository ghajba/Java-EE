package hu.japy.dev;

/**
 * Simple DTO to have the Entity representation decoupled from the entities themselves.
 *
 * @author GHajba
 */
public class EntityDTO {
    private final Long id;
    private final String createdBy;

    public EntityDTO(Long id, String createdBy) {
        this.id = id;
        this.createdBy = createdBy;
    }

    public Long getId() {
        return this.id;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + " / created by: " + this.createdBy;
    }

}
