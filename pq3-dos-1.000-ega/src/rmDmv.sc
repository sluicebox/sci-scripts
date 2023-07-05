;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 204)
(include sci.sh)
(use Main)
(use keyPadBut)
(use Interface)
(use Feature)
(use Game)
(use Actor)
(use System)

(public
	rmDmv 0
)

(local
	[local0 2] = [80 35]
	local2
	local3
	local4
	local5
	[local6 20]
	local26
	local27
	local28
	local29
)

(procedure (localproc_0 param1 param2 param3 param4 param5 param6 &tmp [temp0 75])
	(if (u< param1 1000)
		(GetFarText param1 param2 @temp0)
	else
		(StrCpy @temp0 param1)
	)
	(Display @temp0 dsCOORD param3 param4 dsALIGN alLEFT dsFONT 0 dsCOLOR param6 dsWIDTH param5)
)

(procedure (localproc_1)
	(if local6
		(Display @local6 dsCOORD local26 local27 dsALIGN alLEFT dsFONT 0 dsCOLOR 7 dsWIDTH 110)
	)
)

(procedure (localproc_2)
	(gCurRoom style: 5 drawPic: 199)
	(quitBut loop: 0 forceUpd:)
	(plateBut loop: 0 forceUpd:)
	(driverBut loop: 0 forceUpd:)
	(vinBut loop: 0 forceUpd:)
)

(procedure (localproc_3 &tmp [temp0 200] [temp200 20] [temp220 20] [temp240 20] [temp260 20] [temp280 20])
	(localproc_0 204 0 20 170 200 global125) ; "Identified"
	(GetFarText 501 local5 @temp200)
	(GetFarText 501 (+ 1 local5) @temp220)
	(GetFarText 501 (+ 2 local5) @temp240)
	(GetFarText 501 (+ 3 local5) @temp260)
	(GetFarText 501 (+ 4 local5) @temp280)
	(Format @temp0 204 1 @temp200 @temp220 @temp240 @temp260 @temp280) ; "%s%s %s%s%s"
	(Display @temp0 dsCOORD 30 60 dsALIGN alLEFT dsFONT 0 dsCOLOR 7 dsWIDTH 300)
	(GetFarText 501 (+ 5 local5) @temp200)
	(GetFarText 501 (+ 6 local5) @temp220)
	(GetFarText 501 (+ 7 local5) @temp240)
	(Format @temp0 204 2 @temp200 @temp220 @temp240 @temp260) ; "%s %s %s"
	(Display @temp0 dsCOORD 30 100 dsALIGN alLEFT dsFONT 0 dsCOLOR 7 dsWIDTH 100)
)

(procedure (localproc_4 &tmp [temp0 200] [temp200 20] [temp220 20] [temp240 20] [temp260 20] [temp280 20] [temp300 20])
	(localproc_0 204 0 20 170 200 global125) ; "Identified"
	(GetFarText 501 local5 @temp200)
	(GetFarText 501 (+ 1 local5) @temp220)
	(GetFarText 501 (+ 2 local5) @temp240)
	(GetFarText 501 (+ 3 local5) @temp260)
	(GetFarText 501 (+ 4 local5) @temp280)
	(GetFarText 501 (+ 5 local5) @temp300)
	(Format @temp0 204 3 @temp200 @temp220 @temp240 @temp260 @temp280 @temp300) ; "%s %s %s %s %s %s"
	(Display @temp0 dsCOORD 30 60 dsALIGN alLEFT dsFONT 0 dsCOLOR 7 dsWIDTH 300)
)

