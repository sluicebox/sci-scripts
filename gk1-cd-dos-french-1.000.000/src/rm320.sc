;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 320)
(include sci.sh)
(use Main)
(use n013)
(use ExitFeature)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Grooper)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm320 0
)

(local
	local0
)

(instance rm320 of Room
	(properties
		modNum 301
		noun 1
		picture 320
		style 14
		exitStyle 13
	)

	(method (init)
		(Load rsMESSAGE 320)
		(super init:)
		(gWalkHandler add: eastExit)
		(gGkMusic1 setVol: (gGkMusic1 musicVolume:))
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 142 123 168 123 161 131 125 129
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 257 125 269 127 260 138 233 136 245 125
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 183 110 259 112 267 118 268 123 142 120 153 114
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 296 145 296 124 285 118 278 118 259 109 178 106 163 93 160 82 142 86 99 85 24 102 102 115 45 129 0 129 0 145 15 145 61 133 135 139 129 145
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 97 92 146 93 132 107 81 107
					yourself:
				)
		)
		(vaseL init:)
		(vaseR init:)
		(swordTomb init:)
		(fallenAngel init: approachVerbs: 7) ; Look
		(standingAngel init: approachVerbs: 7) ; Look
		(geddeTomb init: approachVerbs: 7) ; Look
		(tomb1 init: approachVerbs: 7) ; Look
		(tomb2 init: approachVerbs: 7) ; Look
		(tomb3 init: approachVerbs: 7) ; Look
		(tomb4 init: approachVerbs: 7) ; Look
		(tombDoors init: approachVerbs: 7) ; Look
		(westExit init:)
		(eastExit init: approachVerbs: 13) ; Walk
		(flap setCel: (if (and (IsFlag 176) (>= gDay 7)) 0 else 1) init:)
		(switch gPrevRoomNum
			(310
				(if (and (== gDay 3) (not (IsFlag 265)))
					(self setScript: sCartoon)
				else
					(self setScript: sEnterFromWest)
				)
			)
			(else
				(self setScript: sFromTomb)
				(gGkMusic1
					number: 300
					setLoop: -1
					play:
					setVol: 0
					fade: (gGkMusic1 musicVolume:) 5 10 0
				)
			)
		)
	)

	(method (dispose)
		(DisposeScript 21)
		(if (gWalkHandler contains: maliaWalk)
			(gWalkHandler delete: maliaWalk)
		)
		(gWalkHandler delete: eastExit)
		(super dispose:)
	)
)

