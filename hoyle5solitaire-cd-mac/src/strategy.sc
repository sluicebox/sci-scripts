;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6002)
(include sci.sh)
(use Main)
(use KeyMouse)
(use InvisibleWindow)
(use ManualSort)
(use TrackingView)
(use h5Messager)
(use sHand)
(use acesup)
(use Str)
(use Print)
(use IconBar)
(use Motion)
(use File)
(use Actor)
(use System)

(public
	strategy 0
	optionCode 2
	roomScript 3
	proc6002_4 4
	timeWindow 8
)

(local
	local0 = 1
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
	local25
	local26
	local27
	local28
)

(procedure (localproc_0 param1)
	((ScriptID 6080 0) doit: global928 (if argc param1 else 0)) ; scoreSolitaire
)

(procedure (proc6002_4 param1) ; UNUSED
	(if argc
		(= local13 param1)
	else
		(return local13)
	)
)

(procedure (localproc_1 &tmp temp0 temp1)
	(== temp0 0) ; UNINIT
	(while (< temp0 (Deck size:)) ; UNINIT
		(= temp1 (Deck at: temp0)) ; UNINIT
		(cond
			((and (== (temp1 rank:) 1) (== (temp1 suit:) 0))
				(= local14 temp1)
			)
			((and (== (temp1 rank:) 1) (== (temp1 suit:) 1))
				(= local15 temp1)
			)
			((and (== (temp1 rank:) 1) (== (temp1 suit:) 2))
				(= local16 temp1)
			)
			((and (== (temp1 rank:) 1) (== (temp1 suit:) 3))
				(= local17 temp1)
			)
		)
		(++ temp0) ; UNINIT
	)
)

(procedure (localproc_2)
	(if (not (and local14 local15 local16 local17))
		(localproc_1)
	)
	(Deck delete: local14)
	(Deck delete: local15)
	(Deck delete: local16)
	(Deck delete: local17)
	(Deck add: local17)
	(Deck add: local16)
	(Deck add: local15)
	(Deck add: local14)
)

