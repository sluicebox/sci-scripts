;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 430)
(include sci.sh)
(use Main)
(use SQRoom)
(use Inset)
(use Talker)
(use Scaler)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm430 0
	Sidney 1
)

(local
	local0
	local1 = -1
	local2 = -1
	local3
	local4
	local5
	local6
	local7
)

(procedure (localproc_0)
	(switch (gEgo loop:)
		(0
			(= local3 (- (gEgo x:) 15))
			(= local4 (- (gEgo y:) 47))
		)
		(1
			(= local3 (+ (gEgo x:) 15))
			(= local4 (- (gEgo y:) 47))
		)
		(2
			(= local3 (gEgo x:))
			(= local4 (- (gEgo y:) 57))
		)
		(3
			(= local3 (gEgo x:))
			(= local4 (- (gEgo y:) 37))
		)
		(4
			(= local3 (- (gEgo x:) 15))
			(= local4 (- (gEgo y:) 57))
		)
		(5
			(= local3 (+ (gEgo x:) 15))
			(= local4 (- (gEgo y:) 57))
		)
		(6
			(= local3 (- (gEgo x:) 15))
			(= local4 (- (gEgo y:) 37))
		)
		(7
			(= local3 (+ (gEgo x:) 15))
			(= local4 (- (gEgo y:) 37))
		)
	)
)

