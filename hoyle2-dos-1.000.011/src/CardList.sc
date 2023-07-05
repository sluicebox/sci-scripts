;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 301)
(include sci.sh)
(use Main)
(use Column)
(use WL)
(use PlayDealer)
(use CountCombinations)
(use CountPoker)
(use BowlingScoreSheet)
(use n318)
(use n322)
(use theSliders)
(use n324)

(class CardList of WL
	(properties
		x 0
		y 0
		dir 3
		width 35
		height 43
		whenEmpty 1
		stage 1
		dimRule 4
		dimmedObj 0
		fillEmptyWith 13
		playDealNumber 0
		wrap 0
		layoutRecieves 0
		playDealFaceUp 1
		adjXY 6
		cel -1
		growingDeck 1
		digDown 104
		growingStep 4
		active 0
		numFaceDown 0
		buildManner 0
		buildDirection 1
		autoFaceUp 0
		autoFill 0
		theAutoFillSource1 0
		theAutoFillSource2 0
		maxCardsAllowed 104
		rankToBottom 0
		skippedOver 0
		gatherForReDeal 0
		foundationWithin 0
		removeFoundationsWithin 1
		dontBuildFoundationsYet 0
		priority 8
		rowNumber 0
		marked 0
		underBits 0
	)

	(method (init)
		(if theAutoFillSource1
			(= global324 self)
		)
		(if theAutoFillSource2
			(= global325 self)
		)
		(if (or (== dir 1) (== dir 2) (== dir 0))
			(= growingDeck 0)
		)
		(if (not (gTheInputList contains: self))
			(gTheInputList add: self)
		)
		(if (and layoutRecieves (not (gTheDealer contains: self)))
			(gTheDealer add: self)
		)
		(if (and playDealNumber (not argc))
			(for ((= global301 0)) (< global301 playDealNumber) ((++ global301))
				(gTheStock addReciever: self)
			)
		)
	)

	(method (whiten))

	(method (init2)
		(if (!= whenEmpty 0)
			(proc0_1 (+ 400 global679) 0 whenEmpty x y priority)
		)
	)

	(method (limitDigDown param1)
		(if (<= param1 (- (- size 1) digDown))
			(= param1 (- size digDown))
		)
		(return param1)
	)

	(method (showStock &tmp temp0 temp1)
		(if size
			(if (not growingStep)
				(= growingStep 4)
			)
			(if (< (= temp0 (- 4 (/ (+ size (- growingStep 1)) growingStep))) 0)
				(= temp0 0)
			)
		else
			(= temp0 4)
			(self showEmpty:)
			(return)
		)
		(= temp1 0)
		(if (!= temp0 cel)
			(= temp1 1)
			(= cel temp0)
			(= adjXY (* (- 3 cel) 2))
			(if (< adjXY 0)
				(= adjXY 0)
			)
			(proc0_1 (+ 220 global679) 0 cel (- x adjXY) (- y adjXY) priority)
		)
		(if
			(and
				(or temp1 autoFaceUp ((self at: (- size 1)) faceUp:))
				(<= cel 3)
			)
			(if
				(or
					(and (not (gTheDealer currentlyActive:)) autoFaceUp)
					((self at: (- size 1)) faceUp:)
				)
				((self at: (- size 1)) faceUp: 1)
				(proc0_1
					((self at: (- size 1)) suit:)
					((self at: (- size 1)) dimmed:)
					((self at: (- size 1)) rank:)
					(- x adjXY)
					(- y adjXY)
					priority
				)
			else
				(proc0_1 200 0 global300 (- x adjXY) (- y adjXY) priority)
			)
		)
	)

	(method (cue param1 &tmp [temp0 2])
		(self addCards: (if argc param1 else 0) updateCoords:)
		(if
			(and
				(or
					(proc0_6 101)
					(proc0_6 118)
					(proc0_6 119)
					(proc0_6 126)
					(proc0_6 127)
				)
				(gTheWastePiles contains: self)
			)
			((self at: 0) dim: faceUp: 1)
			(if (and (proc0_6 127) global682)
				((self at: 0) whiten:)
				(= global682 0)
			)
		)
		(if (and (proc0_6 124) (proc304_0 self))
			(= underBits (Graph grSAVE_BOX y x (+ y 43) (+ x 35) 1))
		)
		(self showUpdate:)
		(if foundationWithin
			(proc318_0 self)
		)
		(if (proc0_6 117)
			(proc324_0 self)
		)
		(gCurRoom cue:)
	)

	(method (endHand)
		(super endHand:)
		(self giveUpCards: 1)
		(= skippedOver 0)
	)

	(method (addCards param1 &tmp temp0 temp1)
		(if (and (PlayDealer currentlyActive:) (self numDimmed:))
			(self eachElementDo: #whiten)
		)
		(= temp1 (if (and argc param1) param1 else gTheTransferList))
		(temp1 eachElementDo: #whiten)
		(for ((= temp0 0)) (< temp0 (temp1 size:)) ((++ temp0))
			(if
				(and
					(== (temp1 size:) 1)
					(gTheDealer currentlyActive:)
					(== ((temp1 at: 0) rank:) rankToBottom)
				)
				(self addToFront: (temp1 at: temp0))
				(self eachElementDo: #changed 1)
			else
				(self add: (temp1 at: temp0))
			)
		)
		(temp1 empty:)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 [temp3 2])
		(if
			(and
				(not (event claimed:))
				(== (event type:) evMOUSEBUTTON)
				(>= (gTheCardToss x:) 400)
			)
			(if (proc0_6 118)
				(gTheSliders eachElementDo: #handleEvent event)
			)
			(if
				(or
					(and
						(not growingDeck)
						(<=
							x
							(event x:)
							(-
								(+
									x
									(if
										(or
											(not (proc0_6 122))
											(> (event x:) 258)
										)
										width
									else
										21
									)
								)
								1
							)
						)
						(<= y (event y:) (- (+ y height) 1))
					)
					(and
						growingDeck
						(<= (- x adjXY) (event x:) (- (+ (- x adjXY) width) 1))
						(<=
							(- y adjXY)
							(event y:)
							(- (+ (- y adjXY) height) 1)
						)
					)
				)
				(if
					(and
						global311
						(or
							(& (event modifiers:) emALT)
							(& (event modifiers:) emCTRL)
							(& (event modifiers:) emSHIFT)
						)
					)
					(= temp1
						(if (== dimRule 1)
							(self
								at:
									(self
										inWhatCardNum: (event x:) (event y:)
									)
							)
						else
							(self lastCard:)
						)
					)
					(if
						(and
							(not (global311 contains: self))
							size
							(temp1 faceUp:)
							(!= dimRule 8)
							(or
								(not (= temp0 (self isThereADimmedObject: 1)))
								(== (temp0 numDimmed:) 1)
							)
							(or (not (proc0_6 101)) (not (gTheStock size:)))
						)
						(for
							((= temp2 0))
							(< temp2 (global311 size:))
							((++ temp2))
							
							(if
								((global311 at: temp2)
									moveOK2:
										temp1
										((global311 at: temp2) lastCard:)
										0
								)
								(temp1 dim:)
								(self giveUpCards:)
								(gTheCardToss init: temp1 (global311 at: temp2))
								(return 0)
							)
						)
					)
				)
				(if (and (proc0_6 119) (proc314_5 self))
					(return)
				)
				(self
					handleInput:
						(self inWhatCardNum: (event x:) (event y:))
						event
				)
				(return self)
			)
		)
		(return 0)
	)

	(method (inWhatCardNum param1 param2)
		(if (== dir 3)
			(return (- size 1))
		)
		(for ((= global301 0)) (< global301 size) ((++ global301))
			(if ((self at: global301) inRect: param1 param2)
				(return global301)
			)
		)
	)

	(method (numDimmed &tmp temp0)
		(= temp0 0)
		(if size
			(for
				((= global301
					(if (!= dir 3)
						0
					else
						(- size 1)
					)
				))
				(< global301 size)
				((++ global301))
				
				(+= temp0 ((self at: global301) dimmed:))
			)
		)
		(return temp0)
	)

	(method (numFaceUp &tmp temp0)
		(= temp0 0)
		(if size
			(= global301
				(if (!= dir 3)
					0
				else
					(- size 1)
				)
			)
			(= temp0 0)
			(while (< global301 size)
				(+= temp0 ((self at: global301) faceUp:))
				(++ global301)
			)
		)
		(return temp0)
	)

	(method (firstDimmed param1)
		(if size
			(for
				((= global301
					(if (!= dir 3)
						0
					else
						(- size 1)
					)
				))
				(< global301 size)
				((++ global301))
				
				(if ((self at: global301) dimmed:)
					(return
						(if (and argc (== param1 1))
							global301
						else
							(self at: global301)
						)
					)
				)
			)
		)
		(return 0)
	)

	(method (updateCoords &tmp [temp0 2])
		(if size
			(for ((= global301 0)) (< global301 size) ((++ global301))
				(switch dir
					(1
						((self at: global301)
							x: (+ x (* global301 7))
							y: y
							width: (if (== global301 (- size 1)) 35 else 7)
							height: 43
						)
					)
					(2
						(if (and (proc0_6 118) (== self (gTheReserves at: 1)))
							((self at: global301)
								x: (+ x (* (mod global301 3) 7))
								y: (+ y (* (/ global301 3) 7))
								width: (if (== global301 (- size 1)) 35 else 7)
								height: (if (== global301 (- size 1)) 43 else 7)
							)
						else
							((self at: global301)
								x: x
								y: (+ y (* global301 7))
								width: 35
								height: (if (== global301 (- size 1)) 43 else 7)
							)
						)
					)
					(else
						((self at: global301) x: x y: y width: 35 height: 43)
					)
				)
			)
		)
		(self updateArea:)
	)

	(method (handleInput))

	(method (updateArea)
		(= width 35)
		(= height 43)
		(if (> size 1)
			(= width
				(if (!= dir 1)
					35
				else
					(+ 35 (* (- size 1) 7))
				)
			)
			(= height
				(if (!= dir 2)
					43
				else
					(+ 43 (* (- size 1) 7))
				)
			)
		)
	)

	(method (showUpdate &tmp temp0)
		(cond
			((== dir 3)
				(cond
					(growingDeck
						(self showStock:)
					)
					(size
						(= temp0 (self at: (- size 1)))
						(if (temp0 changed:)
							(temp0 changed: 0)
							(if (temp0 faceUp:)
								(proc0_1
									(temp0 suit:)
									0
									(temp0 rank:)
									(temp0 x:)
									(temp0 y:)
									priority
								)
							else
								(proc0_1
									200
									0
									global300
									(temp0 x:)
									(temp0 y:)
									priority
								)
							)
						)
					)
					(else
						(self showEmpty:)
					)
				)
			)
			(size
				(for ((= global301 0)) (< global301 size) ((++ global301))
					(if ((self at: global301) changed:)
						((self at: global301) changed: 0)
						(if ((self at: global301) faceUp:)
							(proc0_1
								(+
									((self at: global301) suit:)
									(if (== global301 (- size 1)) 0 else 100)
								)
								(cond
									((== global301 (- size 1))
										(+ 0 ((self at: global301) dimmed:))
									)
									((== dir 1)
										((self at: global301) dimmed:)
									)
									(else
										(+ 2 ((self at: global301) dimmed:))
									)
								)
								((self at: global301) rank:)
								((self at: global301) x:)
								((self at: global301) y:)
								priority
							)
						else
							(proc0_1
								200
								(cond
									((== global301 (- size 1)) 0)
									((== dir 1) 1)
									(else 2)
								)
								global300
								((self at: global301) x:)
								((self at: global301) y:)
								priority
							)
						)
					)
				)
			)
			(else
				(self showEmpty:)
			)
		)
	)

	(method (nextX &tmp temp0)
		(= temp0 (+ x 17))
		(return
			(if (== dir 1)
				(+ temp0 (* (- size 1) 7))
			else
				temp0
			)
		)
	)

	(method (nextY &tmp temp0)
		(if (and (proc0_6 118) (== self (gTheReserves at: 1)))
			(return (+ y 21 (* (/ ((gTheReserves at: 1) size:) 3) 7)))
		)
		(= temp0 (+ y 21))
		(return
			(if (== dir 2)
				(+ temp0 (* (- size 1) 7))
			else
				temp0
			)
		)
	)

	(method (lastCard)
		(if size
			(return (self at: (- size 1)))
		else
			(return 0)
		)
	)

	(method (firstFaceUp param1)
		(for ((= global301 0)) (< global301 size) ((++ global301))
			(if ((self at: global301) faceUp:)
				(return
					(if (and argc (== param1 1))
						global301
					else
						(self at: global301)
					)
				)
			)
		)
		(return 0)
	)

	(method (isThereADimmedObject param1 &tmp temp0 temp1)
		(for ((= temp0 (= temp1 0))) (< temp0 (gTheInputList size:)) ((++ temp0))
			(if
				(and
					((gTheInputList at: temp0) size:)
					((gTheInputList at: temp0) numDimmed:)
					(== (++ temp1) param1)
				)
				(return (gTheInputList at: temp0))
			)
		)
		(return 0)
	)

	(method (howManyDimmedObjects &tmp temp0 temp1)
		(for ((= temp0 (= temp1 0))) (< temp0 (gTheInputList size:)) ((++ temp0))
			(if
				(and
					((gTheInputList at: temp0) size:)
					((gTheInputList at: temp0) numDimmed:)
				)
				(++ temp1)
			)
		)
		(return temp1)
	)

	(method (firstDimRank)
		(return
			(if size
				((self firstDimmed:) rank:)
			else
				0
			)
		)
	)

	(method (transferCards param1 &tmp temp0 [temp1 2])
		(= temp0 (if (and argc param1) param1 else gTheTransferList))
		(temp0 eachElementDo: #whiten)
		(if (proc0_6 118)
			(proc323_5 self temp0)
		)
		(if (not (proc0_6 118))
			(for ((= global301 0)) (< global301 (temp0 size:)) ((++ global301))
				(self add: (temp0 at: global301))
			)
			(temp0 empty:)
			(self updateCoords: showUpdate:)
		else
			(proc323_6 self temp0)
		)
		(proc0_2)
		(if (proc0_6 119)
			(proc314_1 self)
		)
		(if foundationWithin
			(proc318_0 self)
		)
		(if (proc0_6 122)
			(proc322_2)
		)
		(if (and (proc0_6 127) (gTheColumns contains: self))
			(= global400 (CountCombinations init:))
			(proc0_4)
		)
		(if (and (proc0_6 126) (gTheColumns contains: self))
			(= global400 (CountPoker init:))
			(proc0_4)
		)
		(if (and (proc0_6 118) (gTheColumns contains: self))
			(proc323_2 self)
		)
	)

	(method (eraseMovedCards param1 &tmp temp0 temp1 temp2)
		(if (!= dir 3)
			(= temp0 (- param1 size))
			(if (not size)
				(-- temp0)
			)
			(cond
				((and (proc0_6 118) (== self (gTheReserves at: 1)))
					(for
						((= global301 0))
						(< global301 (+ temp0 1))
						((++ global301))
						
						(proc0_1
							(+ 400 global679)
							0
							0
							(+ x (* (mod global301 3) 7))
							(+ y (* (/ global301 3) 7))
							priority
						)
					)
				)
				((== dir 1)
					(= temp1 (+ x width))
					(= temp2 y)
					(for ((= global301 0)) (< global301 temp0) ((++ global301))
						(proc0_1 13 dir global679 temp1 temp2 priority)
						(+= temp1 7)
					)
				)
				((== dir 2)
					(= temp1 x)
					(= temp2 (+ y height))
					(for ((= global301 0)) (< global301 temp0) ((++ global301))
						(proc0_1 13 dir global679 temp1 temp2 priority)
						(+= temp2 7)
					)
				)
			)
		)
	)

	(method (showEmpty &tmp temp0)
		(proc0_1 (+ 400 global679) 0 whenEmpty x y priority)
		(if (and global330 autoFill)
			(= temp0 0)
			(cond
				((and global324 (global324 size:))
					(= temp0 global324)
				)
				((and global325 (global325 size:))
					(= temp0 global325)
				)
			)
			(if temp0
				(gTheTransferList2 empty:)
				(gTheTransferList2 add: (temp0 giveUpCard:))
				((gTheTransferList2 at: 0) faceUp: 1)
				(gTheAutoCardToss init: temp0 self)
			)
		)
	)

	(method (giveUpCards param1 param2 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp0 size)
		(= temp2 (if (== param1 1) 1 else 0))
		(= temp3 (if (IsObject param1) param1 else gTheTransferList))
		(temp3 empty:)
		(= temp1 0)
		(if size
			(= temp4 0)
			(= temp1 -1)
			(while (< temp4 size)
				(cond
					((and (== argc 1) temp2)
						(temp3 add: (self at: temp4))
						(= temp1 0)
					)
					(((self at: temp4) dimmed:)
						(if (== temp1 -1)
							(= temp1 temp4)
						)
						(temp3 add: (self at: temp4))
					)
				)
				(++ temp4)
			)
		)
		(if (and (== argc 1) temp2)
			(self empty:)
		else
			(for ((= temp4 (- size 1))) (>= temp4 0) ((-- temp4))
				(if ((self at: temp4) dimmed:)
					(self delete: (self at: temp4))
				)
			)
		)
		(for ((= temp4 (- temp1 1))) (< temp4 size) ((++ temp4))
			(if (and (== temp4 (- temp1 1)) autoFaceUp (>= temp4 0))
				((self at: temp4) faceUp: 1)
			)
			(if (>= temp4 0)
				((self at: temp4) changed: 1)
			)
		)
		(if (and (== argc 2) param2)
			(return)
		)
		(self updateCoords: showUpdate: eraseMovedCards: temp0)
	)

	(method (shuffle &tmp temp0)
		(gTheWorkingDeck empty:)
		(for ((= global301 0)) (< global301 3) ((++ global301))
			(while (>= (- size 1) 0)
				(= global302 (self at: (Random 0 (- size 1))))
				(gTheWorkingDeck add: global302)
				(self delete: global302)
			)
			(while (>= (- (gTheWorkingDeck size:) 1) 0)
				(= global302 (gTheWorkingDeck at: (Random 0 (- (gTheWorkingDeck size:) 1))))
				(self add: global302)
				(gTheWorkingDeck delete: global302)
			)
		)
	)

	(method (gather &tmp temp0)
		(if (and size gatherForReDeal (or (not (proc0_6 122)) (proc322_4 self)))
			(for ((= global301 (- size 1))) (>= global301 0) ((-- global301))
				(gTheTransferList add: (self at: global301))
			)
			(= temp0 size)
			(self eachElementDo: #dimmed 0 empty:)
			(self updateCoords: showUpdate: eraseMovedCards: temp0)
			(if growingDeck
				(proc0_1 (+ 220 global679) 0 4 x y priority)
			)
		)
	)

	(method (setOrigDest param1 param2)
		(= global630 (param1 suit:))
		(= global631 (param1 rank:))
		(= global632 (param1 color:))
		(if (IsObject param2)
			(= global634 (param2 rank:))
			(= global633 (param2 suit:))
			(= global635 (param2 color:))
		else
			(= global634 0)
			(= global633 -1)
			(= global635 -1)
		)
		(if (== global631 1)
			(= global631 global316)
		)
		(if (== global634 1)
			(= global634 global316)
		)
	)

	(method (buildMannerOK)
		(return
			(or
				(and (== buildManner 0) (!= global632 global635))
				(and
					(== buildManner 1)
					(or (== global635 -1) (== global632 global635))
				)
				(and
					(== buildManner 3)
					(or (== global633 -1) (== global630 global633))
				)
				(and (== buildManner 4) (!= global630 global633))
				(== buildManner 2)
			)
		)
	)
)

