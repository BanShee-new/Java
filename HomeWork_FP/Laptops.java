package HomeWork_FP;

import java.io.FileWriter;
import java.util.*;

public class Laptops {
 
    public static void main(String[] args) {
        Date time = new Date(System.currentTimeMillis());
        Set<Config> laptops = new HashSet<>();
        Set<Config> infoBase = new HashSet<>();
        Random random = new Random();
        String nameBase = "Laptop database";
        int minNum = 30;
        int maxNum = 41;
        int count = random.nextInt(maxNum - minNum) + minNum;
        System.out.println("---------------------------------------------");
        System.out.println("Добро пожаловать в " + nameBase + "!");
        System.out.println("Сегодня " + time);
        System.out.println("На данный момент в базе более " + count + " ноутбуков.");
        System.out.println("---------------------------------------------");
        
        fillSet(laptops, infoBase, count);
        showCollection(laptops, infoBase, nameBase);
    }

    static void showCollection(Set<Config> laptops, Set<Config> infoBase, String nameBase) {
        System.out.println("Для печати всего списка введите [ Print ], для подбора ноутбуков по параметрам ведите -[ Select ]:");
        Scanner scan = new Scanner(System.in);
        String resScan = scan.next();
        if (resScan.equals("Print")) {
            for (Config it : laptops) {
                System.out.println(it);
            }
            System.out.println("");
            System.out.println("\t\tСписок всех доступных ноутбуков сохранён в файл Collection.txt\n");
            showCollection(laptops, infoBase, nameBase);
        } else if (resScan.equals("Select")) {
            getLaptop(laptops, infoBase, nameBase);
        } else {
            System.out.println("Введите верное значение!");
            showCollection(laptops, infoBase, nameBase);
        }
    }

    static void laptopFill(Set<Config> laptops) {
        Config laptop = new Config();
        laptop.color = laptop.getColor();
        laptop.brand = laptop.getBrand();
        laptop.inch = laptop.getInch();
        laptop.hdd = laptop.getHdd();
        laptop.ram = laptop.getRam();
        laptop.system = laptop.getSystem();
        laptops.add(laptop);
    }

