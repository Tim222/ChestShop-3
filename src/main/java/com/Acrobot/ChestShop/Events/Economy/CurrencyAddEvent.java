package com.Acrobot.ChestShop.Events.Economy;

import com.Acrobot.ChestShop.UUIDs.UUIDSaver;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.math.BigDecimal;

/**
 * Represents an addition of goods to entity
 *
 * @author Acrobot
 */
public class CurrencyAddEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    boolean added;

    private BigDecimal amount;
    private String target;
    private World world;

    public CurrencyAddEvent(BigDecimal amount, String target, World world) {
        this.amount = amount;
        this.target = target;
        this.world = world;
    }

    public CurrencyAddEvent(BigDecimal amount, Player target) {
        this(amount, UUIDSaver.getUsername(target.getUniqueId()), target.getWorld());
    }

    /**
     * @return Amount of currency
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * @return Amount of currency, as a double
     * @deprecated Use {@link #getAmount()} if possible
     */
    public double getDoubleAmount() {
        return amount.doubleValue();
    }

    /**
     * Sets the amount of currency transferred
     *
     * @param amount Amount to transfer
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * Sets the amount of currency transferred
     *
     * @param amount Amount to transfer
     * @deprecated Use {@link #setAmount(java.math.BigDecimal)} if possible
     */
    public void setAmount(double amount) {
        this.amount = BigDecimal.valueOf(amount);
    }

    /**
     * @return Was the money already added to the account?
     */
    public boolean isAdded() {
        return added;
    }

    /**
     * Set if the money was added to the account
     *
     * @param added Was the money added?
     */
    public void setAdded(boolean added) {
        this.added = added;
    }

    /**
     * @return The world in which the transaction occurs
     */
    public World getWorld() {
        return world;
    }

    /**
     * @return Account from which the currency is subtracted
     */
    public String getTarget() {
        return target;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
