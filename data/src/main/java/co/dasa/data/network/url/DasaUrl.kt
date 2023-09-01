package co.dasa.data.network.url

object DasaUrl {
    const val SERVER_HOST = "https://server.dasaedu.com/"
    const val LOGIN = "auth/sign-in"
    const val JOIN_USER = "auth/user/sign-up"
    const val JOIN_OWNER = "auth/owner/sign-up"
    const val GET_USER = "user"

    const val REFRESH_TOKEN = "auth/refresh"
    const val API_KEY = "ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKemRXSWlPaUxzbFlqcms1enJvWnpzbmJUcms1d2lMQ0p5WldGemIyNGlPaUxzbFlqcms1enJvWnpzbmJUcms1d2c2ckNjNjdDY0lpd2lhV0YwSWpveE5qa3pNakEyTURJeUxDSmxlSEFpT2pFMk9UTXlNRGcyTVRSOS51N2ptd2psYnBWc3hTNXlmbkRGOUNRQ2JsVjhqdkprVVN0XzZxQVk5OGtNPw=="

    const val EDUCATION_ALL = "education/list"
    const val EDUCATION_NUM = "education/num/{academy-number}"

    const val NEWS_COLUMN = "news/list/column"

    const val WRITE_COMMENT_NEWS = "comment/news/{id}"
    const val GET_COMMENT_NEWS = "comment/news/{id}"

    const val PAYMENT = "payment"
    const val GET_PAYMENT = "payment/check"
    const val CANCLE_PAYMENT = "payment/cancel"

    const val EDUCATAON_BOARD_ACADEMY = "post/list/{aca-number}"

    const val PROVISION = "https://server.dasaedu.com/provision.html"
    const val POLICY_USER = "https://server.dasaedu.com/policy.html"
    const val POLICY_OWNER = "https://server.dasaedu.com/policy-owner.html"
}
