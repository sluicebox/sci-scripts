;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 912)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use GameControls)
(use System)

(public
	useStndrd 0
)

(local
	local0
)

(procedure (localproc_0)
	(= local0 gGameControls)
	(iconUseStandard loop: (- 2 global462))
	((= gGameControls useStandardControls)
		window: useStandardWindow
		helpIconItem: iconHelp
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add:
			(iconUseStandard theObj: iconUseStandard selector: #doit yourself:)
			iconHelp
			(iconOK theObj: iconOK selector: #doit yourself:)
	)
	(gGameControls show:)
	(DisposeScript 912)
)

(instance useStndrd of Code
	(properties)

	(method (init)
		(localproc_0)
	)
)

(instance useStandardWindow of InvisibleWindow
	(properties
		top 72
		left 53
		bottom 127
		right 267
	)

	(method (open)
		(super open:)
		(DrawCel 912 0 0 0 0 15)
		(Graph grUPDATE_BOX top left (+ bottom 1) (+ right 1) 1)
	)
)

(instance useStandardControls of HoyleGameControls
	(properties)
)

(instance iconUseStandard of ControlIcon
	(properties
		view 912
		loop 1
		cel 0
		nsLeft 12
		nsTop 10
		signal 387
		highlightColor -1
		noun 3
		modNum 912
		helpVerb 4
	)

	(method (doit &tmp temp0)
		(= global462 (if global462 0 else 1))
		(= loop (- 2 global462))
		(self show:)
	)
)

(instance iconHelp of ControlIcon
	(properties
		view 912
		loop 3
		cel 0
		nsLeft 12
		nsTop 28
		cursor 995
		signal 387
		highlightColor -1
		noun 2
		modNum 912
		helpVerb 4
	)
)

(instance iconOK of ControlIcon
	(properties
		view 912
		loop 4
		cel 0
		nsLeft 104
		nsTop 28
		signal 387
		highlightColor -1
		noun 1
		modNum 912
		helpVerb 4
	)

	(method (doit &tmp temp0)
		(gGameControls hide: dispose:)
		(gGame_opt doit: 3)
		(proc0_1)
		(= gGameControls local0)
	)
)

