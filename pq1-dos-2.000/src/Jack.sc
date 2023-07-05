;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1019)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Jack 0
)

(instance Jack of Talker
	(properties
		x 222
		y 90
		view 1019
		priority 15
		signal 16400
		talkWidth 150
		textX -170
	)

	(method (init)
		(= font gUserFont)
		(super init: 0 0 jackMouth &rest)
	)
)

(instance jackMouth of Prop
	(properties
		nsTop 39
		nsLeft 37
		view 1019
		loop 1
		priority 15
		signal 16400
	)
)

