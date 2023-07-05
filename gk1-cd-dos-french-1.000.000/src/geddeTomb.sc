;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 325)
(include sci.sh)
(use Main)
(use n013)
(use Inset)
(use Polygon)
(use Feature)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	geddeTomb 0
)

(local
	local0
	local1 = 150
	local2 = 90
	local3 = 150
	local4 = 90
	local5 = 150
	local6 = 90
	local7
	local8
	local9 = 1
	local10 = 1
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	local20
	local21
	local22
	local23
	local24
	local25
	local26
	local27
	local28
	local29
	local30
	local31
	local32
	local33
	local34
	local35
	local36
	local37
	local38
	local39
)

(instance geddeTomb of Room
	(properties
		noun 1
		picture 325
		style 14
		exitStyle 13
	)

	(method (init)
		(Load rsPIC 325)
		(= local17
			((Polygon new:)
				type: PTotalAccess
				init: 265 27 265 22 55 22 55 27 107 38 218 38
				yourself:
			)
		)
		(= local18
			((Polygon new:)
				type: PTotalAccess
				init: 120 61 208 61 208 100 120 100
				yourself:
			)
		)
		(= local19
			((Polygon new:) type: PTotalAccess init: 55 50 88 59 88 108 55 135 yourself:)
		)
		(= local20
			((Polygon new:)
				type: PTotalAccess
				init: 265 131 265 51 237 59 237 108
				yourself:
			)
		)
		(= local21
			((Polygon new:)
				type: PTotalAccess
				init: 97 145 230 145 210 126 116 126
				yourself:
			)
		)
		(= local22
			((Polygon new:)
				type: PTotalAccess
				init: 55 145 97 145 116 126 88 108 55 135
				yourself:
			)
		)
		(= local23
			((Polygon new:)
				type: PTotalAccess
				init: 265 145 265 131 237 108 210 126 230 145
				yourself:
			)
		)
		(= local24
			((Polygon new:) type: PTotalAccess init: 55 27 55 50 88 59 107 38 yourself:)
		)
		(= local25
			((Polygon new:) type: PTotalAccess init: 265 51 265 27 218 38 237 59 yourself:)
		)
		(= local26
			((Polygon new:) type: PTotalAccess init: 107 38 218 38 208 61 120 61 yourself:)
		)
		(= local27
			((Polygon new:)
				type: PTotalAccess
				init: 116 126 210 126 208 100 120 100
				yourself:
			)
		)
		(= local28
			((Polygon new:) type: PTotalAccess init: 88 59 88 108 120 100 120 61 yourself:)
		)
		(= local29
			((Polygon new:)
				type: PTotalAccess
				init: 208 61 208 100 237 108 237 59
				yourself:
			)
		)
		(= local30 ((Polygon new:) type: PTotalAccess init: 120 61 107 38 88 59 yourself:))
		(= local31
			((Polygon new:) type: PTotalAccess init: 208 61 237 59 218 38 yourself:)
		)
		(= local32
			((Polygon new:) type: PTotalAccess init: 120 100 88 108 116 126 yourself:)
		)
		(= local33
			((Polygon new:) type: PTotalAccess init: 208 100 210 126 237 108 yourself:)
		)
		(= local13 local18)
		(= local34
			((Polygon new:)
				type: PTotalAccess
				init: 102 122 124 115 136 119 148 126 173 117 197 121 189 129 154 135 141 128 132 130 111 132
				yourself:
			)
		)
		(= local35
			((Polygon new:) type: PTotalAccess init: 177 31 177 51 152 51 152 31 yourself:)
		)
		(= local36
			((Polygon new:)
				type: PTotalAccess
				init: 143 64 144 111 115 111 115 64
				yourself:
			)
		)
		(= local37
			((Polygon new:)
				type: PTotalAccess
				init: 176 64 176 110 150 110 150 64
				yourself:
			)
		)
		(= local38
			((Polygon new:)
				type: PTotalAccess
				init: 210 65 212 110 184 110 184 64
				yourself:
			)
		)
		(= local39
			((Polygon new:)
				type: PTotalAccess
				init: 264 98 264 118 252 118 252 98
				yourself:
			)
		)
		(exitButton init:)
		(gGkMusic1
			setLoop: -1
			number: 325
			play:
			setVol: 0
			fade: (gGkMusic1 musicVolume:) 25 10 0
		)
		(super init:)
		(RemapColors 1 254 64 136 80) ; ByRange
		(RemapColors 1 253 64 136 80) ; ByRange
		(gTheIconBar disable: 0)
		(self setScript: walkIn)
	)

	(method (doit)
		(if
			(and
				(not local0)
				(IsFlag 416)
				(not (self script:))
				(gEgo has: 73) ; lit_flash
			)
			(= local0 1)
			(torch init:)
		)
		(super doit:)
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(if (and local0 (== theVerb 129)) ; lit_flash
			(= local3 ((User curEvent:) x:))
			(= local4 ((User curEvent:) y:))
			(if (< local3 55)
				(= local3 55)
			)
			(if (> local3 265)
				(= local3 265)
			)
			(if (< local4 22)
				(= local4 22)
			)
			(if (> local4 145)
				(= local4 145)
			)
			(= local5 local1)
			(= local6 local2)
			(= local7 (- local3 local5))
			(= local8 (- local4 local6))
			(= local9
				(if (>= local7 0)
					1
				else
					(*= local7 -1)
					-1
				)
			)
			(= local10
				(if (>= local8 0)
					1
				else
					(*= local8 -1)
					-1
				)
			)
			(= local11 0)
			(= local12 (if (>= local7 local8) 1 else 0))
		else
			(switch theVerb
				(7 ; Look
					(gMessager say: 1 7 3 0) ; "Gabriel can't see anything in the dark."
				)
				(11 ; Talk
					(gMessager say: 1 11 0 0) ; "(WHISPERING)Is anybody here?"
				)
				(10 ; Ask
					(gMessager say: 1 10 0 0) ; "Gabriel doesn't see anything in here that looks up to answering a few questions."
				)
				(129 ; lit_flash
					(SetFlag 416)
					(gEgo getPoints: 387 1)
					((gTheIconBar curIcon:) cursorCel: 8)
					((gTheIconBar curInvIcon:) mainCel: 8 cel: 8 cursorCel: 8)
					(if (gGame barUp:)
						(gTheIconBar showInvItem: 1)
					)
					(gTheCursor setCel: 8)
					(if (< (= temp1 gMouseX) 55)
						(= temp1 55)
					)
					(if (> temp1 264)
						(= temp1 264)
					)
					(torch x: (= local5 (= local3 (= local1 temp1))))
					(torch y: (= local6 (= local4 (= local2 (- gMouseY 10)))))
				)
				(else
					(gMessager say: 1 0 3 0) ; "Gabriel can't do that in the dark."
				)
			)
		)
		(return 1)
	)

	(method (dispose)
		(UnLoad 129 325)
		(local17 dispose:)
		(local18 dispose:)
		(local19 dispose:)
		(local20 dispose:)
		(local21 dispose:)
		(local22 dispose:)
		(local23 dispose:)
		(local24 dispose:)
		(local25 dispose:)
		(local26 dispose:)
		(local27 dispose:)
		(local28 dispose:)
		(local29 dispose:)
		(local30 dispose:)
		(local31 dispose:)
		(local32 dispose:)
		(local33 dispose:)
		(local34 dispose:)
		(local35 dispose:)
		(local36 dispose:)
		(local37 dispose:)
		(local38 dispose:)
		(local39 dispose:)
		(RemapColors 0) ; Off
		(if (IsFlag 416)
			(ClearFlag 416)
			((gInventory at: 73) mainCel: 9 cursorCel: 9 cel: 9) ; lit_flash
			(if
				(and
					(gGame barUp:)
					(== (gTheIconBar curInvIcon:) (gInventory at: 73)) ; lit_flash
				)
				(gTheIconBar showInvItem: 1)
			)
		)
		(gGkMusic1 fade:)
		(gTheIconBar enable: 0)
		(super dispose:)
	)
)

