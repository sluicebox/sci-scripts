;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6001)
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
	calculation 0
	proc6001_1 1
	optionCode 2
	roomScript 3
	proc6001_4 4
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
)

(procedure (proc6001_1 param1)
	((ScriptID 6080 0) doit: global928 (if argc param1 else 0)) ; scoreSolitaire
)

(procedure (proc6001_4 param1) ; UNUSED
	(if argc
		(= local14 param1)
	else
		(return local14)
	)
)

(procedure (localproc_0 &tmp temp0 temp1)
	(== temp0 0) ; UNINIT
	(while (< temp0 (Deck size:)) ; UNINIT
		(= temp1 (Deck at: temp0)) ; UNINIT
		(cond
			((and (== (temp1 rank:) 1) (== (temp1 suit:) 0))
				(= local5 temp1)
			)
			((and (== (temp1 rank:) 2) (== (temp1 suit:) 1))
				(= local6 temp1)
			)
			((and (== (temp1 rank:) 3) (== (temp1 suit:) 2))
				(= local7 temp1)
			)
			((and (== (temp1 rank:) 4) (== (temp1 suit:) 3))
				(= local8 temp1)
			)
		)
		(++ temp0) ; UNINIT
	)
)

(procedure (localproc_1 &tmp temp0 temp1)
	(if (not (and local5 local6 local7 local8))
		(localproc_0)
	)
	(Deck delete: local5)
	(Deck delete: local6)
	(Deck delete: local7)
	(Deck delete: local8)
	(Deck add: local8)
	(Deck add: local7)
	(Deck add: local6)
	(Deck add: local5)
	(for ((= temp1 0)) (< temp1 4) ((++ temp1))
		(= temp0 (Deck getCard:))
		(cond
			((not (fnd1 size:))
				(fnd1 add: temp0)
			)
			((not (fnd2 size:))
				(fnd2 add: temp0)
			)
			((not (fnd3 size:))
				(fnd3 add: temp0)
			)
			(else
				(fnd4 add: temp0)
			)
		)
	)
	(aceView init:)
	(twoView init:)
	(threeView init:)
	(fourView init: setPri: 1)
)

