;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 203)
(include sci.sh)
(use Main)
(use keyPadBut)
(use Interface)
(use Language)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm203 0
)

(local
	local0
	[local1 2]
	local3
	local4
	local5
	local6
	local7
	local8
	[local9 10]
)

(procedure (localproc_0 param1 param2 param3 param4 param5 param6 &tmp [temp0 200])
	(if (u< param1 1000)
		(GetFarText param1 param2 @temp0)
	else
		(StrCpy @temp0 param1)
	)
	(Display @temp0 dsCOORD param3 param4 dsALIGN alLEFT dsFONT 2 dsCOLOR param6 dsWIDTH param5)
)

(procedure (localproc_1)
	(gCurRoom style: 5 drawPic: 199)
	(mug2 dispose:)
	(conBut dispose:)
	(quitBut loop: 0 forceUpd:)
	(reviewBut loop: 0 forceUpd:)
	(newBut loop: 0 forceUpd:)
	(numBut cel: 0 forceUpd:)
)

(procedure (localproc_2 param1 param2 param3 param4 param5 &tmp [temp0 275])
	(if (u< param1 1000)
		(GetFarText param1 param2 @temp0)
	else
		(StrCpy @temp0 param1)
	)
	(if temp0
		(Display @temp0 dsCOORD param3 param4 dsALIGN alLEFT dsFONT 0 dsCOLOR 7 dsWIDTH param5)
	)
)

(procedure (localproc_3 param1 param2)
	(if local1
		(Display @local1 dsCOORD param1 param2 dsALIGN alLEFT dsFONT 0 dsCOLOR 7 dsWIDTH 40)
	)
)

(instance rm203 of Rm
	(properties
		picture 199
	)

	(method (init)
		(super init:)
		(Load rsVIEW (LangSwitch 197 1971))
		(quitBut view: (LangSwitch 197 1971) x: (LangSwitch 289 307) init:)
		(reviewBut view: (LangSwitch 197 1971) x: (LangSwitch 48 51) init:)
		(newBut view: (LangSwitch 197 1971) x: (LangSwitch 151 144) init:)
		(numBut view: (LangSwitch 197 1971) x: (LangSwitch 204 202) init:)
		(gTheIconBar disable:)
		(gGame setCursor: 999)
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
		(gTheIconBar enable:)
		(super dispose:)
		(DisposeScript 131)
	)
)

