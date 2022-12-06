package domain.Dto;

public record ItemCreationDto(int type, int ownerId, int shelfId) {

    public int getType() {
        return type;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public int getShelfId() {
        return shelfId;
    }

}