(procedure (localproc_3)
	(justHands eachElementDo: #whereTo 2)
	(if (== global927 0)
		(hand1 x: 78)
		(hand2 x: 139)
		(hand3 x: 201)
		(hand4 x: 262)
		(hand5 x: 324)
		(hand6 x: 385)
		(hand7 x: 447)
		(hand8 x: 508)
		(hand1Empty x: 78 setPri: 1 init:)
		(hand2Empty x: 139 setPri: 1 init:)
		(hand3Empty x: 201 setPri: 1 init:)
		(hand4Empty x: 262 setPri: 1 init:)
		(hand5Empty x: 324 setPri: 1 init:)
		(hand6Empty x: 385 setPri: 1 init:)
		(hand7Empty x: 447 setPri: 1 init:)
		(hand8Empty x: 508 setPri: 1 init:)
		(theHands add: hand7 hand8)
	else
		(hand1 x: 137)
		(hand2 x: 200)
		(hand3 x: 263)
		(hand4 x: 326)
		(hand5 x: 389)
		(hand6 x: 452)
		(hand1Empty x: 137 setPri: 1 init:)
		(hand2Empty x: 200 setPri: 1 init:)
		(hand3Empty x: 263 setPri: 1 init:)
		(hand4Empty x: 326 setPri: 1 init:)
		(hand5Empty x: 389 setPri: 1 init:)
		(hand6Empty x: 452 setPri: 1 init:)
		(theHands delete: hand7 hand8)
	)
)

(instance strategy of HoyleRoom
	(properties
		style 14
	)

	(method (init)
		(DisableCursor)
		(if global921
			(= global896 0)
			(= global916 1)
		)
		(if (and (== gPrevRoomNum 975) (not global527)) ; chooseGame
			(gSound2 play: 826)
		)
		(= local10 0)
		(= gCardGameScriptNumber 6002)
		(= local13 0)
		(gChar1 active: 1)
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
		((= global929 strategy_opt) doit:)
		(= picture (+ global877 global385))
		(= local28 global385)
		(= local5 48)
		(super init:)
		(gChar1 view: 0 active: 1 setLoop: 2)
		(if global921
			((gChar1 face:) view: 0 loop: 4 cel: 0)
			(gChar1 x: -50 y: -50)
		else
			((gChar1 face:) view: 0)
			(gChar1 posn: -50 -50)
		)
		(if global921
			(gChar1 view: 0 loop: 4 cel: 0)
		)
		(gChar1 show: init:)
		(Characters init:)
		(= local12 0)
		(= global394 0)
		(= global265 0)
		(hand1 add: owner: 0)
		(hand2 add: owner: 0)
		(hand3 add: owner: 0)
		(hand4 add: owner: 0)
		(hand5 add: owner: 0)
		(hand6 add: owner: 0)
		(hand7 add: owner: 0)
		(hand8 add: owner: 0)
		(hand1 emptyView: hand1Empty)
		(hand2 emptyView: hand2Empty)
		(hand3 emptyView: hand3Empty)
		(hand4 emptyView: hand4Empty)
		(hand5 emptyView: hand5Empty)
		(hand6 emptyView: hand6Empty)
		(hand7 emptyView: hand7Empty)
		(hand8 emptyView: hand8Empty)
		(justHands add: hand1 hand2 hand3 hand4 hand5 hand6 hand7 hand8)
		(= gTheHands theHands)
		(theHands
			add:
				hand1
				hand2
				hand3
				hand4
				hand5
				hand6
				found1Hand
				found2Hand
				found3Hand
				found4Hand
		)
		(if (== global927 0)
			(theHands add: hand7 hand8)
		)
		((= gTheFoundations theFoundations)
			add: found1Hand found2Hand found3Hand found4Hand
		)
		(handleEventList add:)
		(Deck init: sCard)
		(Deck rankAces: 1)
		(localproc_1)
		(= global419 theStock)
		(global419 client: wasteHand)
		(global929 doit: 3)
		(= local9 1)
		(= global928 0)
		(= local4 0)
		(IconBarF init:)
		(if (not global115)
			(if (== gPrevRoomNum 6029) ; cardflick
				(= global113 global184)
				(= global402 global185)
			else
				(= global113 0)
				(= global402 0)
			)
		else
			(= global115 0)
		)
		(gameName init: setPri: 35)
		(gSong stop:)
		(if global878
			(PlaySong play: (+ 50 global878))
		)
		(cond
			((> 38 global878 30)
				(gSong setLoop: -1)
			)
			((not local13)
				(gSong setLoop: 1)
			)
		)
		(if global250
			(timeWindow init:)
		else
			(currentScoreWindow init:)
		)
		(self setScript: roomScript)
	)

	(method (handleEvent event)
		(if
			(and
				(not (event claimed:))
				(== evKEYBOARD (event type:))
				(== (event message:) KEY_TAB)
				local27
			)
			(event claimed: 1)
			(= local27 0)
			(tabView hide:)
		)
		(if
			(and
				(not (event claimed:))
				(== evKEYBOARD (event type:))
				(== (event message:) KEY_TAB)
			)
			(event claimed: 1)
			(tabView init: show:)
			(UpdateScreenItem tabView)
		)
		(super handleEvent: event)
		(if (handleEventList handleEvent: event)
			(event claimed: 1)
		)
	)

	(method (doit)
		(super doit:)
		(sDealer doit:)
	)

	(method (dispose &tmp temp0)
		(= local10 0)
		(= global418 0)
		(gDelayCast release:)
		(= global419 0)
		(= global458 0)
		(IconBarF dispose:)
		(sDealer dispose:)
		((KeyMouse objList:) release:)
		(dealList release: dispose:)
		(gTheHands
			eachElementDo: #release
			eachElementDo: #dispose
			release:
			dispose:
		)
		(gTheFoundations
			eachElementDo: #release
			eachElementDo: #dispose
			release:
			dispose:
		)
		(wasteHand release: dispose:)
		(justHands release: dispose:)
		(if (magList size:)
			(magList release:)
		)
		(if local27
			(tabView hide: dispose:)
		)
		(magList dispose:)
		(theHands dispose:)
		(theFoundations dispose:)
		(handleEventList release: dispose:)
		(hand1Empty dispose:)
		(hand2Empty dispose:)
		(hand3Empty dispose:)
		(hand4Empty dispose:)
		(hand5Empty dispose:)
		(hand6Empty dispose:)
		(hand7Empty dispose:)
		(hand8Empty dispose:)
		(if local22
			(timeWindow dispose:)
		else
			(currentScoreWindow dispose:)
		)
		(Deck dispose:)
		(magView dispose:)
		(gameName dispose:)
		(gTheIconBar disable:)
		(DisposeScript 6096)
		(DisposeScript 64941)
		(DisposeScript 9)
		(DisposeScript 6080)
		(DisposeScript 6090)
		(super dispose:)
	)
)

(instance strategy_opt of File
	(properties
		name {strategy.opt}
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
									{%d%d%2d%2d}
									local13
									global927
									local20
									local21
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
				(= local13 (temp1 asInteger:))
				(self readString: temp1 2)
				(= global927 (temp1 asInteger:))
				(self readString: temp1 3)
				(= local20 (temp1 asInteger:))
				(self readString: temp1 3)
				(= local21 (temp1 asInteger:))
				(temp1 dispose:)
				(self close:)
				(return 0)
			)
			(else
				(= local13 0)
				(= global927 0)
				(= local20 59)
				(= local21 59)
				(return 0)
			)
		)
	)
)

