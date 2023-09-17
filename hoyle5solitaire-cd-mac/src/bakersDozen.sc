;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6013)
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
	bakersDozen 0
	optionCode 2
	roomScript 3
	proc6013_4 4
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
)

(procedure (localproc_0 param1)
	((ScriptID 6080 0) doit: global928 (if argc param1 else 0)) ; scoreSolitaire
)

(procedure (proc6013_4 param1) ; UNUSED
	(if argc
		(= local7 param1)
	else
		(return local7)
	)
)

(procedure (localproc_1 &tmp temp0 temp1 temp2 temp3)
	(for ((= temp0 0)) (< temp0 (gTheHands size:)) ((++ temp0))
		(= temp3 (gTheHands at: temp0))
		(if (!= (temp3 whatType:) 0)
		else
			(for ((= temp1 0)) (< temp1 4) ((++ temp1))
				(= temp2 (temp3 at: temp1))
				(if (and (== (temp2 rank:) 13) (temp2 faceUp:))
					(localproc_2 temp3 temp2)
				)
			)
		)
	)
)

(procedure (localproc_2 param1 param2 &tmp temp0)
	(param1 delete: param2)
	(param1 addToFront: param2)
	(for ((= temp0 0)) (< temp0 4) ((++ temp0))
		((param1 at: temp0) y: (+ (param1 y:) (* temp0 global397)))
	)
)

(procedure (localproc_3)
	(if (== global927 0)
		(gTheHands eachElementDo: #cardsDown 1 eachElementDo: #cardsUp 3)
	else
		(gTheHands eachElementDo: #cardsDown 2 eachElementDo: #cardsUp 2)
	)
	(gTheFoundations eachElementDo: #cardsDown 0 eachElementDo: #cardsUp 0)
)

(instance bakersDozen of HoyleRoom
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
			(gSound2 play: 802)
		)
		(= local6 0)
		(= gCardGameScriptNumber 6013)
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
		((= global929 bakers_opt) doit:)
		(= picture (+ global877 global385))
		(= local18 global385)
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
				hand8
				hand9
				hand10
				hand11
				hand12
				hand13
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
				local17
			)
			(event claimed: 1)
			(= local17 0)
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
		(if local17
			(tabView hide: dispose:)
		)
		(if local12
			(timeWindow dispose:)
		else
			(currentScoreWindow dispose:)
		)
		(Deck dispose:)
		(magView dispose:)
		(gameName dispose:)
		(found1Empty dispose:)
		(found2Empty dispose:)
		(found3Empty dispose:)
		(found4Empty dispose:)
		(gTheIconBar disable:)
		(DisposeScript 6096)
		(DisposeScript 64941)
		(DisposeScript 9)
		(DisposeScript 6080)
		(DisposeScript 6090)
		(super dispose:)
	)
)

