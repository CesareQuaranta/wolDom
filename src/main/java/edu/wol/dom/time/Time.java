package edu.wol.dom.time;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: cesare
 * Date: 20/08/12
 * Time: 14.02
 * To change this template use File | Settings | File Templates.
 */
public class Time implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected long time;
	private iTimeManager<?> timeManager;

    public Time(iTimeManager<?> tm,long time){
    	this.timeManager=tm;
        this.time = time;
    }

    public long getTime(){
        return time;
    }
}
