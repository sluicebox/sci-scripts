;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1017)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	morgan 0
)

(instance morgan of Talker
	(properties
		x 220
		y 93
		view 1017
		priority 15
		signal 16400
		talkWidth 150
		textX -180
		textY -20
	)

	(method (init)
		(= font gUserFont)
		(super init: 0 0 morganMouth &rest)
	)
)

(instance morganMouth of Prop
	(properties
		nsTop 42
		nsLeft 39
		view 1017
		loop 1
		priority 15
		signal 16400
	)
)

