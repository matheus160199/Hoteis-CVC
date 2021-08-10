package br.com.cvc.hotels.config;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.google.common.base.Strings;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class DateAdapter  implements JsonDeserializer<LocalDate>, JsonSerializer<LocalDate> {

	private final DateTimeFormatter formatter;

    public DateAdapter() {
        this.formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy",
        		new Locale("pt", "BR"));
    }

	@Override
	public JsonElement serialize(LocalDate src, Type arg1, JsonSerializationContext arg2) {
		return src == null ? null : new JsonPrimitive(formatter.format(src));
	}

	@Override
	public LocalDate deserialize(JsonElement json, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
		final String dateTime = json.getAsString();
        try {
            return Strings.isNullOrEmpty(dateTime) ? null : LocalDate.from(formatter.parse(dateTime));
        } catch (Exception e) {
            return null;
        }
	}

}
