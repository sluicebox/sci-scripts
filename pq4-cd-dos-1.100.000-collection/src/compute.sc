;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19)
(include sci.sh)
(use Main)
(use TellerIcon)
(use DText)
(use Plane)
(use Str)
(use Array)
(use Print)
(use Inset)
(use Talker)
(use Feature)
(use Sound)
(use User)
(use Actor)
(use System)

(public
	compute 0
	screenTalker 1
)

(local
	local0
	local1
	local2
	local3
)

(instance myPrint of Print
	(properties
		fore 28
	)
)

(instance compute of Inset
	(properties
		picture 550
		anOverlay 1
		modNum 550
	)

	(method (init &tmp temp0 temp1 temp2 temp3)
		(gTheIconBar state: (| (gTheIconBar state:) $0004))
		(User input: 1)
		(gThePlane setRect: 0 0 319 199)
		(gGame fade: 100 0 10)
		(super init: &rest)
		(FrameOut)
		(gGame fade: 0 100 10)
		(RemapColors 2 254 90) ; ByPercent
		(RemapColors 2 253 80) ; ByPercent
		(RemapColors 2 252 70) ; ByPercent
		(SetCursor 73 36 236 151)
		(= local0 (gTheCursor view:))
		(gTheCursor view: 555)
		(gGame setCursor: gTheCursor 1 160 100)
		(= temp1 (Str new:))
		(= temp2 (Str new:))
		(= temp3 (Str new:))
		(= local1 (Str newWith: 100 {}))
		(sFx number: 1022 setLoop: 1 play:)
		(while 1
			(cond
				(
					(==
						(= temp0
							(myPrint
								font: 999
								plane: screenPlane
								addText: 4 51 19 1 0 0 550 ; "ID Number:"
								addEdit: temp1 15 5 12 temp1
								addText: 4 51 19 2 0 25 550 ; "Password:"
								addEdit: temp2 15 5 36 temp2
								addButton: 0 0 0 37 1 80 65 550 ; "OK"
								addButton: -1 0 0 16 1 100 65 550 ; "Cancel"
								init:
							)
						)
						-1
					)
					(break)
				)
				((temp1 size:)
					(Message msgGET 550 0 0 40 1 (temp3 data:)) ; "612"
					(temp1 strip:)
					(temp3 strip:)
					(if (temp1 compare: temp3)
						(if (temp2 size:)
							(temp2 strip: upper:)
							(Message msgGET 550 0 0 17 1 (temp3 data:)) ; "GUNNER"
							(temp3 strip: upper:)
							(if (temp2 compare: temp3)
								(gGame points: 8 68)
								(sFx number: 1022 setLoop: 1 play:)
								(myPrint
									font: 999
									mode: 1
									width: 120
									plane: screenPlane
									addText: 4 51 13 1 0 0 550 ; "Logging in 00001B02345E3 as CAREY on server SONNY."
									init:
								)
								(break)
							else
								(sFx number: 1021 setLoop: 1 play:)
								(myPrint
									font: 999
									mode: 1
									width: 120
									plane: screenPlane
									addText: 0 0 18 3 0 0 550 ; "Incorrect Password!"
									init:
								)
							)
						else
							(sFx number: 1021 setLoop: 1 play:)
							(myPrint
								font: 999
								mode: 1
								width: 120
								plane: screenPlane
								addText: 0 0 18 3 0 0 550 ; "Incorrect Password!"
								init:
							)
						)
					else
						(sFx number: 1021 setLoop: 1 play:)
						(myPrint
							font: 999
							mode: 1
							width: 120
							plane: screenPlane
							addText: 0 0 18 2 0 0 550 ; "Invalid ID Number!"
							init:
						)
					)
				)
				(else
					(sFx number: 1021 setLoop: 1 play:)
					(myPrint
						font: 999
						mode: 1
						width: 120
						plane: screenPlane
						addText: 0 0 18 1 0 0 550 ; "ERROR!! Invalid Entry"
						init:
					)
				)
			)
		)
		(temp1 dispose:)
		(temp2 dispose:)
		(temp3 dispose:)
		(if (== temp0 -1)
			(sFx number: 1022 setLoop: 1 play:)
			(= local2 1)
			(self dispose:)
			(return)
		)
		(screen init:)
		(FrameOut)
		(computerTeller init: screen 550)
		(computerTeller doVerb:)
	)

	(method (doit)
		(super doit:)
		(if local3
			(= local3 0)
			(computerTeller doVerb:)
		)
	)

	(method (dispose)
		(local1 dispose:)
		(if (not local2)
			(computerTeller dispose:)
		)
		(gGame fade: 100 0 10)
		(SetCursor -2)
		(gTheCursor view: local0)
		(gGame setCursor: gTheCursor 1)
		(gThePlane setRect: 0 0 319 152)
		(super dispose:)
		(gTheIconBar enable:)
		(FrameOut)
		(gGame fade: 0 100 10)
		(gGame doRemap: 2 254 75)
	)
)

