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
	(iconSort init:)
	(iconSuitOrder init:)
	(iconLead init:)
	(iconPassing init:)
	((= gGameControls heartsOptions)
		window: heartsWindow
		helpIconItem: iconHelp
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add:
			(iconSort theObj: iconSort selector: #doit init: yourself:)
			(iconSuitOrder
				theObj: iconSuitOrder
				selector: #doit
				init:
				yourself:
			)
			(iconLead theObj: iconLead selector: #doit init: yourself:)
			(iconPassing theObj: iconPassing selector: #doit init: yourself:)
			(iconQueenHeart
				theObj: iconQueenHeart
				selector: #doit
				init:
				yourself:
			)
			(iconBreak1st theObj: iconBreak1st selector: #doit init: yourself:)
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
		top 27
		left 86
		bottom 172
		right 233
	)

	(method (open &tmp temp0)
		(super open:)
		(DrawCel 390 0 0 0 0 15)
		(Graph grUPDATE_BOX top left (+ bottom 1) (+ right 1) 1)
	)
)

(instance heartsOptions of HoyleGameControls
	(properties)
)

(instance iconSort of ControlIcon
	(properties
		view 390
		loop 1
		cel 0
		nsLeft 13
		nsTop 10
		signal 387
		highlightColor -1
		noun 1
		modNum 390
		helpVerb 4
	)

	(method (init)
		(= loop
			(if (== global231 4)
				2
			else
				(= global231 3)
				1
			)
		)
	)

	(method (doit)
		(switch global231
			(3
				(= global231 4)
				(= loop 2)
			)
			(4
				(= global231 3)
				(= loop 1)
			)
		)
		(= global290 (!= local1 global231))
		(= global394 global231)
		(self show:)
	)
)

(instance iconSuitOrder of ControlIcon
	(properties
		view 390
		loop 3
		cel 0
		nsLeft 13
		nsTop 28
		signal 387
		highlightColor -1
		noun 2
		modNum 390
		helpVerb 4
	)

	(method (init)
		(= loop
			(switch global232
				(0 3)
				(1 4)
			)
		)
	)

	(method (doit)
		(switch global232
			(0
				(= global232 1)
				(= loop 4)
				(= [global390 0] 0)
				(= [global390 1] 2)
				(= [global390 2] 1)
				(= [global390 3] 3)
			)
			(1
				(= global232 0)
				(= [global390 0] (= loop 3))
				(= [global390 1] 1)
				(= [global390 2] 2)
				(= [global390 3] 0)
			)
		)
		(= local3 (!= local2 global232))
		(self show:)
	)
)

(instance iconLead of ControlIcon
	(properties
		view 390
		loop 9
		cel 0
		nsLeft 13
		nsTop 46
		signal 387
		highlightColor -1
		noun 3
		modNum 390
		helpVerb 4
	)

	(method (init)
		(= loop
			(switch global233
				(0 9)
				(1 10)
			)
		)
	)

	(method (doit)
		(switch global233
			(0
				(= global233 1)
				(= loop 10)
			)
			(1
				(= global233 0)
				(= loop 9)
			)
		)
		(self show:)
	)
)

(instance iconPassing of ControlIcon
	(properties
		view 390
		loop 13
		cel 0
		nsLeft 13
		nsTop 64
		signal 387
		highlightColor -1
		noun 7
		modNum 390
		helpVerb 4
	)

	(method (init)
		(switch global234
			(0
				(= cel 0)
			)
			(1
				(= cel 2)
			)
			(2
				(= cel 4)
			)
		)
	)

	(method (doit)
		(switch global234
			(0
				(= global234 1)
				(= cel 2)
			)
			(1
				(= global234 2)
				(= cel 4)
			)
			(2
				(= global234 0)
				(= cel 0)
			)
		)
		(self show:)
	)
)

(instance iconQueenHeart of ControlIcon
	(properties
		view 390
		loop 14
		cel 0
		nsLeft 13
		nsTop 82
		signal 387
		highlightColor -1
		noun 8
		modNum 390
		helpVerb 4
	)

	(method (init)
		(switch global235
			(0
				(= cel 2)
			)
			(1
				(= cel 0)
			)
		)
	)

	(method (doit)
		(switch global235
			(0
				(= global235 1)
				(= cel 0)
			)
			(1
				(= global235 0)
				(= cel 2)
			)
		)
		(self show:)
	)
)

(instance iconBreak1st of ControlIcon
	(properties
		view 390
		loop 15
		cel 0
		nsLeft 13
		nsTop 100
		signal 387
		highlightColor -1
		noun 9
		modNum 390
		helpVerb 4
	)

	(method (init)
		(switch global236
			(0
				(= cel 0)
			)
			(1
				(= cel 2)
			)
		)
	)

	(method (doit)
		(switch global236
			(0
				(= global236 1)
				(= cel 2)
			)
			(1
				(= global236 0)
				(= cel 0)
			)
		)
		(self show:)
	)
)

(instance iconHelp of ControlIcon
	(properties
		view 390
		loop 11
		cel 0
		nsLeft 13
		nsTop 118
		cursor 995
		signal 387
		highlightColor -1
		noun 4
		modNum 390
		helpVerb 4
	)

	(method (doit)
		(super doit: &rest)
	)
)

(instance iconOK of ControlIcon
	(properties
		view 390
		loop 12
		cel 0
		nsLeft 74
		nsTop 118
		signal 387
		highlightColor -1
		noun 6
		modNum 390
		helpVerb 4
	)

	(method (doit &tmp temp0)
		(gGameControls hide: dispose:)
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

