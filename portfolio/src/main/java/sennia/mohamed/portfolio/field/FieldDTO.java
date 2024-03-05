package sennia.mohamed.portfolio.field;

public class FieldDTO {
    private int field_id;
    private String fieldName;

    public FieldDTO(int field_id, String fieldName) {
        this.field_id = field_id;
        this.fieldName = fieldName;
    }

    public int getField_id() {
        return field_id;
    }

    public void setField_id(int field_id) {
        this.field_id = field_id;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public String toString() {
        return "FieldDTO{" +
                "field_id=" + field_id +
                ", fieldName='" + fieldName + '\'' +
                '}';
    }
}
