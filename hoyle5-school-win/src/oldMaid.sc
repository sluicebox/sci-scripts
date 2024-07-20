;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 200)
(include sci.sh)
(use Main)
(use KeyMouse)
(use Piles)
(use TrackingView)
(use h5Messager)
(use Tray)
(use Str)
(use Print)
(use Scaler)
(use Motion)
(use File)
(use Actor)
(use System)

(public
	oldMaid 0
	proc200_1 1
	pairCode 2
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
	[local19 33] = [30 135 6 76 135 6 76 195 0 0 0 162 71 0 111 71 2 111 64 0 0 0 295 141 0 243 141 2 243 85 4 1 6]
)

(procedure (proc200_1)
	(proc0_8 97)
	((ScriptID 280 0) doit:) ; scoreOldMaid
	(proc0_8 0)
)

(instance oldMaid of HoyleRoom
	(properties
		style 14
	)

	(method (init)
		(= picture (+ 901 global385))
		(= local16 0)
		((= gOldmaid_opt oldmaid_opt) doit:)
		(= gTheCard3 theCard3)
		(= gTheCard2 theCard2)
		(= gSortMode 0)
		(if global462
			(gChar1 view: global463 active: 1 loop: global466)
			((gChar1 face:) view: global463)
			(gChar2 view: global464 active: 1 loop: global467)
			((gChar2 face:) view: global464)
			(gChar3 view: global465 active: 1 loop: global468)
			((gChar3 face:) view: global465)
			(= gSkill global469)
			(= global197 global470)
			(= global198 global471)
		)
		(= local18 1)
		(= global387 1)
		(UnLoad 129 950)
		(Load rsVIEW 50)
		(Load rsVIEW 51)
		(Load rsVIEW 52)
		(Load rsVIEW 53)
		(Load rsVIEW (+ 54 global384))
		(KeyMouse setList: gTheKeyMouseList)
		(gGame setCursor: 999)
		(super init: &rest)
		(= gCardGameScriptNumber 200)
		(if (== global227 0)
			(= local13 0)
			(pairCode doit:)
		else
			(= local13 1)
			(pairCode doit:)
		)
		(Deck init: MaidCard)
		(= local15 0)
		(Deck
			add:
				((MaidCard new:)
					rank: 0
					suit: -1
					view: (if (== global227 0) 215 else 49)
					setLoop: 0
					cel: 0
					setPri: 2
					ignoreActors:
					yourself:
				)
		)
		(Deck rankAces: 1 topCard: 52)
		((= gTheHands theHands) add: hand1 hand2 hand3 hand4)
		(= gTray 0)
		(if (== global226 0)
			(= local12 1)
		else
			(= local12 0)
		)
		(hand1 add: owner: 0)
		(hand2 add: owner: gChar1 getFrom: hand1)
		(hand3 add: owner: gChar2 getFrom: hand2)
		(hand4 add: owner: gChar3 getFrom: hand3)
		(handleEventList add:)
		(theDiscard add:)
		(gChar1 posn: 24 136 init: show:)
		(gChar2 posn: 105 20 init: show:)
		(gChar3 posn: 296 61 init: show:)
		((gChar1 face:) view: (gChar1 view:))
		((gChar2 face:) view: (gChar2 view:))
		((gChar3 face:) view: (gChar3 view:))
		(Characters init:)
		(Dealer cardsToDeal: 13)
		(self setScript: roomScript)
	)

	(method (doit)
		(super doit:)
		(Dealer doit:)
		(if global290
			(= global290 0)
			(gTheHands eachElementDo: #sort)
			(proc0_9 (gCast elements:) 1)
			(EnableCursor)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(handleEventList handleEvent: event)
	)

	(method (dispose &tmp [temp0 3])
		(if (PalVary 2) ; PalVaryInfo
			(PalVary 1 0) ; PalVaryReverse
		)
		(= gCrazy8sSortCode 0)
		(Dealer dispose:)
		(KeyMouse release:)
		(if (roomScript script:)
			((roomScript script:) dispose:)
		)
		(= global419 0)
		(if gTray
			(Tray dispose:)
		)
		(if (theDiscard size:)
			(theDiscard release:)
		)
		(theDiscard dispose:)
		(gTheHands eachElementDo: #release dispose:)
		(Deck dispose:)
		(gDelayCast release:)
		(handleEventList dispose:)
		(if global458
			(global458 dispose:)
		)
		(= global458 0)
		(DisposeScript 64964)
		(DisposeScript 64941)
		(DisposeScript 9)
		(DisposeScript 64935)
		(DisposeScript 280)
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

(instance removePairs of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(DisableCursor)
				(= local2 (register at: local0))
				(= local3 (register at: local1))
				(if (!= register hand1)
					(local2 flip:)
					(local3 flip:)
					(gSound play: 206)
				)
				(= ticks 60)
			)
			(1
				(= global395 1)
				(= temp0
					(switch global387
						(0 0)
						(1 4)
						(2 2)
					)
				)
				(gTheCard3
					view: (local2 view:)
					cel: (local2 cel:)
					x: (local2 x:)
					y: (local2 y:)
					cycleSpeed: 9
					moveSpeed: 0
					setStep: temp0 temp0
					init:
				)
				(gTheCard2
					view: (local3 view:)
					cel: (local3 cel:)
					x: (local3 x:)
					y: (local3 y:)
					cycleSpeed: 9
					moveSpeed: 0
					setStep: temp0 temp0
					init:
				)
				(if (== global387 0)
					(gTheCard3 posn: (register x1Dest:) (register y1Dest:))
					(UpdateScreenItem gTheCard3)
					(gTheCard2 posn: (register x2Dest:) (register y2Dest:))
					(UpdateScreenItem gTheCard2)
				)
				(gTheCard3
					setLoop: 0
					setPri: 25
					setMotion: MoveTo (register x1Dest:) (register y1Dest:) self
				)
				(gTheCard2
					setLoop: 0
					setPri: 25
					setMotion: MoveTo (register x2Dest:) (register y2Dest:) self
				)
				(local2 hide: posn: 500 500)
				(local3 hide: posn: 500 500)
				(register eliminateCard: local2)
				(register eliminateCard: local3)
				(local2 owner: 0)
				(local3 owner: 0)
				(theDiscard add: local2 local3)
				(gSound play: 207)
			)
			(2 0)
			(3
				(gSound stop:)
				(if
					(and
						(!= register hand1)
						(<= (local2 rank:) 10)
						(> (register size:) 1)
						(or
							(and local4 (not (Random 0 3)))
							(and (not local4) (not (Random 0 6)))
						)
					)
					(proc0_9 (gCast elements:) 0)
					(cond
						((OneOf ((register owner:) view:) 9 15)
							((register owner:) say: 1000 1 23 0 1 711 1)
						)
						((== ((register owner:) view:) 4)
							((register owner:) say: 1000 1 23 0 2 711 1)
						)
						((OneOf ((register owner:) view:) 3 17)
							((register owner:) say: 1000 1 23 0 3)
						)
						(
							(OneOf
								((register owner:) view:)
								1
								5
								6
								7
								8
								10
								12
								13
								16
							)
							((register owner:)
								say: 1000 1 23 0 (Random 1 2) 711 1
							)
						)
						((OneOf ((register owner:) view:) 2 14)
							((register owner:)
								say: 1000 1 23 0 (Random 1 3) 711 1
							)
						)
					)
				)
				(if (and (register owner:) (> (local2 rank:) 10))
					((register owner:) smile:)
				)
				(if (and (== global227 0) (> (local2 rank:) 10))
					(switch (local2 rank:)
						(11
							(gSound play: 204 self)
							(= temp2 223)
						)
						(12
							(gSound play: 203 self)
							(= temp2 227)
						)
						(13
							(gSound play: 202 self)
							(= temp2 231)
						)
					)
					(gTheCard3
						view: (+ temp2 (local2 suit:))
						loop: 0
						cel: 0
						setCycle: Fwd
					)
					(gTheCard2
						view: (+ temp2 (local3 suit:))
						loop: 0
						cel: 0
						setCycle: Fwd
					)
				else
					(= ticks 60)
				)
			)
			(4
				(gSound play: 208)
				(if (== global387 0)
					(gTheCard3
						setMotion: MoveTo (gTheCard3 x:) (gTheCard3 y:) self
					)
					(gTheCard2
						setMotion: MoveTo (gTheCard2 x:) (gTheCard2 y:) self
					)
				else
					(switch register
						(hand1
							(gTheCard3
								setPri: 35
								setScale: Scaler 100 0 75 1
								setMotion: MoveTo 1 1 self
							)
							(gTheCard2
								setPri: 35
								setScale: Scaler 100 0 75 1
								setMotion: MoveTo 318 1 self
							)
						)
						(hand2
							(gTheCard3
								setPri: 35
								setScale: Scaler 100 0 54 1
								setMotion: MoveTo 1 1 self
							)
							(gTheCard2
								setPri: 35
								setScale: Scaler 100 0 98 1
								setMotion: MoveTo 318 1 self
							)
						)
						(hand3
							(gTheCard3
								setPri: 35
								setScale: Scaler 100 0 75 1
								setMotion: MoveTo 1 1 self
							)
							(gTheCard2
								setPri: 35
								setScale: Scaler 100 0 75 1
								setMotion: MoveTo 318 1 self
							)
						)
						(hand4
							(gTheCard3
								setPri: 35
								setScale: Scaler 100 0 54 1
								setMotion: MoveTo 1 1 self
							)
							(gTheCard2
								setPri: 35
								setScale: Scaler 100 0 98 1
								setMotion: MoveTo 318 1 self
							)
						)
					)
				)
			)
			(5 0)
			(6
				(= global395 0)
				(gTheCard3 setScale: 0 dispose:)
				(gTheCard2 setScale: 0 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance compGetCard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global458
					(((Dealer curPlayer:) getFrom:)
						at:
							(Random
								0
								(- (((Dealer curPlayer:) getFrom:) size:) 1)
							)
					)
				)
				(((Dealer curPlayer:) getFrom:)
					moveCard: (Dealer curPlayer:) self
				)
			)
			(1
				((ScriptID 15 6) dispose:) ; littleCard
				(global458 show: setPri: 2)
				((Dealer curPlayer:) add: global458)
				(if (== (Dealer curPlayer:) hand2)
					(global458 flip:)
				)
				(= global395 0)
				((ScriptID 15 6) dispose:) ; littleCard
				(= global458 0)
				(self dispose:)
			)
		)
	)
)

(instance roomScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 [temp2 3] temp5 temp6 temp7 temp8)
		(switch (= state newState)
			(0
				(= ticks (= ticks 1))
			)
			(1
				(if local16
					(RedrawCast)
					(EnableCursor)
					(gGameControls hide:)
					(= local17 (gSystemPlane back:))
					(gSystemPlane back: 53)
					((ScriptID 290 0) init:) ; optionOldMaid
					(gSystemPlane back: local17)
					(DisableCursor)
				)
				(quitButton setPri: 1 init:)
				(gSong fade:)
				(= ticks 10)
			)
			(2
				(= ticks 10)
				(Dealer init: hand1 hand2 hand3 hand4)
			)
			(3
				(DisableCursor)
				(= local4 0)
				(gTheHands
					eachElementDo: #total 0
					eachElementDo: #prevTotal 0
					eachElementDo: #handTotal 0
					eachElementDo: #tempTotal 0
				)
				(handleEventList add: quitButton)
				(handleEventList add: hand1 hand2 hand3 hand4)
				(= global402 0)
				(= cycles 1)
			)
			(4
				(Deck shuffle:)
				(= local10 0)
				(Dealer playDirection: 0 deal: self)
			)
			(5
				((ScriptID 15 6) hide:) ; littleCard
				((Dealer curPlayer:) add: (= temp1 (Deck getCard:)))
				(temp1 flip: ((Dealer curPlayer:) faceUp:) show: init:)
				(if
					(and
						(== ((Dealer curPlayer:) type:) 0)
						(== (temp1 rank:) 0)
					)
					(gSound play: 205)
				)
				(Dealer nextToPlay: (Dealer dealer:) nextToPlay:)
				(= ticks 10)
			)
			(6
				(= ticks 10)
			)
			(7
				(cond
					(((Dealer curPlayer:) owner:)
						(((Dealer curPlayer:) owner:) say: 200 0 68 0 1 711 1)
					)
					((!= register gChar2)
						(gChar2 say: 200 0 69 0 1)
					)
					(else
						(gChar3 say: 200 0 69 0 1)
					)
				)
				(Arrow x: 200 y: 75 init:)
				(= cycles 1)
			)
			(8
				(= cycles 1)
			)
			(9
				((KeyMouse objList:) release:)
				(if (< local10 4)
					(= state 7)
					(cond
						((== ((Dealer curPlayer:) type:) 0)
							(if ((Dealer curPlayer:) findPair:)
								(EnableCursor)
								(if local12
									(pairButton init:)
								else
									(hand1
										eachElementDo: #offsetY 20
										eachElementDo: #addKeyMouse
									)
									(Tray init: handleEventList self theDiscard)
									(if (not (HaveMouse))
										(KeyMouse
											setCursor:
												(hand1 at: (- (hand1 size:) 1))
										)
									)
								)
							else
								(Dealer nextToPlay:)
								(++ local10)
								(= ticks 10)
							)
						)
						(((Dealer curPlayer:) findPair:)
							(self
								setScript: removePairs self (Dealer curPlayer:)
							)
						)
						(else
							(Dealer nextToPlay:)
							(++ local10)
							(= ticks 10)
						)
					)
				else
					(= ticks 20)
				)
			)
			(10
				(= ticks 20)
			)
			(11
				(= local4 1)
				(= local10 (Dealer curPlayer:))
				(if (!= (theDiscard size:) 52)
					(if (== ((Dealer curPlayer:) type:) 0)
						(if (hand4 size:)
							(EnableCursor)
							(= local10 hand1)
							(Dealer curPlayer: hand4)
							((KeyMouse objList:) release:)
							(hand4
								eachElementDo: #offsetY 4
								eachElementDo: #addKeyMouse
							)
							(if (not (HaveMouse))
								(KeyMouse
									setCursor: (hand4 at: (- (hand4 size:) 1))
								)
							)
							(if (and (not (Random 0 10)) (not local18))
								(= local18 1)
								(cond
									((Random 0 1)
										(if (hand2 size:)
											(if (Random 0 1)
												(= temp5 3)
											else
												(= temp5 1)
											)
											(= temp6 (+ ((hand2 at: 0) x:) 34))
											(= temp7 (+ ((hand2 at: 0) y:) 1))
											(joker
												setPri: 15
												loop: temp5
												posn: temp6 temp7
												setCycle: End joker
												init:
											)
											(gSound2 play: 205)
										)
									)
									((>= 7 (hand3 size:) 1)
										(= temp6 (- ((hand3 at: 0) x:) 1))
										(= temp7 (+ ((hand3 at: 0) y:) 33))
										(joker
											setPri: 15
											loop: 2
											posn: temp6 temp7
											setCycle: End joker
											init:
										)
										(gSound2 play: 205)
									)
								)
							)
						else
							(Characters say: 200 0 60 0 1 713)
							(= state 9)
							(Dealer nextToPlay: hand2)
							(= local10 (Dealer curPlayer:))
							(= ticks 10)
						)
					else
						((KeyMouse objList:) release:)
						(if (((Dealer curPlayer:) getFrom:) size:)
							(self setScript: compGetCard self)
						else
							((local10 owner:) say: 200 0 67 0 1)
							(Dealer nextToPlay:)
							(= local10 (Dealer curPlayer:))
							(= state 9)
							(= ticks 10)
						)
					)
				else
					(self changeState: 14)
				)
			)
			(12
				(if (local10 findPair:)
					(if (== local10 hand1)
						((KeyMouse objList:) release:)
						(if local12
							(pairButton init:)
						else
							(hand1
								eachElementDo: #offsetY 20
								eachElementDo: #addKeyMouse
							)
							(EnableCursor)
							(Tray init: handleEventList self theDiscard)
							(if (not (HaveMouse))
								(KeyMouse
									setCursor: (hand1 at: (- (hand1 size:) 1))
								)
							)
						)
					else
						(self setScript: removePairs self (Dealer curPlayer:))
					)
				else
					(= ticks 10)
				)
			)
			(13
				(= state 9)
				(Dealer nextToPlay:)
				(= local10 (Dealer curPlayer:))
				(= ticks 10)
			)
			(14
				(DisableCursor)
				(= local4 0)
				(for ((= temp0 0)) (< temp0 (gTheHands size:)) ((++ temp0))
					(if ((gTheHands at: temp0) size:)
						(= temp8 (= local11 (gTheHands at: temp0)))
						((gTheHands at: temp0)
							total: (+ ((gTheHands at: temp0) total:) 1)
						)
						(= local11 (local11 owner:))
					)
				)
				(gTheIconBar disable:)
				(if
					(or
						(== local11 gChar1)
						(== local11 gChar2)
						(== local11 gChar3)
					)
					(for ((= temp0 0)) (<= temp0 52) ((++ temp0))
						(if (== ((Deck at: temp0) suit:) -1)
							((Deck at: temp0) flip: 1 show:)
						)
					)
					(gChar1 setPri: 6)
					(gChar2 setPri: 6)
					(gChar3 setPri: 6)
					(FrameOut)
					(self setScript: transScript 0 0)
				else
					(self setScript: humanLossScript)
				)
			)
			(15
				(gTheIconBar enable:)
				(proc200_1)
				(= ticks 30)
			)
			(16
				(if (= global748 1)
					(theDiscard release:)
					(Arrow endHand:)
					(Dealer rotate:)
					(gTheHands eachElementDo: #endHand)
					(maid dispose:)
					(card dispose:)
					(= state 3)
				)
				(= ticks 30)
			)
			(17
				(EnableCursor)
				(gGame quitGame:)
			)
		)
	)
)

(instance flasher of Prop
	(properties
		x 217
		y 80
		priority 15
		view 214
		loop 5
		cycleSpeed 10
	)
)

(instance transScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DisableCursor)
				(UnLoad 128 999)
				(UnLoad 128 997)
				(UnLoad 128 908)
				(UnLoad 128 921)
				(UnLoad 128 903)
				(UnLoad 128 950)
				(UnLoad 128 901)
				(UnLoad 128 902)
				(UnLoad 128 998)
				(UnLoad 128 950)
				(UnLoad 128 906)
				(UnLoad 128 907)
				(UnLoad 128 909)
				(UnLoad 128 920)
				(UnLoad 128 990)
				(UnLoad 128 950)
				(= state 5)
				(= ticks 10)
			)
			(1
				(client
					setCycle: Walk
					setPri: 15
					setMotion:
						MoveTo
						[local19 register]
						[local19 (+ register 1)]
						self
				)
			)
			(2
				(client setScale: 0 loop: 4 cel: [local19 (+ register 2)])
				(= ticks 10)
			)
			(3
				(client
					setMotion:
						MoveTo
						[local19 (+ register 3)]
						[local19 (+ register 4)]
						self
				)
			)
			(4
				(client loop: 4 cel: [local19 (+ register 5)])
				(= ticks 10)
			)
			(5
				(client
					setMotion:
						MoveTo
						[local19 (+ register 6)]
						[local19 (+ register 7)]
						self
				)
			)
			(6
				(= ticks 1)
				(if local11
					(cond
						((== (local11 view:) 6)
							(local11 say: 1000 1 23 0 (Random 3 4) 713 1)
						)
						((OneOf (local11 view:) 2 5 7 8 10 12 14 16)
							(local11 say: 1000 1 23 0 (Random 4 5) 713 1)
						)
						((OneOf (local11 view:) 0 1 4 9 11 13 15 17)
							(local11 say: 1000 1 23 0 (Random 3 5) 713 1)
						)
					)
				)
				(= ticks 10)
			)
			(7
				(gChar1 active: 0 posn: 24 136)
				(gChar2 active: 0 posn: 105 20)
				(gChar3 active: 0 posn: 296 61)
				((gChar1 face:)
					setCycle: 0
					view: (+ (gChar1 view:) 250)
					loop: (- (gChar1 loop:) 2)
					cel: 0
					show:
				)
				((gChar2 face:)
					setCycle: 0
					view: (+ (gChar2 view:) 250)
					loop: (- (gChar2 loop:) 2)
					cel: 0
					show:
				)
				((gChar3 face:)
					setCycle: 0
					view: (+ (gChar3 view:) 250)
					loop: (- (gChar3 loop:) 2)
					cel: 0
					show:
				)
				(proc0_9 (gCast elements:) 0)
				(= ticks 10)
			)
			(8
				(= ticks 1)
			)
			(9
				(= ticks 1)
			)
			(10
				(= ticks 1)
				((local11 face:) cycleSpeed: 20 setPri: 14 setCycle: End self)
				(gSound play: 209)
				(= ticks 250)
			)
			(11 1)
			(12
				(= ticks 1)
			)
			(13
				(= ticks 1)
			)
			(14
				(gChar1 active: 1 cel: 0 priority: 6)
				(gChar2 active: 1 cel: 0 priority: 6)
				(gChar3 active: 1 cel: 0 priority: 6)
				((gChar1 face:) view: (gChar1 view:) cel: 0 hide:)
				((gChar2 face:) view: (gChar2 view:) cel: 0 hide:)
				((gChar3 face:) view: (gChar3 view:) cel: 0 hide:)
				(proc0_9 (gCast elements:) 0)
				(roomScript cue:)
			)
		)
	)
)

