;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 600)
(include sci.sh)
(use Main)
(use KeyMouse)
(use Piles)
(use TrackingView)
(use Str)
(use Print)
(use Motion)
(use File)
(use Actor)
(use System)

(public
	klondike 0
	proc600_1 1
	optionCode 2
	roomScript 3
)

(local
	local0 = 51
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	local20
	local21
	local22
	local23
	local24
	[local25 75]
	local100
)

(procedure (proc600_1 param1)
	(proc0_8 97)
	((ScriptID 680 0) doit: local1 (if argc param1 else 0)) ; scoreKlondike
	(proc0_8 0)
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 temp3) ; UNUSED
	(= temp0 (Deck topCard:))
	(if (> local0 44)
		(if (== local0 45)
			(= temp2 1)
			(= temp1 0)
		else
			(if (== local0 51)
				(= temp2 13)
			else
				(= temp2 (- ((Deck at: (+ local0 1)) rank:) (- 52 local0)))
				(if (== local0 47)
					(= temp2 11)
				)
			)
			(if (or (== local0 51) (== local0 50))
				(= temp1 0)
			else
				(= temp1 3)
			)
		)
		((Deck at: local0) rank: temp2)
		((Deck at: local0) suit: temp1)
	)
	(if (and (<= local0 44) (>= local0 39))
		(if (== local0 39)
			(= temp2 1)
			(= temp1 1)
		else
			(if (== local0 44)
				(= temp2 12)
			else
				(= temp2 (- ((Deck at: (+ local0 1)) rank:) (- 46 local0)))
				(if (== local0 41)
					(= temp2 12)
				)
			)
			(if (== local0 44)
				(= temp1 3)
			else
				(= temp1 0)
			)
		)
		((Deck at: local0) rank: temp2)
		((Deck at: local0) suit: temp1)
	)
	(if (and (<= local0 38) (>= local0 34))
		(if (== local0 34)
			(= temp2 1)
			(= temp1 2)
		else
			(if (== local0 38)
				(= temp2 10)
			else
				(= temp2 (- ((Deck at: (+ local0 1)) rank:) (- 41 local0)))
				(if (== local0 36)
					(= temp2 13)
				)
			)
			(= temp1 3)
		)
		((Deck at: local0) rank: temp2)
		((Deck at: local0) suit: temp1)
	)
	(if (and (<= local0 33) (>= local0 30))
		(if (== local0 30)
			(= temp2 1)
			(= temp1 3)
		else
			(if (== local0 33)
				(= temp2 7)
			else
				(= temp2 (- ((Deck at: (+ local0 1)) rank:) (- 37 local0)))
				(if (== local0 31)
					(= temp2 8)
				)
			)
			(if (== local0 32)
				(= temp1 3)
			else
				(= temp1 0)
			)
		)
		((Deck at: local0) rank: temp2)
		((Deck at: local0) suit: temp1)
	)
	(if (and (<= local0 29) (>= local0 27))
		(if (== local0 29)
			(= temp2 3)
		else
			(= temp2 (- ((Deck at: (+ local0 1)) rank:) (- 34 local0)))
			(if (== local0 28)
				(= temp2 9)
			)
		)
		(if (== local0 28)
			(= temp1 3)
		else
			(= temp1 0)
		)
		((Deck at: local0) rank: temp2)
		((Deck at: local0) suit: temp1)
	)
	(if (and (<= local0 26) (>= local0 25))
		(if (== local0 26)
			(= temp2 10)
			(= temp1 0)
		else
			(= temp2 3)
			(= temp1 3)
		)
		((Deck at: local0) rank: temp2)
		((Deck at: local0) suit: temp1)
	)
	(if (== local0 24)
		(= temp2 4)
		(= temp1 0)
		((Deck at: local0) rank: temp2)
		((Deck at: local0) suit: temp1)
	)
	(if (== local0 24)
		(for ((= temp3 23)) (> temp3 11) ((-- temp3))
			(= temp2 (- temp3 10))
			(= temp1 2)
			((Deck at: temp3) rank: temp2)
			((Deck at: temp3) suit: temp1)
		)
		(for ((= temp3 11)) (>= temp3 0) ((-- temp3))
			(= temp2 (+ temp3 2))
			(= temp1 1)
			((Deck at: temp3) rank: temp2)
			((Deck at: temp3) suit: temp1)
		)
	)
	(-- local0)
)

(class Foundation of DiscardPile
	(properties
		foundationView 0
		foundSuit 0
		foundUnder 0
	)

	(method (init)
		(super init: &rest)
		(self view: 600 setPri: 1)
	)

	(method (enterKey)
		(gSound play: 905)
		(Message msgGET 600 19 0 0 8 (local100 data:)) ; "You can't do anything with the foundations."
		(Print
			ticks: 400
			fore: 0
			mode: 1
			addBitmap: 25 2 0
			addText: local100
			init:
		)
		(return 0)
	)

	(method (track)
		(gSound play: 905)
		(Message msgGET 600 19 0 0 8 (local100 data:)) ; "You can't do anything with the foundations."
		(Print
			ticks: 400
			fore: 0
			mode: 1
			addBitmap: 25 2 0
			addText: local100
			init:
		)
		(return 1)
	)

	(method (adjust &tmp temp0)
		(= temp0 ((ScriptID 15 1) at: (- ((ScriptID 15 1) size:) 1))) ; discardList, discardList
		(temp0 posn: origX origY show:)
	)

	(method (cantTake)
		(return 0)
	)

	(method (cue)
		(enterAdd doit: self)
	)

	(method (setCard param1 &tmp [temp0 2])
		(= local9 0)
		(++ local1)
		(if (== global263 1)
			(gSound2 play: 503)
		else
			(gSound2 play: 603)
		)
		(if upCard
			(= foundUnder upCard)
		else
			(foundationView dispose:)
			(= foundUnder param1)
		)
		(Undoer setFrom: self active: 1)
		(undoList release:)
		(Undoer setObject: param1)
		(param1 undoX: (param1 theBeginX:) undoY: (param1 theBeginY:))
		(param1 deleteKeyMouse:)
		(super setCard: param1)
	)

	(method (validPlay param1)
		(if (and (param1 tailList:) ((param1 tailList:) size:))
			(return 0)
		)
		(if (== (param1 suit:) foundSuit)
			(cond
				((not upCard)
					(if (== (param1 rank:) 1)
						(return 1)
					else
						(return 0)
					)
				)
				((== (param1 rank:) (+ (upCard rank:) 1))
					(return 1)
				)
				(else
					(return 0)
				)
			)
		else
			(return 0)
		)
	)
)

