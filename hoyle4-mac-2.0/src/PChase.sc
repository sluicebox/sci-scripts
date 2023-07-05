;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 930)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use GameControls)
(use System)

(public
	yesNo 0
)

(local
	local0
	local1
	local2
	local3
)

(procedure (localproc_0)
	(= local0 gGameControls)
	(iconYes view: local1)
	(iconNo view: local1)
	((= gGameControls yesNoControls)
		window: yesNoWindow
		helpIconItem: 0
		okIconItem: iconNo
		curIcon: (if (not (HaveMouse)) iconYes else 0)
		add:
			(iconYes theObj: iconYes selector: #doit yourself:)
			(iconNo theObj: iconNo selector: #doit yourself:)
	)
	(gGameControls show:)
)

(instance yesNo of Code
	(properties)

	(method (init param1 param2 param3)
		(= local1 param1)
		(= local2 (if (>= argc 2) param2 else -1))
		(= local3 (if (>= argc 2) param3 else -1))
		(iconYes loop: (if (>= argc 2) 10 else 1))
		(iconNo loop: (if (>= argc 2) 11 else 2))
		(localproc_0)
	)
)

(instance yesNoWindow of InvisibleWindow
	(properties
		top 63
		left 97
		bottom 136
		right 223
	)

	(method (open)
		(super open:)
		(DrawCel local1 0 0 0 0 15)
		(if (>= local2 0)
			(if (<= local2 2)
				(DrawCel local1 12 local2 45 9 15)
				(DrawCel local1 (/ local3 100) 0 21 26 15)
			else
				(DrawCel local1 12 3 16 22 15)
			)
		)
		(Graph grUPDATE_BOX top left (+ bottom 1) (+ right 1) 1)
	)
)

(instance yesNoControls of HoyleGameControls
	(properties)
)

(instance iconYes of ControlIcon
	(properties
		loop 1
		cel 0
		nsLeft 15
		nsTop 43
		signal 387
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gGameControls hide: dispose:)
		(= gGameControls local0)
		(Memory 7)
		(= global461 1)
	)
)

(instance iconNo of ControlIcon
	(properties
		loop 2
		cel 0
		nsLeft 62
		nsTop 43
		signal 387
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(iconYes doit:)
		(= global461 0)
	)
)