(procedure (localproc_1 param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3)
	(= temp3 0)
	(if param2
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

(instance rm430 of SQRoom
	(properties
		noun 1
		picture 430
	)

	(method (init &tmp temp0 temp1 temp2 temp3)
		(gGame handsOff:)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 196 98 127 99 110 102 89 104 68 105 83 107 166 105 168 115 132 115 81 121 73 116 65 119 42 122 6 126 6 137 316 137 315 130 295 128 271 120 247 108 219 109 218 101 227 100 226 98
					yourself:
				)
		)
		(Load rsVIEW 900)
		(super init: &rest)
		(= temp1 (>> (<< (= temp0 (GetTime 3)) $0007) $000c)) ; SysDate
		(= temp2 (>> (<< temp0 $000b) $000b))
		(if
			(and
				(or
					(and (== temp1 1) (== temp2 3))
					(and (== temp1 2) (== temp2 4))
					(and (== temp1 4) (== temp2 2))
					(and (== temp1 4) (== temp2 11))
					(and (== temp1 4) (== temp2 16))
					(and (== temp1 5) (== temp2 25))
					(and (== temp1 6) (== temp2 9))
					(and (== temp1 6) (== temp2 12))
					(and (== temp1 6) (== temp2 28))
					(and (== temp1 8) (== temp2 1))
					(and (== temp1 10) (== temp2 31))
					(and (== temp1 12) (== temp2 9))
					(and (== temp1 12) (== temp2 29))
				)
				(not (IsFlag 172))
			)
			(= local5 1)
		)
		(switch gPrevRoomNum
			(460
				(self setScript: sEgoGoes)
			)
			(435 ; regCredits
				(self setScript: sEgoStands)
			)
			(else
				(self setScript: sEgoComes)
			)
		)
		(cond
			((not (IsFlag 118)))
			((and (IsFlag 44) (not (gEgo has: 100))) ; Sidney_Arm
				(circuitSid
					view: 435
					loop: 2
					cel: 0
					init:
					ignoreActors: 1
					approachVerbs: 107 108 2 ; Sidney_Arm, Sidney_Eye, Talk
				)
				(arm init: ignoreActors: 1 approachVerbs: 4) ; Do
			)
			((not (gEgo has: 100)) ; Sidney_Arm
				(circuitSid init: ignoreActors: 1 approachVerbs: 107 108 2) ; Sidney_Arm, Sidney_Eye, Talk
			)
			(else
				(circuitSid
					view: 435
					loop: 2
					cel: 0
					init:
					ignoreActors: 1
					approachVerbs: 107 108 2 ; Sidney_Arm, Sidney_Eye, Talk
				)
			)
		)
		(if (gCast contains: circuitSid)
			(if local5
				(deathHead
					init:
					priority: (+ (circuitSid priority:) 1)
					setScaler: Scaler 100 47 69 47
					setCycle: Fwd
					setScript: startFollower
				)
				(SetFlag 172)
			else
				(head init: priority: (+ (circuitSid priority:) 1) code: slave)
			)
		)
		(if (not (gCast contains: circuitSid))
			(cust1 init: ignoreActors: 1 setScript: (generalMotion new:))
			(cust2 init: ignoreActors: 1 setScript: (generalMotion new:))
		)
		(if (not (RandomNumber 0 2))
			(cust3 init: ignoreActors: 1 setScript: (generalMotion new:))
			(cust4 init: ignoreActors: 1 setScript: (generalMotion new:))
		)
		(if (RandomNumber 0 1)
			(elvis init: ignoreActors: 1 setScript: eatNuts)
		else
			(cust5 init: ignoreActors: 1 setScript: (generalMotion new:))
			(cust6 init: ignoreActors: 1 setScript: (generalMotion new:))
		)
		(if (RandomNumber 0 1)
			(starGazers init: ignoreActors: 1 setScript: pointAtStars)
		else
			(cust7 init: ignoreActors: 1 setScript: (generalMotion new:))
		)
		(if (and (<= gHowFast 8) (= local6 (RandomNumber 0 2)))
			(movingSky init: setPri: 1 ignoreActors: 1 setCycle: Fwd)
		)
		(plant init: ignoreActors: 1 setScript: plantWriggles)
		(comPost init: approachVerbs: 4) ; Do
		(replicatorFeature2 init: approachVerbs: 4) ; Do
		(windowR init: approachVerbs: 4) ; Do
		(windowL init: approachVerbs: 4) ; Do
		(pillar1 init: approachVerbs: 4) ; Do
		(pillar2 init: approachVerbs: 4) ; Do
		(pillar3 init: approachVerbs: 4) ; Do
		(pillar4 init: approachVerbs: 4) ; Do
		(viewScreen init: approachVerbs: 4) ; Do
		(table1 init: approachVerbs: 4) ; Do
		(soylent init:)
		(comPad init:)
		(hangyThing init:)
		(hangyThing2 init:)
		(light init:)
		(light2 init:)
		(light3 init:)
		(star init:)
		(seat1 init:)
		(seat2 init:)
		(seat3 init:)
		(seat4 init:)
		(table2 init:)
		(table3 init:)
		(table4 init:)
		(transportTube init:)
		(PalCycle 0 224 226 1 25) ; Start
		(if (!= gPrevRoomNum 460)
			(cond
				((and (== (Platform) 2) (>= gHowFast 8))
					(= temp3 0)
				)
				((RandomNumber 0 1)
					(= temp3 102)
				)
				(else
					(= temp3 120)
				)
			)
			(if temp3
				(gGSound1 number: temp3 setLoop: -1 play: setVol: 127)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 460)
			(if (gGSound1 handle:)
				(gGSound1 client: 0 fade: 0 10 10 1)
			)
			(gGSound2 client: 0 fade: 0 10 10 1)
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(PalCycle 4) ; Off
		(gEgo setScale: 0)
		(super dispose: &rest)
	)
)

(instance sEgoComes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(gGSound2 number: 941 setLoop: 0 play: setVol: 127)
				(gEgo
					view: 364
					setLoop: 0
					setCel: 0
					init:
					posn: 50 127
					setSpeed: 9
					setCycle: End self
				)
			)
			(2
				(gEgo normalize: setScaler: Scaler 100 47 114 94 setLoop: 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEgoGoes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					normalize:
					setLoop: 3
					setScaler: Scaler 100 47 114 94
					init:
				)
				(= cycles 1)
			)
			(1
				(if (or (== gComPostNextRoomNum gCurRoomNum) (== gComPostNextRoomNum 0))
					(gGame handsOn:)
					(self dispose:)
				else
					(gEgo setHeading: 180)
					(= seconds 2)
				)
			)
			(2
				(gGSound2 number: 926 setLoop: 0 play: setVol: 127)
				(gEgo
					view: 3630
					setCel: 0
					setLoop: 0
					init:
					posn: 50 127
					setSpeed: 9
					setCycle: End self
				)
			)
			(3
				(gCurRoom newRoom: gComPostNextRoomNum)
				(self dispose:)
			)
		)
	)
)

(instance sEgoStands of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					posn: 100 104
					init:
					normalize: 7
					setScaler: Scaler 100 47 114 94
				)
				(= cycles 2)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sillyStar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(PalCycle 0 192 205 -1 6) ; Start
				(= ticks 180)
			)
			(1
				(PalCycle 4) ; Off
				(self dispose:)
			)
		)
	)
)

