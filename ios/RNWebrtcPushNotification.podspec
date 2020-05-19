
Pod::Spec.new do |s|
  s.name         = "RNWebrtcPushNotification"
  s.version      = "1.0.0"
  s.summary      = "RNWebrtcPushNotification"
  s.description  = <<-DESC
                  RNWebrtcPushNotification
                   DESC
  s.homepage     = "https://github.com/ajith-ab/react-native-webrtc-push-notification/blob/master/README.md"
  s.license      = "MIT"
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author             = { "author" => "author@domain.cn" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/author/RNWebrtcPushNotification.git", :tag => "master" }
  s.source_files  = "RNWebrtcPushNotification/**/*.{h,m}"
  s.requires_arc = true


  s.dependency "React"
  #s.dependency "others"

end