(instance searchForCase of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1)
				(= cycles 3)
			)
			(1
				(reviewBut loop: 0 forceUpd:)
				(touchPad init: self)
				(= local0 0)
				(StrCpy @local1 {})
				(self register: -1)
				(localproc_2 203 0 30 40 200) ; "Enter case number:"
				(= cycles 1)
				(= local5 0)
			)
			(2
				(cond
					((== local0 6)
						(= cycles 4)
					)
					((== register -1)
						(= cycles (= state 1))
					)
					((< register 10)
						(++ local0)
						(StrCat @local1 (Format @local9 203 1 register)) ; "%d"
						(localproc_3 160 40)
						(self register: -1)
						(= cycles (= state 1))
					)
				)
			)
			(3
				(touchPad dispose:)
				(localproc_2 203 2 20 170 200) ; "searching..."
				(= seconds 1)
			)
			(4
				(Graph grFILL_BOX 170 20 180 100 1 0 -1 -1)
				(Graph grUPDATE_BOX 170 20 180 100 1)
				(if (< local5 3)
					(= state 2)
					(++ local5)
				)
				(= seconds 1)
			)
			(5
				(cond
					((not (StrCmp @local1 {199124}))
						(= local6 0)
						(gCurRoom setScript: displayCase self)
					)
					((not (StrCmp @local1 {199137}))
						(SetFlag 77)
						(= global105 14)
						(= global106 0)
						(= local6 12)
						(gCurRoom setScript: displayCase self)
					)
					((not (StrCmp @local1 {199144}))
						(if (IsFlag 73)
							(SetFlag 78)
							(= global105 14)
							(= global106 0)
							(= local6 24)
							(gCurRoom setScript: displayMarie self)
						else
							(localproc_2 203 3 20 170 200) ; "Invalid Entry"
							(= cycles 1)
						)
					)
					((not (StrCmp @local1 {199145}))
						(if (IsFlag 80)
							(= local6 37)
							(gCurRoom setScript: displayDent self)
						else
							(localproc_2 203 3 20 170 200) ; "Invalid Entry"
							(= cycles 1)
						)
					)
					(else
						(localproc_2 203 3 20 170 200) ; "Invalid Entry"
						(= cycles 1)
					)
				)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance displayCase of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1)
				(= cycles 3)
			)
			(1
				(if local8
					(localproc_0 203 4 10 20 150 (proc0_15 global122 global121)) ; "- EVIDENCE/ANALYSIS -"
					(localproc_0 504 54 50 40 250 global125) ; "- Stolen property, Military Bronze Star, serial number 09987"
				else
					(localproc_0 203 5 10 20 100 (proc0_15 global122 global121)) ; "VICTIM -"
					(localproc_0
						504
						local6
						(LangSwitch 50 48)
						20
						(LangSwitch 250 260)
						global125
					)
					(localproc_0 203 6 10 30 100 (proc0_15 global122 global121)) ; "LOCATION -"
					(localproc_0
						504
						(+ local6 1)
						(LangSwitch 62 57)
						30
						200
						global125
					)
					(localproc_0 ; "SUSPECT -"
						203
						7
						(LangSwitch 190 185)
						30
						(LangSwitch 100 70)
						(proc0_15 global122 global121)
					)
					(localproc_0
						504
						(+ 5 local6)
						(LangSwitch 239 290)
						30
						(LangSwitch 40 60)
						global125
					)
					(localproc_0 203 8 10 40 100 (proc0_15 global122 global121)) ; "DATE -"
					(localproc_0
						504
						(+ 2 local6)
						(LangSwitch 45 50)
						40
						100
						global125
					)
					(localproc_0 203 9 92 40 50 (proc0_15 global122 global121)) ; "TIME -"
					(localproc_0
						504
						(+ 3 local6)
						(LangSwitch 127 125)
						40
						30
						global125
					)
					(localproc_0 ; "INVESTIGATOR -"
						203
						10
						(LangSwitch 165 155)
						40
						150
						(proc0_15 global122 global121)
					)
					(localproc_0
						504
						(+ 4 local6)
						(LangSwitch 250 214)
						40
						60
						global125
					)
					(Graph grDRAW_LINE 50 0 50 320 54 -1 -1)
					(Graph grUPDATE_BOX 49 0 51 320 1)
					(localproc_0 ; "CAUSE OF DEATH -"
						203
						11
						10
						55
						100
						(proc0_15 global122 global121)
					)
					(localproc_0
						504
						(+ 6 local6)
						(LangSwitch 95 85)
						55
						(LangSwitch 215 225)
						global125
					)
					(localproc_0 ; "WEAPON USED -"
						203
						12
						10
						(LangSwitch 70 73)
						100
						(proc0_15 global122 global121)
					)
					(localproc_0
						504
						(+ 7 local6)
						(LangSwitch 10 40)
						(LangSwitch 70 73)
						(LangSwitch 300 270)
						global125
					)
					(localproc_0 ; "- EVIDENCE/ANALYSIS -"
						203
						4
						100
						90
						150
						(proc0_15 global122 global121)
					)
					(localproc_0 504 (+ 8 local6) 10 100 300 global125)
					(localproc_0
						504
						(+ 9 local6)
						10
						(LangSwitch 120 124)
						300
						global125
					)
					(localproc_0 ; "SUMMARY -"
						203
						13
						10
						(LangSwitch 145 149)
						100
						(proc0_15 global122 global121)
					)
					(localproc_0
						504
						(+ 10 local6)
						(LangSwitch 10 40)
						(LangSwitch 145 149)
						(LangSwitch 300 270)
						global125
					)
					(localproc_0 ; "MOTIVE -"
						203
						14
						10
						(LangSwitch 170 174)
						100
						(proc0_15 global122 global121)
					)
					(localproc_0
						504
						(+ 11 local6)
						(LangSwitch 60 50)
						(LangSwitch 170 174)
						(LangSwitch 250 260)
						global125
					)
				)
				(conBut x: (LangSwitch 293 307) view: (LangSwitch 197 1971) init:)
				(self dispose:)
			)
		)
	)
)