(instance klondike of HoyleRoom
	(properties
		style 14
	)

	(method (init)
		(= picture (+ 901 global385))
		(= local15 0)
		(= gCardGameScriptNumber 600)
		(gChar1 active: 0)
		(gChar2 active: 0)
		(gChar3 active: 0)
		(Load rsVIEW 50)
		(Load rsVIEW 51)
		(Load rsVIEW 52)
		(Load rsVIEW 53)
		(Load rsVIEW (+ 54 global384))
		(gTheKeyMouseList release:)
		(KeyMouse setList: gTheKeyMouseList)
		(gGame setCursor: 999)
		(= local11 0)
		((= gKlondike_opt klondike_opt) doit:)
		(super init:)
		(= local18 0)
		(= local100 (Str new:))
		(= gSortMode 0)
		(if local11
			(RedrawCast)
			(EnableCursor)
			(gGameControls hide:)
			(= local12 (gSystemPlane back:))
			(gSystemPlane back: 53)
			((ScriptID 690 0) init:) ; optionKlondike
			(gSystemPlane back: local12)
			(DisableCursor)
		)
		(if (== global262 1)
			(= local3 1)
		else
			(= local3 0)
		)
		(= global265 0)
		(tempList add:)
		(tempDiscard add:)
		(undoList add:)
		(hand1 add: owner: 0)
		(hand2 add: owner: 0)
		(hand3 add: owner: 0)
		(hand4 add: owner: 0)
		(hand5 add: owner: 0)
		(hand6 add: owner: 0)
		(hand7 add: owner: 0)
		(discardHand add: owner: 0)
		((= gTheHands theHands) add: hand1 hand2 hand3 hand4 hand5 hand6 hand7)
		(emptyCol1 handAssociatedWith: hand1)
		(emptyCol2 handAssociatedWith: hand2)
		(emptyCol3 handAssociatedWith: hand3)
		(emptyCol4 handAssociatedWith: hand4)
		(emptyCol5 handAssociatedWith: hand5)
		(emptyCol6 handAssociatedWith: hand6)
		(emptyCol7 handAssociatedWith: hand7)
		(hand1 emptyColAssociatedWith: emptyCol1)
		(hand2 emptyColAssociatedWith: emptyCol2)
		(hand3 emptyColAssociatedWith: emptyCol3)
		(hand4 emptyColAssociatedWith: emptyCol4)
		(hand5 emptyColAssociatedWith: emptyCol5)
		(hand6 emptyColAssociatedWith: emptyCol6)
		(hand7 emptyColAssociatedWith: emptyCol7)
		(spadeFound foundationView: spadeView)
		(clubFound foundationView: clubView)
		(diamondFound foundationView: diamondView)
		(heartFound foundationView: heartView)
		(handleEventList add:)
		(Deck init: KlonCard)
		(Deck rankAces: 1)
		(= global419 theStock)
		(global419 client: discardHand)
		(gKlondike_opt doit: 3)
		(= local13 1)
		(= global402 0)
		(= local1 0)
		(self setScript: roomScript)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(handleEventList handleEvent: event)
	)

	(method (doit)
		(super doit:)
		(KlonDealer doit:)
	)

	(method (dispose &tmp temp0)
		(undoList release: dispose:)
		(tempList release: dispose:)
		(tempDiscard release: dispose:)
		(= local15 0)
		(= global419 0)
		(= gCrazy8sSortCode 0)
		(gDelayCast release:)
		(= global458 0)
		(Piles eachElementDo: #dispose release: dispose:)
		(KlonDealer dispose:)
		((KeyMouse objList:) release:)
		(discardHand release: dispose:)
		(gTheHands
			eachElementDo: #release
			eachElementDo: #dispose
			release:
			dispose:
		)
		(handleEventList release: dispose:)
		(Deck dispose:)
		(DisposeScript 64941)
		(DisposeScript 9)
		(DisposeScript 680)
		(DisposeScript 601)
		(DisposeScript 690)
		(super dispose:)
	)
)

(instance quitButton of TrackingView
	(properties
		x 280
		y 195
		view 21
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= global748 0)
			((ScriptID 930 0) init: 22) ; yesNo
			(DisposeScript 930)
			(if global748
				(gGame quitGame:)
			)
		)
	)
)

(instance klondike_opt of File
	(properties
		name {klondike.opt}
	)

	(method (doit &tmp [temp0 3])
		(= global261 0)
		(= global262 0)
		(= global263 1)
		(= global264 2)
		(= local11 0)
		(return 0)
	)
)

(instance roomScript of Script
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(super doit: &rest)
		(if
			(and
				local15
				(== state 5)
				(not (theStock size:))
				(not (discardHand size:))
			)
			(= temp1 (- (gTheHands size:) 1))
			(= temp0 0)
			(while (>= temp1 0)
				(= temp2 (gTheHands at: temp1))
				(if (temp2 size:)
					(if ((temp2 at: 0) faceUp:)
						(+= temp0 (temp2 size:))
					else
						(= local21 0)
						(= local23 0)
						(return)
					)
				)
				(-- temp1)
			)
			(if (and temp0 (== (+ local1 temp0) 52))
				(= local21 1)
				(= local22 1)
				(if (not local23)
					(DisableCursor)
					(= local23 1)
				)
			else
				(= local21 0)
				(= local23 0)
			)
			(if (and local21 (not global458))
				(= temp1 0)
				(= temp6 15)
				(while (< temp1 (gTheHands size:))
					(if ((gTheHands at: temp1) size:)
						(= temp7
							((gTheHands at: temp1)
								at: (- ((gTheHands at: temp1) size:) 1)
							)
						)
						(if (< (temp7 rank:) temp6)
							(= temp6 (temp7 rank:))
							(= temp4 temp7)
							(= temp5 (gTheHands at: temp1))
						)
					)
					(++ temp1)
				)
				(if (temp4 tailList:)
					((temp4 tailList:) release:)
					(temp4 tailList: 0)
				)
				(= temp3 (canPlay doit: temp4 1))
				(if (temp3 isKindOf: Foundation)
					(if (= temp8 (temp5 indexOf: temp4))
						((= global399 (temp5 at: (- temp8 1))) setLoop: 0)
					)
					(= global458 temp4)
					(undoList release:)
					(temp5 centerY: (+ (temp5 y:) (* (temp5 size:) 6)))
					(temp5 moveCard: temp3 temp3)
					(if (not (temp5 size:))
						((temp5 emptyColAssociatedWith:) init:)
						(Piles add: (temp5 emptyColAssociatedWith:))
					)
				)
			)
		)
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= local15 0)
				(= ticks (= ticks 1))
			)
			(1
				(= global440 0)
				(= global441 0)
				(quitButton setPri: 1 init:)
				(gSong fade:)
				(= ticks 10)
			)
			(2
				(= ticks 10)
				(KlonDealer init: hand1 hand2 hand3 hand4 hand5 hand6 hand7)
			)
			(3
				(gTheIconBar enable:)
				(= ticks 10)
			)
			(4
				(= local15 0)
				(spadeFound foundUnder: 0)
				(clubFound foundUnder: 0)
				(diamondFound foundUnder: 0)
				(heartFound foundUnder: 0)
				(= local18 0)
				(= local13 1)
				(for ((= temp1 0)) (< temp1 (Deck size:)) ((++ temp1))
					((Deck at: temp1) inPlay: 0)
				)
				(= global395 0)
				(Deck shuffle:)
				(= local2 0)
				(= gGinRummyTurnCount 0)
				(= local1 0)
				(KlonDealer cardsToDeal: 7 playDirection: 0 deal: self)
			)
			(5
				(= local16 0)
				(= local15 1)
				(= local22 0)
				(EnableCursor)
				(resignButton setPri: 1 init:)
				((KeyMouse objList:) add: resignButton)
				(handleEventList add: resignButton)
				(= local10 0)
				(= local9 0)
				(spadeView init: setPri: 2)
				(clubView init: setPri: 2)
				(heartView init: setPri: 2)
				(diamondView init: setPri: 2)
				(spadeFound init:)
				(clubFound init:)
				(heartFound init:)
				(diamondFound init:)
				(handleEventList add: quitButton)
				(handleEventList add: hand1 hand2 hand3 hand4 hand5 hand6 hand7)
				(handleEventList
					add:
						global419
						discardHand
						clubFound
						spadeFound
						diamondFound
						heartFound
				)
				(Piles add: clubFound spadeFound diamondFound heartFound)
				(global419
					init:
					client: discardHand
					active: 1
					size: 24
					addKeyMouse:
				)
				(for ((= temp1 0)) (< temp1 (gTheHands size:)) ((++ temp1))
					((gTheHands at: temp1) partner: 0)
				)
				(for ((= temp1 0)) (< temp1 (Piles size:)) ((++ temp1))
					((Piles at: temp1) condition: 0)
				)
			)
			(6
				(= local15 0)
				(UnLoad 128 50)
				(UnLoad 128 51)
				(UnLoad 128 52)
				(UnLoad 128 53)
				(UnLoad 128 (+ 54 global384))
				(gSound play: 602)
				(spadeActor setScript: (ScriptID 601 0)) ; spadeScript
				(clubActor setScript: (ScriptID 601 1)) ; clubScript
				(heartActor setScript: (ScriptID 601 2)) ; heartScript
				(diamondActor setScript: (ScriptID 601 3)) ; diamondScript
			)
			(7
				(proc0_9 (gCast elements:) 0)
				(= ticks 10)
			)
			(8
				(proc600_1 1)
				(if local13
					((ScriptID 680 1) doit: local1) ; scoreHand
				)
				(= local13 1)
				(= state 2)
				(DisposeScript 601)
				(= ticks 10)
			)
		)
	)
)

