/**
 * 
 */
/**
 * @author Jim
 *
 */

@XmlJavaTypeAdapters({ @XmlJavaTypeAdapter(type = java.time.ZonedDateTime.class, value = DateTimeAdapter.class) })
package pl.crater.archetypes.model;

import pl.crater.archetypes.xml.adapters.DateTimeAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;

