;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 200)
(include sci.sh)
(use Main)
(use eRS)
(use Print)
(use Inset)
(use Scaler)
(use ROsc)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use StopWalk)
(use Motion)
(use Actor)
(use System)

(public
	rm200 0
)

(local
	local0
	local1
)

(instance rm200 of FPRoom
	(properties
		noun 14
		picture 200
		east 210
	)

	(method (init)
		(switch gPrevRoomNum
			(east
				(= style 11)
				(gGame handsOn:)
			)
			(680
				(gGame handsOn:)
			)
			(else
				(= style 100)
				(gEgo x: 185 y: 106)
				(gGame handsOn:)
			)
		)
		(gEgo init: setScale: Scaler 100 50 175 95 normalize:)
		(super init:)
		(if (IsFlag 52)
			(dummyCredits init: setScript: (ScriptID 32 0)) ; sOpeningCredits
		)
		(if (== gCurPuzzle 10)
			(LoadMany rsSOUND 2186 2187)
			(LoadMany rsVIEW 204 202 203)
			(snail
				approachVerbs: 4 ; Do
				ignoreActors:
				setCycle: Fwd
				setScript: sPlayContinuously
				init:
			)
			(if (>= global131 3)
				(snail view: 203 loop: (- global131 3))
			else
				(snail loop: global131)
			)
			(switch global131
				(0
					(snail posn: 49 65 setPri: 2 approachX: 43 approachY: 74)
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 10 87 10 108 81 134 190 110 206 136 303 114 249 84 263 68 319 82 319 189 0 189 0 0 319 0 319 66 255 50 201 49 134 50 119 58 73 61
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 62 80 91 66 145 76 170 83 133 95
								yourself:
							)
					)
				)
				(1
					(snail posn: 17 83 approachX: 14 approachY: 90 setPri: 2)
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 16 89 10 108 81 134 190 110 206 136 303 114 249 84 263 68 319 82 319 189 0 189 0 0 319 0 319 66 255 50 201 49 134 50 119 58 71 65
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 62 80 91 66 145 76 170 83 133 95
								yourself:
							)
					)
				)
				(2
					(snail posn: 50 102 approachX: 65 approachY: 109)
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 37 115 71 128 97 128 119 113 181 109 202 138 292 117 265 99 264 64 319 78 319 189 0 189 0 0 319 0 319 64 289 51 162 52 121 67 183 82 143 102 94 90 69 108
								yourself:
							)
					)
				)
				(3
					(snail
						posn: 95 116
						ignoreActors:
						setPri: 6
						approachX: 89
						approachY: 127
					)
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 97 128 142 113 181 109 202 138 292 117 265 99 264 64 319 78 319 189 0 189 0 0 319 0 319 64 289 51 162 52 121 67 183 82 140 109 84 128
								yourself:
							)
					)
				)
				(4
					(snail posn: 196 107 approachX: 175 approachY: 110)
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 10 87 10 108 81 134 190 110 206 136 303 114 249 84 263 68 319 82 319 189 0 189 0 0 319 0 319 66 255 50 201 49 134 50 119 58 73 61
								yourself:
							)
							((Polygon new:)
								type: PBarredAccess
								init: 62 80 91 66 145 76 170 83 133 95
								yourself:
							)
					)
				)
			)
		else
			(if (and (== gCurPuzzle 13) (IsFlag 27))
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 10 87 10 108 83 124 201 108 216 130 303 114 249 84 263 68 319 82 319 189 0 189 0 0 319 0 319 66 255 50 201 49 134 50 119 58 73 61
							yourself:
						)
				)
			else
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 10 87 10 108 81 134 190 110 206 136 303 114 249 84 263 68 319 82 319 189 0 189 0 0 319 0 319 66 255 50 201 49 134 50 119 58 73 61
							yourself:
						)
				)
			)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 62 80 91 66 145 76 170 83 133 95
						yourself:
					)
			)
		)
		(if (and (not (IsFlag 2)) (== gCurPuzzle 12))
			(LoadMany rsSOUND 185 2184 2202)
			(gGameMusic1 number: 201 loop: -1 play:)
			(srini init: stopUpd: setScale: -1 gEgo approachVerbs: 2 4) ; Talk, Do
			(ClearFlag 84)
			(= global138 0)
		)
		(if (!= gCurPuzzle 10)
			(ants setCycle: Fwd init: ignoreActors: setPri: 5)
		)
		(cond
			((and (== gCurPuzzle 10) (== global131 4))
				(self setScript: sSlimeTime)
			)
			((and (== gCurPuzzle 13) (not (IsFlag 27)))
				(gGameMusic1 number: 203 loop: -1 play:)
				(LoadMany rsSOUND 2180)
				(cedric init: ignoreHorizon:)
				(vulture init: ignoreActors: stopUpd:)
				(cedric setScript: sSeeCedric)
			)
			((== gCurPuzzle 13)
				(= local0 1)
				(gGameMusic1 number: 203 loop: -1 play:)
				(localSound number: 2180 play:)
				(vulture2 init: setCycle: Fwd ignoreActors:)
			)
			((and (== gCurPuzzle 19) (not (IsFlag 98)))
				(SetFlag 98)
				(gGameMusic2 number: 501 loop: -1 play:)
				(hopSingh
					init:
					setScale: -1 gEgo
					setSpeed: 12
					setStep: 6 2
					setScript: sLeaveTown
				)
			)
		)
		(if (IsFlag 2)
			(ladder init: stopUpd: ignoreActors: approachVerbs: 1 4 setPri: 5) ; Look, Do
		)
		(anthill init: approachVerbs: 4 36 setOnMeCheck: 1 2) ; Do, Ladder
		(rocks init: approachVerbs: 4 setOnMeCheck: 1 4) ; Do
		(cacti init: setOnMeCheck: 1 8)
		(farCacti init: setOnMeCheck: 1 4096)
		(road init: approachVerbs: 4 setOnMeCheck: 1 16) ; Do
		(bridge init: approachVerbs: 4 setOnMeCheck: 1 32) ; Do
		(tracks init: approachVerbs: 4 setOnMeCheck: 1 64) ; Do
		(cliff init: approachVerbs: 4 setOnMeCheck: 1 128) ; Do
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((proc0_1 gEgo 16384)
				(gCurRoom setScript: sEgoFalls)
			)
		)
	)

	(method (dispose)
		(if (== gCurPuzzle 10)
			(++ global131)
		)
		(if (== gCurPuzzle 14)
			0
		else
			(gGameMusic1 fade:)
			(gGameMusic2 fade:)
		)
		(DisposeScript 932)
		(DisposeScript 32)
		(super dispose:)
	)
)