(instance maid of Actor
	(properties)

	(method (init param1)
		(self view: 200 loop: 2 cel: 0)
		(card view: 202 loop: 2 cel: 1)
		(self ignoreActors:)
		(gSound play: 209)
		(switch local11
			(gChar1
				(self posn: 30 119 setPri: 15 setScale: Scaler 100 68 130 112)
				(card x: 10 y: 78 setPri: 14 init:)
				(super init: &rest)
				((param1 at: 0) hide:)
				(proc0_9 (gCast elements:) 0)
				(self setScript: transScript 0 0)
			)
			(gChar2
				(self posn: 162 51 setPri: 15 setScale: Scaler 100 68 67 46)
				(card x: 143 y: 10 setPri: 14 init:)
				(super init: &rest)
				((param1 at: 0) hide:)
				(proc0_9 (gCast elements:) 0)
				(self setScript: transScript 0 11)
			)
			(gChar3
				(self posn: 295 120 setPri: 15 setScale: Scaler 100 68 133 112)
				(card x: 274 y: 78 setPri: 14 init:)
				(super init: &rest)
				((param1 at: 0) hide:)
				(proc0_9 (gCast elements:) 0)
				(self setScript: transScript 0 22)
			)
			(else
				(card view: 268 loop: 2 cel: 0 x: 143 y: 146 init:)
				(self view: 268 loop: 4 cel: 0 x: 500 y: 500)
				((param1 at: 0) hide:)
				(proc0_9 (gCast elements:) 0)
				(super init: &rest)
				(self setScript: humanLossScript)
			)
		)
	)
)

