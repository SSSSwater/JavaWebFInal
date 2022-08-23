//package com.example.faceRecognition;
//import ai.djl.inference.Predictor;
//import ai.djl.modality.cv.Image;
//import ai.djl.modality.cv.ImageFactory;
//import ai.djl.modality.cv.output.DetectedObjects;
//import ai.djl.modality.cv.transform.Normalize;
//import ai.djl.modality.cv.transform.Resize;
//import ai.djl.modality.cv.transform.ToTensor;
//import ai.djl.repository.zoo.Criteria;
//import ai.djl.repository.zoo.ModelNotFoundException;
//import ai.djl.translate.*;
//import org.bytedeco.javacv.Java2DFrameUtils;
//import ai.djl.repository.zoo.ModelZoo;
//import ai.djl.repository.zoo.ZooModel;
//import ai.djl.training.util.ProgressBar;
//import ai.djl.modality.cv.output.BoundingBox;
//import ai.djl.modality.cv.output.Landmark;
//import ai.djl.modality.cv.output.Rectangle;
//import ai.djl.ndarray.NDArray;
//import ai.djl.ndarray.NDArrays;
//import ai.djl.ndarray.NDList;
//import ai.djl.ndarray.NDManager;
//import ai.djl.ndarray.types.DataType;
//import ai.djl.ndarray.types.Shape;
//
//import java.awt.image.BufferedImage;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import org.bytedeco.opencv.opencv_core.Mat;
////import org.bytedeco.javacpp.opencv_core.Point;
//import ai.djl.modality.cv.output.Point;
//
//
//import org.bytedeco.opencv.opencv_core.Point2f;
//import org.bytedeco.opencv.opencv_core.Rect;
//import org.bytedeco.opencv.opencv_core.Scalar;
//import org.bytedeco.opencv.opencv_core.Size;
//
//import java.util.List;
//
//import static org.bytedeco.opencv.global.opencv_core.*;
//import static org.bytedeco.opencv.global.opencv_imgproc.*;
//import static org.bytedeco.opencv.global.opencv_imgcodecs.*;
//
//public class FaceDetection {
//    private ZooModel<Image, DetectedObjects> model = null;
//
//    public FaceDetection(){
//        double confThresh = 0.85f;
//        String model_path = "model/retinaface.zip";
//
//        double nmsThresh = 0.45f;
//        double[] variance = {0.1f, 0.2f};
//        int topK = 5000;
//        int[][] scales = {{16, 32}, {64, 128}, {256, 512}};
//        int[] steps = {8, 16, 32};
//        FaceDetectionTranslator translator =
//                new FaceDetectionTranslator(confThresh, nmsThresh, variance, topK, scales, steps);
//
//
//
//        Criteria<Image, DetectedObjects> criteria = Criteria.builder().setTypes(Image.class, DetectedObjects.class)
//                .optModelUrls(model_path)
//                .optModelName("retinaface")
//                .optTranslator(translator)
//                .optProgress(new ProgressBar())
//                .optEngine("PyTorch") // Use PyTorch engine
//                .build();
//        try {
//            model = ModelZoo.loadModel(criteria);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }
//
//    public List<Image>faceDetection(Image img,boolean isrect, Mat mat_img){
//        List<Image>faces= new ArrayList();
//        Predictor<Image, DetectedObjects> predictor = model.newPredictor();
//        try {
//            DetectedObjects detection = predictor.predict(img);
//            for(int i = 0; i < detection.getNumberOfObjects(); i++) {
//                DetectedObjects.DetectedObject box = detection.item(i);
//                double similar = box.getProbability();
////				System.out.println("检测到人脸，相似度=" + similar);
//                double x = img.getWidth() * box.getBoundingBox().getBounds().getX();
//                double y = img.getHeight() * box.getBoundingBox().getBounds().getY();
//                double w = img.getWidth() * box.getBoundingBox().getBounds().getWidth();
//                double h = img.getHeight() * box.getBoundingBox().getBounds().getHeight();
//
//                if(w != h) {
//                    //需要做等比例
//                    if(h < w) {
//                        double xd = (h - w) / 2;
//                        w = h;
//                        x = x - xd;
//                    }else {
//                        double yd = w - h;
//                        h = w;
//                        y = y - yd;
//                    }
//                }
//
//
//                //截取人脸区域
//                if(mat_img != null) {
//                    //mat上截取人脸
//                    Mat face = new Mat();
//                    double size = w>h?w:h;
//                    getRectSubPix(mat_img, new Size((int)size, (int)size), new Point2f((int) (x + w/2), (int) (y + h/2)), face);
//                    BufferedImage bimg = Java2DFrameUtils.toBufferedImage(face);
//                    //转DJL img
//                    Image face_img = ImageFactory.getInstance().fromImage(bimg);
//                    faces.add(face_img);
//                    face.close();
//                }else {
//                    try {
//                        Image face = img.getSubImage((int)x, (int)y, (int)w, (int)h);
//                        faces.add(face);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//
//            }
//
//
//        }
//        catch (TranslateException e){
//            e.printStackTrace();
//        }
//        predictor.close();
//        return faces;
//    }
//}
//
//class FeatureExtraction{
//    ZooModel<Image, float[]> model = null;
//    String model_path = "model/face_feature.zip";
//    public FeatureExtraction(){
//        Criteria<Image, float[]> criteria =
//                Criteria.builder()
//                        .setTypes(Image.class, float[].class)
//                        .optModelUrls(model_path)
//                        .optModelName("face_feature") // specify model file prefix
//                        .optTranslator(new FaceFeatureTranslator())
//                        .optProgress(new ProgressBar())
//                        .optEngine("PyTorch") // Use PyTorch engine
//                        .build();
//        try {
//            model = ModelZoo.loadModel(criteria);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public float[]faceFeatureExtraction(Image img) {
//        Predictor<Image, float[]> predictor = model.newPredictor();
//        float[] faceFeature = null;
//        try {
//            faceFeature = predictor.predict(img);
//        } catch (TranslateException e) {
//            e.printStackTrace();
//        }finally {
//            //关闭预测者
//            predictor.close();
//        }
//        return faceFeature;
//    }
//
//}
//
//class FaceDetectionTranslator implements Translator<Image, DetectedObjects> {
//
//    private double confThresh;
//    private double nmsThresh;
//    private int topK;
//    private double[] variance;
//    private int[][] scales;
//    private int[] steps;
//    private int width;
//    private int height;
//
//    public FaceDetectionTranslator(
//            double confThresh,
//            double nmsThresh,
//            double[] variance,
//            int topK,
//            int[][] scales,
//            int[] steps) {
//        this.confThresh = confThresh;
//        this.nmsThresh = nmsThresh;
//        this.variance = variance;
//        this.topK = topK;
//        this.scales = scales;
//        this.steps = steps;
//    }
//
//    /** {@inheritDoc} */
//    @Override
//    public NDList processInput(TranslatorContext ctx, Image input) {
//        width = input.getWidth();
//        height = input.getHeight();
//        NDArray array = input.toNDArray(ctx.getNDManager(), Image.Flag.COLOR);
//        array = array.transpose(2, 0, 1).flip(0); // HWC -> CHW RGB -> BGR
//        // The network by default takes float32
//        if (!array.getDataType().equals(DataType.FLOAT32)) {
//            array = array.toType(DataType.FLOAT32, false);
//        }
//        NDArray mean =
//                ctx.getNDManager().create(new float[] {104f, 117f, 123f}, new Shape(3, 1, 1));
//        array = array.sub(mean);
//        return new NDList(array);
//    }
//
//    /** {@inheritDoc} */
//    @Override
//    public DetectedObjects processOutput(TranslatorContext ctx, NDList list) {
//        NDManager manager = ctx.getNDManager();
//        double scaleXY = variance[0];
//        double scaleWH = variance[1];
//
//        NDArray prob = list.get(1).get(":, 1:");
//        prob =
//                NDArrays.stack(
//                        new NDList(
//                                prob.argMax(1).toType(DataType.FLOAT32, false),
//                                prob.max(new int[] {1})));
//
//        NDArray boxRecover = boxRecover(manager, width, height, scales, steps);
//        NDArray boundingBoxes = list.get(0);
//        NDArray bbWH = boundingBoxes.get(":, 2:").mul(scaleWH).exp().mul(boxRecover.get(":, 2:"));
//        NDArray bbXY =
//                boundingBoxes
//                        .get(":, :2")
//                        .mul(scaleXY)
//                        .mul(boxRecover.get(":, 2:"))
//                        .add(boxRecover.get(":, :2"))
//                        .sub(bbWH.mul(0.5f));
//
//        boundingBoxes = NDArrays.concat(new NDList(bbXY, bbWH), 1);
//
//        NDArray landms = list.get(2);
//        landms = decodeLandm(landms, boxRecover, scaleXY);
//
//        // filter the result below the threshold
//        NDArray cutOff = prob.get(1).gt(confThresh);
//        boundingBoxes = boundingBoxes.transpose().booleanMask(cutOff, 1).transpose();
//        landms = landms.transpose().booleanMask(cutOff, 1).transpose();
//        prob = prob.booleanMask(cutOff, 1);
//
//        // start categorical filtering
//        long[] order = prob.get(1).argSort().get(":" + topK).toLongArray();
//        prob = prob.transpose();
//        List<String> retNames = new ArrayList<>();
//        List<Double> retProbs = new ArrayList<>();
//        List<BoundingBox> retBB = new ArrayList<>();
//
//        Map<Integer, List<BoundingBox>> recorder = new ConcurrentHashMap<>();
//
//        for (int i = order.length - 1; i >= 0; i--) {
//            long currMaxLoc = order[i];
//            float[] classProb = prob.get(currMaxLoc).toFloatArray();
//            int classId = (int) classProb[0];
//            double probability = classProb[1];
//
//            double[] boxArr = boundingBoxes.get(currMaxLoc).toDoubleArray();
//            double[] landmsArr = landms.get(currMaxLoc).toDoubleArray();
//            Rectangle rect = new Rectangle(boxArr[0], boxArr[1], boxArr[2], boxArr[3]);
//            List<BoundingBox> boxes = recorder.getOrDefault(classId, new ArrayList<>());
//            boolean belowIoU = true;
//            for (BoundingBox box : boxes) {
//                if (box.getIoU(rect) > nmsThresh) {
//                    belowIoU = false;
//                    break;
//                }
//            }
//            if (belowIoU) {
//                List<Point> keyPoints = new ArrayList<>();
//                for (int j = 0; j < 5; j++) { // 5 face landmarks
//                    double x = landmsArr[j * 2];
//                    double y = landmsArr[j * 2 + 1];
//                    keyPoints.add(new Point( x * width,  y * height));
//                }
//                Landmark landmark =
//                        new Landmark(boxArr[0], boxArr[1], boxArr[2], boxArr[3], keyPoints);
//
//                boxes.add(landmark);
//                recorder.put(classId, boxes);
//                String className = "Face"; // classes.get(classId)
//                retNames.add(className);
//                retProbs.add(probability);
//                retBB.add(landmark);
//            }
//        }
//
//        return new DetectedObjects(retNames, retProbs, retBB);
//    }
//
//    private NDArray boxRecover(
//            NDManager manager, int width, int height, int[][] scales, int[] steps) {
//        int[][] aspectRatio = new int[steps.length][2];
//        for (int i = 0; i < steps.length; i++) {
//            int wRatio = (int) Math.ceil((float) width / steps[i]);
//            int hRatio = (int) Math.ceil((float) height / steps[i]);
//            aspectRatio[i] = new int[] {hRatio, wRatio};
//        }
//
//        List<double[]> defaultBoxes = new ArrayList<>();
//
//        for (int idx = 0; idx < steps.length; idx++) {
//            int[] scale = scales[idx];
//            for (int h = 0; h < aspectRatio[idx][0]; h++) {
//                for (int w = 0; w < aspectRatio[idx][1]; w++) {
//                    for (int i : scale) {
//                        double skx = i * 1.0 / width;
//                        double sky = i * 1.0 / height;
//                        double cx = (w + 0.5) * steps[idx] / width;
//                        double cy = (h + 0.5) * steps[idx] / height;
//                        defaultBoxes.add(new double[] {cx, cy, skx, sky});
//                    }
//                }
//            }
//        }
//
//        double[][] boxes = new double[defaultBoxes.size()][defaultBoxes.get(0).length];
//        for (int i = 0; i < defaultBoxes.size(); i++) {
//            boxes[i] = defaultBoxes.get(i);
//        }
//        return manager.create(boxes).clip(0.0, 1.0);
//    }
//
//    // decode face landmarks, 5 points per face
//    private NDArray decodeLandm(NDArray pre, NDArray priors, double scaleXY) {
//        NDArray point1 =
//                pre.get(":, :2").mul(scaleXY).mul(priors.get(":, 2:")).add(priors.get(":, :2"));
//        NDArray point2 =
//                pre.get(":, 2:4").mul(scaleXY).mul(priors.get(":, 2:")).add(priors.get(":, :2"));
//        NDArray point3 =
//                pre.get(":, 4:6").mul(scaleXY).mul(priors.get(":, 2:")).add(priors.get(":, :2"));
//        NDArray point4 =
//                pre.get(":, 6:8").mul(scaleXY).mul(priors.get(":, 2:")).add(priors.get(":, :2"));
//        NDArray point5 =
//                pre.get(":, 8:10").mul(scaleXY).mul(priors.get(":, 2:")).add(priors.get(":, :2"));
//        return NDArrays.concat(new NDList(point1, point2, point3, point4, point5), 1);
//    }
//
//    /** {@inheritDoc} */
//    @Override
//    public Batchifier getBatchifier() {
//        return Batchifier.STACK;
//    }
//}
//class FaceFeatureTranslator implements Translator<Image, float[]> {
//    FaceFeatureTranslator() {}
//
//    /** {@inheritDoc} */
//    @Override
//    public NDList processInput(TranslatorContext ctx, Image input) {
//        NDArray array = input.toNDArray(ctx.getNDManager(), Image.Flag.COLOR);
//        Pipeline pipeline = new Pipeline();
//        pipeline
//                .add(new Resize(160))
//                .add(new ToTensor())
//                .add(
//                        new Normalize(
//                                new float[] {127.5f / 255.0f, 127.5f / 255.0f, 127.5f / 255.0f},
//                                new float[] {
//                                        128.0f / 255.0f, 128.0f / 255.0f, 128.0f / 255.0f
//                                }));
//
//        return pipeline.transform(new NDList(array));
//    }
//
//    /** {@inheritDoc} */
//    @Override
//    public float[] processOutput(TranslatorContext ctx, NDList list) {
//        NDList result = new NDList();
//        long numOutputs = list.singletonOrThrow().getShape().get(0);
//        for (int i = 0; i < numOutputs; i++) {
//            result.add(list.singletonOrThrow().get(i));
//        }
//        float[][] embeddings =
//                result.stream().map(NDArray::toFloatArray).toArray(float[][]::new);
//        float[] feature = new float[embeddings.length];
//        for (int i = 0; i < embeddings.length; i++) {
//            feature[i] = embeddings[i][0];
//        }
//        return feature;
//    }
//
//    /** {@inheritDoc} */
//    @Override
//    public Batchifier getBatchifier() {
//        return Batchifier.STACK;
//    }
//}