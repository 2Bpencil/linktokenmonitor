package com.tyf.linktokenmonitor.code.utils;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * @Auther: tyf
 * @Date: 2019/7/5 17:09
 * @Description: 链克查询工具
 */
public class LinkTokenQueryUtil {

    public static void main(String[] args) {
        try {
            WebClient wc = new WebClient(BrowserVersion.CHROME);
            wc.getOptions().setUseInsecureSSL(true);
            wc.getOptions().setJavaScriptEnabled(true); // 启用JS解释器，默认为true
            wc.getOptions().setCssEnabled(false); // 禁用css支持
            wc.getOptions().setThrowExceptionOnScriptError(false); // js运行错误时，是否抛出异常
            wc.getOptions().setTimeout(10000); // 设置连接超时时间 ，这里是10S。如果为0，则无限期等待
            wc.getOptions().setDoNotTrackEnabled(false);
            wc.getOptions().setThrowExceptionOnFailingStatusCode(false);
            HtmlPage page = wc.getPage("https://explorer.lianxiangcloud.com/#/address/0x760d8de7dda521df6f38dc73620f341b0a1ea3c0");
            wc.waitForBackgroundJavaScript(4000);
            DomNodeList<DomElement> links = page.getElementsByTagName("");
            HtmlElement html = page.getDocumentElement();

            for (DomElement link : links) {
                String data = link.asText();
                System.out.println("data======================>>>"+data);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
