package collections.database;

public class Field
{
	String dataType;

	public Object createField(FieldType type)
	{
		return new Object();
	}


}

enum FieldType
{
	STRING,
	INT,
	BOOLEAN
}
