;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 342)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	bartenderTalker 0
)

(instance bartenderTalker of Talker
	(properties
		x 10
		y 10
		view 1331
		talkWidth 260
		textX 15
		textY 110
	)

	(method (init)
		(= global451 2331)
		(PalVary pvCHANGE_TARGET 2331)
		(AssertPalette 1331)
		(= font gUserFont)
		(super init: bartenderBust bartenderEye bartenderMouth &rest)
	)

	(method (dispose)
		(= global451 0)
		(super dispose:)
	)
)

(instance bartenderBust of Prop
	(properties
		view 1331
	)
)

(instance bartenderMouth of Prop
	(properties
		nsTop 49
		nsLeft 31
		view 1331
		loop 1
	)
)

(instance bartenderEye of Prop
	(properties
		nsTop 24
		nsLeft 16
		view 1331
		loop 2
	)
)

