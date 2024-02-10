;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 700)
(include sci.sh)
(use Main)
(use KeyMouse)
(use Piles)
(use Character)
(use Trick)
(use BScore)
(use n709)
(use SortArray)
(use Declarer_Lead_NT)
(use Declarer_Second_NT)
(use Declarer_Third_NT)
(use Declarer_Fourth_NT)
(use Bid)
(use LeadReturn_Trump)
(use LeadSeat_Trump)
(use SecondSeat_Trump)
(use ThirdSeat_Trump)
(use FourthSeat_Trump)
(use LeadReturn_NoTrump)
(use LeadSeat_NoTrump)
(use SecondSeat_NoTrump)
(use ThirdSeat_NoTrump)
(use FourthSeat_NoTrump)
(use n763)
(use BridgeStrategy)
(use Print)
(use TrickBox)
(use File)
(use User)
(use Actor)
(use System)

(public
	bridge 0
	proc700_1 1
	hand1 2
	hand2 3
	hand3 4
	hand4 5
	BridgeHands 6
	bridgeTrick 7
	proc700_9 9
	handleEventList 10
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	[local6 3]
	local9
	[local10 2]
	[local12 15] = [{} {} {2} {3} {4} {5} {6} {7} {8} {9} {T} {J} {Q} {K} {A}]
	[local27 5] = [{} {C} {D} {H} {S}]
	[local32 10]
	local42
)

(procedure (proc700_1)
	(if (not global405)
		(proc0_8 1097)
	)
	((ScriptID 780 0) init:) ; scoreBridge
	(DisposeScript 780)
	(proc0_8 0)
	(= global405 0)
)

(procedure (localproc_0 param1) ; UNUSED
	(return
		(cond
			((or (not (StrCmp {d} param1)) (not (StrCmp {D} param1))) 2)
			((or (not (StrCmp {c} param1)) (not (StrCmp {C} param1))) 1)
			((or (not (StrCmp {h} param1)) (not (StrCmp {H} param1))) 3)
			((or (not (StrCmp {s} param1)) (not (StrCmp {S} param1))) 4)
		)
	)
)

(procedure (localproc_1 &tmp temp0 temp1)
	(StrCpy @local32 {})
	(HandsOn)
	(Message msgGET 700 20 0 0 1 @global550) ; "Hand to restore:           (or press Enter)"
	(Print addText: @global550 addEdit: @local32 10 init:)
	(if (StrLen @local32)
		(for ((= temp0 0)) (< temp0 (StrLen @local32)) ((++ temp0))
			(= temp1 (StrAt @local32 temp0))
			(if (or (<= 97 temp1 122) (<= 65 temp1 90) (<= 48 temp1 57))
			else
				(Message msgGET 700 27 0 0 1 @global550) ; "Use only letters or numbers for save hands or press Enter to cancel."
				(Print addText: @global550 init:)
				(return 0)
			)
		)
		(StrCat @local32 {.brh})
		(if (not (FileIO fiEXISTS @local32))
			(Message msgGET 700 22 0 0 1 @global550) ; "The hand that you have entered does not exist. Enter the name of a hand that has been previously saved or press Enter to play the hand showing."
			(Print addText: @global550 init:)
			(return 0)
		)
	)
	(return 1)
)

(procedure (localproc_2 &tmp temp0 temp1)
	(StrCpy @local32 {})
	(Message msgGET 700 21 0 0 1 @global550) ; "Hand to save:              (or press Enter)"
	(if (StrLen @local32)
		(for ((= temp0 0)) (< temp0 (StrLen @local32)) ((++ temp0))
			(= temp1 (StrAt @local32 temp0))
			(if (or (<= 97 temp1 122) (<= 65 temp1 90) (<= 48 temp1 57))
			else
				(Message msgGET 700 27 0 0 1 @global550) ; "Use only letters or numbers for save hands or press Enter to cancel."
				(Print addText: @global550 init:)
				(return 0)
			)
		)
		(StrCat @local32 {.brh})
	else
		(Message msgGET 700 23 0 0 1 @global550) ; "Save hand canceled."
		(Print addText: @global550 init:)
	)
	(return 1)
)

(procedure (localproc_3 &tmp temp0 temp1 temp2 temp3 [temp4 50] temp54 temp55 [temp56 3] [temp59 2] [temp61 20] temp81)
	(= temp81 (User controls:))
	(HandsOff)
	(GetCWD @temp4)
	(if (> (CheckFreeSpace @temp4 1) 4)
		((= temp54 (File new:)) name: {lastHand.brh})
		((= temp55 (File new:)) name: @local32)
		(if (temp54 open: 1)
			(if (temp55 open: 2)
				(StrAt @temp56 0 13)
				(StrAt @temp56 1 10)
				(StrAt @temp56 2 0)
				(for ((= temp1 0)) (< temp1 4) ((++ temp1))
					(for ((= temp0 0)) (< temp0 13) ((++ temp0))
						(= temp2 32)
						(while
							(and
								(temp54 read: @temp59 1)
								(OneOf (= temp2 (StrAt @temp59 0)) 32 13 10)
							)
						)
						(= temp3 0)
						(while (not (OneOf temp2 32 13 10))
							(StrAt @temp61 temp3 temp2)
							(++ temp3)
							(temp54 read: @temp59 1)
							(= temp2 (StrAt @temp59 0))
						)
						(StrAt @temp61 temp3 32)
						(StrAt @temp61 (++ temp3) 0)
						(temp55 writeString: @temp61)
					)
					(temp55 writeString: @temp56)
				)
				(temp54 close:)
				(temp55 close:)
				(HandsOn)
				(Prints {Hand saved})
			else
				(HandsOn)
				(Message msgGET 700 24 0 0 1 @global550) ; "Error saving the hand. Not saved."
				(Print addText: @global550 init:)
			)
		else
			(HandsOn)
			(Message msgGET 700 24 0 0 1 @global550) ; "Error saving the hand. Not saved."
			(Print addText: @global550 init:)
		)
		(temp54 dispose:)
		(temp55 dispose:)
	else
		(HandsOn)
		(Message msgGET 700 25 0 0 1 @global550) ; "Not enough disk space to save."
		(Print addText: @global550 init:)
	)
	(if temp81
		(HandsOn)
	)
)

(procedure (proc700_9)
	(if global443
		(while (not (localproc_2))
			0
		)
		(if (StrLen @local32)
			(localproc_3)
		)
	else
		(Message msgGET 700 26 0 0 1 @global550) ; "We are in between hands. Select save again after the next hand is dealt."
		(Print addText: @global550 init:)
	)
)

(class BridgeHands of List
	(properties)

	(method (atLocation param1 &tmp temp0)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(if (== ((self at: temp0) location:) param1)
				(self at: temp0)
				(return)
			)
		)
		(self at: 0)
	)
)

(class BridgeCard of Card
	(properties
		whoLedMe 0
	)

	(method (track &tmp temp0 temp1 temp2 temp3)
		(= temp1 associatedObj)
		(= temp2 (Set new:))
		(if associatedObj
			(temp2 add: associatedObj)
		)
		(= associatedObj temp2)
		(for ((= temp3 0)) (< temp3 (gTrick size:)) ((++ temp3))
			(temp2 add: (gTrick at: temp3))
		)
		(= temp0 (super track:))
		(= associatedObj temp1)
		(temp2 release: dispose:)
		(return temp0)
	)
)

