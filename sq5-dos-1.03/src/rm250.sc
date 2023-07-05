;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 250)
(include sci.sh)
(use Main)
(use eureka)
(use Inset)
(use Scaler)
(use Osc)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm250 0
)

(local
	local0
	local1
	local2
	local3 = 1
	local4 = 1
	[local5 5] = [25 64 77 94 111]
	[local10 5] = [25 75 90 107 127]
)

(procedure (localproc_0)
	(cond
		((IsFlag 84)
			(if (!= (gSq5Music1 number:) 42)
				(gSq5Music1 number: 42 loop: -1 play: 127)
			)
		)
		((IsFlag 61)
			(if (!= (gSq5Music1 number:) 20)
				(gSq5Music1 number: 20 loop: -1 play: 127)
			)
		)
		(else
			(gSq5Music1 number: 101 loop: -1 play: 127)
		)
	)
)

(procedure (localproc_1 param1)
	(cond
		((InRect 83 [local5 1] 110 [local10 1] param1)
			(return 1)
		)
		((InRect 83 [local5 2] 110 [local10 2] param1)
			(return 2)
		)
		((InRect 83 [local5 3] 110 [local10 3] param1)
			(return 3)
		)
		((InRect 83 [local5 4] 110 [local10 4] param1)
			(return 4)
		)
		(else
			(return -1)
		)
	)
)

(procedure (localproc_2 param1) ; UNUSED
	(return
		(switch param1
			(1 [local5 1])
			(2 [local5 2])
			(3 [local5 3])
			(4 [local5 4])
			(else [local5 1])
		)
	)
)

(instance rm250 of Rm
	(properties
		noun 10
		picture 44
		style 10
		vanishingX 20
		vanishingY 110
	)

	(method (init &tmp temp0)
		(gCurRoom setRegions: 210) ; eureka
		(LoadMany rsVIEW 251 266)
		(NormalEgo 0)
		(gEgo init: setScale: Scaler 134 81 164 134 edgeHit: 0)
		(cliffySuit init:)
		(otherSuit init:)
		(oxyTank init:)
		(console init: setOnMeCheck: 1 2)
		(elevatorTop init:)
		(elevatorBottom init:)
		(pod init:)
		(cliffy init:)
		(maskDoor init: stopUpd:)
		(cDoorF init:)
		(bayDoorsF init: setOnMeCheck: 1 16)
		(switch gPrevRoomNum
			(north
				(gEgo posn: 288 135 setHeading: 180)
				(self setScript: sOpenElev)
			)
			(801
				(gEgo posn: -50 -50)
				(podRmDoors init: setCel: (podRmDoors lastCel:))
				(self setScript: dropOffCliffy)
			)
			(else
				(gEgo posn: 288 135 setHeading: 180)
				(self setScript: sOpenElev)
			)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 152 131 126 134 183 153 114 163 49 141 1 144 2 185 157 187 295 151 268 152 231 150 153 131
					yourself:
				)
		)
		(super init:)
		(localproc_0)
		(gWalkHandler addToFront: turboLift)
	)

	(method (dispose)
		(gWalkHandler delete: turboLift)
		(super dispose:)
	)
)