(instance humanLossScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 3])
		(switch (= state newState)
			(0
				(DisableCursor)
				(UnLoad 128 999)
				(UnLoad 128 997)
				(UnLoad 128 908)
				(UnLoad 128 921)
				(UnLoad 128 903)
				(UnLoad 128 950)
				(UnLoad 128 901)
				(UnLoad 128 902)
				(UnLoad 128 998)
				(UnLoad 128 950)
				(UnLoad 128 906)
				(UnLoad 128 907)
				(UnLoad 128 909)
				(UnLoad 128 920)
				(UnLoad 128 990)
				(UnLoad 128 950)
				(= register 0)
				(= state 10)
				(gSound play: 209)
				(Print
					ticks: 400
					mode: 1
					fore: 0
					addBitmap: 25 0 0
					addText: {You are the Troll !!!}
					init:
				)
				(= ticks 10)
			)
			(1
				(card cycleSpeed: 9 setCycle: End self)
			)
			(2
				(if (< (++ register) 3)
					(= state 1)
					(if (not (card cycler:))
						(card setLoop: 3 setCycle: Fwd setPri: 14)
					)
					(maid
						cycleSpeed: 9
						loop: 4
						posn: 142 144
						setPri: 15
						show:
						setCycle: End self
					)
				else
					(= ticks 1)
				)
			)
			(3
				(Characters smile:)
				(= register 0)
				(= ticks 12)
			)
			(4
				(if (< (++ register) 3)
					(maid loop: 5 cel: 0 cycleSpeed: 4)
					(= state 3)
					(switch register
						(1
							(maid posn: 171 187)
						)
						(2
							(maid posn: 200 187)
						)
					)
					(maid setCycle: End self)
				else
					(= ticks 10)
				)
			)
			(5
				(= ticks 12)
				(= register 0)
			)
			(6
				(if (< (++ register) 3)
					(= state 5)
					(if (== register 2)
						(maid cel: 10 posn: 171 187)
					)
					(maid setCycle: CT 0 -1 self)
				else
					(= ticks 10)
				)
			)
			(7
				(PalVary 0 (gCurRoom picture:) 2) ; PalVaryStart
				(= register 0)
				(client loop: 6 posn: 138 144 setCycle: End self)
			)
			(8
				(if (< (++ register) 5)
					(switch register
						(1)
						(2)
						(3)
						(4)
					)
					(= state 7)
				)
				(client cel: 4 setCycle: End)
				(= ticks 40)
			)
			(9
				(= ticks 140)
				(PalVary 1 3) ; PalVaryReverse
			)
			(10
				(gChar1 init:)
				(gChar2 init:)
				(gChar3 init:)
				(card setCycle: 0)
				(= ticks 120)
			)
			(11
				(roomScript cue:)
			)
		)
	)
)

