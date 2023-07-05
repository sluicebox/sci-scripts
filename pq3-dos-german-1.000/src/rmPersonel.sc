;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 205)
(include sci.sh)
(use Main)
(use Interface)
(use Language)
(use Feature)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rmPersonel 0
)

(local
	local0
	local1 = 80
	local2 = 35
	[local3 200]
)

(procedure (localproc_0 param1 param2 param3 param4 param5 &tmp [temp0 400])
	(if (u< param1 1000)
		(GetFarText param1 param2 @temp0)
	else
		(StrCpy @temp0 param1)
	)
	(Display @temp0 dsCOORD param3 param4 dsALIGN alLEFT dsFONT 0 dsCOLOR 7 dsWIDTH param5)
)

(instance rmPersonel of Rm
	(properties
		picture 199
	)

	(method (init)
		(theRoom init:)
		(super init:)
		(Load rsVIEW (LangSwitch 197 1971))
		(quitBut view: (LangSwitch 197 1971) x: (LangSwitch 298 307) init:)
		(gTheIconBar disable:)
		(self setScript: showNames)
		(gGame setCursor: 999)
		(User canControl: 1)
	)

	(method (dispose)
		(gTheIconBar enable:)
		(super dispose:)
	)
)

(instance showNames of Script
	(properties)

	(method (changeState newState &tmp [temp0 40])
		(switch (= state newState)
			(0
				(localproc_0 502 10 25 30 100) ; "Aimes, Sidney"
				(localproc_0 502 20 25 40 100) ; "Banks, Joseph"
				(localproc_0 502 30 25 50 100) ; "Bock, Jon"
				(localproc_0 502 40 25 60 100) ; "Bonds, Sonny"
				(localproc_0 502 50 25 70 100) ; "Cardinal, Jane"
				(localproc_0 502 60 25 80 100) ; "Childs, John"
				(localproc_0 502 70 25 90 100) ; "Crowe, Jeff"
				(localproc_0 502 80 25 100 100) ; "Crowe, Mark"
				(localproc_0 502 90 25 110 100) ; "Downs, Mike"
				(localproc_0 502 100 25 120 100) ; "Escobar, Carlos"
				(localproc_0 502 110 25 130 100) ; "Eidson, Kimberly A."
				(localproc_0 502 120 25 140 100) ; "Ferrell, Frank"
				(localproc_0 502 130 25 150 100) ; "Gibbs, Martha"
				(localproc_0 502 140 25 160 100) ; "Hanks, Earl"
				(localproc_0 502 150 25 170 100) ; "Hartman, Desi"
				(localproc_0 502 160 190 30 100) ; "Jaco, Henry"
				(localproc_0 502 170 190 40 100) ; "Jensen, Jane"
				(localproc_0 502 180 190 50 100) ; "Kling, George"
				(localproc_0 502 190 190 60 100) ; "Lang, Robert"
				(localproc_0 502 200 190 70 100) ; "Larson, James"
				(localproc_0 502 210 190 80 100) ; "Law, Carl"
				(localproc_0 502 220 190 90 100) ; "Loyd, Cheri"
				(localproc_0 502 230 190 100 100) ; "Miller, Kevin"
				(localproc_0 502 240 190 110 100) ; "Morales, Pat"
				(localproc_0 502 250 190 120 100) ; "Morgan, Maurice"
				(localproc_0 502 260 190 130 100) ; "Rhodes, Kathy"
				(localproc_0 502 270 190 140 100) ; "Smith, Daryle"
				(localproc_0 502 280 190 150 100) ; "Stump, C.J."
				(localproc_0 502 290 190 160 100) ; "Swafford, Robert"
				(localproc_0 502 300 190 170 100) ; "Walls, James (BB)"
				(quitBut loop: 0 forceUpd:)
				(self dispose:)
			)
		)
	)
)