(instance spadeActor of Actor
	(properties)
)

(instance clubActor of Actor
	(properties)
)

(instance heartActor of Actor
	(properties)
)

(instance diamondActor of Actor
	(properties)
)

(instance cleanUp of Code
	(properties)

	(method (doit &tmp temp0)
		(for ((= temp0 0)) (< temp0 52) ((++ temp0))
			(if ((Deck at: temp0) tailList:)
				(((Deck at: temp0) tailList:) release:)
			)
			((Deck at: temp0) tailList: 0)
		)
		(resignButton dispose:)
		(= local10 0)
		(= local9 0)
		(= local5 0)
		(gTheHands eachElementDo: #endHand)
		((KeyMouse objList:) release:)
		(global419 endHand:)
		(discardHand endHand:)
		(if (spadeFound upCard:)
			((spadeFound upCard:) hide:)
			(spadeFound upCard: 0)
		)
		(if (clubFound upCard:)
			((clubFound upCard:) hide:)
			(clubFound upCard: 0)
		)
		(if (diamondFound upCard:)
			((diamondFound upCard:) hide:)
			(diamondFound upCard: 0)
		)
		(if (heartFound upCard:)
			((heartFound upCard:) hide:)
			(heartFound upCard: 0)
		)
		(Piles eachElementDo: #dispose release: dispose:)
		(handleEventList release:)
		(global419 dispose:)
		(spadeView dispose:)
		(clubView dispose:)
		(heartView dispose:)
		(diamondView dispose:)
		(tempList release:)
		(undoList release:)
		(tempDiscard release:)
		(proc0_9 (gCast elements:) 0)
		(KlonDealer delete: hand7)
		(KlonDealer dealTo: hand1)
		(DisposeScript 601)
		(KlonDealer add: hand1 hand2 hand3 hand4 hand5 hand6 hand7)
		(if global265
			(Deck sameDeck: 1)
			(= global265 0)
		)
		(if (!= local1 52)
			(roomScript changeState: 3)
		)
	)
)

(class KlonCard of Card
	(properties
		offsetX 12
		offsetY 4
		color 0
		tailList 0
		tailOffSetX 0
		tailOffSetY 0
		theBeginX 0
		theBeginY 0
		undoX 0
		undoY 0
		inPlay 0
	)

	(method (init)
		(super init: &rest)
		(if (< suit 2)
			(= color 0)
		else
			(= color 1)
		)
	)

	(method (cue &tmp temp0)
		(super cue:)
		(self setLoop: 0)
		(if (and tailList (tailList size:))
			(for ((= temp0 0)) (< temp0 (tailList size:)) ((++ temp0))
				((tailList at: temp0)
					x: ((tailList at: temp0) theBeginX:)
					y: ((tailList at: temp0) theBeginY:)
					priority: 2
				)
			)
			(self setLoop: 2)
		)
		(if (and (> (discardHand size:) 1) (== global262 0))
			(for ((= temp0 0)) (< temp0 (- (discardHand size:) 1)) ((++ temp0))
				((discardHand at: temp0) hide:)
			)
		)
		(if local18
			(Undoer active: 1)
		)
		(= local18 0)
	)

	(method (track &tmp temp0 temp1 temp2 [temp3 2] temp5 temp6 temp7)
		(= global291 priority)
		(self setPri: 500)
		(= temp2 (Event new:))
		(= temp0 (- x (temp2 x:)))
		(= temp1 (- y (temp2 y:)))
		(temp2 dispose:)
		(self theBeginX: x theBeginY: y)
		(if tailList
			(for ((= temp6 0)) (< temp6 (tailList size:)) ((++ temp6))
				(= temp7 (tailList at: temp6))
				(temp7 setNSRect:)
				(= temp2 (Event new:))
				(temp7
					tailOffSetX: (- (temp7 x:) (temp2 x:))
					tailOffSetY: (- (temp7 y:) (temp2 y:))
					theBeginX: (temp7 x:)
					theBeginY: (temp7 y:)
					setPri: 500
				)
				(temp2 dispose:)
			)
		)
		(self saveData:)
		(= global189 self)
		(proc0_9 (gAniList elements:) 0)
		(= temp5 1)
		(while (!= evMOUSERELEASE ((= temp2 (Event new:)) type:))
			(= gGameTime (+ gTickOffset (GetTime)))
			(= gMouseX (temp2 x:))
			(= gMouseY (temp2 y:))
			(self x: (+ (temp2 x:) temp0) y: (+ (temp2 y:) temp1) setNSRect:)
			(if tailList
				(for ((= temp6 0)) (< temp6 (tailList size:)) ((++ temp6))
					(= temp7 (tailList at: temp6))
					(temp7 x: (+ (temp2 x:) (temp7 tailOffSetX:)))
					(temp7 y: (+ (temp2 y:) (temp7 tailOffSetY:)))
					(temp7 setNSRect:)
				)
			)
			(proc0_9 (gAniList elements:) 0)
			(temp2 dispose:)
		)
		(= gMouseX (temp2 x:))
		(= gMouseY (temp2 y:))
		(temp2 dispose:)
		(proc0_9 (gAniList elements:) 1)
		(gAniList release:)
		(return temp5)
	)
)

(instance discardHand of Hand
	(properties
		x 121
		y 151
		faceUp 1
		autoSorting 0
		centerX 121
		centerY 151
	)

	(method (eliminateCard param1)
		(param1 inPlay: 1)
		(super eliminateCard: param1)
		(if size
			((self at: (- size 1)) addKeyMouse:)
		)
	)

	(method (add param1)
		(if size
			((self at: (- size 1)) deleteKeyMouse:)
		)
		(if argc
			(super add: param1)
			(param1 addKeyMouse:)
		else
			(super add:)
		)
	)

	(method (calcNextX)
		(return x)
	)

	(method (calcNextY)
		(return y)
	)

	(method (posn &tmp temp0)
		(= global399 0)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3)
		(if
			(and
				(not (event claimed:))
				(not global395)
				(= temp0 (self reverseFirstTrue: 165 event))
				(== (self indexOf: temp0) (- size 1))
			)
			(temp0 setLoop: 0)
			(= global399 0)
			(if (and (!= handDirection 3) (= temp1 (self indexOf: temp0)))
				((= global399 (self at: (- temp1 1)))
					setLoop:
						(if (== temp1 (- size 1))
							0
						else
							(+ 2 handDirection)
						)
					show:
				)
			)
			(switch (temp0 processEvent: event global399)
				(1
					(cond
						((checkHands doit: temp0)
							(Undoer setTo: self)
							(self eliminateCard: temp0)
							(if (== global262 1)
								(showThree doit:)
							)
						)
						(
							(and
								(= temp2 (Piles cardOnPile: temp0))
								(temp2 validPlay: temp0)
							)
							(= local9 0)
							(temp2 setCard: temp0)
							(Undoer setTo: self)
							(self eliminateCard: temp0)
							(if (== global262 1)
								(showThree doit:)
							)
							(if (== local1 52)
								(gTheIconBar disable:)
								(DisableCursor)
								(SetDebug 1)
								(endCode doit: temp0)
								(return 1)
							)
						)
						(else
							(if (Undoer active:)
								(= local18 1)
							)
							(Undoer active: 0)
							(if
								(and
									(temp0 tailList:)
									((temp0 tailList:) size:)
								)
								((temp0 tailList:) add: temp0)
								(temp0 cue:)
							else
								(temp0 moveBack:)
							)
						)
					)
				)
				(2
					(if (= temp3 (canPlay doit: temp0 0))
						(Undoer active: 0)
						(Undoer setTo: self)
						(= global458 temp0)
						(self moveCard: temp3 temp3)
						(if (== global262 1)
							(showThree doit:)
						)
					else
						(Message msgGET 600 19 0 0 1 (local100 data:)) ; "There is no legal destination for this card."
						(Print
							ticks: 400
							fore: 0
							mode: 1
							addBitmap: 25 2 0
							addText: local100
							init:
						)
						(if global399
							(global399 setLoop: 1)
							(if (== global262 0)
								(global399 hide:)
							)
						)
					)
				)
			)
		)
	)
)

(instance endCode of Code
	(properties)

	(method (doit)
		(= local9 0)
		(cleanUp doit:)
		(= local15 0)
		(UnLoad 128 50)
		(UnLoad 128 51)
		(UnLoad 128 52)
		(UnLoad 128 53)
		(UnLoad 128 (+ 54 global384))
		(gSound play: 602)
		(roomScript changeState: 8)
	)
)

(instance canPlay of Code
	(properties)

	(method (doit param1 param2 &tmp temp0 temp1 temp2 [temp3 2] temp5 temp6 temp7 temp8)
		(= temp5 0)
		(if (not (param1 tailList:))
			(= temp0 0)
			(= temp6 1)
			(while (< temp0 (gTheHands size:))
				(if
					(and
						((gTheHands at: temp0) size:)
						(not (((gTheHands at: temp0) at: 0) faceUp:))
					)
					(= temp6 0)
					(break)
				)
				(++ temp0)
			)
			(= temp8 15)
			(for ((= temp0 0)) (< temp0 4) ((++ temp0))
				(if ((Piles at: temp0) upCard:)
					(if (< (((Piles at: temp0) upCard:) rank:) temp8)
						(= temp8 (((Piles at: temp0) upCard:) rank:))
					)
				else
					(= temp8 0)
					(break)
				)
			)
			(if (or (= temp7 (>= temp8 (- (param1 rank:) 2))) temp6)
				(for ((= temp0 0)) (< temp0 4) ((++ temp0))
					(if ((Piles at: temp0) validPlay: param1)
						(= global200 80)
						(return (Piles at: temp0))
					)
				)
			)
		)
		(if (not param2)
			(for ((= temp0 0)) (< temp0 (gTheHands size:)) ((++ temp0))
				(if ((gTheHands at: temp0) size:)
					(= temp1
						((gTheHands at: temp0)
							at: (- ((gTheHands at: temp0) size:) 1)
						)
					)
					(if
						(and
							(== (param1 rank:) (- (temp1 rank:) 1))
							(!= (param1 color:) (temp1 color:))
						)
						(= local9 0)
						(cond
							(
								(and
									(not ((gTheHands at: temp0) partner:))
									(!= (Undoer to:) (gTheHands at: temp0))
								)
								(= global200 76)
								(return (gTheHands at: temp0))
							)
							((not temp5)
								(= temp5 (gTheHands at: temp0))
							)
						)
					else
						(= temp2 0)
					)
				)
			)
		)
		(if (and (== (param1 rank:) 13) (> (Piles size:) 4))
			(= temp5 (Piles at: 4))
		else
			(= temp2 0)
		)
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			(if ((Piles at: temp0) validPlay: param1)
				(cond
					((not ((Piles at: temp0) condition:))
						(= global200 77)
						(return (Piles at: temp0))
					)
					((not temp5)
						(= temp5 (Piles at: temp0))
					)
				)
			else
				(= temp2 0)
			)
		)
		(if (not temp5)
			(= global200 78)
			(return temp2)
		else
			(for ((= temp0 0)) (< temp0 (gTheHands size:)) ((++ temp0))
				((gTheHands at: temp0) partner: 0)
			)
			(for ((= temp0 0)) (< temp0 (Piles size:)) ((++ temp0))
				((Piles at: temp0) condition: 0)
			)
			(= global200 79)
			(return temp5)
		)
	)
)

