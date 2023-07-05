;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6024)
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
(use File)
(use Actor)
(use System)

(public
	penguin 0
	proc6024_1 1
	optionCode 2
	roomScript 3
	proc6024_4 4
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
)

(procedure (proc6024_1 param1)
	((ScriptID 6080 0) doit: global928 (if argc param1 else 0)) ; scoreSolitaire
)

(procedure (proc6024_4 param1) ; UNUSED
	(if argc
		(= local7 param1)
	else
		(return local7)
	)
)

(procedure (localproc_0 &tmp temp0 temp1)
	(for ((= temp0 0)) (< temp0 (Deck size:)) ((++ temp0))
		(= temp1 (Deck at: temp0))
		(cond
			((== local8 0)
				(= local8 temp1)
			)
			((and (== local9 0) (== (local8 rank:) (temp1 rank:)))
				(= local9 temp1)
			)
			((and (== local10 0) (== (local8 rank:) (temp1 rank:)))
				(= local10 temp1)
			)
			((and (== local11 0) (== (local8 rank:) (temp1 rank:)))
				(= local11 temp1)
			)
		)
	)
)

(procedure (localproc_1)
	(if (not (and local8 local9 local10 local11))
		(localproc_0)
	)
	(Deck delete: local8)
	(Deck delete: local9)
	(Deck delete: local10)
	(if (== global927 0)
		(Deck add: local8)
		(Deck add: local9)
		(Deck add: local10)
		(hand1 startRank: 3)
		(hand2 startRank: 3)
		(hand3 startRank: 3)
		(hand4 startRank: 3)
		(hand5 startRank: 3)
		(hand6 startRank: 3)
		(hand7 startRank: 3)
	else
		(Deck delete: local11)
		(Deck add: local11)
		(Deck add: local8)
		(Deck add: local9)
		(Deck add: local10)
		(hand1 startRank: 5)
		(hand2 startRank: 5)
		(hand3 startRank: 5)
		(hand4 startRank: 5)
		(hand5 startRank: 5)
		(hand6 startRank: 5)
		(hand7 startRank: 5)
	)
)

