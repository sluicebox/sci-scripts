;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 590)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use GameControls)
(use System)

(public
	optionCribbage 0
)

(local
	local0
)

(procedure (localproc_0)
	(= local0 gGameControls)
	((= gGameControls cribbageOptions)
		plane: cribbageWindow
		helpIconItem: iconHelp
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add:
			(iconSort theObj: iconSort selector: #doit yourself:)
			(iconMuggins theObj: iconMuggins selector: #doit yourself:)
			iconHelp
			(iconOK theObj: iconOK selector: #doit yourself:)
	)
	(gGameControls show:)
	(DisposeScript 590)
)

(instance optionCribbage of Code
	(properties)

	(method (init)
		(localproc_0)
	)
)

(instance cribbageWindow of InvisibleWindow
	(properties
		left 82
		top 62
		right 229
		bottom 138
	)

	(method (init &tmp temp0)
		(= priority 10)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(super init:)
		(proc0_10 590 0 0 0 0 15 self)
	)
)

(instance cribbageOptions of HoyleGameControls
	(properties)
)

(instance iconSort of ControlIcon
	(properties
		noun 1
		modNum 590
		nsLeft 13
		nsTop 11
		x 13
		y 11
		signal 387
		mainView 590
		mainLoop 1
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(= mainLoop
			(switch global251
				(0 3)
				(1 1)
				(2 2)
			)
		)
		(self setPri: 16)
		(super init: &rest)
	)

	(method (doit)
		(switch global251
			(0
				(= global251 1)
				(= mainLoop 1)
			)
			(1
				(= global251 2)
				(= mainLoop 2)
			)
			(2
				(= global251 0)
				(= mainLoop 3)
			)
		)
		(= gSortMode global251)
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
	)
)

(instance iconMuggins of ControlIcon
	(properties
		noun 2
		modNum 590
		nsLeft 13
		nsTop 28
		x 13
		y 28
		signal 387
		mainView 590
		mainLoop 4
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(= mainLoop
			(switch global252
				(0 5)
				(1 4)
			)
		)
		(super init: &rest)
	)

	(method (doit)
		(switch global252
			(0
				(= global252 1)
				(= mainLoop 4)
			)
			(1
				(= global252 0)
				(= mainLoop 5)
			)
		)
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
	)
)

(instance iconHelp of ControlIcon
	(properties
		noun 3
		modNum 590
		nsLeft 13
		nsTop 46
		x 13
		y 46
		signal 387
		mainView 590
		mainLoop 6
		cursorView 995
		highlightColor -1
		helpVerb 4
	)

	(method (doit)
		(super doit: &rest)
	)
)

(instance iconOK of ControlIcon
	(properties
		noun 4
		modNum 590
		nsLeft 74
		nsTop 46
		x 74
		y 46
		signal 387
		mainView 590
		mainLoop 7
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp temp0)
		(gGameControls hide:)
		(RedrawCast)
		(= gGameControls local0)
		(if 1
			(gCribbage_opt doit: 3)
		)
	)
)