(instance checkHands of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1 temp2 temp3)
		(for ((= temp0 0)) (< temp0 (gTheHands size:)) ((++ temp0))
			(if
				(and
					((gTheHands at: temp0) size:)
					(proc15_0
						(= temp1
							((gTheHands at: temp0)
								at: (- ((gTheHands at: temp0) size:) 1)
							)
						)
						param1
					)
					(== (param1 rank:) (- (temp1 rank:) 1))
					(!= (param1 color:) (temp1 color:))
				)
				(= local9 0)
				(Undoer setFrom: (gTheHands at: temp0))
				((gTheHands at: temp0) add: param1)
				(undoList release:)
				(Undoer setObject: param1 active: 1)
				(param1 undoX: (param1 theBeginX:) undoY: (param1 theBeginY:))
				(if (param1 tailList:)
					(undoList add: param1)
					(for
						((= temp2 0))
						(< temp2 ((param1 tailList:) size:))
						((++ temp2))
						
						(= temp3 ((param1 tailList:) at: temp2))
						((gTheHands at: temp0) add: temp3)
						(temp3
							undoX: (temp3 theBeginX:)
							undoY: (temp3 theBeginY:)
						)
						(undoList add: temp3)
					)
					(Undoer setObject: undoList active: 1)
				)
				(return 1)
			)
		)
		(return 0)
	)
)

(instance theStock of Stock
	(properties
		offsetY 10
	)

	(method (init)
		(= x 70)
		(= y 144)
		(= loop 0)
		(super init:)
	)

	(method (validPlay)
		(return 1)
	)

	(method (adjust)
		(cond
			((< 8 size 13)
				(= local10 0)
				(self setLoop: 1 posn: (+ origX 2) (+ origY 2))
				((ScriptID 15 7) ; stockBack
					view: (+ 54 global384)
					setLoop: 0
					posn: (+ origX 2) (+ origY 2)
				)
			)
			((< 4 size 9)
				(= local10 0)
				(self setLoop: 2 posn: (+ origX 4) (+ origY 4))
				((ScriptID 15 7) ; stockBack
					view: (+ 54 global384)
					setLoop: 0
					posn: (+ origX 4) (+ origY 4)
				)
			)
			((< 0 size 5)
				(if (and (== global261 1) (< size 1))
					(= local10 1)
					(self setLoop: 4 posn: (+ origX 7) (+ origY 7))
					((ScriptID 15 7) ; stockBack
						view: 600
						setLoop: 5
						posn: (+ origX 8) (+ origY 8)
					)
				else
					(= local10 0)
					(self setLoop: 3 posn: (+ origX 6) (+ origY 6))
					((ScriptID 15 7) ; stockBack
						view: (+ 54 global384)
						setLoop: 0
						posn: (+ origX 6) (+ origY 6)
					)
				)
			)
			((== size 0)
				(self setLoop: 4 posn: (+ origX 7) (+ origY 7))
				(= local10 1)
				((ScriptID 15 7) ; stockBack
					view: 600
					setLoop: 5
					posn: (+ origX 8) (+ origY 8)
				)
			)
			(else
				(= local10 0)
				(self setLoop: 0 posn: origX origY)
				((ScriptID 15 7) ; stockBack
					view: (+ 54 global384)
					setLoop: 0
					posn: origX origY
				)
			)
		)
	)

	(method (getCard)
		(DisableCursor)
		(Undoer active: 0)
		(= local9 0)
		(= local17 0)
		(if (or (and (== global261 1) size) (and (== global261 0) size))
			(-= size (if (== global261 1) 3 else 1))
			(if (< size 0)
				(= size 0)
			)
			(++ cardsTaken)
			((ScriptID 15 6) ; littleCard
				view: (+ 54 global384)
				posn: (+ x 18) (+ y 22)
				init:
			)
			(Undoer setTo: self)
			(= local19 (Deck topCard:))
			(self adjust:)
			(= global395 1)
			(if (== global261 1)
				(= local17 1)
			)
			((ScriptID 15 6) ; littleCard
				hide:
				setMotion:
					MoveTo
					(+ (client calcNextX:) 17)
					(+ (client calcNextY:) 21)
					self
			)
			(= global116 0)
		else
			(EnableCursor)
			(if (discardHand size:)
				((discardHand at: (- (discardHand size:) 1)) deleteKeyMouse:)
			)
			(timesThru doit:)
		)
	)

	(method (cue)
		(self setScript: stockScript)
	)
)

