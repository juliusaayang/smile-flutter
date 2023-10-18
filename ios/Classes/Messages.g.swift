// Autogenerated from Pigeon (v10.1.6), do not edit directly.
// See also: https://pub.dev/packages/pigeon

import Foundation
#if os(iOS)
import Flutter
#elseif os(macOS)
import FlutterMacOS
#else
#error("Unsupported platform.")
#endif

private func wrapResult(_ result: Any?) -> [Any?] {
  return [result]
}

private func wrapError(_ error: Any) -> [Any?] {
  if let flutterError = error as? FlutterError {
    return [
      flutterError.code,
      flutterError.message,
      flutterError.details
    ]
  }
  return [
    "\(error)",
    "\(type(of: error))",
    "Stacktrace: \(Thread.callStackSymbols)"
  ]
}

private func nilOrValue<T>(_ value: Any?) -> T? {
  if value is NSNull { return nil }
  return value as! T?
}

enum FlutterJobType: Int {
  case enhancedKyc = 0
  case documentVerification = 1
}

///  Custom values specific to partners can be placed in [extras]
///
/// Generated class from Pigeon that represents data sent in messages.
struct FlutterPartnerParams {
  var jobType: FlutterJobType? = nil
  var jobId: String
  var userId: String
  var extras: [String?: String?]? = nil

  static func fromList(_ list: [Any?]) -> FlutterPartnerParams? {
    var jobType: FlutterJobType? = nil
    let jobTypeEnumVal: Int? = nilOrValue(list[0])
    if let jobTypeRawValue = jobTypeEnumVal {
      jobType = FlutterJobType(rawValue: jobTypeRawValue)!
    }
    let jobId = list[1] as! String
    let userId = list[2] as! String
    let extras: [String?: String?]? = nilOrValue(list[3])

    return FlutterPartnerParams(
      jobType: jobType,
      jobId: jobId,
      userId: userId,
      extras: extras
    )
  }
  func toList() -> [Any?] {
    return [
      jobType?.rawValue,
      jobId,
      userId,
      extras,
    ]
  }
}

/// The Auth Smile request. Auth Smile serves multiple purposes:
///
/// - It is used to fetch the signature needed for subsequent API requests
/// - It indicates the type of job that will being performed
/// - It is used to fetch consent information for the partner
///
/// [jobType] The type of job that will be performed
/// [country] The country code of the country where the job is being performed. This value is
/// required in order to get back consent information for the partner
/// [idType] The type of ID that will be used for the job. This value is required in order to
/// get back consent information for the partner
/// [updateEnrolledImage] Whether or not the enrolled image should be updated with image
/// submitted for this job
/// [jobId] The job ID to associate with the job. Most often, this will correspond to a unique
/// Job ID within your own system. If not provided, a random job ID will be generated
/// [userId] The user ID to associate with the job. Most often, this will correspond to a unique
/// User ID within your own system. If not provided, a random user ID will be generated
///
/// Generated class from Pigeon that represents data sent in messages.
struct FlutterAuthenticationRequest {
  var jobType: FlutterJobType
  var country: String? = nil
  var idType: String? = nil
  var updateEnrolledImage: Bool? = nil
  var jobId: String? = nil
  var userId: String? = nil

  static func fromList(_ list: [Any?]) -> FlutterAuthenticationRequest? {
    let jobType = FlutterJobType(rawValue: list[0] as! Int)!
    let country: String? = nilOrValue(list[1])
    let idType: String? = nilOrValue(list[2])
    let updateEnrolledImage: Bool? = nilOrValue(list[3])
    let jobId: String? = nilOrValue(list[4])
    let userId: String? = nilOrValue(list[5])

    return FlutterAuthenticationRequest(
      jobType: jobType,
      country: country,
      idType: idType,
      updateEnrolledImage: updateEnrolledImage,
      jobId: jobId,
      userId: userId
    )
  }
  func toList() -> [Any?] {
    return [
      jobType.rawValue,
      country,
      idType,
      updateEnrolledImage,
      jobId,
      userId,
    ]
  }
}

/// [consentInfo] is only populated when a country and ID type are provided in the
/// [FlutterAuthenticationRequest]. To get information about *all* countries and ID types instead,
///  [SmileIDService.getProductsConfig]
///
/// [timestamp] is *not* a [DateTime] because technically, any arbitrary value could have been
/// passed to it. This applies to all other timestamp fields in the SDK.
///
/// Generated class from Pigeon that represents data sent in messages.
struct FlutterAuthenticationResponse {
  var success: Bool
  var signature: String
  var timestamp: String
  var partnerParams: FlutterPartnerParams
  var callbackUrl: String? = nil
  var consentInfo: FlutterConsentInfo? = nil