(instance sPlayContinuously of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(== (localSound number:) 2186)
				(== (localSound prevSignal:) -1)
			)
			(localSound number: 2186 loop: 1 play: self)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localSound number: 2186 loop: 1 play: self)
			)
			(1
				(localSound prevSignal: 0)
				(self changeState: 0)
			)
		)
	)
)

(instance sLeaveTown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(client setCycle: End self)
			)
			(2
				(client setCycle: ROsc 3 5 6 self)
			)
			(3
				(= seconds 2)
			)
			(4
				(client setCycle: ROsc 3 5 6 self)
			)
			(5
				(client setLoop: 5 cel: 0 setCycle: End self)
			)
			(6
				(client
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo -30 100 self
				)
			)
			(7
				(gGameMusic2 fade: 0 30 12 1)
				(self dispose:)
			)
		)
	)
)

(instance sWalkSrini of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(sriniCU setMotion: MoveTo 115 87 self)
			)
			(2
				(sriniCU
					setCycle:
						ROsc
						(Random 2 5)
						(sriniCU cel:)
						(+ (sriniCU cel:) 2)
						self
				)
			)
			(3
				(sriniCU setCycle: Walk setMotion: MoveTo 115 97 self)
			)
			(4
				(sriniCU
					setCycle:
						ROsc
						(Random 2 5)
						(sriniCU cel:)
						(+ (sriniCU cel:) 2)
						self
				)
			)
			(5
				(sriniCU setCycle: Walk setMotion: MoveTo 115 107 self)
			)
			(6
				(sriniCU dispose:)
				(inSriniWalk dispose:)
			)
		)
	)
)

