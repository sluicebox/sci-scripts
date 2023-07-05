;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 610)
(include sci.sh)
(use Main)
(use SQRoom)
(use ExitFeature)
(use Scaler)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm610 0
)

(local
	local0
)

(instance rm610 of SQRoom
	(properties
		noun 1
		picture 610
	)

	(method (init)
		(gGame handsOff:)
		(if (not global170)
			(= global170 1)
		)
		(if (or (IsFlag 126) (== global170 1))
			(self
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 1 104 1 137 317 137 317 74 286 70 269 78 248 75 250 81 229 89 204 89 190 84 191 77 186 71 143 77 86 87 74 98 52 98 42 93
						yourself:
					)
					((Polygon new:)
						type: PTotalAccess
						init: 74 122 93 119 111 122 117 127 114 133 106 136 55 136 62 126
						yourself:
					)
			)
		else
			(self
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 1 104 1 137 317 137 317 74 272 74 249 85 220 94 201 97 180 96 164 89 165 82 173 76 177 72 143 77 86 87 74 98 52 98 42 93
						yourself:
					)
					((Polygon new:)
						type: PTotalAccess
						init: 74 122 93 119 111 122 117 127 114 133 106 136 55 136 62 126
						yourself:
					)
			)
		)
		(super init: &rest)
		(floor init:)
		(sausage init:)
		(ballThing init:)
		(ulcer init:)
		(exit620 init: gTheExitSCursor approachVerbs: 10) ; ExitDown
		(cond
			((== gPrevRoomNum 620)
				(gEgo init: setScript: egoClimbsOut)
				(shipDoor init: approachVerbs: 1 4) ; Look, Do
				(if (IsFlag 126)
					(shuttle view: 611 init: ignoreActors: 1 approachVerbs: 4) ; Do
					(fuelTank3 init: approachVerbs: 1 4 134) ; Look, Do, Silver_Chunk
					(if (and (not (gEgo has: 3)) (not (IsFlag 162))) ; Alveoli
						(alveoli init: approachVerbs: 4 ignoreActors: 1) ; Do
					)
					(if
						(and
							(not (or (gEgo has: 99) (gEgo has: 4))) ; Separated_Caps, Attach_Caps
							(not (IsFlag 161))
						)
						(capillaries init: approachVerbs: 1 4 ignoreActors: 1) ; Look, Do
					)
					(if (IsFlag 128)
						(fuelLight3
							loop: 3
							cel: 1
							init:
							setPri: (+ (shuttle priority:) 1)
							approachVerbs: 1 4 ; Look, Do
							ignoreActors: 1
						)
					else
						(fuelLight3
							init:
							setPri: (+ (shuttle priority:) 1)
							setCycle: Fwd
							approachVerbs: 1 4 ; Look, Do
							ignoreActors: 1
						)
						(alarm play:)
					)
					(gGame handsOn:)
				else
					(shuttle view: 614 loop: 0)
					(shuttle
						cel: (shuttle lastCel:)
						posn: 235 77
						init:
						approachVerbs: 4 ; Do
					)
					(gGame handsOn:)
				)
			)
			((== global170 1)
				(shuttle init: setScript: shuttleCrashes)
			)
			((== global170 2)
				(Load 140 612) ; WAVE
				(shuttle
					view: 614
					loop: 0
					cel: 0
					z: 0
					posn: 235 47
					init:
					approachVerbs: 4 ; Do
					setScript: shuttleLands
				)
			)
			((== global170 3)
				(Load 140 614) ; WAVE
				(if (IsFlag 203)
					(shuttle
						view: 6140
						loop: 0
						cel: 0
						posn: 219 72
						init:
						setScript: shuttleExitsSafe
					)
				else
					(shuttle
						view: 613
						loop: 0
						cel: 0
						posn: 219 72
						init:
						setScript: shuttleExits
					)
				)
			)
			((== global170 4)
				(shipDoor init: approachVerbs: 1 4) ; Look, Do
				(if (IsFlag 126)
					(gEgo
						init:
						normalize:
						posn: 250 78
						setScaler: Scaler 71 22 131 66
					)
					(shuttle view: 611 init: approachVerbs: 4 ignoreActors: 1) ; Do
					(fuelTank3 init: approachVerbs: 1 4 134) ; Look, Do, Silver_Chunk
					(if (and (not (gEgo has: 3)) (not (IsFlag 162))) ; Alveoli
						(alveoli init: approachVerbs: 4 ignoreActors: 1) ; Do
					)
					(if
						(and
							(not (or (gEgo has: 99) (gEgo has: 4))) ; Separated_Caps, Attach_Caps
							(not (IsFlag 161))
						)
						(capillaries init: approachVerbs: 1 4 ignoreActors: 1) ; Look, Do
					)
					(if (IsFlag 128)
						(fuelLight3
							loop: 3
							cel: 1
							init:
							setPri: (+ (shuttle priority:) 1)
							approachVerbs: 1 4 ; Look, Do
							ignoreActors: 1
						)
					else
						(fuelLight3
							init:
							setPri: (+ (shuttle priority:) 1)
							setCycle: Fwd
							approachVerbs: 1 4 ; Look, Do
							ignoreActors: 1
						)
						(alarm play:)
					)
					(gGame handsOn:)
				else
					(gEgo
						init:
						normalize:
						posn: 236 94
						setScaler: Scaler 71 22 131 66
					)
					(shuttle view: 614 loop: 0)
					(shuttle
						cel: (shuttle lastCel:)
						posn: 235 77
						approachVerbs: 4 ; Do
						approachX: 185
						approachY: 95
						init:
					)
					(gGame handsOn:)
				)
			)
			(else 0)
		)
		(if (!= gPrevRoomNum 495)
			(gGSound1 number: 610 setLoop: -1 play: setVol: 127)
		)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 1) (not (IsFlag 199))) ; Look
			(SetFlag 199)
			(gMessager say: noun theVerb 1 0)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (newRoom newRoomNumber)
		(RemapColors 0) ; Off
		(FrameOut)
		(super newRoom: newRoomNumber &rest)
	)

	(method (dispose)
		(gGSound1 fade: 0 5 5 1)
		(gEgo setScale: 0)
		(alarm stop:)
		(super dispose: &rest)
	)
)

