;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1834)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Woman 7
)

(instance Woman of Talker
	(properties
		x 5
		y 5
		view 1834
		loop 3
		disposeWhenDone 2
		talkWidth 150
		textX 133
		textY 12
	)

	(method (init)
		(= back global134)
		(= font gUserFont)
		(super init: womanBust womanEyes womanMouth &rest)
	)
)

(instance womanBust of Prop
	(properties
		view 1834
		loop 1
	)
)

(instance womanEyes of Prop
	(properties
		nsTop 37
		nsLeft 50
		view 1834
		loop 2
	)
)

(instance womanMouth of Prop
	(properties
		nsTop 46
		nsLeft 51
		view 1834
	)
)