(instance eatNuts of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 120 360))
			)
			(1
				(client setCycle: End self)
			)
			(2
				(= ticks (client cycleSpeed:))
			)
			(3
				(client cel: 0)
				(= cycles 2)
			)
			(4
				(= state -1)
				(= ticks 1)
			)
		)
	)
)

(instance pointAtStars of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 180 480))
			)
			(1
				(client cel: 0 setCycle: End self)
			)
			(2
				(= state -1)
				(= ticks 1)
			)
		)
	)
)

(instance generalMotion of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 180 480))
			)
			(1
				(client cel: 0 setCycle: End self)
			)
			(2
				(= state -1)
				(= ticks 1)
			)
		)
	)
)

(instance plantWriggles of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 180 480))
			)
			(1
				(client cel: 0 setCycle: Osc (RandomNumber 1 3) self)
			)
			(2
				(client cel: 0)
				(= state -1)
				(= ticks 1)
			)
		)
	)
)

(instance egoSitsDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and local5 (deathHead script:))
					(deathHead setScript: endFollower self)
				else
					(= ticks 1)
				)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 270 self)
			)
			(2
				(= local0 1)
				(gEgo
					view: 433
					setLoop: 0 1
					cel: 0
					posn: 140 114
					setCycle: End self
				)
			)
			(3
				(= local0 1)
				(gMouseDownHandler addToFront: circuitSid)
				(gEgo state: (& (gEgo state:) $fffd))
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance egoStandsUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 433
					loop: 2
					cel: 0
					posn: 140 114
					setCycle: End self
				)
			)
			(1
				(= local0 0)
				(gEgo normalize: 5)
				(if (and (!= local1 -1) (!= local2 -1))
					(gEgo setMotion: PolyPath local1 local2 self)
				else
					(= ticks 1)
				)
			)
			(2
				(= local1 -1)
				(= local2 -1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sidIntro of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not local0)
					(self setScript: egoSitsDown self)
				else
					(= ticks 1)
				)
			)
			(1
				(gGame handsOff:)
				(gCurRoom setInset: talkerInset self 1 1)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sidGivesArm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not local0)
					(self setScript: egoSitsDown self)
				else
					(= ticks 1)
				)
			)
			(1
				(gGame handsOff:)
				(gCurRoom setInset: talkerInset self 2 1)
			)
			(2
				(head hide:)
				(circuitSid view: 434 loop: 0 cel: 0 setCycle: CT 3 1 self)
			)
			(3
				(gGSound2 number: 432 loop: 0 play: setVol: 127)
				(circuitSid setCycle: End self)
			)
			(4
				(SetFlag 44)
				(arm init: ignoreActors: 1 approachVerbs: 4) ; Do
				(head show:)
				(circuitSid view: 435 loop: 2 cel: 0)
				(= cycles 2)
			)
			(5
				(gCurRoom setInset: talkerInset self 3 1)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sidGivesEye of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not local0)
					(self setScript: egoSitsDown self)
				else
					(= ticks 1)
				)
			)
			(1
				(gGame handsOff:)
				(Load 140 431) ; WAVE
				(gCurRoom setInset: talkerInset self 4 1)
			)
			(2
				(head hide:)
				(circuitSid view: 434 loop: 2 cel: 0 setCycle: End self)
			)
			(3
				(gGSound2 number: 431 loop: -1 play: setVol: 127)
				(circuitSid loop: 3 cel: 0 setCycle: Fwd)
				(= ticks 60)
			)
			(4
				(circuitSid setCycle: End self)
			)
			(5
				(gGSound2 stop:)
				(gEgo hide:)
				(circuitSid loop: 4 cel: 0 setCycle: End self)
			)
			(6
				(gEgo show:)
				(head show:)
				(circuitSid loop: 2 cel: 0)
				(= cycles 2)
			)
			(7
				(SetFlag 143)
				(gEgo get: 101) ; Sidney_Eye
				(gGame points: 3 455)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance takeSidsArmSit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(arm hide: dispose:)
				(client view: 438 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(gGame points: 3 454)
				(gEgo get: 100) ; Sidney_Arm
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance takeSidsArmStand of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 270 self)
			)
			(1
				(arm hide: dispose:)
				(client view: 4380 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(gGame points: 3 454)
				(gEgo get: 100 normalize: 1) ; Sidney_Arm
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sidGivesNothing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not local0)
					(self setScript: egoSitsDown self)
				else
					(= ticks 1)
				)
			)
			(1
				(gGame handsOff:)
				(gCurRoom setInset: talkerInset self 5 1)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance startFollower of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gCurRoom script:)
					(= state -1)
				)
				(= ticks 1)
			)
			(1
				(gGame handsOff:)
				(= ticks 45)
			)
			(2
				(deathHead loop: 4)
				(= ticks 10)
			)
			(3
				(deathHead setLoop: 2 1)
				(= ticks 10)
			)
			(4
				(deathHead
					yStep: 1
					setMotion: MoveTo (deathHead x:) (- (deathHead y:) 20) self
				)
			)
			(5
				(localproc_0)
				(deathHead
					yStep: 2
					setLoop: -1
					setMotion: MoveTo local3 local4 self
				)
			)
			(6
				(deathHead code: follow)
				(= cycles 2)
			)
			(7
				(gGame handsOn:)
				(= seconds (RandomNumber 15 20))
			)
			(8
				(self setScript: endFollower self)
			)
			(9
				(self dispose:)
			)
		)
	)
)

