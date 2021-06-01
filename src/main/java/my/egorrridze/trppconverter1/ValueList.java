package my.egorrridze.trppconverter1;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ValueList {
    List<Value> massValue;
    List<Value> lengthValue;
    List<Value> volumeValue;
    List<Value> speedValue;
    List<Value> timeValue;
    List<Value> values;

    ValueList() {
        this.values = new ArrayList<>();

        this.massValue = new ArrayList<>();
        this.lengthValue = new ArrayList<>();
        this.volumeValue = new ArrayList<>();
        this.speedValue = new ArrayList<>();
        this.timeValue = new ArrayList<>();

        Value kilogram = new Value("кг", 1);
        Value gram = new Value("г", 0.001);
        Value centner = new Value("ц", 100);
        Value tonne = new Value("т", 1000);
        Value pound = new Value("фунтов",0.453592);

        Collections.addAll(massValue, kilogram, gram, centner, tonne, pound);


        Value meter = new Value("м", 1);
        Value kilometer = new Value("км", 1000);
        Value centimeter = new Value("см", 0.01);
        Value millimeter = new Value("мм", 0.001);
        Value inch = new Value("дюймов", 0.0254);
        Value mile = new Value("миль", 1609.344);

        Collections.addAll(lengthValue, meter, kilometer, centimeter, millimeter, inch, mile);


        Value cubic_meters = new Value("кубм", 1);
        Value litres = new Value("л", 0.001);
        Value cubic_centimeters = new Value("кубсм", 0.000001);
        Value pint = new Value("пинт", 0.000568);

        Collections.addAll(volumeValue, cubic_meters, litres, cubic_centimeters, pint);


        Value km_hours = new Value("км_ч", 1);
        Value m_second = new Value("м_с", 3.6);
        Value knot = new Value("узлов", 1.85184);
        Value m_hours = new Value("миль_ч", 1.6092);

        Collections.addAll(speedValue, km_hours, m_second, knot, m_hours);


        Value seconds = new Value("с", 1);
        Value minutes = new Value("мин", 60);
        Value hours = new Value("час", 3600);
        Value days = new Value("дней", 86400);
        Value years = new Value("лет", 31557600);

        Collections.addAll(timeValue, seconds, minutes, hours, days, years);


        Collections.addAll(values, kilogram, gram, centner, tonne, pound, meter, kilometer, centimeter, millimeter, inch, mile,
                cubic_meters, litres, cubic_centimeters, pint, km_hours, m_second, knot, m_hours, seconds, minutes, hours, days, years);
    }

    public List<Value> getMassValue() {
        return massValue;
    }

    public List<Value> getLengthValue() {
        return lengthValue;
    }

    public List<Value> getVolumeValue() {
        return volumeValue;
    }

    public List<Value> getSpeedValue() {
        return speedValue;
    }

    public List<Value> getTimeValue() {
        return timeValue;
    }
}
