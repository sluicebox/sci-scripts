;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 702)
(include sci.sh)
(use Main)
(use Piles)
(use Print)
(use Motion)
(use Actor)
(use System)

(class Trick of List
	(properties
		nsLeft 100
		nsRight 220
		nsTop 85
		nsBottom 115
		northX 142
		northY 56
		southX 142
		southY 104
		eastX 182
		eastY 80
		westX 102
		westY 80
		trump -1
		highTrump 0
		highOfSuitLead 0
		leader 0
		highPlayer 0
		highCard 0
		suitLead -1
		northPlayer 0
		southPlayer 0
		eastPlayer 0
		westPlayer 0
		tricksPlayed 0
		numCardsInATrick 4
	)

	(method (init)
		(= gTheCard2 theCard2)
		(= gTheCard3 theCard3)
		(= gTrick self)
	)

	(method (dispose)
		(= gTheCard2 0)
		(= gTheCard3 0)
		(= gTrick 0)
		(super dispose:)
	)

	(method (doCode)
		(return 1)
	)

	(method (endTrick &tmp temp0)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			((ScriptID 15 1) add: (self at: temp0)) ; discardList
		)
		(self release:)
		(= highOfSuitLead (= highTrump 0))
		(= leader highPlayer)
		(= highCard 0)
		(= suitLead -1)
		(++ tricksPlayed)
	)

	(method (add param1 param2)
		(if (not argc)
			(super add:)
		else
			(super add: param1)
			(if (or (< argc 2) (not param2))
				(param1 deleteKeyMouse:)
			)
			(cond
				((== size 1)
					(if (== (= suitLead (param1 suit:)) trump)
						(= highTrump (param1 rank:))
					)
					(= highOfSuitLead (param1 rank:))
					(= highPlayer (Dealer curPlayer:))
					(= highCard param1)
				)
				((== (param1 suit:) trump)
					(if (> (param1 rank:) highTrump)
						(= highTrump (param1 rank:))
						(if (== suitLead trump)
							(= highOfSuitLead (param1 rank:))
						)
						(= highPlayer (Dealer curPlayer:))
						(= highCard param1)
					)
				)
				(
					(and
						(not highTrump)
						(== (param1 suit:) suitLead)
						(> (param1 rank:) highOfSuitLead)
					)
					(= highOfSuitLead (param1 rank:))
					(= highPlayer (Dealer curPlayer:))
					(= highCard param1)
				)
			)
		)
	)

	(method (isValid)
		(return 1)
	)

	(method (calcNextX)
		(return
			(switch ((Dealer curPlayer:) location:)
				(1 northX)
				(3 southX)
				(2 eastX)
				(4 westX)
			)
		)
	)

	(method (calcNextY)
		(return
			(switch ((Dealer curPlayer:) location:)
				(1 northY)
				(3 southY)
				(2 eastY)
				(4 westY)
			)
		)
	)

	(method (setCard param1 param2 &tmp temp0)
		(gSound play: 907)
		(= global291 (+ 2 size))
		(param1
			flip: 1
			posn: (self calcNextX:) (self calcNextY:)
			setLoop: 0
			setPri: (+ 2 size)
			show:
			forceUpd:
		)
		(if (and (>= argc 2) param2)
			(param1 startUpd:)
		)
		(self add: param1)
		(RedrawCast)
		(if (== size numCardsInATrick)
			((gCurRoom script:) setScript: trickScript)
		else
			((gCurRoom script:) cue:)
		)
	)

	(method (validPlay param1 param2 &tmp temp0)
		(if (and (!= suitLead -1) (!= (param1 suit:) suitLead))
			(for ((= temp0 0)) (< temp0 (param2 size:)) ((++ temp0))
				(if (== ((param2 at: temp0) suit:) suitLead)
					(param1 stopUpd:)
					(gSound play: 905)
					(Message msgGET 702 1 43 0 1 @global550) ; "You must follow suit since you have a valid play."
					(Print addText: @global550 init:)
					(param1 startUpd:)
					(return 0)
				)
			)
		)
		(return 1)
	)

	(method (checkCard param1)
		(proc15_0 self param1)
	)
)

