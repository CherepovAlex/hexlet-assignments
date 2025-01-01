package exercise;

public class Address {
    // BEGIN
    @NotNull(name = "country", description = "can not be null")
    @MinLength(minLength = 4)
    // END
    private String country;

    // BEGIN
    @NotNull(name = "city", description = "cannot be null")
    @MinLength(minLength = 4)
    // END
    private String city;

    // BEGIN
    @NotNull(name = "street", description = "cannot be null")
    @MinLength(minLength = 4)
    // END
    private String street;

    // BEGIN
    @NotNull(name = "houseNumber", description = "cannot be null")
    @MinLength(minLength = 4)
    // END
    private String houseNumber;

    @MinLength(minLength = 4)
    private String flatNumber;

    public Address(String country, String city, String street, String houseNumber, String flatNumber) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
    }
}
