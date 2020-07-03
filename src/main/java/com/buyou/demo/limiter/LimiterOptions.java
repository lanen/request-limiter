package com.buyou.demo.limiter;


/**
 *
 */
public interface LimiterOptions {

    /**
     *
     * @return
     */
    int getInitSemaphorePermits ();

    class Key {
        private String name;

        private Object defaultValue;

        public Key(String name, Object defaultValue) {
            this.name = name;
            this.defaultValue = defaultValue;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getDefaultValue() {
            return defaultValue;
        }

        public void setDefaultValue(Object defaultValue) {
            this.defaultValue = defaultValue;
        }
    }

}
