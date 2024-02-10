;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 600)
(include sci.sh)
(use Main)
(use KeyMouse)
(use Piles)
(use TrackingView)
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
	[local24 75]
)

(procedure (proc600_1 param1)
	(proc0_8 97)
	((ScriptID 680 0) doit: local0 (if argc param1 else 0)) ; scoreKlondike
	(proc0_8 0)
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
		(Message msgGET 600 19 0 0 8 @local24) ; "You can't do anything with the foundations."
		(Print addText: @local24 init:)
		(return 0)
	)

	(method (track)
		(gSound play: 905)
		(Message msgGET 600 19 0 0 8 @local24) ; "You can't do anything with the foundations."
		(Print addText: @local24 init:)
		(return 1)
	)

	(method (adjust &tmp temp0)
		(= temp0 ((ScriptID 15 1) at: (- ((ScriptID 15 1) size:) 1))) ; discardList, discardList
		(temp0 posn: origX origY show: forceUpd:)
	)

	(method (cantTake)
		(return 0)
	)

	(method (cue)
		(enterAdd doit: self)
	)

	(method (setCard param1 &tmp [temp0 2])
		(= local8 0)
		(++ local0)
		(if (== global263 1)
			(gSound2 play: 503)
		else
			(gSound2 play: 603)
		)
		(if upCard
			(= foundUnder upCard)
		else
			(foundationView dispose: forceUpd:)
			(= foundUnder param1)
		)
		(Undoer setFrom: self active: 1)
		(undoList release:)
		(Undoer setObject: param1)
		(param1 undoX: (param1 theBeginX:) undoY: (param1 theBeginY:) stopUpd:)
		(param1 deleteKeyMouse:)
		(param1 stopUpd:)
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
		style 10
	)

	(method (init)
		(= picture (+ 901 global385))
		(= local14 0)
		(= global193 600)
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
		(= local10 0)
		((= gKlondike_opt klondike_opt) doit:)
		(super init:)
		(= local17 0)
		(if local10
			(RedrawCast)
			(HandsOn)
			(gGameControls hide:)
			(= local11 (gSystemWindow back:))
			(gSystemWindow back: 53)
			((ScriptID 690 0) init:) ; optionKlondike
			(gSystemWindow back: local11)
			(HandsOff)
		)
		(if (== global262 1)
			(= local2 1)
		else
			(= local2 0)
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
		((= global117 theHands) add: hand1 hand2 hand3 hand4 hand5 hand6 hand7)
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
		(= local12 1)
		(= global402 0)
		(= local0 0)
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
		(= local14 0)
		(= global419 0)
		(= gCrazy8sSortCode 0)
		(gDelayCast release:)
		(= global458 0)
		(Piles eachElementDo: #dispose release: dispose:)
		(KlonDealer dispose:)
		((KeyMouse objList:) release:)
		(discardHand release: dispose:)
		(global117
			eachElementDo: #release
			eachElementDo: #dispose
			release:
			dispose:
		)
		(handleEventList release: dispose:)
		(Deck dispose:)
		(DisposeScript 941)
		(DisposeScript 9)
		(DisposeScript 680)
		(DisposeScript 601)
		(DisposeScript 690)
		(super dispose:)
	)
)

(instance klondike_opt of File
	(properties
		name {klondike.opt}
	)

	(method (doit param1 &tmp [temp0 20] [temp20 11])
		(cond
			((and argc (== param1 3))
				(if (self open: 2)
					(self
						writeString:
							(Format ; "%d%d%d%d"
								@temp0
								600
								0
								global261
								global262
								global263
								global264
							)
						close:
					)
					(return 1)
				else
					(return 0)
				)
			)
			((self open: 1)
				(= global261 (ReadNumber (self readString: @temp20 2)))
				(= global262 (ReadNumber (self readString: @temp20 2)))
				(= global263 (ReadNumber (self readString: @temp20 2)))
				(= global264 (ReadNumber (self readString: @temp20 2)))
				(self close:)
				(return 0)
			)
			(else
				(= global261 0)
				(= global262 0)
				(= global263 0)
				(= global264 0)
				(= local10 1)
				(return 0)
			)
		)
	)
)

(instance roomScript of Script
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(super doit: &rest)
		(if
			(and
				local14
				(== state 5)
				(not (theStock size:))
				(not (discardHand size:))
			)
			(= temp1 (- (global117 size:) 1))
			(= temp0 0)
			(while (>= temp1 0)
				(= temp2 (global117 at: temp1))
				(if (temp2 size:)
					(if ((temp2 at: 0) faceUp:)
						(+= temp0 (temp2 size:))
					else
						(= local20 0)
						(= local22 0)
						(return)
					)
				)
				(-- temp1)
			)
			(if (and temp0 (== (+ local0 temp0) 52))
				(= local20 1)
				(= local21 1)
				(if (not local22)
					(HandsOff)
					(= local22 1)
				)
			else
				(= local20 0)
				(= local22 0)
			)
			(if (and local20 (not global458))
				(= temp1 0)
				(= temp6 15)
				(while (< temp1 (global117 size:))
					(if ((global117 at: temp1) size:)
						(= temp7
							((global117 at: temp1)
								at: (- ((global117 at: temp1) size:) 1)
							)
						)
						(if (< (temp7 rank:) temp6)
							(= temp6 (temp7 rank:))
							(= temp4 temp7)
							(= temp5 (global117 at: temp1))
						)
					)
					(++ temp1)
				)
				(if (IsObject (temp4 tailList:))
					((temp4 tailList:) release:)
					(temp4 tailList: 0)
				)
				(= temp3 (canPlay doit: temp4 1))
				(if (temp3 isKindOf: Foundation)
					(if (= temp8 (temp5 indexOf: temp4))
						((= global399 (temp5 at: (- temp8 1)))
							setLoop: 0
							forceUpd:
						)
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
				(= local14 0)
				(Wait 1)
				(= ticks 1)
			)
			(1
				(= global440 0)
				(= global441 0)
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
				(= local14 0)
				(spadeFound foundUnder: 0)
				(clubFound foundUnder: 0)
				(diamondFound foundUnder: 0)
				(heartFound foundUnder: 0)
				(= local17 0)
				(= local12 1)
				(for ((= temp1 0)) (< temp1 (Deck size:)) ((++ temp1))
					((Deck at: temp1) inPlay: 0)
				)
				(= global395 0)
				(Deck shuffle:)
				(= local1 0)
				(= global243 0)
				(= local0 0)
				(KlonDealer cardsToDeal: 7 playDirection: 0 deal: self)
			)
			(5
				(= local15 0)
				(= local14 1)
				(= local21 0)
				(HandsOn)
				(resignButton init: stopUpd:)
				((KeyMouse objList:) add: resignButton)
				(handleEventList add: resignButton)
				(= local9 0)
				(= local8 0)
				(spadeView init: setPri: 2 stopUpd:)
				(clubView init: setPri: 2 stopUpd:)
				(heartView init: setPri: 2 stopUpd:)
				(diamondView init: setPri: 2 stopUpd:)
				(spadeFound init:)
				(clubFound init:)
				(heartFound init:)
				(diamondFound init:)
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
				(for ((= temp1 0)) (< temp1 (global117 size:)) ((++ temp1))
					((global117 at: temp1) partner: 0)
				)
				(for ((= temp1 0)) (< temp1 (Piles size:)) ((++ temp1))
					((Piles at: temp1) condition: 0)
				)
			)
			(6
				(= local14 0)
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
				(Animate (gCast elements:) 0)
				(= ticks 10)
			)
			(8
				(DrawPic (gCurRoom picture:))
				(Animate (gCast elements:) 0)
				(proc600_1 1)
				(if local12
					((ScriptID 680 1) doit: local0) ; scoreHand
				)
				(= local12 1)
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
			(if (IsObject ((Deck at: temp0) tailList:))
				(((Deck at: temp0) tailList:) release:)
			)
			((Deck at: temp0) tailList: 0)
		)
		(resignButton dispose:)
		(= local9 0)
		(= local8 0)
		(= local4 0)
		(global117 eachElementDo: #endHand)
		((KeyMouse objList:) release:)
		(global419 endHand:)
		(discardHand endHand:)
		(if (spadeFound upCard:)
			((spadeFound upCard:) hide: forceUpd:)
			(spadeFound upCard: 0)
		)
		(if (clubFound upCard:)
			((clubFound upCard:) hide: forceUpd:)
			(clubFound upCard: 0)
		)
		(if (diamondFound upCard:)
			((diamondFound upCard:) hide: forceUpd:)
			(diamondFound upCard: 0)
		)
		(if (heartFound upCard:)
			((heartFound upCard:) hide: forceUpd:)
			(heartFound upCard: 0)
		)
		(Piles eachElementDo: #dispose release: dispose:)
		(handleEventList release:)
		(global419 dispose:)
		(spadeView dispose: forceUpd:)
		(clubView dispose: forceUpd:)
		(heartView dispose: forceUpd:)
		(diamondView dispose: forceUpd:)
		(tempList release:)
		(undoList release:)
		(tempDiscard release:)
		(Animate (gCast elements:) 0)
		(KlonDealer delete: hand7)
		(KlonDealer dealTo: hand1)
		(DisposeScript 601)
		(KlonDealer add: hand1 hand2 hand3 hand4 hand5 hand6 hand7)
		(if global265
			(Deck sameDeck: 1)
			(= global265 0)
		)
		(if (!= local0 52)
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
					forceUpd:
					stopUpd:
				)
			)
			(self setLoop: 2)
		)
		(if (and (> (discardHand size:) 1) (== global262 0))
			(for ((= temp0 0)) (< temp0 (- (discardHand size:) 1)) ((++ temp0))
				((discardHand at: temp0) hide: stopUpd: forceUpd:)
			)
		)
		(if local17
			(Undoer active: 1)
		)
		(= local17 0)
	)

	(method (track &tmp temp0 temp1 temp2 [temp3 2] temp5 temp6 temp7)
		(self setPri: 15)
		(= temp0 (- x (gMouseCursor x:)))
		(= temp1 (- y (gMouseCursor y:)))
		(self theBeginX: x theBeginY: y)
		(if tailList
			(for ((= temp6 0)) (< temp6 (tailList size:)) ((++ temp6))
				(= temp7 (tailList at: temp6))
				(temp7 setNSRect: startUpd:)
				(temp7
					tailOffSetX: (- (temp7 x:) (gMouseCursor x:))
					tailOffSetY: (- (temp7 y:) (gMouseCursor y:))
					theBeginX: (temp7 x:)
					theBeginY: (temp7 y:)
					setPri: 15
				)
			)
		)
		(self saveData:)
		(= global189 self)
		(Animate (gAniList elements:) 0)
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
			(Animate (gAniList elements:) 0)
			(temp2 dispose:)
		)
		(= gMouseX (temp2 x:))
		(= gMouseY (temp2 y:))
		(temp2 dispose:)
		(Animate (gAniList elements:) 0)
		(gAniList release:)
		(return temp5)
	)
)

(instance discardHand of Hand
	(properties
		x 97
		y 155
		faceUp 1
		autoSorting 0
		centerX 97
		centerY 155
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
				(= temp0 (self reverseFirstTrue: 133 event))
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
					forceUpd:
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
							(= local8 0)
							(temp2 setCard: temp0)
							(Undoer setTo: self)
							(self eliminateCard: temp0)
							(if (== global262 1)
								(showThree doit:)
							)
							(if (== local0 52)
								(gTheIconBar disable:)
								(HandsOff)
								(endCode doit: temp0)
								(return 1)
							)
						)
						(else
							(if (Undoer active:)
								(= local17 1)
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
						(Message msgGET 600 19 0 0 1 @local24) ; "There is no legal destination for this card."
						(Print addText: @local24 init:)
						(if global399
							(global399 setLoop: 1)
							(if (== global262 0)
								(global399 hide: forceUpd:)
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

	(method (doit param1)
		(= local8 0)
		(switch (param1 suit:)
			(0
				(param1 posn: 6 3)
			)
			(1
				(param1 posn: 6 99)
			)
			(2
				(param1 posn: 6 148)
			)
			(3
				(param1 posn: 6 51)
			)
		)
		(Animate (gCast elements:) 0)
		(spadeActor
			view: 601
			loop: 0
			cel: 0
			x: 6
			y: 3
			priority: 15
			cycleSpeed: 6
			ignoreActors:
			init:
		)
		(clubActor
			view: 601
			loop: 1
			cel: 0
			x: 6
			y: 99
			priority: 15
			cycleSpeed: 6
			ignoreActors:
			init:
		)
		(heartActor
			view: 601
			loop: 3
			cel: 0
			x: 6
			y: 51
			priority: 15
			cycleSpeed: 6
			ignoreActors:
			init:
		)
		(diamondActor
			view: 601
			loop: 2
			cel: 0
			x: 6
			y: 148
			priority: 15
			cycleSpeed: 6
			ignoreActors:
			init:
		)
		(Animate (gCast elements:) 0)
		(Load rsSCRIPT 601)
		(cleanUp doit:)
		(roomScript changeState: 6)
	)
)

(instance canPlay of Code
	(properties)

	(method (doit param1 param2 &tmp temp0 temp1 temp2 [temp3 2] temp5 temp6 temp7 temp8)
		(= temp5 0)
		(if (not (param1 tailList:))
			(= temp0 0)
			(= temp6 1)
			(while (< temp0 (global117 size:))
				(if
					(and
						((global117 at: temp0) size:)
						(not (((global117 at: temp0) at: 0) faceUp:))
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
			(for ((= temp0 0)) (< temp0 (global117 size:)) ((++ temp0))
				(if ((global117 at: temp0) size:)
					(= temp1
						((global117 at: temp0)
							at: (- ((global117 at: temp0) size:) 1)
						)
					)
					(if
						(and
							(== (param1 rank:) (- (temp1 rank:) 1))
							(!= (param1 color:) (temp1 color:))
						)
						(= local8 0)
						(cond
							(
								(and
									(not ((global117 at: temp0) partner:))
									(!= (Undoer to:) (global117 at: temp0))
								)
								(= global200 76)
								(return (global117 at: temp0))
							)
							((not temp5)
								(= temp5 (global117 at: temp0))
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
			(for ((= temp0 0)) (< temp0 (global117 size:)) ((++ temp0))
				((global117 at: temp0) partner: 0)
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
		(for ((= temp0 0)) (< temp0 (global117 size:)) ((++ temp0))
			(if
				(and
					((global117 at: temp0) size:)
					(proc15_0
						(= temp1
							((global117 at: temp0)
								at: (- ((global117 at: temp0) size:) 1)
							)
						)
						param1
					)
					(== (param1 rank:) (- (temp1 rank:) 1))
					(!= (param1 color:) (temp1 color:))
				)
				(= local8 0)
				(Undoer setFrom: (global117 at: temp0))
				((global117 at: temp0) add: param1)
				(undoList release:)
				(Undoer setObject: param1 active: 1)
				(param1
					undoX: (param1 theBeginX:)
					undoY: (param1 theBeginY:)
					stopUpd:
				)
				(if (param1 tailList:)
					(undoList add: param1)
					(for
						((= temp2 0))
						(< temp2 ((param1 tailList:) size:))
						((++ temp2))
						
						(= temp3 ((param1 tailList:) at: temp2))
						((global117 at: temp0) add: temp3)
						(temp3
							undoX: (temp3 theBeginX:)
							undoY: (temp3 theBeginY:)
							stopUpd:
						)
						(undoList add: temp3)
					)
					(Undoer setObject: undoList active: 1)
				)
				(param1 stopUpd:)
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
		(= x 46)
		(= y 148)
		(= loop 0)
		(super init:)
	)

	(method (validPlay)
		(return 1)
	)

	(method (adjust)
		(cond
			((< 8 size 13)
				(= local9 0)
				(self setLoop: 1 posn: (+ origX 2) (+ origY 2))
				((ScriptID 15 7) ; stockBack
					view: (+ 54 global384)
					setLoop: 0
					posn: (+ origX 2) (+ origY 2)
				)
			)
			((< 4 size 9)
				(= local9 0)
				(self setLoop: 2 posn: (+ origX 4) (+ origY 4))
				((ScriptID 15 7) ; stockBack
					view: (+ 54 global384)
					setLoop: 0
					posn: (+ origX 4) (+ origY 4)
				)
			)
			((< 0 size 5)
				(if (and (== global261 1) (< size 1))
					(= local9 1)
					(self setLoop: 4 posn: (+ origX 7) (+ origY 7))
					((ScriptID 15 7) ; stockBack
						view: 600
						setLoop: 5
						posn: (+ origX 8) (+ origY 8)
					)
				else
					(= local9 0)
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
				(= local9 1)
				((ScriptID 15 7) ; stockBack
					view: 600
					setLoop: 5
					posn: (+ origX 8) (+ origY 8)
				)
			)
			(else
				(= local9 0)
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
		(HandsOff)
		(Undoer active: 0)
		(= local8 0)
		(= local16 0)
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
			(= local18 (Deck topCard:))
			(self adjust:)
			(= global395 1)
			(if (== global261 1)
				(= local16 1)
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
			(HandsOn)
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
		x 165
		y 165
		view 600
		loop 6
	)

	(method (handleEvent event)
		(if (and (!= local0 52) (super handleEvent: event))
			(event claimed: 1)
			((ScriptID 930 0) init: 913 3 gCurRoomNum) ; yesNo
			(DisposeScript 930)
			(if global461
				(handleEventList delete: self)
				(proc600_1 1)
				(if local12
					((ScriptID 680 1) doit: local0) ; scoreHand
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
				(if local16
					(= temp0 (getThree doit:))
				else
					(= temp0 (getOne doit:))
				)
				(= local16 0)
				(temp0 flip: 1 show: init: stopUpd:)
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
				(HandsOn)
			)
		)
	)
)

(instance timesThru of Code
	(properties)

	(method (doit)
		(cond
			((== global264 0)
				(Message msgGET 600 19 0 0 2 @local24) ; "You've played through the deck one time."
				(Print addText: @local24 init:)
			)
			((== global264 1)
				(if (>= (++ local1) 3)
					(Message msgGET 600 19 0 0 3 @local24) ; "You've played through the deck three times."
					(Print addText: @local24 init:)
				else
					(resetStock doit:)
				)
			)
			(else
				(= local1 0)
				(resetStock doit:)
			)
		)
	)
)

(instance getThree of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2)
		(= local8 0)
		(undoList release:)
		(= local19 0)
		(= temp1 0)
		(= temp2 0)
		(while (< temp1 3)
			(if (>= (Deck topCard:) 0)
				(= temp0 (Deck getCard:))
				(if (not (temp0 inPlay:))
					(++ local19)
					(++ temp1)
					(undoList add: (= temp2 temp0))
					(Undoer active: 1)
					(gSound play: 903)
					(temp0 flip: 1 init: stopUpd:)
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
		(= local8 0)
		(undoList release:)
		(= local19 0)
		(= temp1 0)
		(while (< temp1 1)
			(= temp0 (Deck getCard:))
			(if (not (temp0 inPlay:))
				(Undoer active: 1)
				(discardHand add: temp0)
				(++ temp1)
				(++ local19)
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
		(= local9 0)
		(= local8 1)
		(Undoer active: 1)
		(= local6 (Deck topCard:))
		(= local7 (theStock size:))
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
		(= local8 0)
		(theStock size: local7)
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
		(Deck topCard: local6)
	)
)

(instance tempDiscard of List
	(properties)
)

(instance optionCode of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(if (== param1 1)
			(if (or (KlonDealer script:) (not local14))
				(Message msgGET 600 19 0 0 4 @local24) ; "This option does nothing unless in the middle of a hand. If you want a new deal, select this option again at that time."
				(Print addText: @local24 init:)
			else
				(= local12 0)
				(cleanUp doit:)
			)
			(return 1)
		)
		(if (== param1 2)
			(if (and (Undoer active:) local14 (not local21))
				(Undoer undoit:)
			else
				(Message msgGET 600 19 0 0 5 @local24) ; "You can't undo now."
				(Print addText: @local24 init:)
			)
		)
		(= temp0 (discardHand size:))
		(cond
			((and (== global262 1) (not local2))
				(= local2 1)
				(cond
					((> temp0 2)
						((discardHand at: (- temp0 3)) x: 97 show: forceUpd:)
						((discardHand at: (- temp0 2))
							x: (+ 97 global396)
							show:
							forceUpd:
						)
						((discardHand at: (- temp0 1))
							x: (+ 97 (* global396 2))
							show:
							forceUpd:
						)
					)
					((> temp0 1)
						((discardHand at: (- temp0 2)) x: 97 show: forceUpd:)
						((discardHand at: (- temp0 1))
							x: (+ 97 global396)
							show:
							forceUpd:
						)
					)
				)
			)
			((and (== global262 0) local2)
				(= local2 0)
				(if (> temp0 2)
					((discardHand at: (- temp0 3)) x: 97 hide: forceUpd:)
				)
				(if (> temp0 1)
					((discardHand at: (- temp0 2)) x: 97 hide: forceUpd:)
					((discardHand at: (- temp0 1)) x: 97 show: forceUpd:)
				)
			)
		)
		(return
			(cond
				((and (== global261 0) local9 (> (theStock size:) 0))
					(= local9 0)
					(theStock adjust:)
				)
				((and (== global261 1) (not local9) (< 0 (theStock size:) 3))
					(theStock adjust:)
				)
			)
		)
	)
)

(instance showThree of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(= temp0 (discardHand size:))
		(for ((= temp1 0)) (< temp1 temp0) ((++ temp1))
			((discardHand at: temp1) x: 97 hide: forceUpd:)
		)
		(cond
			((> temp0 2)
				((discardHand at: (- temp0 3)) show: forceUpd:)
				((discardHand at: (- temp0 2))
					x: (+ 97 global396)
					show:
					forceUpd:
				)
				((discardHand at: (- temp0 1))
					x: (+ 97 (* global396 2))
					show:
					forceUpd:
				)
			)
			((> temp0 1)
				((discardHand at: (- temp0 2)) show: forceUpd:)
				((discardHand at: (- temp0 1))
					x: (+ 97 global396)
					show:
					forceUpd:
				)
			)
			((== temp0 1)
				((discardHand at: (- temp0 1)) x: 97 show: forceUpd:)
			)
		)
	)
)

(instance spadeFound of Foundation
	(properties
		x 6
		y 3
	)
)

(instance clubFound of Foundation
	(properties
		x 6
		y 99
		foundSuit 1
	)
)

(instance diamondFound of Foundation
	(properties
		x 6
		y 148
		foundSuit 2
	)
)

(instance heartFound of Foundation
	(properties
		x 6
		y 51
		foundSuit 3
	)
)

(instance spadeView of View
	(properties
		x 6
		y 3
		view 600
	)
)

(instance clubView of View
	(properties
		x 6
		y 99
		view 600
		loop 1
	)
)

(instance diamondView of View
	(properties
		x 6
		y 148
		view 600
		loop 2
	)
)

(instance heartView of View
	(properties
		x 6
		y 51
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
		(param1
			undoX: (param1 theBeginX:)
			undoY: (param1 theBeginY:)
			show:
			forceUpd:
			stopUpd:
		)
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
					forceUpd:
					stopUpd:
				)
				(undoList add: temp1)
				(temp1 stopUpd:)
			)
			(Undoer setObject: undoList)
		)
		(param1 stopUpd:)
		(Piles delete: self)
		(self dispose:)
	)

	(method (cue)
		(enterAdd doit: self)
	)
)

(instance emptyCol1 of EmptyCol
	(properties
		x 47
		y 7
	)
)

(instance hand1 of KlonHand
	(properties
		x 47
		y 7
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 47
	)
)

(instance emptyCol2 of EmptyCol
	(properties
		x 86
		y 7
	)
)

(instance hand2 of KlonHand
	(properties
		x 86
		y 7
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 86
	)
)

(instance emptyCol3 of EmptyCol
	(properties
		x 125
		y 7
	)
)

(instance hand3 of KlonHand
	(properties
		x 125
		y 7
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 125
	)
)

(instance emptyCol4 of EmptyCol
	(properties
		x 164
		y 7
	)
)

(instance hand4 of KlonHand
	(properties
		x 164
		y 7
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 164
	)
)

(instance emptyCol5 of EmptyCol
	(properties
		x 203
		y 7
	)
)

(instance hand5 of KlonHand
	(properties
		x 203
		y 7
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 203
	)
)

(instance emptyCol6 of EmptyCol
	(properties
		x 242
		y 7
	)
)

(instance hand6 of KlonHand
	(properties
		x 242
		y 7
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 242
	)
)

(instance emptyCol7 of EmptyCol
	(properties
		x 281
		y 7
	)
)

(instance hand7 of KlonHand
	(properties
		x 281
		y 7
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 281
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
			(HandsOff)
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
				(HandsOff)
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
						(temp0 setPri: 2 show: init: stopUpd:)
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
				(temp0 setPri: 2 show: init: 1 forceUpd: stopUpd:)
				(if (!= register 28)
					(= state 0)
				)
				(client nextDealTo:)
				(= ticks 1)
			)
			(3
				(HandsOn)
				(for ((= temp1 0)) (< temp1 (global117 size:)) ((++ temp1))
					(= temp3 (global117 at: temp1))
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
			(if (!= local13 (theObject at: 0))
				(for ((= temp4 0)) (< temp4 (global117 size:)) ((++ temp4))
					((global117 at: temp4) partner: 0)
				)
				(for ((= temp4 0)) (< temp4 (Piles size:)) ((++ temp4))
					((Piles at: temp4) condition: 0)
				)
			)
			(= local13 (theObject at: 0))
		else
			(if (!= local13 theObject)
				(for ((= temp4 0)) (< temp4 (global117 size:)) ((++ temp4))
					((global117 at: temp4) partner: 0)
				)
				(for ((= temp4 0)) (< temp4 (Piles size:)) ((++ temp4))
					((Piles at: temp4) condition: 0)
				)
			)
			(= local13 theObject)
		)
		(= global200 101)
		(if (from respondsTo: #partner)
			(from partner: 1)
		)
		(if (from respondsTo: #condition)
			(from condition: 1)
		)
		(if local8
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
				forceUpd:
				stopUpd:
			)
			(= global200 91)
			(cond
				((not (to size:))
					(self deleteEmptyPile: to)
				)
				((and (!= to discardHand) local23)
					(gSound play: 903)
					((to at: (- (to size:) 1)) flip: 0)
				)
			)
			(to add: theObject)
			(= global200 92)
			(switch from
				(spadeFound
					(-- local0)
					(if (== theObject (spadeFound foundUnder:))
						(spadeFound upCard: 0)
						(spadeView init: stopUpd:)
					else
						(spadeFound upCard: (spadeFound foundUnder:))
						((spadeFound foundUnder:) show:)
					)
				)
				(clubFound
					(-- local0)
					(if (== theObject (clubFound foundUnder:))
						(clubFound upCard: 0)
						(clubView init: stopUpd:)
					else
						(clubFound upCard: (clubFound foundUnder:))
						((clubFound foundUnder:) show:)
					)
				)
				(diamondFound
					(-- local0)
					(if (== theObject (diamondFound foundUnder:))
						(diamondFound upCard: 0)
						(diamondView init: stopUpd:)
					else
						(diamondFound upCard: (diamondFound foundUnder:))
						((diamondFound foundUnder:) show:)
					)
				)
				(heartFound
					(-- local0)
					(if (== theObject (heartFound foundUnder:))
						(heartView init: stopUpd:)
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
					(temp0 inPlay: 0 hide: forceUpd:)
				)
				(theStock size: (+ (theStock size:) local19))
				(theStock topCard: temp0)
				(Deck topCard: local18)
			else
				(from eliminateCard: theObject)
				(theObject inPlay: 0 hide: forceUpd:)
				(theStock size: (+ (theStock size:) local19))
				(theStock topCard: theObject)
				(Deck topCard: local18)
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
			((and (!= to discardHand) (not local15))
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
					forceUpd:
					stopUpd:
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
				forceUpd:
				stopUpd:
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
		(= local8 0)
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
				forceUpd:
				stopUpd:
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
						stopUpd:
						show:
						forceUpd:
					)
					(undoList add: temp1)
				)
				(Undoer setObject: undoList active: 1)
			)
		else
			(param1 setCard: global458)
			(if (== local0 52)
				(gTheIconBar disable:)
				((ScriptID 15 6) hide: forceUpd:) ; littleCard
				(HandsOff)
				(endCode doit: global458)
			)
		)
		(if (and global399 (not (global399 faceUp:)))
			(gSound play: 903)
			(global399 flip: addKeyMouse:)
			(= local23 1)
		else
			(= local23 0)
		)
		((ScriptID 15 6) hide:) ; littleCard
		(global458 tailList: 0 associatedObj: 0 stopUpd:)
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
					(= temp0 (param2 reverseFirstTrue: 133 param1))
				)
				(cond
					((not (temp0 faceUp:))
						(gSound play: 905)
						(Message msgGET 600 19 0 0 6 @local24) ; "You can't play face down cards."
						(Print addText: @local24 init:)
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
						(Message msgGET 600 19 0 0 7 @local24) ; "You cannot play a card in the middle. Play either the top or bottom card."
						(Print addText: @local24 init:)
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
					((= global399 (param2 at: (- temp1 1)))
						setLoop: 0
						forceUpd:
					)
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
								(= local23 0)
								(if (and global399 (not (global399 faceUp:)))
									(gSound play: 903)
									(global399 flip: addKeyMouse:)
									(= local23 1)
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
								(if (== local0 52)
									(gTheIconBar disable:)
									(HandsOff)
									(endCode doit: temp0)
									(return 1)
								)
								(= local23 0)
								(if (and global399 (not (global399 faceUp:)))
									(gSound play: 903)
									(global399 flip: addKeyMouse:)
									(= local23 1)
								)
								(if (not (param2 size:))
									(param3 init:)
									(Piles add: param3)
								)
							)
							(else
								(if (Undoer active:)
									(= local17 1)
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
									
									(((temp0 tailList:) at: temp1)
										hide:
										forceUpd:
									)
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
							(Message msgGET 600 19 0 0 1 @local24) ; "There is no legal destination for this card."
							(Print addText: @local24 init:)
						)
					)
				)
			)
		)
	)
)