(instance resignButton of TrackingView
	(properties
		x 226
		y 163
		view 600
		loop 6
	)

	(method (handleEvent event)
		(if (and (!= local1 52) (super handleEvent: event))
			(event claimed: 1)
			((ScriptID 930 0) init: 670) ; yesNo
			(DisposeScript 930)
			(if global748
				(handleEventList delete: self)
				(proc600_1 1)
				(if local13
					((ScriptID 680 1) doit: local1) ; scoreHand
				)
				(cleanUp doit:)
			)
		)
	)
)

(instance stockScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(if local17
					(= temp0 (getThree doit:))
				else
					(= temp0 (getOne doit:))
				)
				(= local17 0)
				(temp0 flip: 1 show: init:)
				((ScriptID 15 6) dispose:) ; littleCard
				(= global395 0)
				(if (== global262 1)
					(showThree doit:)
				else
					(if (> (discardHand size:) 1)
						((discardHand at: (- (discardHand size:) 2)) hide:)
					)
					(if (> (discardHand size:) 2)
						((discardHand at: (- (discardHand size:) 3)) hide:)
					)
					(if (> (discardHand size:) 3)
						((discardHand at: (- (discardHand size:) 4)) hide:)
					)
				)
				(discardHand posn:)
				(= cycles
					(if gCrazy8sHand
						(* global386 3)
					else
						1
					)
				)
			)
			(2
				(EnableCursor)
			)
		)
	)
)

(instance timesThru of Code
	(properties)

	(method (doit)
		(cond
			((== global264 0)
				(Message msgGET 600 19 0 0 2 (local100 data:)) ; "You've played through the deck one time."
				(Print
					ticks: 400
					fore: 0
					mode: 1
					addBitmap: 25 2 0
					addText: local100
					init:
				)
			)
			((== global264 1)
				(if (>= (++ local2) 3)
					(Message msgGET 600 19 0 0 3 (local100 data:)) ; "You've played through the deck three times."
					(Print
						ticks: 400
						fore: 0
						mode: 1
						addBitmap: 25 2 0
						addText: local100
						init:
					)
				else
					(resetStock doit:)
				)
			)
			(else
				(= local2 0)
				(resetStock doit:)
			)
		)
	)
)

(instance getThree of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2)
		(= local9 0)
		(undoList release:)
		(= local20 0)
		(= temp1 0)
		(= temp2 0)
		(while (< temp1 3)
			(if (>= (Deck topCard:) 0)
				(= temp0 (Deck getCard:))
				(if (not (temp0 inPlay:))
					(++ local20)
					(++ temp1)
					(undoList add: (= temp2 temp0))
					(Undoer active: 1)
					(gSound play: 903)
					(temp0 flip: 1 init:)
					(discardHand add: temp0)
				)
			else
				(++ temp1)
			)
		)
		(Undoer setObject: undoList)
		(Undoer setFrom: discardHand)
		(return temp2)
	)
)

(instance getOne of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(= local9 0)
		(undoList release:)
		(= local20 0)
		(= temp1 0)
		(while (< temp1 1)
			(= temp0 (Deck getCard:))
			(if (not (temp0 inPlay:))
				(Undoer active: 1)
				(discardHand add: temp0)
				(++ temp1)
				(++ local20)
			)
		)
		(undoList release:)
		(Undoer setObject: temp0)
		(Undoer setFrom: discardHand)
		(return temp0)
	)
)

(instance resetStock of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(= local10 0)
		(= local9 1)
		(Undoer active: 1)
		(= local7 (Deck topCard:))
		(= local8 (theStock size:))
		(= temp0 0)
		(for ((= temp1 0)) (< temp1 52) ((++ temp1))
			(if (not ((Deck at: temp1) inPlay:))
				(++ temp0)
			)
		)
		(theStock size: temp0)
		(tempDiscard release:)
		(for ((= temp1 0)) (< temp1 (discardHand size:)) ((++ temp1))
			(tempDiscard add: (discardHand at: temp1))
		)
		(discardHand eachElementDo: #hide)
		(discardHand release:)
		(theStock adjust:)
		(Deck topCard: 51)
	)
)

(instance undoReset of Code
	(properties)

	(method (doit &tmp temp0)
		(Undoer active: 0)
		(= local9 0)
		(theStock size: local8)
		(theStock adjust:)
		(if (tempDiscard size:)
			(for ((= temp0 0)) (< temp0 (tempDiscard size:)) ((++ temp0))
				(discardHand add: (tempDiscard at: temp0))
			)
		)
		(if (discardHand size:)
			(if (== global262 1)
				(showThree doit:)
			)
			((discardHand at: (- (discardHand size:) 1)) setLoop: 0 show:)
		)
		(Deck topCard: local7)
	)
)

(instance tempDiscard of List
	(properties)
)

(instance optionCode of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(if (== param1 1)
			(if (or (KlonDealer script:) (not local15))
				(Message msgGET 600 19 0 0 4 (local100 data:)) ; "This option does nothing unless in the middle of a hand. If you want a new deal, select this option again at that time."
				(Print
					ticks: 400
					fore: 0
					mode: 1
					addBitmap: 25 2 0
					addText: local100
					init:
				)
				(= local13 0)
				(SetDebug)
				(cleanUp doit:)
			)
			(cleanUp doit:)
		)
		(if (== param1 2)
			(if (and (Undoer active:) local15 (not local22))
				(Undoer undoit:)
			else
				(Message msgGET 600 19 0 0 5 (local100 data:)) ; "You can't undo now."
				(Print
					ticks: 400
					fore: 0
					mode: 1
					addBitmap: 25 2 0
					addText: local100
					init:
				)
			)
		)
		(= temp0 (discardHand size:))
		(cond
			((and (== global262 1) (not local3))
				(= local3 1)
				(cond
					((> temp0 2)
						((discardHand at: (- temp0 3)) x: 121 show:)
						((discardHand at: (- temp0 2))
							x: (+ 121 global396)
							show:
						)
						((discardHand at: (- temp0 1))
							x: (+ 121 (* global396 2))
							show:
						)
					)
					((> temp0 1)
						((discardHand at: (- temp0 2)) x: 121 show:)
						((discardHand at: (- temp0 1))
							x: (+ 121 global396)
							show:
						)
					)
				)
			)
			((and (== global262 0) local3)
				(= local3 0)
				(if (> temp0 2)
					((discardHand at: (- temp0 3)) x: 121 hide:)
				)
				(if (> temp0 1)
					((discardHand at: (- temp0 2)) x: 121 hide:)
					((discardHand at: (- temp0 1)) x: 121 show:)
				)
			)
		)
		(cond
			((and (== global261 0) local10 (> (theStock size:) 0))
				(= local10 0)
				(theStock adjust:)
			)
			((and (== global261 1) (not local10) (< 0 (theStock size:) 3))
				(theStock adjust:)
			)
		)
	)
)

(instance showThree of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(= temp0 (discardHand size:))
		(for ((= temp1 0)) (< temp1 temp0) ((++ temp1))
			((discardHand at: temp1) x: 121 hide:)
		)
		(cond
			((> temp0 2)
				((discardHand at: (- temp0 3)) show:)
				((discardHand at: (- temp0 2)) x: (+ 121 global396) show:)
				((discardHand at: (- temp0 1)) x: (+ 121 (* global396 2)) show:)
			)
			((> temp0 1)
				((discardHand at: (- temp0 2)) show:)
				((discardHand at: (- temp0 1)) x: (+ 121 global396) show:)
			)
			((== temp0 1)
				((discardHand at: (- temp0 1)) x: 121 show:)
			)
		)
	)
)

(instance spadeFound of Foundation
	(properties
		x 21
		y 6
	)
)

(instance clubFound of Foundation
	(properties
		x 21
		y 102
		foundSuit 1
	)
)

