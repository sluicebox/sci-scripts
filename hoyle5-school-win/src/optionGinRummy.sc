;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 490)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use GameControls)
(use System)

(public
	optionGinRummy 0
)

(local
	local0
	local1
)

(procedure (localproc_0)
	(= local0 gGameControls)
	(= local1 global271)
	((= gGameControls ginRummyOptions)
		plane: ginRummyWindow
		helpIconItem: iconHelp
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add:
			(iconSort theObj: iconSort selector: #doit yourself:)
			(iconVariant theObj: iconVariant selector: #doit yourself:)
			iconHelp
			(iconOK theObj: iconOK selector: #doit yourself:)
	)
	(gGameControls init:)
	(gGameControls show:)
	(DisposeScript 490)
)

(instance optionGinRummy of Code
	(properties)

	(method (init)
		(localproc_0)
	)
)

(instance ginRummyWindow of InvisibleWindow
	(properties
		left 77
		top 62
		right 242
		bottom 138
	)

	(method (init &tmp temp0)
		(super init:)
		(= priority 15)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(proc0_10 490 0 0 0 0 15 self)
	)

	(method (dispose)
		(super dispose:)
		((ScriptID 400 3) doit:) ; variantCode
	)
)

(instance ginRummyOptions of HoyleGameControls
	(properties)
)

(instance iconSort of ControlIcon
	(properties
		noun 1
		modNum 490
		nsLeft 11
		nsTop 11
		x 11
		y 11
		signal 387
		mainView 490
		mainLoop 5
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(= mainLoop
			(switch gGinRummyOptionSortMode
				(1 5)
				(2 6)
				(3 3)
				(4 4)
			)
		)
		(self setPri: 16)
		(super init: &rest)
	)

	(method (doit)
		(switch gGinRummyOptionSortMode
			(1
				(= gGinRummyOptionSortMode 2)
				(= mainLoop 6)
			)
			(2
				(= gGinRummyOptionSortMode 3)
				(= mainLoop 3)
			)
			(3
				(= gGinRummyOptionSortMode 4)
				(= mainLoop 4)
			)
			(4
				(= gGinRummyOptionSortMode 1)
				(= mainLoop 5)
			)
		)
		(= global290 (!= local1 gGinRummyOptionSortMode))
		(= gSortMode gGinRummyOptionSortMode)
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
	)
)

(instance iconVariant of ControlIcon
	(properties
		noun 2
		modNum 490
		nsLeft 11
		nsTop 29
		x 11
		y 29
		signal 387
		mainView 490
		mainLoop 1
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(= mainLoop
			(switch gGinRummyOptionIsVariant
				(0 1)
				(1 2)
			)
		)
		(super init: &rest)
	)

	(method (doit)
		(switch gGinRummyOptionIsVariant
			(0
				(= gGinRummyOptionIsVariant 1)
				(= mainLoop 2)
			)
			(1
				(= gGinRummyOptionIsVariant 0)
				(= mainLoop 1)
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
		modNum 490
		nsLeft 11
		nsTop 47
		x 11
		y 47
		signal 387
		mainView 490
		mainLoop 9
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
		modNum 490
		nsLeft 83
		nsTop 47
		x 83
		y 47
		signal 387
		mainView 490
		mainLoop 10
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp temp0)
		(gGameControls hide:)
		(RedrawCast)
		(= gGameControls local0)
		(gGinrummy_opt doit: 3)
	)
)

