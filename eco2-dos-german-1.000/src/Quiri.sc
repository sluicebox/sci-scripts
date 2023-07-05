;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1389)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	Quiri 0
)

(instance Quiri of Eco2Talker
	(properties
		x 5
		y 5
		view 1389
		loop 3
		talkWidth 150
		back 62
		textX 115
		textY 12
		dftBack 62
	)

	(method (init)
		(= font gUserFont)
		(super init: quiriBust quiriEyes quiriMouth &rest)
	)
)

(instance quiriMouth of Prop
	(properties
		nsTop 32
		nsLeft 29
		view 1389
	)
)

(instance quiriBust of Prop
	(properties
		view 1389
		loop 1
	)
)

(instance quiriEyes of Prop
	(properties
		nsTop 19
		nsLeft 29
		view 1389
		loop 2
	)
)