(instance penguin of HoyleRoom
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
			(gSound2 play: 819)
		)
		(= local6 0)
		(= gCardGameScriptNumber 6024)
		(= local7 0)
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
		((= global929 penguin_opt) doit:)
		(= picture (+ global877 global385))
		(= local22 global385)
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
		(hand5 add: owner: 0)
		(hand6 add: owner: 0)
		(hand7 add: owner: 0)
		(hand1 emptyView: hand1Empty)
		(hand1Empty setPri: 1 init: hide:)
		(hand2 emptyView: hand2Empty)
		(hand2Empty setPri: 1 init: hide:)
		(hand3 emptyView: hand3Empty)
		(hand3Empty setPri: 1 init: hide:)
		(hand4 emptyView: hand4Empty)
		(hand4Empty setPri: 1 init: hide:)
		(hand5 emptyView: hand5Empty)
		(hand5Empty setPri: 1 init: hide:)
		(hand6 emptyView: hand6Empty)
		(hand6Empty setPri: 1 init: hide:)
		(hand7 emptyView: hand7Empty)
		(hand7Empty setPri: 1 init: hide:)
		(res1Hand emptyView: res1Empty)
		(res2Hand emptyView: res2Empty)
		(res3Hand emptyView: res3Empty)
		(res4Hand emptyView: res4Empty)
		(res5Hand emptyView: res5Empty)
		(res6Hand emptyView: res6Empty)
		(res7Hand emptyView: res7Empty)
		(found1Hand emptyView: found1Empty)
		(found2Hand emptyView: found2Empty)
		(found3Hand emptyView: found3Empty)
		(found4Hand emptyView: found4Empty)
		((= gTheHands theHands)
			add:
				hand1
				hand2
				hand3
				hand4
				hand5
				hand6
				hand7
				found1Hand
				found2Hand
				found3Hand
				found4Hand
				res1Hand
				res2Hand
				res3Hand
				res4Hand
				res5Hand
				res6Hand
				res7Hand
		)
		((= gTheFoundations theFoundations)
			add: found1Hand found2Hand found3Hand found4Hand
		)
		(handleEventList add:)
		(Deck init: sCard)
		(Deck rankAces: 1)
		(global929 doit: 3)
		(= local5 1)
		(= global928 0)
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
			((not local7)
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
				local21
			)
			(event claimed: 1)
			(= local21 0)
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
		(= local6 0)
		(= global418 0)
		(gDelayCast release:)
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
		(theHands dispose:)
		(theFoundations dispose:)
		(if local21
			(tabView hide: dispose:)
		)
		(handleEventList release: dispose:)
		(hand1Empty dispose:)
		(hand2Empty dispose:)
		(hand3Empty dispose:)
		(hand4Empty dispose:)
		(hand5Empty dispose:)
		(hand6Empty dispose:)
		(hand7Empty dispose:)
		(found1Empty dispose:)
		(found2Empty dispose:)
		(found3Empty dispose:)
		(found4Empty dispose:)
		(res1Empty dispose:)
		(res2Empty dispose:)
		(res3Empty dispose:)
		(res4Empty dispose:)
		(res5Empty dispose:)
		(res6Empty dispose:)
		(res7Empty dispose:)
		(if local16
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

(instance penguin_opt of File
	(properties
		name {penguin.opt}
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
									local7
									global927
									local14
									local15
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
				(= local7 (temp1 asInteger:))
				(self readString: temp1 2)
				(= global927 (temp1 asInteger:))
				(self readString: temp1 3)
				(= local14 (temp1 asInteger:))
				(self readString: temp1 3)
				(= local15 (temp1 asInteger:))
				(temp1 dispose:)
				(self close:)
				(return 0)
			)
			(else
				(= local7 0)
				(= global927 0)
				(= local14 59)
				(= local15 59)
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
			(= local14 59)
			(= local15 59)
			(global929 doit: 3)
			(if local16
				(proc6022_7 {bestminutes} timeWindow)
				(proc6022_7 {bestseconds} timeWindow)
				(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
			)
		)
		(if (!= global385 local22)
			(if local16
				(proc6022_7 {back} timeWindow)
				(proc0_10 990 5 global385 0 0 1 timeWindow {back})
			else
				(proc6022_7 {back} currentScoreWindow)
				(proc0_10 990 5 global385 0 0 1 currentScoreWindow {back})
			)
			(= local22 global385)
		)
		(if
			(and
				global250
				local6
				(== state 5)
				(not local18)
				(not global253)
				local19
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
			(= local19 1)
		)
		(if (and local6 (== state 5))
			(cond
				(global109
					(if (not local1)
						(Load rsVIEW 985)
						(= local1 1)
					)
					(for ((= temp1 0)) (< temp1 (gTheHands size:)) ((++ temp1))
						(for
							((= temp2 (- ((gTheHands at: temp1) size:) 1)))
							(> temp2 -1)
							((-- temp2))
							
							(= temp5 ((gTheHands at: temp1) at: temp2))
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
					(magView hide:)
				)
			)
			(if (and (not global250) (!= local20 global928))
				(proc6022_7 {score} currentScoreWindow)
				(proc6022_6 global928 86 11 1 {score} currentScoreWindow)
				(= local20 global928)
			)
			(if (== global928 52)
				(= local18 1)
				(if global250
					(= local12 global248)
					(if
						(or
							(< (= local13 global249) local14)
							(and (== local13 local14) (< local12 local15))
						)
						(= local14 local13)
						(= local15 local12)
						(= local17 1)
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
				(= local6 0)
				(= ticks (= ticks 1))
			)
			(1
				(= ticks 1)
			)
			(2
				(= ticks 10)
				(IconBar show:)
				(dealList
					add:
						found1Hand
						found2Hand
						found3Hand
						hand1
						hand2
						hand3
						hand4
						hand5
						hand6
						hand7
				)
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
				(= local6 0)
				(= local5 1)
				(for ((= temp1 0)) (< temp1 (Deck size:)) ((++ temp1))
					((Deck at: temp1) tailList: 0)
					((Deck at: temp1) whenPlayed: 0)
					((Deck at: temp1) previousHand: 0)
					((Deck at: temp1) wasFaceDown: 0)
					((Deck at: temp1) wasTailList: 0)
				)
				(= global226 1)
				(= global395 0)
				(Deck shuffle:)
				(for ((= temp1 0)) (< temp1 (Deck size:)) ((++ temp1))
					(tmpDeck add: (Deck at: temp1))
				)
				(= local8 0)
				(= local9 0)
				(= local10 0)
				(= local11 0)
				(found1Hand followRank: 0)
				(found2Hand followRank: 0)
				(found3Hand followRank: 0)
				(found4Hand followRank: 0)
				(localproc_1)
				(= local2 0)
				(= global243 0)
				(= global928 3)
				(= local20 -1)
				(= global252 -1)
				(= global248 0)
				(= global249 0)
				(= local18 0)
				(= global253 0)
				(= local17 0)
				(= local19 0)
				(sDealer deal: self)
			)
			(5
				(= local6 1)
				(EnableCursor)
				(resignButton setPri: 1 init:)
				((KeyMouse objList:) add: resignButton)
				(undoButton setPri: 1 init:)
				((KeyMouse objList:) add: undoButton)
				(= local3 0)
				(res1Empty init: setPri: 1)
				(res2Empty init: setPri: 1)
				(res3Empty init: setPri: 1)
				(res4Empty init: setPri: 1)
				(res5Empty init: setPri: 1)
				(res6Empty init: setPri: 1)
				(res7Empty init: setPri: 1)
				(found4Empty init: setPri: 1)
				(handleEventList add: hand1 hand2 hand3 hand4 hand5 hand6 hand7)
				(handleEventList
					add:
						res1Hand
						res2Hand
						res3Hand
						res4Hand
						res5Hand
						res6Hand
						res7Hand
				)
				(handleEventList
					add: found1Hand found2Hand found3Hand found4Hand
				)
				(handleEventList add: resignButton)
				(handleEventList add: undoButton)
				(for ((= temp1 0)) (< temp1 (gTheHands size:)) ((++ temp1))
					((gTheHands at: temp1) partner: 0)
				)
				(= global225 0)
				(= global226 0)
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
			((Deck at: temp0) wasTailList: 0)
			((Deck at: temp0) tailList: 0)
			((Deck at: temp0) whenPlayed: 0)
			((Deck at: temp0) previousHand: 0)
			((Deck at: temp0) wasFaceDown: 0)
		)
		(resignButton dispose:)
		(undoButton dispose:)
		(if (and local16 (!= global928 52))
			(proc6022_7 {seconds} timeWindow)
			(proc6022_7 {minutes} timeWindow)
		)
		(if local21
			(= local21 0)
			(tabView hide:)
		)
		(= local3 0)
		(gTheHands eachElementDo: #endHand)
		((KeyMouse objList:) release:)
		(handleEventList release:)
		(proc0_9 (gCast elements:) 0)
		(if (tmpDeck size:)
			(Deck release:)
			(for ((= temp0 0)) (< temp0 (tmpDeck size:)) ((++ temp0))
				(Deck add: (tmpDeck at: temp0))
			)
			(tmpDeck release:)
		)
		(res1Empty dispose:)
		(res2Empty dispose:)
		(res3Empty dispose:)
		(res4Empty dispose:)
		(res5Empty dispose:)
		(res6Empty dispose:)
		(res7Empty dispose:)
		(dealList release:)
		(dealList
			add:
				found1Hand
				found2Hand
				found3Hand
				hand1
				hand2
				hand3
				hand4
				hand5
				hand6
				hand7
		)
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
		(if (not global512)
			(++ global221)
			(= global512 1)
			(gGame_opt doit: 3)
		)
		(cleanUp doit:)
		(if (and global250 local17)
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
			(if (and (== local14 59) (== local15 59))
				(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
			else
				(proc6022_6 local14 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 local15 92 20 1 {bestseconds} timeWindow)
			)
			(= local17 0)
		)
		(= local6 0)
		(proc6024_1 1)
		(if local5
			((ScriptID 6080 1) doit: global928) ; scoreHand
		)
		(= local5 1)
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
				(proc6024_1 1)
				(IconBarF lighten:)
				(if local5
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
		(if (super handleEvent: event)
			(event claimed: 1)
			(if (== global225 0)
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
										at: (- ((temp3 previousHand:) size:) 1)
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
			(if (or (sDealer script:) (not local6))
				(= global920 1)
				(if global896
					(gChar1 sayReg: 600 15 128 0 (Random 1 2))
				else
					(gChar1 say: 600 15 128 0 2)
				)
			else
				(= local5 0)
				(cleanUp doit:)
			)
			(return 1)
		)
	)
)

(instance hand1 of sHand
	(properties
		x 147
		y 24
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 147
		cardLimit 18
		buildOrder 5
		buildStep 1
		startRank 3
		wrapping 1
		canTrack 1
		canPlay 1
		cardsUp 7
		tailMove 1
	)
)

(instance hand1Empty of View
	(properties
		x 147
		y 24
		priority 1
		view 915
		loop 8
	)
)

(instance hand2 of sHand
	(properties
		x 210
		y 24
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 210
		cardLimit 18
		buildOrder 5
		buildStep 1
		startRank 3
		wrapping 1
		canTrack 1
		canPlay 1
		cardsUp 7
		tailMove 1
	)
)

(instance hand2Empty of View
	(properties
		x 210
		y 24
		priority 1
		view 915
		loop 8
	)
)

(instance hand3 of sHand
	(properties
		x 273
		y 24
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 273
		cardLimit 18
		buildOrder 5
		buildStep 1
		startRank 3
		wrapping 1
		canTrack 1
		canPlay 1
		cardsUp 7
		tailMove 1
	)
)

(instance hand3Empty of View
	(properties
		x 273
		y 24
		priority 1
		view 915
		loop 8
	)
)

(instance hand4 of sHand
	(properties
		x 336
		y 24
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 336
		cardLimit 18
		buildOrder 5
		buildStep 1
		startRank 3
		wrapping 1
		canTrack 1
		canPlay 1
		cardsUp 7
		tailMove 1
	)
)

(instance hand4Empty of View
	(properties
		x 336
		y 24
		priority 1
		view 915
		loop 8
	)
)

(instance hand5 of sHand
	(properties
		x 399
		y 24
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 399
		cardLimit 18
		buildOrder 5
		buildStep 1
		startRank 3
		wrapping 1
		canTrack 1
		canPlay 1
		cardsUp 7
		tailMove 1
	)
)

(instance hand5Empty of View
	(properties
		x 399
		y 24
		priority 1
		view 915
		loop 8
	)
)

(instance hand6 of sHand
	(properties
		x 462
		y 24
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 462
		cardLimit 18
		buildOrder 5
		buildStep 1
		startRank 3
		wrapping 1
		canTrack 1
		canPlay 1
		cardsUp 7
		tailMove 1
	)
)

(instance hand6Empty of View
	(properties
		x 462
		y 24
		priority 1
		view 915
		loop 8
	)
)

(instance hand7 of sHand
	(properties
		x 525
		y 24
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 525
		cardLimit 18
		buildOrder 5
		buildStep 1
		startRank 3
		wrapping 1
		canTrack 1
		canPlay 1
		cardsUp 7
		tailMove 1
	)
)

(instance hand7Empty of View
	(properties
		x 525
		y 24
		priority 1
		view 915
		loop 8
	)
)

(instance res1Hand of sHand
	(properties
		x 147
		y 320
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 147
		whatType 3
		cardShow 1
		cardLimit 1
		buildOrder 10
		buildStep 1
		startRank 3
		wrapping 1
		canTrack 1
		canPlay 1
	)

	(method (handleEvent event)
		(if (not size)
			(= global223 1)
			(if (and (super handleEvent: event) global222)
				(Print
					ticks: 400
					fore: 0
					mode: 0
					addBitmap: 917 4 0
					font: gUserFont
					addText:
						{The top card of any Column or Reserve\ncan be played to a Column, Reserve\nor Foundation.}
						6
						6
					init:
				)
			)
			(= global223 0)
		else
			(super handleEvent: event)
		)
	)
)

(instance res1Empty of View
	(properties
		x 147
		y 320
		priority 1
		view 915
		loop 8
	)
)

(instance res2Hand of sHand
	(properties
		x 210
		y 320
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 210
		whatType 3
		cardShow 1
		cardLimit 1
		buildOrder 10
		buildStep 1
		startRank 3
		wrapping 1
		canTrack 1
		canPlay 1
	)

	(method (handleEvent event)
		(if (not size)
			(= global223 1)
			(if (and (super handleEvent: event) global222)
				(Print
					ticks: 400
					fore: 0
					mode: 0
					addBitmap: 917 4 0
					font: gUserFont
					addText:
						{The top card of any Column or Reserve\ncan be played to a Column, Reserve\nor Foundation.}
						6
						6
					init:
				)
			)
			(= global223 0)
		else
			(super handleEvent: event)
		)
	)
)

(instance res2Empty of View
	(properties
		x 210
		y 320
		priority 1
		view 915
		loop 8
	)
)

(instance res3Hand of sHand
	(properties
		x 273
		y 320
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 273
		whatType 3
		cardShow 1
		cardLimit 1
		buildOrder 10
		buildStep 1
		startRank 3
		wrapping 1
		canTrack 1
		canPlay 1
	)

	(method (handleEvent event)
		(if (not size)
			(= global223 1)
			(if (and (super handleEvent: event) global222)
				(Print
					ticks: 400
					fore: 0
					mode: 0
					addBitmap: 917 4 0
					font: gUserFont
					addText:
						{The top card of any Column or Reserve\ncan be played to a Column, Reserve\nor Foundation.}
						6
						6
					init:
				)
			)
			(= global223 0)
		else
			(super handleEvent: event)
		)
	)
)

(instance res3Empty of View
	(properties
		x 273
		y 320
		priority 1
		view 915
		loop 8
	)
)

(instance res4Hand of sHand
	(properties
		x 336
		y 320
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 336
		whatType 3
		cardShow 1
		cardLimit 1
		buildOrder 10
		buildStep 1
		startRank 3
		wrapping 1
		canTrack 1
		canPlay 1
	)

	(method (handleEvent event)
		(if (not size)
			(= global223 1)
			(if (and (super handleEvent: event) global222)
				(Print
					ticks: 400
					fore: 0
					mode: 0
					addBitmap: 917 4 0
					font: gUserFont
					addText:
						{The top card of any Column or Reserve\ncan be played to a Column, Reserve\nor Foundation.}
						6
						6
					init:
				)
			)
			(= global223 0)
		else
			(super handleEvent: event)
		)
	)
)

(instance res4Empty of View
	(properties
		x 336
		y 320
		priority 1
		view 915
		loop 8
	)
)

(instance res5Hand of sHand
	(properties
		x 399
		y 320
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 399
		whatType 3
		cardShow 1
		cardLimit 1
		buildOrder 10
		buildStep 1
		startRank 3
		wrapping 1
		canTrack 1
		canPlay 1
	)

	(method (handleEvent event)
		(if (not size)
			(= global223 1)
			(if (and (super handleEvent: event) global222)
				(Print
					ticks: 400
					fore: 0
					mode: 0
					addBitmap: 917 4 0
					font: gUserFont
					addText:
						{The top card of any Column or Reserve\ncan be played to a Column, Reserve\nor Foundation.}
						6
						6
					init:
				)
			)
			(= global223 0)
		else
			(super handleEvent: event)
		)
	)
)

(instance res5Empty of View
	(properties
		x 399
		y 320
		priority 1
		view 915
		loop 8
	)
)

(instance res6Hand of sHand
	(properties
		x 462
		y 320
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 462
		whatType 3
		cardShow 1
		cardLimit 1
		buildOrder 10
		buildStep 1
		startRank 3
		wrapping 1
		canTrack 1
		canPlay 1
	)

	(method (handleEvent event)
		(if (not size)
			(= global223 1)
			(if (and (super handleEvent: event) global222)
				(Print
					ticks: 400
					fore: 0
					mode: 0
					addBitmap: 917 4 0
					font: gUserFont
					addText:
						{The top card of any Column or Reserve\ncan be played to a Column, Reserve\nor Foundation.}
						6
						6
					init:
				)
			)
			(= global223 0)
		else
			(super handleEvent: event)
		)
	)
)

(instance res6Empty of View
	(properties
		x 462
		y 320
		priority 1
		view 915
		loop 8
	)
)

(instance res7Hand of sHand
	(properties
		x 525
		y 320
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 525
		whatType 3
		cardShow 1
		cardLimit 1
		buildOrder 10
		buildStep 1
		startRank 3
		wrapping 1
		canTrack 1
		canPlay 1
	)

	(method (handleEvent event)
		(if (not size)
			(= global223 1)
			(if (and (super handleEvent: event) global222)
				(Print
					ticks: 400
					fore: 0
					mode: 0
					addBitmap: 917 4 0
					font: gUserFont
					addText:
						{The top card of any Column or Reserve\ncan be played to a Column, Reserve\nor Foundation.}
						6
						6
					init:
				)
			)
			(= global223 0)
		else
			(super handleEvent: event)
		)
	)
)

(instance res7Empty of View
	(properties
		x 525
		y 320
		priority 1
		view 915
		loop 8
	)
)

(instance found1Hand of sHand
	(properties
		x 60
		y 45
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
		cardsUp 1
		whereTo 2
	)
)

(instance found2Hand of sHand
	(properties
		x 60
		y 128
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
		cardsUp 1
		whereTo 2
	)
)

(instance found3Hand of sHand
	(properties
		x 60
		y 211
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
		cardsUp 1
		whereTo 2
	)
)

(instance found4Hand of sHand
	(properties
		x 60
		y 294
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
		whereTo 2
	)
)

(instance found1Empty of View
	(properties
		x 60
		y 45
		view 915
		loop 9
	)
)

(instance found2Empty of View
	(properties
		x 60
		y 128
		view 915
		loop 9
	)
)

(instance found3Empty of View
	(properties
		x 60
		y 211
		view 915
		loop 9
	)
)

(instance found4Empty of View
	(properties
		x 60
		y 294
		view 915
		loop 9
	)
)

(instance tmpDeck of Set
	(properties)
)

(instance theHands of List
	(properties)
)

(instance theFoundations of List
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
		loop 18
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
		(= local16 1)
		(super init:)
		(proc0_10 990 5 global385 0 0 1 self {back})
		(proc0_10 990 0 0 0 0 2 self)
		(proc0_10 979 12 11 131 5 15 self)
		(proc0_10 979 12 11 131 20 15 self)
		(proc6022_6 0 92 5 1 {seconds} timeWindow)
		(if (and (== local14 59) (== local15 59))
			(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
			(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
		else
			(proc6022_6 local14 70 20 1 {bestminutes} timeWindow)
			(proc6022_6 local15 92 20 1 {bestseconds} timeWindow)
		)
	)
)

(instance tabView of View
	(properties
		view 728
	)

	(method (init)
		(self setPri: 256)
		(= local21 1)
		(super init: &rest)
	)
)

