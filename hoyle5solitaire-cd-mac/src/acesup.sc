;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6022)
(include sci.sh)
(use Main)
(use KeyMouse)
(use InvisibleWindow)
(use ManualSort)
(use TrackingView)
(use h5Messager)
(use sHand)
(use Str)
(use Print)
(use IconBar)
(use Motion)
(use File)
(use Actor)
(use System)

(public
	acesup 0
	proc6022_1 1
	optionCode 2
	roomScript 3
	proc6022_4 4
	proc6022_5 5
	proc6022_6 6
	proc6022_7 7
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
)

(procedure (proc6022_1 param1)
	((ScriptID 6080 0) doit: global928 (if argc param1 else 0)) ; scoreSolitaire
)

(procedure (proc6022_4 param1) ; UNUSED
	(if argc
		(= local11 param1)
	else
		(return local11)
	)
)

(procedure (proc6022_5 param1 &tmp temp0)
	(for ((= temp0 0)) (< temp0 4) ((++ temp0))
		(if
			(and
				((gTheHands at: temp0) size:)
				(==
					(((gTheHands at: temp0)
							at: (- ((gTheHands at: temp0) size:) 1)
						)
						suit:
					)
					(param1 suit:)
				)
				(>
					(((gTheHands at: temp0)
							at: (- ((gTheHands at: temp0) size:) 1)
						)
						rank:
					)
					(param1 rank:)
				)
			)
			(return 1)
		)
	)
	(return 0)
)

(procedure (localproc_0 &tmp temp0 temp1)
	(for ((= temp0 0)) (< temp0 4) ((++ temp0))
		(if ((gTheHands at: temp0) size:)
			(if (!= (((gTheHands at: temp0) at: 0) rank:) 14)
				(return 0)
			)
		else
			(return 0)
		)
	)
	(cond
		((== global927 0)
			(if
				(and
					(==
						(+ ((gTheHands at: 5) size:) ((gTheHands at: 4) size:))
						48
					)
					(> ((gTheHands at: 4) size:) 42)
				)
				(return 1)
			)
		)
		((== ((gTheHands at: 4) size:) 48)
			(return 1)
		)
	)
	(return 0)
)

(procedure (localproc_1)
	(timeWindow init:)
)

(procedure (proc6022_6 param1 param2 param3 param4 param5 param6 &tmp temp0)
	(if (and (< argc 4) (not param1))
		(return)
	)
	(if (< param1 0)
		(= temp0 1)
		(*= param1 -1)
	else
		(= temp0 0)
	)
	(cond
		((>= param1 1000)
			(proc0_10
				990
				4
				(mod (/ param1 1000) 10)
				(+ param2 30)
				param3
				15
				param6
				param5
			)
			(proc0_10
				990
				4
				(mod (/ param1 100) 10)
				(+ param2 38)
				param3
				15
				param6
				param5
			)
			(proc0_10
				990
				4
				(mod (/ param1 10) 10)
				(+ param2 46)
				param3
				15
				param6
				param5
			)
			(proc0_10
				990
				4
				(mod param1 10)
				(+ param2 54)
				param3
				15
				param6
				param5
			)
		)
		((>= param1 100)
			(proc0_10
				990
				4
				(mod (/ param1 100) 10)
				(+ param2 38)
				param3
				15
				param6
				param5
			)
			(proc0_10
				990
				4
				(mod (/ param1 10) 10)
				(+ param2 46)
				param3
				15
				param6
				param5
			)
			(proc0_10
				990
				4
				(mod param1 10)
				(+ param2 54)
				param3
				15
				param6
				param5
			)
		)
		((>= param1 10)
			(proc0_10
				990
				4
				(mod (/ param1 10) 10)
				(+ param2 46)
				param3
				15
				param6
				param5
			)
			(proc0_10
				990
				4
				(mod param1 10)
				(+ param2 54)
				param3
				15
				param6
				param5
			)
		)
		((>= param1 0)
			(if global250
				(if (== param1 0)
					(proc0_10
						990
						4
						(mod (/ param1 10) 10)
						(+ param2 46)
						param3
						15
						param6
						param5
					)
					(proc0_10
						990
						4
						(mod param1 10)
						(+ param2 54)
						param3
						15
						param6
						param5
					)
				else
					(proc0_10 990 4 0 (+ param2 46) param3 15 param6 param5)
					(proc0_10
						990
						4
						(mod param1 10)
						(+ param2 54)
						param3
						15
						param6
						param5
					)
				)
			else
				(proc0_10
					990
					4
					(mod param1 10)
					(+ param2 54)
					param3
					15
					param6
					param5
				)
			)
		)
	)
)

