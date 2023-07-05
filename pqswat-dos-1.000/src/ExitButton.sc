;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4)
(include sci.sh)
(use Main)
(use Button)
(use Plane)
(use WalkieTalkie)
(use Actor)
(use System)

(public
	proc4_0 0
	proc4_2 2
	proc4_3 3
	proc4_4 4
	proc4_5 5
	proc4_6 6
	proc4_7 7
	proc4_8 8
	proc4_9 9
	proc4_10 10
	proc4_11 11
	proc4_12 12
	proc4_13 13
	proc4_14 14
	proc4_15 15
)

(local
	local0
	local1
	local2
)

(procedure (proc4_0 param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3) ; UNUSED
	(= temp3 0)
	(if (not (> argc 3))
		(= temp1 (param2 x:))
		(= temp2 (param2 y:))
		(if (== argc 3)
			(= temp3 param3)
		)
	else
		(= temp1 param2)
		(= temp2 param3)
		(if (== argc 4)
			(= temp3 param4)
		)
	)
	(= temp0 (GetAngle (param1 x:) (param1 y:) temp1 temp2))
	(param1 setHeading: temp0 temp3)
)

(procedure (proc4_2 param1 param2 param3 &tmp temp0 temp1 temp2) ; UNUSED
	(switch argc
		(0
			(if (gCurRoom inset:)
				(= temp1 30)
				(= temp2 24)
			)
		)
		(1
			(= temp1 30)
			(= temp2 24)
		)
		(2
			(= temp1 param2)
			(= temp2 24)
		)
		(3
			(= temp1 param2)
			(= temp2 param3)
		)
	)
	(= temp0 (ExitButton new:))
	(temp0
		view: 984
		loop: 0
		cel: 0
		posn: temp1 temp2
		roomNum: param1
		disposeNow: 0
		code: 0
		init:
	)
)

(procedure (proc4_3 &tmp [temp0 2])) ; UNUSED