(instance endFollower of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(localproc_1 deathHead circuitSid self)
			)
			(1
				(deathHead code: 0 setMotion: MoveTo 94 78 self)
			)
			(2
				(deathHead setHeading: 90 self)
			)
			(3
				(head init: priority: (+ (circuitSid priority:) 1) code: slave)
				(deathHead setCycle: 0 hide:)
				(= cycles 2)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lookAtTheView of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setMotion:
						PolyPath
						(viewScreen approachX:)
						(viewScreen approachY:)
						self
				)
			)
			(1
				(gCurRoom newRoom: 435) ; regCredits
			)
		)
	)
)

(instance head of Actor
	(properties
		x 94
		y 78
		fixPriority 1
		view 432
		loop 1
		cel 3
	)

	(method (init)
		(|= signal $1000)
		(= actions circuitSid)
		(super init: &rest)
	)
)

(instance deathHead of Actor
	(properties
		noun 29
		sightAngle 40
		x 94
		y 78
		fixPriority 1
		view 4389
		cel 3
		cycleSpeed 10
		moveSpeed 3
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
	)

	(method (cue)
		(gGame handsOff:)
		(gCurRoom setInset: (ScriptID 800 0) 0 0 1) ; foodReplicatorInset
	)
)

(class Customer of Prop
	(properties)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: 0 theVerb 6 0) ; "Yeah, just walk over and feel 'em up. I'm sure they'll appreciate it. And we're sure you'll enjoy it when you're the recipient of some nice phaser blast ventilation."
			)
			(2 ; Talk
				(gMessager say: 0 theVerb 6 0) ; "Don't interrupt them. They're on break. Besides, you stand less of a chance of being insulted or shot down. A guy can only take so much of that."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance starGazers of Customer
	(properties
		noun 30
		sightAngle 40
		x 249
		y 100
		z 3
		view 430
	)
)

(instance elvis of Customer
	(properties
		noun 27
		sightAngle 40
		x 193
		y 95
		view 430
		loop 1
	)
)