(instance sEgoFalls of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(LoadMany rsSOUND 2133 2134)
				(if (gEgo wearingGuns:)
					(Load rsVIEW 134)
				else
					(Load rsVIEW 133)
				)
				(gEgo setSpeed: 7 setHeading: 180)
				(= cycles 5)
			)
			(1
				(gEgo setMotion: MoveFwd 40 self)
			)
			(2
				(localSound number: 2133 play:)
				(gEgo
					setScale: Scaler 100 50 175 95
					setPri: 15
					view: (if (gEgo wearingGuns:) 134 else 133)
					setLoop: 0
					setCel: 0
					setSpeed: 12
					setCycle: End self
				)
			)
			(3
				(gEgo hide:)
				(localSound number: 2134 play: self)
			)
			(4
				(ShakeScreen 25 ssFULL_SHAKE)
				(= ticks 190)
			)
			(5
				(ShakeScreen 5 ssFULL_SHAKE)
				(= cycles 1)
			)
			(6
				(= seconds 3)
			)
			(7
				(= global122 9)
				(gCurRoom newRoom: 99) ; deathRoom
			)
		)
	)
)

(instance sSlimeTime of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 265 65 self)
			)
			(1
				(gEgo setHeading: 180)
				(= cycles 10)
			)
			(2
				(gMessager say: 18 0 0 0 self) ; "Oh, no! You've taken too long! You'll NEVER turn those snails back now!"
			)
			(3
				(= global122 16)
				(gCurRoom newRoom: 99) ; deathRoom
			)
		)
	)
)

(instance sTalkToSrini of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 1 2 register 0 self)
			)
			(1
				(srini cycleSpeed: 12 setCycle: End self)
			)
			(2
				(srini setCycle: Beg self)
			)
			(3
				(srini stopUpd: cycleSpeed: 6)
				(self dispose:)
			)
		)
	)
)

(instance sSeeCedric of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 27)
				(= cycles 1)
			)
			(1
				(cedric
					setLoop: 1
					setCycle: Fwd
					setPri: 15
					setMotion: MoveTo 269 38 self
				)
			)
			(2
				(cedric setLoop: 0 stopUpd:)
				(= seconds 2)
			)
			(3
				(vulture setCycle: End self)
			)
			(4
				(= seconds 2)
			)
			(5
				(vulture setCycle: Beg self)
			)
			(6
				(vulture setLoop: 3 setCycle: Osc 3 self)
			)
			(7
				(vulture stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance sPourBeer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTimers delete: (ScriptID 0 13)) ; deathTimer
				(= local1 (gEgo moveSpeed:))
				(gEgo setSpeed: 6)
				(gEgo
					setMotion:
						PolyPath
						(snail approachX:)
						(snail approachY:)
						self
				)
			)
			(1
				(gEgo
					view: 204
					setLoop: 1
					setCycle: Walk
					setMotion: PolyPath 87 128 self
				)
			)
			(2
				(gEgo view: 204 setLoop: 0 cel: 0 setCycle: Osc 3 self)
				(localSound number: 2813 play:)
			)
			(3
				(localSound stop:)
				(gMessager say: 2 33) ; "Hey, boys! It's Miller time!!"
				(gGame points: 16)
				(gEgo setSpeed: local1)
				(= gCurPuzzle 11)
				(gCurRoom newRoom: 205)
			)
		)
	)
)

