/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package textparser;

import collectData.BDNewsSinglePage;

/**
 *
 * @author yousufkhan
 */
public class Test {
    public static void main(String[] args) {
        String data = BDNewsSinglePage.getArticle("http://bangla.bdnews24.com/tech/article1014839.bdnews");
       // System.out.println(data);
    }
}
