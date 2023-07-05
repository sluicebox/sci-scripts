;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 201)
(include sci.sh)
(use Main)
(use Interface)
(use rmnScript)
(use Language)
(use Feature)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm201 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	[local11 7] = [39 63 87 111 135 159 183]
	[local18 7] = [34 58 82 106 130 154 178]
	[local25 14] = [96 137 124 93 123 108 123 122 123 88 123 65 122 106]
)

(procedure (localproc_0 param1 param2)
	(rFace stopUpd:)
	(lFace stopUpd:)
	(eye stopUpd:)
	(nose stopUpd:)
	(cMouth stopUpd:)
	(brow stopUpd:)
	(hair stopUpd:)
	(beard stopUpd:)
	(= local10 param1)
	(redBox y: [local11 local10] forceUpd:)
	(if (== param2 cFace)
		(rFace startUpd:)
		(lFace startUpd:)
	else
		(param2 startUpd:)
	)
	((= local8 param2) init:)
	(= local9 (local8 cel:))
	(hControl y: (param2 y:))
	(wControl x: (param2 x:))
	(if (!= [local18 local10] 0)
		(rArrow y: [local18 local10] forceUpd:)
		(lArrow y: [local18 local10] forceUpd:)
	)
)

(procedure (localproc_1 param1 param2 param3 param4 param5 &tmp [temp0 200])
	(if (u< param1 1000)
		(GetFarText param1 param2 @temp0)
	else
		(StrCpy @temp0 param1)
	)
	(if temp0
		(Display @temp0 dsCOORD param3 param4 dsALIGN alLEFT dsFONT 0 dsCOLOR 7 dsWIDTH param5)
	)
)