(instance roomScript of Script
	(properties)

	(method (doit &tmp temp0 temp1 temp2 [temp3 2] temp5 [temp6 4])
		(super doit: &rest)
		(if global525
			(= global525 0)
			(= local20 59)
			(= local21 59)
			(global929 doit: 3)
			(if local22
				(proc6022_7 {bestminutes} timeWindow)
				(proc6022_7 {bestseconds} timeWindow)
				(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
			)
		)
		(if (!= global385 local28)
			(if local22
				(proc6022_7 {back} timeWindow)
				(proc0_10 990 5 global385 0 0 1 timeWindow {back})
			else
				(proc6022_7 {back} currentScoreWindow)
				(proc0_10 990 5 global385 0 0 1 currentScoreWindow {back})
			)
			(= local28 global385)
		)
		(if
			(and
				global250
				local10
				(== state 5)
				(not local24)
				(not global253)
				local25
			)
			(= global251 (GetTime 1)) ; SysTime12
			(if (!= global252 global251)
				(= global252 global251)
				(if (== (++ global248) 60)
					(= global248 0)
				)
				(if (and (== global249 59) (== global248 0))
					(= global253 1)
				else
					(proc6022_7 {seconds} timeWindow)
					(proc6022_6 global248 92 5 1 {seconds} timeWindow)
					(if (== global248 0)
						(++ global249)
						(proc6022_7 {minutes} timeWindow)
						(proc6022_6 global249 70 5 1 {minutes} timeWindow)
					)
				)
			)
		else
			(= local25 1)
		)
		(if (and local10 (== state 5) (not global458))
			(cond
				(global109
					(if (not local1)
						(Load rsVIEW 985)
						(for
							((= temp1 0))
							(< temp1 (gTheHands size:))
							((++ temp1))
							
							(magList add: (gTheHands at: temp1))
						)
						(magList add: wasteHand)
						(= local1 1)
					)
					(for ((= temp1 0)) (< temp1 (magList size:)) ((++ temp1))
						(for
							((= temp2 (- ((magList at: temp1) size:) 1)))
							(> temp2 -1)
							((-- temp2))
							
							(= temp5 ((magList at: temp1) at: temp2))
							(if
								(and
									(temp5 faceUp:)
									(< (temp5 x:) gMouseX (+ (temp5 x:) 54))
									(< (temp5 y:) gMouseY (+ (temp5 y:) 77))
								)
								(magView
									init: (temp5 suit:) (- (temp5 rank:) 1)
								)
								(magView setPri: 100 show:)
								(= local0 1)
								(break)
							else
								(magView hide:)
							)
						)
						(if local0
							(= local0 0)
							(break)
						)
					)
				)
				(local1
					(UnLoad 128 985)
					(= local1 0)
					(magList release: dispose:)
					(magView hide:)
				)
			)
			(if
				(and
					(not global395)
					(not (wasteHand size:))
					(not global226)
					(theStock size:)
				)
				(theStock getCard:)
			)
			(cond
				(
					(and
						(==
							(= temp0
								(+
									(hand1 size:)
									(hand2 size:)
									(hand3 size:)
									(hand4 size:)
									(hand5 size:)
									(hand6 size:)
									(hand7 size:)
									(hand8 size:)
								)
							)
							48
						)
						(== (hand1 whereTo:) 2)
					)
					(justHands eachElementDo: #whereTo 1)
					(theFoundations eachElementDo: #buildOrder 4)
				)
				((or (theStock size:) (wasteHand size:))
					(justHands eachElementDo: #whereTo 2)
					(theFoundations eachElementDo: #buildOrder 0)
				)
			)
			(if (and (not global250) (!= local26 global928))
				(proc6022_7 {score} currentScoreWindow)
				(proc6022_6 global928 86 11 1 {score} currentScoreWindow)
				(= local26 global928)
			)
			(if (== global928 52)
				(= local24 1)
				(if global250
					(= local18 global248)
					(if
						(or
							(< (= local19 global249) local20)
							(and (== local19 local20) (< local18 local21))
						)
						(= local20 local19)
						(= local21 local18)
						(= local23 1)
						(global929 doit: 3)
					)
				else
					(proc6022_7 {score} currentScoreWindow)
					(proc6022_6 global928 86 11 1 {score} currentScoreWindow)
				)
				(endCode doit:)
			)
		)
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= local10 0)
				(= ticks (= ticks 1))
			)
			(1
				(= ticks 1)
			)
			(2
				(= ticks 10)
				(IconBar show:)
				(dealList add: found1Hand found2Hand found3Hand found4Hand)
				(sDealer init: dealList)
			)
			(3
				(gTheIconBar enable:)
				(if global524
					(= global524 0)
				)
				(= ticks 10)
			)
			(4
				(= local10 0)
				(= local12 0)
				(= local9 1)
				(for ((= temp1 0)) (< temp1 (Deck size:)) ((++ temp1))
					((Deck at: temp1) tailList: 0)
					((Deck at: temp1) whenPlayed: 0)
					((Deck at: temp1) previousHand: 0)
					((Deck at: temp1) inPlay: 0)
				)
				(= global226 1)
				(= global395 0)
				(Deck shuffle:)
				(localproc_1)
				(localproc_2)
				(= local6 0)
				(= global243 0)
				(= global928 4)
				(= local26 -1)
				(localproc_3)
				(= global252 -1)
				(= global248 0)
				(= global249 0)
				(= local24 0)
				(= global253 0)
				(= local23 0)
				(= local25 0)
				(sDealer deal: self)
			)
			(5
				(theFoundations eachElementDo: #buildOrder 0)
				(= local6 0)
				(= local11 0)
				(= local10 1)
				(EnableCursor)
				(resignButton setPri: 1 init:)
				((KeyMouse objList:) add: resignButton)
				(undoButton setPri: 1 init:)
				((KeyMouse objList:) add: undoButton)
				(= local7 0)
				(handleEventList add: hand1 hand2 hand3 hand4 hand5 hand6)
				(if (== global927 0)
					(handleEventList add: hand7 hand8)
				)
				(handleEventList
					add: found1Hand found2Hand found3Hand found4Hand
				)
				(handleEventList add: resignButton)
				(handleEventList add: wasteHand)
				(handleEventList add: undoButton)
				(global419
					init:
					client: wasteHand
					active: 1
					size: local5
					addKeyMouse:
				)
				(for ((= temp1 0)) (< temp1 (gTheHands size:)) ((++ temp1))
					((gTheHands at: temp1) partner: 0)
				)
				(= global225 0)
				(= global226 0)
				(= local4 1)
			)
		)
	)
)

(instance cleanUp of Code
	(properties)

	(method (doit &tmp temp0)
		(for ((= temp0 0)) (< temp0 (Deck size:)) ((++ temp0))
			(if ((Deck at: temp0) whenPlayed:)
				(((Deck at: temp0) whenPlayed:) release:)
				(((Deck at: temp0) whenPlayed:) dispose:)
			)
			(if ((Deck at: temp0) previousHand:)
				(((Deck at: temp0) previousHand:) release:)
				(((Deck at: temp0) previousHand:) dispose:)
			)
			(if ((Deck at: temp0) tailList:)
				(((Deck at: temp0) tailList:) release:)
			)
			((Deck at: temp0) tailList: 0)
			((Deck at: temp0) whenPlayed: 0)
			((Deck at: temp0) previousHand: 0)
		)
		(resignButton dispose:)
		(undoButton dispose:)
		(if (and local22 (!= global928 52))
			(proc6022_7 {seconds} timeWindow)
			(proc6022_7 {minutes} timeWindow)
		)
		(if local27
			(= local27 0)
			(tabView hide:)
		)
		(= local7 0)
		(gTheHands eachElementDo: #endHand)
		(wasteHand endHand:)
		((KeyMouse objList:) release:)
		(global419 endHand:)
		(handleEventList release:)
		(global419 dispose:)
		(proc0_9 (gCast elements:) 0)
		(dealList release:)
		(dealList add: found1Hand found2Hand found3Hand found4Hand)
		(sDealer init: dealList)
		(if global265
			(Deck sameDeck: 1)
			(= global265 0)
		)
		(if (!= global928 52)
			(roomScript changeState: 3)
		)
	)
)

(instance endCode of Code
	(properties)

	(method (doit)
		(if (not global519)
			(++ global221)
			(= global519 1)
			(gGame_opt doit: 3)
		)
		(cleanUp doit:)
		(if (and global250 local23)
			(Print
				ticks: 200
				fore: 0
				mode: 1
				addBitmap: 917 4 0
				font: gUserFont
				addText: {\n*******NEW BEST TIME!*******} 25 20
				init:
			)
			(proc6022_7 {seconds} timeWindow)
			(proc6022_7 {minutes} timeWindow)
			(proc6022_7 {bestminutes} timeWindow)
			(proc6022_7 {bestseconds} timeWindow)
			(if (and (== local20 59) (== local21 59))
				(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
			else
				(proc6022_6 local20 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 local21 92 20 1 {bestseconds} timeWindow)
			)
			(= local23 0)
		)
		(= local10 0)
		(localproc_0 1)
		(if local9
			((ScriptID 6080 1) doit: global928) ; scoreHand
		)
		(= local9 1)
		(DisableCursor)
		((ScriptID 6096 2) init:) ; aBanner
		(gSound2 play: 3000)
		((ScriptID 6096 2) setScript: (ScriptID 6096 1)) ; aBanner, sBannerOut
	)
)

(instance resignButton of TrackingView
	(properties
		x 596
		y 346
		view 915
		loop 10
	)

	(method (handleEvent event)
		(if (and (!= global928 52) (super handleEvent: event))
			(event claimed: 1)
			((ScriptID 930 0) init: 9131 3 gCurRoomNum) ; yesNo
			(DisposeScript 930)
			(if global748
				(handleEventList delete: self)
				(IconBarF darken:)
				(localproc_0 1)
				(IconBarF lighten:)
				(if local9
					((ScriptID 6080 1) doit: global928) ; scoreHand
				)
				(cleanUp doit:)
			)
		)
	)
)

(instance undoButton of TrackingView
	(properties
		x 4
		y 346
		view 915
		loop 14
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3)
		(if (and (!= global928 52) (super handleEvent: event))
			(event claimed: 1)
			(if (== global225 1)
				(Print
					ticks: 400
					fore: 0
					mode: 0
					addBitmap: 917 4 0
					font: gUserFont
					addText: {Unable to undo last move.} 10 10
					init:
				)
			else
				(= global226 1)
				(for ((= temp0 0)) (< temp0 (Deck size:)) ((++ temp0))
					(if
						(and
							((Deck at: temp0) whenPlayed:)
							(==
								(((Deck at: temp0) whenPlayed:)
									at:
										(-
											(((Deck at: temp0) whenPlayed:)
												size:
											)
											1
										)
								)
								global225
							)
						)
						(= temp3 (Deck at: temp0))
						(if
							(==
								((temp3 previousHand:)
									at: (- ((temp3 previousHand:) size:) 1)
								)
								2
							)
							(temp3 fromStock: 0)
							((temp3 owner:) eliminateCard: temp3)
							(temp3 hide:)
							(temp3 inPlay: 0)
							(if (> ((temp3 previousHand:) size:) 1)
								(for
									((= temp1 0))
									(<
										temp1
										(- ((temp3 previousHand:) size:) 1)
									)
									((++ temp1))
									
									(tempList
										add: ((temp3 previousHand:) at: temp1)
									)
								)
								((temp3 previousHand:) release:)
								(for
									((= temp1 0))
									(< temp1 (tempList size:))
									((++ temp1))
									
									((temp3 previousHand:)
										add: (tempList at: temp1)
									)
								)
								(tempList release:)
							else
								((temp3 previousHand:)
									delete:
										((temp3 previousHand:)
											at:
												(-
													((temp3 previousHand:)
														size:
													)
													1
												)
										)
								)
							)
							(if (< (theStock size:) 1)
								((ScriptID 15 7) show:) ; stockBack
							)
							(resetStock doit:)
							(= temp0 -1)
						else
							((temp3 owner:) eliminateCard: temp3)
							(temp3 inPlay: 1)
							(((temp3 previousHand:)
									at: (- ((temp3 previousHand:) size:) 1)
								)
								add: temp3
							)
							(if (> ((temp3 previousHand:) size:) 1)
								(for
									((= temp1 0))
									(<
										temp1
										(- ((temp3 previousHand:) size:) 1)
									)
									((++ temp1))
									
									(tempList
										add: ((temp3 previousHand:) at: temp1)
									)
								)
								((temp3 previousHand:) release:)
								(for
									((= temp1 0))
									(< temp1 (tempList size:))
									((++ temp1))
									
									((temp3 previousHand:)
										add: (tempList at: temp1)
									)
								)
								(tempList release:)
								(break)
							)
							((temp3 previousHand:)
								delete:
									((temp3 previousHand:)
										at: (- ((temp3 previousHand:) size:) 1)
									)
							)
							(break)
						)
					)
				)
				(= global226 0)
			)
		)
	)
)

(instance optionCode of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(if (== param1 1)
			(if (or (sDealer script:) (not local10))
				(= global920 1)
				(if global896
					(gChar1 sayReg: 600 15 128 0 (Random 1 2))
				else
					(gChar1 say: 600 15 128 0 2)
				)
			else
				(= local9 0)
				(cleanUp doit:)
			)
			(return 1)
		)
	)
)

(instance hand1 of sHand
	(properties
		y 40
		handDirection 2
		faceUp 1
		autoSorting 0
		cardLimit 13
		buildOrder 10
		buildStep 1
		startRank 3
		wrapping 1
		canTrack 1
		canPlay 1
		whereTo 2
	)
)

(instance hand2 of sHand
	(properties
		y 40
		handDirection 2
		faceUp 1
		autoSorting 0
		cardLimit 13
		buildOrder 10
		buildStep 1
		startRank 3
		wrapping 1
		canTrack 1
		canPlay 1
		whereTo 2
	)
)

(instance hand3 of sHand
	(properties
		y 40
		handDirection 2
		faceUp 1
		autoSorting 0
		cardLimit 13
		buildOrder 10
		buildStep 1
		startRank 3
		wrapping 1
		canTrack 1
		canPlay 1
		whereTo 2
	)
)

(instance hand4 of sHand
	(properties
		y 40
		handDirection 2
		faceUp 1
		autoSorting 0
		cardLimit 13
		buildOrder 10
		buildStep 1
		startRank 3
		wrapping 1
		canTrack 1
		canPlay 1
		whereTo 2
	)
)

(instance hand5 of sHand
	(properties
		y 40
		handDirection 2
		faceUp 1
		autoSorting 0
		cardLimit 13
		buildOrder 10
		buildStep 1
		startRank 3
		wrapping 1
		canTrack 1
		canPlay 1
		whereTo 2
	)
)

(instance hand6 of sHand
	(properties
		y 40
		handDirection 2
		faceUp 1
		autoSorting 0
		cardLimit 13
		buildOrder 10
		buildStep 1
		startRank 3
		wrapping 1
		canTrack 1
		canPlay 1
		whereTo 2
	)
)

(instance hand7 of sHand
	(properties
		y 40
		handDirection 2
		faceUp 1
		autoSorting 0
		cardLimit 13
		buildOrder 10
		buildStep 1
		startRank 3
		wrapping 1
		canTrack 1
		canPlay 1
		whereTo 2
	)
)

(instance hand8 of sHand
	(properties
		y 40
		handDirection 2
		faceUp 1
		autoSorting 0
		cardLimit 13
		buildOrder 10
		buildStep 1
		startRank 3
		wrapping 1
		canTrack 1
		canPlay 1
		whereTo 2
	)
)

(instance hand1Empty of View
	(properties
		y 40
		priority 1
		view 915
		loop 8
	)
)

(instance hand2Empty of View
	(properties
		y 40
		priority 1
		view 915
		loop 8
	)
)

(instance hand3Empty of View
	(properties
		y 40
		priority 1
		view 915
		loop 8
	)
)

(instance hand4Empty of View
	(properties
		y 40
		priority 1
		view 915
		loop 8
	)
)

(instance hand5Empty of View
	(properties
		y 40
		priority 1
		view 915
		loop 8
	)
)

(instance hand6Empty of View
	(properties
		y 40
		priority 1
		view 915
		loop 8
	)
)

(instance hand7Empty of View
	(properties
		y 40
		priority 1
		view 915
		loop 8
	)
)

(instance hand8Empty of View
	(properties
		y 40
		priority 1
		view 915
		loop 8
	)
)

(instance wasteHand of sHand
	(properties
		x 338
		y 298
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 4
		cardShow 1
		cardLimit 52
		buildOrder 10
		buildStep 1
		startRank 3
		wrapping 1
		canPlay 1
		orgX 338
		orgY 298
	)
)

(instance found1Hand of sHand
	(properties
		x 92
		y 298
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 1
		cardShow 1
		cardLimit 13
		buildOrder 4
		buildStep 1
		startRank 3
		wrapping 1
		canPlay 1
		cardsUp 1
		whereTo 2
	)
)

(instance found2Hand of sHand
	(properties
		x 162
		y 298
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 1
		cardShow 1
		cardLimit 13
		buildOrder 4
		buildStep 1
		startRank 3
		wrapping 1
		canPlay 1
		cardsUp 1
		whereTo 2
	)
)

(instance found3Hand of sHand
	(properties
		x 434
		y 298
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 1
		cardShow 1
		cardLimit 13
		buildOrder 4
		buildStep 1
		startRank 3
		wrapping 1
		canPlay 1
		cardsUp 1
		whereTo 2
	)
)

(instance found4Hand of sHand
	(properties
		x 506
		y 298
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 1
		cardShow 1
		cardLimit 13
		buildOrder 4
		buildStep 1
		startRank 3
		wrapping 1
		canPlay 1
		cardsUp 1
		whereTo 2
	)
)

(instance theHands of Set
	(properties)
)

(instance theFoundations of List
	(properties)
)

(instance justHands of List
	(properties)
)

(instance dealList of List
	(properties)
)

(instance magList of List
	(properties)
)

(instance tempList of List
	(properties)
)

(instance handleEventList of EventHandler
	(properties)
)

(instance theStock of Stock
	(properties
		priority 4
		offsetY 10
	)

	(method (init)
		(= x 248)
		(= y 285)
		(super init:)
		(= loop 0)
	)

	(method (validPlay)
		(return 1)
	)

	(method (adjust)
		(cond
			((< 8 size 13)
				(= local7 0)
				(self setLoop: 1 posn: (+ origX 8) (+ origY 7))
				((ScriptID 15 7) ; stockBack
					view: (+ 54 global384)
					setLoop: 0
					posn: (+ origX 8) (+ origY 7)
					show:
				)
			)
			((< 4 size 9)
				(= local7 0)
				(self setLoop: 2 posn: (+ origX 10) (+ origY 9))
				((ScriptID 15 7) ; stockBack
					view: (+ 54 global384)
					setLoop: 0
					posn: (+ origX 10) (+ origY 9)
					show:
				)
			)
			((< 0 size 5)
				(= local7 0)
				(self setLoop: 3 posn: (+ origX 12) (+ origY 11))
				((ScriptID 15 7) ; stockBack
					view: (+ 54 global384)
					setLoop: 0
					posn: (+ origX 12) (+ origY 11)
					show:
				)
			)
			((== size 0)
				(self setLoop: 4 posn: (+ origX 14) (+ origY 13))
				(= local7 1)
				((ScriptID 15 7) hide:) ; stockBack
			)
			(else
				(= local7 0)
				(self setLoop: 0 posn: origX origY)
				((ScriptID 15 7) ; stockBack
					view: (+ 54 global384)
					setLoop: 0
					posn: origX origY
					show:
				)
			)
		)
	)

	(method (getCard)
		(self setCel: 1)
		(DisableCursor)
		(if size
			(-- size)
			(if (< size 0)
				(= size 0)
			)
			(++ cardsTaken)
			((ScriptID 15 6) ; littleCard
				view: (+ 54 global384)
				posn: (+ x 18) (+ y 22)
				init:
			)
			(self adjust:)
			(= global395 1)
			((ScriptID 15 6) ; littleCard
				hide:
				setMotion: MoveTo (client calcNextX:) (client calcNextY:) self
			)
			(= global116 0)
		else
			(EnableCursor)
		)
	)

	(method (cue)
		(self setScript: stockScript)
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
				(= temp0 (getOne doit:))
				(UpdateScreenItem temp0)
				((ScriptID 15 6) dispose:) ; littleCard
				(= global395 0)
				(= cycles 1)
			)
			(2
				(theStock setCel: 0)
				(EnableCursor)
			)
		)
	)
)

(instance resetStock of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(= local2 (Deck topCard:))
		(= local3 (theStock size:))
		(= temp0 0)
		(for ((= temp1 0)) (< temp1 (Deck size:)) ((++ temp1))
			(if (not ((Deck at: temp1) inPlay:))
				(++ temp0)
			)
		)
		(theStock size: temp0)
		(theStock adjust:)
		(Deck topCard: 51)
	)
)

