;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 911)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use GameControls)
(use System)

(public
	giveTimeCode 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(procedure (localproc_0)
	(= local0 gGameControls)
	(HandsOn)
	((= gGameControls giveTime)
		window: giveTimeWindow
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add: (iconOK theObj: iconOK selector: #doit yourself:)
	)
	(gGameControls show:)
)

(instance giveTimeCode of Code
	(properties)

	(method (init param1 param2 param3 param4 param5)
		(= local1 param1)
		(= local2 param2)
		(= local3 param3)
		(= local4 param4)
		(= local5 param5)
		(localproc_0)
	)
)

(instance giveTimeWindow of InvisibleWindow
	(properties
		top 62
		left 105
		bottom 137
		right 216
	)

	(method (open &tmp [temp0 3])
		(super open:)
		(DrawCel 911 0 0 0 0 15)
		(DrawCel 911 5 0 23 10 15)
		(DrawCel 911 5 2 72 11 15)
		(DrawCel 911 1 local1 59 11 15)
		(DrawCel 911 1 (/ local2 10) 69 11 15)
		(DrawCel 911 1 (mod local2 10) 76 11 15)
		(DrawCel 911 3 (- local3 1) 2 26 15)
		(DrawCel 911 1 (/ local4 10) 37 28 15)
		(DrawCel 911 1 (mod local4 10) 45 28 15)
		(DrawCel 911 5 1 57 28 15)
		(if (< local5 90)
			(DrawCel 911 2 1 63 28 15)
		else
			(DrawCel 911 2 0 63 28 15)
		)
		(DrawCel 911 1 (/ local5 10) 73 28 15)
		(DrawCel 911 1 (mod local5 10) 81 28 15)
		(Graph grUPDATE_BOX top left (+ bottom 1) (+ right 1) 1)
	)
)

(instance giveTime of HoyleGameControls
	(properties)
)

(instance iconOK of ControlIcon
	(properties
		view 911
		loop 4
		cel 0
		nsLeft 44
		nsTop 44
		signal 387
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gGameControls hide: dispose:)
		(= gGameControls local0)
	)
)