(instance displayMarie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1)
				(= cycles 3)
			)
			(1
				(if local8
					(localproc_0 203 4 10 20 150 (proc0_15 global122 global121)) ; "- EVIDENCE/ANALYSIS -"
					(if (== global145 3)
						(localproc_0 504 50 10 40 250 global125) ; "- Blood and hair sample found on the floor inside apparent altar setup."
					)
					(if (== global146 3)
						(localproc_0 504 51 10 60 250 global125) ; "- Black insignia ring with pentagram design. Found on hand of Steve Rocklin, murder suspect."
					)
					(if (== global147 3)
						(localproc_0 504 52 10 80 250 global125) ; "- Black cult book with pentagram design on cover. Found on body of Steve Rocklin, murder suspect."
					)
					(if (== global148 3)
						(localproc_0 504 53 10 100 250 global125) ; "- White paint transfer found on car of Steve Rocklin."
					)
					(if (== global149 3)
						(localproc_0 504 54 10 120 250 global125) ; "- Stolen property, Military Bronze Star, serial number 09987"
					)
				else
					(localproc_0 203 5 10 20 100 (proc0_15 global122 global121)) ; "VICTIM -"
					(localproc_0 504 local6 50 20 250 global125)
					(localproc_0 203 6 10 30 100 (proc0_15 global122 global121)) ; "LOCATION -"
					(localproc_0
						504
						(+ local6 1)
						(LangSwitch 62 57)
						30
						200
						global125
					)
					(localproc_0 ; "SUSPECT -"
						203
						7
						(LangSwitch 190 180)
						30
						(LangSwitch 100 70)
						(proc0_15 global122 global121)
					)
					(if (IsFlag 74)
						(localproc_0
							504
							(+ 12 local6)
							(LangSwitch 239 285)
							30
							(LangSwitch 70 65)
							global125
						)
					else
						(localproc_0
							504
							(+ 5 local6)
							(LangSwitch 239 285)
							30
							(LangSwitch 40 65)
							global125
						)
					)
					(localproc_0 203 8 10 40 100 (proc0_15 global122 global121)) ; "DATE -"
					(localproc_0
						504
						(+ 2 local6)
						(LangSwitch 45 48)
						40
						100
						global125
					)
					(localproc_0 203 9 92 40 50 (proc0_15 global122 global121)) ; "TIME -"
					(localproc_0
						504
						(+ 3 local6)
						(LangSwitch 127 123)
						40
						30
						global125
					)
					(localproc_0 ; "INVESTIGATOR -"
						203
						10
						(LangSwitch 165 150)
						40
						(LangSwitch 150 165)
						(proc0_15 global122 global121)
					)
					(localproc_0
						504
						(+ 4 local6)
						(LangSwitch 250 210)
						40
						(LangSwitch 60 100)
						global125
					)
					(Graph grDRAW_LINE 50 0 50 320 54 -1 -1)
					(Graph grUPDATE_BOX 49 0 51 320 1)
					(localproc_0 ; "DISPOSITION -"
						203
						15
						10
						55
						100
						(proc0_15 global122 global121)
					)
					(localproc_0
						504
						(+ 6 local6)
						(LangSwitch 95 75)
						55
						(LangSwitch 215 235)
						global125
					)
					(localproc_0 ; "WEAPON USED -"
						203
						12
						10
						(LangSwitch 70 73)
						100
						(proc0_15 global122 global121)
					)
					(localproc_0
						504
						(+ 7 local6)
						(LangSwitch 10 15)
						(LangSwitch 70 73)
						300
						global125
					)
					(localproc_0 ; "- EVIDENCE/ANALYSIS -"
						203
						4
						100
						90
						150
						(proc0_15 global122 global121)
					)
					(if (IsFlag 75)
						(localproc_0 504 (+ 8 local6) 10 100 300 global125)
					)
					(if (IsFlag 76)
						(localproc_0
							504
							(+ 9 local6)
							10
							(LangSwitch 120 116)
							300
							global125
						)
					)
					(localproc_0 ; "SUMMARY -"
						203
						13
						10
						(LangSwitch 145 141)
						100
						(proc0_15 global122 global121)
					)
					(localproc_0
						504
						(+ 10 local6)
						(LangSwitch 10 40)
						(LangSwitch 145 141)
						(LangSwitch 300 250)
						global125
					)
					(localproc_0 ; "MOTIVE -"
						203
						14
						10
						(LangSwitch 170 173)
						100
						(proc0_15 global122 global121)
					)
					(localproc_0
						504
						(+ 11 local6)
						60
						(LangSwitch 170 173)
						250
						global125
					)
				)
				(= cycles 1)
			)
			(2
				(conBut x: (LangSwitch 293 307) view: (LangSwitch 197 1971) init:)
				(self dispose:)
			)
		)
	)
)

