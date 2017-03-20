package com.lucky;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Hello world!
 */
public class App {


    public static void main(String[] args) {

        try {
            File xml = new File("/Users/lucky/java/AndroidDimenAdapterTool/src/main/java/com/lucky/file/dimens.xml");
            Document document = Jsoup.parse(xml, "utf-8");
            Elements nodes = document.getElementsByTag("dimen");
            for (Element ele :
                    nodes) {

                String name = ele.attr("name");
                String value = ele.text();

//                换算
                String valueNum = value
                        .substring(0, value.length() - 2);


                double v = Integer.valueOf(valueNum) / 1.5;

                String resultNum = "";
                if (value.endsWith("dp")) {
                    resultNum = (int) Math.rint(v) + "dp";
                } else if (value.endsWith("sp")) {
                    resultNum = (int) Math.rint(v) + "sp";
                }
                String line = "<dimen name=\"" + name + "\">" + resultNum+"</dimen>";
//                System.out.println(resultNum);
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
