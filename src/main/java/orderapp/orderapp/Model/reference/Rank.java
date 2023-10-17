package orderapp.orderapp.Model.reference;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("rank")
public class Rank {
    @Field("id")
    private String id;
    @Field("cumulation")
    private String cumulation;
    @Field("position")
    private String position;
    @Field("rank")
    private String rank;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCumulation() {
        return cumulation;
    }

    public void setCumulation(String cumulation) {
        this.cumulation = cumulation;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Rank{" +
                "id='" + id + '\'' +
                ", cumulation='" + cumulation + '\'' +
                ", position='" + position + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }
}
