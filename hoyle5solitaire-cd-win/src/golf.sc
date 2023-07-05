;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6007)
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
	golf 0
	proc6007_1 1
	optionCode 2
	roomScript 3
	proc6007_4 4
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
	local11 = 35
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

(procedure (proc6007_1 param1)
	((ScriptID 6080 0) doit: global928 (if argc param1 else 0)) ; scoreSolitaire
)

(procedure (localproc_0 &tmp temp0 temp1)
	(if (== global927 1)
		(= temp1 6)
	else
		(= temp1 7)
	)
	(for ((= temp0 0)) (< temp0 temp1) ((++ temp0))
		(if (== global927 1)
			((gTheHands at: temp0) cardLimit: 6 cardsUp: 6)
		else
			((gTheHands at: temp0) cardLimit: 5 cardsUp: 5)
		)
	)
)

(procedure (proc6007_4 param1) ; UNUSED
	(if argc
		(= local10 param1)
	else
		(return local10)
	)
)

(instance golf of HoyleRoom
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
			(gSound2 play: 815)
		)
		(= local9 0)
		(= gCardGameScriptNumber 6007)
		(= local10 0)
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
		((= global929 golf_opt) doit:)
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
		(found1 emptyView: foundEmpty)
		(found1 growView: foundGrow)
		(foundGrow init: setPri: 1)
		(if (== global927 1)
			((= gTheHands theHands)
				add: hand1 hand2 hand3 hand4 hand5 hand6 found1
			)
		else
			((= gTheHands theHands)
				add: hand1 hand2 hand3 hand4 hand5 hand6 hand7 found1
			)
		)
		((= gTheFoundations theFoundations) add: found1)
		(handleEventList add:)
		(Deck init: sCard)
		(Deck rankAces: 1)
		(= global419 theStock)
		(global419 client: found1)
		(global929 doit: 3)
		(= local8 1)
		(= local5 0)
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
			((not local10)
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
		(= local9 0)
		(= global419 0)
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
		(foundEmpty dispose:)
		(foundGrow dispose:)
		(if local21
			(tabView hide: dispose:)
		)
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

(instance golf_opt of File
	(properties
		name {golf.opt}
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
									local10
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
				(= local10 (temp1 asInteger:))
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
				(= local10 0)
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
				local9
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
		(if (and local9 (== state 5) (not global458))
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
			(if (== global928 0)
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
				(= local9 0)
				(= ticks (= ticks 1))
			)
			(1
				(= ticks 1)
			)
			(2
				(= ticks 10)
				(IconBar show:)
				(localproc_0)
				(if (== global927 1)
					(dealList add: hand1 hand2 hand3 hand4 hand5 hand6)
				else
					(dealList add: hand1 hand2 hand3 hand4 hand5 hand6 hand7)
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
				(= local9 0)
				(= local8 1)
				(for ((= temp1 0)) (< temp1 (Deck size:)) ((++ temp1))
					((Deck at: temp1) tailList: 0)
					((Deck at: temp1) whenPlayed: 0)
					((Deck at: temp1) previousHand: 0)
					((Deck at: temp1) inPlay: 0)
				)
				(= global395 0)
				(Deck shuffle:)
				(= local2 0)
				(= global243 0)
				(= global226 1)
				(if (== global927 1)
					(= global928 36)
				else
					(= global928 35)
				)
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
				(= local9 1)
				(EnableCursor)
				(resignButton setPri: 1 init:)
				((KeyMouse objList:) add: resignButton)
				(undoButton setPri: 1 init:)
				((KeyMouse objList:) add: undoButton)
				(= local6 0)
				(foundEmpty init: setPri: 1)
				(if (== global927 1)
					(= local11 36)
					(handleEventList add: hand1 hand2 hand3 hand4 hand5 hand6)
					(global419
						init:
						client: found1
						active: 1
						size: 16
						addKeyMouse:
					)
				else
					(= local11 35)
					(handleEventList
						add: hand1 hand2 hand3 hand4 hand5 hand6 hand7
					)
					(global419
						init:
						client: found1
						active: 1
						size: 17
						addKeyMouse:
					)
				)
				(handleEventList add: found1)
				(handleEventList add: global419)
				(handleEventList add: resignButton)
				(handleEventList add: undoButton)
				(for ((= temp1 0)) (< temp1 (gTheHands size:)) ((++ temp1))
					((gTheHands at: temp1) partner: 0)
				)
				(= global225 0)
				(= global226 0)
				(= local5 1)
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
			((Deck at: temp0) owner: 0)
		)
		(resignButton dispose:)
		(undoButton dispose:)
		(if (and local16 (!= global928 0))
			(proc6022_7 {seconds} timeWindow)
			(proc6022_7 {minutes} timeWindow)
		)
		(if local21
			(= local21 0)
			(tabView hide:)
		)
		(= local6 0)
		(gTheHands eachElementDo: #endHand)
		((KeyMouse objList:) release:)
		(global419 endHand:)
		(handleEventList release:)
		(global419 dispose:)
		(foundEmpty dispose:)
		(proc0_9 (gCast elements:) 0)
		(dealList release:)
		(theHands release:)
		(if (== global927 1)
			(theHands add: hand1 hand2 hand3 hand4 hand5 hand6 found1)
			(localproc_0)
			(dealList add: hand1 hand2 hand3 hand4 hand5 hand6)
		else
			(theHands add: hand1 hand2 hand3 hand4 hand5 hand6 hand7 found1)
			(localproc_0)
			(dealList add: hand1 hand2 hand3 hand4 hand5 hand6 hand7)
		)
		(sDealer init: dealList)
		(if global265
			(Deck sameDeck: 1)
			(= global265 0)
		)
		(if (!= global928 0)
			(roomScript changeState: 3)
		)
	)
)

(instance endCode of Code
	(properties)

	(method (doit)
		(if (not global508)
			(++ global221)
			(= global508 1)
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
		(= local9 0)
		(proc6007_1 1)
		(if local8
			((ScriptID 6080 1) doit: global928) ; scoreHand
		)
		(= local8 1)
		(DisableCursor)
		((ScriptID 6096 2) init:) ; aBanner
		(gSound2 play: 3000)
		((ScriptID 6096 2) setScript: (ScriptID 6096 1)) ; aBanner, sBannerOut
	)
)

(instance theStock of Stock
	(properties
		priority 4
		offsetY 10
	)

	(method (init)
		(= x 131)
		(= y 282)
		(super init:)
		(= loop 0)
	)

	(method (validPlay)
		(return 1)
	)

	(method (adjust)
		(cond
			((< 8 size 13)
				(= local6 0)
				(self setLoop: 1 posn: (+ origX 8) (+ origY 7))
				((ScriptID 15 7) ; stockBack
					view: (+ 54 global384)
					setLoop: 0
					posn: (+ origX 8) (+ origY 7)
				)
			)
			((< 4 size 9)
				(= local6 0)
				(self setLoop: 2 posn: (+ origX 10) (+ origY 9))
				((ScriptID 15 7) ; stockBack
					view: (+ 54 global384)
					setLoop: 0
					posn: (+ origX 10) (+ origY 9)
				)
			)
			((< 0 size 5)
				(handleEventList add: global419)
				(= local6 0)
				(self setLoop: 3 posn: (+ origX 12) (+ origY 11))
				((ScriptID 15 7) ; stockBack
					view: (+ 54 global384)
					setLoop: 0
					posn: (+ origX 12) (+ origY 11)
				)
			)
			((== size 0)
				(self setLoop: 4 posn: (+ origX 14) (+ origY 13))
				(handleEventList delete: global419)
				(= local6 1)
				((ScriptID 15 7) hide:) ; stockBack
			)
			(else
				(= local6 0)
				(self setLoop: 0 posn: origX origY)
				((ScriptID 15 7) ; stockBack
					view: (+ 54 global384)
					setLoop: 0
					posn: origX origY
				)
			)
		)
	)

	(method (getCard)
		(DisableCursor)
		(if size
			(-= size 1)
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
			((ScriptID 15 6) hide: setMotion: MoveTo 296 296 self) ; littleCard
		else
			(EnableCursor)
		)
	)

	(method (cue)
		(self setScript: stockScript)
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
		(if (and (!= global928 0) (super handleEvent: event))
			(event claimed: 1)
			((ScriptID 930 0) init: 9131 3 gCurRoomNum) ; yesNo
			(DisposeScript 930)
			(if global748
				(handleEventList delete: self)
				(IconBarF darken:)
				(proc6007_1 1)
				(IconBarF lighten:)
				(if local8
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
		(if (and (!= global928 0) (super handleEvent: event))
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
								(handleEventList add: global419)
								((ScriptID 15 7) show:) ; stockBack
							)
							(-= global928 1)
							(resetStock doit:)
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
				(+= global928 2)
				(= global226 0)
			)
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
				(= temp0 (getOne doit:))
				(= global395 0)
				(= cycles 1)
			)
			(2
				(EnableCursor)
			)
		)
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

(instance resetStock of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(= local3 (Deck topCard:))
		(= local4 (theStock size:))
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

(instance optionCode of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(if (== param1 1)
			(if (or (sDealer script:) (not local9))
				(= global920 1)
				(if global896
					(gChar1 sayReg: 600 15 128 0 (Random 1 2))
				else
					(gChar1 say: 600 15 128 0 2)
				)
			else
				(= local8 0)
				(cleanUp doit:)
			)
			(return 1)
		)
	)
)

(instance tempList of List
	(properties)
)

(instance dealList of List
	(properties)
)

(instance theFoundations of List
	(properties)
)

(instance hand1Empty of View ; UNUSED
	(properties
		x 99
		y 92
		priority 1
		view 915
		loop 8
	)
)

(instance hand2Empty of View ; UNUSED
	(properties
		x 163
		y 92
		priority 1
		view 915
		loop 8
	)
)

(instance hand3Empty of View ; UNUSED
	(properties
		x 227
		y 92
		priority 1
		view 915
		loop 8
	)
)

(instance hand4Empty of View ; UNUSED
	(properties
		x 291
		y 92
		priority 1
		view 915
		loop 8
	)
)

(instance hand5Empty of View ; UNUSED
	(properties
		x 355
		y 92
		priority 1
		view 915
		loop 8
	)
)

(instance hand6Empty of View ; UNUSED
	(properties
		x 419
		y 92
		priority 1
		view 915
		loop 8
	)
)

(instance hand7Empty of View ; UNUSED
	(properties
		x 483
		y 92
		priority 1
		view 915
		loop 8
	)
)

(instance hand1 of sHand
	(properties
		x 99
		y 92
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 99
		cardLimit 5
		canPlay 1
		cardsUp 5
		whereTo 1
	)
)

(instance hand2 of sHand
	(properties
		x 163
		y 92
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 163
		cardLimit 5
		canPlay 1
		cardsUp 5
		whereTo 1
	)
)

(instance hand3 of sHand
	(properties
		x 227
		y 92
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 227
		cardLimit 5
		canPlay 1
		cardsUp 5
		whereTo 1
	)
)

(instance hand4 of sHand
	(properties
		x 291
		y 92
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 291
		cardLimit 5
		canPlay 1
		cardsUp 5
		whereTo 1
	)
)

(instance hand5 of sHand
	(properties
		x 355
		y 92
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 355
		cardLimit 5
		canPlay 1
		cardsUp 5
		whereTo 1
	)
)

(instance hand6 of sHand
	(properties
		x 419
		y 92
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 419
		cardLimit 5
		canPlay 1
		cardsUp 5
		whereTo 1
	)
)

(instance hand7 of sHand
	(properties
		x 483
		y 92
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 483
		cardLimit 5
		canPlay 1
		cardsUp 5
		whereTo 1
	)
)

(instance foundGrow of View
	(properties
		x 296
		y 296
		view 915
		loop 4
	)
)

(instance found1 of sHand
	(properties
		x 296
		y 296
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 1
		cardShow 1
		cardLimit 52
		buildOrder 3
		buildStep 1
		startRank 3
		orgX 296
		orgY 296
		whereTo 2
	)

	(method (add param1 &tmp temp0)
		(if argc
			(for ((= temp0 0)) (< temp0 (- (gTheHands size:) 1)) ((++ temp0))
				(cond
					((== (param1 owner:) (gTheHands at: temp0))
						(-= global928 2)
						(break)
					)
					((== temp0 (- (gTheHands size:) 2))
						(-= global928 1)
					)
				)
			)
			(super add: param1 &rest)
		else
			(super add: &rest)
		)
	)
)

(instance foundEmpty of View
	(properties
		x 296
		y 296
		view 915
		loop 9
	)
)

(instance theHands of Set
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
		loop 14
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
		view 724
	)

	(method (init)
		(if (== global927 0)
			(= cel 0)
		else
			(= cel 1)
		)
		(self setPri: 256)
		(= local21 1)
		(super init: &rest)
	)
)