(instance sEnterFromWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					normalize: 0
					init:
					posn: -10 135
					state: 2
					setMotion: MoveTo 25 130 self
				)
			)
			(1
				(gCurRoom west: 310)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSwitchFlap of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 207 115 self)
			)
			(1
				(Face gEgo 207 110 self)
			)
			(2
				(if (or (== register 8) (== register 9) (== register 6))
					(gEgo
						view: 322
						setCel: 0
						setLoop:
							(if (and (IsFlag 176) (>= gDay 7)) 0 else 1)
						setSpeed: 12
						setCycle: End self
					)
				else
					(= cycles 1)
				)
			)
			(3
				(if (not (OneOf register 8 6 12 10 11 9 7 13))
					(if (and (IsFlag 176) (>= gDay 7))
						(gMessager say: 11 0 2 0 self) ; "There's no reason to use that on the open plate."
					else
						(switch register
							(44
								(gMessager say: 11 register 1 0 self) ; "That key doesn't fit the lock on the plate."
							)
							(76
								(gMessager say: 11 register 1 0 self) ; "That key doesn't fit the lock on the plate."
							)
							(else
								(gMessager say: 11 0 1 0 self) ; "That doesn't work on the locked plate."
							)
						)
					)
				else
					(switch register
						(8
							(cond
								(
									(and
										(IsFlag 176)
										(>= gDay 7)
										(not (IsFlag 362))
									)
									(gEgo getPoints: 165 2)
									(gGkSound1 setLoop: 1 number: 307 play:)
									(gMessager say: 11 8 6 0 self) ; "Gabriel hears the faint sound of breaking glass."
									(gGkSound1 setLoop: 1 number: 307 play:)
									(= local0 1)
								)
								((and (>= gDay 7) (IsFlag 362))
									(gEgo getPoints: 165 2)
									(= cycles 1)
									(= local0 1)
								)
								(else
									(gMessager say: 11 8 1 0 self) ; "The plate is locked in position. There's a keyhole on the plate, but Gabriel can't operate that without a key."
								)
							)
						)
						(9
							(cond
								(
									(and
										(IsFlag 176)
										(>= gDay 7)
										(not (IsFlag 362))
									)
									(SetFlag 362)
									(gEgo getPoints: 165 2)
									(gMessager say: 11 8 6 0 self) ; "Gabriel hears the faint sound of breaking glass."
									(= local0 1)
								)
								((and (>= gDay 7) (IsFlag 362))
									(gEgo getPoints: 165 2)
									(= cycles 1)
									(= local0 1)
								)
								(else
									(gMessager say: 11 8 1 0 self) ; "The plate is locked in position. There's a keyhole on the plate, but Gabriel can't operate that without a key."
								)
							)
						)
						(12
							(if (and (IsFlag 176) (>= gDay 7))
								(gMessager say: 11 9 2 0 self) ; "The plate's already up, and Gabriel doesn't want to put it back down."
							else
								(gMessager say: 11 9 1 0 self) ; "It's locked shut."
							)
						)
						(6
							(if (and (IsFlag 176) (>= gDay 7))
								(gMessager say: 11 6 2 0 self) ; "The plate's already up, and Gabriel doesn't want to put it back down."
							else
								(gMessager say: 11 6 1 0 self) ; "The plate is locked in position. There's a keyhole on the plate, but Gabriel can't operate that without a key."
							)
						)
						(11
							(if (and (IsFlag 176) (>= gDay 7))
								(gMessager say: 11 11 2 0 self) ; "The tomb is unlikely to respond."
							else
								(gMessager say: 11 11 1 0 self) ; "If only it were that simple."
							)
						)
						(10
							(if (and (IsFlag 176) (>= gDay 7))
								(gMessager say: 11 11 2 0 self) ; "The tomb is unlikely to respond."
							else
								(gMessager say: 11 11 1 0 self) ; "If only it were that simple."
							)
						)
						(else
							(if (and gMsgType (Message msgGET 320 11 register 0 1))
								(gMessager say: 11 register 0 0 self 320)
							else
								(gDoVerbCode doit: register self)
							)
						)
					)
				)
			)
			(4
				(gGame handsOn:)
				(if local0
					(gCurRoom newRoom: 325) ; geddeTomb
				else
					(gEgo normalize: 3)
					(self dispose:)
				)
			)
		)
	)
)

