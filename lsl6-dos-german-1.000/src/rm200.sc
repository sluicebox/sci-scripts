;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 200)
(include sci.sh)
(use Main)
(use n079)
(use LarryRoom)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm200 0
	rideTram 1
)

(local
	local0 = 1
	[local1 2]
	local3 = 5
	local4 = -1
	local5
	local6
	local7
)

(instance rm200 of LarryRoom
	(properties
		noun 12
		picture 200
		horizon 0
		showControls 1
	)

	(method (init)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 116 267 116 253 106 256 99 246 104 214 96 198 96 198 92 121 92 121 96 84 96 67 96 72 112 0 112
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 117 23 117 39 186 283 186 292 122 319 122 319 189 0 189
					yourself:
				)
		)
		(gGame handsOff:)
		(if (not (IsFlag 35))
			(gEgo normalize: 900 init: ignoreActors: 0)
		)
		(if (IsFlag 187)
			(= global171 10)
			(SetFlag 20)
			(SetFlag 183)
		)
		(if (OneOf global171 1 2 9)
			(gammie init: approachVerbs: 4 1 2 5 6 7) ; Do, Look, Talk, Take, Zipper, roomkey
		)
		(switch gPrevRoomNum
			(600
				(self setScript: downStairsScr)
			)
			(300
				(self style: 12)
				(if (not (IsFlag 35))
					(self setScript: enterThruLeftDoor)
				)
			)
			(500
				(self style: 11)
				(if (not (IsFlag 35))
					(self setScript: enterThruRightDoor)
				)
			)
			(210
				(gEgo
					x: (gammie approachX:)
					y: (gammie approachY:)
					heading: 315
					cel: 7
				)
				(if (== global171 2)
					(gammie setScript: gammieLeavesScr)
				else
					(gGame handsOn:)
				)
			)
			(800
				(if (not global180)
					(= global180 157)
				)
				(gEgo x: global180 y: 190 loop: 8 cel: 3 heading: 180)
				(self setScript: enterFrom800Scr)
			)
			(else
				(gEgo posn: 157 137 loop: 8 cel: 3)
				(gGame handsOn:)
			)
		)
		(if (IsFlag 35)
			(if (IsFlag 36)
				((ScriptID 825 1) z: 0 view: 90 posn: 0 126 init:) ; tram
			else
				((ScriptID 825 1) z: 0 view: 90 posn: 319 126 init:) ; tram
			)
			((ScriptID 825 2) play: setLoop: -1) ; tramSoundFx
			(self setScript: rideTram)
		)
		(fKeyBox init: approachVerbs: 4 2 5 6) ; Do, Talk, Take, Zipper
		(fCounterTop init: approachVerbs: 4 2 5 6) ; Do, Talk, Take, Zipper
		(if
			(or
				(not (gGlobalSound2 handle:))
				(not (OneOf gPrevRoomNum 210 300 500 600))
			)
			(gGlobalSound2 number: 200 loop: -1 play:)
			(gGlobalSound1 number: 0 stop:)
		)
		(ashTray init: approachVerbs: 4 2 5 6 7) ; Do, Talk, Take, Zipper, roomkey
		(leftChand init:)
		(rightChand init:)
		(theSign init:)
		(leftPlant init: approachVerbs: 4 5) ; Do, Take
		(rightPlant init: approachVerbs: 4 5) ; Do, Take
		(stairs init:)
		(carpet init:)
		(leftDoorway init:)
		(rightDoorway init:)
		(gammiesDoor init: approachVerbs: 4 2 5 6 stopUpd:) ; Do, Talk, Take, Zipper
		(super init: &rest)
	)

	(method (doit &tmp [temp0 21])
		(cond
			(script)
			((gEgo inRect: 251 93 268 106)
				(self setScript: upStairsScr)
			)
			((gEgo inRect: 0 99 5 122)
				(self setScript: exitThruLeftDoorScr)
			)
			((gEgo inRect: 309 95 319 138)
				(self setScript: exitThruRightDoorScr)
			)
			((== (gEgo edgeHit:) EDGE_BOTTOM)
				(self setScript: exitSouthScr)
			)
		)
		(super doit: &rest)
	)

	(method (newRoom newRoomNumber)
		(stenchTimer dispose: delete:)
		(if (and (== global171 2) (!= newRoomNumber 300))
			(= global171 7)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance gammie of Actor
	(properties
		x 163
		y 67
		noun 3
		approachX 184
		approachY 96
		view 202
		loop 1
		priority 3
		signal 26640
	)

	(method (cue)
		(self setCel: 0)
		(= local0 1)
		(super cue:)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			(script)
			((and local0 (== (Random 0 80) 4))
				(self setLoop: (Random 0 2))
				(= local0 0)
				(gammie setCycle: End gammie)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(cond
					((IsFlag 35)
						(gMessager say: 3 2 11) ; "Hi, babe! It's me, Larry!"
					)
					((not script)
						(= global189 2)
						(gCurRoom setScript: talkToGammieScr)
					)
					(else
						(Face gEgo gammie)
						(gMessager say: 3 2 2) ; "(LARRY MUSES) (Whoa! Baby! Welcome to Cellulite City!)"
					)
				)
			)
			(6 ; Zipper
				(gCurRoom setScript: zipperScr)
			)
			(1 ; Look
				(cond
					((and (not (gEgo has: 22)) (IsFlag 35)) ; roomkey
						(gMessager say: 3 1 11) ; "That's the same woman who was behind the reception desk when you arrived here at La Costa Lotta."
					)
					((IsFlag 35)
						(gMessager say: 3 1 10) ; "Gammie is still hard at work, behind the reception desk."
					)
					((not script)
						(= global189 1)
						(gCurRoom setScript: lookAtGammieScr)
					)
					(else
						(Face gEgo gammie)
						(gMessager say: 3 1 2) ; "Gammie's hips look like two pigs in a gunny sack!"
					)
				)
			)
			(7 ; roomkey
				(if (== global171 9)
					(gMessager say: 4 7 0 0 0 210) ; "I don't need your room key. Remember: my master key lets me into any room at any time!"
				else
					(SetFlag 56)
					(gGlobalSound2 fade: 90 10 10 0)
					(gEgo cel: 7 heading: 315)
					(gCurRoom newRoom: 210)
				)
			)
			(51 ; randomKey
				(gMessager say: 4 51 0 0 0 210) ; "Thank you for returning that lost key. Just deposit it in the box over there. I'll get to it later."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ashTray of Feature
	(properties
		x 230
		y 87
		noun 16
		sightAngle 10
		approachX 217
		approachY 100
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 223 78 236 78 236 97 223 97
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 6) ; Zipper
			(gCurRoom setScript: pissInAshTray)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fKeyBox of Feature
	(properties
		x 91
		y 79
		noun 4
		sightAngle 10
		approachX 85
		approachY 92
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:) type: PTotalAccess init: 83 73 97 73 97 92 83 92 yourself:)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 5 6) ; Do, Take, Zipper
			(gCurRoom setScript: keyScript 0 theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fCounterTop of Feature
	(properties
		x 118
		y 69
		noun 14
		sightAngle 10
		approachX 139
		approachY 92
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 216 67 223 69 224 73 217 77 104 77 100 75 98 70 104 67
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 4) (gCast contains: gammie)) ; Do
			(gMessager say: 14 4 12) ; "You COULD rap on the counter, but what good would that do? The receptionist is right in front of you!"
		else
			(super doVerb: theVerb)
		)
	)
)

