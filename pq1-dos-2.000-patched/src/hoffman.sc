;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1373)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	hoffman 0
)

(instance hoffman of Talker
	(properties
		x 215
		y 90
		view 1373
		priority 15
		signal 16400
		talkWidth 150
		textX -180
	)

	(method (init)
		(= font gUserFont)
		(super init: 0 0 hoffmanMouth &rest)
	)
)

(instance hoffmanMouth of Prop
	(properties
		nsTop 38
		nsLeft 32
		view 1373
		loop 1
		priority 15
		signal 16400
	)
)