(instance sFromTomb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					normalize: 5
					init:
					posn: 220 110
					state: 2
					setMotion: MoveTo 215 113
				)
				(doors cycleSpeed: 12 setCel: 5 init: setCycle: Beg self)
				(gGkSound1 setLoop: 1 number: 301 play:)
			)
			(1
				(gCurRoom west: 310)
				(gGame handsOn:)
				(doors dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGkMusic1
					number: 209
					setLoop: -1
					play:
					setVol: 0
					fade: (gGkMusic1 musicVolume:) 5 10 0
				)
				(SetFlag 265)
				(gGame handsOff:)
				(gEgo
					normalize: 0
					init:
					posn: -10 135
					state: 2
					setSpeed: 12
					setMotion: MoveTo 25 130
				)
				(doors init: cycleSpeed: 12 setCycle: End self)
				(gGkSound1 setLoop: 1 number: 301 play:)
			)
			(1
				(= seconds 3)
			)
			(2
				(malia init: setSpeed: 15 setCycle: End self)
				(gEgo getPoints: -999 2)
			)
			(3
				(doors setCycle: Beg)
				(gGkSound1 setLoop: 1 number: 301 play:)
				(malia
					view: 362
					posn: 224 112
					signal: 4129
					setLoop: -1
					setLooper: Grooper
					setPri: -1
					illegalBits: 0
					loop: 8
					cel: 1
					setSpeed: 6
					ignoreActors: 1
					setStep: 3 2
					setCycle: StopWalk -1
					setMotion: MoveTo 163 112 self
				)
			)
			(4
				(malia setMotion: MoveTo 75 125 self)
			)
			(5
				(doors dispose:)
				(gEgo setMotion: MoveTo 45 130)
				(malia setMotion: MoveTo 66 130 self)
			)
			(6
				(malia
					view: 323
					setSpeed: 12
					posn: 75 130
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
				(gMessager say: 12 0 4 1 self) ; "Malia!"
			)
			(7 0)
			(8
				(gMessager say: 12 0 4 2 self) ; "Mr. Knight! What are you doing here?"
				(malia setLoop: 5 setSpeed: 25 setCel: 0 setCycle: RandCycle)
			)
			(9
				(malia setSpeed: 15 setCel: 0 setCycle: 0)
				(gMessager say: 12 0 4 3 self) ; "Uh, my family's tomb is here."
			)
			(10
				(gMessager say: 12 0 4 4 self) ; "Mine, too."
				(malia setLoop: 1 setCel: 0 setCycle: End self)
			)
			(11 0)
			(12
				(gMessager say: 12 0 4 5 self) ; "(BEING FACETIOUS)I noticed. Subtle."
			)
			(13
				(gMessager say: 12 0 4 6 self) ; "(OFFENDED)Well, Mr. Knight, if there's nothing else...."
				(malia setLoop: 5 setCel: 0 setSpeed: 25 setCycle: RandCycle)
			)
			(14
				(malia setCel: 0 setSpeed: 15 setCycle: 0)
				(malia z: 1000)
				(gEgo view: 324 setLoop: 2 setCel: 0 setCycle: End self)
				(gMessager say: 12 0 4 7 self) ; "Don't go. I need to talk to you."
			)
			(15 0)
			(16
				(gEgo setCycle: Beg self)
				(gMessager say: 12 0 4 8 self) ; "Whatever for?"
			)
			(17 0)
			(18
				(gEgo normalize: 0)
				(malia z: 0 view: 362 setLoop: 8 setCel: 1)
				(= cycles 1)
			)
			(19
				(gMessager say: 12 0 4 9 self) ; "(HESITATING)I can't stop thinking about you."
			)
			(20
				(malia view: 323 setLoop: 2 setCel: 1 setCycle: CT 3 1 self)
				(gMessager say: 12 0 4 10 self) ; "I've been in your thoughts, too. I can see it in your eyes."
			)
			(21 0)
			(22
				(malia setCycle: End self)
			)
			(23
				(gMessager say: 12 0 4 11 self) ; "Mr. Knight, you don't know anything about me. I'm not in a position to get involved...."
				(malia setLoop: 5 setSpeed: 25 setCel: 0 setCycle: RandCycle)
			)
			(24
				(malia setCel: 0 setSpeed: 15 setCycle: 0)
				(gMessager say: 12 0 4 12 self) ; "I've said that a million times myself, but this is different. I think we both know we can't fight it."
			)
			(25
				(gEgo view: 324 setLoop: 0 setCel: 0 setCycle: End self)
				(gMessager say: 12 0 4 13 self) ; "<groan>I can't believe I'm saying this!"
			)
			(26 0)
			(27
				(gEgo setCycle: Beg self)
			)
			(28
				(gEgo normalize: 0)
				(gMessager say: 12 0 4 14 self) ; "I have so many obligations. My family is very traditional. You wouldn't understand."
				(malia setCel: 0 setLoop: 5 setSpeed: 25 setCycle: RandCycle)
			)
			(29
				(malia setCel: 0 setSpeed: 15 setCycle: 0)
				(= cycles 1)
			)
			(30
				(gMessager say: 12 0 4 15 self) ; "Hey, I love tradition! I've seen 'Fiddler on the Roof' a hundred times!"
			)
			(31
				(gMessager say: 12 0 4 16 self) ; "(BITTER LAUGH)This isn't a musical, Mr. Knight. We live in different worlds!"
				(malia setLoop: 5 setSpeed: 25 setCel: 0 setCycle: RandCycle)
			)
			(32
				(malia setSpeed: 15 setCel: 0 setCycle: 0)
				(gMessager say: 12 0 4 17 self) ; "(RRCC. PLEADING WITH MALIA. FIRST RECORD HAD SOME BRITISH ON MORE MONEY)Look, I know you've got more money than God. Do you think I care? Do you think that's why I'm saying this?"
			)
			(33
				(gMessager say: 12 0 4 18 self) ; "No. I don't."
				(malia setLoop: 5 setSpeed: 25 setCel: 0 setCycle: RandCycle)
			)
			(34
				(malia setCel: 0 setSpeed: 15 setCycle: 0)
				(gMessager say: 12 0 4 19 self) ; "Why don't you come SEE my world? I have a little book shop, St. George's on Bourbon...."
			)
			(35
				(gMessager say: 12 0 4 20 self) ; "I know."
				(malia setLoop: 5 setSpeed: 25 setCel: 0 setCycle: RandCycle)
			)
			(36
				(malia setSpeed: 15 setCel: 0 setCycle: 0)
				(malia z: 1000)
				(gEgo view: 324 setLoop: 2 setCel: 0 setCycle: End self)
				(gMessager say: 12 0 4 21 self) ; "See, I knew it! You're crazy about me, too! Come by tonight! Please? My world isn't so bad."
			)
			(37 0)
			(38
				(gEgo setLoop: 3 setCel: 0 setCycle: End self)
				(gMessager say: 12 0 4 22 self) ; "(ADAMANT, NEARLY TEARFUL)I'm sorry, but there's no place for someone like you in my life...."
			)
			(39 0)
			(40
				(gEgo normalize: 0)
				(malia
					z: 0
					view: 323
					posn: 87 130
					setLoop: 3
					setCel: 0
					setCycle: End self
				)
				(gMessager say: 12 0 4 23) ; "Not now, not ever!"
			)
			(41
				(Face gEgo malia)
				(malia
					posn: 97 130
					setLoop: 4 1
					setSpeed: 6
					setCycle: Fwd
					setMotion: MoveTo 148 98 self
				)
			)
			(42
				(malia
					fixPriority: 1
					setPri: 1
					setSpeed: 2
					setMotion: MoveTo 183 76 self
				)
			)
			(43
				(malia dispose:)
				(gGkMusic1
					number: 300
					setLoop: -1
					play:
					setVol: 0
					fade: (gGkMusic1 musicVolume:) 5 10 0
				)
				(gMessager say: 12 0 4 24 self) ; "DAMN it!"
				(gCurRoom west: 310)
				(gWalkHandler add: maliaWalk)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance malia of Actor
	(properties
		x 238
		y 111
		view 3200
	)
)

(instance doors of Prop
	(properties
		x 207
		y 56
		view 320
	)
)

(instance fallenAngel of Feature
	(properties
		noun 8
		sightAngle 20
		approachX 178
		approachY 130
		x 207
		y 115
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 176 108 186 100 191 90 198 82 209 71 216 71 224 84 232 102 238 103 239 111 231 118 177 116
					yourself:
				)
		)
		(super init:)
	)
)

