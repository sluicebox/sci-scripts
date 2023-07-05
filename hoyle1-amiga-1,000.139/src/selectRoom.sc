;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 101)
(include sci.sh)
(use Main)
(use Interface)
(use CursorCoords)
(use n902)
(use Game)
(use Actor)
(use System)

(public
	selectRoom 0
)

(local
	local0 = 1
)

(procedure (localproc_0 &tmp temp0 temp1 [temp2 20] [temp22 20] temp42)
	(SetCursor 999)
	(= temp2 (= temp22 0))
	(if (not (GameIsRestarting))
		(gCurRoom drawPic: 11)
		(proc0_5)
	)
	(if (== (= temp0 (FOpen {NAME.SET} 1)) -1)
		(if (GameIsRestarting)
			(StrCpy @global138 {You       })
		)
	else
		(FGets @global138 11 temp0)
		(FClose temp0)
	)
	(if (not (GameIsRestarting))
		(StrCpy @temp2 @global138)
		(for ((= temp42 (- (StrLen @temp2) 1))) (> temp42 0) ((-- temp42))
			(if (!= (StrAt @temp2 temp42) 32)
				(break)
			)
		)
		(StrAt @temp2 (+ temp42 1) 0)
		(StrCpy @temp22 @temp2)
		(Print {Please enter your name:} 41 @temp2 12 81 {OK})
		(if (or (== (StrLen @temp2) 0) (StrCmp @temp22 @temp2))
			(if (== (StrLen @temp2) 0)
				(StrCpy @temp2 {You})
			)
			(StrCpy @global138 @temp2)
			(for ((= temp42 (StrLen @temp2))) (< temp42 10) ((++ temp42))
				(StrAt @global138 temp42 32)
			)
			(StrAt @global138 10 0)
			(if (!= (= temp1 (FOpen {NAME.SET} 2)) -1)
				(FPuts temp1 @global138)
				(FClose temp1)
			)
		)
	)
	(SetCursor 997)
)

