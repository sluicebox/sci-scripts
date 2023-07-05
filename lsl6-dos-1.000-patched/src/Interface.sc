;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 255)
(include sci.sh)
(use Main)
(use Print)
(use System)

(public
	StillDown 0
	GetNumber 1
	MousedOn 2
)

(procedure (StillDown &tmp event ret)
	(= event (Event new:))
	(= ret (!= (event type:) evMOUSERELEASE))
	(event dispose:)
	(return ret)
)

(procedure (GetNumber string default &tmp [theLine 40])
	(= theLine 0)
	(if (> argc 1)
		(Format @theLine {%d} default)
	)
	(return
		(if (GetInput @theLine 5 string)
			(ReadNumber @theLine)
		else
			-1
		)
	)
)

(procedure (MousedOn obj event)
	(return
		(and
			(< (obj nsLeft:) (event x:) (obj nsRight:))
			(< (obj nsTop:) (event y:) (obj nsBottom:))
		)
	)
)

(class DItem of Obj
	(properties
		type 0
		state 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		key 0
		said 0
		value 0
	)

	(method (enable bool)
		(if bool
			(|= state $0001)
		else
			(&= state $fffe)
		)
	)

	(method (select bool)
		(if bool
			(|= state $0008)
		else
			(&= state $fff7)
		)
		(self draw:)
	)

	(method (handleEvent event &tmp ret evtType evt)
		(if (event claimed:)
			(return 0)
		)
		(= ret 0)
		(if
			(and
				(& state $0001)
				(or
					(and
						(== (= evtType (event type:)) evKEYBOARD)
						(== (event message:) key)
					)
					(and (== evtType evMOUSEBUTTON) (self check: event))
				)
			)
			(event claimed: 1)
			(= ret (self track: event))
		)
		(return ret)
	)

	(method (check event)
		(return
			(and
				(>= (event x:) nsLeft)
				(>= (event y:) nsTop)
				(< (event x:) nsRight)
				(< (event y:) nsBottom)
			)
		)
	)

	(method (track event &tmp in lastIn)
		(if (== 1 (event type:))
			(= lastIn 0)
			(repeat
				(= event (Event new: -32768))
				(event localize:)
				(if (!= (= in (self check: event)) lastIn)
					(HiliteControl self)
					(= lastIn in)
				)
				(event dispose:)
				(breakif (not (StillDown)))
			)
			(if in
				(HiliteControl self)
			)
			(return in)
		else
			(return self)
		)
	)

	(method (isType theType)
		(return (== type theType))
	)

	(method (checkState bit)
		(return (& state bit))
	)

	(method (doit)
		(return value)
	)

	(method (setSize))

	(method (move h v)
		(+= nsRight h)
		(+= nsLeft h)
		(+= nsTop v)
		(+= nsBottom v)
	)

	(method (moveTo h v)
		(self move: (- h nsLeft) (- v nsTop))
	)

	(method (draw)
		(DrawControl self)
	)

	(method (cycle))
)

