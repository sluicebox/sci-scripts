;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1819)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	PHBalance 42
)

(instance PHBalance of Talker
	(properties
		x 5
		y 5
		view 1807
		loop 3
		disposeWhenDone 2
		talkWidth 150
		textX 133
		textY 12
	)

	(method (init)
		(= back global134)
		(= font gUserFont)
		(if (== gCurRoomNum 400)
			(= x 200)
			(= y 76)
			(= textX -185)
		)
		(super init: phBalanceBust phBalanceEyes phBalanceMouth &rest)
	)
)

(instance phBalanceBust of Prop
	(properties
		view 1807
		loop 1
	)
)

(instance phBalanceEyes of Prop
	(properties
		nsTop 26
		nsLeft 36
		view 1807
		loop 2
	)
)

(instance phBalanceMouth of Prop
	(properties
		nsTop 36
		nsLeft 30
		view 1807
	)
)

