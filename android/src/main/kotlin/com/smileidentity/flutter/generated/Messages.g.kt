// Autogenerated from Pigeon (v10.1.6), do not edit directly.
// See also: https://pub.dev/packages/pigeon


import android.util.Log
import io.flutter.plugin.common.BasicMessageChannel
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MessageCodec
import io.flutter.plugin.common.StandardMessageCodec
import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer

private fun wrapResult(result: Any?): List<Any?> {
    return listOf(result)
}

private fun wrapError(exception: Throwable): List<Any?> {
    if (exception is FlutterError) {
        return listOf(
            exception.code,
            exception.message,
            exception.details
        )
    } else {
        return listOf(
            exception.javaClass.simpleName,
            exception.toString(),
            "Cause: " + exception.cause + ", Stacktrace: " + Log.getStackTraceString(exception)
        )
    }
}

/**
 * Error class for passing custom error details to Flutter via a thrown PlatformException.
 * @property code The error code.
 * @property message The error message.
 * @property details The error details. Must be a datatype supported by the api codec.
 */
class FlutterError (
    val code: String,
    override val message: String? = null,
    val details: Any? = null
) : Throwable()

enum class FlutterJobType(val raw: Int) {
    ENHANCEDKYC(0),
    DOCUMENTVERIFICATION(1);

    companion object {
        fun ofRaw(raw: Int): FlutterJobType? {
            return values().firstOrNull { it.raw == raw }
        }
    }
}

/**
 *  Custom values specific to partners can be placed in [extras]
 *
 * Generated class from Pigeon that represents data sent in messages.
 */
data class FlutterPartnerParams (
    val jobType: FlutterJobType? = null,
    val jobId: String,
    val userId: String,
    val extras: Map<String?, String?>? = null

) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun fromList(list: List<Any?>): FlutterPartnerParams {
            val jobType: FlutterJobType? = (list[0] as Int?)?.let {
                FlutterJobType.ofRaw(it)
            }
            val jobId = list[1] as String
            val userId = list[2] as String
            val extras = list[3] as Map<String?, String?>?
            return FlutterPartnerParams(jobType, jobId, userId, extras)
        }
    }
    fun toList(): List<Any?> {
        return listOf<Any?>(
            jobType?.raw,
            jobId,
            userId,
            extras,
        )
    }
}

/**
 * The Auth Smile request. Auth Smile serves multiple purposes:
 *
 * - It is used to fetch the signature needed for subsequent API requests
 * - It indicates the type of job that will being performed
 * - It is used to fetch consent information for the partner
 *
 * [jobType] The type of job that will be performed
 * [country] The country code of the country where the job is being performed. This value is
 * required in order to get back consent information for the partner
 * [idType] The type of ID that will be used for the job. This value is required in order to
 * get back consent information for the partner
 * [updateEnrolledImage] Whether or not the enrolled image should be updated with image
 * submitted for this job
 * [jobId] The job ID to associate with the job. Most often, this will correspond to a unique
 * Job ID within your own system. If not provided, a random job ID will be generated
 * [userId] The user ID to associate with the job. Most often, this will correspond to a unique
 * User ID within your own system. If not provided, a random user ID will be generated
 *
 * Generated class from Pigeon that represents data sent in messages.
 */
data class FlutterAuthenticationRequest (
    val jobType: FlutterJobType,
    val country: String? = null,
    val idType: String? = null,
    val updateEnrolledImage: Boolean? = null,
    val jobId: String? = null,
    val userId: String? = null

) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun fromList(list: List<Any?>): FlutterAuthenticationRequest {
            val jobType = FlutterJobType.ofRaw(list[0] as Int)!!
            val country = list[1] as String?
            val idType = list[2] as String?
            val updateEnrolledImage = list[3] as Boolean?
            val jobId = list[4] as String?
            val userId = list[5] as String?
            return FlutterAuthenticationRequest(jobType, country, idType, updateEnrolledImage, jobId, userId)
        }
    }
    fun toList(): List<Any?> {
        return listOf<Any?>(
            jobType.raw,
            country,
            idType,
            updateEnrolledImage,
            jobId,
            userId,
        )
    }
}

/**
 * [consentInfo] is only populated when a country and ID type are provided in the
 * [FlutterAuthenticationRequest]. To get information about *all* countries and ID types instead,
 *  [SmileIDService.getProductsConfig]
 *
 * [timestamp] is *not* a [DateTime] because technically, any arbitrary value could have been
 * passed to it. This applies to all other timestamp fields in the SDK.
 *
 * Generated class from Pigeon that represents data sent in messages.
 */
