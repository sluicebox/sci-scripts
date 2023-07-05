;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1878)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	Orchid2 0
)

(instance Orchid2 of Eco2Talker
	(properties
		x 5
		y 5
		view 1878
		loop 1
		talkWidth 150
		back 14
		textX 115
		textY 12
		dftBack 14
	)

	(method (init)
		(= font gUserFont)
		(super init: orchid2Bust orchid2Eyes orchid2Mouth &rest)
	)
)

(instance orchid2Mouth of Prop
	(properties
		nsTop 33
		nsLeft 30
		view 1878
	)
)

(instance orchid2Bust of Prop
	(properties
		view 1878
		loop 1
	)
)

(instance orchid2Eyes of Prop
	(properties
		nsTop 26
		nsLeft 37
		view 1878
		loop 2
	)
)

