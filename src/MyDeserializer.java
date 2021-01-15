import java.lang.reflect.Type;
import org.json.*;

import com.google.gson.*;

class MyDeserializer implements JsonDeserializer<JsonResultObject>
{
    @Override
    public JsonResultObject deserialize(JsonElement je, Type type, JsonDeserializationContext jdc)
        throws JsonParseException
    {
        // Get the "content" element from the parsed JSON
        JsonElement content = je.getAsJsonObject().get("content");

        // Deserialize it. You use a new instance of Gson to avoid infinite recursion
        // to this deserializer
        return new Gson().fromJson(content, JsonResultObject.class);

    }
}