(instance leftChand of Feature
	(properties
		noun 5
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 103 0 111 3 114 10 106 20 90 21 80 12 80 3 86 0
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (and (== global100 2) (not (-- local3)) (== theVerb 4)) ; Do
			(gGame changeScore: 10 183)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance rightChand of Feature
	(properties
		noun 11
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 235 0 245 1 243 11 233 19 219 20 210 13 210 4 220 0
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (and (gCast contains: gammie) (== theVerb 2)) ; Talk
			(gMessager say: 11 2 12) ; "You are my sunshine... my only sunshine..."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance gammiesDoor of Prop
	(properties
		x 53
		y 92
		noun 2
		approachX 68
		approachY 97
		view 200
		priority 3
		signal 18448
	)
)

(instance leftDoorway of Feature
	(properties
		noun 6
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 16 89 18 61 26 47 39 42 46 44 49 51 45 74 46 101 39 102 39 94 34 92 28 94 27 100 23 94 25 91 21 88
					yourself:
				)
		)
		(super init:)
	)
)

(instance rightDoorway of Feature
	(properties
		noun 7
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 272 52 275 43 292 45 304 63 304 87 297 89 294 98 289 91 284 91 281 95 282 102 282 105 272 105 273 102
					yourself:
				)
		)
		(super init:)
	)
)

