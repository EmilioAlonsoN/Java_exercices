/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

/*
 * Lab - Composition
 * 
 * The Tuner class handles some of the internal functionality that a Television uses.
 * It has the ability to get and set a channel (a String).  Internally, it converts the channel to
 * a "tuner frequency" which in this implementation is a simple placeholder created 
 * by getting the hashcode of the channel string.  
 */

package com.entertainment;

class Tuner {
  private String channel = "Menu";
  private int station;  // internal tuner frequency for the named channel

  public void setChannel(String channel) {
    this.channel = channel;
    findStation(channel);
    goToStation();
  }

  public String getChannel() {
    return channel;
  }

  private void findStation(String channel) {
    station = channel.hashCode();
  }

  private void goToStation() {
    System.out.println("Tuner - going to station: " + station);
  }
}