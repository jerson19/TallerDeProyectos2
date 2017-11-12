/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.adox.app.util.biometrico;

public class BioMiniJniSDK
{
  public final int UFS_OK = 0;
  public final int UFS_STATUS = 0;
  public final int UFS_ERROR = -1;
  public final int UFS_ERR_NO_LICENSE = -101;
  public final int UFS_ERR_LICENSE_NOT_MATCH = -102;
  public final int UFS_ERR_LICENSE_EXPIRED = -103;
  public final int UFS_ERR_NOT_SUPPORTED = -111;
  public final int UFS_ERR_INVALID_PARAMETERS = -112;
  public final int UFS_ERR_ALREADY_INITIALIZED = -201;
  public final int UFS_ERR_NOT_INITIALIZED = -202;
  public final int UFS_ERR_DEVICE_NUMBER_EXCEED = -203;
  public final int UFS_ERR_LOAD_SCANNER_LIBRARY = -204;
  public final int UFS_ERR_CAPTURE_RUNNING = -211;
  public final int UFS_ERR_CAPTURE_FAILED = -212;
  public final int UFS_ERR_FAKE_FINGER = -221;
  public final int UFS_ERR_FINGER_ON_SENSOR = -231;
  public final int UFS_ERR_NOT_GOOD_IMAGE = -301;
  public final int UFS_ERR_EXTRACTION_FAILED = -302;
  public final int UFS_ERR_CORE_NOT_DETECTED = -351;
  public final int UFS_ERR_CORE_TO_LEFT = -352;
  public final int UFS_ERR_CORE_TO_LEFT_TOP = -353;
  public final int UFS_ERR_CORE_TO_TOP = -354;
  public final int UFS_ERR_CORE_TO_RIGHT_TOP = -355;
  public final int UFS_ERR_CORE_TO_RIGHT = -356;
  public final int UFS_ERR_CORE_TO_RIGHT_BOTTOM = -357;
  public final int UFS_ERR_CORE_TO_BOTTOM = -358;
  public final int UFS_ERR_CORE_TO_LEFT_BOTTOM = -359;
  public final int UFS_PARAM_TIMEOUT = 201;
  public final int UFS_PARAM_BRIGHTNESS = 202;
  public final int UFS_PARAM_SENSITIVITY = 203;
  public final int UFS_PARAM_SERIAL = 204;
  public final int UFS_PARAM_DETECT_CORE = 301;
  public final int UFS_PARAM_TEMPLATE_SIZE = 302;
  public final int UFS_PARAM_USE_SIF = 311;
  public final int UFS_PARAM_CHECK_ENROLL_QUALITY = 321;
  public final int UFS_PARAM_DETECT_FAKE = 312;
  public final int UFS_SCANNER_TYPE_SFR200 = 1001;
  public final int UFS_SCANNER_TYPE_SFR300 = 1002;
  public final int UFS_SCANNER_TYPE_SFR300v2 = 1003;
  public final int UFS_SCANNER_TYPE_SFR500 = 1004;
  public final int UFS_TEMPLATE_TYPE_SUPREMA = 2001;
  public final int UFS_TEMPLATE_TYPE_ISO19794_2 = 2002;
  public final int UFS_TEMPLATE_TYPE_ANSI378 = 2003;
  public final int UFMOK = 0;
  public final int UFMERROR = -1;
  public final int UFMERR_NO_LICENSE = -101;
  public final int UFMERR_LICENSE_NOT_MATCH = -102;
  public final int UFMERR_LICENSE_EXPIRED = -103;
  public final int UFMERR_NOT_SUPPORTED = -111;
  public final int UFMERR_INVALID_PARAMETERS = -112;
  public final int UFM_ERR_MATCH_TIMEOUT = -401;
  public final int UFM_ERR_MATCH_ABORTED = -402;
  public final int UFM_ERR_TEMPLATE_TYPE = -411;
  public final int UFM_PARAM_FAST_MODE = 301;
  public final int UFM_PARAM_SECURITY_LEVEL = 302;
  public final int UFM_PARAM_USE_SIF = 311;
  public final int UFM_TEMPLATE_TYPE_SUPREMA = 2001;
  public final int UFM_TEMPLATE_TYPE_ISO19794_2 = 2002;
  public final int UFM_TEMPLATE_TYPE_ANSI378 = 2003;
  
  public native int UFS_Init();
  
  public native int UFS_Update();
  
  public native int UFS_Uninit();
  
  public native int UFS_SetScannerCallback(String paramString);
  
  public native int UFS_RemoveScannerCallback();
  
  public native int UFS_SetClassName(String paramString);
  
