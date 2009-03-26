/**
 * Copyright 2005-2009 Noelios Technologies.
 * 
 * The contents of this file are subject to the terms of one of the following
 * open source licenses: LGPL 3.0 or LGPL 2.1 or CDDL 1.0 or EPL 1.0 (the
 * "Licenses"). You can select the license that you prefer but you may not use
 * this file except in compliance with one of these Licenses.
 * 
 * You can obtain a copy of the LGPL 3.0 license at
 * http://www.opensource.org/licenses/lgpl-3.0.html
 * 
 * You can obtain a copy of the LGPL 2.1 license at
 * http://www.opensource.org/licenses/lgpl-2.1.php
 * 
 * You can obtain a copy of the CDDL 1.0 license at
 * http://www.opensource.org/licenses/cddl1.php
 * 
 * You can obtain a copy of the EPL 1.0 license at
 * http://www.opensource.org/licenses/eclipse-1.0.php
 * 
 * See the Licenses for the specific language governing permissions and
 * limitations under the Licenses.
 * 
 * Alternatively, you can obtain a royalty free commercial license with less
 * limitations, transferable or non-transferable, directly at
 * http://www.noelios.com/products/restlet-engine
 * 
 * Restlet is a registered trademark of Noelios Technologies.
 */

package org.restlet.ext.rdf.internal.xml;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.restlet.data.Reference;
import org.restlet.ext.rdf.Graph;
import org.restlet.ext.rdf.GraphHandler;
import org.restlet.ext.rdf.Literal;

/**
 * Handler of RDF content according to the RDF XML syntax.
 */
public class RdfXmlWritingContentHandler extends GraphHandler {

    /** Buffered writer. */
    // TODO plutôt un XMLWriter?
    BufferedWriter bw;

    /**
     * Constructor.
     * 
     * @param linkSet
     *            The set of links to write to the output stream.
     * @param outputStream
     *            The output stream to write to.
     * @throws IOException
     * @throws IOException
     */
    public RdfXmlWritingContentHandler(Graph linkset, OutputStream outputStream)
            throws IOException {
        super();
        this.bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        this.bw.flush();
    }

    @Override
    public void link(Graph source, Reference typeRef, Literal target) {
        // TODO Auto-generated method stub

    }

    @Override
    public void link(Graph source, Reference typeRef, Reference target) {
        // TODO Auto-generated method stub

    }

    @Override
    public void link(Reference source, Reference typeRef, Literal target) {
        // TODO Auto-generated method stub

    }

    @Override
    public void link(Reference source, Reference typeRef, Reference target) {
        // TODO Auto-generated method stub

    }
}
