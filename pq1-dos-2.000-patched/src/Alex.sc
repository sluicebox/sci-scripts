;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1449)
(include sci.sh)
(use Talker)
(use Actor)

(public
	Alex 0
)

(instance Alex of Talker
	(properties
		x 20
		y 15
		view 1448
		priority 14
		signal 16400
		talkWidth 180
		font 4
	)

	(method (init)
		(super init: 0 0 alexMouth &rest)
	)
)

(instance alexMouth of Prop
	(properties
		nsTop 41
		nsLeft 33
		view 1448
		loop 1
		priority 15
		signal 16400
	)
)