(instance bakers_opt of File
	(properties
		name {bakers.opt}
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
									local10
									local11
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
				(= local10 (temp1 asInteger:))
				(self readString: temp1 3)
				(= local11 (temp1 asInteger:))
				(temp1 dispose:)
				(self close:)
				(return 0)
			)
			(else
				(= local7 0)
				(= global927 0)
				(= local10 59)
				(= local11 59)
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
			(= local10 59)
			(= local11 59)
			(global929 doit: 3)
			(if local12
				(proc6022_7 {bestminutes} timeWindow)
				(proc6022_7 {bestseconds} timeWindow)
				(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
			)
		)
		(if (!= global385 local18)
			(if local12
				(proc6022_7 {back} timeWindow)
				(proc0_10 990 5 global385 0 0 1 timeWindow {back})
			else
				(proc6022_7 {back} currentScoreWindow)
				(proc0_10 990 5 global385 0 0 1 currentScoreWindow {back})
			)
			(= local18 global385)
		)
		(if
			(and
				global250
				local6
				(== state 5)
				(not local14)
				(not global253)
				local15
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
			(= local15 1)
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
			(if (and (not global250) (!= local16 global928))
				(proc6022_7 {score} currentScoreWindow)
				(proc6022_6 global928 86 11 1 {score} currentScoreWindow)
				(= local16 global928)
			)
			(if (== global928 52)
				(= local14 1)
				(if global250
					(= local8 global248)
					(if
						(or
							(< (= local9 global249) local10)
							(and (== local9 local10) (< local8 local11))
						)
						(= local10 local9)
						(= local11 local8)
						(= local13 1)
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
					((Deck at: temp1) inPlay: 0)
					((Deck at: temp1) tailList: 0)
					((Deck at: temp1) whenPlayed: 0)
					((Deck at: temp1) previousHand: 0)
					((Deck at: temp1) wasFaceDown: 0)
				)
				(= global395 0)
				(Deck shuffle:)
				(= local2 0)
				(= global243 0)
				(= global226 1)
				(= global928 0)
				(= local16 -1)
				(localproc_3)
				(= global252 -1)
				(= global248 0)
				(= global249 0)
				(= local14 0)
				(= global253 0)
				(= local13 0)
				(= local15 0)
				(sDealer deal: self)
			)
			(5
				(localproc_1)
				(= local6 1)
				(EnableCursor)
				(resignButton setPri: 1 init:)
				((KeyMouse objList:) add: resignButton)
				(undoButton setPri: 1 init:)
				((KeyMouse objList:) add: undoButton)
				(= local3 0)
				(found1Empty init: setPri: 1)
				(found2Empty init: setPri: 1)
				(found3Empty init: setPri: 1)
				(found4Empty init: setPri: 1)
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
			((Deck at: temp0) tailList: 0)
			((Deck at: temp0) whenPlayed: 0)
			((Deck at: temp0) previousHand: 0)
			((Deck at: temp0) wasFaceDown: 0)
		)
		(resignButton dispose:)
		(undoButton dispose:)
		(if (and local12 (!= global928 52))
			(proc6022_7 {seconds} timeWindow)
			(proc6022_7 {minutes} timeWindow)
		)
		(if local17
			(= local17 0)
			(tabView hide:)
		)
		(= local3 0)
		(gTheHands eachElementDo: #endHand)
		((KeyMouse objList:) release:)
		(handleEventList release:)
		(proc0_9 (gCast elements:) 0)
		(gTheFoundations eachElementDo: #followRank 0)
		(dealList release:)
		(dealList
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
		(if (not global495)
			(++ global221)
			(= global495 1)
			(gGame_opt doit: 3)
		)
		(cleanUp doit:)
		(if (and global250 local13)
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
			(if (and (== local10 59) (== local11 59))
				(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
			else
				(proc6022_6 local10 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 local11 92 20 1 {bestseconds} timeWindow)
			)
			(= local13 0)
		)
		(= local6 0)
		(localproc_0 1)
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
				(localproc_0 1)
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
								(< temp1 (- ((temp2 previousHand:) size:) 1))
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
							(break)
						)
						((temp2 previousHand:)
							delete:
								((temp2 previousHand:)
									at: (- ((temp2 previousHand:) size:) 1)
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
		x 73
		y 26
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 73
		cardLimit 11
		buildOrder 2
		buildStep 1
		canTrack 1
		canPlay 1
		cardsDown 1
		cardsUp 3
	)
)

(instance hand2 of sHand
	(properties
		x 133
		y 26
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 133
		cardLimit 11
		buildOrder 2
		buildStep 1
		canTrack 1
		canPlay 1
		cardsDown 1
		cardsUp 3
	)
)

(instance hand3 of sHand
	(properties
		x 194
		y 26
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 194
		cardLimit 11
		buildOrder 2
		buildStep 1
		canTrack 1
		canPlay 1
		cardsDown 1
		cardsUp 3
	)
)

(instance hand4 of sHand
	(properties
		x 253
		y 26
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 253
		cardLimit 11
		buildOrder 2
		buildStep 1
		canTrack 1
		canPlay 1
		cardsDown 1
		cardsUp 3
	)
)

(instance hand5 of sHand
	(properties
		x 314
		y 26
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 314
		cardLimit 11
		buildOrder 2
		buildStep 1
		canTrack 1
		canPlay 1
		cardsDown 1
		cardsUp 3
	)
)

(instance hand6 of sHand
	(properties
		x 373
		y 26
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 373
		cardLimit 11
		buildOrder 2
		buildStep 1
		canTrack 1
		canPlay 1
		cardsDown 1
		cardsUp 3
	)
)

(instance hand7 of sHand
	(properties
		x 434
		y 26
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 434
		cardLimit 11
		buildOrder 2
		buildStep 1
		canTrack 1
		canPlay 1
		cardsDown 1
		cardsUp 3
	)
)

(instance hand8 of sHand
	(properties
		x 97
		y 223
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 97
		cardLimit 11
		buildOrder 2
		buildStep 1
		canTrack 1
		canPlay 1
		cardsDown 1
		cardsUp 3
	)
)

(instance hand9 of sHand
	(properties
		x 156
		y 223
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 156
		cardLimit 11
		buildOrder 2
		buildStep 1
		canTrack 1
		canPlay 1
		cardsDown 1
		cardsUp 3
	)
)

(instance hand10 of sHand
	(properties
		x 217
		y 223
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 217
		cardLimit 11
		buildOrder 2
		buildStep 1
		canTrack 1
		canPlay 1
		cardsDown 1
		cardsUp 3
	)
)

(instance hand11 of sHand
	(properties
		x 277
		y 223
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 277
		cardLimit 11
		buildOrder 2
		buildStep 1
		canTrack 1
		canPlay 1
		cardsDown 1
		cardsUp 3
	)
)

(instance hand12 of sHand
	(properties
		x 337
		y 223
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 337
		cardLimit 11
		buildOrder 2
		buildStep 1
		canTrack 1
		canPlay 1
		cardsDown 1
		cardsUp 3
	)
)

(instance hand13 of sHand
	(properties
		x 397
		y 223
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 397
		cardLimit 11
		buildOrder 2
		buildStep 1
		canTrack 1
		canPlay 1
		cardsDown 1
		cardsUp 3
	)
)

(instance found1Hand of sHand
	(properties
		x 512
		y 26
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 1
		cardShow 1
		cardLimit 13
		buildOrder 4
		buildStep 1
		startRank 2
	)
)

(instance found2Hand of sHand
	(properties
		x 512
		y 125
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 1
		cardShow 1
		cardLimit 13
		buildOrder 4
		buildStep 1
		startRank 2
	)
)

(instance found3Hand of sHand
	(properties
		x 512
		y 224
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 1
		cardShow 1
		cardLimit 13
		buildOrder 4
		buildStep 1
		startRank 2
	)
)

(instance found4Hand of sHand
	(properties
		x 512
		y 322
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 1
		cardShow 1
		cardLimit 13
		buildOrder 4
		buildStep 1
		startRank 2
	)
)

(instance found1Empty of View
	(properties
		x 512
		y 26
		view 915
		loop 9
	)
)

(instance found2Empty of View
	(properties
		x 512
		y 125
		view 915
		loop 9
	)
)

(instance found3Empty of View
	(properties
		x 512
		y 224
		view 915
		loop 9
	)
)

(instance found4Empty of View
	(properties
		x 512
		y 322
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
		loop 1
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
		(= local12 1)
		(super init:)
		(proc0_10 990 5 global385 0 0 1 self {back})
		(proc0_10 990 0 0 0 0 2 self)
		(proc0_10 979 12 11 131 5 15 self)
		(proc0_10 979 12 11 131 20 15 self)
		(proc6022_6 0 92 5 1 {seconds} timeWindow)
		(if (and (== local10 59) (== local11 59))
			(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
			(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
		else
			(proc6022_6 local10 70 20 1 {bestminutes} timeWindow)
			(proc6022_6 local11 92 20 1 {bestseconds} timeWindow)
		)
	)
)

(instance tabView of View
	(properties
		view 711
	)

	(method (init)
		(self setPri: 255)
		(= local17 1)
		(super init: &rest)
	)
)

