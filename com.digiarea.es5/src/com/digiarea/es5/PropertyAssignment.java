package com.digiarea.es5;

import com.digiarea.es5.Expression;
import com.digiarea.es5.PropertyName;
import com.digiarea.es5.Comment;
import com.digiarea.es5.JSDocComment;

/** 
 * The Class PropertyAssignment.
 */
public abstract class PropertyAssignment extends Expression {

    /** 
     * The property name.
     */
    private PropertyName propertyName;

    /** 
     * The comment.
     */
    private Comment comment = null;

    public PropertyName getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(PropertyName propertyName) {
        this.propertyName = propertyName;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    PropertyAssignment() {
        super();
    }

    PropertyAssignment(PropertyName propertyName, Comment comment, JSDocComment jsDocComment, int posBegin, int posEnd) {
        super(jsDocComment, posBegin, posEnd);
        this.propertyName = propertyName;
        this.comment = comment;
    }

}
