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

public class SmbFileFilters {

    /**
     * Accepts all SmbFile entries, including null.
     */
    public static final IOSmbFileFilter ALL = new AbstractFileFilter() {
    	
    	@Override
        public boolean accept(SmbFile file) throws SmbException {
            return true;
        }
    	
    };

    /**
     * Accepts all non-null SmbFile entries.
     */
    public static final IOSmbFileFilter NON_NULL = new AbstractFileFilter() {
        
        @Override
        public boolean accept(SmbFile file) throws SmbException {
        	return file != null;
        }
		 
    };

    /**
     * Accepts all (non-null) SmbFile directory entries.
     */
    public static final IOSmbFileFilter DIRECTORIES = new AbstractFileFilter() {
    	
    	@Override
        public boolean accept(SmbFile file) throws SmbException {
			return file != null && file.isDirectory();
        }
    	
    };

    
}
