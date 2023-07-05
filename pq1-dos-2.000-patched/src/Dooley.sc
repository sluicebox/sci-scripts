;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1016)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Dooley 0
)

(instance Dooley of Talker
	(properties
		x 2
		y 2
		view 1016
		priority 15
		signal 16400
		talkWidth 150
	)

	(method (init)
		(= font gUserFont)
		(super init: 0 0 dooleyMouth &rest)
	)
)

(instance dooleyMouth of Prop
	(properties
		nsTop 49
		nsLeft 43
		view 1016
		loop 1
		priority 15
		signal 16400
	)
)

