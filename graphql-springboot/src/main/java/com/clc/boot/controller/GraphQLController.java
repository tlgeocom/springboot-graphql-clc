package com.clc.boot.controller;

import graphql.ExecutionResult;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * ClassName: GraphQLController<br/>
 * Description: <br/>
 * date: 2019/6/28 5:38 PM<br/>
 *
 * @author chengluchao
 * @since JDK 1.8
 */
@RequestMapping("graphql")
@Controller
public class GraphQLController {
    @Autowired
    private GraphQL graphQL;

    @RequestMapping("query")
    @ResponseBody
    public Object query(@RequestParam("query") String query) {
        ExecutionResult result = this.graphQL.execute(query);
        return result.toSpecification();
    }
}