(instance diamondFound of Foundation
	(properties
		x 21
		y 151
		foundSuit 2
	)
)

(instance heartFound of Foundation
	(properties
		x 21
		y 54
		foundSuit 3
	)
)

(instance spadeView of View
	(properties
		x 21
		y 6
		view 600
	)
)

(instance clubView of View
	(properties
		x 21
		y 102
		view 600
		loop 1
	)
)

(instance diamondView of View
	(properties
		x 21
		y 151
		view 600
		loop 2
	)
)

(instance heartView of View
	(properties
		x 21
		y 54
		view 600
		loop 3
	)
)

(instance tempList of List
	(properties)
)

(class KlonHand of Hand
	(properties
		emptyColAssociatedWith 0
	)

	(method (add param1)
		(if argc
			(super add: param1 &rest)
			(param1 setPri: 2)
		else
			(super add:)
		)
	)

	(method (eliminateCard param1)
		(self delete: param1)
	)

	(method (calcNextY &tmp [temp0 3])
		(return
			(if size
				(super calcNextY:)
			else
				y
			)
		)
	)

	(method (handleEvent event &tmp [temp0 3])
		(handleCode doit: event self emptyColAssociatedWith)
	)

	(method (cue)
		(enterAdd doit: self)
		(super cue:)
	)

	(method (motionCue)
		(return 1)
	)
)

(class EmptyCol of DiscardPile
	(properties
		handAssociatedWith 0
	)

	(method (validPlay param1)
		(if (== (param1 rank:) 13)
			(return 1)
		else
			(return 0)
		)
	)

	(method (setCard param1 &tmp temp0 temp1)
		(Undoer setFrom: handAssociatedWith)
		(handAssociatedWith add: param1)
		(undoList release:)
		(param1 undoX: (param1 theBeginX:) undoY: (param1 theBeginY:) show:)
		(Undoer setObject: param1 active: 1)
		(if (param1 tailList:)
			(undoList add: param1)
			(for ((= temp0 0)) (< temp0 ((param1 tailList:) size:)) ((++ temp0))
				(= temp1 ((param1 tailList:) at: temp0))
				(handAssociatedWith add: temp1)
				(temp1
					undoX: (temp1 theBeginX:)
					undoY: (temp1 theBeginY:)
					show:
				)
				(undoList add: temp1)
			)
			(Undoer setObject: undoList)
		)
		(Piles delete: self)
		(self dispose:)
	)

	(method (cue)
		(enterAdd doit: self)
	)
)

(instance emptyCol1 of EmptyCol
	(properties
		x 58
		y 20
	)
)

(instance hand1 of KlonHand
	(properties
		x 58
		y 20
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 58
	)
)

(instance emptyCol2 of EmptyCol
	(properties
		x 92
		y 20
	)
)

(instance hand2 of KlonHand
	(properties
		x 92
		y 20
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 92
	)
)

(instance emptyCol3 of EmptyCol
	(properties
		x 126
		y 20
	)
)

(instance hand3 of KlonHand
	(properties
		x 126
		y 20
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 126
	)
)

(instance emptyCol4 of EmptyCol
	(properties
		x 160
		y 20
	)
)

(instance hand4 of KlonHand
	(properties
		x 160
		y 20
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 160
	)
)

(instance emptyCol5 of EmptyCol
	(properties
		x 194
		y 20
	)
)

(instance hand5 of KlonHand
	(properties
		x 194
		y 20
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 194
	)
)

(instance emptyCol6 of EmptyCol
	(properties
		x 228
		y 20
	)
)

(instance hand6 of KlonHand
	(properties
		x 228
		y 20
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 228
	)
)

(instance emptyCol7 of EmptyCol
	(properties
		x 262
		y 20
	)
)

(instance hand7 of KlonHand
	(properties
		x 262
		y 20
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 262
	)
)

(instance theHands of List
	(properties)
)

(instance handleEventList of EventHandler
	(properties)
)

(class KlonDealer of List
	(properties
		dealer 0
		cardsToDeal 13
		cardsAtATime 1
		dealDirection 0
		script 0
		litlCard 0
		dealerX 160
		dealerY 225
		dealTo 0
		caller 0
		curPlayer 0
		playDirection 0
	)

	(method (init param1 param2 param3 param4 param5 param6 param7)
		(super add: param1 param2 param3 param4 param5 param6 param7)
		(= dealTo (= dealer param1))
		(= curPlayer dealer)
	)

	(method (nextToPlay param1 &tmp temp0 temp1)
		(= gCrazy8sHand 0)
		(if (and argc param1)
			(= curPlayer param1)
		else
			(= temp0 (self indexOf: curPlayer))
			(= curPlayer
				(cond
					((== playDirection 0)
						(if (== temp0 (- size 1))
							(self at: 0)
						else
							(self at: (+ temp0 1))
						)
					)
					((== temp0 0)
						(self at: (- size 1))
					)
					(else
						(self at: (- temp0 1))
					)
				)
			)
		)
		(if (== (curPlayer type:) 1)
			(DisableCursor)
		)
		(Arrow setLoop: (curPlayer getLocation:))
	)

	(method (rotate &tmp temp0)
		(if (== dealDirection 0)
			(= temp0 (self at: 0))
			(self delete: temp0 add: temp0)
		else
			(= temp0 (self at: (- size 1)))
			(self delete: temp0 addToFront: temp0)
		)
		(= dealer (self at: 0))
		(= dealTo (self at: 0))
		(= curPlayer dealTo)
		(Arrow setLoop: (curPlayer getLocation:))
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (deal param1)
		(= caller (if argc param1 else 0))
		(self setScript: dealScript)
	)

	(method (setScript param1)
		(if litlCard
			(litlCard dispose:)
			(= litlCard 0)
		)
		(if (and argc param1)
			((= script param1) init: self)
		else
			(= script 0)
		)
	)

	(method (dispose)
		(self setScript: 0)
		(self release:)
		(super dispose:)
	)

	(method (nextDealTo &tmp temp0)
		(= temp0 (self indexOf: dealTo))
		(if (== dealDirection 0)
			(= dealTo
				(self
					at:
						(if (== temp0 (- size 1))
							0
						else
							(+ temp0 1)
						)
				)
			)
		else
			(= dealTo
				(self
					at:
						(if (== temp0 0)
							(- size 1)
						else
							(- temp0 1)
						)
				)
			)
		)
	)
)