(instance sSaveSrini of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(LoadMany rsSOUND 2202 185 2184)
				((ScriptID 1800 49) textY: 35 talkWidth: 140) ; Freddy
				((ScriptID 1802 40) ; Srini
					x: 207
					y: 81
					textX: -170
					textY: 35
					talkWidth: 140
				)
				(gEgo put: 28) ; Ladder
				(proc0_9 610)
				(gGame points: 10)
				(gMessager say: 3 36 10 1 2 self) ; "I've got it, Srini! I know how I can help you!"
			)
			(1
				(SetFlag 2)
				(ladder
					init:
					stopUpd:
					ignoreActors:
					approachVerbs: 1 4 ; Look, Do
					setPri: 5
				)
				(localSound number: 2202 play:)
				(= cycles 30)
			)
			(2
				(gEgo setMotion: PolyPath 116 104 self)
				(srini loop: 2 cel: 0 setCycle: End self)
			)
			(3 0)
			(4
				(Face gEgo srini)
				(= cycles 15)
			)
			(5
				(gCast eachElementDo: #stopUpd)
				(gCast eachElementDo: #ignoreActors)
				(= cycles 15)
			)
			(6
				(gMessager say: 3 36 10 3 self) ; "Ooooh! My balance sense is stretching now."
				(proc0_9 0)
			)
			(7
				(gCurRoom setInset: inSriniWalk self)
			)
			(8
				(proc0_9 610)
				(= cycles 30)
			)
			(9
				(gMessager say: 3 36 10 4 self) ; "You made it!"
			)
			(10
				(srini setMotion: MoveTo 109 61 self)
			)
			(11
				(srini setPri: -1 setMotion: MoveTo 110 70 self)
			)
			(12
				(gEgo setHeading: 270)
				(srini
					moveSpeed: 4
					cycleSpeed: 4
					setMotion: PolyPath 106 104 self
				)
			)
			(13
				(gEgo hide:)
				(srini
					view: 201
					loop: 3
					cel: 0
					x: 112
					y: 105
					moveSpeed: 12
					cycleSpeed: 12
					setCycle: CT 8 1 self
				)
			)
			(14
				(gMessager say: 3 36 10 5 7 self) ; "Oh, thank you, Mr. P! You saved me!"
			)
			(15
				(srini setCycle: End)
				(= seconds 3)
			)
			(16
				(gMessager say: 1 2 1 0 self) ; "Thank you again, Mr. F. I am so much grateful!"
			)
			(17
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 780 6)
				(= seconds 3)
			)
			(18
				(gMessager say: 19 0 0 0 self) ; "So Freddy headed on back to the Pharmacy, followed by the eternally grateful Srini Lalkaka Bagdnish. Seems like Freddy'd not only found hisself a new assistance at the Pharmacy, but also a good friend as well!"
			)
			(19
				(gCurRoom newRoom: 610)
				(self dispose:)
			)
		)
	)
)

(instance hopSingh of Actor
	(properties
		x 90
		y 100
		noun 21
		view 844
		loop 3
	)
)

