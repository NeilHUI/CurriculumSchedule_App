package com.xjtu.curriculumschedule.curriculumschedule_app;

import net.sf.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class GetJson {
    //获取格式一的数据---------教师课表
    public  JSONObject getClassInfo1 (String fileName) throws IOException {
//        File file = new File(fileName);
        Document dInfo = Jsoup.parse(fileName);
        Elements eInfo=dInfo.select("table").select("tr");
        ArrayList<ClassInfo1> list = new ArrayList<ClassInfo1>();
        for (int i = 5; i <eInfo.size(); i++) {
            Elements eInfo1=eInfo.get(i).select("td");
            if(eInfo1.text().toString().equals("注1：")){
                break;
            }
            if(eInfo1.size()==9) {
                for (int j = 2; j < eInfo1.size(); j++) {
                    if(eInfo1.get(j).text().length()!=0){
                        ClassInfo1 classInfo1=new ClassInfo1();
                        classInfo1.setWeek(String.valueOf(j-1));
                        classInfo1.setLesson(String.valueOf(i-4));
                        classInfo1.setInfo(eInfo1.get(j).text());
                        list.add(classInfo1);
                    }
                }
            }else {
                for (int j = 1; j < eInfo1.size(); j++) {
                    if(eInfo1.get(j).text().length()!=0){
                        ClassInfo1 classInfo1=new ClassInfo1();
                        classInfo1.setWeek(String.valueOf(j));
                        classInfo1.setLesson(String.valueOf(i-4));
                        classInfo1.setInfo(eInfo1.get(j).text());
                        list.add(classInfo1);
                    }
                }
            }
        }

        /*Iterator<ClassInfo1> it=list.iterator();
        while (it.hasNext()){
            ClassInfo1 classInfo1=new ClassInfo1();
            classInfo1=it.next();
            System.out.println(classInfo1.getInfo()+"----课程："+classInfo1.getLesson()+"----星期："+classInfo1.getWeek());
        }*/

        //获取部门，教师，性别，职称
        String infoTitle=eInfo.get(3).select("td").text();

        JSONObject jsonObject=new JSONObject();
        jsonObject.put(infoTitle,list);
        System.out.println(jsonObject.toString());
        return jsonObject;
    }



    //获取格式一的数据---------课程课表
    public  JSONObject getClassInfo2 (String fileName) throws IOException {
//        File file = new File(fileName);
//        Document dInfo = Jsoup.parse(file, "UTF-8");
        Document dInfo=Jsoup.parse(fileName);
        Elements eInfo=dInfo.select("table").select("tr");
        ArrayList<ClassInfo1> list = new ArrayList<ClassInfo1>();
        for (int i = 5; i <eInfo.size(); i++) {
            Elements eInfo1=eInfo.get(i).select("td");
            if(eInfo1.text().toString().equals("注1：")){
                break;
            }
            if(eInfo1.size()==9) {
                for (int j = 2; j < eInfo1.size(); j++) {
                    if(eInfo1.get(j).text().length()!=0){
                        ClassInfo1 classInfo1=new ClassInfo1();
                        classInfo1.setWeek(String.valueOf(j-1));
                        classInfo1.setLesson(String.valueOf(i-4));
                        classInfo1.setInfo(eInfo1.get(j).text());
                        list.add(classInfo1);
                    }
                }
            }else {
                for (int j = 1; j < eInfo1.size(); j++) {
                    if(eInfo1.get(j).text().length()!=0){
                        ClassInfo1 classInfo1=new ClassInfo1();
                        classInfo1.setWeek(String.valueOf(j));
                        classInfo1.setLesson(String.valueOf(i-4));
                        classInfo1.setInfo(eInfo1.get(j).text());
                        list.add(classInfo1);
                    }
                }
            }
        }

        /*Iterator<ClassInfo1> it=list.iterator();
        while (it.hasNext()){
            ClassInfo1 classInfo1=new ClassInfo1();
            classInfo1=it.next();
            System.out.println(classInfo1.getInfo()+"----课程："+classInfo1.getLesson()+"----星期："+classInfo1.getWeek());
        }*/

        //获取部门，教师，性别，职称
        String infoTitle=eInfo.get(3).select("td").text();

        JSONObject jsonObject=new JSONObject();
        jsonObject.put(infoTitle,list);
        System.out.println(jsonObject.toString());
        return jsonObject;
    }

    //获取格式一的数据---------教室课表
    public  JSONObject getClassInfo3 (String fileName) throws IOException {
//        File file = new File(fileName);
//        Document dInfo = Jsoup.parse(file, "UTF-8");
        Document dInfo=Jsoup.parse(fileName);
        Elements eInfo=dInfo.select("table").select("tr");
        ArrayList<ClassInfo1> list = new ArrayList<ClassInfo1>();
        for (int i = 5; i <eInfo.size(); i++) {
            Elements eInfo1=eInfo.get(i).select("td");
            if(eInfo1.text().toString().equals("注1：")){
                break;
            }
            if(eInfo1.size()==9) {
                for (int j = 2; j < eInfo1.size(); j++) {
                    if(eInfo1.get(j).text().length()!=0){
                        ClassInfo1 classInfo1=new ClassInfo1();
                        classInfo1.setWeek(String.valueOf(j-1));
                        classInfo1.setLesson(String.valueOf(i-4));
                        classInfo1.setInfo(eInfo1.get(j).text());
                        list.add(classInfo1);
                    }
                }
            }else {
                for (int j = 1; j < eInfo1.size(); j++) {
                    if(eInfo1.get(j).text().length()!=0){
                        ClassInfo1 classInfo1=new ClassInfo1();
                        classInfo1.setWeek(String.valueOf(j));
                        classInfo1.setLesson(String.valueOf(i-4));
                        classInfo1.setInfo(eInfo1.get(j).text());
                        list.add(classInfo1);
                    }
                }
            }
        }

        /*Iterator<ClassInfo1> it=list.iterator();
        while (it.hasNext()){
            ClassInfo1 classInfo1=new ClassInfo1();
            classInfo1=it.next();
            System.out.println(classInfo1.getInfo()+"----课程："+classInfo1.getLesson()+"----星期："+classInfo1.getWeek());
        }*/

        //获取部门，教师，性别，职称
        String infoTitle=eInfo.get(3).select("td").text();

        JSONObject jsonObject=new JSONObject();
        jsonObject.put(infoTitle,list);
        System.out.println(jsonObject.toString());
        return jsonObject;
    }

    //获取格式一的数据---------任选课表
    public  JSONObject getClassInfo4 (String fileName) throws IOException {
//        File file = new File(fileName);
//        Document dInfo = Jsoup.parse(file, "UTF-8");
        Document dInfo=Jsoup.parse(fileName);
        Elements eInfo=dInfo.select("table").select("tr");
        ArrayList<ClassInfo> list = new ArrayList<ClassInfo>();
        for (int i = 5; i <eInfo.size(); i++) {
            Elements eInfo1=eInfo.get(i).select("td");
            ClassInfo classInfo=new ClassInfo();
            classInfo.setClassId(eInfo1.get(0).text());
            classInfo.setClassName(eInfo1.get(1).text());
            classInfo.setClassCount(eInfo1.get(2).text());
            classInfo.setClassTeacher(eInfo1.get(3).text());
            classInfo.setClassNum(eInfo1.get(4).text());
            classInfo.setClassPerson(eInfo1.get(5).text());
            classInfo.setClassWeek(eInfo1.get(6).text());
            classInfo.setClassTime(eInfo1.get(7).text());
            classInfo.setClassRoom(eInfo1.get(8).text());
            list.add(classInfo);
        }

        /*Iterator<ClassInfo1> it=list.iterator();
        while (it.hasNext()){
            ClassInfo1 classInfo1=new ClassInfo1();
            classInfo1=it.next();
            System.out.println(classInfo1.getInfo()+"----课程："+classInfo1.getLesson()+"----星期："+classInfo1.getWeek());
        }*/

        //获取部门，教师，性别，职称
        String infoTitle=eInfo.get(3).select("td").text();

        JSONObject jsonObject=new JSONObject();
        jsonObject.put(infoTitle,list);
        System.out.println(jsonObject.toString());
        return jsonObject;
    }

}
