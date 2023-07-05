;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1100)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)
(use System)

(public
	egoInterrogater 0
)

(instance egoInterrogater of Talker
	(properties
		x 2
		y 0
		talkWidth 200
		modeless 2
		fore 1
		back 0
		view 970
		textX 71
		textY -10
	)

	(method (init)
		(= font gUserFont)
		(if
			(or
				(OneOf global178 2 45 46)
				(and (== gDay 10) (== global178 8))
			)
			(= view 9701)
		)
		(if (== global178 12)
			(= view 9702)
		)
		(cond
			((IsHiRes)
				(if (< view 10000)
					(+= view 10000)
				)
			)
			((> view 10000)
				(-= view 10000)
			)
		)
		(egoMouth view: view)
		(egoEyes view: view)
		(super init: egoMouth 0 egoEyes &rest)
	)
)

(instance egoMouth of Prop
	(properties
		x 36
		y 40
		view 970
		loop 1
	)
)

(instance egoEyes of Prop
	(properties
		x 40
		y 30
		view 970
		loop 2
	)
)

