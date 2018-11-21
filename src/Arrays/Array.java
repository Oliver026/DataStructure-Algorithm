package Arrays;

public class Array<E>{


    private E[] data;
    private int size;

    /**
     * 带参数的构造函数，传入数组的容量capacity构造Array
     * @param capacity
     */
    public Array(int capacity){
        data =(E[]) new Object[capacity];
        size = 0;
    }

    /**
     *无参数的构造函数，默认数组的容量capacity是10
     */
    public Array(){
        this(10);
    }

    /**
     * 获取数组中的元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取数组的长度
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 获取数组是否为口
     * @return  boolean 如果是空，返回true
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在指定的索引位置添加元素
     * 注意：这里如果是添加第0个位置的元素也不会报错，因为当size = 0 时，循环中不满足 -1 >= 0 的条件，所以不进入循环
     * @param index
     * @param e
     */
    public void add(int index, E e){

        if (index < 0 || index > size ){
            throw new IllegalArgumentException("Add failed,Require index < 0 || index > size");
        }
        if (size == data.length){
            resize( 2 * data.length);   //动态扩容，数组容量满了的时候，自动增加原来容量的2倍
        }
        for (int i = size-1;i>=index;i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 在最后一个位置添加元素
     * @param e
     */
    public void addLast(E e){
        this.add(size,e);
    }

    /**
     * 在第一个位置添加元素
     * @param e
     */
    public void addFirst(E e){
        this.add(0,e);
    }

    /**
     *取得指定索引位置的元素
     * @param index
     * @return 返回取得的指定位置的元素
     */
    public E get (int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Get Failed .Index is illegal.");
        }
        return data[index];
    }
    public E getFist(){
        return get(0);
    }
    /**
     * 取得最后一个索引位置的元素，并返回
     * @return
     */
    public E getLast(){
        return get(size-1);
    }
    /**
     *将指定元素放到指定索引位置
     * @param index
     * @param e
     */
    void set (int index,E e){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Get Failed .Index is illegal.");
        }
        data[index] = e;
    }


    /**
     * 查找数组中是否包含元素 e ；只是查找是否包含，而不能查找有多少个
     * @param e
     * @return
     */
    public boolean contains(E e){
        for(int i=0;i<size;i++){
            if (data[i].equals(e)){
                return true;
            }

        }
        return false;
    }

    /**
     * 查找数组中元素e的索引，并返回该元素所在位置的索引，但如果不存在，则返回-1
     * @param e
     * @return
     */
    public int find(E e){
        for (int i = 0;i<size;i++){
            if (data[i].equals(e)){     //值比较和应用比较的区别，equals是值比较， == 是引用比较
                return i;
            }
        }
        return -1;
    }

    /**
     * 移除指定索引位置的元素，并返回该位置初试的值
     * @param index
     * @return
     */
    public E remove(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Remove Failed,Index is illegal");
        }
        /*
        缩容，如果数组的容量小于定义容量的一半，则自动缩容为原来的一半
         */
        if (size <= data.length/2){
            resize(data.length/2);
        }
        E re = data[index];
        for (int i = index+1;i<size;i++){
            data[i-1] = data[i];
        }
        size--;
        return re;
    }

    /**
     * 移除数组的第一个元素，并返回该位置的初试值
     * @return
     */
    public E removeFist(){
        return remove(0);
    }

    /**
     * 移除数组的最后一个元素，并返回该位置的初始值
     * @return
     */
    public E removeLast(){
        return remove(size-1);
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for (int i=0;i<size;i++){
            newData[i] = data[i];
        }
        data = newData;        //让data重新指向newData
    }

    /**
     * 将数组转换成特定格式的字符串,便于打印输出
     * @return
     */

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int i=0;i<size;i++){
            res.append(data[i]);
            if (i != size-1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();

    }
}