(instance sPopUpConsole of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(gTheIconBar disable: 0 3 1 5 4 6)
				(= seconds 2)
				(= register 0)
			)
			(1
				(gCast eachElementDo: #stopUpd)
				(gCurRoom setInset: popUpConsole self)
				(gGame setCursor: 982 1 88 (+ [local5 1] 5))
			)
			(2
				(= seconds 2)
			)
			(3
				(switch register
					(1
						(if (gCast contains: cliffy)
							(gMessager say: 11 0 0 0 self) ; "Captain, are you crazy?! We'll get sucked out into the deep void of space!"
						else
							(= next sDoRedButton)
							(self dispose:)
						)
					)
					(2
						(self setScript: sElevatorDoors self)
					)
					(3
						(self setScript: sRotatePod self)
					)
					(4
						(self setScript: sIntercom self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(4
				(gTheIconBar enable: 0 3 5 4 1 6)
				(if (gCast contains: cliffy)
					(cliffy startUpd:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenElev of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: 288 138)
				(= cycles 1)
			)
			(1
				(gSq5Music2 number: 127 loop: 1 play:)
				(= cycles 1)
			)
			(2
				(elevLights init: setCycle: End self)
			)
			(3
				(gSq5Music2 number: 241 setLoop: 1 play: self)
			)
			(4
				(elevLights dispose:)
				(self setScript: sElevatorDoors self)
			)
			(5
				(gEgo setMotion: MoveTo 277 154 self)
			)
			(6
				(self setScript: sElevatorDoors self)
			)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 288 138 self)
			)
			(1
				(gEgo setHeading: 180)
				(= seconds 1)
			)
			(2
				(self setScript: sElevatorDoors self)
			)
			(3
				(elevLights init: setCycle: Beg self)
				(gSq5Music2 number: 127 loop: 1 play:)
			)
			(4
				(gCurRoom newRoom: 225)
				(self dispose:)
			)
		)
	)
)

(instance sRogPushButton of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo hide:)
				(rogThink init:)
				(= seconds 1)
			)
			(1
				(rogThink setCycle: End self)
				(rogArm init: cycleSpeed: 20 setCycle: Osc 1 self)
			)
			(2 0)
			(3
				(rogArm dispose:)
				(rogThink setCycle: Beg self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance sDoButton of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(sPopUpConsole register: local0)
				(= seconds 2)
			)
			(1
				(popUpConsole dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenPodDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 118)
				(podDoor init: cel: 0 setCycle: End self)
				(gSq5Music2 number: 217 loop: 1 play:)
			)
			(1
				(podDoor setLoop: 1)
				(= cycles 3)
			)
			(2
				(podDoor setLoop: 1 cel: 0 setCycle: End self)
				(gSq5Music2 number: 217 loop: 1 play:)
			)
			(3
				(podDoor stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance sClosePodDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(podDoor setLoop: 1 cel: 10 setCycle: Beg self)
				(gSq5Music2 number: 217 loop: 1 play:)
			)
			(1
				(= cycles 1)
			)
			(2
				(podDoor setLoop: 0 cel: 12 setCycle: Beg self)
				(gSq5Music2 number: 217 loop: 1 play:)
			)
			(3
				(podDoor dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sRotatePod of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gCast contains: pod)
					(= cycles 1)
				else
					(gMessager say: 16 0 0 1 self) ; "Currently, there is no pod."
					(= state 4)
				)
			)
			(1
				(if (== (pod cel:) 4)
					(ClearFlag 118)
					(self setScript: sClosePodDoor self)
					(= state 2)
				else
					(pod view: 254 loop: 0 cel: 0 setCycle: End self)
				)
			)
			(2
				(pod stopUpd:)
				(self setScript: sOpenPodDoor self)
				(SetFlag 118)
				(= state 3)
			)
			(3
				(pod view: 254 loop: 0 cel: (pod lastCel:) setCycle: Beg self)
			)
			(4
				(pod view: 251 loop: 1 cel: (if (pod cel:) 4 else 3) stopUpd:)
				(= cycles 1)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetInPod of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(if (== global113 14)
					(SetScore 195 300)
				)
				(gEgo
					view: 267
					setLoop: 0
					cel: 0
					x: 142
					y: 156
					setScale: 0
					setCycle: End self
				)
			)
			(2
				(= seconds 2)
			)
			(3
				(self setScript: sClosePodDoor self)
			)
			(4
				(if (not local4)
					(self setScript: sElevatorDoors self)
				else
					(= cycles 1)
				)
			)
			(5
				(podRmDoors init: cycleSpeed: 10 setCycle: End self)
				(= local3 0)
			)
			(6
				(pod
					view: 254
					cel: 0
					setLoop: 1
					x: 161
					y: 154
					setCycle: End self
				)
			)
			(7
				(if (== global113 15)
					(gCurRoom newRoom: 801)
				else
					(SetFlag 88)
					(gCurRoom newRoom: 802)
				)
				(self dispose:)
			)
		)
	)
)

