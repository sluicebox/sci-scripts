;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6081)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use GameControls)
(use System)

(public
	scoreBowling 0
	scoreHand 1
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
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

(procedure (localproc_1)
	(= local0 gGameControls)
	(gGame setCursor: 999)
	(iconOK nsLeft: 190 nsTop: 200 x: 190 y: 200)
	((= gGameControls solitaireScore)
		plane: solitaireScoreWindow
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add: (iconOK theObj: iconOK selector: #doit yourself:)
	)
	(gGameControls show:)
	(if (not (HaveMouse))
		(gMouseCursor
			x: (+ (/ (- gScreenWidth 320) 2) (iconOK nsLeft:) 20)
			y: (+ (/ (- gScreenHeight 260) 2) (iconOK nsTop:) 13)
		)
		(SetCursor (gMouseCursor x:) (gMouseCursor y:))
	)
)

(instance scoreBowling of Code
	(properties)

	(method (doit param1 param2 param3 param4 param5)
		(if (> argc 1)
			(= local5 param2)
			(= local6 param3)
			(= local7 param4)
			(= local8 param5)
			(= local9 1)
		else
			(= local4 param1)
		)
		(localproc_1)
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
			top: (+ (/ (- gScreenHeight 260) 2) 2)
			left: (+ (/ (- gScreenWidth 320) 2) 1)
			bottom: (- (+ (/ (- gScreenHeight 260) 2) 260) 2)
			right: (+ (/ (- gScreenWidth 320) 2) 320)
		)
		(= priority 15)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(super init:)
		(if local9
			(proc0_10 979 0 1 0 0 15 self)
		else
			(proc0_10 979 0 0 0 0 15 self)
		)
		(proc0_10 979 11 0 45 60 15 self)
		(proc0_10 979 11 1 45 90 15 self)
		(proc0_10 979 11 2 45 120 15 self)
		(proc0_10 979 11 3 45 150 15 self)
		(if local9
			(= local9 0)
			(localproc_0 local5 170 58 1)
			(localproc_0 local6 170 88 1)
			(localproc_0 local7 170 118 1)
			(localproc_0 local8 170 148 1)
		else
			(localproc_0 global238 150 58 1)
			(localproc_0 global230 210 58 1)
			(localproc_0 global239 150 88 1)
			(localproc_0 global231 210 88 1)
			(localproc_0 global240 150 118 1)
			(localproc_0 global232 210 118 1)
			(localproc_0 global241 150 148 1)
			(localproc_0 global233 210 148 1)
		)
		(= global278 global238)
		(= global279 global239)
		(= global280 global240)
		(= global281 global241)
		(= global274 global234)
		(= global275 global235)
		(= global276 global236)
		(= global277 global237)
		(= global270 global230)
		(= global271 global231)
		(= global272 global232)
		(= global273 global233)
		(FrameOut)
	)
)

(instance solitaireScore of HoyleGameControls
	(properties)
)

(instance iconOK of ControlIcon
	(properties
		signal 387
		mainView 979
		mainLoop 9
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
		(+= global113 param1)
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

