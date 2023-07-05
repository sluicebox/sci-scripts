;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 802)
(include sci.sh)
(use Main)
(use n013)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Motion)
(use Actor)
(use System)

(public
	sHRoom2 0
	sDJKillGabe2 1
)

(instance sHRoom2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 800 0) ; Hounfour
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 257 137 211 117 81 117 45 137
							yourself:
						)
					okayToDie: 1
				)
				((ScriptID 800 2) doit: 830) ; xDrawThePic
				(if (not (GK script:))
					(gGkMusic1
						number: 260
						setLoop: -1
						stop:
						play:
						setVol: 0
						fade: (gGkMusic1 musicVolume:) 5 10 0
					)
				)
				(if (== ((ScriptID 800 1) room:) 802) ; xDJ
					((ScriptID 800 1) ; xDJ
						view: 830
						setCel: 0
						setLoop: 0
						init:
						actions: djActions
						setSpeed: 12
						setScript: sJohnChant
						noun: 3
						setCycle: Fwd
					)
				)
				(if (== ((ScriptID 800 1) room:) 802) ; xDJ
					(gWalkHandler add: pRoom)
				)
				(LoadMany rsVIEW 814 8141 831)
				(door1 init: setCel: 5)
				(machete init:)
				(keypad init:)
				(bed init:)
				(elephantSkull init:)
				(gorillaSkull init:)
				(offal init:)
				(wings init:)
				(bullSkull init:)
				(if (not (gEgo has: 80)) ; hounfourKey
					(hounfourKey init:)
				)
				(self setScript: sEnter)
				(gEgo
					normalize: 1
					posn: 230 126
					init:
					setMotion: MoveTo 215 126 script
				)
			)
			(1
				(if (== ((ScriptID 800 1) room:) 802) ; xDJ
					((ScriptID 800 1) setCycle: 0) ; xDJ
				)
				(if (gWalkHandler contains: pRoom)
					(gWalkHandler delete: pRoom)
				)
				(= cycles 1)
			)
			(2
				(if (not (GK script:))
					(gGkMusic1 fade:)
				)
				(self dispose:)
			)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(gGkSound1 number: 812 play:)
				(door1 setCycle: Beg self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDJKillGabe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 187 124 self)
				((ScriptID 800 1) ; xDJ
					setScript: 0
					setCel: 0
					setLoop: 2
					setCycle: End self
				)
			)
			(1 0)
			(2
				(gMessager say: 9 0 7 1 self 802) ; "Gabriel Knight! How dare you violate my sanctuary!"
				(Face gEgo (ScriptID 800 1) self) ; xDJ
			)
			(3 0)
			(4
				(= cycles 2)
			)
			(5
				(gMessager say: 9 0 7 2 self 802) ; "Is this your room? I'm so sorry."
			)
			(6
				((ScriptID 800 1) setCel: 0 setLoop: 3 setCycle: CT 5 1 self) ; xDJ
			)
			(7
				((ScriptID 800 1) setCel: 6) ; xDJ
				(gEgo hide:)
				(= cycles 2)
			)
			(8
				((ScriptID 800 1) ; xDJ
					posn: 187 124
					view: 814
					setSpeed: 8
					setCel: 0
					setLoop: 0
					setCycle: End self
				)
			)
			(9
				(gGkMusic1 number: 901 setLoop: 1 stop: play:)
				((ScriptID 800 1) ; xDJ
					view: 8141
					setCel: 0
					setLoop: 0
					setCycle: End self
				)
			)
			(10
				(gMessager say: 9 0 7 3 self 802) ; "You are so DEAD!"
			)
			(11
				(= seconds 3)
			)
			(12
				(gEgo show: posn: 0 0)
				((ScriptID 800 0) goToDeath: 802) ; Hounfour
				(client cue:)
				(self dispose:)
			)
		)
	)
)