  static func fromList(_ list: [Any?]) -> FlutterAuthenticationResponse? {
    let success = list[0] as! Bool
    let signature = list[1] as! String
    let timestamp = list[2] as! String
    let partnerParams = FlutterPartnerParams.fromList(list[3] as! [Any?])!
    let callbackUrl: String? = nilOrValue(list[4])
    var consentInfo: FlutterConsentInfo? = nil
    if let consentInfoList: [Any?] = nilOrValue(list[5]) {
      consentInfo = FlutterConsentInfo.fromList(consentInfoList)
    }

    return FlutterAuthenticationResponse(
      success: success,
      signature: signature,
      timestamp: timestamp,
      partnerParams: partnerParams,
      callbackUrl: callbackUrl,
      consentInfo: consentInfo
    )
  }
  func toList() -> [Any?] {
    return [
      success,
      signature,
      timestamp,
      partnerParams.toList(),
      callbackUrl,
      consentInfo?.toList(),
    ]
  }
}

/// [canAccess] Whether or not the ID type is enabled for the partner
/// [consentRequired] Whether or not consent is required for the ID type
///
/// Generated class from Pigeon that represents data sent in messages.
struct FlutterConsentInfo {
  var canAccess: Bool
  var consentRequired: Bool

  static func fromList(_ list: [Any?]) -> FlutterConsentInfo? {
    let canAccess = list[0] as! Bool
    let consentRequired = list[1] as! Bool

    return FlutterConsentInfo(
      canAccess: canAccess,
      consentRequired: consentRequired
    )
  }
  func toList() -> [Any?] {
    return [
      canAccess,
      consentRequired,
    ]
  }
}

/// [timestamp] is *not* a [DateTime] because technically, any arbitrary value could have been
/// passed to it. This applies to all other timestamp fields in the SDK.
///
/// Generated class from Pigeon that represents data sent in messages.
struct FlutterEnhancedKycRequest {
  var country: String
  var idType: String
  var idNumber: String
  var firstName: String? = nil
  var middleName: String? = nil
  var lastName: String? = nil
  var dob: String? = nil
  var phoneNumber: String? = nil
  var bankCode: String? = nil
  var callbackUrl: String? = nil
  var partnerParams: FlutterPartnerParams
  var timestamp: String
  var signature: String

  static func fromList(_ list: [Any?]) -> FlutterEnhancedKycRequest? {
    let country = list[0] as! String
    let idType = list[1] as! String
    let idNumber = list[2] as! String
    let firstName: String? = nilOrValue(list[3])
    let middleName: String? = nilOrValue(list[4])
    let lastName: String? = nilOrValue(list[5])
    let dob: String? = nilOrValue(list[6])
    let phoneNumber: String? = nilOrValue(list[7])
    let bankCode: String? = nilOrValue(list[8])
    let callbackUrl: String? = nilOrValue(list[9])
    let partnerParams = FlutterPartnerParams.fromList(list[10] as! [Any?])!
    let timestamp = list[11] as! String
    let signature = list[12] as! String

    return FlutterEnhancedKycRequest(
      country: country,
      idType: idType,
      idNumber: idNumber,
      firstName: firstName,
      middleName: middleName,
      lastName: lastName,
      dob: dob,
      phoneNumber: phoneNumber,
      bankCode: bankCode,
      callbackUrl: callbackUrl,
      partnerParams: partnerParams,
      timestamp: timestamp,
      signature: signature
    )
  }
  func toList() -> [Any?] {
    return [
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
    ]
  }
}

/// Generated class from Pigeon that represents data sent in messages.
struct FlutterEnhancedKycAsyncResponse {
  var success: Bool

  static func fromList(_ list: [Any?]) -> FlutterEnhancedKycAsyncResponse? {
    let success = list[0] as! Bool

    return FlutterEnhancedKycAsyncResponse(
      success: success
    )
  }
  func toList() -> [Any?] {
    return [
      success,
    ]
  }
}

private class SmileIDApiCodecReader: FlutterStandardReader {
  override func readValue(ofType type: UInt8) -> Any? {
    switch type {
      case 128:
        return FlutterAuthenticationRequest.fromList(self.readValue() as! [Any?])
      case 129:
        return FlutterAuthenticationResponse.fromList(self.readValue() as! [Any?])
      case 130:
        return FlutterConsentInfo.fromList(self.readValue() as! [Any?])
      case 131:
        return FlutterEnhancedKycAsyncResponse.fromList(self.readValue() as! [Any?])
      case 132:
        return FlutterEnhancedKycRequest.fromList(self.readValue() as! [Any?])
      case 133:
        return FlutterPartnerParams.fromList(self.readValue() as! [Any?])
      default:
        return super.readValue(ofType: type)
    }
  }
}

private class SmileIDApiCodecWriter: FlutterStandardWriter {
  override func writeValue(_ value: Any) {
    if let value = value as? FlutterAuthenticationRequest {
      super.writeByte(128)
      super.writeValue(value.toList())
    } else if let value = value as? FlutterAuthenticationResponse {
      super.writeByte(129)
      super.writeValue(value.toList())
    } else if let value = value as? FlutterConsentInfo {
      super.writeByte(130)
      super.writeValue(value.toList())
    } else if let value = value as? FlutterEnhancedKycAsyncResponse {
      super.writeByte(131)
      super.writeValue(value.toList())
    } else if let value = value as? FlutterEnhancedKycRequest {
      super.writeByte(132)
      super.writeValue(value.toList())
    } else if let value = value as? FlutterPartnerParams {
      super.writeByte(133)
      super.writeValue(value.toList())
    } else {
      super.writeValue(value)
    }
  }
}

