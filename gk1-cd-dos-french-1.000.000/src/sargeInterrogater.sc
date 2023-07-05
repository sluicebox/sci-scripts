;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1102)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	sargeInterrogater 0
)

(instance sargeInterrogater of Talker
	(properties
		x 222
		y 85
		talkWidth 200
		modeless 2
		fore 3
		back 0
		view 972
		textX -229
		textY 5
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
		(hisMouth view: view)
		(hisEyes view: view)
		(super init: hisMouth 0 hisEyes &rest)
	)
)

(instance hisMouth of Prop
	(properties
		x 242
		y 119
		view 972
		loop 1
	)
)

(instance hisEyes of Prop
	(properties
		x 241
		y 106
		view 972
		loop 2
	)
)

