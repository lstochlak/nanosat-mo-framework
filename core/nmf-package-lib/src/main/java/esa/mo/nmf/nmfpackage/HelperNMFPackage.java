/* ----------------------------------------------------------------------------
 * Copyright (C) 2021      European Space Agency
 *                         European Space Operations Centre
 *                         Darmstadt
 *                         Germany
 * ----------------------------------------------------------------------------
 * System                : ESA NanoSat MO Framework
 * ----------------------------------------------------------------------------
 * Licensed under the European Space Agency Public License, Version 2.0
 * You may not use this file except in compliance with the License.
 *
 * Except as expressly set forth in this License, the Software is provided to
 * You on an "as is" basis and without warranties of any kind, including without
 * limitation merchantability, fitness for a particular purpose, absence of
 * defects or errors, accuracy or non-infringement of intellectual property rights.
 * 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * ----------------------------------------------------------------------------
 */
package esa.mo.nmf.nmfpackage;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;

/**
 *
 * @author Cesar Coelho
 */
public class HelperNMFPackage {

    public static final String RECEIPT_FILENAME = "nmfPackage.receipt";
    public static final String DS_FILENAME = "digitalSignature.key";
    public static final String PRIVATE_KEY_FILENAME = "privateKey.key";
    public static final String NMF_PACKAGE_DESCRIPTOR_VERSION = "NMFPackageDescriptorVersion=";

    public static long calculateCRCFromFile(final String filepath) throws IOException {
        InputStream inputStream = new BufferedInputStream(new FileInputStream(filepath));
        long crc = calculateCRCFromInputStream(inputStream);
        inputStream.close();
        return crc;
    }

    public static long calculateCRCFromInputStream(final InputStream inputStream) throws IOException {
        CRC32 crc = new CRC32();
        int cnt;

        while ((cnt = inputStream.read()) != -1) {
            crc.update(cnt);
        }

        return crc.getValue();
    }

    public static String generateLinuxStartAppScript(String mainclass) throws IOException {
        StringBuilder str = new StringBuilder();
        str.append("#!/bin/sh\n");
        str.append("###########################################\n");
        str.append("#  This file is auto-generated by the NMF\n");
        str.append("#  during the installation of the App\n");
        str.append("###########################################\n");
        str.append("\n");
        str.append("cd ${0%/*}\n");
        str.append("\n");

        str.append("# NMF_LIB can be provided by the parent app (i.e. supervisor) or set locally\n");
        str.append("if [ -z \"$NMF_LIB\" ] ; then\n");
        str.append("    NMF_LIB=`cd ../../libs > /dev/null; pwd`\n");
        str.append("fi\n");
        str.append("\n");

        str.append("if [ -z \"$NMF_HOME\" ] ; then\n");
        str.append("    NMF_HOME=`cd ../../ > /dev/null; pwd`\n");
        str.append("fi\n");
        str.append("\n");
        
        str.append("if [ -z \"$JAVA_OPTS\" ] ; then\n");
        str.append("    JAVA_OPTS=\"-Xms32m -Xmx256m\"\n");
        str.append("fi\n");
        str.append("\n");

        str.append("LOCAL_LIB_PATH=`readlink -f lib`\n");
        str.append("LD_LIBRARY_PATH=$LOCAL_LIB_PATH:`cd ../../libs > /dev/null; pwd`:$LD_LIBRARY_PATH\n");
        str.append("\n");

        str.append("export JAVA_OPTS\n");
        str.append("export NMF_LIB\n");
        str.append("export NMF_HOME\n");
        str.append("export LD_LIBRARY_PATH\n");
        str.append("\n");

        str.append("# Replaced with the main class name\n");
        str.append("MAIN_CLASS_NAME=");
        str.append(mainclass);
        str.append("\n\n");

        str.append("java $JAVA_OPTS \\ \n");
        str.append("  -classpath \"$NMF_LIB/*:benchmark-2.0.0-SNAPSHOT.jar\" \\ \n");
        str.append("  \"$MAIN_CLASS_NAME\" \\ \n");
        str.append("  \"$@\" \n");
        str.append("\n");

        return str.toString();
    }
    
}
