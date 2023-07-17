;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50)
(include sci.sh)
(use Main)
(use DText)
(use Str)
(use Inset)

(public
	lookFiles 0
)

(instance lookFiles of Inset
	(properties
		view 838
		x 86
		y 27
		disposeNotOnMe 1
		modNum 50
		noun 1
	)

	(method (init &tmp temp0 temp1 temp2)
		(= temp2 0)
		(= temp1 0)
		(gGame handsOn:)
		(gTheIconBar disable: 0 setupExit: 1 disable: 4 5 6)
		(if (not (& ((gTheIconBar at: 7) signal:) $0004))
			(gTheIconBar disable: 7)
		)
		(super init: &rest)
		(if (IsFlag 136)
			(++ temp1)
		)
		(if (IsFlag 133)
			(++ temp1)
		)
		(if (IsFlag 137)
			(++ temp1)
		)
		(if (and (not gLookedAtNigelFile) (== temp1 3) (IsFlag 134))
			(= gLookedAtNigelFile register)
		)
		(if (== gLookedAtNigelFile register)
			(= temp2 1)
		)
		(= temp0 (Str newWith: 80 {}))
		(Message msgGET 50 register 1 1 1 (temp0 data:))
		((DText new:)
			text: (KString 8 (temp0 data:)) ; StrDup
			fore: 0
			font: 490
			x: 20
			y: 11
			setSize: 105
			setPri: (self priority:)
			init:
		)
		(Message msgGET 50 register 1 0 1 (temp0 data:))
		((DText new:)
			text: (KString 8 (temp0 data:)) ; StrDup
			fore: 0
			font: 490
			x: 20
			y: 25
			setSize: 105
			setPri: (self priority:)
			init:
		)
		(if temp2
			(Message msgGET 50 7 1 0 1 (temp0 data:)) ; "Additional Cross Reference: |c10|Project: Immortality|c|"
			((DText new:)
				text: (KString 8 (temp0 data:)) ; StrDup
				fore: 0
				font: 490
				x: 20
				y: 75
				setSize: 105
				setPri: (self priority:)
				init:
			)
		)
		(temp0 dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: noun 0 0 0 0 modNum) ; "Hmm ... looks like interesting reading."
			)
			(4 ; Do
				(gMessager say: noun 0 0 0 0 modNum) ; "Hmm ... looks like interesting reading."
			)
			(2 ; Talk
				(gMessager say: 0 0 17 0 0 98) ; "I'm not gonna put my lips on that!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doit)
		(if (not ((gTheIconBar plane:) onMe: (gUser curEvent:)))
			(cond
				(
					(and
						(gUser canInput:)
						(not (self onMe: (gUser curEvent:)))
						(!= gTheCursor gTheExitCursor)
					)
					(gGame setCursor: gTheExitCursor 1)
				)
				(
					(and
						(gUser canInput:)
						(self onMe: (gUser curEvent:))
						(!= gTheCursor ((gTheIconBar curIcon:) getCursor:))
					)
					(gGame setCursor: ((gTheIconBar curIcon:) getCursor:))
				)
			)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(if (== ((gTheIconBar at: 0) message:) 5)
			(gTheIconBar setupExit: 0)
		)
		(if (IsFlag 66)
			(gTheIconBar select: (gTheIconBar at: 0))
		)
		((gTheIconBar at: 4) signal: (& ((gTheIconBar at: 4) signal:) $fffb) show:)
		(if (gInventory selectedInvIcon:)
			((gTheIconBar at: 7)
				signal: (& ((gTheIconBar at: 7) signal:) $fffb)
				show:
			)
		)
		((gTheIconBar at: 0) signal: (| ((gTheIconBar at: 0) signal:) $0004) show:)
		((gTheIconBar at: 1) signal: (| ((gTheIconBar at: 1) signal:) $0004) show:)
		((gTheIconBar at: 2) signal: (| ((gTheIconBar at: 2) signal:) $0004) show:)
		((gTheIconBar at: 3) signal: (| ((gTheIconBar at: 3) signal:) $0004) show:)
		(SetFlag 65)
		(gGame setCursor: ((gTheIconBar curIcon:) getCursor:))
		(super dispose: &rest)
		(gInventory showSelf:)
		(gTheIconBar show:)
	)
)

