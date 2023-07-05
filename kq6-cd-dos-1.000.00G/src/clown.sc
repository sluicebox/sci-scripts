;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 274)
(include sci.sh)
(use Main)
(use n913)
(use PolyPath)
(use Motion)
(use Actor)
(use System)

(public
	clown 0
	clownExitScr 1
	clownScr 2
)

(instance clown of Actor
	(properties
		x 206
		y 133
		noun 10
		approachX 231
		approachY 140
		view 2721
	)

	(method (doVerb theVerb)
		(cond
			((OneOf theVerb 5 1) ; Do, Look
				(gMessager say: noun theVerb (if (IsFlag 10) 7 else 8) 0 0 270)
			)
			((== theVerb 2) ; Talk
				(if (not (IsFlag 10))
					(gCurRoom setScript: (ScriptID 277 0)) ; talkClownNotFriendScr
				else
					(gCurRoom setScript: (ScriptID 277 1)) ; talkClownFriendScr
				)
			)
			((OneOf theVerb 40 70) ; coin, royalRing
				(cond
					((not (IsFlag 78))
						(gMessager say: noun theVerb 10 0 0 270)
					)
					((IsFlag 10)
						(gCurRoom setScript: (ScriptID 277 2) 0 theVerb) ; showClownScr
					)
					(else
						(gGame givePoints: 4)
						(SetFlag 10)
						(gCurRoom
							setScript:
								(ScriptID 275 0) ; giveRingScr
								0
								(if (== theVerb 40) 1 else 0) ; coin
						)
					)
				)
			)
			((OneOf theVerb 69 13) ; ring, mirror
				(super doVerb: theVerb &rest)
			)
			(
				(or
					(OneOf theVerb 45 8 14 30 47 15 18) ; clothes, dagger, potion, feather, flower, hair, cassimaHair
					(OneOf theVerb 32 12 62 63 65 66 67) ; poem, map, milk, mint, note, pearl, peppermint
				)
				(if (== theVerb 15) ; hair
					(= theVerb 18) ; cassimaHair
				)
				(if (== theVerb 67) ; peppermint
					(= theVerb 63) ; mint
				)
				(gCurRoom setScript: (ScriptID 277 2) 0 theVerb) ; showClownScr
			)
			(else
				(gCurRoom setScript: (ScriptID 277 2)) ; showClownScr
			)
		)
	)

	(method (init)
		(super init: &rest)
		(self
			approachVerbs: 5 2 70 ; Do, Talk, royalRing
			illegalBits: 0
			ignoreActors:
			setScript: (ScriptID 274 2) ; clownScr
		)
	)
)

(instance clownScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client view: 2721 loop: 0)
				(= cycles 1)
			)
			(1
				(= seconds (Random 5 20))
			)
			(2
				(client cel: 0 setCycle: End self)
			)
			(3
				(client stopUpd:)
				(= state 0)
				(self cue:)
			)
		)
	)
)

(instance clownExitScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(DisposeScript 275)
				(gEgo stopUpd:)
				(clown
					posn: 201 137
					view: 2741
					setLoop: 0
					scaleX: 121
					scaleY: 121
					setStep: 5 3
					setScale:
					setCycle: Walk
					setSpeed: 4
					setMotion: PolyPath 107 135 self
				)
			)
			(2
				(clown
					setPri: 1
					view: 274
					loop: 1
					cel: 0
					posn: 72 135
					cycleSpeed: 6
					setCycle: End
				)
				(gGlobalSound4 number: 901 loop: 1 play:)
				((ScriptID 270 4) setCycle: End self) ; shopDoor
			)
			(3
				((ScriptID 270 4) setCycle: Beg self) ; shopDoor
			)
			(4
				(clown dispose:)
				(gGlobalSound4 number: 902 loop: 1 play:)
				(gEgo startUpd:)
				(= cycles 2)
			)
			(5
				((ScriptID 270 4) stopUpd:) ; shopDoor
				((ScriptID 10 0) setIt: 2) ; rgCrown
				(gGlobalSound fade: 0 20 15 0)
				(= ticks 45)
			)
			(6
				(UnLoad 128 2741)
				(UnLoad 128 274)
				(gGlobalSound number: 240 loop: -1 play: 0 fade: 70 10 15 0)
				(gGame handsOn:)
				(gTheIconBar curIcon: (gTheIconBar at: 0))
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
				(= seconds 13)
			)
			(7
				((ScriptID 270 5) init:) ; clownChair
				((ScriptID 10 0) clrIt: 2) ; rgCrown
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(ClearFlag 53)
		(if (not (OneOf gAct 3 4))
			(ClearFlag 54)
		else
			(SetFlag 54)
		)
		(clown dispose:)
		(clown delete:)
		(DisposeScript 274)
	)
)

