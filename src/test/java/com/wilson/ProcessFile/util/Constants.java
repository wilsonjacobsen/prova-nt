package com.wilson.ProcessFile.util;

import java.util.stream.Stream;

public class Constants {
    public static Stream<String> stringStream = Stream.of(
            "001ç1234567891234çPedroç50000",
            "001ç3245678865434çPauloç40000.99",
            "002ç2345675434544345çJose da SilvaçRural",
            "002ç2345675433444345çEduardo PereiraçRural",
            "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro",
            "003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo"
    );
}
