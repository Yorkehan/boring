!function (a) {
    "use strict";
    a("html, body");
    var e = a(".pwdMask > .form-control"), t = a(".pwd-toggle");
    a(".lnk-toggler").on("click", function (t) {
        t.preventDefault();
        var e = a(this).data("panel");
        a(".authfy-panel.active").removeClass("active"), a(e).addClass("active")
    }), a(t).on("click", function (t) {
        t.preventDefault(), a(this).toggleClass("fa-eye-slash fa-eye"), a(this).hasClass("fa-eye") ? a(e).attr("type", "text") : a(e).attr("type", "password")
    }), a("#forget-lnk").on("click", function () {
        a(".authfy-login .nav-tabs").find("li").removeClass("active")
    }), a(window).on("load", function () {
        a(".square-block").fadeOut(), a("#preload-block").fadeOut("slow", function () {
            a(this).remove()
        })
    }),
        a(".btn-github").on("click", function (t) {
            PopupCenter("https://github.com/login/oauth/authorize?client_id=4a3583c52db343eac31d","dasd",700,600)
        })

}(jQuery);
function PopupCenter(url, title, w, h) {
    var userAgent = navigator.userAgent,
        mobile = function() {
            return /\b(iPhone|iP[ao]d)/.test(userAgent) ||
                /\b(iP[ao]d)/.test(userAgent) ||
                /Android/i.test(userAgent) ||
                /Mobile/i.test(userAgent);
        },
        screenX = typeof window.screenX != 'undefined' ? window.screenX : window.screenLeft,
        screenY = typeof window.screenY != 'undefined' ? window.screenY : window.screenTop,
        outerWidth = typeof window.outerWidth != 'undefined' ? window.outerWidth : document.documentElement.clientWidth,
        outerHeight = typeof window.outerHeight != 'undefined' ? window.outerHeight : document.documentElement.clientHeight - 22,
        targetWidth = mobile() ? null : w,
        targetHeight = mobile() ? null : h,
        V = screenX < 0 ? window.screen.width + screenX : screenX,
        left = parseInt(V + (outerWidth - targetWidth) / 2, 10),
        right = parseInt(screenY + (outerHeight - targetHeight) / 2.5, 10),
        features = [];
    if (targetWidth !== null) {
        features.push('width=' + targetWidth);
    }
    if (targetHeight !== null) {
        features.push('height=' + targetHeight);
    }
    features.push('left=' + left);
    features.push('top=' + right);
    features.push('scrollbars=1');

    var newWindow = window.open(url, title, features.join(','));

    if (window.focus) {
        newWindow.focus();
    }

    return newWindow;
}


