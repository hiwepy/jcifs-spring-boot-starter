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

import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileFilter;
import jcifs.smb.SmbFilenameFilter;

public interface IOSmbFileFilter extends SmbFileFilter, SmbFilenameFilter {

    /**
     * Checks to see if the File should be accepted by this filter.
     * <p>
     * Defined in {@link jcifs.smb.SmbFileFilter}.
     *
     * @param file  the SmbFile to check
     * @return true if this file matches the test
     */
	public boolean accept( SmbFile file ) throws SmbException;

    /**
     * Checks to see if the File should be accepted by this filter.
     * <p>
     * Defined in {@link jcifs.smb.SmbFilenameFilter}.
     *
     * @param dir  the directory File to check
     * @param name  the filename within the directory to check
     * @return true if this SmbFile matches the test
     */
    public boolean accept( SmbFile dir, String name ) throws SmbException;

}
