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
		window: ginRummyWindow
		helpIconItem: iconHelp
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add:
			(iconSort theObj: iconSort selector: #doit init: yourself:)
			(iconVariant theObj: iconVariant selector: #doit init: yourself:)
			iconHelp
			(iconOK theObj: iconOK selector: #doit yourself:)
	)
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
		top 62
		left 77
		bottom 138
		right 242
	)

	(method (open &tmp temp0)
		(super open:)
		(DrawCel 490 0 0 0 0 15)
		(Graph grUPDATE_BOX top left (+ bottom 1) (+ right 1) 1)
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
		view 490
		loop 5
		cel 0
		nsLeft 11
		nsTop 11
		signal 387
		highlightColor -1
		noun 1
		modNum 490
		helpVerb 4
	)

	(method (init)
		(= loop
			(switch global241
				(1 5)
				(2 6)
				(3 3)
				(4 4)
			)
		)
	)

	(method (doit)
		(switch global241
			(1
				(= global241 2)
				(= loop 6)
			)
			(2
				(= global241 3)
				(= loop 3)
			)
			(3
				(= global241 4)
				(= loop 4)
			)
			(4
				(= global241 1)
				(= loop 5)
			)
		)
		(= global290 (!= local1 global241))
		(= global394 global241)
		(self show:)
	)
)

(instance iconVariant of ControlIcon
	(properties
		view 490
		loop 1
		cel 0
		nsLeft 11
		nsTop 29
		signal 387
		highlightColor -1
		noun 2
		modNum 490
		helpVerb 4
	)

	(method (init)
		(= loop
			(switch global242
				(0 1)
				(1 2)
			)
		)
	)

	(method (doit)
		(switch global242
			(0
				(= global242 1)
				(= loop 2)
			)
			(1
				(= global242 0)
				(= loop 1)
			)
		)
		(self show:)
	)
)

(instance iconHelp of ControlIcon
	(properties
		view 490
		loop 9
		cel 0
		nsLeft 11
		nsTop 47
		cursor 995
		signal 387
		highlightColor -1
		noun 3
		modNum 490
		helpVerb 4
	)

	(method (doit)
		(super doit: &rest)
	)
)

(instance iconOK of ControlIcon
	(properties
		view 490
		loop 10
		cel 0
		nsLeft 83
		nsTop 47
		signal 387
		highlightColor -1
		noun 4
		modNum 490
		helpVerb 4
	)

	(method (doit &tmp temp0)
		(gGameControls hide: dispose:)
		(RedrawCast)
		(= gGameControls local0)
		(gGinrummy_opt doit: 3)
	)
)