(instance sDJKillGabe2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo normalize: setMotion: PolyPath 88 133 self)
			)
			(1
				(gGkSound1 number: 811 play:)
				(door1 setCycle: End self)
				(Face gEgo door1 self)
			)
			(2 0)
			(3
				(gGkSound1 number: 812 play:)
				(door1 setCycle: Beg)
				((ScriptID 800 1) ; xDJ
					view: 835
					setCel: 0
					setLoop: -1
					setCycle: StopWalk -1
					init:
					posn: 230 126
					setMotion: MoveTo 125 135 self
				)
			)
			(4
				(gMessager say: 9 0 11 1 self 802) ; "Gabriel Knight! So it was YOU on the drums!"
				(Face gEgo (ScriptID 800 1)) ; xDJ
			)
			(5
				(gMessager say: 9 0 11 2 self 802) ; "Who me? No, I was just looking around."
			)
			(6
				(gEgo hide:)
				((ScriptID 800 1) ; xDJ
					posn: 88 133
					view: 814
					setSpeed: 8
					setCel: 0
					setLoop: 1
					setCycle: End self
				)
			)
			(7
				(gGkMusic1 number: 901 setLoop: 1 stop: play:)
				((ScriptID 800 1) ; xDJ
					view: 8141
					setCel: 0
					setLoop: 1
					setCycle: End self
				)
			)
			(8
				(gMessager say: 9 0 11 3 self 802) ; "You will not escape death this time, Knight!"
			)
			(9
				(gEgo show: posn: 0 0)
				((ScriptID 800 0) goToDeath: 802) ; Hounfour
				(client cue:)
				(self dispose:)
			)
		)
	)
)

(instance sSneakToKeys of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 831
					setLoop: 0 1
					setCycle: Walk
					setMotion: MoveTo 82 135 self
				)
			)
			(1
				(gEgo
					view: 832
					posn: 73 132
					setCel: 0
					setLoop: 0
					setCycle: CT 4 1 self
				)
			)
			(2
				(hounfourKey dispose:)
				(gEgo setCel: 5 setCycle: End self)
			)
			(3
				(gEgo
					view: 831
					setLoop: 1 1
					posn: 99 135
					setCycle: Walk
					setMotion: MoveTo 167 135 self
				)
			)
			(4
				(gEgo setMotion: MoveTo 187 124 self)
			)
			(5
				(gEgo normalize: 0)
				(sHRoom2 setScript: sDJKillGabe)
			)
		)
	)
)

(instance sGetKeys of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 84 134 self)
			)
			(1
				(gEgo
					view: 832
					posn: 73 132
					setCel: 0
					setLoop: 0 1
					setCycle: CT 4 1 self
				)
			)
			(2
				(hounfourKey dispose:)
				(gEgo get: 80 setCycle: End self) ; hounfourKey
			)
			(3
				(gGame handsOn:)
				(gEgo getPoints: -999 2)
				(gEgo normalize: 0 posn: 92 134)
				(self dispose:)
			)
		)
	)
)

(instance sExitToHounfour of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gNarrator dispose:)
				(if (== ((ScriptID 800 1) room:) 802) ; xDJ
					((ScriptID 800 1) setScript: 0) ; xDJ
				)
				(gEgo setMotion: PolyPath 219 126 self)
			)
			(1
				(gEgo view: 801 setCel: 0 setLoop: 0 setCycle: CT 3 1 self)
			)
			(2
				(gEgo setCel: 4 setCycle: End self)
				(gGkSound1 setLoop: 1 number: 802 play:)
			)
			(3
				(door1 setCycle: End self)
				(gGkSound1 setLoop: 1 number: 811 play:)
			)
			(4
				(gEgo normalize: 0 setMotion: PolyPath 234 128 self)
			)
			(5
				(if (not (Random 0 2))
					(gEgo
						view: 802
						setSpeed: 12
						setCel: 0
						setLoop: 1
						setCycle: End self
					)
				else
					(= cycles 1)
				)
			)
			(6
				(gGame handsOn:)
				(client cue:)
			)
		)
	)
)

