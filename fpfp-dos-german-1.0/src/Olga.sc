;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1847)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Olga 30
)

(instance Olga of Talker
	(properties
		x 5
		y 5
		view 1847
		loop 3
		disposeWhenDone 2
		talkWidth 150
		textX 133
		textY 12
	)

	(method (init)
		(= back global134)
		(= font gUserFont)
		(super init: olgaBust olgaEyes olgaMouth &rest)
	)
)

(instance olgaBust of Prop
	(properties
		view 1847
		loop 1
	)
)

(instance olgaEyes of Prop
	(properties
		nsTop 44
		nsLeft 33
		view 1847
		loop 2
	)
)

(instance olgaMouth of Prop
	(properties
		nsTop 62
		nsLeft 37
		view 1847
	)
)

