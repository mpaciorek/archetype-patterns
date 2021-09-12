package pl.inpost.archetypes.jpa.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Duration;

/**
 * Convert a duration into a long, representing seconds.
 * 
 * @author Jim
 *
 */
@Converter(autoApply = true)
public class DurationToSecondsInteger implements AttributeConverter<Duration, Long> {

	@Override
	public Long convertToDatabaseColumn(Duration attribute) {
		return attribute.getSeconds();
	}

	@Override
	public Duration convertToEntityAttribute(Long dbData) {
		return Duration.ofSeconds(dbData);
	}

}
