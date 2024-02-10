;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 890)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use GameControls)
(use System)

(public
	optionEuchre 0
)

(local
	local0
	local1
)

(procedure (localproc_0)
	(= local0 gGameControls)
	(= local1 global281)
	(iconSort init:)
	(iconPoints init:)
	(iconStickDealer init:)
	(= global282 24)
	((= gGameControls euchreOptions)
		window: euchreWindow
		helpIconItem: iconHelp
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add:
			(iconSort theObj: iconSort selector: #doit yourself:)
			(iconPoints theObj: iconPoints selector: #doit yourself:)
			(iconStickDealer theObj: iconStickDealer selector: #doit yourself:)
			iconHelp
			(iconOK theObj: iconOK selector: #doit yourself:)
	)
	(gGameControls show:)
	(DisposeScript 890)
)

(instance optionEuchre of Code
	(properties)

	(method (init)
		(localproc_0)
	)
)

(instance euchreWindow of InvisibleWindow
	(properties
		top 63
		left 65
		bottom 156
		right 256
	)

	(method (open &tmp temp0)
		(super open:)
		(DrawCel 890 0 0 0 0 15)
		(Graph grUPDATE_BOX top left (+ bottom 1) (+ right 1) 1)
	)
)

(instance euchreOptions of HoyleGameControls
	(properties)
)

(instance iconSort of ControlIcon
	(properties
		view 890
		loop 1
		cel 0
		nsLeft 11
		nsTop 10
		signal 387
		highlightColor -1
		noun 1
		modNum 890
		helpVerb 4
	)

	(method (init)
		(= cel (if (== global281 3) 0 else 2))
	)

	(method (doit)
		(switch global281
			(3
				(= global281 4)
				(= cel 2)
			)
			(4
				(= global281 3)
				(= cel 0)
			)
		)
		(= global290 (!= local1 global281))
		(= global394 global281)
		(self show:)
	)
)

(instance iconPoints of ControlIcon
	(properties
		view 890
		loop 2
		cel 0
		nsLeft 11
		nsTop 28
		signal 387
		highlightColor -1
		noun 9
		modNum 890
		helpVerb 4
	)

	(method (init)
		(switch global283
			(5
				(= cel 0)
			)
			(7
				(= cel 2)
			)
			(else
				(= cel 4)
			)
		)
	)

	(method (doit)
		(switch global283
			(5
				(= cel 2)
				(= global283 7)
			)
			(7
				(= cel 4)
				(= global283 10)
			)
			(else
				(= cel 0)
				(= global283 5)
			)
		)
		(self show:)
	)
)

(instance iconStickDealer of ControlIcon
	(properties
		view 890
		loop 3
		cel 0
		nsLeft 11
		nsTop 46
		signal 387
		highlightColor -1
		noun 11
		modNum 890
		helpVerb 4
	)

	(method (init)
		(if global288
			(= cel 2)
		else
			(= cel 0)
		)
	)

	(method (doit)
		(switch global288
			(0
				(= cel 2)
				(= global288 1)
			)
			(else
				(= global288 (= cel 0))
			)
		)
		(self show:)
	)
)

(instance iconHelp of ControlIcon
	(properties
		view 890
		loop 4
		cel 0
		nsLeft 11
		nsTop 64
		cursor 995
		signal 387
		highlightColor -1
		noun 7
		modNum 890
		helpVerb 4
	)
)

(instance iconOK of ControlIcon
	(properties
		view 890
		loop 5
		cel 0
		nsLeft 95
		nsTop 64
		signal 387
		highlightColor -1
		noun 8
		modNum 890
		helpVerb 4
	)

	(method (doit &tmp temp0)
		(gGameControls hide: dispose:)
		(RedrawCast)
		(= gGameControls local0)
		(gEuchre_opt doit: 3)
	)
)

