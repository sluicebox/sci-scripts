;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 190)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use GameControls)
(use System)

(public
	optionCrazy8s 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0)
	(= local0 gGameControls)
	(= local1 global221)
	(= local2 global222)
	((= gGameControls crazy8sOptions)
		window: crazy8sWindow
		helpIconItem: iconHelp
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add:
			(iconSort theObj: iconSort selector: #doit init: yourself:)
			(iconEights theObj: iconEights selector: #doit init: yourself:)
			(iconVariant theObj: iconVariant selector: #doit init: yourself:)
			(iconDrawLimit
				theObj: iconDrawLimit
				selector: #doit
				init:
				yourself:
			)
			iconHelp
			(iconOK theObj: iconOK selector: #doit yourself:)
	)
	(gGameControls show:)
	(DisposeScript 190)
)

(instance optionCrazy8s of Code
	(properties)

	(method (init)
		(Load rsVIEW 190)
		(Load rsVIEW 1902)
		(localproc_0)
	)
)

(instance crazy8sWindow of InvisibleWindow
	(properties
		top 45
		left 65
		bottom 154
		right 256
	)

	(method (open &tmp temp0)
		(super open:)
		(DrawCel 190 0 0 0 0 15)
		(Graph grUPDATE_BOX top left (+ bottom 1) (+ right 1) 1)
	)
)

(instance crazy8sOptions of HoyleGameControls
	(properties)
)

(instance iconSort of ControlIcon
	(properties
		view 1902
		loop 0
		cel 0
		nsLeft 12
		nsTop 11
		signal 387
		highlightColor -1
		noun 5
		modNum 190
		helpVerb 4
	)

	(method (init)
		(= loop
			(switch global221
				(1 0)
				(2 1)
				(3 2)
				(4 3)
				(0 4)
			)
		)
	)

	(method (doit)
		(switch global221
			(1
				(= global221 2)
				(= loop 1)
			)
			(2
				(= global221 3)
				(= loop 2)
			)
			(3
				(= global221 4)
				(= loop 3)
			)
			(4
				(= global221 0)
				(= loop 4)
			)
			(0
				(= global221 1)
				(= loop 0)
			)
		)
		(= global290 (and (!= (= global394 global221) 0) (!= local1 global221)))
		(self show:)
	)
)

(instance iconEights of ControlIcon
	(properties
		view 1902
		loop 5
		cel 0
		nsLeft 12
		nsTop 29
		signal 387
		highlightColor -1
		noun 2
		modNum 190
		helpVerb 4
	)

	(method (init)
		(= loop
			(switch global222
				(0 5)
				(1 6)
				(2 7)
			)
		)
	)

	(method (doit)
		(switch global222
			(0
				(= global222 1)
				(= loop 6)
			)
			(1
				(= global222 2)
				(= loop 7)
			)
			(2
				(= global222 0)
				(= loop 5)
			)
		)
		(= global290
			(or
				(and (== local2 0) (== global222 1))
				(and (== local2 1) (== global222 0))
				(and (== local2 2) (!= global222 2))
			)
		)
		(self show:)
	)
)

(instance iconVariant of ControlIcon
	(properties
		view 1902
		loop 8
		cel 0
		nsLeft 12
		nsTop 47
		signal 387
		highlightColor -1
		noun 6
		modNum 190
		helpVerb 4
	)

	(method (init)
		(= loop
			(switch global223
				(0 8)
				(1 9)
			)
		)
	)

	(method (doit)
		(switch global223
			(0
				(= global223 1)
				(= loop 9)
			)
			(1
				(= global223 0)
				(= loop 8)
			)
		)
		(self show:)
	)
)

(instance iconDrawLimit of ControlIcon
	(properties
		view 1902
		loop 10
		cel 0
		nsLeft 12
		nsTop 65
		signal 387
		highlightColor -1
		noun 1
		modNum 190
		helpVerb 4
	)

	(method (init)
		(= loop
			(switch global224
				(0 10)
				(1 11)
				(2 12)
			)
		)
	)

	(method (doit)
		(switch global224
			(0
				(= global224 1)
				(= loop 11)
			)
			(1
				(= global224 2)
				(= loop 12)
			)
			(2
				(= global224 0)
				(= loop 10)
			)
		)
		(self show:)
	)
)

(instance iconHelp of ControlIcon
	(properties
		view 1902
		loop 13
		cel 0
		nsLeft 12
		nsTop 83
		cursor 995
		signal 387
		highlightColor -1
		noun 3
		modNum 190
		helpVerb 4
	)

	(method (doit)
		(super doit: &rest)
	)
)

(instance iconOK of ControlIcon
	(properties
		view 1902
		loop 14
		cel 0
		nsLeft 96
		nsTop 83
		signal 387
		highlightColor -1
		noun 4
		modNum 190
		helpVerb 4
	)

	(method (doit &tmp temp0)
		(gGameControls hide: dispose:)
		(if global290
			(HandsOff)
		)
		(RedrawCast)
		(= gGameControls local0)
		(gCrazy8s_opt doit: 3)
	)
)

