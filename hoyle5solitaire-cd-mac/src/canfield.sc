;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6006)
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
	canfield 0
	proc6006_1 1
	optionCode 2
	roomScript 3
	proc6006_4 4
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
)

(procedure (proc6006_1 param1)
	((ScriptID 6080 0) doit: global928 (if argc param1 else 0)) ; scoreSolitaire
)

(procedure (proc6006_4 param1) ; UNUSED
	(if argc
		(= local16 param1)
	else
		(return local16)
	)
)

(instance canfield of HoyleRoom
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
			(gSound2 play: 807)
		)
		(= local14 0)
		(= gCardGameScriptNumber 6006)
		(= local16 0)
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
		((= global929 canfield_opt) doit:)
		(= picture (+ global877 global385))
		(= local27 global385)
		(if (== global927 0)
			(reserveHand cardsDown: 10)
			(= local2 37)
		else
			(reserveHand cardsDown: 13)
			(= local2 34)
		)
		(= local6 1)
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
		(= global394 0)
		(= global265 0)
		(hand1 add: owner: 0)
		(hand2 add: owner: 0)
		(hand3 add: owner: 0)
		(hand4 add: owner: 0)
		(hand1 emptyView: hand1Empty)
		(hand1Empty setPri: 1 init: hide:)
		(hand2 emptyView: hand2Empty)
		(hand2Empty setPri: 1 init: hide:)
		(hand3 emptyView: hand3Empty)
		(hand3Empty setPri: 1 init: hide:)
		(hand4 emptyView: hand4Empty)
		(hand4Empty setPri: 1 init: hide:)
		(found1Hand emptyView: found1Empty)
		(found2Hand emptyView: found2Empty)
		(found3Hand emptyView: found3Empty)
		(found4Hand emptyView: found4Empty)
		(wasteHand growView: wasteGrow)
		(wasteGrow setPri: 2 init:)
		((= gTheHands theHands)
			add:
				hand1
				hand2
				hand3
				hand4
				found1Hand
				found2Hand
				found3Hand
				found4Hand
		)
		((= gTheFoundations theFoundations)
			add: found1Hand found2Hand found3Hand found4Hand
		)
		(handleEventList add:)
		(Deck init: sCard)
		(Deck rankAces: 1)
		(= global419 theStock)
		(global419 client: wasteHand)
		(global929 doit: 3)
		(= local13 1)
		(= global928 0)
		(= local8 0)
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
			((not local16)
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
				local26
			)
			(event claimed: 1)
			(= local26 0)
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
		(= local14 0)
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
		(reserveHand release: dispose:)
		(if (magList size:)
			(magList release:)
		)
		(if local26
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
		(found1Empty dispose:)
		(found2Empty dispose:)
		(found3Empty dispose:)
		(found4Empty dispose:)
		(wasteGrow dispose:)
		(reserveGrow dispose:)
		(if local21
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

(instance canfield_opt of File
	(properties
		name {canfield.opt}
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
									local16
									global927
									local19
									local20
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
				(= local16 (temp1 asInteger:))
				(self readString: temp1 2)
				(= global927 (temp1 asInteger:))
				(self readString: temp1 3)
				(= local19 (temp1 asInteger:))
				(self readString: temp1 3)
				(= local20 (temp1 asInteger:))
				(temp1 dispose:)
				(self close:)
				(return 0)
			)
			(else
				(= local16 0)
				(= global927 0)
				(= local19 59)
				(= local20 59)
				(return 0)
			)
		)
	)
)