(procedure (localproc_2 &tmp temp0 [temp1 200])
	(= temp0 (partList at: local10))
	(cond
		(
			(and
				(<= (Abs (- [local25 (* 2 local10)] (temp0 x:))) 2)
				(<= (Abs (- [local25 (+ (* 2 local10) 1)] (temp0 y:))) 2)
			)
			(if 1
				(= global186 (Memory memALLOC_CRIT (StrLen (temp0 description:))))
				(= global192 (Memory memALLOC_CRIT (StrLen (temp0 description:))))
				(StrSplitInTwo global186 global192 (temp0 description:))
				(Format @temp1 201 0 global186 global192) ; "The %s looks ok."
				(Memory memFREE global186)
				(Memory memFREE global192)
			)
			(= local0 (<< $0001 (mod local10 16)))
			(|= local1 local0)
		)
		((> (- [local25 (+ (* 2 local10) 1)] (temp0 y:)) 6)
			(if 1
				(= global186 (Memory memALLOC_CRIT (StrLen (temp0 description:))))
				(= global192 (Memory memALLOC_CRIT (StrLen (temp0 description:))))
				(StrSplitInTwo global186 global192 (temp0 description:))
				(Format @temp1 201 1 global186 global192) ; "The %s is way too high."
				(Memory memFREE global186)
				(Memory memFREE global192)
			)
		)
		((> (- (temp0 y:) [local25 (+ (* 2 local10) 1)]) 6)
			(if 1
				(= global186 (Memory memALLOC_CRIT (StrLen (temp0 description:))))
				(= global192 (Memory memALLOC_CRIT (StrLen (temp0 description:))))
				(StrSplitInTwo global186 global192 (temp0 description:))
				(Format @temp1 201 2 global186 global192) ; "The %s is way too low"
				(Memory memFREE global186)
				(Memory memFREE global192)
			)
		)
		((> (- [local25 (* 2 local10)] (temp0 x:)) 6)
			(if 1
				(= global186 (Memory memALLOC_CRIT (StrLen (temp0 description:))))
				(= global192 (Memory memALLOC_CRIT (StrLen (temp0 description:))))
				(StrSplitInTwo global186 global192 (temp0 description:))
				(Format @temp1 201 3 global186 global192) ; "The %s is way too left"
				(Memory memFREE global186)
				(Memory memFREE global192)
			)
		)
		((> (- (temp0 y:) [local25 (+ (* 2 local10) 1)]) 6)
			(if 1
				(= global186 (Memory memALLOC_CRIT (StrLen (temp0 description:))))
				(= global192 (Memory memALLOC_CRIT (StrLen (temp0 description:))))
				(StrSplitInTwo global186 global192 (temp0 description:))
				(Format @temp1 201 4 global186 global192) ; "The %s is way too right"
				(Memory memFREE global186)
				(Memory memFREE global192)
			)
		)
		((> (- [local25 (+ (* 2 local10) 1)] (temp0 y:)) 2)
			(if 1
				(= global186 (Memory memALLOC_CRIT (StrLen (temp0 description:))))
				(= global192 (Memory memALLOC_CRIT (StrLen (temp0 description:))))
				(StrSplitInTwo global186 global192 (temp0 description:))
				(Format @temp1 201 5 global186 global192) ; "The %s is a little too high."
				(Memory memFREE global186)
				(Memory memFREE global192)
			)
		)
		((> (- (temp0 y:) [local25 (+ (* 2 local10) 1)]) 2)
			(if 1
				(= global186 (Memory memALLOC_CRIT (StrLen (temp0 description:))))
				(= global192 (Memory memALLOC_CRIT (StrLen (temp0 description:))))
				(StrSplitInTwo global186 global192 (temp0 description:))
				(Format @temp1 201 6 global186 global192) ; "The %s is a little too low"
				(Memory memFREE global186)
				(Memory memFREE global192)
			)
		)
		((> (- [local25 (* 2 local10)] (temp0 x:)) 2)
			(if 1
				(= global186 (Memory memALLOC_CRIT (StrLen (temp0 description:))))
				(= global192 (Memory memALLOC_CRIT (StrLen (temp0 description:))))
				(StrSplitInTwo global186 global192 (temp0 description:))
				(Format @temp1 201 7 global186 global192) ; "The %s is a little too left"
				(Memory memFREE global186)
				(Memory memFREE global192)
			)
		)
		((and (> (- (temp0 y:) [local25 (+ (* 2 local10) 1)]) 2) 1)
			(= global186 (Memory memALLOC_CRIT (StrLen (temp0 description:))))
			(= global192 (Memory memALLOC_CRIT (StrLen (temp0 description:))))
			(StrSplitInTwo global186 global192 (temp0 description:))
			(Format @temp1 201 8 global186 global192) ; "The %s is a little too right"
			(Memory memFREE global186)
			(Memory memFREE global192)
		)
	)
	(Say dummy @temp1)
)

(procedure (localproc_3 &tmp temp0 temp1)
	(for ((= temp0 0)) (<= temp0 6) ((++ temp0))
		(= temp1 (partList at: temp0))
		(if (not temp0)
			(= temp1 lFace)
		)
		(if
			(and
				(<= (Abs (- [local25 (* 2 temp0)] (temp1 x:))) 2)
				(<= (Abs (- [local25 (+ 1 (* 2 temp0))] (temp1 y:))) 2)
			)
			(= local0 (<< $0001 (mod temp0 16)))
			(|= local1 local0)
		)
	)
)

(procedure (localproc_4)
	(Print 201 28) ; "MOUSE Click mouse on menu items, feature buttons, and arrows to cycle through each feature. Press and hold to move sliders."
	(Print 201 29) ; "KEYS Use TAB key to select features, arrow keys to move sliders, and alpha keys to select menu items. Use the N and B keys to select the next and previous feature."
	(Print 201 30) ; "JOYSTICK Move cursor to menus, arrows, selections, sliders, and press a button. Hold the button down to move sliders"
)

