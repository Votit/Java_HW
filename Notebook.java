import java.util.HashMap;
import java.util.Map;

public class Notebook {

    int serialNumber;

    Map<String, String> parameters = new HashMap<>();

    public void fillingWithInformation(int serialNum, String manufacturer, String model, String operatingSystem,
            String color, String screenDiagonal, String processorModel, String ram, String ssd, String videoCard) {
        serialNumber = serialNum;
        parameters.put("Manufacturer", manufacturer);
        parameters.put("Model", model);
        parameters.put("Operation system", operatingSystem);
        parameters.put("Color", color);
        parameters.put("Screen Diagonal", screenDiagonal);
        parameters.put("Processor model", processorModel);
        parameters.put("RAM", ram);
        parameters.put("SSD", ssd);
        parameters.put("Video card", videoCard);
    }

    @Override
    public String toString() {
        String result = "";

        for (var elem : parameters.entrySet()) {
            result += String.format("%s: %s\n", elem.getKey(), elem.getValue());
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        var e = (Notebook) obj;
        return serialNumber == e.serialNumber;
    }

    @Override
    public int hashCode() {
        return serialNumber;
    }
}