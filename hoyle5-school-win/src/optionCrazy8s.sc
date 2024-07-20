;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 190)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use GameControls)
(use System)

(public
	optionCrazy8s 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0)
	(= local0 gGameControls)
	(= local1 global221)
	(= local2 global222)
	((= gGameControls crazy8sOptions)
		plane: crazy8sWindow
		helpIconItem: iconHelp
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add:
			(iconSort theObj: iconSort selector: #doit yourself:)
			(iconEights theObj: iconEights selector: #doit yourself:)
			(iconVariant theObj: iconVariant selector: #doit yourself:)
			(iconDrawLimit theObj: iconDrawLimit selector: #doit yourself:)
			iconHelp
			(iconOK theObj: iconOK selector: #doit yourself:)
	)
	(gGameControls show:)
	(DisposeScript 190)
)

(instance optionCrazy8s of Code
	(properties)

	(method (init)
		(Load rsVIEW 190)
		(Load rsVIEW 1902)
		(localproc_0)
	)
)

(instance crazy8sWindow of InvisibleWindow
	(properties
		left 65
		top 45
		right 256
		bottom 154
	)

	(method (init &tmp temp0)
		(= priority 15)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(super init:)
		(proc0_10 190 0 0 0 0 0 self)
	)
)

(instance crazy8sOptions of HoyleGameControls
	(properties)
)

(instance iconSort of ControlIcon
	(properties
		noun 5
		modNum 190
		nsLeft 12
		nsTop 11
		x 10
		y 5
		signal 387
		mainView 1902
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(= mainLoop
			(switch global221
				(1 0)
				(2 1)
				(3 2)
				(4 3)
				(0 4)
			)
		)
		(super init: &rest)
	)

	(method (doit)
		(switch global221
			(1
				(= global221 2)
				(= mainLoop 1)
			)
			(2
				(= global221 3)
				(= mainLoop 2)
			)
			(3
				(= global221 4)
				(= mainLoop 3)
			)
			(4
				(= global221 0)
				(= mainLoop 4)
			)
			(0
				(= global221 1)
				(= mainLoop 0)
			)
		)
		(= global290 (and (!= (= gSortMode global221) 0) (!= local1 global221)))
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
	)
)

(instance iconEights of ControlIcon
	(properties
		noun 2
		modNum 190
		nsLeft 12
		nsTop 29
		x 10
		y 25
		signal 387
		mainView 1902
		mainLoop 5
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(= mainLoop
			(switch global222
				(0 5)
				(1 6)
				(2 7)
			)
		)
		(super init: &rest)
	)

	(method (doit)
		(switch global222
			(0
				(= global222 1)
				(= mainLoop 6)
			)
			(1
				(= global222 2)
				(= mainLoop 7)
			)
			(2
				(= global222 0)
				(= mainLoop 5)
			)
		)
		(= global290
			(or
				(and (== local2 0) (== global222 1))
				(and (== local2 1) (== global222 0))
				(and (== local2 2) (!= global222 2))
			)
		)
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
	)
)

(instance iconVariant of ControlIcon
	(properties
		noun 6
		modNum 190
		nsLeft 12
		nsTop 47
		x 10
		y 45
		signal 387
		mainView 1902
		mainLoop 8
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(= mainLoop
			(switch global223
				(0 8)
				(1 9)
			)
		)
		(super init: &rest)
	)

	(method (doit)
		(switch global223
			(0
				(= global223 1)
				(= mainLoop 9)
			)
			(1
				(= global223 0)
				(= mainLoop 8)
			)
		)
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
	)
)

(instance iconDrawLimit of ControlIcon
	(properties
		noun 1
		modNum 190
		nsLeft 12
		nsTop 65
		x 10
		y 65
		signal 387
		mainView 1902
		mainLoop 10
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(= mainLoop
			(switch global224
				(0 10)
				(1 11)
				(2 12)
			)
		)
		(super init: &rest)
	)

	(method (doit)
		(switch global224
			(0
				(= global224 1)
				(= mainLoop 11)
			)
			(1
				(= global224 2)
				(= mainLoop 12)
			)
			(2
				(= global224 0)
				(= mainLoop 10)
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
		modNum 190
		nsLeft 12
		nsTop 83
		x 10
		y 85
		signal 387
		mainView 1902
		mainLoop 13
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
		modNum 190
		nsLeft 96
		nsTop 83
		x 95
		y 85
		signal 387
		mainView 1902
		mainLoop 14
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp temp0)
		(gGameControls hide:)
		(if global290
			(DisableCursor)
		)
		(RedrawCast)
		(= gGameControls local0)
		(gCrazy8s_opt doit: 3)
	)
)

