;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 280)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use GameControls)
(use System)

(public
	scoreOldMaid 0
)

(local
	local0
	[local1 18] = [8 4 2 3 1 5 6 7 0 13 15 9 16 12 10 14 11 17]
)

(procedure (localproc_0)
	(= local0 gGameControls)
	(EnableCursor)
	((= gGameControls oldMaidScore)
		plane: oldMaidScoreWindow
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add: (iconOK theObj: iconOK selector: #doit yourself:)
	)
	(gGameControls show:)
	(if (not (HaveMouse))
		(gMouseCursor x: (+ 90 (iconOK nsLeft:)) y: (+ 51 (iconOK nsTop:)))
		(SetCursor (gMouseCursor x:) (gMouseCursor y:))
	)
)

(instance scoreOldMaid of Code
	(properties)

	(method (doit)
		(localproc_0)
	)
)

(instance oldMaidScoreWindow of InvisibleWindow
	(properties
		left 70
		top 38
		right 246
		bottom 189
	)

	(method (init &tmp temp0 temp1 [temp2 4])
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(= priority 15)
		(super init:)
		(proc0_10 280 0 0 0 0 15 self)
		(= temp1 (((gTheHands at: 1) owner:) view:))
		(proc0_10
			280
			(if (>= temp1 9) 2 else 1)
			(mod temp1 9)
			19
			22
			15
			self
			{score}
		)
		(drawMaids doit: temp1 1 22)
		(= temp1 (((gTheHands at: 2) owner:) view:))
		(proc0_10
			280
			(if (>= temp1 9) 2 else 1)
			(mod temp1 9)
			19
			47
			15
			self
			{score}
		)
		(drawMaids doit: temp1 2 47)
		(= temp1 (((gTheHands at: 3) owner:) view:))
		(proc0_10
			280
			(if (>= temp1 9) 2 else 1)
			(mod temp1 9)
			19
			72
			15
			self
			{score}
		)
		(drawMaids doit: temp1 3 72)
		(proc0_10 280 3 0 19 99 15 self {score})
		(drawMaids doit: 99 0 99)
	)
)

(instance drawMaids of Code
	(properties)

	(method (doit param1 param2 param3 &tmp temp0 temp1)
		(= temp1 25)
		(for
			((= temp0 0))
			(< temp0 ((gTheHands at: param2) total:))
			((++ temp0))
			
			(if (> temp1 115)
				(break)
			)
			(if (< param1 99)
				(proc0_10
					280
					4
					0
					(+
						(CelWide 280 (if (>= param1 9) 2 else 1) (mod param1 9))
						temp1
					)
					(- param3 11)
					15
					oldMaidScoreWindow
					{score}
				)
			else
				0
				(proc0_10
					280
					4
					0
					(+ (CelWide 280 3 0) temp1)
					(- param3 11)
					15
					oldMaidScoreWindow
					{score}
				)
			)
			(+= temp1 23)
		)
	)
)

(instance oldMaidScore of HoyleGameControls
	(properties)
)

(instance iconOK of ControlIcon
	(properties
		nsLeft 93
		nsTop 127
		x 93
		y 127
		signal 387
		mainView 280
		mainLoop 5
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gGameControls hide:)
		(RedrawCast)
		(= gGameControls local0)
	)
)

