;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6011)
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
	laBelleLucie 0
	proc6011_1 1
	optionCode 2
	roomScript 3
	proc6011_4 4
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
	local8 = 3
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
)

(procedure (proc6011_1 param1)
	((ScriptID 6080 0) doit: global928 (if argc param1 else 0)) ; scoreSolitaire
)

(procedure (proc6011_4 param1) ; UNUSED
	(if argc
		(= local7 param1)
	else
		(return local7)
	)
)

(procedure (localproc_0)
	(if (== global927 0)
		(= local8 3)
	else
		(= local8 2)
	)
)

(procedure (localproc_1 &tmp temp0 temp1)
	(== temp0 0) ; UNINIT
	(while (< temp0 (Deck size:)) ; UNINIT
		(= temp1 (Deck at: temp0)) ; UNINIT
		(cond
			((and (== (temp1 rank:) 1) (== (temp1 suit:) 0))
				(= local10 temp1)
			)
			((and (== (temp1 rank:) 1) (== (temp1 suit:) 1))
				(= local11 temp1)
			)
			((and (== (temp1 rank:) 1) (== (temp1 suit:) 2))
				(= local12 temp1)
			)
			((and (== (temp1 rank:) 1) (== (temp1 suit:) 3))
				(= local13 temp1)
			)
		)
		(++ temp0) ; UNINIT
	)
)

(procedure (localproc_2)
	(if (not (and local10 local11 local12 local13))
		(localproc_1)
	)
	(Deck delete: local10)
	(Deck delete: local11)
	(Deck delete: local12)
	(Deck delete: local13)
	(Deck add: local13)
	(Deck add: local12)
	(Deck add: local11)
	(Deck add: local10)
)

(procedure (localproc_3 &tmp temp0 temp1 temp2 temp3 temp4)
	(Deck release:)
	(for ((= temp0 0)) (< temp0 16) ((++ temp0))
		(if ((gTheHands at: temp0) size:)
			(for
				((= temp1 0))
				(< temp1 ((gTheHands at: temp0) size:))
				((++ temp1))
				
				(Deck add: ((gTheHands at: temp0) at: temp1))
			)
			((gTheHands at: temp0)
				eachElementDo: #hide
				eachElementDo: #deleteKeyMouse
				release:
			)
		)
	)
	(if (= temp3 (mod (= temp2 (Deck size:)) 3))
		(= temp4 (+ (/ temp2 3) 1))
		((gTheHands at: (- temp4 1)) cardsUp: temp3)
	else
		(= temp4 (/ temp2 3))
	)
	(dealList release:)
	(for ((= temp0 0)) (< temp0 temp4) ((++ temp0))
		(dealList add: (gTheHands at: temp0))
	)
	(= local23 (Deck size:))
	(Deck shuffle:)
	(sDealer init: dealList)
	(= global395 0)
	(sDealer deal: self)
)

(instance laBelleLucie of HoyleRoom
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
			(gSound2 play: 817)
		)
		(= local6 0)
		(= gCardGameScriptNumber 6011)
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
		((= global929 labelle_opt) doit:)
		(= picture (+ global877 global385))
		(= local26 global385)
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
		(hand8 add: owner: 0)
		(hand9 add: owner: 0)
		(hand10 add: owner: 0)
		(hand11 add: owner: 0)
		(hand12 add: owner: 0)
		(hand13 add: owner: 0)
		(hand14 add: owner: 0)
		(hand15 add: owner: 0)
		(hand16 add: owner: 0)
		((= gTheHands theHands)
			add:
				hand1
				hand2
				hand3
				hand4
				hand5
				hand6
				hand7
				hand8
				hand9
				hand10
				hand11
				hand12
				hand13
				hand14
				hand15
				hand16
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
				local25
			)
			(event claimed: 1)
			(= local25 0)
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
		(handleEventList release: dispose:)
		(if (TmpDeck size:)
			(for ((= temp0 0)) (< temp0 52) ((++ temp0))
				(Deck add: (TmpDeck at: temp0))
			)
			(TmpDeck release: dispose:)
		)
		(if local25
			(tabView hide: dispose:)
		)
		(if local19
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

(instance labelle_opt of File
	(properties
		name {labelle.opt}
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
									local17
									local18
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
				(= local17 (temp1 asInteger:))
				(self readString: temp1 3)
				(= local18 (temp1 asInteger:))
				(temp1 dispose:)
				(self close:)
				(return 0)
			)
			(else
				(= local7 0)
				(= global927 0)
				(= local17 59)
				(= local18 59)
				(return 0)
			)
		)
	)
)