(instance card of Prop
	(properties
		x 274
		y 78
		priority 7
		view 202
		loop 2
		cel 1
	)
)

(class Walk of Fwd
	(properties)

	(method (doit &tmp temp0)
		(if (not (client isStopped:))
			(super doit:)
		)
	)
)

(instance oldmaid_opt of File
	(properties
		name {oldmaid.opt}
	)

	(method (doit param1 &tmp temp0 temp1 temp2)
		(= temp0 (Str new:))
		(= temp1 (Str new:))
		(cond
			((and argc (== param1 3))
				(if (self open: 2)
					(self
						writeString:
							(temp0
								format:
									{%d%d%2d%2d%2d%d%d%d%d%d%d}
									global227
									global226
									(gChar1 view:)
									(gChar2 view:)
									(gChar3 view:)
									(gChar1 loop:)
									(gChar2 loop:)
									(gChar3 loop:)
									gSkill
									global197
									global198
							)
						close:
					)
					(temp0 dispose:)
					(temp1 dispose:)
					(return 1)
				else
					(temp0 dispose:)
					(temp1 dispose:)
					(return 0)
				)
			)
			((self open: 1)
				(self readString: temp1 2)
				(= global227 ((Str with: temp1) asInteger:))
				(self readString: temp1 2)
				(= global226 ((Str with: temp1) asInteger:))
				(self readString: temp1 3)
				(= global463 ((Str with: temp1) asInteger:))
				(self readString: temp1 3)
				(= global464 ((Str with: temp1) asInteger:))
				(self readString: temp1 3)
				(= global465 ((Str with: temp1) asInteger:))
				(self readString: temp1 2)
				(= global466 ((Str with: temp1) asInteger:))
				(self readString: temp1 2)
				(= global467 ((Str with: temp1) asInteger:))
				(self readString: temp1 2)
				(= global468 ((Str with: temp1) asInteger:))
				(self readString: temp1 2)
				(= global469 ((Str with: temp1) asInteger:))
				(self readString: temp1 2)
				(= global470 ((Str with: temp1) asInteger:))
				(self readString: temp1 2)
				(= global471 ((Str with: temp1) asInteger:))
				(self close:)
				(temp0 dispose:)
				(temp1 dispose:)
				(return 0)
			)
			(else
				(= global227 1)
				(= global226 1)
				(= global463 12)
				(= global464 13)
				(= global465 14)
				(= global466 2)
				(= global467 2)
				(= global468 2)
				(= global469 2)
				(= global470 2)
				(= global471 2)
				(= local16 0)
				(temp0 dispose:)
				(temp1 dispose:)
				(return 0)
			)
		)
	)
)

