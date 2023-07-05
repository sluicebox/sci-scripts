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
		window: klondikeWindow
		helpIconItem: iconHelp
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add:
			(iconFlip theObj: iconFlip selector: #doit init: yourself:)
			(iconTopShown theObj: iconTopShown selector: #doit init: yourself:)
			(iconScoring theObj: iconScoring selector: #doit init: yourself:)
			(iconTimesThru
				theObj: iconTimesThru
				selector: #doit
				init:
				yourself:
			)
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
		(localproc_0)
	)
)

(instance klondikeWindow of InvisibleWindow
	(properties
		top 32
		left 55
		bottom 165
		right 265
	)

	(method (open &tmp temp0)
		(super open:)
		(= local1 0)
		(DrawCel 690 0 0 0 0 15)
		(Graph grUPDATE_BOX top left (+ bottom 1) (+ right 1) 1)
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
		view 690
		loop 1
		cel 0
		nsLeft 11
		nsTop 10
		signal 387
		highlightColor -1
		noun 1
		modNum 690
		helpVerb 4
	)

	(method (init)
		(= loop
			(switch global261
				(0 1)
				(1 2)
			)
		)
	)

	(method (doit)
		(switch global261
			(0
				(= global261 1)
				(= loop 2)
			)
			(1
				(= global261 0)
				(= loop 1)
			)
		)
		(self show:)
	)
)

(instance iconTopShown of ControlIcon
	(properties
		view 690
		loop 6
		cel 0
		nsLeft 95
		nsTop 10
		signal 387
		highlightColor -1
		noun 2
		modNum 690
		helpVerb 4
	)

	(method (init)
		(= loop
			(switch global262
				(0 6)
				(1 14)
			)
		)
	)

	(method (doit)
		(switch global262
			(0
				(= global262 1)
				(= loop 14)
			)
			(1
				(= global262 0)
				(= loop 6)
			)
		)
		(self show:)
	)
)

(instance iconScoring of ControlIcon
	(properties
		view 690
		cel 0
		nsLeft 11
		nsTop 28
		signal 387
		highlightColor -1
		noun 3
		modNum 690
		helpVerb 4
	)

	(method (init)
		(= loop
			(switch global263
				(0 10)
				(1 11)
			)
		)
	)

	(method (doit)
		(switch global263
			(0
				(= global263 1)
				(= loop 11)
			)
			(1
				(= global263 0)
				(= loop 10)
			)
		)
		(self show:)
	)
)

(instance iconTimesThru of ControlIcon
	(properties
		view 690
		loop 3
		cel 0
		nsLeft 11
		nsTop 46
		signal 387
		highlightColor -1
		noun 4
		modNum 690
		helpVerb 4
	)

	(method (init)
		(= loop
			(switch global264
				(0 3)
				(1 4)
				(2 5)
			)
		)
	)

	(method (doit)
		(switch global264
			(0
				(= global264 1)
				(= loop 4)
			)
			(1
				(= global264 2)
				(= loop 5)
			)
			(2
				(= global264 0)
				(= loop 3)
			)
		)
		(self show:)
	)
)

(instance iconAbandon of ControlIcon
	(properties
		view 690
		loop 8
		cel 0
		nsLeft 11
		nsTop 64
		signal 387
		highlightColor -1
		noun 5
		modNum 690
		helpVerb 4
	)

	(method (doit)
		((ScriptID 930 0) init: 913 3 gCurRoomNum) ; yesNo
		(if global461
			(= local1 1)
			(iconOK doit:)
		)
	)
)

(instance iconUndo of ControlIcon
	(properties
		view 690
		loop 7
		cel 0
		nsLeft 102
		nsTop 64
		signal 387
		highlightColor -1
		noun 6
		modNum 690
		helpVerb 4
	)

	(method (doit)
		(= local1 2)
		(iconOK doit:)
	)
)

(instance iconSameDeck of ControlIcon
	(properties
		view 690
		loop 9
		cel 0
		nsLeft 11
		nsTop 82
		signal 387
		highlightColor -1
		noun 7
		modNum 690
		helpVerb 4
	)

	(method (doit)
		((ScriptID 930 0) init: 913 3 gCurRoomNum) ; yesNo
		(if global461
			(= local1 1)
			(= global265 1)
			(iconOK doit:)
		)
	)
)

(instance iconHelp of ControlIcon
	(properties
		view 690
		loop 12
		cel 0
		nsLeft 11
		nsTop 100
		cursor 995
		signal 387
		highlightColor -1
		noun 8
		modNum 690
		helpVerb 4
	)

	(method (doit)
		(super doit: &rest)
	)
)

(instance iconOK of ControlIcon
	(properties
		view 690
		loop 13
		cel 0
		nsLeft 103
		nsTop 100
		signal 387
		highlightColor -1
		noun 9
		modNum 690
		helpVerb 4
	)

	(method (doit &tmp temp0)
		(gGameControls hide: dispose:)
		(proc0_1)
		(= gGameControls local0)
		(if 1
			(gKlondike_opt doit: 3)
		)
	)
)

