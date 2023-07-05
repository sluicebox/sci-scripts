;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1877)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	Orchid1 0
)

(instance Orchid1 of Eco2Talker
	(properties
		x 5
		y 5
		view 1877
		loop 3
		talkWidth 150
		back 14
		textX 115
		textY 12
		dftBack 14
	)

	(method (init)
		(= font gUserFont)
		(super init: orchid1Bust orchid1Eyes orchid1Mouth &rest)
	)
)

(instance orchid1Mouth of Prop
	(properties
		nsTop 36
		nsLeft 16
		view 1877
	)
)

(instance orchid1Bust of Prop
	(properties
		view 1877
		loop 1
	)
)

(instance orchid1Eyes of Prop
	(properties
		nsTop 25
		nsLeft 27
		view 1877
		loop 2
	)
)