(class OldMaidHand of Hand
	(properties
		autoSorting 0
		x1Dest 0
		y1Dest 0
		x2Dest 0
		y2Dest 0
		getFrom 0
	)

	(method (calcNextX)
		(return
			(if (and local4 (== handDirection 1) (not size))
				143
			else
				(super calcNextX:)
			)
		)
	)

	(method (calcNextY)
		(return
			(if (and local4 (== handDirection 2) (not size))
				78
			else
				(super calcNextY:)
			)
		)
	)

	(method (handleEvent event &tmp temp0)
		(if
			(and
				(not (event claimed:))
				(not global395)
				(self reverseFirstTrue: 165 event)
			)
			(if (gCast contains: joker)
				(gSound2 stop:)
				(joker dispose:)
				(proc0_9 (gCast elements:) 0)
			)
			(cond
				((and (gCast contains: pairButton) (not owner))
					(gSound play: 904)
					(Characters say: 200 19 0 0 1 711)
					(return 1)
				)
				((and (or gTray (gCast contains: pairButton)) owner)
					(gSound play: 904)
					(owner say: 200 0 71 0 1 711)
					(return 1)
				)
				(
					(and
						(not gTray)
						(not (gCast contains: pairButton))
						local4
					)
					(cond
						((!= self hand4)
							(flasher setCycle: Fwd init:)
							(gSound play: 904)
							((hand4 owner:) say: 200 0 70 0 1 711)
							(return 1)
						)
						((gCast contains: flasher)
							(flasher dispose:)
							(proc0_9 (gCast elements:) 0)
						)
					)
				)
			)
		)
		(event claimed: 0)
		(super handleEvent: event)
	)

	(method (enterKey param1 param2)
		(= global458 param1)
		(if gTray
			(if (gTray validPlay: param1)
				(self moveCard: gTray)
				(RedrawCast)
				(cond
					((== (gTray size:) 1)
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
		else
			(param1 moveBack:)
		)
	)

	(method (cue)
		(super cue:)
		((ScriptID 15 6) setCycle: 0) ; littleCard
		(if gTray
			(gTray setCard: global458)
		)
		(= global395 (= global458 0))
	)

	(method (findPair)
		(if (> (self size:) 1)
			(for ((= local0 0)) (< local0 (self size:)) ((++ local0))
				(for
					((= local1 (+ local0 1)))
					(< local1 (self size:))
					((++ local1))
					
					(if (== ((self at: local0) rank:) ((self at: local1) rank:))
						(return 1)
					)
				)
			)
		)
		(return 0)
	)
)

(class MaidCard of Card
	(properties
		offsetY 4
	)

	(method (saveData)
		(super saveData:)
		(= local5 x)
		(= local6 y)
		(= local7 view)
		(= local8 cel)
		(= local9 signal)
	)

	(method (flip param1)
		(cond
			((and argc param1)
				(self view: (+ local14 suit) cel: rank faceUp: 1)
			)
			((and argc (not param1))
				(self view: (+ 54 global384) cel: 0 faceUp: 0)
			)
			(faceUp
				(self view: (+ 54 global384) cel: 0 faceUp: 0)
			)
			(else
				(self view: (+ local14 suit) cel: rank faceUp: 1)
			)
		)
	)

	(method (moveBack param1 param2 param3 &tmp temp0)
		(self hide:)
		(= temp0
			(switch global387
				(0 10)
				(1 5)
				(2 2)
			)
		)
		(gSound play: 906)
		(gTheCard1
			view: view
			setLoop: 0
			cel: cel
			posn: x y
			setStep: temp0 temp0
			moveSpeed: 0
			ignoreActors:
			ignoreHorizon:
			init:
			show:
		)
		(if (hand1 size:)
			(gTheCard1
				setPri: (+ ((hand1 at: (- (hand1 size:) 1)) priority:) 1)
			)
		else
			(gTheCard1 setPri: 2)
		)
		(if (and local4 (not gTray) (not (gCast contains: pairButton)))
			(DisableCursor)
			(hand4 eliminateCard: self)
			(gTheCard1 setScript: getCardScript 0 self)
		else
			(gTheCard1
				setMotion:
					MoveTo
					(if argc param1 else local5)
					(if argc param2 else local6)
					(if argc param3 else self)
			)
		)
		(= global395 1)
	)
)

(instance getCardScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheCard1
					setMotion: MoveTo (hand1 calcNextX:) (hand1 calcNextY:) self
				)
			)
			(1
				(= global395 0)
				(register show:)
				(hand1 add: register)
				(register flip: 1)
				(proc0_9 (gCast elements:) 0)
				(Dealer nextToPlay: hand1)
				(if (== (register rank:) 0)
					(gSound play: 205)
				)
				(= cycles 1)
				(gTheCard1 hide:)
			)
			(2
				(roomScript cue:)
				(gTheCard1 dispose:)
			)
		)
	)
)