(instance carpet of Feature
	(properties
		noun 1
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 23 138 39 121 37 111 40 105 54 104 60 97 54 94 54 89 75 83 103 85 113 88 117 82 202 84 203 89 217 90 220 87 244 93 273 106 283 105 283 112 278 118 282 129 284 136 294 138
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 5) ; Do, Take
			(gCurRoom setScript: carpetScr 0 theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance theSign of Feature
	(properties
		noun 15
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 146 24 178 24 236 45 235 52 230 57 173 42 149 41 97 54 91 54 91 44
					yourself:
				)
		)
		(super init:)
	)
)

(instance rightPlant of Feature
	(properties
		x 314
		y 135
		noun 13
		sightAngle 10
		approachX 293
		approachY 136
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 319 139 296 139 291 135 287 137 283 136 285 124 280 128 279 118 282 113 281 100 280 97 286 92 291 93 293 99 296 98 296 93 300 88 319 88
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 5) (gCast contains: gammie)) ; Take
			(gMessager say: 13 5 12) ; "Oops, there goes another rubber tree plant!"
		else
			(super doVerb: theVerb)
		)
	)
)

(instance stairs of Feature
	(properties
		noun 10
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 267 88 266 104 242 92 240 77 259 64
					yourself:
				)
		)
		(super init:)
	)
)

(instance leftPlant of Feature
	(properties
		x 3
		y 135
		noun 9
		sightAngle 10
		approachX 25
		approachY 134
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 0 86 4 91 9 88 18 89 24 89 24 93 25 98 27 102 27 96 29 93 35 92 39 96 38 105 40 126 33 122 37 136 33 136 26 130 26 137 23 137 22 139 4 138 1 134 5 129 2 126 0 130
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 5) (gCast contains: gammie)) ; Take
			(gMessager say: 9 5 12) ; "You can't take that. It's part of the advertised scenery."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance rideTram of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheIconBar
					disable:
						(ScriptID 0 3) ; icon0
						(ScriptID 0 5) ; icon2
						(ScriptID 0 6) ; icon3
						(ScriptID 0 9) ; icon6
					enable: (ScriptID 0 7) (ScriptID 0 4) ; icon4, icon1
				)
				(if (OneOf global166 (ScriptID 0 4) (ScriptID 0 7)) ; icon1, icon4
					(gTheIconBar curIcon: global166)
				else
					(gTheIconBar curIcon: (ScriptID 0 7)) ; icon4
				)
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
				(User canInput: 1 canControl: 1)
				(if (IsFlag 36)
					((ScriptID 825 1) ; tram
						setCycle: Walk
						setMotion: MoveTo 319 126 self
					)
				else
					((ScriptID 825 1) ; tram
						setCycle: Walk
						setMotion: MoveTo 0 126 self
					)
				)
			)
			(1
				(DisposeScript 826)
				(if (IsFlag 36)
					(gCurRoom newRoom: 500)
				else
					(gCurRoom newRoom: 300)
				)
			)
		)
	)
)

(instance carpetScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (< (gEgo heading:) 181)
					(gEgo setHeading: 45 self)
				else
					(gEgo setHeading: 270 self)
				)
			)
			(1
				(= cycles 2)
			)
			(2
				(gEgo
					view: 901
					setLoop: (if (== (gEgo heading:) 45) 4 else 5)
					cel: 0
					setCycle: 0
				)
				(= cycles 2)
			)
			(3
				(gEgo setCycle: CT 3 1 self)
			)
			(4
				(= ticks 30)
			)
			(5
				(gMessager say: 1 register 0 0 self)
			)
			(6
				(gEgo setCycle: Beg self)
			)
			(7
				(gEgo normalize: 900 ignoreActors: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance exitSouthScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo (gEgo x:) 190 self)
				(gGlobalSound2 fade: 30 10 20 1 self)
			)
			(1)
			(2
				(= global180 (gEgo x:))
				(gGlobalSound1 number: 0 stop:)
				(gGlobalSound2 number: 0 stop:)
				(gCurRoom newRoom: 800)
			)
		)
	)
)

(instance enterFrom800Scr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: MoveTo global180 137 self)
			)
			(2
				(gGame handsOn:)
				(= global180 0)
				(self dispose:)
			)
		)
	)
)

(instance exitThruLeftDoorScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 0 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 300)
			)
		)
	)
)

(instance exitThruRightDoorScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 320 108 self)
			)
			(1
				(gCurRoom newRoom: 500)
			)
		)
	)
)