data class FlutterAuthenticationResponse (
    val success: Boolean,
    val signature: String,
    val timestamp: String,
    val partnerParams: FlutterPartnerParams,
    val callbackUrl: String? = null,
    val consentInfo: FlutterConsentInfo? = null

) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun fromList(list: List<Any?>): FlutterAuthenticationResponse {
            val success = list[0] as Boolean
            val signature = list[1] as String
            val timestamp = list[2] as String
            val partnerParams = FlutterPartnerParams.fromList(list[3] as List<Any?>)
            val callbackUrl = list[4] as String?
            val consentInfo: FlutterConsentInfo? = (list[5] as List<Any?>?)?.let {
                FlutterConsentInfo.fromList(it)
            }
            return FlutterAuthenticationResponse(success, signature, timestamp, partnerParams, callbackUrl, consentInfo)
        }
    }
    fun toList(): List<Any?> {
        return listOf<Any?>(
            success,
            signature,
            timestamp,
            partnerParams.toList(),
            callbackUrl,
            consentInfo?.toList(),
        )
    }
}

/**
 * [canAccess] Whether or not the ID type is enabled for the partner
 * [consentRequired] Whether or not consent is required for the ID type
 *
 * Generated class from Pigeon that represents data sent in messages.
 */
data class FlutterConsentInfo (
    val canAccess: Boolean,
    val consentRequired: Boolean

) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun fromList(list: List<Any?>): FlutterConsentInfo {
            val canAccess = list[0] as Boolean
            val consentRequired = list[1] as Boolean
            return FlutterConsentInfo(canAccess, consentRequired)
        }
    }
    fun toList(): List<Any?> {
        return listOf<Any?>(
            canAccess,
            consentRequired,
        )
    }
}

/**
 * [timestamp] is *not* a [DateTime] because technically, any arbitrary value could have been
 * passed to it. This applies to all other timestamp fields in the SDK.
 *
 * Generated class from Pigeon that represents data sent in messages.
 */
data class FlutterEnhancedKycRequest (
    val country: String,
    val idType: String,
    val idNumber: String,
    val firstName: String? = null,
    val middleName: String? = null,
    val lastName: String? = null,
    val dob: String? = null,
    val phoneNumber: String? = null,
    val bankCode: String? = null,
    val callbackUrl: String? = null,
    val partnerParams: FlutterPartnerParams,
    val timestamp: String,
    val signature: String

) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun fromList(list: List<Any?>): FlutterEnhancedKycRequest {
            val country = list[0] as String
            val idType = list[1] as String
            val idNumber = list[2] as String
            val firstName = list[3] as String?
            val middleName = list[4] as String?
            val lastName = list[5] as String?
            val dob = list[6] as String?
            val phoneNumber = list[7] as String?
            val bankCode = list[8] as String?
            val callbackUrl = list[9] as String?
            val partnerParams = FlutterPartnerParams.fromList(list[10] as List<Any?>)
            val timestamp = list[11] as String
            val signature = list[12] as String
            return FlutterEnhancedKycRequest(country, idType, idNumber, firstName, middleName, lastName, dob, phoneNumber, bankCode, callbackUrl, partnerParams, timestamp, signature)
        }
    }
    fun toList(): List<Any?> {
        return listOf<Any?>(
            country,
            idType,
            idNumber,
            firstName,
            middleName,
            lastName,
            dob,
            phoneNumber,
            bankCode,
            callbackUrl,
            partnerParams.toList(),
            timestamp,
            signature,
        )
    }
}

/** Generated class from Pigeon that represents data sent in messages. */
data class FlutterEnhancedKycAsyncResponse (
    val success: Boolean

) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun fromList(list: List<Any?>): FlutterEnhancedKycAsyncResponse {
            val success = list[0] as Boolean
            return FlutterEnhancedKycAsyncResponse(success)
        }
    }
    fun toList(): List<Any?> {
        return listOf<Any?>(
            success,
        )
    }
}

@Suppress("UNCHECKED_CAST")
private object SmileIDApiCodec : StandardMessageCodec() {
    override fun readValueOfType(type: Byte, buffer: ByteBuffer): Any? {
        return when (type) {
            128.toByte() -> {
                return (readValue(buffer) as? List<Any?>)?.let {
                    FlutterAuthenticationRequest.fromList(it)
                }
            }
            129.toByte() -> {
                return (readValue(buffer) as? List<Any?>)?.let {
                    FlutterAuthenticationResponse.fromList(it)
                }
            }
            130.toByte() -> {
                return (readValue(buffer) as? List<Any?>)?.let {
                    FlutterConsentInfo.fromList(it)
                }
            }
            131.toByte() -> {
                return (readValue(buffer) as? List<Any?>)?.let {
                    FlutterEnhancedKycAsyncResponse.fromList(it)
                }
            }
            132.toByte() -> {
                return (readValue(buffer) as? List<Any?>)?.let {
                    FlutterEnhancedKycRequest.fromList(it)
                }
            }
            133.toByte() -> {
                return (readValue(buffer) as? List<Any?>)?.let {
                    FlutterPartnerParams.fromList(it)
                }
            }
            else -> super.readValueOfType(type, buffer)
        }
    }
    override fun writeValue(stream: ByteArrayOutputStream, value: Any?)   {
        when (value) {
            is FlutterAuthenticationRequest -> {
                stream.write(128)
                writeValue(stream, value.toList())
            }
            is FlutterAuthenticationResponse -> {
                stream.write(129)
                writeValue(stream, value.toList())
            }
            is FlutterConsentInfo -> {
                stream.write(130)
                writeValue(stream, value.toList())
            }
            is FlutterEnhancedKycAsyncResponse -> {
                stream.write(131)
                writeValue(stream, value.toList())
            }
            is FlutterEnhancedKycRequest -> {
                stream.write(132)
                writeValue(stream, value.toList())
            }
            is FlutterPartnerParams -> {
                stream.write(133)
                writeValue(stream, value.toList())
            }
            else -> super.writeValue(stream, value)
        }
    }
}

