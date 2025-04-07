;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 593)
(include sci.sh)
(use Main)
(use GloryRm)
(use Teller)
(use forest)
(use Scaler)
(use Polygon)
(use Jump)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm593 0
)

(local
	local0
	local1
)

(instance rm593 of GloryRm
	(properties
		picture 420
		horizon 66
		north 592
		west 480
		topX 158
	)

	(method (init)
		(SetFlag 35)
		(self setRegions: 50) ; forest
		(super init: &rest)
		(if (or (!= gPrevRoomNum 480) global467)
			(if global467
				(self setScript: sJumpFrom480)
			)
			(= global467 0)
			(barrier init:)
			(heroTeller init: gEgo 593 3 128 2)
			(= west 0)
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 173 105 173 -300 619 -300 619 489 -300 489 -300 155 -300 122 -300 -300 141 -300 141 68 164 84 136 101 102 101 94 96 64 96 37 69 8 69 8 75 49 92 49 99 16 99 16 105 70 117 70 148 25 148 25 174 192 174 192 162 262 162 300 138 261 127 261 118 216 118 216 113 140 113 140 105
						yourself:
					)
			)
		else
			(barrier loop: 2 cel: 9 init:)
			(= local0 1)
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 173 105 173 -300 619 -300 619 489 -300 489 -300 155 25 155 25 174 192 174 192 162 262 162 300 138 261 127 261 118 216 118 216 113 140 113 140 105
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 141 -300 141 68 164 84 136 101 102 101 94 96 64 96 37 69 8 69 8 75 49 92 49 99 16 99 16 122 -300 122 -300 -300
						yourself:
					)
			)
		)
		(atp1 init: setPri: 180)
		(atp2 init: setPri: 95)
		(atp3 init: setPri: 109)
		(atp4 init: setPri: 180)
		(extra1 init:)
		(extra2 init: setPri: 180)
		(stream1 setPri: 74 setCycle: Fwd init:)
		(stream2 setPri: 74 setCycle: Fwd init:)
		(stream3 setPri: 74 setCycle: Fwd init:)
		(streamMat init:)
		(if (IsFlag 380)
			(gGlory save: 1)
		)
	)

	(method (dispose)
		(ClearFlag 35)
		(streamMat dispose:)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; detectMagicSpell
				(if local0
					(gMessager say: 2 81 2) ; "You sense no magic here other than from the already-open bush."
					(return 1)
				else
					(self setScript: sDetectBush)
				)
			)
			(82 ; triggerSpell
				(proc0_12 32 122)
				(self setScript: (ScriptID 11) 0 barrier) ; castTriggerScript
			)
			(80 ; openSpell
				(gMessager say: 1 80) ; "You can't open THAT, even with a spell."
				(return 1)
			)
			(11 ; glideSpell
				(if (streamMat onMe: (gEgo x:) (gEgo y:))
					(gMessager say: 5 6 7) ; "The water is too shallow for this spell to work."
				else
					(gMessager say: 4 0 8) ; "The Glide spell only works on liquid; you can't cast it here."
				)
			)
			(else
				(if (Message msgSIZE 593 0 theVerb 0 1)
					(gMessager say: 0 theVerb 0 0 0 593)
				else
					((ScriptID 50) doVerb: theVerb) ; forest
					(return 1)
				)
			)
		)
	)
)

(instance heroTeller of Teller
	(properties
		loopMenu 0
	)

	(method (showCases)
		(super showCases: 5 (IsFlag 186)) ; Say Magic Phrase
	)

	(method (sayMessage)
		(ClearFlag 51)
		(if (== iconValue 5) ; Say Magic Phrase
			(if local0
				(gMessager say: 2 81 2) ; "You sense no magic here other than from the already-open bush."
			else
				(gCurRoom setScript: sSpellBush 0 1)
			)
		else
			(super sayMessage: &rest)
		)
	)

	(method (respond)
		(super respond: &rest)
		(if (== iconValue -999)
			((User curEvent:) claimed: 1)
		)
		(return 1)
	)
)

(instance sSpellBush of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= cycles 10)
			)
			(1
				(gEgo
					setHeading:
						(GetAngle
							(gEgo x:)
							(gEgo y:)
							(barrier x:)
							(barrier y:)
						)
						self
				)
			)
			(2
				(barrier signal: (| (barrier signal:) $0001) setCycle: End self)
			)
			(3
				(barrier setCycle: Beg self)
			)
			(4
				(barrier setLoop: 1 setCel: 0 setCycle: End self)
			)
			(5
				(barrier setCycle: Beg self)
			)
			(6
				(barrier setLoop: 2 setCel: 0 setCycle: End self)
			)
			(7
				(barrier signal: (& (barrier signal:) $fffe))
				(if (== register 1)
					(gMessager say: 3 128 5 0 self) ; "As you repeat the magic phrase you learned from the Leshy, the bushes on the west spring apart as if by magic!"
				else
					(self cue:)
				)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 173 105 173 -300 619 -300 619 489 -300 489 -300 155 25 155 25 174 192 174 192 162 262 162 300 138 261 127 261 118 216 118 216 113 140 113 140 105
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 141 -300 141 68 164 84 136 101 102 101 94 96 64 96 37 69 8 69 8 75 49 92 49 99 16 99 16 122 -300 122 -300 -300
							yourself:
						)
				)
				(= local0 1)
				(heroTeller dispose:)
				(gCurRoom west: 480)
				(gGlory handsOn:)
				(= register 0)
				(self dispose:)
			)
		)
	)
)

