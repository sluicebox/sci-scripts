;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 290)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use GameControls)
(use System)

(public
	optionOldMaid 0
)

(local
	local0
)

(procedure (localproc_0)
	(= local0 gGameControls)
	((= gGameControls oldMaidOptions)
		window: oldMaidWindow
		helpIconItem: iconHelp
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add:
			(iconRemovePairs
				theObj: iconRemovePairs
				selector: #doit
				init:
				yourself:
			)
			(iconDeck theObj: iconDeck selector: #doit init: yourself:)
			iconHelp
			(iconOK theObj: iconOK selector: #doit yourself:)
	)
	(gGameControls show:)
	(DisposeScript 290)
)

(instance optionOldMaid of Code
	(properties)

	(method (init)
		(localproc_0)
	)
)

(instance oldMaidWindow of InvisibleWindow
	(properties
		top 61
		left 55
		bottom 139
		right 265
	)

	(method (open &tmp temp0)
		(super open:)
		(DrawCel 290 0 0 0 0 15)
		(Graph grUPDATE_BOX top left (+ bottom 1) (+ right 1) 1)
	)

	(method (dispose)
		(super dispose:)
		((ScriptID 200 2) doit:) ; pairCode
	)
)

(instance oldMaidOptions of HoyleGameControls
	(properties)
)

(instance iconRemovePairs of ControlIcon
	(properties
		view 290
		loop 1
		cel 0
		nsLeft 12
		nsTop 13
		signal 387
		highlightColor -1
		noun 1
		modNum 290
		helpVerb 4
	)

	(method (init)
		(= loop
			(switch global226
				(0 1)
				(1 2)
			)
		)
	)

	(method (doit)
		(switch global226
			(0
				(= global226 1)
				(= loop 2)
			)
			(1
				(= global226 0)
				(= loop 1)
			)
		)
		(self show:)
	)
)

(instance iconDeck of ControlIcon
	(properties
		view 290
		loop 3
		cel 0
		nsLeft 12
		nsTop 31
		signal 387
		highlightColor -1
		noun 2
		modNum 290
		helpVerb 4
	)

	(method (init)
		(= loop
			(switch global227
				(0 3)
				(1 4)
			)
		)
	)

	(method (doit)
		(switch global227
			(0
				(= global227 1)
				(= loop 4)
			)
			(1
				(= global227 0)
				(= loop 3)
			)
		)
		(self show:)
	)
)

(instance iconHelp of ControlIcon
	(properties
		view 290
		loop 5
		cel 0
		nsLeft 12
		nsTop 49
		cursor 995
		signal 387
		highlightColor -1
		noun 3
		modNum 290
		helpVerb 4
	)

	(method (doit)
		(super doit: &rest)
	)
)

(instance iconOK of ControlIcon
	(properties
		view 290
		loop 6
		cel 0
		nsLeft 105
		nsTop 49
		signal 387
		highlightColor -1
		noun 4
		modNum 290
		helpVerb 4
	)

	(method (doit &tmp temp0)
		(gGameControls hide: dispose:)
		(RedrawCast)
		(= gGameControls local0)
		(if 1
			(gOldmaid_opt doit: 3)
		)
	)
)

