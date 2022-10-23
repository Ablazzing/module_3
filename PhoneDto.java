package org.example;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;
import lombok.Value;

@Value
public class PhoneDto {
 @NonNull
String number;
 @ToString.Exclude
boolean isGovernment ;
@NonNull
@ToString.Exclude
PhoneType phoneType;
String clientFio;
}
