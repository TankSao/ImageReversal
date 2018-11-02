# ImageReversal
图片左右翻转demo</br>
![image](https://github.com/TankSao/ImageReversal/blob/master/iimage/img1.png)</br>
![image](https://github.com/TankSao/ImageReversal/blob/master/iimage/img2.png)</br>
``` Android
img.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        img.setDrawingCacheEnabled(true);
        Bitmap bitmap = img.getDrawingCache();
        Bitmap modBm = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(),bitmap.getConfig());
        Canvas canvas = new Canvas(modBm);
        Paint paint = new Paint();
        Matrix matrix = new Matrix();
        matrix.setScale(-1,1);//翻转
        matrix.postTranslate(bitmap.getWidth(),0);
        canvas.drawBitmap(bitmap,matrix,paint);
        img.setImageBitmap(modBm);
        img.setDrawingCacheEnabled(false);
    }
});