(procedure (proc4_4 &tmp temp0 temp1 temp2)
	(= temp0 (= temp1 (= local1 0)))
	(= temp0 gCast)
	((= temp1 (Plane new:))
		setRect: 0 0 (gThePlane right:) (gThePlane bottom:)
		back: 0
		picture: -2
		priority: 1000
		init:
		addCast: (= gCast (Cast new:))
	)
	(quitView init:)
	(quitYes init:)
	(quitNo init:)
	(temp1 setSize: posn: -1 -1)
	(FrameOut)
	(= local1 (gGame setCursor:))
	(gNormalCursor view: 999 loop: 0)
	(gGame setCursor: gNormalCursor 1)
	(while ((= temp2 (Event new:)) type:)
		(temp2 dispose:)
	)
	(temp2 dispose:)
	(while (== gQuit 2)
		(if ((= temp2 (Event new: 3)) type:)
			(gCast eachElementDo: #handleEvent temp2)
		)
		(temp2 dispose:)
	)
	(gCast dispose:)
	(= gCast temp0)
	(gGame setCursor: local1 1)
	(temp1 dispose:)
)

(procedure (proc4_5 param1 param2 &tmp temp0 temp1 temp2)
	(if global128
		(= global128 0)
		(if (and argc param1)
			(= temp1 param1)
		else
			(= temp1 0)
		)
		(if (> argc 1)
			(= temp2 param2)
			(WalkieTalkie killRobot: temp1 temp2)
		else
			(WalkieTalkie killRobot: temp1)
		)
	)
)

(procedure (proc4_6 param1 param2 param3 param4 param5 param6 param7 &tmp temp0 temp1 temp2)
	(if (> argc 1)
		(= temp1 param2)
	else
		(= temp1 0)
	)
	(if (> argc 2)
		(= temp2 param3)
	else
		(= temp2 0)
	)
	(WalkieTalkie
		doRobot:
			param1
			temp1
			temp2
			(if (> argc 3) param4 else 0)
			(if (not (> argc 7)) self else 0)
			(if (> argc 4) param5 else 0)
			(if (> argc 5) param6 else -1)
			(if (> argc 6) param7 else 0)
	)
	(= global128 param1)
)

(procedure (proc4_7 param1 param2 param3)
	(param1 at: param2 param3)
	(param1 at: (+ param2 1) (>> param3 $0008))
)

(procedure (proc4_8 param1 param2)
	(return
		(+ (& (param1 at: param2) $00ff) (<< (param1 at: (+ param2 1)) $0008))
	)
)

(procedure (proc4_9 &tmp temp0 temp1 temp2)
	(= temp0 (= temp1 (= local1 0)))
	(= temp0 gCast)
	((= temp1 (Plane new:))
		setRect: 0 0 (gThePlane right:) (gThePlane bottom:)
		back: 0
		picture: -2
		priority: 1000
		init:
		addCast: (= gCast (Cast new:))
	)
	(saveView init:)
	(saveYes init:)
	(saveNo init:)
	(temp1 setSize: posn: -1 -1)
	(FrameOut)
	(= local1 (gGame setCursor:))
	(gNormalCursor view: 999 loop: 0)
	(gGame setCursor: gNormalCursor 1)
	(while ((= temp2 (Event new:)) type:)
		(temp2 dispose:)
	)
	(temp2 dispose:)
	(= local2 0)
	(while (not local2)
		(if ((= temp2 (Event new: 3)) type:)
			(gCast eachElementDo: #handleEvent temp2)
		)
		(temp2 dispose:)
	)
	(gCast dispose:)
	(= gCast temp0)
	(gSwatInterface setCursor:)
	(temp1 dispose:)
	(return local2)
)

(procedure (proc4_10 &tmp temp0 temp1 temp2)
	(= temp0 (= temp1 (= local1 0)))
	(= temp0 gCast)
	((= temp1 (Plane new:))
		setRect: 0 0 (gThePlane right:) (gThePlane bottom:)
		back: 0
		picture: -2
		priority: 1000
		init:
		addCast: (= gCast (Cast new:))
	)
	(replayView init:)
	(replayYes init:)
	(replayRestore init:)
	(if argc
		(replayMap init:)
	else
		(replayMetro init:)
	)
	(temp1 setSize: posn: -1 -1)
	(FrameOut)
	(gGame handsOn:)
	(while ((= temp2 (Event new:)) type:)
		(temp2 dispose:)
	)
	(temp2 dispose:)
	(= local2 0)
	(while (not local2)
		(if ((= temp2 (Event new: 3)) type:)
			(gCast eachElementDo: #handleEvent temp2)
		)
		(temp2 dispose:)
	)
	(gCast dispose:)
	(= gCast temp0)
	(gGame handsOff:)
	(temp1 dispose:)
	(return local2)
)

(procedure (proc4_11 param1)
	(return (& [global140 (/ param1 16)] (>> $8000 (mod param1 16))))
)

(procedure (proc4_12 param1)
	(= [global140 (/ param1 16)]
		(| [global140 (/ param1 16)] (>> $8000 (mod param1 16)))
	)
)

(procedure (proc4_13 param1)
	(= [global140 (/ param1 16)]
		(& [global140 (/ param1 16)] (~ (>> $8000 (mod param1 16))))
	)
)

(procedure (proc4_14 param1 param2) ; UNUSED
	(return (/ (* param2 param1 100) 100))
)

(procedure (proc4_15 &tmp temp0 temp1 temp2 temp3)
	(if gAutoRobot
		(= temp2 (Robot 11)) ; FrameNum
		(= temp3 (gAutoRobot robot:))
		(= temp0 (gAutoRobot x:))
		(= temp1 (gAutoRobot y:))
		(proc4_5)
		(WalkieTalkie showFrame: temp3 (+ temp2 1) temp0 temp1)
		(= global128 temp3)
		(return temp2)
	)
)

(instance doUpdateCode of Code ; UNUSED
	(properties)

	(method (doit param1)
		(if (not (& (param1 signal:) $0008))
			(UpdateScreenItem param1)
		)
	)
)

(class ExitButton of View
	(properties
		x 30
		y 24
		view 989
		disposeNow 0
		roomNum 0
		code 0
	)

	(method (init)
		(super init: &rest)
		(gMouseDownHandler addToFront: self)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if
			(or
				(not (self onMe: event))
				(not (event type:))
				(not (gUser input:))
			)
			(super handleEvent: event)
			(return)
		)
		(= temp1 0)
		(while 1
			(= temp0 ((gUser curEvent:) new:))
			(temp0 localize: gThePlane)
			(cond
				((== (temp0 type:) 2)
					(break)
				)
				((self onMe: temp0)
					(= temp1 (= cel 1))
					(UpdateScreenItem self)
				)
				(else
					(= temp1 (= cel 0))
					(UpdateScreenItem self)
				)
			)
			(FrameOut)
			(temp0 dispose:)
		)
		(temp0 dispose:)
		(= cel 0)
		(UpdateScreenItem self)
		(FrameOut)
		(if temp1
			(event claimed: 1)
			(self doVerb:)
		else
			(super handleEvent: event)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if (and disposeNow (gCurRoom inset:))
			(gCurRoom newRoom: roomNum)
		)
	)

	(method (doVerb)
		(if code
			(code doit:)
		else
			(= disposeNow 1)
		)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)
)

(instance quitView of View
	(properties
		priority 150
		fixPriority 1
		view 151
	)

	(method (init &tmp temp0 temp1)
		(= temp0 (CelWide view loop cel))
		(= temp1 (CelHigh view loop cel))
		(= x (/ (- (- (gThePlane right:) (gThePlane left:)) temp0) 2))
		(= y (/ (- (- (gThePlane bottom:) (gThePlane top:)) temp1) 2))
		(super init: &rest)
	)

	(method (onMe)
		(return 0)
	)
)

(instance quitYes of Button
	(properties
		priority 151
		fixPriority 1
		view 151
		loop 2
	)

	(method (init)
		(= x (+ (quitView x:) 16))
		(= y (+ (quitView y:) 84))
		(super init: &rest)
	)

	(method (doVerb)
		(if (gGame quitCode:)
			(= gQuit 0)
			((gGame quitCode:) doit:)
		else
			(= gQuit 1)
		)
	)
)

(instance quitNo of Button
	(properties
		priority 151
		fixPriority 1
		view 151
		loop 1
		upCel 2
		downCel 3
	)

	(method (init)
		(= x (+ (quitView x:) 166))
		(= y (+ (quitView y:) 84))
		(super init: &rest)
	)

	(method (doVerb)
		(= gQuit 0)
	)
)

(instance saveView of View
	(properties
		priority 150
		fixPriority 1
		view 152
	)

	(method (init &tmp temp0 temp1)
		(= temp0 (CelWide view loop cel))
		(= temp1 (CelHigh view loop cel))
		(= x (/ (- (- (gThePlane right:) (gThePlane left:)) temp0) 2))
		(= y (/ (- (- (gThePlane bottom:) (gThePlane top:)) temp1) 2))
		(super init: &rest)
	)

	(method (onMe)
		(return 0)
	)
)

(instance saveYes of Button
	(properties
		priority 151
		fixPriority 1
		view 152
		loop 1
		keyMessage 110
	)

	(method (init)
		(= x (+ (saveView x:) 14))
		(= y (+ (saveView y:) 83))
		(super init: &rest)
	)

	(method (doVerb)
		(= local2 1)
	)
)

(instance saveNo of Button
	(properties
		priority 151
		fixPriority 1
		view 152
		loop 1
		upCel 2
		downCel 3
		keyMessage 110
	)

	(method (init)
		(= x (+ (saveView x:) 165))
		(= y (+ (saveView y:) 83))
		(super init: &rest)
	)

	(method (doVerb)
		(= local2 2)
	)
)

(instance replayView of View
	(properties
		priority 150
		fixPriority 1
		view 155
	)

	(method (init &tmp temp0 temp1)
		(= temp0 (CelWide view loop cel))
		(= temp1 (CelHigh view loop cel))
		(= x (/ (- (- (gThePlane right:) (gThePlane left:)) temp0) 2))
		(= y (/ (- (- (gThePlane bottom:) (gThePlane top:)) temp1) 2))
		(super init: &rest)
	)

	(method (onMe)
		(return 0)
	)
)

(instance replayYes of Button
	(properties
		priority 151
		fixPriority 1
		view 155
		loop 1
		keyMessage 110
	)

	(method (init)
		(= x (+ (replayView x:) 14))
		(= y (+ (replayView y:) 80))
		(super init: &rest)
	)

	(method (doVerb)
		(= local2 1)
	)
)

(instance replayRestore of Button
	(properties
		priority 151
		fixPriority 1
		view 155
		loop 1
		upCel 2
		downCel 3
	)

	(method (init)
		(= x (+ (replayView x:) 112))
		(= y (+ (replayView y:) 80))
		(super init: &rest)
	)

	(method (doVerb)
		(= local2 2)
	)
)

(instance replayMetro of Button
	(properties
		priority 151
		fixPriority 1
		view 155
		loop 1
		upCel 4
		downCel 5
	)

	(method (init)
		(= x (+ (replayView x:) 210))
		(= y (+ (replayView y:) 80))
		(super init: &rest)
	)

	(method (doVerb)
		(= local2 3)
	)
)

(instance replayMap of Button
	(properties
		priority 151
		fixPriority 1
		view 155
		loop 1
		upCel 6
		downCel 7
	)

	(method (init)
		(= x (+ (replayView x:) 210))
		(= y (+ (replayView y:) 80))
		(super init: &rest)
	)

	(method (doVerb)
		(= local2 4)
	)
)

