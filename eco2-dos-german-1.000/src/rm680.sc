;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 680)
(include sci.sh)
(use Main)
(use ExitFeature)
(use Bats)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm680 0
)

(local
	local0
	local1
	local2
)

(instance rm680 of Rm
	(properties
		noun 10
		picture 680
		style 10
		horizon 16
		north 630
	)

	(method (init)
		(super init:)
		(LoadMany rsVIEW 50 51 680 681 682)
		(gGameSound1 number: 692 play:)
		(cond
			((not (gEgo has: 14))
				(self
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 9 28 9 34 52 61 14 81 14 92 126 133 222 101 202 101 202 96 210 96 210 92 233 92 192 66 240 30 215 30 207 44 181 69 204 90 135 114 38 86 68 66 68 49 33 42 19 27 35 20 35 0 319 0 319 189 0 189 0 0 32 0 31 19
							yourself:
						)
				)
				(gEgo
					view: 0
					x: 32
					y: 18
					init:
					normalize: 0
					setScale: Scaler 100 20 123 16
				)
				(self setScript: enterScript)
			)
			((not (gCurrentRegionFlags test: 0))
				(= local0 1)
				(self
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 319 0 319 189 0 189 0 0 31 0 31 20 12 29 12 34 47 50 46 66 8 82 8 90 128 125 154 119 154 107 137 113 48 91 48 85 68 69 68 51 17 34 17 29 35 20 35 0
							yourself:
						)
				)
				(gEgo
					view: 0
					x: 32
					y: 18
					init:
					normalize: 0
					setScale: Scaler 100 20 123 16
				)
				(self setScript: enterScript)
			)
			(else
				(self
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 -10 216 -2 216 30 194 63 171 63 205 92 143 110 143 120 153 120 162 126 215 99 201 99 201 96 209 96 209 91 234 91 195 65 229 31 228 -2 319 -1 319 189 0 189
							yourself:
						)
				)
				(gEgo
					view: 4
					setLoop: 1
					cel: 0
					x: 152
					y: 118
					actions: rmAction
					init:
					setScale: Scaler 100 20 123 16
				)
				(paquita view: 682 setLoop: 1 cel: 3 x: 130 y: 126 init:)
				(chiropterus init:)
				(self setScript: examPaquita)
			)
		)
		(rope init:)
		(waterfallX setCycle: Fwd init:)
		(adaminboat init:)
		(bats init:)
		(exitnorth init:)
		(stairs init:)
		(darktunnel init:)
		(lighttunnel init:)
		(river init:)
		(floor init:)
	)

	(method (dispose)
		(gEgo actions: 0)
		(if local0
			(gCurrentRegionFlags set: 0)
		)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(if (not (IsFlag 5))
			(Palette palANIMATE 72 77 -15 78 83 -5 84 89 -15)
		)
	)
)