(instance sJumpBush of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: MoveTo 200 (barrier approachY:) self)
			)
			(1
				(gMessager say: 2 159 0 0 self) ; "Thinking you see a gap beyond the western bushes, you take a mighty acrobatic leap over them."
			)
			(2
				(= register gEgoGait)
				(gEgo
					changeGait: 1 ; running
					setMotion:
						MoveTo
						(barrier approachX:)
						(barrier approachY:)
						self
				)
			)
			(3
				(= local1 (gEgo cycleSpeed:))
				(= global467 1)
				(gEgo
					view: 30
					setLoop: 3
					setCel: 0
					setSpeed: global433
					setScale: 0
					setScaler: 0
					setCycle: CT 8 1
					setMotion: JumpTo -30 (gEgo y:) self
				)
			)
			(4
				(gEgo changeGait: register normalize: setSpeed: local1)
				(gCurRoom newRoom: 480)
			)
		)
	)
)

(instance sJumpFrom480 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local1 (gEgo cycleSpeed:))
				(gEgo
					view: 30
					x: -30
					y: 140
					setLoop: 2
					setCel: 0
					setSpeed: global433
					setScale: 0
					setCycle: CT 8 1
					setMotion: JumpTo 84 140 self
				)
			)
			(1
				(gEgo
					normalize: 0
					setScaler: Scaler 100 40 147 61
					setSpeed: local1
				)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDetectBush of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo
					setHeading:
						(GetAngle
							(gEgo x:)
							(gEgo y:)
							(barrier x:)
							(barrier y:)
						)
						self
				)
			)
			(1
				(barrier signal: (| (barrier signal:) $0001) setCycle: End self)
			)
			(2
				(barrier setCycle: Beg self)
			)
			(3
				(barrier setLoop: 1 setCel: 0 setCycle: End self)
			)
			(4
				(barrier setCycle: Beg self)
			)
			(5
				(gMessager say: 1 6 1 0 self) ; "An enchantment has been placed on the hedge to the west."
			)
			(6
				(barrier setLoop: 0 signal: (& (barrier signal:) $fffe))
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance atp1 of ForestView
	(properties
		x 146
		y 152
		view 422
		cel 1
	)
)

(instance atp2 of ForestView
	(properties
		x 224
		y 34
		view 421
		cel 1
	)
)

(instance atp3 of ForestView
	(properties
		x 146
		y 5
		view 424
		cel 2
	)
)

(instance atp4 of ForestView
	(properties
		x 4
		y 169
		view 422
	)
)

(instance stream1 of ForestView
	(properties
		x 69
		y 73
		view 420
		loop 2
		signal 16385
		detailLevel 2
	)
)

(instance stream2 of ForestView
	(properties
		x 133
		y 102
		view 420
		loop 4
		signal 16385
		detailLevel 2
	)
)

(instance stream3 of ForestView
	(properties
		x 290
		y 126
		view 420
		loop 6
		signal 16385
		detailLevel 2
	)
)

(instance extra1 of ForestView
	(properties
		x 84
		y -35
		view 421
		loop 1
		cel 1
		signal 16384
	)
)

(instance extra2 of ForestView
	(properties
		x 80
		y 143
		view 422
		loop 1
		cel 1
		signal 16384
	)
)

(instance barrier of Prop
	(properties
		noun 2
		approachX 84
		approachY 140
		y 146
		view 593
		signal 16384
	)

	(method (init)
		(self approachVerbs: 4 10 setPri: 1) ; Do, Jump
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(80 ; openSpell
				(if local0
					(gMessager say: 2 80 2) ; "You've already opened a pathway through the bushes. Nothing else happens."
				else
					(proc0_12 gMouseX (- gMouseY 10))
					(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
				)
				(return 1)
			)
			(-80 ; openSpell (part 2)
				(gCurRoom setScript: sSpellBush)
				(return 1)
			)
			(10 ; Jump
				(if (not loop)
					(gCurRoom setScript: sJumpBush)
				else
					((ScriptID 50) doVerb: theVerb) ; forest
				)
			)
			(82 ; triggerSpell
				(gCurRoom doVerb: 82)
			)
			(-82 ; triggerSpell (part 2)
				(if local0
					(gMessager say: 2 80 2) ; "You've already opened a pathway through the bushes. Nothing else happens."
					(gCurRoom setScript: 0)
					(gGlory handsOn:)
					(return 1)
				else
					(self setScript: sSpellBush)
				)
			)
			(else
				(if (Message msgSIZE 593 noun theVerb 0 1)
					(gMessager say: noun theVerb 0 0 0 593)
				else
					((ScriptID 50) doVerb: theVerb) ; forest
				)
			)
		)
	)
)

(instance streamMat of Polygon
	(properties)

	(method (init)
		(super init: 134 101 175 101 176 91 141 92)
	)
)