/** Generated interface from Pigeon that represents a handler of messages from Flutter. */
interface SmileIDApi {
    fun initialize()
    fun setEnvironment(useSandbox: Boolean)
    fun setCallbackUrl(callbackUrl: String)
    fun authenticate(request: FlutterAuthenticationRequest, callback: (Result<FlutterAuthenticationResponse>) -> Unit)
    fun doEnhancedKycAsync(request: FlutterEnhancedKycRequest, callback: (Result<FlutterEnhancedKycAsyncResponse>) -> Unit)

    companion object {
        /** The codec used by SmileIDApi. */
        val codec: MessageCodec<Any?> by lazy {
            SmileIDApiCodec
        }
        /** Sets up an instance of `SmileIDApi` to handle messages through the `binaryMessenger`. */
        @Suppress("UNCHECKED_CAST")
        fun setUp(binaryMessenger: BinaryMessenger, api: SmileIDApi?) {
            run {
                val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.smileid.SmileIDApi.initialize", codec)
                if (api != null) {
                    channel.setMessageHandler { _, reply ->
                        var wrapped: List<Any?>
                        try {
                            api.initialize()
                            wrapped = listOf<Any?>(null)
                        } catch (exception: Throwable) {
                            wrapped = wrapError(exception)
                        }
                        reply.reply(wrapped)
                    }
                } else {
                    channel.setMessageHandler(null)
                }
            }
            run {
                val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.smileid.SmileIDApi.setEnvironment", codec)
                if (api != null) {
                    channel.setMessageHandler { message, reply ->
                        val args = message as List<Any?>
                        val useSandboxArg = args[0] as Boolean
                        var wrapped: List<Any?>
                        try {
                            api.setEnvironment(useSandboxArg)
                            wrapped = listOf<Any?>(null)
                        } catch (exception: Throwable) {
                            wrapped = wrapError(exception)
                        }
                        reply.reply(wrapped)
                    }
                } else {
                    channel.setMessageHandler(null)
                }
            }
            run {
                val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.smileid.SmileIDApi.setCallbackUrl", codec)
                if (api != null) {
                    channel.setMessageHandler { message, reply ->
                        val args = message as List<Any?>
                        val callbackUrlArg = args[0] as String
                        var wrapped: List<Any?>
                        try {
                            api.setCallbackUrl(callbackUrlArg)
                            wrapped = listOf<Any?>(null)
                        } catch (exception: Throwable) {
                            wrapped = wrapError(exception)
                        }
                        reply.reply(wrapped)
                    }
                } else {
                    channel.setMessageHandler(null)
                }
            }
            run {
                val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.smileid.SmileIDApi.authenticate", codec)
                if (api != null) {
                    channel.setMessageHandler { message, reply ->
                        val args = message as List<Any?>
                        val requestArg = args[0] as FlutterAuthenticationRequest
                        api.authenticate(requestArg) { result: Result<FlutterAuthenticationResponse> ->
                            val error = result.exceptionOrNull()
                            if (error != null) {
                                reply.reply(wrapError(error))
                            } else {
                                val data = result.getOrNull()
                                reply.reply(wrapResult(data))
                            }
                        }
                    }
                } else {
                    channel.setMessageHandler(null)
                }
            }
            run {
                val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.smileid.SmileIDApi.doEnhancedKycAsync", codec)
                if (api != null) {
                    channel.setMessageHandler { message, reply ->
                        val args = message as List<Any?>
                        val requestArg = args[0] as FlutterEnhancedKycRequest
                        api.doEnhancedKycAsync(requestArg) { result: Result<FlutterEnhancedKycAsyncResponse> ->
                            val error = result.exceptionOrNull()
                            if (error != null) {
                                reply.reply(wrapError(error))
                            } else {
                                val data = result.getOrNull()
                                reply.reply(wrapResult(data))
                            }
                        }
                    }
                } else {
                    channel.setMessageHandler(null)
                }
            }
        }
    }
}
