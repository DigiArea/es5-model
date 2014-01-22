package com.digiarea.es5;

import com.digiarea.es5.Expression;
import com.digiarea.es5.PropertyName;
import com.digiarea.es5.Comment;

public abstract class PropertyAssignment extends Expression {

    private PropertyName propertyName;

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

    public PropertyAssignment() {
        super();
    }

    public PropertyAssignment(PropertyName propertyName, Comment comment, int posBegin, int posEnd) {
        super(posBegin, posEnd);
        this.propertyName = propertyName;
        this.comment = comment;
    }

}
