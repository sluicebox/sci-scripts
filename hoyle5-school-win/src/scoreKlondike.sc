;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 680)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use GameControls)
(use System)

(public
	scoreKlondike 0
	scoreHand 1
)

(local
	local0
	[local1 18] = [8 4 2 3 1 5 6 7 0 13 15 9 16 12 10 14 11 17]
	local19 = -50
	local20
	local21
	local22
	local23
	local24
	local25
	local26
	local27
	local28
	local29
)

(procedure (localproc_0 param1 param2 param3 param4 param5 &tmp temp0)
	(if (and (< argc 4) (not param1))
		(return)
	)
	(if (< argc 5)
		(= param5 0)
	)
	(if (< param1 0)
		(= temp0 1)
		(*= param1 -1)
	else
		(= temp0 0)
	)
	(cond
		((>= param1 1000)
			(if (or param5 temp0)
				(drawSigns doit: param2 param3 param5 temp0)
			)
			(proc0_10
				680
				2
				(mod (/ param1 1000) 10)
				(+ param2 12)
				param3
				15
				klondikeScoreWindow
				{score}
			)
			(proc0_10
				680
				2
				(mod (/ param1 100) 10)
				(+ param2 20)
				param3
				15
				klondikeScoreWindow
				{score}
			)
			(proc0_10
				680
				2
				(mod (/ param1 10) 10)
				(+ param2 28)
				param3
				15
				klondikeScoreWindow
				{score}
			)
			(proc0_10
				680
				2
				(mod param1 10)
				(+ param2 36)
				param3
				15
				klondikeScoreWindow
				{score}
			)
		)
		((>= param1 100)
			(if (or param5 temp0)
				(drawSigns doit: (+ param2 8) param3 param5 temp0)
			)
			(proc0_10
				680
				2
				(mod (/ param1 100) 10)
				(+ param2 20)
				param3
				15
				klondikeScoreWindow
				{score}
			)
			(proc0_10
				680
				2
				(mod (/ param1 10) 10)
				(+ param2 28)
				param3
				15
				klondikeScoreWindow
				{score}
			)
			(proc0_10
				680
				2
				(mod param1 10)
				(+ param2 36)
				param3
				15
				klondikeScoreWindow
				{score}
			)
		)
		((>= param1 10)
			(if (or param5 temp0)
				(drawSigns doit: (+ param2 16) param3 param5 temp0)
			)
			(proc0_10
				680
				2
				(mod (/ param1 10) 10)
				(+ param2 28)
				param3
				15
				klondikeScoreWindow
				{score}
			)
			(proc0_10
				680
				2
				(mod param1 10)
				(+ param2 36)
				param3
				15
				klondikeScoreWindow
				{score}
			)
		)
		((>= param1 0)
			(if (or param5 temp0)
				(drawSigns doit: (+ param2 24) param3 param5 temp0)
			)
			(proc0_10
				680
				2
				(mod param1 10)
				(+ param2 36)
				param3
				15
				klondikeScoreWindow
				{score}
			)
		)
	)
)

