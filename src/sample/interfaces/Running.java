package sample.interfaces;

import javafx.scene.image.ImageView;

import java.util.List;

public interface Running {

    default void run(ImageView player1Img, ImageView player2Img,List<ImageView> levelList,boolean runLeftP1,boolean canJumpP1,
                     int crossCountP1,int MAX_DOWN, boolean flyDownP1,boolean runRightP1,boolean runLeftP2,boolean canJumpP2,
                     boolean flyDownP2,int crossCountP2,boolean runRightP2,int levelP1,boolean inJumpP1,int FIRST_STAGE,int yP1,
                     boolean flyUpP1,boolean inJumpP2,boolean flyUpP2,int levelP2,int yP2){
//todo Player1
        if (runLeftP1) {
            player1Img.relocate(player1Img.getLayoutX()-8, player1Img.getLayoutY());
            for (ImageView image:levelList){
                if (canJumpP1 && player1Img.getBoundsInParent().intersects(image.getBoundsInParent()) && player1Img.getLayoutY()<MAX_DOWN)
                    crossCountP1++;}
            if (player1Img.getLayoutY() != MAX_DOWN && canJumpP1 && crossCountP1 == 0) {
                flyDownP1 = true;
                canJumpP1 = false;}
            crossCountP1 = 0;
        }
        if (runRightP1){
            player1Img.relocate(player1Img.getLayoutX()+8, player1Img.getLayoutY());
            for (ImageView image:levelList){
                if (canJumpP1 && player1Img.getBoundsInParent().intersects(image.getBoundsInParent()) && player1Img.getLayoutY()<MAX_DOWN)
                    crossCountP1++;}
            if (player1Img.getLayoutY() != MAX_DOWN && canJumpP1 && crossCountP1 == 0) {
                flyDownP1 = true;
                canJumpP1 = false;}
            crossCountP1 = 0;
        }
        //todo Player2
        if (runLeftP2) {
            player2Img.relocate(player2Img.getLayoutX()-8, player2Img.getLayoutY());
            for (ImageView image:levelList){
                if (canJumpP2 && player2Img.getBoundsInParent().intersects(image.getBoundsInParent()) && player2Img.getLayoutY()<MAX_DOWN)
                    crossCountP2++;}
            if (player2Img.getLayoutY() != MAX_DOWN && canJumpP2 && crossCountP2 == 0) {
                flyDownP2 = true;
                canJumpP2 = false;}
            crossCountP2 = 0;
        }
        if (runRightP2){
            player2Img.relocate(player2Img.getLayoutX()+8, player2Img.getLayoutY());
            for (ImageView image:levelList){
                if (canJumpP2 && player2Img.getBoundsInParent().intersects(image.getBoundsInParent()) && player2Img.getLayoutY()<MAX_DOWN)
                    crossCountP2++;}
            if (player2Img.getLayoutY() != MAX_DOWN && canJumpP2 && crossCountP2 == 0) {
                flyDownP2 = true;
                canJumpP2 = false;}
            crossCountP2 = 0;
        }
        //todo Player1
        if (inJumpP1 && flyUpP1){
            System.out.println(player1Img.getLayoutY()+" 1c");
            player1Img.relocate(player1Img.getLayoutX(), player1Img.getLayoutY()-8);
            levelP1 +=8;
            System.out.println(levelP1 +" level");
            if (levelP1 >= 230) {
                System.out.println("верх прыжка"); flyUpP1 = false;
                flyDownP1 = true; } }
//падение
        if (flyDownP1){
            System.out.println(player1Img.getLayoutY()+" начинаемвниз");
            System.out.println(levelP1 +" level");
            player1Img.relocate(player1Img.getLayoutX(), player1Img.getLayoutY()+7);
            levelP1 -=7;
            for (ImageView image:levelList){
                if (player1Img.getBoundsInParent().intersects(image.getBoundsInParent()) &&
                        image.getLayoutY()>= player1Img.getLayoutY()+40 && levelP1 >=0)
                {
                    player1Img.setY(image.getTranslateY());
                    levelP1 =0;
                    inJumpP1 = false;
                    flyDownP1 = false;
                    canJumpP1 = true; System.out.println(levelP1 +" level before jump");break;}
                if (player1Img.getLayoutY()<FIRST_STAGE && !player1Img.getBoundsInParent().intersects(image.getBoundsInParent()) && levelP1 <=0)
                {
                    levelP1 =230;}
                if (player1Img.getLayoutY()>=MAX_DOWN)
                {
                    player1Img.setLayoutY(yP1);
                    levelP1 = 0;
                    inJumpP1 = false;
                    flyDownP1 = false;
                    canJumpP1 = true;}}
        }
        //todo Player2
        if (inJumpP2 && flyUpP2){
            System.out.println(player2Img.getLayoutY()+" 1c");
            player2Img.relocate(player2Img.getLayoutX(), player2Img.getLayoutY()-8);
            levelP2 +=8;
            System.out.println(levelP2 +" level");
            if (levelP2 >= 230) {
                System.out.println("верх прыжка"); flyUpP2 = false;
                flyDownP2 = true; } }
//падение
        if (flyDownP2){
            System.out.println(player2Img.getLayoutY()+" начинаемвниз");
            System.out.println(levelP2 +" level");
            player2Img.relocate(player2Img.getLayoutX(), player2Img.getLayoutY()+7);
            levelP2 -=7;
            for (ImageView image:levelList){
                if (player2Img.getBoundsInParent().intersects(image.getBoundsInParent()) &&
                        image.getLayoutY()>= player2Img.getLayoutY()+40 && levelP2 >=0)
                {
                    player2Img.setY(image.getTranslateY());
                    levelP2 =0;
                    inJumpP2 = false;
                    flyDownP2 = false;
                    canJumpP2 = true; System.out.println(levelP2 +" level before jump");break;}
                if (player2Img.getLayoutY()<FIRST_STAGE && !player2Img.getBoundsInParent().intersects(image.getBoundsInParent()) && levelP2 <=0)
                {
                    levelP2 =230;}
                if (player2Img.getLayoutY()>=MAX_DOWN)
                {
                    player2Img.setLayoutY(yP2);
                    levelP2 = 0;
                    inJumpP2 = false;
                    flyDownP2 = false;
                    canJumpP2 = true;}}
        }
    }

//   default void jump(ImageView player1Img,ImageView player2Img,List<ImageView> levelList,boolean inJumpP1,boolean flyUpP1,int levelP1,
//                     boolean flyDownP1,boolean canJumpP1,int FIRST_STAGE,int MAX_DOWN,int yP1,boolean inJumpP2,boolean flyUpP2,
//                     boolean flyDownP2,int levelP2,boolean canJumpP2,int yP2){
//       //todo Player1
//       if (inJumpP1 && flyUpP1){
//           System.out.println(player1Img.getLayoutY()+" 1c");
//           player1Img.relocate(player1Img.getLayoutX(), player1Img.getLayoutY()-8);
//           levelP1 +=8;
//           System.out.println(levelP1 +" level");
//           if (levelP1 >= 230) {
//               System.out.println("верх прыжка"); flyUpP1 = false;
//               flyDownP1 = true; } }
////падение
//       if (flyDownP1){
//           System.out.println(player1Img.getLayoutY()+" начинаемвниз");
//           System.out.println(levelP1 +" level");
//           player1Img.relocate(player1Img.getLayoutX(), player1Img.getLayoutY()+7);
//           levelP1 -=7;
//           for (ImageView image:levelList){
//               if (player1Img.getBoundsInParent().intersects(image.getBoundsInParent()) &&
//                       image.getLayoutY()>= player1Img.getLayoutY()+40 && levelP1 >=0)
//               {
//                   player1Img.setY(image.getTranslateY());
//                   levelP1 =0;
//                   inJumpP1 = false;
//                   flyDownP1 = false;
//                   canJumpP1 = true; System.out.println(levelP1 +" level before jump");break;}
//               if (player1Img.getLayoutY()<FIRST_STAGE && !player1Img.getBoundsInParent().intersects(image.getBoundsInParent()) && levelP1 <=0)
//               {
//                   levelP1 =230;}
//               if (player1Img.getLayoutY()>=MAX_DOWN)
//               {
//                   player1Img.setLayoutY(yP1);
//                   levelP1 = 0;
//                   inJumpP1 = false;
//                   flyDownP1 = false;
//                   canJumpP1 = true;}}
//       }
//       //todo Player2
//       if (inJumpP2 && flyUpP2){
//           System.out.println(player2Img.getLayoutY()+" 1c");
//           player2Img.relocate(player2Img.getLayoutX(), player2Img.getLayoutY()-8);
//           levelP2 +=8;
//           System.out.println(levelP2 +" level");
//           if (levelP2 >= 230) {
//               System.out.println("верх прыжка"); flyUpP2 = false;
//               flyDownP2 = true; } }
////падение
//       if (flyDownP2){
//           System.out.println(player2Img.getLayoutY()+" начинаемвниз");
//           System.out.println(levelP2 +" level");
//           player2Img.relocate(player2Img.getLayoutX(), player2Img.getLayoutY()+7);
//           levelP2 -=7;
//           for (ImageView image:levelList){
//               if (player2Img.getBoundsInParent().intersects(image.getBoundsInParent()) &&
//                       image.getLayoutY()>= player2Img.getLayoutY()+40 && levelP2 >=0)
//               {
//                   player2Img.setY(image.getTranslateY());
//                   levelP2 =0;
//                   inJumpP2 = false;
//                   flyDownP2 = false;
//                   canJumpP2 = true; System.out.println(levelP2 +" level before jump");break;}
//               if (player2Img.getLayoutY()<FIRST_STAGE && !player2Img.getBoundsInParent().intersects(image.getBoundsInParent()) && levelP2 <=0)
//               {
//                   levelP2 =230;}
//               if (player2Img.getLayoutY()>=MAX_DOWN)
//               {
//                   player2Img.setLayoutY(yP2);
//                   levelP2 = 0;
//                   inJumpP2 = false;
//                   flyDownP2 = false;
//                   canJumpP2 = true;}}
//       }
//   }
}