(instance dealScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4)
		(switch (= state newState)
			(0
				(Undoer active: 0)
				(for ((= temp1 (- (gCast size:) 1))) (>= temp1 0) ((-- temp1))
					(if ((gCast at: temp1) isKindOf: KlonCard)
						(gCast delete: (gCast at: temp1))
					)
				)
				(DisableCursor)
				(= register 0)
				(client litlCard: (ScriptID 15 6)) ; littleCard
				((ScriptID 15 6) ; littleCard
					view: (+ 54 global384)
					posn: (client dealerX:) (client dealerY:)
					init:
				)
				(if (== global387 0)
					(for ((= temp1 0)) (< temp1 28) ((++ temp1))
						(= temp3 0)
						(if (== temp1 0)
							(= temp3 1)
						)
						(if
							(or
								(== temp1 7)
								(== temp1 13)
								(== temp1 18)
								(== temp1 22)
								(== temp1 25)
								(== temp1 27)
							)
							(= temp3 1)
							(KlonDealer delete: (KlonDealer at: 0))
						)
						((KlonDealer at: (mod temp1 (KlonDealer size:)))
							add: (= temp0 (Deck getCard:))
						)
						(temp0 setPri: 2 init: show:)
						(temp0 inPlay: 1)
						(client nextDealTo:)
					)
					(= state 2)
					(KlonDealer nextToPlay: (KlonDealer dealer:) nextToPlay:)
				)
				(= ticks 1)
			)
			(1
				((ScriptID 15 6) ; littleCard
					setMotion:
						MoveTo
						(+ ((client dealTo:) calcNextX:) 17)
						(+ ((client dealTo:) calcNextY:) 21)
						self
				)
			)
			(2
				(= temp2
					(switch global387
						(0 300)
						(1 20)
						(2 10)
					)
				)
				((ScriptID 15 6) view: (+ 54 global384) setStep: temp2 temp2) ; littleCard
				(++ register)
				((ScriptID 15 6) posn: (client dealerX:) (client dealerY:)) ; littleCard
				((client dealTo:) add: (= temp0 (Deck getCard:)))
				(temp0 inPlay: 1)
				(if
					(or
						(== register 1)
						(== register 8)
						(== register 14)
						(== register 19)
						(== register 23)
						(== register 26)
						(== register 28)
					)
					(gSound play: 903)
					(temp0 flip: 1 1)
				)
				(if
					(or
						(== register 7)
						(== register 13)
						(== register 18)
						(== register 22)
						(== register 25)
						(== register 27)
					)
					(KlonDealer delete: (KlonDealer at: 0))
				)
				(temp0 setPri: 2 show: init: 1)
				(if (!= register 28)
					(= state 0)
				)
				(client nextDealTo:)
				(= ticks 1)
			)
			(3
				(EnableCursor)
				(for ((= temp1 0)) (< temp1 (gTheHands size:)) ((++ temp1))
					(= temp3 (gTheHands at: temp1))
					((temp3 at: (- (temp3 size:) 1)) flip: 1 1 addKeyMouse:)
				)
				(gSound play: 903)
				(KlonDealer setScript: 0)
				(if (KlonDealer caller:)
					((KlonDealer caller:) cue:)
					(KlonDealer caller: 0)
				)
				(for ((= temp1 0)) (< temp1 (gDelayCast size:)) ((++ temp1))
					(gCast add: (gDelayCast at: temp1))
				)
				(gDelayCast release:)
			)
		)
	)
)

(instance undoList of List
	(properties)
)

(class Undoer of Obj
	(properties
		theObject 0
		from 0
		to 0
		active 0
	)

	(method (deleteEmptyPile param1)
		(SetDebug)
		(switch param1
			(hand1
				(Piles delete: emptyCol1)
				(emptyCol1 dispose:)
			)
			(hand2
				(Piles delete: emptyCol2)
				(emptyCol2 dispose:)
			)
			(hand3
				(Piles delete: emptyCol3)
				(emptyCol3 dispose:)
			)
			(hand4
				(Piles delete: emptyCol4)
				(emptyCol4 dispose:)
			)
			(hand5
				(Piles delete: emptyCol5)
				(emptyCol5 dispose:)
			)
			(hand6
				(Piles delete: emptyCol6)
				(emptyCol6 dispose:)
			)
			(hand7
				(Piles delete: emptyCol7)
				(emptyCol7 dispose:)
			)
		)
	)

	(method (setObject param1)
		(= theObject param1)
	)

	(method (setFrom param1)
		(= from param1)
	)

	(method (setTo param1)
		(= to param1)
	)

	(method (undoit &tmp temp0 temp1 temp2 temp3 temp4)
		(= global200 100)
		(if (theObject isMemberOf: List)
			(if (!= local14 (theObject at: 0))
				(for ((= temp4 0)) (< temp4 (gTheHands size:)) ((++ temp4))
					((gTheHands at: temp4) partner: 0)
				)
				(for ((= temp4 0)) (< temp4 (Piles size:)) ((++ temp4))
					((Piles at: temp4) condition: 0)
				)
			)
			(= local14 (theObject at: 0))
		else
			(if (!= local14 theObject)
				(for ((= temp4 0)) (< temp4 (gTheHands size:)) ((++ temp4))
					((gTheHands at: temp4) partner: 0)
				)
				(for ((= temp4 0)) (< temp4 (Piles size:)) ((++ temp4))
					((Piles at: temp4) condition: 0)
				)
			)
			(= local14 theObject)
		)
		(= global200 101)
		(if (from respondsTo: #partner)
			(from partner: 1)
		)
		(if (from respondsTo: #condition)
			(from condition: 1)
		)
		(if local9
			(undoReset doit:)
			(return 1)
		)
		(= global200 102)
		(if (from isMemberOf: Foundation)
			(= global200 90)
			(= temp1 (theObject undoX:))
			(= temp2 (theObject undoY:))
			(theObject
				undoX: (theObject x:)
				undoY: (theObject y:)
				x: temp1
				y: temp2
				priority: 2
			)
			(= global200 91)
			(cond
				((not (to size:))
					(self deleteEmptyPile: to)
				)
				((and (!= to discardHand) local24)
					(gSound play: 903)
					((to at: (- (to size:) 1)) flip: 0)
				)
			)
			(to add: theObject)
			(= global200 92)
			(switch from
				(spadeFound
					(-- local1)
					(if (== theObject (spadeFound foundUnder:))
						(spadeFound upCard: 0)
						(spadeView init:)
					else
						(spadeFound upCard: (spadeFound foundUnder:))
						((spadeFound foundUnder:) show:)
					)
				)
				(clubFound
					(-- local1)
					(if (== theObject (clubFound foundUnder:))
						(clubFound upCard: 0)
						(clubView init:)
					else
						(clubFound upCard: (clubFound foundUnder:))
						((clubFound foundUnder:) show:)
					)
				)
				(diamondFound
					(-- local1)
					(if (== theObject (diamondFound foundUnder:))
						(diamondFound upCard: 0)
						(diamondView init:)
					else
						(diamondFound upCard: (diamondFound foundUnder:))
						((diamondFound foundUnder:) show:)
					)
				)
				(heartFound
					(-- local1)
					(if (== theObject (heartFound foundUnder:))
						(heartView init:)
						(heartFound upCard: 0)
					else
						(heartFound upCard: (heartFound foundUnder:))
						((heartFound foundUnder:) show:)
					)
				)
			)
			(= global200 103)
			(cond
				((and (== to discardHand) (discardHand size:))
					(theObject inPlay: 0)
					(if (== global262 1)
						(showThree doit:)
					)
					((discardHand at: (- (discardHand size:) 1))
						setLoop: 0
						show:
					)
				)
				((not (to size:))
					(self deleteEmptyPile: to)
				)
			)
			(= global200 104)
			(Undoer active: 0)
			(return 1)
		)
		(= global200 105)
		(if (== to theStock)
			(if (theObject isMemberOf: List)
				(for ((= temp4 0)) (< temp4 (theObject size:)) ((++ temp4))
					(= temp0 (theObject at: temp4))
					(from eliminateCard: temp0)
					(temp0 inPlay: 0 hide:)
				)
				(theStock size: (+ (theStock size:) local20))
				(theStock topCard: temp0)
				(Deck topCard: local19)
			else
				(from eliminateCard: theObject)
				(theObject inPlay: 0 hide:)
				(theStock size: (+ (theStock size:) local20))
				(theStock topCard: theObject)
				(Deck topCard: local19)
			)
			(if (discardHand size:)
				(if (== global262 1)
					(showThree doit:)
				)
				((discardHand at: (- (discardHand size:) 1)) setLoop: 0 show:)
			)
			(theStock adjust:)
			(self active: 0)
			(self dispose:)
			(return 1)
		)
		(= global200 106)
		(cond
			((not (to size:))
				(self deleteEmptyPile: to)
			)
			((and (!= to discardHand) (not local16))
				(gSound play: 903)
				((to at: (- (to size:) 1)) flip:)
			)
		)
		(= global200 107)
		(if (theObject isMemberOf: List)
			(for ((= temp4 0)) (< temp4 (theObject size:)) ((++ temp4))
				(= temp0 (theObject at: temp4))
				(= temp1 (temp0 undoX:))
				(= temp2 (temp0 undoY:))
				(temp0
					undoX: (temp0 x:)
					undoY: (temp0 y:)
					x: temp1
					y: temp2
					priority: 2
				)
				(to add: temp0)
				(if (== to discardHand)
					(temp0 inPlay: 0)
				)
				(from eliminateCard: temp0)
			)
		else
			(= temp1 (theObject undoX:))
			(= temp2 (theObject undoY:))
			(theObject
				undoX: (theObject x:)
				undoY: (theObject y:)
				x: temp1
				y: temp2
				priority: 2
			)
			(to add: theObject)
			(if (== to discardHand)
				(theObject inPlay: 0)
			)
			(from eliminateCard: theObject)
		)
		(= global200 108)
		(if (and (== to discardHand) (discardHand size:))
			(if (== global262 1)
				(showThree doit:)
			)
			((discardHand at: (- (discardHand size:) 1)) setLoop: 0 show:)
		)
		(if (from size:)
			((from at: (- (from size:) 1)) setLoop: 0)
		else
			(switch from
				(hand1
					(emptyCol1 init:)
					(Piles add: emptyCol1)
				)
				(hand2
					(emptyCol2 init:)
					(Piles add: emptyCol2)
				)
				(hand3
					(emptyCol3 init:)
					(Piles add: emptyCol3)
				)
				(hand4
					(emptyCol4 init:)
					(Piles add: emptyCol4)
				)
				(hand5
					(emptyCol5 init:)
					(Piles add: emptyCol5)
				)
				(hand6
					(emptyCol6 init:)
					(Piles add: emptyCol6)
				)
				(hand7
					(emptyCol7 init:)
					(Piles add: emptyCol7)
				)
			)
		)
		(= global200 109)
		(= temp3 to)
		(self setTo: from setFrom: temp3)
		(Undoer active: 0)
		(return (self dispose:))
	)
)

(instance enterAdd of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1)
		(= local9 0)
		(Undoer setFrom: param1)
		(if (param1 isKindOf: Hand)
			(param1 add: global458)
			(undoList release:)
			(Undoer setObject: global458 active: 1)
			(global458
				undoX: (global458 theBeginX:)
				undoY: (global458 theBeginY:)
				show:
				setPri: 2
			)
			(if (global458 tailList:)
				(undoList add: global458)
				(for
					((= temp0 0))
					(< temp0 ((global458 tailList:) size:))
					((++ temp0))
					
					(= temp1 ((global458 tailList:) at: temp0))
					(param1 add: temp1)
					(temp1
						undoX: (temp1 theBeginX:)
						undoY: (temp1 theBeginY:)
						show:
					)
					(undoList add: temp1)
				)
				(Undoer setObject: undoList active: 1)
			)
		else
			(param1 setCard: global458)
			(if (== local1 52)
				(gTheIconBar disable:)
				((ScriptID 15 6) hide:) ; littleCard
				(DisableCursor)
				(endCode doit: global458)
			)
		)
		(if (and global399 (not (global399 faceUp:)))
			(gSound play: 903)
			(global399 flip: addKeyMouse:)
			(= local24 1)
		else
			(= local24 0)
		)
		((ScriptID 15 6) hide:) ; littleCard
		(global458 tailList: 0 associatedObj: 0)
		(= global395 (= global458 0))
	)
)

