;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 93)
(include sci.sh)
(use Main)
(use n001)
(use Stage)
(use Actor)
(use System)

(public
	RasPlaza 0
)

(procedure (ExcludeFountain theX)
	(if (> theX 159)
		(= theX (Max 220 theX))
	else
		(= theX (Min 90 theX))
	)
	(return theX)
)

(class RasPlaza of Stage
	(properties
		picture 300
		horizon 82
		topFromX 160
		topFromY 80
		topToX 160
		topToY 100
		bottomFromX 160
		bottomFromY 250
		bottomToX 160
		bottomToY 188
		rightFromX 325
		rightFromY 162
		rightToX 310
		rightToY 162
		leftFromX -10
		leftFromY 162
		leftToX 35
		leftToY 162
	)

	(method (init)
		(gEgo init:)
		(if (== gPrevRoomNum south)
			(= bottomToX (= bottomFromX (ExcludeFountain (- 319 (gEgo x:)))))
		else
			(self style: 7)
		)
		(if gNight
			(= global61 3)
		else
			(= global61 2)
		)
		(super init:)
		(self overlay: gCurRoomNum)
		(if (or (== gCurRoomNum 390) (== gCurRoomNum 450))
			(InitAddToPics fountainBasin fountainSpout)
		)
	)

	(method (dispose)
		(= global61 0)
		(super dispose:)
	)
)

(instance fountainBasin of PicView
	(properties
		x 161
		y 197
		noun '/basin,fount'
		description {the city fountain}
		view 450
		priority 14
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(if gNight
			(= palette 2)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1)
			(HighPrint 93 0) ; "The cracked and dry fountain is a pitiful sight."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance fountainSpout of PicView
	(properties
		x 161
		y 194
		noun '/fount'
		description {the city fountain}
		view 450
		cel 1
		priority 15
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(if gNight
			(= palette 2)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1)
			(HighPrint 93 0) ; "The cracked and dry fountain is a pitiful sight."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

