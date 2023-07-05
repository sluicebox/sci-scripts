;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1069)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	Shaman 0
)

(instance Shaman of Eco2Talker
	(properties
		x 5
		y 5
		view 1069
		loop 3
		talkWidth 150
		back 62
		textX 115
		textY 12
		dftBack 62
	)

	(method (init)
		(= font gUserFont)
		(super init: shamanBust shamanEyes shamanMouth &rest)
	)
)

(instance shamanMouth of Prop
	(properties
		nsTop 59
		nsLeft 37
		view 1069
	)
)

(instance shamanBust of View
	(properties
		view 1069
		loop 1
	)
)

(instance shamanEyes of Prop
	(properties
		nsTop 38
		nsLeft 37
		view 1069
		loop 2
	)
)

