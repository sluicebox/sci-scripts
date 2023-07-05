;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1800)
(include sci.sh)
(use Main)
(use n079)
(use LarryTalker)
(use Actor)
(use System)

(public
	You 1
)

(instance You of LarryTalker
	(properties
		x 10
		y 10
		view 1830
		loop 1
		showTitle 1
		back 74
		textX 125
		textY 11
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
			(tBust view: 1901)
			(tMouth view: 1901)
			(tEyes view: 1901)
		else
			(tBust view: 1900)
			(tMouth view: 1900)
			(tEyes view: 1900)
		)
		(cond
			(
				(or
					(OneOf gCurRoomNum 210 390)
					(and (== gCurRoomNum 440) (gCurRoom inset:))
				)
				(= winPosn 0)
				(= textX (proc79_4 175 180 180 180 180))
				(= textY (proc79_4 1 11 11 11 11))
				(= talkWidth (proc79_4 125 120 120 120 120))
			)
			((OneOf gCurRoomNum 320 310)
				(= winPosn 0)
				(= textX 170)
				(= talkWidth 130)
			)
			((== gCurRoomNum 140)
				(= winPosn 0)
				(= textX 90)
				(= talkWidth 205)
			)
			((== gCurRoomNum 250)
				(= textX 100)
				(= textY 68)
			)
			((or (== gCurRoomNum 280) (and (== gCurRoomNum 230) (IsFlag 8)))
				(= textX 100)
				(= textY 68)
				(= modeless 1)
			)
			((== gCurRoomNum 370)
				(= x (proc79_4 2 2 2 2 2 7))
				(= talkWidth 120)
				(= textX 168)
				(= modeless 1)
			)
			((== gCurRoomNum 430)
				(= textX 120)
				(= textY 55)
			)
			((== gCurRoomNum 410)
				(= textX 120)
				(= textY 65)
			)
			((== gCurRoomNum 380)
				(= textX 90)
				(= textY 10)
				(= talkWidth 205)
			)
			((OneOf gCurRoomNum 520 590)
				(= textX 110)
				(= textY 70)
				(= talkWidth 180)
			)
			((OneOf gCurRoomNum 720 730)
				(= textX 140)
				(= textY 47)
				(= talkWidth 150)
			)
			(else
				(= winPosn 1)
			)
		)
		(super init: tBust tEyes tMouth)
	)
)

(instance tBust of View
	(properties
		nsTop 4
		nsLeft 4
		view 1900
		loop 1
	)
)

(instance tMouth of Prop
	(properties
		nsTop 53
		nsLeft 19
		view 1900
	)
)

(instance tEyes of Prop
	(properties
		nsTop 40
		nsLeft 29
		view 1900
		loop 2
	)
)

