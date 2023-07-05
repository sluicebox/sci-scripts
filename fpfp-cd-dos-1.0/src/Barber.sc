;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1803)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Barber 43
)

(instance Barber of Talker
	(properties
		x 5
		y 5
		view 1811
		loop 3
		disposeWhenDone 2
		talkWidth 150
		textX 133
		textY 12
	)

	(method (init)
		(= back global134)
		(= font gUserFont)
		(super init: barberBust barberEyes barberMouth &rest)
	)
)

(instance barberBust of Prop
	(properties
		view 1811
		loop 1
	)
)

(instance barberEyes of Prop
	(properties
		nsTop 31
		nsLeft 46
		view 1811
		loop 2
	)
)

(instance barberMouth of Prop
	(properties
		nsTop 42
		nsLeft 27
		view 1811
	)
)