private class SmileIDApiCodecReaderWriter: FlutterStandardReaderWriter {
  override func reader(with data: Data) -> FlutterStandardReader {
    return SmileIDApiCodecReader(data: data)
  }

  override func writer(with data: NSMutableData) -> FlutterStandardWriter {
    return SmileIDApiCodecWriter(data: data)
  }
}

class SmileIDApiCodec: FlutterStandardMessageCodec {
  static let shared = SmileIDApiCodec(readerWriter: SmileIDApiCodecReaderWriter())
}

/// Generated protocol from Pigeon that represents a handler of messages from Flutter.
protocol SmileIDApi {
  func initialize() throws
  func setEnvironment(useSandbox: Bool) throws
  func setCallbackUrl(callbackUrl: String) throws
  func authenticate(request: FlutterAuthenticationRequest, completion: @escaping (Result<FlutterAuthenticationResponse, Error>) -> Void)
  func doEnhancedKycAsync(request: FlutterEnhancedKycRequest, completion: @escaping (Result<FlutterEnhancedKycAsyncResponse, Error>) -> Void)
}

/// Generated setup class from Pigeon to handle messages through the `binaryMessenger`.
class SmileIDApiSetup {
  /// The codec used by SmileIDApi.
  static var codec: FlutterStandardMessageCodec { SmileIDApiCodec.shared }
  /// Sets up an instance of `SmileIDApi` to handle messages through the `binaryMessenger`.
  static func setUp(binaryMessenger: FlutterBinaryMessenger, api: SmileIDApi?) {
    let initializeChannel = FlutterBasicMessageChannel(name: "dev.flutter.pigeon.smileid.SmileIDApi.initialize", binaryMessenger: binaryMessenger, codec: codec)
    if let api = api {
      initializeChannel.setMessageHandler { _, reply in
        do {
          try api.initialize()
          reply(wrapResult(nil))
        } catch {
          reply(wrapError(error))
        }
      }
    } else {
      initializeChannel.setMessageHandler(nil)
    }
    let setEnvironmentChannel = FlutterBasicMessageChannel(name: "dev.flutter.pigeon.smileid.SmileIDApi.setEnvironment", binaryMessenger: binaryMessenger, codec: codec)
    if let api = api {
      setEnvironmentChannel.setMessageHandler { message, reply in
        let args = message as! [Any?]
        let useSandboxArg = args[0] as! Bool
        do {
          try api.setEnvironment(useSandbox: useSandboxArg)
          reply(wrapResult(nil))
        } catch {
          reply(wrapError(error))
        }
      }
    } else {
      setEnvironmentChannel.setMessageHandler(nil)
    }
    let setCallbackUrlChannel = FlutterBasicMessageChannel(name: "dev.flutter.pigeon.smileid.SmileIDApi.setCallbackUrl", binaryMessenger: binaryMessenger, codec: codec)
    if let api = api {
      setCallbackUrlChannel.setMessageHandler { message, reply in
        let args = message as! [Any?]
        let callbackUrlArg = args[0] as! String
        do {
          try api.setCallbackUrl(callbackUrl: callbackUrlArg)
          reply(wrapResult(nil))
        } catch {
          reply(wrapError(error))
        }
      }
    } else {
      setCallbackUrlChannel.setMessageHandler(nil)
    }
    let authenticateChannel = FlutterBasicMessageChannel(name: "dev.flutter.pigeon.smileid.SmileIDApi.authenticate", binaryMessenger: binaryMessenger, codec: codec)
    if let api = api {
      authenticateChannel.setMessageHandler { message, reply in
        let args = message as! [Any?]
        let requestArg = args[0] as! FlutterAuthenticationRequest
        api.authenticate(request: requestArg) { result in
          switch result {
            case .success(let res):
              reply(wrapResult(res))
            case .failure(let error):
              reply(wrapError(error))
          }
        }
      }
    } else {
      authenticateChannel.setMessageHandler(nil)
    }
    let doEnhancedKycAsyncChannel = FlutterBasicMessageChannel(name: "dev.flutter.pigeon.smileid.SmileIDApi.doEnhancedKycAsync", binaryMessenger: binaryMessenger, codec: codec)
    if let api = api {
      doEnhancedKycAsyncChannel.setMessageHandler { message, reply in
        let args = message as! [Any?]
        let requestArg = args[0] as! FlutterEnhancedKycRequest
        api.doEnhancedKycAsync(request: requestArg) { result in
          switch result {
            case .success(let res):
              reply(wrapResult(res))
            case .failure(let error):
              reply(wrapError(error))
          }
        }
      }
    } else {
      doEnhancedKycAsyncChannel.setMessageHandler(nil)
    }
  }
}
