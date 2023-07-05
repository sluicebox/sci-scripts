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
	(properties)

	(method (init &tmp [temp0 3])
		(= top (/ (- gScreenHeight 180) 2))
		(= left (/ (- gScreenWidth 222) 2))
		(= bottom (+ (/ (- gScreenHeight 180) 2) 180))
		(= right (+ (/ (- gScreenWidth 222) 2) 222))
		(= priority 15)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(super init:)
		(proc0_10 911 0 0 0 0 15 self)
		(proc0_10 911 5 0 24 39 16 self)
		(proc0_10 911 5 2 145 39 16 self)
		(proc0_10 911 1 local1 120 39 16 self)
		(proc0_10 911 1 (/ local2 10) 139 39 16 self)
		(proc0_10 911 1 (mod local2 10) 152 39 16 self)
		(if
			(or
				(== local3 1)
				(== local3 2)
				(== local3 3)
				(== local3 5)
				(== local3 8)
				(== local3 10)
				(== local3 11)
				(== local3 12)
			)
			(proc0_10 911 3 (- local3 1) 0 84 16 self)
		else
			(proc0_10 911 3 (- local3 1) 24 84 16 self)
		)
		(proc0_10 911 1 (/ local4 10) 95 84 16 self)
		(proc0_10 911 1 (mod local4 10) 108 84 16 self)
		(proc0_10 911 5 1 134 84 16 self)
		(if (< local5 90)
			(proc0_10 911 2 1 147 84 16 self)
		else
			(proc0_10 911 2 0 147 84 16 self)
		)
		(proc0_10 911 1 (/ local5 10) 160 84 16 self)
		(proc0_10 911 1 (mod local5 10) 173 84 16 self)
	)
)

(instance giveTime of HoyleGameControls
	(properties)
)

(instance iconOK of ControlIcon
	(properties
		nsLeft 136
		nsTop 138
		x 136
		y 138
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