(instance outtaHere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local0
					(= local3 260)
					(= local4 109)
					(= local5 local1)
					(= local6 local2)
					(= local7 (- local3 local5))
					(= local8 (- local4 local6))
					(= local9
						(if (>= local7 0)
							1
						else
							(*= local7 -1)
							-1
						)
					)
					(= local10
						(if (>= local8 0)
							1
						else
							(*= local8 -1)
							-1
						)
					)
					(= local11 0)
					(= local12 (if (>= local7 local8) 1 else 0))
					(= local16 1)
					(exitButton hide: loop: 0)
				else
					(+= state 1)
					(= seconds 1)
				)
			)
			(1
				(gGkSound1 setLoop: 1 number: 316 play:)
				(exitButton setCycle: End self)
			)
			(2
				(exitButton dispose:)
				(if local0
					(torch dispose:)
				)
				(wayOut init: setCycle: CT 6 1 self)
				(gGkSound1 setLoop: 1 number: 301 play:)
			)
			(3
				(gGame handsOn:)
				(wayOut dispose:)
				(gCurRoom newRoom: 320)
			)
		)
	)
)

(instance walkIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(enterView init:)
				(= seconds 3)
			)
			(1
				(gGkSound1 setLoop: 1 number: 301 play:)
				(enterView setCycle: End self)
			)
			(2
				(if (IsFlag 362)
					(= cycles 1)
				else
					(gMessager say: 9 0 2 0 self) ; "Damn! You'd think there'd be a light!"
				)
			)
			(3
				(enterView dispose:)
				(self dispose:)
				(SetFlag 362)
				(gGame handsOn:)
			)
		)
	)
)

