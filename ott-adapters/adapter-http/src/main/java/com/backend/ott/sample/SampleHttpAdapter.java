package com.backend.ott.sample;

import org.springframework.stereotype.Repository;

@Repository
public class SampleHttpAdapter implements SamplePort{
    @Override
    public SamplePortResponse getSample() {
        return new SamplePortResponse("Hello World");
    }
}
