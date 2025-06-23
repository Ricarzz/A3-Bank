package codigo;

import java.text.NumberFormat;
import java.util.Locale;

public class ConversorBR {
    public static double stringParaDouble(String valorStr) throws Exception {
        NumberFormat formatoBR = NumberFormat.getInstance(new Locale("pt", "BR"));
        Number numero = formatoBR.parse(valorStr);
        return numero.doubleValue();
    }   
}