(instance enterThruLeftDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: 5 112 setMotion: MoveTo 50 112 self)
			)
			(1
				(gEgo normalize: 900 ignoreActors: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterThruRightDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 315 115 setMotion: MoveTo 275 115 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance gammieLeavesScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 0)
				(gammie
					view: 203
					x: 159
					y: 98
					setPri: 2
					setCycle: Fwd
					setLoop: 1
					setStep: 2 1
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 93 98 self
				)
				(= global171 2)
			)
			(1
				(gammie
					approachVerbs: 0
					x: 78
					y: 86
					setLoop: 4
					cel: 2
					setCycle: 0
				)
				(sfx number: 32 loop: 1 play:)
				(gammiesDoor setCycle: End self)
				(gEgo setMotion: MoveTo 133 103)
			)
			(2
				(gammie setLoop: 1 setCycle: Fwd setMotion: MoveTo 66 85 self)
			)
			(3
				(gammie setLoop: 4 setCycle: 0 cel: 2)
				(= ticks 10)
			)
			(4
				(gammie setLoop: 2 setCycle: Fwd setMotion: MoveTo 65 98 self)
			)
			(5
				(gammie setPri: -1 setLoop: 4 cel: 0 setCycle: 0)
				(= ticks 10)
			)
			(6
				(gammie setLoop: 4 cel: 3)
				(= ticks 10)
			)
			(7
				(gammiesDoor setCycle: Beg self)
			)
			(8
				(sfx number: 33 loop: 1 play:)
				(gammie setLoop: 4 cel: 0)
				(= ticks 10)
			)
			(9
				(gGame handsOn:)
				(gEgo ignoreActors: 0)
				(gammie
					setLoop: 0
					setCycle: Fwd
					setMotion: MoveTo 80 97 self
					ignoreActors: 0
				)
			)
			(10
				(gMessager say: 3 2 2 1) ; "(LARRY MUSES) (Whoa! Baby! Welcome to Cellulite City!)"
				(gammie setLoop: 2 setMotion: MoveTo 68 115 self)
			)
			(11
				(gammie setLoop: 1 setMotion: MoveTo -2 115 self)
				(= ticks 10)
			)
			(12
				(gMessager say: 3 2 2 2 self) ; "I'll be right behind you, Gammie!"
			)
			(13
				(gMessager say: 3 2 2 3) ; "(UNDER BREATH) (Assuming I can take it!)"
			)
			(14
				(gammie hide:)
				(= seconds 2)
			)
			(15
				(= global171 3)
				(= seconds 6)
			)
			(16
				(= global171 5)
				(= seconds 6)
			)
			(17
				(= global171 7)
				(client dispose:)
			)
		)
	)
)

(instance sfx of Sound
	(properties
		flags 1
	)
)

(instance pissInAshTray of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo loop: 8 cel: 6 heading: 45)
				(= ticks 30)
			)
			(1
				(gEgo
					view: 908
					setLoop: 0
					cel: 0
					cycleSpeed: 8
					setCycle: CT 3 1 self
				)
				(sfx setLoop: 1)
			)
			(2
				(sfx number: 35 loop: 1 play:)
				(gEgo setCycle: CT 6 1 self)
			)
			(3
				(gMessager say: 16 6 0 0 self) ; "It's an ashtray, fer gawdsakes!"
			)
			(4
				(gEgo normalize: 900 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance upStairsScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gEgo
					setLoop: 6
					setCycle: 0
					setCycle: Fwd
					setMotion: MoveTo 278 79 self
				)
				(gGlobalSound2 fade: 90 10 10 0)
			)
			(2
				(= ticks 30)
			)
			(3
				(gCurRoom newRoom: 600)
			)
		)
	)
)

(instance lookAtGammieScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo cel: 7 heading: 315)
				(= ticks 30)
			)
			(1
				(= register (gNarrator talkWidth:))
				(gNarrator x: 5 y: 10 talkWidth: 130)
				(if (not (IsFlag 93))
					(SetFlag 93)
					(gMessager say: 3 1 1 0 self) ; "The woman behind the front desk is a real knock-out! Although you can only see down to her waist, what you see is what you like."
				else
					(self cue:)
				)
			)
			(2
				(gGlobalSound2 fade: 90 10 10 0 self)
			)
			(3
				(gNarrator x: -1 y: -1 talkWidth: register)
				(gCurRoom newRoom: 210)
			)
		)
	)
)