(instance sIntercom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 3 4 0 1 self) ; "Cliffy scavenged the microphone and speaker from this intercom to rig up a voice activated flush mechanism for the Eureka's head. When the rest of the crew balked at having to say ''bombs away!'' each time they used the facilities, he hooked it up the transporter unit instead."
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDoRedButton of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 2)
			)
			(1
				(self setScript: sRogPushButton self)
			)
			(2
				(podRmDoors init: cycleSpeed: 16 setCycle: End self)
				(= local3 0)
			)
			(3
				(= cycles 1)
			)
			(4
				(gSq5Music1 number: 276 loop: -1 play:)
				(= cycles 1)
			)
			(5
				(rogThink loop: 5 cel: 0 posn: 246 126 setCycle: Fwd self)
				(gSq5Music2 number: 102 loop: 1 play:)
				(= seconds 4)
			)
			(6
				(rogThink
					setLoop: 5
					setCel: 8
					setPri: 6
					setCycle: 0
					moveSpeed: 0
					setStep: 20
					setScale: Scaler 134 75 164 110
					setMotion: MoveTo 35 110 self
				)
			)
			(7
				(podRmDoors setCycle: Beg self)
			)
			(8
				(podRmDoors dispose:)
				(= seconds 2)
			)
			(9
				(gSq5Music1 stop:)
				(rogThink dispose:)
				(EgoDead 10) ; "Nice move, ace. Really spectacular."
				(self dispose:)
			)
		)
	)
)

