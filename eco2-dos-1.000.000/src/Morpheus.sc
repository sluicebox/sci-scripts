;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1079)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	Morpheus 0
)

(instance Morpheus of Eco2Talker
	(properties
		x 5
		y 5
		view 1079
		loop 3
		talkWidth 150
		back 26
		textX 115
		textY 12
		dftBack 26
	)

	(method (init)
		(= font gUserFont)
		(super init: morpheusBust morpheusEyes morpheusMouth &rest)
	)
)

(instance morpheusMouth of Prop
	(properties
		nsTop 40
		nsLeft 18
		view 1079
	)
)

(instance morpheusBust of Prop
	(properties
		view 1079
		loop 1
	)
)

(instance morpheusEyes of Prop
	(properties
		nsTop 14
		nsLeft 27
		view 1079
		loop 2
	)
)

