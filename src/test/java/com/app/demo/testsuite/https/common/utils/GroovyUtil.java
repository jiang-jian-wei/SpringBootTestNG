package com.app.demo.testsuite.https.common.utils;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

public class GroovyUtil {
    public static void main(String[] args) {
        Binding binding = new Binding();
        binding.setProperty("name","张三");

        GroovyShell shell = new GroovyShell(binding);
        String expression = "'abc'.concat('DEF').concat(binding.getProperty('name'))";
        System.out.println(expression);
        String result = shell.evaluate(expression).toString();
        System.out.println(result);

    }
}
