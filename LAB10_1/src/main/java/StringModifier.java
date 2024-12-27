import java.lang.reflect.Field;

public class StringModifier {
    public static void modifyStringValue(String str, String newValue) throws Exception {
        Class<String> stringClass = String.class;
        Field[] fields = stringClass.getDeclaredFields();
        boolean valueFieldFound = false;

        for (Field field : fields) {
            if (field.getName().equals("value")) {
                field.setAccessible(true);
                valueFieldFound = true;

                Object originalValue = field.get(str);

                if (originalValue instanceof byte[]) {
                    byte[] newValueBytes = newValue.getBytes();
                    field.set(str, newValueBytes);

                } else if (originalValue instanceof char[]) {
                    char[] newValueChars = newValue.toCharArray();
                    field.set(str, newValueChars);

                } else {
                    throw new UnsupportedOperationException("Unsupported type of \"value\" field.");
                }

                return;
            }
        }

        if (!valueFieldFound) {
            System.out.println("Field \"value\" not found.");
        }
    }
}

