package edu.miu.cs.cs489.lesson7.citylibraryapp.dto.publisher;

import edu.miu.cs.cs489.lesson7.citylibraryapp.dto.address.AddressResponse;

public record PublisherResponse(
        Integer publisherId,
        String name,
        AddressResponse primaryAddress
        ) {
}
