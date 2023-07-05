;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 300)
(include sci.sh)
(use Main)
(use KeyMouse)
(use Piles)
(use h5Messager)
(use theTitle)
(use n307)
(use HeartsStrategy)
(use Trick)
(use Str)
(use IconBar)
(use Motion)
(use File)
(use Actor)
(use System)

(public
	heartsGame 0
	proc300_1 1
	proc300_2 2
	proc300_3 3
)

(local
	local0
	local1
	local2
	local3
	[local4 12] = [{h1} {h2} {h3} {h4} {h5} {h6} {h7} {h8} {h9} {h10} {h11} {h12}]
	local16 = 13
	local17
)

(procedure (proc300_1)
	(IconBarF darken:)
	((ScriptID 380 0) init:) ; scoreHearts
	(DisposeScript 380)
	(IconBarF lighten:)
)

(procedure (proc300_2 param1)
	(= global520 (localproc_0 param1))
)

(procedure (localproc_0 &tmp temp0)
	(global117 at: temp0) ; UNINIT
)

(procedure (proc300_3 param1)
	(if argc
		(= local17 param1)
	else
		(return local17)
	)
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
		style 14
	)

	(method (init)
		(= local17 0)
		(Load rsVIEW 50)
		(Load rsVIEW 51)
		(Load rsVIEW 52)
		(Load rsVIEW 53)
		(Load rsVIEW (+ 54 global384))
		(gGame setCursor: 999)
		(= local0 0)
		((= gHearts_opt hearts_opt) doit:)
		(if global878
			(PlaySong play: (+ 50 global878))
		else
			(PlaySong play: 51)
		)
		(if (not local17)
			(gSong setLoop: 1)
		)
		(= picture (+ global877 global385))
		(super init:)
		(Deck init: HeartsCard)
		(= gCardGameScriptNumber 300)
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
		(= gSortMode global231)
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
		(Dealer cardsToDeal: local16)
		(Deck rankAces: 14)
		(gChar1 posn: 56 327 view: (gChar1 view:) show: init:)
		(gChar2 posn: 210 56 view: (gChar2 view:) show: init:)
		(gChar3 posn: 584 149 view: (gChar3 view:) show: init:)
		(Characters init:)
		(Deck shuffle:)
		(gHearts_opt doit: 3)
		(KeyMouse setList: gTheKeyMouseList)
		(IconBarF init:)
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
			(proc0_9 (gCast elements:) 1)
		)
		(if (and global482 (== (++ global482) 1000))
			(if (== global233 0)
				(= global920 1)
				(Characters sayReg: 300 15 40 0 (Random 1 2))
			else
				(= global920 1)
				(Characters sayReg: 1000 2 123 0 (Random 1 2))
			)
			(= global482 1)
		)
	)

	(method (dispose)
		(self setScript: roomScript)
		(KeyMouse release:)
		(if ((ScriptID 15 1) size:) ; discardList
			((ScriptID 15 1) release:) ; discardList
		)
		((ScriptID 15 1) dispose:) ; discardList
		(gTrick release: dispose:)
		(gDelayCast release:)
		(Dealer dispose:)
		(handleEventList release: dispose:)
		(HeartsTrick dispose:)
		(IconBarF dispose:)
		(global117 eachElementDo: #release dispose:)
		(if gTray
			(if (gTray elements:)
				(gTray release:)
			)
			(gTray dispose:)
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
		(DisposeScript 64941)
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

	(method (add &tmp temp0)
		(super add: &rest)
		(if (not (Dealer script:))
			(for ((= temp0 0)) (< temp0 (hand1 size:)) ((++ temp0))
				((hand1 at: temp0) setPri: (+ temp0 2))
			)
			(for ((= temp0 0)) (< temp0 (hand2 size:)) ((++ temp0))
				((hand2 at: temp0) setPri: (+ temp0 2))
			)
			(for ((= temp0 0)) (< temp0 (hand3 size:)) ((++ temp0))
				((hand3 at: temp0) setPri: (+ temp0 2))
			)
			(for ((= temp0 0)) (< temp0 (hand4 size:)) ((++ temp0))
				((hand4 at: temp0) setPri: (+ temp0 2))
			)
		)
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
					(RedrawCast)
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
		(if (<= 74 (gTheCard1 view:) 93)
			(gTheCard1 view: (+ 74 global384))
		)
		(if (<= 74 (gTheCard2 view:) 93)
			(gTheCard2 view: (+ 74 global384))
		)
		(if (<= 74 (gTheCard3 view:) 93)
			(gTheCard3 view: (+ 74 global384))
		)
		(if (<= 74 (gTheCard4 view:) 93)
			(gTheCard4 view: (+ 74 global384))
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
		(passActor setPri: 100)
		(passActor
			setMotion: MoveTo (passTo calcNextX:) (passTo calcNextY:) param1
		)
	)

	(method (showPassCards &tmp temp0 temp1)
		(proc0_12 901)
		(= temp1
			(switch global898
				(0 300)
				(1 300)
				(2 300)
				(3 100)
				(4 100)
				(5 100)
				(14 10)
				(15 10)
				(16 10)
				(else 50)
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
			view: (+ 74 global384)
			setLoop: (- handDirection 1)
			cel: 0
			posn: passCardsX passCardsY
			setStep: temp1 temp1
			setPri: 30
			moveSpeed: 0
			ignoreActors:
			ignoreHorizon:
		)
		(passActor init:)
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
		(if (and (>= argc 2) param2 (!= param2 0))
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
		x 196
		y 315
		handNumber 3
		faceUp 1
		centerX 286
		centerY 315
		passCardsX 286
		passCardsY 290
	)
)

(instance hand2 of HeartsHand
	(properties
		x 71
		y 46
		handDirection 2
		type 1
		handNumber 4
		location 4
		centerX 71
		centerY 124
		passCardsX 96
		passCardsY 124
	)
)

(instance hand3 of HeartsHand
	(properties
		x 237
		y 20
		type 1
		handNumber 1
		location 1
		centerX 327
		centerY 20
		passCardsX 327
		passCardsY 45
	)
)

(instance hand4 of HeartsHand
	(properties
		x 500
		y 133
		handDirection 2
		type 1
		handNumber 2
		location 2
		centerX 500
		centerY 214
		passCardsX 475
		passCardsY 214
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

	(method (doit param1 &tmp temp0 temp1)
		(cond
			((and argc (== param1 3))
				(if (self open: 2)
					(= temp0 (Str new:))
					(self
						writeString:
							(= temp0
								(Str
									format:
										{%d%d%d%d%d%d%d%d%2d%d%d%d%d%d%d}
										global231
										global232
										global233
										global234
										global235
										global236
										global385
										global878
										global384
										local17
										0
										0
										0
										0
										0
								)
							)
						close:
					)
					(temp0 dispose:)
					(return 1)
				else
					(return 0)
				)
			)
			((self open: 1)
				(= temp1 (Str new:))
				(self readString: temp1 2)
				(= global231 (temp1 asInteger:))
				(self readString: temp1 2)
				(= global232 (temp1 asInteger:))
				(self readString: temp1 2)
				(= global233 (temp1 asInteger:))
				(self readString: temp1 2)
				(= global234 (temp1 asInteger:))
				(self readString: temp1 2)
				(= global235 (temp1 asInteger:))
				(self readString: temp1 2)
				(= global236 (temp1 asInteger:))
				(self readString: temp1 2)
				(= global385 (temp1 asInteger:))
				(self readString: temp1 2)
				(= global878 (temp1 asInteger:))
				(self readString: temp1 3)
				(= global384 (temp1 asInteger:))
				(self readString: temp1 2)
				(= local17 (temp1 asInteger:))
				(self readString: temp1 2)
				(self readString: temp1 2)
				(self readString: temp1 2)
				(self readString: temp1 2)
				(self readString: temp1 2)
				(temp1 dispose:)
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
				(= local17 0)
				(= global385 7)
				(= global878 0)
				(= global384 0)
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
				(= ticks 1)
			)
			(1
				(if local0
					(EnableCursor)
					(RedrawCast)
					(gGameControls hide:)
					((ScriptID 390 0) init:) ; optionHearts
					(DisableCursor)
				)
				(= global480 0)
				(= ticks 1)
			)
			(2
				(Dealer init: hand1 hand2 hand3 hand4)
				(IconBar show:)
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
				(DisableCursor)
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
				(Arrow x: 490 y: 20 init:)
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
				(hand1 sort:)
				(RedrawCast)
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
						x: 260
						y: 160
						init:
							handleEventList
							self
							((Dealer curPlayer:) passList:)
					)
					(RedrawCast)
					(EnableCursor)
				)
				(hand3 update:)
				(hand2 update:)
				(hand4 update:)
				(RedrawCast)
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
				(hand3 update:)
				(hand2 update:)
				(hand4 update:)
				(hand1 sort:)
				(RedrawCast)
				(if (hand1 passTo:)
					(if (Random 0 1)
						(Characters sayPN: 1000 2 82 0 (Random 1 5) 719 1 self)
					else
						(Characters sayPN: 1000 2 83 0 (Random 1 5) 721 1 self)
					)
				else
					(= ticks 1)
				)
			)
			(12
				(RedrawCast)
				(if (Piles elements:)
					(if (not (Piles contains: gTrick))
						(Piles add: gTrick)
					)
				else
					(Piles add: gTrick)
				)
				(if (== global233 0)
					(for ((= temp2 0)) (< temp2 4) ((++ temp2))
						(if ((global117 at: temp2) hasCard: 2 1)
							(Dealer nextToPlay: (global117 at: temp2))
							(RedrawCast)
							(= global482 1)
							(break)
						)
					)
				)
				(= ticks 1)
			)
			(13
				(DisableCursor)
				(hand2 setTakeAllPlayer:)
				(hand3 setTakeAllPlayer:)
				(hand4 setTakeAllPlayer:)
				(if (== ((Dealer curPlayer:) type:) 1)
					((Dealer curPlayer:) think:)
				else
					(if (not (gTrick size:))
						(= global528 -1)
					)
					(EnableCursor)
				)
			)
			(14
				(hand3 update:)
				(hand2 update:)
				(hand4 update:)
				(RedrawCast)
				(Dealer
					nextToPlay:
						(if (gTrick size:)
							0
						else
							(gTrick leader:)
						)
				)
				(RedrawCast)
				(if (and global459 (not (gTrick size:)))
					(= ticks 1)
				else
					(= ticks
						(if (== ((Dealer curPlayer:) type:) 1)
							(* global899 5)
						else
							1
						)
					)
					(if (== ticks 5)
						(= ticks 1)
					)
					(if (!= (gTrick tricksPlayed:) 13)
						(-= state 2)
					)
				)
			)
			(15
				(EnableCursor)
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
						(proc0_12
							(if (== ((global117 at: temp2) type:) 0)
								304
							else
								303
							)
						)
						(if (== ((global117 at: temp2) type:) 0)
							(Characters
								sayPN: 1000 2 83 0 (Random 1 5) 721 1 self
							)
						else
							(Characters
								sayPN: 1000 2 82 0 (Random 1 5) 719 1 self
							)
						)
						(= temp2 10)
					)
				)
				(if (<= temp2 9)
					(= ticks 1)
				)
			)
			(17
				(RedrawCast)
				(cond
					(
						(or
							(== (hand2 tempTotal:) 0)
							(and
								(< (hand2 tempTotal:) (hand1 tempTotal:))
								(< (hand2 tempTotal:) (hand3 tempTotal:))
								(< (hand2 tempTotal:) (hand4 tempTotal:))
							)
						)
						(gChar1 sayPN: 1000 2 82 0 (Random 1 5) 719 1 self)
					)
					(
						(or
							(== (hand3 tempTotal:) 0)
							(and
								(< (hand3 tempTotal:) (hand1 tempTotal:))
								(< (hand3 tempTotal:) (hand2 tempTotal:))
								(< (hand3 tempTotal:) (hand4 tempTotal:))
							)
						)
						(gChar2 sayPN: 1000 2 82 0 (Random 1 5) 719 1 self)
					)
					(
						(or
							(== (hand4 tempTotal:) 0)
							(and
								(< (hand4 tempTotal:) (hand1 tempTotal:))
								(< (hand4 tempTotal:) (hand2 tempTotal:))
								(< (hand4 tempTotal:) (hand3 tempTotal:))
							)
						)
						(gChar3 sayPN: 1000 2 82 0 (Random 1 5) 719 1 self)
					)
					(else
						(= ticks 1)
					)
				)
				(global117 eachElementDo: #calcScore 1)
				(IconBarF darken:)
				((ScriptID 380 0) init:) ; scoreHearts
				(DisposeScript 380)
				(IconBarF lighten:)
				((ScriptID 15 1) release:) ; discardList
				(global117 eachElementDo: #endHand)
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
					(Dealer rotate: cardsToDeal: local16)
				)
			)
			(18
				(= ticks 1)
			)
			(19
				(cond
					(
						(or
							(== (hand2 total:) 0)
							(and
								(< (hand2 total:) (hand1 total:))
								(< (hand2 total:) (hand3 total:))
								(< (hand2 total:) (hand4 total:))
							)
						)
						(gChar1 sayReg: 1000 2 64 0 2)
					)
					(
						(or
							(== (hand3 total:) 0)
							(and
								(< (hand3 total:) (hand1 total:))
								(< (hand3 total:) (hand2 total:))
								(< (hand3 total:) (hand4 total:))
							)
						)
						(gChar2 sayReg: 1000 2 64 0 2)
					)
					(
						(or
							(== (hand4 total:) 0)
							(and
								(< (hand4 total:) (hand1 total:))
								(< (hand4 total:) (hand2 total:))
								(< (hand4 total:) (hand3 total:))
							)
						)
						(gChar3 sayReg: 1000 2 64 0 2)
					)
					((> gAttitudeSetting 1)
						(gChar1 say: 15 15 179 0 (Random 1 7))
					)
				)
				(IconBarF darken:)
				((ScriptID 930 0) init: 370) ; yesNo
				(DisposeScript 930)
				(IconBarF lighten:)
				(cond
					(global748
						(= state 2)
						(Deck shuffle:)
						(= global503 0)
						(= global234 0)
						(Dealer rotate: cardsToDeal: local16)
					)
					(global924
						(gGame quitGame:)
						(proc0_8 0)
					)
				)
				(= ticks 1)
			)
			(20
				(EnableCursor)
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
				(proc0_12 (if (== (highPlayer type:) 0) 302 else 301))
			)
		)
		(highPlayer tempTotal: (+ (highPlayer tempTotal:) global530))
		(+= global237 global530)
		(if (and (> global530 0) (< global530 13))
			(cond
				((Random 0 1)
					(cond
						((== (highPlayer location:) 2)
							(gChar3 sayPN: 1000 2 83 0 (Random 1 5))
						)
						((== (highPlayer location:) 1)
							(gChar2 sayPN: 1000 2 83 0 (Random 1 5))
						)
						((== (highPlayer location:) 4)
							(gChar1 sayPN: 1000 2 83 0 (Random 1 5))
						)
						(else
							(Characters sayPN: 1000 2 82 0 (Random 1 5))
						)
					)
				)
				((== (highPlayer location:) 2)
					(gChar2 sayPN: 1000 2 82 0 (Random 1 5))
				)
				((== (highPlayer location:) 1)
					(gChar1 sayPN: 1000 2 82 0 (Random 1 5))
				)
				((== (highPlayer location:) 4)
					(gChar3 sayPN: 1000 2 82 0 (Random 1 5))
				)
				(else
					(Characters sayPN: 1000 2 82 0 (Random 1 5))
				)
			)
		)
		(if (and (not temp1) (>= global530 13))
			(cond
				((== (highPlayer location:) 3)
					(Characters sayPN: 1000 2 82 0 (Random 1 5))
				)
				((== (highPlayer location:) 2)
					(gChar3 sayPN: 1000 2 83 0 (Random 1 5))
				)
				((== (highPlayer location:) 1)
					(gChar2 sayPN: 1000 2 83 0 (Random 1 5))
				)
				((== (highPlayer location:) 4)
					(gChar1 sayPN: 1000 2 83 0 (Random 1 5))
				)
			)
		)
		(if (and temp1 (!= temp1 (self checkShoot:)))
			(if (== temp1 hand1)
				(Characters sayPN: 1000 2 82 0 (Random 1 5))
			else
				(Characters sayPN: 1000 2 83 0 (Random 1 5))
			)
			(RedrawCast)
		)
		(super endTrick:)
	)

	(method (validPlay param1 param2 &tmp temp0)
		(if (and global482 (== global233 0))
			(if (and (== (param1 rank:) 2) (== (param1 suit:) 1))
				(= global482 0)
				(return 1)
			else
				(proc0_12 905)
				(= global920 1)
				(if gAttitudeSetting
					(Characters sayReg: 300 15 42 0 (Random 1 2))
				else
					(Characters say: 300 15 42 0 2)
				)
				(param1 startUpd:)
				(return 0)
			)
		)
		(if (and (!= global528 -1) (!= (param1 suit:) global528))
			(for ((= temp0 0)) (< temp0 (param2 size:)) ((++ temp0))
				(if (== ((param2 at: temp0) suit:) global528)
					(proc0_12 905)
					(= global920 1)
					(if gAttitudeSetting
						(Characters sayReg: 300 19 43 0 (Random 1 2))
					else
						(Characters say: 300 19 43 0 2)
					)
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
				(proc0_12 905)
				(= global920 1)
				(if gAttitudeSetting
					(Characters sayReg: 300 15 41 0 (Random 1 2))
				else
					(Characters say: 300 15 41 0 2)
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
					(proc0_12 905)
					(if
						(and
							(== (param1 suit:) 0)
							(== (param1 rank:) 12)
							(== global235 1)
						)
						(= global920 1)
						(if gAttitudeSetting
							(Characters sayReg: 300 15 25 0 (Random 1 2))
						else
							(Characters say: 300 15 25 0 2)
						)
					else
						(= global920 1)
						(if gAttitudeSetting
							(Characters sayReg: 300 15 24 0 (Random 1 2))
						else
							(Characters say: 300 15 24 0 2)
						)
					)
					(param1 startUpd:)
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

	(method (setCard param1 &tmp temp0 temp1 temp2)
		(= temp2 0)
		(if (and (== (param1 rank:) 12) (== (param1 suit:) 0))
			(= global503 1)
			(proc0_12 102 2)
			(= temp2 1)
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

