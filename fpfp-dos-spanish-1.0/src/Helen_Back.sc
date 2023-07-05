;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1811)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Helen_Back 53
)

(instance Helen_Back of Talker
	(properties
		name {Helen Back}
		x 5
		y 5
		view 1812
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
		(super init: helenBackBust helenBackEyes helenBackMouth &rest)
	)
)

(instance helenBackBust of Prop
	(properties
		view 1812
		loop 1
	)
)

(instance helenBackEyes of Prop
	(properties
		nsTop 35
		nsLeft 36
		view 1812
		loop 2
	)
)

(instance helenBackMouth of Prop
	(properties
		nsTop 43
		nsLeft 30
		view 1812
	)
)

