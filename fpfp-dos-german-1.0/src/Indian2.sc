;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1840)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Indian2 10
)

(instance Indian2 of Talker
	(properties
		x 5
		y 5
		view 1840
		loop 3
		disposeWhenDone 2
		talkWidth 150
		textX 133
		textY 12
	)

	(method (init)
		(= back global134)
		(= font gUserFont)
		(super init: indian2Bust indian2Eyes indian2Mouth &rest)
	)
)

(instance indian2Bust of Prop
	(properties
		view 1840
		loop 1
	)
)

(instance indian2Eyes of Prop
	(properties
		nsTop 55
		nsLeft 45
		view 1840
		loop 2
	)
)

(instance indian2Mouth of Prop
	(properties
		nsTop 73
		nsLeft 44
		view 1840
	)
)

