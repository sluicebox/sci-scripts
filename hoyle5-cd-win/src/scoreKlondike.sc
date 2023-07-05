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
				(+ param2 30)
				param3
				15
				klondikeScoreWindow
				{score}
			)
			(proc0_10
				680
				2
				(mod (/ param1 100) 10)
				(+ param2 39)
				param3
				15
				klondikeScoreWindow
				{score}
			)
			(proc0_10
				680
				2
				(mod (/ param1 10) 10)
				(+ param2 48)
				param3
				15
				klondikeScoreWindow
				{score}
			)
			(proc0_10
				680
				2
				(mod param1 10)
				(+ param2 57)
				param3
				15
				klondikeScoreWindow
				{score}
			)
		)
		((>= param1 100)
			(if (or param5 temp0)
				(drawSigns doit: (+ param2 9) param3 param5 temp0)
			)
			(proc0_10
				680
				2
				(mod (/ param1 100) 10)
				(+ param2 39)
				param3
				15
				klondikeScoreWindow
				{score}
			)
			(proc0_10
				680
				2
				(mod (/ param1 10) 10)
				(+ param2 48)
				param3
				15
				klondikeScoreWindow
				{score}
			)
			(proc0_10
				680
				2
				(mod param1 10)
				(+ param2 57)
				param3
				15
				klondikeScoreWindow
				{score}
			)
		)
		((>= param1 10)
			(if (or param5 temp0)
				(drawSigns doit: (+ param2 18) param3 param5 temp0)
			)
			(proc0_10
				680
				2
				(mod (/ param1 10) 10)
				(+ param2 48)
				param3
				15
				klondikeScoreWindow
				{score}
			)
			(proc0_10
				680
				2
				(mod param1 10)
				(+ param2 57)
				param3
				15
				klondikeScoreWindow
				{score}
			)
		)
		((>= param1 0)
			(if (or param5 temp0)
				(drawSigns doit: (+ param2 27) param3 param5 temp0)
			)
			(proc0_10
				680
				2
				(mod param1 10)
				(+ param2 57)
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
	(gGame setCursor: 999)
	(if (== global263 1)
		(iconOK nsLeft: 180 nsTop: 169 x: 180 y: 169)
	else
		(iconOK nsLeft: 192 nsTop: 237 x: 192 y: 237)
	)
	((= gGameControls klondikeScore)
		plane: klondikeScoreWindow
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add: (iconOK theObj: iconOK selector: #doit yourself:)
	)
	(gGameControls show:)
	(if (not (HaveMouse))
		(gMouseCursor
			x: (+ (/ (- gScreenWidth 300) 2) (iconOK nsLeft:) 20)
			y: (+ (/ (- gScreenHeight 224) 2) (iconOK nsTop:) 13)
		)
		(SetCursor (gMouseCursor x:) (gMouseCursor y:))
	)
)

(instance scoreKlondike of Code
	(properties)

	(method (doit param1 param2)
		(= local29 param1)
		(gSong stop:)
		(if global878
			(PlaySong play: (+ 60 global878))
		else
			(PlaySong play: 61)
		)
		(if (and (>= argc 2) param2)
			(scoreHand init: param1)
		)
		(localproc_1)
		(PlaySong play: 0)
	)
)

(instance drawSigns of Code
	(properties)

	(method (doit param1 param2 param3 param4)
		(cond
			((and param3 param4)
				(proc0_10
					680
					3
					0
					(+ param1 9)
					param2
					15
					klondikeScoreWindow
					{score}
				)
				(proc0_10
					680
					3
					1
					(+ param1 19)
					(- param2 1)
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
					(+ param1 9)
					param2
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
					(+ param1 19)
					(- param2 1)
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
			(self
				top: (/ (- gScreenHeight 224) 2)
				left: (/ (- gScreenWidth 300) 2)
				bottom: (+ (/ (- gScreenHeight 224) 2) 224)
				right: (+ (/ (- gScreenWidth 300) 2) 300)
			)
		else
			(self
				top: (/ (- gScreenHeight 292) 2)
				left: (/ (- gScreenWidth 296) 2)
				bottom: (+ (/ (- gScreenHeight 292) 2) 292)
				right: (+ (/ (- gScreenWidth 296) 2) 296)
			)
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
			(localproc_0 local29 188 47 1)
			(localproc_0 local25 188 75 1)
			(localproc_0 global402 188 103 1)
			(localproc_0 local27 164 131 1)
			(proc0_10 680 3 2 230 131 15 self {score})
			(localproc_0 local28 188 131 1)
			(if (< local28 10)
				(localproc_0 0 178 131 1)
			)
		else
			(proc0_10 680 0 1 0 0 15 self {score})
			(localproc_0 local20 203 41 1 1)
			(localproc_0 local19 203 69 1 1)
			(localproc_0 local21 203 97 1 1)
			(localproc_0 (+ local19 (* local29 5)) 203 125 1 1)
			(localproc_0 global402 203 181 1)
			(localproc_0 local22 180 209 1 1)
			(proc0_10 680 3 2 245 209 15 self {score})
			(localproc_0 local23 203 209 1)
			(if (< local23 10)
				(localproc_0 0 193 209 1)
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

