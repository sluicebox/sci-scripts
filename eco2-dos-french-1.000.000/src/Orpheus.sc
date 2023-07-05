;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1078)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	Orpheus 0
)

(instance Orpheus of Eco2Talker
	(properties
		x 5
		y 5
		view 1078
		loop 3
		talkWidth 150
		back 26
		textX 115
		textY 12
		dftBack 26
	)

	(method (init)
		(= font gUserFont)
		(super init: orpheusBust orpheusEyes orpheusMouth &rest)
	)
)

(instance orpheusMouth of Prop
	(properties
		nsTop 41
		nsLeft 15
		view 1078
	)
)

(instance orpheusBust of Prop
	(properties
		view 1078
		loop 1
	)
)

(instance orpheusEyes of Prop
	(properties
		nsTop 23
		nsLeft 21
		view 1078
		loop 2
	)
)

