;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 390)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use GameControls)
(use System)

(public
	optionHearts 0
)

(local
	local0
	local1
	local2
	local3
)

(procedure (localproc_0)
	(= local0 gGameControls)
	(= local1 global231)
	(= local2 global232)
	(= local3 0)
	((= gGameControls heartsOptions)
		plane: heartsWindow
		helpIconItem: iconHelp
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add:
			(iconSort theObj: iconSort selector: #doit yourself:)
			(iconSuitOrder theObj: iconSuitOrder selector: #doit yourself:)
			(iconLead theObj: iconLead selector: #doit yourself:)
			(iconPassing theObj: iconPassing selector: #doit yourself:)
			(iconQueenHeart theObj: iconQueenHeart selector: #doit yourself:)
			(iconBreak1st theObj: iconBreak1st selector: #doit yourself:)
			iconHelp
			(iconOK theObj: iconOK selector: #doit yourself:)
	)
	(gGameControls show:)
	(DisposeScript 390)
)

(instance optionHearts of Code
	(properties)

	(method (init)
		(localproc_0)
	)
)

(instance heartsWindow of InvisibleWindow
	(properties
		left 172
		top 64
		right 540
		bottom 426
	)

	(method (init &tmp temp0)
		(= priority 15)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(super init:)
		(proc0_10 390 0 0 0 0 0 self)
	)
)

(instance heartsOptions of HoyleGameControls
	(properties)
)

(instance iconSort of ControlIcon
	(properties
		noun 1
		modNum 390
		nsLeft 19
		nsTop 19
		x 19
		y 19
		signal 387
		mainView 390
		mainLoop 1
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(= mainLoop
			(if (== global231 4)
				2
			else
				(= global231 3)
				1
			)
		)
		(super init: &rest)
	)

	(method (doit)
		(switch global231
			(3
				(= global231 4)
				(= mainLoop 2)
			)
			(4
				(= global231 3)
				(= mainLoop 1)
			)
		)
		(= global290 (!= local1 global231))
		(= gSortMode global231)
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
	)
)

(instance iconSuitOrder of ControlIcon
	(properties
		noun 2
		modNum 390
		nsLeft 19
		nsTop 62
		x 19
		y 62
		signal 387
		mainView 390
		mainLoop 3
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(= mainLoop
			(switch global232
				(0 3)
				(1 4)
			)
		)
		(super init: &rest)
	)

	(method (doit)
		(switch global232
			(0
				(= global232 1)
				(= mainLoop 4)
				(= [global390 0] 0)
				(= [global390 1] 2)
				(= [global390 2] 1)
				(= [global390 3] 3)
			)
			(1
				(= global232 0)
				(= [global390 0] (= mainLoop 3))
				(= [global390 1] 1)
				(= [global390 2] 2)
				(= [global390 3] 0)
			)
		)
		(= local3 (!= local2 global232))
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
	)
)

(instance iconLead of ControlIcon
	(properties
		noun 3
		modNum 390
		nsLeft 19
		nsTop 105
		x 19
		y 105
		signal 387
		mainView 390
		mainLoop 9
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(= mainLoop
			(switch global233
				(0 9)
				(1 10)
			)
		)
		(super init: &rest)
	)

	(method (doit)
		(switch global233
			(0
				(= global233 1)
				(= mainLoop 10)
			)
			(1
				(= global233 0)
				(= mainLoop 9)
			)
		)
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
	)
)

(instance iconPassing of ControlIcon
	(properties
		noun 7
		modNum 390
		nsLeft 19
		nsTop 148
		x 19
		y 148
		signal 387
		mainView 390
		mainLoop 13
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(switch global234
			(0
				(= mainCel 0)
			)
			(1
				(= mainCel 2)
			)
			(2
				(= mainCel 4)
			)
		)
		(super init: &rest)
	)

	(method (doit)
		(switch global234
			(0
				(= global234 1)
				(= mainCel 2)
			)
			(1
				(= global234 2)
				(= mainCel 4)
			)
			(2
				(= global234 0)
				(= mainCel 0)
			)
		)
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
	)
)

(instance iconQueenHeart of ControlIcon
	(properties
		noun 8
		modNum 390
		nsLeft 19
		nsTop 191
		x 19
		y 191
		signal 387
		mainView 390
		mainLoop 14
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(switch global235
			(0
				(= mainCel 2)
			)
			(1
				(= mainCel 0)
			)
		)
		(super init: &rest)
	)

	(method (doit)
		(switch global235
			(0
				(= global235 1)
				(= mainCel 0)
			)
			(1
				(= global235 0)
				(= mainCel 2)
			)
		)
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
	)
)

(instance iconBreak1st of ControlIcon
	(properties
		noun 9
		modNum 390
		nsLeft 19
		nsTop 234
		x 19
		y 234
		signal 387
		mainView 390
		mainLoop 15
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(switch global236
			(0
				(= mainCel 0)
			)
			(1
				(= mainCel 2)
			)
		)
		(super init: &rest)
	)

	(method (doit)
		(switch global236
			(0
				(= global236 1)
				(= mainCel 2)
			)
			(1
				(= global236 0)
				(= mainCel 0)
			)
		)
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
	)
)

(instance iconHelp of ControlIcon
	(properties
		noun 4
		modNum 390
		nsLeft 19
		nsTop 278
		x 19
		y 278
		signal 387
		mainView 390
		mainLoop 11
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
		noun 6
		modNum 390
		nsLeft 191
		nsTop 278
		x 191
		y 278
		signal 387
		mainView 390
		mainLoop 12
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp temp0)
		(gGameControls hide:)
		(RedrawCast)
		(= gGameControls local0)
		(if local3
			(= global290 1)
		)
		(if 1
			(gHearts_opt doit: 3)
		)
	)
)

