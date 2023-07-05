;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 720)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use Print)
(use GameControls)
(use System)

(public
	rulesBridge 0
)

(local
	local0
	[local1 3]
)

(procedure (localproc_0)
	(= local0 gGameControls)
	((= gGameControls readWhichControls)
		window: readWhcihWindow
		helpIconItem: 0
		okIconItem: iconConventions
		curIcon: (if (not (HaveMouse)) iconConventions else 0)
		add:
			(iconConventions theObj: iconConventions selector: #doit yourself:)
			(iconRules theObj: iconRules selector: #doit yourself:)
	)
	(gGameControls show:)
)

(instance rulesBridge of Code
	(properties)

	(method (init &tmp temp0)
		(localproc_0)
		(if global461
			(for ((= temp0 1)) (<= temp0 10) ((++ temp0))
				(if (not (Print addText: 1 18 0 temp0 0 0 720 init:))
					(break)
				)
			)
		else
			(for ((= temp0 1)) (<= temp0 19) ((++ temp0))
				(if (not (Print addText: 1 79 0 temp0 0 0 720 init:))
					(break)
				)
			)
		)
		(DisposeScript 720)
	)
)

(instance readWhcihWindow of InvisibleWindow
	(properties
		top 63
		left 73
		bottom 136
		right 247
	)

	(method (open)
		(super open:)
		(DrawCel 770 3 0 0 0 15)
		(Graph grUPDATE_BOX top left (+ bottom 1) (+ right 1) 1)
	)
)

(instance readWhichControls of HoyleGameControls
	(properties)
)

(instance iconConventions of ControlIcon
	(properties
		view 770
		loop 4
		cel 0
		nsLeft 15
		nsTop 43
		signal 387
		highlightColor -1
	)

	(method (doit)
		(gGameControls hide: dispose:)
		(= gGameControls local0)
		(= global461 0)
	)
)

(instance iconRules of ControlIcon
	(properties
		view 770
		loop 5
		cel 0
		nsLeft 104
		nsTop 43
		signal 387
		highlightColor -1
	)

	(method (doit)
		(gGameControls hide: dispose:)
		(= gGameControls local0)
		(= global461 1)
	)
)