(instance talkToGammieScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo cel: 7 heading: 315)
				(if (!= global171 9)
					(= register (gNarrator talkWidth:))
					(gNarrator x: 5 y: 10 talkWidth: 130)
				)
				(= ticks 30)
			)
			(1
				(if (not (IsFlag 93))
					(SetFlag 93)
					(gMessager say: 3 2 1 0 self) ; "The woman behind the front desk is a real knock-out! Although you can only see down to her waist, what you see is what you like."
				else
					(self cue:)
				)
			)
			(2
				(gGlobalSound2 fade: 90 10 10 0 self)
			)
			(3
				(gNarrator x: -1 y: -1 talkWidth: register)
				(gCurRoom newRoom: 210)
			)
		)
	)
)

(instance zipperScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 310 self)
			)
			(1
				(= cycles 2)
			)
			(2
				(gEgo
					view: 908
					setLoop: 1
					cel: 0
					cycleSpeed: 8
					setCycle: CT 3 1 self
				)
			)
			(3
				(sfx number: 35 loop: 1 play:)
				(gEgo setCycle: CT 6 1 self)
			)
			(4
				(if (not (gEgo has: 22)) ; roomkey
					(gMessager say: 3 6 7 0 self) ; "Please, Sir! Don't you have any other form of identification?"
				else
					(gMessager say: 3 6 0 0 self) ; "Please, Mr. Laffer! Your guest suite has a bathroom. Try using it!"
				)
			)
			(5
				(gEgo normalize: 900 7)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance stenchTimer of Timer
	(properties)

	(method (cue)
		(if (and (not (gCurRoom script:)) (not (gEgo script:)))
			(gMessager say: 0 0 3) ; "Peeeee-uuuuu! What's that horrible stench?!"
			(ClearFlag 55)
		)
	)
)

(instance downStairsScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 278 79)
				(= ticks 90)
			)
			(1
				(gGlobalSound2 fade: 127 10 10 0)
				(gEgo setLoop: 5 setMotion: MoveTo 243 106 self)
			)
			(2
				(gEgo normalize: 900 ignoreActors: 0)
				(if (and (IsFlag 55) (gCast contains: gammie))
					(stenchTimer setReal: stenchTimer 4)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance keyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local5 (gEgo cycleSpeed:))
				(gEgo loop: 8 cel: 6 heading: 45)
				(if (!= register 6)
					(= state 7)
				)
				(= cycles 2)
			)
			(1
				(gEgo
					view: 908
					setLoop: 0
					cel: 0
					cycleSpeed: 8
					setCycle: CT 3 1 self
				)
				(sfx setLoop: 1)
			)
			(2
				(sfx number: 35 loop: 1 play:)
				(gEgo setCycle: CT 6 1 self)
				(= local7 4)
			)
			(3
				(if local6
					(sfx number: 351 loop: 1 play:)
					(if (-- local7)
						(-- state)
					)
					(= ticks 60)
				else
					(pissingSfx number: 30 loop: -1 play:)
					(= seconds 4)
				)
			)
			(4
				(pissingSfx number: 0 stop:)
				(gMessager say: 4 6 0 0 self) ; "Whew! What a relief!"
			)
			(5
				(= local6 1)
				(gEgo setCycle: CT 3 -1 self)
			)
			(6
				(sfx number: 35 loop: 1 play:)
				(gEgo setCycle: Beg self)
			)
			(7
				(gEgo normalize: 900 6 ignoreActors: 0)
				(gGame handsOn:)
				(self dispose:)
			)
			(8
				(gEgo view: 201 cel: 0 setLoop: 0 setCycle: CT 4 1 self)
			)
			(9
				(= ticks 30)
			)
			(10
				(cond
					((!= register 5)
						(gMessager say: 4 register 0 0 self)
					)
					((not (IsFlag 161))
						(gEgo get: 21) ; randomKey
						(gGame changeScore: 2 161)
						(gMessager say: 4 5 8 0 self) ; "Rummaging around in this morning's room keys, you grab the one that feels the least sticky."
					)
					(else
						(gMessager say: 4 5 9 0 self) ; "Another key? What? Are you starting a collection?"
					)
				)
			)
			(11
				(gEgo setCycle: End self)
			)
			(12
				(gEgo normalize: 900 3 ignoreActors: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pissingSfx of Sound
	(properties
		flags 1
		loop -1
	)
)