(instance sJohnChant of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(if (not (gTalkers size:))
					(gMessager say: 9 0 (Random 2 6) 0 self 802)
				else
					(-- state)
					(= seconds 1)
				)
			)
			(2
				(= seconds 5)
			)
			(3
				(if (not (gTalkers size:))
					(gMessager say: 9 0 (Random 2 6) 0 self 802)
				else
					(-- state)
					(= seconds 1)
				)
			)
			(4
				(= seconds 5)
			)
			(5
				(if (not (gTalkers size:))
					(gMessager say: 9 0 (Random 2 6) 0 self 802)
				else
					(-- state)
					(= seconds 1)
				)
			)
			(6
				(= seconds 5)
			)
			(7
				(if (not (gTalkers size:))
					(gMessager say: 9 0 (Random 2 6) 0 self 802)
				else
					(-- state)
					(= seconds 1)
				)
			)
			(8
				(= seconds 5)
			)
			(9
				(if (not (sHRoom2 script:))
					(sHRoom2 setScript: sDJKillGabe)
					(self dispose:)
				else
					(self changeState: 0)
				)
			)
		)
	)
)

(instance sTalkToJohn of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 3 11 0 0 self 802) ; "Do you really think that would be wise?"
			)
			(1
				(client setScript: sDJKillGabe)
			)
		)
	)
)

(instance djActions of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Operate
				(sHRoom2 setScript: sDJKillGabe)
				(return 1)
			)
			(else
				(return 0)
			)
		)
	)
)

(instance door1 of Prop
	(properties
		noun 4
		modNum 800
		x 248
		y 129
		priority 1
		fixPriority 1
		view 833
		signal 16417
	)
)

(instance keypad of Feature
	(properties
		noun 20
		modNum 800
		nsLeft 227
		nsTop 81
		nsRight 235
		nsBottom 92
		sightAngle 40
		approachX 232
		approachY 86
		x 231
		y 130
		z 38
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Operate
				(sHRoom2 setScript: sExitToHounfour)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pRoom of Feature
	(properties
		nsRight 319
		nsBottom 199
		x 231
		y 30
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(sHRoom2 setScript: sDJKillGabe)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hounfourKey of View
	(properties
		noun 4
		modNum 802
		x 49
		y 78
		view 830
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; Pickup
				(if (== ((ScriptID 800 1) room:) 802) ; xDJ
					(sHRoom2 setScript: sSneakToKeys)
				else
					(sHRoom2 setScript: sGetKeys)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bed of Feature
	(properties
		noun 1
		modNum 802
		sightAngle 20
		x 80
		y 130
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 69 122 71 124 136 126 131 132 48 131 45 127 65 120
					yourself:
				)
		)
		(super init:)
	)
)

(instance bullSkull of Feature
	(properties
		noun 6
		modNum 802
		sightAngle 20
		x 145
		y 72
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 141 84 137 69 124 64 144 68 164 65 150 71 146 84
					yourself:
				)
		)
		(super init:)
	)
)

(instance machete of Feature
	(properties
		noun 10
		modNum 802
		sightAngle 20
		x 266
		y 137
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 274 100 274 96 265 87 262 79 263 76 281 99
					yourself:
				)
		)
		(super init:)
	)
)

(instance elephantSkull of Feature
	(properties
		noun 5
		modNum 802
		sightAngle 20
		x 145
		y 104
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 121 114 129 112 133 102 123 93 144 84 155 87 170 93 159 100 157 106 164 114 171 108 168 117 117 117 118 108
					yourself:
				)
		)
		(super init:)
	)
)

(instance gorillaSkull of Feature
	(properties
		noun 7
		modNum 802
		sightAngle 20
		x 145
		y 63
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 148 55 151 66 144 67 139 65 141 55
					yourself:
				)
		)
		(super init:)
	)
)

(instance offal of Feature
	(properties
		noun 8
		modNum 802
		sightAngle 20
		x 145
		y 103
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 205 107 208 111 200 114 200 119 184 121 176 117 78 117 85 106
					yourself:
				)
		)
		(super init:)
	)
)

(instance wings of Feature
	(properties
		noun 2
		modNum 802
		sightAngle 20
		x 145
		y 102
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 155 55 176 60 152 65 150 58
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 140 64 127 60 111 60 133 53 141 59
					yourself:
				)
		)
		(super init:)
	)
)

