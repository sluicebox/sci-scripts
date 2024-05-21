;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7)
(include sci.sh)
(use Main)
(use Interface)
(use CursorCoords)
(use DisplayBox)
(use Motion)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	room7 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
)

(procedure (localproc_0 param1 param2 param3 param4)
	(return
		(and
			(>= (global321 x:) param1)
			(< (global321 x:) param2)
			(>= (global321 y:) param3)
			(< (global321 y:) param4)
		)
	)
)

(class s of c
	(properties)

	(method (whiten)
		(= loop 0)
	)

	(method (forceWhite)
		(if faceUp
			(= loop 0)
		)
	)

	(method (dimCard param1)
		(if faceUp
			(= loop 1)
			(param1 incInverted:)
		)
	)

	(method (invert param1)
		(^= loop $0001)
		(if loop
			(param1 incInverted:)
		)
	)

	(method (flip)
		(^= faceUp $0001)
	)

	(method (eraseCard)
		(= erase 1)
	)

	(method (invertIfFaceUp param1)
		(if faceUp
			(^= loop $0001)
			(if loop
				(param1 incInverted:)
			)
		)
	)

	(method (eraseIfFaceUp)
		(if faceUp
			(self eraseCard:)
		)
	)

	(method (moveIfFaceUp param1)
		(if faceUp
			(= loop 0)
			(param1 add: self)
		)
	)

	(method (update)
		(proc0_2
			(if faceUp
				(+ 152 cardSuit)
			else
				(+ 290 global507)
			)
			loop
			(if faceUp cardRank else 0)
			x
			y
		)
	)
)

(class Deck of CardDeck
	(properties
		cursorX 74
		cursorY 144
		origPutX 57
		origPutY 135
		putX 57
		putY 135
		cursorZ 144
	)

	(method (endHand &tmp temp0)
		(self addAllToWorkingDeck: empty: self)
	)

	(method (handleInput)
		(if (not (self aCardToGet:))
			(= global181 1)
			(cardRoom cue:)
		else
			(= global324 0)
			(wastePile takeCard: 1)
		)
	)

	(method (checkInput)
		(if (localproc_0 putX (+ putX 35) putY (+ putY 43))
			(= global318 self)
			(global321 claimed: 1)
		)
	)

	(method (init &tmp temp0 [temp1 57])
		(super init:)
		(for ((= temp0 4)) (< temp0 56) ((++ temp0))
			(= [temp1 temp0] (Clone s))
			([temp1 temp0] cardRank: (/ temp0 4) cardSuit: (mod temp0 4))
		)
		(for ((= temp0 4)) (< temp0 56) ((++ temp0))
			(theDeck add: [temp1 temp0])
		)
		(self shuffle:)
		(global517 add: self)
	)

	(method (resetDealXY)
		(= putX origPutX)
		(= putY origPutY)
		(= dealX putX)
		(= dealY putY)
	)

	(method (showDeck param1 &tmp temp0)
		(if (> (= temp0 (* param1 2)) 6)
			(= temp0 6)
		)
		(= putX (+ origPutX temp0))
		(= putY (+ origPutY temp0))
		(proc0_2 172 0 param1 putX putY)
		(if (or (not param1) (theDeck size:))
			(proc0_2 (+ 290 global507) 0 0 putX putY)
		else
			(proc0_2 160 0 2 putX putY)
		)
	)

	(method (getCard)
		(super getCard:)
		(if (< (theDeck size:) 12)
			(self showDeck: (- 4 (/ (+ (theDeck size:) 3) 4)))
		)
	)
)

