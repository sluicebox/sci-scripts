;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 204)
(include sci.sh)
(use Main)
(use keyPadBut)
(use Interface)
(use Language)
(use Feature)
(use Game)
(use Actor)
(use System)

(public
	rmDmv 0
)

(local
	local0
	local1
	local2
	local3
	[local4 20]
	local24
	local25
	local26
	local27
)

(procedure (localproc_0 param1 param2 param3 param4 param5 param6 &tmp [temp0 100])
	(if (u< param1 1000)
		(GetFarText param1 param2 @temp0)
	else
		(StrCpy @temp0 param1)
	)
	(Display @temp0 dsCOORD param3 param4 dsALIGN alLEFT dsFONT 0 dsCOLOR param6 dsWIDTH param5)
)

(procedure (localproc_1)
	(if local4
		(Display @local4 dsCOORD local24 local25 dsALIGN alLEFT dsFONT 0 dsCOLOR 7 dsWIDTH 110)
	)
)

(procedure (localproc_2)
	(gCurRoom style: 5 drawPic: 199)
	(quitBut loop: 0 forceUpd:)
	(plateBut loop: 0 forceUpd:)
	(driverBut loop: 0 forceUpd:)
	(vinBut loop: 0 forceUpd:)
)

(procedure (localproc_3 &tmp [temp0 250] [temp250 40] [temp290 40] [temp330 40] [temp370 40] [temp410 45])
	(localproc_0 204 0 20 170 200 global125) ; "Identified"
	(GetFarText 501 local3 @temp250)
	(GetFarText 501 (+ 1 local3) @temp290)
	(GetFarText 501 (+ 2 local3) @temp330)
	(GetFarText 501 (+ 3 local3) @temp370)
	(GetFarText 501 (+ 4 local3) @temp410)
	(if 1
		(= global186 (Memory memALLOC_CRIT (StrLen @temp250)))
		(= global187 (Memory memALLOC_CRIT (StrLen @temp290)))
		(= global188 (Memory memALLOC_CRIT (StrLen @temp330)))
		(= global189 (Memory memALLOC_CRIT (StrLen @temp370)))
		(= global190 (Memory memALLOC_CRIT (StrLen @temp410)))
		(= global192 (Memory memALLOC_CRIT (StrLen @temp250)))
		(= global193 (Memory memALLOC_CRIT (StrLen @temp290)))
		(= global194 (Memory memALLOC_CRIT (StrLen @temp330)))
		(= global195 (Memory memALLOC_CRIT (StrLen @temp370)))
		(= global196 (Memory memALLOC_CRIT (StrLen @temp410)))
		(StrSplitInTwo global186 global192 @temp250)
		(StrSplitInTwo global187 global193 @temp290)
		(StrSplitInTwo global188 global194 @temp330)
		(StrSplitInTwo global189 global195 @temp370)
		(StrSplitInTwo global190 global196 @temp410)
		(Format ; "%s%s %s%s%s"
			@temp0
			204
			1
			global186
			global187
			global188
			global189
			global190
			global192
			global193
			global194
			global195
			global196
		)
		(Memory memFREE global186)
		(Memory memFREE global187)
		(Memory memFREE global188)
		(Memory memFREE global189)
		(Memory memFREE global190)
		(Memory memFREE global192)
		(Memory memFREE global193)
		(Memory memFREE global194)
		(Memory memFREE global195)
		(Memory memFREE global196)
	)
	(Display @temp0 dsCOORD 30 60 dsALIGN alLEFT dsFONT 0 dsCOLOR 7 dsWIDTH 300)
	(GetFarText 501 (+ 5 local3) @temp250)
	(GetFarText 501 (+ 6 local3) @temp290)
	(GetFarText 501 (+ 7 local3) @temp330)
	(if 1
		(= global186 (Memory memALLOC_CRIT (StrLen @temp250)))
		(= global187 (Memory memALLOC_CRIT (StrLen @temp290)))
		(= global188 (Memory memALLOC_CRIT (StrLen @temp330)))
		(= global192 (Memory memALLOC_CRIT (StrLen @temp250)))
		(= global193 (Memory memALLOC_CRIT (StrLen @temp290)))
		(= global194 (Memory memALLOC_CRIT (StrLen @temp330)))
		(StrSplitInTwo global186 global192 @temp250)
		(StrSplitInTwo global187 global193 @temp290)
		(StrSplitInTwo global188 global194 @temp330)
		(Format ; "%s %s %s"
			@temp0
			204
			2
			global186
			global187
			global188
			global192
			global193
			global194
		)
		(Memory memFREE global186)
		(Memory memFREE global187)
		(Memory memFREE global188)
		(Memory memFREE global192)
		(Memory memFREE global193)
		(Memory memFREE global194)
	)
	(Display @temp0 dsCOORD 30 100 dsALIGN alLEFT dsFONT 0 dsCOLOR 7 dsWIDTH 100)
)

