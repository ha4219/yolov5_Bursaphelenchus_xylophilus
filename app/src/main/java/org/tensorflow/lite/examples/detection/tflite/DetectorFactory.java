package org.tensorflow.lite.examples.detection.tflite;

import android.content.res.AssetManager;

import java.io.IOException;

public class DetectorFactory {
    public static YoloV5Classifier getDetector(
            final AssetManager assetManager,
            final String modelFilename)
            throws IOException {
        String labelFilename = null;
        boolean isQuantized = false;
        int inputSize = 0;
        int[] output_width = new int[]{0};
        int[][] masks = new int[][]{{0}};
        int[] anchors = new int[]{0};

        if (modelFilename.equals("lite-model_yolo-v5-tflite_tflite_model_1.tflite")) {
            labelFilename = "file:///android_asset/coco.txt";
            isQuantized = false;
            inputSize = 320;
            output_width = new int[]{80, 40, 20};
            masks = new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
            anchors = new int[]{
                    10,13, 16,30, 33,23, 30,61, 62,45, 59,119, 116,90, 156,198, 373,326
            };
        }
        else if (modelFilename.equals("yolov5s-fp16.tflite")) {
            labelFilename = "file:///android_asset/coco.txt";
            isQuantized = false;
            inputSize = 320;
            output_width = new int[]{40, 20, 10};
            masks = new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
            anchors = new int[]{
                    10,13, 16,30, 33,23, 30,61, 62,45, 59,119, 116,90, 156,198, 373,326
            };
        }
        else if (modelFilename.equals("yolov5s-int8.tflite")) {
            labelFilename = "file:///android_asset/coco.txt";
            isQuantized = true;
            inputSize = 320;
            output_width = new int[]{40, 20, 10};
            masks = new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
            anchors = new int[]{
                    10,13, 16,30, 33,23, 30,61, 62,45, 59,119, 116,90, 156,198, 373,326
            };
        }
        else if (modelFilename.equals("best-fp16.tflite")) {
            labelFilename = "file:///android_asset/custom.txt";
            isQuantized = false;
            inputSize = 416;
            output_width = new int[]{52, 26, 13};
            masks = new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
            anchors = new int[]{
                    14,14, 24,23, 32,35, 47,47, 58,76, 95,75, 78,112, 118,117, 176,166
            };
        }
        else if (modelFilename.equals("best-int8.tflite")) {
            labelFilename = "file:///android_asset/custom.txt";
            isQuantized = true;
            inputSize = 416;
            output_width = new int[]{52, 26, 13};
            masks = new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
            anchors = new int[]{
                    14,14, 24,23, 32,35, 47,47, 58,76, 95,75, 78,112, 118,117, 176,166
            };
        }
        else if (modelFilename.equals("best640-fp16.tflite")) {
            labelFilename = "file:///android_asset/custom.txt";
            isQuantized = false;
            inputSize = 640;
            output_width = new int[]{80, 40, 20};
            masks = new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
            anchors = new int[]{
                    14,14, 24,23, 32,35, 47,47, 58,76, 95,75, 78,112, 118,117, 176,166
            };
        }
        else if (modelFilename.equals("best640-int8.tflite")) {
            labelFilename = "file:///android_asset/custom.txt";
            isQuantized = true;
            inputSize = 640;
            output_width = new int[]{80, 40, 20};
            masks = new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
            anchors = new int[]{
                    14,14, 24,23, 32,35, 47,47, 58,76, 95,75, 78,112, 118,117, 176,166
            };
        }
        return YoloV5Classifier.create(assetManager, modelFilename, labelFilename, isQuantized,
                inputSize);
    }

}