(instance snail of Actor
	(properties
		x 31
		y 64
		noun 2
		view 202
		loop 2
		detailLevel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (or (gEgo has: 54) (IsFlag 32)) ; Snails
					(gMessager say: noun theVerb 5) ; "You have more than enough snails already!"
				else
					(gEgo get: 54 self 1) ; Snails
					(gGame points: 1 132)
				)
			)
			(33 ; Open_Beer
				(if (== gCurPuzzle 10)
					(gCurRoom setScript: sPourBeer)
				else
					(Prints {We need a msg here, Josh.})
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance srini of Actor
	(properties
		x 138
		y 67
		noun 1
		approachX 156
		approachY 103
		view 201
		loop 1
		priority 5
		signal 16400
	)

	(method (doVerb theVerb &tmp temp0)
		(= temp0 (if (IsFlag 2) 1 else 3))
		(switch theVerb
			(1 ; Look
				(if (and (== temp0 3) (IsFlag 92))
					(= temp0 12)
					(gMessager say: noun theVerb 12) ; "An Indian sits atop an anthill, surrounded by swarms of ants. He looks trapped. You feel sorry for him. If there were only some way you could help him."
				else
					(gMessager say: noun theVerb temp0)
					(SetFlag 92)
				)
			)
			(4 ; Do
				(gMessager say: noun theVerb temp0)
			)
			(2 ; Talk
				(gCurRoom setScript: sTalkToSrini 0 temp0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance vulture of Prop
	(properties
		x 142
		y 169
		z 40
		noun 10
		view 209
		loop 2
		detailLevel 2
	)

	(method (doVerb theVerb &tmp temp0)
		(= temp0 (if local0 9 else 8))
		(if (OneOf theVerb 1 4 2) ; Look, Do, Talk
			(gMessager say: noun theVerb temp0)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance vulture2 of Actor
	(properties
		x 153
		y 173
		z 40
		noun 10
		view 209
		loop 4
	)

	(method (doVerb theVerb &tmp temp0)
		(= temp0 (if local0 9 else 8))
		(if (OneOf theVerb 1 4 2) ; Look, Do, Talk
			(gMessager say: noun theVerb temp0)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance ants of Prop
	(properties
		x 136
		y 64
		z -2
		noun 13
		view 200
		detailLevel 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(if (gCast contains: srini)
				(gMessager say: noun theVerb 10) ; "Nasty fire ants are swarming around the poor potential Indian Sidekick seated at the top of their anthill."
			else
				(gMessager say: noun theVerb 11) ; "The dense swarm of dense fire ants diligently attempts to collect plenty of sand for the coming winter."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance cedric of Actor
	(properties
		x 270
		y -20
		noun 12
		view 209
		loop 1
		detailLevel 2
	)

	(method (doVerb theVerb &tmp temp0)
		(= temp0 8)
		(if (OneOf theVerb 1 4 2) ; Look, Do, Talk
			(gMessager say: noun theVerb temp0)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance dummyCredits of Prop
	(properties
		x -10
		y -10
		view 996
	)
)

(instance ladder of View
	(properties
		x 119
		y 82
		z 17
		noun 16
		approachX 129
		approachY 101
		view 200
		loop 1
		priority 5
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo get: -1 28) ; Ladder
				(ClearFlag 2)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance anthill of Feature
	(properties
		x 126
		y 81
		noun 3
		sightAngle 40
		approachX 105
		approachY 91
		approachDist 26
	)

	(method (doVerb theVerb)
		(switch theVerb
			(36 ; Ladder
				(if (== gCurPuzzle 12)
					(gCurRoom setScript: sSaveSrini)
				else
					(gMessager say: noun theVerb 11) ; "Don't leave the ladder lying around unless you have a specific reason to do so!"
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rocks of Feature
	(properties
		x 80
		y 75
		noun 4
		sightAngle 40
		approachX 73
		approachY 95
		approachDist 26
	)
)

(instance cacti of Feature
	(properties
		x 125
		y 23
		noun 5
		sightAngle 40
		approachX 161
		approachY 66
		approachDist 81
	)
)

(instance farCacti of Feature
	(properties
		x 125
		y 23
		noun 17
		sightAngle 40
		approachX 161
		approachY 66
		approachDist 81
	)
)

(instance road of Feature
	(properties
		x 125
		y 23
		noun 6
		sightAngle 40
		approachX 161
		approachY 66
		approachDist 81
	)
)

(instance bridge of Feature
	(properties
		x 289
		y 60
		noun 7
		sightAngle 40
		approachX 235
		approachY 84
		approachDist 65
	)
)

(instance tracks of Feature
	(properties
		x 140
		y 160
		noun 8
		sightAngle 40
		approachX 81
		approachY 130
		approachDist 65
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(cond
					((< gCurPuzzle 10)
						(= temp0 5)
					)
					((== gCurPuzzle 10)
						(= temp0 6)
					)
					(else
						(= temp0 7)
					)
				)
				(gMessager say: noun theVerb temp0)
			)
			(4 ; Do
				(= temp0 (if (> gCurPuzzle 10) 7 else 5))
				(gMessager say: noun theVerb temp0)
			)
			(32 ; Beer
				(if (== gCurPuzzle 10)
					(gMessager say: noun theVerb 6) ; "While you love the drama of breaking open a bottle of beer on a ribbon of steel, you'll retain more brew by using a bottle opener."
				else
					(super doVerb: theVerb)
				)
			)
			(33 ; Open_Beer
				(if (== gCurPuzzle 10)
					(gCurRoom setScript: sPourBeer)
				else
					(gMessager say: noun theVerb 13) ; "You don't have time to be walking around dumping beer all over the place. You've got flatulent horses to attend to!"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cliff of Feature
	(properties
		x 180
		y 160
		noun 9
		sightAngle 40
		approachX 235
		approachY 84
		approachDist 65
	)
)

(instance inSriniWalk of Inset
	(properties
		view 205
		x 81
		y 32
		disposeNotOnMe 1
	)

	(method (init)
		(super init: &rest)
		(sriniCU init: setLoop: 1 setPri: 15 ignoreActors: setCycle: Walk)
		(gGameMusic1 stop:)
		(localSound number: 2184 play:)
		(self setScript: sWalkSrini)
	)

	(method (dispose)
		(super dispose:)
		(ants setCycle: Fwd)
		(srini view: 801 loop: 1 x: 106 y: 66 setCycle: StopWalk -1)
		(localSound fade:)
		(gGameMusic1 number: 185 loop: -1 play:)
	)
)

(instance sriniCU of Actor
	(properties
		x 117
		y 77
		view 205
	)
)

(instance localSound of FPSound
	(properties
		flags 1
	)
)

(instance fallSound of FPSound ; UNUSED
	(properties
		flags 1
	)
)

