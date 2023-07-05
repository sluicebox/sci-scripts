;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1841)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Indian3 11
)

(instance Indian3 of Talker
	(properties
		x 5
		y 5
		view 1841
		loop 3
		disposeWhenDone 2
		talkWidth 150
		textX 133
		textY 12
	)

	(method (init)
		(= back global134)
		(= font gUserFont)
		(super init: indian3Bust indian3Eyes indian3Mouth &rest)
	)
)

(instance indian3Bust of Prop
	(properties
		view 1841
		loop 1
	)
)

(instance indian3Eyes of Prop
	(properties
		nsTop 41
		nsLeft 46
		view 1841
		loop 2
	)
)

(instance indian3Mouth of Prop
	(properties
		nsTop 56
		nsLeft 42
		view 1841
	)
)

