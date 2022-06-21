import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

public class CountryName {
    public static void main(String[] args) {
        System.out.println(getCountryNameFromCode("BQ"));
        //System.out.println(getCountryNameFromCode("AF"));
        //System.out.println(getCountryNameFromCode("AE"));
        //System.out.println(getCountryNameFromCode("LL"));


        System.out.println(getCountryCodeFromName("Bolivia"));
        //System.out.println(getCountryCodeFromName("Afghanistan"));
        //System.out.println(getCountryCodeFromName("United Arab Emirates"));
        //System.out.println(getCountryCodeFromName("abcd"));
    }

    private static String getCountryNameFromCode(String code){
        String[] locales = Locale.getISOCountries();
        String countryName = null;
        if(Objects.nonNull(code)) {
            Locale filteredLocale = Arrays.stream(locales).filter(Objects::nonNull)
                    .map(locale -> new Locale("", locale))
                    .filter(locale -> locale.getCountry().equalsIgnoreCase(code))
                    .findFirst().orElse(null);
            if(Objects.nonNull(filteredLocale)){
                countryName = filteredLocale.getDisplayCountry(Locale.US);
            }
        }
        return countryName;
    }


    private static String getCountryCodeFromName(String name){
        String[] locales = Locale.getISOCountries();
        String countryCode = null;
        if(Objects.nonNull(name)) {
            Locale filteredLocale = Arrays.stream(locales).filter(Objects::nonNull)
                    .map(locale -> new Locale("", locale))
                    .filter(locale -> locale.getDisplayCountry().equalsIgnoreCase(name))
                    .findFirst().orElse(null);
            if(Objects.nonNull(filteredLocale)){
                countryCode = filteredLocale.getCountry();
            }
        }
        return countryCode;
    }
}
