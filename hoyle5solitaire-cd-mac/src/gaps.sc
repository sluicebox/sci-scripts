;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6023)
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
	gaps 0
	proc6023_1 1
	optionCode 2
	roomScript 3
	proc6023_4 4
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
	local10 = -1
	local11 = -1
	local12 = -1
	local13 = -1
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
	local29
	local30
	local31 = {spades}
	local32 = {clubs}
	local33 = {diamonds}
	local34 = {hearts}
	local35
	local36
	local37
	local38
	local39
	local40
	local41
	local42
	local43
	local44
	local45
	local46
)

(procedure (proc6023_1 param1)
	((ScriptID 6080 0) doit: global928 (if argc param1 else 0)) ; scoreSolitaire
)

(procedure (proc6023_4 param1) ; UNUSED
	(if argc
		(= local7 param1)
	else
		(return local7)
	)
)

(procedure (localproc_0 param1 param2 param3 param4 &tmp temp0 temp1)
	(if (not global226)
		(++ global225)
		(local8 setWhenPlayed:)
		(param2 setWhenPlayed:)
	)
	(if (== (local8 owner:) param1)
		(if (< param4 param3)
			(tmpCrdList add: param2)
			(for ((= temp0 (+ param4 1))) (< temp0 param3) ((++ temp0))
				(tmpCrdList add: (param1 at: temp0))
			)
			(tmpCrdList add: local8)
			(for ((= temp0 (+ param3 1))) (< temp0 13) ((++ temp0))
				(tmpCrdList add: (param1 at: temp0))
			)
			(for ((= temp0 param4)) (< temp0 13) ((++ temp0))
				(param1 eliminateCard: (param1 at: param4))
			)
			(for ((= temp0 0)) (< temp0 (tmpCrdList size:)) ((++ temp0))
				(param1 add: (tmpCrdList at: temp0))
			)
		else
			(tmpCrdList add: local8)
			(for ((= temp0 (+ param3 1))) (< temp0 param4) ((++ temp0))
				(tmpCrdList add: (param1 at: temp0))
			)
			(tmpCrdList add: param2)
			(for ((= temp0 (+ param4 1))) (< temp0 13) ((++ temp0))
				(tmpCrdList add: (param1 at: temp0))
			)
			(for ((= temp0 param3)) (< temp0 13) ((++ temp0))
				(param1 eliminateCard: (param1 at: param3))
			)
			(for ((= temp0 0)) (< temp0 (tmpCrdList size:)) ((++ temp0))
				(param1 add: (tmpCrdList at: temp0))
			)
		)
	else
		((local8 owner:) eliminateCard: local8)
		(tmpCrdList add: param2)
		(for ((= temp0 param4)) (< temp0 ((local8 owner:) size:)) ((++ temp0))
			(tmpCrdList add: ((local8 owner:) at: temp0))
		)
		(for ((= temp0 0)) (< temp0 (- 12 param4)) ((++ temp0))
			((local8 owner:) eliminateCard: ((local8 owner:) at: param4))
		)
		(for ((= temp0 0)) (< temp0 (tmpCrdList size:)) ((++ temp0))
			((local8 owner:) add: (tmpCrdList at: temp0))
		)
		(tmpCrdList release:)
		(tmpCrdList add: local8)
		(param1 eliminateCard: param2)
		(for ((= temp0 param3)) (< temp0 (param1 size:)) ((++ temp0))
			(tmpCrdList add: (param1 at: temp0))
		)
		(for ((= temp0 0)) (< temp0 (- 12 param3)) ((++ temp0))
			(param1 eliminateCard: (param1 at: param3))
		)
		(for ((= temp0 0)) (< temp0 (tmpCrdList size:)) ((++ temp0))
			(param1 add: (tmpCrdList at: temp0))
		)
	)
	(tmpCrdList release:)
	(= local8 0)
)

(procedure (localproc_1 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp2 2)
	(= temp3 0)
	(= local27 0)
	(= local28 0)
	(= local29 0)
	(= local30 0)
	(= temp4 1)
	(for ((= temp0 0)) (< temp0 4) ((++ temp0))
		(for ((= temp1 0)) (< temp1 12) ((++ temp1))
			(if (== (((gTheHands at: temp0) at: temp1) rank:) temp2)
				(if
					(and
						temp4
						(== (((gTheHands at: temp0) at: 0) rank:) 2)
						(==
							(((gTheHands at: temp0) at: temp1) suit:)
							(((gTheHands at: temp0) at: 0) suit:)
						)
					)
					(if (== temp0 0)
						(++ local27)
					)
					(if (== temp0 1)
						(++ local28)
					)
					(if (== temp0 2)
						(++ local29)
					)
					(if (== temp0 3)
						(++ local30)
					)
				)
				(++ temp2)
			else
				(= temp4 0)
			)
		)
		(if (== temp2 14)
			(++ temp3)
		)
		(= temp4 1)
		(= temp2 2)
	)
	(= global928 (+ local27 local28 local29 local30))
	(if (== temp3 4)
		(+= global928 4)
		(return 1)
	else
		(return 0)
	)
)

