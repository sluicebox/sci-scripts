;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 117)
(include sci.sh)
(use Main)
(use Print)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm117 0
)

(local
	[local0 10]
	local10
	local11 = -1
	[local12 200]
	[local212 200]
	[local412 27] = [15 16 27 35 36 37 38 39 40 41 17 18 19 20 21 22 23 24 25 26 28 29 30 31 32 33 34]
	local439
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 temp3)
	(= temp1 0)
	(for ((= temp0 0)) (< temp0 1) ((++ temp0))
		(= temp3 1)
		(for ((= temp2 0)) (< temp2 5) ((++ temp2))
			(if
				(!=
					(StrAt @local0 temp2)
					(if (== (gCurRoom script:) weaponsScript)
						(StrAt {97649 } (+ temp1 temp2))
					else
						(StrAt {60321 } (+ temp1 temp2))
					)
				)
				(= temp3 0)
				(break)
			)
		)
		(if temp3
			(return temp0)
		)
		(+= temp1 6)
	)
	(return -1)
)

(procedure (localproc_1)
	(HandsOn)
	(gTheIconBar disable: 0 4 5 3 1)
)

(procedure (localproc_2 param1 param2 param3 param4)
	(Display param1 dsCOORD param2 param3 dsALIGN alLEFT dsFONT 3 dsCOLOR 7 dsWIDTH param4)
)

(procedure (localproc_3 &tmp temp0)
	(for ((= temp0 0)) (< temp0 27) ((++ temp0))
		(Message msgGET 117 [local412 temp0] 0 10 1 @local212)
		(localproc_2
			@local212
			(+ 20 (* (/ temp0 15) 160))
			(+ 30 (* (mod temp0 15) 10))
			135
		)
	)
)

(procedure (localproc_4 param1 param2 param3 param4 param5 param6 &tmp [temp0 200] [temp200 200])
	(if (Message msgGET 117 [local412 param1] 0 param2 1 @local212)
		(Message msgGET 117 param3 0 0 1 @temp0)
		(Format @temp200 @temp0 @local212)
		(localproc_2 @temp200 param4 param5 param6)
	)
)

(procedure (localproc_5 param1)
	(= local439 2)
	(quitComp moduleScript: personnelScript)
	(gCurRoom picture: 199 drawPic: 199)
	(Animate (gCast elements:) 0)
	(Graph grDRAW_LINE 95 0 95 320 54 -1 -1)
	(Graph grUPDATE_BOX 94 0 96 320 1)
	(localproc_4 param1 10 8 10 30 160)
	(localproc_4 param1 5 1 10 40 160)
	(localproc_4 param1 8 4 10 50 160)
	(localproc_4 param1 6 2 10 60 160)
	(localproc_4 param1 13 14 10 70 160)
	(localproc_4 param1 12 13 180 30 135)
	(localproc_4 param1 7 3 180 40 135)
	(localproc_4 param1 9 6 180 50 135)
	(localproc_4 param1 14 44 180 60 135)
	(Message msgGET 117 10 0 0 1 @local212) ; "Notes"
	(localproc_2 @local212 90 110 160)
	(localproc_4 param1 11 9 40 130 250)
	(Animate (gCast elements:) 0)
)

(instance rm117 of Rm
	(properties
		picture 200
	)

	(method (init)
		(= local439 1)
		(localproc_1)
		(gTheIconBar curIcon: (gTheIconBar at: 2))
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
		(super init:)
		(Load rsVIEW 197)
		(self setScript: startUpRoom)
	)

	(method (dispose)
		(gTheIconBar enable:)
		(super dispose:)
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(switch theVerb
			(4 ; Do
				(if (== local439 0)
					(= temp0 (User curEvent:))
					(if
						(and
							(or (<= 20 (temp0 x:) 155) (<= 180 (temp0 x:) 315))
							(<= 30 (temp0 y:) 180)
						)
						(= temp1
							(+
								(* (/ (temp0 x:) 180) 15)
								(/ (- (temp0 y:) 30) 10)
							)
						)
						(localproc_5 temp1)
					else
						(super doVerb: theVerb &rest)
					)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (notify param1 param2 param3 param4 param5 param6)
		(Format
			@local0
			{%c%c%c%c%c}
			(+ param2 48)
			(+ param3 48)
			(+ param4 48)
			(+ param5 48)
			(+ param6 48)
		)
		(= local10 param1)
		(= local11 (localproc_0))
	)
)

(instance startUpRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fbi init:)
				(weapons init:)
				(personnel init:)
				(quitComp init:)
			)
		)
	)
)

(instance flashIcon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(client setCel: 1)
				(= cycles 15)
			)
			(1
				(client setCel: 0)
				(= cycles 1)
			)
			(2
				(client stopUpd:)
				(gCurRoom setScript: (client moduleScript:) self)
			)
			(3
				(localproc_1)
				(self dispose:)
			)
		)
	)
)