(instance selectRoom of Rm
	(properties
		picture 11
	)

	(method (init &tmp temp0)
		(if (GameIsRestarting)
			(proc902_0)
			(DisposeScript 902)
			(gIntroSong number: 20 loop: -1 play:)
		)
		(localproc_0)
		((= global517 inList) add:)
		(super init:)
		(Load rsVIEW 180)
		(proc0_7 128 1 2 3 4 5 6 8 9 10 11 12 13 14 15 16 17 18 19)
		(SetMenu 517 112 1)
		(cardBack1 init:)
		(cardBack2 init:)
		(cardBack3 init:)
		(cardBack4 init:)
		(cardBack5 init:)
		(cardBack6 init:)
		(cardBack7 init:)
		(cardBack8 init:)
		(cardBack9 init:)
		(selectMessage init:)
		(crazy8sView init:)
		(oldMaidView init:)
		(heartsView init:)
		(ginRummyView init:)
		(cribbageView init:)
		(klondikeView init:)
		(= temp0
			(switch global507
				(1 cardBack3)
				(2 cardBack2)
				(3 cardBack6)
				(4 cardBack7)
				(5 cardBack5)
				(6 cardBack4)
				(7 cardBack8)
				(8 cardBack9)
				(else cardBack1)
			)
		)
		(cardBoarder init: temp0)
		(global517
			add:
				crazy8sView
				oldMaidView
				heartsView
				ginRummyView
				cribbageView
				klondikeView
		)
		(if (not (HaveMouse))
			(SetCursor 999 1 232 (crazy8sView cursorY:))
		)
	)

	(method (doit)
		(if local0
			(-- local0)
			(if (not (HaveMouse))
				(SetCursor 999 1 232 (crazy8sView cursorY:))
			)
		)
	)

	(method (handleEvent event)
		(global517 eachElementDo: #handleEvent event)
		(if global503
			(selectMessage hide:)
			(if (!= global503 1)
				(crazy8sView hide:)
			)
			(if (!= global503 2)
				(oldMaidView hide:)
			)
			(if (!= global503 3)
				(heartsView hide:)
			)
			(if (!= global503 4)
				(ginRummyView hide:)
			)
			(if (!= global503 5)
				(cribbageView hide:)
			)
			(if (!= global503 7)
				(klondikeView hide:)
			)
			(proc0_5)
			(Display 101 0 dsCOORD 6 13 dsCOLOR 15 dsWIDTH 308 dsALIGN alCENTER dsFONT 0) ; "Just a moment..."
			(cardBacksList empty: dispose:)
			(switch global503
				(1
					(gIntroSong number: 4 play:)
				)
				(2
					(gIntroSong number: 17 play:)
				)
				(3
					(gIntroSong number: 9 play:)
				)
				(4
					(gIntroSong number: 7 play:)
				)
				(5
					(gIntroSong number: 5 play:)
				)
				(7
					(gIntroSong number: 13 loop: 1 play:)
					(SetMenu 517 112 0)
				)
			)
			(if (== global503 7)
				(gCurRoom newRoom: 7)
			else
				(gCurRoom newRoom: 102) ; chooserm
			)
		)
		(event claimed: 1)
	)

	(method (dispose)
		(global517 empty: dispose:)
		(DisposeScript 891)
		(super dispose:)
	)
)

(instance cardBacksList of WL
	(properties)
)

(class CardBack of Obj
	(properties
		view 0
		loop 0
		cel 0
		backNum 0
		cursorX 0
		cursorY 0
		x 0
		y 0
	)

	(method (init)
		(proc0_2 view loop cel x y)
		(cardBacksList add: self)
		(global517 add: self)
	)

	(method (handleEvent event)
		(if
			(and
				(not (event claimed:))
				(or
					(and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
					(== (event type:) evMOUSEBUTTON)
				)
				(<= x (event x:) (+ x 35))
				(<= y (- (event y:) 10) (+ y 43))
			)
			(event claimed: 1)
			(= global507 backNum)
			(cardBoarder init: self)
			(proc0_5)
		)
		(event claimed:)
	)
)

(instance cardBack1 of CardBack
	(properties
		view 180
		loop 7
		cursorX 45
		cursorY 75
		x 25
		y 45
	)
)

(instance cardBack2 of CardBack
	(properties
		view 180
		loop 7
		cel 1
		backNum 2
		cursorX 125
		cursorY 75
		x 65
		y 45
	)
)

(instance cardBack3 of CardBack
	(properties
		view 180
		loop 7
		cel 2
		backNum 1
		cursorX 85
		cursorY 75
		x 105
		y 45
	)
)

(instance cardBack4 of CardBack
	(properties
		view 180
		loop 7
		cel 3
		backNum 6
		cursorX 45
		cursorY 122
		x 25
		y 92
	)
)

(instance cardBack5 of CardBack
	(properties
		view 180
		loop 7
		cel 4
		backNum 5
		cursorX 85
		cursorY 122
		x 65
		y 92
	)
)

(instance cardBack6 of CardBack
	(properties
		view 180
		loop 7
		cel 5
		backNum 3
		cursorX 125
		cursorY 122
		x 105
		y 92
	)
)

(instance cardBack7 of CardBack
	(properties
		view 180
		loop 7
		cel 6
		backNum 4
		cursorX 45
		cursorY 169
		x 25
		y 139
	)
)

(instance cardBack8 of CardBack
	(properties
		view 180
		loop 7
		cel 7
		backNum 7
		cursorX 85
		cursorY 169
		x 65
		y 139
	)
)

(instance cardBack9 of CardBack
	(properties
		view 180
		loop 7
		cel 8
		backNum 8
		cursorX 125
		cursorY 169
		x 105
		y 139
	)
)

(instance cardBoarder of View
	(properties
		view 299
	)

	(method (init param1)
		(self posn: (param1 x:) (param1 y:))
		(super init:)
	)
)

(instance selectMessage of View
	(properties
		y 25
		x 160
		view 180
		priority 8
	)
)

(instance crazy8sView of CView
	(properties
		y 55
		x 235
		view 180
		loop 1
		priority 8
		cursorY 52
	)

	(method (handleEvent event)
		(if
			(and
				(not (event claimed:))
				(or
					(and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
					(== (event type:) evMOUSEBUTTON)
				)
				(<= nsLeft (event x:) nsRight)
				(<= nsTop (- (event y:) 10) nsBottom)
			)
			(event claimed: 1)
			(= global503 1)
		)
		(event claimed:)
	)
)

(instance oldMaidView of CView
	(properties
		y 78
		x 235
		view 180
		loop 2
		priority 8
		cursorY 75
	)

	(method (handleEvent event)
		(if
			(and
				(not (event claimed:))
				(or
					(and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
					(== (event type:) evMOUSEBUTTON)
				)
				(<= nsLeft (event x:) nsRight)
				(<= nsTop (- (event y:) 10) nsBottom)
			)
			(event claimed: 1)
			(= global503 2)
		)
		(event claimed:)
	)
)

(instance heartsView of CView
	(properties
		y 101
		x 235
		view 180
		loop 3
		priority 8
		cursorY 98
	)

	(method (handleEvent event)
		(if
			(and
				(not (event claimed:))
				(or
					(and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
					(== (event type:) evMOUSEBUTTON)
				)
				(<= nsLeft (event x:) nsRight)
				(<= nsTop (- (event y:) 10) nsBottom)
			)
			(event claimed: 1)
			(= global503 3)
		)
		(event claimed:)
	)
)

(instance ginRummyView of CView
	(properties
		y 124
		x 235
		view 180
		loop 4
		priority 8
		cursorY 121
	)

	(method (handleEvent event)
		(if
			(and
				(not (event claimed:))
				(or
					(and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
					(== (event type:) evMOUSEBUTTON)
				)
				(<= nsLeft (event x:) nsRight)
				(<= nsTop (- (event y:) 10) nsBottom)
			)
			(event claimed: 1)
			(= global503 4)
		)
		(event claimed:)
	)
)

(instance cribbageView of CView
	(properties
		y 147
		x 235
		view 180
		loop 5
		priority 8
		cursorY 144
	)

	(method (handleEvent event)
		(if
			(and
				(not (event claimed:))
				(or
					(and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
					(== (event type:) evMOUSEBUTTON)
				)
				(<= nsLeft (event x:) nsRight)
				(<= nsTop (- (event y:) 10) nsBottom)
			)
			(event claimed: 1)
			(= global503 5)
		)
		(event claimed:)
	)
)

(instance klondikeView of CView
	(properties
		y 170
		x 235
		view 180
		loop 6
		priority 8
		cursorY 167
	)

	(method (handleEvent event)
		(if
			(and
				(not (event claimed:))
				(or
					(and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
					(== (event type:) evMOUSEBUTTON)
				)
				(<= nsLeft (event x:) nsRight)
				(<= nsTop (- (event y:) 10) nsBottom)
			)
			(event claimed: 1)
			(= global500 (= global501 (= global502 0)))
			(= global503 7)
		)
		(event claimed:)
	)
)

(instance inList of InputList
	(properties)
)

