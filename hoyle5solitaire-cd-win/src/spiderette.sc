;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6010)
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
	spiderette 0
	proc6010_1 1
	optionCode 2
	roomScript 3
	proc6010_4 4
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
)

(procedure (proc6010_1 param1)
	((ScriptID 6080 0) doit: global928 (if argc param1 else 0)) ; scoreSolitaire
)

(procedure (proc6010_4 param1) ; UNUSED
	(if argc
		(= local13 param1)
	else
		(return local13)
	)
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 temp3)
	(for ((= temp1 0)) (< temp1 7) ((++ temp1))
		(= temp3 1)
		(if
			(and
				(!= ((gTheHands at: temp1) size:) 0)
				(== (((gTheHands at: temp1) at: 0) rank:) 13)
				(== ((gTheHands at: temp1) size:) 13)
				(((gTheHands at: temp1) at: 0) faceUp:)
			)
			(= temp0 (((gTheHands at: temp1) at: 0) rank:))
			(for ((= temp2 1)) (< temp2 13) ((++ temp2))
				(if (== (((gTheHands at: temp1) at: temp2) rank:) (- temp0 1))
					(= temp0 (((gTheHands at: temp1) at: temp2) rank:))
				else
					(= temp3 0)
				)
			)
			(if (and temp3 (not global226))
				(if (not local15)
					(= local15 1)
				else
					(++ local15)
				)
				(++ global225)
				(((gTheHands at: temp1) at: 0) setWhenPlayed: setPreviousHand:)
				(cond
					((not (fullHand1 size:))
						(((gTheHands at: temp1) at: 0) wasReset: 1)
						(for
							((= temp2 0))
							(< temp2 ((gTheHands at: temp1) size:))
							((++ temp2))
							
							(fullHand1 add: ((gTheHands at: temp1) at: temp2))
						)
					)
					((not (fullHand2 size:))
						(((gTheHands at: temp1) at: 0) wasReset: 2)
						(for
							((= temp2 0))
							(< temp2 ((gTheHands at: temp1) size:))
							((++ temp2))
							
							(fullHand2 add: ((gTheHands at: temp1) at: temp2))
						)
					)
					(else
						(((gTheHands at: temp1) at: 0) wasReset: 3)
						(for
							((= temp2 0))
							(< temp2 ((gTheHands at: temp1) size:))
							((++ temp2))
							
							(fullHand3 add: ((gTheHands at: temp1) at: temp2))
						)
					)
				)
				((gTheHands at: temp1) eachElementDo: #hide release:)
				(((gTheHands at: temp1) emptyView:) show:)
				(++ local14)
			else
				(= temp3 0)
			)
		)
	)
)

(procedure (localproc_1 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp4 0)
	(if (== local14 1)
		(= temp4 13)
	)
	(if (== local14 2)
		(= temp4 26)
	)
	(if (== local14 3)
		(= temp4 39)
	)
	(for ((= temp1 0)) (< temp1 (gTheHands size:)) ((++ temp1))
		(if ((gTheHands at: temp1) size:)
			(= temp0 (((gTheHands at: temp1) at: 0) rank:))
		)
		(= temp3 2)
		(for ((= temp2 1)) (< temp2 ((gTheHands at: temp1) size:)) ((++ temp2))
			(if
				(and
					(((gTheHands at: temp1) at: (- temp2 1)) faceUp:)
					(((gTheHands at: temp1) at: temp2) faceUp:)
					(== temp0 (+ 1 (((gTheHands at: temp1) at: temp2) rank:)))
				)
				(+= temp4 temp3)
				(= temp3 1)
			else
				(= temp3 2)
			)
			(= temp0 (((gTheHands at: temp1) at: temp2) rank:))
		)
	)
	(= global928 temp4)
)