(instance rm201 of Rm
	(properties
		picture 201
	)

	(method (init &tmp temp0)
		(super init:)
		(hSelect init:)
		(fSelect init:)
		(nSelect init:)
		(eSelect init:)
		(mSelect init:)
		(brSelect init:)
		(beSelect init:)
		(hControl init:)
		(wControl init:)
		(redBox init:)
		(lArrow init:)
		(rArrow init:)
		(trashBut
			view: (proc0_20 2005 2006 2004 2004 2004)
			x: (proc0_20 28 28 23 23 23)
			init:
		)
		(quitBut
			view: (proc0_20 2005 2006 2004 2004 2004)
			x: (proc0_20 299 233 296 296 296)
			init:
		)
		(helpBut
			view: (proc0_20 2005 2006 2004 2004 2004)
			x: (proc0_20 250 167 255 255 255)
			init:
		)
		(searchBut
			view: (proc0_20 2005 2006 2004 2004 2004)
			x: (proc0_20 90 103 72 72 72)
			init:
		)
		(lFace init:)
		(cFace init:)
		(rFace init:)
		(dummy init:)
		(gTheIconBar at: 1)
		(gTheIconBar disable:)
		(butList add: trashBut searchBut quitBut)
		(partList add: cFace eye nose cMouth brow hair beard)
		(= local8 cFace)
		(= local3 (= local4 cFace))
		(gTheIconBar curIcon: (gTheIconBar at: 0))
		(gGame setCursor: 999 1 304 172)
		(if (IsFlag 81)
			(self setScript: bagLadyScript)
		else
			(self setScript: runDraw)
		)
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
		(partList release: dispose:)
		(butList release: dispose:)
		(super dispose:)
	)
)

(instance runDraw of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(cond
					((not local8) 0)
					((and (!= local4 local3) (>= local2 5))
						(= local3 local4)
						(self dispose:)
						(gCurRoom setScript: describeScript)
					)
					((== local8 cFace)
						(= temp0 (/ (- (wControl x:) 123) 5))
						(lFace x: (- 98 temp0))
						(rFace x: (+ 146 temp0))
					)
					(else
						(local8 x: (wControl x:) y: (hControl y:))
					)
				)
				(= cycles 1)
			)
			(1
				(self init:)
			)
		)
	)
)

(instance searchScript of rmnScript
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(localproc_1 201 9 20 (LangSwitch 170 175) (LangSwitch 70 150)) ; "searching..."
				(= seconds 1)
			)
			(1
				(Graph
					grFILL_BOX
					(LangSwitch 170 175)
					20
					(LangSwitch 180 185)
					(LangSwitch 70 150)
					1
					0
					-1
					-1
				)
				(Graph
					grUPDATE_BOX
					(LangSwitch 170 175)
					20
					(LangSwitch 180 185)
					(LangSwitch 70 150)
					1
				)
				(if (< local5 3)
					(= state -1)
					(++ local5)
				)
				(= seconds 1)
			)
			(2
				(localproc_3)
				(if (and (== local1 127) (or (IsFlag 81) (IsFlag 142)))
					(SetScore 142 20)
					(gCast eachElementDo: #dispose)
					(Animate (gCast elements:) 0)
					(mug1 init:)
					(mug2 init:)
					(mug3 init:)
					(butList delete: searchBut trashBut eachElementDo: #init)
					(ClearFlag 81)
					(SetFlag 74)
					(+= state 1)
					(dummy init:)
					(Say dummy 201 10) ; "THAT'S THE RUMMY! The one there in the middle. I'd never furget his mean looking mug."
					(= seconds 8)
				else
					(= save1 1)
					(localproc_1 ; "No Match"
						201
						11
						20
						(LangSwitch 170 175)
						(LangSwitch 70 150)
					)
					(= seconds 3)
				)
			)
			(3
				(Graph
					grFILL_BOX
					(LangSwitch 170 175)
					20
					(LangSwitch 180 185)
					(LangSwitch 70 150)
					1
					0
					-1
					-1
				)
				(Graph
					grUPDATE_BOX
					(LangSwitch 170 175)
					20
					(LangSwitch 180 185)
					(LangSwitch 70 150)
					1
				)
				(gCurRoom setScript: runDraw)
				(self dispose:)
			)
			(4
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(mug1 dispose:)
				(mug3 dispose:)
				(mug2 posn: 47 105 forceUpd:)
				(= cycles 2)
			)
			(5
				(localproc_1 201 12 100 20 70) ; "Steve Rocklin"
				(localproc_1 201 13 100 30 (LangSwitch 100 150)) ; "M/W 6'2" 210 red/hzl"
				(localproc_1 201 14 100 40 100) ; "d.o.b. 1/10/50."
				(localproc_1 201 15 100 50 100) ; "Address Jan/89"
				(localproc_1 201 16 100 60 100) ; "214 Pigeon Ct."
				(localproc_1 201 17 100 70 100) ; "Gibbon U.S.A."
				(localproc_1 201 18 100 90 100) ; "SUMMARY"
				(localproc_1 201 19 (LangSwitch 10 2) 110 (LangSwitch 250 270)) ; "Convicted on two counts of burglary 6/23/85. Sentenced to 5 years in state penitentiary. Paroled 6/25/88 and is currently serving 3 years probation."
				(localproc_1 201 20 100 140 65) ; "NO WANTS"
				(localproc_1 201 21 (LangSwitch 10 2) 150 (LangSwitch 250 270)) ; "NOTE: Rocklin associates with, and at one time was known to be a member of the cult "Sons of Darkness." It is suspicioned the cult deals in the sale of "crack" cocaine."
				(self dispose:)
			)
		)
	)
)

