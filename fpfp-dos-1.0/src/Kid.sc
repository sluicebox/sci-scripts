;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1826)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Kid 5
)

(instance Kid of Talker
	(properties
		x 5
		y 5
		view 1826
		loop 3
		disposeWhenDone 2
		talkWidth 150
		textX 133
		textY 12
	)

	(method (init)
		(= back global134)
		(= font gUserFont)
		(super init: kidBust kidEyes kidMouth &rest)
	)
)

(instance kidBust of Prop
	(properties
		view 1826
		loop 1
	)
)

(instance kidEyes of Prop
	(properties
		nsTop 39
		nsLeft 41
		view 1826
		loop 2
	)
)

(instance kidMouth of Prop
	(properties
		nsTop 47
		nsLeft 30
		view 1826
	)
)