(instance sElevatorDoors of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 1)
			)
			(1
				(if local4
					(elevatorBottom startUpd:)
					(elevatorTop
						posn: 249 88
						ignoreActors: 0
						setMotion: MoveTo 249 45 self
					)
					(turboLift init:)
					(= local4 0)
				else
					(elevatorTop
						posn: 249 45
						ignoreActors: 0
						setMotion: MoveTo 249 88 self
					)
					(elevatorBottom ignoreActors: 0)
					(turboLift dispose:)
					(= local4 1)
				)
			)
			(2
				(if local4
					(gSq5Music2 number: 233 loop: 1 play:)
				)
				(elevatorTop stopUpd:)
				(elevatorBottom stopUpd:)
				(if (!= client sOpenElev)
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance dropOffCliffy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 87)
				(gEgo stopUpd:)
				(pod setCycle: End self)
			)
			(1
				(podRmDoors setCycle: Beg self)
			)
			(2
				(podRmDoors dispose:)
				(= local3 1)
				(pod
					view: 254
					cel: 0
					setLoop: 0
					x: 161
					y: 154
					cycleSpeed: 20
					setCycle: End
				)
				(cliffy
					x: 150
					y: 138
					setLoop: 1
					cel: 0
					setCycle: 0
					setStep: 6 6
					setMotion: MoveTo 150 166 self
				)
			)
			(3
				(gSq5Music2 number: 102 loop: 1 play:)
				(cliffy setCycle: End self)
			)
			(4
				(cliffy setLoop: 2 cel: 0 setCycle: End self)
			)
			(5
				(cliffy view: 251 loop: 1 cel: 5 stopUpd:)
				(pod view: 251 setLoop: 1 cel: 4 stopUpd:)
				(self setScript: sOpenPodDoor self)
			)
			(6
				(gEgo
					view: 267
					setLoop: 0
					cel: 11
					x: 142
					y: 156
					setScale: 0
					setCycle: Beg self
				)
			)
			(7
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 114 164 176 155 182 177 121 177
							yourself:
						)
				)
				(NormalEgo 0 7)
				(gEgo
					setScale: Scaler 134 81 164 134
					posn: 147 156
					setMotion: MoveTo 182 156 self
				)
			)
			(8
				(gEgo setHeading: 225 self)
			)
			(9
				(gMessager say: 12 0 0 0 self) ; "You okay, Cliffy?"
			)
			(10
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getTank of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(oxyTank view: 266 loop: 2 cel: 0 setCycle: End self)
				(gSq5Music2 number: 103 loop: 1 play:)
				(= global137 3)
			)
			(1
				(gEgo view: 267 loop: 1 cel: 0 setCycle: CT 2 1 self)
			)
			(2
				(SetScore 190 25)
				(oxyTank setCel: 2 loop: 1 view: 251)
				(gEgo get: 9 setCycle: End self) ; Oxygen_Tank
			)
			(3
				(NormalEgo 0 6)
				(oxyTank stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance returnTank of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 267 loop: 1 cel: 0 setCycle: CT 2 1 self)
			)
			(1
				(gEgo put: 9 setCycle: End self) ; Oxygen_Tank
				(oxyTank startUpd: view: 266 loop: 2 cel: 8)
			)
			(2
				(gSq5Music2 number: 103 loop: 1 play:)
				(oxyTank setCycle: Beg self)
			)
			(3
				(NormalEgo 0 6)
				(oxyTank view: 251 loop: 1 cel: 6 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getMask of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 45 self)
			)
			(1
				(gEgo view: 243 loop: 2 cel: 0 setCycle: End self)
			)
			(2
				(oxygenMask init:)
				(gSq5Music2 number: 103 loop: 1 play:)
				(maskDoor setCycle: End self)
				(gEgo setCycle: Beg self)
			)
			(3)
			(4
				(gEgo view: 267 loop: 1 cel: 0 setCycle: CT 2 1 self)
			)
			(5
				(SetScore 182 5)
				(oxygenMask setLoop: 4)
				(gEgo setCycle: End self)
			)
			(6
				(gSq5Music2 number: 103 loop: 1 play:)
				(maskDoor setCycle: Beg self)
			)
			(7
				(NormalEgo 0 6)
				(oxygenMask dispose:)
				(maskDoor stopUpd:)
				(gEgo get: 21) ; Oxygen_Mask
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance cStuff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 90 self)
			)
			(1
				(gSq5Music2 number: 4800 loop: -1 play:)
				(cDoor init: setCycle: End self)
			)
			(2
				(chick
					init:
					posn: 1 117
					setMotion: MoveTo 67 157 self
					setCycle: Fwd
				)
			)
			(3
				(cDoor setCycle: Beg)
				(chick setMotion: MoveTo 193 186 self)
			)
			(4
				(cDoor dispose:)
				(chick dispose:)
				(gSq5Music2 stop:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance bang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (gGame detailLevel:) (cliffy detailLevel:))
					(cliffy stopUpd:)
					(-- state)
				else
					(cliffy startUpd:)
				)
				(= cycles 1)
			)
			(1
				(cliffy cel: 0 setCycle: End self)
			)
			(2
				(-= state 3)
				(if (not (gCurRoom script:))
					(gSq5Music2 number: 230 loop: 1 play: self)
				else
					(= cycles 1)
				)
			)
		)
	)
)

(instance oxygenMask of View
	(properties
		x 183
		y 90
		approachX 172
		approachY 141
		view 251
		loop 3
		priority 4
		signal 16400
	)
)

