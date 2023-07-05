;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 557)
(include sci.sh)
(use Main)
(use n007)
(use GloryWindow)
(use n814)
(use IconBar)
(use GameControls)

(public
	actionBar 0
)

(instance actionBar of GameControls
	(properties)

	(method (init)
		(self
			window: actWin
			add:
				iconNormal
				iconRun
				iconSneak
				iconRest
				iconSheet
				iconTime
				iconOk
				iconActionHelp
			eachElementDo: #init
			eachElementDo: #highlightColor -1
			eachElementDo: #lowlightColor -1
			curIcon: iconSheet
			okButton: iconOk
			helpIconItem: iconActionHelp
			state: 3072
		)
		(if (& global425 $0001)
			(self disable: iconNormal)
		)
		(if (& global425 $0002)
			(self disable: iconRun)
		)
		(if (& global425 $0004)
			(self disable: iconSneak)
		)
		(if (& global425 $0008)
			(self disable: iconRest)
		)
	)

	(method (hide)
		((gTheIconBar at: 1)
			cursor:
				(switch gEgoGait
					(0 940) ; walking
					(1 937) ; running
					(2 947) ; sneaking
				)
		)
		(gGame setCursor: (curIcon cursor:) 1)
		(super hide:)
	)

	(method (show)
		(super show:)
		(self dispose: release:)
		(if (IsFlag 360)
			(gGame setCursor: gTheCursor 0)
			(SetFlag 359)
			((ScriptID 204) doit:) ; theCharSheet
		)
		(DisposeScript 557)
	)
)

(instance iconNormal of IconI
	(properties
		view 994
		loop 0
		cel 0
		nsLeft 10
		nsTop 4
		cursor 940
		message 3
		signal 451
		maskView 994
		maskLoop 9
		noun 9
		modNum 557
		helpVerb 9
	)

	(method (select)
		(if (super select: &rest)
			(actionBar hide:)
			(proc814_32 1)
			(EgoGait 0 1) ; walking
			(return 1)
		else
			(return 0)
		)
	)
)

(instance iconRun of IconI
	(properties
		view 994
		loop 1
		cel 0
		nsLeft 39
		nsTop 4
		cursor 937
		message 3
		signal 451
		maskView 994
		maskLoop 9
		noun 5
		modNum 557
		helpVerb 9
	)

	(method (select)
		(if (super select: &rest)
			(actionBar hide:)
			(proc814_32 1)
			(EgoGait 1 1) ; running
			(return 1)
		)
	)
)

(instance iconSneak of IconI
	(properties
		view 994
		loop 2
		cel 0
		nsLeft 68
		nsTop 4
		cursor 947
		message 3
		signal 451
		maskView 994
		maskLoop 9
		noun 7
		modNum 557
		helpVerb 9
	)

	(method (select)
		(if (super select: &rest)
			(actionBar hide:)
			(proc814_32 1)
			(if (!= gEgoGait 2) ; sneaking
				(if (TrySkill 8 5 0) ; stealth
					(EgoGait 2 1) ; sneaking
				else
					(gMessager say: 1 0 0 1 0 557) ; "You're about as stealthy as the average Goon."
				)
			)
			(return 1)
		)
	)
)

(instance iconRest of IconI
	(properties
		view 994
		loop 3
		cel 0
		nsLeft 97
		nsTop 4
		cursor 943
		message 52
		signal 451
		maskView 994
		maskLoop 9
		noun 4
		modNum 557
		helpVerb 9
	)

	(method (select)
		(if (super select: &rest)
			(actionBar hide:)
			(PromptSleep)
			(return 1)
		)
	)
)

(instance iconSheet of IconI
	(properties
		view 994
		loop 5
		cel 0
		nsLeft 126
		nsTop 4
		cursor 999
		signal 451
		maskView 994
		maskLoop 9
		noun 6
		modNum 557
		helpVerb 9
	)

	(method (select)
		(if (super select: &rest)
			(actionBar hide:)
			(cond
				((not (HaveMem 2000))
					(gMessager say: 1 0 0 2 0 557) ; "Sorry, there's not enough room to see that here."
				)
				((not global102)
					(SetFlag 360)
				)
			)
			(return 1)
		)
	)
)

(instance iconTime of IconI
	(properties
		view 994
		loop 6
		cel 0
		nsLeft 155
		nsTop 4
		cursor 999
		signal 451
		maskView 994
		maskLoop 9
		noun 8
		modNum 557
		helpVerb 9
	)

	(method (select)
		(if (super select: &rest)
			(actionBar hide:)
			(PrintTimeAndDay)
			(return 1)
		)
	)
)

(instance iconOk of IconI
	(properties
		view 994
		loop 4
		cel 0
		nsLeft 184
		nsTop 4
		cursor 999
		signal 451
		maskView 994
		maskLoop 9
		noun 3
		modNum 557
		helpVerb 9
	)

	(method (select)
		(if (super select: &rest)
			(actionBar hide:)
			(return 1)
		)
	)
)

(instance iconActionHelp of IconI
	(properties
		view 994
		loop 8
		cel 0
		nsLeft 213
		nsTop 4
		cursor 949
		message 9
		signal 451
		noun 2
		modNum 557
		helpVerb 9
	)
)

(instance actWin of GloryWindow
	(properties)

	(method (open)
		(self top: 30 left: 37 bottom: 60 right: 280 priority: -1)
		(super open:)
	)
)

