package edu.miu.cs.cs489.citylibraryapp.dto.publisher;

import edu.miu.cs.cs489.citylibraryapp.dto.address.AddressRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record PublisherRequest(
        @NotBlank(message = "Publisher Name is required and cannot be null or empty string or blank spaces")
        String name,
        @Valid AddressRequest primaryAddress
    ) {
}