(class Column of WL
	(properties
		columnNum 1
		cardsToTake 1
		baseX 90
		baseY 6
		prevSize 0
		firstUpRank -1
		firstUpColor -1
		firstUpCardInverted -1
		lastUpColor -1
		lastUpRank -1
		lastUpCardInverted -1
		numInverted 0
		pointedAtLastCard 0
		cursorX 0
		cursorY 9
		cursorZ 9
		aCursorObj 0
		lastUpSuit -1
	)

	(method (anyFaceDownCards)
		(if size
			(if ((self at: 0) faceUp:)
				(return 0)
			else
				(return 1)
			)
		else
			(return 0)
		)
	)

	(method (findFirstUpCard &tmp temp0)
		(if size
			(for ((= temp0 0)) (< temp0 size) ((++ temp0))
				(if ((self at: temp0) faceUp:)
					(return temp0)
				)
			)
			(return (- size 1))
		else
			(return 0)
		)
	)

	(method (updateCursorCoords param1)
		(= cursorZ (+ cursorY (* (self findFirstUpCard:) 7)))
		(aCursorObj
			cursorZ:
				(if size
					(+ cursorY (* (- size 1) 7))
				else
					cursorY
				)
		)
		(if (and argc param1)
			(= local4 aCursorObj)
			(if (== local5 4)
				(SetCursor
					gTheCursor
					1
					(aCursorObj cursorX:)
					(aCursorObj cursorZ:)
				)
			)
		)
	)

	(method (init)
		(global517 add: self)
		(if (not aCursorObj)
			((= aCursorObj (CursorCoords new:))
				cursorX: cursorX
				cursorY: cursorY
			)
			(global517 add: aCursorObj)
		)
	)

	(method (unHighLight)
		(if (self seeIfAnyColumnsInverted:)
			(self forceWhite:)
		)
	)

	(method (cue)
		(switch global432
			(1
				(self addCard:)
				(columnsList eachElementDo: #setStatus)
				(global173 update:)
			)
			(2
				(self addCard:)
				(global173 update:)
			)
			(3
				(self update: 2)
				(self updateCursorCoords: 1)
			)
		)
		(cardRoom cue:)
	)

	(method (endHand &tmp temp0)
		(proc0_2 161 2 0 baseX baseY)
		(for ((= temp0 1)) (< temp0 size) ((++ temp0))
			(proc0_2 161 2 0 baseX (+ baseY (* temp0 7)))
		)
		(= prevSize 0)
		(self eachElementDo: #whiten)
		(self addAllToWorkingDeck: empty: self)
	)

	(method (giveUpCard)
		(= global173 (self at: (- size 1)))
		(global173 loop: 0)
		(proc0_2
			161
			(if (>= size 2) 0 else 2)
			0
			baseX
			(if (>= size 2)
				(+ ((self at: (- size 1)) y:) 36)
			else
				baseY
			)
		)
		(if (== size 1)
			(proc0_2 166 1 0 baseX baseY)
		)
		(if (>= size 2)
			(if ((self at: (- size 2)) faceUp:)
				(proc0_2
					(+ 152 ((self at: (- size 2)) cardSuit:))
					0
					((self at: (- size 2)) cardRank:)
					baseX
					((self at: (- size 2)) y:)
				)
			else
				(proc0_2 (+ 290 global507) 0 0 baseX ((self at: (- size 2)) y:))
			)
		)
	)

	(method (forceWhite param1)
		(= numInverted 0)
		(self eachElementDo: #forceWhite)
		(self update: 0)
		(if param1
			(cardRoom cue:)
		)
	)

	(method (resetXY &tmp temp0)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			((self at: temp0) x: baseX)
			((self at: temp0) y: (+ baseY (* temp0 7)))
		)
	)

	(method (handleInput)
		(cond
			(size
				(if ((self at: (- size 1)) faceUp:)
					(cond
						(pointedAtLastCard
							(cond
								(lastUpCardInverted
									(if firstUpCardInverted
										(self invert: 1)
									else
										(self invertLastCard: 1)
									)
								)
								((wastePile inverted:)
									(if
										(and
											(==
												(- lastUpRank 1)
												(wastePile returnRank:)
											)
											(!=
												lastUpColor
												(wastePile returnColor:)
											)
										)
										(wastePile giveUpCard:)
										(= global324 0)
										(gSndEffect
											number:
												(proc0_6
													(if (> columnNum 3)
														105
													else
														103
													)
												)
											playMaybe:
										)
										(cardToss
											init:
												(wastePile x:)
												(wastePile y:)
												baseX
												(+ (* size 7) baseY)
												[global417 (- global406 1)]
												self
												1
										)
									else
										(wastePile whiten:)
										(self invertLastCard: 1)
									)
								)
								((self seeIfAnyColumnsInverted:)
									(if (gColumn firstUpCardInverted:)
										(if
											(and
												(==
													(- lastUpRank 1)
													(gColumn firstUpRank:)
												)
												(!=
													lastUpColor
													(gColumn firstUpColor:)
												)
											)
											(gColumn transferTo: self)
										else
											(gColumn invert: 0)
											(self invertLastCard: 1)
										)
									else
										(gColumn invertLastCard: 0)
										(self invertLastCard: 1)
									)
								)
								(else
									(self invertLastCard: 1)
								)
							)
						)
						(firstUpCardInverted
							(self invert: 1)
						)
						((self seeIfAnyColumnsInverted:)
							(cond
								((== gColumn self)
									(self dimAllUpCards: 1)
								)
								((gColumn firstUpCardInverted:)
									(gColumn invert: 0)
									(self invert: 1)
								)
								(else
									(gColumn invertLastCard: 0)
									(self invert: 1)
								)
							)
						)
						(else
							(self invert: 1)
							(wastePile whiten:)
						)
					)
				else
					(self flipCard: 1)
				)
			)
			((self seeIfAnyColumnsInverted:)
				(if
					(and
						(== (gColumn firstUpRank:) 13)
						(gColumn firstUpCardInverted:)
					)
					(gColumn transferTo: self)
				else
					(gSndEffect number: 36 play:)
					(Print 7 0) ; "Illegal Play"
					(cardRoom cue:)
				)
			)
			((and (wastePile inverted:) (== (wastePile returnRank:) 13))
				(wastePile giveUpCard:)
				(gSndEffect
					number: (proc0_6 (if (> columnNum 3) 105 else 103))
					playMaybe:
				)
				(cardToss
					init:
						(wastePile x:)
						(wastePile y:)
						baseX
						baseY
						[global417 (- global406 1)]
						self
						1
				)
			)
			(else
				(gSndEffect number: 36 play:)
				(Print 7 0) ; "Illegal Play"
				(cardRoom cue:)
			)
		)
	)

	(method (seeIfAnyColumnsInverted)
		(= gColumn 0)
		(columnsList eachElementDo: #setIfInverted)
		(return gColumn)
	)

	(method (incInverted)
		(++ numInverted)
	)

	(method (dimAllUpCards param1)
		(= numInverted 0)
		(self eachElementDo: #dimCard self)
		(self update: 0)
		(if param1
			(cardRoom cue:)
		)
	)

	(method (setIfInverted)
		(if numInverted
			(= gColumn self)
		)
	)

	(method (setStatus &tmp temp0)
		(= pointedAtLastCard 0)
		(= firstUpCardInverted (= firstUpColor (= firstUpRank -1)))
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(if ((self at: temp0) faceUp:)
				(= firstUpRank ((self at: temp0) cardRank:))
				(= firstUpColor
					(if (> ((self at: temp0) cardSuit:) 1) 1 else 0)
				)
				(= firstUpCardInverted ((self at: temp0) loop:))
				(break)
			)
		)
		(= lastUpSuit (= lastUpCardInverted (= lastUpColor (= lastUpRank -1))))
		(if (and size ((self at: (- size 1)) faceUp:))
			(= lastUpRank ((self at: (- size 1)) cardRank:))
			(= lastUpColor
				(if (> ((self at: (- size 1)) cardSuit:) 1) 1 else 0)
			)
			(= lastUpCardInverted ((self at: (- size 1)) loop:))
			(= lastUpSuit ((self at: (- size 1)) cardSuit:))
		)
	)

	(method (addCard)
		(global173 erase: 0)
		(self add: global173)
		(self updateCursorCoords: (>= (gCardRoom state:) 6))
	)

	(method (invert param1)
		(= numInverted 0)
		(self eachElementDo: #invertIfFaceUp self)
		(self update: 0)
		(if param1
			(cardRoom cue:)
		)
	)

	(method (invertLastCard param1)
		(= numInverted 0)
		((self at: (- size 1)) invert: self)
		(self update: 1)
		(if param1
			(cardRoom cue:)
		)
	)

	(method (flipCard param1)
		((self at: (- size 1)) flip:)
		(self update: 1)
		(if param1
			(cardRoom cue:)
		)
	)

	(method (transferTo param1 &tmp temp0)
		(self eachElementDo: #eraseIfFaceUp)
		(self updateLastFaceDownCard:)
		(if (not ((self at: 0) erase:))
			(self update: 0)
		else
			(self update: 3)
		)
		((self at: 0) erase: 0)
		(self eachElementDo: #moveIfFaceUp param1)
		(for
			((= temp0 (- size 1)))
			(and (>= temp0 0) ((self at: temp0) faceUp:))
			((-- temp0))
			
			((self at: temp0) erase: 0)
			(self delete: (self at: temp0))
		)
		(self updateCursorCoords:)
		(= numInverted 0)
		(= prevSize size)
		(self setStatus:)
		(gSndEffect
			number:
				(proc0_6 (if (> columnNum (param1 columnNum:)) 104 else 105))
			playMaybe:
		)
		(cardToss
			init:
				baseX
				(+ baseY (* size 7))
				(param1 baseX:)
				(+ baseY (* (param1 size:) 7))
				[global417 (- global406 1)]
				param1
				3
		)
	)

	(method (updateLastFaceDownCard &tmp temp0)
		(if (== numInverted size)
			(proc0_2 166 1 0 baseX baseY)
		else
			(for ((= temp0 (- size 1))) (>= temp0 0) ((-- temp0))
				(if (not ((self at: temp0) faceUp:))
					(gDeck plotCard: (self at: temp0) 0)
					(return)
				)
			)
		)
	)

	(method (checkInput param1 &tmp temp0)
		(= temp0
			(if size
				(- size 1)
			else
				0
			)
		)
		(if (localproc_0 baseX (+ baseX 35) baseY (+ baseY 43 (* temp0 7)))
			(if
				(and
					(== numInverted 1)
					(== (param1 type:) 4)
					(== (param1 message:) 20992)
					((self at: (- size 1)) loop:)
				)
				(= global318
					(switch (= global329 ((self at: (- size 1)) cardSuit:))
						(0 spadesF)
						(1 clubsF)
						(2 diamondsF)
						(3 heartsF)
					)
				)
			else
				(= global318 self)
				(global321 claimed: 1)
				(if
					(localproc_0
						baseX
						(+ baseX 35)
						(+ baseY (* temp0 7))
						(+ baseY 43 (* temp0 7))
					)
					(= pointedAtLastCard 1)
				else
					(= pointedAtLastCard 0)
				)
			)
		)
	)

	(method (takeCard)
		(if (== size cardsToTake)
			(gCardRoom cue:)
			(return)
		)
		(gDeck getCard:)
		(global173 faceUp: (if (== size (- cardsToTake 1)) 1 else 0))
		(gSndEffect
			number: (proc0_6 (if (> columnNum 3) 102 else 100))
			playMaybe:
		)
		(cardToss
			init:
				(deck dealX:)
				(deck dealY:)
				baseX
				(+ baseY (* size 7))
				[global408 (- global405 1)]
				self
				2
		)
	)

	(method (update param1 &tmp temp0 temp1 temp2)
		(self resetXY:)
		(= temp1 (if (> prevSize size) prevSize else size))
		(for ((= temp0 0)) (< temp0 temp1) ((++ temp0))
			(switch param1
				(0
					(if ((self at: temp0) faceUp:)
						(if
							(and
								(==
									(= temp2
										(cond
											(((self at: temp0) erase:) 3)
											((!= temp0 (- temp1 1)) 1)
											(else 0)
										)
									)
									3
								)
								(== size 1)
							)
							(= prevSize size)
							(self setStatus:)
							(return)
						else
							(gDeck plotCard: (self at: temp0) temp2)
						)
					)
				)
				(1
					(if (== temp0 (- temp1 1))
						(gDeck plotCard: (self at: temp0) 0)
					)
				)
				(2
					(if (>= temp0 (- prevSize 1))
						(gDeck
							plotCard:
								(self at: temp0)
								(if (!= temp0 (- temp1 1)) 1 else 0)
						)
					)
				)
				(3
					(if (!= temp0 0)
						(proc0_2 161 0 0 baseX (+ baseY 36 (* temp0 7)))
					)
				)
			)
		)
		(= prevSize size)
		(self setStatus:)
	)
)

(class Foundation of Obj
	(properties
		suit 0
		rank 0
		view 166
		loop 0
		cel 0
		x 0
		y 0
		cursorX 0
		cursorY 0
		cursorZ 0
	)

	(method (playable param1)
		(cond
			((and (wastePile size:) (== param1 (wastePile at: 0)))
				(if
					(and
						(== (+ rank 1) (param1 cardRank:))
						(== suit (param1 cardSuit:))
					)
					(return 1)
				)
			)
			(
				(and
					(== (+ rank 1) (param1 lastUpRank:))
					(== suit (param1 lastUpSuit:))
				)
				(return 1)
			)
		)
		(return 0)
	)

	(method (cue)
		(switch global432
			(1
				(global173 erase: 0 loop: 0)
			)
		)
		(global173 update:)
		(if (not local6)
			(gIntroSong number: 41 play:)
		)
		(cardRoom cue:)
	)

	(method (endHand)
		(= rank 0)
		(self init:)
	)

	(method (handleInput)
		(= gColumn 0)
		(columnsList eachElementDo: #setIfInverted)
		(cond
			(gColumn
				(if (== (gColumn numInverted:) 1)
					(if
						(and
							(== (+ rank 1) (gColumn lastUpRank:))
							(==
								suit
								((gColumn at: (- (gColumn size:) 1))
									cardSuit:
								)
							)
						)
						(gColumn giveUpCard:)
						(gSndEffect number: (proc0_6 104) playMaybe:)
						(cardToss
							init:
								((gColumn at: (- (gColumn size:) 1)) x:)
								((gColumn at: (- (gColumn size:) 1)) y:)
								x
								y
								[global417 (- global406 1)]
								self
								1
						)
						(gColumn delete: global173)
						(gColumn setStatus:)
						(gColumn numInverted: (- (gColumn numInverted:) 1))
						(gColumn prevSize: (gColumn size:))
						(++ rank)
						(= global324 0)
						(gColumn updateCursorCoords: 1)
					else
						(gSndEffect number: 36 play:)
						(Print 7 0) ; "Illegal Play"
						(cardRoom cue:)
					)
				else
					(gSndEffect number: 36 play:)
					(Print 7 0) ; "Illegal Play"
					(cardRoom cue:)
				)
			)
			((wastePile inverted:)
				(if
					(and
						(== (+ rank 1) (wastePile returnRank:))
						(==
							suit
							((wastePile at: (- (wastePile size:) 1)) cardSuit:)
						)
					)
					(wastePile giveUpCard:)
					(gSndEffect number: (proc0_6 104) playMaybe:)
					(cardToss
						init:
							(wastePile x:)
							(wastePile y:)
							x
							y
							[global417 (- global406 1)]
							self
							2
					)
					(++ rank)
					(= global324 0)
				else
					(gSndEffect number: 36 play:)
					(Print 7 0) ; "Illegal Play"
					(cardRoom cue:)
				)
			)
			(else
				(gSndEffect number: 36 play:)
				(Print 7 1) ; "Choose a Card First."
				(cardRoom cue:)
			)
		)
	)

	(method (init)
		(proc0_2 view 0 suit x y)
		(global517 add: self)
	)

	(method (reportPoints)
		(return (* rank 5))
	)

	(method (checkInput)
		(if (localproc_0 x (+ x 35) y (+ y 43))
			(= global318 self)
			(global321 claimed: 1)
		)
	)
)

(class WastePile of WL
	(properties
		x 98
		y 141
		view 166
		cel 3
		topCardX 98
		topCardY 141
		cardsTaken 0
		cursorX 121
		cursorY 144
		cursorZ 144
	)

	(method (unHighLight)
		(if (self inverted:)
			(self whiten:)
		)
	)

	(method (cue)
		(self addCard: update:)
		(++ cardsTaken)
		(= global318 self)
		(if
			(and
				(not ((deck theDeck:) size:))
				(or (== global445 3) (== global445 2))
			)
			(= cardsTaken 0)
			(flipDeck init: 1)
		)
		(cardRoom cue:)
	)

	(method (endHand &tmp temp0)
		(self eachElementDo: #whiten)
		(self init: addAllToWorkingDeck: empty: self)
	)

	(method (setXY))

	(method (giveUpCard)
		(= global173 (self at: (- size 1)))
		(global173 loop: 0)
		(self delete: global173)
		(self update:)
	)

	(method (invert)
		((self at: (- size 1)) loop: (^ ((self at: (- size 1)) loop:) $0001))
	)

	(method (whiten)
		(if size
			((self at: (- size 1)) loop: 0)
			(self update:)
		)
	)

	(method (setTopCardCoords)
		(= cel (- 3 (/ (- size 1) 4)))
		(if (< cel 0)
			(= cel 0)
		)
		(= topCardX (- x (- 6 (* cel 2))))
		(= topCardY (- y (- 6 (* cel 2))))
	)

	(method (update)
		(if (not size)
			(self init:)
			(if (or (== global445 3) (== global445 2))
				(flipDeck init: 0)
			)
		else
			(self setTopCardCoords:)
			(proc0_2 172 2 cel topCardX topCardY)
			(proc0_2
				(+ 152 ((self at: (- size 1)) cardSuit:))
				((self at: (- size 1)) loop:)
				(self returnRank:)
				topCardX
				topCardY
			)
		)
	)

	(method (returnRank)
		((self at: (- size 1)) cardRank:)
	)

	(method (returnColor)
		(return (if (> ((self at: (- size 1)) cardSuit:) 1) 1 else 0))
	)

	(method (inverted)
		(return
			(if size
				((self at: (- size 1)) loop:)
			else
				0
			)
		)
	)

	(method (handleInput)
		(if size
			(self invert: update:)
			(= gColumn 0)
			(columnsList eachElementDo: #setIfInverted)
			(if gColumn
				(gColumn forceWhite: 0)
			)
		else
			(gSndEffect number: 36 play:)
			(Print 7 2) ; "No Cards Here!"
			(= global318 0)
		)
		(cardRoom cue:)
	)

	(method (init)
		(proc0_2 172 0 3 x y)
		(global517 add: self)
	)

	(method (checkInput param1)
		(if (localproc_0 topCardX (+ topCardX 35) topCardY (+ topCardY 43))
			(if
				(and
					size
					(== (param1 type:) 4)
					(== (param1 message:) 20992)
					((self at: (- size 1)) loop:)
				)
				(= global318
					(switch (= global329 ((self at: (- size 1)) cardSuit:))
						(0 spadesF)
						(1 clubsF)
						(2 diamondsF)
						(3 heartsF)
					)
				)
			else
				(= global318 self)
				(global321 claimed: 1)
			)
		)
	)

	(method (takeCard param1)
		(deck getCard:)
		(if size
			((self at: (- size 1)) loop: 0)
		)
		(global173 faceUp: 1)
		(= global318 self)
		(if param1
			(= cardsTaken 0)
		)
		(gSndEffect number: (proc0_6 100) playMaybe:)
		(cardToss
			init:
				(deck putX:)
				(deck putY:)
				topCardX
				topCardY
				(/ [global417 (- global406 1)] 2)
				self
				1
		)
	)

	(method (addCard &tmp temp0)
		(self setTopCardCoords:)
		(global173 x: topCardX)
		(global173 y: topCardY)
		(global173 loop: 0)
		(self add: global173)
	)
)

(class SolitareHumanPlayer of HumanPlayer
	(properties)

	(method (handleEvent event &tmp temp0)
		(if local6
			(return)
		)
		(if (== global855 1)
			(= global854 0)
		)
		(= global321 event)
		(= local5 global855)
		(if (and global324 (not (cardToss mover:)))
			(= global318 0)
			(if
				(and
					global321
					(or
						(== (global321 type:) evMOUSEBUTTON)
						(and
							(== (global321 type:) evKEYBOARD)
							(or (== global854 13) (== global854 20992))
						)
					)
				)
				(if (not (global321 claimed:))
					(columnsList eachElementDo: #checkInput event)
					(deck checkInput:)
					(wastePile checkInput: event)
					(spadesF checkInput:)
					(clubsF checkInput:)
					(diamondsF checkInput:)
					(heartsF checkInput:)
					(flipDeck doit:)
					(autoPlay doit:)
				)
				(if global318
					(global321 claimed: 1)
				)
			)
		)
		(if
			(and
				(or
					(== (global321 type:) evMOUSEBUTTON)
					(and
						(== (global321 type:) evKEYBOARD)
						(or (== global854 13) (== global854 20992))
					)
				)
				(not (global321 claimed:))
			)
			(columnsList eachElementDo: #unHighLight)
			(wastePile unHighLight:)
		)
		(global321 claimed: 1)
	)

	(method (wonTheGame))
)

(instance room7 of Rm
	(properties)

	(method (init)
		(cardRoom init:)
	)

	(method (doit)
		(gCardRoom doit:)
	)

	(method (handleEvent event param2)
		(if (== argc 2)
			(switch param2
				(1281
					(gGame setCursor: 997)
					((ScriptID 887) doit:) ; klondikeRules
					(DisposeScript 887)
					(event claimed: 1)
					(return)
				)
				(1282
					(= global445 1)
					(Print 7 3) ; "Variation Flip 1 chosen"
				)
				(1283
					(= global445 3)
					(Print 7 4) ; "Variation Flip 3 chosen"
				)
				(1284
					(= global445 2)
					(Print 7 5) ; "Variation Unlimited Flip 1 chosen"
				)
			)
		else
			(player0 handleEvent: event)
		)
	)
)

(instance cardRoom of CardRoom
	(properties)

	(method (init)
		(AddMenu
			{ Klondike }
			{Rules `^r:Original Klondike:Flip 3 Unlimited:Flip 1 Unlimited}
		)
		(MenuBar draw:)
		(= global517 inList)
		(= global264 ScoreCard)
		(= gPlayer0 player0)
		(= gPlayer1 player1)
		(= gPlayer2 player2)
		(= gPlayer3 player3)
		(= gDeck deck)
		(= gCardRoom cardRoom)
		(= global197 solitareEndThrow)
		(super init:)
		(Load rsVIEW 152)
		(Load rsVIEW 153)
		(Load rsVIEW 154)
		(Load rsVIEW 155)
		(Load rsVIEW 52)
		(Load rsVIEW 53)
		(Load rsVIEW 54)
		(Load rsVIEW 55)
		(Load rsVIEW 160)
		(Load rsSOUND 100)
		(Load rsSOUND 101)
		(Load rsSOUND 102)
		(Load rsSOUND 103)
		(Load rsSOUND 104)
		(Load rsSOUND 105)
		(Load rsSOUND 32)
		(= gScoreObj scoreObj)
		(columnsList init:)
		(= state 2)
		(= global239 0)
		(= local1 0)
		(= local2 0)
		(= local0 0)
		(= global324 0)
		(gPlayer1 sittingOut: 1)
		(gPlayer2 sittingOut: 1)
		(gPlayer3 sittingOut: 1)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(switch state
			(2
				(self cue:)
			)
			(3
				(for
					((= temp0 0))
					(< temp0 ((deck theDeck:) size:))
					((++ temp0))
					
					(saveDeck add: ((deck theDeck:) at: temp0))
				)
				(self cue:)
			)
			(4
				(if global508
					(= global508 0)
					(if (Print 7 6 #button {Yes} 1 #button {No} 0) ; "Reset Scores?"
						(= global239 (= local0 0))
					)
				)
				(= global319 0)
				(= global320 0)
				(spadesF init:)
				(clubsF init:)
				(diamondsF init:)
				(heartsF init:)
				(deck showDeck: 0)
				(wastePile init:)
				(= global318 0)
				(= global186 0)
				(columnsList eachElementDo: #numInverted 0)
				(proc0_5)
				(proc0_1 (* global407 12))
				(= local6 0)
				(self cue:)
			)
			(5
				(if (not global186)
					(++ global186)
					((columnsList at: global319) takeCard:)
				)
			)
			(6
				(= global324 1)
				(if
					(and
						(not local6)
						(not (column1 anyFaceDownCards:))
						(not (column2 anyFaceDownCards:))
						(not (column3 anyFaceDownCards:))
						(not (column4 anyFaceDownCards:))
						(not (column5 anyFaceDownCards:))
						(not (column6 anyFaceDownCards:))
						(not (column7 anyFaceDownCards:))
						(not ((deck theDeck:) size:))
						(== (wastePile size:) 0)
					)
					(autoPlay init: 1)
				)
				(if local6
					(columnsList eachElementDo: #setStatus)
					(for ((= temp0 (= temp2 0))) (< temp0 7) ((++ temp0))
						(if ((columnsList at: temp0) numInverted:)
							(= temp2 (columnsList at: temp0))
						)
					)
					(if (or temp2 (wastePile inverted:))
						(if temp2
							(switch ((temp2 at: (- (temp2 size:) 1)) cardSuit:)
								(0
									(= global318 spadesF)
								)
								(1
									(= global318 clubsF)
								)
								(2
									(= global318 diamondsF)
								)
								(3
									(= global318 heartsF)
								)
							)
						else
							(switch ((wastePile at: 0) cardSuit:)
								(0
									(= global318 spadesF)
								)
								(1
									(= global318 clubsF)
								)
								(2
									(= global318 diamondsF)
								)
								(3
									(= global318 heartsF)
								)
							)
						)
					else
						(= global318 0)
						(if (wastePile size:)
							(if (spadesF playable: (wastePile at: 0))
								(= global318 wastePile)
							)
							(if (clubsF playable: (wastePile at: 0))
								(= global318 wastePile)
							)
							(if (diamondsF playable: (wastePile at: 0))
								(= global318 wastePile)
							)
							(if (heartsF playable: (wastePile at: 0))
								(= global318 wastePile)
							)
						)
						(for ((= temp0 0)) (< temp0 7) ((++ temp0))
							(if (spadesF playable: (columnsList at: temp0))
								(= global318 (columnsList at: temp0))
								(global318 pointedAtLastCard: 1)
							)
							(if (clubsF playable: (columnsList at: temp0))
								(= global318 (columnsList at: temp0))
								(global318 pointedAtLastCard: 1)
							)
							(if (diamondsF playable: (columnsList at: temp0))
								(= global318 (columnsList at: temp0))
								(global318 pointedAtLastCard: 1)
							)
							(if (heartsF playable: (columnsList at: temp0))
								(= global318 (columnsList at: temp0))
								(global318 pointedAtLastCard: 1)
							)
						)
					)
				)
				(if global318
					(self cue:)
				)
			)
			(7
				(if (not global186)
					(++ global186)
					(if global318
						(SetMenu 1282 112 0)
						(SetMenu 1283 112 0)
						(SetMenu 1284 112 0)
						(global318 handleInput:)
					)
				)
				(if (not (cardToss mover:))
					(++ local2)
				)
				(if (> local2 2)
					(self cue:)
				)
			)
			(8
				(gGame setCursor: 997)
				(proc0_5)
				(columnsList eachElementDo: #endHand)
				(wastePile endHand:)
				(deck endHand:)
				(= local1
					(+
						(spadesF reportPoints:)
						(clubsF reportPoints:)
						(diamondsF reportPoints:)
						(heartsF reportPoints:)
					)
				)
				(++ global239)
				(if (autoPlay status0:)
					(autoPlay init: 0)
				)
				(self cue:)
			)
			(9
				(gGame setCursor: 999)
				(scoreObj display:)
				(= local0 (- (+ local0 local1) 50))
				(= local1 0)
				(self cue:)
			)
			(10
				(spadesF endHand:)
				(clubsF endHand:)
				(diamondsF endHand:)
				(heartsF endHand:)
				(proc0_5)
				((deck workingDeck:) empty: (deck workingDeck:))
				(for ((= temp0 0)) (< temp0 (saveDeck size:)) ((++ temp0))
					((deck workingDeck:) add: (saveDeck at: temp0))
				)
				(saveDeck empty: saveDeck)
				(deck showDeck: 0 reShuffle:)
				(for
					((= temp0 0))
					(< temp0 ((deck theDeck:) size:))
					((++ temp0))
					
					(saveDeck add: ((deck theDeck:) at: temp0))
				)
				(self cue:)
			)
			(15
				(gIntroSong number: 10 play:)
				(= local7 (Act new:))
				(= local8 (Act new:))
				(= local9 (Act new:))
				(local7 view: 198 posn: 140 90 setPri: 8 init:)
				(proc0_5)
				(Wait 60)
				(local7 setCel: 1)
				(proc0_5)
				(Wait 10)
				(local8 view: 198 setLoop: 1 posn: 200 133 setPri: 8 init:)
				(proc0_5)
				(Wait 45)
				(local8 setLoop: 2 setCycle: Fwd)
				(local9
					view: 198
					setLoop: 3
					posn: 180 70
					setCycle: Fwd
					setPri: 8
					init:
				)
				(++ state)
				(= global186 0)
			)
			(16
				(if (== (++ global186) 100)
					(local7 dispose:)
					(local8 dispose:)
					(local9 dispose:)
					(gIntroSong fade:)
					(= state 8)
				)
			)
		)
	)

	(method (cue)
		(switch state
			(5
				(= global186 0)
				(if (== (++ global319) (columnsList size:))
					(= global319 0)
					(if (== (++ global320) 7)
						(gGame setCursor: 999)
						(++ state)
						(columnsList eachElementDo: #setStatus)
					)
				)
			)
			(7
				(if
					(and
						(== global318 wastePile)
						(== global445 3)
						(deck aCardToGet:)
						(!= (wastePile cardsTaken:) 3)
					)
					(wastePile takeCard: 0)
					(return)
				)
				(= global186 0)
				(= local2 0)
				(if
					(and
						(== (spadesF rank:) 13)
						(== (clubsF rank:) 13)
						(== (diamondsF rank:) 13)
						(== (heartsF rank:) 13)
					)
					(= state 14)
					(= global181 1)
				)
				(if global181
					(SetMenu 1282 112 1)
					(SetMenu 1283 112 1)
					(SetMenu 1284 112 1)
					(++ state)
					(= global324 0)
					(flipDeck init: 0)
				else
					(= state 6)
					(= global318 0)
				)
			)
			(10
				(= global181 0)
				(= state 4)
				(= local4 0)
			)
			(else
				(++ state)
			)
		)
	)

	(method (removeViews)
		(deck showDeck: 5)
		(gPlayerList eachElementDo: #giveUpCards)
	)

	(method (newDeal)
		(super newDeal:)
		(self newDeal2:)
	)

	(method (setCurrentPlayer)
		(= currentPlayer (= lastPlayer 0))
	)
)

(instance player0 of SolitareHumanPlayer
	(properties
		dealFromX 42
		dealFromY 130
	)
)

(instance player1 of Player
	(properties
		playerNum 1
	)
)

(instance player2 of Player
	(properties
		playerNum 2
	)
)

(instance player3 of Player
	(properties
		playerNum 3
	)
)

(instance columnsList of WL
	(properties)

	(method (init)
		(self add: column1 column2 column3 column4 column5 column6 column7)
		(self eachElementDo: #init)
	)
)

(instance scoreObj of ScoreCard
	(properties
		x 90
		y 35
		title {KLONDIKE SCORECARD}
	)

	(method (display &tmp [temp0 200] temp200 temp201 temp202 temp203 [temp204 10] [temp214 10] [temp224 10])
		(if (== local1 260)
			(= local1 500)
		)
		(cond
			((< local0 -999)
				(= temp200 (Format @temp204 7 7 (Abs local0))) ; "-%d"
			)
			((< local0 -99)
				(= temp200 (Format @temp204 7 8 (Abs local0))) ; "- %d"
			)
			((< local0 -9)
				(= temp200 (Format @temp204 7 9 (Abs local0))) ; "- %d"
			)
			((< local0 0)
				(= temp200 (Format @temp204 7 10 (Abs local0))) ; "-  %d"
			)
			((< local0 10)
				(= temp200 (Format @temp204 7 11 local0)) ; "%d"
			)
			((< local0 100)
				(= temp200 (Format @temp204 7 12 local0)) ; "%d"
			)
			((< local0 1000)
				(= temp200 (Format @temp204 7 13 local0)) ; "%d"
			)
			(else
				(= temp200 (Format @temp204 7 14 local0)) ; "%d"
			)
		)
		(cond
			((< local1 10)
				(= temp201 (Format @temp214 7 11 local1)) ; "%d"
			)
			((< local1 100)
				(= temp201 (Format @temp214 7 12 local1)) ; "%d"
			)
			(else
				(= temp201 (Format @temp214 7 13 local1)) ; "%d"
			)
		)
		(cond
			((< (= temp203 (- (+ local0 local1) 50)) -999)
				(= temp202 (Format @temp224 7 7 (Abs temp203))) ; "-%d"
			)
			((< temp203 -99)
				(= temp202 (Format @temp224 7 8 (Abs temp203))) ; "- %d"
			)
			((< temp203 -9)
				(= temp202 (Format @temp224 7 9 (Abs temp203))) ; "- %d"
			)
			((< temp203 0)
				(= temp202 (Format @temp224 7 10 (Abs temp203))) ; "-  %d"
			)
			((< temp203 10)
				(= temp202 (Format @temp224 7 11 temp203)) ; "%d"
			)
			((< temp203 100)
				(= temp202 (Format @temp224 7 12 temp203)) ; "%d"
			)
			((< temp203 1000)
				(= temp202 (Format @temp224 7 13 temp203)) ; "%d"
			)
			(else
				(= temp202 (Format @temp224 7 14 temp203)) ; "%d"
			)
		)
		(= global199 (Format @temp0 { ---------------------------- \n}))
		(StrCat global199 (Format @global520 7 15 temp200)) ; "Previous Points    %s"
		(StrCat global199 (Format @global520 7 16 temp201)) ; "Points This Hand   %s"
		(StrCat global199 { Deduct For Each Hand__-__50\n})
		(StrCat global199 {______________________-------\n})
		(StrCat global199 (Format @global520 7 17 temp202)) ; "Net Points  %s"
		(StrCat global199 { ---------------------------- \n})
		(StrCat global199 {\n})
		(if (!= global239 1)
			(StrCat global199 (Format @global520 7 18 global239)) ; "%d Hands Played"
		else
			(StrCat global199 {________1 Hand Played})
		)
		(= global305 (Print global199 #font sFont #title title #at x y #dispose))
		(proc0_1 12200)
		(gModelessDialog dispose:)
	)
)

(instance column1 of Column
	(properties
		baseX 62
		prevSize 1
		cursorX 79
	)
)

(instance column2 of Column
	(properties
		columnNum 2
		cardsToTake 2
		baseX 98
		prevSize 2
		cursorX 115
	)
)

(instance column3 of Column
	(properties
		columnNum 3
		cardsToTake 3
		baseX 134
		prevSize 3
		cursorX 151
	)
)

(instance column4 of Column
	(properties
		columnNum 4
		cardsToTake 4
		baseX 170
		prevSize 4
		cursorX 187
	)
)

(instance column5 of Column
	(properties
		columnNum 5
		cardsToTake 5
		baseX 206
		prevSize 5
		cursorX 223
	)
)

(instance column6 of Column
	(properties
		columnNum 6
		cardsToTake 6
		baseX 242
		prevSize 6
		cursorX 259
	)
)

(instance column7 of Column
	(properties
		columnNum 7
		cardsToTake 7
		baseX 278
		prevSize 7
		cursorX 296
	)
)

(instance wastePile of WastePile
	(properties)
)

(instance spadesF of Foundation
	(properties
		x 10
		y 6
		cursorX 34
		cursorY 9
		cursorZ 9
	)
)

(instance clubsF of Foundation
	(properties
		suit 1
		cel 1
		x 10
		y 51
		cursorX 34
		cursorY 54
		cursorZ 54
	)
)

(instance diamondsF of Foundation
	(properties
		suit 2
		cel 2
		x 10
		y 96
		cursorX 34
		cursorY 99
		cursorZ 99
	)
)

(instance heartsF of Foundation
	(properties
		suit 3
		cel 3
		x 10
		y 141
		cursorX 34
		cursorY 144
		cursorZ 144
	)
)

(instance solitareEndThrow of EndThrow
	(properties)

	(method (cue)
		(= global182 (- (client x:) 17))
		(= global183 (- (client y:) 21))
		(client dispose:)
		(global173 x: global182)
		(global173 y: global183)
		(local3 cue:)
	)
)

(instance deck of Deck
	(properties
		origPutX 49
		putX 49
	)

	(method (plotCard)
		(= global184 1)
		(super plotCard: &rest)
	)
)

(instance cardToss of Act
	(properties)

	(method (init param1 param2 param3 param4 param5 param6 param7)
		(= global432 param7)
		(= local3 param6)
		(self
			view: (+ 290 global507)
			setLoop: 8
			setCel: 3
			setCycle: Fwd
			setStep: param5 param5
			setPri: 15
			posn: (+ param1 17) (+ param2 21)
			setScript: solitareEndThrow
			setMotion: MoveTo (+ param3 17) (+ param4 21) self
		)
		(super init:)
	)
)

(instance saveDeck of WL
	(properties)
)

(instance flipDeck of GO
	(properties
		x 141
		y 141
		view 160
		cursorX 172
		cursorY 144
		cursorZ 144
	)

	(method (init param1)
		(if (!= param1 status0)
			(= status0 param1)
			(proc0_2 view 0 status0 x y)
			(if param1
				(global517 add: self)
			else
				(global517 delete: self)
			)
		)
	)

	(method (doit &tmp temp0)
		(if (and status0 (localproc_0 x (+ x 35) y (+ y 43)))
			(global321 claimed: 1)
			(self init: 0)
			(for ((= temp0 0)) (< temp0 (wastePile size:)) ((++ temp0))
				((deck theDeck:) add: (wastePile at: temp0))
			)
			(wastePile empty: wastePile init:)
			(deck
				showDeck:
					(if (< ((deck theDeck:) size:) 12)
						(- 4 (/ (+ ((deck theDeck:) size:) 3) 4))
					else
						0
					)
			)
		)
	)
)

(instance autoPlay of GO
	(properties
		x 191
		y 141
		view 166
		cursorX 222
		cursorY 144
		cursorZ 144
	)

	(method (init param1)
		(= status0 param1)
		(if status0
			(proc0_2 166 2 0 x y)
			(global517 add: self)
		else
			(proc0_2 160 0 0 x y)
			(global517 delete: self)
		)
	)

	(method (doit &tmp temp0)
		(if (and status0 (localproc_0 x (+ x 35) y (+ y 43)))
			(global321 claimed: 1)
			(self init: 0)
			(= local6 1)
			(columnsList eachElementDo: #forceWhite)
			(wastePile whiten:)
		)
	)
)

(instance inList of InputList
	(properties)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16)
		(= temp7 [global241 (event message:)])
		(= temp3 60)
		(= temp4 400)
		(= temp15 0)
		(= temp10 (event x:))
		(= temp11 (- (event y:) 10))
		(if local4
			(if
				(and
					(== temp10 (local4 cursorX:))
					(== temp11 (local4 cursorZ:))
				)
				(= temp11 (local4 cursorY:))
			else
				(= local4 0)
			)
		)
		(for ((= temp5 (= temp2 0))) (< temp5 size) ((++ temp5))
			(= temp1 (self at: temp5))
			(= temp12 (temp1 cursorX:))
			(= temp13 (temp1 cursorY:))
			(= temp14 (temp1 cursorZ:))
			(if (!= temp1 local4)
				(= temp8 (GetAngle temp10 temp11 temp12 temp13))
				(if (and (== temp10 temp12) (== temp11 temp13))
					(= temp16
						(GetAngle (event x:) (- (event y:) 10) temp12 temp14)
					)
					(if (> (= temp9 (Abs (- temp7 temp16))) 180)
						(= temp9 (- 360 temp9))
					)
					(if (< temp9 60)
						(= temp8 temp7)
					)
				)
				(= temp0 (GetDistance temp10 temp11 temp12 temp13))
				(if (> (= temp9 (Abs (- temp7 temp8))) 180)
					(= temp9 (- 360 temp9))
				)
				(cond
					((< temp9 temp3)
						(= temp3 temp9)
						(= temp4 temp0)
						(= temp15 (- temp14 temp13))
						(= temp2 temp1)
					)
					((== temp9 temp3)
						(cond
							((< temp0 temp4)
								(= temp4 temp0)
								(= temp2 temp1)
								(= temp15 (- temp14 temp13))
							)
							((and (== temp0 temp4) (> (- temp14 temp13) temp15))
								(= temp2 temp1)
								(= temp15 (- temp14 temp13))
							)
						)
					)
				)
			)
		)
		(if temp2
			(= local4 temp2)
			(SetCursor gTheCursor 1 (temp2 cursorX:) (temp2 cursorZ:))
		)
	)
)

