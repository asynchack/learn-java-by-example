package org.example.constructordi.domain;

/**
 * @author bo.wang
 * @version V1.0
 * @Package org.example.constructordi.domain
 * @date 2024/3/5 08:31
 */
public class Engine {

        private final String type;
        private final int volume;

        public Engine(String type, int volume) {
            this.type = type;
            this.volume = volume;

        }

        @Override
        public String toString() { return String.format("%s, %d", type, volume); }
}


