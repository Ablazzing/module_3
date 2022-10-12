package org.example.homework2_ToadBundy;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PhoneDto {
    String number;
    Boolean isGovernment;
    PhoneType phoneType;
    String clientFio;

}
