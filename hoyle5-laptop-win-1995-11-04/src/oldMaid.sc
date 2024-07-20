;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 200)
(include sci.sh)
(use Main)
(use KeyMouse)
(use Piles)
(use TrackingView)
(use h5Messager)
(use theTitle)
(use Str)
(use Scaler)
(use IconBar)
(use Motion)
(use File)
(use Actor)
(use System)

(public
	oldMaid 0
	proc200_1 1
	pairCode 2
	proc200_3 3
	proc200_4 4
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
	[local23 33] = [30 135 6 76 135 6 76 195 0 0 0 162 71 0 111 71 2 111 64 0 0 0 295 141 0 243 141 2 243 85 4 1 6]
	[local56 28] = [-5 13 -1 14 -2 17 -4 8 -10 3 2 19 0 18 9999 9999 9999 9999 0 12 9999 9999 -7 14 -5 16 -8 2]
)

(procedure (proc200_1)
	(IconBarF darken:)
	((ScriptID 280 0) doit:) ; scoreOldMaid
	(IconBarF lighten:)
)

(procedure (proc200_3 param1 &tmp temp0)
	(= temp0 (param1 view:))
	(cond
		((== (param1 oldMaidStage:) 3)
			(return (param1 prevView:))
		)
		((and (>= temp0 250) (<= temp0 263))
			(return (- temp0 250))
		)
		((and (>= temp0 220) (<= temp0 233))
			(return (- temp0 220))
		)
		(else
			(return temp0)
		)
	)
)

(procedure (localproc_0 &tmp temp0 temp1 temp2)
	(for ((= temp2 0)) (<= temp2 2) ((++ temp2))
		(= temp0 (Characters at: temp2))
		(if (and (>= (= temp1 (temp0 view:)) 250) (<= temp1 263))
			(-= temp1 250)
		)
		(if (and (>= temp1 220) (<= temp1 233))
			(-= temp1 220)
		)
		(temp0
			setPri: 200
			view: temp1
			loop: (temp0 loop:)
			cel: 0
			cycleSpeed: 2
			setCycle: BlinkFwd
		)
	)
	(Characters
		eachElementDo: #prevView 0
		eachElementDo: #prevLoop 0
		eachElementDo: #prevCel 0
		eachElementDo: #oldMaidStage 0
	)
)

(procedure (proc200_4 param1)
	(if argc
		(= local22 param1)
	else
		(return local22)
	)
)

(instance oldMaidFrame of View
	(properties)
)

(instance playerFrame of View
	(properties)
)

(instance eyeBall of Prop
	(properties)
)

