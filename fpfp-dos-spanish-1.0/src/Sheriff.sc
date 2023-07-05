;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1813)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Sheriff 58
)

(instance Sheriff of Talker
	(properties
		x 5
		y 5
		view 1806
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
		(if (== gCurRoomNum 400)
			(= x 200)
			(= y 76)
			(= textX -185)
		)
		(super init: sheriffBust sheriffEyes sheriffMouth &rest)
	)
)

(instance sheriffBust of Prop
	(properties
		view 1806
		loop 1
	)
)

(instance sheriffEyes of Prop
	(properties
		nsTop 33
		nsLeft 68
		view 1806
		loop 2
	)
)

(instance sheriffMouth of Prop
	(properties
		nsTop 45
		nsLeft 54
		view 1806
	)
)

