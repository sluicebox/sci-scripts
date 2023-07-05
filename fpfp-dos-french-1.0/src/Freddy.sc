;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1800)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Freddy 49
)

(instance Freddy of Talker
	(properties
		x 5
		y 5
		view 1800
		loop 3
		disposeWhenDone 2
		talkWidth 150
		textX -185
		textY 12
	)

	(method (init)
		(= back global134)
		(= font gUserFont)
		(cond
			((== gCurRoomNum 790)
				(= textY 40)
				(if (gEgo wearingGuns:)
					(= x 165)
					(= y 72)
					(= textX -146)
					(= talkWidth 120)
					(super init: freddyBust2 freddyEyes2 freddyMouth2 &rest)
				else
					(= x 190)
					(= y 80)
					(= textX -163)
					(= talkWidth 135)
					(super init: freddyBust freddyEyes freddyMouth &rest)
				)
			)
			((gEgo wearingGuns:)
				(= x 159)
				(= textX -143)
				(= talkWidth 120)
				(super init: freddyBust2 freddyEyes2 freddyMouth2 &rest)
			)
			((== gCurRoomNum 420)
				(= y (= x 0))
				(= textX 10)
				(= textY 140)
				(= talkWidth 290)
				(super
					init: freddyCloseBust freddyCloseEyes freddyCloseMouth &rest
				)
			)
			((or (== gCurRoomNum 690) (== gCurRoomNum 200))
				(= x 205)
				(= y 76)
				(= textX -185)
				(super init: freddyBust freddyEyes freddyMouth &rest)
			)
			(else
				(= x 205)
				(super init: freddyBust freddyEyes freddyMouth &rest)
			)
		)
	)
)

(instance freddyBust of Prop
	(properties
		view 1800
		loop 1
	)
)

(instance freddyEyes of Prop
	(properties
		nsTop 33
		nsLeft 40
		view 1800
		loop 2
	)
)

(instance freddyMouth of Prop
	(properties
		nsTop 46
		nsLeft 38
		view 1800
	)
)

(instance freddyCloseBust of Prop
	(properties
		view 1843
	)
)

(instance freddyCloseEyes of Prop
	(properties
		nsTop 76
		nsLeft 196
		view 421
	)
)

(instance freddyCloseMouth of Prop
	(properties
		nsTop 94
		nsLeft 200
		view 421
		loop 1
	)
)

(instance freddyBust2 of Prop
	(properties
		view 1842
		loop 1
	)
)

(instance freddyEyes2 of Prop
	(properties
		nsTop 45
		nsLeft 73
		view 1842
		loop 2
	)
)

(instance freddyMouth2 of Prop
	(properties
		nsTop 53
		nsLeft 64
		view 1842
	)
)

