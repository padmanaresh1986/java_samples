import java.util.Arrays;
import java.util.Objects;

public enum CountryCodesEnum {

    AF("Afghanistan"),
    AX("Aland Islands");

    String countryName;
    private CountryCodesEnum(String countryName){
        this.countryName   = countryName;
    }

    public static CountryCodesEnum getCountryCodeEnumFromCountryName(String name){
        CountryCodesEnum[] values = CountryCodesEnum.values();
        return Arrays.stream(values).filter(Objects::nonNull)
                .filter(countryCodesEnum -> countryCodesEnum.countryName.equalsIgnoreCase(name))
                .findFirst().orElse(null);
    }

    public static CountryCodesEnum getCountryCodeEnumFromCode(String code){
        CountryCodesEnum[] values = CountryCodesEnum.values();
        return Arrays.stream(values).filter(Objects::nonNull)
                .filter(countryCodesEnum -> countryCodesEnum.name().equalsIgnoreCase(code))
                .findFirst().orElse(null);
    }

    /**
     *  System.out.println(CountryCodesEnum.getCountryCodeEnumFromCountryName("Afghanistan").name());
     *  System.out.println(CountryCodesEnum.getCountryCodeEnumFromCode("AF").countryName);
     */

}
