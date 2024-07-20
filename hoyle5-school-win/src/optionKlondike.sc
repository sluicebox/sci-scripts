;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 690)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use GameControls)
(use System)

(public
	optionKlondike 0
)

(local
	local0
	local1
)

(procedure (localproc_0)
	(= local0 gGameControls)
	((= gGameControls klondikeOptions)
		plane: klondikeWindow
		helpIconItem: iconHelp
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add:
			(iconFlip theObj: iconFlip selector: #doit yourself:)
			(iconTopShown theObj: iconTopShown selector: #doit yourself:)
			(iconScoring theObj: iconScoring selector: #doit yourself:)
			(iconTimesThru theObj: iconTimesThru selector: #doit yourself:)
			(iconAbandon theObj: iconAbandon selector: #doit yourself:)
			(iconUndo theObj: iconUndo selector: #doit yourself:)
			(iconSameDeck theObj: iconSameDeck selector: #doit yourself:)
			iconHelp
			(iconOK theObj: iconOK selector: #doit yourself:)
	)
	(gGameControls show:)
	(DisposeScript 690)
)

(instance optionKlondike of Code
	(properties)

	(method (init)
		(Load rsVIEW 690)
		(localproc_0)
	)
)

(instance klondikeWindow of InvisibleWindow
	(properties
		left 55
		top 32
		right 265
		bottom 165
	)

	(method (init &tmp temp0)
		(= priority 15)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(= local1 0)
		(super init:)
		(proc0_10 690 0 0 0 0 8 self)
	)

	(method (dispose)
		(super dispose:)
		((ScriptID 600 2) doit: local1) ; optionCode
	)
)

(instance klondikeOptions of HoyleGameControls
	(properties)
)

(instance iconFlip of ControlIcon
	(properties
		noun 1
		modNum 690
		nsLeft 11
		nsTop 10
		x 11
		y 10
		signal 387
		mainView 690
		mainLoop 1
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(= mainLoop
			(switch global261
				(0 1)
				(1 2)
			)
		)
		(super init: &rest)
	)

	(method (doit)
		(switch global261
			(0
				(= global261 1)
				(= mainLoop 2)
			)
			(1
				(= global261 0)
				(= mainLoop 1)
			)
		)
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
	)
)

(instance iconTopShown of ControlIcon
	(properties
		noun 2
		modNum 690
		nsLeft 95
		nsTop 10
		x 95
		y 10
		signal 387
		mainView 690
		mainLoop 6
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(= mainLoop
			(switch global262
				(0 6)
				(1 14)
			)
		)
		(super init: &rest)
	)

	(method (doit)
		(switch global262
			(0
				(= global262 1)
				(= mainLoop 14)
			)
			(1
				(= global262 0)
				(= mainLoop 6)
			)
		)
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
	)
)

(instance iconScoring of ControlIcon
	(properties
		noun 3
		modNum 690
		nsLeft 11
		nsTop 28
		x 11
		y 28
		signal 387
		mainView 690
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(= mainLoop
			(switch global263
				(0 10)
				(1 11)
			)
		)
		(super init: &rest)
	)

	(method (doit)
		(switch global263
			(0
				(= global263 1)
				(= mainLoop 11)
			)
			(1
				(= global263 0)
				(= mainLoop 10)
			)
		)
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
	)
)

(instance iconTimesThru of ControlIcon
	(properties
		noun 4
		modNum 690
		nsLeft 11
		nsTop 46
		x 11
		y 46
		signal 387
		mainView 690
		mainLoop 3
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(= mainLoop
			(switch global264
				(0 3)
				(1 4)
				(2 5)
			)
		)
		(super init: &rest)
	)

	(method (doit)
		(switch global264
			(0
				(= global264 1)
				(= mainLoop 4)
			)
			(1
				(= global264 2)
				(= mainLoop 5)
			)
			(2
				(= global264 0)
				(= mainLoop 3)
			)
		)
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
	)
)

(instance iconAbandon of ControlIcon
	(properties
		noun 5
		modNum 690
		nsLeft 11
		nsTop 64
		x 11
		y 64
		signal 387
		mainView 690
		mainLoop 8
		highlightColor -1
		helpVerb 4
	)

	(method (doit)
		((ScriptID 930 0) init: 913 3 gCurRoomNum) ; yesNo
		(if global748
			(= local1 1)
			(iconOK doit:)
		)
	)
)

(instance iconUndo of ControlIcon
	(properties
		noun 6
		modNum 690
		nsLeft 102
		nsTop 64
		x 102
		y 64
		signal 387
		mainView 690
		mainLoop 7
		highlightColor -1
		helpVerb 4
	)

	(method (doit)
		(= local1 2)
		(iconOK doit:)
	)
)

(instance iconSameDeck of ControlIcon
	(properties
		noun 7
		modNum 690
		nsLeft 11
		nsTop 82
		x 11
		y 82
		signal 387
		mainView 690
		mainLoop 9
		highlightColor -1
		helpVerb 4
	)

	(method (doit)
		((ScriptID 930 0) init: 913 3 gCurRoomNum) ; yesNo
		(if global748
			(= local1 1)
			(= global265 1)
			(iconOK doit:)
		)
	)
)

(instance iconHelp of ControlIcon
	(properties
		noun 8
		modNum 690
		nsLeft 11
		nsTop 100
		x 11
		y 100
		signal 387
		mainView 690
		mainLoop 12
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
		noun 9
		modNum 690
		nsLeft 103
		nsTop 100
		x 103
		y 100
		signal 387
		mainView 690
		mainLoop 13
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp temp0)
		(gGameControls hide:)
		(RedrawCast)
		(= gGameControls local0)
		(if 1
			(gKlondike_opt doit: 3)
		)
	)
)

