package com.one.conversormoeda.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ConversaoDto {

    @SerializedName("conversion_result")
    BigDecimal resultadoConversao;
}