(instance roomScript of Script
	(properties)

	(method (doit &tmp temp0 temp1 temp2 [temp3 2] temp5 temp6 [temp7 3])
		(super doit: &rest)
		(if global525
			(= global525 0)
			(= local19 59)
			(= local20 59)
			(global929 doit: 3)
			(if local21
				(proc6022_7 {bestminutes} timeWindow)
				(proc6022_7 {bestseconds} timeWindow)
				(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
			)
		)
		(if (!= global385 local27)
			(if local21
				(proc6022_7 {back} timeWindow)
				(proc0_10 990 5 global385 0 0 1 timeWindow {back})
			else
				(proc6022_7 {back} currentScoreWindow)
				(proc0_10 990 5 global385 0 0 1 currentScoreWindow {back})
			)
			(= local27 global385)
		)
		(if
			(and
				global250
				local14
				(== state 5)
				(not local23)
				(not global253)
				local24
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
			(= local24 1)
		)
		(if (and local14 (== state 5))
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
						(magList add: wasteHand reserveHand)
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
			(for ((= temp1 0)) (< temp1 (gTheHands size:)) ((++ temp1))
				(= temp6 (gTheHands at: temp1))
				(cond
					((!= (temp6 whatType:) 0))
					(
						(and
							(not (temp6 size:))
							(reserveHand size:)
							(not global458)
						)
						(= global458 (= temp5 (reserveHand lastCrd:)))
						(reserveHand eliminateCard: temp5)
						(reserveHand moveCard: temp6 temp6)
					)
				)
			)
			(if (and (not global250) (!= local25 global928))
				(proc6022_7 {score} currentScoreWindow)
				(proc6022_6 global928 86 11 1 {score} currentScoreWindow)
				(= local25 global928)
			)
			(if (== global928 52)
				(= local23 1)
				(if global250
					(= local17 global248)
					(if
						(or
							(< (= local18 global249) local19)
							(and (== local18 local19) (< local17 local20))
						)
						(= local19 local18)
						(= local20 local17)
						(= local22 1)
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
				(= local14 0)
				(= ticks (= ticks 1))
			)
			(1
				(= ticks 1)
			)
			(2
				(= ticks 10)
				(IconBar show:)
				(dealList add: hand1 hand2 hand3 hand4 found1Hand reserveHand)
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
				(= local14 0)
				(= local13 1)
				(for ((= temp1 0)) (< temp1 (Deck size:)) ((++ temp1))
					((Deck at: temp1) inPlay: 0)
					((Deck at: temp1) tailList: 0)
					((Deck at: temp1) whenPlayed: 0)
					((Deck at: temp1) previousHand: 0)
					((Deck at: temp1) numFromStock: 0)
					((Deck at: temp1) wasFaceDown: 0)
					((Deck at: temp1) fromStock: 0)
					((Deck at: temp1) wasReset: 0)
					((Deck at: temp1) wasTailList: 0)
				)
				(= global395 0)
				(Deck shuffle:)
				(= local3 0)
				(= global243 0)
				(= local8 0)
				(= global928 1)
				(= local25 -1)
				(= global226 1)
				(if (== global927 0)
					(hand1 tailMove: 2)
					(hand2 tailMove: 2)
					(hand3 tailMove: 2)
					(hand4 tailMove: 2)
				else
					(hand1 tailMove: 1)
					(hand2 tailMove: 1)
					(hand3 tailMove: 1)
					(hand4 tailMove: 1)
				)
				(reserveHand growView: 0)
				(= global252 -1)
				(= global248 0)
				(= global249 0)
				(= local23 0)
				(= global253 0)
				(= local22 0)
				(= local24 0)
				(sDealer deal: self)
			)
			(5
				(= local3 0)
				(reserveGrow setPri: 2 init:)
				(reserveHand growView: reserveGrow growAdjust:)
				(reserveHand eachElementDo: #flip 1)
				(= local14 1)
				(EnableCursor)
				(resignButton setPri: 1 init:)
				(flipButton setPri: 1 init: hide:)
				((KeyMouse objList:) add: resignButton)
				(undoButton setPri: 1 init:)
				((KeyMouse objList:) add: undoButton)
				(= local11 0)
				(= local10 0)
				(found1Empty init: setPri: 1 hide:)
				(found2Empty init: setPri: 1)
				(found3Empty init: setPri: 1)
				(found4Empty init: setPri: 1)
				(handleEventList add: hand1 hand2 hand3 hand4)
				(handleEventList
					add: found1Hand found2Hand found3Hand found4Hand
				)
				(handleEventList add: global419)
				(handleEventList add: resignButton)
				(handleEventList add: undoButton)
				(handleEventList add: wasteHand reserveHand)
				(global419
					init:
					client: wasteHand
					active: 1
					size: local2
					addKeyMouse:
				)
				(for ((= temp1 0)) (< temp1 (gTheHands size:)) ((++ temp1))
					((gTheHands at: temp1) partner: 0)
				)
				(= global225 0)
				(= global226 0)
				(= local8 1)
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
			(if ((Deck at: temp0) numFromStock:)
				(((Deck at: temp0) numFromStock:) release:)
				(((Deck at: temp0) numFromStock:) dispose:)
			)
			(if ((Deck at: temp0) tailList:)
				(((Deck at: temp0) tailList:) release:)
			)
			((Deck at: temp0) tailList: 0)
			((Deck at: temp0) whenPlayed: 0)
			((Deck at: temp0) previousHand: 0)
			((Deck at: temp0) numFromStock: 0)
			((Deck at: temp0) wasFaceDown: 0)
			((Deck at: temp0) fromStock: 0)
			((Deck at: temp0) wasReset: 0)
			((Deck at: temp0) wasTailList: 0)
		)
		(resignButton dispose:)
		(undoButton dispose:)
		(flipButton dispose:)
		(if (and local21 (!= global928 52))
			(proc6022_7 {seconds} timeWindow)
			(proc6022_7 {minutes} timeWindow)
		)
		(if local26
			(= local26 0)
			(tabView hide:)
		)
		(= local11 0)
		(= local10 0)
		(gTheHands eachElementDo: #endHand)
		(gTheFoundations eachElementDo: #followRank 0)
		(wasteHand endHand:)
		(reserveHand endHand:)
		(reserveHand growView: 0)
		((KeyMouse objList:) release:)
		(global419 endHand:)
		(handleEventList release:)
		(global419 dispose:)
		(proc0_9 (gCast elements:) 0)
		(dealList release:)
		(dealList add: hand1 hand2 hand3 hand4 found1Hand reserveHand)
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
		(if (not global500)
			(++ global221)
			(= global500 1)
			(gGame_opt doit: 3)
		)
		(cleanUp doit:)
		(if (and global250 local22)
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
			(if (and (== local19 59) (== local20 59))
				(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
			else
				(proc6022_6 local19 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 local20 92 20 1 {bestseconds} timeWindow)
			)
			(= local22 0)
		)
		(= local14 0)
		(proc6006_1 1)
		(if local13
			((ScriptID 6080 1) doit: global928) ; scoreHand
		)
		(= local13 1)
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
				(proc6006_1 1)
				(IconBarF lighten:)
				(if local13
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

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4)
		(if (and (!= global928 52) (super handleEvent: event))
			(event claimed: 1)
			(if (== global225 0)
				(Print
					ticks: 400
					fore: 0
					mode: 0
					addBitmap: 917 4 0
					font: gUserFont
					addText: {You can't undo yet.} 10 10
					init:
				)
			else
				(= global226 1)
				(= temp4 0)
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
						(cond
							(
								(and
									(> (temp3 wasTailList:) 0)
									(!=
										((temp3 owner:) indexOf: temp3)
										(- ((temp3 owner:) size:) 1)
									)
								)
								(temp3 wasTailList: (- (temp3 wasTailList:) 1))
								(for
									((= temp1 ((temp3 owner:) indexOf: temp3)))
									(< temp1 ((temp3 owner:) size:))
									((++ temp1))
									
									(tempList add: ((temp3 owner:) at: temp1))
								)
								(for
									((= temp1 (- ((temp3 owner:) size:) 1)))
									(> temp1 ((temp3 owner:) indexOf: temp3))
									((-- temp1))
									
									((temp3 owner:)
										delete: ((temp3 owner:) at: temp1)
									)
								)
								((temp3 owner:) eliminateCard: temp3)
								(((temp3 previousHand:)
										at: (- ((temp3 previousHand:) size:) 1)
									)
									add: temp3
								)
								(= global224 1)
								(for
									((= temp1 1))
									(< temp1 (tempList size:))
									((++ temp1))
									
									(((temp3 previousHand:)
											at:
												(-
													((temp3 previousHand:)
														size:
													)
													1
												)
										)
										add: (tempList at: temp1)
									)
								)
								(= global224 0)
								(tempList release:)
								(temp3 inPlay: 1)
								(if (> ((temp3 previousHand:) size:) 1)
									(for
										((= temp1 0))
										(<
											temp1
											(- ((temp3 previousHand:) size:) 1)
										)
										((++ temp1))
										
										(tempList
											add:
												((temp3 previousHand:)
													at: temp1
												)
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
							(
								(and
									(temp3 wasReset:)
									(==
										((temp3 previousHand:)
											at:
												(-
													((temp3 previousHand:)
														size:
													)
													1
												)
										)
										4
									)
								)
								(temp3 wasReset: (- (temp3 wasReset:) 1))
								(if (> ((temp3 previousHand:) size:) 1)
									(for
										((= temp1 0))
										(<
											temp1
											(- ((temp3 previousHand:) size:) 1)
										)
										((++ temp1))
										
										(tempList
											add:
												((temp3 previousHand:)
													at: temp1
												)
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
								(-- global225)
								(temp3 setWhenPlayed: 1)
								(for
									((= temp1 (- (Deck size:) 1)))
									(> temp1 -1)
									((-- temp1))
									
									(if (not ((Deck at: temp1) inPlay:))
										((Deck at: temp1)
											flip: 1
											init:
											inPlay: 1
										)
										(theStock size: (- (theStock size:) 1))
										((theStock client:)
											add: (Deck at: temp1)
										)
									)
								)
								(theStock adjust:)
							)
							(
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
											add:
												((temp3 previousHand:)
													at: temp1
												)
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
									(handleEventList add: global419)
									((ScriptID 15 7) show:) ; stockBack
								)
								(resetUndoStock doit:)
								(if
									(>
										((temp3 numFromStock:)
											at:
												(-
													((temp3 numFromStock:)
														size:
													)
													1
												)
										)
										1
									)
									(temp3 setNumFromStock: 0 1)
									(for ((= temp1 1)) (< temp1 3) ((++ temp1))
										(for
											((= temp0 0))
											(< temp0 (Deck size:))
											((++ temp0))
											
											(if
												(and
													((Deck at: temp0)
														whenPlayed:
													)
													(==
														(((Deck at: temp0)
																whenPlayed:
															)
															at:
																(-
																	(((Deck
																				at:
																					temp0
																			)
																			whenPlayed:
																		)
																		size:
																	)
																	1
																)
														)
														global225
													)
													(==
														(((Deck at: temp0)
																previousHand:
															)
															at:
																(-
																	(((Deck
																				at:
																					temp0
																			)
																			previousHand:
																		)
																		size:
																	)
																	1
																)
														)
														2
													)
												)
												(= temp3 (Deck at: temp0))
												(temp3 fromStock: 0)
												((temp3 owner:)
													eliminateCard: temp3
												)
												(temp3 hide:)
												(temp3 inPlay: 0)
												(if
													(>
														((temp3 previousHand:)
															size:
														)
														1
													)
													(for
														((= temp2 0))
														(<
															temp2
															(-
																((temp3
																		previousHand:
																	)
																	size:
																)
																1
															)
														)
														((++ temp2))
														
														(tempList
															add:
																((temp3
																		previousHand:
																	)
																	at: temp2
																)
														)
													)
													((temp3 previousHand:)
														release:
													)
													(for
														((= temp2 0))
														(<
															temp2
															(tempList size:)
														)
														((++ temp2))
														
														((temp3 previousHand:)
															add:
																(tempList
																	at: temp2
																)
														)
													)
													(tempList release:)
												else
													((temp3 previousHand:)
														delete:
															((temp3
																	previousHand:
																)
																at:
																	(-
																		((temp3
																				previousHand:
																			)
																			size:
																		)
																		1
																	)
															)
													)
												)
												(resetUndoStock doit:)
												(break)
											)
										)
										(if
											(==
												((temp3 numFromStock:)
													at:
														(-
															((temp3
																	numFromStock:
																)
																size:
															)
															1
														)
												)
												1
											)
											(temp3 setNumFromStock: 0 1)
											(break)
										else
											(temp3 setNumFromStock: 0 1)
										)
									)
									(break)
								)
								(temp3 setNumFromStock: 0 1)
								(break)
							)
							(else
								(if
									(and
										(== ((temp3 owner:) size:) 1)
										(==
											(((temp3 previousHand:)
													at:
														(-
															((temp3
																	previousHand:
																)
																size:
															)
															1
														)
												)
												whatType:
											)
											3
										)
									)
									(= temp4 1)
								)
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
											add:
												((temp3 previousHand:)
													at: temp1
												)
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
								(if temp4
									(= temp4 0)
									(for
										((= temp1 0))
										(< temp1 (Deck size:))
										((++ temp1))
										
										(if
											(and
												((Deck at: temp1) whenPlayed:)
												(==
													(((Deck at: temp1)
															whenPlayed:
														)
														at:
															(-
																(((Deck
																			at:
																				temp1
																		)
																		whenPlayed:
																	)
																	size:
																)
																1
															)
													)
													global225
												)
											)
											(= temp3 (Deck at: temp1))
											(if (temp3 wasTailList:)
												(temp3
													wasTailList:
														(-
															(temp3 wasTailList:)
															1
														)
												)
												(for
													((= temp1
														((temp3 owner:)
															indexOf: temp3
														)
													))
													(<
														temp1
														((temp3 owner:) size:)
													)
													((++ temp1))
													
													(tempList
														add:
															((temp3 owner:)
																at: temp1
															)
													)
												)
												(for
													((= temp1
														(-
															((temp3 owner:)
																size:
															)
															1
														)
													))
													(>
														temp1
														((temp3 owner:)
															indexOf: temp3
														)
													)
													((-- temp1))
													
													((temp3 owner:)
														delete:
															((temp3 owner:)
																at: temp1
															)
													)
												)
												((temp3 owner:)
													eliminateCard: temp3
												)
												(((temp3 previousHand:)
														at:
															(-
																((temp3
																		previousHand:
																	)
																	size:
																)
																1
															)
													)
													add: temp3
												)
												(= global224 1)
												(for
													((= temp1 1))
													(< temp1 (tempList size:))
													((++ temp1))
													
													(((temp3 previousHand:)
															at:
																(-
																	((temp3
																			previousHand:
																		)
																		size:
																	)
																	1
																)
														)
														add:
															(tempList at: temp1)
													)
												)
												(= global224 0)
												(tempList release:)
												(temp3 inPlay: 1)
												(if
													(>
														((temp3 previousHand:)
															size:
														)
														1
													)
													(for
														((= temp1 0))
														(<
															temp1
															(-
																((temp3
																		previousHand:
																	)
																	size:
																)
																1
															)
														)
														((++ temp1))
														
														(tempList
															add:
																((temp3
																		previousHand:
																	)
																	at: temp1
																)
														)
													)
													((temp3 previousHand:)
														release:
													)
													(for
														((= temp1 0))
														(<
															temp1
															(tempList size:)
														)
														((++ temp1))
														
														((temp3 previousHand:)
															add:
																(tempList
																	at: temp1
																)
														)
													)
													(tempList release:)
													(break)
												)
												((temp3 previousHand:)
													delete:
														((temp3 previousHand:)
															at:
																(-
																	((temp3
																			previousHand:
																		)
																		size:
																	)
																	1
																)
														)
												)
											else
												((temp3 owner:)
													eliminateCard: temp3
												)
												(temp3 inPlay: 1)
												(((temp3 previousHand:)
														at:
															(-
																((temp3
																		previousHand:
																	)
																	size:
																)
																1
															)
													)
													add: temp3
												)
												(if
													(>
														((temp3 previousHand:)
															size:
														)
														1
													)
													(for
														((= temp2 0))
														(<
															temp2
															(-
																((temp3
																		previousHand:
																	)
																	size:
																)
																1
															)
														)
														((++ temp2))
														
														(tempList
															add:
																((temp3
																		previousHand:
																	)
																	at: temp2
																)
														)
													)
													((temp3 previousHand:)
														release:
													)
													(for
														((= temp2 0))
														(<
															temp2
															(tempList size:)
														)
														((++ temp2))
														
														((temp3 previousHand:)
															add:
																(tempList
																	at: temp2
																)
														)
													)
													(tempList release:)
													(break)
												)
												((temp3 previousHand:)
													delete:
														((temp3 previousHand:)
															at:
																(-
																	((temp3
																			previousHand:
																		)
																		size:
																	)
																	1
																)
														)
												)
											)
											(break)
										)
									)
								)
							)
						)
						(break)
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
			(if (or (sDealer script:) (not local14))
				(= global920 1)
				(if global896
					(gChar1 sayReg: 600 15 128 0 (Random 1 2))
				else
					(gChar1 say: 600 15 128 0 2)
				)
			else
				(= local13 0)
				(cleanUp doit:)
			)
			(return 1)
		)
	)
)

(instance hand1 of sHand
	(properties
		x 268
		y 153
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 268
		cardLimit 15
		buildOrder 7
		buildStep 1
		startRank 3
		wrapping 1
		canTrack 1
		canPlay 1
		cardsUp 1
		tailMove 2
	)
)

(instance hand2 of sHand
	(properties
		x 342
		y 153
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 342
		cardLimit 15
		buildOrder 7
		buildStep 1
		startRank 3
		wrapping 1
		canTrack 1
		canPlay 1
		cardsUp 1
		tailMove 2
	)
)

(instance hand3 of sHand
	(properties
		x 419
		y 153
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 419
		cardLimit 15
		buildOrder 7
		buildStep 1
		startRank 3
		wrapping 1
		canTrack 1
		canPlay 1
		cardsUp 1
		tailMove 2
	)
)

(instance hand4 of sHand
	(properties
		x 496
		y 153
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 496
		cardLimit 15
		buildOrder 7
		buildStep 1
		startRank 3
		wrapping 1
		canTrack 1
		canPlay 1
		cardsUp 1
		tailMove 2
	)
)

(instance hand1Empty of View
	(properties
		x 268
		y 153
		priority 1
		view 915
		loop 8
	)
)

(instance hand2Empty of View
	(properties
		x 342
		y 153
		priority 1
		view 915
		loop 8
	)
)

(instance hand3Empty of View
	(properties
		x 419
		y 153
		priority 1
		view 915
		loop 8
	)
)

(instance hand4Empty of View
	(properties
		x 496
		y 153
		priority 1
		view 915
		loop 8
	)
)

(instance wasteHand of sHand
	(properties
		x 185
		y 293
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
		orgX 185
		orgY 293
	)
)

(instance wasteGrow of View
	(properties
		x 185
		y 293
		priority 1
		view 915
		loop 4
	)
)

(instance reserveHand of sHand
	(properties
		x 172
		y 154
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 3
		cardShow 1
		cardLimit 13
		buildStep 1
		startRank 3
		canPlay 1
		cardsDown 10
		orgX 172
		orgY 154
	)
)

(instance reserveGrow of View
	(properties
		x 172
		y 154
		priority 1
		view 915
		loop 4
	)
)

(instance found1Hand of sHand
	(properties
		x 268
		y 51
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 1
		cardShow 1
		cardLimit 13
		buildOrder 4
		buildStep 1
		startRank 4
		wrapping 1
		canPlay 1
		cardsUp 1
		whereTo 2
	)
)

(instance found2Hand of sHand
	(properties
		x 342
		y 51
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 1
		cardShow 1
		cardLimit 13
		buildOrder 4
		buildStep 1
		startRank 4
		wrapping 1
		canPlay 1
		whereTo 2
	)
)

(instance found3Hand of sHand
	(properties
		x 419
		y 51
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 1
		cardShow 1
		cardLimit 13
		buildOrder 4
		buildStep 1
		startRank 4
		wrapping 1
		canPlay 1
		whereTo 2
	)
)

(instance found4Hand of sHand
	(properties
		x 496
		y 51
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 1
		cardShow 1
		cardLimit 13
		buildOrder 4
		buildStep 1
		startRank 4
		wrapping 1
		canPlay 1
		whereTo 2
	)
)

(instance found1Empty of View
	(properties
		x 268
		y 51
		view 915
		loop 9
	)
)

(instance found2Empty of View
	(properties
		x 342
		y 51
		view 915
		loop 9
	)
)

(instance found3Empty of View
	(properties
		x 419
		y 51
		view 915
		loop 9
	)
)

(instance found4Empty of View
	(properties
		x 496
		y 51
		view 915
		loop 9
	)
)

(instance theHands of List
	(properties)
)

(instance theFoundations of List
	(properties)
)

(instance magList of List
	(properties)
)

(instance dealList of List
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
		(= x 87)
		(= y 280)
		(super init:)
		(= loop 0)
	)

	(method (validPlay)
		(return 1)
	)

	(method (adjust)
		(cond
			((< 8 size 13)
				(= local11 0)
				(self setLoop: 1 posn: (+ origX 8) (+ origY 7))
				((ScriptID 15 7) ; stockBack
					view: (+ 54 global384)
					setLoop: 0
					posn: (+ origX 8) (+ origY 7)
					show:
				)
			)
			((< 4 size 9)
				(= local11 0)
				(self setLoop: 2 posn: (+ origX 10) (+ origY 9))
				((ScriptID 15 7) ; stockBack
					view: (+ 54 global384)
					setLoop: 0
					posn: (+ origX 10) (+ origY 9)
					show:
				)
			)
			((< 0 size 5)
				(handleEventList delete: flipButton)
				(flipButton hide:)
				(handleEventList add: global419)
				(= local11 0)
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
				(handleEventList delete: global419)
				(handleEventList addToEnd: flipButton)
				(flipButton show:)
				(= local11 1)
				((ScriptID 15 7) hide:) ; stockBack
			)
			(else
				(= local11 0)
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
		(DisableCursor)
		(= local10 0)
		(= local9 0)
		(if (or (and (== local6 1) size) (and (== local6 0) size))
			(-= size (if (== local6 1) 3 else 1))
			(if (< size 0)
				(= size 0)
			)
			(++ cardsTaken)
			((ScriptID 15 6) ; littleCard
				view: (+ 54 global384)
				posn: (+ x 18) (+ y 22)
				init:
			)
			(= local15 (Deck topCard:))
			(self adjust:)
			(= global395 1)
			(if (== local6 1)
				(= local9 1)
			)
			((ScriptID 15 6) ; littleCard
				hide:
				setMotion: MoveTo (client calcNextX:) (client calcNextY:) self
			)
			(= global116 0)
		else
			(EnableCursor)
			(timesThru doit:)
		)
	)

	(method (cue)
		(self setScript: stockScript)
	)
)

(instance flipButton of TrackingView
	(properties
		x 101
		y 293
		priority 1
		view 915
		loop 7
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(timesThru doit:)
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
				(if local9
					(= temp0 (getThree doit:))
				else
					(= temp0 (getOne doit:))
				)
				(= local9 0)
				(UpdateScreenItem temp0)
				((ScriptID 15 6) dispose:) ; littleCard
				(= global395 0)
				(= cycles 1)
			)
			(2
				(EnableCursor)
			)
		)
	)
)

(instance getThree of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2)
		(= temp1 0)
		(= temp2 0)
		(while (< temp1 3)
			(if (>= (Deck topCard:) 0)
				(= temp0 (Deck getCard:))
				(if (not (temp0 inPlay:))
					(++ temp1)
					(= temp2 temp0)
					(gSound play: 903)
					(temp0 flip: 1 init:)
					(temp0 fromStock: 1 setNumFromStock: temp1)
					((theStock client:) add: temp0)
				)
			else
				(++ temp1)
			)
		)
		(return temp2)
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
				(temp0 fromStock: 1 setNumFromStock: 1)
				((theStock client:) add: temp0)
				(++ temp1)
			)
		)
		(return temp0)
	)
)

(instance resetStock of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(= local5 (theStock size:))
		(= temp0 0)
		(flipButton hide:)
		(if (wasteHand size:)
			(++ global225)
			((wasteHand at: 0) wasReset: (+ ((wasteHand at: 0) wasReset:) 1))
			((wasteHand at: 0) setWhenPlayed: setPreviousHand: 4)
		)
		(for ((= temp1 0)) (< temp1 (wasteHand size:)) ((++ temp1))
			((wasteHand at: temp1) inPlay: 0)
		)
		(for ((= temp1 0)) (< temp1 52) ((++ temp1))
			(if (not ((Deck at: temp1) inPlay:))
				(++ temp0)
			)
		)
		((theStock client:) eachElementDo: #hide)
		(if ((theStock client:) size:)
			((theStock client:) release:)
		)
		(if ((theStock client:) growView:)
			((theStock client:) growAdjust:)
		)
		(theStock size: temp0)
		(theStock adjust:)
		(Deck topCard: 51)
	)
)

(instance resetUndoStock of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(= local4 (Deck topCard:))
		(= local5 (theStock size:))
		(= temp0 0)
		(for ((= temp1 0)) (< temp1 52) ((++ temp1))
			(if (not ((Deck at: temp1) inPlay:))
				(++ temp0)
			)
		)
		(theStock size: temp0)
		(theStock adjust:)
		(Deck topCard: 51)
	)
)

(instance timesThru of Code
	(properties)

	(method (doit)
		(= local3 1)
		(resetStock doit:)
		(if
			(not
				(and (== (theStock size:) 0) (== ((theStock client:) size:) 0))
			)
			(handleEventList add: global419)
			(handleEventList delete: flipButton)
		)
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
		loop 6
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
		(= local21 1)
		(super init:)
		(proc0_10 990 5 global385 0 0 1 self {back})
		(proc0_10 990 0 0 0 0 2 self)
		(proc0_10 979 12 11 131 5 15 self)
		(proc0_10 979 12 11 131 20 15 self)
		(proc6022_6 0 92 5 1 {seconds} timeWindow)
		(if (and (== local19 59) (== local20 59))
			(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
			(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
		else
			(proc6022_6 local19 70 20 1 {bestminutes} timeWindow)
			(proc6022_6 local20 92 20 1 {bestseconds} timeWindow)
		)
	)
)

(instance tabView of View
	(properties
		view 716
	)

	(method (init)
		(self setPri: 256)
		(= local26 1)
		(super init: &rest)
	)
)

