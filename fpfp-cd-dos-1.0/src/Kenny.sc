;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1815)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Kenny 54
)

(instance Kenny of Talker
	(properties
		x 5
		y 5
		view 1810
		loop 3
		disposeWhenDone 2
		talkWidth 150
		textX 133
		textY 12
	)

	(method (init)
		(= back global134)
		(= font gUserFont)
		(cond
			((== gCurRoomNum 570)
				(= y (= x 0))
				(= textX 190)
				(= talkWidth 100)
				(= textY 20)
				(super
					init: kennyCloseBust kennyCloseEyes kennyCloseMouth &rest
				)
			)
			((== gCurRoomNum 560)
				(= textX 11)
				(= textY 150)
				(= talkWidth 280)
				(super init: kennyBust560 kennyEyes560 kennyMouth560 &rest)
			)
			(else
				(= bust kennyBust)
				(= eyes kennyEyes)
				(= mouth kennyMouth)
				(super init: bust eyes mouth &rest)
			)
		)
	)
)

(instance kennyCloseBust of Prop
	(properties
		view 1843
	)
)

(instance kennyCloseEyes of Prop
	(properties
		nsTop 27
		nsLeft 151
		view 571
	)
)

(instance kennyCloseMouth of Prop
	(properties
		nsTop 33
		nsLeft 151
		view 571
		loop 1
	)
)

(instance kennyBust560 of Prop
	(properties
		view 1843
	)
)

(instance kennyEyes560 of Prop
	(properties
		nsTop 84
		nsLeft 141
		view 560
		loop 5
	)
)

(instance kennyMouth560 of Prop
	(properties
		nsTop 87
		nsLeft 141
		view 560
		loop 4
	)
)

(instance kennyBust of Prop
	(properties
		view 1810
		loop 1
	)
)

(instance kennyEyes of Prop
	(properties
		nsTop 37
		nsLeft 49
		view 1810
		loop 2
	)
)

(instance kennyMouth of Prop
	(properties
		nsTop 42
		nsLeft 38
		view 1810
	)
)

