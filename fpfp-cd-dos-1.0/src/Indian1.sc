;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1839)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Indian1 9
)

(instance Indian1 of Talker
	(properties
		x 5
		y 5
		view 1839
		loop 3
		disposeWhenDone 2
		talkWidth 150
		textX 133
		textY 12
	)

	(method (init)
		(= back global134)
		(= font gUserFont)
		(super init: indian1Bust indian1Eyes indian1Mouth &rest)
	)
)

(instance indian1Bust of Prop
	(properties
		view 1839
		loop 1
	)
)

(instance indian1Eyes of Prop
	(properties
		nsTop 36
		nsLeft 52
		view 1839
		loop 2
	)
)

(instance indian1Mouth of Prop
	(properties
		nsTop 52
		nsLeft 45
		view 1839
	)
)

