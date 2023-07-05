;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1817)
(include sci.sh)
(use Main)
(use n079)
(use LarryTalker)
(use Actor)
(use System)

(public
	You 28
)

(instance You of LarryTalker
	(properties
		x 10
		y 10
		view 1830
		loop 1
		showTitle 1
		back 74
		textX 90
		textY 10
	)

	(method (init)
		(= name
			(switch (gGame printLang:)
				(49 {Du})
				(33 {Tu})
				(else {You})
			)
		)
		(if (IsFlag 74)
			(tBust cel: 1)
		else
			(tBust cel: 0)
		)
		(cond
			(
				(or
					(OneOf gCurRoomNum 210 390)
					(and (== gCurRoomNum 440) (gCurRoom inset:))
				)
				(self textX: 165 talkWidth: 110)
			)
			((OneOf gCurRoomNum 320 310)
				(self textX: 140 talkWidth: 135)
			)
			((== gCurRoomNum 280)
				(= textY 60)
			)
			((== gCurRoomNum 380)
				(= talkWidth 205)
			)
		)
		(super init: tBust)
	)
)

(instance tBust of View
	(properties
		nsTop 4
		nsLeft 4
		view 1903
	)
)