(instance calculation of HoyleRoom
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
			(gSound2 play: 806)
		)
		(= local13 0)
		(= gCardGameScriptNumber 6001)
		(= local14 0)
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
		((= global929 calculat_opt) doit:)
		(= picture (+ global877 global385))
		(= local25 global385)
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
		(fnd1 emptyView: found1Empty)
		(fnd2 emptyView: found2Empty)
		(fnd3 emptyView: found3Empty)
		(fnd4 emptyView: found4Empty)
		(if (== global927 1)
			((= gTheHands theHands)
				add: hand1 hand2 hand3 hand4 fnd1 fnd2 fnd3 fnd4
			)
		else
			((= gTheHands theHands)
				add: hand1 hand2 hand3 hand4 hand5 fnd1 fnd2 fnd3 fnd4
			)
		)
		((= gTheFoundations theFoundations) add: fnd1 fnd2 fnd3 fnd4)
		(handleEventList add:)
		(Deck init: sCard)
		(Deck rankAces: 1)
		(= global419 theStock)
		(global419 client: flip1)
		(global929 doit: 3)
		(= local12 1)
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
			((not local14)
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
				local24
			)
			(event claimed: 1)
			(= local24 0)
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
	)

	(method (dispose &tmp temp0)
		(= local13 0)
		(= global419 0)
		(= global418 0)
		(gDelayCast release:)
		(= global458 0)
		(IconBarF dispose:)
		((KeyMouse objList:) release:)
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
		(flip1 release: dispose:)
		(if (magList size:)
			(magList release:)
		)
		(if local24
			(tabView hide: dispose:)
		)
		(magList dispose:)
		(theHands dispose:)
		(theFoundations dispose:)
		(hand1Empty dispose:)
		(hand2Empty dispose:)
		(hand3Empty dispose:)
		(hand4Empty dispose:)
		(hand5Empty dispose:)
		(found1Empty dispose:)
		(found2Empty dispose:)
		(found3Empty dispose:)
		(found4Empty dispose:)
		(aceView dispose:)
		(twoView dispose:)
		(threeView dispose:)
		(fourView dispose:)
		(handleEventList release: dispose:)
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

(instance calculat_opt of File
	(properties
		name {calculat.opt}
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
									local14
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
				(= local14 (temp1 asInteger:))
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
				(= local14 0)
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

	(method (doit &tmp temp0 temp1 temp2 [temp3 2] temp5 [temp6 4])
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
		(if (!= global385 local25)
			(if local19
				(proc6022_7 {back} timeWindow)
				(proc0_10 990 5 global385 0 0 1 timeWindow {back})
			else
				(proc6022_7 {back} currentScoreWindow)
				(proc0_10 990 5 global385 0 0 1 currentScoreWindow {back})
			)
			(= local25 global385)
		)
		(if
			(and
				global250
				local13
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
		(if (and local13 (== state 5))
			(cond
				(global109
					(if (not local1)
						(for
							((= temp1 0))
							(< temp1 (gTheHands size:))
							((++ temp1))
							
							(magList add: (gTheHands at: temp1))
						)
						(magList add: flip1)
						(Load rsVIEW 985)
						(= local1 1)
					)
					(for ((= temp1 0)) (< temp1 (magList size:)) ((++ temp1))
						(for
							((= temp2 (- ((magList at: temp1) size:) 1)))
							(> temp2 -1)
							((-- temp2))
							
							(= temp5 ((magList at: temp1) at: temp2))
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
										(<
											(aceView x:)
											gMouseX
											(+ (aceView x:) 54)
										)
										(<
											(aceView y:)
											gMouseY
											(+ (aceView y:) 77)
										)
										(= temp5 (fnd1 at: 0))
									)
									(and
										(<
											(twoView x:)
											gMouseX
											(+ (twoView x:) 54)
										)
										(<
											(twoView y:)
											gMouseY
											(+ (twoView y:) 77)
										)
										(= temp5 (fnd2 at: 0))
									)
									(and
										(<
											(threeView x:)
											gMouseX
											(+ (threeView x:) 54)
										)
										(<
											(threeView y:)
											gMouseY
											(+ (threeView y:) 77)
										)
										(= temp5 (fnd3 at: 0))
									)
									(and
										(<
											(fourView x:)
											gMouseX
											(+ (fourView x:) 54)
										)
										(<
											(fourView y:)
											gMouseY
											(+ (fourView y:) 77)
										)
										(= temp5 (fnd4 at: 0))
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
					(magList release: dispose:)
					(magView hide:)
				)
			)
			(if (and (not global250) (!= local23 global928))
				(proc6022_7 {score} currentScoreWindow)
				(proc6022_6 global928 86 11 1 {score} currentScoreWindow)
				(= local23 global928)
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
				(= local13 0)
				(= ticks (= ticks 1))
			)
			(1
				(= ticks 1)
			)
			(2
				(= ticks 10)
				(IconBar show:)
			)
			(3
				(gTheIconBar enable:)
				(if global524
					(= global524 0)
				)
				(= ticks 10)
			)
			(4
				(= local13 0)
				(for ((= temp1 0)) (< temp1 (Deck size:)) ((++ temp1))
					((Deck at: temp1) tailList: 0)
					((Deck at: temp1) whenPlayed: 0)
					((Deck at: temp1) previousHand: 0)
					((Deck at: temp1) inPlay: 0)
				)
				(= local5 0)
				(= local6 0)
				(= local7 0)
				(= local8 0)
				(= local12 1)
				(= local4 0)
				(= global928 4)
				(= local23 -1)
				(= global226 1)
				(Deck shuffle:)
				(localproc_0)
				(localproc_1)
				(= global395 0)
				(= local9 0)
				(= global243 0)
				(= global252 -1)
				(= global248 0)
				(= global249 0)
				(= local21 0)
				(= global253 0)
				(= local20 0)
				(= local22 0)
				(= cycles 1)
			)
			(5
				(= local13 1)
				(EnableCursor)
				(resignButton setPri: 1 init:)
				((KeyMouse objList:) add: resignButton)
				(undoButton setPri: 1 init:)
				((KeyMouse objList:) add: undoButton)
				(= local11 0)
				(= local10 0)
				(found1Empty init: setPri: 1)
				(found2Empty init: setPri: 1)
				(found3Empty init: setPri: 1)
				(found4Empty init: setPri: 1)
				(hand1Empty setPri: 1 init: show:)
				(hand2Empty setPri: 1 init: show:)
				(hand3Empty setPri: 1 init: show:)
				(hand4Empty setPri: 1 init: show:)
				(if (== global927 1)
					(handleEventList add: hand1 hand2 hand3 hand4)
					(global419
						init:
						client: flip1
						active: 1
						size: 48
						addKeyMouse:
					)
				else
					(handleEventList add: hand1 hand2 hand3 hand4 hand5)
					(global419
						init:
						client: flip1
						active: 1
						size: 48
						addKeyMouse:
					)
					(hand5Empty setPri: 1 init: show:)
				)
				(handleEventList add: fnd1 fnd2 fnd3 fnd4)
				(handleEventList add: global419)
				(handleEventList add: flip1)
				(handleEventList add: resignButton)
				(handleEventList add: undoButton)
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
		(if (and local19 (!= global928 52))
			(proc6022_7 {seconds} timeWindow)
			(proc6022_7 {minutes} timeWindow)
		)
		(if local24
			(= local24 0)
			(tabView hide:)
		)
		(= local11 0)
		(= local10 0)
		(gTheHands eachElementDo: #endHand)
		(flip1 endHand:)
		((KeyMouse objList:) release:)
		(global419 endHand:)
		(handleEventList release:)
		(global419 dispose:)
		(aceView dispose:)
		(twoView dispose:)
		(threeView dispose:)
		(fourView dispose:)
		(= local5 0)
		(= local6 0)
		(= local7 0)
		(= local8 0)
		(proc0_9 (gCast elements:) 0)
		(theHands release:)
		(if (== global927 1)
			(hand5 dispose:)
			(theHands add: hand1 hand2 hand3 hand4 fnd1 fnd2 fnd3 fnd4)
		else
			(hand5 add:)
			(theHands add: hand1 hand2 hand3 hand4 hand5 fnd1 fnd2 fnd3 fnd4)
		)
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
		(if (not global499)
			(++ global221)
			(= global499 1)
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
		(= local13 0)
		(proc6001_1 1)
		(if local12
			((ScriptID 6080 1) doit: global928) ; scoreHand
		)
		(= local12 1)
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
		(= x 43)
		(= y 261)
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
				)
			)
			((< 4 size 9)
				(= local11 0)
				(self setLoop: 2 posn: (+ origX 10) (+ origY 9))
				((ScriptID 15 7) ; stockBack
					view: (+ 54 global384)
					setLoop: 0
					posn: (+ origX 10) (+ origY 9)
				)
			)
			((< 0 size 5)
				(handleEventList add: global419)
				(= local11 0)
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
				)
			)
		)
	)

	(method (getCard)
		(DisableCursor)
		(if (not (flip1 size:))
			(= local10 0)
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
				((ScriptID 15 6) hide: setMotion: MoveTo 43 173 self) ; littleCard
				(= global116 0)
			else
				(EnableCursor)
			)
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
		(if (and (!= global928 52) (super handleEvent: event))
			(event claimed: 1)
			((ScriptID 930 0) init: 9131 3 gCurRoomNum) ; yesNo
			(DisposeScript 930)
			(if global748
				(handleEventList delete: self)
				(IconBarF darken:)
				(proc6001_1 1)
				(IconBarF lighten:)
				(if local12
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
				(= cycles
					(if global455
						(* global386 3)
					else
						1
					)
				)
			)
			(2
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
		(= local10 0)
		(= temp1 0)
		(while (< temp1 1)
			(= temp0 (Deck getCard:))
			(if (not (temp0 inPlay:))
				(temp0 fromStock: 1)
				((theStock client:) add: temp0)
				(++ temp1)
			)
		)
		(return temp0)
	)
)

(instance optionCode of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(if (== param1 1)
			(if (or (sDealer script:) (not local13))
				(= global920 1)
				(if global896
					(gChar1 sayReg: 6005 15 128 0 (Random 1 2))
				else
					(gChar1 say: 6005 15 128 0 2)
				)
			else
				(= local12 0)
				(cleanUp doit:)
			)
			(return 1)
		)
		(return
			(if (and local11 (> (theStock size:) 0))
				(= local11 0)
				(theStock adjust:)
			)
		)
	)
)

(instance theFoundations of List
	(properties)
)

(instance hand1 of sHand
	(properties
		x 119
		y 20
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 119
		cardLimit 27
		buildOrder 10
		startRank 3
		canPlay 1
		whereTo 1
	)
)

(instance hand1Empty of View
	(properties
		x 119
		y 20
		priority 1
		view 915
		loop 8
	)
)

(instance hand2 of sHand
	(properties
		x 188
		y 20
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 188
		cardLimit 27
		buildOrder 10
		startRank 3
		canPlay 1
		whereTo 1
	)
)

(instance hand2Empty of View
	(properties
		x 188
		y 20
		priority 1
		view 915
		loop 8
	)
)

(instance hand3 of sHand
	(properties
		x 257
		y 20
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 257
		cardLimit 27
		buildOrder 10
		startRank 3
		canPlay 1
		whereTo 1
	)
)

(instance hand3Empty of View
	(properties
		x 257
		y 20
		priority 1
		view 915
		loop 8
	)
)

(instance hand4 of sHand
	(properties
		x 326
		y 20
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 326
		cardLimit 27
		buildOrder 10
		startRank 3
		canPlay 1
		whereTo 1
	)
)

(instance hand4Empty of View
	(properties
		x 326
		y 20
		priority 1
		view 915
		loop 8
	)
)

(instance hand5 of sHand
	(properties
		x 396
		y 20
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 396
		cardLimit 27
		buildOrder 10
		startRank 3
		canPlay 1
		whereTo 1
	)
)

(instance hand5Empty of View
	(properties
		x 396
		y 20
		priority 1
		view 915
		loop 8
	)
)

(instance flip1 of sHand
	(properties
		x 43
		y 173
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 43
		whatType 2
		cardShow 1
		cardLimit 1
		canPlay 1
	)

	(method (add param1)
		(self topCard: param1)
		(super add: param1 &rest)
		((self topCard:) flip: 1 show: init:)
	)
)

(instance fnd1 of sHand
	(properties
		x 467
		y 20
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 1
		cardShow 1
		cardLimit 13
		buildOrder 1
		buildStep 1
		startRank 3
		wrapping 1
	)
)

(instance fnd2 of sHand
	(properties
		x 467
		y 121
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 1
		cardShow 1
		cardLimit 13
		buildOrder 1
		buildStep 2
		startRank 3
		wrapping 1
	)
)

(instance fnd3 of sHand
	(properties
		x 467
		y 221
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 1
		cardShow 1
		cardLimit 13
		buildOrder 1
		buildStep 3
		startRank 3
		wrapping 1
	)
)

(instance fnd4 of sHand
	(properties
		x 467
		y 322
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 1
		cardShow 1
		cardLimit 13
		buildOrder 1
		buildStep 4
		startRank 3
		wrapping 1
	)
)

(instance found1Empty of View
	(properties
		x 467
		y 20
		priority 1
		view 915
		loop 9
	)
)

(instance found2Empty of View
	(properties
		x 467
		y 121
		priority 1
		view 915
		loop 9
	)
)

(instance found3Empty of View
	(properties
		x 467
		y 221
		priority 1
		view 915
		loop 9
	)
)

(instance found4Empty of View
	(properties
		x 467
		y 322
		priority 1
		view 915
		loop 9
	)
)

(instance theHands of List
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

(instance aceView of View
	(properties
		x 540
		y 20
		priority 1
		view 50
		cel 1
	)
)

(instance twoView of View
	(properties
		x 540
		y 121
		priority 1
		view 51
		cel 2
	)
)

(instance threeView of View
	(properties
		x 540
		y 221
		priority 1
		view 52
		cel 3
	)
)

(instance fourView of View
	(properties
		x 540
		y 322
		priority 1
		view 53
		cel 4
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
		x 218
		y 446
		priority 35
		view 977
		loop 5
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
		view 715
	)

	(method (init)
		(if (== global927 0)
			(= cel 0)
		else
			(= cel 1)
		)
		(self setPri: 256)
		(= local24 1)
		(super init: &rest)
	)
)