(procedure (localproc_1)
	(= local0 gGameControls)
	(EnableCursor)
	(if (== global263 1)
		(iconOK nsLeft: 42 nsTop: 98 x: 42 y: 98)
	else
		(iconOK nsLeft: 49 nsTop: 156 x: 49 y: 156)
	)
	((= gGameControls klondikeScore)
		plane: klondikeScoreWindow
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add: (iconOK theObj: iconOK selector: #doit yourself:)
	)
	(gGameControls show:)
	(if (not (HaveMouse))
		(gMouseCursor x: (+ 104 (iconOK nsLeft:)) y: (+ 44 (iconOK nsTop:)))
		(SetCursor (gMouseCursor x:) (gMouseCursor y:))
	)
)

(instance scoreKlondike of Code
	(properties)

	(method (doit param1 param2)
		(= local29 param1)
		(if (and (>= argc 2) param2)
			(scoreHand init: param1)
		)
		(localproc_1)
	)
)

(instance drawSigns of Code
	(properties)

	(method (doit param1 param2 param3 param4)
		(cond
			((and param3 param4)
				(proc0_10 680 3 0 param1 param2 15 klondikeScoreWindow {score})
				(proc0_10
					680
					3
					1
					(+ param1 7)
					(- param2 3)
					15
					klondikeScoreWindow
					{score}
				)
			)
			(param4
				(proc0_10
					680
					3
					0
					(+ param1 7)
					(+ param2 2)
					15
					klondikeScoreWindow
					{score}
				)
			)
			(param3
				(proc0_10
					680
					3
					1
					(+ param1 7)
					(- param2 3)
					15
					klondikeScoreWindow
					{score}
				)
			)
		)
	)
)

(instance klondikeScoreWindow of InvisibleWindow
	(properties)

	(method (init)
		(if (== global263 1)
			(self top: 31 left: 84 bottom: 158 right: 254)
		else
			(self top: 10 left: 78 bottom: 194 right: 288)
		)
		(= priority 15)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(= local21 (* local29 5))
		(super init:)
		(if (== global263 1)
			(proc0_10 680 0 0 0 0 15 self)
			(localproc_0 local29 116 22 1)
			(localproc_0 local25 116 40 1)
			(localproc_0 global402 116 58 1)
			(localproc_0 local27 98 77 1)
			(proc0_10 680 3 2 142 84 15 self {score})
			(localproc_0 local28 117 77 1)
			(if (< local28 10)
				(localproc_0 0 108 77 1)
			)
		else
			(proc0_10 680 0 1 0 0 15 self {score})
			(localproc_0 local20 152 16 1 1)
			(localproc_0 local19 152 37 1 1)
			(localproc_0 local21 152 58 1 1)
			(localproc_0 (+ local19 (* local29 5)) 152 80 1 1)
			(localproc_0 global402 152 115 1)
			(localproc_0 local22 134 140 1 1)
			(proc0_10 680 3 2 177 147 15 self {score})
			(localproc_0 local23 152 140 1)
			(if (< local23 10)
				(localproc_0 0 144 140 1)
			)
		)
		(FrameOut)
	)
)

(instance klondikeScore of HoyleGameControls
	(properties)
)

(instance iconOK of ControlIcon
	(properties
		signal 387
		mainView 680
		mainLoop 1
		highlightColor -1
	)

	(method (doit)
		(gGameControls hide:)
		(RedrawCast)
		(= gGameControls local0)
	)
)

(instance scoreHand of Code
	(properties)

	(method (init param1)
		(++ global402)
		(+= global440 (* param1 5))
		(+= global441 param1)
		(= local24 (+ local19 local21))
		(= local25 (+ param1 local26))
		(= local23 0)
		(= local22 0)
		(if global402
			(if local24
				(= local22 (/ global440 global402))
				(for
					((= local23
						(/ (* (mod (Abs global440) global402) 100) global402)
					))
					(> local23 99)
					((/= local23 10))
				)
				(if (< local23 10)
					(= local23 0)
				)
			)
			(if local25
				(= local27 (/ global441 global402))
				(for
					((= local28 (/ (* (mod global441 global402) 100) global402)))
					(> local28 99)
					((/= local28 10))
				)
				(if (< local28 10)
					(= local28 0)
				)
			)
		)
	)

	(method (doit param1)
		(if global402
			(= local21 (* param1 5))
			(= local19 (- (= local20 (= local24 (+ local19 local21))) 50))
			(= local26 (= local25 (+ param1 local26)))
			(if global402
				(if local24
					(= local22 (/ global440 global402))
					(for
						((= local23
							(/
								(* (mod (Abs global440) global402) 100)
								global402
							)
						))
						(> local23 99)
						((/= local23 10))
					)
					(if (< local23 10)
						(= local23 0)
					)
				)
				(if local25
					(= local27 (/ global441 global402))
					(for
						((= local28
							(/ (* (mod global441 global402) 100) global402)
						))
						(> local28 99)
						((/= local28 10))
					)
					(if (< local28 10)
						(= local28 0)
					)
				)
			)
		)
	)
)