(instance spiderette of HoyleRoom
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
			(gSound2 play: 825)
		)
		(= local12 0)
		(= gCardGameScriptNumber 6010)
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
		((= global929 spider_opt) doit:)
		(= picture (+ global877 global385))
		(= local26 global385)
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
		((= gTheHands theHands) add: hand1 hand2 hand3 hand4 hand5 hand6 hand7)
		(= gTheFoundations 0)
		(handleEventList add:)
		(Deck init: sCard)
		(Deck rankAces: 1)
		(= global419 theStock)
		(global419 client: hand1)
		(global929 doit: 3)
		(= local11 1)
		(= global928 0)
		(= local7 0)
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
		(= local12 0)
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
		(theHands dispose:)
		(handleEventList release: dispose:)
		(hand1Empty dispose:)
		(hand2Empty dispose:)
		(hand3Empty dispose:)
		(hand4Empty dispose:)
		(hand5Empty dispose:)
		(hand6Empty dispose:)
		(hand7Empty dispose:)
		(if local25
			(tabView hide: dispose:)
		)
		(if local20
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

(instance spider_opt of File
	(properties
		name {spider.opt}
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
									local18
									local19
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
				(= local18 (temp1 asInteger:))
				(self readString: temp1 3)
				(= local19 (temp1 asInteger:))
				(temp1 dispose:)
				(self close:)
				(return 0)
			)
			(else
				(= local13 0)
				(= global927 0)
				(= local18 59)
				(= local19 59)
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
			(= local18 59)
			(= local19 59)
			(global929 doit: 3)
			(if local20
				(proc6022_7 {bestminutes} timeWindow)
				(proc6022_7 {bestseconds} timeWindow)
				(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
			)
		)
		(if (!= global385 local26)
			(if local20
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
				local12
				(== state 5)
				(not local22)
				(not global253)
				local23
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
			(= local23 1)
		)
		(if (and local12 (== state 5))
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
			(localproc_1)
			(localproc_0)
			(if (and (not global250) (!= local24 global928))
				(proc6022_7 {score} currentScoreWindow)
				(proc6022_6 global928 86 11 1 {score} currentScoreWindow)
				(= local24 global928)
			)
			(if (== local14 4)
				(= local22 1)
				(if global250
					(= local16 global248)
					(if
						(or
							(< (= local17 global249) local18)
							(and (== local17 local18) (< local16 local19))
						)
						(= local18 local17)
						(= local19 local16)
						(= local21 1)
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
				(= local12 0)
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
				(dealList add: hand1 hand2 hand3 hand4 hand5 hand6 hand7)
				(if (== global927 0)
					(hand1 cardsDown: 2)
					(hand2 cardsDown: 2)
					(hand3 cardsDown: 2)
					(hand4 cardsDown: 2)
					(hand5 cardsDown: 2)
					(hand6 cardsDown: 2)
					(hand7 cardsDown: 2)
					(= local3 31)
				else
					(hand1 cardsDown: 3)
					(hand2 cardsDown: 3)
					(hand3 cardsDown: 3)
					(hand4 cardsDown: 3)
					(hand5 cardsDown: 3)
					(hand6 cardsDown: 3)
					(hand7 cardsDown: 3)
					(= local3 24)
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
				(= local12 0)
				(= local11 1)
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
				(if (fullHand1 size:)
					(fullHand1 release:)
				)
				(if (fullHand2 size:)
					(fullHand2 release:)
				)
				(if (fullHand3 size:)
					(fullHand3 release:)
				)
				(= global226 1)
				(= global395 0)
				(Deck shuffle:)
				(= local2 0)
				(= global243 0)
				(= local15 0)
				(= global928 0)
				(= local24 -1)
				(= local14 0)
				(= global252 -1)
				(= global248 0)
				(= global249 0)
				(= local22 0)
				(= global253 0)
				(= local21 0)
				(= local23 0)
				(sDealer deal: self)
			)
			(5
				(= local12 1)
				(EnableCursor)
				(resignButton setPri: 1 init:)
				((KeyMouse objList:) add: resignButton)
				(undoButton setPri: 1 init:)
				((KeyMouse objList:) add: undoButton)
				(= local9 0)
				(handleEventList add: hand1 hand2 hand3 hand4 hand5 hand6 hand7)
				(handleEventList add: global419)
				(handleEventList add: resignButton)
				(handleEventList add: undoButton)
				(global419
					init:
					client: hand1
					active: 1
					size: local3
					addKeyMouse:
				)
				(theStock adjust:)
				(for ((= temp1 0)) (< temp1 (gTheHands size:)) ((++ temp1))
					((gTheHands at: temp1) partner: 0)
				)
				(= global225 0)
				(= global226 0)
				(= local7 1)
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
		(= local9 0)
		(if (and local20 (!= global928 52))
			(proc6022_7 {seconds} timeWindow)
			(proc6022_7 {minutes} timeWindow)
		)
		(if local25
			(= local25 0)
			(tabView hide:)
		)
		(gTheHands eachElementDo: #endHand)
		((KeyMouse objList:) release:)
		(global419 endHand:)
		(handleEventList release:)
		(global419 dispose:)
		(proc0_9 (gCast elements:) 0)
		(dealList release:)
		(dealList add: hand1 hand2 hand3 hand4 hand5 hand6 hand7)
		(if (== global927 0)
			(hand1 cardsDown: 2)
			(hand2 cardsDown: 2)
			(hand3 cardsDown: 2)
			(hand4 cardsDown: 2)
			(hand5 cardsDown: 2)
			(hand6 cardsDown: 2)
			(hand7 cardsDown: 2)
			(= local3 31)
		else
			(hand1 cardsDown: 3)
			(hand2 cardsDown: 3)
			(hand3 cardsDown: 3)
			(hand4 cardsDown: 3)
			(hand5 cardsDown: 3)
			(hand6 cardsDown: 3)
			(hand7 cardsDown: 3)
			(= local3 24)
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
		(if (not global518)
			(++ global221)
			(= global518 1)
			(gGame_opt doit: 3)
		)
		(cleanUp doit:)
		(if (and global250 local21)
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
			(if (and (== local18 59) (== local19 59))
				(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
			else
				(proc6022_6 local18 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 local19 92 20 1 {bestseconds} timeWindow)
			)
			(= local21 0)
		)
		(= local12 0)
		(proc6010_1 1)
		(if local11
			((ScriptID 6080 1) doit: global928) ; scoreHand
		)
		(= local11 1)
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
				(proc6010_1 1)
				(IconBarF lighten:)
				(if local11
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
						(cond
							(
								(and
									(> (temp3 wasTailList:) 0)
									(!=
										((temp3 owner:) indexOf: temp3)
										(- ((temp3 owner:) size:) 1)
									)
									(not (temp3 wasReset:))
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
								(break)
							)
							(
								(and
									(temp3 wasReset:)
									(== (temp3 wasReset:) local15)
								)
								(-- local15)
								(-- local14)
								(-- global225)
								(temp3 setWhenPlayed: 1)
								(cond
									((== (temp3 wasReset:) 1)
										(for
											((= temp1 0))
											(< temp1 (fullHand1 size:))
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
												add: (fullHand1 at: temp1)
											)
											((fullHand1 at: temp1) show:)
										)
										(fullHand1 release:)
									)
									((== (temp3 wasReset:) 2)
										(for
											((= temp1 0))
											(< temp1 (fullHand2 size:))
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
												add: (fullHand2 at: temp1)
											)
											((fullHand2 at: temp1) show:)
										)
										(fullHand2 release:)
									)
									(else
										(for
											((= temp1 0))
											(< temp1 (fullHand3 size:))
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
												add: (fullHand3 at: temp1)
											)
											((fullHand3 at: temp1) show:)
										)
										(fullHand3 release:)
									)
								)
								(temp3 wasReset: 0)
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
								(= temp0 -1)
							)
							(else
								(if
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
												(-
													((temp3 previousHand:)
														size:
													)
													1
												)
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
									(if (< (theStock size:) 1)
										(handleEventList add: global419)
										((ScriptID 15 7) show:) ; stockBack
									)
									(resetStock doit:)
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
										(for
											((= temp1 1))
											(< temp1 7)
											((++ temp1))
											
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
															((temp3
																	previousHand:
																)
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
																		at:
																			temp2
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
															
															((temp3
																	previousHand:
																)
																add:
																	(tempList
																		at:
																			temp2
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
													(resetStock doit:)
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
									else
										(temp3 setNumFromStock: 0 1)
									)
								else
									((temp3 owner:) eliminateCard: temp3)
									(temp3 inPlay: 1)
									(((temp3 previousHand:)
											at:
												(-
													((temp3 previousHand:)
														size:
													)
													1
												)
										)
										add: temp3
									)
									(if (> ((temp3 previousHand:) size:) 1)
										(for
											((= temp1 0))
											(<
												temp1
												(-
													((temp3 previousHand:)
														size:
													)
													1
												)
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
								)
								(break)
							)
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
			(if (or (sDealer script:) (not local12))
				(= global920 1)
				(if global896
					(gChar1 sayReg: 600 15 128 0 (Random 1 2))
				else
					(gChar1 say: 600 15 128 0 2)
				)
			else
				(= local11 0)
				(cleanUp doit:)
			)
			(return 1)
		)
	)
)

(instance hand1 of sHand
	(properties
		x 129
		y 34
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 129
		cardLimit 25
		buildOrder 2
		buildStep 1
		startRank 3
		canTrack 1
		canPlay 1
		cardsDown 2
		cardsUp 1
		tailMove 1
	)
)

(instance hand1Empty of View
	(properties
		x 129
		y 34
		priority 1
		view 915
		loop 8
	)
)

(instance hand2 of sHand
	(properties
		x 192
		y 34
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 192
		cardLimit 25
		buildOrder 2
		buildStep 1
		startRank 3
		canTrack 1
		canPlay 1
		cardsDown 2
		cardsUp 1
		tailMove 1
	)
)

(instance hand2Empty of View
	(properties
		x 192
		y 34
		priority 1
		view 915
		loop 8
	)
)

(instance hand3 of sHand
	(properties
		x 255
		y 34
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 255
		cardLimit 25
		buildOrder 2
		buildStep 1
		startRank 3
		canTrack 1
		canPlay 1
		cardsDown 2
		cardsUp 1
		tailMove 1
	)
)

(instance hand3Empty of View
	(properties
		x 255
		y 34
		priority 1
		view 915
		loop 8
	)
)

(instance hand4 of sHand
	(properties
		x 318
		y 34
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 318
		cardLimit 25
		buildOrder 2
		buildStep 1
		startRank 3
		canTrack 1
		canPlay 1
		cardsDown 2
		cardsUp 1
		tailMove 1
	)
)

(instance hand4Empty of View
	(properties
		x 318
		y 34
		priority 1
		view 915
		loop 8
	)
)

(instance hand5 of sHand
	(properties
		x 381
		y 34
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 381
		cardLimit 25
		buildOrder 2
		buildStep 1
		startRank 3
		canTrack 1
		canPlay 1
		cardsDown 2
		cardsUp 1
		tailMove 1
	)
)

(instance hand5Empty of View
	(properties
		x 381
		y 34
		priority 1
		view 915
		loop 8
	)
)

(instance hand6 of sHand
	(properties
		x 445
		y 34
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 445
		cardLimit 25
		buildOrder 2
		buildStep 1
		startRank 3
		canTrack 1
		canPlay 1
		cardsDown 2
		cardsUp 1
		tailMove 1
	)
)

(instance hand6Empty of View
	(properties
		x 445
		y 34
		priority 1
		view 915
		loop 8
	)
)

(instance hand7 of sHand
	(properties
		x 508
		y 34
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 508
		cardLimit 25
		buildOrder 2
		buildStep 1
		startRank 3
		canTrack 1
		canPlay 1
		cardsDown 2
		cardsUp 1
		tailMove 1
	)
)

(instance hand7Empty of View
	(properties
		x 508
		y 34
		priority 1
		view 915
		loop 8
	)
)

(instance theHands of List
	(properties)
)

(instance dealList of List
	(properties)
)

(instance tempList of List
	(properties)
)

(instance fullHand1 of List
	(properties)
)

(instance fullHand2 of List
	(properties)
)

(instance fullHand3 of List
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
		(= x 69)
		(= y 300)
		(super init:)
		(= loop 0)
	)

	(method (validPlay)
		(return 1)
	)

	(method (adjust)
		(cond
			((< 8 size 13)
				(= local9 0)
				(self setLoop: 1 posn: (+ origX 8) (+ origY 7))
				((ScriptID 15 7) ; stockBack
					view: (+ 54 global384)
					setLoop: 0
					posn: (+ origX 8) (+ origY 7)
					show:
				)
			)
			((< 4 size 9)
				(= local9 0)
				(self setLoop: 2 posn: (+ origX 10) (+ origY 9))
				((ScriptID 15 7) ; stockBack
					view: (+ 54 global384)
					setLoop: 0
					posn: (+ origX 10) (+ origY 9)
					show:
				)
			)
			((< 0 size 5)
				(handleEventList add: global419)
				(= local9 0)
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
				(= local9 1)
				((ScriptID 15 7) hide:) ; stockBack
			)
			(else
				(= local9 0)
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
		(= local8 0)
		(if (or (and (== (= local6 1) 1) size) (and (== local6 0) size))
			(-= size (if (> size 7) 7 else 3))
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
			(if (== local6 1)
				(= local8 1)
			)
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
				(if local8
					(= temp0 (getThree doit:))
				else
					(= temp0 (getOne doit:))
				)
				(= local8 0)
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
		(if (> (theStock size:) 2)
			(while (< temp1 7)
				(if (>= (Deck topCard:) 0)
					(= temp0 (Deck getCard:))
					(if (not (temp0 inPlay:))
						(++ temp1)
						(= temp2 temp0)
						(gSound play: 903)
						(temp0 flip: 1 init:)
						(temp0 fromStock: 1 setNumFromStock: temp1)
						(switch temp1
							(1
								(if
									(==
										((theStock client:) size:)
										((theStock client:) cardLimit:)
									)
									((theStock client:) cardLimit: 26)
								)
								((theStock client:) add: temp0)
								(if (== ((theStock client:) size:) 26)
									((theStock client:) cardLimit: 25)
								)
								(theStock client: hand2)
							)
							(2
								(if
									(==
										((theStock client:) size:)
										((theStock client:) cardLimit:)
									)
									((theStock client:) cardLimit: 26)
								)
								((theStock client:) add: temp0)
								(if (== ((theStock client:) size:) 26)
									((theStock client:) cardLimit: 25)
								)
								(theStock client: hand3)
							)
							(3
								(if
									(==
										((theStock client:) size:)
										((theStock client:) cardLimit:)
									)
									((theStock client:) cardLimit: 26)
								)
								((theStock client:) add: temp0)
								(if (== ((theStock client:) size:) 26)
									((theStock client:) cardLimit: 25)
								)
								(theStock client: hand4)
							)
							(4
								(if
									(==
										((theStock client:) size:)
										((theStock client:) cardLimit:)
									)
									((theStock client:) cardLimit: 26)
								)
								((theStock client:) add: temp0)
								(if (== ((theStock client:) size:) 26)
									((theStock client:) cardLimit: 25)
								)
								(theStock client: hand5)
							)
							(5
								(if
									(==
										((theStock client:) size:)
										((theStock client:) cardLimit:)
									)
									((theStock client:) cardLimit: 26)
								)
								((theStock client:) add: temp0)
								(if (== ((theStock client:) size:) 26)
									((theStock client:) cardLimit: 25)
								)
								(theStock client: hand6)
							)
							(6
								(if
									(==
										((theStock client:) size:)
										((theStock client:) cardLimit:)
									)
									((theStock client:) cardLimit: 26)
								)
								((theStock client:) add: temp0)
								(if (== ((theStock client:) size:) 26)
									((theStock client:) cardLimit: 25)
								)
								(theStock client: hand7)
							)
							(7
								(if
									(==
										((theStock client:) size:)
										((theStock client:) cardLimit:)
									)
									((theStock client:) cardLimit: 26)
								)
								((theStock client:) add: temp0)
								(if (== ((theStock client:) size:) 26)
									((theStock client:) cardLimit: 25)
								)
								(theStock client: hand1)
							)
						)
					)
				else
					(++ temp1)
				)
			)
		else
			(while (< temp1 3)
				(if (>= (Deck topCard:) 0)
					(= temp0 (Deck getCard:))
					(if (not (temp0 inPlay:))
						(++ temp1)
						(= temp2 temp0)
						(gSound play: 903)
						(temp0 flip: 1 init:)
						(temp0 fromStock: 1 setNumFromStock: temp1)
						(switch temp1
							(1
								((theStock client:) add: temp0)
								(theStock client: hand2)
							)
							(2
								((theStock client:) add: temp0)
								(theStock client: hand3)
							)
							(3
								((theStock client:) add: temp0)
								(theStock client: hand1)
							)
						)
					)
				else
					(++ temp1)
				)
			)
		)
		(return temp2)
	)
)

(instance resetStock of Code
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
		loop 24
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
		(= local20 1)
		(super init:)
		(proc0_10 990 5 global385 0 0 1 self {back})
		(proc0_10 990 0 0 0 0 2 self)
		(proc0_10 979 12 11 131 5 15 self)
		(proc0_10 979 12 11 131 20 15 self)
		(proc6022_6 0 92 5 1 {seconds} timeWindow)
		(if (and (== local18 59) (== local19 59))
			(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
			(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
		else
			(proc6022_6 local18 70 20 1 {bestminutes} timeWindow)
			(proc6022_6 local19 92 20 1 {bestseconds} timeWindow)
		)
	)
)

(instance tabView of View
	(properties
		view 734
	)

	(method (init)
		(self setPri: 256)
		(= local25 1)
		(super init: &rest)
	)
)

