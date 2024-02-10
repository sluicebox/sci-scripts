;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
(include sci.sh)
(use Main)
(use KeyMouse)
(use TrackingView)
(use Character)
(use Motion)
(use Actor)
(use System)

(public
	proc15_0 0
	discardList 1
	discardScript 2
	ascendingBySuitCode 3
	descendingBySuitCode 4
	sortedList 5
	littleCard 6
	stockBack 7
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
)

(procedure (proc15_0 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
	(if (not param2)
		(return 1)
	)
	(if (and (param2 respondsTo: #scaleSignal) (& (param2 scaleSignal:) $0004))
		(= temp2 (+ (param2 x:) (param2 nsLeft:)))
		(= temp3 (+ (param2 x:) (param2 nsRight:)))
		(= temp0 (+ (param2 y:) (param2 nsTop:)))
		(= temp1 (+ (param2 y:) (param2 nsBottom:)))
	else
		(= temp2 (param2 nsLeft:))
		(= temp3 (param2 nsRight:))
		(= temp0 (param2 nsTop:))
		(= temp1 (param2 nsBottom:))
	)
	(if (and (param1 respondsTo: #scaleSignal) (& (param1 scaleSignal:) $0004))
		(= temp6 (+ (param1 x:) (param1 nsLeft:)))
		(= temp7 (+ (param1 x:) (param1 nsRight:)))
		(= temp8 (+ (param1 y:) (param1 nsTop:)))
		(= temp9 (+ (param1 y:) (param1 nsBottom:)))
	else
		(= temp6 (param1 nsLeft:))
		(= temp7 (param1 nsRight:))
		(= temp8 (param1 nsTop:))
		(= temp9 (param1 nsBottom:))
	)
	(= temp4 (+ temp2 (/ (- temp3 temp2) 2)))
	(= temp5 (+ temp0 (/ (- temp1 temp0) 2)))
	(return
		(or
			(and
				(<= temp0 temp8)
				(>= temp1 temp8)
				(<= temp2 temp6)
				(>= temp3 temp6)
			)
			(and
				(<= temp0 temp8)
				(>= temp1 temp8)
				(<= temp2 temp7)
				(>= temp3 temp7)
			)
			(and
				(<= temp0 temp9)
				(>= temp1 temp9)
				(<= temp2 temp6)
				(>= temp3 temp6)
			)
			(and
				(<= temp0 temp9)
				(>= temp1 temp9)
				(<= temp2 temp7)
				(>= temp3 temp7)
			)
			(and
				(>= temp0 temp8)
				(<= temp1 temp9)
				(or
					(and (<= temp2 temp6) (>= temp3 temp6))
					(and (<= temp2 temp7) (>= temp3 temp7))
					(and (>= temp2 temp6) (<= temp3 temp7))
				)
			)
			(and
				(>= temp2 temp6)
				(<= temp3 temp7)
				(or
					(and (<= temp0 temp8) (>= temp1 temp8))
					(and (<= temp0 temp9) (>= temp1 temp9))
					(and (>= temp0 temp8) (<= temp1 temp9))
				)
			)
			(and (<= temp6 temp4 temp7) (<= temp8 temp5 temp9))
		)
	)
)

(procedure (localproc_0 param1 &tmp temp0)
	(return
		(cond
			((== (= temp0 (param1 suit:)) [global390 0]) 0)
			((== temp0 [global390 1]) 100)
			((== temp0 [global390 2]) 200)
			(else 300)
		)
	)
)

(instance workngDeck of List
	(properties)
)

(class Piles of List
	(properties)

	(method (cardOnPile param1 &tmp temp0)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(if ((self at: temp0) checkCard: param1)
				(return (self at: temp0))
			)
		)
		(return 0)
	)
)

(class Card of View
	(properties
		scaleSignal 4
		rank 0
		suit 0
		faceUp 0
		offsetX 4
		offsetY 20
		valid 0
		owner 0
		associatedObj 0
		partialLoop 0
	)

	(method (setLoop param1 param2)
		(if (and (>= argc 2) param2)
			(= local0 partialLoop)
		)
		(= partialLoop param1)
		(super setLoop: 0)
		(self setNSRect:)
	)

	(method (dispose)
		(super dispose:)
		(self delete:)
	)

	(method (setNSRect)
		(switch partialLoop
			(0
				(self nsLeft: 0 nsTop: 0 nsRight: 35 nsBottom: 43)
			)
			(1
				(self nsLeft: 0 nsTop: 0 nsRight: 8 nsBottom: 43)
			)
			(2
				(self nsLeft: 0 nsTop: 0 nsRight: 35 nsBottom: 8)
			)
			(3
				(self nsLeft: 0 nsTop: 0 nsRight: 16 nsBottom: 43)
			)
			(4
				(self nsLeft: 0 nsTop: 0 nsRight: 35 nsBottom: 16)
			)
		)
	)

	(method (init param1 &tmp temp0)
		(= partialLoop 0)
		(self setNSRect:)
		(super init: &rest)
		(if (and argc param1)
			(= temp0 0)
			(if (and local7 (not (gCast contains: local7)))
				(= temp0 1)
				(gCast add: local7)
			)
			(Animate (gCast elements:) 1)
			(if temp0
				(gCast delete: local7)
				(= local7 0)
			)
			(if
				(or
					(not (IsObject owner))
					(not (IsObject (owner owner:)))
					(not (proc15_0 (owner owner:) self))
				)
				(gDelayCast add: self)
				(gCast delete: self)
			)
		)
	)

	(method (doit)
		(self setNSRect:)
		(super doit:)
	)

	(method (saveData)
		(= local1 x)
		(= local2 y)
		(= local3 view)
		(= local4 cel)
		(= local5 signal)
	)

	(method (addKeyMouse)
		((KeyMouse objList:) add: self)
	)

	(method (deleteKeyMouse)
		((KeyMouse objList:) delete: self)
	)

	(method (track &tmp temp0 temp1 temp2 [temp3 2] temp5 temp6)
		(if associatedObj
			(if (associatedObj isKindOf: Collect)
				(for ((= temp6 0)) (< temp6 (associatedObj size:)) ((++ temp6))
					(gAniList add: (associatedObj at: temp6))
				)
			else
				(gAniList add: associatedObj)
			)
		)
		(= global291 priority)
		(self setPri: 14)
		(= temp0 (- x (gMouseCursor x:)))
		(= temp1 (- y (gMouseCursor y:)))
		(self saveData:)
		(self setLoop: 0 1)
		(= global189 self)
		(gAniList add: self)
		(if (gAbsoluteCast size:)
			(for ((= temp6 0)) (< temp6 (gAbsoluteCast size:)) ((++ temp6))
				(gAniList add: (gAbsoluteCast at: temp6))
			)
		)
		(= local5 signal)
		(Animate (gAniList elements:) 0)
		(= temp5 1)
		(while (!= evMOUSERELEASE ((= temp2 (Event new:)) type:))
			(= gGameTime (+ gTickOffset (GetTime)))
			(= gMouseX (temp2 x:))
			(= gMouseY (temp2 y:))
			(self x: (+ (temp2 x:) temp0) y: (+ (temp2 y:) temp1))
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

	(method (processEvent param1 &tmp temp0)
		(cond
			((& (param1 type:) $0001)
				(self startUpd:)
				(if (IsObject owner)
					(if (IsObject (owner owner:))
						(gAniList add: (owner owner:))
					)
					(for ((= temp0 0)) (< temp0 (owner size:)) ((++ temp0))
						(gAniList add: (owner at: temp0))
					)
				)
				(return (self track:))
			)
			((IsEnter param1)
				(return (self flash:))
			)
		)
		(= global189 0)
		(return 0)
	)

	(method (flash)
		(= global189 self)
		(return 2)
	)

	(method (moveBack param1 param2 param3 &tmp temp0)
		(self hide:)
		(= temp0
			(switch global387
				(0 300)
				(1 20)
				(2 10)
			)
		)
		(gSound play: 906)
		(gTheCard1
			view: view
			setLoop: 0
			cel: cel
			posn: x y
			setStep: temp0 temp0
			setPri: 14
			moveSpeed: 0
			ignoreActors:
			ignoreHorizon:
			setMotion:
				MoveTo
				(if argc param1 else local1)
				(if argc param2 else local2)
				(if argc param3 else self)
			show:
			init:
		)
		(= global395 1)
	)

	(method (flip param1 param2)
		(cond
			((and argc param1)
				(self
					view: (+ 50 (mod suit 4))
					cel: (if (== rank 14) 1 else rank)
					faceUp: 1
				)
			)
			((and argc (not param1))
				(self view: (+ 54 global384) cel: 0 faceUp: 0)
			)
			(faceUp
				(self view: (+ 54 global384) cel: 0 faceUp: 0)
			)
			(else
				(self
					view: (+ 50 (mod suit 4))
					cel: (if (== rank 14) 1 else rank)
					faceUp: 1
				)
			)
		)
		(if (or (<= argc 1) param2)
			(self forceUpd:)
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp0 0)
		(if (not (event claimed:))
			(= temp1 (+ y nsTop))
			(= temp2 (+ x nsLeft))
			(if owner
				(= temp5 (== (owner indexOf: self) (- (owner size:) 1)))
				(if (or (== global394 5) (== global394 6))
					(= temp5 1)
				)
				(switch (owner handDirection:)
					(1
						(if temp5
							(= temp3 (+ y (- nsBottom 1)))
							(= temp4 (+ x (- nsRight 1)))
						else
							(= temp3 (+ y (- nsBottom 1)))
							(= temp4 (+ x nsLeft (- global396 1)))
						)
					)
					(2
						(if temp5
							(= temp3 (+ y (- nsBottom 1)))
							(= temp4 (+ x (- nsRight 1)))
						else
							(= temp3 (+ y nsTop (- global397 1)))
							(= temp4 (+ x (- nsRight 1)))
						)
					)
				)
				(if
					(and
						(<= temp2 (event x:) temp4)
						(<= temp1 (event y:) temp3)
					)
					(cond
						((IsEnter event)
							(event claimed: 1)
							(= temp0 1)
						)
						((& (event type:) evMOUSEBUTTON)
							(event claimed: 1)
							(= temp0 1)
						)
					)
				)
			)
		)
		(if temp0 self else 0)
	)

	(method (cue)
		(gTheCard1 hide:)
		(self
			posn: local1 local2
			setLoop: local0
			setPri: global291
			show:
			forceUpd:
			stopUpd:
		)
		(if global399
			(global399 setLoop: (owner handDirection:) forceUpd:)
			(= global399 0)
		)
		(gSound play: 907)
		(= global395 0)
	)
)

(class Deck of Set
	(properties
		sameDeck 0
		topCard 51
	)

	(method (init param1 param2 &tmp temp0 temp1 temp2)
		(= temp1 (if (and argc (IsObject param1)) param1 else Card))
		(if (not size)
			(for ((= temp0 4)) (< temp0 56) ((++ temp0))
				(if (or (<= argc 1) (not param2) (< temp0 8) (>= temp0 36))
					(= temp2 (mod temp0 4))
					(if (and (== global193 700) (not temp2))
						(= temp2 4)
					)
					(self
						add:
							((temp1 new:)
								rank: (/ temp0 4)
								suit: temp2
								view: (+ 50 (mod temp0 4))
								setLoop: 0
								cel: (/ temp0 4)
								setPri: 2
								ignoreActors:
								yourself:
							)
					)
				)
			)
			(self shuffle:)
		)
	)

	(method (shuffle &tmp [temp0 2] temp2 temp3)
		(self eachElementDo: #flip 0 0)
		(= topCard (- size 1))
		(if sameDeck
			(= sameDeck 0)
			(return)
		)
		(for ((= temp3 0)) (<= temp3 (+ 2 (Random 0 4))) ((++ temp3))
			(while (>= (- size 1) 0)
				(= temp2 (self at: (Random 0 (- size 1))))
				(workngDeck add: temp2)
				(self delete: temp2)
			)
			(while (>= (- (workngDeck size:) 1) 0)
				(= temp2 (workngDeck at: (Random 0 (- (workngDeck size:) 1))))
				(self add: temp2)
				(workngDeck delete: temp2)
			)
		)
		(workngDeck dispose:)
		(self eachElementDo: #setLoop 0)
	)

	(method (getCard)
		(self at: (+ (-- topCard) 1))
	)

	(method (shuffling &tmp temp0 temp1)
		(if (and size (> topCard 1) (not sameDeck))
			(= temp0 (self at: (= temp1 (Random 0 topCard))))
			(self delete: temp0 addAfter: (self at: (- temp1 1)) temp0)
		)
	)

	(method (rankAces param1 &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(= temp1 (self at: temp0))
			(if (or (== (temp1 rank:) 1) (== (temp1 rank:) 14))
				(temp1 rank: param1)
			)
		)
	)

	(method (newBacks &tmp temp0 temp1 temp2)
		(if size
			(= temp1
				(or
					(== gCurRoomNum 100) ; crazy8s
					(== gCurRoomNum 200) ; oldMaid
					(== gCurRoomNum 300) ; heartsGame
					(== gCurRoomNum 400) ; ginRummy
					(== gCurRoomNum 500) ; cribbage
					(== gCurRoomNum 600) ; klondike
					(== gCurRoomNum 700) ; bridge
					(== gCurRoomNum 800) ; euchre
				)
			)
			(HandsOff)
			(for ((= temp0 0)) (< temp0 size) ((++ temp0))
				(= temp2 (self at: temp0))
				(if (not (temp2 faceUp:))
					(temp2 view: (+ 54 global384))
					(if temp1
						(temp2 forceUpd:)
					)
				)
			)
			(if global419
				(global419 newBacks:)
			)
			(RedrawCast)
			(HandsOn)
		)
	)
)

(class Arrow of View
	(properties
		x 275
		y 157
		view 214
		loop 3
		priority 3
		active 1
	)

	(method (init)
		(if active
			(self
				setLoop: loop
				ignoreActors:
				setPri: priority
				posn: x y
				stopUpd:
			)
			(super init:)
		)
	)

	(method (setLoop)
		(if active
			(super setLoop: &rest)
		)
	)

	(method (endHand)
		(self dispose:)
	)
)

(class Dealer of List
	(properties
		dealer 0
		cardsToDeal 13
		cardsAtATime 1
		dealDirection 0
		script 0
		litlCard 0
		dealerX 0
		dealerY 0
		dealTo 0
		caller 0
		curPlayer 0
		playDirection 0
	)

	(method (init param1 param2 param3 param4)
		(super add: param1 param2)
		(if (> argc 2)
			(super add: param3)
			(if (> argc 3)
				(super add: param4)
			)
		)
		(= dealer param1)
		(= dealTo param2)
		(= curPlayer dealer)
		(self nextToPlay:)
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
		(= dealTo (self at: 1))
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
			(litlCard hide:)
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

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(for ((= temp1 (- (gCast size:) 1))) (>= temp1 0) ((-- temp1))
					(if ((gCast at: temp1) isKindOf: Card)
						(gCast delete: (gCast at: temp1))
					)
				)
				(HandsOff)
				(= register 0)
				(switch ((client at: 0) location:)
					(1
						(client dealerX: 160 dealerY: -40)
					)
					(3
						(client dealerX: 160 dealerY: 220)
					)
					(2
						(client dealerX: 340 dealerY: 100)
					)
					(4
						(client dealerX: -40 dealerY: 100)
					)
				)
				(client litlCard: littleCard)
				(littleCard
					view: (+ 54 global384)
					posn: (client dealerX:) (client dealerY:)
					init:
				)
				(if (== global387 0)
					(for
						((= temp1 0))
						(< temp1 (* (Dealer cardsToDeal:) (Dealer size:)))
						((++ temp1))
						
						((Dealer at: (mod temp1 (Dealer size:)))
							add: (= temp0 (Deck getCard:))
						)
						(temp0
							flip:
								((Dealer at: (mod temp1 (Dealer size:)))
									faceUp:
								)
							setPri: 2
							show:
							init:
							stopUpd:
						)
						(client nextDealTo:)
					)
					(= state 2)
					(Dealer nextToPlay: (Dealer dealer:) nextToPlay:)
				)
				(= ticks 1)
			)
			(1
				(gSound play: 902)
				(cond
					((& (littleCard signal:) $0080)
						(if global387
							(littleCard show:)
						)
					)
					((not global387)
						(littleCard hide:)
					)
				)
				(if global387
					(littleCard
						setMotion:
							MoveTo
							(+ ((client dealTo:) calcNextX:) 17)
							(+ ((client dealTo:) calcNextY:) 21)
							self
					)
				else
					(= ticks 1)
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
				(littleCard view: (+ 54 global384) setStep: temp2 temp2)
				(++ register)
				(if global387
					(littleCard posn: (client dealerX:) (client dealerY:))
				)
				((client dealTo:) add: (= temp0 (Deck getCard:)))
				(temp0
					flip: ((client dealTo:) faceUp:)
					setPri: 2
					show:
					init: 1
					stopUpd:
				)
				(if (!= register (* (client size:) (client cardsToDeal:)))
					(= state 0)
				)
				(client nextDealTo:)
				(= ticks 1)
			)
			(3
				(Dealer setScript: 0)
				(if (Dealer caller:)
					((Dealer caller:) cue:)
					(Dealer caller: 0)
				)
				(if (gDelayCast size:)
					(for ((= temp1 0)) (< temp1 (gDelayCast size:)) ((++ temp1))
						(gCast add: (gDelayCast at: temp1))
					)
					(gDelayCast release:)
				)
			)
		)
	)
)

(class Hand of EventHandler
	(properties
		owner 0
		x 0
		y 0
		adjustedX 0
		adjustedY 0
		handDirection 1
		type 0
		handNumber 0
		faceUp 0
		location 3
		total 0
		prevTotal 0
		handTotal 0
		tempTotal 0
		autoSorting 1
		module 0
		centerX 0
		centerY 0
		partner 0
	)

	(method (newBacks)
		(return 1)
	)

	(method (moveCard param1 param2)
		(= global395 1)
		(gSound play: 903)
		(littleCard
			posn: centerX centerY
			show:
			init:
			setMotion:
				MoveTo
				(+ (param1 calcNextX:) 17)
				(+ (param1 calcNextY:) 21)
				(if (>= argc 2) param2 else self)
		)
		(global458 hide:)
		(self eliminateCard: global458)
	)

	(method (eliminateCard param1)
		(self delete: param1)
		(if (and autoSorting faceUp)
			(self sort:)
		else
			(self posn:)
		)
	)

	(method (couldPlay)
		(return 1)
	)

	(method (cue)
		(littleCard dispose:)
		(gSound play: 907)
	)

	(method (calcScore)
		(= handTotal tempTotal)
		(= total (+ (= prevTotal total) handTotal))
	)

	(method (endHand)
		(self eachElementDo: #hide eachElementDo: #deleteKeyMouse release:)
	)

	(method (getLocation)
		(return location)
	)

	(method (think)
		(return 1)
	)

	(method (reverseFirstTrue param1 &tmp temp0 temp1)
		(for ((= temp0 (- size 1))) (>= temp0 0) ((-- temp0))
			(= temp1 (self at: temp0))
			(if (temp1 param1: &rest)
				(return temp1)
			)
		)
		(return 0)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(if
			(and
				(not (event claimed:))
				(not global395)
				(= temp0 (self reverseFirstTrue: 133 event))
			)
			(if (or (== (Dealer curPlayer:) self) (== owner -1))
				(= global399 0)
				(if (and (!= handDirection 3) (= temp1 (self indexOf: temp0)))
					(= global399 (self at: (- temp1 1)))
					(if (& (event type:) evMOUSEBUTTON)
						(global399
							setLoop:
								(if (== temp1 (- size 1))
									0
								else
									(+ 2 handDirection)
								)
							forceUpd:
						)
					)
				)
				(switch (temp0 processEvent: event global399)
					(1
						(cond
							((= temp2 (Piles cardOnPile: temp0))
								(if (temp2 validPlay: temp0 self)
									(temp2 setCard: temp0)
									(self eliminateCard: temp0)
									(= global395 0)
									(temp2 doCode: temp0 self)
								else
									(temp0 moveBack:)
								)
							)
							((and gTray (== (temp0 owner:) gTray))
								(gTray eliminateCard: temp0)
								(= global458 temp0)
								(temp0
									moveBack:
										((Dealer curPlayer:) calcNextX:)
										((Dealer curPlayer:) calcNextY:)
										gTray
								)
								(gTray posn:)
							)
							(else
								(temp0 moveBack:)
							)
						)
					)
					(2
						(self enterKey: temp0 global399)
					)
				)
			else
				(gSound play: 904)
				(if owner
					(owner say: 15 0 46)
				else
					(Characters say: 15 0 47)
				)
			)
		)
	)

	(method (enterKey)
		(return 1)
	)

	(method (calcNextX &tmp temp0 temp1 temp2)
		(return
			(cond
				(size
					(= temp0 (self at: (- size 1)))
					(if (== handDirection 1)
						(+ (temp0 x:) global396)
					else
						(temp0 x:)
					)
				)
				((or (== handDirection 1) (== handDirection 3))
					(= temp1 (+ (* (- (Dealer cardsToDeal:) 1) global396) 35))
					(= temp2 0)
					(if (!= temp1 131)
						(= temp2 (+ x (/ (- 131 temp1) 2)))
					else
						(= temp2 x)
					)
				)
				(else x)
			)
		)
	)

	(method (calcNextY &tmp temp0 temp1 temp2)
		(return
			(cond
				(size
					(= temp0 (self at: (- size 1)))
					(if (== handDirection 1)
						(temp0 y:)
					else
						(+ (temp0 y:) global397)
					)
				)
				((== handDirection 2)
					(= temp1 (+ (* (- (Dealer cardsToDeal:) 1) global397) 43))
					(= temp2 0)
					(if (!= temp1 139)
						(= temp2 (+ y (/ (- 139 temp1) 2)))
					else
						(= temp2 y)
					)
				)
				(else y)
			)
		)
	)

	(method (add param1 param2 param3 param4)
		(= local7 0)
		(if argc
			(if size
				(= local7 (self at: (- size 1)))
				(if (!= handDirection 3)
					(local7 setLoop: handDirection forceUpd:)
				)
			)
			(super
				add:
					(param1
						posn: (self calcNextX:) (self calcNextY:)
						setLoop: 0
						owner: (if (and (>= argc 4) param4) param4 else self)
						forceUpd:
						yourself:
					)
			)
			(if (and (>= argc 2) param2)
				(self sort: (if (>= argc 3) param3 else 0))
			)
		else
			(super add:)
		)
	)

	(method (center &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp4 0)
		(= temp5 0)
		(cond
			((== handDirection 3)
				(return)
			)
			((== handDirection 1)
				(if (!= (= temp2 (+ (* global396 (- size 1)) 35)) 131)
					(= temp4 (/ (- 131 temp2) 2))
				)
			)
			(
				(and
					(== handDirection 2)
					(!= (= temp3 (+ (* global397 (- size 1)) 43)) 139)
				)
				(= temp5 (/ (- 139 temp3) 2))
			)
		)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(= temp1 (self at: temp0))
			(temp1 posn: (+ (temp1 x:) temp4) (+ (temp1 y:) temp5))
		)
	)

	(method (posn &tmp temp0)
		(cond
			((== handDirection 3)
				(self matrix:)
				(return)
			)
			((== handDirection 1)
				(= adjustedX
					(+
						x
						(-
							(+ (* (- size 1) global396) 35)
							(+ (* (- size 1) global396) 35)
						)
					)
				)
				(= adjustedY y)
				(for ((= temp0 0)) (< temp0 size) ((++ temp0))
					((self at: temp0)
						posn: (+ adjustedX (* temp0 global396)) adjustedY
						setLoop: (if (< temp0 (- size 1)) 1 else 0)
						forceUpd:
					)
				)
			)
			((== handDirection 2)
				(= adjustedX x)
				(= adjustedY
					(+
						y
						(-
							(+ (* (- size 1) global397) 43)
							(+ (* (- size 1) global397) 43)
						)
					)
				)
				(for ((= temp0 0)) (< temp0 size) ((++ temp0))
					((self at: temp0)
						posn: adjustedX (+ adjustedY (* temp0 global397))
						setLoop: (if (< temp0 (- size 1)) 2 else 0)
						forceUpd:
					)
				)
			)
		)
		(self center:)
		(= global399 0)
	)

	(method (matrix &tmp temp0)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(= adjustedX (+ x (* (- ((self at: temp0) rank:) 1) global396)))
			(= adjustedY
				(switch ((self at: temp0) suit:)
					(3
						(- y (* global397 3))
					)
					(1
						(- y (* global397 2))
					)
					(2
						(- y global397)
					)
					(0 y)
				)
			)
			(switch ((self at: temp0) suit:)
				(3
					((self at: temp0) setPri: 3)
				)
				(1
					((self at: temp0) setPri: 4)
				)
				(2
					((self at: temp0) setPri: 5)
				)
				(0
					((self at: temp0) setPri: 6)
				)
			)
			((self at: temp0) posn: adjustedX adjustedY setLoop: 0 forceUpd:)
		)
	)

	(method (sort param1)
		(if (and (not (Dealer script:)) (or faceUp (and argc param1)))
			(switch global394
				(1
					(Sorts self sortedList ascendingCode)
				)
				(2
					(Sorts self sortedList descendingCode)
				)
				(3
					(Sorts self sortedList ascendingBySuitCode)
				)
				(4
					(Sorts self sortedList descendingBySuitCode)
				)
				(5
					(Sorts self sortedList ascendingBySuitCode)
				)
				(6
					(Sorts self sortedList descendingBySuitCode)
				)
				(else
					(self posn:)
					(return)
				)
			)
			(self update: gCrazy8sSortCode)
		)
	)

	(method (update &tmp temp0)
		(self release:)
		(for ((= temp0 0)) (< temp0 (sortedList size:)) ((++ temp0))
			(self add: (sortedList at: temp0))
		)
		(sortedList release: dispose:)
		(if gCrazy8sSortCode
			(gCrazy8sSortCode doit: self)
		)
		(self posn:)
	)
)

(instance sortedList of List
	(properties)
)

(instance ascendingCode of Code
	(properties)

	(method (doit param1)
		(param1 rank:)
	)
)

(instance descendingCode of Code
	(properties)

	(method (doit param1)
		(return (- (param1 rank:)))
	)
)

(instance ascendingBySuitCode of Code
	(properties)

	(method (doit param1)
		(return (+ (localproc_0 param1) (param1 rank:)))
	)
)

(instance descendingBySuitCode of Code
	(properties)

	(method (doit param1)
		(return (- (localproc_0 param1) (param1 rank:)))
	)
)

(instance littleCard of Actor
	(properties)

	(method (init &tmp temp0)
		(= temp0
			(switch global387
				(0 300)
				(1 20)
				(2 10)
			)
		)
		(self
			view: (+ 54 global384)
			setLoop: 1
			moveSpeed: 0
			setPri: 14
			setCycle: Fwd
			setStep: temp0 temp0
			ignoreActors:
			show:
		)
		(super init:)
	)
)

(class DiscardPile of TrackingView
	(properties
		priority 2
		discardOnly 1
		client 0
		recentClient 0
		upCard 0
		takeCondition 0
		origX 0
		origY 0
		condition 0
		conditionSet 0
		emptyLoop 4
	)

	(method (enterKey)
		(super enterKey:)
	)

	(method (isValid)
		(return 1)
	)

	(method (calcNextX)
		(return x)
	)

	(method (calcNextY)
		(return y)
	)

	(method (endHand)
		(discardList eachElementDo: #hide release:)
		(self dispose:)
	)

	(method (init)
		(= global116 0)
		(discardList add:)
		(self
			view: 915
			setLoop: 4
			cel: 1
			posn: x y
			origX: x
			origY: y
			setPri: priority
			ignoreActors:
			stopUpd:
		)
		(= associatedObj (= upCard 0))
		(super init:)
	)

	(method (setCondition param1 param2)
		(= condition param1)
		(= conditionSet (if (>= argc 2) param2 else 1))
	)

	(method (doCode)
		(return 1)
	)

	(method (handleEvent event)
		(if (and (not global395) (super handleEvent: event))
			(event claimed: 1)
			(cond
				(discardOnly
					(self cantTake: 0)
				)
				((and (discardList size:) (not takeCondition))
					(self getCard:)
				)
				(else
					(self cantTake: takeCondition)
				)
			)
		)
	)

	(method (cantTake param1)
		(gSound play: 905)
		(if (not param1)
			(Message msgGET 15 19 0 0 1 @global550) ; "You cannot take cards from the Discard Pile."
			(Characters say: -1 @global550)
		else
			(Message msgGET 15 20 0 0 1 @global550) ; "You cannot take cards from the Discard Pile at this time."
			(Characters say: -1 @global550)
		)
	)

	(method (getCard param1 param2)
		(= local6 (if (>= argc 2) param2 else 0))
		(littleCard view: (+ 54 global384) posn: (+ x 18) (+ y 22) init:)
		(= recentClient
			(if (and argc (IsObject param1))
				param1
			else
				(Dealer curPlayer:)
			)
		)
		(= global395 1)
		(= global116 0)
		(gSound play: 903)
		(littleCard
			setMotion:
				MoveTo
				(+ (recentClient calcNextX:) 17)
				(+ (recentClient calcNextY:) 21)
				self
		)
		(discardList delete: (= global458 upCard))
		(global458 hide:)
		(if (discardList size:)
			(= upCard (discardList at: (- (discardList size:) 1)))
		else
			(= upCard 0)
		)
		(= associatedObj upCard)
		(self adjust:)
	)

	(method (cue &tmp temp0)
		(self setScript: discardScript local6 recentClient)
	)

	(method (setCard param1 &tmp temp0)
		(if upCard
			(upCard hide:)
		)
		(= associatedObj (= upCard param1))
		(associatedObj flip: 1 setLoop: 0 setPri: 2 stopUpd: show: forceUpd:)
		(discardList add: param1)
		(self adjust:)
		(= global116 0)
	)

	(method (adjust &tmp temp0)
		(= temp0 (discardList at: (- (discardList size:) 1)))
		(cond
			((< 8 (discardList size:) 13)
				(self setLoop: 1 posn: (- origX 5) (- origY 5))
				(temp0 posn: (- origX 5) (- origY 5) show:)
			)
			((< 4 (discardList size:) 9)
				(self setLoop: 2 posn: (- origX 3) (- origY 3))
				(temp0 posn: (- origX 3) (- origY 3) show:)
			)
			((< 0 (discardList size:) 5)
				(self setLoop: 3 posn: (- origX 1) (- origY 1))
				(temp0 posn: (- origX 1) (- origY 1) show:)
			)
			((== (discardList size:) 0)
				(self setLoop: emptyLoop posn: origX origY)
			)
			(else
				(self setLoop: 0 posn: (- origX 7) (- origY 7))
				(temp0 posn: (- origX 7) (- origY 7) show:)
			)
		)
	)

	(method (validPlay)
		(return 1)
	)

	(method (checkCard param1)
		(if (not takeCondition)
			(return (proc15_0 self param1))
		else
			(self cantTake: takeCondition)
			(return 0)
		)
	)

	(method (dispose)
		(discardList eachElementDo: #setLoop 0 release: dispose:)
		(super dispose:)
	)
)

(instance discardList of List
	(properties)
)

(instance discardScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= ticks 1)
			)
			(1
				(register add: global458)
				(global458 flip: (register faceUp:) init: show: stopUpd:)
				(if (and (global458 owner:) (== ((global458 owner:) type:) 0))
					(global458 addKeyMouse:)
				)
				(= global458 (= global395 0))
				(littleCard hide:)
				(gSound play: 907)
				(register posn:)
				(= ticks 1)
			)
			(2
				(if caller
					(caller cue:)
				)
				(= caller 0)
			)
		)
	)
)

(class Stock of TrackingView
	(properties
		x 115
		y 71
		view 915
		priority 2
		active 1
		client 0
		recentClient 0
		origX 0
		origY 0
		emptyLoop 5
		theDiscardPile 0
		cardsTaken 0
		size 0
		topCard 0
		cardsTakenThisTurn 0
	)

	(method (enterKey)
		(super enterKey:)
	)

	(method (validPlay)
		((Dealer curPlayer:) couldPlay:)
	)

	(method (endHand)
		(self dispose:)
		(stockBack dispose:)
		(if (IsObject topCard)
			(topCard hide:)
			(discardList add: topCard)
		)
		(= topCard 0)
	)

	(method (init)
		(= global116 0)
		(self
			setLoop: loop
			posn: x y
			origX: x
			origY: y
			setPri: priority
			show:
			ignoreActors:
			stopUpd:
		)
		(stockBack
			view: (+ 54 global384)
			setLoop: 0
			posn: x y
			setPri: (- priority 1)
			ignoreActors:
			stopUpd:
			show:
			init:
		)
		(= cardsTakenThisTurn 0)
		(= associatedObj stockBack)
		(= size (Deck topCard:))
		(= global419 self)
		(super init:)
	)

	(method (handleEvent event)
		(if (and (not global395) (super handleEvent: event))
			(event claimed: 1)
			(if active
				(if (self validPlay:)
					(self getCard:)
				else
					(self cantTake:)
				)
			else
				(self notActive:)
			)
		)
		(event claimed:)
	)

	(method (cantTake)
		(return 1)
	)

	(method (notActive)
		(gSound play: 904)
		(Characters say: 15 0 48)
	)

	(method (flip param1)
		(if param1
			(stockBack hide:)
			(= topCard (Deck getCard:))
			(topCard
				view: (+ 50 (topCard suit:))
				cel:
					(if (== (topCard rank:) 14)
						1
					else
						(topCard rank:)
					)
				faceUp: 1
				setLoop: 0
				posn: x y
				setPri: (- priority 1)
				ignoreActors:
				stopUpd:
				show:
				init:
			)
			(= associatedObj topCard)
		else
			(Deck add: topCard)
			(Deck topCard: (+ (Deck topCard:) 1))
			(topCard hide:)
			(= topCard 0)
			(stockBack
				view: (+ 54 global384)
				setLoop: 0
				posn: x y
				setPri: (- priority 1)
				ignoreActors:
				stopUpd:
				show:
				init:
			)
			(= associatedObj stockBack)
		)
	)

	(method (getCard)
		(if (>= size 0)
			(++ cardsTaken)
			(++ cardsTakenThisTurn)
			(littleCard view: (+ 54 global384) posn: (+ x 18) (+ y 22) init:)
			(if argc
				(self flash:)
			)
			(cond
				((< 8 size 13)
					(self setLoop: 1 posn: (+ origX 2) (+ origY 2))
					(stockBack
						view: (+ 54 global384)
						setLoop: 0
						posn: (+ origX 2) (+ origY 2)
					)
				)
				((< 4 size 9)
					(self setLoop: 2 posn: (+ origX 4) (+ origY 4))
					(stockBack
						view: (+ 54 global384)
						setLoop: 0
						posn: (+ origX 4) (+ origY 4)
					)
				)
				((< 0 size 5)
					(self setLoop: 3 posn: (+ origX 6) (+ origY 6))
					(stockBack
						view: (+ 54 global384)
						setLoop: 0
						posn: (+ origX 6) (+ origY 6)
					)
				)
				((== size 0)
					(self setLoop: 4 posn: (+ origX 7) (+ origY 7))
					(stockBack
						view: 915
						setLoop: emptyLoop
						posn: (+ origX 7) (+ origY 7)
					)
					(if global421
						(= global421 1)
					)
				)
				(else
					(self setLoop: 0 posn: origX origY)
					(stockBack
						view: (+ 54 global384)
						setLoop: 0
						posn: origX origY
					)
				)
			)
			(= recentClient (Dealer curPlayer:))
			(= global395 1)
			(gSound play: 903)
			(littleCard
				setMotion:
					MoveTo
					(+ (recentClient calcNextX:) 17)
					(+ (recentClient calcNextY:) 21)
					self
			)
			(= global116 0)
			(self adjust:)
		else
			(self pass:)
		)
	)

	(method (pass)
		(if (== ((Dealer curPlayer:) type:) 1)
			(self flash:)
		)
		(if ((Dealer curPlayer:) owner:)
			(((Dealer curPlayer:) owner:) say: 1000 1 0 0 14)
		)
		(if theDiscardPile
			(theDiscardPile setCondition: 0)
		)
		(++ global116)
		(= gCrazy8sHand 0)
		(if
			(and
				((Dealer curPlayer:) autoSorting:)
				((Dealer curPlayer:) faceUp:)
			)
			((Dealer curPlayer:) sort:)
		)
	)

	(method (adjust)
		(return 1)
	)

	(method (cue)
		(= size (- (Deck topCard:) 1))
		(self setScript: stockScript 0 recentClient)
	)

	(method (newBacks)
		(cond
			((== global193 600)
				(if (> size 0)
					(stockBack view: (+ 54 global384) forceUpd:)
				)
			)
			((and (not topCard) (!= size -1))
				(stockBack view: (+ 54 global384) forceUpd:)
			)
		)
	)
)

(instance stockBack of View
	(properties)
)

(instance stockScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= ticks 1)
			)
			(1
				(register add: (= temp0 (Deck getCard:)))
				(temp0 flip: (register faceUp:) show: init: stopUpd:)
				(if (and (temp0 owner:) (== ((temp0 owner:) type:) 0))
					(temp0 addKeyMouse:)
				)
				(littleCard hide:)
				(= global395 0)
				(gSound play: 907)
				(register posn:)
				(= ticks
					(if gCrazy8sHand
						(* global386 3)
					else
						1
					)
				)
			)
			(2
				(if gCrazy8sHand
					(gCrazy8sHand think:)
				)
			)
		)
	)
)

