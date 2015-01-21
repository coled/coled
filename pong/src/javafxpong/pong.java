package javafxpong;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;



public class pong {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

var position = 0;
var rev = 0;

var t = Timeline {
    repeatCount: Timeline.INDEFINITE
    keyFrames: [
        KeyFrame {
            time: 40ms
            action: function() {
                if (rev == 0) {
                    position1 = position1 + 10;
                }
                if (rev == 1) {
                    position1 = position1 - 10;
                }
                if (position1 > 860) {
                    rev =1;
                }
                if (position1 < 0) {
                    rev =0;
                }
            }
        }
    ]
};

var points = 0;
var ppp = bind points;
var pt: Timeline = Timeline {
    repeatCount: Timeline.INDEFINITE
    keyFrames: [
        KeyFrame {
            time: 100ms
            action: function() {
                points +=1;
                ptext.content = "Points {ppp}"
            }
        }
    ]
}

var t1: Timeline = Timeline {
    repeatCount: Timeline.INDEFINITE
    keyFrames: [
        KeyFrame {
            time: 40ms
            action: function() {
                if (position1 > recY and position > 1410)
                   {
                    if (position1 < recY + 100 and position > 1410)
                          {
                        rev1 = 1;
                        points+=20;
                    }
                }
                if (position1 > recY and position < 30)
                   {
                    if (position1 < recY + 100 and position < 30)
                          {
                        rev1 = 0;
                        points+=20;
                    }
                }
                if (rev1 == 0) {
                    position = position + 10;
                }
                if (rev1 == 1) {
                    position = position - 10;
                }
                if (position > 1440) {
                    rev1 =1;
                    lost();
                    reset();
                }
                if (position < 0) {
                    rev1 =0;
                    lost();
                    reset();
                }
            }
        }
    ]
};

function lost() {
    t.stop();
    t1.stop();
    pt.stop();
    tex.content = "PRESS ANY KEY TO CONTINUE\nYour Points were {points}";
    points =0;
}

function reset() {
    position1= 450;
    position = 720
}

var tex = Text {
    x: 550
    y: 390
    font: Font { size: 20
    }
    content: "WELCOME TO PONG"
}
var ptext = Text {
    x: 550
    y: 50
    font: Font { size: 20
    }
    content: ""
}
var rec1 = Rectangle {
    x: 0,
    y: bind recY;
    width: 20,
    height: 100
    fill: Color.BLACK
}
var rec2 = Rectangle {
    x: 1420,
    y: bind recY
    width: 20,
    height: 100
    fill: Color.BLACK
}

var recY = 300;
var position1 = 0;
var rev1 = 0;
Stage {
    title: "JavaFX Pong"
    width: 1440
    height: 250
    fullScreen: true;
    scene: Scene {
        fill: Color.TRANSPARENT;
        content: [
            Circle {
                onMouseDragged: function( e: MouseEvent ):Void {
                    position = e.sceneX as Integer;
                    println(e.x);
                    position1 = e.sceneY as Integer;
                    println(e.y);
                }
                onMousePressed: function( e: MouseEvent ):Void {
                    t.stop();
                    t1.stop();
                }
                onMouseReleased: function( e: MouseEvent ):Void {
                    t1.play();
                    t.play();
                }
                onKeyPressed: function( e: KeyEvent ):Void {
                    println(e.text);
                    if (e.text == "Up") {
                        if (recY > 0) {
                            recY-=30;
                        }
                    }
else if (e.text == "Down") {
                        if (recY < 800) {
                            recY+=30;
                        }
                    }
else
{
                        if (not t.running){
                            t.play();
                            t1.play();
                            pt.play();
                            tex.content = "";
                        }
                    }
                }
                centerX: 0,
                centerY: 0,
                translateX: bind position,
                translateY: bind position1,
                radius: 20
                fill: RadialGradient {
                    centerX: 0
                    centerY: 0
                    focusX: 0.1
                    focusY: 0.1
                    radius: 21
                    proportional: false
                    stops: [
                        Stop {
                            color: Color.RED
                            offset: 0.0
                        },
                        Stop {
                            color: Color.BLACK
                            offset: 1.0
                        },
                    ]
                }
            }
        ,tex,rec1,rec2,ptext]
    }
}
		
		
		
		
	}

}