(instance showRecord of Script
	(properties)

	(method (changeState newState &tmp [temp0 200] [temp200 30] [temp230 30] [temp260 30] [temp290 30] [temp320 30])
		(switch (= state newState)
			(0
				(theRoom dispose:)
				(gCurRoom style: 5 drawPic: 199)
				(quitBut loop: 0 forceUpd:)
				(= cycles 3)
			)
			(1
				(GetFarText 502 0 @temp200) ; "NAME"
				(GetFarText 502 1 @temp230) ; "BADGE"
				(GetFarText 502 2 @temp260) ; "D.O.H."
				(GetFarText 502 3 @temp290) ; "DIVISION"
				(GetFarText 502 4 @temp320) ; "STATUS"
				(if 1
					(= global186 (Memory memALLOC_CRIT (StrLen @temp200)))
					(= global187 (Memory memALLOC_CRIT (StrLen @temp230)))
					(= global188 (Memory memALLOC_CRIT (StrLen @temp260)))
					(= global189 (Memory memALLOC_CRIT (StrLen @temp290)))
					(= global190 (Memory memALLOC_CRIT (StrLen @temp320)))
					(= global192 (Memory memALLOC_CRIT (StrLen @temp200)))
					(= global193 (Memory memALLOC_CRIT (StrLen @temp230)))
					(= global194 (Memory memALLOC_CRIT (StrLen @temp260)))
					(= global195 (Memory memALLOC_CRIT (StrLen @temp290)))
					(= global196 (Memory memALLOC_CRIT (StrLen @temp320)))
					(StrSplitInTwo global186 global192 @temp200)
					(StrSplitInTwo global187 global193 @temp230)
					(StrSplitInTwo global188 global194 @temp260)
					(StrSplitInTwo global189 global195 @temp290)
					(StrSplitInTwo global190 global196 @temp320)
					(Format ; "%s %s %s %s %s"
						@local3
						205
						0
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
				(Display @local3 dsCOORD 10 40 dsALIGN alLEFT dsFONT 0 dsCOLOR 7 dsWIDTH 80)
				(localproc_0 205 1 70 40 10) ; ": : : : :"
				(*= local0 10)
				(GetFarText 502 local0 @temp200)
				(GetFarText 502 (+ 1 local0) @temp230)
				(GetFarText 502 (+ 2 local0) @temp260)
				(GetFarText 502 (+ 3 local0) @temp290)
				(GetFarText 502 (+ 4 local0) @temp320)
				(if 1
					(= global186 (Memory memALLOC_CRIT (StrLen @temp200)))
					(= global187 (Memory memALLOC_CRIT (StrLen @temp230)))
					(= global188 (Memory memALLOC_CRIT (StrLen @temp260)))
					(= global189 (Memory memALLOC_CRIT (StrLen @temp290)))
					(= global190 (Memory memALLOC_CRIT (StrLen @temp320)))
					(= global192 (Memory memALLOC_CRIT (StrLen @temp200)))
					(= global193 (Memory memALLOC_CRIT (StrLen @temp230)))
					(= global194 (Memory memALLOC_CRIT (StrLen @temp260)))
					(= global195 (Memory memALLOC_CRIT (StrLen @temp290)))
					(= global196 (Memory memALLOC_CRIT (StrLen @temp320)))
					(StrSplitInTwo global186 global192 @temp200)
					(StrSplitInTwo global187 global193 @temp230)
					(StrSplitInTwo global188 global194 @temp260)
					(StrSplitInTwo global189 global195 @temp290)
					(StrSplitInTwo global190 global196 @temp320)
					(Format ; "%s %s %s %s %s"
						@local3
						205
						0
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
				(Display @local3 dsCOORD 80 40 dsALIGN alLEFT dsFONT 0 dsCOLOR 7 dsWIDTH 100)
				(GetFarText 502 5 @temp200) ; "SEX"
				(GetFarText 502 6 @temp230) ; "D.O.B."
				(GetFarText 502 7 @temp260) ; "HEIGHT"
				(GetFarText 502 8 @temp290) ; "WEIGHT"
				(if 1
					(= global186 (Memory memALLOC_CRIT (StrLen @temp200)))
					(= global187 (Memory memALLOC_CRIT (StrLen @temp230)))
					(= global188 (Memory memALLOC_CRIT (StrLen @temp260)))
					(= global189 (Memory memALLOC_CRIT (StrLen @temp290)))
					(= global192 (Memory memALLOC_CRIT (StrLen @temp200)))
					(= global193 (Memory memALLOC_CRIT (StrLen @temp230)))
					(= global194 (Memory memALLOC_CRIT (StrLen @temp260)))
					(= global195 (Memory memALLOC_CRIT (StrLen @temp290)))
					(StrSplitInTwo global186 global192 @temp200)
					(StrSplitInTwo global187 global193 @temp230)
					(StrSplitInTwo global188 global194 @temp260)
					(StrSplitInTwo global189 global195 @temp290)
					(Format ; "%s %s %s %s"
						@local3
						205
						2
						global186
						global187
						global188
						global189
						global192
						global193
						global194
						global195
					)
					(Memory memFREE global186)
					(Memory memFREE global187)
					(Memory memFREE global188)
					(Memory memFREE global189)
					(Memory memFREE global192)
					(Memory memFREE global193)
					(Memory memFREE global194)
					(Memory memFREE global195)
				)
				(Display @local3 dsCOORD 185 40 dsALIGN alLEFT dsFONT 0 dsCOLOR 7 dsWIDTH 80)
				(localproc_0 205 3 240 40 10) ; ": : : :"
				(GetFarText 502 (+ 5 local0) @temp200)
				(GetFarText 502 (+ 6 local0) @temp230)
				(GetFarText 502 (+ 7 local0) @temp260)
				(GetFarText 502 (+ 8 local0) @temp290)
				(if 1
					(= global186 (Memory memALLOC_CRIT (StrLen @temp200)))
					(= global187 (Memory memALLOC_CRIT (StrLen @temp230)))
					(= global188 (Memory memALLOC_CRIT (StrLen @temp260)))
					(= global189 (Memory memALLOC_CRIT (StrLen @temp290)))
					(= global192 (Memory memALLOC_CRIT (StrLen @temp200)))
					(= global193 (Memory memALLOC_CRIT (StrLen @temp230)))
					(= global194 (Memory memALLOC_CRIT (StrLen @temp260)))
					(= global195 (Memory memALLOC_CRIT (StrLen @temp290)))
					(StrSplitInTwo global186 global192 @temp200)
					(StrSplitInTwo global187 global193 @temp230)
					(StrSplitInTwo global188 global194 @temp260)
					(StrSplitInTwo global189 global195 @temp290)
					(Format ; "%s %s %s %s"
						@local3
						205
						2
						global186
						global187
						global188
						global189
						global192
						global193
						global194
						global195
					)
					(Memory memFREE global186)
					(Memory memFREE global187)
					(Memory memFREE global188)
					(Memory memFREE global189)
					(Memory memFREE global192)
					(Memory memFREE global193)
					(Memory memFREE global194)
					(Memory memFREE global195)
				)
				(Display @local3 dsCOORD 250 40 dsALIGN alLEFT dsFONT 0 dsCOLOR 7 dsWIDTH 70)
				(localproc_0 205 4 90 100 200) ; "Departmental Action"
				(Graph grDRAW_LINE 95 0 95 320 54 -1 -1)
				(Graph grUPDATE_BOX 94 0 96 320 1)
				(Animate (gCast elements:) 0)
				(localproc_0 502 (+ 9 local0) 20 120 280)
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
					(if (gCurRoom script:)
						(gCurRoom style: 5 drawPic: 199 setScript: showNames)
						(theRoom init:)
						(quitBut forceUpd:)
					else
						(gCurRoom style: 10 newRoom: gPrevRoomNum)
					)
					(event claimed: 1)
				)
			)
			(evMOUSEBUTTON
				(if (MousedOn self event)
					(self loop: 1 forceUpd:)
					(Animate (gCast elements:) 0)
					(if (gCurRoom script:)
						(gCurRoom style: 5 drawPic: 199 setScript: showNames)
						(theRoom init:)
						(quitBut forceUpd:)
					else
						(gCurRoom style: 10 newRoom: gPrevRoomNum)
					)
					(event claimed: 1)
				)
			)
			($0044 ; direction | evKEYBOARD
				(if (== ((gTheIconBar curIcon:) message:) 1)
					(switch (event message:)
						(JOY_UP
							(if (> local2 5)
								(-= local2 10)
							)
						)
						(JOY_DOWN
							(if (< local2 175)
								(+= local2 10)
							)
						)
						(JOY_RIGHT
							(if (< local1 280)
								(+= local1 100)
							)
						)
						(JOY_LEFT
							(if (> local1 80)
								(-= local1 100)
							)
						)
					)
					(SetCursor 999 1 local1 local2)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance theRoom of Feature
	(properties
		nsTop 27
		nsBottom 200
		nsRight 320
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

	(method (handleEvent event &tmp temp0 temp1)
		(switch (event type:)
			(evKEYBOARD
				(if
					(and
						(InRect nsLeft nsTop nsRight nsBottom event)
						(== (event message:) KEY_RETURN)
					)
					(= temp0 (/ (event x:) 160))
					(= temp1 (/ (- (event y:) 28) 10))
					(= local0 (+ 1 (* 15 temp0) temp1))
					(gCurRoom setScript: showRecord)
					(event claimed: 1)
				)
			)
			(evMOUSEBUTTON
				(if (MousedOn self event)
					(= temp0 (/ (event x:) 160))
					(= temp1 (/ (- (event y:) 28) 10))
					(= local0 (+ 1 (* 15 temp0) temp1))
					(gCurRoom setScript: showRecord)
					(event claimed: 1)
				)
			)
		)
	)
)

