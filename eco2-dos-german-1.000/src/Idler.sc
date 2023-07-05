;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1379)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	Idler 0
)

(instance Idler of Eco2Talker
	(properties
		x 5
		y 5
		view 1379
		loop 3
		talkWidth 150
		back 62
		textX 115
		textY 12
		dftBack 62
	)

	(method (init)
		(= font gUserFont)
		(super init: idlerBust idlerEyes idlerMouth &rest)
	)
)

(instance idlerMouth of Prop
	(properties
		nsTop 47
		nsLeft 25
		view 1379
	)
)

(instance idlerBust of Prop
	(properties
		view 1379
		loop 1
	)
)

(instance idlerEyes of Prop
	(properties
		nsTop 26
		nsLeft 26
		view 1379
		loop 2
	)
)

