package observer;

public interface IUndoableStringBuilder
{
    /***
     * Appends the specified string to this character sequence.
     * @param str : our input string
     * @return the String after append
     */
    public UndoableStringBuilder append (String str);

    /***
     * Removes the characters in a substring of this sequence
     * If start is equal to end, no changes are made.
     * @param start:  The substring begins at the specified start
     * @param end :  at index end -1 or to the end of the sequence if no such character exists.
     * @return new str after delete
     */
    public UndoableStringBuilder delete (int start , int end);

    /***
     * Inserts the string into this character sequence.
     * @param offset : the place  we want to insert in the string (Which index)
     * @param str
     * @return
     */
    public UndoableStringBuilder insert (int offset ,String str );

    /***
     * Replaces the characters in a substring of this sequence with characters in
     * the specified String.
     * @param start :  The substring begins at the specified start ,
     *  first the characters in the substring are removed and then the specified String is inserted at start.
     * @param end :  at index end - 1 or to the end of the sequence if no such character exists.
     * @param str : specified string we want to replace
     * @return the string after replace
     */
    public UndoableStringBuilder replace(int start ,int end ,String str);

    /***
     *  Causes this character sequence to be replaced by the reverse of the sequence
     * @return
     */
    public UndoableStringBuilder reverse();

    /***
     * command or function  is used to reverse the last action performed
     * @return the result of last action performed
     */
    public void undo();


}
