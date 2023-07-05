;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1021)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	laura 0
)

(instance laura of Talker
	(properties
		x 222
		y 75
		view 1021
		priority 15
		signal 16400
		talkWidth 150
		textX -180
	)

	(method (init)
		(= font gUserFont)
		(super init: 0 0 lauraMouth &rest)
	)
)

(instance lauraMouth of Prop
	(properties
		nsTop 37
		nsLeft 38
		view 1021
		loop 1
		priority 15
		signal 16400
	)
)