  public native int UFS_GetScannerNumber(int[] paramArrayOfInt);
  
  public native int UFS_GetScannerHandle(int paramInt, long[] paramArrayOfLong);
  
  public native int UFS_GetScannerHandleByID(String paramString, long[] paramArrayOfLong);
  
  public native int UFS_GetScannerIndex(long paramLong, int[] paramArrayOfInt);
  
  public native int UFS_GetScannerID(long paramLong, byte[] paramArrayOfByte);
  
  public native int UFS_GetCompanyID(long paramLong, byte[] paramArrayOfByte);
  
  public native int UFS_GetScannerType(long paramLong, int[] paramArrayOfInt);
  
  public native int UFS_GetParameter(long paramLong, int paramInt, int[] paramArrayOfInt);
  
  public native int UFS_SetParameter(long paramLong, int paramInt, int[] paramArrayOfInt);
  
  public native int UFS_IsSensorOn(long paramLong, int[] paramArrayOfInt);
  
  public native int UFS_IsFingerOn(long paramLong, int[] paramArrayOfInt);
  
  public native int UFS_CaptureSingleImage(long paramLong);
  
  public native int UFS_StartCapturing(long paramLong, String paramString);
  
  public native int UFS_IsCapturing(long paramLong, int[] paramArrayOfInt);
  
  public native int UFS_AbortCapturing(long paramLong);
  
  public native int UFS_Extract(long paramLong, byte[] paramArrayOfByte, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  public native int UFS_SetEncryptionKey(long paramLong, byte[] paramArrayOfByte);
  
  public native int UFS_EncryptTemplate(long paramLong, byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2, int[] paramArrayOfInt);
  
  public native int UFS_DecryptTemplate(long paramLong, byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2, int[] paramArrayOfInt);
  
  public native int UFS_GetCaptureImageBufferInfo(long paramLong, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3);
  
  public native int UFS_GetCaptureImageBuffer(long paramLong, byte[] paramArrayOfByte);
  
  public native int UFS_SaveCaptureImageBufferToBMP(long paramLong, String paramString);
  
  public native int UFS_SaveCaptureImageBufferTo19794_4(long paramLong, String paramString);
  
  public native int UFS_ClearCaptureImageBuffer(long paramLong);
  
  public native int UFS_SaveCaptureImageBufferToWSQ(long paramLong, float paramFloat, String paramString);
  
  public native int UFS_GetFeatureNumber(long paramLong, byte[] paramArrayOfByte, int paramInt, int[] paramArrayOfInt);
  
  public native int UFS_GetErrorString(int paramInt, byte[] paramArrayOfByte);
  
  public native int UFS_SetTemplateType(long paramLong, int paramInt);
  
  public native int UFS_GetTemplateType(long paramLong, int[] paramArrayOfInt);
  
  public native int UFS_SelectTemplate(long paramLong, byte[][] paramArrayOfByte1, int[] paramArrayOfInt1, int paramInt1, byte[][] paramArrayOfByte2, int[] paramArrayOfInt2, int paramInt2);
  
  public native int UFM_Create(long[] paramArrayOfLong);
  
  public native int UFM_Delete(long paramLong);
  
  public native int UFM_GetParameter(long paramLong, int paramInt, int[] paramArrayOfInt);
  
  public native int UFM_SetParameter(long paramLong, int paramInt, int[] paramArrayOfInt);
  
  public native int UFM_Verify(long paramLong, byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int[] paramArrayOfInt);
  
  public native int UFM_Identify(long paramLong, byte[] paramArrayOfByte, int paramInt1, byte[][] paramArrayOfByte1, int[] paramArrayOfInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt2);
  
  public native int UFM_IdentifyMT(long paramLong, byte[] paramArrayOfByte, int paramInt1, byte[][] paramArrayOfByte1, int[] paramArrayOfInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt2);
  
  public native int UFM_AbortIdentify(long paramLong);
  
  public native int UFM_IdentifyInit(long paramLong, byte[] paramArrayOfByte, int paramInt);
  
  public native int UFM_IdentifyNext(long paramLong, byte[] paramArrayOfByte, int paramInt, int[] paramArrayOfInt);
  
  public native int UFM_RotateTemplate(long paramLong, byte[] paramArrayOfByte, int paramInt);
  
  public native int UFM_GetErrorString(int paramInt, byte[] paramArrayOfByte);
  
  public native int UFM_SetTemplateType(long paramLong, int paramInt);
  
  public native int UFM_GetTemplateType(long paramLong, int[] paramArrayOfInt);
  
  static
  {
    System.loadLibrary("BioMiniJniSDK");
  }
}