(instance getOne of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(= temp1 0)
		(while (< temp1 1)
			(= temp0 (Deck getCard:))
			(if (not (temp0 inPlay:))
				(temp0 flip: 1 show: init:)
				(temp0 fromStock: 1)
				((theStock client:) add: temp0)
				(++ temp1)
			)
		)
		(return temp0)
	)
)

(instance magView of View
	(properties)

	(method (init param1 param2)
		(= view 985)
		(= loop param1)
		(= cel param2)
		(= x 99)
		(= y 448)
		(super init: &rest)
	)
)

(instance gameName of View
	(properties
		x 220
		y 446
		priority 35
		view 977
		loop 25
	)
)

(instance currentScoreWindow of InvisibleWindow
	(properties
		left 421
		top 446
		right 577
		bottom 477
	)

	(method (init &tmp [temp0 2])
		(= priority 4)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(super init:)
		(proc0_10 990 5 global385 0 0 1 self {back})
		(proc0_10 990 2 0 0 0 5 self)
		(proc6022_6 global928 86 11 1 {score} self)
	)
)

(instance timeWindow of InvisibleWindow
	(properties
		left 421
		top 446
		right 577
		bottom 477
	)

	(method (init &tmp [temp0 2])
		(= priority 4)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(= local22 1)
		(super init:)
		(proc0_10 990 5 global385 0 0 1 self {back})
		(proc0_10 990 0 0 0 0 2 self)
		(proc0_10 979 12 11 131 5 15 self)
		(proc0_10 979 12 11 131 20 15 self)
		(proc6022_6 0 92 5 1 {seconds} timeWindow)
		(if (and (== local20 59) (== local21 59))
			(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
			(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
		else
			(proc6022_6 local20 70 20 1 {bestminutes} timeWindow)
			(proc6022_6 local21 92 20 1 {bestseconds} timeWindow)
		)
	)
)

(instance tabView of View
	(properties
		view 735
	)

	(method (init)
		(if (== global927 0)
			(= cel 0)
		else
			(= cel 1)
		)
		(self setPri: 256)
		(= local27 1)
		(super init: &rest)
	)
)