(instance standingAngel of Feature
	(properties
		noun 3
		sightAngle 20
		approachX 124
		approachY 113
		x 106
		y 103
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 91 89 94 85 99 85 101 74 96 74 95 66 90 66 96 58 96 50 98 44 95 44 90 42 89 37 96 36 98 39 102 40 107 35 117 40 133 62 126 64 114 55 119 86 124 86 124 100 115 104 92 102
					yourself:
				)
		)
		(super init:)
	)
)

(instance geddeTomb of Feature
	(properties
		noun 1
		sightAngle 20
		approachX 181
		approachY 140
		x 228
		y 69
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 182 21 319 22 319 90 302 91 246 126 162 120 161 89 159 77 154 76 154 53 153 45 147 40
					yourself:
				)
		)
		(super init:)
	)
)

(instance vaseL of Feature
	(properties
		noun 9
		sightAngle 20
		x 150
		y 129
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 138 127 139 106 135 102 140 99 144 99 142 89 145 81 144 77 152 75 158 78 162 89 156 100 162 100 162 125 156 129 137 128
					yourself:
				)
		)
		(super init:)
	)
)

(instance vaseR of Feature
	(properties
		noun 9
		sightAngle 20
		x 250
		y 134
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 238 106 245 105 239 95 243 86 241 84 244 81 259 82 257 86 261 94 255 104 263 104 264 130 256 134 238 133
					yourself:
				)
		)
		(super init:)
	)
)