(procedure (localproc_2 &tmp temp0 temp1 temp2 temp3)
	(= temp2 2)
	(= temp3 -1)
	(tempList add: temp1 temp2 temp3 temp4) ; UNINIT
	(for ((= temp0 0)) (< temp0 4) ((++ temp0))
		(for ((= temp1 0)) (< temp1 12) ((++ temp1))
			(if (== (((gTheHands at: temp0) at: temp1) rank:) 2)
				(= temp3 (((gTheHands at: temp0) at: temp1) suit:))
			)
			(if (== (((gTheHands at: temp0) at: temp1) suit:) temp3)
				(if (== (((gTheHands at: temp0) at: temp1) rank:) temp2)
					(tmpCrdList add: ((gTheHands at: temp0) at: temp1))
					(++ temp2)
				else
					(break)
				)
			else
				(break)
			)
		)
		(= temp2 2)
		((gTheHands at: temp0) eachElementDo: #hide release:)
		(for ((= temp1 0)) (< temp1 (tmpCrdList size:)) ((++ temp1))
			((tempList at: temp0) add: (tmpCrdList at: temp1))
			((gTheHands at: temp0) cardsUp: (- 13 (tmpCrdList size:)))
		)
		(if (tmpCrdList size:)
			(tmpCrdList release:)
		)
	)
	(if (tmpCrdList size:)
		(tmpCrdList release:)
	)
	(for ((= temp0 0)) (< temp0 4) ((++ temp0))
		(if ((tempList at: temp0) size:)
			(for
				((= temp1 0))
				(< temp1 ((tempList at: temp0) size:))
				((++ temp1))
				
				(Deck delete: ((tempList at: temp0) at: temp1))
			)
		)
	)
	(for ((= temp0 0)) (< temp0 4) ((++ temp0))
		(for ((= temp1 0)) (< temp1 ((tempList at: temp0) size:)) ((++ temp1))
			((gTheHands at: temp0) add: ((tempList at: temp0) at: temp1))
			(((tempList at: temp0) at: temp1) show: flip:)
		)
	)
	(Deck shuffle:)
	(for ((= temp0 0)) (< temp0 (Deck size:)) ((++ temp0))
		(cond
			((!= ((gTheHands at: 0) size:) 13)
				((gTheHands at: 0) add: (Deck at: temp0))
			)
			((!= ((gTheHands at: 1) size:) 13)
				((gTheHands at: 1) add: (Deck at: temp0))
			)
			((!= ((gTheHands at: 2) size:) 13)
				((gTheHands at: 2) add: (Deck at: temp0))
			)
			((!= ((gTheHands at: 3) size:) 13)
				((gTheHands at: 3) add: (Deck at: temp0))
			)
		)
	)
	(for ((= temp0 0)) (< temp0 4) ((++ temp0))
		(for ((= temp1 0)) (< temp1 13) ((++ temp1))
			(((gTheHands at: temp0) at: temp1) show: flip:)
		)
	)
	(for ((= temp0 0)) (< temp0 4) ((++ temp0))
		(for ((= temp1 0)) (< temp1 ((tempList at: temp0) size:)) ((++ temp1))
			(Deck add: ((tempList at: temp0) at: temp1))
		)
	)
	(if (tmpCrdList size:)
		(tmpCrdList release:)
	)
	(if (temp1 size:)
		(temp1 release:)
	)
	(if (temp2 size:)
		(temp2 release:)
	)
	(if (temp3 size:)
		(temp3 release:)
	)
	(if (temp4 size:)
		(temp4 release:)
	)
	(tempList release:)
	(local18 view: 973 loop: 0)
	(local19 view: 973 loop: 1)
	(local20 view: 973 loop: 2)
	(local21 view: 973 loop: 3)
)

(procedure (localproc_3 &tmp temp0 temp1)
	(== temp0 0) ; UNINIT
	(while (< temp0 (Deck size:)) ; UNINIT
		(= temp1 (Deck at: temp0)) ; UNINIT
		(cond
			((and (== (temp1 rank:) 2) (== (temp1 suit:) 0))
				(= local22 temp1)
				(tempTwos add: temp1)
			)
			((and (== (temp1 rank:) 2) (== (temp1 suit:) 1))
				(= local23 temp1)
				(tempTwos add: temp1)
			)
			((and (== (temp1 rank:) 2) (== (temp1 suit:) 2))
				(= local24 temp1)
				(tempTwos add: temp1)
			)
			((and (== (temp1 rank:) 2) (== (temp1 suit:) 3))
				(= local25 temp1)
				(tempTwos add: temp1)
			)
		)
		(++ temp0) ; UNINIT
	)
)

(procedure (localproc_4)
	(if (not (and local22 local23 local24 local25))
		(localproc_3)
	)
	(Deck delete: local22)
	(Deck delete: local23)
	(Deck delete: local24)
	(Deck delete: local25)
	(Deck add: (tempTwos at: 0))
	(Deck add: (tempTwos at: 1))
	(Deck add: (tempTwos at: 2))
	(Deck add: (tempTwos at: 3))
	(tempTwos release:)
)

(instance gaps of HoyleRoom
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
			(gSound2 play: 814)
		)
		(= local6 0)
		(= gCardGameScriptNumber 6023)
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
		((= global929 gaps_opt) doit:)
		(= picture (+ global877 global385))
		(= local45 global385)
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
		((= gTheHands theHands) add: hand1 hand2 hand3 hand4)
		(handleEventList add:)
		(Deck init: gCard)
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
				local44
			)
			(event claimed: 1)
			(= local44 0)
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
		(theHands dispose:)
		(if (== global927 1)
			(flipButton dispose:)
		)
		(if local44
			(tabView hide: dispose:)
		)
		(handleEventList release: dispose:)
		(if local39
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

(instance gaps_opt of File
	(properties
		name {gaps.opt}
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
									local37
									local38
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
				(= local37 (temp1 asInteger:))
				(self readString: temp1 3)
				(= local38 (temp1 asInteger:))
				(temp1 dispose:)
				(self close:)
				(return 0)
			)
			(else
				(= local7 0)
				(= global927 0)
				(= local37 59)
				(= local38 59)
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
			(= local37 59)
			(= local38 59)
			(global929 doit: 3)
			(if local39
				(proc6022_7 {bestminutes} timeWindow)
				(proc6022_7 {bestseconds} timeWindow)
				(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
			)
		)
		(if (!= global385 local45)
			(if local39
				(proc6022_7 {back} timeWindow)
				(proc0_10 990 5 global385 0 0 1 timeWindow {back})
			else
				(proc6022_7 {back} currentScoreWindow)
				(proc0_10 990 5 global385 0 0 1 currentScoreWindow {back})
			)
			(= local45 global385)
		)
		(if
			(and
				global250
				local6
				(== state 5)
				(not local41)
				(not global253)
				local42
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
			(= local42 1)
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
									(!= (temp5 rank:) 1)
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
			(if (and (not global250) (!= local43 global928))
				(proc6022_7 {score} currentScoreWindow)
				(proc6022_6 global928 86 11 1 {score} currentScoreWindow)
				(= local43 global928)
			)
			(if (localproc_1)
				(= local41 1)
				(if global250
					(= local35 global248)
					(if
						(or
							(< (= local36 global249) local37)
							(and (== local36 local37) (< local35 local38))
						)
						(= local37 local36)
						(= local38 local35)
						(= local40 1)
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

	(method (changeState newState &tmp temp0 temp1 temp2)
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
				(= local6 0)
				(= local5 1)
				(for ((= temp1 0)) (< temp1 (Deck size:)) ((++ temp1))
					((Deck at: temp1) tailList: 0)
					((Deck at: temp1) whenPlayed: 0)
					((Deck at: temp1) previousHand: 0)
					((Deck at: temp1) wasFaceDown: 0)
				)
				(for ((= temp1 0)) (< temp1 (Deck size:)) ((++ temp1))
					(tmpDeck add: (Deck at: temp1))
				)
				(= global395 0)
				(Deck shuffle:)
				(localproc_3)
				(localproc_4)
				(= local2 0)
				(= global243 0)
				(= global226 1)
				(= global928 0)
				(= local43 -1)
				(= global252 -1)
				(= global248 0)
				(= global249 0)
				(= local41 0)
				(= global253 0)
				(= local40 0)
				(= local42 0)
				(sDealer deal: self)
			)
			(5
				(for ((= temp1 0)) (< temp1 4) ((++ temp1))
					(for ((= temp2 0)) (< temp2 13) ((++ temp2))
						(if (== (((gTheHands at: temp1) at: temp2) rank:) 1)
							(cond
								((< local10 0)
									(= local10 temp2)
									(= local14 temp1)
								)
								((< local11 0)
									(= local11 temp2)
									(= local15 temp1)
								)
								((< local12 0)
									(= local12 temp2)
									(= local16 temp1)
								)
								(else
									(= local13 temp2)
									(= local17 temp1)
								)
							)
						)
					)
				)
				(= local18 ((gTheHands at: local14) at: local10))
				(local18 view: 973 loop: 0 cel: 0)
				(= local19 ((gTheHands at: local15) at: local11))
				(local19 view: 973 loop: 1 cel: 0)
				(= local20 ((gTheHands at: local16) at: local12))
				(local20 view: 973 loop: 2 cel: 0)
				(= local21 ((gTheHands at: local17) at: local13))
				(local21 view: 973 loop: 3 cel: 0)
				(= local6 1)
				(EnableCursor)
				(resignButton setPri: 1 init:)
				((KeyMouse objList:) add: resignButton)
				(undoButton setPri: 1 init:)
				((KeyMouse objList:) add: undoButton)
				(= local3 0)
				(handleEventList add: hand1 hand2 hand3 hand4)
				(handleEventList add: resignButton)
				(handleEventList add: undoButton)
				(if (== global927 1)
					(flipButton setPri: 1 init: show:)
					(handleEventList add: flipButton)
				)
				(for ((= temp1 0)) (< temp1 (gTheHands size:)) ((++ temp1))
					((gTheHands at: temp1) partner: 0)
				)
				(= global226 0)
				(= global225 0)
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
		(if (and local39 (!= global928 52))
			(proc6022_7 {seconds} timeWindow)
			(proc6022_7 {minutes} timeWindow)
		)
		(if local44
			(= local44 0)
			(tabView hide:)
		)
		(if (== global927 1)
			(flipButton dispose:)
		)
		(= local3 0)
		(if (tmpDeck size:)
			(Deck release:)
			(for ((= temp0 0)) (< temp0 52) ((++ temp0))
				(Deck add: (tmpDeck at: temp0))
			)
		)
		(gTheHands eachElementDo: #endHand)
		((KeyMouse objList:) release:)
		(handleEventList release:)
		(proc0_9 (gCast elements:) 0)
		(= local8 0)
		(if (== global927 1)
			(hand1 cardsUp: 13)
			(hand2 cardsUp: 13)
			(hand3 cardsUp: 13)
			(hand4 cardsUp: 13)
		)
		(= local10 -1)
		(= local11 -1)
		(= local12 -1)
		(= local13 -1)
		(= local26 0)
		(dealList release:)
		(dealList add: hand1 hand2 hand3 hand4)
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
		(if (not global507)
			(++ global221)
			(= global507 1)
			(gGame_opt doit: 3)
		)
		(cleanUp doit:)
		(if (and global250 local40)
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
			(if (and (== local37 59) (== local38 59))
				(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
			else
				(proc6022_6 local37 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 local38 92 20 1 {bestseconds} timeWindow)
			)
			(= local40 0)
		)
		(= local6 0)
		(proc6023_1 1)
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
				(proc6023_1 1)
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
				(= temp3 0)
				(= local9 0)
				(= local8 0)
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
							(if (== ((Deck at: temp0) rank:) 1)
								(= temp2 (Deck at: temp0))
							else
								(= local8 (Deck at: temp0))
							)
						)
						(
							(and
								(== global927 1)
								(whenReset size:)
								(==
									(whenReset at: (- (whenReset size:) 1))
									global225
								)
							)
							(= temp3 1)
							(hand1 release:)
							(hand2 release:)
							(hand3 release:)
							(hand4 release:)
							(if (== local26 2)
								(for ((= temp1 0)) (< temp1 13) ((++ temp1))
									(hand1 add: (oldhand1List at: temp1))
									(hand2 add: (oldhand2List at: temp1))
									(hand3 add: (oldhand3List at: temp1))
									(hand4 add: (oldhand4List at: temp1))
								)
								(oldhand1List release:)
								(oldhand2List release:)
								(oldhand3List release:)
								(oldhand4List release:)
								(handleEventList add: flipButton)
								(flipButton show:)
							else
								(for ((= temp1 0)) (< temp1 13) ((++ temp1))
									(hand1 add: (olderhand1List at: temp1))
									(hand2 add: (olderhand2List at: temp1))
									(hand3 add: (olderhand3List at: temp1))
									(hand4 add: (olderhand4List at: temp1))
								)
								(olderhand1List release:)
								(olderhand2List release:)
								(olderhand3List release:)
								(olderhand4List release:)
							)
							(-- local26)
							(break)
						)
					)
				)
				(if (not temp3)
					(= local9 local8)
					(localproc_0
						(temp2 owner:)
						temp2
						((temp2 owner:) indexOf: temp2)
						((local8 owner:) indexOf: local8)
					)
					(-- global225)
					(= local8 local9)
					(local8 setWhenPlayed: 1)
					(temp2 setWhenPlayed: 1)
					(= local8 0)
				else
					(-- global225)
					(whenReset delete: (whenReset at: (- (whenReset size:) 1)))
				)
				(= global226 0)
			)
		)
	)
)

(instance flipButton of TrackingView
	(properties
		x 596
		y 284
		priority 1
		view 974
	)

	(method (handleEvent event &tmp temp0)
		(if (super handleEvent: event)
			(event claimed: 1)
			(if (!= local26 2)
				(++ local26)
				(++ global225)
				(whenReset add: global225)
				(if (== local26 1)
					(for ((= temp0 0)) (< temp0 13) ((++ temp0))
						(olderhand1List add: (hand1 at: temp0))
						(olderhand2List add: (hand2 at: temp0))
						(olderhand3List add: (hand3 at: temp0))
						(olderhand4List add: (hand4 at: temp0))
					)
				else
					(for ((= temp0 0)) (< temp0 13) ((++ temp0))
						(oldhand1List add: (hand1 at: temp0))
						(oldhand2List add: (hand2 at: temp0))
						(oldhand3List add: (hand3 at: temp0))
						(oldhand4List add: (hand4 at: temp0))
					)
				)
				(localproc_2)
			)
			(if (== local26 2)
				(handleEventList delete: self)
				(self hide:)
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

(class gHand of sHand
	(properties)

	(method (handleCard param1 param2 &tmp temp0 temp1 temp2 [temp3 4] temp7 temp8 temp9 temp10 temp11 temp12 temp13)
		(return
			(if
				(and
					(not (param1 claimed:))
					(not global395)
					(= temp0 (param2 reverseFirstTrue: 165 param1))
				)
				(= temp1 (param2 indexOf: temp0))
				(cond
					(
						(and
							(== (param2 tailMove:) 0)
							(!= temp1 (- (param2 size:) 1))
							(!= (param2 whatType:) 0)
						)
						(= global920 1)
						(gChar1 sayReg: 600 15 130 0 (Random 1 2))
						(if global222
							(Print
								ticks: 400
								fore: 0
								mode: 0
								addBitmap: 917 4 0
								font: gUserFont
								addText: {No Packed Card moves allowed.} 6 6
								init:
							)
						)
						(return 1)
					)
					(
						(and
							(or
								(== (param2 tailMove:) 1)
								(== (param2 tailMove:) 2)
							)
							(!= temp1 (- (param2 size:) 1))
							(not (param2 pBuild: temp0))
						)
						(= global920 1)
						(gChar1 sayReg: 600 15 130 0 (Random 1 2))
						(if global222
							(Print
								ticks: 400
								fore: 0
								mode: 0
								addBitmap: 917 4 0
								font: gUserFont
								addText:
									{Not a complete set of Packed Cards.}
									6
									6
								init:
							)
						)
						(return 1)
					)
					((== (param2 whereTo:) 2)
						(= global920 1)
						(gChar1 sayReg: 600 15 130 0 (Random 1 2))
						(if global222
							(Print
								ticks: 400
								fore: 0
								mode: 0
								addBitmap: 917 4 0
								font: gUserFont
								addText: {No Legal destination.} 6 6
								init:
							)
						)
						(return 1)
					)
				)
				(= global399 0)
				(if (= temp1 (param2 indexOf: temp0))
					((= global399 (param2 at: (- temp1 1))) setLoop: 0)
				)
				(if (not (temp0 faceUp:))
					(temp0 flip: 1)
				)
				(if
					(and
						(== (= temp8 (temp0 processEvent: param1 global399)) 1)
						(& (param1 modifiers:) $0003)
					)
					(= temp7 2)
				else
					(= temp7 temp8)
				)
				(if (and global222 (== (temp0 rank:) 1))
					(cond
						((== global927 0)
							(cond
								((== temp1 0)
									(if
										(or
											(==
												((param2 at: (+ temp1 1)) rank:)
												1
											)
											(==
												((param2 at: (+ temp1 1)) rank:)
												2
											)
										)
										(if (not local8)
											(Print
												ticks: 400
												fore: 0
												mode: 0
												addBitmap: 917 4 0
												font: gUserFont
												addTextF:
													{\n  You can only play a 2 here now.}
												init:
											)
											(return 1)
										)
									else
										(switch ((param2 at: (+ temp1 1)) suit:)
											(0
												(= temp10 local31)
											)
											(1
												(= temp10 local32)
											)
											(2
												(= temp10 local33)
											)
											(3
												(= temp10 local34)
											)
										)
										(switch
											(-
												((param2 at: (+ temp1 1)) rank:)
												1
											)
											(11
												(= temp11 {jack})
											)
											(12
												(= temp11 {queen})
											)
										)
										(cond
											(
												(<
													((param2 at: (+ temp1 1))
														rank:
													)
													12
												)
												(if (not local8)
													(Print
														ticks: 400
														fore: 0
														mode: 0
														addBitmap: 917 4 0
														font: gUserFont
														addTextF:
															{\n  You can only play a 2 or the %d of %s\n  here now.}
															(-
																((param2
																		at:
																			(+
																				temp1
																				1
																			)
																	)
																	rank:
																)
																1
															)
															temp10
														init:
													)
													(return 1)
												)
											)
											((not local8)
												(Print
													ticks: 400
													fore: 0
													mode: 0
													addBitmap: 917 4 0
													font: gUserFont
													addTextF:
														{\n  You can only play a 2 or the %s of\n  %s here now.}
														temp11
														temp10
													init:
												)
												(return 1)
											)
										)
									)
								)
								((== temp1 12)
									(if
										(or
											(==
												((param2 at: (- temp1 1)) rank:)
												1
											)
											(==
												((param2 at: (- temp1 1)) rank:)
												13
											)
										)
										(if (not local8)
											(Print
												ticks: 400
												fore: 0
												mode: 0
												addBitmap: 917 4 0
												font: gUserFont
												addTextF:
													{\n  You can't play a card here now.}
												init:
											)
											(return 1)
										)
									else
										(switch ((param2 at: (- temp1 1)) suit:)
											(0
												(= temp10 local31)
											)
											(1
												(= temp10 local32)
											)
											(2
												(= temp10 local33)
											)
											(3
												(= temp10 local34)
											)
										)
										(switch
											(+
												((param2 at: (- temp1 1)) rank:)
												1
											)
											(11
												(= temp11 {jack})
											)
											(12
												(= temp11 {queen})
											)
											(13
												(= temp11 {king})
											)
										)
										(cond
											(
												(<
													((param2 at: (- temp1 1))
														rank:
													)
													10
												)
												(if (not local8)
													(Print
														ticks: 400
														fore: 0
														mode: 0
														addBitmap: 917 4 0
														font: gUserFont
														addTextF:
															{\n  You can only play the %d of %s\n  here now.}
															(+
																((param2
																		at:
																			(-
																				temp1
																				1
																			)
																	)
																	rank:
																)
																1
															)
															temp10
														init:
													)
													(return 1)
												)
											)
											((not local8)
												(Print
													ticks: 400
													fore: 0
													mode: 0
													addBitmap: 917 4 0
													font: gUserFont
													addTextF:
														{\n  You can only play the %s of %s\n  here now.}
														temp11
														temp10
													init:
												)
												(return 1)
											)
										)
									)
								)
								(else
									(switch ((param2 at: (- temp1 1)) suit:)
										(0
											(= temp10 local31)
										)
										(1
											(= temp10 local32)
										)
										(2
											(= temp10 local33)
										)
										(3
											(= temp10 local34)
										)
									)
									(switch
										(+ ((param2 at: (- temp1 1)) rank:) 1)
										(11
											(= temp11 {jack})
										)
										(12
											(= temp11 {queen})
										)
										(13
											(= temp11 {king})
										)
									)
									(switch ((param2 at: (+ temp1 1)) suit:)
										(0
											(= temp12 local31)
										)
										(1
											(= temp12 local32)
										)
										(2
											(= temp12 local33)
										)
										(3
											(= temp12 local34)
										)
									)
									(switch
										(- ((param2 at: (+ temp1 1)) rank:) 1)
										(11
											(= temp13 {jack})
										)
										(12
											(= temp13 {queen})
										)
										(13
											(= temp13 {king})
										)
									)
									(cond
										(
											(or
												(and
													(==
														((param2
																at: (- temp1 1)
															)
															rank:
														)
														1
													)
													(<
														((param2
																at: (+ temp1 1)
															)
															rank:
														)
														3
													)
												)
												(and
													(==
														((param2
																at: (- temp1 1)
															)
															rank:
														)
														13
													)
													(<
														((param2
																at: (+ temp1 1)
															)
															rank:
														)
														3
													)
												)
											)
											(Print
												ticks: 400
												fore: 0
												mode: 0
												addBitmap: 917 4 0
												font: gUserFont
												addTextF:
													{\n  You can't play a card here now.}
												init:
											)
											(return 1)
										)
										((== ((param2 at: (+ temp1 1)) rank:) 1)
											(cond
												(
													(<
														((param2
																at: (- temp1 1)
															)
															rank:
														)
														10
													)
													(if (not local8)
														(Print
															ticks: 400
															fore: 0
															mode: 0
															addBitmap: 917 4 0
															font: gUserFont
															addTextF:
																{\n  You can only play the %d of %s\n  here now.}
																(+
																	((param2
																			at:
																				(-
																					temp1
																					1
																				)
																		)
																		rank:
																	)
																	1
																)
																temp10
															init:
														)
														(return 1)
													)
												)
												((not local8)
													(Print
														ticks: 400
														fore: 0
														mode: 0
														addBitmap: 917 4 0
														font: gUserFont
														addTextF:
															{\n  You can only play the %s of %s\n  here now.}
															temp11
															temp10
														init:
													)
													(return 1)
												)
											)
										)
										((== ((param2 at: (- temp1 1)) rank:) 1)
											(cond
												(
													(<
														((param2
																at: (+ temp1 1)
															)
															rank:
														)
														12
													)
													(if (not local8)
														(Print
															ticks: 400
															fore: 0
															mode: 0
															addBitmap: 917 4 0
															font: gUserFont
															addTextF:
																{\n  You can only play the %d of %s\n  here now.}
																(-
																	((param2
																			at:
																				(+
																					temp1
																					1
																				)
																		)
																		rank:
																	)
																	1
																)
																temp12
															init:
														)
														(return 1)
													)
												)
												((not local8)
													(Print
														ticks: 400
														fore: 0
														mode: 0
														addBitmap: 917 4 0
														font: gUserFont
														addTextF:
															{\n  You can only play the %s of %s\n  here now.}
															temp13
															temp12
														init:
													)
													(return 1)
												)
											)
										)
										((not local8)
											(cond
												(
													(and
														(<
															((param2
																	at:
																		(-
																			temp1
																			1
																		)
																)
																rank:
															)
															10
														)
														(<
															((param2
																	at:
																		(+
																			temp1
																			1
																		)
																)
																rank:
															)
															12
														)
													)
													(cond
														(
															(and
																(==
																	((param2
																			at:
																				(-
																					temp1
																					1
																				)
																		)
																		suit:
																	)
																	((param2
																			at:
																				(+
																					temp1
																					1
																				)
																		)
																		suit:
																	)
																)
																(==
																	((param2
																			at:
																				(-
																					temp1
																					1
																				)
																		)
																		rank:
																	)
																	(-
																		((param2
																				at:
																					(+
																						temp1
																						1
																					)
																			)
																			rank:
																		)
																		2
																	)
																)
															)
															(Print
																ticks: 400
																fore: 0
																mode: 0
																addBitmap:
																	917
																	4
																	0
																font: gUserFont
																addTextF:
																	{\n  You can only play the %d of %s\n  here now.}
																	(+
																		((param2
																				at:
																					(-
																						temp1
																						1
																					)
																			)
																			rank:
																		)
																		1
																	)
																	temp10
																init:
															)
														)
														(
															(!=
																((param2
																		at:
																			(+
																				temp1
																				1
																			)
																	)
																	rank:
																)
																2
															)
															(Print
																ticks: 400
																fore: 0
																mode: 0
																addBitmap:
																	917
																	4
																	0
																font: gUserFont
																addTextF:
																	{\n  You can only play the %d of %s\n  or the %d of %s here now.}
																	(+
																		((param2
																				at:
																					(-
																						temp1
																						1
																					)
																			)
																			rank:
																		)
																		1
																	)
																	temp10
																	(-
																		((param2
																				at:
																					(+
																						temp1
																						1
																					)
																			)
																			rank:
																		)
																		1
																	)
																	temp12
																init:
															)
														)
														(else
															(Print
																ticks: 400
																fore: 0
																mode: 0
																addBitmap:
																	917
																	4
																	0
																font: gUserFont
																addTextF:
																	{\n  You can only play the %d of %s\n  here now.}
																	(+
																		((param2
																				at:
																					(-
																						temp1
																						1
																					)
																			)
																			rank:
																		)
																		1
																	)
																	temp10
																init:
															)
														)
													)
													(return 1)
												)
												(
													(and
														(>
															((param2
																	at:
																		(-
																			temp1
																			1
																		)
																)
																rank:
															)
															9
														)
														(<
															((param2
																	at:
																		(+
																			temp1
																			1
																		)
																)
																rank:
															)
															12
														)
													)
													(cond
														(
															(and
																(==
																	((param2
																			at:
																				(-
																					temp1
																					1
																				)
																		)
																		suit:
																	)
																	((param2
																			at:
																				(+
																					temp1
																					1
																				)
																		)
																		suit:
																	)
																)
																(==
																	((param2
																			at:
																				(-
																					temp1
																					1
																				)
																		)
																		rank:
																	)
																	(-
																		((param2
																				at:
																					(+
																						temp1
																						1
																					)
																			)
																			rank:
																		)
																		2
																	)
																)
															)
															(if
																(<
																	((param2
																			at:
																				(+
																					temp1
																					1
																				)
																		)
																		rank:
																	)
																	12
																)
																(Print
																	ticks: 400
																	fore: 0
																	mode: 0
																	addBitmap:
																		917
																		4
																		0
																	font:
																		gUserFont
																	addTextF:
																		{\n  You can only play the %d of %s\n  here now.}
																		(+
																			((param2
																					at:
																						(-
																							temp1
																							1
																						)
																				)
																				rank:
																			)
																			1
																		)
																		temp10
																	init:
																)
															else
																(Print
																	ticks: 400
																	fore: 0
																	mode: 0
																	addBitmap:
																		917
																		4
																		0
																	font:
																		gUserFont
																	addTextF:
																		{\n  You can only play the %s of %s\n  here now.}
																		temp11
																		temp10
																	init:
																)
															)
														)
														(
															(!=
																((param2
																		at:
																			(-
																				temp1
																				1
																			)
																	)
																	rank:
																)
																13
															)
															(if
																(!=
																	((param2
																			at:
																				(+
																					temp1
																					1
																				)
																		)
																		rank:
																	)
																	2
																)
																(Print
																	ticks: 400
																	fore: 0
																	mode: 0
																	addBitmap:
																		917
																		4
																		0
																	font:
																		gUserFont
																	addTextF:
																		{\n  You can only play the %s of %s\n  or the %d of %s here now.}
																		temp11
																		temp10
																		(-
																			((param2
																					at:
																						(+
																							temp1
																							1
																						)
																				)
																				rank:
																			)
																			1
																		)
																		temp12
																	init:
																)
															else
																(Print
																	ticks: 400
																	fore: 0
																	mode: 0
																	addBitmap:
																		917
																		4
																		0
																	font:
																		gUserFont
																	addTextF:
																		{\n  You can only play the %s of %s\n  here now.}
																		temp11
																		temp10
																	init:
																)
															)
															(return 1)
														)
														(else
															(Print
																ticks: 400
																fore: 0
																mode: 0
																addBitmap:
																	917
																	4
																	0
																font: gUserFont
																addTextF:
																	{\n  You can only play the %d of %s\n  here now.}
																	(-
																		((param2
																				at:
																					(+
																						temp1
																						1
																					)
																			)
																			rank:
																		)
																		1
																	)
																	temp12
																init:
															)
														)
													)
													(return 1)
												)
												(
													(and
														(<
															((param2
																	at:
																		(-
																			temp1
																			1
																		)
																)
																rank:
															)
															10
														)
														(>
															((param2
																	at:
																		(+
																			temp1
																			1
																		)
																)
																rank:
															)
															11
														)
													)
													(Print
														ticks: 400
														fore: 0
														mode: 0
														addBitmap: 917 4 0
														font: gUserFont
														addTextF:
															{\n  You can only play the %d of %s\n  or the %s of %s here now.}
															(+
																((param2
																		at:
																			(-
																				temp1
																				1
																			)
																	)
																	rank:
																)
																1
															)
															temp10
															temp13
															temp12
														init:
													)
													(return 1)
												)
												(else
													(cond
														(
															(and
																(==
																	((param2
																			at:
																				(-
																					temp1
																					1
																				)
																		)
																		suit:
																	)
																	((param2
																			at:
																				(+
																					temp1
																					1
																				)
																		)
																		suit:
																	)
																)
																(==
																	((param2
																			at:
																				(-
																					temp1
																					1
																				)
																		)
																		rank:
																	)
																	(-
																		((param2
																				at:
																					(+
																						temp1
																						1
																					)
																			)
																			rank:
																		)
																		2
																	)
																)
															)
															(Print
																ticks: 400
																fore: 0
																mode: 0
																addBitmap:
																	917
																	4
																	0
																font: gUserFont
																addTextF:
																	{\n  You can only play the %s of %s\n  here now.}
																	temp13
																	temp12
																init:
															)
														)
														(
															(!=
																((param2
																		at:
																			(-
																				temp1
																				1
																			)
																	)
																	rank:
																)
																13
															)
															(Print
																ticks: 400
																fore: 0
																mode: 0
																addBitmap:
																	917
																	4
																	0
																font: gUserFont
																addTextF:
																	{\n  You can only play the %s of %s\n  or the %s of %s here now.}
																	temp11
																	temp10
																	temp13
																	temp12
																init:
															)
														)
														(else
															(Print
																ticks: 400
																fore: 0
																mode: 0
																addBitmap:
																	917
																	4
																	0
																font: gUserFont
																addTextF:
																	{\n  You can only play the %s of %s\n  here now.}
																	temp13
																	temp12
																init:
															)
														)
													)
													(return 1)
												)
											)
										)
									)
								)
							)
						)
						((not local8)
							(if (== temp1 0)
								(Print
									ticks: 400
									fore: 0
									mode: 0
									addBitmap: 917 4 0
									font: gUserFont
									addTextF:
										{\n  You can only play a 2 here now.}
									init:
								)
							else
								(switch ((param2 at: (- temp1 1)) suit:)
									(0
										(= temp10 local31)
									)
									(1
										(= temp10 local32)
									)
									(2
										(= temp10 local33)
									)
									(3
										(= temp10 local34)
									)
								)
								(switch (+ ((param2 at: (- temp1 1)) rank:) 1)
									(11
										(= temp11 {jack})
									)
									(12
										(= temp11 {queen})
									)
									(13
										(= temp11 {king})
									)
								)
								(cond
									((== ((param2 at: (- temp1 1)) rank:) 1)
										(Print
											ticks: 400
											fore: 0
											mode: 0
											addBitmap: 917 4 0
											font: gUserFont
											addTextF:
												{\n  You can't play a card here now.}
											init:
										)
									)
									((> ((param2 at: (- temp1 1)) rank:) 9)
										(if
											(!=
												((param2 at: (- temp1 1)) rank:)
												13
											)
											(Print
												ticks: 400
												fore: 0
												mode: 0
												addBitmap: 917 4 0
												font: gUserFont
												addTextF:
													{\n  You can only play the %s of %s\n   here now.}
													temp11
													temp10
												init:
											)
										else
											(Print
												ticks: 400
												fore: 0
												mode: 0
												addBitmap: 917 4 0
												font: gUserFont
												addTextF:
													{\n  You can't play a card here now.}
												init:
											)
										)
									)
									(else
										(Print
											ticks: 400
											fore: 0
											mode: 0
											addBitmap: 917 4 0
											font: gUserFont
											addTextF:
												{\n  You can only play the %d of %s\n   here now.}
												(+
													((param2 at: (- temp1 1))
														rank:
													)
													1
												)
												temp10
											init:
										)
									)
								)
							)
							(return 1)
						)
					)
				)
				(cond
					(local8
						(cond
							((and (!= local8 temp0) (== (temp0 rank:) 1))
								(cond
									((== global927 1)
										(cond
											(temp1
												(if
													(and
														(!=
															((param2
																	at:
																		(-
																			temp1
																			1
																		)
																)
																rank:
															)
															1
														)
														(==
															(local8 rank:)
															(+
																((param2
																		at:
																			(-
																				temp1
																				1
																			)
																	)
																	rank:
																)
																1
															)
														)
														(==
															(local8 suit:)
															((param2
																	at:
																		(-
																			temp1
																			1
																		)
																)
																suit:
															)
														)
													)
													(= temp2
														((local8 owner:)
															indexOf: local8
														)
													)
													(localproc_0
														param2
														temp0
														temp1
														temp2
													)
												else
													(local8 loop: 0)
													(temp0 loop: 0)
													(= local8 0)
												)
											)
											((== (local8 rank:) 2)
												(= temp2
													((local8 owner:)
														indexOf: local8
													)
												)
												(localproc_0
													param2
													temp0
													temp1
													temp2
												)
											)
											(else
												(local8 loop: 0)
												(temp0 loop: 0)
												(= local8 0)
											)
										)
									)
									((and temp1 (!= temp1 12))
										(if
											(or
												(and
													(==
														(local8 rank:)
														(-
															((param2
																	at:
																		(+
																			temp1
																			1
																		)
																)
																rank:
															)
															1
														)
													)
													(==
														(local8 suit:)
														((param2
																at: (+ temp1 1)
															)
															suit:
														)
													)
												)
												(and
													(!=
														((param2
																at: (- temp1 1)
															)
															rank:
														)
														1
													)
													(==
														(local8 rank:)
														(+
															((param2
																	at:
																		(-
																			temp1
																			1
																		)
																)
																rank:
															)
															1
														)
													)
													(==
														(local8 suit:)
														((param2
																at: (- temp1 1)
															)
															suit:
														)
													)
												)
											)
											(= temp2
												((local8 owner:)
													indexOf: local8
												)
											)
											(localproc_0
												param2
												temp0
												temp1
												temp2
											)
										else
											(local8 loop: 0)
											(temp0 loop: 0)
											(= local8 0)
										)
									)
									((not temp1)
										(if
											(or
												(and
													(==
														(local8 rank:)
														(-
															((param2
																	at:
																		(+
																			temp1
																			1
																		)
																)
																rank:
															)
															1
														)
													)
													(==
														(local8 suit:)
														((param2
																at: (+ temp1 1)
															)
															suit:
														)
													)
												)
												(== (local8 rank:) 2)
											)
											(= temp2
												((local8 owner:)
													indexOf: local8
												)
											)
											(localproc_0
												param2
												temp0
												temp1
												temp2
											)
										else
											(local8 loop: 0)
											(temp0 loop: 0)
											(= local8 0)
										)
									)
									(
										(and
											(!=
												((param2 at: (- temp1 1)) rank:)
												1
											)
											(==
												(local8 rank:)
												(+
													((param2 at: (- temp1 1))
														rank:
													)
													1
												)
											)
											(==
												(local8 suit:)
												((param2 at: (- temp1 1)) suit:)
											)
										)
										(= temp2
											((local8 owner:) indexOf: local8)
										)
										(localproc_0 param2 temp0 temp1 temp2)
									)
									(else
										(local8 loop: 0)
										(temp0 loop: 0)
										(= local8 0)
									)
								)
							)
							((== local8 temp0)
								(local8 loop: 0)
								(= local8 0)
							)
							(else
								(local8 loop: 0)
								(= local8 temp0)
							)
						)
					)
					((== (temp0 rank:) 1)
						(= local8 0)
					)
					(else
						(= local8 temp0)
						(local8 loop: 1)
					)
				)
			)
		)
	)
)

(instance hand1 of gHand
	(properties
		x 61
		y 44
		faceUp 1
		autoSorting 0
		centerX 61
		cardLimit 13
		buildOrder 10
		buildStep 1
		startRank 3
		canTrack 1
		canPlay 1
		cardsUp 13
	)
)

(instance hand2 of gHand
	(properties
		x 61
		y 129
		faceUp 1
		autoSorting 0
		centerX 61
		cardLimit 13
		buildOrder 10
		buildStep 1
		startRank 3
		canTrack 1
		canPlay 1
		cardsUp 13
	)
)

(instance hand3 of gHand
	(properties
		x 61
		y 214
		faceUp 1
		autoSorting 0
		centerX 61
		cardLimit 13
		buildOrder 10
		buildStep 1
		startRank 3
		canTrack 1
		canPlay 1
		cardsUp 13
	)
)

(instance hand4 of gHand
	(properties
		x 61
		y 297
		faceUp 1
		autoSorting 0
		centerX 61
		cardLimit 13
		buildOrder 10
		buildStep 1
		startRank 3
		canTrack 1
		canPlay 1
		cardsUp 13
	)
)

(class gCard of sCard
	(properties
		gap 0
	)

	(method (setNSRect &tmp temp0)
		(if (not (self owner:))
			(return)
		)
		(= temp0 ((self owner:) handDirection:))
		(cond
			((== ((self owner:) whatType:) 0)
				(self nsLeft: 0 nsRight: 54 nsTop: 0 nsBottom: 77)
			)
			((== ((self owner:) lastCrd:) self)
				(self nsLeft: 0 nsRight: 54 nsTop: 0 nsBottom: 77)
			)
			((== temp0 1)
				(self nsLeft: 0 nsRight: global396 nsTop: 0 nsBottom: 77)
			)
			((== temp0 2)
				(self nsLeft: 0 nsRight: 54 nsTop: 0 nsBottom: global397)
			)
		)
	)

	(method (track &tmp temp0)
		(self loop: 1)
		(gAniList release:)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp0 0)
		(if (not (event claimed:))
			(= temp1 (+ y nsTop))
			(= temp2 (+ x nsLeft))
			(if owner
				(if (== (owner whatType:) 0)
					(= temp5 self)
				else
					(= temp5 (== (owner indexOf: self) (- (owner size:) 1)))
				)
				(if (or (== global394 5) (== global394 6))
					(= temp5 1)
				)
				(switch (owner handDirection:)
					(1
						(if temp5
							(= temp3 (+ y (- nsBottom 1)))
							(= temp4 (+ x (- nsRight 1)))
						else
							(= temp3 (+ y (- nsBottom 1)))
							(= temp4 (+ x nsLeft (- global396 1)))
						)
					)
					(2
						(if temp5
							(= temp3 (+ y (- nsBottom 1)))
							(= temp4 (+ x (- nsRight 1)))
						else
							(= temp3 (+ y nsTop (- global397 1)))
							(= temp4 (+ x (- nsRight 1)))
						)
					)
				)
				(if
					(and
						(<= temp2 (event x:) temp4)
						(<= temp1 (event y:) temp3)
					)
					(cond
						((proc0_2 event)
							(event claimed: 1)
							(= temp0 1)
						)
						((& (event type:) evMOUSEBUTTON)
							(event claimed: 1)
							(= temp0 1)
						)
					)
				)
			)
		)
		(if temp0 self else 0)
	)
)

(instance tmpDeck of Set
	(properties)
)

(instance theHands of List
	(properties)
)

(instance dealList of List
	(properties)
)

(instance tmpCrdList of List
	(properties)
)

(instance temp1 of List
	(properties)
)

(instance temp2 of List
	(properties)
)

(instance temp3 of List
	(properties)
)

(instance temp4 of List
	(properties)
)

(instance tempList of List
	(properties)
)

(instance whenReset of List
	(properties)
)

(instance oldhand1List of List
	(properties)
)

(instance olderhand1List of List
	(properties)
)

(instance oldhand2List of List
	(properties)
)

(instance olderhand2List of List
	(properties)
)

(instance oldhand3List of List
	(properties)
)

(instance olderhand3List of List
	(properties)
)

(instance oldhand4List of List
	(properties)
)

(instance olderhand4List of List
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
		loop 13
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
		(= local39 1)
		(super init:)
		(proc0_10 990 5 global385 0 0 1 self {back})
		(proc0_10 990 0 0 0 0 2 self)
		(proc0_10 979 12 11 131 5 15 self)
		(proc0_10 979 12 11 131 20 15 self)
		(proc6022_6 0 92 5 1 {seconds} timeWindow)
		(if (and (== local37 59) (== local38 59))
			(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
			(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
		else
			(proc6022_6 local37 70 20 1 {bestminutes} timeWindow)
			(proc6022_6 local38 92 20 1 {bestseconds} timeWindow)
		)
	)
)

(instance tabView of View
	(properties
		view 723
	)

	(method (init)
		(self setPri: 256)
		(= local44 1)
		(super init: &rest)
	)
)

(instance tempTwos of List
	(properties)
)