(class DText of DItem
	(properties
		type 2
		text 0
		font 1
		mode 0
		rects 0
	)

	(method (dispose isNotPtr)
		(if (and text (or (not argc) (not isNotPtr)))
			(Memory memFREE (self text:))
		)
		(if rects
			(Memory memFREE (self rects:))
		)
		(super dispose:)
	)

	(method (new &tmp newText)
		((super new:) font: gUserFont yourself:)
	)

	(method (setSize w &tmp [r 4])
		(TextSize @[r 0] text font (if argc w else 0))
		(= nsBottom (+ nsTop [r 2]))
		(= nsRight (+ nsLeft [r 3]))
	)

	(method (handleEvent event &tmp rect t l b r)
		(if
			(and
				global17
				rects
				(or
					(OneOf (event type:) evMOUSEBUTTON evJOYDOWN)
					(and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
				)
			)
			(= rect -1)
			(event globalize: claimed: 1)
			(while (!= (WordAt rects (+ rect 1)) 30583)
				(= l (WordAt rects (++ rect)))
				(= t (WordAt rects (++ rect)))
				(= r (WordAt rects (++ rect)))
				(= b (WordAt rects (++ rect)))
				(if
					(and
						(<= l (event x:) r)
						(<= t (event y:) b)
					)
					(global17 doit: (/ rect 4))
					(event type: evNULL claimed: 0)
					(break)
				)
			)
		)
		(super handleEvent: event)
	)

	(method (draw)
		(= rects (DrawControl self))
	)
)

(class Dialog of List
	(properties
		text 0
		font 0
		window 0
		theItem 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		time 0
		caller 0
		seconds 0
		lastSeconds 0
		eatTheMice 0
		lastTicks 0
	)

	(method (open wtype pri)
		(if (and (PicNotValid) gCast)
			(Animate (gCast elements:) 0)
		)
		(= window (window new:))
		(window
			top: nsTop
			left: nsLeft
			bottom: nsBottom
			right: nsRight
			title: text
			type: wtype
			priority: pri
			open:
		)
		(= seconds time)
		(self draw:)
	)

	(method (draw)
		(self eachElementDo: #draw)
	)

	(method (doit def &tmp event ret done)
		(= gGameTime (+ gTickOffset (GetTime)))
		(= done 0)
		(self eachElementDo: #init)
		(if theItem
			(theItem select: 0)
		)
		(= theItem
			(if (and argc def)
				def
			else
				(self firstTrue: #checkState 1)
			)
		)
		(if theItem
			(theItem select: 1)
		)
		(if (not theItem)
			(= eatTheMice gEatMice)
			(= lastTicks (GetTime))
		else
			(= eatTheMice 0)
		)
		(= ret 0)
		(while (not ret)
			(= gGameTime (+ gTickOffset (GetTime)))
			(self eachElementDo: #cycle)
			(= event ((Event new:) localize:))
			(if eatTheMice
				(-- eatTheMice)
				(if (== (event type:) 1)
					(event type: 0)
				)
				(while (== lastTicks (GetTime))
				)
				(= lastTicks (GetTime))
			)
			(self eachElementDo: #perform checkHiliteCode self event)
			(= ret (self handleEvent: event))
			(event dispose:)
			(if (self check:)
				(break)
			)
			(if (== ret -2)
				(= ret 0)
				(EditControl theItem 0)
				(break)
			)
			(Wait 1)
		)
		(return ret)
	)

	(method (check &tmp thisSeconds)
		(if seconds
			(= thisSeconds (GetTime 1)) ; SysTime12
			(if (!= lastSeconds thisSeconds)
				(= lastSeconds thisSeconds)
				(return (not (-- seconds)))
			)
		)
	)

	(method (dispose &tmp theCaller)
		(self eachElementDo: #dispose release:)
		(if (== self gModelessDialog)
			(SetPort gModelessPort)
			(= gModelessDialog 0)
			(= gModelessPort 0)
		)
		(if window
			(window dispose:)
			(= window 0)
		)
		(= theItem 0)
		(= theCaller caller)
		(super dispose:)
		(if theCaller
			(theCaller cue:)
		)
	)

	(method (advance &tmp obj node)
		(if theItem
			(theItem select: 0)
			(= node (self contains: theItem))
			(repeat
				(if (not (= node (self next: node)))
					(= node (self first:))
				)
				(= theItem (NodeValue node))
				(if (& (theItem state:) $0001)
					(break)
				)
			)
			(theItem select: 1)
			(gGame
				setCursor:
					gTheCursor
					1
					(+
						(theItem nsLeft:)
						(/ (- (theItem nsRight:) (theItem nsLeft:)) 2)
					)
					(- (theItem nsBottom:) 3)
			)
		)
	)

	(method (retreat &tmp obj node)
		(if theItem
			(theItem select: 0)
			(= node (self contains: theItem))
			(repeat
				(if (not (= node (self prev: node)))
					(= node (self last:))
				)
				(= theItem (NodeValue node))
				(if (& (theItem state:) $0001)
					(break)
				)
			)
			(theItem select: 1)
			(gGame
				setCursor:
					gTheCursor
					1
					(+
						(theItem nsLeft:)
						(/ (- (theItem nsRight:) (theItem nsLeft:)) 2)
					)
					(- (theItem nsBottom:) 3)
			)
		)
	)

	(method (handleEvent event &tmp ret eType eMsg)
		(if (& (event type:) $0040) ; direction
			(switch (event message:)
				(JOY_DOWN
					(event type: evKEYBOARD message: KEY_DOWN)
				)
				(JOY_UP
					(event type: evKEYBOARD message: KEY_UP)
				)
				(JOY_LEFT
					(event type: evKEYBOARD message: KEY_LEFT)
				)
				(JOY_RIGHT
					(event type: evKEYBOARD message: KEY_RIGHT)
				)
			)
		)
		(= eType (event type:))
		(= eMsg (event message:))
		(if (= ret (self firstTrue: #handleEvent event))
			(EditControl theItem 0)
			(if (not (ret checkState: 2))
				(if theItem
					(theItem select: 0)
				)
				((= theItem ret) select: 1)
				(ret doit:)
				(= ret 0)
			else
				(return ret)
			)
		else
			(= eType (event type:))
			(= eMsg (event message:))
			(= ret 0)
			(cond
				(
					(and
						(or (== eType evJOYDOWN) (and (== eType evKEYBOARD) (== eMsg KEY_RETURN)))
						theItem
						(theItem checkState: 1)
					)
					(= ret theItem)
					(EditControl theItem 0)
					(event claimed: 1)
				)
				((and (== eType evKEYBOARD) (== eMsg KEY_ESCAPE))
					(event claimed: 1)
					(= ret -1)
				)
				(
					(and
						(not (self firstTrue: #checkState 1))
						(or
							(and (== eType evKEYBOARD) (== eMsg KEY_RETURN))
							(OneOf eType evMOUSEBUTTON evJOYDOWN)
						)
					)
					(event claimed: 1)
					(= ret -2)
				)
				(
					(and
						(IsObject theItem)
						(theItem isType: 3)
						(== eType evKEYBOARD)
						(== eMsg KEY_RIGHT)
					)
					(if (>= (theItem cursor:) (StrLen (theItem text:)))
						(self advance:)
					else
						(EditControl theItem event)
					)
				)
				(
					(and
						(IsObject theItem)
						(theItem isType: 3)
						(== eType evKEYBOARD)
						(== eMsg KEY_LEFT)
					)
					(if (<= (theItem cursor:) 0)
						(self retreat:)
					else
						(EditControl theItem event)
					)
				)
				((and (== eType evKEYBOARD) (OneOf eMsg KEY_TAB KEY_RIGHT KEY_DOWN))
					(event claimed: 1)
					(self advance:)
				)
				((and (== eType evKEYBOARD) (OneOf eMsg KEY_SHIFTTAB KEY_LEFT KEY_UP))
					(event claimed: 1)
					(self retreat:)
				)
				(else
					(EditControl theItem event)
				)
			)
		)
		(return ret)
	)

	(method (move h v)
		(+= nsRight h)
		(+= nsLeft h)
		(+= nsTop v)
		(+= nsBottom v)
	)

	(method (moveTo h v)
		(self move: (- h nsLeft) (- v nsTop))
	)

	(method (center)
		(self
			moveTo:
				(+
					(window brLeft:)
					(/
						(-
							(- (window brRight:) (window brLeft:))
							(- nsRight nsLeft)
						)
						2
					)
				)
				(+
					(window brTop:)
					(/
						(-
							(- (window brBottom:) (window brTop:))
							(- nsBottom nsTop)
						)
						2
					)
				)
		)
	)

	(method (setSize &tmp node obj [r 4])
		(if text
			(TextSize @[r 0] text font -1 0)
			(= nsTop [r 0])
			(= nsLeft [r 1])
			(= nsBottom [r 2])
			(= nsRight [r 3])
		else
			(= nsRight (= nsBottom (= nsLeft (= nsTop 0))))
		)
		(for ((= node (self first:))) node ((= node (self next: node)))
			(= obj (NodeValue node))
			(if (< (obj nsLeft:) nsLeft)
				(= nsLeft (obj nsLeft:))
			)
			(if (< (obj nsTop:) nsTop)
				(= nsTop (obj nsTop:))
			)
			(if (> (obj nsRight:) nsRight)
				(= nsRight (obj nsRight:))
			)
			(if (> (obj nsBottom:) nsBottom)
				(= nsBottom (obj nsBottom:))
			)
		)
		(+= nsRight 4)
		(+= nsBottom 4)
		(self moveTo: 0 0)
	)
)

(instance checkHiliteCode of Code
	(properties)

	(method (doit who dlg event)
		(if
			(and
				(& (who state:) $0001)
				(who check: event)
				(not (& (who state:) $0008))
			)
			((dlg theItem:) select: 0)
			(dlg theItem: who)
			(who select: 1)
		)
	)
)

