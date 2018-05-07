package net.floodlightcontroller.trafficmonitor;

import java.util.Date;

import org.projectfloodlight.openflow.types.U64;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import net.floodlightcontroller.core.types.NodePortTuple;
import net.floodlightcontroller.trafficmonitor.web.EventSerializer;

@JsonSerialize(using=EventSerializer.class)
public class Event {
	private Date 				time;			
	private NodePortTuple 		source;			// 事件产生来源
	private U64					portSpeed;		// 端口的流量
	private U64					rxSpeed;		// 端口输入速率
	private U64					txSpeed;		// 端口输出速率
	private Policy				policy;			// 系统执行策略
	
	public Event(){
		time = new Date();
		source = null;
		portSpeed = rxSpeed = txSpeed = U64.ZERO;
		policy = null;
	}
	public Event(SwitchPortStatistics sps, Policy policy){
		time = new Date();
		source = new NodePortTuple(sps.getDpid(), sps.getPortNo());
		portSpeed = sps.getPortSpeed();
		rxSpeed = sps.getRxSpeed();
		txSpeed = sps.getTxSpeed();
		this.policy = policy;
	}
	
	
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public NodePortTuple getSource() {
		return source;
	}

	public void setSource(NodePortTuple source) {
		this.source = source;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public U64 getPortSpeed() {
		return portSpeed;
	}

	public void setPortSpeed(U64 portSpeed) {
		this.portSpeed = portSpeed;
	}

	public U64 getRxSpeed() {
		return rxSpeed;
	}

	public void setRxSpeed(U64 rxSpeed) {
		this.rxSpeed = rxSpeed;
	}

	public U64 getTxSpeed() {
		return txSpeed;
	}

	public void setTxSpeed(U64 txSpeed) {
		this.txSpeed = txSpeed;
	}

	
	
	public String description(){
		return "";
	}
	
	public String systemAction(){
		return "";
	}
	
}
