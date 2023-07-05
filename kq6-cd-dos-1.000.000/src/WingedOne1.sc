;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1030)
(include sci.sh)
(use Main)
(use Kq6Talker)
(use Actor)

(public
	WingedOne1 18
	WingedOne2 31
)

(instance WingedOne1 of Kq6Talker
	(properties
		x 5
		y 5
		view 8942
		talkWidth 213
		textX 81
		textY 6
		raveName {WINGG}
	)

	(method (init)
		(if (== gCurRoomNum 380)
			(= winPosn 0)
		)
		(super init: tBust1 tEyes1 tMouth1 &rest)
	)
)

(instance tBust1 of Prop
	(properties
		view 8942
	)
)

(instance tEyes1 of Prop
	(properties
		nsTop 29
		nsLeft 27
		view 8942
		loop 2
	)
)

(instance tMouth1 of Prop
	(properties
		nsTop 39
		nsLeft 26
		view 8942
		loop 1
	)
)

(instance WingedOne2 of Kq6Talker
	(properties
		x 245
		y 5
		view 8942
		talkWidth 213
		textX -233
		textY 6
		raveName {WINGG}
	)

	(method (init)
		(super init: tBust2 tEyes2 tMouth2 &rest)
	)
)

(instance tBust2 of Prop
	(properties
		view 8942
	)
)

(instance tEyes2 of Prop
	(properties
		nsTop 29
		nsLeft 27
		view 8942
		loop 2
	)
)

(instance tMouth2 of Prop
	(properties
		nsTop 39
		nsLeft 26
		view 8942
		loop 1
	)
)

