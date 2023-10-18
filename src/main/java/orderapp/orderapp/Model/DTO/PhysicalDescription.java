package orderapp.orderapp.Model.DTO;

import org.springframework.data.mongodb.core.mapping.Field;

public class PhysicalDescription {

    @Field("height")
    private String height;
    @Field("weight")
    private String weight;
    @Field("hair_type")
    private String hairType;
    @Field("face_shape")
    private String faceShape;
    @Field("skin_color")
    private String skinColor;
    @Field("birth_mark")
    private String birthMark;
    @Field("disability")
    private String disability;
    @Field("hobby")
    private String hobby;

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHairType() {
        return hairType;
    }

    public void setHairType(String hairType) {
        this.hairType = hairType;
    }

    public String getFaceShape() {
        return faceShape;
    }

    public void setFaceShape(String faceShape) {
        this.faceShape = faceShape;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public String getBirthMark() {
        return birthMark;
    }

    public void setBirthMark(String birthMark) {
        this.birthMark = birthMark;
    }

    public String getDisability() {
        return disability;
    }

    public void setDisability(String disability) {
        this.disability = disability;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
