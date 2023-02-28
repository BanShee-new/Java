package HomeWork_FP;

import java.util.Random;

public class Config {
    int ram, hdd;
    double inch;
    String system, color, brand;

    public String toString() {
        return "Производитель: " + brand + ". Диагональ: " + inch + "\". Размер HDD: " + hdd + " Гб. Объём RAM: "
                + ram + "Гб. Операционная система: " + system + ". Цвет: " + color;
    }

    String getColor() {
        String[] colorCollection = new String[]{"Black", "White", "Silver", "Golden"};
        Random ranCol = new Random();
        return colorCollection[ranCol.nextInt(colorCollection.length)];
    }

    String getBrand() {
        String[] brandcollection = new String[]{"Acer", "Asus", "Lenovo", "HP", "Huawei"};
        Random ranBra = new Random();
        return brandcollection[ranBra.nextInt(brandcollection.length)];
    }

    String getSystem() {
        String[] systemcollection = new String[]{"Windows", "Linux", "Android", "noOS"};
        Random ranSys = new Random();
        return systemcollection[ranSys.nextInt(systemcollection.length)];
    }

    double getInch() {
        double[] inchCollection = new double[]{14, 15, 16, 17};
        Random ranInch = new Random();
        return inchCollection[ranInch.nextInt(inchCollection.length)];
    }

    int getRam() {
        int[] ramCollection = new int[]{4, 8, 16, 32};
        Random ranRam = new Random();
        return ramCollection[ranRam.nextInt(ramCollection.length)];
    }

    int getHdd() {
        int min = 128;
        int max = 2049;
        Random ranHdd = new Random();
        return ranHdd.nextInt(max - min) + min;
    }
}