(instance shuttleCrashes of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(RemapColors 2 244 75) ; ByPercent
				(gGSound2 number: 612 loop: 0 play: setVol: 127)
				(client setCycle: End self)
			)
			(2
				(gGSound2 stop:)
				(fuelLight3
					init:
					setPri: (+ (client priority:) 1)
					setCycle: Fwd
				)
				(alarm play:)
				(= ticks 210)
			)
			(3
				(SetFlag 126)
				(= global170 4)
				(= global148 610)
				(gCurRoom newRoom: 490)
			)
		)
	)
)

(instance shuttleLands of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(RemapColors 2 244 75) ; ByPercent
				(gGSound2 number: 612 loop: 0 play: setVol: 127)
				(= ticks 30)
			)
			(2
				(client setSpeed: 6 setCycle: End self)
			)
			(3
				(if (gGSound2 handle:)
					(gGSound2 fade: 0 5 5 1)
				)
				(= ticks 60)
			)
			(4
				(= global148 610)
				(gCurRoom newRoom: 490)
			)
		)
	)
)

(instance shuttleExits of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(RemapColors 2 244 75) ; ByPercent
				(client setCycle: CT 8 1 self)
			)
			(2
				(gGSound2 number: 614 loop: 0 play: setVol: 127)
				(client setCycle: End self)
			)
			(3
				(SetFlag 203)
				(gCurRoom newRoom: 740)
			)
		)
	)
)

(instance shuttleExitsSafe of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(RemapColors 2 244 75) ; ByPercent
				(gGSound2 number: 614 loop: 0 play: setVol: 127)
				(client setCycle: CT 38 1 self)
			)
			(2
				(client setCycle: End)
				(proc0_7 1 1 self)
			)
			(3
				(gCurRoom exitStyle: 0 newRoom: 740)
			)
		)
	)
)

(instance getHumanParts of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(client
					view: 612
					loop: (register loopToUse:)
					cel: 0
					setScale: 0
					setCycle: End self
				)
			)
			(1
				(register hide: dispose:)
				(= cycles 2)
			)
			(2
				(client
					get: (register invItem:)
					normalize: (register dirToFace:)
					setScaler: Scaler 71 22 131 66
				)
				(if (!= (register flagToSet:) -1)
					(SetFlag (register flagToSet:))
				)
				(if (!= (register pFlagToSet:) -1)
					(gGame
						points: (register pointsToSet:) (register pFlagToSet:)
					)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance blowChunks of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(client
					view: 615
					loop: 0
					cel: 0
					x: (- (gEgo x:) 4)
					setScale: 0
					setCycle: End self
				)
			)
			(1
				(fuelLight3 loop: 3 cel: 1 setCycle: 0)
				(alarm stop:)
				(= cycles 2)
			)
			(2
				(client
					put: 102 ; Silver_Chunk
					x: (+ (gEgo x:) 4)
					normalize: 3
					setScaler: Scaler 71 22 131 66
				)
				(SetFlag 128)
				(gGame points: 5 499)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance egoClimbsOut of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(client
					view: 616
					loop: 1
					cel: 0
					posn: 90 125
					setSpeed: 8
					setCycle: CT 4 1 self
				)
			)
			(1
				(gGSound2 stop:)
				(client setCycle: End self)
			)
			(2
				(client
					posn: 89 129
					normalize: 6
					setScaler: Scaler 71 22 131 66
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance egoClimbsIn of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 255) ; WAVE
				(client setHeading: 135 self)
			)
			(1
				(gGSound2 number: 255 setLoop: -1 play: setVol: 127)
				(client
					view: 616
					loop: 0
					cel: 0
					posn: 73 134
					setSpeed: 8
					setScale: 0
					setCycle: End self
				)
			)
			(2
				(gCurRoom newRoom: 620)
			)
		)
	)
)

