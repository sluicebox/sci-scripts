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
		window: cribbageWindow
		helpIconItem: iconHelp
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add:
			(iconSort theObj: iconSort selector: #doit init: yourself:)
			(iconMuggins theObj: iconMuggins selector: #doit init: yourself:)
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
		top 62
		left 82
		bottom 138
		right 229
	)

	(method (open &tmp temp0)
		(super open:)
		(DrawCel 590 0 0 0 0 15)
		(Graph grUPDATE_BOX top left (+ bottom 1) (+ right 1) 1)
	)
)

(instance cribbageOptions of HoyleGameControls
	(properties)
)

(instance iconSort of ControlIcon
	(properties
		view 590
		loop 1
		cel 0
		nsLeft 13
		nsTop 10
		signal 387
		highlightColor -1
		noun 1
		modNum 590
		helpVerb 4
	)

	(method (init)
		(= loop
			(switch global251
				(0 3)
				(1 1)
				(2 2)
			)
		)
	)

	(method (doit)
		(switch global251
			(0
				(= global251 1)
				(= loop 1)
			)
			(1
				(= global251 2)
				(= loop 2)
			)
			(2
				(= global251 0)
				(= loop 3)
			)
		)
		(= global394 global251)
		(self show:)
	)
)

(instance iconMuggins of ControlIcon
	(properties
		view 590
		loop 4
		cel 0
		nsLeft 13
		nsTop 28
		signal 387
		highlightColor -1
		noun 2
		modNum 590
		helpVerb 4
	)

	(method (init)
		(= loop
			(switch global252
				(0 5)
				(1 4)
			)
		)
	)

	(method (doit)
		(switch global252
			(0
				(= global252 1)
				(= loop 4)
			)
			(1
				(= global252 0)
				(= loop 5)
			)
		)
		(self show:)
	)
)

(instance iconHelp of ControlIcon
	(properties
		view 590
		loop 6
		cel 0
		nsLeft 13
		nsTop 46
		cursor 995
		signal 387
		highlightColor -1
		noun 3
		modNum 590
		helpVerb 4
	)

	(method (doit)
		(super doit: &rest)
	)
)

(instance iconOK of ControlIcon
	(properties
		view 590
		loop 7
		cel 0
		nsLeft 74
		nsTop 46
		signal 387
		highlightColor -1
		noun 4
		modNum 590
		helpVerb 4
	)

	(method (doit &tmp temp0)
		(gGameControls hide: dispose:)
		(proc0_1)
		(= gGameControls local0)
		(if 1
			(gCribbage_opt doit: 3)
		)
	)
)

