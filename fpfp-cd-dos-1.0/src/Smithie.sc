;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1809)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Smithie 59
)

(instance Smithie of Talker
	(properties
		x 5
		y 5
		view 1805
		loop 3
		disposeWhenDone 2
		talkWidth 150
		textX 133
		textY 12
	)

	(method (init)
		(= back global134)
		(= font gUserFont)
		(if (== gCurRoomNum 600)
			(= x 200)
			(= y 76)
			(= textX -180)
		)
		(super init: smithieBust smithieEyes smithieMouth &rest)
	)
)

(instance smithieBust of Prop
	(properties
		view 1805
		loop 1
	)
)

(instance smithieEyes of Prop
	(properties
		nsTop 37
		nsLeft 38
		view 1805
		loop 2
	)
)

(instance smithieMouth of Prop
	(properties
		nsTop 55
		nsLeft 21
		view 1805
	)
)