(instance swordTomb of Feature
	(properties
		noun 2
		sightAngle 20
		x 53
		y 143
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 12 137 24 132 24 129 52 118 124 124 125 129 133 129 134 139 124 145 13 145
					yourself:
				)
		)
		(super init:)
	)
)

(instance tomb1 of Feature
	(properties
		noun 4
		sightAngle 20
		approachX 264
		approachY 143
		x 319
		y 188
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 319 145 296 145 296 85 287 74 287 62 319 42
					yourself:
				)
		)
		(super init:)
	)
)

(instance tomb2 of Feature
	(properties
		noun 5
		sightAngle 20
		approachX 124
		approachY 113
		x 53
		y 125
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 86 116 42 131 9 125 9 84 4 80 9 75 51 67 71 65 85 69 85 78
					yourself:
				)
		)
		(super init:)
	)
)

(instance tomb3 of Feature
	(properties
		noun 6
		sightAngle 20
		approachX 124
		approachY 113
		x 64
		y 69
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 36 26 27 67 22 92 32 92 85 84 90 3 83 4 39
					yourself:
				)
		)
		(super init:)
	)
)

(instance tomb4 of Feature
	(properties
		noun 7
		sightAngle 20
		approachX 124
		approachY 113
		x 126
		y 82
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 82 27 110 21 189 20 188 79 132 82 84 82
					yourself:
				)
		)
		(super init:)
	)
)

(instance tombDoors of Feature
	(properties
		noun 10
		sightAngle 20
		approachX 240
		approachY 111
		x 232
		y 103
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 245 57 243 100 207 100 207 57
					yourself:
				)
		)
		(super init:)
	)
)

(instance westExit of ExitFeature
	(properties
		nsTop 125
		nsBottom 150
		nsRight 5
		cursor 962
		exitDir 4
		eCursor 0
	)
)

(instance flap of View
	(properties
		noun 11
		x 187
		y 271
		z 200
		priority 105
		fixPriority 1
		view 322
		loop 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 7) ; Look
			(cond
				((and (>= gDay 7) (IsFlag 176) (not (IsFlag 363)))
					(SetFlag 363)
					(gMessager say: 11 7 8) ; "The plate is up. Beneath the plate is a button."
				)
				((and (>= gDay 7) (IsFlag 363))
					(gMessager say: 11 7 9) ; "The plate is up. Beneath the plate is a button."
				)
				(else
					(gMessager say: 11 7 1) ; "There's a small marble plate near the tomb doors."
				)
			)
		else
			(gCurRoom setScript: sSwitchFlap 0 theVerb)
		)
		(return 1)
	)
)

(instance eastExit of Feature
	(properties
		nsLeft 296
		nsTop 25
		nsRight 319
		nsBottom 148
		sightAngle 40
		approachX 285
		approachY 133
		x 307
		y 133
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(gMessager say: 12 0 10) ; "(GK-AM2)To the east there is only the back wall of the cemetery. Gabriel cannot go any further in that direction."
			)
		)
	)
)

(instance maliaWalk of Feature
	(properties
		nsLeft 139
		nsTop 22
		nsRight 181
		nsBottom 81
		sightAngle 40
		approachX 160
		approachY 51
		x 160
		y 51
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(gMessager say: 12 0 11) ; "(RRCC)Gabriel's done all the begging he can muster at the moment.  Malia will have to work this out on her own."
				(return 1)
			)
		)
	)
)

