package com.kaisersakhi.graphs;

public class GraphException extends Exception{
    protected String msg;
    public GraphException(){
        this.msg = "GraphException";
    }
    public GraphException(String msg){
        this.msg = msg;
    }
    @Override
    public String getMessage(){
        return msg;
    }
}