(instance displayDent of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1)
				(= cycles 3)
			)
			(1
				(if local8
					(localproc_0 203 4 10 20 150 (proc0_15 global122 global121)) ; "- EVIDENCE/ANALYSIS -"
					(if (== global145 4)
						(localproc_0 504 50 10 40 250 global125) ; "- Blood and hair sample found on the floor inside apparent altar setup."
					)
					(if (== global146 4)
						(localproc_0 504 51 10 60 250 global125) ; "- Black insignia ring with pentagram design. Found on hand of Steve Rocklin, murder suspect."
					)
					(if (== global147 4)
						(localproc_0 504 52 10 80 250 global125) ; "- Black cult book with pentagram design on cover. Found on body of Steve Rocklin, murder suspect."
					)
					(if (== global148 4)
						(localproc_0 504 53 10 100 250 global125) ; "- White paint transfer found on car of Steve Rocklin."
					)
					(if (== global149 4)
						(localproc_0 504 54 10 120 250 global125) ; "- Stolen property, Military Bronze Star, serial number 09987"
					)
					(if (and (== global143 4) (>= gDay 5))
						(= global150 0)
						(SetFlag 32)
						(if (IsFlag 2)
							(localproc_0 504 55 10 140 250 global125) ; "- Gold paint transfer analysis shows car to be used on General Motors sedan models, 1976."
						else
							(localproc_0
								{- Light red paint transfer analysis shows car to be used on General Motors sedan models, 1976.}
								0
								10
								140
								250
								global125
							)
						)
					)
					(if (== gDay 6)
						(= global150 0)
						(localproc_0 504 56 10 160 250 global125) ; "- Four one-pound packets of cocaine."
					)
				else
					(localproc_0 203 5 10 20 100 (proc0_15 global122 global121)) ; "VICTIM -"
					(localproc_0 504 local6 50 20 250 global125)
					(localproc_0 203 6 10 30 100 (proc0_15 global122 global121)) ; "LOCATION -"
					(localproc_0
						504
						(+ local6 1)
						(LangSwitch 62 57)
						30
						200
						global125
					)
					(localproc_0 ; "SUSPECT -"
						203
						7
						(LangSwitch 190 180)
						30
						(LangSwitch 100 70)
						(proc0_15 global122 global121)
					)
					(localproc_0
						504
						(+ 5 local6)
						(LangSwitch 239 255)
						30
						(LangSwitch 70 60)
						global125
					)
					(localproc_0 203 8 10 40 100 (proc0_15 global122 global121)) ; "DATE -"
					(localproc_0 504 (+ 2 local6) 45 40 100 global125)
					(localproc_0 ; "TIME -"
						203
						9
						(LangSwitch 92 87)
						40
						50
						(proc0_15 global122 global121)
					)
					(localproc_0
						504
						(+ 3 local6)
						(LangSwitch 127 122)
						40
						30
						global125
					)
					(localproc_0 ; "INVESTIGATOR -"
						203
						10
						(LangSwitch 165 150)
						40
						(LangSwitch 150 165)
						(proc0_15 global122 global121)
					)
					(localproc_0
						504
						(+ 4 local6)
						(LangSwitch 250 210)
						40
						(LangSwitch 60 70)
						global125
					)
					(Graph grDRAW_LINE 50 0 50 320 54 -1 -1)
					(Graph grUPDATE_BOX 49 0 51 320 1)
					(localproc_0 ; "DISPOSITION -"
						203
						15
						10
						55
						100
						(proc0_15 global122 global121)
					)
					(localproc_0 504 (+ 6 local6) 95 55 215 global125)
					(localproc_0 ; "WEAPON USED -"
						203
						12
						10
						70
						100
						(proc0_15 global122 global121)
					)
					(localproc_0
						504
						(+ 7 local6)
						(LangSwitch 10 55)
						70
						(LangSwitch 300 255)
						global125
					)
					(localproc_0 ; "- EVIDENCE/ANALYSIS -"
						203
						4
						100
						90
						150
						(proc0_15 global122 global121)
					)
					(if (== global143 4)
						(if (IsFlag 2)
							(localproc_0 504 (+ 8 local6) 10 100 300 global125)
						else
							(localproc_0
								{- Paint transfers, light red, possibly from suspect vehicle.}
								0
								10
								100
								250
								global125
							)
						)
					)
					(if (== global144 4)
						(localproc_0 504 (+ 9 local6) 10 120 300 global125)
					)
					(localproc_0 ; "SUMMARY -"
						203
						13
						10
						145
						100
						(proc0_15 global122 global121)
					)
					(localproc_0
						504
						(+ 10 local6)
						(LangSwitch 10 55)
						145
						(LangSwitch 300 255)
						global125
					)
					(localproc_0 ; "MOTIVE -"
						203
						14
						10
						170
						100
						(proc0_15 global122 global121)
					)
					(localproc_0 504 (+ 11 local6) 60 170 250 global125)
				)
				(= cycles 1)
			)
			(2
				(conBut x: (LangSwitch 293 307) view: (LangSwitch 197 1971) init:)
				(self dispose:)
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
		(gDirectionHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(gDirectionHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp [temp0 2])
		(switch (event type:)
			(evKEYBOARD
				(if
					(or
						(== (event message:) (LangSwitch 113 101))
						(== (event message:) (LangSwitch 81 69))
						(and (== (event message:) KEY_RETURN) (MousedOn self event))
					)
					(self loop: 1 forceUpd:)
					(Animate (gCast elements:) 0)
					(gCurRoom newRoom: gPrevRoomNum)
					(event claimed: 1)
				)
			)
			(evMOUSEBUTTON
				(if (MousedOn self event)
					(self loop: 1 forceUpd:)
					(Animate (gCast elements:) 0)
					(gCurRoom newRoom: gPrevRoomNum)
					(event claimed: 1)
				)
			)
			($0044 ; direction | evKEYBOARD
				(if (== ((gTheIconBar curIcon:) message:) 1)
					(switch (event message:)
						(JOY_UP
							(if (> local4 5)
								(-= local4 10)
							)
						)
						(JOY_DOWN
							(if (< local4 175)
								(+= local4 10)
							)
						)
						(JOY_RIGHT
							(if (< local3 280)
								(+= local3 100)
							)
						)
						(JOY_LEFT
							(if (> local3 80)
								(-= local3 100)
							)
						)
					)
					(SetCursor 999 1 local3 local4)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance newBut of Prop
	(properties
		x 151
		y 10
		view 197
		cel 6
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
		(switch (event type:)
			(evKEYBOARD
				(if
					(or
						(== (event message:) KEY_n)
						(== (event message:) KEY_N)
						(and (== (event message:) KEY_RETURN) (MousedOn self event))
					)
					(self loop: 1 forceUpd:)
					(Animate (gCast elements:) 0)
					(localproc_1)
					(self loop: 0 forceUpd:)
					(Animate (gCast elements:) 0)
					(if (IsFlag 87)
						(localproc_2 203 16 20 20 200) ; "New Case Number: 199146"
					else
						(localproc_2 203 17 20 20 200) ; "New Case Number: 199145"
						(Animate (gCast elements:) 0)
						(Wait 60)
						(if (IsFlag 80)
							(Print 203 18) ; "Based on the information you obtained at the murder scene, you open up a new file on the Dent murder."
							(StrCpy @local1 {199145})
							(SetFlag 87)
							(SetScore 156 1)
							(= local6 37)
							(gCurRoom setScript: displayDent)
						)
					)
					(event claimed: 1)
				)
			)
			(evMOUSEBUTTON
				(if (and (MousedOn self event) (not (gCurRoom script:)))
					(self loop: 1 forceUpd:)
					(Animate (gCast elements:) 0)
					(localproc_1)
					(self loop: 0 forceUpd:)
					(Animate (gCast elements:) 0)
					(if (IsFlag 87)
						(localproc_2 203 16 20 20 200) ; "New Case Number: 199146"
					else
						(localproc_2 203 17 20 20 200) ; "New Case Number: 199145"
						(Animate (gCast elements:) 0)
						(Wait 60)
						(if (IsFlag 80)
							(Print 203 18) ; "Based on the information you obtained at the murder scene, you open up a new file on the Dent murder."
							(StrCpy @local1 {199145})
							(SetFlag 87)
							(SetScore 156 1)
							(= local6 37)
							(gCurRoom setScript: displayDent)
						)
					)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance reviewBut of Prop
	(properties
		x 48
		y 10
		view 197
		cel 5
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
							(== (event message:) (LangSwitch 114 97))
							(== (event message:) (LangSwitch 82 65))
							(and
								(== (event message:) KEY_RETURN)
								(MousedOn self event)
							)
						)
						(conBut
							x: (LangSwitch 293 307)
							view: (LangSwitch 197 1971)
							cel: 0
						)
						(= local8 0)
						(self loop: 1 forceUpd:)
						(Animate (gCast elements:) 0)
						(gCurRoom setScript: searchForCase)
						(event claimed: 1)
					)
				)
				(evMOUSEBUTTON
					(if (MousedOn self event)
						(conBut
							x: (LangSwitch 293 307)
							view: (LangSwitch 197 1971)
							cel: 0
						)
						(= local8 0)
						(self loop: 1 forceUpd:)
						(Animate (gCast elements:) 0)
						(gCurRoom setScript: searchForCase)
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance numBut of Prop
	(properties
		x 204
		y 10
		view 197
		loop 3
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
							(== (event message:) KEY_s)
							(== (event message:) KEY_S)
							(and
								(== (event message:) KEY_RETURN)
								(MousedOn self event)
							)
						)
						(= local7 5)
						(self setCycle: Beg)
						(gCurRoom setScript: enterCode)
						(event claimed: 1)
					)
				)
				(evMOUSEBUTTON
					(if (MousedOn self event)
						(= local7 5)
						(self setCycle: Beg)
						(gCurRoom setScript: enterCode)
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
		(no1 init: param1)
		(no2 init: param1)
		(no3 init: param1)
		(no4 init: param1)
		(no5 init: param1)
		(no6 init: param1)
		(no7 init: param1)
		(no8 init: param1)
		(no9 init: param1)
		(no10 init: param1)
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
		y 73
		view 198
		loop 1
		number 1
		keyEquiv 49
		soundNum 922
	)
)

(instance no2 of keyPadBut
	(properties
		x 251
		y 73
		view 198
		loop 2
		number 2
		keyEquiv 50
		soundNum 923
	)
)

(instance no3 of keyPadBut
	(properties
		x 271
		y 73
		view 198
		loop 3
		number 3
		keyEquiv 51
		soundNum 924
	)
)

(instance no4 of keyPadBut
	(properties
		x 291
		y 73
		view 198
		loop 4
		number 4
		keyEquiv 52
		soundNum 925
	)
)

(instance no5 of keyPadBut
	(properties
		x 311
		y 73
		view 198
		loop 5
		number 5
		keyEquiv 53
		soundNum 926
	)
)

(instance no6 of keyPadBut
	(properties
		x 231
		y 89
		view 198
		loop 6
		number 6
		keyEquiv 54
		soundNum 927
	)
)

(instance no7 of keyPadBut
	(properties
		x 251
		y 89
		view 198
		loop 7
		number 7
		keyEquiv 55
		soundNum 928
	)
)

(instance no8 of keyPadBut
	(properties
		x 271
		y 89
		view 198
		loop 8
		number 8
		keyEquiv 56
		soundNum 929
	)
)

(instance no9 of keyPadBut
	(properties
		x 291
		y 89
		view 198
		loop 9
		number 9
		keyEquiv 57
		soundNum 930
	)
)

(instance no10 of keyPadBut
	(properties
		x 311
		y 89
		view 198
		keyEquiv 48
		soundNum 931
	)
)

(instance enterCode of Script
	(properties)

	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				(localproc_1)
				(= cycles 3)
			)
			(1
				(touchPad init: self)
				(= local0 0)
				(StrCpy @local1 {})
				(self register: -1)
				(localproc_2 203 19 30 40 200) ; "Enter serial number:"
				(= cycles 1)
				(= local5 0)
			)
			(2
				(cond
					((== local0 local7)
						(= cycles 4)
					)
					((== register -1)
						(= cycles (= state 1))
					)
					((< register 10)
						(++ local0)
						(StrCat @local1 (Format @temp0 203 1 register)) ; "%d"
						(localproc_3 160 40)
						(self register: -1)
						(= cycles (= state 1))
					)
				)
			)
			(3
				(touchPad dispose:)
				(localproc_0 203 2 20 170 200 global125) ; "searching..."
				(= seconds 1)
			)
			(4
				(Graph grFILL_BOX 170 20 180 100 1 0 -1 -1)
				(Graph grUPDATE_BOX 170 20 180 100 1)
				(if (< local5 3)
					(= state 2)
					(++ local5)
				)
				(= seconds 1)
			)
			(5
				(cond
					((not (StrCmp @local1 {09987}))
						(self setScript: displayStar self)
					)
					((not (StrCmp @local1 {98765}))
						(mug2 init:)
						(localproc_2 203 20 100 20 70) ; "Steve Rocklin"
						(localproc_2 203 21 100 30 100) ; "M/W 6'2" 210 red/hzl"
						(localproc_2 203 22 100 40 100) ; "d.o.b. 1/10/50."
						(localproc_2 203 23 100 50 100) ; "Address Jan/89"
						(localproc_2 203 24 100 60 100) ; "214 Pigeon Ct."
						(localproc_2 203 25 100 70 100) ; "Gibbon U.S.A."
						(localproc_2 203 26 100 90 100) ; "SUMMARY"
						(localproc_2 203 27 10 110 250) ; "Convicted on two counts of burglary 6/23/85. Sentenced to 5 years in state penitentiary. Paroled 6/25/88 and is currently serving 3 years probation."
						(localproc_2 203 28 100 140 65) ; "NO WANTS"
						(localproc_2 203 29 10 150 250) ; "NOTE: Rocklin associates with, and at one time was known to be a member of the cult "Sons of Darkness." It is suspicioned the cult deals in the sale of "crack" cocaine."
						(= cycles 1)
					)
					(else
						(localproc_2 203 30 20 170 70) ; "No Match"
						(= cycles 1)
					)
				)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance mug2 of Prop
	(properties
		x 47
		y 105
		view 810
		loop 1
		cel 1
		priority 15
		signal 22545
	)
)

(instance displayStar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1)
				(= cycles 3)
			)
			(1
				(localproc_0 203 31 10 20 300 global125) ; "U.S. Army Bronze Star"
				(localproc_0 203 32 10 30 300 global125) ; "Awarded to Samuel Britt, Infantry"
				(localproc_0 203 33 10 40 300 global125) ; "For meritorious Service during WWII."
				(= seconds 8)
			)
			(2
				(localproc_0 203 34 10 100 300 global125) ; "Samuel Britt murder victim"
				(localproc_0 203 35 10 110 300 global125) ; "See case number #199124"
				(SetScore 130 5)
				(self dispose:)
			)
		)
	)
)

(instance conBut of Prop
	(properties
		x 293
		y 186
		view 197
		loop 4
		priority 15
		signal 22544
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
							(and
								(or
									(== (event message:) (LangSwitch 99 119))
									(== (event message:) (LangSwitch 67 87))
								)
								(== local8 0)
							)
							(and
								(or
									(== (event message:) (LangSwitch 112 122))
									(== (event message:) (LangSwitch 80 90))
								)
								(== local8 1)
							)
							(and
								(== (event message:) KEY_RETURN)
								(MousedOn self event)
							)
						)
						(if local8
							(= local8 0)
							(self cel: 0)
						else
							(= local8 1)
							(self cel: 1)
						)
						(cond
							((not (StrCmp @local1 {199124}))
								(= local6 0)
								(gCurRoom setScript: displayCase)
							)
							((not (StrCmp @local1 {199137}))
								(= local6 12)
								(gCurRoom setScript: displayCase)
							)
							((not (StrCmp @local1 {199144}))
								(= local6 24)
								(gCurRoom setScript: displayMarie)
							)
							((not (StrCmp @local1 {199145}))
								(= local6 37)
								(gCurRoom setScript: displayDent)
							)
						)
						(event claimed: 1)
					)
				)
				(evMOUSEBUTTON
					(if (MousedOn self event)
						(if local8
							(= local8 0)
							(self cel: 0)
						else
							(= local8 1)
							(self cel: 1)
						)
						(cond
							((not (StrCmp @local1 {199124}))
								(= local6 0)
								(gCurRoom setScript: displayCase)
							)
							((not (StrCmp @local1 {199137}))
								(= local6 12)
								(gCurRoom setScript: displayCase)
							)
							((not (StrCmp @local1 {199144}))
								(= local6 24)
								(gCurRoom setScript: displayMarie)
							)
							((not (StrCmp @local1 {199145}))
								(= local6 37)
								(gCurRoom setScript: displayDent)
							)
						)
						(event claimed: 1)
					)
				)
			)
		)
	)
)

