;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use KeyMouse)
(use Piles)
(use Character)
(use Crazy8sStrategy)
(use Print)
(use Motion)
(use File)
(use Actor)
(use System)

(public
	crazy8s 0
	proc100_1 1
)

(local
	local0
	local1
	local2
	local3
)

(procedure (proc100_1)
	(proc0_8 97)
	((ScriptID 180 0) init:) ; scoreCrazy8s
	(DisposeScript 180)
	(proc0_8 0)
)

(procedure (localproc_0 param1 &tmp temp0 temp1)
	(for ((= temp0 (= temp1 0))) (< temp0 (param1 size:)) ((++ temp0))
		(cond
			((== ((param1 at: temp0) rank:) 8)
				(+= temp1 50)
			)
			((>= ((param1 at: temp0) rank:) 10)
				(+= temp1 10)
			)
			(else
				(+= temp1 ((param1 at: temp0) rank:))
			)
		)
	)
	(return temp1)
)

(procedure (localproc_1 param1 &tmp temp0)
	(if (== global223 1)
		(cond
			((OneOf (discardPile condition:) 2 4 6 8)
				(for ((= temp0 0)) (< temp0 (param1 size:)) ((++ temp0))
					(if (== ((param1 at: temp0) rank:) 2)
						(return 1)
					)
				)
				(return 0)
			)
			((== (discardPile condition:) 12)
				(return 0)
			)
		)
	)
	(for ((= temp0 0)) (< temp0 (param1 size:)) ((++ temp0))
		(if (== ((param1 at: temp0) rank:) 8)
			(return 1)
		)
	)
	(if (== ((discardPile upCard:) rank:) 8)
		(for ((= temp0 0)) (< temp0 (param1 size:)) ((++ temp0))
			(if (== ((param1 at: temp0) suit:) global420)
				(return 1)
			)
		)
		(return 0)
	)
	(for ((= temp0 0)) (< temp0 (param1 size:)) ((++ temp0))
		(if
			(or
				(== ((param1 at: temp0) rank:) ((discardPile upCard:) rank:))
				(== ((param1 at: temp0) suit:) ((discardPile upCard:) suit:))
			)
			(return 1)
		)
	)
	(return 0)
)