(instance screen of Feature
	(properties
		noun 3
		nsLeft 72
		nsTop 36
		nsRight 245
		nsBottom 162
		sightAngle 360
		x 158
		y 99
	)
)

(instance compIcon of TellerIcon
	(properties)

	(method (dispose)
		(myHandle dispose:)
		(= myHandle 0)
		(if text1
			(text1 dispose:)
			(= text1 0)
		)
		(if text2
			(text2 dispose:)
			(= text2 0)
		)
		(if text3
			(text3 dispose:)
			(= text3 0)
		)
		(DisposeClone self)
	)

	(method (show &tmp temp0 temp1)
		(= temp1 (IntArray with: 0 0 0 0))
		(TextSize (temp1 data:) (myHandle data:) (myTeller font:))
		(= nsRight (+ nsLeft (- (plane right:) (plane left:))))
		(-- nsTop)
		(= nsBottom (+ nsTop 8))
		(= x (+ nsLeft 1))
		(= y (+ nsTop 1))
		(if (not text3)
			(= text3
				((myDText new:)
					posn: (+ 1 x) nsTop
					font: (myTeller font:)
					text: (myHandle data:)
					fore: lowlightColor
					back: 254
					skip: 254
					setSize:
					init: (myTeller tellCast:)
					setPri: 240
					yourself:
				)
			)
		)
		(if (not text2)
			(= text2
				((myDText new:)
					posn: (+ x 1) nsTop
					text: (myHandle data:)
					font: (myTeller font:)
					fore: highlightColor
					back: 254
					skip: 254
					setSize:
					init: (myTeller tellCast:)
					setPri: 255
					yourself:
				)
			)
		)
		(UpdateScreenItem text3)
		(UpdateScreenItem text2)
		(temp1 dispose:)
	)

	(method (init &tmp temp0)
		(&= signal $fff7)
		(= plane ((myTeller theControls:) plane:))
	)

	(method (select param1 &tmp temp0 temp1 temp2)
		(if
			(if (and argc param1 (& signal $0001))
				(= temp1 1)
				(text2 setPri: 240)
				(text3 setPri: 254)
				(UpdateScreenItem text2)
				(UpdateScreenItem text3)
				(FrameOut)
				(while (!= ((= temp0 ((gUser curEvent:) new:)) type:) 2)
					(temp0 localize: plane)
					(cond
						((self onMe: temp0)
							(if (not temp1)
								(= temp1 1)
								(self highlight: 1)
								(FrameOut)
							)
						)
						(temp1
							(= temp1 0)
							(self highlight: 0)
							(FrameOut)
						)
					)
				)
				(if temp1
					(sFx number: 1023 setLoop: 1 play:)
				)
				temp1
			else
				1
			)
			(myTeller iconValue: value)
			((myTeller theControls:)
				state: (& ((myTeller theControls:) state:) $ffdf)
			)
			(return 1)
		else
			(return 0)
		)
	)

	(method (highlight param1)
		(if param1
			(text2 setPri: 240)
			(text3 setPri: 254)
		else
			(text2 setPri: 254)
			(text3 setPri: 240)
		)
	)
)