(instance dropTile of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 613) ; WAVE
				(gMessager say: 6 4 0 1 self) ; "This heat tile looks loose."
			)
			(1
				(gGSound2 number: 613 loop: 0 play: setVol: 127)
				(= ticks 50)
			)
			(2
				(gMessager say: 6 4 0 3 self) ; "Whoops, I have to stop doing that."
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance shuttle of Actor
	(properties
		noun 6
		sightAngle 40
		approachX 233
		approachY 89
		x 219
		y 72
		z 30
		view 610
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not script)
					(self setScript: dropTile)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fuelLight3 of Prop
	(properties
		noun 13
		approachX 252
		approachY 78
		x 219
		y 77
		z 35
		view 611
		loop 1
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 128)
					(gMessager say: noun theVerb 9 0) ; "The reassuring green indicates, "Yes! I am ready to rock and roll!""
				else
					(gMessager say: noun theVerb 10 0) ; "Red light. Hmmmm, this is not good. Apparently some or all of the intermix element in Fuel Tank 3 was disgorged during your heinous veinous joyride."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(class HumanParts of View
	(properties
		invItem 0
		flagToSet -1
		loopToUse -1
		dirToFace -1
		pFlagToSet -1
		pointsToSet 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo setScript: getHumanParts 0 self)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance alveoli of HumanParts
	(properties
		noun 14
		sightAngle 40
		approachX 221
		approachY 89
		x 216
		y 79
		view 611
		loop 2
		invItem 3
		flagToSet 162
		loopToUse 0
		dirToFace 7
		pFlagToSet 498
		pointsToSet 3
	)
)

(instance capillaries of HumanParts
	(properties
		noun 15
		sightAngle 40
		approachX 274
		approachY 81
		x 270
		y 64
		view 611
		loop 2
		cel 1
		invItem 99
		flagToSet 161
		loopToUse 1
		dirToFace 7
		pFlagToSet 497
		pointsToSet 3
	)
)

(instance shipDoor of Feature
	(properties
		noun 7
		sightAngle 40
		approachX 245
		approachY 80
		x 230
		y 73
		z 10
	)

	(method (init)
		(if (IsFlag 126)
			(self
				setPolygon:
					((Polygon new:)
						type: PTotalAccess
						init: 222 62 229 57 236 60 239 66 231 70 227 63
						yourself:
					)
			)
		else
			(self
				setPolygon:
					((Polygon new:)
						type: PTotalAccess
						init: 218 64 227 61 234 69 235 75 227 78 225 71
						yourself:
					)
			)
			(= z 20)
			(= y 83)
			(= approachX 231)
			(= approachY 87)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= global148 610)
				(gCurRoom newRoom: 480)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance floor of Feature
	(properties
		noun 3
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 100 12 95 48 85 100 78 136 72 149 72 195 67 207 68 235 67 250 64 271 66 279 65 284 65 300 66 320 68 320 139 0 139
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance sausage of Feature
	(properties
		noun 4
		sightAngle 40
		x 126
		y 65
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 51 14 61 44 73 63 77 55 92 67 93 67 78 84 81 134 72 159 71 226 65 275 65 271 53 260 44 246 40 221 40 198 41 178 45 158 42 154 43 120 34 94 23 104 17 112 5 113 0 0 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance ballThing of Feature
	(properties
		noun 2
		sightAngle 40
		x 299
		y 65
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 290 4 280 13 271 28 267 42 267 52 272 65 320 67 320 0 303 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance fuelTank3 of Feature
	(properties
		noun 10
		sightAngle 40
		approachX 256
		approachY 64
		x 256
		y 74
		z 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 257 60 252 64 255 68 261 62
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 128)
					(gMessager say: noun 4 9 0) ; "Good boy! Now leave the pretty shuttle tanks alone. They're all happy now."
				else
					(gMessager say: noun 4 5 0) ; "The third fuel tank is as closed as it can get, considering the damage you've done to it."
				)
			)
			(134 ; Silver_Chunk
				(if (IsFlag 128)
					(gMessager say: noun 1 6 0) ; "She's all topped off."
				else
					(gEgo setScript: blowChunks)
				)
			)
			(1 ; Look
				(cond
					((and (IsFlag 128) (not local0))
						(gMessager say: noun theVerb 7 0) ; "She's filled up with what passes for silver in these here parts, and she's sealed up and ready to go."
						(++ local0)
					)
					((and (IsFlag 128) local0)
						(gMessager say: noun theVerb 8 0) ; "Thanks to your sophisticated futuristic garbage picking, this tank is full and sealed."
					)
					(else
						(gMessager say: noun theVerb 4 0) ; "Uh-oh. This tank's cover must've come open during Mr. Wilco's Wild Ride."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ulcer of Feature
	(properties
		noun 5
		sightAngle 40
		x 84
		y 134
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 68 138 103 135 107 126 89 122 78 124 62 127 59 135
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance exit620 of ExitFeature
	(properties
		noun 5
		sightAngle 40
		approachX 88
		approachY 132
		x 84
		y 134
		z -10
		nextRoom 620
		message 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 68 138 103 135 107 126 89 122 78 124 62 127 59 135
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb message)
			(gEgo setScript: egoClimbsIn)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance alarm of Sound
	(properties
		flags 1
		number 611
		loop -1
	)
)

