/*
 * Copyright (c) 2018, vindell (https://github.com/vindell).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package net.jeebiz.smbclient.filefilter;

import java.io.Serializable;

import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileFilter;

@SuppressWarnings("serial")
public class DelegateFileFilter  extends AbstractFileFilter implements Serializable {

    /** The File filter */
    private final SmbFileFilter fileFilter;

    /**
     * Constructs a delegate file filter around an existing FileFilter.
     *
     * @param filter  the filter to decorate
     */
    public DelegateFileFilter(final SmbFileFilter filter) {
        if (filter == null) {
            throw new IllegalArgumentException("The FileFilter must not be null");
        }
        this.fileFilter = filter;
    }

    /**
     * Checks the filter.
     *
     * @param file  the file to check
     * @return true if the filter matches
     */
    @Override
    public boolean accept(final SmbFile file) throws SmbException {
        if (fileFilter != null) {
            return fileFilter.accept(file);
        } else {
            return false;
        }
    }

    /**
     * Provide a String representaion of this file filter.
     *
     * @return a String representaion
     */
    @Override
    public String toString() {
        final String delegate = fileFilter != null ? fileFilter.toString() : "";
        return super.toString() + "(" + delegate + ")";
    }

}