(instance rmAction of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(45 ; whistle
				(if (not local1)
					(gCurRoom setScript: blowWhistle)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance wateraction_1 of Prop ; UNUSED
	(properties
		name {wateraction#1}
		x 131
		y 170
		noun 1
		view 680
		loop 1
		cel 3
		detailLevel 3
	)
)

(instance waterfallX of Prop
	(properties
		x 60
		y 132
		noun 1
		view 680
		loop 2
		cel 3
		priority 13
		signal 16
		detailLevel 3
	)
)

(instance wateraction_2 of Prop ; UNUSED
	(properties
		name {wateraction#2}
		x 256
		y 69
		noun 1
		view 680
		loop 3
		cel 3
		detailLevel 3
	)
)

(instance rope of Prop
	(properties
		x 230
		y 87
		noun 15
		view 680
		loop 5
		priority 10
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (and (gCurrentRegionFlags test: 0) local1)
					(gCurRoom setScript: moorOff)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitnorth of ExitFeature
	(properties
		nsTop 2
		nsLeft 18
		nsBottom 23
		nsRight 48
		cursor 13
		exitDir 1
	)
)

(instance adaminboat of Actor
	(properties
		x 184
		y 74
		noun 9
		approachX 182
		approachY 106
		view 681
		loop 2
		priority 14
		signal 28689
	)

	(method (init)
		(super init:)
		(self approachVerbs: 4 1) ; Do, Look
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((not (gCurrentRegionFlags test: 0))
						(super doVerb: theVerb)
					)
					((not local1)
						(super doVerb: theVerb)
					)
					((not local2)
						(gCurRoom setScript: moorOff)
					)
					(else
						(gCurRoom setScript: ontoBoat)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bats of Actor
	(properties
		x 259
		y 18
		noun 5
		view 680
		loop 6
		signal 24576
	)

	(method (init)
		(super init:)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: noun theVerb 1) ; "Many bats block the sunlit opening of the tunnel. They appear asleep."
			)
			(4 ; Do
				(gMessager say: noun theVerb 1) ; "I'm not so sure those bats are asleep!"
			)
		)
	)
)

(instance paquita of Actor
	(properties
		x 33
		y 19
		noun 8
		approachX 132
		approachY 122
		view 50
		loop 2
		signal 24576
	)

	(method (init)
		(super init:)
		(self approachVerbs: 4 2 1 setScale: Scaler 100 20 123 16) ; Do, Talk, Look
	)

	(method (cue)
		(if (Random 0 1)
			(self cycleSpeed: 8 setCycle: End self)
		else
			(self stopUpd: setScript: (STimer new:) self (Random 1 3))
		)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 2 1) ; Do, Talk, Look
			(cond
				((not (gCurrentRegionFlags test: 0))
					(gCurRoom setScript: checkItOut 0 theVerb)
				)
				(local1
					(gMessager say: noun theVerb 7)
				)
				(else
					(gMessager say: noun theVerb 5)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance chiropterus of Prop
	(properties
		x 130
		y 97
		noun 11
		view 682
		loop 3
		cel 2
		signal 16385
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 1 2) ; Do, Look, Talk
			(gMessager say: noun theVerb 7)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance waterfall of Feature ; UNUSED
	(properties
		x 87
		y 151
		noun 1
		nsTop 136
		nsLeft 65
		nsBottom 167
		nsRight 110
		sightAngle 40
		approachX 87
		approachY 151
	)
)

(instance stairs of Feature
	(properties
		x 70
		y 74
		noun 2
		nsTop 24
		nsLeft 3
		nsBottom 124
		nsRight 138
		sightAngle 40
		approachX 70
		approachY 74
	)
)

(instance darktunnel of Feature
	(properties
		x 212
		y 19
		noun 4
		nsTop 7
		nsLeft 189
		nsBottom 31
		nsRight 236
		sightAngle 40
		approachX 212
		approachY 19
	)
)

(instance lighttunnel of Feature
	(properties
		x 270
		y 17
		noun 5
		nsTop 15
		nsLeft 239
		nsBottom 63
		nsRight 301
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (gEgo view:) 681)
					(gCurRoom setScript: leave)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance river of Feature
	(properties
		x 233
		y 151
		noun 6
		nsTop 134
		nsLeft 170
		nsBottom 169
		nsRight 297
	)
)

(instance floor of Feature
	(properties
		x 141
		y 160
		noun 7
		nsTop 139
		nsLeft 115
		nsBottom 181
		nsRight 167
	)
)

(instance wFeature of Feature ; UNUSED
	(properties
		x 10
		y 10
		noun 1
		onMeCheck 8
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 5)
			)
			(1
				(gEgo setMotion: PolyPath 28 82 self)
			)
			(2
				(if (gEgo has: 14)
					(gGameSound2 number: 682 play:)
					(paquita init: setScript: flyNdead)
				)
				(gEgo setHeading: 135 self)
			)
			(3
				(if (not (gEgo has: 14))
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance flyNdead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(paquita
					setStep: 10 10
					setPri: 14
					setCycle: Walk
					setMotion: MoveTo 46 38 self
				)
			)
			(1
				(gMessager say: 10 0 2 0 self) ; "Adam! Wait for me!"
			)
			(2
				(paquita setMotion: MoveTo 100 48 self)
			)
			(3
				(paquita view: 51 setLoop: 0 cel: 0 setCycle: CT 4 1 self)
			)
			(4
				(paquita
					view: 50
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 53 78 self
				)
			)
			(5
				(paquita view: 51 setLoop: 1 cel: 0 setCycle: CT 4 1 self)
			)
			(6
				(paquita
					view: 50
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 112 83 self
				)
			)
			(7
				(paquita setLoop: 6 setMotion: MoveTo 198 56 self)
			)
			(8
				(paquita view: 51 setLoop: 0 cel: 0 setCycle: CT 3 1 self)
			)
			(9
				(paquita
					view: 50
					setLoop: 4
					setCycle: Walk
					setMotion: MoveTo 130 96 self
				)
			)
			(10
				(paquita view: 682 setLoop: 0 cel: 0 setCycle: End self)
			)
			(11
				(paquita
					origStep: 2575
					setStep: 10 15
					moveSpeed: 1
					setMotion: MoveTo (paquita x:) (+ (paquita y:) 30) self
				)
			)
			(12
				(gGameSound2 number: 684 setLoop: -1 play:)
				(paquita setLoop: 1 cel: 0)
				(gEgo stopUpd:)
				(= cycles 5)
			)
			(13
				(gMessager say: 10 0 3 0 self) ; "I do not understand, I feel so terrible."
			)
			(14
				(paquita cue:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance checkItOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 5)
			)
			(1
				(if (OneOf register 1 2)
					(self cue:)
				else
					(gEgo view: 5 setLoop: 2 cel: 0 setCycle: CT 3 1 self)
				)
			)
			(2
				(gMessager say: 8 register 4 0 self)
			)
			(3
				(if (OneOf register 1 2)
					(self cue:)
				else
					(gEgo cel: 3 setCycle: CT 5 1 self)
				)
			)
			(4
				(gEgo normalize: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance examPaquita of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 15)
			)
			(1
				(chiropterus setCycle: Fcycler 2 4)
				(= cycles 25)
			)
			(2
				(gMessager say: 10 0 6 0 self) ; "What is it, Chiropterus? Is she going to be all right?"
			)
			(3
				(chiropterus cel: 0 setCycle: CT 1 1 self)
			)
			(4
				(gMessager say: 10 4 9 0 self) ; "Chiropterus passes a carved whistle to Adam."
			)
			(5
				(Bats points: 5)
				(gEgo setCycle: End self)
			)
			(6
				(chiropterus cel: 1 setCycle: End self)
			)
			(7
				(gEgo get: 13 normalize: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance ontoBoat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 5)
			)
			(1
				(gEgo setMotion: MoveTo 182 106 self)
			)
			(2
				(gEgo setHeading: 90 self)
			)
			(3
				(adaminboat dispose:)
				(gEgo
					view: 681
					x: 214
					y: 117
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(4
				(gCurRoom setScript: leave)
			)
		)
	)
)

(instance blowWhistle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 5)
			)
			(1
				(gEgo setMotion: PolyPath 184 100 self)
			)
			(2
				(gEgo setHeading: 90 self)
			)
			(3
				(gEgo view: 681 setLoop: 3 cel: 0 setCycle: End self)
			)
			(4
				(gEgo normalize: 0 0)
				(Bats points: 5)
				(bats setCycle: End self)
			)
			(5
				(bats dispose:)
				(= local1 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance moorOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 5)
			)
			(1
				(gEgo setMotion: PolyPath 194 103 self)
			)
			(2
				(Bats points: 5)
				(gEgo view: 5 setLoop: 3 cel: 0 setCycle: CT 2 1 self)
			)
			(3
				(rope cycleSpeed: (gEgo cycleSpeed:) setCycle: End)
				(gEgo setCycle: End self)
			)
			(4
				(rope dispose:)
				(= local2 1)
				(gEgo normalize: 0)
				(gCurRoom setScript: ontoBoat)
			)
		)
	)
)

(instance leave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 5)
			)
			(1
				(= register (gEgo cycleSpeed:))
				(gEgo
					setStep: 3 1
					setLoop: 4
					cycleSpeed: 10
					moveSpeed: 10
					setCycle: End
					setMotion: MoveTo 236 119 self
				)
			)
			(2
				(gEgo setSpeed: register)
				(gCurRoom newRoom: 700)
			)
		)
	)
)

