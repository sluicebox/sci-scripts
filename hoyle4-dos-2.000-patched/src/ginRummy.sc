;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 400)
(include sci.sh)
(use Main)
(use KeyMouse)
(use Piles)
(use TrackingView)
(use Character)
(use n402)
(use n403)
(use n404)
(use n405)
(use n406)
(use Print)
(use File)
(use Actor)
(use System)

(public
	ginRummy 0
	proc400_1 1
	discardPile 2
	variantCode 3
	disposeList 4
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
	[local8 2]
	local10
	local11
	local12
	local13
	local14
	[local15 3]
	[local18 3]
	local21
	local22
	local23
	local24
	local25
	local26
	local27
	[local28 3]
	local31
	local32
	local33
	local34
)

(procedure (proc400_1)
	(proc0_8 97)
	((ScriptID 480 0) doit: local34) ; scoreGinRummy
	(proc0_8 0)
)

(instance ginRummy of HoyleRoom
	(properties
		style 10
	)

	(method (init &tmp temp0)
		(= picture (+ 901 global385))
		(Load rsVIEW 50)
		(Load rsVIEW 51)
		(Load rsVIEW 52)
		(Load rsVIEW 53)
		(Load rsVIEW (+ 54 global384))
		(KeyMouse setList: gTheKeyMouseList)
		(= local23 0)
		(gGame setCursor: 999)
		((= gGinrummy_opt ginrummy_opt) doit:)
		(if global462
			(gChar1 view: global463 active: 1 loop: global466)
			((gChar1 face:) view: global463)
			(= global196 global469)
			(gChar2 active: 0)
			(gChar3 active: 0)
		)
		(super init:)
		(PicNotValid 1)
		(= gKnownCards knownCards)
		(gKnownCards add:)
		(okieList add:)
		(= global193 400)
		((= global117 theHands) add: hand1 hand2)
		(hand1 add: owner: 0)
		(hand2 add: owner: gChar1)
		(handleEventList add:)
		(tempHand add:)
		(tempDead add:)
		(hand1 group1List: (humGrp1List add:))
		(hand1 group2List: (humGrp2List add:))
		(hand1 group3List: (humGrp3List add:))
		(hand1 deadWoodList: (humDeadList add:))
		(hand2 group1List: (comGrp1List add:))
		(hand2 group2List: (comGrp2List add:))
		(hand2 group3List: (comGrp3List add:))
		(hand2 deadWoodList: (comDeadList add:))
		(layOffHand add:)
		(disposeList add:)
		(deadWood1 add:)
		(deadWood2 add:)
		(gDelayCast release:)
		(= local31 0)
		(if (== global242 0)
			(= local21 10)
			(= local22 10)
			(= local1 0)
		else
			(= local1 1)
		)
		(= [global390 0] 3)
		(= [global390 1] 1)
		(= [global390 2] 2)
		(= [global390 3] 0)
		(= global394 global241)
		(Deck init: GinCard)
		(Deck rankAces: 1)
		(gChar1 posn: 245 45 show: init:)
		((gChar1 face:) view: (gChar1 view:))
		(Characters init:)
		(= global419 theStock)
		(global419 client: hand1 theDiscardPile: discardPile)
		(Piles add: discardPile)
		(gGinrummy_opt doit: 3)
		(gGame setCursor: 999 1 199 319)
		(self setScript: roomScript)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if local7
			(= local7 0)
			(event claimed: 1)
			((gCurRoom script:) cue:)
		)
		(handleEventList handleEvent: event)
	)

	(method (doit)
		(super doit:)
		(Dealer doit:)
		(if global290
			(if (not local7)
				(= global290 0)
				(global117 eachElementDo: #sort)
				(Animate (gCast elements:) 1)
				(proc0_3)
			else
				(Message msgGET 400 19 0 0 1 @global550) ; "You can't sort now."
				(Print addText: @global550 init:)
			)
		)
	)

	(method (dispose)
		(okieList release: dispose:)
		(Deck eachElementDo: #associatedObj 0)
		(Deck eachElementDo: #dispose dispose:)
		(= global458 0)
		(= global419 0)
		(KeyMouse release:)
		(= gCrazy8sSortCode 0)
		(gDelayCast release:)
		(Piles dispose:)
		(Dealer dispose:)
		(global117 eachElementDo: #dispose dispose:)
		(gKnownCards dispose:)
		(handleEventList dispose:)
		(humGrp1List dispose:)
		(humGrp2List dispose:)
		(humGrp3List dispose:)
		(humDeadList dispose:)
		(comGrp1List dispose:)
		(comGrp2List dispose:)
		(comGrp3List dispose:)
		(comDeadList dispose:)
		(deadWood1 dispose:)
		(deadWood2 dispose:)
		(disposeList eachElementDo: #dispose dispose:)
		(layOffHand dispose:)
		(tempHand dispose:)
		(tempDead dispose:)
		(DisposeScript 480)
		(DisposeScript 402)
		(DisposeScript 403)
		(DisposeScript 404)
		(DisposeScript 405)
		(DisposeScript 406)
		(DisposeScript 941)
		(DisposeScript 9)
		(DisposeScript 490)
		(super dispose:)
	)
)

(instance discardPile of DiscardPile
	(properties)

	(method (init)
		(= x 177)
		(= y 91)
		(super init:)
	)

	(method (enterKey)
		(super enterKey:)
		(= local13 1)
	)

	(method (getCard)
		(if
			(and
				(== ((ScriptID 15 1) size:) 1) ; discardList
				(== local2 2)
				(== (hand1 size:) 10)
			)
			(gChar1 say: 400 0 78 0 1)
		else
			(proc0_4)
			(super getCard:)
			(self discardOnly: 1)
			(if local3
				(= local3 0)
				(passButton dispose:)
			)
		)
	)

	(method (cantTake)
		(gSound play: 905)
		(gChar1 say: 400 0 72 0 1)
	)

	(method (validPlay param1 &tmp temp0)
		(if discardOnly
			(proc0_4)
			(return 1)
		else
			(= temp0 (param1 signal:))
			(param1 stopUpd:)
			(gChar1 say: 400 0 73 0 1)
			(if (& temp0 $0003)
				(param1 startUpd:)
			)
			(return 0)
		)
	)

	(method (isValid)
		(return 1)
	)

	(method (cue)
		(super cue:)
		((gCurRoom script:) ticks: 20)
	)

	(method (setCard param1)
		(gSound play: 907)
		(super setCard: param1)
		(gKnownCards add: param1)
		(param1 deleteKeyMouse:)
		(= local0 param1)
		(if local1
			(if (> (= local21 local33) 10)
				(= local21 10)
			)
			(= local22 local21)
			(if (== global196 2)
				(if (< (= local22 (- 10 (- global243 4))) 1)
					(= local22 1)
				)
				(if (> local22 local21)
					(= local22 local21)
				)
			)
		)
		(if (or (== ((Dealer curPlayer:) type:) 0) (not local6))
			((gCurRoom script:) ticks: 20)
		)
	)
)

(instance theStock of Stock
	(properties
		offsetY 38
	)

	(method (init)
		(= x 122)
		(= y 84)
		(= loop 0)
		(super init:)
	)

	(method (enterKey)
		(super enterKey:)
		(= local13 2)
	)

	(method (getCard)
		(proc0_4)
		(= global422 0)
		(super getCard:)
		(if local3
			(= local3 0)
			(passButton dispose:)
		)
	)

	(method (pass)
		(super pass:)
		((gCurRoom script:) cue:)
	)

	(method (validPlay)
		(return 1)
	)

	(method (cue)
		(super cue:)
		((gCurRoom script:) ticks: 20)
	)
)

(class GinCard of Card
	(properties
		inARun 0
		ofAKind 0
		rating 1
		theGroup 0
		bestGroup 0
		playOff 0
		offRating 0
		defRating 0
		fourOrMoreInGroup 0
	)
)

(class WL of List
	(properties)

	(method (setSize)
		(= local27 (- (= local26 (self size:)) 1))
	)

	(method (howManyOfRank param1 &tmp temp0 temp1)
		(if size
			(for ((= temp0 (= temp1 0))) (< temp0 size) ((++ temp0))
				(if (== ((self at: temp0) rank:) param1)
					(++ temp1)
				)
			)
			(return temp1)
		)
	)

	(method (atRank param1)
		((self at: param1) rank:)
	)

	(method (atSuit param1)
		((self at: param1) suit:)
	)

	(method (hasCard param1 param2 &tmp temp0)
		(for ((= temp0 0)) (< temp0 (self size:)) ((++ temp0))
			(if
				(and
					(== ((self at: temp0) rank:) param1)
					(== ((self at: temp0) suit:) param2)
				)
				(return temp0)
			)
		)
		(return -1)
	)
)

(class GinHand of Hand
	(properties
		group1List 0
		group2List 0
		group3List 0
		deadWoodList 0
		knockHand 0
		caller 0
		opponent 0
		spadesList 0
		clubsList 0
		diamondsList 0
		heartsList 0
		handsWon 0
		bonus 0
		bestDeadWood 0
		highestDeadWood 0
		highestDeadWoodCard 0
		passedOnCard 0
		base1GroupNum 0
		base2GroupNum 0
		base3GroupNum 0
	)

	(method (enterKey param1 param2)
		(= global458 (= local10 param1))
		(if (discardPile validPlay: param1)
			(proc0_4)
			(self moveCard: discardPile)
			(proc0_1)
			(if size
				(KeyMouse
					setCursor:
						(if param2
							param2
						else
							(self at: 0)
						)
				)
			)
		)
	)

	(method (thinkGetCard)
		(cond
			((and local3 (< local12 2))
				(if local2
					(= local3 0)
				)
				(if (self pickUpCard:)
					(discardPile getCard:)
					(passButton dispose:)
				else
					(++ local2)
					(passButton cue:)
					(gChar1 say: 1000 1 0 0 14)
					(self passedOnCard: (discardPile upCard:))
				)
			)
			((self pickUpCard:)
				(discardPile getCard:)
			)
			(else
				(theStock getCard:)
			)
		)
	)

	(method (thinkDiscard)
		(= global458 (= local10 (self discard:)))
		(self moveCard: discardPile)
	)

	(method (filterSpecialList &tmp temp0 temp1)
		(= temp1 0)
		(for ((= temp0 0)) (< temp0 (gWL size:)) ((++ temp0))
			(if (< ((gWL at: temp0) defRating:) 20)
				(= temp1 1)
				(break)
			)
		)
		(if temp1
			(for ((= temp0 0)) (< temp0 (gWL size:)) ((++ temp0))
				(if (>= ((gWL at: temp0) defRating:) 20)
					(gWL delete: (self at: temp0))
				)
			)
		)
	)

	(method (setOffensiveRating)
		(proc402_0 self)
		(DisposeScript 402)
	)

	(method (setDefensiveRating)
		(proc403_0 self)
		(DisposeScript 403)
	)

	(method (chooseGinHandDiscard &tmp temp0 temp1)
		(self sort: 1)
		(= temp1 (self at: 0))
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(if ((self at: temp0) fourOrMoreInGroup:)
				(= temp1 (self at: temp0))
			)
		)
		(return temp1)
	)

	(method (calcGroups &tmp temp0 temp1)
		(= temp0 (GinHand new:))
		(for ((= temp1 0)) (< temp1 (self size:)) ((++ temp1))
			(temp0 add: (self at: temp1))
		)
		(self
			caller: self
			opponent: hand1
			clearMarks:
			clearGroup:
			clearBestGroup:
			eachElementDo: #rating 0
			eachElementDo: #ofAKind 0
			eachElementDo: #fourOrMoreInGroup 0
		)
		(self createSuitLists: sortHandByRank: 1)
		(self findAllOfAKinds: markRuns: findBestGroup:)
		(= bestDeadWood local25)
		(self disposeSuitLists: reOrderCardList: temp0)
		(temp0 release: dispose:)
	)

	(method (disposeSuitLists)
		(disposeList delete: spadesList)
		(spadesList release: dispose:)
		(disposeList delete: clubsList)
		(clubsList release: dispose:)
		(disposeList delete: diamondsList)
		(diamondsList release: dispose:)
		(disposeList delete: heartsList)
		(heartsList release: dispose:)
	)

	(method (reOrderCardList param1 &tmp temp0)
		(self release:)
		(for ((= temp0 0)) (< temp0 (param1 size:)) ((++ temp0))
			(self add: (param1 at: temp0))
		)
	)

	(method (discard &tmp [temp0 2] temp2 temp3 [temp4 20])
		(self calcGroups:)
		(if bestDeadWood
			(if (<= (- bestDeadWood highestDeadWood) local22)
				(= local31 self)
				(if (= temp3 (- bestDeadWood highestDeadWood))
					(gChar1 say: 1000 1 0 (+ temp3 11) 16 462 1)
					(proc0_4)
					(= local11 1)
				else
					(gChar1 say: 1000 1 0 22 16 462 1)
					(proc0_4)
					(= local11 1)
				)
				(return highestDeadWoodCard)
			else
				(= gWL (WL new:))
				(disposeList add: gWL)
				(self
					makeSpecialList:
					setOffensiveRating:
					setDefensiveRating:
					filterSpecialList:
				)
				(= temp2 (self chooseBestDiscard:))
				(disposeList delete: gWL)
				(gWL release: dispose:)
				(return temp2)
			)
		else
			(proc0_4)
			(= local11 1)
			(gChar1 say: 1000 1 0 22 16 462 1)
			(= local31 self)
			(return (self chooseGinHandDiscard:))
		)
	)

	(method (makeSpecialList &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 (self size:)) ((++ temp0))
			(if (not ((self at: temp0) bestGroup:))
				(gWL add: (self at: temp0))
			)
		)
	)

	(method (chooseBestDiscard &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp1 (gWL at: 0))
		(= temp2 (+ (temp1 offRating:) (temp1 defRating:)))
		(for ((= temp0 1)) (< temp0 (gWL size:)) ((++ temp0))
			(= temp4 (gWL at: temp0))
			(= temp3 (+ (temp4 offRating:) (temp4 defRating:)))
			(if (<= (temp4 offRating:) (temp1 offRating:))
				(cond
					((< (temp4 offRating:) (temp1 offRating:))
						(= temp1 temp4)
						(= temp2 temp3)
					)
					(
						(and
							(!= global196 0)
							(<= (temp4 defRating:) (temp1 defRating:))
						)
						(cond
							((< (temp4 defRating:) (temp1 defRating:))
								(= temp2 temp3)
								(= temp1 temp4)
							)
							(
								(and
									(== global196 2)
									(> (temp4 rank:) (temp1 rank:))
								)
								(= temp2 temp3)
								(= temp1 temp4)
							)
						)
					)
				)
			)
		)
		(return temp1)
	)

	(method (cue)
		(discardPile setCard: local10)
		(super cue:)
		(= global395 0)
		(= global458 0)
		((gCurRoom script:) ticks: 20)
	)

	(method (arrangeGroups param1 &tmp [temp0 4])
		(if argc
			(= caller param1)
		)
		(proc405_0 self)
		(DisposeScript 405)
	)

	(method (testGroups param1 param2 param3 param4 param5)
		(self setDeadWoodOfAKinds: param1)
		(if (>= argc 3)
			(self setCardRating: param2 param3)
		)
		(if (>= argc 4)
			(self setCardRating: param4 param5)
		)
		(self calcRuns: countDeadWood:)
		(return (not local25))
	)

	(method (findBestGroup &tmp temp0 temp1 temp2 temp3)
		(self clearBestGroup:)
		(= local25 1000)
		(self countDeadWoodRuns:)
		(if (not local25)
			(return local25)
		)
		(switch local14
			(1
				(if (== local18 3)
					(if (self testGroups: 0)
						(return local25)
					)
				else
					(for ((= temp1 1)) (< temp1 5) ((++ temp1))
						(if (self testGroups: 0 temp1 local15)
							(return local25)
						)
					)
					(if (self testGroups: 0)
						(return local25)
					)
				)
			)
			(2
				(for ((= temp0 0)) (< temp0 2) ((++ temp0))
					(if (== [local18 temp0] 3)
						(if (self testGroups: [local15 temp0])
							(return local25)
						)
					else
						(for ((= temp1 1)) (< temp1 5) ((++ temp1))
							(if
								(self
									testGroups:
										[local15 temp0]
										temp1
										[local15 temp0]
								)
								(return local25)
							)
						)
						(if (self testGroups: [local15 temp0])
							(return local25)
						)
					)
				)
				(cond
					((== (+ local18 [local18 1]) 7)
						(= temp3 (if (== local18 4) 0 else 1))
						(for ((= temp1 1)) (< temp1 5) ((++ temp1))
							(if (self testGroups: 0 temp1 [local15 temp3])
								(return local25)
							)
						)
					)
					((== (+ local18 [local18 1]) 8)
						(for ((= temp1 1)) (< temp1 5) ((++ temp1))
							(for ((= temp2 1)) (< temp2 5) ((++ temp2))
								(if
									(self
										testGroups:
											0
											temp1
											local15
											temp2
											[local15 1]
									)
									(return local25)
								)
							)
						)
						(for ((= temp0 0)) (< temp0 2) ((++ temp0))
							(for ((= temp1 1)) (< temp1 5) ((++ temp1))
								(if (self testGroups: 0 temp1 [local15 temp0])
									(return local25)
								)
							)
						)
					)
				)
				(if (self testGroups: 0)
					(return local25)
				)
			)
			(3
				(self countDeadWoodOfAKinds: 0)
			)
		)
		(self bestDeadWood: local25)
		(return local25)
	)

	(method (markRuns &tmp [temp0 4])
		(proc406_0 self)
		(DisposeScript 406)
	)

	(method (findAllOfAKinds &tmp temp0 temp1)
		(= local14 0)
		(for ((= temp0 0)) (< temp0 (- size 2)) ((++ temp0))
			(if
				(and
					(==
						(= temp1 ((self at: temp0) rank:))
						((self at: (+ temp0 1)) rank:)
					)
					(== temp1 ((self at: (+ temp0 2)) rank:))
				)
				((self at: temp0) ofAKind: (+ temp1 100))
				((self at: (+ temp0 1)) ofAKind: (+ temp1 100))
				((self at: (+ temp0 2)) ofAKind: (+ temp1 100))
				(= [local18 local14] 3)
				(if
					(and
						(< temp0 (- size 3))
						(== temp1 ((self at: (+ temp0 3)) rank:))
					)
					((self at: (+ temp0 3))
						ofAKind: (+ temp1 100)
						fourOrMoreInGroup: 1
					)
					(++ temp0)
					(= [local18 local14] 4)
				)
				(+= temp0 2)
				(= [local15 local14] temp1)
				(++ local14)
			)
		)
	)

	(method (setGroups &tmp temp0 temp1 temp2 temp3)
		(for ((= temp1 (= temp2 (= temp3 0)))) (< temp1 size) ((++ temp1))
			(= temp0 (self at: temp1))
			(temp0 rating: (not (temp0 theGroup:)))
			(temp0 bestGroup: (temp0 theGroup:))
			(if (and (not (temp0 bestGroup:)) (> (self atValue: temp1) temp2))
				(= temp2 (self atValue: temp1))
				(= temp3 temp0)
			)
		)
		(self highestDeadWood: temp2 highestDeadWoodCard: temp3)
	)

	(method (setCardRating param1 param2 &tmp temp0 temp1)
		(for ((= temp0 (= temp1 0))) (< temp0 size) ((++ temp0))
			(if (== ((self at: temp0) ofAKind:) (+ param2 100))
				(++ temp1)
				(if (== param1 temp1)
					((self at: temp0) rating: 1 theGroup: 0)
					(return)
				)
			)
		)
	)

	(method (calcRuns &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp3 0)
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			(= temp2
				(switch temp0
					(0
						(self spadesList:)
					)
					(1
						(self clubsList:)
					)
					(2
						(self diamondsList:)
					)
					(3
						(self heartsList:)
					)
				)
			)
			(if (>= (temp2 size:) 3)
				(for ((= temp1 0)) (<= temp1 (- (temp2 size:) 3)) ((++ temp1))
					(cond
						(
							(and
								((temp2 at: temp1) rating:)
								((temp2 at: (+ temp1 1)) rating:)
								((temp2 at: (+ temp1 2)) rating:)
								(==
									(temp2 atRank: temp1)
									(- (temp2 atRank: (+ temp1 1)) 1)
								)
								(==
									(temp2 atRank: temp1)
									(- (temp2 atRank: (+ temp1 2)) 2)
								)
							)
							(= temp4 1)
							((temp2 at: temp1) rating: -1)
							((temp2 at: (+ temp1 1)) rating: -1)
							((temp2 at: (+ temp1 2)) rating: -1)
							((temp2 at: temp1)
								theGroup: (+ ((temp2 at: temp1) inARun:) temp3)
							)
							((temp2 at: (+ temp1 1))
								theGroup:
									(+ ((temp2 at: (+ temp1 1)) inARun:) temp3)
							)
							((temp2 at: (+ temp1 2))
								theGroup:
									(+ ((temp2 at: (+ temp1 2)) inARun:) temp3)
							)
						)
						(temp4 ; UNINIT
							(+= temp3 10)
							(= temp4 0)
						)
					)
				)
			)
		)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(if (== ((self at: temp0) rating:) -1)
				((self at: temp0) rating: 0)
			)
		)
	)

	(method (tryToPlayOffCard param1 param2 &tmp temp0 [temp1 2] temp3)
		(if (param2 size:)
			(cond
				((> (= temp0 ((param2 at: 0) theGroup:)) 100)
					(if
						(and
							(== (param1 rank:) ((param2 at: 0) rank:))
							(not (param1 theGroup:))
						)
						(param1 playOff: param2)
					)
				)
				(
					(and
						temp0
						(== (param1 suit:) ((param2 at: 0) suit:))
						(not (param1 theGroup:))
					)
					(if
						(or
							(== (+ (param1 rank:) 1) ((param2 at: 0) rank:))
							(==
								(- (param1 rank:) 1)
								((param2 at: (- (param2 size:) 1)) rank:)
							)
						)
						(param1 playOff: param2)
					)
					(if
						(or
							(and
								(== (+ (param1 rank:) 2) ((param2 at: 0) rank:))
								(>=
									(= temp3
										(self
											hasCard:
												(+ (param1 rank:) 1)
												(param1 suit:)
										)
									)
									0
								)
								(< temp3 size)
								(not ((self at: temp3) theGroup:))
							)
							(and
								(==
									(- (param1 rank:) 2)
									((param2 at: (- (param2 size:) 1)) rank:)
								)
								(>=
									(= temp3
										(self
											hasCard:
												(- (param1 rank:) 1)
												(param1 suit:)
										)
									)
									0
								)
								(< temp3 size)
								(not ((self at: temp3) theGroup:))
							)
						)
						(param1 playOff: param2)
					)
				)
			)
		)
	)

	(method (countDeadWood &tmp temp0 temp1 temp2 temp3)
		(self eachElementDo: #playOff 0)
		(= opponent (if (== self hand1) hand2 else hand1))
		(= temp2 0)
		(for ((= temp1 0)) (< temp1 size) ((++ temp1))
			(if ((= temp0 (self at: temp1)) rating:)
				(if (and local31 (!= self local31) (local31 bestDeadWood:))
					(temp0 playOff: 0)
					(self
						tryToPlayOffCard: temp0 (opponent group1List:)
						tryToPlayOffCard: temp0 (opponent group2List:)
						tryToPlayOffCard: temp0 (opponent group3List:)
					)
					(if (not (temp0 playOff:))
						(+= temp2 (self atValue: temp1))
					)
				else
					(+= temp2 (self atValue: temp1))
				)
			)
		)
		(if (<= temp2 local25)
			(= local25 temp2)
			(self setGroups:)
		)
	)

	(method (countDeadWoodRuns &tmp temp0 temp1 temp2)
		(self clearGroup:)
		(for ((= temp1 0)) (< temp1 size) ((++ temp1))
			(= temp0 (self at: temp1))
			(temp0 rating: (== (temp0 inARun:) 0) theGroup: (temp0 inARun:))
		)
		(self countDeadWood:)
	)

	(method (countDeadWoodOfAKinds &tmp temp0 temp1 temp2)
		(self clearGroup:)
		(for ((= temp1 0)) (< temp1 size) ((++ temp1))
			(= temp0 (self at: temp1))
			(temp0 rating: (== (temp0 ofAKind:) 0) theGroup: (temp0 ofAKind:))
		)
		(self countDeadWood:)
	)

	(method (setDeadWoodOfAKinds param1 &tmp temp0 temp1 temp2)
		(self clearGroup:)
		(for ((= temp1 0)) (< temp1 size) ((++ temp1))
			((= temp0 (self at: temp1)) rating: 1)
			(cond
				((== param1 0)
					(if (temp0 ofAKind:)
						(temp0 rating: 0 theGroup: (temp0 ofAKind:))
					)
				)
				((== (temp0 ofAKind:) (+ param1 100))
					(temp0 rating: 0 theGroup: ((self at: temp1) ofAKind:))
				)
			)
		)
	)

	(method (atValue param1 &tmp temp0)
		(if (> (= temp0 ((self at: param1) rank:)) 10)
			(= temp0 10)
		)
		(return temp0)
	)

	(method (clearMarks)
		(self eachElementDo: #inARun 0)
	)

	(method (clearGroup)
		(self eachElementDo: #theGroup 0 eachElementDo: #playOff 0)
	)

	(method (clearBestGroup)
		(self eachElementDo: #bestGroup 0)
	)

	(method (atRank param1)
		((self at: param1) rank:)
	)

	(method (atSuit param1)
		((self at: param1) suit:)
	)

	(method (howManyOfSuit param1 &tmp temp0 temp1)
		(if size
			(for ((= temp0 (= temp1 0))) (< temp0 size) ((++ temp0))
				(if (== (self atSuit: temp0) param1)
					(++ temp1)
				)
			)
			(return temp1)
		)
	)

	(method (howManyOfRank param1 &tmp temp0 temp1)
		(if size
			(for ((= temp0 (= temp1 0))) (< temp0 size) ((++ temp0))
				(if (== (self atRank: temp0) param1)
					(++ temp1)
				)
			)
			(return temp1)
		)
	)

	(method (makeSuitList param1 &tmp temp0 temp1 temp2)
		(= temp2 (WL new:))
		(disposeList add: temp2)
		(for ((= temp1 1)) (< temp1 14) ((++ temp1))
			(for ((= temp0 0)) (< temp0 size) ((++ temp0))
				(if
					(and
						(== (self atRank: temp0) temp1)
						(== (self atSuit: temp0) param1)
					)
					(temp2 add: (self at: temp0))
					(break)
				)
			)
		)
		(= global505 (- (= global504 (temp2 size:)) 1))
		(return temp2)
	)

	(method (adjustList param1 param2)
		(if (not param1)
			(self addToFront: (self at: (- param2 1)))
		else
			(self addAfter: (self at: (- param1 1)) (self at: (- param2 1)))
		)
		(self
			delete:
				(self
					at:
						(if (< param1 param2)
							param2
						else
							(- param2 1)
						)
				)
		)
	)

	(method (hasCard param1 param2 &tmp temp0)
		(if (< 0 param1 14)
			(for ((= temp0 0)) (< temp0 size) ((++ temp0))
				(if
					(and
						(== ((self at: temp0) rank:) param1)
						(== ((self at: temp0) suit:) param2)
					)
					(return temp0)
				)
			)
		)
		(return -1)
	)

	(method (releaseSuitLists)
		(spadesList release:)
		(clubsList release:)
		(diamondsList release:)
		(heartsList release:)
	)

	(method (createSuitLists)
		(= spadesList (self makeSuitList: 0))
		(= clubsList (self makeSuitList: 1))
		(= diamondsList (self makeSuitList: 2))
		(= heartsList (self makeSuitList: 3))
	)

	(method (shouldIAcceptKnock)
		(return (<= bestDeadWood (local31 bestDeadWood:)))
	)

	(method (sortHandByRank &tmp temp0)
		(= temp0 global394)
		(= global394 1)
		(self sort: 1)
		(= global394 temp0)
	)

	(method (pickUpCard &tmp temp0)
		(= temp0 (proc404_0 self local22))
		(DisposeScript 404)
		(return temp0)
	)
)

(instance humGrp1List of List
	(properties)
)

(instance humGrp2List of List
	(properties)
)

(instance humGrp3List of List
	(properties)
)

(instance humDeadList of List
	(properties)
)

(instance comGrp1List of List
	(properties)
)

(instance comGrp2List of List
	(properties)
)

(instance comGrp3List of List
	(properties)
)

(instance comDeadList of List
	(properties)
)

(instance deadWood1 of Hand
	(properties
		x 5
		handDirection 2
	)
)

(instance deadWood2 of Hand
	(properties
		x 276
		y 10
		handDirection 2
	)
)

(instance layOffHand of List
	(properties)
)

(instance disposeList of List
	(properties)
)

(instance tempHand of Hand
	(properties)
)

(instance hand1 of GinHand
	(properties
		x 101
		y 146
		handNumber 3
		faceUp 1
		centerX 160
		centerY 175
	)
)

(instance hand2 of GinHand
	(properties
		x 101
		y 10
		type 1
		handNumber 1
		location 1
		autoSorting 0
		centerX 120
		centerY 25
	)
)

(instance theHands of List
	(properties)
)

(instance handleEventList of EventHandler
	(properties)
)

(instance ginrummy_opt of File
	(properties
		name {ginrummy.opt}
	)

	(method (doit param1 &tmp [temp0 20] [temp20 11])
		(cond
			((and argc (== param1 3))
				(if (self open: 2)
					(self
						writeString:
							(Format ; "%d%d%2d%d%d"
								@temp0
								400
								0
								global241
								global242
								(gChar1 view:)
								(gChar1 loop:)
								global196
							)
						close:
					)
					(return 1)
				else
					(return 0)
				)
			)
			((self open: 1)
				(= global241 (ReadNumber (self readString: @temp20 2)))
				(= global242 (ReadNumber (self readString: @temp20 2)))
				(= global463 (ReadNumber (self readString: @temp20 3)))
				(= global466 (ReadNumber (self readString: @temp20 2)))
				(= global469 (ReadNumber (self readString: @temp20 2)))
				(self close:)
				(return 0)
			)
			(else
				(= global241 1)
				(= global242 0)
				(= global463 4)
				(= global466 2)
				(= global469 2)
				(= local23 1)
				(return 0)
			)
		)
	)
)

(instance roomScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(Wait 1)
				(= local6 0)
				(= local7 0)
				(= register 0)
				(= ticks 1)
			)
			(1
				(PicNotValid 0)
				(if local23
					(proc0_3)
					(proc0_1)
					(gGameControls hide:)
					(= local24 (gSystemWindow back:))
					(gSystemWindow back: 53)
					((ScriptID 490 0) init:) ; optionGinRummy
					(gSystemWindow back: local24)
					(proc0_4)
				)
				(= global547 0)
				(gSong fade:)
				(= ticks 10)
			)
			(2
				(= ticks 10)
				(Dealer init: hand1 hand2)
				(= global402 0)
			)
			(3
				(Deck shuffle:)
				(global117
					eachElementDo: #total 0
					eachElementDo: #prevTotal 0
					eachElementDo: #handTotal 0
					eachElementDo: #tempTotal 0
				)
				(= ticks 10)
			)
			(4
				(Dealer nextToPlay: (if (== global547 0) hand2 else hand1))
				(= local6 0)
				(= global244 0)
				(= global111 0)
				(= local5 0)
				(= local2 0)
				(= local3 1)
				(= global243 0)
				(= local12 0)
				(= local4 0)
				(Dealer cardsToDeal: 10 playDirection: 0 deal: self)
			)
			(5
				(hand1 sort:)
				(= ticks 10)
			)
			(6
				(proc0_4)
				(= local11 0)
				(knockButton setLoop: 0 init: stopUpd:)
				(discardPile init:)
				(global419 init:)
				(global419 active: 0)
				(= temp0 (Deck getCard:))
				(temp0 init:)
				(Arrow x: 255 y: 100 init:)
				(passButton init: setPri: 15 stopUpd: addKeyMouse:)
				(discardPile discardOnly: 0)
				(handleEventList
					add: knockButton passButton hand1 hand2 discardPile
				)
				(if (not (HaveMouse))
					(gGame
						setCursor:
							gTheCursor
							1
							(+ (passButton x:) 20)
							(+ (passButton y:) 30)
					)
					(= global191 (+ (passButton x:) 20))
					(= global192 (+ (passButton y:) 30))
				)
				(if (not (temp0 suit:))
					(= local34 1)
				else
					(= local34 0)
				)
				(if (> (temp0 rank:) 1)
					(= local33 (temp0 rank:))
				else
					(= local33 0)
				)
				(discardPile setCard: temp0)
				(if (== global242 1)
					(okieBox init:)
				)
			)
			(7
				(= local6 1)
				((KeyMouse objList:) add: discardPile)
				(discardPile discardOnly: 0)
				(if (not local3)
					(global419 active: 1 addKeyMouse:)
				)
				(if (!= local13 0)
					(= local13 0)
					(KeyMouse setCursor: global419)
				)
				(if (== ((Dealer curPlayer:) type:) 1)
					((Dealer curPlayer:) thinkGetCard:)
				else
					(proc0_3)
				)
			)
			(8
				(proc0_4)
				(if (== ((Dealer curPlayer:) type:) 0)
					(= local4 1)
				)
				((KeyMouse objList:) add: knockButton)
				(hand1 eachElementDo: #addKeyMouse)
				((KeyMouse objList:) delete: discardPile)
				(global419 deleteKeyMouse:)
				(if (== ((Dealer curPlayer:) type:) 1)
					(= ticks 60)
				else
					(= ticks 10)
				)
			)
			(9
				(if (!= ((Dealer curPlayer:) type:) 1)
					(cond
						((== local13 1)
							(KeyMouse
								setCursor: (hand1 at: (/ (hand1 size:) 2))
							)
						)
						((== local13 2)
							(KeyMouse
								setCursor: (hand1 at: (- (hand1 size:) 1))
							)
						)
					)
					(proc0_3)
				)
				(discardPile discardOnly: 1)
				(global419 active: 0)
				(if (== ((Dealer curPlayer:) type:) 1)
					((Dealer curPlayer:) thinkDiscard:)
				else
					(proc0_3)
				)
			)
			(10
				(if (or local11 (and local5 (knockCheck doit:)))
					(if local11
						(compCode doit:)
					)
					(= global244 1)
					(= local6 0)
					(clearTable doit:)
					(showCards doit:)
				else
					(= local4 0)
					(hand1 eachElementDo: #deleteKeyMouse)
					((KeyMouse objList:) delete: knockButton)
					(if (== (global419 size:) 2)
						(gChar1 say: 400 0 75 0 1 462 1)
						(= global244 1)
						(clearTable doit:)
						(= local6 0)
						(= state 11)
						(= ticks 60)
					else
						(if (== (Dealer curPlayer:) (Dealer at: 0))
							(++ global243)
						)
						(if (== global196 2)
							(if (< (= local22 (- 10 (- global243 4))) 1)
								(= local22 1)
							)
							(if (> local22 local21)
								(= local22 local21)
							)
						)
						(Dealer nextToPlay:)
						(= state 6)
						(= ticks 60)
					)
				)
			)
			(11
				(proc400_1)
				(tempHand release:)
				(tempDead release:)
				(deadWood1 release:)
				(deadWood2 release:)
				(= ticks 120)
			)
			(12
				(= local7 0)
				(tempHand release:)
				(layOffHand release:)
				((hand1 group1List:) release:)
				((hand1 group2List:) release:)
				((hand1 group3List:) release:)
				((hand1 deadWoodList:) release:)
				((hand2 group1List:) release:)
				((hand2 group2List:) release:)
				((hand2 group3List:) release:)
				((hand2 deadWoodList:) release:)
				(global117 eachElementDo: #endHand)
				(if (!= ((Dealer dealer:) type:) global547)
					(Dealer rotate:)
				)
				(Deck shuffle:)
				(if (not global111)
					(= state 3)
				)
				(= ticks 10)
			)
			(13
				((ScriptID 930 0) init: 470) ; yesNo
				(DisposeScript 930)
				(if global461
					(= state 3)
				)
				(= ticks 10)
			)
			(14
				(= gNewRoomNum 975) ; chooseGame
			)
		)
	)
)

(instance passButton of TrackingView
	(properties
		x 121
		y 83
		view 400
		loop 2
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(++ local2)
			(self cue:)
		)
	)

	(method (cue)
		(++ local12)
		(Dealer nextToPlay:)
		((gCurRoom script:) state: 6 ticks: 45)
		(if (>= local2 2)
			(self dispose:)
		)
	)

	(method (dispose)
		(handleEventList delete: self)
		(handleEventList add: global419)
		((KeyMouse objList:) delete: self)
		(= local3 0)
		(= global243 0)
		(super dispose:)
		(proc0_1)
	)
)

(instance knockButton of TrackingView
	(properties
		x 30
		y 66
		view 400
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(gSound play: 401)
			(event claimed: 1)
			(if local4
				(if (not local5)
					(= local5 1)
					(self loop: 1)
					(= local31 hand1)
				else
					(= local31 0)
					(= local5 0)
					(self loop: 0)
				)
			else
				(gChar1 say: 400 0 74 0 1)
			)
		)
	)
)

(instance compCode of Code
	(properties)

	(method (doit &tmp [temp0 23])
		(local31 createSuitLists: sortHandByRank:)
		(local31
			clearMarks:
			clearGroup:
			clearBestGroup:
			eachElementDo: #rating 0
			eachElementDo: #ofAKind 0
			findAllOfAKinds:
			markRuns:
		)
		(local31 bestDeadWood: (hand2 findBestGroup:) disposeSuitLists:)
	)
)

(instance knockCheck of Code
	(properties)

	(method (doit &tmp temp0 [temp1 20] temp21 temp22)
		(= temp21 global394)
		(local31 createSuitLists: sortHandByRank:)
		(local31
			clearMarks:
			clearGroup:
			clearBestGroup:
			eachElementDo: #rating 0
			eachElementDo: #ofAKind 0
			findAllOfAKinds:
			markRuns:
		)
		(local31 bestDeadWood: (hand1 findBestGroup:) disposeSuitLists:)
		(= temp0 1)
		(if (== local31 hand1)
			(cond
				((> (local31 bestDeadWood:) local21)
					(if ((local31 opponent:) shouldIAcceptKnock:)
						(gChar1 say: 400 0 77 0 1 462 1)
						(= local32 (if (== local31 hand1) hand2 else hand1))
						(return 1)
					else
						(gChar1 say: 400 0 76 0 1 462 1)
						(for
							((= temp22 0))
							(< temp22 (hand1 size:))
							((++ temp22))
							
							(gKnownCards add: (hand1 at: temp22))
						)
						(= local5 0)
						(knockButton setLoop: 0)
						(= global394 temp21)
						(local31 sort:)
						(= local31 0)
						(return 0)
					)
				)
				((local31 bestDeadWood:)
					(= local32 (if (== local31 hand1) hand2 else hand1))
					(return 1)
				)
				(else
					(if (== local31 hand1)
						(gSound play: 402)
					else
						(gSound play: 403)
					)
					(= local32 (if (== local31 hand1) hand2 else hand1))
					(return 1)
				)
			)
		)
	)
)

(instance clearTable of Code
	(properties)

	(method (doit)
		(proc0_4)
		(if (IsObject okieBox)
			(okieBox dispose:)
		)
		(knockButton dispose:)
		(gKnownCards release:)
		(Arrow endHand:)
		(global419 endHand:)
		(discardPile endHand:)
		(handleEventList delete: hand1 hand2 global419 discardPile)
	)
)

(instance showCards of Code
	(properties)

	(method (doit &tmp [temp0 6])
		(local31 arrangeGroups: (local31 opponent:))
		((local31 opponent:)
			createSuitLists:
			sortHandByRank:
			clearMarks:
			clearGroup:
			clearBestGroup:
			eachElementDo: #rating 0
			eachElementDo: #ofAKind 0
			findAllOfAKinds:
			markRuns:
		)
		((local31 opponent:)
			bestDeadWood: ((local31 opponent:) findBestGroup:)
			disposeSuitLists:
		)
		((local31 opponent:) arrangeGroups: (local31 opponent:))
		(hand1 knockHand: local31)
		(hand2 knockHand: local31)
		(roomScript setScript: layEmOut roomScript)
	)
)

(instance tempDead of Hand
	(properties
		handDirection 2
	)
)

(instance layEmOut of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(switch (= state newState)
			(0
				(hand2 eachElementDo: #hide)
				(hand2 eachElementDo: #forceUpd)
				(= ticks 2)
			)
			(1
				(= temp0 (hand2 group1List:))
				(tempHand
					release:
					handDirection: 1
					x: (+ (findStartX doit: hand2) 15)
					y: 5
				)
				(Dealer cardsToDeal: (temp0 size:))
				(= temp7 1)
				(for ((= temp2 0)) (< temp2 (temp0 size:)) ((++ temp2))
					(tempHand add: (temp0 at: temp2) 1 1)
					((temp0 at: temp2) flip: 1 show: forceUpd:)
					(= temp7 30)
				)
				(= ticks temp7)
			)
			(2
				(= temp0 (hand2 group2List:))
				(= temp1 (+ (tempHand calcNextX:) 20))
				(tempHand release: x: temp1)
				(Dealer cardsToDeal: (temp0 size:))
				(= temp7 1)
				(for ((= temp2 0)) (< temp2 (temp0 size:)) ((++ temp2))
					(tempHand add: (temp0 at: temp2) 1 1)
					((temp0 at: temp2) flip: 1 show: forceUpd:)
					(= temp7 30)
				)
				(= ticks temp7)
			)
			(3
				(= temp0 (hand2 group3List:))
				(= temp1 (+ (tempHand calcNextX:) 20))
				(tempHand release: x: temp1)
				(Dealer cardsToDeal: (temp0 size:))
				(= temp7 1)
				(for ((= temp2 0)) (< temp2 (temp0 size:)) ((++ temp2))
					(tempHand add: (temp0 at: temp2) 1 1)
					((temp0 at: temp2) flip: 1 show: forceUpd:)
					(= temp7 30)
				)
				(= ticks temp7)
			)
			(4
				(gChar1 frown:)
				(= temp0 (hand2 deadWoodList:))
				(deadWood2 release:)
				(Dealer cardsToDeal: (temp0 size:))
				(= temp7 1)
				(for ((= temp2 0)) (< temp2 (temp0 size:)) ((++ temp2))
					(deadWood2 add: (temp0 at: temp2) 1 1)
					((temp0 at: temp2) flip: 1 show: forceUpd:)
					(= temp7 30)
				)
				(= ticks temp7)
			)
			(5
				(hand1 eachElementDo: #hide)
				(hand1 eachElementDo: #forceUpd)
				(= ticks 2)
			)
			(6
				(= temp0 (hand1 group1List:))
				(tempHand
					release:
					handDirection: 1
					x: (findStartX doit: hand1)
					y: 154
				)
				(Dealer cardsToDeal: (temp0 size:))
				(= temp7 1)
				(for ((= temp2 0)) (< temp2 (temp0 size:)) ((++ temp2))
					(tempHand add: (temp0 at: temp2) 1 1)
					((temp0 at: temp2) show: forceUpd:)
					(= temp7 30)
				)
				(= ticks temp7)
			)
			(7
				(= temp0 (hand1 group2List:))
				(= temp1 (+ (tempHand calcNextX:) 20))
				(tempHand release: x: temp1)
				(Dealer cardsToDeal: (temp0 size:))
				(= temp7 1)
				(for ((= temp2 0)) (< temp2 (temp0 size:)) ((++ temp2))
					(tempHand add: (temp0 at: temp2) 1 1)
					((temp0 at: temp2) show: forceUpd:)
					(= temp7 30)
				)
				(= ticks temp7)
			)
			(8
				(= temp0 (hand1 group3List:))
				(= temp1 (+ (tempHand calcNextX:) 20))
				(tempHand release: x: temp1)
				(Dealer cardsToDeal: (temp0 size:))
				(= temp7 1)
				(for ((= temp2 0)) (< temp2 (temp0 size:)) ((++ temp2))
					(tempHand add: (temp0 at: temp2) 1 1)
					((temp0 at: temp2) show: forceUpd:)
					(= temp7 30)
				)
				(= ticks temp7)
			)
			(9
				(= temp0 (hand1 deadWoodList:))
				(deadWood1 y: 40 release:)
				(Dealer cardsToDeal: (temp0 size:))
				(for ((= temp2 0)) (< temp2 (temp0 size:)) ((++ temp2))
					((temp0 at: temp2) playOff:)
					(deadWood1 y: 30)
				)
				(= temp7 1)
				(for ((= temp2 0)) (< temp2 (temp0 size:)) ((++ temp2))
					(deadWood1 add: (temp0 at: temp2) 1 1)
					((temp0 at: temp2) show: forceUpd:)
					(= temp7 30)
				)
				(= ticks temp7)
			)
			(10
				(layOffHand release:)
				(tempDead release:)
				(= ticks 1)
			)
			(11
				(if (== local31 hand1)
					(= temp5 deadWood2)
				else
					(= temp5 deadWood1)
				)
				(for ((= temp2 (- (temp5 size:) 1))) (>= temp2 0) ((-- temp2))
					(= temp6 (temp5 at: temp2))
					(if (temp6 playOff:)
						(layOffHand add: temp6)
						(temp5 eliminateCard: temp6)
					)
				)
				(if (layOffHand size:)
					(= temp4 (if (== local31 hand1) deadWood2 else deadWood1))
					(tempDead
						x: (if (== local31 hand1) 276 else 5)
						y:
							(if (temp4 size:)
								(+ ((temp4 at: (- (temp4 size:) 1)) y:) 50)
							else
								(- 150 (* (layOffHand size:) global397))
							)
					)
					(for ((= temp2 0)) (< temp2 (layOffHand size:)) ((++ temp2))
						(tempDead add: (layOffHand at: temp2) 1 1)
					)
					(for ((= temp2 0)) (< temp2 (tempDead size:)) ((++ temp2))
						((tempDead at: temp2)
							posn: (tempDead x:) (+ (tempDead y:) (* temp2 8))
							flip: 1
							show:
							forceUpd:
						)
					)
				)
				(if
					(>=
						(local31 bestDeadWood:)
						((local31 opponent:) bestDeadWood:)
					)
					(if (== (local31 type:) 0)
						(gSound play: 405)
					else
						(gSound play: 404)
					)
				)
				(= ticks 30)
			)
			(12
				(self dispose:)
			)
		)
	)
)

(instance findStartX of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1 temp2 [temp3 30])
		(= temp0 0)
		(if ((param1 group1List:) size:)
			(++ temp0)
		)
		(if ((param1 group2List:) size:)
			(++ temp0)
		)
		(if ((param1 group3List:) size:)
			(++ temp0)
		)
		(= temp2
			(+
				(* (= temp1 (- 10 ((param1 deadWoodList:) size:))) 4)
				(cond
					((== temp0 2) 45)
					((== temp0 3) 76)
					(else 0)
				)
			)
		)
		(return (- 122 temp2))
	)
)

(instance variantCode of Code
	(properties)

	(method (doit &tmp [temp0 20])
		(if (>= (hand1 size:) 10)
			(hand1 sort:)
		)
		(cond
			((and (== global242 1) (not local1))
				(= local1 1)
				(= local21 local33)
				(= local22 local33)
				(if (> local21 10)
					(= local21 10)
				)
				(if local6
					(okieBox init:)
				)
			)
			((and (== global242 0) local1)
				(= local21 10)
				(= local22 10)
				(if (IsObject okieBox)
					(okieBox dispose:)
				)
				(= local1 0)
			)
		)
		(if (== global196 2)
			(if (< (= local22 (- 10 (- global243 4))) 1)
				(= local22 1)
			)
			(if (> local22 local21)
				(= local22 local21)
			)
		)
	)
)

(instance okieList of List
	(properties)
)

(instance okieBox of View
	(properties
		x 17
		y 60
		view 400
		loop 3
		priority 13
	)

	(method (init)
		(super init:)
		(if local21
			(okieNum x: 85 loop: 7 cel: local21 init:)
		else
			(okieNum x: 75 loop: 6 cel: 0 init:)
		)
		(okieList release: add: self okieNum)
		(if local34
			(okieDouble init:)
			(okieList add: okieDouble)
		)
		(Animate (gCast elements:) 0)
		(self stopUpd:)
		(okieNum stopUpd:)
		(okieDouble stopUpd:)
		(knockButton associatedObj: okieList)
	)

	(method (dispose)
		(knockButton associatedObj: 0)
		(okieNum dispose:)
		(if (IsObject okieDouble)
			(okieDouble dispose:)
		)
		(super dispose:)
	)
)

(instance okieNum of Actor
	(properties
		x 85
		y 97
		view 400
		loop 7
		priority 14
	)
)

(instance okieDouble of Actor
	(properties
		x 47
		y 118
		view 400
		loop 5
		priority 14
	)
)

(instance knownCards of WL
	(properties)

	(method (add param1)
		(if (not argc)
			(super add:)
		else
			(super add: param1)
		)
	)
)