(instance oldMaid of HoyleRoom
	(properties
		style 14
	)

	(method (init)
		(if (== gAttitudeSetting 0)
			(= gAttitudeSetting 1)
			(gChar1 loop: 0)
			(gChar2 loop: 0)
			(gChar3 loop: 0)
			(= global916 0)
		)
		(= global387 1)
		(= local22 0)
		(= local17 0)
		((= gOldmaid_opt oldmaid_opt) doit:)
		(if global878
			(PlaySong play: (+ 50 global878))
		else
			(PlaySong play: 51)
		)
		(if (not local22)
			(gSong setLoop: 1)
		)
		(= picture (+ 901 global385))
		(= gTheCard3 theCard3)
		(= gTheCard2 theCard2)
		(= gSortMode 0)
		(= local19 0)
		(= local20 0)
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
			(= local14 0)
			(pairCode doit:)
		else
			(= local14 1)
			(pairCode doit:)
		)
		(Deck init: MaidCard)
		(hand1 init:)
		(hand2 init:)
		(hand3 init:)
		(hand4 init:)
		(= local16 0)
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
		((= global117 theHands) add: hand1 hand2 hand3 hand4)
		(= gTray 0)
		(if (== global226 0)
			(= local13 1)
		else
			(= local13 0)
		)
		(hand1 add: owner: 0)
		(hand2 add: owner: gChar1 getFrom: hand1)
		(hand3 add: owner: gChar2 getFrom: hand2)
		(hand4 add: owner: gChar3 getFrom: hand3)
		(handleEventList add:)
		(theDiscard add:)
		(oldMaidFrame dispose:)
		(playerFrame dispose:)
		(UnLoad 128 203)
		(UnLoad 128 204)
		(localproc_0)
		(gChar1 posn: 59 327 init: show:)
		(gChar2 posn: 210 56 init: show:)
		(gChar3 posn: 582 148 init: show:)
		(Characters init:)
		(Dealer cardsToDeal: 13)
		(IconBarF init:)
		(self setScript: roomScript)
	)

	(method (doit)
		(super doit:)
		(Dealer doit:)
		(if global290
			(= global290 0)
			(global117 eachElementDo: #sort)
			(proc0_9 (gCast elements:) 1)
			(EnableCursor)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (handleEventList handleEvent: event)
			(event claimed: 1)
		)
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
		(global117 eachElementDo: #release dispose:)
		(Deck dispose:)
		(IconBarF dispose:)
		(oldMaidFrame dispose:)
		(playerFrame dispose:)
		(gDelayCast release:)
		(handleEventList dispose:)
		(= global458 0)
		(DisposeScript 64964)
		(DisposeScript 64941)
		(DisposeScript 9)
		(DisposeScript 64935)
		(DisposeScript 280)
		(super dispose:)
	)
)

(instance removePairs of Script
	(properties)

	(method (changeState newState &tmp [temp0 2] temp2 temp3 temp4)
		(switch (= state newState)
			(0
				(DisableCursor)
				(= local12 600)
				(if global898
					(= local12 (+ 8 (* 4 (- 16 global898))))
				)
				(= local2 (register at: local0))
				(= local3 (register at: local1))
				(if (!= register hand1)
					(local2 flip:)
					(local3 flip:)
					(gSound play: 206)
				)
				(= ticks 60)
				(UpdateScreenItem local2)
				(UpdateScreenItem local3)
				(FrameOut)
				(if (and (!= register hand1) (== global898 0))
					(local2 hide: posn: 500 500)
					(local3 hide: posn: 500 500)
					(register eliminateCard: local2)
					(register eliminateCard: local3)
					(local2 owner: 0)
					(local3 owner: 0)
					(theDiscard add: local2 local3)
					(register posn:)
					(self dispose:)
				)
			)
			(1
				(= global395 1)
				(gTheCard3
					view: (local2 view:)
					cel: (local2 cel:)
					x: (local2 x:)
					y: (local2 y:)
					cycleSpeed: 9
					moveSpeed: 2
					setStep: local12 local12
					ignoreActors: 1
					init:
				)
				(gTheCard2
					view: (local3 view:)
					cel: (local3 cel:)
					x: (local3 x:)
					y: (local3 y:)
					cycleSpeed: 9
					moveSpeed: 2
					setStep: local12 local12
					ignoreActors: 1
					init:
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
				(proc0_12 207)
			)
			(2 0)
			(3
				(gSound stop:)
				(if (Random 0 1)
					(proc0_9 (gCast elements:) 0)
					(switch register
						(hand1
							(switch (= temp4 (Random 1 3))
								(1
									(gChar1 sayPN: 1000 2 83 0 (Random 1 5))
								)
								(2
									(gChar2 sayPN: 1000 2 83 0 (Random 1 5))
								)
								(3
									(gChar3 sayPN: 1000 2 83 0 (Random 1 5))
								)
							)
						)
						(hand2
							(gChar1 sayPN: 1000 2 82 0 (Random 1 5) 718 1)
						)
						(hand3
							(gChar2 sayPN: 1000 2 82 0 (Random 1 5) 718 1)
						)
						(hand4
							(gChar3 sayPN: 1000 2 82 0 (Random 1 5) 718 1)
						)
					)
				)
				(if (and (register owner:) (> (local2 rank:) 10))
					((register owner:) smile:)
				)
				(if (and (== global227 0) (> (local2 rank:) 10))
					(switch (local2 rank:)
						(11
							(proc0_12 202 self)
							(= temp2 223)
						)
						(12
							(proc0_12 203 self)
							(= temp2 227)
						)
						(13
							(proc0_12 204 self)
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
					(= ticks 120)
				else
					(= ticks 60)
				)
			)
			(4
				(proc0_12 208)
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
							setMotion: MoveTo 638 1 self
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
							setMotion: MoveTo 638 1 self
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
							setMotion: MoveTo 638 1 self
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
							setMotion: MoveTo 638 1 self
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

	(method (changeState newState &tmp temp0 temp1 [temp2 3] temp5 temp6 temp7 temp8 temp9 temp10)
		(switch (= state newState)
			(0
				(= ticks (= ticks 1))
			)
			(1
				(if local17
					(RedrawCast)
					(EnableCursor)
					(gGameControls hide:)
					(= local18 (gSystemPlane back:))
					(gSystemPlane back: 53)
					((ScriptID 290 0) init:) ; optionOldMaid
					(gSystemPlane back: local18)
					(DisableCursor)
				)
				(= ticks 10)
			)
			(2
				(= ticks 10)
				(Dealer init: hand1 hand2 hand3 hand4)
				(Characters eachElementDo: #oldMaidStage 0)
			)
			(3
				(IconBar show:)
				(DisableCursor)
				(= local4 0)
				(global117
					eachElementDo: #prevTotal 0
					eachElementDo: #handTotal 0
					eachElementDo: #tempTotal 0
				)
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
					(proc0_12 205)
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
						(= temp9 ((Dealer curPlayer:) owner:))
						(temp9
							sayReg:
								200
								(+ (proc200_3 temp9) 1)
								68
								0
								(Random 1 2)
						)
					)
					((!= register gChar2)
						(gChar2
							sayReg:
								200
								(+ (proc200_3 gChar2) 1)
								69
								0
								(Random 1 2)
						)
					)
					(else
						(gChar3
							sayReg:
								200
								(+ (proc200_3 gChar3) 1)
								69
								0
								(Random 1 2)
						)
					)
				)
				(Arrow x: 400 y: 180 init:)
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
								(if local13
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
							(switch gAttitudeSetting
								(2
									(= temp10 (not (Random 0 10)))
								)
								(3
									(= temp10 (not (Random 0 5)))
								)
								(else
									(= temp10 0)
								)
							)
							(if (and (>= gAttitudeSetting 2) temp10 (not local19))
								(cond
									((Random 0 1)
										(if (>= 8 (hand2 size:) 1)
											(= temp5 (Random 1 2))
											(= temp6 (+ ((hand2 at: 0) x:) 0))
											(= temp7 (+ ((hand2 at: 0) y:) 0))
											(joker
												setPri: 15
												cel: 0
												loop: temp5
												posn: temp6 temp7
												setCycle: End joker
												init:
											)
											(proc0_12 205 2)
										)
									)
									((hand3 size:)
										(= temp6
											(+
												((hand3 at: (- (hand3 size:) 1))
													x:
												)
												0
											)
										)
										(= temp7
											(+
												((hand3 at: (- (hand3 size:) 1))
													y:
												)
												0
											)
										)
										(joker
											setPri: 55
											loop: 3
											cel: 0
											posn: temp6 temp7
											setCycle: End joker
											init:
										)
										(proc0_12 205 2)
									)
								)
							)
						else
							(= temp9 (Characters at: (Random 0 2)))
							(temp9
								sayReg:
									200
									(+ (proc200_3 temp9) 1)
									60
									0
									(Random 1 2)
							)
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
							(= temp9 (local10 owner:))
							(temp9
								say6:
									200
									(+ (proc200_3 temp9) 1)
									67
									0
									(Random 1 5)
							)
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
						(if local13
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
				(for ((= temp0 0)) (< temp0 (global117 size:)) ((++ temp0))
					(if ((global117 at: temp0) size:)
						(= temp8 (= local11 (global117 at: temp0)))
						((global117 at: temp0)
							total: (+ ((global117 at: temp0) total:) 1)
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
				)
				(proc17_3)
				(Characters habitsOn: 0)
				(if (== (temp8 type:) 0)
					(switch (temp8 total:)
						(1
							(self setScript: humanStageOneLoss self local11)
						)
						(2
							(self setScript: humanStageTwoLoss self local11)
						)
						(3
							(= local20 1)
							(self setScript: humanStageThreeLoss self local11)
						)
					)
				else
					(switch (temp8 total:)
						(1
							(self setScript: compStageOneLoss self local11)
						)
						(2
							(self setScript: compStageTwoLoss self local11)
						)
						(3
							(= local20 1)
							(self setScript: compStageThreeLoss self local11)
						)
					)
				)
			)
			(15
				(gTheIconBar enable:)
				(proc200_1)
				(= ticks 30)
			)
			(16
				(if (not local20)
					(= global748 1)
				else
					(IconBarF darken:)
					((ScriptID 930 0) init: 270) ; yesNo
					(DisposeScript 930)
					(IconBarF lighten:)
				)
				(cond
					(global748
						(if local20
							(if local21
								(local21
									setPri: 200
									view: (local21 prevView:)
									loop: (local21 prevLoop:)
									cycleSpeed: 2
									setCycle: BlinkFwd
								)
							)
							(global117 eachElementDo: #total 0)
							(localproc_0)
							(oldMaidFrame dispose:)
							(playerFrame dispose:)
							(eyeBall dispose:)
							(UnLoad 128 205)
							(UnLoad 128 206)
							(= local20 0)
						)
						(theDiscard release:)
						(Arrow endHand:)
						(Dealer rotate:)
						(global117 eachElementDo: #endHand)
						(maid dispose:)
						(card dispose:)
						(= state 3)
					)
					(global924
						(gGame quitGame:)
						(proc0_8 0)
					)
				)
				(Characters habitsOn: 1)
				(= ticks 30)
			)
			(17
				(EnableCursor)
				(= gNewRoomNum 975) ; chooseGame
			)
		)
	)
)

(instance compStageOneLoss of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(register oldMaidStage: 1)
				(if ((register face:) isNotHidden:)
					(= state -1)
				)
				(= ticks 1)
			)
			(1
				(Load rsVIEW (+ (register view:) 250))
				(proc0_12 205)
				(= ticks 210)
			)
			(2
				(register
					setPri: 200
					view: (+ (register view:) 250)
					loop: (+ (register loop:) 2)
					cel: 0
					cycleSpeed: 10
					setCycle: End self
				)
				(gSound play: 202)
			)
			(3
				(= ticks 1)
			)
			(4
				(register
					setPri: 200
					loop: (- (register loop:) 2)
					cel: 0
					cycleSpeed: 2
					setCycle: BlinkFwd
				)
				(register sayPN: 1000 2 83 0 (Random 1 5))
				(self dispose:)
			)
		)
	)
)

(instance compStageTwoLoss of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW (- (register view:) 30))
				(proc0_12 205)
				(= ticks 210)
			)
			(1
				(gSound play: 203)
				(register
					oldMaidStage: 2
					setPri: 200
					view: (- (register view:) 30)
					loop: (register loop:)
					cel: 0
					setCycle: 0
				)
				(= ticks 60)
			)
			(2
				(= ticks 1)
			)
			(3
				(register
					setPri: 200
					loop: (register loop:)
					cel: 0
					cycleSpeed: 2
					setCycle: BlinkFwd
				)
				(register sayPN: 1000 2 83 0 (Random 1 5))
				(self dispose:)
			)
		)
	)
)

(instance compStageThreeLoss of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(register oldMaidStage: 3)
				(= local21 register)
				(local21 prevView: (- (register view:) 220))
				(local21 prevLoop: (register loop:))
				(Load rsVIEW 240)
				(Load rsVIEW 241)
				(proc0_12 209)
				(= ticks 120)
			)
			(1
				(= temp0 (- (register view:) 220))
				(= temp1 (register x:))
				(= temp2 (register y:))
				(oldMaidFrame
					setPri: 200
					view: 240
					loop: (+ (* temp0 2) (register loop:))
					cel: 0
					posn: temp1 temp2
					init:
				)
				(gSound play: 204)
				(register
					setPri: 201
					view: 241
					loop: 0
					cel: 0
					posn:
						(+ [local56 (* temp0 2)] temp1)
						(+ [local56 (+ (* temp0 2) 1)] temp2)
					setCycle: 0
				)
				(= ticks 90)
			)
			(2
				(= ticks 1)
			)
			(3
				(register loop: (Random 0 2) cycleSpeed: 10 setCycle: End self)
			)
			(4
				(= ticks 120)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance humanStageOneLoss of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 203)
				(proc0_12 205)
				(= ticks 210)
			)
			(1
				(gSound play: 202)
				(playerFrame setPri: 1 view: 203 loop: 0 cel: 0 posn: 0 0 init:)
				(= ticks 120)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance humanStageTwoLoss of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 204)
				(proc0_12 205)
				(= ticks 210)
			)
			(1
				(gSound play: 203)
				(playerFrame setPri: 1 view: 204 loop: 0 cel: 0 posn: 0 0 init:)
				(= ticks 180)
			)
			(2
				(UnLoad 128 203)
				(self dispose:)
			)
		)
	)
)

