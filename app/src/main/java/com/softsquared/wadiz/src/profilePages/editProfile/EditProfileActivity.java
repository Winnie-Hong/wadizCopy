package com.softsquared.wadiz.src.profilePages.editProfile;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.loader.content.CursorLoader;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;
import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseActivity;
import com.softsquared.wadiz.src.login.LoginActivity;
import com.softsquared.wadiz.src.profilePages.editProfile.interfaces.EditProfileView;
import com.softsquared.wadiz.src.signUp.EmailSignUpActivity;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static android.view.View.GONE;
import static android.view.View.INVISIBLE;

public class EditProfileActivity extends BaseActivity implements EditProfileView{

    private Uri imgUri;
    private Uri albumURI;
    private String mCurrentPhotoPath;
    String profileUrl=null;
    private static final int FROM_CAMERA = 0;
    private static final int FROM_ALBUM = 1;
    Boolean isImageSet;

    ImageView mProfileImgBg;
    ImageView mProfileImg;
    TextView mUploadImg;
    TextView mChangeImg;
    TextView mDeleteImg;
    LinearLayout mUploadLayout;
    LinearLayout mEditLayout;
    Button mCancelBtn;
    Button mOkBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        mProfileImgBg = findViewById(R.id.profile_profile_img_background);
        mProfileImg = findViewById(R.id.profile_profile_img);
        mUploadImg = findViewById(R.id.upload_profile_img_btn);
        mChangeImg = findViewById(R.id.change_profile_img_btn);
        mDeleteImg = findViewById(R.id.delete_profile_img_btn);
        mUploadLayout = findViewById(R.id.upload_profile_image_layout);
        mEditLayout = findViewById(R.id.edit_profile_image_layout);
        mCancelBtn = findViewById(R.id.edit_profile_cancel_btn);
        mOkBtn = findViewById(R.id.edit_profile_ok_btn);

        //이미지 동그랗게
        mProfileImg.setBackground(new ShapeDrawable(new OvalShape()));
        mProfileImg.setClipToOutline(true);

        mProfileImgBg.setBackground(new ShapeDrawable(new OvalShape()));
        mProfileImgBg.setClipToOutline(true);


        //프로파일 이미지 있는지 확인
        isImageSet();

