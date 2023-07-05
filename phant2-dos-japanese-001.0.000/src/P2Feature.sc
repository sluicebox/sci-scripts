;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 63011)
(include sci.sh)
(use Main)
(use n63002)
(use Rectangle)
(use Feature)
(use System)

(class P2Feature of Feature
	(properties
		scene 0
		sceneScored 0
		fadeToVol -1
		readyFlag 0
		doneFlag 0
		invItem -1
		whoDoit 0
		nextRoom 0
		exitDir -1
		fullLVDM 0
		verbArray 0
		v2 0
		v3 0
	)

	(method (init)
		(if
			(and
				(or (not readyFlag) (IsFlag readyFlag))
				(or (not doneFlag) (not (IsFlag doneFlag)))
			)
			(super init: gThePlane (if (!= priority -1) priority else 1) &rest)
			(self isHot: 1)
			(= verbArray (= v2 (= v3 0)))
			(self addVerb: 4)
			(return self)
		else
			(return 0)
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(= temp2 0)
		(if
			(and
				(not (event claimed:))
				(or (!= exitDir -1) (self seesVerb: gVerb))
				(& (event type:) evMOUSEBUTTON)
				(not (and doneFlag (IsFlag doneFlag)))
			)
			(event claimed: self)
			(gGame handsOff:)
			(if (!= -1 fadeToVol)
				(= temp1 (Min 100 fadeToVol))
				(if (gRoboGary isPlaying:)
					(= temp0 (gRoboGary myVol:))
					(gRoboGary fadeTo: temp1)
				else
					(= temp0 (gP2SongPlyr volPercent:))
					(gP2SongPlyr fadeTo: temp1 9 10)
				)
			)
			(if fullLVDM
				(= global243 1)
			)
			(if (!= invItem -1)
				(gEgo get: invItem)
			)
			(if doneFlag
				(SetFlag doneFlag)
				(= temp2 1)
			)
			(if scene
				(if sceneScored
					(= global211 1)
				)
				(proc63002_7 scene)
			)
			(if whoDoit
				(whoDoit doit:)
			)
			(if nextRoom
				(gCurRoom newRoom: nextRoom)
			)
			(= gVerb 4) ; Do
			(if (!= -1 fadeToVol)
				(if (gRoboGary isPlaying:)
					(gRoboGary fadeTo: temp0)
				else
					(gP2SongPlyr fadeTo: temp0 6 10)
				)
			)
			(if temp2
				(SetFlag doneFlag)
				(self dispose:)
			)
			(gGame handsOn:)
		)
		(event claimed:)
	)

	(method (seesVerb param1 &tmp temp0)
		(switch (/ (= temp0 ((ScriptID 0 4) lookup: param1)) 16) ; cursorLoopTable
			(0
				(return (& verbArray (>> $8000 (mod temp0 16))))
			)
			(1
				(return (& v2 (>> $8000 (mod temp0 16))))
			)
			(2
				(return (& v3 (>> $8000 (mod temp0 16))))
			)
		)
	)

	(method (addVerb param1 &tmp temp0 temp1)
		(for ((= temp1 0)) (< temp1 argc) ((++ temp1))
			(switch (/ (= temp0 ((ScriptID 0 4) lookup: [param1 temp1])) 16) ; cursorLoopTable
				(0
					(|= verbArray (>> $8000 (mod temp0 16)))
				)
				(1
					(|= v2 (>> $8000 (mod temp0 16)))
				)
				(2
					(|= v3 (>> $8000 (mod temp0 16)))
				)
			)
		)
	)

	(method (delVerb param1 &tmp temp0 temp1)
		(for ((= temp1 0)) (< temp1 argc) ((++ temp1))
			(switch (/ (= temp0 ((ScriptID 0 4) lookup: [param1 temp1])) 16) ; cursorLoopTable
				(0
					(&= verbArray (~ (>> $8000 (mod temp0 16))))
				)
				(1
					(&= v2 (~ (>> $8000 (mod temp0 16))))
				)
				(2
					(&= v3 (~ (>> $8000 (mod temp0 16))))
				)
			)
		)
	)

	(method (addTarget param1 param2)
		(if (not (and (> argc 1) param2))
			(if (and target (target isMemberOf: Rectangle))
				(target dispose:)
			)
			(= target 0)
		)
		(super addTarget: param1)
	)

	(method (isHot param1 param2)
		(super isHot: param1)
		(if (and plane (plane cast:) ((plane cast:) respondsTo: #eventList))
			(if (or (and param1 (< argc 2)) (and (> argc 1) param2))
				(((plane cast:) eventList:) add: self)
			else
				(((plane cast:) eventList:) delete: self)
			)
		)
	)
)

