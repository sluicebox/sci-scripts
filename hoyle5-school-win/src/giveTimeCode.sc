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
	(EnableCursor)
	((= gGameControls giveTime)
		plane: giveTimeWindow
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
		left 105
		top 62
		right 216
		bottom 137
	)

	(method (init &tmp [temp0 3])
		(= priority 15)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(super init:)
		(proc0_10 911 0 0 0 0 15 self)
		(proc0_10 911 5 0 23 10 16 self)
		(proc0_10 911 5 2 72 11 16 self)
		(proc0_10 911 1 local1 59 11 16 self)
		(proc0_10 911 1 (/ local2 10) 69 11 16 self)
		(proc0_10 911 1 (mod local2 10) 76 11 16 self)
		(proc0_10 911 3 (- local3 1) 2 26 16 self)
		(proc0_10 911 1 (/ local4 10) 37 28 16 self)
		(proc0_10 911 1 (mod local4 10) 45 28 16 self)
		(proc0_10 911 5 1 57 28 16 self)
		(if (< local5 90)
			(proc0_10 911 2 1 63 28 16 self)
		else
			(proc0_10 911 2 0 63 28 16 self)
		)
		(proc0_10 911 1 (/ local5 10) 73 28 16 self)
		(proc0_10 911 1 (mod local5 10) 81 28 16 self)
	)
)

(instance giveTime of HoyleGameControls
	(properties)
)

(instance iconOK of ControlIcon
	(properties
		nsLeft 44
		nsTop 44
		x 44
		y 44
		signal 387
		mainView 911
		mainLoop 4
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gGameControls hide:)
		(= gGameControls local0)
	)
)