(instance plaqueMessage of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gMessager say: 10 7 9 1 self) ; "(GK-AM2)The plaque on the drawer has a name etched on it:"
			)
			(1
				(= temp0 (+ 1 (mod (+ 1 local14 (* 3 local15)) 9)))
				(gMessager say: 10 7 9 temp0 self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance openADrawer of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and register (== local1 local3) (== local2 local4))
			(= register 0)
			(self changeState: (++ state))
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local3 (+ 96 (* local14 33)))
				(= local4 (+ 57 (* local15 15)))
				(= local5 local1)
				(= local6 local2)
				(= local7 (- local3 local5))
				(= local8 (- local4 local6))
				(= local9
					(if (>= local7 0)
						1
					else
						(*= local7 -1)
						-1
					)
				)
				(= local10
					(if (>= local8 0)
						1
					else
						(*= local8 -1)
						-1
					)
				)
				(= local11 0)
				(= local12 (if (>= local7 local8) 1 else 0))
				(= register 1)
			)
			(1
				(aDrawer
					view: 3280
					loop:
						(if (and (== local14 2) (== local15 2)) 0 else local14)
					cel: 0
					x: local1
					y: local2
					init:
					setCycle: End self
				)
				(gGkSound1 setLoop: 1 number: 302 play:)
				(= local0 0)
				(torch dispose:)
			)
			(2
				(if (if (and (== local14 2) (== local15 2)) 0 else local14)
					(= cycles 1)
				else
					(aDrawer
						view: (if (IsFlag 357) 3282 else 3281)
						loop: 0
						cel: 0
						setCycle: End self
					)
					(if (not (IsFlag 357))
						(gEgo getPoints: -999 2)
					)
				)
			)
			(3
				(= seconds 2)
			)
			(4
				(seeWhatsOnTheSlab init: self geddeTomb 1)
			)
			(5
				(gGame handsOff:)
				(if
					(or
						(if (and (== local14 2) (== local15 2)) 0 else local14)
						(IsFlag 357)
					)
					(if (if (and (== local14 2) (== local15 2)) 0 else local14)
						(= cycles 1)
					else
						(aDrawer setCycle: Beg self)
					)
				else
					(aDrawer view: 329 loop: 0 cel: 0 x: 172 setCycle: End self)
					(gGkSound1 setLoop: 1 number: 311 play:)
				)
			)
			(6
				(if
					(or
						(if (and (== local14 2) (== local15 2)) 0 else local14)
						(IsFlag 357)
					)
					(aDrawer
						view: 3280
						loop:
							(if (and (== local14 2) (== local15 2))
								0
							else
								local14
							)
						cel: (aDrawer lastCel:)
						setCycle: Beg self
					)
					(gGkSound1 setLoop: 1 number: 302 play:)
				else
					(gMessager say: 2 6 5 2 self) ; "Shit! I dropped my flashlight!"
				)
			)
			(7
				(if
					(or
						(if (and (== local14 2) (== local15 2)) 0 else local14)
						(IsFlag 357)
					)
					(= local0 1)
					(torch init: posn: local1 local2)
					(gGame handsOn:)
					(aDrawer dispose:)
					(self dispose:)
				else
					(gGkSound1 setLoop: 1 number: 303 play:)
					(gMessager say: 2 6 5 3 self) ; "Huh?"
				)
			)
			(8
				(gMessager say: 2 6 5 4) ; "<THUNK!>"
				(aDrawer loop: 1 cel: 0 posn: 142 123 setCycle: End self)
				(gGkSound1 setLoop: 1 number: 312 play:)
			)
			(9
				(for ((= temp0 100)) (> temp0 0) ((-= temp0 8))
					(Palette 2 0 256 temp0) ; PalIntensity
					(FrameOut)
				)
				(= cycles 1)
			)
			(10
				(SetFlag 357)
				(aDrawer loop: 2 cel: 0)
				(= seconds 2)
			)
			(11
				(gMessager say: 2 6 5 5 self) ; "Sometime later...."
				(for ((= temp0 0)) (< temp0 100) ((++ temp0))
					(Palette 2 0 256 temp0) ; PalIntensity
					(FrameOut)
				)
			)
			(12
				(gMessager say: 2 6 5 6 self) ; "Ouch! My head! What the hell was that?"
				(aDrawer setCycle: End self)
			)
			(13 1)
			(14
				(aDrawer loop: 3 cel: 0)
				(gEgo put: 73) ; lit_flash
				(gCurRoom setScript: findsTheLight)
			)
		)
	)
)

