;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 932)
(include sci.sh)
(use Main)
(use Print)

(public
	PrintSplit 0
	DisplaySplit 1
	LangSwitch 2
	SaveSubLang 3
	RestoreSubLang 4
	SwapLangs 5
	StrSplitInTwo 6
	IfEnglishElse 7
)

(local
	savedSubLang
	savedSubLangLevel
)

(procedure (PrintSplit) ; UNUSED
	(ShowSplit 0 &rest)
)

(procedure (DisplaySplit) ; UNUSED
	(ShowSplit 1 &rest)
)

(procedure (ShowSplit funIsDisplay &tmp mainLang subLang)
	(= subLang (gGame subtitleLang:))
	(gGame subtitleLang: 0)
	(if funIsDisplay
		(Display &rest)
	else
		(Prints &rest 124)
	)
	(if subLang
		(= mainLang (gGame printLang:))
		(gGame printLang: subLang)
		(if funIsDisplay
			(Display &rest)
		else
			(Prints &rest)
		)
		(gGame printLang: mainLang)
	)
	(gGame subtitleLang: subLang)
)

(procedure (LangSwitch EngVal ForVal EngForVal ForEngVal) ; UNUSED
	(return
		(cond
			((== (gGame printLang:) 1)
				(if (or (< argc 3) (== (gGame subtitleLang:) 0))
					EngVal
				else
					EngForVal
				)
			)
			((or (< argc 4) (== (gGame subtitleLang:) 0)) ForVal)
			(else ForEngVal)
		)
	)
)

(procedure (SaveSubLang &tmp subL)
	(if (and (not savedSubLang) (= subL (gGame subtitleLang:)))
		(= savedSubLang subL)
		(gGame subtitleLang: 0)
	)
	(return subL)
)

(procedure (RestoreSubLang &tmp subL)
	(if (and (= subL savedSubLang) (not (gGame subtitleLang:)))
		(gGame subtitleLang: savedSubLang)
		(= savedSubLang 0)
	)
	(return subL)
)

(procedure (SwapLangs &tmp subL) ; UNUSED
	(if (= subL (gGame subtitleLang:))
		(gGame subtitleLang: (gGame printLang:))
		(gGame printLang: subL)
		(return 1)
	)
)

(procedure (StrSplitInTwo engBuf forBuf bufOrNum optEntry &tmp mainL subL altLang [thisBuf 1000]) ; UNUSED
	(if (== argc 4)
		(GetFarText @thisBuf bufOrNum optEntry)
	else
		(StrCpy @thisBuf bufOrNum)
	)
	(= mainL (gGame printLang:))
	(= subL (gGame subtitleLang:))
	(gGame printLang: 1 subtitleLang: 0)
	(StrSplit engBuf @thisBuf 0)
	(if (= altLang 0)
		(gGame printLang: 0)
		(StrSplit forBuf @thisBuf 0)
	else
		(StrCpy forBuf {})
	)
	(gGame printLang: mainL subtitleLang: subL)
	(return engBuf)
)

(procedure (IfEnglishElse EngVal ForVal) ; UNUSED
	(return (if (== (gGame parseLang:) 1) EngVal else ForVal))
)

