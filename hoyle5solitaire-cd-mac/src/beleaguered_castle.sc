;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6004)
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
	beleaguered_castle 0
	proc6004_1 1
	optionCode 2
	roomScript 3
	proc6004_4 4
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
	[local8 13]
	local21
	local22
	local23
	local24
	local25
	local26
	local27
	local28
	local29
	local30
	local31
	local32
	local33
	local34
	local35
)

(procedure (proc6004_1 param1)
	((ScriptID 6080 0) doit: global928 (if argc param1 else 0)) ; scoreSolitaire
)

(procedure (proc6004_4 param1) ; UNUSED
	(if argc
		(= local7 param1)
	else
		(return local7)
	)
)

(procedure (localproc_0 &tmp temp0 temp1)
	(== temp0 0) ; UNINIT
	(while (< temp0 (Deck size:)) ; UNINIT
		(= temp1 (Deck at: temp0)) ; UNINIT
		(cond
			((and (== (temp1 rank:) 1) (== (temp1 suit:) 0))
				(= local21 temp1)
			)
			((and (== (temp1 rank:) 1) (== (temp1 suit:) 1))
				(= local22 temp1)
			)
			((and (== (temp1 rank:) 1) (== (temp1 suit:) 2))
				(= local23 temp1)
			)
			((and (== (temp1 rank:) 1) (== (temp1 suit:) 3))
				(= local24 temp1)
			)
		)
		(++ temp0) ; UNINIT
	)
)

(procedure (localproc_1)
	(if (not (and local21 local22 local23 local24))
		(localproc_0)
	)
	(Deck delete: local21)
	(Deck delete: local22)
	(Deck delete: local23)
	(Deck delete: local24)
	(Deck add: local24)
	(Deck add: local23)
	(Deck add: local22)
	(Deck add: local21)
)

(instance beleaguered_castle of HoyleRoom
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
			(gSound2 play: 803)
		)
		(= local6 0)
		(= gCardGameScriptNumber 6004)
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
		((= global929 belcastl_opt) doit:)
		(= picture (+ global877 global385))
		(= local35 global385)
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
		(hand8 emptyView: hand8Empty)
		(hand8Empty setPri: 1 init: hide:)
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
		(localproc_0)
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
				local34
			)
			(event claimed: 1)
			(= local34 0)
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
		(if local34
			(tabView hide: dispose:)
		)
		(if local29
			(timeWindow dispose:)
		else
			(currentScoreWindow dispose:)
		)
		(Deck dispose:)
		(magView dispose:)
		(gameName dispose:)
		(hand1Empty dispose:)
		(hand2Empty dispose:)
		(hand3Empty dispose:)
		(hand4Empty dispose:)
		(hand5Empty dispose:)
		(hand6Empty dispose:)
		(hand7Empty dispose:)
		(hand8Empty dispose:)
		(gTheIconBar disable:)
		(DisposeScript 6096)
		(DisposeScript 64941)
		(DisposeScript 9)
		(DisposeScript 6080)
		(DisposeScript 6090)
		(super dispose:)
	)
)