(instance crazy8s of HoyleRoom
	(properties
		style 10
	)

	(method (init)
		(= picture (+ 901 global385))
		(= global419 theStock)
		(= global395 0)
		(Load rsVIEW 50)
		(Load rsVIEW 51)
		(Load rsVIEW 52)
		(Load rsVIEW 53)
		(Load rsVIEW (+ 54 global384))
		(KeyMouse setList: gTheKeyMouseList)
		(gGame setCursor: 999)
		(= local0 0)
		((= gCrazy8s_opt crazy8s_opt) doit:)
		(if global462
			(gChar1 view: global463 active: 1 loop: global466)
			((gChar1 face:) view: global463)
			(gChar2 view: global464 active: 1 loop: global467)
			((gChar2 face:) view: global464)
			(gChar3 view: global465 active: 1 loop: global468)
			((gChar3 face:) view: global465)
			(= global196 global469)
			(= global197 global470)
			(= global198 global471)
		)
		(super init:)
		(PicNotValid 1)
		(Deck init:)
		((= global117 theHands) add: hand1 hand2 hand3 hand4)
		(hand1 add: owner: 0)
		(hand2 add: owner: gChar1)
		(hand3 add: owner: gChar2)
		(hand4 add: owner: gChar3)
		(Piles add: discardPile)
		(discardPile client: hand1)
		(handleEventList add:)
		(= gCrazy8sSortCode crazy8sSortCode)
		(= global193 100)
		(= [global390 0] 3)
		(= [global390 1] 1)
		(= [global390 2] 2)
		(= [global390 3] 0)
		(= global394 global221)
		(global419 client: hand1 theDiscardPile: discardPile)
		(Dealer cardsToDeal: 5)
		(gChar1 posn: 73 115 show: init:)
		(gChar2 posn: 100 39 show: init:)
		(gChar3 posn: 247 114 show: init:)
		(Characters init:)
		((gChar1 face:) view: (gChar1 view:))
		((gChar2 face:) view: (gChar2 view:))
		((gChar3 face:) view: (gChar3 view:))
		(Deck shuffle:)
		(gCrazy8s_opt doit: 3)
		(self setScript: roomScript)
	)

	(method (doit)
		(super doit:)
		(Dealer doit:)
		(if global290
			(= global290 0)
			(global117 eachElementDo: #sort)
			(Animate (gCast elements:) 1)
			(HandsOn)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(handleEventList handleEvent: event)
	)

	(method (dispose)
		(= global458 0)
		(= global419 0)
		(= gCrazy8sSortCode 0)
		(KeyMouse release:)
		(Piles eachElementDo: #dispose release: dispose:)
		(Dealer dispose:)
		(global117
			eachElementDo: #release
			eachElementDo: #dispose
			release:
			dispose:
		)
		(Deck dispose:)
		(handleEventList release: dispose:)
		(DisposeScript 180)
		(DisposeScript 941)
		(DisposeScript 9)
		(DisposeScript 170)
		(DisposeScript 190)
		(DisposeScript 150)
		(super dispose:)
	)
)

(instance handleEventList of EventHandler
	(properties)
)

(instance roomScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2] temp2 temp3 temp4 temp5)
		(switch (= state newState)
			(0
				(Wait 1)
				(= ticks 1)
			)
			(1
				(PicNotValid 0)
				(if local0
					(RedrawCast)
					(HandsOn)
					(gGameControls hide:)
					(= local1 (gSystemWindow back:))
					(gSystemWindow back: 53)
					((ScriptID 190 0) init:) ; optionCrazy8s
					(gSystemWindow back: local1)
					(HandsOff)
				)
				(gSong fade:)
				(= ticks 1)
			)
			(2
				(Dealer init: hand1 hand2 hand3 hand4)
				(= ticks 1)
			)
			(3
				(global117
					eachElementDo: #total 0
					eachElementDo: #prevTotal 0
					eachElementDo: #handTotal 0
					eachElementDo: #tempTotal 0
				)
				(= global402 0)
				(= ticks 1)
			)
			(4
				(discardPile condition: 0)
				(= global421 0)
				(HandsOff)
				(Dealer playDirection: 0 deal: self)
			)
			(5
				(hand1 sort:)
				(hand1 eachElementDo: #addKeyMouse)
				(= ticks 1)
			)
			(6
				(Deck rankAces: 1)
				(global419 init: addKeyMouse:)
				(discardPile init:)
				(= temp5 (Deck getCard:))
				(discardPile setCard: temp5 1)
				(if (and (== (temp5 rank:) 13) (== global223 1))
					(Dealer playDirection: 1)
				)
				(if (== (temp5 rank:) 8)
					(= global420 (temp5 suit:))
				)
				(temp5 init: 0)
				(Arrow x: 200 y: 53 init:)
				(directionArrow init: (Dealer playDirection:))
				(handleEventList
					add: hand1 hand2 hand3 hand4 global419 discardPile
				)
				(= ticks 1)
			)
			(7
				(= ticks 1)
			)
			(8
				(Stock cardsTaken: 0)
				(if (== ((Dealer curPlayer:) type:) 1)
					((Dealer curPlayer:) think:)
				else
					(HandsOn)
				)
			)
			(9
				(if
					(and
						((Dealer at: 0) size:)
						((Dealer at: 1) size:)
						((Dealer at: 2) size:)
						((Dealer at: 3) size:)
						(< global116 4)
					)
					(if (== ((Dealer curPlayer:) type:) 0)
						((Dealer curPlayer:) lastPlay: (discardPile upCard:))
					)
					(global419 cardsTakenThisTurn: 0)
					(= local3 0)
					(Dealer nextToPlay:)
					((Dealer curPlayer:) tookCard: 0)
					(= state 6)
					(= ticks
						(if (== ((Dealer curPlayer:) type:) 1)
							(* global386 3)
						else
							1
						)
					)
				else
					(= ticks (* global386 5))
				)
			)
			(10
				(HandsOn)
				(Arrow endHand:)
				(directionArrow init: -1)
				(global419 endHand: deleteKeyMouse:)
				(discardPile endHand:)
				(transition hide: forceUpd:)
				(hand1 eachElementDo: #flip 1)
				(hand2 eachElementDo: #flip 1)
				(hand3 eachElementDo: #flip 1)
				(hand4 eachElementDo: #flip 1)
				(handleEventList
					delete: hand1 hand2 hand3 hand4 global419 discardPile
				)
				(= ticks 1)
			)
			(11
				(gSound play: 101)
				(global117 eachElementDo: #calcScore)
				(++ global402)
				(= temp2 1)
				(= temp3 (global117 at: 0))
				(= temp4 ((global117 at: 0) tempTotal:))
				(while (< temp2 (global117 size:))
					(if
						(<
							((global117 at: temp2) tempTotal:)
							(temp3 tempTotal:)
						)
						(= temp3 (global117 at: temp2))
					)
					(+= temp4 ((global117 at: temp2) tempTotal:))
					(++ temp2)
				)
				(if (not (temp3 tempTotal:))
					(for ((= temp2 0)) (< temp2 (global117 size:)) ((++ temp2))
						(if (!= (global117 at: temp2) temp3)
							((global117 at: temp2) tempTotal: 0)
						)
					)
					(temp3 tempTotal: (/ temp4 3))
					(if (== (temp3 type:) 0)
						(Characters say: 1000 1 23 0 (Random 4 5) 464 1 self)
					else
						((temp3 owner:)
							say: 1000 1 23 0 (Random 1 2) 462 1 self
						)
					)
				else
					(for ((= temp2 0)) (< temp2 (global117 size:)) ((++ temp2))
						((global117 at: temp2) tempTotal: 0)
					)
					(= ticks 1)
				)
			)
			(12
				(RedrawCast)
				(global117 eachElementDo: #calcScore 1)
				((ScriptID 180 0) init:) ; scoreCrazy8s
				(global117 eachElementDo: #endHand)
				(= ticks 1)
			)
			(13
				(if
					(and
						(< (hand1 total:) 100)
						(< (hand2 total:) 100)
						(< (hand3 total:) 100)
						(< (hand4 total:) 100)
					)
					(= state 3)
					(Deck shuffle:)
					(Dealer rotate: cardsToDeal: 5)
				)
				(= ticks 1)
			)
			(14
				((ScriptID 930 0) init: 170) ; yesNo
				(DisposeScript 930)
				(if global461
					(= state 2)
					(Deck shuffle:)
					(Dealer rotate: cardsToDeal: 5)
				)
				(= ticks 1)
			)
			(15
				(= gNewRoomNum 975) ; chooseGame
			)
		)
	)
)

(instance crazy8s_opt of File
	(properties
		name {crazy8s.opt}
	)

	(method (doit param1 &tmp [temp0 20] [temp20 10])
		(cond
			((and argc (== param1 3))
				(if (self open: 2)
					(self
						writeString:
							(Format ; "%d%d%d%d%2d%2d%2d%d%d%d%d%d%d"
								@temp0
								100
								0
								global221
								global222
								global223
								global224
								(gChar1 view:)
								(gChar2 view:)
								(gChar3 view:)
								(gChar1 loop:)
								(gChar2 loop:)
								(gChar3 loop:)
								global196
								global197
								global198
							)
						close:
					)
					(return 1)
				else
					(return 0)
				)
			)
			((self open: 1)
				(= global221 (ReadNumber (self readString: @temp20 2)))
				(= global222 (ReadNumber (self readString: @temp20 2)))
				(= global223 (ReadNumber (self readString: @temp20 2)))
				(= global224 (ReadNumber (self readString: @temp20 2)))
				(= global463 (ReadNumber (self readString: @temp20 3)))
				(= global464 (ReadNumber (self readString: @temp20 3)))
				(= global465 (ReadNumber (self readString: @temp20 3)))
				(= global466 (ReadNumber (self readString: @temp20 2)))
				(= global467 (ReadNumber (self readString: @temp20 2)))
				(= global468 (ReadNumber (self readString: @temp20 2)))
				(= global469 (ReadNumber (self readString: @temp20 2)))
				(= global470 (ReadNumber (self readString: @temp20 2)))
				(= global471 (ReadNumber (self readString: @temp20 2)))
				(self close:)
				(return 0)
			)
			(else
				(= global221 1)
				(= global222 0)
				(= global223 0)
				(= global224 0)
				(= global463 2)
				(= global464 6)
				(= global465 10)
				(= global466 2)
				(= global467 2)
				(= global468 2)
				(= global469 2)
				(= global470 2)
				(= global471 2)
				(= local0 1)
				(return 0)
			)
		)
	)
)

(class Crazy8sHand of Hand
	(properties
		tookCard 0
		lastPlay 0
	)

	(method (enterKey param1 param2)
		(= global458 param1)
		(if (discardPile validPlay: param1)
			(self moveCard: discardPile)
			(= local2 1)
			(RedrawCast)
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

	(method (couldPlay)
		(localproc_1 self)
	)

	(method (calcScore param1)
		(if (and argc param1)
			(super calcScore:)
		else
			(= tempTotal (localproc_0 self))
		)
	)

	(method (think &tmp temp0)
		(if (= global458 (Crazy8sStrategy think: self))
			(if (== (global458 rank:) 8)
				(= global420 (Crazy8sStrategy newSuitChosen:))
			)
			(DisposeScript 170)
			(= lastPlay global458)
			(self moveCard: discardPile)
			(= gCrazy8sHand 0)
		else
			(++ tookCard)
			(global419 getCard: self)
			(= gCrazy8sHand self)
		)
	)

	(method (cue)
		(super cue:)
		((ScriptID 15 6) setCycle: 0) ; littleCard
		(discardPile setCard: global458)
		(RedrawCast)
		(if local2
			(= local2 0)
			(discardPile doCode: global458)
			(= global395 0)
			(return)
		)
		(if (and size (== (global458 rank:) 8))
			(transition
				init: (+ 101 (* (global458 suit:) 4) global420) transition
			)
			(discardPile associatedObj: transition)
		else
			(= global395 0)
			((gCurRoom script:) cue:)
		)
	)

	(method (moveCard)
		(= tookCard 0)
		(super moveCard: &rest)
	)
)

(instance hand1 of Crazy8sHand
	(properties
		x 95
		y 153
		handNumber 3
		faceUp 1
		centerX 160
		centerY 175
	)
)

(instance hand2 of Crazy8sHand
	(properties
		x 5
		y 30
		handDirection 2
		type 1
		handNumber 2
		location 4
		centerX 25
		centerY 100
	)
)

(instance hand3 of Crazy8sHand
	(properties
		x 95
		y 5
		type 1
		handNumber 1
		location 1
		centerX 160
		centerY 25
	)
)

(instance hand4 of Crazy8sHand
	(properties
		x 279
		y 30
		handDirection 2
		type 1
		handNumber 4
		location 2
		centerX 295
		centerY 100
	)
)

(instance crazy8sSortCode of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1 temp2 temp3)
		(= temp3 1)
		(switch global222
			(0
				(while temp3
					(= temp3 0)
					(= temp1 0)
					(for
						((= temp0 (- (param1 size:) 1)))
						(>= temp0 0)
						((-- temp0))
						
						(= temp2 (param1 at: temp0))
						(cond
							((== (temp2 rank:) 8)
								(= temp1 temp2)
							)
							(temp1
								(param1 delete: temp1 addToFront: temp1)
								(= temp3 1)
								(break)
							)
						)
					)
				)
			)
			(1
				(while temp3
					(= temp3 0)
					(= temp1 0)
					(for ((= temp0 0)) (< temp0 (param1 size:)) ((++ temp0))
						(= temp2 (param1 at: temp0))
						(cond
							((== (temp2 rank:) 8)
								(= temp1 temp2)
							)
							(temp1
								(param1 delete: temp1 add: temp1)
								(= temp3 1)
								(break)
							)
						)
					)
				)
			)
		)
	)
)

(instance theStock of Stock
	(properties)

	(method (init)
		(= offsetY 32)
		(= x 110)
		(= y 92)
		(= loop 0)
		(super init:)
	)

	(method (getCard &tmp temp0 temp1)
		(= global422 0)
		(cond
			((and (not local3) (discardPile conditionSet:))
				(discardPile conditionSet: 0)
				(if (OneOf (discardPile condition:) 2 4 6 8)
					(gSound play: 107)
				)
				(if (== ((Dealer curPlayer:) type:) 0)
					(switch (discardPile condition:)
						(2
							(if (not (Random 0 5))
								(Characters say: 1000 1 23 0 2 462 1)
								(= local3 1)
							)
						)
						(4
							(if (not (Random 0 3))
								(Characters say: 1000 1 23 0 1 462 1)
								(= local3 1)
							)
						)
						(6
							(if (not (Random 0 2))
								(Characters say: 1000 1 23 0 2 462 1)
								(= local3 1)
							)
						)
						(8
							(Characters say: 1000 1 23 0 1 462 1)
							(= local3 1)
						)
						(12
							(if (not (Random 0 1))
								(Characters say: 1000 1 23 0 1 462 1)
								(= local3 1)
							)
						)
					)
				else
					(= temp0 ((Dealer curPlayer:) owner:))
					(switch (discardPile condition:)
						(2
							(if (not (Random 0 5))
								(temp0 say: 1000 1 23 0 4 464 1)
								(= local3 1)
							)
						)
						(4
							(if (not (Random 0 3))
								(temp0 say: 1000 1 23 0 5 464 1)
								(= local3 1)
							)
						)
						(6
							(if (not (Random 0 2))
								(temp0 say: 1000 1 23 0 4 464 1)
								(= local3 1)
							)
						)
						(8
							(temp0 say: 1000 1 23 0 5 464 1)
							(= local3 1)
						)
						(12
							(if (not (Random 0 1))
								(temp0 say: 1000 1 23 0 5 464 1)
								(= local3 1)
							)
						)
					)
				)
			)
			((and (not local3) (> (theStock cardsTakenThisTurn:) 3))
				(if (< (= temp1 (- 10 (theStock cardsTakenThisTurn:))) 1)
					(= temp1 1)
				)
				(cond
					((== ((Dealer curPlayer:) type:) 0)
						(if (not (Random 0 temp1))
							(= local3 1)
						)
					)
					((not (Random 0 temp1))
						(((Dealer curPlayer:) owner:)
							say: 1000 1 23 0 (Random 4 5) 464 1
						)
						(= local3 1)
					)
				)
			)
		)
		(super getCard: &rest)
	)

	(method (pass)
		(gSound play: 907)
		(RedrawCast)
		(super pass:)
		(discardPile condition: 0)
		(= global421 0)
		((gCurRoom script:) cue:)
	)

	(method (validPlay)
		(if (== global224 2)
			(if
				(and
					(or
						(not global421)
						(and global421 (discardPile conditionSet:))
					)
					((Dealer curPlayer:) couldPlay:)
				)
				(gSound play: 905)
				(Message msgGET 100 19 0 0 1 @global550) ; "You must make a play since you have a valid play."
				(Print addText: @global550 init:)
				(return 0)
			else
				(return 1)
			)
		else
			(return 1)
		)
	)

	(method (cue)
		(super cue: &rest)
		(cond
			(global421
				(if (or (== size -1) (not (-- global421)))
					(if theDiscardPile
						(theDiscardPile setCondition: 0)
					)
					(if (== ((Dealer curPlayer:) type:) 0)
						((Dealer curPlayer:) sort:)
					)
					(if (== size -1)
						(discardPile condition: 0)
						(= global421 0)
						(RedrawCast 1)
						(if ((Dealer curPlayer:) owner:)
							(RedrawCast)
							(((Dealer curPlayer:) owner:) say: 1000 1 0 0 14)
						)
					)
					((gCurRoom script:) cue:)
				)
			)
			((== global224 1)
				((gCurRoom script:) cue:)
			)
		)
	)
)

(instance discardPile of DiscardPile
	(properties)

	(method (cue)
		(return 1)
	)

	(method (init)
		(= x 165)
		(= y 99)
		(super init:)
	)

	(method (endHand)
		(upCard hide:)
		(super endHand:)
	)

	(method (isValid param1)
		(if
			(or
				(not upCard)
				(== (param1 rank:) (upCard rank:))
				(== (param1 rank:) 8)
				(and (== (upCard rank:) 8) (== (param1 suit:) global420))
				(and (!= (upCard rank:) 8) (== (param1 suit:) (upCard suit:)))
			)
			(cond
				((== condition 0)
					(return 1)
				)
				(
					(or
						(== condition 2)
						(== condition 4)
						(== condition 6)
						(== condition 8)
					)
					(if (and global422 (== (param1 rank:) 2))
						(return 1)
					else
						(= global403 condition)
						(return 0)
					)
				)
				((== condition 11)
					(return 1)
				)
				((== condition 12)
					(= global403 12)
					(return 0)
				)
				((== condition 13)
					(return 1)
				)
			)
		)
		(= global403 1)
		(if
			(or
				(== condition 2)
				(== condition 4)
				(== condition 6)
				(== condition 8)
			)
			(= global403 condition)
		)
		(if (== condition 12)
			(= global403 12)
		)
		(return 0)
	)

	(method (validPlay param1 &tmp temp0)
		(= global403 0)
		(if (self isValid: param1)
			(= temp0 (param1 signal:))
			(param1 stopUpd:)
			(cond
				((or (== condition 0) (== condition 11) (== condition 13))
					(return 1)
				)
				(
					(or
						(== condition 2)
						(== condition 4)
						(== condition 6)
						(== condition 8)
					)
					(if (and global422 (== (param1 rank:) 2))
						(return 1)
					else
						(gSound play: 905)
						(Characters say: 100 0 50 0 1 462)
						(return 0)
					)
				)
				((== condition 12)
					(gSound play: 905)
					(Characters say: 100 0 51 0 1 462)
					(return 0)
				)
			)
			(if (& temp0 $0003)
				(param1 startUpd:)
			)
		else
			(= temp0 (param1 signal:))
			(param1 stopUpd:)
			(if
				(or
					(and
						(or
							(== global403 2)
							(== global403 4)
							(== global403 6)
							(== global403 8)
							(== global403 12)
						)
						(!= global421 global403)
					)
					(and (== global403 12) (!= global421 5))
				)
				(= global403 7)
			)
			(if
				(and
					(or
						(== global403 2)
						(== global403 4)
						(== global403 6)
						(== global403 8)
						(== global403 12)
					)
					(== (global419 size:) -1)
				)
				(= global403 3)
			)
			(switch global403
				(1
					(gSound play: 905)
					(Characters say: 100 0 59 0 1 464)
				)
				(3
					(gSound play: 905)
					(Characters say: 100 0 60)
				)
				(7
					(gSound play: 905)
					(Characters say: 100 0 53 0 1 462)
				)
				(2
					(gSound play: 905)
					(Characters say: 100 0 54 0 1 462)
				)
				(4
					(gSound play: 905)
					(Characters say: 100 0 55 0 1 462)
				)
				(6
					(gSound play: 905)
					(Characters say: 100 0 56 0 1 462)
				)
				(8
					(gSound play: 905)
					(Characters say: 100 0 57 0 1 462)
				)
				(12
					(gSound play: 905)
					(Characters say: 100 0 58 0 1 462)
				)
			)
			(if (& temp0 $0003)
				(param1 startUpd:)
			)
		)
		(return 0)
	)

	(method (setCard param1 param2)
		(if (and (or (< argc 2) (not param2)) upCard (== (upCard rank:) 8))
			(transition hide: forceUpd:)
		)
		(param1 deleteKeyMouse:)
		(super setCard: param1)
		(if (and (== (upCard rank:) 8) ((Dealer curPlayer:) size:))
			(gSound play: 505)
		)
		(= global421 0)
		(if (and (== global223 1) (or (< argc 2) (not param2)))
			(switch (upCard rank:)
				(2
					(switch condition
						(2
							(self setCondition: 4)
							(= global421 4)
							(= global422 1)
							(gSong setLoop: 1)
							(gSong play: 104)
							(gSound2 play: 108)
						)
						(4
							(self setCondition: 6)
							(= global421 6)
							(= global422 1)
							(gSong setLoop: 1)
							(gSong play: 105)
							(gSound2 play: 108)
						)
						(6
							(self setCondition: 8)
							(= global421 8)
							(= global422 1)
							(gSong setLoop: 1)
							(gSong play: 106)
							(gSound2 play: 108)
						)
						(else
							(if (not (OneOf condition 2 4 6))
								(self setCondition: 2)
								(= global421 2)
								(= global422 1)
								(gSong setLoop: 1)
								(gSong play: 103)
							else
								(= condition 0)
							)
						)
					)
				)
				(11
					(if ((Dealer curPlayer:) size:)
						(gSong setLoop: 1)
						(gSong play: 109)
					)
					(self setCondition: 11 0)
					(Dealer nextToPlay:)
					((Dealer curPlayer:) tookCard: 0)
				)
				(12
					(if (== (upCard suit:) 0)
						(if ((Dealer curPlayer:) size:)
							(gSong setLoop: 1)
							(gSong play: 102)
						)
						(self setCondition: 12)
						(= global421 5)
					else
						(= condition 0)
					)
				)
				(13
					(if ((Dealer curPlayer:) size:)
						(gSong setLoop: 1)
						(gSong play: 110)
					)
					(self setCondition: 13 0)
					(if (== (Dealer playDirection:) 0)
						(Dealer playDirection: 1)
					else
						(Dealer playDirection: 0)
					)
					(directionArrow init: (Dealer playDirection:))
				)
				(else
					(= condition 0)
				)
			)
		else
			(= condition 0)
		)
	)

	(method (doCode param1)
		(if (and (== (param1 rank:) 8) ((Dealer curPlayer:) size:))
			(RedrawCast)
			((ScriptID 150 0) init:) ; chooseSuit
			(= global395 1)
			(transition init: (+ 101 (* (param1 suit:) 4) global420))
			(= associatedObj transition)
		else
			((gCurRoom script:) cue:)
		)
	)
)

(instance transition of Prop
	(properties)

	(method (init param1)
		(if (== ((Dealer curPlayer:) type:) 1)
			(((Dealer curPlayer:) owner:)
				say:
					1000
					1
					0
					0
					(switch (mod (- param1 1) 4)
						(0 8)
						(1 2)
						(2 4)
						(3 6)
					)
			)
		)
		(gSong setLoop: 1)
		(gSong play: 111)
		(self
			view: param1
			setLoop: 0
			cel: 0
			ignoreActors:
			setPri: 3
			posn: (+ (discardPile x:) 17) (+ (discardPile y:) 21)
			setCycle: End self
			show:
		)
		(super init:)
	)

	(method (cue)
		(self stopUpd:)
		(= global395 0)
		((gCurRoom script:) cue:)
	)
)

(instance theHands of List
	(properties)
)

(instance directionArrow of View
	(properties
		view 214
	)

	(method (init param1)
		(if (>= param1 0)
			(if param1
				(self posn: (+ (Arrow x:) 22) (Arrow y:))
			else
				(self posn: (- (Arrow x:) 15) (Arrow y:))
			)
			(self cel: param1 ignoreActors: setPri: 3 show: stopUpd:)
			(super init:)
		else
			(self dispose:)
		)
	)
)