(procedure (localproc_4 &tmp [temp0 250] [temp250 40] [temp290 40] [temp330 40] [temp370 40] [temp410 40] [temp450 45])
	(localproc_0 204 0 20 170 200 global125) ; "Identified"
	(GetFarText 501 local3 @temp250)
	(GetFarText 501 (+ 1 local3) @temp290)
	(GetFarText 501 (+ 2 local3) @temp330)
	(GetFarText 501 (+ 3 local3) @temp370)
	(GetFarText 501 (+ 4 local3) @temp410)
	(GetFarText 501 (+ 5 local3) @temp450)
	(if 1
		(= global186 (Memory memALLOC_CRIT (StrLen @temp250)))
		(= global187 (Memory memALLOC_CRIT (StrLen @temp290)))
		(= global188 (Memory memALLOC_CRIT (StrLen @temp330)))
		(= global189 (Memory memALLOC_CRIT (StrLen @temp370)))
		(= global190 (Memory memALLOC_CRIT (StrLen @temp410)))
		(= global191 (Memory memALLOC_CRIT (StrLen @temp450)))
		(= global192 (Memory memALLOC_CRIT (StrLen @temp250)))
		(= global193 (Memory memALLOC_CRIT (StrLen @temp290)))
		(= global194 (Memory memALLOC_CRIT (StrLen @temp330)))
		(= global195 (Memory memALLOC_CRIT (StrLen @temp370)))
		(= global196 (Memory memALLOC_CRIT (StrLen @temp410)))
		(= global197 (Memory memALLOC_CRIT (StrLen @temp450)))
		(StrSplitInTwo global186 global192 @temp250)
		(StrSplitInTwo global187 global193 @temp290)
		(StrSplitInTwo global188 global194 @temp330)
		(StrSplitInTwo global189 global195 @temp370)
		(StrSplitInTwo global190 global196 @temp410)
		(StrSplitInTwo global191 global197 @temp450)
		(Format ; "%s %s %s %s %s %s"
			@temp0
			204
			3
			global186
			global187
			global188
			global189
			global190
			global191
			global192
			global193
			global194
			global195
			global196
			global197
		)
		(Memory memFREE global186)
		(Memory memFREE global187)
		(Memory memFREE global188)
		(Memory memFREE global189)
		(Memory memFREE global190)
		(Memory memFREE global191)
		(Memory memFREE global192)
		(Memory memFREE global193)
		(Memory memFREE global194)
		(Memory memFREE global195)
		(Memory memFREE global196)
		(Memory memFREE global197)
	)
	(Display @temp0 dsCOORD 30 60 dsALIGN alLEFT dsFONT 0 dsCOLOR 7 dsWIDTH 300)
)

