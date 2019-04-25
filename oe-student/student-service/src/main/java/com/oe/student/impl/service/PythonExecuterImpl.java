package com.oe.student.impl.service;


import com.oe.student.service.PythonExecuter;
import com.oe.student.vo.StepVo;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author wangwj
 * @data 2019/3/12
 */
@Service
public class PythonExecuterImpl implements PythonExecuter {

    @Override
    public Map<String, String> executePython(List<StepVo> list, String studentId, String experimentId, String realPath, String args) {
        final String path = realPath + File.separator + studentId
                + experimentId + ".py";
        String code = list.stream().map(StepVo::getStepCode).reduce("# -*- coding: utf-8 -*-\nimport sys\n", (a, b) -> a + "\n" + b);
        writeToFile(code, path);
        InputStream error = null;
        InputStream in = null;
        String cmd = "python " + path + " " + args;
        String result = null;
        String errMsg = null;
        BufferedReader reader = null;
        BufferedReader reader2 = null;
        Map<String, String> map = null;
        try {
            Process process = Runtime.getRuntime().exec(cmd);
            error = process.getErrorStream();
            reader = new BufferedReader(new InputStreamReader(error, Charset.forName("UTF-8")));
            map = new HashMap<>(2);
            Optional<String> o = reader.lines().reduce((a, b) -> a + b);
            if (o.isPresent()) {
                errMsg = o.get();
                map.put("error", errMsg);

            }
            in = process.getInputStream();
            reader2 = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));
            Optional<String> o2 = reader2.lines().reduce((a, b) -> a + b);
            if (o2.isPresent()) {
                result = o2.get();
                map.put("result", result);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader2 != null) {
                try {
                    reader2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in != null) {
                try {
                    error.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (error != null) {
                try {
                    error.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return map;
    }

    private void writeToFile(String code, String path) {
        File file = new File(path);
        FileOutputStream out = null;
        PrintWriter writer = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            out = new FileOutputStream(file);
            writer = new PrintWriter(out);
            writer.write(code.toCharArray());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (writer != null) {
                writer.close();
            }
        }

    }
}