(instance hand1 of OldMaidHand
	(properties
		x 98
		y 141
		handNumber 3
		faceUp 1
		centerX 157
		centerY 141
		x1Dest 124
		y1Dest 85
		x2Dest 160
		y2Dest 85
	)
)

(instance hand2 of OldMaidHand
	(properties
		x 36
		y 22
		handDirection 2
		type 1
		handNumber 2
		location 4
		centerX 36
		centerY 78
		x1Dest 143
		y1Dest 59
		x2Dest 143
		y2Dest 100
	)
)

(instance hand3 of OldMaidHand
	(properties
		x 113
		y 19
		type 1
		handNumber 1
		location 1
		centerX 172
		centerY 19
		x1Dest 124
		y1Dest 85
		x2Dest 160
		y2Dest 85
	)
)

(instance hand4 of OldMaidHand
	(properties
		x 250
		y 53
		handDirection 2
		type 1
		handNumber 4
		location 2
		centerX 250
		centerY 109
		x1Dest 143
		y1Dest 59
		x2Dest 143
		y2Dest 100
	)
)

(instance theHands of List
	(properties)
)

(instance theDiscard of List
	(properties)
)

(instance handleEventList of EventHandler
	(properties)
)

(instance theCard2 of Actor
	(properties)
)

(instance theCard3 of Actor
	(properties)
)

