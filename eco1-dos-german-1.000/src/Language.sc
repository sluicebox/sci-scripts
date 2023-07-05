;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 932)
(include sci.sh)
(use Main)
(use Interface)

(public
	proc932_0 0
	proc932_1 1
	proc932_2 2
	proc932_3 3
	proc932_4 4
	proc932_5 5
	proc932_6 6
	proc932_7 7
	proc932_8 8
)

(local
	savedSubLang
	savedSubLangLevel
)

(procedure (proc932_0) ; UNUSED
	(ShowSplit 0 &rest)
)

(procedure (proc932_1) ; UNUSED
	(ShowSplit 1 &rest)
)

(procedure (ShowSplit funIsDisplay &tmp mainLang subLang)
	(= subLang (gGame subtitleLang:))
	(gGame subtitleLang: 0)
	(if funIsDisplay
		(Display &rest)
	else
		(Print &rest #first)
	)
	(if subLang
		(= mainLang (gGame printLang:))
		(gGame printLang: subLang)
		(if funIsDisplay
			(Display &rest)
		else
			(Print &rest)
		)
		(gGame printLang: mainLang)
	)
	(gGame subtitleLang: subLang)
)

(procedure (proc932_2 param1 param2 param3 param4)
	(return
		(cond
			((== (gGame printLang:) 1)
				(if (or (< argc 3) (== (gGame subtitleLang:) 0))
					param1
				else
					param3
				)
			)
			((or (< argc 4) (== (gGame subtitleLang:) 0)) param2)
			(else param4)
		)
	)
)

(procedure (proc932_3 &tmp temp0)
	(if (and (not savedSubLang) (= temp0 (gGame subtitleLang:)))
		(= savedSubLang temp0)
		(gGame subtitleLang: 0)
	)
	(return temp0)
)

(procedure (proc932_4 &tmp temp0)
	(if (and (= temp0 savedSubLang) (not (gGame subtitleLang:)))
		(gGame subtitleLang: savedSubLang)
		(= savedSubLang 0)
	)
	(return temp0)
)

(procedure (proc932_5 &tmp temp0) ; UNUSED
	(if (= temp0 (gGame subtitleLang:))
		(gGame subtitleLang: (gGame printLang:))
		(gGame printLang: temp0)
		(return 1)
	)
)

(procedure (proc932_6 param1 param2 param3 param4 &tmp temp0 temp1 temp2 [temp3 1000]) ; UNUSED
	(if (== argc 4)
		(GetFarText @temp3 param3 param4)
	else
		(StrCpy @temp3 param3)
	)
	(= temp0 (gGame printLang:))
	(= temp1 (gGame subtitleLang:))
	(gGame printLang: 1 subtitleLang: 0)
	(StrSplit param1 @temp3 0)
	(if (= temp2 49)
		(gGame printLang: 49)
		(StrSplit param2 @temp3 0)
	else
		(StrCpy param2 {})
	)
	(gGame printLang: temp0 subtitleLang: temp1)
	(return param1)
)

(procedure (proc932_7 param1 param2) ; UNUSED
	(return (if (== (gGame parseLang:) 1) param1 else param2))
)

(procedure (proc932_8 param1 param2 param3 param4)
	(if (== (gGame printLang:) 1)
		(GetMessage param1 param2 param3 param4)
	else
		(GetMessage param1 (+ param2 1000) param3 param4)
	)
)