    static void fillSet(Set<Config> laptops, Set<Config> infoBase, int count) {
        for (int i = 0; i < count; i++) {
            laptopFill(laptops);
        }
        infoBase.addAll(laptops);

        try (FileWriter writer = new FileWriter("HomeWork_FP/Collection.txt")) {
            writer.flush();
            for (Config it : infoBase
            ) {
                String text = new String(it.toString().getBytes(), "UTF-8");
                writer.write(text + "\n");

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    static void writeFile(Set<Config> base_collection) {
        try (FileWriter writer = new FileWriter("HomeWork_FP/Selection.txt")) {
            for (Config it : base_collection
            ) {
                String text = new String(it.toString().getBytes(), "UTF-8");
                writer.write(text + "\n");

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static void getLaptop(Set<Config> laptops, Set<Config> infoBase, String nameBase) {
        Set<Config> newSet = new HashSet<>();
        System.out.println("[1] Производитель; [2] Диагональ; [3] HDD; [4] RAM; [5] Операционная система; [6] Цвет; ");
        System.out.print("Выберите нужный параметр введя цифру: ");
        Scanner insert = new Scanner(System.in);
        int getScan = insert.nextInt();
        if (getScan == 1) {
            System.out.println("Поиск по производителям: [ Asus ], [ Acer ], [ Lenovo ], [ HP ], [ Huawei ]");
            System.out.print("Введите название предпочтительного бренда из списка: ");
            String name = insert.next();
            int checkCount = 0;
            for (Config it : laptops) {
                if (name.equals(it.brand)) {
                    System.out.println(it);
                    newSet.add(it);
                    writeFile(newSet);
                    checkCount++;
                }
            }
            if (checkCount < 1) {
                System.out.println("Данной модели нет в наличии!");
                getLaptop(laptops, infoBase, nameBase);
            } else {
                System.out.println("");
                System.out.println("Количество соответствующих моделей: " + newSet.size() + "\n");
                stepNext(insert, newSet, laptops, infoBase, nameBase);
            }

        } else if (getScan == 2) {
            System.out.println("Поиск по диагонали: [ 14 ], [ 15 ], [ 16 ], [ 17Select ]");
            System.out.print("Введите минимальную диагональ: ");
            double mark = insert.nextDouble();
            if (mark > 17.3) {
                System.out.println("Данной модели нет в наличии!");
                getLaptop(laptops, infoBase, nameBase);
            } else {
                for (Config it : laptops) {
                    if (mark <= it.inch) {
                        System.out.println(it);
                        newSet.add(it);
                        writeFile(newSet);
                    }
                }
                System.out.println("");
                System.out.println("Количество соответствующих моделей: " + newSet.size() + "\n");
                stepNext(insert, newSet, laptops, infoBase, nameBase);
            }

        } else if (getScan == 3) {
            System.out.print("Укажите минимальный объём HDD: ");
            int scan = insert.nextInt();
            if (scan > 2048) {
                System.out.println("Данного объёма HDD нет в наличии!");
                getLaptop(laptops, infoBase, nameBase);
            } else {
                for (Config it : laptops) {
                    if (scan <= it.hdd) {
                        System.out.println(it);
                        newSet.add(it);
                        writeFile(newSet);
                    }
                }
                System.out.println("");
                System.out.println("Количество соответствующих моделей: " + newSet.size() + "\n");
                stepNext(insert, newSet, laptops, infoBase, nameBase);
            }
        } else if (getScan == 4) {
            System.out.print("Введите минимальный объём RAM: ");
            int scan = insert.nextInt();
            if (scan > 32) {
                System.out.println("Данного объёма RAM нет в наличие!");
                getLaptop(laptops, infoBase, nameBase);
            } else {
                for (Config it : laptops) {
                    if (scan <= it.ram) {
                        System.out.println(it);
                        newSet.add(it);
                        writeFile(newSet);
                    }
                }
                System.out.println("");
                System.out.println("Количество соответствующих моделей: " + newSet.size() + "\n");
                stepNext(insert, newSet, laptops, infoBase, nameBase);
            }
        } else if (getScan == 5) {
            System.out.println("Поиск по системе: [ Windows ], [ Linux ], [ Android ], [ noOS ]");
            System.out.print("Введите название предпочтительной системы из списка: ");
            String system = insert.next();
            int checkCount = 0;
            for (Config it : laptops) {
                if (system.equals(it.system)) {
                    System.out.println(it);
                    newSet.add(it);
                    writeFile(newSet);
                    checkCount++;
                }
            }
            if (checkCount < 1) {
                System.out.println("Данной системы нет в наличие!");
                getLaptop(laptops, infoBase, nameBase);
            } else {
                stepNext(insert, newSet, laptops, infoBase, nameBase);
            }
        } else if (getScan == 6) {
            System.out.println("Поиск по цвету: Белый - [ White ], Чёрный - [ Black ], Серебристый - [ Silver ], Золотистый - [ Golden ]");
            System.out.print("Введите предпочтительный цвет из списка: ");
            String color = insert.next();
            int checkCount = 0;
            for (Config it : laptops) {
                if (color.equals(it.color)) {
                    System.out.println(it);
                    newSet.add(it);
                    writeFile(newSet);
                    checkCount++;
                }
            }
            if (checkCount < 1) {
                System.out.println("Данного цвета нет в наличие!");
                getLaptop(laptops, infoBase, nameBase);
            } else {
                System.out.println("");
                System.out.println("Количество соответствующих моделей: " + newSet.size() + "\n");
                stepNext(insert, newSet, laptops, infoBase, nameBase);
            }
        } else {
            System.out.println("Вы ввели неверное значение!");
            getLaptop(laptops, infoBase, nameBase);
        }
        insert.close();
    }

    static void stepNext(Scanner insert, Set<Config> newSet, Set<Config> laptops, Set<Config> infoBase, String nameBase) {
        System.out.println("Для новой сортировки введите - [ Again ], или уточните текущий список, введя команду - [ Still ]. Команда [ Stop ] для завершения.");
        String chat = insert.next();
        if (chat.equals("Still")) {
            getLaptop(newSet, laptops, nameBase);
        } else if (chat.equals("Again")) {
            showCollection(infoBase, infoBase, nameBase);
        } else if (chat.equals("Stop")) {
            System.out.println("Ноутбуки выбранные по вашим критериям сохранены в файл Selection.txt");
            System.out.println("Количество ноутбуков, отобранных по вашему запросу: " + newSet.size() + "шт.\n");
            return;
        } else {
            System.out.println("Введите корректную фразу!");
            stepNext(insert, newSet, laptops, infoBase, nameBase);
        }
        return;
    }
}