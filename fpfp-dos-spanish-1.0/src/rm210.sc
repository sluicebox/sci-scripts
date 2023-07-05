;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 210)
(include sci.sh)
(use Main)
(use OccasionalCycle)
(use eRS)
(use Scaler)
(use RandCycle)
(use Polygon)
(use Feature)
(use LoadMany)
(use DPath)
(use Motion)
(use Actor)
(use System)

(public
	rm210 0
)

(local
	local0 = 1
)

(instance rm210 of FPRoom
	(properties
		noun 6
		picture 210
		east 220
		west 200
	)

	(method (init)
		(LoadMany rsVIEW 211 212)
		(switch gPrevRoomNum
			(west
				(= style 12)
				(gGame handsOn:)
			)
			(east
				(= east 0)
				(= style 11)
				(gGame handsOn:)
			)
			(680
				(gGame handsOn:)
			)
			(else
				(= style 100)
				(gEgo x: 281 y: 121)
				(gGame handsOn:)
			)
		)
		(gEgo init: setScale: Scaler 100 50 175 95 normalize:)
		(super init:)
		(gGameMusic2 number: 2210 loop: -1 play:)
		(if (< gCurPuzzle 24)
			(cond
				((< gCurPuzzle 18)
					(Load rsSOUND 2114)
					(animal1 loop: 0)
					(animal2 loop: 1)
				)
				((< gCurPuzzle 22)
					(Load rsSOUND 2120)
					(animal1 loop: 2)
					(animal2 loop: 3)
				)
				((< gCurPuzzle 24)
					(Load rsSOUND 2114)
					(animal1 loop: 4)
					(animal2 loop: 5)
				)
			)
			(animal1 setCycle: OccasionalCycle 1 30 120 2 6 init:)
			(animal2 setCycle: OccasionalCycle 1 30 120 2 6 init:)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 81 319 143 319 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 110 275 113 0 67
					yourself:
				)
		)
		(tracks init: approachVerbs: 1 4 setOnMeCheck: 1 16) ; Look, Do
		(bridge init: approachVerbs: 1 4 setOnMeCheck: 1 4) ; Look, Do
		(rapids init: setOnMeCheck: 1 2)
		(corral init: setOnMeCheck: 1 32)
		(river setCycle: Fwd init:)
		(cliff init: setOnMeCheck: 1 8)
		(board init: stopUpd: ignoreActors:)
		(if (and (not (IsFlag 1)) (== (Random 2 10) 4))
			(smallChild setLoop: (Random 0 1) setCycle: RandCycle init:)
		)
		(if (IsFlag 52)
			(dummyCredits init: setScript: (ScriptID 32 0)) ; sOpeningCredits
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((and (gEgo inRect: 103 90 155 119) local0)
				(board setScript: sBoardFall)
			)
			((== (gEgo edgeHit:) 2)
				(gCurRoom setScript: sExitEast)
			)
		)
	)

	(method (newRoom)
		(gGameMusic2 fade:)
		(gMessager caller: 0)
		(gNarrator dispose: 0)
		(super newRoom: &rest)
	)

	(method (dispose)
		(DisposeScript 32)
		(super dispose:)
	)
)

(instance sExitEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setMotion: MoveTo (+ (gEgo x:) 20) (gEgo y:) self
				)
			)
			(1
				(gCurRoom newRoom: 220)
			)
		)
	)
)

(instance sBoardFall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheIconBar disable:)
				(Load rsSOUND 2938)
				(gNarrator modeless: 1)
				(= local0 0)
				(board setCycle: Fwd setMotion: MoveTo 120 140 self)
			)
			(1
				(board setPri: 9 setMotion: MoveTo 130 185 self)
			)
			(2
				(splashSound play:)
				(board setLoop: 1 setCel: 0 setCycle: End self)
			)
			(3
				(board setLoop: 2 setMotion: DPath 152 166 210 136)
				(gMessager say: 2 3 3 0 self) ; "Whew! That was a close one! Considering the condition of this old bridge, you may only have about three crossings left."
			)
			(4
				(if (== gCurPuzzle 14)
					(gGameMusic1 play:)
				)
				(= cycles 1)
			)
			(5
				(gNarrator modeless: 0)
				(UnLoad 132 2938)
				(board dispose:)
				(gTheIconBar enable:)
				(self dispose:)
			)
		)
	)
)

(instance smallChild of Prop
	(properties
		x 295
		y 106
		noun 8
		view 107
		detailLevel 2
	)
)

(instance animal1 of Prop
	(properties
		x 281
		y 101
		z 62
		noun 9
		view 213
		detailLevel 2
	)

	(method (doit)
		(super doit:)
		(if (and (== cel 1) (== (heepSound prevSignal:) -1))
			(switch loop
				(0
					(heepSound number: 2114)
				)
				(2
					(heepSound number: 2120)
				)
			)
			(heepSound play:)
		)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 1 2) ; Do, Look, Talk
			(switch (animal1 loop:)
				(0
					(gMessager say: noun theVerb 13)
				)
				(2
					(gMessager say: noun theVerb 4)
				)
				(4
					(gMessager say: noun theVerb 15)
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance animal2 of Prop
	(properties
		x 300
		y 101
		z 44
		noun 10
		view 213
		detailLevel 2
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 1 2) ; Do, Look, Talk
			(switch (animal2 loop:)
				(1
					(gMessager say: noun theVerb 13)
				)
				(3
					(gMessager say: noun theVerb 4)
				)
				(5
					(gMessager say: noun theVerb 15)
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance river of Prop
	(properties
		x 132
		y 171
		noun 4
		view 211
		cel 2
		priority 1
		signal 16400
		cycleSpeed 20
		detailLevel 2
	)
)

(instance board of Actor
	(properties
		x 110
		y 103
		yStep 10
		view 212
		priority 4
		signal 16400
		scaleSignal 5
	)

	(method (init)
		(self setScale: Scaler 36 100 189 100)
		(super init: &rest)
	)
)

(instance dummyCredits of Prop
	(properties
		x -10
		y -10
		view 996
	)
)

(instance tracks of Feature
	(properties
		x 212
		y 174
		noun 1
		sightAngle 40
		approachX 212
		approachY 174
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: 1 4 11) ; "You slide your hand back and forth across the rusty tracks, getting a little rust-burn in the process."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bridge of Feature
	(properties
		x 136
		y 89
		noun 2
		sightAngle 40
		approachX 136
		approachY 89
	)
)

(instance rapids of Feature
	(properties
		x 136
		y 160
		noun 4
		sightAngle 40
	)
)

(instance cliff of Feature
	(properties
		x 136
		y 160
		noun 5
		sightAngle 40
	)
)

(instance corral of Feature
	(properties
		x 160
		y 100
		noun 3
		sightAngle 40
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 1 2) ; Do, Look, Talk
			(cond
				((< gCurPuzzle 18)
					(gMessager say: noun theVerb 8)
				)
				((< gCurPuzzle 22)
					(gMessager say: noun theVerb 9)
				)
				((< gCurPuzzle 24)
					(gMessager say: noun theVerb 7)
				)
				(else
					(gMessager say: noun theVerb 12)
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance heepSound of FPSound
	(properties
		flags 1
		number 2114
	)
)

(instance splashSound of FPSound
	(properties
		flags 1
		number 2938
	)
)

