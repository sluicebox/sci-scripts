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
	(iconYes mainView: local1)
	(iconNo mainView: local1)
	((= gGameControls yesNoControls)
		plane: yesNoWindow
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
		(iconYes mainLoop: (if (>= argc 2) 10 else 1))
		(iconNo mainLoop: (if (>= argc 2) 11 else 2))
		(localproc_0)
	)
)

(instance yesNoWindow of InvisibleWindow
	(properties
		left 97
		top 63
		right 223
		bottom 136
	)

	(method (init)
		(= priority 16)
		(= inTop top)
		(= inLeft left)
		(= inBottom bottom)
		(= inRight right)
		(super init:)
		(proc0_10 local1 0 0 0 0 0 self)
		(if (>= local2 0)
			(if (<= local2 2)
				(proc0_10 local1 12 local2 45 9 0 self)
				(proc0_10 local1 (/ local3 100) 0 21 26 0 self)
			else
				(proc0_10 local1 12 3 16 22 0 self)
			)
		)
	)
)

(instance yesNoControls of HoyleGameControls
	(properties)
)

(instance iconYes of ControlIcon
	(properties
		nsLeft 7
		nsTop 40
		x 7
		y 40
		signal 387
		mainLoop 1
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gGameControls hide:)
		(= gGameControls local0)
		(= global748 1)
	)
)

(instance iconNo of ControlIcon
	(properties
		nsLeft 47
		nsTop 40
		x 47
		y 40
		signal 387
		mainLoop 2
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(iconYes doit:)
		(= global748 0)
	)
)

