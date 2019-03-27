package guess.thenumber.core;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// @Target -> Our Annotation can be added to fields/parameters/Methods
// @Retention -> How long the annotations should be retained
// @Qualifier -> To annotate our custom annotations
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface GuessCount {

}