(instance trickScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks (* global386 20))
			)
			(1
				(= temp4 0)
				(for
					((= temp0 0))
					(< temp0 (gTrick numCardsInATrick:))
					((++ temp0))
					
					(= temp1 (gTrick highCard:))
					(if (!= (= temp3 (gTrick at: temp0)) temp1)
						(= temp2
							(switch ((gTrick highPlayer:) partner:)
								((gTrick northPlayer:)
									(+
										8
										(*
											2
											(and
												(==
													(temp3 x:)
													(gTrick northX:)
												)
												(==
													(temp3 y:)
													(gTrick northY:)
												)
											)
										)
									)
								)
								((gTrick southPlayer:)
									(+
										8
										(*
											2
											(and
												(==
													(temp3 x:)
													(gTrick southX:)
												)
												(==
													(temp3 y:)
													(gTrick southY:)
												)
											)
										)
									)
								)
								((gTrick eastPlayer:)
									(+
										6
										(*
											6
											(and
												(==
													(temp3 x:)
													(gTrick eastX:)
												)
												(==
													(temp3 y:)
													(gTrick eastY:)
												)
											)
										)
									)
								)
								((gTrick westPlayer:)
									(+
										6
										(*
											6
											(and
												(==
													(temp3 x:)
													(gTrick westX:)
												)
												(==
													(temp3 y:)
													(gTrick westY:)
												)
											)
										)
									)
								)
							)
						)
						(switch temp4
							(0
								(= temp4 gTheCard1)
							)
							(gTheCard1
								(= temp4 gTheCard2)
							)
							(gTheCard2
								(= temp4 gTheCard3)
							)
						)
						(temp3 stopUpd: hide:)
						(temp4
							view: (temp3 view:)
							setLoop: 0
							cel: (temp3 cel:)
							posn: (temp3 x:) (+ (temp3 y:) 1)
							setStep: temp2 temp2
							setPri: 1
							moveSpeed: 0
							setMotion: MoveTo (temp1 x:) (+ (temp1 y:) 1) self
							ignoreActors:
							ignoreHorizon:
							show:
							init:
						)
					)
				)
				(RedrawCast)
				(gSound play: 906)
			)
			(2 0)
			(3
				(if (== (gTrick numCardsInATrick:) 3)
					(= cycles 1)
				)
			)
			(4
				(gTheCard1 hide:)
				(gTheCard2 hide:)
				(gTheCard3 hide:)
				(= cycles 1)
			)
			(5
				((gTrick highCard:) stopUpd: hide:)
				(= temp5
					(switch global387
						(0 300)
						(1 20)
						(2 10)
					)
				)
				(gTheCard1
					view: ((gTrick highCard:) view:)
					setLoop: 0
					cel: ((gTrick highCard:) cel:)
					posn: ((gTrick highCard:) x:) ((gTrick highCard:) y:)
					setStep: temp5 temp5
					setPri: 14
					moveSpeed: 0
					ignoreActors:
					ignoreHorizon:
					show:
					init:
				)
				(switch (gTrick highPlayer:)
					((gTrick northPlayer:)
						(if gAddToTricksWon
							(gAddToTricksWon doit: (gTrick northPlayer:))
						)
						(gTheCard1
							setMotion: MoveTo (gTrick northX:) -50 self
						)
					)
					((gTrick southPlayer:)
						(if gAddToTricksWon
							(gAddToTricksWon doit: (gTrick southPlayer:))
						)
						(gTheCard1
							setMotion: MoveTo (gTrick southX:) 205 self
						)
					)
					((gTrick eastPlayer:)
						(if gAddToTricksWon
							(gAddToTricksWon doit: (gTrick eastPlayer:))
						)
						(gTheCard1
							setMotion: MoveTo 325 (gTrick eastY:) self
						)
					)
					((gTrick westPlayer:)
						(if gAddToTricksWon
							(gAddToTricksWon doit: (gTrick westPlayer:))
						)
						(gTheCard1
							setMotion: MoveTo -40 (gTrick westY:) self
						)
					)
				)
				(gSound play: (if global253 global253 else 907))
				(= global253 0)
			)
			(6
				(gTheCard1 hide:)
				(gTrick endTrick:)
				((gCurRoom script:) setScript: 0 cue:)
			)
		)
	)
)

(instance theCard2 of Actor
	(properties)
)

(instance theCard3 of Actor
	(properties)
)