(instance bridge of HoyleRoom
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
		SortArray
		(Lock rsSCRIPT 725 1)
		BScore
		(Lock rsSCRIPT 704 1)
		(gGame setCursor: 999)
		((= global117 BridgeHands) add: hand1 hand2 hand3 hand4)
		(= global184 0)
		(= global185 0)
		(= global186 0)
		(= global187 0)
		(= local4 0)
		((= gBridge_opt bridge_opt) doit:)
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
		(Deck init: BridgeCard)
		(= global193 700)
		(= gAddToTricksWon addToTricksWon)
		(hand1 partner: hand3 LHO: hand2 RHO: hand4)
		(hand3 partner: hand1 LHO: hand4 RHO: hand2)
		(hand2 partner: hand4 LHO: hand3 RHO: hand1)
		(hand4 partner: hand2 LHO: hand1 RHO: hand3)
		(hand1 add: owner: 0)
		(hand2 add: owner: gChar1)
		(hand3 add: owner: gChar2)
		(hand4 add: owner: gChar3)
		(bridgeTrick init:)
		(Piles add: gTrick)
		(gTrick add: init:)
		((ScriptID 15 1) add:) ; discardList
		(handleEventList add:)
		(= global394 global271)
		(Dealer cardsToDeal: 13)
		(Deck rankAces: 14)
		(gChar1 posn: 65 115 show: init:)
		(gChar2 posn: 81 47 view: (gChar2 view:) show: init:)
		(gChar3 posn: 291 151 view: (gChar3 view:) show: init:)
		(Characters init:)
		((gChar2 face:) view: (gChar2 view:))
		((gChar3 face:) view: (gChar3 view:))
		(Deck shuffle:)
		(gBridge_opt doit: 3)
		(KeyMouse setList: gTheKeyMouseList)
		(if (== global432 2)
			(global117 eachElementDo: #faceUp 1 eachElementDo: #type 0)
		)
		(self setScript: roomScript)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(handleEventList handleEvent: event)
		(if (and (& (event type:) evKEYBOARD) (== (event message:) KEY_ALT_s))
			(proc700_9)
		)
	)

	(method (doit &tmp temp0)
		(if (and global459 (== (roomScript state:) 14))
			((ScriptID 762 0) dispose:) ; scorePanel
		)
		(super doit:)
		(Dealer doit:)
		(if global436
			(= global436 0)
			(BidBox review:)
		)
		(if global290
			(= global290 0)
			(global117 eachElementDo: #sort)
			(Animate (gCast elements:) 1)
			(HandsOn)
		)
		(if global438
			(for ((= temp0 0)) (< temp0 (global117 size:)) ((++ temp0))
				(if ((global117 at: temp0) faceUp:)
					((global117 at: temp0) sort:)
				)
			)
			(if (and local1 (not global395))
				(= global438 0)
				(roomScript state: 10 cue:)
			)
		)
		(if (and global404 (not (gSong handle:)) (not (gSound handle:)))
			(proc0_8 1097)
		)
	)

	(method (dispose)
		(= global458 0)
		(= gAddToTricksWon 0)
		(playedList1 release: dispose:)
		(playedList2 release: dispose:)
		(playedList3 release: dispose:)
		(playedList4 release: dispose:)
		(KeyMouse release:)
		(Deck eachElementDo: #associatedObj 0)
		(BidBox newHand: dispose:)
		(gTrick eachElementDo: #stopUpd release: dispose:)
		((ScriptID 15 1) release: dispose:) ; discardList
		(Piles release: dispose:)
		(Dealer dispose:)
		(global117
			eachElementDo: #release
			eachElementDo: #dispose
			release:
			dispose:
		)
		(handleEventList release: dispose:)
		(Deck dispose:)
		(= global184 0)
		(= global185 0)
		(= global186 0)
		(= global187 0)
		(fixFile dispose:)
		(putFile dispose:)
		(DisposeScript 922)
		(DisposeScript 940)
		(DisposeScript 702)
		(Lock rsSCRIPT 704 0)
		(DisposeScript 704)
		(DisposeScript 941)
		(DisposeScript 9)
		(DisposeScript 701)
		(DisposeScript 770)
		(DisposeScript 709)
		(DisposeScript 712)
		(DisposeScript 713)
		(DisposeScript 714)
		(DisposeScript 715)
		(DisposeScript 716)
		(DisposeScript 717)
		(DisposeScript 718)
		(DisposeScript 719)
		(DisposeScript 761)
		(DisposeScript 721)
		(DisposeScript 722)
		(DisposeScript 731)
		(Lock rsSCRIPT 725 0)
		(DisposeScript 725)
		(proc763_1)
		(DisposeScript 745)
		(super dispose:)
	)

	(method (beforeNewPic)
		(if (and (< 6 (roomScript state:) 11) (== global432 2))
			(return 0)
		)
		(if (BidBox active:)
			(BidBox save:)
		)
		(if (TrickBox active:)
			(TrickBox save:)
		)
		(super beforeNewPic:)
		(return 1)
	)

	(method (afterNewPic)
		(if (BidBox active:)
			(BidBox restore:)
		)
		(if (TrickBox active:)
			(TrickBox restore:)
		)
		(super afterNewPic:)
	)

	(method (drawNewPic)
		(if global406
			(UnLoad 133 global406)
			(= local2 1)
		else
			(= local2 0)
		)
		(super drawNewPic: &rest)
		(if local2
			(= local2 0)
			((ScriptID 762 0) init:) ; scorePanel
		)
	)
)

(class BridgeHand of Hand
	(properties
		tricksWon 0
		origType 0
		playedList 0
		points 0
		hcp 0
		honors 0
		playingTricks 0
		quickTricks 0
		losers 0
		stoppers 0
		singletons 0
		voids 0
		aces 0
		clubs 0
		diamonds 0
		hearts 0
		spades 0
		shape 0
		clubHCP 0
		diamondHCP 0
		heartHCP 0
		spadeHCP 0
		agreedSuit 0
		agreedPoints 0
		combinedCards 0
		partnerHearts 0
		partnerSpades 0
		partnerDiamonds 0
		partnerClubs 0
		bidTree 0
		bidBranch 0
		preempted 0
		combinedPts 0
		combinedHCP 0
		minPoints 0
		maxPoints 0
		directSeat 0
		firstBidSuit 0
		bidsOpen 0
		minClubs 0
		maxClubs 0
		minDiamonds 0
		maxDiamonds 0
		minHearts 0
		maxHearts 0
		minSpades 0
		maxSpades 0
		forcing 0
		LHO 0
		RHO 0
		topSp 0
		topCl 0
		topDi 0
		topHt 0
	)

	(method (handleEvent event)
		(= local42 0)
		(super handleEvent: event &rest)
	)

	(method (raisedSuit &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp0 (- (BidBox size:) (BidBox bidsSinceOpen:)))
		(= temp2 0)
		(while (and (not temp2) (<= 0 temp0 (- (BidBox size:) 1)))
			(if
				(and
					(== ((= temp4 (BidBox at: temp0)) location:) location)
					(not (OneOf (temp4 bidNumber:) 0 50 99))
					(not (temp4 artificial:))
					(<= 1 (= temp2 (temp4 suit:)) 4)
				)
				(= temp3 0)
				(= temp1 (+ temp0 2))
				(= temp3 0)
				(while (and (not temp3) (<= temp1 (- (BidBox size:) 1)))
					(= temp5 (BidBox at: temp1))
					(= temp3
						(and (not (temp5 artificial:)) (== (temp5 suit:) temp2))
					)
					(+= temp1 4)
				)
				(if (not temp3)
					(= temp2 0)
				)
			)
			(++ temp0)
		)
		(return temp2)
	)

	(method (flip param1)
		(if argc
			(if (!= faceUp param1)
				(= faceUp param1)
				(self eachElementDo: #flip faceUp)
			)
		else
			(= faceUp (not faceUp))
			(self eachElementDo: #flip faceUp)
		)
	)

	(method (enterKey param1 param2)
		(= global458 param1)
		(if (gTrick validPlay: param1 self)
			(self moveCard: gTrick)
			(RedrawCast)
			(= local42 1)
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

	(method (setHonors)
		(proc763_0 self)
	)

	(method (calcScore &tmp [temp0 4] temp4 temp5)
		(= combinedPts
			(= combinedHCP
				(= minPoints
					(= directSeat
						(= firstBidSuit
							(= partnerSpades
								(= partnerDiamonds
									(= partnerClubs
										(= bidsOpen
											(= agreedSuit
												(= agreedPoints
													(= combinedCards
														(= partnerHearts
															(= aces
																(= bidTree
																	(= bidBranch
																		(=
																			forcing
																			(=
																				tricksWon
																				0
																			)
																		)
																	)
																)
															)
														)
													)
												)
											)
										)
									)
								)
							)
						)
					)
				)
			)
		)
		(= maxPoints 37)
		(= minClubs (= minDiamonds (= minHearts (= minSpades 0))))
		(= maxClubs (= maxDiamonds (= maxHearts (= maxSpades 13))))
		(for ((= temp4 0)) (< temp4 size) ((++ temp4))
			(if (== ((self at: temp4) rank:) 14)
				(++ aces)
			)
		)
		(= clubs (= [temp0 0] (self countSuit: 1)))
		(= diamonds (= [temp0 1] (self countSuit: 2)))
		(= hearts (= [temp0 2] (self countSuit: 3)))
		(= spades (= [temp0 3] (self countSuit: 4)))
		(while (not (>= [temp0 0] [temp0 1] [temp0 2] [temp0 3]))
			(for ((= temp4 0)) (< temp4 3) ((++ temp4))
				(if (< [temp0 temp4] [temp0 (+ temp4 1)])
					(= temp5 [temp0 temp4])
					(= [temp0 temp4] [temp0 (+ temp4 1)])
					(= [temp0 (+ temp4 1)] temp5)
				)
			)
		)
		(= shape
			(+
				(<< [temp0 0] $000c)
				(<< [temp0 1] $0008)
				(<< [temp0 2] $0004)
				[temp0 3]
			)
		)
		(for ((= temp4 (= singletons (= voids 0)))) (< temp4 4) ((++ temp4))
			(switch [temp0 temp4]
				(1
					(++ singletons)
				)
				(0
					(++ voids)
				)
			)
		)
		(= points (self calcPoints:))
		(= hcp
			(+
				(= clubHCP (self calcHCP: 1))
				(= diamondHCP (self calcHCP: 2))
				(= spadeHCP (self calcHCP: 4))
				(= heartHCP (self calcHCP: 3))
			)
		)
		(= temp4 0)
		(if (== spades 1)
			(+= temp4 spadeHCP)
		)
		(if (== hearts 1)
			(+= temp4 heartHCP)
		)
		(if (== diamonds 1)
			(+= temp4 diamondHCP)
		)
		(if (== clubs 1)
			(+= temp4 clubHCP)
		)
		(if (> temp4 (/ (+ hcp 1) 2))
			(-- hcp)
		)
		(= honors (self calcHonors:))
		(= playingTricks (self calcTricks:))
		(= quickTricks (self calcQTS:))
		(= losers 0)
		(= stoppers
			(+ (self stops: 1) (self stops: 2) (self stops: 3) (self stops: 4))
		)
	)

	(method (calcTricks param1 &tmp temp0 temp1 [temp2 2] temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14)
		(= temp0 0)
		(for ((= temp1 1)) (< temp1 5) ((++ temp1))
			(if (or (not argc) (== temp1 param1))
				(= temp4 0)
				(= temp5 0)
				(= temp14 temp1)
				(= temp7 (self hasCard: temp14 14))
				(= temp8 (self hasCard: temp14 13))
				(= temp9 (self hasCard: temp14 12))
				(= temp10 (self hasCard: temp14 11))
				(= temp11 (self hasCard: temp14 10))
				(= temp12 (self hasCard: temp14 9))
				(= temp13 (self hasCard: temp14 8))
				(switch (= temp6 (self countSuit: temp14))
					(0 0)
					(1
						(+=
							temp0
							(cond
								(temp7 2)
								(temp8 1)
								(else 0)
							)
						)
					)
					(2
						(+=
							temp0
							(cond
								((and temp4 temp9 temp10) 2)
								((and temp4 temp7 temp10) 3)
								((and temp8 temp9)
									(if temp4 3 else 2)
								)
								((and temp7 temp9)
									(if (or temp4 temp5) 4 else 3)
								)
								((and temp7 temp8) 4)
								((or temp7 temp8) 2)
								(temp9 1)
								(else 0)
							)
						)
					)
					(3
						(+=
							temp0
							(cond
								((and temp7 temp8 temp9) 6)
								((and temp7 temp9 temp10) 5)
								((and temp7 temp8 temp10) 5)
								((and temp7 temp8 temp11)
									(if temp4 5 else 4)
								)
								((and temp7 temp10 temp11)
									(if (or temp4 temp5) 6 else 4)
								)
								((and temp8 temp10 temp11)
									(if (or temp4 temp5) 4 else 3)
								)
								((and temp8 temp10 temp12) 3)
								((and temp8 temp9 (or temp12 temp11)) 4)
								((and temp7 temp10)
									(if temp4 4 else 3)
								)
								((and temp7 temp9)
									(if temp4 4 else 3)
								)
								((and temp7 temp8) 4)
								((and temp9 temp10) 2)
								((or temp7 temp8) 2)
								(temp9 1)
								(temp10
									(if temp4 2 else 0)
								)
								(else 0)
							)
						)
					)
					(4
						(+=
							temp0
							(cond
								((and temp7 temp8 temp9 temp10) 8)
								((and temp7 temp9 temp8) 7)
								((and temp7 temp8 temp10 temp11) 7)
								((and temp7 temp8 temp10) 6)
								((and temp7 temp9 temp10 (or temp12 temp11)) 7)
								((and temp7 temp10 temp11 temp12) 6)
								((and temp8 temp9 temp10 temp11) 6)
								((and temp7 temp9 temp10) 5)
								((and temp8 temp9 temp10) 5)
								((and temp7 temp8) 4)
								((and temp7 temp9) 4)
								((and temp8 temp9) 4)
								((and temp7 temp10) 3)
								((and temp8 temp10) 3)
								((and temp9 temp10) 2)
								((or temp7 temp8 temp9) 2)
								(temp10
									(if (self hasCard: temp14 3849) 2)
								)
								(else 0)
							)
						)
					)
					(5
						(+=
							temp0
							(cond
								((and temp7 temp8 temp9 temp10) 10)
								((and temp7 temp8 temp10 temp11) 9)
								((and temp7 temp9 temp10 temp11 temp12) 9)
								((and temp7 temp8 temp9) 9)
								((and temp7 temp8 temp10 temp11) 9)
								((and temp8 temp9 temp10 temp11) 8)
								((and temp7 temp8 temp10) 8)
								((and temp7 temp9 temp10) 8)
								((and temp8 temp9 temp10) 7)
								((and temp8 temp9 temp11) 7)
								((and temp8 temp10 temp11) 6)
								((and temp9 temp10 temp11 temp12) 6)
								((and temp9 temp10 temp11) 5)
								((and temp9 temp10 temp12 temp13) 5)
								((and temp9 temp10 temp12) 4)
								((and temp7 temp8) 7)
								((and temp7 temp9) 6)
								((and temp8 temp9) 6)
								((and temp7 temp10) 5)
								((and temp7 temp11) 5)
								((and temp8 temp10) 5)
								((and temp8 temp11) 4)
								((and temp9 temp10) 3)
								((and temp9 temp11) 2)
								((and temp10 temp11) 2)
								(temp7 4)
								(temp8 3)
								(temp9 3)
								(temp10 2)
								(else 0)
							)
						)
					)
					(6
						(+=
							temp0
							(cond
								((and temp7 temp8 temp9 temp10) 12)
								((and temp7 temp9 temp8) 11)
								((and temp7 temp8 temp10 temp11) 11)
								((and temp7 temp9 temp10 temp11) 11)
								((and temp7 temp8 temp10) 10)
								((and temp7 temp9 temp10) 10)
								((and temp8 temp9 temp10) 10)
								((and temp7 temp10 temp11) 9)
								((and temp8 temp9 temp11)
									(if (or temp4 temp5) 10 else 9)
								)
								((and temp8 temp10 temp11)
									(if (or temp4 temp5) 10 else 9)
								)
								((and temp9 temp10 temp11) 8)
								((and temp7 temp8) 10)
								((and temp7 temp9) 9)
								((and temp7 (or temp10 temp11)) 8)
								((and temp8 temp9) 9)
								((and temp8 temp10) 8)
								((and temp8 temp11) 7)
								((and temp9 (or temp9 temp10)) 7)
								((and temp10 temp11) 7)
								(temp7 9)
								(temp8 8)
								(temp9 7)
								(temp10 6)
								(temp11 5)
								(else 3)
							)
						)
					)
					(7
						(+=
							temp0
							(cond
								((and temp7 temp8 temp9) 14)
								((and temp7 temp8 temp10) 13)
								((and temp7 temp9 temp10) 13)
								((and temp8 temp9 temp10) 12)
								((and temp8 temp10 temp11) 11)
								((and temp7 temp8) 13)
								((and temp7 temp9) 12)
								((and temp8 temp9) 11)
								((and temp9 temp10) 10)
								((and temp10 temp11) 9)
								(temp7 11)
								(temp8 10)
								(temp9 9)
								(else 8)
							)
						)
					)
					(8
						(+=
							temp0
							(cond
								((and temp7 temp8) 16)
								((and temp7 temp9) 15)
								((and temp8 temp9) 14)
								((and temp8 temp10) 13)
								((and temp9 (or temp10 temp11)) 12)
								((and temp10 temp11) 11)
								(temp7 14)
								(temp8 13)
								(temp9 12)
								(else 11)
							)
						)
					)
					(9
						(+=
							temp0
							(cond
								((and temp7 temp8) 18)
								((and temp7 temp9) 17)
								((and temp8 temp9) 16)
								(temp7 16)
								(temp8 15)
								(else 14)
							)
						)
					)
					(10
						(+=
							temp0
							(cond
								((and temp7 temp8) 20)
								((and temp7 temp9) 19)
								(temp7 19)
								(temp8 18)
								(else 17)
							)
						)
					)
					(else
						(+=
							temp0
							(if temp7
								(* temp6 2)
							else
								(* (- temp6 1) 2)
							)
						)
					)
				)
			)
		)
		(return temp0)
	)

	(method (calcQTS &tmp temp0 temp1 temp2 temp3)
		(= temp0 0)
		(for ((= temp1 1)) (< temp1 5) ((++ temp1))
			(if (or (not argc) (== temp1 temp3)) ; UNINIT
				(+=
					temp0
					(cond
						((self hasCard: temp1 14)
							(cond
								((self hasCard: temp1 13) 4)
								((self hasCard: temp1 12) 3)
								(else 2)
							)
						)
						((self hasCard: temp1 13)
							(if (self hasCard: temp1 12) 2 else 1)
						)
					)
				)
			)
		)
		(return temp0)
	)

	(method (calcPoints param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 [temp9 5] [temp14 5] [temp19 5] [temp24 5] temp29 temp30 temp31 temp32 [temp33 5])
		(= [temp9 2] diamonds)
		(= [temp9 1] clubs)
		(= [temp9 3] hearts)
		(= [temp9 4] spades)
		(= temp0 0)
		(= [temp14 1] (= [temp14 2] (= [temp14 3] (= [temp14 4] 0))))
		(= [temp19 1] (= [temp19 2] (= [temp19 3] (= [temp19 4] 0))))
		(= [temp24 1] (= [temp24 2] (= [temp24 3] (= [temp24 4] 0))))
		(for ((= temp2 1)) (<= temp2 4) ((++ temp2))
			(= [temp33 temp2] 0)
		)
		(if argc
			(= temp3 (& param1 $f000))
			(= temp4 (& param1 $0f00))
			(&= param1 $000f)
			(if (<= 1 param1 4)
				(= temp32 (partner location:))
				(for
					((= temp30 (- (BidBox size:) 1)))
					(>= temp30 0)
					((-- temp30))
					
					(= temp31 (BidBox at: temp30))
					(if
						(and
							(== (temp31 location:) temp32)
							(not (temp31 artificial:))
						)
						(++ [temp33 temp2])
						(break)
					)
				)
			)
		else
			(= temp3 (= temp4 0))
		)
		(for ((= temp1 0)) (< temp1 size) ((++ temp1))
			(= temp6 (self at: temp1))
			(= temp5 (temp6 suit:))
			(switch (= temp29 (temp6 rank:))
				(13
					(= [temp14 temp5] 1)
				)
				(12
					(= [temp19 temp5] 1)
				)
				(11
					(= [temp24 temp5] 1)
				)
			)
		)
		(for ((= temp1 1)) (<= temp1 4) ((++ temp1))
			(= temp2 0)
			(if (or (not argc) (== param1 6) (== temp1 param1))
				(= temp7 [temp33 temp1])
				(= temp8 (or (not agreedSuit) (!= agreedSuit temp1)))
				(if (self hasCard: temp1 14)
					(+=
						temp2
						(cond
							([temp14 temp1]
								(= [temp14 temp1] 0)
								7
							)
							([temp19 temp1]
								(= [temp19 temp1] 0)
								6
							)
							([temp24 temp1]
								(= [temp24 temp1] 0)
								5
							)
							(temp3 4)
							((>= [temp9 temp1] 3) 4)
							((== [temp9 temp1] 2)
								(if temp8 5 else 4)
							)
							(temp8 6)
							(else 5)
						)
					)
				)
				(if [temp14 temp1]
					(= [temp14 temp1] 0)
					(+=
						temp2
						(cond
							((and [temp19 temp1] (> [temp9 temp1] 2))
								(= [temp19 temp1] 0)
								5
							)
							((and [temp24 temp1] (> [temp9 temp1] 2))
								(= [temp24 temp1] 0)
								4
							)
							([temp19 temp1]
								(= [temp19 temp1] 0)
								(if temp7 5 else 4)
							)
							([temp24 temp1]
								(= [temp24 temp1] 0)
								(if temp7 4 else 3)
							)
							((> [temp9 temp1] 2) 3)
							((== [temp9 temp1] 2)
								(if temp3 3 else 4)
							)
							(temp7 3)
							(temp3 2)
							(else 4)
						)
					)
				)
				(if [temp19 temp1]
					(= [temp19 temp1] 0)
					(+=
						temp2
						(cond
							((and [temp24 temp1] (>= [temp9 temp1] 3))
								(= [temp24 temp1] 0)
								3
							)
							([temp24 temp1]
								(= [temp24 temp1] 0)
								(if temp7 3 else 2)
							)
							((> [temp9 temp1] 2) 2)
							((== [temp9 temp1] 2)
								(if (or temp7 (not temp3)) 2 else 1)
							)
							(temp3 1)
							(temp7 2)
							(else 3)
						)
					)
				)
				(if [temp24 temp1]
					(= [temp24 temp1] 0)
					(+=
						temp2
						(cond
							((> [temp9 temp1] 2) 1)
							(temp3
								(if temp7 1 else 0)
							)
							((== [temp9 temp1] 2) 1)
							(else 2)
						)
					)
				)
				(if (and (not temp4) temp2 temp7 (>= [temp9 temp1] 3))
					(++ temp2)
				)
				(+= temp0 temp2)
			)
			(+=
				temp0
				(cond
					((or temp2 temp3) 0)
					(agreedSuit
						(if (not (== temp1 agreedSuit))
							(switch [temp9 temp1]
								(0 5)
								(1 3)
								(2 1)
							)
						else
							0
						)
					)
					(else
						(switch [temp9 temp1]
							(0 3)
							(1 2)
							(2 1)
						)
					)
				)
			)
		)
		(if (and temp0 (== param1 6) (or (not aces) (== shape 17203)))
			(-- temp0)
		)
		(return temp0)
	)

	(method (calcHCP param1 &tmp temp0)
		(= temp0 (if argc param1 else 6))
		(self calcPoints: (| temp0 $ff00))
	)

	(method (calcHonors param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if (< argc 2)
			(= temp0 5)
		else
			(= temp0 param2)
		)
		(= temp1 0)
		(for ((= temp2 0)) (< temp2 size) ((++ temp2))
			(= temp3 (self at: temp2))
			(= temp5 (temp3 rank:))
			(if
				(and
					(or
						(not argc)
						(== param1 6)
						(== (= temp4 (temp3 suit:)) param1)
					)
					(>= temp0 1)
				)
				(if (== temp5 14)
					(++ temp1)
				)
				(if (>= temp0 2)
					(if (== temp5 13)
						(++ temp1)
					)
					(if (>= temp0 3)
						(if (== temp5 12)
							(++ temp1)
						)
						(if (>= temp0 4)
							(if (== temp5 11)
								(++ temp1)
							)
							(if (and (>= temp0 5) (== temp5 10))
								(++ temp1)
							)
						)
					)
				)
			)
		)
		(return temp1)
	)

	(method (countSuit param1 param2 &tmp temp0 temp1 temp2)
		(= temp1 0)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(if (< argc 2)
				(= temp2 (self at: temp0))
			else
				(= temp2 (param2 at: temp0))
			)
			(if (== (temp2 suit:) param1)
				(++ temp1)
			)
		)
		(return temp1)
	)

	(method (longSuit param1 &tmp temp0 [temp1 2] temp3 temp4 temp5 [temp6 5] [temp11 5] [temp16 4])
		(= [temp6 1] clubs)
		(= [temp6 2] diamonds)
		(= [temp6 3] hearts)
		(= [temp6 4] spades)
		(for ((= temp3 1)) (<= temp3 4) ((++ temp3))
			(= [temp11 temp3] 1)
		)
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			(= temp4 0)
			(for ((= temp3 1)) (<= temp3 4) ((++ temp3))
				(if (and (>= [temp6 temp3] temp4) [temp11 temp3])
					(= temp4 [temp6 temp3])
					(= temp5 temp3)
				)
			)
			(= [temp11 temp5] 0)
			(= [temp16 temp0] temp5)
		)
		(return
			[temp16
				(= temp0
					(if argc
						(- param1 1)
					else
						0
					)
				)
			]
		)
	)

	(method (strongSuit &tmp temp0 temp1 temp2 temp3)
		(= temp1 (+ (self calcHCP: 4) (self calcHonors: 4)))
		(= temp0 (+ (self calcHCP: 3) (self calcHonors: 3)))
		(= temp2 (+ (self calcHCP: 2) (self calcHonors: 2)))
		(= temp3 (+ (self calcHCP: 1) (self calcHonors: 1)))
		(Max temp0 temp1 temp2 temp3)
	)

	(method (cheapSuit &tmp temp0)
		(return
			(if (> (= temp0 (mod global427 5)) 3)
				1
			else
				(+ temp0 1)
			)
		)
	)

	(method (canBid param1 &tmp temp0)
		(return
			(or
				(== param1 0)
				(and (<= param1 35) (> param1 global427))
				(and
					(== param1 50)
					(== global424 -1)
					(or
						(< (= temp0 (BidBox size:)) 2)
						(<= 1 ((BidBox at: (- temp0 1)) bidNumber:) 31)
						(== ((BidBox at: (- temp0 2)) bidNumber:) 0)
					)
				)
				(and (== param1 99) (== global424 50) (!= global426 partner))
			)
		)
	)

	(method (minLevel param1 &tmp temp0 temp1 temp2)
		(= temp0 (mod global427 5))
		(= temp1 (+ (/ global427 5) 1))
		(return
			(if (<= param1 temp0)
				(+ temp1 1)
			else
				temp1
			)
		)
	)

	(method (stops param1 param2 &tmp temp0 temp1)
		(= temp0 (self countSuit: param1))
		(= temp1
			(+
				(self hasCard: param1 14)
				(and (self hasCard: param1 13) (> temp0 1))
				(and (self hasCard: param1 12) (> temp0 2))
				(and (self hasCard: param1 11) (> temp0 3))
			)
		)
		(return
			(if (and (== argc 2) param2)
				temp1
			else
				(> temp1 0)
			)
		)
	)

	(method (supports param1 param2 &tmp temp0)
		(= temp0
			(cond
				((>= param1 3)
					(if (self hasCard: param1 3852) 3 else 4)
				)
				((self hasCard: param1 3851) 4)
				(else 5)
			)
		)
		(if (and (>= argc 2) param2)
			(-- temp0)
		)
		(return (>= (self countSuit: param1) temp0))
	)

	(method (findGameLevel param1 &tmp temp0 temp1 temp2 temp3)
		(= temp1
			(if (OneOf (global429 location:) 1 3)
				(BScore weHandTotal:)
			else
				(BScore theyHandTotal:)
			)
		)
		(= temp0 (if (>= param1 3) 30 else 20))
		(= temp2 (- 100 temp1))
		(= temp3 1)
		(if (== param1 5)
			(-= temp2 40)
			(++ temp3)
		)
		(if (> temp2 0)
			(+= temp3 (/ (- temp2 1) temp0))
		)
		(return temp3)
	)

	(method (hasCard param1 param2 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp1 (& param2 $0f00))
		(&= param2 $00ff)
		(for
			((= temp0 (= temp3 0)))
			(and (< temp0 size) (or temp1 (not temp3)))
			((++ temp0))
			
			(= temp4 (self at: temp0))
			(if
				(and
					(== (temp4 suit:) param1)
					(or
						(== (= temp2 (temp4 rank:)) param2)
						(and temp1 (> temp2 param2))
					)
				)
				(++ temp3)
			)
		)
		(return temp3)
	)

	(method (bid &tmp temp0 [temp1 2] temp3 temp4 temp5 temp6)
		(= temp0 (BidBox newBid: (BridgeStrategy bid: self) 1))
		(= temp3 ((Dealer curPlayer:) owner:))
		(temp0 artificial: global439)
		(= global439 0)
		(Load rsVIEW 990)
		(Load rsTEXT 700)
		(if (IsObject temp3)
			(switch (temp0 bidNumber:)
				(0
					(temp3 say: 1000 1 0 0 14)
				)
				(50
					(temp3 say: 1000 1 0 0 11)
				)
				(99
					(temp3 say: 1000 1 0 0 13)
				)
				(else
					(= temp4
						(if (== (temp0 level:) 1)
							(switch (temp0 suit:)
								(1 1)
								(2 4)
								(3 2)
								(4 3)
								(5 9)
							)
						else
							(switch (temp0 suit:)
								(1 5)
								(2 8)
								(3 6)
								(4 7)
								(5 9)
							)
						)
					)
					(temp3 say: 1000 1 22 temp4 (temp0 level:))
				)
			)
		)
		(= temp5 (BidBox objectForDelayDraw:))
		(= temp6 (BidBox selectorForDelayDraw:))
		(temp5 temp6:)
		((gCurRoom script:) ticks: 1)
		(return temp0)
	)

	(method (think &tmp [temp0 4])
		(= global458
			(if (or (== (self origType:) 1) (== self global431) (not global432))
				(cond
					((or (== self global429) (== self global431))
						(switch (gTrick size:)
							(0
								(Declarer_Lead_NT think: self)
							)
							(1
								(Declarer_Second_NT think: self)
							)
							(2
								(Declarer_Third_NT think: self)
							)
							(3
								(Declarer_Fourth_NT think: self)
							)
						)
					)
					(local9
						(switch (gTrick size:)
							(0
								(if (gTrick tricksPlayed:)
									(LeadReturn_NoTrump think: self)
								else
									(LeadSeat_NoTrump think: self)
								)
							)
							(1
								(SecondSeat_NoTrump think: self)
							)
							(2
								(ThirdSeat_NoTrump think: self)
							)
							(3
								(FourthSeat_NoTrump think: self)
							)
						)
					)
					(else
						(switch (gTrick size:)
							(0
								(if (gTrick tricksPlayed:)
									(LeadReturn_Trump think: self)
								else
									(LeadSeat_Trump think: self)
								)
							)
							(1
								(SecondSeat_Trump think: self)
							)
							(2
								(ThirdSeat_Trump think: self)
							)
							(3
								(FourthSeat_Trump think: self)
							)
						)
					)
				)
			)
		)
		(= local1 0)
		(self moveCard: gTrick)
		(= gCrazy8sHand 0)
		(proc763_2)
	)

	(method (cue)
		(super cue:)
		((ScriptID 15 6) setCycle: 0) ; littleCard
		(gTrick setCard: global458)
		(= global395 0)
	)
)

(instance hand1 of BridgeHand
	(properties
		x 95
		y 154
		handNumber 3
		faceUp 1
		centerX 160
		centerY 175
	)
)

(instance hand2 of BridgeHand
	(properties
		x 4
		y 10
		handDirection 2
		handNumber 2
		location 4
		centerX 25
		centerY 100
		origType 1
	)
)

(instance hand3 of BridgeHand
	(properties
		x 95
		y 3
		handNumber 1
		location 1
		centerX 160
		centerY 25
		origType 1
	)
)

(instance hand4 of BridgeHand
	(properties
		x 280
		y 10
		handDirection 2
		handNumber 4
		location 2
		centerX 295
		centerY 100
		origType 1
	)
)

(instance handleEventList of EventHandler
	(properties)
)

(instance bridge_opt of File
	(properties
		name {bridge.opt}
	)

	(method (doit param1 &tmp [temp0 20] [temp20 10])
		(cond
			((and argc (== param1 3))
				(if (self open: 2)
					(self
						writeString:
							(Format ; "%d%d%2d%2d%2d%d%d%d%d%d%d%d"
								@temp0
								700
								0
								global271
								global432
								(gChar1 view:)
								(gChar2 view:)
								(gChar3 view:)
								(gChar1 loop:)
								(gChar2 loop:)
								(gChar3 loop:)
								global196
								global197
								global198
								global442
							)
						close:
					)
					(return 1)
				else
					(return 0)
				)
			)
			((self open: 1)
				(= global271 (ReadNumber (self readString: @temp20 2)))
				(= global432 (ReadNumber (self readString: @temp20 2)))
				(= global463 (ReadNumber (self readString: @temp20 3)))
				(= global464 (ReadNumber (self readString: @temp20 3)))
				(= global465 (ReadNumber (self readString: @temp20 3)))
				(= global466 (ReadNumber (self readString: @temp20 2)))
				(= global467 (ReadNumber (self readString: @temp20 2)))
				(= global468 (ReadNumber (self readString: @temp20 2)))
				(= global469 (ReadNumber (self readString: @temp20 2)))
				(= global470 (ReadNumber (self readString: @temp20 2)))
				(= global471 (ReadNumber (self readString: @temp20 2)))
				(= global442 (ReadNumber (self readString: @temp20 2)))
				(self close:)
				(return 0)
			)
			(else
				(= global271 3)
				(= global432 1)
				(= global463 16)
				(= global464 9)
				(= global465 12)
				(= global466 2)
				(= global467 2)
				(= global468 2)
				(= global469 2)
				(= global470 2)
				(= global471 2)
				(= global442 0)
				(= local4 1)
				(return 0)
			)
		)
	)
)

(instance roomScript of Script
	(properties)

	(method (changeState newState &tmp temp0 [temp1 5] temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 [temp14 10] temp24 temp25 temp26 temp27 [temp28 5] [temp33 5] temp38 temp39 temp40 temp41 temp42 temp43 temp44 temp45 temp46 temp47 temp48 [temp49 2])
		(switch (= state newState)
			(0
				(= global437 0)
				(Wait 1)
				(= global443 0)
				(= ticks 1)
			)
			(1
				(PicNotValid 0)
				(if local4
					(= script roomScript)
					(RedrawCast)
					(HandsOn)
					(gGameControls hide:)
					(= local5 (gSystemWindow back:))
					(gSystemWindow back: 53)
					((ScriptID 790 0) init:) ; optionBridge
					(gSystemWindow back: local5)
					(HandsOff)
					(= script 0)
				)
				(gSong fade:)
				(BScore rubberInit:)
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
				(if (!= global459 1)
					(BidBox newHand:)
				)
				(hand1 playedList: playedList1)
				(hand2 playedList: playedList2)
				(hand3 playedList: playedList3)
				(hand4 playedList: playedList4)
				(gTrick
					tricksPlayed: 0
					northPlayer: hand3
					southPlayer: hand1
					eastPlayer: hand4
					westPlayer: hand2
				)
				(hand1 type: (hand1 origType:) faceUp: (== (hand1 origType:) 0))
				(hand2 type: (hand2 origType:) faceUp: (== (hand2 origType:) 0))
				(hand3 type: (hand3 origType:) faceUp: (== (hand3 origType:) 0))
				(hand4 type: (hand4 origType:) faceUp: (== (hand4 origType:) 0))
				(= [global390 0] 2)
				(= [global390 1] 1)
				(= [global390 2] 3)
				(= [global390 3] 4)
				(if (== global432 2)
					(hand1 type: 0 faceUp: 1)
					(hand2 type: 0 faceUp: 1)
					(hand3 type: 0 faceUp: 1)
					(hand4 type: 0 faceUp: 1)
				)
				(Dealer playDirection: 0 deal: self)
			)
			(5
				(hand1 sort: calcScore:)
				(hand2 calcScore:)
				(hand3 calcScore:)
				(hand4 calcScore:)
				(if (hand2 faceUp:)
					(hand2 sort:)
				)
				(if (hand3 faceUp:)
					(hand3 sort:)
				)
				(if (hand4 faceUp:)
					(hand4 sort:)
				)
				(= ticks 1)
			)
			(6
				(if (and global442 (or (not global459) (== global459 3)))
					(while (not (localproc_1))
						0
					)
					(if (StrLen @local32)
						(fixFile name: @local32 doit:)
						(hand1 calcScore:)
						(hand2 calcScore:)
						(hand3 calcScore:)
						(hand4 calcScore:)
					)
				)
				(putFile name: {lastHand.brh} doit:)
				(= global443 1)
				(Arrow x: 231 y: 122 init:)
				(if (== global459 1)
					(= state 9)
				)
				(Dealer nextToPlay: (Dealer dealer:))
				(= ticks 1)
			)
			(7
				(= global459 0)
				(BidBox init: (Dealer dealer:))
				(= ticks 1)
			)
			(8
				(= temp43 global427)
				(if (== ((= temp42 (Dealer curPlayer:)) forcing:) 1)
					(temp42 forcing: 0)
				)
				(if (== (temp42 type:) 1)
					(= temp27 (temp42 bid:))
				else
					(HandsOn)
					(BidBox move: temp42)
					((ScriptID 701 0) init:) ; bridgeInput
					(= temp27 (BidBox newBid: global425))
					(if (and global425 (not (BidBox openingBidder:)))
						(BidBox
							openingBidder: hand1
							openingBidValue: global425
							bidsSinceOpen: 1
						)
					)
					(if (== (BidBox openingBidder:) hand4)
						(hand1 bidTree: 718 directSeat: 1)
					)
					(if (not (temp42 bidsOpen:))
						(= temp44 (temp42 calcPoints:))
						(= temp45 (temp42 clubs:))
						(= temp46 (temp42 diamonds:))
						(= temp47 (temp42 hearts:))
						(= temp48 (temp42 spades:))
						(proc709_4
							temp42
							(- temp44 1)
							(+ temp44 1)
							(- temp45 1)
							(+ temp45 1)
							(- temp46 1)
							(+ temp46 1)
							(- temp47 1)
							(+ temp47 1)
							(- temp48 1)
							(+ temp48 1)
						)
					)
					(if
						(and
							(not (hand1 agreedSuit:))
							(!= (= temp0 (+ 1 (mod (- global425 1) 5))) 5)
							(proc709_2 temp0 hand3)
						)
						(hand1 agreedSuit: temp0)
						(hand3 agreedSuit: temp0)
					)
					(cond
						(
							(and
								(or (hand1 agreedSuit:) (< temp43 15))
								(== global425 20)
							)
							(hand1 bidTree: 761 bidBranch: 8 forcing: 1)
							(hand3 bidTree: 761 bidBranch: 9)
							(temp27 artificial: 1)
						)
						(
							(and
								(> (= temp13 (BidBox size:)) 3)
								(== global425 16)
								(OneOf
									(= temp0
										((BidBox at: (- temp13 3)) bidNumber:)
									)
									5
									10
								)
							)
							(hand1 bidTree: 722 bidBranch: 12 forcing: 1)
							(hand3 bidTree: 722 bidBranch: 13)
							(temp27 artificial: 1)
						)
						(
							(and
								(> temp13 3)
								(OneOf global425 6 11)
								(OneOf
									(= temp0
										((BidBox at: (- temp13 3)) bidNumber:)
									)
									5
									10
								)
							)
							(BidBox
								openingBidValue: temp0
								openingBidder: hand3
								bidsSinceOpen: 2
							)
							(hand1 bidTree: 721 bidsOpen: 0 forcing: 1)
							(hand3 bidTree: 721 bidsOpen: 1)
							(temp27 artificial: 1)
						)
						((== (BidBox bidsSinceOpen:) 1)
							(proc709_4
								hand1
								(hand1 points:)
								(hand1 points:)
								(hand1 clubs:)
								(hand1 clubs:)
								(hand1 diamonds:)
								(hand1 diamonds:)
								(hand1 hearts:)
								(hand1 hearts:)
								(hand1 spades:)
								(hand1 spades:)
							)
							(switch global425
								(6
									(hand1 bidTree: 715 forcing: 1)
									(temp27 artificial: 1)
								)
								(5
									(hand1 bidTree: 712)
								)
								(10
									(hand1 bidTree: 713)
									(hand3 bidTree: 713)
								)
								(15
									(hand3 bidTree: 714)
								)
								(else
									(switch (/ (- global425 1) 5)
										(0
											(hand1 bidTree: 716)
										)
										(1
											(hand1 bidTree: 717)
										)
										(else
											(hand1 bidTree: 719)
											(hand3 bidTree: 719)
										)
									)
								)
							)
						)
						(
							(and
								(not (hand1 firstBidSuit:))
								(!= (= temp0 (+ 1 (mod (- global425 1) 5))) 5)
								(not (temp27 artificial:))
								(or
									(!=
										(BidBox openingBidder:)
										(hand1 partner:)
									)
									(!= (BidBox openingBidValue:) 6)
									(!= ((proc709_6 2) bidNumber:) 7)
									(!=
										(- ((proc709_6 2) bidNumber:) global425)
										1
									)
								)
							)
							(hand1 firstBidSuit: temp0)
						)
					)
					(= temp41 (temp27 bidNumber:))
					(if (BidBox openingBidder:)
						(temp42 bidsOpen: (+ (= temp38 (temp42 bidsOpen:)) 1))
						(cond
							((and (not temp38) (== temp41 50))
								(hand1 bidBranch: 17)
							)
							((== (hand1 bidBranch:) 17)
								(hand1 bidBranch: 0)
							)
						)
					)
					(for ((= temp0 0)) (<= temp0 4) ((++ temp0))
						(= [temp28 temp0] (= [temp33 temp0] 0))
					)
					(= temp40 0)
					(= temp0 0)
					(= temp13 (- (BidBox size:) 1))
					(while (< temp0 temp13)
						(= temp25 (BidBox at: temp0))
						(= temp38 (temp25 bidNumber:))
						(if (== (= temp39 (temp25 location:)) 1)
							(= temp40 temp38)
						)
						(if
							(and
								(not (temp25 artificial:))
								(not (OneOf (temp25 bidNumber:) 0 50 99))
								(<= 1 (= temp26 (temp25 suit:)) 4)
							)
							(if (OneOf temp39 1 3)
								(++ [temp28 temp26])
							else
								(++ [temp33 temp26])
							)
						)
						(++ temp0)
					)
					(= temp26 (temp27 suit:))
					(= temp38 0)
					(if
						(and
							(<= 1 temp41 35)
							(or
								(!= temp26 5)
								(and (== temp41 10) (<= 1 temp40 4))
							)
							(or
								(= temp38 [temp33 temp26])
								(temp27 artificial:)
								(and
									(not [temp28 temp26])
									(>= (= temp38 (BidBox bidsSinceOpen:)) 3)
									(!=
										((BidBox at: (- (BidBox size:) 3))
											bidNumber:
										)
										0
									)
									(or
										(and
											(> temp41 (+ temp40 5))
											(temp42 forcing: 2)
										)
										(and
											(== (BidBox openingBidder:) hand3)
											(OneOf (Dealer dealer:) 4 1)
										)
										(and
											(== (BidBox openingBidder:) temp42)
											(/ (- temp41 1) 5)
										)
									)
								)
							)
						)
						(if temp38
							(temp42 bidBranch: 1)
						)
						(if (not (temp42 forcing:))
							(temp42 forcing: 1)
						)
					)
					(= ticks 3)
				)
				(cond
					((== (= temp41 (temp27 bidNumber:)) 50)
						(= global424 50)
						(= global428 0)
						(= global426 temp42)
					)
					(
						(or
							(= temp25 0)
							(<= 1 temp41 35)
							(and
								(== temp41 0)
								(>= (= temp13 (BidBox size:)) 3)
								(== ((BidBox at: (- temp13 2)) bidNumber:) 0)
								(!=
									(= temp25
										((BidBox at: (- temp13 3)) bidNumber:)
									)
									0
								)
							)
						)
						(= global426 0)
						(= global424
							(switch temp25
								(50
									(= global426 (temp42 partner:))
									50
								)
								(99 -2)
								(else
									(= global424 -1)
								)
							)
						)
					)
					(else
						(= global424 -2)
					)
				)
			)
			(9
				(cond
					((or (== global459 2) (== global459 3))
						(BidBox erase:)
						(global117 eachElementDo: #endHand)
						(= state 12)
						(= ticks 1)
					)
					((< global116 (+ 3 (== global427 0)))
						(Dealer nextToPlay:)
						(-= state 2)
						(= ticks
							(if (== ((Dealer curPlayer:) type:) 1)
								(* global386 3)
							else
								1
							)
						)
					)
					(else
						(if (== global116 4)
							(BidBox erase:)
							(global117 eachElementDo: #endHand)
							(= state 12)
						)
						(= ticks (* global386 5))
					)
				)
			)
			(10
				(if (== global459 1)
					(= global459 0)
				)
				(DisposeScript 701)
				(gTrick
					trump:
						(switch (mod global427 5)
							(0 5)
							(1 1)
							(2 2)
							(3 3)
							(4 4)
						)
				)
				(switch (gTrick trump:)
					(1
						(= [global390 0] 1)
						(= [global390 1] 2)
						(= [global390 2] 4)
						(= [global390 3] 3)
					)
					(4
						(= [global390 0] 4)
						(= [global390 1] 2)
						(= [global390 2] 1)
						(= [global390 3] 3)
					)
					(3
						(= [global390 0] 3)
						(= [global390 1] 1)
						(= [global390 2] 2)
						(= [global390 3] 4)
					)
					(else
						(= [global390 0] 2)
						(= [global390 1] 1)
						(= [global390 2] 3)
						(= [global390 3] 4)
					)
				)
				(DisposeScript 709)
				(DisposeScript 712)
				(DisposeScript 713)
				(DisposeScript 714)
				(DisposeScript 715)
				(DisposeScript 716)
				(DisposeScript 717)
				(DisposeScript 718)
				(DisposeScript 719)
				(DisposeScript 761)
				(DisposeScript 721)
				(DisposeScript 722)
				(DisposeScript 731)
				(if (== (gTrick trump:) 5)
					(= local9 1)
				else
					(= local9 0)
				)
				(BidBox setDeclarer: (gTrick trump:))
				(= global431 (global429 partner:))
				(hand1
					type:
						(if (== global431 hand1)
							(hand3 origType:)
						else
							(hand1 origType:)
						)
				)
				(hand2
					type:
						(if (== global431 hand2)
							(hand4 origType:)
						else
							(hand2 origType:)
						)
				)
				(hand3
					type:
						(if (== global431 hand3)
							(hand1 origType:)
						else
							(hand3 origType:)
						)
				)
				(hand4
					type:
						(if (== global431 hand4)
							(hand2 origType:)
						else
							(hand4 origType:)
						)
				)
				(if (== global432 2)
					(hand1 type: 0)
					(hand2 type: 0)
					(hand3 type: 0)
					(hand4 type: 0)
				)
				(if (>= (= temp13 (BidBox size:)) 4)
					(= global424 ((BidBox at: (- temp13 4)) bidNumber:))
					(if (<= 1 global424 35)
						(= global424 0)
					)
				else
					(= global424 0)
				)
				(BidBox erase:)
				(Dealer nextToPlay: global429)
				(Dealer nextToPlay:)
				(gTrick leader: (global429 LHO:))
				(HandsOn)
				(= global430 0)
				(if (and (!= global432 2) (== (global431 origType:) 0))
					(global429 sort: 1 flip: 1)
					(if (== global432 1)
						(hand1 type: 0)
						(hand3 type: 0)
					)
				)
				(TrickBox init: (BScore weTricksWon:) (BScore theyTricksWon:))
				(dummySymbol init:)
				(if (BScore weGamesWon:)
					(BScore weVulnerable: 1)
				)
				(if (BScore theyGamesWon:)
					(BScore theyVulnerable: 1)
				)
				(Deck eachElementDo: #associatedObj 0)
				(if (or (== global431 hand1) (== global431 hand3))
					(global431 eachElementDo: #associatedObj dummySymbol)
				)
				(BScore weHonors: 0 theyHonors: 0)
				(global117 eachElementDo: #setHonors)
				(if
					(or
						(== (global429 location:) 1)
						(== (global429 location:) 3)
					)
					(= global435 (BScore weGamesWon:))
				else
					(= global435 (BScore theyGamesWon:))
				)
				(if global459
					(= state 12)
				)
				(handleEventList add: hand1 hand2 hand3 hand4)
				(= global437 1)
				(Deck eachElementDo: #offsetX 4 eachElementDo: #offsetY 20)
				(if (== (hand1 type:) 0)
					(hand1 eachElementDo: #addKeyMouse)
				)
				(if (== (hand2 type:) 0)
					(hand2
						eachElementDo: #addKeyMouse
						eachElementDo: #offsetX 20
						eachElementDo: #offsetY 4
					)
				)
				(if (== (hand3 type:) 0)
					(hand3 eachElementDo: #addKeyMouse)
				)
				(if (== (hand4 type:) 0)
					(hand4
						eachElementDo: #addKeyMouse
						eachElementDo: #offsetX 20
						eachElementDo: #offsetY 4
					)
				)
				(if (and (!= (gTrick trump:) 5) (!= (gTrick trump:) 2))
					(hand2 sort:)
					(if (hand2 faceUp:)
						(hand2 sort:)
					)
					(if (hand3 faceUp:)
						(hand3 sort:)
					)
					(if (hand4 faceUp:)
						(hand4 sort:)
					)
				)
				(= ticks 1)
			)
			(11
				(if (== ((Dealer curPlayer:) type:) 1)
					(= local1 0)
					((Dealer curPlayer:) think:)
				else
					(= local1 1)
					(if
						(and
							(!= local42 0)
							((Dealer curPlayer:) size:)
							(or
								(<
									gMouseX
									(- (((Dealer curPlayer:) at: 0) lsLeft:) 20)
								)
								(<
									gMouseY
									(- (((Dealer curPlayer:) at: 0) lsTop:) 20)
								)
								(>
									gMouseX
									(+
										(((Dealer curPlayer:)
												at:
													(-
														((Dealer curPlayer:)
															size:
														)
														1
													)
											)
											lsRight:
										)
										20
									)
								)
								(>
									gMouseY
									(+
										(((Dealer curPlayer:)
												at:
													(-
														((Dealer curPlayer:)
															size:
														)
														1
													)
											)
											lsBottom:
										)
										20
									)
								)
							)
						)
						(if
							(or
								(not (gTrick size:))
								(not
									((Dealer curPlayer:)
										countSuit: (gTrick suitLead:)
									)
								)
							)
							(KeyMouse
								setCursor:
									((Dealer curPlayer:)
										at: (/ ((Dealer curPlayer:) size:) 2)
									)
							)
						else
							(for
								((= temp0 0))
								(< temp0 ((Dealer curPlayer:) size:))
								((++ temp0))
								
								(if
									(==
										(((Dealer curPlayer:) at: temp0) suit:)
										(gTrick suitLead:)
									)
									(KeyMouse
										setCursor:
											((Dealer curPlayer:) at: temp0)
									)
									(break)
								)
							)
						)
					)
					(HandsOn)
				)
			)
			(12
				(if (not global430)
					(= global430 1)
					(= local0 (global431 faceUp:))
					(global431 sort: 1 flip: 1)
				)
				(Dealer
					nextToPlay:
						(if (gTrick size:)
							0
						else
							(gTrick leader:)
						)
				)
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
			(13
				(Arrow endHand:)
				(if global431
					(dummySymbol dispose:)
					(global431 faceUp: local0)
				)
				(handleEventList delete: hand1 hand2 hand3 hand4)
				(= ticks 1)
			)
			(14
				(= global405 0)
				(SortArray clearOut:)
				((ScriptID 15 1) release:) ; discardList
				(proc763_1)
				(= temp12 0)
				(= local3 0)
				(= global437 0)
				(if (and (!= global116 4) (not global459))
					(= temp8
						(or
							(== (global429 location:) 1)
							(== (global429 location:) 3)
						)
					)
					(if (>= global433 (+ global434 6))
						(if (>= global424 50)
							(= temp24 (if (== global424 50) 50 else 100))
							(if temp8
								(BScore
									weMadeDoubled: temp24
									addOverLine: temp24 0
								)
							else
								(BScore
									theyMadeDoubled: temp24
									addOverLine: temp24 1
								)
							)
						)
						(if (== global434 6)
							(= global405 1)
							(gSound play: 706)
							(if (== (global429 location:) 1)
								((global429 owner:) say: 1000 1 23 0 1 464 1)
							else
								(((global429 partner:) owner:)
									say: 1000 1 23 0 1 464 1
								)
							)
							(= temp12 1)
							(= temp11 (if global435 750 else 500))
							(if temp8
								(BScore
									weSlamBonus: temp11
									addOverLine: temp11 0
								)
							else
								(BScore
									theySlamBonus: temp11
									addOverLine: temp11 1
								)
							)
						)
						(if (== global434 7)
							(= global405 1)
							(gSound play: 706)
							(if (== (global429 location:) 1)
								((global429 owner:) say: 1000 1 23 0 1 464 1)
							else
								(((global429 partner:) owner:)
									say: 1000 1 23 0 1 464 1
								)
							)
							(= temp12 1)
							(= temp11 (if global435 1500 else 1000))
							(if temp8
								(BScore
									weSlamBonus: temp11
									addOverLine: temp11 0
								)
							else
								(BScore
									theySlamBonus: temp11
									addOverLine: temp11 1
								)
							)
						)
						(if (> global433 (+ global434 6))
							(= temp9 (- global433 (+ global434 6)))
							(= temp10 (if (<= (gTrick trump:) 2) 20 else 30))
							(switch global424
								(50
									(= temp11 (* (+ global435 1) 100 temp9))
								)
								(99
									(= temp11 (* (+ global435 1) 200 temp9))
								)
								(else
									(= temp11 (* temp10 temp9))
								)
							)
							(if temp8
								(BScore
									weOvertricks: temp11
									addOverLine: temp11 0
								)
							else
								(BScore
									theyOvertricks: temp11
									addOverLine: temp11 1
								)
							)
						)
						(= temp11
							(= temp10
								(switch (gTrick trump:)
									(5 40)
									(1 20)
									(2 20)
									(3 30)
									(4 30)
								)
							)
						)
						(if (and (> global434 1) (== temp10 40))
							(= temp10 30)
						)
						(+= temp11 (* temp10 (- global434 1)))
						(switch global424
							(50
								(*= temp11 2)
							)
							(99
								(*= temp11 4)
							)
						)
						(if temp8
							(BScore weHandTotal: temp11)
						else
							(BScore theyHandTotal: temp11)
						)
						(if (not temp12)
							(= global405 1)
							(gSound play: 704)
							(if (not (Random 0 4))
								(if (== (global429 location:) 1)
									((global429 owner:) say: 1000 1 23 0 2 464)
								else
									(((global429 partner:) owner:)
										say: 1000 1 23 0 2 464
									)
								)
							)
						)
					else
						(= temp6 (- (+ global434 6) global433))
						(= temp11 (if global435 100 else 50))
						(switch global424
							(50
								(*= temp11 2)
							)
							(99
								(*= temp11 4)
							)
						)
						(if (> temp6 1)
							(switch global424
								(50
									(+= temp11 (* (- temp6 1) 200))
									(if global435
										(+= temp11 (* (- temp6 1) 100))
									)
								)
								(99
									(+= temp11 (* (- temp6 1) 400))
									(if global435
										(+= temp11 (* (- temp6 1) 200))
									)
								)
								(else
									(+= temp11 (* (- temp6 1) 50))
									(if global435
										(+= temp11 (* (- temp6 1) 50))
									)
								)
							)
						)
						(if (and (>= temp6 4) (>= global424 50) (not global435))
							(if (== global424 50)
								(+= temp11 (* (- temp6 3) 100))
							else
								(+= temp11 (* (- temp6 3) 200))
							)
						)
						(if temp8
							(BScore
								theyOvertricks: 0
								theyUndertricks: temp11
								addOverLine: temp11 1
							)
						else
							(BScore
								weOvertricks: 0
								weUndertricks: temp11
								addOverLine: temp11 0
							)
						)
						(= global405 1)
						(gSound play: 705)
						(if (not (Random 0 3))
							(if
								(or
									(== (global429 location:) 1)
									(== (global429 location:) 3)
								)
								(if (Random 0 1)
									((hand2 owner:)
										say: 1000 1 23 0 (Random 1 2) 464
									)
								else
									((hand4 owner:)
										say: 1000 1 23 0 (Random 1 2) 464
									)
								)
							else
								((hand3 owner:)
									say: 1000 1 23 0 (Random 1 2) 464
								)
							)
						)
					)
					(if (BScore weHonors:)
						(BScore addOverLine: (BScore weHonors:) 0)
					)
					(if (BScore theyHonors:)
						(BScore addOverLine: (BScore theyHonors:) 1)
					)
					(BScore addScore:)
					(= local3 1)
					((ScriptID 762 0) init:) ; scorePanel
					(BScore wePrevOverLine: (BScore weOverLine:))
					(BScore theyPrevOverLine: (BScore theyOverLine:))
				else
					(= ticks 1)
				)
			)
			(15
				(= global443 0)
				((hand1 playedList:) release:)
				((hand2 playedList:) release:)
				((hand3 playedList:) release:)
				((hand4 playedList:) release:)
				(TrickBox erase:)
				(global117 eachElementDo: #endHand)
				(if (BScore gameOver:)
					(BScore gameInit:)
				else
					(BScore handInit:)
				)
				(if (!= global459 1)
					(= global431 0)
					(= global429 0)
				)
				(= ticks 1)
			)
			(16
				(if (not (BScore rubberOver:))
					(= state 3)
					(if (or (== global459 2) (== global459 1))
						(Deck sameDeck: 1)
					)
					(Deck shuffle:)
					(if (not global459)
						(Dealer rotate:)
					)
					(Dealer cardsToDeal: 13)
				else
					(BScore rubberInit:)
				)
				(= ticks 1)
			)
			(17
				((ScriptID 930 0) init: 770) ; yesNo
				(DisposeScript 930)
				(if global461
					(= state 2)
					(Deck shuffle:)
					(Dealer rotate: cardsToDeal: 13)
				)
				(= ticks 1)
			)
			(18
				(= gNewRoomNum 975) ; chooseGame
			)
		)
	)
)

(instance dummySymbol of View
	(properties)

	(method (init)
		(if (or (== global431 hand1) (== global431 hand3))
			(self
				view: 704
				setLoop: 6
				cel: 0
				posn: 126 (if (== global431 hand1) 182 else 34)
				setPri: 14
				ignoreActors:
				stopUpd:
			)
			(super init:)
		)
	)
)

(instance addToTricksWon of Code
	(properties)

	(method (doit param1)
		(switch param1
			((gTrick northPlayer:)
				(BScore weTricksWon: (+ (BScore weTricksWon:) 1))
				(TrickBox
					increment: 0 (BScore weTricksWon:) (BScore theyTricksWon:)
				)
			)
			((gTrick southPlayer:)
				(BScore weTricksWon: (+ (BScore weTricksWon:) 1))
				(TrickBox
					increment: 0 (BScore weTricksWon:) (BScore theyTricksWon:)
				)
			)
			((gTrick eastPlayer:)
				(BScore theyTricksWon: (+ (BScore theyTricksWon:) 1))
				(TrickBox
					increment: 1 (BScore weTricksWon:) (BScore theyTricksWon:)
				)
			)
			((gTrick westPlayer:)
				(BScore theyTricksWon: (+ (BScore theyTricksWon:) 1))
				(TrickBox
					increment: 1 (BScore weTricksWon:) (BScore theyTricksWon:)
				)
			)
		)
	)
)

(instance bridgeTrick of Trick
	(properties)

	(method (setCard param1)
		(if (and (== (param1 owner:) (gTrick leader:)) (== size 0))
			(param1 whoLedMe: (param1 owner:))
		)
		(((Dealer curPlayer:) playedList:) add: param1)
		(switch (param1 suit:)
			(1
				(++ global185)
			)
			(2
				(++ global186)
			)
			(3
				(++ global187)
			)
			(4
				(++ global184)
			)
		)
		(SortArray discarded: param1)
		(= local1 0)
		(super setCard: param1 1)
	)
)

(instance playedList1 of List
	(properties)
)

(instance playedList2 of List
	(properties)
)

(instance playedList3 of List
	(properties)
)

(instance playedList4 of List
	(properties)
)

(instance fixFile of File
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 [temp8 2] [temp10 52] [temp62 52])
		(if (self open: 1)
			(for ((= temp4 0)) (< temp4 52) ((++ temp4))
				(= temp3 32)
				(while
					(and
						(self read: @temp8 1)
						(OneOf (= temp3 (StrAt @temp8 0)) 32 13 10 9 44)
					)
				)
				(= temp6 (= temp7 0))
				(while (not (OneOf temp3 32 13 10 9 44))
					(cond
						((OneOf temp3 67 68 72 83)
							(= temp7 temp3)
						)
						((OneOf temp3 99 100 104 115)
							(= temp7 (+ temp3 -32))
						)
						((not temp6)
							(if (<= 97 temp3 122)
								(+= temp3 -32)
							)
							(= temp6 temp3)
						)
					)
					(self read: @temp8 1)
					(= temp3 (StrAt @temp8 0))
				)
				(= temp6
					(cond
						((or (== temp6 49) (== temp6 84)) 10)
						((== temp6 74) 11)
						((== temp6 81) 12)
						((== temp6 75) 13)
						((== temp6 65) 14)
						((<= 50 temp6 57)
							(- temp6 48)
						)
						(else 0)
					)
				)
				(= [temp10 temp4]
					(+
						(*
							(-
								(= temp7
									(switch temp7
										(67 1)
										(68 2)
										(72 3)
										(83 4)
										(else 0)
									)
								)
								1
							)
							13
						)
						(- temp6 2)
					)
				)
			)
			(self close:)
			(for ((= temp3 0)) (< temp3 52) ((++ temp3))
				(= [temp62 temp3] 0)
			)
			(for ((= temp3 0)) (< temp3 52) ((++ temp3))
				(if (<= 0 [temp10 temp3] 51)
					(++ [temp62 [temp10 temp3]])
				)
			)
			(= temp3 0)
			(= temp5 1)
			(while (< temp3 52)
				(if (!= [temp62 temp3] 1)
					(= temp5 0)
					(break)
				)
				(++ temp3)
			)
			(if temp5
				(for ((= temp0 (= temp4 0))) (< temp0 4) ((++ temp0))
					(= temp2
						(switch temp0
							(0 hand1)
							(1 hand2)
							(2 hand3)
							(3 hand4)
						)
					)
					(= temp1 0)
					(while (< temp1 13)
						(= temp6 (+ (mod [temp10 temp4] 13) 2))
						(= temp7 (+ (/ [temp10 temp4] 13) 1))
						((temp2 at: temp1) rank: temp6 suit: temp7)
						(++ temp1)
						(++ temp4)
					)
					(if (== (temp2 type:) 0)
						(temp2 flip: 0 flip: 1 sort:)
					)
				)
			else
				(Message msgGET 700 28 0 0 1 @global550) ; "File was in the wrong format or contained duplicate cards."
				(Print addText: @global550 init:)
			)
		else
			(Message msgGET 700 19 0 0 1 @global550)
			(Print addText: @global550 init:)
		)
		(return 0)
	)
)

(instance putFile of File
	(properties)

	(method (doit &tmp temp0 temp1 temp2 [temp3 3])
		(if (self open: 2)
			(StrAt @temp3 0 13)
			(StrAt @temp3 1 10)
			(StrAt @temp3 2 0)
			(for ((= temp0 0)) (< temp0 4) ((++ temp0))
				(= temp2
					(switch temp0
						(0 hand1)
						(1 hand2)
						(2 hand3)
						(3 hand4)
					)
				)
				(for ((= temp1 0)) (< temp1 13) ((++ temp1))
					(self
						writeString:
							[local12 ((temp2 at: temp1) rank:)]
							[local27 ((temp2 at: temp1) suit:)]
							{ }
					)
				)
				(self writeString: @temp3)
			)
			(self close:)
		)
		(return 0)
	)
)