(procedure (localproc_5)
	(Graph grDRAW_LINE 15 20 15 170 54 -1 -1)
	(Graph grDRAW_LINE 15 20 165 20 54 -1 -1)
	(Graph grDRAW_LINE 15 170 165 170 54 -1 -1)
	(Graph grDRAW_LINE 165 20 165 170 54 -1 -1)
	(Graph grDRAW_LINE 29 20 29 170 54 -1 -1)
	(Graph grDRAW_LINE 30 20 30 170 54 -1 -1)
	(Graph grDRAW_LINE 31 20 31 170 54 -1 -1)
	(Graph grDRAW_LINE 45 20 45 170 54 -1 -1)
	(Graph grDRAW_LINE 60 20 60 170 54 -1 -1)
	(Graph grDRAW_LINE 75 20 75 170 54 -1 -1)
	(Graph grDRAW_LINE 90 20 90 170 54 -1 -1)
	(Graph grDRAW_LINE 75 83 90 83 54 -1 -1)
	(Graph grDRAW_LINE 75 120 90 120 54 -1 -1)
	(Graph grDRAW_LINE 105 20 105 170 54 -1 -1)
	(Graph grDRAW_LINE 90 71 105 71 54 -1 -1)
	(Graph grDRAW_LINE 90 114 105 114 54 -1 -1)
	(Graph grDRAW_LINE 120 20 120 170 54 -1 -1)
	(Graph grDRAW_LINE 105 92 120 92 54 -1 -1)
	(Graph grDRAW_LINE 135 20 135 170 54 -1 -1)
	(Graph grDRAW_LINE 120 79 135 79 54 -1 -1)
	(Graph grDRAW_LINE 150 20 150 170 54 -1 -1)
	(Graph grDRAW_LINE 135 90 150 90 54 -1 -1)
	(Graph grDRAW_LINE 165 20 165 170 54 -1 -1)
	(Graph grUPDATE_BOX 0 0 170 175 1)
	(localproc_0 204 4 50 20 100 global125) ; "NOTICE TO APPEAR"
	(localproc_0 204 5 25 37 100 (proc0_15 global122 global121)) ; "Name -"
	(localproc_0 501 local5 60 37 100 global125)
	(localproc_0 204 6 25 52 100 (proc0_15 global122 global121)) ; "Street -"
	(localproc_0 501 (+ 1 local5) 70 52 100 global125)
	(localproc_0 204 7 25 67 100 (proc0_15 global122 global121)) ; "City -"
	(localproc_0 501 (+ 2 local5) 55 67 100 global125)
	(localproc_0 204 8 25 82 100 (proc0_15 global122 global121)) ; "DL -"
	(localproc_0 501 (+ 3 local5) 47 82 200 global125)
	(localproc_0 204 9 86 82 100 (proc0_15 global122 global121)) ; "Sex -"
	(localproc_0 501 (+ 5 local5) 111 82 100 global125)
	(localproc_0 204 10 125 82 100 (proc0_15 global122 global121)) ; "Eye -"
	(localproc_0 501 (+ 7 local5) 152 82 100 global125)
	(localproc_0 204 11 25 97 100 (proc0_15 global122 global121)) ; "Hair -"
	(localproc_0 501 (+ 6 local5) 55 97 100 global125)
	(localproc_0 204 12 74 97 100 (proc0_15 global122 global121)) ; "WT -"
	(localproc_0 501 (+ 9 local5) 96 97 100 global125)
	(localproc_0 204 13 117 97 100 (proc0_15 global122 global121)) ; "HT -"
	(localproc_0 501 (+ 8 local5) 142 97 100 global125)
	(localproc_0 204 14 25 112 100 (proc0_15 global122 global121)) ; "D.O.B. -"
	(localproc_0 501 (+ 4 local5) 50 112 50 global125)
	(localproc_0 204 15 95 112 100 (proc0_15 global122 global121)) ; "Time -"
	(localproc_0 204 16 25 127 100 (proc0_15 global122 global121)) ; "L.I. -"
	(localproc_0 501 (+ 10 local5) 50 127 50 global125)
	(localproc_0 204 17 83 127 100 (proc0_15 global122 global121)) ; "Reg Exp -"
	(localproc_0 501 (+ 11 local5) 130 127 50 global125)
	(localproc_0 204 18 25 142 100 (proc0_15 global122 global121)) ; "Year -"
	(localproc_0 501 (+ 12 local5) 63 142 50 global125)
	(localproc_0 204 19 95 142 100 (proc0_15 global122 global121)) ; "Make -"
	(localproc_0 501 (+ 12 local5) 133 142 50 global125)
	(localproc_0 204 20 25 157 100 (proc0_15 global122 global121)) ; "Vehicle Code -"
)

