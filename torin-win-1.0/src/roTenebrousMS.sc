;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50800)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use TPScript)
(use foEExit)
(use PolyPath)
(use Polygon)
(use Motion)

(public
	roTenebrousMS 0
)

(instance foBackStageExit of ExitFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 1)) ; oNorthCursor
		(self setRect: 298 88 408 228)
	)

	(method (doVerb)
		(gEgo setScript: soEnterBackstage)
	)
)

(instance soEnterBackstage of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 350 232 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 0 self)
			)
			(2
				(gCurRoom newRoom: 50900) ; roBackstageAmp
				(self dispose:)
			)
		)
	)
)

(instance soPlayMovie of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo hide:)
				(= seconds 2)
			)
			(1
				(gEgo
					posn: 605 443
					show:
					setLoop: 7 1
					setMotion: MoveTo 98 278 self
				)
			)
			(2
				(gEgo setPri: 1 setMotion: MoveTo 6 441 self)
			)
			(3
				(= ticks 60)
			)
			(4
				(gEgo
					setScalePercent: 10
					posn: 29 290
					setLoop: -1
					setStep: 1 1
					doit:
					setMotion: MoveTo 46 265 self
				)
			)
			(5
				(gCurRoom picture: 50801)
				(gCurRoom drawPic: 50801)
				(gEgo hide:)
				(= seconds 2)
			)
			(6
				(gEgo
					posn: 662 310
					normalize:
					show:
					setMotion: MoveTo 602 310 self
				)
			)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance roTenebrousMS of TPRoom
	(properties
		picture 50800
	)

	(method (init)
		(super init: &rest)
		(goMusic1 setMusic: 50400)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 3 285 3 310 6 313 628 314 629 288 575 283 508 252 478 232 211 233 194 251 127 287
					yourself:
				)
		)
		(foBackStageExit init:)
		(gEgo init: normalize:)
		(gCurRoom setScript: soPlayMovie)
	)

	(method (gimme))
)