        //취소버튼
        mCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //확인버튼
        mOkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editProfileImg(profileUrl);
                finish();
            }
        });


        //사진 접근 허용 리스너
        PermissionListener permissionlistener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                Toast.makeText(EditProfileActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPermissionDenied(List<String> deniedPermissions) {
                Toast.makeText(EditProfileActivity.this, "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
            }

        };

        //권한체크
        TedPermission.with(this)
                .setPermissionListener(permissionlistener)
                .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission] ")
                .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA)
                .check();

        //앨범선택, 사진촬영, 취소 다이얼로그 생성
        mUploadImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeImgSelectDialog();
            }
        });

        //이미지 변경 버튼
        mChangeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeImgSelectDialog();
            }
        });

        //이미지 삭제 버튼
        mDeleteImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeImgDeleteDialog();
            }
        });

    }//onCreate

    //프로파일 사진 수정
    private void editProfileImg(String profileUrl) {
        showProgressDialog();
        final EditProfileService editProfileService = new EditProfileService((EditProfileView) this);
        editProfileService.patchEditProfileImg(profileUrl);
    }

    public void validateFailure(String message) {
        hideProgressDialog();
    }

    @Override
    public void patchProfileImgSuccess(String result, String jwt) {
        hideProgressDialog();
        showCustomToast("프로필 사진이 저장되었습니다.");
    }


    //사진 선택 다이얼로그
    private void makeImgSelectDialog() {
        AlertDialog.Builder alt_bld = new AlertDialog.Builder(EditProfileActivity.this);
        alt_bld.setTitle("사진 업로드").setCancelable(false).setPositiveButton("사진촬영",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Log.d("알림", "다이얼로그 > 사진촬영 선택");
                        // 사진 촬영 클릭
                        takePhoto();
                    }
                }).setNeutralButton("앨범선택",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int id) {
                        Log.d("알림", "다이얼로그 > 앨범선택 선택");
                        //앨범에서 선택
                        selectAlbum();
                    }
                }).setNegativeButton("취소   ",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Log.v("알림", "다이얼로그 > 취소 선택");
                        // 취소 클릭. dialog 닫기
                        dialog.cancel();
                    }
                });
        AlertDialog alert = alt_bld.create();
        alert.show();
    }

    //사진 삭제 다이얼로그
    private void makeImgDeleteDialog() {
        AlertDialog.Builder delete_alt_bld = new AlertDialog.Builder(EditProfileActivity.this);
        delete_alt_bld.setTitle("프로필 사진을 삭제하시겠습니까?").setCancelable(false).setPositiveButton("취소",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                }).setNegativeButton("확인",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                        mProfileImg.setVisibility(INVISIBLE);
                    }
                });
        AlertDialog alert = delete_alt_bld.create();
        alert.show();
    }

    //앨범 선택 클릭
    public void selectAlbum() {
        //앨범 열기
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
        intent.setType("image/*");
        startActivityForResult(intent, FROM_ALBUM);
    }

    //사진 찍기 클릭
    public void takePhoto() {
        // 촬영 후 이미지 가져옴
        String state = Environment.getExternalStorageState();

        if (Environment.MEDIA_MOUNTED.equals(state)) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (intent.resolveActivity(getPackageManager()) != null) {
                File photoFile = null;
                try {
                    photoFile = createImageFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (photoFile != null) {
                    Uri providerURI = FileProvider.getUriForFile(this, getPackageName(), photoFile);
                    imgUri = providerURI;
                    intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, providerURI);
                    startActivityForResult(intent, FROM_CAMERA);
                }
            }
        } else {
            Log.d("알림", "저장공간에 접근 불가능");
            return;
        }
    }

    //create imgFile
    public File createImageFile() throws IOException {
        String imgFileName = System.currentTimeMillis() + ".jpg";
        File imageFile = null;
//    File storageDir = new File(Environment.getExternalStorageDirectory() + "/Pictures", "ireh");
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        if (!storageDir.exists()) {
            Log.v("알림", "storageDir 존재 x " + storageDir.toString());
            storageDir.mkdirs();
        }

        Log.v("알림", "storageDir 존재함 " + storageDir.toString());
        imageFile = new File(storageDir, imgFileName);
        mCurrentPhotoPath = imageFile.getAbsolutePath();
        return imageFile;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != RESULT_OK) {
            return;
        }
        switch (requestCode) {
            case FROM_ALBUM: {
                //앨범에서 가져오기
                if (data.getData() != null) {
                    try {
                        File albumFile = null;
                        albumFile = createImageFile();
                        Uri photoURI = data.getData();
                        String photoUriPath = getPath(photoURI);

                        albumURI = Uri.fromFile(albumFile);

                        uploadToFirebase(photoUriPath);
                        mProfileImg.setImageURI(photoURI);
                        //cropImage();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.d("알림", "앨범에서 가져오기 에러");
                    }
                }
                break;
            }
            case FROM_CAMERA: {
                //촬영
                try {
                    Log.d("알림", "FROM_CAMERA 처리");
                    mProfileImg.setImageURI(imgUri);
                    String photoUriPath = getPath(imgUri);
                    uploadToFirebase(photoUriPath);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    //절대경로 가져오기
    private String getPath(Uri uriPath) {
        String[] proj = {MediaStore.Images.Media.DATA};
        CursorLoader cursorLoader = new CursorLoader(this, uriPath, proj, null, null, null);
        Cursor cursor = cursorLoader.loadInBackground();
        int index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

        cursor.moveToFirst();
        return cursor.getString(index);
    }

//파이어베이스에 업로드하기
    private void uploadToFirebase(final String photoUriPath) {
        //업로드할 파일이 있으면 수행
        final Uri file = Uri.fromFile(new File(photoUriPath));
        //업로드 진행 Dialog 보이기
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("업로드중...");
        progressDialog.show();

        //storage
        FirebaseStorage storage = FirebaseStorage.getInstance();

        //파일명
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMHH_mmss");
        Date now = new Date();
        String filename = formatter.format(now) + ".png";

        //storage 주소와 폴더 파일명을 지정해 준다.
        final StorageReference storageRef = storage.getReferenceFromUrl("gs://wadiz-3f34d.appspot.com").child("images/" + filename);
        //파일 업로드
        storageRef.putFile(file)
                //성공시
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        progressDialog.dismiss(); //업로드 진행 Dialog 상자 닫기
                        Toast.makeText(getApplicationContext(), "업로드 완료!", Toast.LENGTH_SHORT).show();
                        mProfileImg.setVisibility(View.VISIBLE);
                        isImageSet();

                        //url경로 받아오기
                        profileUrl = String.valueOf(storageRef.getDownloadUrl());
                    }
                })
                //실패시
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                        Log.d("photoUriPath", photoUriPath + "");
                        Toast.makeText(getApplicationContext(), "업로드 실패!", Toast.LENGTH_SHORT).show();
                    }
                })
                //진행중
                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                        @SuppressWarnings("VisibleForTests") //이걸 넣어 줘야 아랫줄에 에러가 사라진다. 넌 누구냐?
                                double progress = (100 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();
                        //dialog에 진행률을 퍼센트로 출력해 준다
                        progressDialog.setMessage("Uploaded " + ((int) progress) + "% ...");
                    }
                });
    }

    public boolean isImageSet() {
        if (mProfileImg.getVisibility() == View.VISIBLE) {
            isImageSet = true;
            mUploadLayout.setVisibility(GONE);
            mEditLayout.setVisibility(View.VISIBLE);
            mProfileImg.setVisibility(View.VISIBLE);
            Log.d("tag", "이미지 있음");
        } else {
            isImageSet = false;
            mUploadLayout.setVisibility(View.VISIBLE);
            mEditLayout.setVisibility(GONE);
            mProfileImg.setVisibility(INVISIBLE);
            Log.d("tag", "이미지 없음");
        }
        return isImageSet;
    }

}
