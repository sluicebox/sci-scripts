;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1101)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	graceInterrogater 0
)

(instance graceInterrogater of Talker
	(properties
		x 222
		y 85
		talkWidth 200
		modeless 2
		fore 2
		back 0
		view 971
		textX -233
		textY -6
	)

	(method (init)
		(= font gUserFont)
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
		(herMouth view: view)
		(herEyes view: view)
		(super init: herMouth 0 herEyes &rest)
	)
)

(instance herMouth of Prop
	(properties
		x 245
		y 131
		view 971
		loop 1
	)
)

(instance herEyes of Prop
	(properties
		x 237
		y 120
		view 971
		loop 2
	)
)

