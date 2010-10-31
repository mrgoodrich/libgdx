package com.badlogic.gdx.graphics.glutils;

import java.nio.FloatBuffer;

import com.badlogic.gdx.graphics.VertexAttributes;

/**
 * A VertexData instance holds vertices for rendering with OpenGL. It
 * is implemented as either a {@link VertexArray} or a {@link VertexBufferObject}. Only
 * the later supports OpenGL ES 2.0.
 *  
 * @author mzechner
 *
 */
public interface VertexData {
	/**
	 * @return the number of vertices this VertexData stores
	 */
	public int getNumVertices ();
	
	/**
	 * @return the number of vertices this VertedData can store
	 */
	public int getNumMaxVertices ();
	
	/**
	 * @return the {@link VertexAttributes} as specified during construction.
	 */
	public VertexAttributes getAttributes ();	
	
	/**
	 * Sets the vertices of this VertexData, discarding the old vertex data. The
	 * count must equal the number of floats per vertex times the number of vertices to
	 * be copied to this VertexData. The order of the vertex attributes must be the same
	 * as specified at construction time via {@link VertexAttributes}.
	 * 
	 * @param vertices the vertex data
	 * @param offset the offset to start copying the data from
	 * @param count the number of floats to copy
	 */
	public void setVertices (float[] vertices, int offset, int count);	
	
	/**
	 * Returns the underlying FloatBuffer. If this is called an internal dirty
	 * flag is set and the VertexData is reuploaded to OpenGL on the next bind. The
	 * data is therefore considered dirty.
	 * 
	 * @return the underlying FloatBuffer holding the vertex data.
	 */
	public FloatBuffer getBuffer ();
	
	/**
	 * Binds this VertexData for rendering via glDrawArrays or glDrawElements.
	 */
	public void bind ();
	
	/**
	 * Unbinds this VertexData.
	 */
	public void unbind ();	
	
	/**
	 * Disposes this VertexData and all its associated OpenGL resources.
	 */
	public void dispose ();
}
