;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27)
(include sci.sh)
(use Main)
(use PQIconItem)

(public
	caseInv 0
)

(instance caseInv of PqInv
	(properties)

	(method (init)
		(= gCaseInv self)
		(self
			helpIconItem: caseInvHelp
			selectIcon: caseInvSelect
			theSlider: caseInvSlider
			okButton: caseOk
			numRow: 2
			numCol: 4
			numScroll: 4
			itemWide: 35
			itemHigh: 30
			colMargin: 12
			rowMargin: 5
			add:
				caseBaggies
				casePryBar
				caseGlassJar
				caseGloves
				caseFlashlight
				caseChalk
				casePuttyKnife
				caseInvLook
				caseInvHand
				caseInvSelect
				caseInvHelp
				caseOk
				caseInvUpArrow
				caseInvDownArrow
				caseInvSlider
			eachElementDo: #highlightColor -1
			eachElementDo: #lowlightColor -1
			eachElementDo: #modNum 11
			state: 2048
		)
		(super init:)
		(self setPlane: (if (IsHiRes) 10980 else 980) 0 0)
	)
)

(instance caseInvLook of PQIconItem
	(properties
		noun 42
		signal 129
		message 1
		mainView 980
		mainLoop 1
		helpVerb 9
	)

	(method (init)
		(if (IsHiRes)
			(= mainView 10980)
			(= x 5)
			(= y 4)
		else
			(= x 9)
			(= y 5)
		)
		(self setCursor: 992 0 0)
		(super init: &rest)
	)
)

(instance caseInvHand of PQIconItem
	(properties
		noun 43
		signal 129
		message 4
		mainView 980
		mainLoop 2
		helpVerb 9
	)

	(method (init)
		(if (IsHiRes)
			(= mainView 10980)
			(= x 42)
			(= y 4)
		else
			(= x 47)
			(= y 5)
		)
		(self setCursor: 993 0 0)
		(super init: &rest)
	)
)

(instance caseInvSelect of PQIconItem
	(properties
		noun 45
		signal 129
		mainView 980
		mainLoop 5
		helpVerb 9
	)

	(method (init)
		(if (IsHiRes)
			(= mainView 10980)
			(= x 80)
			(= y 4)
		else
			(= x 85)
			(= y 5)
		)
		(self setCursor: 999 0 0)
		(super init: &rest)
	)
)

(instance caseInvHelp of PQIconItem
	(properties
		noun 44
		signal 129
		message 9
		mainView 980
		mainLoop 3
		helpVerb 9
	)

	(method (init)
		(if (IsHiRes)
			(= mainView 10980)
			(= x 118)
			(= y 4)
		else
			(= x 122)
			(= y 5)
		)
		(self setCursor: 989 0 0)
		(super init: &rest)
	)
)

(instance caseOk of PQIconItem
	(properties
		noun 41
		signal 195
		mainView 980
		mainLoop 4
		helpVerb 9
	)

	(method (init)
		(if (IsHiRes)
			(= mainView 10980)
			(= x 155)
			(= y 4)
		else
			(= x 159)
			(= y 5)
		)
		(self setCursor: 999 0 0)
		(super init: &rest)
	)
)

(instance caseInvUpArrow of PQIconItem
	(properties
		noun 49
		signal 131
		message 4
		mainView 980
		mainLoop 8
		helpVerb 9
	)

	(method (init)
		(if (IsHiRes)
			(= mainView 10980)
		)
		(self setCursor: 999 0 0)
		(= x 183)
		(= y 41)
		(super init: &rest)
	)

	(method (select)
		(if (super select: &rest)
			(gCaseInv setCurIndex: (- 0 (gCaseInv numScroll:)))
			((gCaseInv theSlider:) update: -1)
			(return 0)
		)
	)
)

(instance caseInvDownArrow of PQIconItem
	(properties
		noun 50
		signal 131
		message 4
		mainView 980
		mainLoop 7
		helpVerb 9
	)

	(method (init)
		(if (IsHiRes)
			(= mainView 10980)
		)
		(self setCursor: 999 0 0)
		(= x 183)
		(= y 107)
		(super init: &rest)
	)

	(method (select)
		(if (super select: &rest)
			(gCaseInv setCurIndex: (gCaseInv numScroll:))
			((gCaseInv theSlider:) update: 1)
			(return 0)
		)
	)
)

(instance caseInvSlider of InvSlider
	(properties
		noun 51
		signal 131
		message 4
		mainView 980
		mainLoop 6
		helpVerb 9
	)

	(method (select)
		(if (super select: &rest)
			(return 0)
		)
	)

	(method (init)
		(if (IsHiRes)
			(= mainView 10980)
		)
		(= theUpArrow caseInvUpArrow)
		(= theDnArrow caseInvDownArrow)
		(self setCursor: 999 0 0)
		(= x 183)
		(= y 48)
		(super init: &rest)
	)
)

(instance caseBaggies of PQInvItem
	(properties
		noun 5
		signal 2
		message 13
		mainView 924
	)
)

(instance casePryBar of PQInvItem
	(properties
		noun 61
		signal 2
		message 63
		mainView 949
	)
)

(instance caseGlassJar of PQInvItem
	(properties
		noun 62
		signal 2
		message 65
		mainView 973
	)
)

(instance caseGloves of PQInvItem
	(properties
		noun 63
		signal 2
		message 64
		mainView 974
	)
)

(instance caseFlashlight of PQInvItem
	(properties
		noun 35
		signal 2
		message 43
		mainView 955
	)
)

(instance caseChalk of PQInvItem
	(properties
		noun 59
		signal 2
		message 38
		mainView 968
	)
)

(instance casePuttyKnife of PQInvItem
	(properties
		noun 58
		signal 2
		message 61
		mainView 967
	)
)