(instance bagLadyScript of rmnScript
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(= save1 1)
				(dummy x: 0)
				(Say dummy 201 22) ; "Now, if you would give a general description."
				(= seconds 4)
			)
			(2
				(dummy x: 310)
				(= save1 1)
				(Say dummy 201 23) ; "He was a mean lookin' fella, all dark and hairy."
				(= seconds 4)
			)
			(3
				(= save1 1)
				(Say dummy 201 24) ; "A real sour face with a hawkish nose, sharp, beady eyes and a leery brow."
				(= seconds 4)
			)
			(4
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= local4 cFace)
				(++ local2)
				(localproc_0 0 cFace)
				(gCurRoom setScript: runDraw)
				(self dispose:)
			)
		)
	)
)

(instance timerScript of rmnScript
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(gCurRoom setScript: describeScript)
				(self dispose:)
			)
		)
	)
)

(instance describeScript of rmnScript
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= cycles 6)
			)
			(1
				(if (IsFlag 81)
					(= save1 1)
					(switch local10
						(0
							(cond
								((>= (- 96 (lFace x:)) 4)
									(Say dummy 201 25) ; "Naw his face is too wide."
								)
								((>= (- (lFace x:) 96) 4)
									(Say dummy 201 26) ; "Naw his face is too narrow."
								)
								(else
									(= local0 (<< $0001 (mod local10 16)))
									(|= local1 local0)
									(Say dummy 201 27) ; "Yea his face look right."
								)
							)
						)
						(5
							(if (== (hair cel:) 7)
								(localproc_2)
							else
								(Say dummy 505 (+ (hair cel:) 0))
							)
						)
						(1
							(if (== (eye cel:) 15)
								(localproc_2)
							else
								(Say dummy 505 (+ (eye cel:) 8))
							)
						)
						(2
							(if (== (nose cel:) 13)
								(localproc_2)
							else
								(Say dummy 505 (+ (nose cel:) 24))
							)
						)
						(3
							(if (== (cMouth cel:) 12)
								(localproc_2)
							else
								(Say dummy 505 (+ (cMouth cel:) 39))
							)
						)
						(4
							(if (== (brow cel:) 8)
								(localproc_2)
							else
								(Say dummy 505 (+ (brow cel:) 52))
							)
						)
						(6
							(if (== (beard cel:) 4)
								(localproc_2)
							else
								(Say dummy 505 (+ (beard cel:) 62))
							)
						)
					)
					(= seconds 6)
				else
					(= cycles 1)
				)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(self dispose:)
				(gCurRoom setScript: runDraw)
			)
		)
	)
)

