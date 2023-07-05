;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 932)
(include sci.sh)
(use Main)
(use Interface)

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
	(= subLang (gGame sel_85:))
	(gGame sel_85: 0)
	(if funIsDisplay
		(Display &rest)
	else
		(Print &rest 124)
	)
	(if subLang
		(= mainLang (gGame sel_84:))
		(gGame sel_84: subLang)
		(if funIsDisplay
			(Display &rest)
		else
			(Print &rest)
		)
		(gGame sel_84: mainLang)
	)
	(gGame sel_85: subLang)
)

(procedure (LangSwitch EngVal ForVal EngForVal ForEngVal) ; UNUSED
	(return
		(cond
			((== (gGame sel_84:) 1)
				(if (or (< argc 3) (== (gGame sel_85:) 0)) EngVal else EngForVal)
			)
			((or (< argc 4) (== (gGame sel_85:) 0)) ForVal)
			(else ForEngVal)
		)
	)
)

(procedure (SaveSubLang &tmp subL) ; UNUSED
	(if (and (not savedSubLang) (= subL (gGame sel_85:)))
		(= savedSubLang subL)
		(gGame sel_85: 0)
	)
	(return subL)
)

(procedure (RestoreSubLang &tmp subL) ; UNUSED
	(if (and (= subL savedSubLang) (not (gGame sel_85:)))
		(gGame sel_85: savedSubLang)
		(= savedSubLang 0)
	)
	(return subL)
)

(procedure (SwapLangs &tmp subL) ; UNUSED
	(if (= subL (gGame sel_85:))
		(gGame sel_85: (gGame sel_84:))
		(gGame sel_84: subL)
		(return 1)
	)
)

(procedure (StrSplitInTwo engBuf forBuf bufOrNum optEntry &tmp mainL subL altLang [thisBuf 1000]) ; UNUSED
	(if (== argc 4)
		(GetFarText @thisBuf bufOrNum optEntry)
	else
		(StrCpy @thisBuf bufOrNum)
	)
	(= mainL (gGame sel_84:))
	(= subL (gGame sel_85:))
	(gGame sel_84: 1 sel_85: 0)
	(StrSplit engBuf @thisBuf 0)
	(if (= altLang 0)
		(gGame sel_84: 0)
		(StrSplit forBuf @thisBuf 0)
	else
		(StrCpy forBuf {})
	)
	(gGame sel_84: mainL sel_85: subL)
	(return engBuf)
)

(procedure (IfEnglishElse EngVal ForVal) ; UNUSED
	(return (if (== (gGame sel_83:) 1) EngVal else ForVal))
)

