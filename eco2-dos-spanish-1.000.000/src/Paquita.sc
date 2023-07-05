;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1059)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	Paquita 0
)

(instance Paquita of Eco2Talker
	(properties
		x 5
		y 5
		view 1059
		loop 3
		talkWidth 150
		back 56
		textX 115
		textY 12
		dftBack 56
	)

	(method (init)
		(= font gUserFont)
		(super init: paquitaBust paquitaEyes paquitaMouth &rest)
	)
)

(instance paquitaMouth of Prop
	(properties
		nsTop 56
		nsLeft 32
		view 1059
	)
)

(instance paquitaBust of Prop
	(properties
		view 1059
		loop 1
	)
)

(instance paquitaEyes of Prop
	(properties
		nsTop 41
		nsLeft 20
		view 1059
		loop 2
	)
)