(instance circuitSid of Prop
	(properties
		noun 19
		sightAngle 40
		approachX 115
		approachY 120
		x 102
		y 112
		priority 115
		fixPriority 1
		view 432
		loop 2
	)

	(method (init)
		(|= signal $1000)
		(gWalkHandler addToFront: self)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(switch gSidneyTalkCount
					(0
						(gEgo setScript: sidIntro)
					)
					(1
						(gEgo setScript: sidGivesArm)
					)
					(2
						(gEgo setScript: sidGivesEye)
					)
					(3
						(gEgo setScript: sidGivesNothing)
					)
					(4
						(gMessager say: noun theVerb 4 0) ; "Sydney won't be interested in talking to you any further until you return his body parts."
					)
				)
				(if (< gSidneyTalkCount 4)
					(++ gSidneyTalkCount)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (handleEvent event)
		(cond
			(
				(and
					(gUser controls:)
					(gUser input:)
					(& (event type:) evMOUSEBUTTON)
					(not (self onMe: event))
					(not (arm onMe: event))
					local0
				)
				(if (== (gTheIconBar curIcon:) (gTheIconBar walkIconItem:))
					(= local1 (event x:))
					(= local2 (event y:))
				else
					(= local1 -1)
					(= local2 -1)
				)
				(= local0 0)
				(if (gMouseDownHandler contains: self)
					(gMouseDownHandler delete: self)
				)
				(gEgo setScript: egoStandsUp)
				(= approachX 115)
				(= approachY 120)
				(event claimed: 1)
				(return 1)
			)
			(
				(and
					(& (event type:) evMOVE)
					(or (self onMe: event) (arm onMe: event))
					local0
				)
				(event claimed: 1)
				(return 1)
			)
			(
				(and
					(& (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
					(== (event message:) JOY_UPRIGHT)
				)
				(= approachX 153)
				(= approachY 118)
				(super handleEvent: event &rest)
			)
			(else
				(= approachX 115)
				(= approachY 120)
				(super handleEvent: event &rest)
			)
		)
	)

	(method (dispose)
		(if (gMouseDownHandler contains: self)
			(gMouseDownHandler delete: self)
		)
		(if (gWalkHandler contains: self)
			(gWalkHandler delete: self)
		)
		(super dispose: &rest)
	)
)

(instance cust1 of Customer
	(properties
		noun 20
		sightAngle 40
		x 120
		y 108
		priority 109
		fixPriority 1
		view 431
	)
)

(instance cust2 of Customer
	(properties
		noun 21
		sightAngle 40
		x 122
		y 111
		view 431
		loop 1
	)
)

(instance cust3 of Customer
	(properties
		noun 22
		sightAngle 40
		x 246
		y 105
		view 431
		loop 2
		cel 5
	)
)

(instance cust4 of Customer
	(properties
		noun 23
		sightAngle 40
		x 246
		y 105
		view 431
		loop 3
		cel 10
	)
)

(instance cust5 of Customer
	(properties
		noun 24
		sightAngle 40
		x 176
		y 94
		view 431
		loop 4
		cel 8
	)
)

(instance cust6 of Customer
	(properties
		noun 25
		sightAngle 40
		x 174
		y 100
		z 6
		priority 97
		fixPriority 1
		view 431
		loop 5
	)
)

(instance cust7 of Customer
	(properties
		noun 26
		sightAngle 40
		x 228
		y 97
		z 3
		view 431
		loop 6
	)
)

(instance plant of Prop
	(properties
		noun 28
		sightAngle 40
		x 71
		y 107
		view 436
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
	)
)

(instance movingSky of Prop
	(properties
		noun 3
		x 61
		view 4311
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (< ((gUser curEvent:) x:) 153)
			(= noun 4)
		else
			(= noun 3)
		)
		(super doVerb: theVerb &rest)
	)
)

(instance arm of View
	(properties
		approachX 136
		approachY 116
		x 122
		y 88
		priority 115
		fixPriority 1
		view 434
		loop 1
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if
			(and
				(& (event type:) evVERB)
				(self onMe: event)
				(self isNotHidden:)
				(== (event message:) JOY_DOWNRIGHT)
			)
			(= approachX 143)
			(= approachY 117)
			(super handleEvent: event &rest)
		else
			(= approachX 136)
			(= approachY 116)
			(super handleEvent: event &rest)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((gEgo has: 100)) ; Sidney_Arm
					(local0
						(gEgo setScript: takeSidsArmSit)
					)
					(else
						(gEgo setScript: takeSidsArmStand)
					)
				)
			)
			(1 ; Look
				(gMessager say: 0 theVerb 0 7 0 0) ; "What can be said that isn't painfully obvious?"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bigArm of View
	(properties
		x 48
		y 79
		view 439
	)
)

(instance bigEye of View
	(properties
		x 124
		y 37
		view 439
		cel 1
	)
)

(instance comPost of Feature
	(properties
		noun 2
		sightAngle 20
		approachX 50
		approachY 127
		x 33
		y 83
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 26 79 26 88 41 88 41 79 yourself:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom newRoom: 460)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance replicatorFeature2 of Feature
	(properties
		noun 7
		sightAngle 40
		approachX 281
		approachY 125
		x 301
		y 125
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 278 65 278 91 276 95 301 100 306 92 306 61
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (and local5 (deathHead script:))
					(deathHead setScript: endFollower deathHead)
				else
					(gGame handsOff:)
					(gCurRoom setInset: (ScriptID 800 0) 0 0 1) ; foodReplicatorInset
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance comPad of Feature
	(properties
		noun 9
		sightAngle 40
		x 47
		y 126
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 42 120 62 121 77 126 67 130 45 132 24 130 17 125 29 121
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance hangyThing of Feature
	(properties
		noun 15
		sightAngle 40
		x 145
		y 14
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 138 0 137 26 144 28 153 27 153 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance hangyThing2 of Feature
	(properties
		noun 15
		sightAngle 40
		x 212
		y 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 207 0 207 41 211 43 216 41 218 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance light of Feature
	(properties
		noun 14
		sightAngle 40
		x 61
		y 20
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 3 53 4 98 13 121 24 123 27 120 29 119 32 98 36 62 38 64 32 39 25 5 19 4 15 3 6 0 6
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance pillar1 of Feature
	(properties
		noun 10
		sightAngle 40
		approachX 3
		approachY 71
		x 2
		y 64
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 5 4 7 4 15 5 17 5 34 3 36 4 124 0 124
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance pillar2 of Feature
	(properties
		noun 11
		sightAngle 40
		approachX 130
		approachY 7
		x 124
		y 48
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 119 0 120 97 129 95 130 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance pillar3 of Feature
	(properties
		noun 12
		sightAngle 40
		approachX 176
		approachY 7
		x 171
		y 47
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 166 0 166 94 176 94 176 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance pillar4 of Feature
	(properties
		noun 16
		sightAngle 40
		approachX 262
		approachY 112
		x 265
		y 57
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 259 0 259 95 257 96 257 111 267 114 269 32 273 29 273 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance windowL of Feature
	(properties
		noun 4
		sightAngle 40
		x 71
		y 7
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 62 38 64 45 117 53 120 52 120 31 91 38 71 38
					yourself:
				)
				((Polygon new:) type: PTotalAccess init: 70 0 94 5 119 14 119 0 yourself:)
				((Polygon new:)
					type: PTotalAccess
					init: 130 0 130 55 130 57 141 57 153 39 153 28 136 28 136 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance windowR of Feature
	(properties
		noun 3
		sightAngle 20
		approachX 252
		approachY 99
		x 252
		y 99
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 207 0 197 15 195 35 199 51 216 67 242 78 259 79 259 45 257 44 256 31 259 28 259 0
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 273 0 273 30 313 21 305 5 274 0 275 17 272 20
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance viewScreen of Feature
	(properties
		noun 5
		sightAngle 40
		approachX 98
		approachY 90
		x 85
		y 68
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 73 59 73 75 98 77 98 62 yourself:)
		)
		(gMouseDownHandler add: self)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if
			(and
				(gUser input:)
				(gUser controls:)
				(& (event type:) evMOUSEBUTTON)
				(& (event modifiers:) emCTRL)
				(self onMe: event)
				(>= (++ local7) 5)
			)
			(= local7 0)
			(gCurRoom setScript: lookAtTheView)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (dispose)
		(if (gMouseDownHandler contains: self)
			(gMouseDownHandler delete: self)
		)
		(super dispose: &rest)
	)
)

(instance table1 of Feature
	(properties
		noun 13
		sightAngle 40
		x 108
		y 89
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 78 87 81 91 139 91 138 87 78 87
					yourself:
				)
		)
		(= approachX (arm approachX:))
		(= approachY (arm approachY:))
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 4) gCast (gCast contains: arm)) ; Do
			(arm doVerb: theVerb)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance seat1 of Feature
	(properties
		noun 17
		sightAngle 40
		x 104
		y 95
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 84 98 84 102 104 102 104 98
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 98 95 98 97 114 97 114 95
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 140 99 140 103 161 103 161 99
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance table2 of Feature
	(properties
		noun 13
		sightAngle 40
		x 176
		y 83
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 163 82 163 85 189 85 189 82
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance seat2 of Feature
	(properties
		noun 17
		sightAngle 40
		x 104
		y 95
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 151 87 151 90 162 90 162 87
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 171 87 171 90 182 90 182 87
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 190 87 190 90 200 90 200 87
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance table3 of Feature
	(properties
		noun 13
		sightAngle 40
		x 232
		y 85
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 220 84 220 86 245 86 245 84
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance seat3 of Feature
	(properties
		noun 17
		sightAngle 40
		x 219
		y 95
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 208 87 208 90 218 90 218 87
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 228 87 228 90 239 90 239 87
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance table4 of Feature
	(properties
		noun 13
		sightAngle 40
		x 249
		y 89
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 240 91 259 91 259 88 240 88
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance seat4 of Feature
	(properties
		noun 17
		sightAngle 40
		x 234
		y 95
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 221 96 221 98 234 98 234 96
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 243 95 243 97 255 97 255 95
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 248 98 248 100 257 100 257 98
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance light2 of Feature
	(properties
		noun 14
		sightAngle 40
		x 180
		y 3
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 166 0 166 5 179 6 194 5 194 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance light3 of Feature
	(properties
		noun 14
		sightAngle 40
		x 297
		y 2
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 276 0 319 5 319 0 yourself:)
		)
		(super init: &rest)
	)
)

(instance star of Feature
	(properties
		noun 3
		nsLeft 231
		nsTop 30
		nsRight 232
		nsBottom 31
		y 100
	)

	(method (doVerb theVerb)
		(if
			(and
				(== theVerb 4) ; Do
				(not local6)
				(not (gCurRoom script:))
				(not (RandomNumber 0 12))
			)
			(gCurRoom setScript: sillyStar)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance soylent of Feature
	(properties
		noun 6
		sightAngle 40
		x 290
		y 56
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 276 53 302 49 305 50 305 60 276 64
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance transportTube of Feature
	(properties
		noun 5
		modNum 370
		sightAngle 40
		x 46
		y 21
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 65 0 65 14 65 5 65 14 55 16 38 16 28 14 28 4 30 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(class TalkInset of Inset
	(properties)

	(method (cue))
)

(instance talkerInset of TalkInset
	(properties
		picture 435
		disposeNotOnMe 1
	)

	(method (init)
		(Load rsVIEW 439)
		(Load rsSCRIPT 64929)
		(Load rsHEAP 64929)
		(super init: &rest)
		(if (IsFlag 44)
			(bigArm init:)
		)
		(if (IsFlag 143)
			(bigEye init:)
		)
		(switch register
			(1
				(gMessager say: 0 0 1 0 self) ; "Hello, Roger. Please join me in consuming something."
			)
			(2
				(gMessager sayRange: 19 2 1 1 6 self) ; "Sydney, I have a favor I'd like to ask of you."
			)
			(3
				(gMessager sayRange: 19 2 1 7 8 self) ; "You will get it right back to me, won't you, Roger?"
			)
			(4
				(gMessager say: 19 2 2 0 self) ; "Sydney, I kind of need another favor. I need one of your eyes."
			)
			(5
				(gMessager say: 19 2 3 0 self) ; "Roger, are you here to return my structural loans?"
			)
		)
	)

	(method (cue)
		(self dispose:)
	)
)

(instance Sidney of Talker
	(properties)

	(method (init)
		(= mouth sidMouth)
		(= eyes sidEyes)
		(super init: &rest)
	)
)

(instance sidMouth of Prop
	(properties
		x 120
		y 57
		view 439
		loop 1
	)
)

(instance sidEyes of Prop
	(properties
		x 120
		y 37
		fixPriority 1
		view 439
		loop 2
	)

	(method (init)
		(if (IsFlag 143)
			(= loop 3)
			(= cel 0)
			(= priority (+ (bigEye priority:) 1))
		)
		(super init: &rest)
	)
)

(instance slave of Code
	(properties)

	(method (doit)
		(cond
			((< (gEgo y:) 118)
				(if (!= (head cel:) 3)
					(head cel: 3)
				)
			)
			((< 0 (gEgo x:) 95)
				(if (!= (head cel:) 0)
					(head cel: 0)
				)
			)
			((< 95 (gEgo x:) 135)
				(if (!= (head cel:) 1)
					(head cel: 1)
				)
			)
			((and (< 135 (gEgo x:) 210) (!= (head cel:) 2))
				(head cel: 2)
			)
		)
	)
)

(instance follow of Code
	(properties)

	(method (doit)
		(localproc_0)
		(deathHead
			x: local3
			y: local4
			loop: (gEgo loop:)
			priority: (gEgo priority:)
		)
	)
)

