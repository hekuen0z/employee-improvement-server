package bsuir.diplom.serverapplication.utilities;

import bsuir.diplom.serverapplication.constants.StockMessageProto;
import bsuir.diplom.serverapplication.constants.StockMessageProto.StockMessage;

import java.util.HashMap;

public class ProtoMessageUtil {
    public static StockMessage createRegistrationRequest(
            String username, String password, HashMap<String, String> regData) {
        StockMessageProto.RegistrationRequest.Builder registrationRequestBuilder = StockMessageProto.RegistrationRequest.newBuilder();
        registrationRequestBuilder.setUsername(username);
        registrationRequestBuilder.setPassword(password);
        registrationRequestBuilder.putAllRegData(regData);

        StockMessage.Builder messageBuilder = StockMessage.newBuilder();
        messageBuilder.setCommandType(StockMessageProto.CommandType.REGISTRATION);
        messageBuilder.setRegistrationRequest(registrationRequestBuilder);
        return messageBuilder.build();
    }

    public static StockMessage createRegistrationResponse(boolean result, int code, String msg, String uid, String token, String sessionId) {
        StockMessageProto.RegistrationResponse.Builder registrationResponseBuilder = StockMessageProto.RegistrationResponse.newBuilder();
        registrationResponseBuilder.setResult(result);
        registrationResponseBuilder.setCode(code);
        registrationResponseBuilder.setMsg(msg);
        registrationResponseBuilder.setUid(uid);
        registrationResponseBuilder.setToken(token);
        registrationResponseBuilder.setSessionId(sessionId);

        StockMessage.Builder messageBuilder = StockMessage.newBuilder();
        messageBuilder.setCommandType(StockMessageProto.CommandType.REGISTRATION_BACK);
        messageBuilder.setRegistrationResponse(registrationResponseBuilder);

        return messageBuilder.build();
    }

    public static StockMessage createAuthRequest(String username, String password) {
        StockMessageProto.AuthRequest.Builder authRequestBuilder = StockMessageProto.AuthRequest.newBuilder();
        authRequestBuilder.setUsername(username);
        authRequestBuilder.setPassword(password);

        StockMessage.Builder messageBuilder = StockMessage.newBuilder();
        messageBuilder.setCommandType(StockMessageProto.CommandType.AUTH);
        messageBuilder.setAuthRequest(authRequestBuilder);
        return messageBuilder.build();
    }

    public static StockMessage createAuthResponse(boolean result, int code, String msg,String uid, String token, String sessionId) {
        StockMessageProto.AuthResponse.Builder authResponseBuilder = StockMessageProto.AuthResponse.newBuilder();
        authResponseBuilder.setResult(result);
        authResponseBuilder.setCode(code);
        authResponseBuilder.setMsg(msg);
        authResponseBuilder.setUid(uid);
        authResponseBuilder.setToken(token);
        authResponseBuilder.setSessionId(sessionId);

        StockMessage.Builder messageBuilder = StockMessage.newBuilder();
        messageBuilder.setCommandType(StockMessageProto.CommandType.AUTH_BACK);
        messageBuilder.setAuthResponse(authResponseBuilder);

        return messageBuilder.build();
    }

    public static StockMessage createLogoutRequest(String uid, String token, String sessionId) {
        StockMessageProto.LogoutRequest.Builder logoutRequestBuilder = StockMessageProto.LogoutRequest.newBuilder();
        logoutRequestBuilder.setUid(uid);
        logoutRequestBuilder.setToken(token);
        logoutRequestBuilder.setSessionId(sessionId);

        StockMessage.Builder messageBuilder = StockMessage.newBuilder();
        messageBuilder.setCommandType(StockMessageProto.CommandType.LOGOUT);
        messageBuilder.setLogoutRequest(logoutRequestBuilder);
        return messageBuilder.build();
    }

    public static StockMessage createLogoutResponse(boolean result, int code, String msg) {
        StockMessageProto.LogoutResponse.Builder logoutResponseBuilder = StockMessageProto.LogoutResponse.newBuilder();
        logoutResponseBuilder.setResult(result);
        logoutResponseBuilder.setCode(code);
        logoutResponseBuilder.setMsg(msg);

        StockMessage.Builder messageBuilder = StockMessage.newBuilder();
        messageBuilder.setCommandType(StockMessageProto.CommandType.LOGOUT_BACK);
        messageBuilder.setLogoutResponse(logoutResponseBuilder);

        return messageBuilder.build();
    }

    public static StockMessage createPing(String uid, String token, String sessionId){
        StockMessageProto.Ping.Builder pingBuilder = StockMessageProto.Ping.newBuilder();
        pingBuilder.setUid(uid);
        pingBuilder.setToken(token);
        pingBuilder.setSessionId(sessionId);

        StockMessage.Builder messageBuilder = StockMessage.newBuilder();
        messageBuilder.setCommandType(StockMessageProto.CommandType.PING);
        messageBuilder.setPing(pingBuilder);
        return messageBuilder.build();
    }

