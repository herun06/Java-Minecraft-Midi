package main.java.com.xfherun.jmci.utils;

import com.xfherun.xflog.XFLog;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

public class ReadTextFile
{
    private ReadTextFile()
    {
    }

    public static ArrayList<String> readAll(File file)
    {
        String list = "";
        String b = "";
        ArrayList<String> list2 = new ArrayList<>();

        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file.toString()), "UTF-8"));
        }
        catch (UnsupportedEncodingException e)
        {
            throw new UnsupportedOperationException();
        }
        catch (FileNotFoundException e)
        {
            try
            {
                throw new FileNotFoundException(String.valueOf(e));
            }
            catch (FileNotFoundException ex)
            {
                throw new RuntimeException(ex);
            }
        }
        while (true)
        {
            try
            {
                if (!((b = br.readLine()) != null)) break;
            }
            catch (IOException e)
            {
                try
                {
                    throw new IOException(String.valueOf(e));
                }
                catch (IOException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
            list2.add(b);
        }
        try
        {
            br.close();
        }
        catch (IOException e)
        {
            try
            {
                throw new IOException(String.valueOf(e));
            }
            catch (IOException ex)
            {
                throw new RuntimeException(ex);
            }
        }

        return list2;
    }

    public static String readAllToLine(File file)
    {
        String b = "";
        StringBuilder sb = new StringBuilder();

        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file.toString()), "UTF-8"));
        }
        catch (UnsupportedEncodingException e)
        {
            throw new UnsupportedOperationException();
        }
        catch (FileNotFoundException e)
        {
            try
            {
                throw new FileNotFoundException(String.valueOf(e));
            }
            catch (FileNotFoundException ex)
            {
                throw new RuntimeException(ex);
            }
        }
        while (true)
        {
            try
            {
                if (!((b = br.readLine()) != null)) break;
            }
            catch (IOException e)
            {
                try
                {
                    throw new IOException(String.valueOf(e));
                }
                catch (IOException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
            sb.append(b).append("\n");
        }
        try
        {
            br.close();
        }
        catch (IOException e)
        {
            try
            {
                throw new IOException(String.valueOf(e));
            }
            catch (IOException ex)
            {
                throw new RuntimeException(ex);
            }
        }

        return sb.toString();
    }

    private static String fillZero(int length, int number, String str)
    {
        if (String.valueOf(number).length() > length) throw new RuntimeException("非法参数: " + length + " :: " + number);
        int size = length - String.valueOf(number).length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) stringBuilder.append(str);
        stringBuilder.append(number);
        return stringBuilder.toString();
    }

    public static String[] readAllToLine_lineNumber(File file)
    {
        try
        {
            String b = "";
            ArrayList<Integer> lengthArrayList = new ArrayList<>();
            String[] temp = new String[3];
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();

            BufferedReader br = null;
            try
            {
                br = new BufferedReader(new InputStreamReader(new FileInputStream(file.toString()), "UTF-8"));
            }
            catch (UnsupportedEncodingException e)
            {
                throw new UnsupportedOperationException();
            }
            catch (FileNotFoundException e)
            {
                try
                {
                    throw new FileNotFoundException(String.valueOf(e));
                }
                catch (FileNotFoundException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
            int lineNumber = 1;
            while (true)
            {
                try
                {
                    if (!((b = br.readLine()) != null)) break;
                }
                catch (IOException e)
                {
                    try
                    {
                        throw new IOException(String.valueOf(e));
                    }
                    catch (IOException ex)
                    {
                        throw new RuntimeException(ex);
                    }
                }
                String s = sb.append("    |").append(fillZero(10, lineNumber, " ")).append("|").append("    ").append(b).append("\n").toString();
                sb2.append(b).append("\n");
                int length = ("|" + fillZero(10, lineNumber, " ") + "|" + "    " + b + "").length();
                lengthArrayList.add(length);
                lineNumber++;
            }
            try
            {
                br.close();
            }
            catch (IOException e)
            {
                try
                {
                    throw new IOException(String.valueOf(e));
                }
                catch (IOException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
            temp[0] = sb.toString();
            temp[1] = sb2.toString();
            temp[2] = String.valueOf(Collections.max(lengthArrayList));
            if (!sb2.toString().equals("")) return temp;
            else return null;
        }
        catch (RuntimeException e)
        {
            return null;
        }
    }

    public static String readAllToString(File file)
    {
        String result = "";
        String b = "";
        ArrayList<String> list2 = new ArrayList<>();

        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file.toString()), "UTF-8"));
        }
        catch (UnsupportedEncodingException e)
        {
            throw new UnsupportedOperationException();
        }
        catch (FileNotFoundException e)
        {
            try
            {
                throw new FileNotFoundException(String.valueOf(e));
            }
            catch (FileNotFoundException ex)
            {
                throw new RuntimeException(ex);
            }
        }
        while (true)
        {
            try
            {
                if (!((b = br.readLine()) != null)) break;
            }
            catch (IOException e)
            {
                try
                {
                    throw new IOException(String.valueOf(e));
                }
                catch (IOException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
            result = (result + b);
        }
        try
        {
            br.close();
        }
        catch (IOException e)
        {
            try
            {
                throw new IOException(String.valueOf(e));
            }
            catch (IOException ex)
            {
                throw new RuntimeException(ex);
            }
        }

        return result.replace("\n", "").
                replace("\t", "").replace("\r", "");
    }

    public static String readAllToStringToDot(File file)
    {
        String result = "";
        String b = "";
        ArrayList<String> list2 = new ArrayList<>();

        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file.toString()), "UTF-8"));
        }
        catch (UnsupportedEncodingException e)
        {
            throw new UnsupportedOperationException();
        }
        catch (FileNotFoundException e)
        {
            try
            {
                throw new FileNotFoundException(String.valueOf(e));
            }
            catch (FileNotFoundException ex)
            {
                throw new RuntimeException(ex);
            }
        }
        while (true)
        {
            try
            {
                if (!((b = br.readLine()) != null)) break;
            }
            catch (IOException e)
            {
                try
                {
                    throw new IOException(String.valueOf(e));
                }
                catch (IOException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
            list2.add(b);
        }
        try
        {
            br.close();
        }
        catch (IOException e)
        {
            try
            {
                throw new IOException(String.valueOf(e));
            }
            catch (IOException ex)
            {
                throw new RuntimeException(ex);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : list2) stringBuilder.append(s);

        return stringBuilder.toString().replace("\n", ".").
                replace("\t", ".").replace("\r", ".");
    }

    public static String readAllToStringToString(File file)
    {
        String result = "";
        String b = "";
        ArrayList<String> list2 = new ArrayList<>();

        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file.toString()), "UTF-8"));
        }
        catch (UnsupportedEncodingException e)
        {
            throw new UnsupportedOperationException();
        }
        catch (FileNotFoundException e)
        {
            try
            {
                throw new FileNotFoundException(String.valueOf(e));
            }
            catch (FileNotFoundException ex)
            {
                throw new RuntimeException(ex);
            }
        }
        while (true)
        {
            try
            {
                if (!((b = br.readLine()) != null)) break;
            }
            catch (IOException e)
            {
                try
                {
                    throw new IOException(String.valueOf(e));
                }
                catch (IOException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
            list2.add(b);
        }
        try
        {
            br.close();
        }
        catch (IOException e)
        {
            try
            {
                throw new IOException(String.valueOf(e));
            }
            catch (IOException ex)
            {
                throw new RuntimeException(ex);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : list2) stringBuilder.append(s);

        return stringBuilder.toString().replace("\n", "").replace(" ", "").
                replace("\t", "").replace("\r", "");
    }
}