(procedure (localproc_6)
	(localproc_2)
	(Animate (gCast elements:) 0)
	(Graph grDRAW_LINE 15 20 15 170 54 -1 -1)
	(Graph grDRAW_LINE 15 20 165 20 54 -1 -1)
	(Graph grDRAW_LINE 15 170 165 170 54 -1 -1)
	(Graph grDRAW_LINE 165 20 165 170 54 -1 -1)
	(Graph grDRAW_LINE 29 20 29 170 54 -1 -1)
	(Graph grDRAW_LINE 30 20 30 170 54 -1 -1)
	(Graph grDRAW_LINE 31 20 31 170 54 -1 -1)
	(Graph grDRAW_LINE 45 20 45 170 54 -1 -1)
	(Graph grDRAW_LINE 60 20 60 170 54 -1 -1)
	(Graph grDRAW_LINE 75 20 75 170 54 -1 -1)
	(Graph grDRAW_LINE 90 20 90 170 54 -1 -1)
	(Graph grDRAW_LINE 75 83 90 83 54 -1 -1)
	(Graph grDRAW_LINE 75 120 90 120 54 -1 -1)
	(Graph grDRAW_LINE 105 20 105 170 54 -1 -1)
	(Graph grDRAW_LINE 90 71 105 71 54 -1 -1)
	(Graph grDRAW_LINE 90 114 105 114 54 -1 -1)
	(Graph grDRAW_LINE 120 20 120 170 54 -1 -1)
	(Graph grDRAW_LINE 105 92 120 92 54 -1 -1)
	(Graph grDRAW_LINE 135 20 135 170 54 -1 -1)
	(Graph grDRAW_LINE 120 79 135 79 54 -1 -1)
	(Graph grDRAW_LINE 150 20 150 170 54 -1 -1)
	(Graph grDRAW_LINE 135 90 150 90 54 -1 -1)
	(Graph grDRAW_LINE 165 20 165 170 54 -1 -1)
	(Graph grUPDATE_BOX 0 0 170 175 1)
	(localproc_0 204 4 50 20 100 global125) ; "NOTICE TO APPEAR"
	(localproc_0 204 5 25 37 100 (proc0_15 global122 global121)) ; "Name -"
	(localproc_0 204 6 25 52 100 (proc0_15 global122 global121)) ; "Street -"
	(localproc_0 204 7 25 67 100 (proc0_15 global122 global121)) ; "City -"
	(localproc_0 204 8 25 82 100 (proc0_15 global122 global121)) ; "DL -"
	(localproc_0 204 9 86 82 100 (proc0_15 global122 global121)) ; "Sex -"
	(localproc_0 204 10 125 82 100 (proc0_15 global122 global121)) ; "Eye -"
	(localproc_0 204 11 25 97 100 (proc0_15 global122 global121)) ; "Hair -"
	(localproc_0 204 12 74 97 100 (proc0_15 global122 global121)) ; "WT -"
	(localproc_0 204 13 117 97 100 (proc0_15 global122 global121)) ; "HT -"
	(localproc_0 204 14 25 112 100 (proc0_15 global122 global121)) ; "D.O.B. -"
	(localproc_0 204 15 95 112 100 (proc0_15 global122 global121)) ; "Time -"
	(localproc_0 204 16 25 127 100 (proc0_15 global122 global121)) ; "L.I. -"
	(localproc_0 204 17 83 127 100 (proc0_15 global122 global121)) ; "Reg Exp -"
	(localproc_0 204 18 25 142 100 (proc0_15 global122 global121)) ; "Year -"
	(localproc_0 204 19 95 142 100 (proc0_15 global122 global121)) ; "Make -"
	(localproc_0 204 20 25 157 100 (proc0_15 global122 global121)) ; "Vehicle Code -"
	(localproc_0 204 21 200 100 100 global125) ; "You must first insert the violator's license into the computer."
)