(class ComputerIcon of Prop
	(properties
		y 10
		view 197
		priority 14
		signal 2049
		moduleScript 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(self setScript: flashIcon)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fbiScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom picture: 199 drawPic: 199)
				(fbi hide:)
				(personnel hide:)
				(weapons hide:)
				(quitComp moduleScript: mainMenu x: 17)
				(= cycles 1)
			)
			(1
				(Message msgGET 117 5 4 0 1 @local212) ; "Establishing FBI link. Enter FBI case number:"
				(localproc_2 @local212 20 160 200)
				(= seconds 4)
			)
			(2
				(Graph grFILL_BOX 160 20 179 220 1 0 -1 -1)
				(Graph grUPDATE_BOX 160 20 179 220 1)
				(= cycles 1)
			)
			(3
				(= register 0)
				(self setScript: (ScriptID 165 0) self 0 235 100) ; keyStuff
			)
			(4
				(cond
					((== local10 1)
						(Message msgGET 117 12 0 0 1 @local212) ; "Searching..."
						(localproc_2 @local212 20 160 200)
						(= seconds 1)
					)
					(
						(quitComp
							onMe: ((User curEvent:) x:) ((User curEvent:) y:)
						)
						(gCurRoom setScript: (quitComp moduleScript:))
						(self dispose:)
					)
					(else
						(-= state 2)
						(= cycles 1)
					)
				)
			)
			(5
				(Graph grFILL_BOX 160 20 179 220 1 0 -1 -1)
				(Graph grUPDATE_BOX 160 20 179 220 1)
				(if (<= (++ register) 3)
					(-= state 2)
				)
				(= seconds 1)
			)
			(6
				(if (!= local11 -1)
					(= register
						(Print
							addText: 5 0 2 1 0 0 117 ; "File found:  Taselli, Jason - Currently on Most Wanted List Sex: M Height: 6'0" Hair: Blk Eyes: Blue Weight: 190 Distinguishing Marks: Rose Tattoo over left nipple Please select action:"
							addButton: 0 5 0 2 2 0 86 117 ; "Print file"
							addButton: 1 5 0 2 3 0 102 117 ; "Enter new file code:"
							init:
						)
					)
				else
					(= register 1)
					(Message msgGET 117 5 0 1 1 @local212) ; "File not found."
					(localproc_2 @local212 20 160 200)
				)
				(= seconds 4)
			)
			(7
				(Graph grFILL_BOX 160 20 179 220 1 0 -1 -1)
				(Graph grUPDATE_BOX 160 20 179 220 1)
				(if (not register)
					(Message msgGET 117 5 0 2 4 @local212) ; "Sending file to local printer."
					(localproc_2 @local212 20 160 200)
					(SetFlag 81)
					(= seconds 4)
				else
					(= cycles 1)
				)
			)
			(8
				(Graph grFILL_BOX 160 20 179 220 1 0 -1 -1)
				(Graph grUPDATE_BOX 160 20 179 220 1)
				(-= state 6)
				(= cycles 1)
			)
		)
	)
)

(instance fbi of ComputerIcon
	(properties
		x 17
	)

	(method (init)
		(super init: &rest)
		(= moduleScript fbiScript)
	)
)

(instance weaponsScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom picture: 199 drawPic: 199)
				(fbi hide:)
				(personnel hide:)
				(weapons hide:)
				(quitComp moduleScript: mainMenu x: 17)
				(= cycles 1)
			)
			(1
				(Message msgGET 117 43 4 0 1 @local212) ; "Please enter the 5 digit serial number of your weapon."
				(localproc_2 @local212 20 160 200)
				(= seconds 4)
			)
			(2
				(Graph grFILL_BOX 160 20 179 220 1 0 -1 -1)
				(Graph grUPDATE_BOX 160 20 179 220 1)
				(= cycles 1)
			)
			(3
				(= register 0)
				(self setScript: (ScriptID 165 0) self 0 235 100) ; keyStuff
			)
			(4
				(cond
					((== local10 1)
						(Message msgGET 117 12 0 0 1 @local212) ; "Searching..."
						(localproc_2 @local212 20 160 200)
						(= seconds 1)
					)
					(
						(quitComp
							onMe: ((User curEvent:) x:) ((User curEvent:) y:)
						)
						(gCurRoom setScript: (quitComp moduleScript:))
						(self dispose:)
					)
					(else
						(-= state 2)
						(= cycles 1)
					)
				)
			)
			(5
				(Graph grFILL_BOX 160 20 179 220 1 0 -1 -1)
				(Graph grUPDATE_BOX 160 20 179 220 1)
				(if (<= (++ register) 3)
					(-= state 2)
				)
				(= seconds 1)
			)
			(6
				(if (!= local11 -1)
					(Message msgGET 117 42 0 2 1 @local212) ; "Registered to: Jason Taselli, FBI file #60321."
				else
					(Message msgGET 117 42 0 1 1 @local212) ; "Sorry, that weapon code is not on file."
				)
				(localproc_2 @local212 20 160 200)
				(= seconds 8)
			)
			(7
				(Graph grFILL_BOX 160 20 179 220 1 0 -1 -1)
				(Graph grUPDATE_BOX 160 20 179 220 1)
				(-= state 5)
				(= cycles 1)
			)
		)
	)
)

(instance weapons of ComputerIcon
	(properties
		x 66
		loop 1
	)

	(method (init)
		(super init: &rest)
		(= moduleScript weaponsScript)
	)
)

(instance mainMenu of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local439 1)
				(gCurRoom picture: 200 drawPic: 200)
				(fbi show:)
				(personnel show:)
				(weapons show:)
				(quitComp moduleScript: 0 x: 258)
				(= cycles 1)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance personnelScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local439 0)
				(gCurRoom picture: 199 drawPic: 199)
				(fbi hide:)
				(personnel hide:)
				(weapons hide:)
				(quitComp moduleScript: mainMenu x: 17)
				(Animate (gCast elements:) 0)
				(= cycles 1)
			)
			(1
				(localproc_3)
				(Animate (gCast elements:) 0)
				(self dispose:)
			)
		)
	)
)

(instance personnel of ComputerIcon
	(properties
		x 158
		loop 2
	)

	(method (init)
		(super init: &rest)
		(= moduleScript personnelScript)
	)
)

(instance quitComp of ComputerIcon
	(properties
		x 258
		loop 3
	)

	(method (doVerb)
		(super doVerb: &rest)
		(if (not moduleScript)
			(gCurRoom style: 10 newRoom: 21)
		)
	)
)

