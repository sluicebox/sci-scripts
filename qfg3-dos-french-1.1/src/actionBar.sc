;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20)
(include sci.sh)
(use Main)
(use GloryWindow)
(use IconBar)
(use GameControls)

(public
	actionBar 0
)

(local
	local0
)

(instance actionBar of GameControls
	(properties)

	(method (init)
		(self add: iconRun iconSneak iconRest)
		(if (& global399 $0001)
			(iconRun signal: (| (iconRun signal:) $0004))
		)
		(if (& global399 $0002)
			(iconSneak signal: (| (iconSneak signal:) $0004))
		)
		(if (& global399 $0004)
			(iconRest signal: (| (iconRest signal:) $0004))
		)
		(self
			window: actWin
			add: iconSheet iconTime iconActionHelp iconEdge
			eachElementDo: #init
			eachElementDo: #highlightColor -1
			eachElementDo: #lowlightColor -1
			curIcon: iconSheet
			helpIconItem: iconActionHelp
			state: 3072
		)
	)

	(method (hide)
		(super hide:)
		(proc0_10)
	)

	(method (show)
		(super show:)
		(self dispose: release:)
		(if local0
			((ScriptID 15) doit:) ; charSheet
		)
		(DisposeScript 20)
	)
)

(instance iconRun of IconI
	(properties
		view 931
		loop 0
		cel 0
		nsLeft 7
		nsTop 4
		cursor 940
		message 3
		signal 451
		maskView 931
		maskLoop 14
		noun 1
		modNum 20
		helpVerb 9
	)

	(method (select)
		(if (super select: &rest)
			(actionBar hide:)
			(gTheIconBar curIcon: (gTheIconBar at: 1))
			(gEgo changeGait: 1 1) ; running
			(return 1)
		else
			(return 0)
		)
	)
)

(instance iconSneak of IconI
	(properties
		view 931
		loop 1
		cel 0
		nsLeft 36
		nsTop 4
		cursor 941
		message 3
		signal 451
		maskView 931
		maskLoop 14
		noun 2
		modNum 20
		helpVerb 9
	)

	(method (select)
		(if (super select: &rest)
			(actionBar hide:)
			(gTheIconBar curIcon: (gTheIconBar at: 1))
			(if (!= gEgoGait 2) ; sneaking
				(if (gEgo trySkill: 8 5 0) ; sneak
					(gEgo changeGait: 2 1) ; sneaking
				else
					(gMessager say: 7 6 1 0 0 20) ; "You're still about as stealthy as the average Goon."
				)
			)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance iconRest of IconI
	(properties
		view 931
		loop 3
		cel 0
		nsLeft 65
		nsTop 4
		cursor 943
		message 74
		signal 451
		maskView 931
		maskLoop 14
		noun 3
		modNum 20
		helpVerb 9
	)

	(method (select)
		(if (super select: &rest)
			(actionBar hide:)
			((ScriptID 7 2) init:) ; doSleep
			(return 1)
		else
			(return 0)
		)
	)
)

(instance iconSheet of IconI
	(properties
		view 931
		loop 5
		cel 0
		nsLeft 94
		nsTop 4
		cursor 999
		signal 451
		maskView 931
		maskLoop 14
		noun 4
		modNum 20
		helpVerb 9
	)

	(method (select)
		(if (super select: &rest)
			(actionBar hide:)
			(cond
				((not (HaveMem 2100))
					(gMessager say: 7 6 2 0 0 20) ; "Sorry, there's not enough room to see that here."
				)
				((not global208)
					(= local0 1)
				)
			)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance iconTime of IconI
	(properties
		view 931
		loop 6
		cel 0
		nsLeft 123
		nsTop 4
		cursor 999
		signal 451
		maskView 931
		maskLoop 14
		noun 5
		modNum 20
		helpVerb 9
	)

	(method (select)
		(if (super select: &rest)
			(actionBar hide:)
			((ScriptID 7 3) init:) ; showTime
		)
	)
)

(instance iconActionHelp of IconI
	(properties
		view 931
		loop 8
		cel 0
		nsLeft 152
		nsTop 4
		cursor 949
		message 9
		signal 451
		noun 6
		modNum 20
		helpVerb 9
	)
)

(instance iconEdge of IconI
	(properties
		view 931
		loop 9
		cel 1
		nsLeft 181
		nsTop 4
		signal 451
	)

	(method (select)
		(return 0)
	)
)

(instance actWin of GloryWindow
	(properties)

	(method (open)
		(self top: 30 left: 61 bottom: 67 right: 254 priority: -1)
		(super open:)
	)
)

