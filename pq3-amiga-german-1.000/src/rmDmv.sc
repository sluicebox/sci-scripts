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

(procedure (localproc_0 param1 param2 param3 param4 param5 param6 &tmp [temp0 157])
	(if (u< param1 1000)
		(GetFarText param1 param2 @temp0)
	else
		(StrCpy @temp0 param1)
	)
	(Display @temp0 dsCOORD param3 param4 dsALIGN alLEFT dsFONT 0 dsCOLOR param6 dsWIDTH param5)
)

(procedure (localproc_1)
	(if local6
		(Display
			@local6
			dsCOORD
			local26
			local27
			dsALIGN
			alLEFT
			dsFONT
			0
			dsCOLOR
			7
			dsWIDTH
			(LangSwitch 110 100)
		)
	)
)

(procedure (localproc_2)
	(gCurRoom style: 5 drawPic: 199)
	(quitBut loop: 0 forceUpd:)
	(plateBut loop: 0 forceUpd:)
	(driverBut loop: 0 forceUpd:)
	(vinBut loop: 0 forceUpd:)
)

(procedure (localproc_3 &tmp [temp0 300] [temp300 40] [temp340 40] [temp380 40] [temp420 40] [temp460 40])
	(localproc_0 204 0 20 170 200 global125) ; "Identified"
	(GetFarText 501 local5 @temp300)
	(GetFarText 501 (+ 1 local5) @temp340)
	(GetFarText 501 (+ 2 local5) @temp380)
	(GetFarText 501 (+ 3 local5) @temp420)
	(GetFarText 501 (+ 4 local5) @temp460)
	(if 1
		(= global186 (Memory memALLOC_CRIT (StrLen @temp300)))
		(= global187 (Memory memALLOC_CRIT (StrLen @temp340)))
		(= global188 (Memory memALLOC_CRIT (StrLen @temp380)))
		(= global189 (Memory memALLOC_CRIT (StrLen @temp420)))
		(= global190 (Memory memALLOC_CRIT (StrLen @temp460)))
		(= global192 (Memory memALLOC_CRIT (StrLen @temp300)))
		(= global193 (Memory memALLOC_CRIT (StrLen @temp340)))
		(= global194 (Memory memALLOC_CRIT (StrLen @temp380)))
		(= global195 (Memory memALLOC_CRIT (StrLen @temp420)))
		(= global196 (Memory memALLOC_CRIT (StrLen @temp460)))
		(StrSplitInTwo global186 global192 @temp300)
		(StrSplitInTwo global187 global193 @temp340)
		(StrSplitInTwo global188 global194 @temp380)
		(StrSplitInTwo global189 global195 @temp420)
		(StrSplitInTwo global190 global196 @temp460)
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
	(GetFarText 501 (+ 5 local5) @temp300)
	(GetFarText 501 (+ 6 local5) @temp340)
	(GetFarText 501 (+ 7 local5) @temp380)
	(if 1
		(= global186 (Memory memALLOC_CRIT (StrLen @temp300)))
		(= global187 (Memory memALLOC_CRIT (StrLen @temp340)))
		(= global188 (Memory memALLOC_CRIT (StrLen @temp380)))
		(= global192 (Memory memALLOC_CRIT (StrLen @temp300)))
		(= global193 (Memory memALLOC_CRIT (StrLen @temp340)))
		(= global194 (Memory memALLOC_CRIT (StrLen @temp380)))
		(StrSplitInTwo global186 global192 @temp300)
		(StrSplitInTwo global187 global193 @temp340)
		(StrSplitInTwo global188 global194 @temp380)
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

(procedure (localproc_4 &tmp [temp0 300] [temp300 40] [temp340 40] [temp380 40] [temp420 40] [temp460 40] [temp500 40])
	(localproc_0 204 0 20 170 200 global125) ; "Identified"
	(GetFarText 501 local5 @temp300)
	(GetFarText 501 (+ 1 local5) @temp340)
	(GetFarText 501 (+ 2 local5) @temp380)
	(GetFarText 501 (+ 3 local5) @temp420)
	(GetFarText 501 (+ 4 local5) @temp460)
	(GetFarText 501 (+ 5 local5) @temp500)
	(if 1
		(= global186 (Memory memALLOC_CRIT (StrLen @temp300)))
		(= global187 (Memory memALLOC_CRIT (StrLen @temp340)))
		(= global188 (Memory memALLOC_CRIT (StrLen @temp380)))
		(= global189 (Memory memALLOC_CRIT (StrLen @temp420)))
		(= global190 (Memory memALLOC_CRIT (StrLen @temp460)))
		(= global191 (Memory memALLOC_CRIT (StrLen @temp500)))
		(= global192 (Memory memALLOC_CRIT (StrLen @temp300)))
		(= global193 (Memory memALLOC_CRIT (StrLen @temp340)))
		(= global194 (Memory memALLOC_CRIT (StrLen @temp380)))
		(= global195 (Memory memALLOC_CRIT (StrLen @temp420)))
		(= global196 (Memory memALLOC_CRIT (StrLen @temp460)))
		(= global197 (Memory memALLOC_CRIT (StrLen @temp500)))
		(StrSplitInTwo global186 global192 @temp300)
		(StrSplitInTwo global187 global193 @temp340)
		(StrSplitInTwo global188 global194 @temp380)
		(StrSplitInTwo global189 global195 @temp420)
		(StrSplitInTwo global190 global196 @temp460)
		(StrSplitInTwo global191 global197 @temp500)
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
	(localproc_6)
	(localproc_0 204 4 (LangSwitch 50 60) 20 100 global125) ; "NOTICE TO APPEAR"
	(localproc_0 501 local5 60 37 100 global125)
	(localproc_0 501 (+ 1 local5) (LangSwitch 70 75) 52 100 global125)
	(localproc_0 501 (+ 2 local5) (LangSwitch 55 75) 67 100 global125)
	(localproc_0 501 (+ 3 local5) (LangSwitch 47 45) 82 200 global125)
	(localproc_0 501 (+ 5 local5) (LangSwitch 111 116) 82 100 global125)
	(localproc_0 501 (+ 7 local5) (LangSwitch 152 155) 82 100 global125)
	(localproc_0 501 (+ 6 local5) (LangSwitch 55 61) 97 100 global125)
	(localproc_0 501 (+ 9 local5) (LangSwitch 96 114) 97 100 global125)
	(localproc_0 501 (+ 8 local5) (LangSwitch 142 156) 97 100 global125)
	(localproc_0 501 (+ 4 local5) (LangSwitch 50 55) 112 50 global125)
	(localproc_0 501 (+ 10 local5) 50 127 50 global125)
	(localproc_0 501 (+ 11 local5) (LangSwitch 130 140) 127 50 global125)
	(localproc_0 501 (+ 12 local5) 63 142 50 global125)
	(localproc_0 501 (+ 13 local5) 133 142 50 global125)
)

(procedure (localproc_6)
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
	(Graph grUPDATE_BOX 0 0 (LangSwitch 170 175) 180 1)
	(localproc_0 204 4 (LangSwitch 50 60) 20 100 global125) ; "NOTICE TO APPEAR"
	(localproc_0 204 5 25 37 100 (proc0_15 global122 global121 global137)) ; "Name -"
	(localproc_0 204 6 25 52 100 (proc0_15 global122 global121 global137)) ; "Street -"
	(localproc_0 204 7 25 67 100 (proc0_15 global122 global121 global137)) ; "City -"
	(localproc_0 204 8 25 82 100 (proc0_15 global122 global121 global137)) ; "DL -"
	(localproc_0 ; "Sex -"
		204
		9
		(LangSwitch 86 79)
		82
		100
		(proc0_15 global122 global121 global137)
	)
	(localproc_0 ; "Eye -"
		204
		10
		(LangSwitch 125 126)
		82
		100
		(proc0_15 global122 global121 global137)
	)
	(localproc_0 204 11 25 97 100 (proc0_15 global122 global121 global137)) ; "Hair -"
	(localproc_0 ; "WT -"
		204
		12
		(LangSwitch 74 88)
		97
		100
		(proc0_15 global122 global121 global137)
	)
	(localproc_0 ; "HT -"
		204
		13
		(LangSwitch 117 133)
		97
		100
		(proc0_15 global122 global121 global137)
	)
	(localproc_0 204 14 25 112 100 (proc0_15 global122 global121 global137)) ; "D.O.B. -"
	(localproc_0 204 15 95 112 100 (proc0_15 global122 global121 global137)) ; "Time -"
	(localproc_0 204 16 25 127 100 (proc0_15 global122 global121 global137)) ; "L.I. -"
	(localproc_0 204 17 83 127 100 (proc0_15 global122 global121 global137)) ; "Reg Exp -"
	(localproc_0 204 18 25 142 100 (proc0_15 global122 global121 global137)) ; "Year -"
	(localproc_0 204 19 95 142 100 (proc0_15 global122 global121 global137)) ; "Make -"
	(localproc_0 204 20 25 157 100 (proc0_15 global122 global121 global137)) ; "Vehicle Code -"
)

(instance rmDmv of Rm
	(properties
		picture 199
		style 0
	)

	(method (init)
		(super init:)
		(quitBut
			view: (proc0_20 1971 197 197 197 197)
			x: (proc0_20 310 289 289 289 289)
			init:
		)
		(vinBut
			view: (proc0_20 1971 197 197 197 197)
			x: (proc0_20 132 99 99 99 99)
			init:
		)
		(driverBut
			view: (proc0_20 1971 197 197 197 197)
			x: (proc0_20 41 39 39 39 39)
			init:
		)
		(plateBut
			view: (proc0_20 1971 197 197 197 197)
			x: (proc0_20 188 155 155 155 155)
			init:
		)
		(gGame setCursor: 999)
		(if (== gPrevRoomNum 25)
			(formBut
				view: (proc0_20 1971 197 197 197 197)
				x: (proc0_20 247 221 221 221 221)
				init:
			)
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
				(localproc_0 204 21 20 170 200 global125) ; "Enter vehicle ID:"
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
						(localproc_0 204 22 20 170 200 global125) ; "Invalid Entry"
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
				(localproc_0 204 23 20 170 200 global125) ; "Enter vehicle license number:"
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
						(localproc_0 204 22 20 170 200 global125) ; "Invalid Entry"
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
				(localproc_0 204 24 20 170 200 global125) ; "Enter driver's ID:"
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
						(localproc_0 204 22 20 170 200 global125) ; "Invalid Entry"
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
						(StrCat @local6 (Format @temp0 204 25 register)) ; "%d"
						(localproc_1)
						(self register: -1)
						(= state 0)
						(= cycles 1)
					)
				)
			)
			(2
				(touchPad dispose:)
				(cond
					((== local4 0)
						(= cycles 8)
					)
					(local28
						(= state 3)
						(= seconds 1)
					)
					(else
						(localproc_0 204 26 20 170 200 global125) ; "searching..."
						(= seconds 1)
					)
				)
			)
			(3
				(Graph grFILL_BOX 170 20 180 (LangSwitch 160 185) 1 0 -1 -1)
				(Graph grUPDATE_BOX 170 20 180 (LangSwitch 160 185) 1)
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

	(method (changeState newState &tmp [temp0 15])
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
						(Print 204 27) ; "You can't give this guy a traffic citation. He wasn't driving a car."
						(gEgo get: 23) ; license
						(gCurRoom newRoom: gPrevRoomNum)
					)
				)
				(= cycles 5)
			)
			(2
				(Graph grFILL_BOX 90 205 99 290 1 0 -1 -1)
				(Graph grUPDATE_BOX 90 205 99 290 1)
				(= local28 1)
				(= local2 2)
				(= local26 125)
				(= local27 112)
				(localproc_0 204 28 205 50 100 global125) ; "Enter Military Time"
				(self setScript: enterCode self)
			)
			(3
				(if (< (StrCmp {24} @local6) 1)
					(Graph grFILL_BOX 112 125 119 169 1 0 -1 -1)
					(Graph grUPDATE_BOX 112 125 119 169 1)
					(localproc_0 204 22 205 90 100 global125) ; "Invalid Entry"
					(= state 1)
					(= seconds 3)
				else
					(if (not (StrCmp @local6 (Format @temp0 204 25 global105))) ; "%d"
						(++ local29)
					)
					(= cycles 3)
				)
			)
			(4
				(Graph grFILL_BOX 90 205 99 290 1 0 -1 -1)
				(Graph grUPDATE_BOX 90 205 99 290 1)
				(= local28 1)
				(= local2 2)
				(= local26 138)
				(= local27 112)
				(localproc_0 204 28 205 50 100 global125) ; "Enter Military Time"
				(self setScript: enterCode self)
			)
			(5
				(if (< (StrCmp {60} @local6) 1)
					(Graph grFILL_BOX 112 139 119 169 1 0 -1 -1)
					(Graph grUPDATE_BOX 112 139 119 169 1)
					(localproc_0 204 22 205 90 100 global125) ; "Invalid Entry"
					(= seconds (= state 3))
				else
					(if (not (StrCmp @local6 (Format @temp0 204 25 global106))) ; "%d"
						(++ local29)
					)
					(= cycles 3)
				)
			)
			(6
				(= local26 (proc0_20 100 90 90 90 90))
				(= local27 157)
				(= local2 5)
				(Graph grFILL_BOX 50 205 60 295 1 0 -1 -1)
				(Graph grUPDATE_BOX 50 205 60 295 1)
				(localproc_0 204 29 205 80 100 global125) ; "Enter vehicle code:"
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
							(==
								(event message:)
								(proc0_20 101 113 113 113 113)
							)
							(== (event message:) (proc0_20 69 81 81 81 81 81))
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
							(==
								(event message:)
								(proc0_20 119 118 118 118 118)
							)
							(== (event message:) (proc0_20 87 86 86 86 86))
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
							(== (event message:) (proc0_20 97 100 100 100 100))
							(== (event message:) (proc0_20 65 68 68 68 68))
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
							(==
								(event message:)
								(proc0_20 107 112 112 112 112)
							)
							(== (event message:) (proc0_20 75 80 80 80 80))
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
							(localproc_2)
							(Animate (gCast elements:) 0)
							(localproc_6)
							(localproc_0 204 30 190 100 120 global125) ; "You must first insert the violator's license into the computer."
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
							(localproc_2)
							(Animate (gCast elements:) 0)
							(localproc_6)
							(localproc_0 204 30 190 100 120 global125) ; "You must first insert the violator's license into the computer."
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