(instance belcastl_opt of File
	(properties
		name {belcastl.opt}
	)

	(method (doit param1 &tmp temp0 temp1)
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
									local27
									local28
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
				(= local27 (temp1 asInteger:))
				(self readString: temp1 3)
				(= local28 (temp1 asInteger:))
				(temp1 dispose:)
				(self close:)
				(return 0)
			)
			(else
				(= local7 0)
				(= global927 0)
				(= local27 59)
				(= local28 59)
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
			(= local27 59)
			(= local28 59)
			(global929 doit: 3)
			(if local29
				(proc6022_7 {bestminutes} timeWindow)
				(proc6022_7 {bestseconds} timeWindow)
				(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
			)
		)
		(if (!= global385 local35)
			(if local29
				(proc6022_7 {back} timeWindow)
				(proc0_10 990 5 global385 0 0 1 timeWindow {back})
			else
				(proc6022_7 {back} currentScoreWindow)
				(proc0_10 990 5 global385 0 0 1 currentScoreWindow {back})
			)
			(= local35 global385)
		)
		(if
			(and
				global250
				local6
				(== state 5)
				(not local31)
				(not global253)
				local32
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
			(= local32 1)
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
								(or
									(and
										(temp5 faceUp:)
										(<
											(temp5 x:)
											gMouseX
											(+ (temp5 x:) 54)
										)
										(<
											(temp5 y:)
											gMouseY
											(+ (temp5 y:) 77)
										)
									)
									(and
										(== (found2Hand size:) 1)
										(<
											(aceClubsView x:)
											gMouseX
											(+ (aceClubsView x:) 54)
										)
										(<
											(aceClubsView y:)
											gMouseY
											(+ (aceClubsView y:) 77)
										)
										(= temp5 (found2Hand at: 0))
									)
									(and
										(== (found1Hand size:) 1)
										(<
											(aceSpadesView x:)
											gMouseX
											(+ (aceSpadesView x:) 54)
										)
										(<
											(aceSpadesView y:)
											gMouseY
											(+ (aceSpadesView y:) 77)
										)
										(= temp5 (found1Hand at: 0))
									)
									(and
										(== (found3Hand size:) 1)
										(<
											(aceDiamondsView x:)
											gMouseX
											(+ (aceDiamondsView x:) 54)
										)
										(<
											(aceDiamondsView y:)
											gMouseY
											(+ (aceDiamondsView y:) 77)
										)
										(= temp5 (found3Hand at: 0))
									)
									(and
										(== (found4Hand size:) 1)
										(<
											(aceHeartsView x:)
											gMouseX
											(+ (aceHeartsView x:) 54)
										)
										(<
											(aceHeartsView y:)
											gMouseY
											(+ (aceHeartsView y:) 77)
										)
										(= temp5 (found4Hand at: 0))
									)
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
			(if (and (not global250) (!= local33 global928))
				(proc6022_7 {score} currentScoreWindow)
				(proc6022_6 global928 86 11 1 {score} currentScoreWindow)
				(= local33 global928)
			)
			(if (== global928 52)
				(= local31 1)
				(if global250
					(= local25 global248)
					(if
						(or
							(< (= local26 global249) local27)
							(and (== local26 local27) (< local25 local28))
						)
						(= local27 local26)
						(= local28 local25)
						(= local30 1)
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
				(for ((= temp1 0)) (< temp1 (Deck size:)) ((++ temp1))
					((Deck at: temp1) tailList: 0)
					((Deck at: temp1) whenPlayed: 0)
					((Deck at: temp1) previousHand: 0)
					((Deck at: temp1) wasFaceDown: 0)
				)
				(= local21 0)
				(= local22 0)
				(= local23 0)
				(= local24 0)
				(= local5 1)
				(= global226 1)
				(Deck shuffle:)
				(localproc_0)
				(localproc_1)
				(= global395 0)
				(= local2 0)
				(= global243 0)
				(= global928 4)
				(= local33 -1)
				(= global252 -1)
				(= global248 0)
				(= global249 0)
				(= local31 0)
				(= global253 0)
				(= local30 0)
				(= local32 0)
				(sDealer deal: self)
			)
			(5
				(= local6 1)
				(EnableCursor)
				(resignButton setPri: 1 init:)
				((KeyMouse objList:) add: resignButton)
				(undoButton setPri: 1 init:)
				((KeyMouse objList:) add: undoButton)
				(if (== global927 1)
					(found1Hand buildOrder: 4)
					(found2Hand buildOrder: 4)
					(found3Hand buildOrder: 4)
					(found4Hand buildOrder: 4)
				else
					(found1Hand buildOrder: 1)
					(found2Hand buildOrder: 1)
					(found3Hand buildOrder: 1)
					(found4Hand buildOrder: 1)
				)
				(= local3 0)
				(handleEventList
					add: hand1 hand2 hand3 hand4 hand5 hand6 hand7 hand8
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
		(if (and local29 (!= global928 52))
			(proc6022_7 {seconds} timeWindow)
			(proc6022_7 {minutes} timeWindow)
		)
		(if local34
			(= local34 0)
			(tabView hide:)
		)
		(= local3 0)
		(gTheHands eachElementDo: #endHand)
		((KeyMouse objList:) release:)
		(handleEventList release:)
		(proc0_9 (gCast elements:) 0)
		(= local21 0)
		(= local22 0)
		(= local23 0)
		(= local24 0)
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
		(if (not global496)
			(++ global221)
			(= global496 1)
			(gGame_opt doit: 3)
		)
		(cleanUp doit:)
		(if (and global250 local30)
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
			(if (and (== local27 59) (== local28 59))
				(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
			else
				(proc6022_6 local27 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 local28 92 20 1 {bestseconds} timeWindow)
			)
			(= local30 0)
		)
		(= local6 0)
		(proc6004_1 1)
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
				(proc6004_1 1)
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
		x 132
		y 26
		faceUp 1
		autoSorting 0
		centerX 132
		cardLimit 13
		buildOrder 2
		buildStep 1
		startRank 1
		canTrack 1
		canPlay 1
		cardsUp 6
	)
)

(instance hand2 of sHand
	(properties
		x 132
		y 123
		faceUp 1
		autoSorting 0
		centerX 132
		cardLimit 13
		buildOrder 2
		buildStep 1
		startRank 1
		canTrack 1
		canPlay 1
		cardsUp 6
	)
)

(instance hand3 of sHand
	(properties
		x 132
		y 220
		faceUp 1
		autoSorting 0
		centerX 132
		cardLimit 13
		buildOrder 2
		buildStep 1
		startRank 1
		canTrack 1
		canPlay 1
		cardsUp 6
	)
)

(instance hand4 of sHand
	(properties
		x 132
		y 319
		faceUp 1
		autoSorting 0
		centerX 132
		cardLimit 13
		buildOrder 2
		buildStep 1
		startRank 1
		canTrack 1
		canPlay 1
		cardsUp 6
	)
)

(instance hand5 of sHand
	(properties
		x 393
		y 26
		faceUp 1
		autoSorting 0
		centerX 393
		cardLimit 13
		buildOrder 2
		buildStep 1
		startRank 1
		canTrack 1
		canPlay 1
		cardsUp 6
	)
)

(instance hand6 of sHand
	(properties
		x 393
		y 123
		faceUp 1
		autoSorting 0
		centerX 393
		cardLimit 13
		buildOrder 2
		buildStep 1
		startRank 1
		canTrack 1
		canPlay 1
		cardsUp 6
	)
)

(instance hand7 of sHand
	(properties
		x 393
		y 220
		faceUp 1
		autoSorting 0
		centerX 393
		cardLimit 13
		buildOrder 2
		buildStep 1
		startRank 1
		canTrack 1
		canPlay 1
		cardsUp 6
	)
)

(instance hand8 of sHand
	(properties
		x 393
		y 319
		faceUp 1
		autoSorting 0
		centerX 393
		cardLimit 13
		buildOrder 2
		buildStep 1
		startRank 1
		canTrack 1
		canPlay 1
		cardsUp 6
	)
)

(instance found1Hand of sHand
	(properties
		x 335
		y 26
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 1
		cardShow 1
		cardLimit 13
		buildOrder 1
		buildStep 1
		startRank 2
		cardsUp 1
	)
)

(instance found2Hand of sHand
	(properties
		x 335
		y 123
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 1
		cardShow 1
		cardLimit 13
		buildOrder 1
		buildStep 1
		startRank 2
		cardsUp 1
	)
)

(instance found3Hand of sHand
	(properties
		x 335
		y 220
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 1
		cardShow 1
		cardLimit 13
		buildOrder 1
		buildStep 1
		startRank 2
		cardsUp 1
	)
)

(instance found4Hand of sHand
	(properties
		x 335
		y 319
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 1
		cardShow 1
		cardLimit 13
		buildOrder 1
		buildStep 1
		startRank 2
		cardsUp 1
	)
)

(instance hand1Empty of View
	(properties
		x 132
		y 26
		view 915
		loop 8
	)
)

(instance hand2Empty of View
	(properties
		x 132
		y 123
		view 915
		loop 8
	)
)

(instance hand3Empty of View
	(properties
		x 132
		y 220
		view 915
		loop 8
	)
)

(instance hand4Empty of View
	(properties
		x 132
		y 319
		view 915
		loop 8
	)
)

(instance hand5Empty of View
	(properties
		x 393
		y 26
		view 915
		loop 8
	)
)

(instance hand6Empty of View
	(properties
		x 393
		y 123
		view 915
		loop 8
	)
)

(instance hand7Empty of View
	(properties
		x 393
		y 220
		view 915
		loop 8
	)
)

(instance hand8Empty of View
	(properties
		x 393
		y 319
		view 915
		loop 8
	)
)

(instance aceSpadesView of View
	(properties
		x 335
		y 26
		priority 1
		view 50
		cel 1
	)
)

(instance aceClubsView of View
	(properties
		x 335
		y 123
		priority 1
		view 51
		cel 1
	)
)

(instance aceDiamondsView of View
	(properties
		x 335
		y 220
		priority 1
		view 52
		cel 1
	)
)

(instance aceHeartsView of View
	(properties
		x 335
		y 319
		priority 1
		view 53
		cel 1
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
		loop 2
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
		(= local29 1)
		(super init:)
		(proc0_10 990 5 global385 0 0 1 self {back})
		(proc0_10 990 0 0 0 0 2 self)
		(proc0_10 979 12 11 131 5 15 self)
		(proc0_10 979 12 11 131 20 15 self)
		(proc6022_6 0 92 5 1 {seconds} timeWindow)
		(if (and (== local27 59) (== local28 59))
			(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
			(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
		else
			(proc6022_6 local27 70 20 1 {bestminutes} timeWindow)
			(proc6022_6 local28 92 20 1 {bestseconds} timeWindow)
		)
	)
)

(instance tabView of View
	(properties
		view 712
	)

	(method (init)
		(self setPri: 255)
		(= local34 1)
		(super init: &rest)
	)
)