(instance maskDoor of Prop
	(properties
		x 183
		y 90
		noun 15
		approachX 172
		approachY 141
		view 251
		loop 2
		priority 5
		signal 20497
	)

	(method (init)
		(self approachVerbs: 4 1) ; Do, Look
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (gEgo has: 21) ; Oxygen_Mask
					(gMessager say: 15 4 1 0) ; "The compartment is empty. Besides, you've already got a mask."
				else
					(gCurRoom setScript: getMask)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cliffy of Actor
	(properties
		x 10
		y 143
		noun 17
		view 191
		loop 2
		cel 2
		scaleSignal 1
		detailLevel 3
	)

	(method (init)
		(cond
			((== gPrevRoomNum 801)
				(self
					view: 268
					loop: 1
					cel: 0
					posn: -50 -38
					ignoreActors: 1
					setPri: 13
				)
				(= global130 3)
				(super init: &rest)
			)
			((== global130 3)
				(self setScale: Scaler 134 81 164 134 setScript: bang)
				(super init: &rest)
			)
		)
	)
)

(instance cDoor of Prop
	(properties
		x 4
		y 102
		view 251
		loop 5
		priority 8
		signal 16400
	)
)

(instance chick of Actor
	(properties
		y 116
		yStep 4
		view 970
		signal 18432
		xStep 6
	)
)

(instance podRmDoors of Prop
	(properties
		x 38
		y 83
		noun 1
		view 266
		loop 1
	)

	(method (setCycle param1)
		(if (and param1 (not cel))
			(gSq5Music2 number: 108 loop: 1 play:)
		)
		(super setCycle: param1 &rest)
	)
)

(instance podDoor of Prop
	(properties
		x 127
		y 161
		z 60
		approachX 142
		approachY 156
		view 262
		priority 10
		signal 16400
	)

	(method (init)
		(self approachVerbs: 4 setPri: 10) ; Do
		(if (IsFlag 118)
			(self setLoop: 1 cel: 10)
		else
			(self setLoop: 0 cel: 0)
		)
		(if (not (IsFlag 88))
			(super init:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(switch global113
					(15
						(if (IsFlag 87)
							(gMessager say: 13 0 0 0) ; "The pod will have to be refueled and repaired by Cliffy before you can use it again."
						else
							(gCurRoom setScript: sGetInPod)
						)
					)
					(14
						(gCurRoom setScript: sGetInPod)
					)
					(else
						(gMessager say: 14 0 0 0) ; "StarCon regulations prohibit use of the EVA pod except for rescue and emergency situations."
					)
				)
			)
			(else
				(super doVerb: &rest)
			)
		)
	)
)

(instance pod of Prop
	(properties
		x 161
		y 154
		noun 5
		view 251
		loop 1
		cel 3
		priority 10
		signal 16401
		cycleSpeed 12
	)

	(method (setCycle param1)
		(if (and argc param1)
			(gSq5Music2 number: 106 loop: 1 play:)
		)
		(super setCycle: param1 &rest)
	)

	(method (init)
		(cond
			((== gPrevRoomNum 801)
				(self view: 268 loop: 4 cel: 0 x: 63 y: 139)
				(super init:)
			)
			((or (IsFlag 88) (and (IsFlag 84) (!= (eureka state:) 3)))
				(self dispose:)
			)
			((IsFlag 118)
				(self view: 251 loop: 1 cel: 4)
				(super init:)
				(podDoor init:)
			)
			(else
				(self stopUpd:)
				(super init:)
			)
		)
	)
)

(instance elevatorTop of Actor
	(properties
		x 249
		y 88
		noun 4
		view 251
		priority 10
		signal 18449
	)

	(method (setMotion param1)
		(if (and argc param1)
			(gSq5Music2 number: 108 loop: 1 play:)
		)
		(super setMotion: param1 &rest)
	)
)

(instance elevatorBottom of View
	(properties
		x 251
		y 128
		noun 4
		view 251
		cel 1
		priority 9
		signal 18449
	)

	(method (doit)
		(self posn: x (+ 128 (/ (- 88 (elevatorTop y:)) 2)))
		(super doit:)
	)
)

(instance elevLights of Prop
	(properties
		x 273
		y 97
		view 266
		priority 15
		signal 16
	)
)

(instance rogThink of Actor
	(properties
		x 240
		y 170
		view 267
		loop 2
		priority 12
		signal 16400
	)
)

(instance rogArm of Prop
	(properties
		x 226
		y 112
		view 267
		loop 3
		priority 13
		signal 16400
	)
)

(instance oxyTank of Prop
	(properties
		x 167
		y 95
		noun 7
		approachX 158
		approachY 133
		view 251
		loop 1
		priority 6
		signal 16400
	)

	(method (init)
		(self cel: (if (gEgo has: 9) 2 else 6) approachVerbs: 4 1 25) ; Oxygen_Tank, Do, Look, Oxygen_Tank
		(super init: &rest)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(if (== (self cel:) 2)
			(self noun: 7)
		else
			(self noun: 8)
		)
		(switch theVerb
			(4 ; Do
				(if (gEgo has: 9) ; Oxygen_Tank
					(gCurRoom setScript: returnTank)
				else
					(gCurRoom setScript: getTank)
				)
			)
			(25 ; Oxygen_Tank
				(gCurRoom setScript: returnTank)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theKey of View
	(properties
		x 83
		y 64
		sightAngle 360
		view 252
		loop 1
		cel 1
		priority 15
		signal 16
	)

	(method (show param1)
		(self y: [local5 param1] setLoop: param1 setCel: 0)
		(super show: &rest)
	)
)

(instance cDoorF of Feature
	(properties
		y 98
		nsTop 98
		nsBottom 125
		nsRight 8
		approachY 150
	)

	(method (init)
		(self approachVerbs: 4) ; Do
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: cStuff)
		else
			(gCurRoom doVerb: theVerb)
		)
	)
)

(instance console of Feature
	(properties
		x 274
		y 225
		z 50
		noun 9
		onMeCheck 2
		approachX 240
		approachY 170
		approachDist 2
	)

	(method (init)
		(self approachVerbs: 4 1) ; Do, Look
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sPopUpConsole)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cliffySuit of Feature
	(properties
		x 212
		y 117
		noun 2
		nsTop 95
		nsLeft 205
		nsBottom 139
		nsRight 220
		sightAngle 40
	)
)

(instance otherSuit of Feature
	(properties
		x 233
		y 117
		noun 6
		nsTop 95
		nsLeft 228
		nsBottom 139
		nsRight 239
		sightAngle 40
	)
)

(instance bayDoorsF of Feature
	(properties
		x 70
		y 110
		noun 1
		onMeCheck 16
	)
)

(instance turboLift of Feature
	(properties
		x 277
		y 104
		noun 4
		nsTop 60
		nsLeft 240
		nsBottom 148
		nsRight 315
		sightAngle 40
		approachX 285
		approachY 152
		approachDist 55
	)

	(method (init)
		(turboLift approachVerbs: 3 4) ; Walk, Do
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(if (not local4)
					(gCurRoom setScript: sExitNorth)
				)
			)
			(4 ; Do
				(if (not local4)
					(gCurRoom setScript: sExitNorth)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance popUpConsole of Inset
	(properties
		view 252
		x 60
		y 25
		disposeNotOnMe 1
	)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(theKey init: show: 1 stopUpd:)
		(= local0 1)
	)

	(method (doit)
		(if local1
			(if local0
				(gSq5Music2 number: 124 loop: 1 play:)
			)
			(= local1 0)
			(self setScript: sDoButton)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(theKey dispose:)
		(super dispose: &rest)
	)

	(method (handleEvent event &tmp temp0)
		(if (User controls:)
			(= temp0 (event message:))
			(cond
				((or (& (event type:) evKEYBOARD) (& (event type:) $0040)) ; direction
					(switch temp0
						(KEY_RETURN
							(= local1 1)
							(event claimed: 1)
							(return)
						)
						(KEY_ESCAPE
							(= local1 1)
							(= local0 0)
							(event claimed: 1)
							(return)
						)
						(JOY_DOWN
							(= local0 (if (>= local0 4) 1 else (++ local0)))
							(theKey show: local0)
							(gGame setCursor: 982 1 88 (+ [local5 local0] 5))
							(event claimed: 1)
							(return)
						)
						(JOY_UP
							(= local0 (if (<= local0 1) 4 else (-- local0)))
							(theKey show: local0)
							(gGame setCursor: 982 1 88 (+ [local5 local0] 5))
							(event claimed: 1)
							(return)
						)
						(else
							(super handleEvent: event &rest)
						)
					)
				)
				(
					(and
						(& (event type:) evMOUSEBUTTON)
						(!= (= local0 (localproc_1 event)) -1)
						(not (event modifiers:))
					)
					(gGame handsOff:)
					(theKey show: local0)
					(= local1 1)
					(event claimed: 1)
				)
				(else
					(super handleEvent: event &rest)
				)
			)
		else
			(super handleEvent: event &rest)
		)
	)
)