(instance rmDmv of Rm
	(properties
		picture 199
		style 0
	)

	(method (init)
		(super init:)
		(quitBut init:)
		(vinBut init:)
		(driverBut init:)
		(plateBut init:)
		(gGame setCursor: 999)
		(if (== gPrevRoomNum 25)
			(formBut init:)
		)
		(gTheIconBar disable:)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(script
				(script handleEvent: event)
			)
			(else
				(event claimed: 1)
			)
		)
	)

	(method (dispose)
		(if (and (== gPrevRoomNum 25) (== ((gInventory at: 23) owner:) 204)) ; license
			(gEgo get: 23) ; license
		)
		(gTheIconBar enable:)
		(super dispose:)
		(DisposeScript 131)
	)
)

(instance runVin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_2)
				(= cycles 3)
			)
			(1
				(= local2 5)
				(localproc_0 204 22 20 170 200 global125) ; "Enter vehicle ID:"
				(= local26 210)
				(= local27 170)
				(self setScript: enterCode self)
			)
			(2
				(cond
					((not (StrCmp @local6 {77668}))
						(= local5 0)
						(localproc_3)
					)
					((not (StrCmp @local6 {09823}))
						(= local5 8)
						(localproc_3)
					)
					((not (StrCmp @local6 {99947}))
						(= local5 16)
						(localproc_3)
					)
					((not (StrCmp @local6 {88996}))
						(= local5 24)
						(localproc_3)
					)
					((not (StrCmp @local6 {69444}))
						(= local5 32)
						(localproc_3)
					)
					((not (StrCmp @local6 {08996}))
						(= local5 40)
						(localproc_3)
					)
					((not (StrCmp @local6 {88116}))
						(= local5 48)
						(localproc_3)
					)
					(else
						(localproc_0 204 23 20 170 200 global125) ; "Invalid Entry"
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance runPlate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_2)
				(= cycles 3)
			)
			(1
				(= local2 5)
				(= local26 210)
				(= local27 170)
				(localproc_0 204 24 20 170 200 global125) ; "Enter vehicle license number:"
				(self setScript: enterCode self)
			)
			(2
				(cond
					((not (StrCmp @local6 {34567}))
						(= local5 0)
						(localproc_3)
					)
					((not (StrCmp @local6 {83756}))
						(= local5 8)
						(localproc_3)
					)
					((not (StrCmp @local6 {12896}))
						(SetFlag 89)
						(= local5 16)
						(localproc_3)
					)
					((not (StrCmp @local6 {22776}))
						(= local5 24)
						(localproc_3)
					)
					((not (StrCmp @local6 {01923}))
						(= local5 32)
						(localproc_3)
					)
					((not (StrCmp @local6 {84016}))
						(= local5 40)
						(localproc_3)
					)
					((not (StrCmp @local6 {22776}))
						(= local5 48)
						(localproc_3)
					)
					(else
						(localproc_0 204 23 20 170 200 global125) ; "Invalid Entry"
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance runDriver of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_2)
				(= cycles 3)
			)
			(1
				(= local2 6)
				(= local26 210)
				(= local27 170)
				(localproc_0 204 25 20 170 200 global125) ; "Enter driver's ID:"
				(self setScript: enterCode self)
			)
			(2
				(cond
					((not (StrCmp @local6 {654321}))
						(= local5 56)
						(localproc_4)
					)
					((not (StrCmp @local6 {145698}))
						(= local5 62)
						(localproc_4)
					)
					((not (StrCmp @local6 {522341}))
						(= local5 68)
						(localproc_4)
					)
					((not (StrCmp @local6 {434301}))
						(= local5 74)
						(localproc_4)
					)
					((not (StrCmp @local6 {836702}))
						(= local5 80)
						(localproc_4)
					)
					((not (StrCmp @local6 {789612}))
						(= local5 86)
						(localproc_4)
					)
					((not (StrCmp @local6 {980453}))
						(= local5 92)
						(localproc_4)
					)
					(else
						(localproc_0 204 23 20 170 200 global125) ; "Invalid Entry"
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance enterCode of Script
	(properties)

	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				(touchPad init: self)
				(= local3 0)
				(StrCpy @local6 {})
				(self register: -1)
				(= cycles 1)
				(= local4 0)
			)
			(1
				(cond
					((== local3 local2)
						(= cycles 3)
					)
					((== register -1)
						(= state 0)
						(= cycles 1)
					)
					((< register 10)
						(++ local3)
						(StrCat @local6 (Format @temp0 204 26 register)) ; "%d"
						(localproc_1)
						(self register: -1)
						(= state 0)
						(= cycles 1)
					)
				)
			)
			(2
				(touchPad dispose:)
				(if local28
					(= state 3)
				else
					(localproc_0 204 27 20 170 200 global125) ; "searching..."
				)
				(= seconds 1)
			)
			(3
				(Graph grFILL_BOX 170 20 180 160 1 0 -1 -1)
				(Graph grUPDATE_BOX 170 20 180 160 1)
				(if (< local4 3)
					(= state 1)
					(++ local4)
				)
				(= seconds 1)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance fillForm of Script
	(properties)

	(method (changeState newState &tmp [temp0 5])
		(switch (= state newState)
			(0
				(localproc_2)
				(= cycles 3)
			)
			(1
				(switch ((gInventory at: 23) state:) ; license
					(1
						(= local5 112)
						(localproc_5)
					)
					(2
						(= local5 98)
						(localproc_5)
					)
					(3
						(= local5 139)
						(localproc_5)
					)
					(4
						(Print 204 28) ; "You can't give this guy a traffic citation. He wasn't driving a car."
						(gEgo get: 23) ; license
						(gCurRoom newRoom: gPrevRoomNum)
					)
				)
				(= cycles 5)
			)
			(2
				(Graph grFILL_BOX 90 205 99 280 1 0 -1 -1)
				(Graph grUPDATE_BOX 90 205 99 280 1)
				(= local28 1)
				(= local2 2)
				(= local26 125)
				(= local27 112)
				(localproc_0 204 29 205 50 100 global125) ; "Enter Military Time"
				(self setScript: enterCode self)
			)
			(3
				(if (< (StrCmp {24} @local6) 1)
					(Graph grFILL_BOX 112 125 119 169 1 0 -1 -1)
					(Graph grUPDATE_BOX 112 125 119 169 1)
					(localproc_0 204 23 205 90 100 global125) ; "Invalid Entry"
					(= state 1)
					(= seconds 3)
				else
					(if (not (StrCmp @local6 (Format @temp0 204 26 global105))) ; "%d"
						(++ local29)
					)
					(= cycles 3)
				)
			)
			(4
				(Graph grFILL_BOX 90 205 99 280 1 0 -1 -1)
				(Graph grUPDATE_BOX 90 205 99 280 1)
				(= local28 1)
				(= local2 2)
				(= local26 138)
				(= local27 112)
				(localproc_0 204 29 205 50 100 global125) ; "Enter Military Time"
				(self setScript: enterCode self)
			)
			(5
				(if (< (StrCmp {60} @local6) 1)
					(Graph grFILL_BOX 112 139 119 169 1 0 -1 -1)
					(Graph grUPDATE_BOX 112 139 119 169 1)
					(localproc_0 204 23 205 90 100 global125) ; "Invalid Entry"
					(= seconds (= state 3))
				else
					(if (not (StrCmp @local6 (Format @temp0 204 26 global106))) ; "%d"
						(++ local29)
					)
					(= cycles 3)
				)
			)
			(6
				(= local26 90)
				(= local27 157)
				(= local2 5)
				(Graph grFILL_BOX 50 205 60 305 1 0 -1 -1)
				(Graph grUPDATE_BOX 50 205 60 305 1)
				(localproc_0 204 30 205 80 100 global125) ; "Enter vehicle code:"
				(self setScript: enterCode self)
			)
			(7
				(switch ((gInventory at: 23) state:) ; license
					(1
						(if (== local29 2)
							(SetFlag 47)
						)
						(if (not (StrCmp @local6 {21654}))
							(SetFlag 70)
							(SetScore 117 5)
						)
					)
					(2
						(if (not (StrCmp @local6 {22349}))
							(SetFlag 71)
							(SetScore 118 5)
						)
					)
					(3
						(if (not (StrCmp @local6 {23152}))
							(SetFlag 72)
						)
					)
				)
				((gInventory at: 24) owner: 25) ; ticket
				(gEgo get: 23) ; license
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance quitBut of Prop
	(properties
		x 289
		y 10
		view 197
		cel 4
		priority 15
		signal 22545
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp [temp0 2])
		(if (not (gCurRoom script:))
			(switch (event type:)
				(evKEYBOARD
					(if
						(or
							(== (event message:) KEY_q)
							(== (event message:) KEY_Q)
							(and
								(== (event message:) KEY_RETURN)
								(MousedOn self event)
							)
						)
						(self loop: 1 forceUpd:)
						(Animate (gCast elements:) 0)
						(self loop: 0 forceUpd:)
						(Animate (gCast elements:) 0)
						(gCurRoom newRoom: gPrevRoomNum)
						(event claimed: 1)
					)
				)
				(evMOUSEBUTTON
					(if (MousedOn self event)
						(self loop: 1 forceUpd:)
						(Animate (gCast elements:) 0)
						(self loop: 0 forceUpd:)
						(Animate (gCast elements:) 0)
						(gCurRoom newRoom: gPrevRoomNum)
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance vinBut of Prop
	(properties
		x 99
		y 10
		view 197
		cel 8
		priority 15
		signal 22545
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp [temp0 2])
		(if (not (gCurRoom script:))
			(switch (event type:)
				(evKEYBOARD
					(if
						(or
							(== (event message:) KEY_v)
							(== (event message:) KEY_V)
							(and
								(== (event message:) KEY_RETURN)
								(MousedOn self event)
							)
						)
						(self loop: 1 forceUpd:)
						(Animate (gCast elements:) 0)
						(gCurRoom setScript: runVin)
						(event claimed: 1)
					)
				)
				(evMOUSEBUTTON
					(if (MousedOn self event)
						(self loop: 1 forceUpd:)
						(Animate (gCast elements:) 0)
						(self loop: 0 forceUpd:)
						(Animate (gCast elements:) 0)
						(gCurRoom setScript: runVin)
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance driverBut of Prop
	(properties
		x 39
		y 10
		view 197
		cel 7
		priority 15
		signal 22545
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp [temp0 2])
		(if (not (gCurRoom script:))
			(switch (event type:)
				(evKEYBOARD
					(if
						(or
							(== (event message:) KEY_d)
							(== (event message:) KEY_D)
							(and
								(== (event message:) KEY_RETURN)
								(MousedOn self event)
							)
						)
						(self loop: 1 forceUpd:)
						(Animate (gCast elements:) 0)
						(self loop: 0 forceUpd:)
						(Animate (gCast elements:) 0)
						(gCurRoom setScript: runDriver)
						(event claimed: 1)
					)
				)
				(evMOUSEBUTTON
					(if (MousedOn self event)
						(self loop: 1 forceUpd:)
						(Animate (gCast elements:) 0)
						(self loop: 0 forceUpd:)
						(Animate (gCast elements:) 0)
						(gCurRoom setScript: runDriver)
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance plateBut of Prop
	(properties
		x 155
		y 10
		view 197
		cel 9
		priority 15
		signal 22545
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp [temp0 2])
		(if (not (gCurRoom script:))
			(switch (event type:)
				(evKEYBOARD
					(if
						(or
							(== (event message:) KEY_p)
							(== (event message:) KEY_P)
							(and
								(== (event message:) KEY_RETURN)
								(MousedOn self event)
							)
						)
						(self loop: 1 forceUpd:)
						(Animate (gCast elements:) 0)
						(self loop: 0 forceUpd:)
						(Animate (gCast elements:) 0)
						(gCurRoom setScript: runPlate)
						(event claimed: 1)
					)
				)
				(evMOUSEBUTTON
					(if (MousedOn self event)
						(self loop: 1 forceUpd:)
						(Animate (gCast elements:) 0)
						(self loop: 0 forceUpd:)
						(Animate (gCast elements:) 0)
						(gCurRoom setScript: runPlate)
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance formBut of Prop
	(properties
		x 221
		y 10
		view 197
		cel 15
		priority 15
		signal 22545
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp [temp0 2])
		(if (not (gCurRoom script:))
			(switch (event type:)
				(evKEYBOARD
					(if
						(or
							(== (event message:) KEY_f)
							(== (event message:) KEY_F)
							(and
								(== (event message:) KEY_RETURN)
								(MousedOn self event)
							)
						)
						(self loop: 1 forceUpd:)
						(Animate (gCast elements:) 0)
						(self loop: 0 forceUpd:)
						(Animate (gCast elements:) 0)
						(if (== ((gInventory at: 23) owner:) 204) ; license
							(gCurRoom setScript: fillForm)
						else
							(localproc_6)
						)
						(event claimed: 1)
					)
				)
				(evMOUSEBUTTON
					(if (MousedOn self event)
						(self loop: 1 forceUpd:)
						(Animate (gCast elements:) 0)
						(self loop: 0 forceUpd:)
						(Animate (gCast elements:) 0)
						(if (== ((gInventory at: 23) owner:) 204) ; license
							(gCurRoom setScript: fillForm)
						else
							(localproc_6)
						)
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance touchPad of Feature
	(properties)

	(method (init param1)
		(no1 init: param1 cel: 0)
		(no2 init: param1 cel: 0)
		(no3 init: param1 cel: 0)
		(no4 init: param1 cel: 0)
		(no5 init: param1 cel: 0)
		(no6 init: param1 cel: 0)
		(no7 init: param1 cel: 0)
		(no8 init: param1 cel: 0)
		(no9 init: param1 cel: 0)
		(no10 init: param1 cel: 0)
		(super init:)
	)

	(method (dispose)
		(no1 dispose:)
		(no2 dispose:)
		(no3 dispose:)
		(no4 dispose:)
		(no5 dispose:)
		(no6 dispose:)
		(no7 dispose:)
		(no8 dispose:)
		(no9 dispose:)
		(no10 dispose:)
		(super dispose:)
	)
)

(instance no1 of keyPadBut
	(properties
		x 231
		y 143
		view 198
		loop 1
		number 1
		keyEquiv 49
	)
)

(instance no2 of keyPadBut
	(properties
		x 251
		y 143
		view 198
		loop 2
		number 2
		keyEquiv 50
	)
)

(instance no3 of keyPadBut
	(properties
		x 271
		y 143
		view 198
		loop 3
		number 3
		keyEquiv 51
	)
)

(instance no4 of keyPadBut
	(properties
		x 291
		y 143
		view 198
		loop 4
		number 4
		keyEquiv 52
	)
)

(instance no5 of keyPadBut
	(properties
		x 311
		y 143
		view 198
		loop 5
		number 5
		keyEquiv 53
	)
)

(instance no6 of keyPadBut
	(properties
		x 231
		y 159
		view 198
		loop 6
		number 6
		keyEquiv 54
	)
)

(instance no7 of keyPadBut
	(properties
		x 251
		y 159
		view 198
		loop 7
		number 7
		keyEquiv 55
	)
)

(instance no8 of keyPadBut
	(properties
		x 271
		y 159
		view 198
		loop 8
		number 8
		keyEquiv 56
	)
)

(instance no9 of keyPadBut
	(properties
		x 291
		y 159
		view 198
		loop 9
		number 9
		keyEquiv 57
	)
)

(instance no10 of keyPadBut
	(properties
		x 311
		y 159
		view 198
		keyEquiv 48
	)
)

