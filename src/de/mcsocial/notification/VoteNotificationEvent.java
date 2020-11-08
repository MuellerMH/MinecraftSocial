package de.mcsocial.notification;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class VoteNotificationEvent extends Event {
	private static final HandlerList handlers = new HandlerList();
	private VoteNotify vote;
	public VoteNotify getVote(){
		return vote;
	}
	public VoteNotificationEvent(final VoteNotify vote) {
		this.vote = vote;
	}
	@Override
	public HandlerList getHandlers() {

		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
}
