;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 300)
(include sci.sh)
(use Main)
(use KeyMouse)
(use Piles)
(use Character)
(use Tray)
(use n307)
(use HeartsStrategy)
(use Trick)
(use Print)
(use Motion)
(use File)
(use Actor)
(use System)

(public
	heartsGame 0
	proc300_1 1
	proc300_2 2
)

(local
	local0
	local1
	local2
	local3
	[local4 12] = [{h1} {h2} {h3} {h4} {h5} {h6} {h7} {h8} {h9} {h10} {h11} {h12}]
)

(procedure (proc300_1)
	(proc0_8 1097)
	((ScriptID 380 0) init:) ; scoreHearts
	(DisposeScript 380)
	(proc0_8 0)
)

(procedure (proc300_2 param1)
	(= global520 (localproc_0 param1))
)

(procedure (localproc_0 &tmp temp0)
	(global117 at: temp0) ; UNINIT
)

(class HeartsCard of Card
	(properties
		rating 0
	)

	(method (track &tmp temp0 temp1 [temp2 2])
		(= temp1 associatedObj)
		(= associatedObj gTrick)
		(= temp0 (super track:))
		(= associatedObj temp1)
		(return temp0)
	)
)

(instance heartsGame of HoyleRoom
	(properties
		style 10
	)

	(method (init)
		(= picture (+ 901 global385))
		(Load rsVIEW 50)
		(Load rsVIEW 51)
		(Load rsVIEW 52)
		(Load rsVIEW 53)
		(Load rsVIEW (+ 54 global384))
		(gGame setCursor: 999)
		(= local0 0)
		((= gHearts_opt hearts_opt) doit:)
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
		(Deck init: HeartsCard)
		(= global193 300)
		((= global117 theHands) add: hand1 hand2 hand3 hand4)
		(Piles add:)
		(passList1 add:)
		(passList2 add:)
		(passList3 add:)
		(passList4 add:)
		(= gTheCard4 theCard4)
		(hand1 partner: hand3)
		(hand3 partner: hand1)
		(hand2 partner: hand4)
		(hand4 partner: hand2)
		(hand1 playerOnLeft: hand2 playerOnRight: hand4 playerAcross: hand3)
		(hand2 playerOnLeft: hand3 playerOnRight: hand1 playerAcross: hand4)
		(hand3 playerOnLeft: hand4 playerOnRight: hand2 playerAcross: hand1)
		(hand4 playerOnLeft: hand1 playerOnRight: hand3 playerAcross: hand2)
		(hand1 add: passList: passList1 owner: 0)
		(hand2 add: passList: passList2 owner: gChar1)
		(hand3 add: passList: passList3 owner: gChar2)
		(hand4 add: passList: passList4 owner: gChar3)
		(HeartsTrick init:)
		(gTrick add: init: trump: -1)
		(handleEventList add:)
		(= global394 global231)
		(switch global232
			(0
				(= [global390 0] 3)
				(= [global390 1] 1)
				(= [global390 2] 2)
				(= [global390 3] 0)
			)
			(1
				(= [global390 0] 0)
				(= [global390 1] 2)
				(= [global390 2] 1)
				(= [global390 3] 3)
			)
		)
		(Dealer cardsToDeal: 13)
		(Deck rankAces: 14)
		(gChar1 posn: 55 120 view: (gChar1 view:) show: init:)
		(gChar2 posn: 90 34 view: (gChar2 view:) show: init:)
		(gChar3 posn: 265 120 view: (gChar3 view:) show: init:)
		(Characters init:)
		((gChar1 face:) view: (gChar1 view:))
		((gChar2 face:) view: (gChar2 view:))
		((gChar3 face:) view: (gChar3 view:))
		(Deck shuffle:)
		(gHearts_opt doit: 3)
		(KeyMouse setList: gTheKeyMouseList)
		(self setScript: roomScript)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(handleEventList handleEvent: event)
	)

	(method (doit)
		(super doit:)
		(Dealer doit:)
		(if global290
			(= global290 0)
			(global117 eachElementDo: #sort)
			(Animate (gCast elements:) 1)
		)
		(if (and global482 (== (++ global482) 1000))
			(if (== global233 0)
				(Characters say: 300 0 40)
			else
				(Characters say: 300 0 39)
			)
			(= global482 1)
		)
	)

	(method (dispose)
		(KeyMouse release:)
		((ScriptID 15 1) release: dispose:) ; discardList
		(gTrick eachElementDo: #stopUpd release: dispose:)
		(gDelayCast release:)
		(Dealer dispose:)
		(handleEventList release: dispose:)
		(global117 eachElementDo: #release dispose:)
		(if gTray
			(gTray release: dispose:)
		else
			(Piles dispose:)
		)
		(passList1 release: dispose:)
		(passList2 release: dispose:)
		(passList3 release: dispose:)
		(passList4 release: dispose:)
		(Deck dispose:)
		(= global395 0)
		(DisposeScript 702)
		(DisposeScript 941)
		(DisposeScript 9)
		(DisposeScript 370)
		(DisposeScript 380)
		(super dispose:)
	)
)

(class HeartsHand of Hand
	(properties
		pointsTaken 0
		passList 0
		passCardsX 0
		passCardsY 0
		passTo 0
		playerOnLeft 0
		playerOnRight 0
		playerAcross 0
		passActor 0
		takeAllPlayer 0
		obvious 0
		spadesList 0
		clubsList 0
		diamondsList 0
		heartsList 0
		outOfSpades 0
		outOfClubs 0
		outOfDiamonds 0
		outOfHearts 0
	)

	(method (dispose)
		(if spadesList
			(spadesList release: dispose:)
			(= spadesList 0)
		)
		(if clubsList
			(clubsList release: dispose:)
			(= clubsList 0)
		)
		(if diamondsList
			(diamondsList release: dispose:)
			(= diamondsList 0)
		)
		(if heartsList
			(heartsList release: dispose:)
			(= heartsList 0)
		)
		(super dispose:)
	)

	(method (enterKey param1 param2)
		(= global458 param1)
		(cond
			(gTray
				(if (gTray validPlay: param1)
					(self moveCard: gTray)
					(proc0_1)
					(cond
						((== (gTray size:) 2)
							(KeyMouse setCursor: (gTray theOkButton:))
						)
						(size
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
			)
			((gTrick validPlay: param1 self)
				(if (== (global458 suit:) 3)
					(= global481 1)
				)
				(if
					(and
						(== global235 1)
						(== (global458 suit:) 0)
						(== (global458 rank:) 12)
					)
					(= global481 1)
				)
				(self moveCard: gTrick)
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
	)

	(method (hasCard param1 param2 &tmp temp0)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(if
				(and
					(== ((self at: temp0) rank:) param1)
					(== ((self at: temp0) suit:) param2)
				)
				(return (self at: temp0))
			)
		)
		(return 0)
	)

	(method (newBacks)
		(if (<= 64 (gTheCard1 view:) 72)
			(gTheCard1 view: (+ 64 global384) forceUpd:)
		)
		(if (<= 64 (gTheCard2 view:) 72)
			(gTheCard2 view: (+ 64 global384) forceUpd:)
		)
		(if (<= 64 (gTheCard3 view:) 72)
			(gTheCard3 view: (+ 64 global384) forceUpd:)
		)
		(if (<= 64 (gTheCard4 view:) 72)
			(gTheCard4 view: (+ 64 global384) forceUpd:)
		)
	)

	(method (setPassTo param1)
		(switch param1
			(1
				(= passTo playerOnLeft)
			)
			(2
				(= passTo playerOnRight)
			)
			(3
				(= passTo playerAcross)
			)
		)
	)

	(method (addPassCards &tmp temp0 temp1)
		(passActor dispose:)
		(gSound play: 907)
		(for ((= temp1 0)) (< temp1 3) ((++ temp1))
			(passTo
				add:
					((passList at: temp1)
						flip: (passTo faceUp:)
						setPri: 2
						show:
						yourself:
					)
					0
					1
			)
			(if (== (passTo type:) 1)
				((passList at: temp1) deleteKeyMouse:)
			else
				((passList at: temp1) addKeyMouse:)
			)
		)
		(passList release:)
	)

	(method (passCards param1 &tmp temp0)
		(gSound play: 902)
		(passActor
			setMotion: MoveTo (passTo calcNextX:) (passTo calcNextY:) param1
		)
	)

	(method (showPassCards &tmp temp0 temp1)
		(gSound play: 901)
		(= temp1
			(switch global387
				(0 300)
				(1 20)
				(2 10)
			)
		)
		(= passActor
			(switch location
				(3 gTheCard1)
				(4 gTheCard2)
				(1 gTheCard3)
				(2 gTheCard4)
			)
		)
		(passActor
			view: (+ 64 global384)
			setLoop: (- handDirection 1)
			cel: 0
			posn: passCardsX passCardsY
			setStep: temp1 temp1
			setPri: 3
			moveSpeed: 0
			ignoreActors:
			ignoreHorizon:
			show:
			stopUpd:
			init:
		)
	)

	(method (thinkPass)
		(HeartsStrategy thinkPass: self)
		(self showPassCards:)
		((gCurRoom script:) cue:)
	)

	(method (think &tmp temp0)
		(= global458 (HeartsStrategy think: self))
		(if
			(or
				(== (global458 suit:) 3)
				(and
					(== global235 1)
					(== (global458 suit:) 0)
					(== (global458 rank:) 12)
				)
			)
			(= global481 1)
		)
		(if (!= (global458 suit:) global528)
			(switch global528
				(0
					(= outOfSpades 1)
				)
				(1
					(= outOfClubs 1)
				)
				(2
					(= outOfDiamonds 1)
				)
				(3
					(= outOfHearts 1)
				)
			)
		)
		(= [global184 (global458 suit:)] (+ [global184 (global458 suit:)] 1))
		(if (not (gTrick size:))
			(proc307_0 self)
			(DisposeScript 307)
		)
		(self moveCard: gTrick)
		(= gCrazy8sHand 0)
	)

	(method (cue)
		(super cue:)
		((ScriptID 15 6) setCycle: 0) ; littleCard
		(if gTray
			(gTray setCard: global458)
		else
			(gTrick setCard: global458)
		)
		(= global395 0)
	)

	(method (couldPlay param1 &tmp temp0 temp1)
		(for ((= temp0 (= temp1 0))) (< temp0 size) ((++ temp0))
			(if (== ((self at: temp0) suit:) param1)
				(++ temp1)
			)
		)
		(return temp1)
	)

	(method (atRank param1)
		((self at: param1) rank:)
	)

	(method (atSuit param1)
		((self at: param1) suit:)
	)

	(method (howManyOfSuit param1 &tmp temp0 temp1)
		(for ((= temp0 (= temp1 0))) (< temp0 size) ((++ temp0))
			(if (== (self atSuit: temp0) param1)
				(++ temp1)
			)
		)
		(return temp1)
	)

	(method (howManyOfRank param1 &tmp temp0 temp1)
		(for ((= temp0 (= temp1 0))) (< temp0 size) ((++ temp0))
			(if (== (self atRank: temp0) param1)
				(++ temp1)
			)
		)
		(return temp1)
	)

	(method (makeLists)
		(= spadesList (self makeSuitList: 0 spadesList))
		(= clubsList (self makeSuitList: 1 clubsList))
		(= diamondsList (self makeSuitList: 2 diamondsList))
		(= heartsList (self makeSuitList: 3 heartsList))
	)

	(method (makeSuitList param1 param2 &tmp temp0 temp1 temp2)
		(if (and (>= argc 2) param2 (IsObject param2))
			((= temp2 param2) release:)
		else
			((= temp2 (HeartsHand new:)) name: [local4 local2] add:)
			(++ local2)
		)
		(for ((= temp0 2)) (<= temp0 14) ((++ temp0))
			(for ((= temp1 0)) (< temp1 size) ((++ temp1))
				(if
					(and
						(== (self atRank: temp1) temp0)
						(== (self atSuit: temp1) param1)
					)
					(temp2 add: (self at: temp1) 0 0 self)
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

	(method (outOf param1)
		(if
			(switch param1
				(0 outOfSpades)
				(1 outOfClubs)
				(2 outOfDiamonds)
				(3 outOfHearts)
			)
			(return 1)
		else
			(return 0)
		)
	)

	(method (setTakeAllPlayer &tmp [temp0 3])
		(HeartsStrategy setTakeAllPlayer: self)
	)
)

(instance hand1 of HeartsHand
	(properties
		x 95
		y 155
		handNumber 3
		faceUp 1
		centerX 160
		centerY 175
		passCardsX 133
		passCardsY 141
	)
)

(instance hand2 of HeartsHand
	(properties
		x 3
		y 30
		handDirection 2
		type 1
		handNumber 4
		location 4
		centerX 25
		centerY 100
		passCardsX 15
		passCardsY 69
	)
)

(instance hand3 of HeartsHand
	(properties
		x 95
		y 3
		type 1
		handNumber 1
		location 1
		centerX 160
		centerY 25
		passCardsX 133
		passCardsY 14
	)
)

(instance hand4 of HeartsHand
	(properties
		x 280
		y 30
		handDirection 2
		type 1
		handNumber 2
		location 2
		centerX 295
		centerY 100
		passCardsX 268
		passCardsY 69
	)
)

(instance passList1 of List
	(properties)
)

(instance passList2 of List
	(properties)
)

(instance passList3 of List
	(properties)
)

(instance passList4 of List
	(properties)
)

(instance theHands of List
	(properties)
)

(instance handleEventList of EventHandler
	(properties)
)

(instance hearts_opt of File
	(properties
		name {hearts.opt}
	)

	(method (doit param1 &tmp [temp0 20] [temp20 10])
		(cond
			((and argc (== param1 3))
				(if (self open: 2)
					(self
						writeString:
							(Format ; "%d%d%d%d%d%d%2d%2d%2d%d%d%d%d%d%d"
								@temp0
								300
								0
								global231
								global232
								global233
								global234
								global235
								global236
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
				(= global231 (ReadNumber (self readString: @temp20 2)))
				(= global232 (ReadNumber (self readString: @temp20 2)))
				(= global233 (ReadNumber (self readString: @temp20 2)))
				(= global234 (ReadNumber (self readString: @temp20 2)))
				(= global235 (ReadNumber (self readString: @temp20 2)))
				(= global236 (ReadNumber (self readString: @temp20 2)))
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
				(= global231 3)
				(= global232 0)
				(= global233 0)
				(= global234 0)
				(= global235 0)
				(= global236 0)
				(= global463 9)
				(= global464 13)
				(= global465 17)
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

(instance roomScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2] temp2 [temp3 3])
		(switch (= state newState)
			(0
				(Wait 1)
				(= ticks 1)
			)
			(1
				(PicNotValid 0)
				(if local0
					(proc0_3)
					(proc0_1)
					(gGameControls hide:)
					(= local1 (gSystemWindow back:))
					(gSystemWindow back: 53)
					((ScriptID 390 0) init:) ; optionHearts
					(gSystemWindow back: local1)
					(proc0_4)
				)
				(gSong fade:)
				(= global480 0)
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
				(proc0_4)
				(= global482 0)
				(= global237 0)
				(hand1 tempTotal: 0)
				(hand2 tempTotal: 0)
				(hand3 tempTotal: 0)
				(hand4 tempTotal: 0)
				(gTrick
					tricksPlayed: 0
					northPlayer: hand3
					southPlayer: hand1
					eastPlayer: hand4
					westPlayer: hand2
				)
				(Dealer playDirection: 0 deal: self)
			)
			(5
				(global117 eachElementDo: #tempTotal 0)
				(hand1 sort:)
				(hand1 eachElementDo: #addKeyMouse)
				(= ticks 1)
			)
			(6
				(Arrow x: 240 y: 30 init:)
				(= global116 0)
				(handleEventList add: hand1 hand2 hand3 hand4)
				(Piles delete: gTrick)
				(cond
					((== global234 1)
						(= global480 1)
					)
					((== global234 2)
						(= global480 0)
					)
					(else
						(= global480
							(switch global480
								(1 2)
								(2 3)
								(3 0)
								(else 1)
							)
						)
					)
				)
				(if (or (< global480 0) (> global480 3))
					(= global480 1)
				)
				(= ticks 1)
			)
			(7
				(= global481 0)
				(global117 eachElementDo: #setPassTo global480)
				(if (== global480 0)
					(= state 10)
					(= ticks 1)
					(Piles add: gTrick)
					(return)
				)
				(if (== ((Dealer curPlayer:) type:) 1)
					((Dealer curPlayer:) thinkPass:)
				else
					(Tray
						x: 90
						y: 75
						init:
							handleEventList
							self
							((Dealer curPlayer:) passList:)
					)
					(proc0_1)
					(proc0_3)
				)
			)
			(8
				(if (== ((Dealer curPlayer:) type:) 0)
					((Dealer curPlayer:) showPassCards:)
				)
				(if (!= (++ global116) 4)
					(-= state 2)
				else
					(= global116 0)
				)
				(Dealer nextToPlay:)
				(= ticks 1)
			)
			(9
				((Dealer curPlayer:) passCards: self)
			)
			(10
				((Dealer curPlayer:) addPassCards:)
				(if (!= (++ global116) 4)
					(-= state 2)
				)
				(Dealer nextToPlay:)
				(= ticks 1)
			)
			(11
				(if (and (hand1 passTo:) (not (Random 0 5)))
					(if (Random 0 1)
						(Characters say: 1000 1 23 0 (Random 1 3) 464 1 self)
					else
						(Characters say: 1000 1 23 0 (Random 3 5) 466 1 self)
					)
				else
					(= ticks 1)
				)
			)
			(12
				(proc0_1)
				(if (not (Piles contains: gTrick))
					(Piles add: gTrick)
				)
				(if (== global233 0)
					(for ((= temp2 0)) (< temp2 4) ((++ temp2))
						(if ((global117 at: temp2) hasCard: 2 1)
							(Dealer nextToPlay: (global117 at: temp2))
							(proc0_1)
							(= global482 1)
							(break)
						)
					)
				)
				(= ticks 1)
			)
			(13
				(hand2 setTakeAllPlayer:)
				(hand3 setTakeAllPlayer:)
				(hand4 setTakeAllPlayer:)
				(if (== ((Dealer curPlayer:) type:) 1)
					((Dealer curPlayer:) think:)
				else
					(if (not (gTrick size:))
						(= global528 -1)
					)
					(proc0_3)
				)
			)
			(14
				(Dealer
					nextToPlay:
						(if (gTrick size:)
							0
						else
							(gTrick leader:)
						)
				)
				(proc0_1)
				(if (and global459 (not (gTrick size:)))
					(= ticks 1)
				else
					(= ticks
						(if (== ((Dealer curPlayer:) type:) 1)
							(* global386 3)
						else
							1
						)
					)
					(if (!= (gTrick tricksPlayed:) 13)
						(-= state 2)
					)
				)
			)
			(15
				(proc0_3)
				(Arrow endHand:)
				(handleEventList delete: hand1 hand2 hand3 hand4)
				(= ticks 1)
			)
			(16
				(for ((= temp2 0)) (< temp2 (global117 size:)) ((++ temp2))
					(if (== ((global117 at: temp2) tempTotal:) 26)
						(hand1 tempTotal: 26)
						(hand2 tempTotal: 26)
						(hand3 tempTotal: 26)
						(hand4 tempTotal: 26)
						((global117 at: temp2) tempTotal: 0)
						(gSound
							play:
								(if (== ((global117 at: temp2) type:) 0)
									304
								else
									303
								)
						)
						(if (== ((global117 at: temp2) type:) 0)
							(Characters
								say: 1000 1 23 0 (Random 4 5) 466 1 self
							)
						else
							(Characters
								say: 1000 1 23 0 (Random 1 2) 464 1 self
							)
						)
						(return)
					)
				)
				(= ticks 1)
			)
			(17
				(proc0_1)
				(global117 eachElementDo: #calcScore 1)
				((ScriptID 380 0) init:) ; scoreHearts
				((ScriptID 15 1) release:) ; discardList
				(global117 eachElementDo: #endHand)
				(= ticks 1)
			)
			(18
				(if
					(and
						(< (hand1 total:) 100)
						(< (hand2 total:) 100)
						(< (hand3 total:) 100)
						(< (hand4 total:) 100)
					)
					(= state 3)
					(= global503 0)
					(Deck shuffle:)
					(Dealer rotate: cardsToDeal: 13)
				)
				(= ticks 1)
			)
			(19
				((ScriptID 930 0) init: 370) ; yesNo
				(DisposeScript 930)
				(if global461
					(= state 2)
					(Deck shuffle:)
					(Dealer rotate: cardsToDeal: 13)
				)
				(= ticks 1)
			)
			(20
				(= gNewRoomNum 975) ; chooseGame
			)
		)
	)
)

(instance theCard4 of Actor
	(properties)
)

(class HeartsTrick of Trick
	(properties)

	(method (checkShoot &tmp temp0 temp1 temp2 temp3)
		(= temp1 0)
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			(if ((global117 at: temp0) tempTotal:)
				(++ temp1)
				(= temp2 ((global117 at: temp0) tempTotal:))
				(= temp3 (global117 at: temp0))
			)
		)
		(if (and (== temp1 1) (>= temp2 22))
			(return temp3)
		)
		(return 0)
	)

	(method (init)
		(= global530 0)
		(super init: &rest)
	)

	(method (endTrick &tmp temp0 temp1)
		(= temp1 (self checkShoot:))
		(= global530 0)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(if (== ((self at: temp0) suit:) 3)
				(++ global530)
			)
			(if
				(and
					(== ((self at: temp0) suit:) 0)
					(== ((self at: temp0) rank:) 12)
				)
				(+= global530 13)
				(gSound play: (if (== (highPlayer type:) 0) 302 else 301))
			)
		)
		(highPlayer tempTotal: (+ (highPlayer tempTotal:) global530))
		(+= global237 global530)
		(if (and (not (Random 0 5)) (not temp1) (>= global530 13))
			(if (== (highPlayer location:) 3)
				(Characters say: 1000 1 23 0 (Random 1 2))
			else
				(Characters say: 1000 1 23 0 (Random 4 5))
			)
		)
		(if (and temp1 (!= temp1 (self checkShoot:)))
			(if (== temp1 hand1)
				(Characters say: 1000 1 23 0 (Random 1 2))
			else
				(Characters say: 1000 1 23 0 (Random 4 5))
			)
			(proc0_1)
		)
		(super endTrick:)
	)

	(method (validPlay param1 param2 &tmp temp0)
		(if (and global482 (== global233 0))
			(if (and (== (param1 rank:) 2) (== (param1 suit:) 1))
				(= global482 0)
				(return 1)
			else
				(param1 stopUpd:)
				(gSound play: 905)
				(Characters say: 300 0 42)
				(param1 startUpd:)
				(return 0)
			)
		)
		(if (and (!= global528 -1) (!= (param1 suit:) global528))
			(for ((= temp0 0)) (< temp0 (param2 size:)) ((++ temp0))
				(if (== ((param2 at: temp0) suit:) global528)
					(param1 stopUpd:)
					(gSound play: 905)
					(Print addText: 19 43 0 1 init:) ; "You must follow suit since you have a valid play."
					(param1 startUpd:)
					(return 0)
				)
			)
			(if
				(and
					(== (param2 size:) 13)
					(== global236 1)
					(or
						(== (param1 suit:) 3)
						(and
							(== global235 1)
							(== (param1 suit:) 0)
							(== (param1 rank:) 12)
						)
					)
				)
				(= local3 (param1 signal:))
				(param1 stopUpd:)
				(gSound play: 905)
				(Characters say: 300 0 41)
				(if (& local3 $0003)
					(param1 startUpd:)
				)
				(return 0)
			)
		)
		(if
			(and
				(== global528 -1)
				(not global481)
				(or
					(== (param1 suit:) 3)
					(and
						(== global235 1)
						(== (param1 suit:) 0)
						(== (param1 rank:) 12)
					)
				)
			)
			(for ((= temp0 0)) (< temp0 (param2 size:)) ((++ temp0))
				(if
					(or
						(== ((param2 at: temp0) suit:) 1)
						(== ((param2 at: temp0) suit:) 2)
						(and (== ((param2 at: temp0) suit:) 0) (== global235 0))
						(and
							(== ((param2 at: temp0) suit:) 0)
							(== global235 1)
							(!= ((param2 at: temp0) rank:) 12)
						)
					)
					(= local3 (param1 signal:))
					(param1 stopUpd:)
					(gSound play: 905)
					(if
						(and
							(== (param1 suit:) 0)
							(== (param1 rank:) 12)
							(== global235 1)
						)
						(Characters say: 300 0 25)
					else
						(Characters say: 300 0 24)
					)
					(if (& local3 $0003)
						(param1 startUpd:)
					)
					(return 0)
				)
			)
		)
		(if
			(or
				(== (param1 suit:) 3)
				(and
					(== global235 1)
					(== (param1 suit:) 0)
					(== (param1 rank:) 12)
				)
			)
			(= global481 1)
		)
		(= global482 0)
		(return 1)
	)

	(method (setCard param1 &tmp temp0 temp1)
		(if (and (== (param1 rank:) 12) (== (param1 suit:) 0))
			(= global503 1)
			(gSound2 play: 1102)
		)
		(if
			(or
				(not size)
				(and (> (param1 rank:) global529) (== (param1 suit:) global528))
			)
			(= global528 (param1 suit:))
			(= global529 (param1 rank:))
			(= global525 (global117 indexOf: (Dealer curPlayer:)))
		)
		(super setCard: param1 1)
		(= global530 0)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(if (== ((= temp1 (self at: temp0)) suit:) 3)
				(++ global530)
			)
			(if (and (== (temp1 suit:) 0) (== (temp1 rank:) 12))
				(+= global530 13)
			)
		)
	)

	(method (playedCard param1 param2 &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(if
				(and
					(== ((= temp1 (self at: temp0)) rank:) param1)
					(== (temp1 suit:) param2)
				)
				(return 1)
			)
		)
		(for ((= temp0 0)) (< temp0 ((ScriptID 15 1) size:)) ((++ temp0)) ; discardList
			(if
				(and
					(== ((= temp1 ((ScriptID 15 1) at: temp0)) rank:) param1) ; discardList
					(== (temp1 suit:) param2)
				)
				(return 1)
			)
		)
		(return 0)
	)

	(method (remaining param1 &tmp temp0 temp1)
		(= temp0 (= temp1 0))
		(while (< temp1 size)
			(if (== ((self at: temp1) suit:) param1)
				(++ temp0)
			)
			(++ temp1)
		)
		(for ((= temp1 0)) (< temp1 ((ScriptID 15 1) size:)) ((++ temp1)) ; discardList
			(if (== (((ScriptID 15 1) at: temp1) suit:) param1) ; discardList
				(++ temp0)
			)
		)
		(return (- 13 temp0))
	)

	(method (anyHigherRemaining param1 param2 &tmp temp0 temp1 temp2 temp3)
		(= temp0 (= temp1 0))
		(while (< temp1 size)
			(if
				(and
					(== ((= temp3 (self at: temp1)) suit:) param1)
					(> (temp3 rank:) param2)
				)
				(++ temp0)
			)
			(++ temp1)
		)
		(for ((= temp1 0)) (< temp1 ((ScriptID 15 1) size:)) ((++ temp1)) ; discardList
			(if
				(and
					(== ((= temp3 ((ScriptID 15 1) at: temp1)) suit:) param1) ; discardList
					(> (temp3 rank:) param2)
				)
				(++ temp0)
			)
		)
		(return (- 14 (+ param2 temp0)))
	)
)

