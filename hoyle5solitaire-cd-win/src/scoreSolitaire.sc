;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6080)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use GameControls)
(use System)

(public
	scoreSolitaire 0
	scoreHand 1
	proc6080_2 2
)

(local
	local0
	local1
	local2
	local3
	local4
)

(procedure (proc6080_2 param1 param2 param3 param4 param5 &tmp temp0)
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
				solitaireScoreWindow
				{score}
			)
			(proc0_10
				680
				2
				(mod (/ param1 100) 10)
				(+ param2 39)
				param3
				15
				solitaireScoreWindow
				{score}
			)
			(proc0_10
				680
				2
				(mod (/ param1 10) 10)
				(+ param2 48)
				param3
				15
				solitaireScoreWindow
				{score}
			)
			(proc0_10
				680
				2
				(mod param1 10)
				(+ param2 57)
				param3
				15
				solitaireScoreWindow
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
				solitaireScoreWindow
				{score}
			)
			(proc0_10
				680
				2
				(mod (/ param1 10) 10)
				(+ param2 48)
				param3
				15
				solitaireScoreWindow
				{score}
			)
			(proc0_10
				680
				2
				(mod param1 10)
				(+ param2 57)
				param3
				15
				solitaireScoreWindow
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
				solitaireScoreWindow
				{score}
			)
			(proc0_10
				680
				2
				(mod param1 10)
				(+ param2 57)
				param3
				15
				solitaireScoreWindow
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
				solitaireScoreWindow
				{score}
			)
		)
	)
)

(procedure (localproc_0)
	(= local0 gGameControls)
	(gGame setCursor: 999)
	(iconOK nsLeft: 184 nsTop: 168 x: 184 y: 168)
	((= gGameControls solitaireScore)
		plane: solitaireScoreWindow
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

(instance scoreSolitaire of Code
	(properties)

	(method (doit param1 param2)
		(= local4 param1)
		(if (and global402 global113)
			(= local2 (/ global113 global402))
			(for
				((= local3 (/ (* (mod global113 global402) 100) global402)))
				(> local3 99)
				((/= local3 10))
			)
			(if (< local3 10)
				(= local3 0)
			)
		)
		(if (and (>= argc 2) param2)
			(scoreHand init: param1)
		)
		(localproc_0)
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
					solitaireScoreWindow
					{score}
				)
				(proc0_10
					680
					3
					1
					(+ param1 19)
					(- param2 1)
					15
					solitaireScoreWindow
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
					solitaireScoreWindow
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
					solitaireScoreWindow
					{score}
				)
			)
		)
	)
)

(instance solitaireScoreWindow of InvisibleWindow
	(properties)

	(method (init)
		(self
			top: (/ (- gScreenHeight 224) 2)
			left: (/ (- gScreenWidth 300) 2)
			bottom: (+ (/ (- gScreenHeight 224) 2) 224)
			right: (+ (/ (- gScreenWidth 300) 2) 300)
		)
		(= priority 15)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(super init:)
		(proc0_10 680 0 0 0 0 15 self)
		(proc6080_2 local4 188 47 1)
		(proc6080_2 global113 188 75 1)
		(proc6080_2 global402 188 103 1)
		(proc6080_2 local2 164 131 1)
		(proc0_10 680 3 2 230 131 15 self {score})
		(proc6080_2 local3 188 131 1)
		(if (< local3 10)
			(proc6080_2 0 178 131 1)
		)
		(FrameOut)
	)
)

(instance solitaireScore of HoyleGameControls
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
		(= global184 (+= global113 param1))
		(= global185 global402)
		(if (and global402 global113)
			(= local2 (/ global113 global402))
			(for
				((= local3 (/ (* (mod global113 global402) 100) global402)))
				(> local3 99)
				((/= local3 10))
			)
			(if (< local3 10)
				(= local3 0)
			)
		)
	)

	(method (doit)
		(if global402
			(= local1 global113)
			(if (and global402 global113)
				(= local2 (/ global113 global402))
				(for
					((= local3 (/ (* (mod global113 global402) 100) global402)))
					(> local3 99)
					((/= local3 10))
				)
				(if (< local3 10)
					(= local3 0)
				)
			)
		)
	)
)