(procedure (proc6022_7 param1 param2 &tmp temp0 temp1 temp2)
	(= temp1 (Str format: {%s} param1))
	(= temp2 ((param2 casts:) at: 0))
	(for ((= temp0 (- (temp2 size:) 1))) (>= temp0 0) ((-- temp0))
		(if
			(and
				((temp2 at: temp0) name:)
				(temp1 compare: ((temp2 at: temp0) name:))
			)
			((temp2 at: temp0) dispose:)
		)
	)
	(temp1 dispose:)
)

(instance acesup of HoyleRoom
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
			(gSound2 play: 801)
		)
		(= local10 0)
		(= gCardGameScriptNumber 6022)
		(= local11 0)
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
		((= global929 acesup_opt) doit:)
		(= picture (+ global877 global385))
		(= local24 global385)
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
		(found1Hand growView: found1Grow)
		(found1Grow init: setPri: 1)
		(if (== global927 0)
			((= gTheHands theHands)
				add: hand1 hand2 hand3 hand4 found1Hand waste1Hand
			)
			(waste1Hand emptyView: waste1Empty)
		else
			((= gTheHands theHands) add: hand1 hand2 hand3 hand4 found1Hand)
		)
		((= gTheFoundations theFoundations) add: found1Hand)
		(handleEventList add:)
		(Deck init: sCard)
		(Deck rankAces: 14)
		(= global419 theStock)
		(global419 client: hand1)
		(global929 doit: 3)
		(= local9 1)
		(= global928 0)
		(= local12 0)
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
			((not local11)
				(gSong setLoop: 1)
			)
		)
		(if global250
			(localproc_1)
		else
			(currentScoreWindow init:)
		)
		(self setScript: roomScript)
	)

	(method (handleEvent event &tmp temp0)
		(if
			(and
				(not (event claimed:))
				(== evKEYBOARD (event type:))
				(== (event message:) KEY_TAB)
				local23
			)
			(event claimed: 1)
			(= local23 0)
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
		(if
			(and
				(== evMOUSEBUTTON (event type:))
				(& (event modifiers:) emSHIFT)
				(& (event modifiers:) emCTRL)
			)
			(gCurRoom newRoom: 6029) ; cardflick
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
		(waste1Hand release: dispose:)
		(theHands dispose:)
		(theFoundations dispose:)
		(handleEventList release: dispose:)
		(hand1Empty dispose:)
		(hand2Empty dispose:)
		(hand3Empty dispose:)
		(hand4Empty dispose:)
		(found1Empty dispose:)
		(found1Grow dispose:)
		(waste1Empty dispose:)
		(if local23
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

(instance acesup_opt of File
	(properties
		name {acesup.opt}
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
									local11
									global927
									local16
									local17
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
				(= local11 (temp1 asInteger:))
				(self readString: temp1 2)
				(= global927 (temp1 asInteger:))
				(self readString: temp1 3)
				(= local16 (temp1 asInteger:))
				(self readString: temp1 3)
				(= local17 (temp1 asInteger:))
				(temp1 dispose:)
				(self close:)
				(return 0)
			)
			(else
				(= local11 0)
				(= global927 0)
				(= local16 59)
				(= local17 59)
				(return 0)
			)
		)
	)
)

(instance roomScript of Script
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(super doit: &rest)
		(if global525
			(= global525 0)
			(= local16 59)
			(= local17 59)
			(global929 doit: 3)
			(if local19
				(proc6022_7 {bestminutes} timeWindow)
				(proc6022_7 {bestseconds} timeWindow)
				(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
			)
		)
		(if (!= global385 local24)
			(if local19
				(proc6022_7 {back} timeWindow)
				(proc0_10 990 5 global385 0 0 1 timeWindow {back})
			else
				(proc6022_7 {back} currentScoreWindow)
				(proc0_10 990 5 global385 0 0 1 currentScoreWindow {back})
			)
			(= local24 global385)
		)
		(if
			(and
				global250
				local10
				(== state 5)
				(not local18)
				(not global253)
				local21
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
			(= local21 1)
		)
		(if (and local10 (== state 5))
			(cond
				(global109
					(if (not local1)
						(Load rsVIEW 985)
						(= local1 1)
					)
					(for ((= temp0 0)) (< temp0 (gTheHands size:)) ((++ temp0))
						(for
							((= temp1 (- ((gTheHands at: temp0) size:) 1)))
							(> temp1 -1)
							((-- temp1))
							
							(= temp2 ((gTheHands at: temp0) at: temp1))
							(if
								(and
									(temp2 faceUp:)
									(< (temp2 x:) gMouseX (+ (temp2 x:) 54))
									(< (temp2 y:) gMouseY (+ (temp2 y:) 77))
								)
								(magView
									init: (temp2 suit:) (- (temp2 rank:) 1)
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
			(if (and (not global250) (!= local22 global928))
				(proc6022_7 {score} currentScoreWindow)
				(proc6022_6 global928 86 11 1 {score} currentScoreWindow)
				(= local22 global928)
			)
			(if (localproc_0)
				(= local18 1)
				(if global250
					(= local14 global248)
					(if
						(or
							(< (= local15 global249) local16)
							(and (== local15 local16) (< local14 local17))
						)
						(= local16 local15)
						(= local17 local14)
						(= local20 1)
						(global929 doit: 3)
					)
				)
				(+= global928 4)
				(if (not global250)
					(proc6022_7 {score} currentScoreWindow)
					(proc6022_6 global928 86 11 1 {score} currentScoreWindow)
				)
				(= local13 1)
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
				(if (== gPrevRoomNum 975) ; chooseGame
					(= seconds 4)
				else
					(= cycles 1)
				)
			)
			(2
				(= ticks 10)
				(IconBar show:)
				(dealList add: hand1 hand2 hand3 hand4)
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
				(= local9 1)
				(for ((= temp1 0)) (< temp1 (Deck size:)) ((++ temp1))
					((Deck at: temp1) inPlay: 0)
					((Deck at: temp1) tailList: 0)
					((Deck at: temp1) whenPlayed: 0)
					((Deck at: temp1) previousHand: 0)
				)
				(= global395 0)
				(Deck shuffle:)
				(if (== global927 0)
					(waste1Empty init: setPri: 1)
				)
				(= local2 0)
				(= global243 0)
				(= local12 0)
				(= global928 0)
				(= local22 -1)
				(= global226 1)
				(= global252 -1)
				(= global248 0)
				(= global249 0)
				(= local18 0)
				(= global253 0)
				(= local20 0)
				(= local21 0)
				(sDealer deal: self)
			)
			(5
				(= local10 1)
				(EnableCursor)
				(resignButton setPri: 1 init:)
				((KeyMouse objList:) add: resignButton)
				(undoButton setPri: 1 init:)
				((KeyMouse objList:) add: undoButton)
				(= local7 0)
				(found1Empty init: setPri: 1)
				(handleEventList add: hand1 hand2 hand3 hand4)
				(if (== global927 0)
					(handleEventList add: waste1Hand)
				)
				(handleEventList add: found1Hand)
				(handleEventList add: global419)
				(handleEventList add: resignButton)
				(handleEventList add: undoButton)
				(global419 init: client: hand1 active: 1 size: 48 addKeyMouse:)
				(for ((= temp1 0)) (< temp1 (gTheHands size:)) ((++ temp1))
					((gTheHands at: temp1) partner: 0)
				)
				(= global225 0)
				(= global226 0)
				(= local12 1)
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
				(((Deck at: temp0) tailList:) dispose:)
			)
			((Deck at: temp0) tailList: 0)
			((Deck at: temp0) whenPlayed: 0)
			((Deck at: temp0) previousHand: 0)
		)
		(if (and local19 (not local13))
			(proc6022_7 {seconds} timeWindow)
			(proc6022_7 {minutes} timeWindow)
		)
		(if local23
			(= local23 0)
			(tabView hide:)
		)
		(resignButton dispose:)
		(undoButton dispose:)
		(= local7 0)
		(gTheHands eachElementDo: #endHand)
		(waste1Hand endHand:)
		((KeyMouse objList:) release:)
		(global419 endHand:)
		(handleEventList release:)
		(global419 dispose:)
		(proc0_9 (gCast elements:) 0)
		(theHands release:)
		(if (== global927 0)
			(theHands add: hand1 hand2 hand3 hand4 found1Hand waste1Hand)
		else
			(theHands add: hand1 hand2 hand3 hand4 found1Hand)
		)
		(dealList release:)
		(dealList add: hand1 hand2 hand3 hand4)
		(sDealer init: dealList)
		(if global265
			(Deck sameDeck: 1)
			(= global265 0)
		)
		(if (not local13)
			(roomScript changeState: 3)
		)
	)
)

(instance endCode of Code
	(properties)

	(method (doit &tmp temp0)
		(if (not global494)
			(++ global221)
			(= global494 1)
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
			(if (and (== local16 59) (== local17 59))
				(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
			else
				(proc6022_6 local16 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 local17 92 20 1 {bestseconds} timeWindow)
			)
			(= local20 0)
		)
		(= local10 0)
		(proc6022_1 1)
		(if local9
			((ScriptID 6080 1) doit: global928) ; scoreHand
		)
		(= local9 1)
		(= local13 0)
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

	(method (handleEvent event &tmp [temp0 3])
		(if (and (!= global928 52) (super handleEvent: event))
			(event claimed: 1)
			((ScriptID 930 0) init: 9131 3 gCurRoomNum) ; yesNo
			(DisposeScript 930)
			(if global748
				(handleEventList delete: self)
				(IconBarF darken:)
				(proc6022_1 1)
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
							(resetStock doit:)
							(for ((= temp1 1)) (< temp1 4) ((++ temp1))
								(for
									((= temp0 0))
									(< temp0 (Deck size:))
									((++ temp0))
									
									(if
										(and
											((Deck at: temp0) whenPlayed:)
											(==
												(((Deck at: temp0) whenPlayed:)
													at:
														(-
															(((Deck at: temp0)
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
															(((Deck at: temp0)
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
										((temp3 owner:) eliminateCard: temp3)
										(temp3 hide:)
										(temp3 inPlay: 0)
										(if (> ((temp3 previousHand:) size:) 1)
											(for
												((= temp2 0))
												(<
													temp2
													(-
														((temp3 previousHand:)
															size:
														)
														1
													)
												)
												((++ temp2))
												
												(tempList
													add:
														((temp3 previousHand:)
															at: temp2
														)
												)
											)
											((temp3 previousHand:) release:)
											(for
												((= temp2 0))
												(< temp2 (tempList size:))
												((++ temp2))
												
												((temp3 previousHand:)
													add: (tempList at: temp2)
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
										(resetStock doit:)
										(break)
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
								(break)
							)
							((temp3 previousHand:)
								delete:
									((temp3 previousHand:)
										at: (- ((temp3 previousHand:) size:) 1)
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

(class aceHand of sHand
	(properties)

	(method (legalPlay param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(for ((= temp0 0)) (< temp0 (gTheHands size:)) ((++ temp0))
			(if (== (param1 owner:) (gTheHands at: temp0))
			else
				(= temp5 ((gTheHands at: temp0) size:))
				(= temp6 (gTheHands at: temp0))
				(if (param1 tailList:)
					(= temp4 (+ 1 ((param1 tailList:) size:)))
				else
					(= temp4 1)
				)
				(= temp1 (temp6 lastCrd:))
				(if
					(and
						(proc15_0 temp1 param1)
						(or
							(!= (temp6 buildOrder:) 0)
							(and (== temp5 0) (== (temp6 startRank:) 3))
						)
						(not (and (param1 tailList:) (!= (temp6 whatType:) 0)))
						(<= (+ temp4 (temp6 size:)) (temp6 cardLimit:))
						(or
							(== ((param1 owner:) whereTo:) 0)
							(and
								(== ((param1 owner:) whereTo:) 1)
								(== (temp6 whatType:) 1)
							)
						)
						(or
							(and
								(== temp5 0)
								(!= (temp6 startRank:) 0)
								(or
									(and
										(== (param1 rank:) 13)
										(== (temp6 startRank:) 1)
									)
									(and
										(== (param1 rank:) 1)
										(== (temp6 startRank:) 2)
									)
									(== (temp6 startRank:) 3)
									(and
										(== (temp6 startRank:) 4)
										(or
											(== (temp6 followRank:) 0)
											(==
												(param1 rank:)
												(temp6 followRank:)
											)
										)
									)
								)
							)
							(temp6 buildCheck: temp1 param1)
						)
						(or
							(== (temp6 whatType:) 4)
							(proc6022_5 param1)
							(and (== (temp6 whatType:) 0) (== temp5 0))
						)
						(not (and (== (temp6 startRank:) 0) (== temp5 0)))
					)
					((gTheHands at: temp0) add: param1)
					(if (param1 tailList:)
						(for
							((= temp2 0))
							(< temp2 ((param1 tailList:) size:))
							((++ temp2))
							
							(= temp3 ((param1 tailList:) at: temp2))
							((gTheHands at: temp0) add: temp3)
						)
					)
					(if (!= (temp6 whatType:) 1)
						(gSound play: 907)
					)
					(return 1)
				)
			)
		)
	)
)

(instance hand1 of aceHand
	(properties
		x 183
		y 102
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 183
		cardLimit 13
		buildStep 1
		startRank 3
		canTrack 1
		canPlay 1
		cardsUp 1
	)
)

(instance hand1Empty of View
	(properties
		x 183
		y 102
		priority 1
		view 915
		loop 8
	)
)

(instance hand2 of aceHand
	(properties
		x 256
		y 102
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 256
		cardLimit 13
		buildStep 1
		startRank 3
		canTrack 1
		canPlay 1
		cardsUp 1
	)
)

(instance hand2Empty of View
	(properties
		x 256
		y 102
		priority 1
		view 915
		loop 8
	)
)

(instance hand3 of aceHand
	(properties
		x 329
		y 102
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 329
		cardLimit 13
		buildStep 1
		startRank 3
		canTrack 1
		canPlay 1
		cardsUp 1
	)
)

(instance hand3Empty of View
	(properties
		x 329
		y 102
		priority 1
		view 915
		loop 8
	)
)

(instance hand4 of aceHand
	(properties
		x 402
		y 102
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 402
		cardLimit 13
		buildStep 1
		startRank 3
		canTrack 1
		canPlay 1
		cardsUp 1
	)
)

(instance hand4Empty of View
	(properties
		x 402
		y 102
		priority 1
		view 915
		loop 8
	)
)

(instance waste1Hand of sHand
	(properties
		x 91
		y 246
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 4
		cardLimit 5
		buildOrder 10
		buildStep 1
		startRank 3
		wrapping 1
		canPlay 1
		orgX 91
		orgY 246
		whereTo 2
	)

	(method (handleEvent event)
		(= global223 1)
		(if (and (super handleEvent: event) (!= (event type:) evKEYBOARD) global222)
			(Print
				ticks: 400
				fore: 0
				mode: 0
				addBitmap: 917 4 0
				font: gUserFont
				addText:
					{Any available card from the Columns\ncan be played to this pile, but no\ncards can be played from this pile.}
					6
					6
				init:
			)
		)
		(= global223 0)
	)
)

(instance waste1Empty of View
	(properties
		x 91
		y 246
		priority 1
		view 915
		loop 8
	)
)

(instance found1Hand of sHand
	(properties
		x 492
		y 142
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 1
		cardShow 1
		cardLimit 52
		buildOrder 10
		buildStep 1
		startRank 3
		wrapping 1
		orgX 492
		orgY 142
		whereTo 2
	)
)

(instance found1Empty of View
	(properties
		x 492
		y 142
		view 915
		loop 9
	)
)

(instance found1Grow of View
	(properties
		x 492
		y 142
		view 915
		loop 4
	)
)

(instance tempList of List
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

(instance handleEventList of EventHandler
	(properties)
)

(instance theStock of Stock
	(properties
		priority 4
		offsetY 10
	)

	(method (init)
		(= x 77)
		(= y 131)
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
				(handleEventList add: global419)
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
				(handleEventList delete: global419)
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
		(DisableCursor)
		(= local4 0)
		(if (or (and (== (= local3 1) 1) size) (and (== local3 0) size))
			(-= size 4)
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
			(if (== local3 1)
				(= local4 1)
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
				(if local4
					(= temp0 (getThree doit:))
				else
					(= temp0 (getOne doit:))
				)
				(= local4 0)
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
		(while (< temp1 4)
			(if (>= (Deck topCard:) 0)
				(= temp0 (Deck getCard:))
				(if (not (temp0 inPlay:))
					(++ temp1)
					(= temp2 temp0)
					(gSound play: 903)
					(temp0 flip: 1 init:)
					(temp0 fromStock: 1)
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
							(theStock client: hand4)
						)
						(4
							((theStock client:) add: temp0)
							(theStock client: hand1)
						)
					)
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
		(= local5 (Deck topCard:))
		(= local6 (theStock size:))
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
		(if (and (== local16 59) (== local17 59))
			(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
			(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
		else
			(proc6022_6 local16 70 20 1 {bestminutes} timeWindow)
			(proc6022_6 local17 92 20 1 {bestseconds} timeWindow)
		)
	)
)

(instance tabView of View
	(properties
		view 710
	)

	(method (init)
		(if (== global927 0)
			(= cel 0)
		else
			(= cel 1)
		)
		(self setPri: 255)
		(= local23 1)
		(super init: &rest)
	)
)