(procedure (localproc_5)
	(Graph grDRAW_LINE 15 20 15 (LangSwitch 170 175) 54 -1 -1)
	(Graph grDRAW_LINE 15 20 165 20 54 -1 -1)
	(Graph grDRAW_LINE 15 (LangSwitch 170 175) 165 (LangSwitch 170 175) 54 -1 -1)
	(Graph grDRAW_LINE 165 20 165 (LangSwitch 170 175) 54 -1 -1)
	(Graph grDRAW_LINE 29 20 29 (LangSwitch 170 175) 54 -1 -1)
	(Graph grDRAW_LINE 30 20 30 (LangSwitch 170 175) 54 -1 -1)
	(Graph grDRAW_LINE 31 20 31 (LangSwitch 170 175) 54 -1 -1)
	(Graph grDRAW_LINE 45 20 45 (LangSwitch 170 175) 54 -1 -1)
	(Graph grDRAW_LINE 60 20 60 (LangSwitch 170 175) 54 -1 -1)
	(Graph grDRAW_LINE 75 20 75 (LangSwitch 170 175) 54 -1 -1)
	(Graph grDRAW_LINE 90 20 90 (LangSwitch 170 175) 54 -1 -1)
	(Graph grDRAW_LINE 75 (LangSwitch 83 77) 90 (LangSwitch 83 77) 54 -1 -1)
	(Graph grDRAW_LINE 75 (LangSwitch 120 125) 90 (LangSwitch 120 125) 54 -1 -1)
	(Graph grDRAW_LINE 105 20 105 (LangSwitch 170 175) 54 -1 -1)
	(Graph grDRAW_LINE 90 (LangSwitch 71 86) 105 (LangSwitch 71 86) 54 -1 -1)
	(Graph grDRAW_LINE 90 (LangSwitch 114 130) 105 (LangSwitch 114 130) 54 -1 -1)
	(Graph grDRAW_LINE 120 20 120 (LangSwitch 170 175) 54 -1 -1)
	(Graph grDRAW_LINE 105 92 120 92 54 -1 -1)
	(Graph grDRAW_LINE 135 20 135 (LangSwitch 170 175) 54 -1 -1)
	(Graph grDRAW_LINE 120 79 135 79 54 -1 -1)
	(Graph grDRAW_LINE 150 20 150 (LangSwitch 170 175) 54 -1 -1)
	(Graph grDRAW_LINE 135 90 150 90 54 -1 -1)
	(Graph grDRAW_LINE 165 20 165 (LangSwitch 170 175) 54 -1 -1)
	(Graph grUPDATE_BOX 0 0 170 175 1)
	(localproc_0 204 4 (LangSwitch 50 60) 20 100 global125) ; "NOTICE TO APPEAR"
	(localproc_0 204 5 25 37 100 (proc0_15 global122 global121)) ; "Name -"
	(localproc_0 501 local3 60 37 100 global125)
	(localproc_0 204 6 25 52 100 (proc0_15 global122 global121)) ; "Street -"
	(localproc_0 501 (+ 1 local3) (LangSwitch 70 75) 52 100 global125)
	(localproc_0 204 7 25 67 100 (proc0_15 global122 global121)) ; "City -"
	(localproc_0 501 (+ 2 local3) (LangSwitch 55 75) 67 100 global125)
	(localproc_0 204 8 25 82 100 (proc0_15 global122 global121)) ; "DL -"
	(localproc_0 501 (+ 3 local3) (LangSwitch 47 45) 82 200 global125)
	(localproc_0 204 9 (LangSwitch 86 79) 82 100 (proc0_15 global122 global121)) ; "Sex -"
	(localproc_0 501 (+ 5 local3) (LangSwitch 111 116) 82 100 global125)
	(localproc_0 ; "Eye -"
		204
		10
		(LangSwitch 125 126)
		82
		100
		(proc0_15 global122 global121)
	)
	(localproc_0 501 (+ 7 local3) (LangSwitch 152 155) 82 100 global125)
	(localproc_0 204 11 25 97 100 (proc0_15 global122 global121)) ; "Hair -"
	(localproc_0 501 (+ 6 local3) (LangSwitch 55 61) 97 100 global125)
	(localproc_0 204 12 (LangSwitch 74 88) 97 100 (proc0_15 global122 global121)) ; "WT -"
	(localproc_0 501 (+ 9 local3) (LangSwitch 96 114) 97 100 global125)
	(localproc_0 ; "HT -"
		204
		13
		(LangSwitch 117 133)
		97
		100
		(proc0_15 global122 global121)
	)
	(localproc_0 501 (+ 8 local3) (LangSwitch 142 156) 97 100 global125)
	(localproc_0 204 14 25 112 100 (proc0_15 global122 global121)) ; "D.O.B. -"
	(localproc_0 501 (+ 4 local3) (LangSwitch 50 55) 112 50 global125)
	(localproc_0 204 15 95 112 100 (proc0_15 global122 global121)) ; "Time -"
	(localproc_0 204 16 25 127 100 (proc0_15 global122 global121)) ; "L.I. -"
	(localproc_0 501 (+ 10 local3) 50 127 50 global125)
	(localproc_0 204 17 83 127 100 (proc0_15 global122 global121)) ; "Reg Exp -"
	(localproc_0 501 (+ 11 local3) (LangSwitch 130 140) 127 50 global125)
	(localproc_0 204 18 25 142 100 (proc0_15 global122 global121)) ; "Year -"
	(localproc_0 501 (+ 12 local3) 63 142 50 global125)
	(localproc_0 204 19 95 142 100 (proc0_15 global122 global121)) ; "Make -"
	(localproc_0 501 (+ 12 local3) 133 142 50 global125)
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
	(localproc_0 204 21 25 37 100 (proc0_15 global122 global121)) ; "Name -"
	(localproc_0 204 22 25 52 100 (proc0_15 global122 global121)) ; "Street -"
	(localproc_0 204 23 25 67 100 (proc0_15 global122 global121)) ; "City -"
	(localproc_0 204 24 25 82 100 (proc0_15 global122 global121)) ; "DL -"
	(localproc_0 204 25 86 82 100 (proc0_15 global122 global121)) ; "Sex -"
	(localproc_0 204 26 125 82 100 (proc0_15 global122 global121)) ; "Eye -"
	(localproc_0 204 27 25 97 100 (proc0_15 global122 global121)) ; "Hair -"
	(localproc_0 204 28 74 97 100 (proc0_15 global122 global121)) ; "WT -"
	(localproc_0 204 29 117 97 100 (proc0_15 global122 global121)) ; "HT -"
	(localproc_0 204 30 25 112 100 (proc0_15 global122 global121)) ; "D.O.B. -"
	(localproc_0 204 31 95 112 100 (proc0_15 global122 global121)) ; "Time -"
	(localproc_0 204 32 25 127 100 (proc0_15 global122 global121)) ; "L.I. -"
	(localproc_0 204 33 83 127 100 (proc0_15 global122 global121)) ; "Reg Exp -"
	(localproc_0 204 34 25 142 100 (proc0_15 global122 global121)) ; "Year -"
	(localproc_0 204 35 95 142 100 (proc0_15 global122 global121)) ; "Make -"
	(localproc_0 204 20 25 157 100 (proc0_15 global122 global121)) ; "Vehicle Code -"
	(localproc_0 204 36 200 100 100 global125) ; "You must first insert the violator's license into the computer."
)