(instance findsTheLight of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(aDrawer setCycle: End self)
			)
			(1
				(aDrawer dispose:)
				(gGkSound1 setLoop: 1 number: 313 play:)
				(= seconds 1)
			)
			(2
				(torch posn: local1 local2 init:)
				(= local0 1)
				(gEgo get: 73) ; lit_flash
				(= temp0 (gTheIconBar useIconItem:))
				(= temp1 (gInventory at: 73)) ; lit_flash
				(gTheIconBar curInvIcon: temp1 curIcon: temp0 enableIcon: temp0)
				(temp0
					cursorView: (temp1 cursorView:)
					cursorLoop: (temp1 cursorLoop:)
					cursorCel: (temp1 cursorCel:)
				)
				(if (gGame keepBar:)
					(gTheIconBar showInvItem: 1)
				)
				(gGame setCursor: (gTheIconBar getCursor:))
				(gGame oldCurIcon: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance yikes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 1)
			)
			(1
				(gMessager say: 2 6 5 1 self) ; "(HORRIFIED--JUST FOUND MOSELY 'DEAD')Mosely!"
			)
			(2
				(seeWhatsOnTheSlab dispose:)
				(self dispose:)
			)
		)
	)
)

(instance seeWhatsOnTheSlab of Inset
	(properties
		view 328
		x 93
		y 52
		disposeNotOnMe 1
		modNum 325
		noun 7
	)

	(method (init)
		(= disposeNotOnMe
			(if
				(and
					(not
						(if (and (== local14 2) (== local15 2)) 0 else local14)
					)
					(not (IsFlag 357))
				)
				0
			else
				1
			)
		)
		(self priority: 12)
		(super init: &rest)
		(plaque init:)
		(cond
			((if (and (== local14 2) (== local15 2)) 0 else local14)
				(demBones init: setPri: 13)
				(UpdateScreenItem demBones)
				(gGame handsOn:)
			)
			((IsFlag 357)
				(gGame handsOn:)
				(if (not (IsFlag 393))
					(walletView init: setPri: 13)
				)
			)
			(else
				(moselyAAAGH init: setPri: 13)
				(UpdateScreenItem moselyAAAGH)
				(self setScript: yikes)
			)
		)
		(UpdatePlane plane)
		(FrameOut)
	)

	(method (doVerb theVerb)
		(cond
			(
				(and
					(== theVerb 7) ; Look
					(not
						(if (and (== local14 2) (== local15 2)) 0 else local14)
					)
				)
				(gMessager say: 7 7 6 0) ; "Mosely's body is gone!"
				(return 1)
			)
			((== theVerb 6) ; Open
				(self dispose:)
			)
			((OneOf theVerb 8 6 12 10 11 9 7 13) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
				(super doVerb: theVerb &rest)
			)
			(else
				(gMessager say: 7 0 0 0) ; "There's no point in leaving that in the drawer."
				(return 1)
			)
		)
		(return
			(and
				(== theVerb 7) ; Look
				(not (if (and (== local14 2) (== local15 2)) 0 else local14))
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doit &tmp temp0)
		(if script
			(script doit:)
		else
			(super doit:)
		)
	)

	(method (dispose)
		(plaque dispose:)
		(super dispose:)
		(if
			(and
				(not (if (and (== local14 2) (== local15 2)) 0 else local14))
				(not (IsFlag 357))
			)
			(gGame setCursor: gWaitCursor 1)
		)
		(if (gGame keepBar:)
			(gTheIconBar draw:)
		)
	)
)

(instance torch of Prop
	(properties
		x 150
		y 90
		view 326
		loop 2
	)

	(method (init)
		(super init: &rest)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (doit)
		(if (and (& signal $0001) cycler)
			(cycler doit:)
		)
		(if (and (& -info- $0008) (self isNotHidden:))
			(UpdateScreenItem self)
		)
		(if (or (!= local1 local3) (!= local2 local4))
			(if local12
				(+= local1 local9)
			else
				(+= local2 local10)
			)
			(cond
				(local12
					(if (>= (+= local11 local8) local7)
						(-= local11 local7)
						(+= local2 local10)
					)
				)
				((>= (+= local11 local7) local8)
					(-= local11 local8)
					(+= local1 local9)
				)
			)
		)
		(if (InPolygon local1 local2 local13)
			1
		else
			(= local13
				(cond
					((InPolygon local1 local2 local18)
						(= loop 2)
						local18
					)
					((InPolygon local1 local2 local17)
						(= loop 0)
						local17
					)
					((InPolygon local1 local2 local19)
						(= loop 5)
						local19
					)
					((InPolygon local1 local2 local20)
						(= loop 5)
						local20
					)
					((InPolygon local1 local2 local21)
						(= loop 4)
						local21
					)
					((InPolygon local1 local2 local22)
						(= loop 10)
						local22
					)
					((InPolygon local1 local2 local23)
						(= loop 11)
						local23
					)
					((InPolygon local1 local2 local24)
						(= loop 6)
						local24
					)
					((InPolygon local1 local2 local25)
						(= loop 7)
						local25
					)
					((InPolygon local1 local2 local26)
						(= loop 1)
						local26
					)
					((InPolygon local1 local2 local27)
						(= loop 3)
						local27
					)
					((InPolygon local1 local2 local28)
						(= loop 8)
						local28
					)
					((InPolygon local1 local2 local29)
						(= loop 9)
						local29
					)
					((InPolygon local1 local2 local30)
						(= loop 12)
						local30
					)
					((InPolygon local1 local2 local31)
						(= loop 13)
						local31
					)
					((InPolygon local1 local2 local32)
						(= loop 14)
						local32
					)
					((InPolygon local1 local2 local33)
						(= loop 15)
						local33
					)
					(else 0)
				)
			)
		)
		(= x local1)
		(= y local2)
	)

	(method (doVerb theVerb &tmp temp0 temp1 temp2 temp3)
		(= temp0 ((User curEvent:) x:))
		(= temp1 ((User curEvent:) y:))
		(if (== theVerb 129) ; lit_flash
			(= local3 temp0)
			(= local4 temp1)
			(if (< local3 55)
				(= local3 55)
			)
			(if (> local3 265)
				(= local3 265)
			)
			(if (< local4 22)
				(= local4 22)
			)
			(if (> local4 145)
				(= local4 145)
			)
			(= local5 local1)
			(= local6 local2)
			(= local7 (- local3 local5))
			(= local8 (- local4 local6))
			(= local9
				(if (>= local7 0)
					1
				else
					(*= local7 -1)
					-1
				)
			)
			(= local10
				(if (>= local8 0)
					1
				else
					(*= local8 -1)
					-1
				)
			)
			(= local11 0)
			(= local12 (if (>= local7 local8) 1 else 0))
			(return 1)
		else
			(= temp2
				(cond
					((InPolygon temp0 temp1 local36) 2)
					((InPolygon temp0 temp1 local37) 2)
					((InPolygon temp0 temp1 local38) 2)
					((InPolygon temp0 temp1 local34) 5)
					((InPolygon temp0 temp1 local35) 6)
					((InPolygon temp0 temp1 local39) 3)
					(else 1)
				)
			)
			(= temp3 0)
			(if (and (== temp2 1) (== theVerb 7)) ; Look
				(= temp3 4)
			)
			(if
				(and
					(== theVerb 7) ; Look
					(== temp2 2)
					(InPolygon temp0 temp1 local37)
					(<= 80 temp1 95)
				)
				(= temp3 1)
			)
			(if (and (OneOf theVerb 6 8 9) (== temp2 2)) ; Open, Operate, Move
				(= local14
					(cond
						((InPolygon temp0 temp1 local36) 1)
						((InPolygon temp0 temp1 local37) 2)
						(else 3)
					)
				)
				(= local15
					(cond
						((> 80 temp1) 1)
						((< 95 temp1) 3)
						(else 2)
					)
				)
				(gCurRoom setScript: openADrawer)
				(return 1)
			)
			(if (and (== theVerb 8) (== temp2 3)) ; Operate
				(gCurRoom setScript: outtaHere)
				(return 1)
			)
			(if (OneOf temp2 5 6)
				(gMessager
					say:
						temp2
						(if (OneOf theVerb 7 9 8 12) theVerb else 0) ; Look, Move, Operate, Pickup
						temp3
						0
				)
				(return 1)
			)
			(if (and (== temp2 2) (OneOf theVerb 10 11)) ; Ask, Talk
				(gMessager say: 1 theVerb 0 0)
				(return 1)
			)
			(if (== temp2 3)
				(cond
					((OneOf theVerb 9 6) ; Move, Open
						(gMessager say: temp2 9 temp3 0)
						(return 1)
					)
					((OneOf theVerb 10 11 12) ; Ask, Talk, Pickup
						(gMessager say: temp2 7 temp3 0)
						(return 1)
					)
				)
			)
			(gMessager
				say:
					temp2
					(if (OneOf theVerb 10 7 9 6 8 12 11) theVerb else 0) ; Ask, Look, Move, Open, Operate, Pickup, Talk
					temp3
					0
			)
			(return 1)
		)
	)
)

(instance enterView of Prop
	(properties
		x 163
		y 87
		view 325
		cycleSpeed 15
	)
)

(instance wayOut of Prop
	(properties
		x 163
		y 87
		view 325
		loop 1
		cycleSpeed 15
	)
)

(instance exitButton of Prop
	(properties
		noun 3
		x 260
		y 109
		view 3291
		loop 1
		cycleSpeed 15
	)

	(method (doit)
		(if (and local16 (== local1 local3) (== local2 local4))
			(= local16 (= local0 0))
			(torch dispose:)
			(self show:)
			((gCurRoom script:) cue:)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			((OneOf theVerb 8 9) ; Operate, Move
				(gCurRoom setScript: outtaHere)
				(return 1)
			)
			(129 ; lit_flash
				(if local0
					(torch doVerb: theVerb)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance aDrawer of Prop
	(properties
		noun 4
		view 3280
		cycleSpeed 12
	)

	(method (doVerb theVerb)
		(if (== theVerb 12) ; Pickup
			(gCurRoom setScript: findsTheLight)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance demBones of View
	(properties
		noun 7
		x 2
		y 2
		view 328
		loop 2
	)
)

(instance walletView of View
	(properties
		noun 8
		x 9
		y 158
		z 150
		priority 13
		view 328
		loop 1
	)

	(method (doVerb theVerb)
		(if (== theVerb 12) ; Pickup
			(gEgo get: 72) ; wallet
			(gEgo getPoints: 393 2)
			(self dispose:)
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance moselyAAAGH of View
	(properties
		x 2
		y 2
		priority 13
		view 328
		loop 3
	)
)

(instance plaque of Feature
	(properties
		noun 10
	)

	(method (init)
		(= y 53)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 140 44 139 65 101 85 101 65
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(if (if (and (== local14 2) (== local15 2)) 0 else local14)
					(seeWhatsOnTheSlab setScript: plaqueMessage)
				else
					(gMessager say: 10 7 1 0) ; "(GK-AM2)The plaque on the drawer has an etching of the v\82v\82 on it, but no name."
				)
			)
			(else
				(gMessager say: 10 0 0 0) ; "(GK-AM2)There's no reason to mess with the plaque."
			)
		)
		(return 1)
	)
)