(instance humanStageThreeLoss of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 205)
				(Load rsVIEW 206)
				(proc0_12 209)
				(= ticks 120)
			)
			(1
				(= ticks 1)
			)
			(2
				(gSound play: 210)
				(playerFrame
					view: 205
					loop: 0
					cel: 0
					setPri: 2000
					posn: 320 240
				)
				(eyeBall
					view: 206
					loop: 0
					cel: 0
					setPri: 1000
					posn: 320 240
					init:
					cycleSpeed: 9
					setCycle: End self
				)
				(playerFrame init:)
			)
			(3
				(= seconds 3)
			)
			(4
				(UnLoad 128 204)
				(self dispose:)
			)
		)
	)
)

(instance flasher of Prop
	(properties
		x 443
		y 209
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
				(= ticks 10)
			)
			(1
				(client
					setCycle: Walk
					setPri: 15
					setMotion:
						MoveTo
						[local23 register]
						[local23 (+ register 1)]
						self
				)
			)
			(2
				(client setScale: 0 loop: 4 cel: [local23 (+ register 2)])
				(= ticks 10)
			)
			(3
				(client
					setMotion:
						MoveTo
						[local23 (+ register 3)]
						[local23 (+ register 4)]
						self
				)
			)
			(4
				(client loop: 4 cel: [local23 (+ register 5)])
				(= ticks 10)
			)
			(5
				(client
					setMotion:
						MoveTo
						[local23 (+ register 6)]
						[local23 (+ register 7)]
						self
				)
			)
			(6
				(client loop: 4 cel: [local23 (+ register 8)])
				(proc0_9 (gCast elements:) 0)
				(if local11
					(cond
						((== (local11 view:) 6)
							(local11
								sayReg: 1000 2 63 0 (Random 1 2) 720 1 self
							)
						)
						((OneOf (local11 view:) 2 5 7 8 10 12 14 16)
							(local11
								sayReg: 1000 2 63 0 (Random 1 2) 720 1 self
							)
						)
						((OneOf (local11 view:) 0 1 4 9 11 13 15 17)
							(local11
								sayReg: 1000 2 63 0 (Random 1 2) 720 1 self
							)
						)
					)
				)
				(= ticks 10)
			)
			(7
				(gChar1 active: 0 posn: 59 327)
				(gChar2 active: 0 posn: 210 56)
				(gChar3 active: 0 posn: 582 148)
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
				(client
					view: 268
					loop: [local23 (+ register 9)]
					cel: 0
					setCycle: CT 5 1 self
				)
			)
			(9
				(client cycleSpeed: 0 setCycle: End self)
			)
			(10
				(client cycleSpeed: 6 cel: 5 setCycle: CT 0 -1 self)
				((local11 face:) cycleSpeed: 20 setPri: 14 setCycle: End self)
				(proc0_12 209)
			)
			(11 1)
			(12
				(client
					view: 200
					setCycle: 0
					loop: 4
					cel: [local23 (+ register 10)]
				)
				(= ticks 10)
			)
			(13
				(client cel: 7)
				(= ticks 120)
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
		(proc0_12 209)
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
		(cond
			((and argc (== param1 3))
				(if (self open: 2)
					(= temp0 (Str new:))
					(self
						writeString:
							(temp0
								format:
									{%d%d%d%d%2d%d%d%d%d%d%d}
									global227
									global226
									global385
									global878
									global384
									local22
									0
									0
									0
									0
									0
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
				(= global227 (temp1 asInteger:))
				(self readString: temp1 2)
				(= global226 (temp1 asInteger:))
				(self readString: temp1 2)
				(= global385 (temp1 asInteger:))
				(self readString: temp1 2)
				(= global878 (temp1 asInteger:))
				(self readString: temp1 3)
				(= global384 (temp1 asInteger:))
				(self readString: temp1 2)
				(= local22 (temp1 asInteger:))
				(self readString: temp1 2)
				(self readString: temp1 2)
				(self readString: temp1 2)
				(self readString: temp1 2)
				(self readString: temp1 2)
				(self close:)
				(temp1 dispose:)
				(return 0)
			)
			(else
				(= global227 1)
				(= global226 0)
				(= global385 7)
				(= global878 0)
				(= global384 0)
				(= local22 0)
				(= local17 0)
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
		(if (and local4 (== handDirection 1) (not size))
			(self centerX:)
		else
			(super calcNextX:)
		)
	)

	(method (calcNextY)
		(if (and local4 (== handDirection 2) (not size))
			(self centerY:)
		else
			(super calcNextY:)
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
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
					(proc0_12 904)
					(Characters say: 200 19 0 0 1 718)
					(return 1)
				)
				((and (or gTray (gCast contains: pairButton)) owner)
					(proc0_12 904)
					(owner say6: 18 15 71 0 1)
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
							(proc0_12 904)
							(= temp1 (hand4 owner:))
							(temp1
								sayReg: 200 (+ (proc200_3 temp1) 1) 70 0 1 718
							)
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
				(self view: (+ local15 suit) cel: rank faceUp: 1)
			)
			((and argc (not param1))
				(self view: (+ 54 global384) cel: 0 faceUp: 0)
			)
			(faceUp
				(self view: (+ 54 global384) cel: 0 faceUp: 0)
			)
			(else
				(self view: (+ local15 suit) cel: rank faceUp: 1)
			)
		)
	)

	(method (moveBack param1 param2 param3)
		(self hide:)
		(gSound play: 906)
		(= local12 600)
		(if global898
			(= local12 (+ 8 (* 4 (- 16 global898))))
		)
		(gTheCard1
			view: view
			setLoop: 0
			cel: cel
			posn: x y
			setStep: local12 local12
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
					(proc0_12 205)
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
		x 196
		y 318
		handNumber 3
		faceUp 1
		x1Dest 239
		y1Dest 168
		x2Dest 323
		y2Dest 168
	)

	(method (init)
		(= centerX (+ (/ (* 12 global396) 2) x))
		(= centerY y)
	)
)

(instance hand2 of OldMaidHand
	(properties
		x 71
		y 70
		handDirection 2
		type 1
		handNumber 2
		location 4
		x1Dest 286
		y1Dest 118
		x2Dest 286
		y2Dest 218
	)

	(method (init)
		(= centerY (+ (/ (* 12 global397) 2) y))
		(= centerX x)
	)
)

(instance hand3 of OldMaidHand
	(properties
		x 237
		y 18
		type 1
		handNumber 1
		location 1
		x1Dest 239
		y1Dest 168
		x2Dest 323
		y2Dest 168
	)

	(method (init)
		(= centerX (+ (/ (* 12 global396) 2) x))
		(= centerY y)
	)
)

(instance hand4 of OldMaidHand
	(properties
		x 500
		y 132
		handDirection 2
		type 1
		handNumber 4
		location 2
		x1Dest 286
		y1Dest 118
		x2Dest 286
		y2Dest 218
	)

	(method (init)
		(= centerY (+ (/ (* 12 global397) 2) y))
		(= centerX x)
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
			((and (== global227 0) (not local14))
				(= local15 216)
				(= local14 1)
				(for ((= temp0 0)) (< temp0 (Deck size:)) ((++ temp0))
					(if
						(and
							((Deck at: temp0) faceUp:)
							(!= ((Deck at: temp0) rank:) 0)
						)
						((Deck at: temp0)
							view: (+ local15 ((Deck at: temp0) suit:))
						)
					)
				)
			)
			((and (== global227 1) local14)
				(= local15 50)
				(= local14 0)
				(for ((= temp0 0)) (< temp0 (Deck size:)) ((++ temp0))
					(if
						(and
							((Deck at: temp0) faceUp:)
							(!= ((Deck at: temp0) rank:) 0)
						)
						((Deck at: temp0)
							view: (+ local15 ((Deck at: temp0) suit:))
						)
					)
				)
			)
		)
		(cond
			((and (== global226 0) (not local13))
				(= local13 1)
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
			((and (== global226 1) local13)
				(= local13 0)
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
		priority 100
		view 202
		loop 1
	)

	(method (init &tmp temp0 temp1 temp2)
		(= x (/ (- gScreenWidth 144) 2))
		(= y (/ (- gScreenHeight 150) 2))
		(= temp1 (Set new:))
		(for ((= temp0 0)) (< temp0 (hand1 size:)) ((++ temp0))
			(temp1 add: (hand1 at: temp0))
		)
		(KList 22 (temp1 elements:) 767 0) ; Sort
		(= temp2 0)
		(for ((= temp0 0)) (< temp0 (temp1 size:)) ((++ temp0))
			(if
				(and
					(< temp0 (- (temp1 size:) 1))
					(==
						((temp1 at: temp0) rank:)
						((temp1 at: (+ temp0 1)) rank:)
					)
				)
				(++ temp2)
				(+= temp0 1)
			)
		)
		(temp1 release: dispose:)
		(if (> temp2 1)
			(self loop: 1)
		else
			(self loop: 3)
		)
		(super init:)
		(self setPri: 100 show:)
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
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0)
		(if (super handleEvent: event)
			(pairButton setCycle: Fwd)
			(proc0_12 201)
			(event claimed: 1)
			(self dispose:)
			(while (hand1 findPair:)
				(= local2 (hand1 at: local0))
				(= local3 (hand1 at: local1))
				(local2 hide: posn: 500 500)
				(local3 hide: posn: 500 500)
				(hand1 eliminateCard: local2)
				(hand1 eliminateCard: local3)
				(local2 owner: 0)
				(local3 owner: 0)
				(theDiscard add: local2 local3)
				(hand1 posn:)
			)
			(roomScript cue:)
		)
	)
)

(instance pairBack of View
	(properties
		priority 20
		view 202
	)

	(method (init)
		(= x (- (/ (- gScreenWidth 144) 2) 0))
		(= y (- (/ (- gScreenHeight 150) 2) 0))
		(super init:)
		(self setPri: 20 show:)
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

