package ru.job4j.pingpong;

import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {
  private final Rectangle rect;
  private double velocityX;
  private double velocityY;
  private final int limitX = 300;
  private final int limitY = 300;
  private final int multiplier = 2;

  public RectangleMove(Rectangle rect) {
    this.rect = rect;
    this.velocityX = multiplier * (Math.random() - 1);
    this.velocityY = multiplier * (Math.random() - 1);
  }


  private void changePosition() {
    updateX();
    updateY();
  }

  private void updateX() {
    double x = this.rect.getX();
    if (x < 0 || x + this.rect.getWidth() > limitX) {
      velocityX *= -1;
    }
    this.rect.setX(x + velocityX);

  }

  private void updateY() {
    double y = this.rect.getY();
    if (y < 0 || y + this.rect.getHeight() > limitY) {
      velocityY *= -1;
    }
    this.rect.setY(y + velocityY);

  }

  @Override
  public void run() {
    while (true) {
        changePosition();
      try {
        Thread.sleep(50);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