(instance handleCode of Code
	(properties)

	(method (doit param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp4 0)
		(return
			(if
				(and
					(not (param1 claimed:))
					(not global395)
					(= temp0 (param2 reverseFirstTrue: 165 param1))
				)
				(cond
					((not (temp0 faceUp:))
						(gSound play: 905)
						(Message msgGET 600 19 0 0 6 (local100 data:)) ; "You can't play face down cards."
						(Print
							ticks: 400
							fore: 0
							mode: 1
							addBitmap: 25 1 0
							addText: local100
							init:
						)
						(return 1)
					)
					(
						(and
							(!=
								(= temp1 (param2 indexOf: temp0))
								(- (param2 size:) 1)
							)
							(!= temp1 0)
							((param2 at: (- temp1 1)) faceUp:)
						)
						(gSound play: 905)
						(Message msgGET 600 19 0 0 7 (local100 data:)) ; "You cannot play a card in the middle. Play either the top or bottom card."
						(Print
							ticks: 400
							fore: 0
							mode: 1
							addBitmap: 25 2 0
							addText: local100
							init:
						)
						(return 1)
					)
				)
				(if (and (!= temp1 0) ((param2 at: (- temp1 1)) faceUp:))
					(= temp4 1)
				)
				(= global399 0)
				(tempList release:)
				(for
					((= temp1 (+ (param2 indexOf: temp0) 1)))
					(< temp1 (param2 size:))
					((++ temp1))
					
					(tempList add: (param2 at: temp1))
				)
				(if (tempList size:)
					(temp0 tailList: tempList)
					(temp0 associatedObj: tempList)
				)
				(if (= temp1 (param2 indexOf: temp0))
					((= global399 (param2 at: (- temp1 1))) setLoop: 0)
				)
				(switch (temp0 processEvent: param1 global399)
					(1
						(cond
							((and (not temp4) (checkHands doit: temp0))
								(param2 eliminateCard: temp0)
								(if (temp0 tailList:)
									(for
										((= temp1 0))
										(< temp1 ((temp0 tailList:) size:))
										((++ temp1))
										
										(param2
											eliminateCard:
												((temp0 tailList:) at: temp1)
										)
									)
								)
								(Undoer setTo: param2)
								(temp0 tailList: 0 associatedObj: 0)
								(= local24 0)
								(if (and global399 (not (global399 faceUp:)))
									(gSound play: 903)
									(global399 flip: addKeyMouse:)
									(= local24 1)
								)
								(if (not (param2 size:))
									(param3 init:)
									(Piles add: param3)
								)
							)
							(
								(and
									(= temp2 (Piles cardOnPile: temp0))
									(temp2 validPlay: temp0)
								)
								(Undoer setTo: param2)
								(temp2 setCard: temp0)
								(param2 eliminateCard: temp0)
								(if (temp0 tailList:)
									(for
										((= temp1 0))
										(< temp1 ((temp0 tailList:) size:))
										((++ temp1))
										
										(param2
											eliminateCard:
												((temp0 tailList:) at: temp1)
										)
									)
								)
								(temp0 tailList: 0 associatedObj: 0)
								(if (== local1 52)
									(gTheIconBar disable:)
									(DisableCursor)
									(endCode doit: temp0)
									(return 1)
								)
								(= local24 0)
								(if (and global399 (not (global399 faceUp:)))
									(gSound play: 903)
									(global399 flip: addKeyMouse:)
									(= local24 1)
								)
								(if (not (param2 size:))
									(param3 init:)
									(Piles add: param3)
								)
							)
							(else
								(if (Undoer active:)
									(= local18 1)
								)
								(Undoer active: 0)
								(if
									(and
										(temp0 tailList:)
										((temp0 tailList:) size:)
									)
									((temp0 tailList:) add: temp0)
									(temp0 cue:)
								else
									(temp0 moveBack:)
								)
							)
						)
					)
					(2
						(if (= temp3 (canPlay doit: temp0 temp4))
							(Undoer active: 0)
							(Undoer setFrom: temp3)
							(Undoer setTo: param2)
							(undoList release:)
							(Undoer setObject: temp0)
							(= global458 temp0)
							(param2
								centerY: (+ (param2 y:) (* (param2 size:) 6))
							)
							(param2 moveCard: temp3 temp3)
							(if (temp0 tailList:)
								(for
									((= temp1 0))
									(< temp1 ((temp0 tailList:) size:))
									((++ temp1))
									
									(((temp0 tailList:) at: temp1) hide:)
									(param2
										eliminateCard:
											((temp0 tailList:) at: temp1)
									)
								)
							)
							(if (not (param2 size:))
								(param3 init:)
								(Piles add: param3)
							)
						else
							(if (= temp1 (param2 indexOf: temp0))
								((= global399 (param2 at: (- temp1 1)))
									setLoop: 2
								)
							)
							(Message msgGET 600 19 0 0 1 (local100 data:)) ; "There is no legal destination for this card."
							(Print
								ticks: 400
								fore: 0
								mode: 1
								addBitmap: 25 2 0
								addText: local100
								init:
							)
						)
					)
				)
			)
		)
	)
)

