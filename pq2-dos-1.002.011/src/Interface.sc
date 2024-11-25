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
	StillDown 6
)

(local
	local0
	[local1 20]
)

(procedure (StillDown &tmp event ret)
	(= event (Event new:))
	(= ret (!= (event type:) evMOUSERELEASE))
	(event dispose:)
	(return ret)
)

(procedure (MousedOn obj event theMods) ; UNUSED
	(cond
		((!= (event type:) 1) 0)
		((and (>= argc 3) theMods (== (& (event modifiers:) theMods) 0)) 0)
		((obj respondsTo: #nsLeft)
			(proc999_4
				(obj nsLeft:)
				(obj nsTop:)
				(obj nsRight:)
				(obj nsBottom:)
				event
			)
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

(procedure (Print args &tmp theDialog textI iconI editI ret i atX atY fixWidth keepIt default curPort [buttons 6] buttonWide buttonsUsed butAtX [buffer 1000])
	(= curPort (GetPort))
	(= atX (= atY -1))
	(= keepIt (= fixWidth (= buttonWide (= iconI (= editI (= buttonsUsed 0))))))
	((= theDialog (Dialog new:)) window: gSysWindow name: {PrintD})
	(= textI (DText new:))
	(cond
		((u< [args 0] 1000)
			(GetFarText [args 0] [args 1] @buffer)
			(= i 2)
		)
		([args 0]
			(StrCpy @buffer [args 0])
			(= i 1)
		)
		(else
			(= buffer 0)
			(= i 0)
		)
	)
	(textI text: @buffer moveTo: 4 4 font: gUserFont setSize:)
	(theDialog add: textI)
	(for ((= i i)) (< i argc) ((++ i))
		(switch [args i]
			(30
				(++ i)
				(textI mode: [args i])
			)
			(33
				(++ i)
				(textI font: [args i] setSize: fixWidth)
			)
			(70
				(= fixWidth [args (++ i)])
				(textI setSize: fixWidth)
			)
			(25
				(++ i)
				(theDialog time: [args i])
			)
			(80
				(++ i)
				(theDialog text: [args i])
			)
			(67
				(= atX [args (++ i)])
				(= atY [args (++ i)])
			)
			(83
				(Animate (gCast elements:) 0)
			)
			(41
				(++ i)
				((= editI (DEdit new:)) text: [args i])
				(++ i)
				(editI max: [args i] setSize:)
			)
			(81
				((= [buttons buttonsUsed] (DButton new:))
					text: [args (++ i)]
					value: [args (++ i)]
					setSize:
				)
				(+= buttonWide (+ ([buttons buttonsUsed] nsRight:) 4))
				(++ buttonsUsed)
			)
			(82
				(if (not iconI)
					(= iconI (DIcon new:))
				)
				(iconI
					view: [args (+ i 1)]
					loop: [args (+ i 2)]
					cel: [args (+ i 3)]
					setSize:
				)
				(+= i 3)
			)
			(88
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= keepIt theDialog)
			)
			(35
				(++ i)
				(theDialog window: [args i])
			)
		)
	)
	(if iconI
		(iconI moveTo: 4 4)
		(textI moveTo: (+ 4 (iconI nsRight:)) (textI nsTop:))
		(theDialog add: iconI)
	)
	(theDialog setSize:)
	(if editI
		(editI moveTo: (textI nsLeft:) (+ 4 (textI nsBottom:)))
		(theDialog add: editI setSize:)
	)
	(= butAtX
		(if (> buttonWide (theDialog nsRight:))
			4
		else
			(- (theDialog nsRight:) buttonWide)
		)
	)
	(for ((= i 0)) (< i buttonsUsed) ((++ i))
		([buttons i] moveTo: butAtX (theDialog nsBottom:))
		(theDialog add: [buttons i])
		(= butAtX (+ 4 ([buttons i] nsRight:)))
	)
	(theDialog setSize: center:)
	(if (and iconI (not (StrLen @buffer)))
		(iconI
			moveTo:
				(/
					(-
						(- (theDialog nsRight:) (theDialog nsLeft:))
						(- (iconI nsRight:) (iconI nsLeft:))
					)
					2
				)
				4
		)
	)
	(theDialog
		moveTo:
			(if (== -1 atX)
				(theDialog nsLeft:)
			else
				atX
			)
			(if (== -1 atY)
				(theDialog nsTop:)
			else
				atY
			)
	)
	(theDialog open: (if (theDialog text:) 4 else 0) (if keepIt 15 else -1))
	(if keepIt
		(= local0 (GetPort))
		(SetPort curPort)
		(return (= gModelessDialog keepIt))
	)
	(if
		(and
			(= default (theDialog firstTrue: #checkState 1))
			(not (theDialog firstTrue: #checkState 2))
		)
		(default state: (| (default state:) $0002))
	)
	(if (== (= ret (theDialog doit: default)) -1)
		(= ret 0)
	)
	(for ((= i 0)) (< i buttonsUsed) ((++ i))
		(if (== ret [buttons i])
			(= ret (ret value:))
			(break)
		)
	)
	(if (not (theDialog theItem:))
		(= ret 1)
	)
	(theDialog dispose:)
	(return ret)
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

	(method (handleEvent event)
		(if state
			(MenuSelect event &rest)
		else
			0
		)
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

	(method (handleEvent event &tmp ret evtType evt)
		(if (event claimed:)
			(return 0)
		)
		(= ret 0)
		(if
			(and
				(& state $0001)
				(or
					(and (== (= evtType (event type:)) evSAID) (Said said))
					(and (== evtType evKEYBOARD) (== (event message:) key))
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
				(= event (Event new: evPEEK))
				(GlobalToLocal event)
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
)

(class DText of Item
	(properties
		type 2
		text 0
		font 1
		mode 0
	)

	(method (new &tmp newText)
		((super new:) font: gUserFont yourself:)
	)

	(method (setSize w &tmp [r 4])
		(TextSize @[r 0] text font (if argc w else 0))
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

(class DButton of Item
	(properties
		type 1
		state 3
		text 0
		font 0
	)

	(method (setSize &tmp [r 4])
		(TextSize @[r 0] text font)
		(+= [r 2] 2)
		(+= [r 3] 2)
		(= nsBottom (+ nsTop [r 2]))
		(= [r 3] (* (/ (+ [r 3] 15) 16) 16))
		(= nsRight (+ [r 3] nsLeft))
	)
)

(class DEdit of Item
	(properties
		type 3
		state 1
		text 0
		font 0
		max 0
		cursor 0
	)

	(method (track evt)
		(EditControl self evt)
		(return self)
	)

	(method (setSize &tmp [r 4])
		(TextSize @[r 0] {M} font)
		(= nsBottom (+ nsTop [r 2]))
		(= nsRight (+ nsLeft (/ (* [r 3] max 3) 4)))
		(= cursor (StrLen text))
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
		timer 0
		busy 0
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
		(if time
			(Timer setReal: self time)
		)
		(self draw:)
	)

	(method (draw)
		(self eachElementDo: #draw)
	)

	(method (doit def &tmp done event ret eatMice lastTick)
		(= done 0)
		(= busy 1)
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
			(= eatMice 60)
			(= lastTick (GetTime))
		else
			(= eatMice 0)
		)
		(= ret 0)
		(while (not ret)
			(GlobalToLocal (= event (Event new:)))
			(if eatMice
				(-- eatMice)
				(if (== (event type:) evMOUSEBUTTON)
					(event type: evNULL)
				)
				(while (== lastTick (GetTime))
				)
				(= lastTick (GetTime))
			)
			(= ret (self handleEvent: event))
			(event dispose:)
			(if timer
				(timer doit:)
			)
			(if (or (== ret -1) (not busy))
				(= ret 0)
				(EditControl theItem 0)
				(break)
			)
		)
		(= busy 0)
		(return ret)
	)

	(method (cue)
		(if (not busy)
			(self dispose:)
		else
			(= busy 0)
		)
	)

	(method (dispose)
		(if (== self gModelessDialog)
			(SetPort local0)
			(= gModelessDialog 0)
			(= local0 0)
		)
		(if window
			(window dispose:)
		)
		(= window 0)
		(if timer
			(timer dispose: delete:)
		)
		(= theItem 0)
		(super dispose:)
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
		)
	)

	(method (handleEvent event &tmp ret)
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
			(if (not (ret checkState: 2))
				(if theItem
					(theItem select: 0)
				)
				((= theItem ret) select: 1)
				(ret doit:)
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
				((and (== evKEYBOARD (event type:)) (== KEY_TAB (event message:)))
					(event claimed: 1)
					(self advance:)
				)
				((and (== evKEYBOARD (event type:)) (== KEY_SHIFTTAB (event message:)))
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
			(TextSize @[r 0] text 0 -1)
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

(class SysWindow of Obj
	(properties
		top 0
		left 0
		bottom 0
		right 0
		color 0
		back 15
		priority -1
		window 0
		type 0
		title 0
		brTop 0
		brLeft 0
		brBottom 190
		brRight 320
	)

	(method (open)
		(= window
			(NewWindow top left bottom right title type priority color back)
		)
	)

	(method (dispose)
		(DisposeWindow window)
		(super dispose:)
	)
)