(instance roomScript of Script
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 [temp5 2] temp7 [temp8 4] temp12)
		(super doit: &rest)
		(if global525
			(= global525 0)
			(= local17 59)
			(= local18 59)
			(global929 doit: 3)
			(if local19
				(proc6022_7 {bestminutes} timeWindow)
				(proc6022_7 {bestseconds} timeWindow)
				(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
			)
		)
		(if (!= global385 local26)
			(if local19
				(proc6022_7 {back} timeWindow)
				(proc0_10 990 5 global385 0 0 1 timeWindow {back})
			else
				(proc6022_7 {back} currentScoreWindow)
				(proc0_10 990 5 global385 0 0 1 currentScoreWindow {back})
			)
			(= local26 global385)
		)
		(if
			(and
				global250
				local6
				(== state 5)
				(not local21)
				(not global253)
				local22
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
			(= local22 1)
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
							
							(= temp7 ((gTheHands at: temp1) at: temp2))
							(if
								(and
									(temp7 faceUp:)
									(< (temp7 x:) gMouseX (+ (temp7 x:) 54))
									(< (temp7 y:) gMouseY (+ (temp7 y:) 77))
								)
								(magView
									init: (temp7 suit:) (- (temp7 rank:) 1)
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
			(if (< (Deck size:) 52)
				(= temp12 0)
				(for ((= temp1 0)) (< temp1 16) ((++ temp1))
					(+= temp12 ((gTheHands at: temp1) size:))
				)
				(if (== temp12 local23)
					(for ((= temp3 0)) (< temp3 (gTheFoundations size:)) ((++ temp3))
						(for
							((= temp4 0))
							(< temp4 ((gTheFoundations at: temp3) size:))
							((++ temp4))
							
							(Deck add: ((gTheFoundations at: temp3) at: temp4))
						)
					)
				)
			)
			(if (and (not global250) (!= local24 global928))
				(proc6022_7 {score} currentScoreWindow)
				(proc6022_6 global928 86 11 1 {score} currentScoreWindow)
				(= local24 global928)
			)
			(if (== global928 52)
				(= local21 1)
				(if global250
					(= local15 global248)
					(if
						(or
							(< (= local16 global249) local17)
							(and (== local16 local17) (< local15 local18))
						)
						(= local17 local16)
						(= local18 local15)
						(= local20 1)
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
				(if (== gPrevRoomNum 975) ; chooseGame
					(= seconds 2)
				else
					(= cycles 1)
				)
			)
			(2
				(= ticks 10)
				(IconBar show:)
				(dealList
					add:
						found1Hand
						found2Hand
						found3Hand
						found4Hand
						hand1
						hand2
						hand3
						hand4
						hand5
						hand6
						hand7
						hand8
						hand9
						hand10
						hand11
						hand12
						hand13
						hand14
						hand15
						hand16
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
				)
				(if (firstRedealList size:)
					(firstRedealList release:)
				)
				(if (secondRedealList size:)
					(secondRedealList release:)
				)
				(if (thirdRedealList size:)
					(thirdRedealList release:)
				)
				(= global226 1)
				(= global395 0)
				(Deck shuffle:)
				(localproc_1)
				(localproc_2)
				(= local2 0)
				(= global243 0)
				(= global928 4)
				(= local24 -1)
				(= global252 -1)
				(= global248 0)
				(= global249 0)
				(= local21 0)
				(= global253 0)
				(= local20 0)
				(= local22 0)
				(sDealer deal: self)
			)
			(5
				(localproc_0)
				(= local6 1)
				(= local9 0)
				(EnableCursor)
				(resignButton setPri: 1 init:)
				(reDealButton setPri: 1 init:)
				(undoButton setPri: 1 init:)
				((KeyMouse objList:) add: resignButton)
				((KeyMouse objList:) add: reDealButton)
				((KeyMouse objList:) add: undoButton)
				(= local3 0)
				(handleEventList
					add:
						hand1
						hand2
						hand3
						hand4
						hand5
						hand6
						hand7
						hand8
						hand9
						hand10
						hand11
						hand12
						hand13
						hand14
						hand15
						hand16
				)
				(handleEventList
					add: found1Hand found2Hand found3Hand found4Hand
				)
				(handleEventList add: resignButton reDealButton)
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
			((Deck at: temp0) tailList: 0)
			((Deck at: temp0) whenPlayed: 0)
			((Deck at: temp0) previousHand: 0)
			((Deck at: temp0) wasFaceDown: 0)
		)
		(if (firstRedealList size:)
			(firstRedealList release:)
		)
		(if (secondRedealList size:)
			(secondRedealList release:)
		)
		(if (thirdRedealList size:)
			(thirdRedealList release:)
		)
		(resignButton dispose:)
		(reDealButton dispose:)
		(undoButton dispose:)
		(if (and local19 (!= global928 52))
			(proc6022_7 {seconds} timeWindow)
			(proc6022_7 {minutes} timeWindow)
		)
		(if local25
			(= local25 0)
			(tabView hide:)
		)
		(= local3 0)
		(if (TmpDeck size:)
			(Deck release:)
			(for ((= temp0 0)) (< temp0 52) ((++ temp0))
				(Deck add: (TmpDeck at: temp0))
			)
			(TmpDeck release: dispose:)
		)
		(= local14 1)
		(gTheHands eachElementDo: #endHand)
		(gTheFoundations eachElementDo: #endHand)
		((KeyMouse objList:) release:)
		(handleEventList release:)
		(proc0_9 (gCast elements:) 0)
		(gTheFoundations eachElementDo: #followRank 0)
		(for ((= temp0 0)) (< temp0 16) ((++ temp0))
			((gTheHands at: temp0) cardsUp: 3)
		)
		(dealList release:)
		(dealList
			add:
				found1Hand
				found2Hand
				found3Hand
				found4Hand
				hand1
				hand2
				hand3
				hand4
				hand5
				hand6
				hand7
				hand8
				hand9
				hand10
				hand11
				hand12
				hand13
				hand14
				hand15
				hand16
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
		(if (not global510)
			(++ global221)
			(= global510 1)
			(gGame_opt doit: 3)
		)
		(cleanUp doit:)
		(if (and global250 local20)
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
			(if (and (== local17 59) (== local18 59))
				(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
			else
				(proc6022_6 local17 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 local18 92 20 1 {bestseconds} timeWindow)
			)
			(= local20 0)
		)
		(= local6 0)
		(proc6011_1 1)
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
				(proc6011_1 1)
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

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(if (and (!= global928 52) (super handleEvent: event))
			(event claimed: 1)
			(if (== global225 0)
				(Print
					ticks: 400
					fore: 0
					mode: 1
					addBitmap: 917 4 0
					font: gUserFont
					addText: {Unable to undo last move.} 10 10
					init:
				)
			else
				(= global226 1)
				(= global245 0)
				(for ((= temp0 0)) (< temp0 (Deck size:)) ((++ temp0))
					(cond
						(
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
							(= temp2 (Deck at: temp0))
							((temp2 owner:) eliminateCard: temp2)
							(temp2 inPlay: 1)
							(((temp2 previousHand:)
									at: (- ((temp2 previousHand:) size:) 1)
								)
								add: temp2
							)
							(if (> ((temp2 previousHand:) size:) 1)
								(for
									((= temp1 0))
									(<
										temp1
										(- ((temp2 previousHand:) size:) 1)
									)
									((++ temp1))
									
									(tempList
										add: ((temp2 previousHand:) at: temp1)
									)
								)
								((temp2 previousHand:) release:)
								(for
									((= temp1 0))
									(< temp1 (tempList size:))
									((++ temp1))
									
									((temp2 previousHand:)
										add: (tempList at: temp1)
									)
								)
								(tempList release:)
							else
								((temp2 previousHand:)
									delete:
										((temp2 previousHand:)
											at:
												(-
													((temp2 previousHand:)
														size:
													)
													1
												)
										)
								)
							)
							(temp2 show:)
							(UpdateScreenItem temp2)
							(break)
						)
						(
							(and
								(whenReset size:)
								(==
									(whenReset at: (- (whenReset size:) 1))
									global225
								)
							)
							(= global245 1)
							(for ((= temp0 0)) (< temp0 16) ((++ temp0))
								((gTheHands at: temp0) release:)
							)
							(= temp1 -1)
							(switch local9
								(1
									(for
										((= temp0 0))
										(< temp0 (firstRedealList size:))
										((++ temp0))
										
										(if (== (firstRedealList at: temp0) 1)
											(++ temp1)
										else
											((gTheHands at: temp1)
												add: (firstRedealList at: temp0)
											)
											((firstRedealList at: temp0) show:)
											(UpdateScreenItem
												(firstRedealList at: temp0)
											)
										)
									)
									(firstRedealList release:)
								)
								(2
									(for
										((= temp0 0))
										(< temp0 (secondRedealList size:))
										((++ temp0))
										
										(if (== (secondRedealList at: temp0) 1)
											(++ temp1)
										else
											((gTheHands at: temp1)
												add:
													(secondRedealList at: temp0)
											)
											((secondRedealList at: temp0) show:)
											(UpdateScreenItem
												(secondRedealList at: temp0)
											)
										)
									)
									(secondRedealList release:)
								)
								(3
									(for
										((= temp0 0))
										(< temp0 (thirdRedealList size:))
										((++ temp0))
										
										(if (== (thirdRedealList at: temp0) 1)
											(++ temp1)
										else
											((gTheHands at: temp1)
												add: (thirdRedealList at: temp0)
											)
											((thirdRedealList at: temp0) show:)
											(UpdateScreenItem
												(thirdRedealList at: temp0)
											)
										)
									)
									(thirdRedealList release:)
									(handleEventList add: reDealButton)
									(reDealButton show:)
								)
							)
							(-- local9)
							(-- global225)
							(whenReset
								delete: (whenReset at: (- (whenReset size:) 1))
							)
							(= global245 0)
							(break)
						)
					)
				)
				(= global226 0)
			)
		)
	)
)

(instance reDealButton of TrackingView
	(properties
		x 596
		y 284
		view 974
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if (and (!= global928 52) (super handleEvent: event))
			(event claimed: 1)
			(= global225 0)
			(if (not (TmpDeck size:))
				(for ((= temp0 0)) (< temp0 52) ((++ temp0))
					(TmpDeck add: (Deck at: temp0))
				)
				(= local14 1)
			)
			(= global245 1)
			(if (< local9 local8)
				(localproc_3)
			)
			(= global245 0)
			(++ local9)
		)
		(if (== local9 local8)
			(self hide:)
			(handleEventList delete: self)
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
		x 59
		y 55
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 59
		cardLimit 7
		buildOrder 5
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
	)
)

(instance hand2 of sHand
	(properties
		x 117
		y 55
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 117
		cardLimit 7
		buildOrder 5
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
	)
)

(instance hand3 of sHand
	(properties
		x 175
		y 55
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 175
		cardLimit 7
		buildOrder 5
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
	)
)

(instance hand4 of sHand
	(properties
		x 234
		y 55
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 234
		cardLimit 7
		buildOrder 5
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
	)
)

(instance hand5 of sHand
	(properties
		x 292
		y 55
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 292
		cardLimit 7
		buildOrder 5
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
	)
)

(instance hand6 of sHand
	(properties
		x 350
		y 55
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 350
		cardLimit 7
		buildOrder 5
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
	)
)

(instance hand7 of sHand
	(properties
		x 409
		y 55
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 409
		cardLimit 7
		buildOrder 5
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
	)
)

(instance hand8 of sHand
	(properties
		x 467
		y 55
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 467
		cardLimit 7
		buildOrder 5
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
	)
)

(instance hand9 of sHand
	(properties
		x 59
		y 213
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 59
		cardLimit 7
		buildOrder 5
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
	)
)

(instance hand10 of sHand
	(properties
		x 117
		y 213
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 117
		cardLimit 7
		buildOrder 5
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
	)
)

(instance hand11 of sHand
	(properties
		x 175
		y 213
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 175
		cardLimit 7
		buildOrder 5
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
	)
)

(instance hand12 of sHand
	(properties
		x 234
		y 213
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 234
		cardLimit 7
		buildOrder 5
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
	)
)

(instance hand13 of sHand
	(properties
		x 292
		y 213
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 292
		cardLimit 7
		buildOrder 5
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
	)
)

(instance hand14 of sHand
	(properties
		x 350
		y 213
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 350
		cardLimit 7
		buildOrder 5
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
	)
)

(instance hand15 of sHand
	(properties
		x 409
		y 213
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 409
		cardLimit 7
		buildOrder 5
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
	)
)

(instance hand16 of sHand
	(properties
		x 467
		y 213
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 467
		cardLimit 7
		buildOrder 5
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
	)
)

(instance found1Hand of sHand
	(properties
		x 528
		y 55
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
	)
)

(instance found2Hand of sHand
	(properties
		x 528
		y 133
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
	)
)

(instance found3Hand of sHand
	(properties
		x 528
		y 212
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
	)
)

(instance found4Hand of sHand
	(properties
		x 528
		y 291
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
	)
)

(instance hand1Empty of View ; UNUSED
	(properties
		x 59
		y 55
		view 915
		loop 8
	)
)

(instance hand2Empty of View ; UNUSED
	(properties
		x 117
		y 55
		view 915
		loop 8
	)
)

(instance hand3Empty of View ; UNUSED
	(properties
		x 175
		y 55
		view 915
		loop 8
	)
)

(instance hand4Empty of View ; UNUSED
	(properties
		x 234
		y 55
		view 915
		loop 8
	)
)

(instance hand5Empty of View ; UNUSED
	(properties
		x 292
		y 55
		view 915
		loop 8
	)
)

(instance hand6Empty of View ; UNUSED
	(properties
		x 350
		y 55
		view 915
		loop 8
	)
)

(instance hand7Empty of View ; UNUSED
	(properties
		x 409
		y 55
		view 915
		loop 8
	)
)

(instance hand8Empty of View ; UNUSED
	(properties
		x 467
		y 55
		view 915
		loop 8
	)
)

(instance hand9Empty of View ; UNUSED
	(properties
		x 59
		y 213
		view 915
		loop 8
	)
)

(instance hand10Empty of View ; UNUSED
	(properties
		x 117
		y 213
		view 915
		loop 8
	)
)

(instance hand11Empty of View ; UNUSED
	(properties
		x 175
		y 213
		view 915
		loop 8
	)
)

(instance hand12Empty of View ; UNUSED
	(properties
		x 234
		y 213
		view 915
		loop 8
	)
)

(instance hand13Empty of View ; UNUSED
	(properties
		x 292
		y 213
		view 915
		loop 8
	)
)

(instance hand14Empty of View ; UNUSED
	(properties
		x 350
		y 213
		view 915
		loop 8
	)
)

(instance hand15Empty of View ; UNUSED
	(properties
		x 409
		y 213
		view 915
		loop 8
	)
)

(instance hand16Empty of View ; UNUSED
	(properties
		x 467
		y 213
		view 915
		loop 8
	)
)

(instance TmpDeck of Set
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

(instance whenReset of List
	(properties)
)

(instance firstRedealList of List
	(properties)
)

(instance secondRedealList of List
	(properties)
)

(instance thirdRedealList of List
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
		loop 16
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
		(= local19 1)
		(super init:)
		(proc0_10 990 5 global385 0 0 1 self {back})
		(proc0_10 990 0 0 0 0 2 self)
		(proc0_10 979 12 11 131 5 15 self)
		(proc0_10 979 12 11 131 20 15 self)
		(proc6022_6 0 92 5 1 {seconds} timeWindow)
		(if (and (== local17 59) (== local18 59))
			(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
			(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
		else
			(proc6022_6 local17 70 20 1 {bestminutes} timeWindow)
			(proc6022_6 local18 92 20 1 {bestseconds} timeWindow)
		)
	)
)

(instance tabView of View
	(properties
		view 726
	)

	(method (init)
		(self setPri: 256)
		(= local25 1)
		(super init: &rest)
	)
)

