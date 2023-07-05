;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 255)
(include sci.sh)
(use Main)
(use System)

(public
	Print 0
	ShowView 1
	GetInput 2
	GetNumber 3
	Printf 4
	MousedOn 5
)

(procedure (StillDown &tmp event ret)
	(= event (Event new:))
	(= ret (!= (event type:) evMOUSERELEASE))
	(event dispose:)
	(return ret)
)

(procedure (MousedOn obj event)
	(return
		(and
			(< (obj nsLeft:) (event x:) (obj nsRight:))
			(< (obj nsTop:) (event y:) (obj nsBottom:))
		)
	)
)

(procedure (GetInput str maxLen prompt &tmp [temp0 4])
	(if (Print (if (>= argc 3) prompt else {}) #edit str maxLen &rest)
		(StrLen str)
	)
)

(procedure (ShowView txt v l c)
	(Print txt #icon v l c &rest)
)

(procedure (Print args &tmp theDialog textI iconI editI ret i atX atY fixWidth keepIt default [curPort 6] buttons buttonWide buttonsUsed butAtX buffer jStr k jKanjiROMTextI mainI subI mainL subL widthGiven iconGiven kShift tempMod dontDispose)
	(= subL 0)
	(= widthGiven 0)
	(= i (= atX -1))
	(= subI (gGame printLang:))
	(= mainL (gGame subtitleLang:))
	(= dontDispose (OneOf 81 subI mainL))
	(= tempMod
		(= fixWidth
			(= atY
				(= buttons
					(= textI
						(= iconI
							(= k
								(= iconGiven (= buttonWide (= jKanjiROMTextI (= mainI 0))))
							)
						)
					)
				)
			)
		)
	)
	((= theDialog (Dialog new:)) window: gSystemWindow name: {PrintD})
	(cond
		((u< [args 0] 1000)
			(= butAtX (GetFarText [args 0] [args 1] 0))
			(= ret 2)
		)
		([args 0]
			(= butAtX (Memory memALLOC_CRIT (+ (StrLen [args 0]) 1)))
			(StrCpy butAtX [args 0])
			(= ret 1)
		)
		(else
			(= butAtX (Memory memALLOC_CRIT 2))
			(StrCpy butAtX { })
			(= ret 0)
		)
	)
	(if dontDispose
		(for ((= jStr 0)) (StrAt butAtX jStr) ((++ jStr))
			(if
				(and
					(== (StrAt butAtX jStr) 14848)
					(== (StrAt butAtX (+ 1 jStr)) 74)
				)
				(StrSplit butAtX butAtX {#J})
				(StrAt butAtX jStr 0)
				((= jKanjiROMTextI (DText new:))
					disposeText: 1
					text: butAtX
					font: 900
					name: {jDText}
				)
				(if mainL
					((= mainI (DText new:))
						disposeText: 0
						text: (+ butAtX jStr 2)
						font: gUserFont
						setSize:
					)
				)
				(break)
			)
		)
	)
	(if (not jKanjiROMTextI)
		((= jKanjiROMTextI (DText new:))
			disposeText: 1
			text: butAtX
			font: gUserFont
			setSize:
		)
	)
	(jKanjiROMTextI moveTo: 4 4 setSize:)
	(theDialog add: jKanjiROMTextI setSize:)
	(if mainI
		(mainI setSize: moveTo: (jKanjiROMTextI nsLeft:) (+ 4 (jKanjiROMTextI nsBottom:)))
		(theDialog add: mainI setSize:)
	)
	(for ((= ret ret)) (< ret argc) ((++ ret))
		(switch [args ret]
			(30
				(++ ret)
				(if jKanjiROMTextI
					(jKanjiROMTextI mode: [args ret])
				)
			)
			(33
				(++ ret)
				(if jKanjiROMTextI
					(jKanjiROMTextI font: [args ret] setSize: atY)
				)
			)
			(70
				(= subL 1)
				(= atY [args (++ ret)])
				(jKanjiROMTextI setSize: atY)
				(if mainI
					(mainI
						setSize: atY
						moveTo: (jKanjiROMTextI nsLeft:) (+ 4 (jKanjiROMTextI nsBottom:))
					)
				)
			)
			(25
				(++ ret)
				(theDialog time: [args ret])
			)
			(80
				(= butAtX (Memory memALLOC_CRIT (+ (StrLen [args (++ ret)]) 1)))
				(StrCpy butAtX [args ret])
				(theDialog text: butAtX disposeText: 1)
			)
			(67
				(= i [args (++ ret)])
				(= atX [args (++ ret)])
			)
			(83
				(Animate (gCast elements:) 0)
			)
			(41
				(= butAtX (Memory memALLOC_CRIT (+ (StrLen [args (++ ret)]) 1)))
				(StrCpy butAtX [args ret])
				((= iconI (DEdit new:))
					text: butAtX
					disposeText: 1
					max: [args (++ ret)]
					setSize:
				)
			)
			(81
				(= butAtX (Memory memALLOC_CRIT (+ (StrLen [args (++ ret)]) 1)))
				(StrCpy butAtX [args ret])
				((= [curPort buttonWide] (DButton new:))
					text: butAtX
					disposeText: 1
					value: [args (++ ret)]
					setSize:
				)
				(+= buttons (+ ([curPort buttonWide] nsRight:) 4))
				(++ buttonWide)
			)
			(82
				(= widthGiven 1)
				(if (IsObject [args (+ ret 1)])
					(= textI ([args (+ ret 1)] new:))
					(textI setSize:)
					(+= ret 1)
				else
					(= textI (DIcon new:))
					(textI
						view: [args (+ ret 1)]
						loop: [args (+ ret 2)]
						cel: [args (+ ret 3)]
						setSize:
					)
					(+= ret 3)
				)
			)
			(108
				(if (and (< (+ ret 1) argc) (IsObject [args (+ ret 1)]))
					(theDialog caller: [args (+ ret 1)])
					(++ ret)
				)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= fixWidth theDialog)
			)
			(35
				(++ ret)
				(theDialog window: [args ret])
			)
			(121
				(= tempMod 1)
			)
		)
	)
	(if tempMod
		(= fixWidth 0)
	)
	(if textI
		(textI moveTo: 4 4)
		(if (or (== jKanjiROMTextI k) (== mainI k))
			(= iconGiven 8)
		)
		(if (& (textI state:) $0010)
			(jKanjiROMTextI
				moveTo: (+ 4 iconGiven) (+ (textI nsBottom:) (jKanjiROMTextI nsTop:))
				setSize:
			)
		else
			(jKanjiROMTextI
				moveTo: (+ 4 (textI nsRight:) iconGiven) (jKanjiROMTextI nsTop:)
				setSize:
			)
		)
		(if mainI
			(mainI moveTo: (jKanjiROMTextI nsLeft:) (+ 4 (jKanjiROMTextI nsBottom:)))
		)
		(theDialog add: textI)
	)
	(theDialog setSize:)
	(if iconI
		(iconI
			moveTo:
				((or mainI jKanjiROMTextI) nsLeft:)
				(+ 4 ((or mainI jKanjiROMTextI) nsBottom:))
		)
		(theDialog add: iconI setSize:)
	)
	(= buttonsUsed
		(if (> buttons (theDialog nsRight:))
			4
		else
			(- (theDialog nsRight:) buttons)
		)
	)
	(for ((= ret 0)) (< ret buttonWide) ((++ ret))
		([curPort ret] moveTo: buttonsUsed (theDialog nsBottom:))
		(theDialog add: [curPort ret])
		(= buttonsUsed (+ 4 ([curPort ret] nsRight:)))
	)
	(theDialog setSize: center:)
	(if
		(or
			(and textI (& (textI state:) $0010))
			(and textI (not (StrLen butAtX)))
		)
		(textI
			moveTo:
				(/
					(-
						(- (theDialog nsRight:) (theDialog nsLeft:))
						(- (textI nsRight:) (textI nsLeft:))
					)
					2
				)
				4
		)
	)
	(theDialog
		moveTo:
			(if (== -1 i)
				(theDialog nsLeft:)
			else
				i
			)
			(if (== -1 atX)
				(theDialog nsTop:)
			else
				atX
			)
	)
	(= default (GetPort))
	(theDialog open: (if (theDialog text:) 4 else 0) (if fixWidth 15 else -1))
	(if fixWidth
		(= gModelessPort (GetPort))
		(SetPort default)
		(return (= gModelessDialog fixWidth))
	else
		(gSounds pause: 1)
	)
	(if
		(and
			(= keepIt (theDialog firstTrue: #checkState 1))
			(not (theDialog firstTrue: #checkState 2))
		)
		(keepIt state: (| (keepIt state:) $0002))
	)
	(if (== (= editI (theDialog doit: keepIt)) -1)
		(= editI 0)
	)
	(for ((= ret 0)) (< ret buttonWide) ((++ ret))
		(if (== editI [curPort ret])
			(= editI (editI value:))
			(break)
		)
	)
	(if (not (theDialog theItem:))
		(= editI 1)
	)
	(theDialog dispose:)
	(gSounds pause: 0)
	(return editI)
)

(procedure (GetNumber string default &tmp [theLine 40])
	(= theLine 0)
	(if (> argc 1)
		(Format @theLine 255 0 default) ; "%d"
	)
	(return
		(if (GetInput @theLine 5 string)
			(ReadNumber @theLine)
		else
			-1
		)
	)
)

(procedure (Printf &tmp [str 500])
	(Format @str &rest)
	(Print @str)
)

(class MenuBar of Obj
	(properties
		state 0
	)

	(method (draw)
		(= state 1)
		(DrawMenuBar 1)
	)

	(method (hide)
		(DrawMenuBar 0)
	)

	(method (add)
		(AddMenu &rest)
	)

	(method (handleEvent event &tmp retVal oldRepeat)
		(= retVal 0)
		(if state
			(= oldRepeat (Joystick 12 30))
			(= retVal (MenuSelect event &rest))
			(Joystick 12 oldRepeat)
		)
		(return retVal)
	)
)

(class Item of Obj
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

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4)
		(if (event claimed:)
			(return 0)
		)
		(= temp0 0)
		(if
			(and
				(& state $0001)
				(or
					(and (== (= temp1 (event type:)) evSAID) (Said said))
					(if (== temp1 evKEYBOARD)
						(= temp3 (event message:))
						(if (<= 65 key 90)
							(= temp4 (+ key 32))
							(or (== temp3 key) (== temp3 temp4))
						else
							(== temp3 key)
						)
					)
					(and (== temp1 evMOUSEBUTTON) (self check: event))
					(and (& state $0008) (== temp1 evKEYBOARD) (== (event message:) KEY_RETURN))
				)
			)
			(event claimed: 1)
			(= temp0 (self track: event))
		)
		(return temp0)
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
			(&= state $ffbf)
			(repeat
				(= event (Event new: -32768))
				(event localize:)
				(if (!= (= in (self check: event)) lastIn)
					(^= state $0040)
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
			(^= state $0040)
			(HiliteControl self)
			(Wait 5)
			(^= state $0040)
			(HiliteControl self)
			(return self)
		)
	)

	(method (isType param1)
		(return (== type param1))
	)

	(method (checkState param1)
		(return (& state param1))
	)

	(method (doit)
		(return value)
	)

	(method (setSize))

	(method (move param1 param2)
		(+= nsRight param1)
		(+= nsLeft param1)
		(+= nsTop param2)
		(+= nsBottom param2)
	)

	(method (moveTo param1 param2)
		(self move: (- param1 nsLeft) (- param2 nsTop))
	)

	(method (draw)
		(DrawControl self)
	)

	(method (cycle))
)

(class DTextField of Item
	(properties
		text 0
		disposeText 0
	)

	(method (dispose)
		(if (and text disposeText)
			(Memory memFREE text)
		)
		(super dispose:)
	)
)

(class DText of DTextField
	(properties
		type 2
		font 1
		mode 0
	)

	(method (new &tmp newText)
		((super new:) font: gUserFont yourself:)
	)

	(method (setSize w &tmp [r 4])
		(TextSize
			@[r 0]
			text
			font
			(if argc w else 0)
			{\r\n----------\r\n}
		)
		(= nsBottom (+ nsTop [r 2]))
		(= nsRight (+ nsLeft [r 3]))
	)
)

(class DIcon of Item
	(properties
		type 4
		view 0
		loop 0
		cel 0
	)

	(method (setSize &tmp [r 4])
		(= nsRight (+ nsLeft (CelWide view loop cel)))
		(= nsBottom (+ nsTop (CelHigh view loop cel)))
	)
)

(class DButton of DTextField
	(properties
		type 1
		state 3
		font 0
	)

	(method (setSize &tmp [r 4])
		(TextSize @[r 0] text font 0 0)
		(+= [r 2] 4)
		(+= [r 3] 4)
		(= nsBottom (+ nsTop [r 2]))
		(= [r 3] (* (/ (+ [r 3] 17) 18) 18))
		(= nsRight (+ [r 3] nsLeft))
	)
)

(class DEdit of DTextField
	(properties
		type 3
		state 1
		font 0
		max 0
		cursor 0
	)

	(method (track evt)
		(EditControl self evt)
		(return self)
	)

	(method (setSize &tmp [r 4])
		(= font gInputFont)
		(TextSize @[r 0] {M} font 0 0)
		(= nsBottom (+ nsTop [r 2]))
		(= nsRight (+ nsLeft (/ (* [r 3] max 3) 4)))
		(= cursor (StrLen text))
	)
)

(class DSelector of DTextField
	(properties
		type 6
		font 0
		x 20
		y 6
		cursor 0
		topString 0
		mark 0
	)

	(method (indexOf what &tmp ptr i)
		(= ptr text)
		(for ((= i 0)) (< i 300) ((++ i))
			(if (== 0 (StrLen ptr))
				(return -1)
			)
			(if (not (StrCmp what ptr))
				(return i)
			)
			(+= ptr x)
		)
	)

	(method (at what)
		(return (+ text (* x what)))
	)

	(method (setSize &tmp [r 4])
		(TextSize @[r 0] {M} font 0 0)
		(= nsBottom (+ nsTop 20 (* [r 2] y)))
		(= nsRight (+ nsLeft (/ (* [r 3] x 3) 4)))
		(= topString (= cursor text))
		(= mark 0)
	)

	(method (retreat lines &tmp redraw)
		(= redraw 0)
		(while lines
			(if (!= cursor text)
				(= redraw 1)
				(-= cursor x)
				(if mark
					(-- mark)
				else
					(-= topString x)
				)
			else
				(break)
			)
			(-- lines)
		)
		(return
			(if redraw
				(self draw:)
				1
			)
		)
	)

	(method (advance lines &tmp redraw)
		(if (not (StrAt cursor 0))
			(return)
		)
		(= redraw 0)
		(while lines
			(if (StrAt cursor x)
				(= redraw 1)
				(+= cursor x)
				(if (< (+ mark 1) y)
					(++ mark)
				else
					(+= topString x)
				)
			else
				(break)
			)
			(-- lines)
		)
		(return
			(if redraw
				(self draw:)
				1
			)
		)
	)

	(method (handleEvent event &tmp temp0 [temp1 3] temp4 [temp5 4])
		(if (event claimed:)
			(return 0)
		)
		(= temp0 0)
		(switch (event type:)
			(evKEYBOARD
				(event
					claimed:
						(switch (event message:)
							(KEY_HOME
								(self retreat: 50)
							)
							(KEY_END
								(self advance: 50)
							)
							($5100 ; PAGEDOWN
								(self advance: (- y 1))
							)
							($4900 ; PAGEUP
								(self retreat: (- y 1))
							)
							(KEY_DOWN
								(self advance: 1)
							)
							(KEY_UP
								(self retreat: 1)
							)
							(else 0)
						)
				)
			)
			(evMOUSEBUTTON
				(if (self check: event)
					(event claimed: 1)
					(cond
						((< (event y:) (+ nsTop 10))
							(repeat
								(self retreat: 1)
								(breakif (not (StillDown)))
							)
						)
						((> (event y:) (- nsBottom 10))
							(repeat
								(self advance: 1)
								(breakif (not (StillDown)))
							)
						)
						(else
							(TextSize @[temp5 0] {M} font 0 0)
							(if
								(>
									(= temp4
										(/
											(- (event y:) (+ nsTop 10))
											[temp5 2]
										)
									)
									mark
								)
								(self advance: (- temp4 mark))
							else
								(self retreat: (- mark temp4))
							)
						)
					)
				)
			)
		)
		(if (and (event claimed:) (& state $0002)) self else 0)
	)
)

(class Dialog of List
	(properties
		text 0
		window 0
		theItem 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		time 0
		busy 0
		caller 0
		seconds 0
		lastSeconds 0
		disposeText 0
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
			dialog: self
			open:
		)
		(= seconds time)
		(self draw:)
	)

	(method (draw)
		(self eachElementDo: #draw)
	)

	(method (doit def &tmp done event ret eatMice lastTick)
		(= done 0)
		(= busy 1)
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
			(= eatMice gEatMice)
			(= lastTick (GetTime))
		else
			(= eatMice 0)
		)
		(= ret 0)
		(while (not ret)
			(self eachElementDo: #cycle)
			(= event ((Event new:) localize:))
			(if eatMice
				(-- eatMice)
				(if (== (event type:) 1)
					(event type: 0)
				)
				(while (== lastTick (GetTime))
				)
				(= lastTick (GetTime))
			)
			(= ret (self handleEvent: event))
			(event dispose:)
			(self check:)
			(if (or (== ret -1) (not busy))
				(= ret 0)
				(EditControl theItem 0)
				(break)
			)
			(Wait 1)
		)
		(= busy 0)
		(return ret)
	)

	(method (check &tmp thisSeconds)
		(if seconds
			(= thisSeconds (GetTime 1)) ; SysTime12
			(if (!= lastSeconds thisSeconds)
				(= lastSeconds thisSeconds)
				(if (not (-- seconds))
					(self cue:)
				)
			)
		)
	)

	(method (cue)
		(if (not busy)
			(self dispose:)
		else
			(= busy 0)
		)
	)

	(method (dispose &tmp theCaller)
		(if (== self gModelessDialog)
			(SetPort gModelessPort)
			(= gModelessDialog 0)
			(= gModelessPort 0)
		)
		(if window
			(window dispose:)
		)
		(= theItem (= window 0))
		(if (and text disposeText)
			(Memory memFREE text)
		)
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

	(method (handleEvent event &tmp ret)
		(if (& (event type:) $0040) ; direction
			(event type: evKEYBOARD)
			(switch (event message:)
				(5
					(event message: KEY_DOWN)
				)
				(1
					(event message: KEY_UP)
				)
				(7
					(event message: KEY_LEFT)
				)
				(3
					(event message: KEY_RIGHT)
				)
				(else
					(event type: $0040) ; direction
				)
			)
		)
		(if
			(or
				(event claimed:)
				(== (event type:) evNULL)
				(and
					(!= evMOUSEBUTTON (event type:))
					(!= evKEYBOARD (event type:))
					(!= $0040 (event type:)) ; direction
					(!= evJOYDOWN (event type:))
				)
			)
			(EditControl theItem event)
			(return 0)
		)
		(if (= ret (self firstTrue: #handleEvent event))
			(EditControl theItem 0)
			(if theItem
				(theItem select: 0)
			)
			((= theItem ret) select: 1)
			(ret doit:)
			(if (not (ret checkState: 2))
				(= ret 0)
			)
		else
			(= ret 0)
			(cond
				(
					(and
						(or
							(== (event type:) evJOYDOWN)
							(and
								(== evKEYBOARD (event type:))
								(== KEY_RETURN (event message:))
							)
						)
						theItem
						(theItem checkState: 1)
					)
					(= ret theItem)
					(EditControl theItem 0)
					(event claimed: 1)
				)
				(
					(or
						(and
							(not (self firstTrue: #checkState 1))
							(or
								(and
									(== evKEYBOARD (event type:))
									(== KEY_RETURN (event message:))
								)
								(== evMOUSEBUTTON (event type:))
								(== evJOYDOWN (event type:))
							)
						)
						(and (== evKEYBOARD (event type:)) (== KEY_ESCAPE (event message:)))
					)
					(event claimed: 1)
					(= ret -1)
				)
				(
					(and
						(IsObject theItem)
						(theItem isType: 3)
						(== (event type:) evKEYBOARD)
						(== (event message:) KEY_RIGHT)
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
						(== (event type:) evKEYBOARD)
						(== (event message:) KEY_LEFT)
					)
					(if (<= (theItem cursor:) 0)
						(self retreat:)
					else
						(EditControl theItem event)
					)
				)
				(
					(and
						(== evKEYBOARD (event type:))
						(OneOf (event message:) KEY_TAB KEY_RIGHT KEY_DOWN)
					)
					(event claimed: 1)
					(self advance:)
				)
				(
					(and
						(== evKEYBOARD (event type:))
						(OneOf (event message:) KEY_SHIFTTAB KEY_LEFT KEY_UP)
					)
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
			(TextSize @[r 0] text 0 -1 0)
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
		(self moveTo: 0 0)
	)
)

(class Controls of List
	(properties)

	(method (draw)
		(self eachElementDo: #setSize)
		(self eachElementDo: #draw)
	)

	(method (handleEvent event &tmp cont)
		(if (event claimed:)
			(return 0)
		)
		(if
			(and
				(= cont (self firstTrue: #handleEvent event))
				(not (cont checkState: 2))
			)
			(cont doit:)
			(= cont 0)
		)
		(return cont)
	)
)