(instance rmDmv of Rm
	(properties
		picture 199
		style 0
	)

	(method (init)
		(super init:)
		(quitBut view: (LangSwitch 197 1971) x: (LangSwitch 289 310) init:)
		(driverBut view: (LangSwitch 197 1971) x: (LangSwitch 39 41) init:)
		(vinBut view: (LangSwitch 197 1971) x: (LangSwitch 99 132) init:)
		(plateBut view: (LangSwitch 197 1971) x: (LangSwitch 155 188) init:)
		(gGame setCursor: 999)
		(if (== gPrevRoomNum 25)
			(formBut view: (LangSwitch 197 1971) x: (LangSwitch 221 247) init:)
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
				(= local0 5)
				(localproc_0 204 37 20 170 200 global125) ; "Enter vehicle ID:"
				(= local24 210)
				(= local25 170)
				(self setScript: enterCode self)
			)
			(2
				(cond
					((not (StrCmp @local4 {77668}))
						(= local3 0)
						(localproc_3)
					)
					((not (StrCmp @local4 {09823}))
						(= local3 8)
						(localproc_3)
					)
					((not (StrCmp @local4 {99947}))
						(= local3 16)
						(localproc_3)
					)
					((not (StrCmp @local4 {88996}))
						(= local3 24)
						(localproc_3)
					)
					((not (StrCmp @local4 {69444}))
						(= local3 32)
						(localproc_3)
					)
					((not (StrCmp @local4 {08996}))
						(= local3 40)
						(localproc_3)
					)
					((not (StrCmp @local4 {88116}))
						(= local3 48)
						(localproc_3)
					)
					(else
						(localproc_0 204 38 20 170 200 global125) ; "Invalid Entry"
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
				(= local0 5)
				(= local24 210)
				(= local25 170)
				(localproc_0 204 39 20 170 200 global125) ; "Enter vehicle license number:"
				(self setScript: enterCode self)
			)
			(2
				(cond
					((not (StrCmp @local4 {34567}))
						(= local3 0)
						(localproc_3)
					)
					((not (StrCmp @local4 {83756}))
						(= local3 8)
						(localproc_3)
					)
					((not (StrCmp @local4 {12896}))
						(SetFlag 89)
						(= local3 16)
						(localproc_3)
					)
					((not (StrCmp @local4 {22776}))
						(= local3 24)
						(localproc_3)
					)
					((not (StrCmp @local4 {01923}))
						(= local3 32)
						(localproc_3)
					)
					((not (StrCmp @local4 {84016}))
						(= local3 40)
						(localproc_3)
					)
					((not (StrCmp @local4 {22776}))
						(= local3 48)
						(localproc_3)
					)
					(else
						(localproc_0 204 38 20 170 200 global125) ; "Invalid Entry"
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
				(= local0 6)
				(= local24 210)
				(= local25 170)
				(localproc_0 204 40 20 170 200 global125) ; "Enter driver's ID:"
				(self setScript: enterCode self)
			)
			(2
				(cond
					((not (StrCmp @local4 {654321}))
						(= local3 56)
						(localproc_4)
					)
					((not (StrCmp @local4 {145698}))
						(= local3 62)
						(localproc_4)
					)
					((not (StrCmp @local4 {522341}))
						(= local3 68)
						(localproc_4)
					)
					((not (StrCmp @local4 {434301}))
						(= local3 74)
						(localproc_4)
					)
					((not (StrCmp @local4 {836702}))
						(= local3 80)
						(localproc_4)
					)
					((not (StrCmp @local4 {789612}))
						(= local3 86)
						(localproc_4)
					)
					((not (StrCmp @local4 {980453}))
						(= local3 92)
						(localproc_4)
					)
					(else
						(localproc_0 204 38 20 170 200 global125) ; "Invalid Entry"
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance enterCode of Script
	(properties)

	(method (changeState newState &tmp [temp0 30])
		(switch (= state newState)
			(0
				(touchPad init: self)
				(= local1 0)
				(StrCpy @local4 {})
				(self register: -1)
				(= cycles 1)
				(= local2 0)
			)
			(1
				(cond
					((== local1 local0)
						(= cycles 3)
					)
					((== register -1)
						(= state 0)
						(= cycles 1)
					)
					((< register 10)
						(++ local1)
						(StrCat @local4 (Format @temp0 204 41 register)) ; "%d"
						(localproc_1)
						(self register: -1)
						(= state 0)
						(= cycles 1)
					)
				)
			)
			(2
				(touchPad dispose:)
				(if local26
					(= state 3)
				else
					(localproc_0 204 42 20 170 200 global125) ; "searching..."
				)
				(= seconds 1)
			)
			(3
				(Graph grFILL_BOX 170 20 180 (LangSwitch 160 185) 1 0 -1 -1)
				(Graph grUPDATE_BOX 170 20 180 (LangSwitch 160 185) 1)
				(if (< local2 3)
					(= state 1)
					(++ local2)
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

	(method (changeState newState &tmp [temp0 10])
		(switch (= state newState)
			(0
				(localproc_2)
				(= cycles 3)
			)
			(1
				(switch ((gInventory at: 23) state:) ; license
					(1
						(= local3 112)
						(localproc_5)
					)
					(2
						(= local3 98)
						(localproc_5)
					)
					(3
						(= local3 139)
						(localproc_5)
					)
					(4
						(Print 204 43) ; "You can't give this guy a traffic citation. He wasn't driving a car."
						(gEgo get: 23) ; license
						(gCurRoom newRoom: gPrevRoomNum)
					)
				)
				(= cycles 5)
			)
			(2
				(Graph grFILL_BOX 90 205 99 280 1 0 -1 -1)
				(Graph grUPDATE_BOX 90 205 99 280 1)
				(= local26 1)
				(= local0 2)
				(= local24 125)
				(= local25 112)
				(localproc_0 204 44 205 50 100 global125) ; "Enter Military Time"
				(self setScript: enterCode self)
			)
			(3
				(if (< (StrCmp {24} @local4) 1)
					(Graph grFILL_BOX 112 125 119 169 1 0 -1 -1)
					(Graph grUPDATE_BOX 112 125 119 169 1)
					(localproc_0 204 38 205 90 100 global125) ; "Invalid Entry"
					(= state 1)
					(= seconds 3)
				else
					(if (not (StrCmp @local4 (Format @temp0 204 41 global105))) ; "%d"
						(++ local27)
					)
					(= cycles 3)
				)
			)
			(4
				(Graph grFILL_BOX 90 205 99 280 1 0 -1 -1)
				(Graph grUPDATE_BOX 90 205 99 280 1)
				(= local26 1)
				(= local0 2)
				(= local24 138)
				(= local25 112)
				(localproc_0 204 44 205 50 100 global125) ; "Enter Military Time"
				(self setScript: enterCode self)
			)
			(5
				(if (< (StrCmp {60} @local4) 1)
					(Graph grFILL_BOX 112 139 119 169 1 0 -1 -1)
					(Graph grUPDATE_BOX 112 139 119 169 1)
					(localproc_0 204 38 205 90 100 global125) ; "Invalid Entry"
					(= seconds (= state 3))
				else
					(if (not (StrCmp @local4 (Format @temp0 204 41 global106))) ; "%d"
						(++ local27)
					)
					(= cycles 3)
				)
			)
			(6
				(= local24 90)
				(= local25 157)
				(= local0 5)
				(Graph grFILL_BOX 50 205 60 305 1 0 -1 -1)
				(Graph grUPDATE_BOX 50 205 60 305 1)
				(localproc_0 204 45 205 80 100 global125) ; "Enter vehicle code:"
				(self setScript: enterCode self)
			)
			(7
				(switch ((gInventory at: 23) state:) ; license
					(1
						(if (== local27 2)
							(SetFlag 47)
						)
						(if (not (StrCmp @local4 {21654}))
							(SetFlag 70)
							(SetScore 117 5)
						)
					)
					(2
						(if (not (StrCmp @local4 {22349}))
							(SetFlag 71)
							(SetScore 118 5)
						)
					)
					(3
						(if (not (StrCmp @local4 {23152}))
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
							(== (event message:) (LangSwitch 113 101))
							(== (event message:) (LangSwitch 81 69))
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
							(== (event message:) (LangSwitch 118 119))
							(== (event message:) (LangSwitch 86 87))
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
							(== (event message:) (LangSwitch 100 97))
							(== (event message:) (LangSwitch 68 65))
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
							(== (event message:) (LangSwitch 112 107))
							(== (event message:) (LangSwitch 80 75))
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

