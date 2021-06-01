package my.egorrridze.trppconverter1;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ValueList {
    List<Value> massValue;
    List<Value> lengthValue;
    List<Value> values;

    ValueList() {
        this.values = new ArrayList<>();

        this.massValue = new ArrayList<>();
        this.lengthValue = new ArrayList<>();

        Value kilogram = new Value("кг", 1);
        Value gram = new Value("г", 0.001);
        Value centner = new Value("ц", 100);
        Value tonne = new Value("т", 1000);
        Value pound = new Value("фунт",0.453592);

        Collections.addAll(massValue, kilogram, gram, centner, tonne, pound);

        Value meter = new Value("м", 1);
        Value kilometer = new Value("км", 1000);
        Value centimeter = new Value("см", 0.01);
        Value millimeter = new Value("мм", 0.001);
        Value inch = new Value("дюйм", 0.0254);
        Value mile = new Value("миля", 1609.344);

        Collections.addAll(lengthValue, meter, kilometer, centimeter, millimeter, inch, mile);

        // Объем, длина, масса, температура, скорость, время

        Collections.addAll(values, kilogram, gram, centner, tonne, pound, meter, kilometer, centimeter, millimeter, inch, mile);
    }

    public List<Value> getMassValue() {
        return massValue;
    }

    public List<Value> getLengthValue() {
        return lengthValue;
    }
}