(instance myDText of DText
	(properties)

	(method (setPri)
		(super setPri: &rest)
		(UpdateScreenItem self)
	)

	(method (dispose &tmp temp0)
		(if bitmap
			(Bitmap 1 bitmap) ; Dispose
			(= bitmap 0)
		)
		(gCast delete: self)
		(if (self isNotHidden:)
			(DeleteScreenItem self)
		)
		(= temp0 (plane casts:))
		(temp0 eachElementDo: #delete self)
		(= plane 0)
		(DisposeClone self)
	)
)

(instance intList of List
	(properties)

	(method (dispose)
		(self release:)
		(DisposeClone self)
	)
)

(instance computerTeller of Teller
	(properties
		sayNoun 4
		verb 51
		modNum 550
		title 1
	)

	(method (respond &tmp temp0 temp1 temp2)
		(= iconValue 0)
		(self buildCaseList: showCases:)
		(curList dispose:)
		(= curList 0)
		(cond
			((not iconValue)
				(return 0)
			)
			((== iconValue -999)
				(return 1)
			)
			((== iconValue 999)
				(FrameOut)
				(stack delete: curNoun)
				(= curNoun (stack at: 0))
				(return 0)
			)
			((== iconValue 64981)
				(FrameOut)
				(if stack
					(stack dispose:)
				)
				((= stack (intList new:))
					addToFront: (= curNoun (client noun:))
				)
				(return 0)
			)
			(else
				(if
					(and
						(>= (= temp2 (self sayMessage:)) 0)
						(Message msgSIZE modNum curNoun verb iconValue 2)
						(>
							(= temp0
								(Message 4 modNum curNoun verb iconValue 2) ; msgREF_NOUN
							)
							-1
						)
					)
					(= curNoun temp0)
					(stack addToFront: curNoun)
				)
				(return temp2)
			)
		)
	)

	(method (showCases param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 [temp7 3] temp10 temp11 temp12 temp13 temp14 temp15)
		(= temp13 0)
		(= temp12 120)
		(= temp1 0)
		(= temp3 0)
		(= temp6 0)
		(= temp2 0)
		(theControls plane: (screenPlane new:))
		(= temp15 0)
		(if title
			(= temp14 (Str newWith: 100 {}))
			(Message msgGET 550 0 0 title 1 (temp14 data:))
			((= temp15 (DText new:))
				text: (temp14 data:)
				font: 999
				mode: 1
				fore: 34
				back: 0
				skip: 0
			)
			(+= temp3 10)
			(temp14 data: 0 dispose:)
		)
		(for ((= temp0 0)) (< temp0 (curList size:)) ((++ temp0))
			(= temp4 1)
			(for ((= temp1 0)) (and temp4 (< temp1 argc)) ((+= temp1 2))
				(if
					(and
						(== (curList at: temp0) [param1 temp1])
						(not [param1 (+ temp1 1)])
					)
					(= temp4 0)
				)
			)
			(if temp4
				(= temp13 1)
				(= temp5 (curList at: temp0))
				(= temp11 (self getSeqNum: temp5))
				(if
					(not
						(= temp10 (Message msgSIZE modNum curNoun verb temp5 temp11))
					)
					(break)
				)
				(= temp2 (compIcon new:))
				(temp2 myHandle: (Str new: temp10))
				(if (> (= temp10 (+ (* temp10 5) 20)) temp12)
					(= temp12 temp10)
				)
				(Message
					msgGET
					modNum
					curNoun
					verb
					temp5
					temp11
					((temp2 myHandle:) data:)
				)
				(temp2 value: temp5 nsTop: temp3 myTeller: self)
				(theControls add: temp2)
				(++ temp6)
				(+= temp3 8)
			)
		)
		(if (not temp2)
			(client doVerb: 2)
			(if temp15
				(temp15 dispose:)
			)
			(theControls dispose:)
			(return -999)
		)
		((= temp2 (compIcon new:)) nsTop: temp3 myTeller: self)
		(if (> (stack size:) 2)
			(= temp10 (Message msgSIZE 2 0 0 2 1)) ; "Something else"
			(temp2 myHandle: (Str new: (+ temp10 1)))
			(Message msgGET modNum 0 0 41 1 ((temp2 myHandle:) data:))
			(temp2 value: 999)
			(theControls add: temp2)
			(+= temp3 8)
			((= temp2 (compIcon new:)) nsTop: temp3 myTeller: self)
			(= temp10 (Message msgSIZE 2 0 0 2 1)) ; "Something else"
			(temp2 myHandle: (Str new: (+ temp10 1)))
			(Message msgGET modNum 0 0 2 1 ((temp2 myHandle:) data:))
			(temp2 value: 64981)
			(theControls add: temp2)
		else
			(if (not (== curNoun (client noun:)))
				(= temp10 (Message msgSIZE modNum 0 0 2 1))
				(temp2 myHandle: (Str new: (+ temp10 1)))
				(Message msgGET modNum 0 0 2 1 ((temp2 myHandle:) data:))
				(temp2 value: 999)
			else
				(= temp10 (Message msgSIZE modNum 0 0 3 1))
				(temp2 myHandle: (Str new: (+ temp10 1)))
				(Message msgGET modNum 0 0 3 1 ((temp2 myHandle:) data:))
				(temp2 value: -999)
			)
			(theControls add: temp2)
		)
		((theControls plane:)
			top: 38
			bottom: (+ 70 (* 9 temp6))
			left: (- 160 (/ temp12 2))
			right: (+ 160 (/ temp12 2))
			init:
			addCast: tellCast
		)
		(if temp15
			(temp15 x: 0 y: 0 setSize: temp12 init: tellCast)
		)
		(theControls init: show: eachElementDo: #dispose release: dispose:)
		(return (FrameOut))
	)

	(method (sayMessage &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
		(cond
			((> (Message 4 modNum curNoun verb iconValue 2) -1) ; msgREF_NOUN
				(return 0)
			)
			((== iconValue 61)
				(local1 fill: 0 (local1 size:) 0)
				(compute setScript: (hateScr new:))
				(return 1)
			)
			((== iconValue 57)
				(local1 fill: 0 (local1 size:) 0)
				(compute setScript: (licenseScr new:))
				(return 1)
			)
			((or (<= 21 iconValue 30) (<= 42 iconValue 51))
				(if (== iconValue 29)
					(gGame points: 2 69)
					(gPqFlags set: 45)
				)
				(= temp6
					(if (>= iconValue 42)
						(- iconValue 42)
					else
						(- iconValue 21)
					)
				)
				(= temp7 (if (>= iconValue 42) 1 else 0))
				((= temp9 (View new:))
					view: 555
					loop: 0
					cel: 1
					x: 75
					y: 40
					fixPriority: 1
					priority: 0
					init:
				)
				((= temp8 (View new:))
					view: 551
					loop: temp6
					cel: temp7
					x: 75
					y: 40
					fixPriority: 1
					priority: 1
					init:
				)
				(= temp3 (Str newWith: 100 {}))
				(Message msgGET 550 4 51 iconValue 1 (temp3 data:))
				((DText new:)
					text: (temp3 data:)
					font: 999
					posn: 160 39
					mode: 1
					setSize: 110
					fore: 34
					back: 0
					skip: 0
					init:
				)
				(temp3 data: 0)
				(temp3 dispose:)
				(= temp3 (Str newWith: 100 {}))
				(Message msgGET 550 4 51 iconValue 2 (temp3 data:))
				((DText new:)
					text: (temp3 data:)
					font: 999
					posn: 142 51
					mode: 0
					setSize: 100
					fore: 22
					back: 0
					skip: 0
					init:
				)
				(temp3 data: 0)
				(temp3 dispose:)
				(= temp2 3)
				(while 1
					(= temp4 (Str newWith: 800 {}))
					(if (not (screenText text:))
						(Message msgGET 550 4 51 iconValue temp2 (temp4 data:))
						(screenText
							text: (temp4 data:)
							font: 999
							posn: 80 99
							mode: 0
							setSize: 165
							fore: 13
							back: 0
							skip: 0
							init:
						)
						(temp4 data: 0 dispose:)
					else
						(KString 4 (screenText text:)) ; StrFree
						(Message msgGET 550 4 51 iconValue temp2 (temp4 data:))
						(screenText text: (temp4 data:) setSize: 165 draw:)
						(temp4 data: 0 dispose:)
					)
					(myPrint
						x: 92
						y: 138
						plane: screenPlane
						addButton: -1 0 0 37 1 0 0 550 ; "OK"
					)
					(if (> temp2 3)
						(myPrint addButton: 1 0 0 39 1 19 0 550) ; "Prev"
					)
					(if (Message msgSIZE 550 4 51 iconValue (+ temp2 1))
						(myPrint
							addButton: ; "Next"
								2
								0
								0
								38
								1
								(if (> temp2 3) 54 else 19)
								0
								550
						)
					)
					(= temp1 (myPrint init:))
					(sFx number: 1023 setLoop: 1 play:)
					(switch temp1
						(-1
							(break)
						)
						(1
							(-- temp2)
						)
						(2
							(++ temp2)
						)
					)
					(FrameOut)
				)
				(gCast eachElementDo: #dispose release:)
				(screenText text: 0)
				(FrameOut)
				(return 0)
			)
			(else
				(gMessager say: sayNoun verb iconValue 0 self modNum)
			)
		)
		(return 1)
	)

	(method (cue)
		(FrameOut)
		(self doVerb:)
	)

	(method (doVerb)
		(while 1
			(if (self respond:)
				(break)
			)
		)
		(if (== iconValue -999)
			(sFx number: 1022 setLoop: 1 play:)
			(myPrint
				font: 999
				mode: 1
				width: 120
				plane: screenPlane
				addText: 4 51 3 1 0 0 550 ; "CAREY  Logged Out From  Server SONNY, Connection 29"
				init:
			)
			(compute dispose:)
		)
	)
)

(instance screenText of DText
	(properties)
)

(instance exitScript of Script ; UNUSED
	(properties)

	(method (changeState newState &tmp [temp0 4])
		(switch (= state newState)
			(0
				(gMessager say: 4 51 3 1 self 550) ; "CAREY  Logged Out From  Server SONNY, Connection 29"
			)
			(1
				(compute dispose:)
			)
		)
	)
)

(instance licenseScr of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(= ticks 1)
			)
			(1
				(FrameOut)
				(= register
					(myPrint
						font: 999
						plane: screenPlane
						addText: 4 51 57 1 0 0 550 ; "Enter License Number:"
						addEdit: local1 10 5 12 local1
						addButton: -1 0 0 16 1 100 65 550 ; "Cancel"
						addButton: 1 0 0 37 1 80 65 550 ; "OK"
						init:
					)
				)
				(sFx number: 1023 setLoop: 1 play:)
				(if (== register -1)
					(FrameOut)
					(= local3 1)
					(self dispose:)
				else
					(gMessager say: 4 51 60 0 self 550) ; "Searching..."
				)
			)
			(2
				(FrameOut)
				(= temp0 0)
				(= temp3 (Str new:))
				(local1 upper:)
				(while (< temp0 100)
					(if (Message msgSIZE 550 9 0 temp0 1)
						(Message msgGET 550 9 0 temp0 1 (temp3 data:))
						(temp3 upper:)
						(= temp1 0)
						(if (local1 compare: temp3)
							(sFx number: 1023 setLoop: 1 play:)
							(if (== temp0 66)
								(if (gPqFlags test: 91)
									(gGame points: 2 70)
									(gPqFlags set: 21)
								else
									(gMessager say: 4 51 63 0 self 550) ; "Hey no cheating! You aren't supposed to have that information yet."
									(break)
								)
							)
							(gMessager say: 9 2 temp0 0 self 550)
							(break)
						)
					)
					(++ temp0)
				)
				(temp3 dispose:)
				(if (== temp0 100)
					(sFx number: 1021 setLoop: 1 play:)
					(gMessager say: 4 0 59 1 self 550) ; "License Information Not Found"
				)
			)
			(3
				(FrameOut)
				(= state -1)
				(= cycles 2)
			)
		)
	)
)

(instance hateScr of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(= ticks 1)
			)
			(1
				(FrameOut)
				(= register
					(myPrint
						font: 999
						plane: screenPlane
						addText: 4 51 61 1 0 0 550 ; "Enter Suspect's Last Name:"
						addEdit: local1 10 5 12 local1
						addButton: 1 0 0 37 1 80 65 550 ; "OK"
						addButton: -1 0 0 16 1 100 65 550 ; "Cancel"
						init:
					)
				)
				(sFx number: 1023 setLoop: 1 play:)
				(if (== register -1)
					(FrameOut)
					(= local3 1)
					(self dispose:)
				else
					(gMessager say: 4 51 60 0 self 550) ; "Searching..."
				)
			)
			(2
				(= temp0 0)
				(= temp3 (Str newWith: 100 {}))
				(local1 strip: upper:)
				(while (< temp0 100)
					(if (Message msgSIZE 550 10 0 temp0 1)
						(Message msgGET 550 10 0 temp0 1 (temp3 data:))
						(= temp1 0)
						(temp3 strip: upper:)
						(if (local1 compare: temp3)
							(sFx number: 1023 setLoop: 1 play:)
							(if (== temp0 68)
								(if (gPqFlags test: 139)
									(gGame points: 2 71)
									(gPqFlags set: 12)
								else
									(gMessager say: 4 51 63 0 self 550) ; "Hey no cheating! You aren't supposed to have that information yet."
									(break)
								)
							)
							(gMessager say: 10 2 temp0 0 self 550)
							(break)
						)
					)
					(++ temp0)
				)
				(if (== temp0 100)
					(sFx number: 1021 setLoop: 1 play:)
					(gMessager say: 4 0 62 1 self 550) ; "No Information Found"
				)
				(temp3 dispose:)
			)
			(3
				(= state -1)
				(= cycles 2)
			)
		)
	)
)

(instance screenPlane of Plane
	(properties)

	(method (init)
		(= picture -2)
		(super init: &rest)
	)
)

(instance sFx of Sound
	(properties
		flags 1
	)
)

(instance screenTalker of Narrator
	(properties
		y 40
		back 0
	)

	(method (display param1 &tmp temp0 temp1)
		(= temp0 170)
		((= temp1 (Print new:))
			plane: screenPlane
			posn: x y
			fore: 13
			font: 999
			mode: 1
			width: temp0
			modeless: 1
		)
		(temp1 addText: param1 init:)
		(gPrints delete: temp1)
		(= dialog (temp1 dialog:))
	)
)