(instance fSelect of Feature
	(properties
		nsTop 17
		nsLeft 273
		nsBottom 38
		nsRight 300
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

	(method (handleEvent event)
		(switch (event type:)
			(evKEYBOARD
				(if (and (== (event message:) KEY_RETURN) (MousedOn self event))
					(= local4 self)
					(++ local2)
					(localproc_0 0 cFace)
					(event claimed: 1)
				)
			)
			(evMOUSEBUTTON
				(if (and (MousedOn self event) (== (gCurRoom script:) runDraw))
					(= local4 self)
					(++ local2)
					(localproc_0 0 cFace)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance eSelect of Feature
	(properties
		nsTop 41
		nsLeft 273
		nsBottom 62
		nsRight 300
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

	(method (handleEvent event)
		(switch (event type:)
			(evKEYBOARD
				(if (and (== (event message:) KEY_RETURN) (MousedOn self event))
					(= local4 self)
					(++ local2)
					(localproc_0 1 eye)
					(event claimed: 1)
				)
			)
			(evMOUSEBUTTON
				(if (and (MousedOn self event) (== (gCurRoom script:) runDraw))
					(= local4 self)
					(++ local2)
					(localproc_0 1 eye)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance nSelect of Feature
	(properties
		nsTop 65
		nsLeft 273
		nsBottom 86
		nsRight 300
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

	(method (handleEvent event)
		(switch (event type:)
			(evKEYBOARD
				(if (and (== (event message:) KEY_RETURN) (MousedOn self event))
					(= local4 self)
					(++ local2)
					(localproc_0 2 nose)
					(event claimed: 1)
				)
			)
			(evMOUSEBUTTON
				(if (and (MousedOn self event) (== (gCurRoom script:) runDraw))
					(= local4 self)
					(++ local2)
					(localproc_0 2 nose)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance mSelect of Feature
	(properties
		nsTop 89
		nsLeft 273
		nsBottom 110
		nsRight 300
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

	(method (handleEvent event)
		(switch (event type:)
			(evKEYBOARD
				(if (and (== (event message:) KEY_RETURN) (MousedOn self event))
					(= local4 self)
					(++ local2)
					(localproc_0 3 cMouth)
					(event claimed: 1)
				)
			)
			(evMOUSEBUTTON
				(if (and (MousedOn self event) (== (gCurRoom script:) runDraw))
					(= local4 self)
					(++ local2)
					(localproc_0 3 cMouth)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance brSelect of Feature
	(properties
		nsTop 113
		nsLeft 273
		nsBottom 134
		nsRight 300
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

	(method (handleEvent event)
		(switch (event type:)
			(evKEYBOARD
				(if (and (== (event message:) KEY_RETURN) (MousedOn self event))
					(= local4 self)
					(++ local2)
					(localproc_0 4 brow)
					(event claimed: 1)
				)
			)
			(evMOUSEBUTTON
				(if (and (MousedOn self event) (== (gCurRoom script:) runDraw))
					(= local4 self)
					(++ local2)
					(localproc_0 4 brow)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance hSelect of Feature
	(properties
		nsTop 137
		nsLeft 273
		nsBottom 158
		nsRight 300
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

	(method (handleEvent event)
		(switch (event type:)
			(evKEYBOARD
				(if (and (== (event message:) KEY_RETURN) (MousedOn self event))
					(= local4 self)
					(++ local2)
					(localproc_0 5 hair)
					(event claimed: 1)
				)
			)
			(evMOUSEBUTTON
				(if (and (MousedOn self event) (== (gCurRoom script:) runDraw))
					(= local4 self)
					(++ local2)
					(localproc_0 5 hair)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance beSelect of Feature
	(properties
		nsTop 161
		nsLeft 273
		nsBottom 182
		nsRight 300
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

	(method (handleEvent event)
		(switch (event type:)
			(evKEYBOARD
				(if (and (== (event message:) KEY_RETURN) (MousedOn self event))
					(= local4 self)
					(++ local2)
					(localproc_0 6 beard)
					(event claimed: 1)
				)
			)
			(evMOUSEBUTTON
				(if (and (MousedOn self event) (== (gCurRoom script:) runDraw))
					(= local4 self)
					(++ local2)
					(localproc_0 6 beard)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance lFace of Prop
	(properties
		x 101
		y 137
		description {face}
		view 2001
		priority 2
		signal 22545
	)
)

(instance rFace of Prop
	(properties
		x 143
		y 137
		description {face}
		view 2001
		cel 2
		priority 2
		signal 22545
	)
)

(instance cFace of View
	(properties
		x 122
		y 137
		description {face}
		view 2001
		cel 1
		priority 1
		signal 16401
	)
)

(instance nose of Prop
	(properties
		x 122
		y 112
		description {nose}
		view 811
		loop 2
		priority 10
		signal 22544
	)
)

(instance eye of Prop
	(properties
		x 120
		y 93
		description {eyes}
		view 811
		loop 1
		priority 10
		signal 22545
	)
)

(instance cMouth of Prop
	(properties
		x 120
		y 123
		description {mouth}
		view 811
		loop 3
		priority 10
		signal 22545
	)
)

(instance hair of Prop
	(properties
		x 123
		y 74
		description {hair}
		view 2000
		priority 14
		signal 22545
	)
)

(instance brow of Prop
	(properties
		x 123
		y 85
		description {brow}
		view 811
		loop 5
		priority 13
		signal 22545
	)
)

(instance beard of Prop
	(properties
		x 123
		y 108
		description {beard}
		view 811
		loop 6
		priority 14
		signal 22545
	)
)

(instance dummy of Prop
	(properties
		x 310
		y 160
		view 811
		loop 4
		priority 1
		signal 22544
	)
)

(instance lArrow of Prop
	(properties
		x 265
		y 33
		loop 9
		cel 1
		signal 22545
	)

	(method (init)
		(super init:)
		(= view (proc0_20 2005 2006 2004 2004 2004))
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evKEYBOARD
				(if
					(and
						(or
							(== (event message:) (proc0_20 98 112 98 98 98))
							(== (event message:) (proc0_20 66 80 66 66 66))
							(and
								(== (event message:) KEY_RETURN)
								(MousedOn self event)
							)
						)
						(!= local8 cFace)
						(== (gCurRoom script:) runDraw)
					)
					(if local9
						(-- local9)
					else
						(= local9 (local8 lastCel:))
					)
					(local8 cel: local9 forceUpd:)
					(self setScript: timerScript)
					(event claimed: 1)
				)
			)
			(evMOUSEBUTTON
				(if
					(and
						(!= local8 cFace)
						(== (gCurRoom script:) runDraw)
						(MousedOn self event)
					)
					(if local9
						(-- local9)
					else
						(= local9 (local8 lastCel:))
					)
					(local8 cel: local9 forceUpd:)
					(self setScript: timerScript)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance rArrow of Prop
	(properties
		x 309
		y 33
		loop 9
		cel 2
		signal 22545
	)

	(method (init)
		(super init:)
		(= view (proc0_20 2005 2006 2004 2004 2004))
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evKEYBOARD
				(if
					(and
						(or
							(and
								(== (event message:) KEY_RETURN)
								(MousedOn self event)
							)
							(== (event message:) KEY_n)
							(== (event message:) KEY_N)
						)
						(== (gCurRoom script:) runDraw)
						(!= local8 cFace)
					)
					(if (< local9 (local8 lastCel:))
						(++ local9)
					else
						(= local9 0)
					)
					(local8 cel: local9 forceUpd:)
					(self setScript: timerScript)
				)
			)
			(evMOUSEBUTTON
				(if
					(and
						(!= local8 cFace)
						(== (gCurRoom script:) runDraw)
						(MousedOn self event)
					)
					(if (< local9 (local8 lastCel:))
						(++ local9)
					else
						(= local9 0)
					)
					(local8 cel: local9 forceUpd:)
					(self setScript: timerScript)
				)
			)
		)
	)
)

(instance trashBut of Prop
	(properties
		x 23
		y 12
		loop 10
		signal 22545
	)

	(method (init)
		(= x (proc0_20 28 28 23 23 23))
		(= view (proc0_20 2005 2006 2004 2004 2004))
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evKEYBOARD
				(if
					(or
						(== (event message:) (proc0_20 108 100 99 99 99))
						(== (event message:) (proc0_20 76 68 67 67 67))
						(and (== (event message:) KEY_RETURN) (MousedOn self event))
					)
					(= local1 (= local2 0))
					(self setCycle: Beg)
					(nose dispose:)
					(eye dispose:)
					(cMouth dispose:)
					(hair startUpd: dispose:)
					(brow dispose:)
					(beard dispose:)
					(= local8 cFace)
					(wControl x: (cFace x:))
					(rArrow y: 34)
					(lArrow y: 34)
					(local8 cel: 1 init:)
					(= local10 0)
					(Animate (gCast elements:) 0)
					(localproc_0 local10 (partList at: local10))
					(gCurRoom setScript: runDraw)
					(event claimed: 1)
				)
			)
			(evMOUSEBUTTON
				(if (and (== (gCurRoom script:) runDraw) (MousedOn self event))
					(= local1 (= local2 0))
					(self setCycle: Beg)
					(nose dispose:)
					(eye dispose:)
					(cMouth dispose:)
					(hair startUpd: dispose:)
					(brow dispose:)
					(beard dispose:)
					(= local8 cFace)
					(wControl x: (cFace x:))
					(rArrow y: 34)
					(lArrow y: 34)
					(local8 cel: 1 init:)
					(= local10 0)
					(Animate (gCast elements:) 0)
					(localproc_0 local10 (partList at: local10))
					(gCurRoom setScript: runDraw)
					(event claimed: 1)
				)
			)
		)
	)
)

(class mySlider of Actor
	(properties
		yStep 1
		xStep 1
		type 0
		sView 0
		sLoop 0
		sCel 0
		sTop 0
		sLeft 0
		maxV 0
		minV 0
	)

	(method (init)
		((View new:) view: sView loop: sLoop cel: sCel x: sLeft y: sTop init:)
		(self view: sView loop: sLoop cel: 0 signal: 6144)
		(super init:)
	)

	(method (doit &tmp temp0 temp1)
		(= temp0 (User curEvent:))
		(cond
			((& (temp0 type:) evMOUSEBUTTON)
				(if (and (== (gCurRoom script:) runDraw) (self onMe: temp0))
					(= local6 1)
					(= local7 self)
					(temp0 dispose:)
				)
			)
			((and (& (temp0 type:) evKEYBOARD) (self onMe: temp0))
				(if (and (== (gCurRoom script:) runDraw) (self onMe: temp0))
					(= local6 1)
					(= local7 self)
					(temp0 dispose:)
				)
			)
			((& (temp0 type:) evJOYUP)
				(temp0 dispose:)
				(= local6 0)
				(= local7 0)
			)
			((& (temp0 type:) evMOUSERELEASE)
				(temp0 dispose:)
				(= local6 0)
				(= local7 0)
			)
			(local6
				(switch (local7 type:)
					(0
						(if
							(and
								(> gMouseY (local7 minV:))
								(< gMouseY (local7 maxV:))
							)
							(local7 y: (- gMouseY 10))
						)
					)
					(1
						(if
							(and
								(> gMouseX (local7 minV:))
								(< gMouseX (local7 maxV:))
							)
							(local7 x: gMouseX)
						)
					)
				)
			)
		)
		(temp0 dispose:)
		(super doit:)
	)
)

(instance wControl of mySlider
	(properties
		x 122
		y 164
		type 1
		sView 811
		sLoop 8
		sCel 1
		sTop 159
		sLeft 92
		maxV 146
		minV 101
	)
)

(instance hControl of mySlider
	(properties
		x 36
		y 88
		sView 811
		sLoop 7
		sCel 1
		sTop 48
		sLeft 31
		maxV 145
		minV 64
	)
)

(instance redBox of Prop
	(properties
		x 287
		y 39
		view 811
		loop 13
		signal 22545
	)
)

(instance quitBut of Prop
	(properties
		x 296
		y 12
		loop 11
		signal 22545
	)

	(method (init)
		(= x (proc0_20 299 233 296 296 296))
		(= view (proc0_20 2005 2006 2004 2004 2004))
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

	(method (handleEvent event)
		(switch (event type:)
			(evKEYBOARD
				(cond
					((== (event message:) KEY_TAB)
						(if (== (gCurRoom script:) runDraw)
							(if (== local10 6)
								(= local10 0)
							else
								(++ local10)
							)
							(= local4 (partList at: local10))
							(localproc_0 local10 (partList at: local10))
						)
						(event claimed: 1)
					)
					(
						(or
							(== (event message:) (proc0_20 101 97 113 113 113))
							(== (event message:) (proc0_20 69 65 81 81 81))
							(and
								(== (event message:) KEY_RETURN)
								(MousedOn self event)
							)
						)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(self cel: 1)
						(Animate (gCast elements:) 0)
						(gCurRoom newRoom: gPrevRoomNum)
						(event claimed: 1)
					)
				)
			)
			(evMOUSEBUTTON
				(if (MousedOn self event)
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(self cel: 1)
					(Animate (gCast elements:) 0)
					(gCurRoom newRoom: gPrevRoomNum)
					(event claimed: 1)
				)
			)
			($0044 ; direction | evKEYBOARD
				(if (== (gCurRoom script:) runDraw)
					(switch (event message:)
						(JOY_RIGHT
							(if (< (wControl x:) 146)
								(wControl x: (+ (wControl x:) 1))
							)
						)
						(JOY_LEFT
							(if (> (wControl x:) 101)
								(wControl x: (- (wControl x:) 1))
							)
						)
					)
					(switch (event message:)
						(JOY_UP
							(if (> (hControl y:) 54)
								(hControl y: (- (hControl y:) 1))
							)
						)
						(JOY_DOWN
							(if (< (hControl y:) 135)
								(hControl y: (+ (hControl y:) 1))
							)
						)
					)
				)
				(event claimed: 1)
			)
		)
	)
)

(instance searchBut of Prop
	(properties
		x 72
		y 12
		loop 12
		signal 22545
	)

	(method (init)
		(= x (proc0_20 90 103 72 72 72))
		(= view (proc0_20 2005 2006 2004 2004 2004))
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evKEYBOARD
				(if
					(or
						(and
							(== (gCurRoom script:) runDraw)
							(or
								(==
									(event message:)
									(proc0_20 118 98 115 115 115)
								)
								(== (event message:) (proc0_20 86 66 83 83 83))
							)
						)
						(and
							(== (event message:) KEY_RETURN)
							(MousedOn self event)
							(== (gCurRoom script:) runDraw)
						)
					)
					(self setCycle: Beg)
					(= local5 0)
					(gCurRoom setScript: searchScript)
					(event claimed: 1)
				)
			)
			(evMOUSEBUTTON
				(if (and (== (gCurRoom script:) runDraw) (MousedOn self event))
					(self setCycle: Beg)
					(= local5 0)
					(gCurRoom setScript: searchScript)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance partList of List
	(properties)
)

(instance butList of List
	(properties)
)

(instance mug1 of Prop
	(properties
		x 47
		y 105
		view 810
		loop 1
		priority 14
		signal 22545
	)
)

(instance mug2 of Prop
	(properties
		x 125
		y 105
		view 810
		loop 1
		cel 1
		priority 14
		signal 22545
	)
)

(instance mug3 of Prop
	(properties
		x 202
		y 105
		view 810
		loop 1
		cel 2
		priority 14
		signal 22545
	)
)

(instance helpBut of Prop
	(properties
		x 255
		y 12
		loop 14
		signal 22545
	)

	(method (init)
		(= x (proc0_20 250 167 255 255 255))
		(= view (proc0_20 2005 2006 2004 2004 2004))
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evKEYBOARD
				(if
					(or
						(== (event message:) (proc0_20 104 121 104 104 104))
						(== (event message:) (proc0_20 72 89 72 72 72))
						(and (== (event message:) KEY_RETURN) (MousedOn self event))
					)
					(localproc_4)
					(event claimed: 1)
				)
			)
			(evMOUSEBUTTON
				(if (MousedOn self event)
					(localproc_4)
					(event claimed: 1)
				)
			)
		)
	)
)

