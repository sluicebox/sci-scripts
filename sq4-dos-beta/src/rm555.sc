;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 555)
(include sci.sh)
(use Main)
(use SQRoom)
(use ForwardCounter)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm555 0
)

(local
	local0
)

(procedure (localproc_0)
	(Display 555 0 dsRESTOREPIXELS local0)
)

(class mdlScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and local0 (OneOf ((User curEvent:) type:) evMOUSEBUTTON evKEYBOARD))
			(proc0_12 local0)
			(= local0 (= seconds 0))
			(= cycles 1)
		)
	)
)

(instance rm555 of SQRoom
	(properties
		picture 555
	)

	(method (init)
		(super init:)
		(holo init:)
		(self setScript: realyStupidScript)
	)
)

(instance realyStupidScript of mdlScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(holo setCycle: End)
				(= cycles 1)
			)
			(1
				(hair init: setCycle: ForwardCounter 20)
				(= cycles 2)
			)
			(2
				(aSound init: number: 813 loop: 1 play:)
				(= local0
					(proc0_12
						{"** See I told you."}
						67
						5
						20
						28
						global150
						29
						global129
						30
						1
						70
						125
					)
				)
				(= seconds 15)
			)
			(3
				(localproc_0)
				(= cycles 1)
			)
			(4
				(gCurRoom newRoom: 556)
			)
		)
	)
)

(instance hair of Prop
	(properties
		x 176
		y 32
		description {**holo of Rogers future wife.}
		sightAngle 180
		lookStr {**Her golden hair blows in the breeze, and you wonder how you will get so lucky.}
		view 557
		loop 1
		priority 7
		signal 16400
	)
)

(instance holo of Prop
	(properties
		x 167
		y 120
		description {**Holo of your future wife.}
		sightAngle 180
		lookStr {**You gaze at the beautiful woman in the holo and look forward to the day that you finally meet her.}
		view 557
		priority 6
		signal 16400
	)
)

(instance aSound of Sound
	(properties
		number 813
	)
)