(instance pairCode of Code
	(properties)

	(method (doit &tmp temp0)
		(cond
			((and (== global227 0) (not local13))
				(= local14 216)
				(= local13 1)
				(for ((= temp0 0)) (< temp0 (Deck size:)) ((++ temp0))
					(if
						(and
							((Deck at: temp0) faceUp:)
							(!= ((Deck at: temp0) rank:) 0)
						)
						((Deck at: temp0)
							view: (+ local14 ((Deck at: temp0) suit:))
						)
					)
				)
			)
			((and (== global227 1) local13)
				(= local14 50)
				(= local13 0)
				(for ((= temp0 0)) (< temp0 (Deck size:)) ((++ temp0))
					(if
						(and
							((Deck at: temp0) faceUp:)
							(!= ((Deck at: temp0) rank:) 0)
						)
						((Deck at: temp0)
							view: (+ local14 ((Deck at: temp0) suit:))
						)
					)
				)
			)
		)
		(cond
			((and (== global226 0) (not local12))
				(= local12 1)
				(if gTray
					(cond
						((== (gTray size:) 1)
							(hand1 add: (gTray at: 0))
							((gTray at: 0) associatedObj: 0)
							(gTray eliminateCard: (gTray at: 0))
							(Tray dispose:)
						)
						((== (gTray size:) 2)
							(gTray okPressed:)
						)
						(else
							(Tray dispose:)
						)
					)
					(if (hand1 findPair:)
						(pairButton init:)
					)
				)
			)
			((and (== global226 1) local12)
				(= local12 0)
				(if (gCast contains: pairButton)
					(pairButton dispose:)
					(hand1
						eachElementDo: #offsetY 20
						eachElementDo: #addKeyMouse
					)
					(EnableCursor)
					(Tray init: handleEventList roomScript theDiscard)
				)
			)
		)
	)
)

(instance pairButton of TrackingView
	(properties
		x 129
		y 79
		view 202
		loop 1
	)

	(method (init)
		(super init:)
		(pairBack init:)
		(EnableCursor)
		(self associatedObj: pairBack)
		((KeyMouse objList:) release: add: self)
		(handleEventList add: self)
	)

	(method (dispose)
		(self associatedObj: 0)
		(pairBack dispose:)
		((KeyMouse objList:) release:)
		(handleEventList delete: self)
		(DisableCursor)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(pairButton setCycle: Fwd)
			(gSound play: 201)
			(event claimed: 1)
			(self dispose:)
			(roomScript setScript: removePairs roomScript hand1)
		)
	)
)

(instance pairBack of View
	(properties
		x 129
		y 79
		view 202
	)
)

(instance joker of Prop
	(properties
		view 201
		loop 1
		cycleSpeed 8
	)

	(method (cue)
		(Characters smile:)
		(self dispose:)
		(gSound2 stop:)
	)
)