    public static StockMessage createPong(boolean result, int code, String msg){
        StockMessageProto.Pong.Builder pongBuilder = StockMessageProto.Pong.newBuilder();
        pongBuilder.setResult(result);
        pongBuilder.setCode(code);
        pongBuilder.setMsg(msg);

        StockMessage.Builder messageBuilder = StockMessage.newBuilder();
        messageBuilder.setCommandType(StockMessageProto.CommandType.PONG);
        messageBuilder.setPong(pongBuilder);
        return messageBuilder.build();
    }

    public static StockMessage createMessageRequest(String uid, String token, String sessionId, String toUid, String toGroup, String msg, int timeStamp){
        StockMessageProto.MessageRequest.Builder messageRequestBuilder = StockMessageProto.MessageRequest.newBuilder();
        messageRequestBuilder.setUid(uid);
        messageRequestBuilder.setToken(token);
        messageRequestBuilder.setSessionId(sessionId);
        messageRequestBuilder.setToUid(toUid);
        messageRequestBuilder.setToGroup(toGroup);
        messageRequestBuilder.setMessage(msg);
        messageRequestBuilder.setTimeStamp(timeStamp);

        StockMessage.Builder messageBuilder = StockMessage.newBuilder();
        messageBuilder.setCommandType(StockMessageProto.CommandType.SEND_MESSAGE);
        messageBuilder.setMessageRequest(messageRequestBuilder);
        return messageBuilder.build();
    }

    public static StockMessage createMessageResponse(boolean result, int code, String msg){
        StockMessageProto.MessageResponse.Builder messageResponseBuilder = StockMessageProto.MessageResponse.newBuilder();
        messageResponseBuilder.setResult(result);
        messageResponseBuilder.setCode(code);
        messageResponseBuilder.setMsg(msg);

        StockMessage.Builder messageBuilder = StockMessage.newBuilder();
        messageBuilder.setCommandType(StockMessageProto.CommandType.SEND_MESSAGE_BACK);
        messageBuilder.setMessageResponse(messageResponseBuilder);
        return messageBuilder.build();
    }

    public static StockMessage createDownloadRequest(String uid, String token, String sessionId, String criteria, int timeStamp){
        StockMessageProto.DownloadDataRequest.Builder downloadDataRequestBuilder = StockMessageProto.DownloadDataRequest.newBuilder();
        downloadDataRequestBuilder.setUid(uid);
        downloadDataRequestBuilder.setToken(token);
        downloadDataRequestBuilder.setSessionId(sessionId);
        downloadDataRequestBuilder.setCriteria(criteria);
        downloadDataRequestBuilder.setTimeStamp(timeStamp);

        StockMessage.Builder messageBuilder = StockMessage.newBuilder();
        messageBuilder.setCommandType(StockMessageProto.CommandType.DOWNLOAD_DATA);
        messageBuilder.setDownloadDataRequest(downloadDataRequestBuilder);
        return messageBuilder.build();
    }

    public static StockMessage createDownloadResponse(boolean result, int code, String msg){
        StockMessageProto.DownloadDataResponse.Builder downloadDataResponseBuilder = StockMessageProto.DownloadDataResponse.newBuilder();
        downloadDataResponseBuilder.setResult(result);
        downloadDataResponseBuilder.setCode(code);
        downloadDataResponseBuilder.setMsg(msg);

        StockMessage.Builder messageBuilder = StockMessage.newBuilder();
        messageBuilder.setCommandType(StockMessageProto.CommandType.DOWNLOAD_DATA_BACK);
        messageBuilder.setDownloadDataResponse(downloadDataResponseBuilder);
        return messageBuilder.build();
    }

    public static StockMessage createUploadRequest(String uid, String token, String sessionId, HashMap<String, String> data, int timeStamp){
        StockMessageProto.UploadDataRequest.Builder uploadDataRequestBuilder = StockMessageProto.UploadDataRequest.newBuilder();
        uploadDataRequestBuilder.setUid(uid);
        uploadDataRequestBuilder.setToken(token);
        uploadDataRequestBuilder.setSessionId(sessionId);
        uploadDataRequestBuilder.putAllData(data);
        uploadDataRequestBuilder.setTimeStamp(timeStamp);

        StockMessage.Builder messageBuilder = StockMessage.newBuilder();
        messageBuilder.setCommandType(StockMessageProto.CommandType.UPLOAD_DATA);
        messageBuilder.setUploadDataRequest(uploadDataRequestBuilder);
        return messageBuilder.build();
    }

    public static StockMessage createUploadResponse(boolean result, int code, String msg){
        StockMessageProto.UploadDataResponse.Builder uploadDataResponseBuilder = StockMessageProto.UploadDataResponse.newBuilder();
        uploadDataResponseBuilder.setResult(result);
        uploadDataResponseBuilder.setCode(code);
        uploadDataResponseBuilder.setMsg(msg);

        StockMessage.Builder messageBuilder = StockMessage.newBuilder();
        messageBuilder.setCommandType(StockMessageProto.CommandType.UPLOAD_DATA_BACK);
        messageBuilder.setUploadDataResponse(uploadDataResponseBuilder);
        return messageBuilder.build();
    }

}
