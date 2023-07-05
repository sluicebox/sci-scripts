;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1501)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use Plane)
(use ROsc)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm1501 0
)

(local
	local0
	local1
	local2
	[local3 2]
	local5 = 200
	local6
	local7
	local8
	[local9 2]
	local11 = 311
	local12 = 179
	local13
	local14 = 1
	local15 = 1
	local16 = 1
	local17 = 1
	local18
	local19
	local20
	local21
	local22
	local23
	local24
	[local25 2]
	local27
	local28
	[local29 5]
	local34
	local35
	local36
	local37
	local38
	local39
	local40
	local41
)

(instance rm1501 of PQRoom
	(properties)

	(method (init)
		(Load rsAUDIO 45)
		(Load rsAUDIO 1501)
		(Lock rsVIEW 55 0)
		(Lock rsAUDIO 1501 1)
		(SetFlag 15)
		(gSwatInterface setMaxInvLevel: 1)
		(super init: &rest)
		(= global432 myTalkerStopCheck)
		(gBackMusic number: 1501 setLoop: -1 play:)
		(SetCursor 311 179)
		(gThePlane picture: -2 setBitmap: 15090 0 0 setRect: 0 0 640 358)
		(gNormalCursor view: 996)
		(gGame setCursor: gNormalCursor)
		(= local19 (CelWide 15091 0 0))
		(= local18 (CelHigh 15091 0 0))
		(snipePlane
			priority: 1
			init: 0 0 local19 local18
			setBitmap: 15091 0 0
			setRect:
				(- (/ (- local19 640) 2))
				(- (/ (- local18 480) 2))
				(- local19 (/ (- local19 640) 2))
				(- local18 (/ (- local18 480) 2))
				1
		)
		(priView init: ((snipePlane casts:) at: 0) setPri: 1000 yourself:)
		(UpdateScreenItem priView)
		(gTheDoits add: snipePlane)
		(UpdatePlane gThePlane)
		(FrameOut)
		(windWindow init:)
		(windFlag init: setLoop: 9 setCycle: Fwd)
		(topDial init:)
		(sideDial init:)
		(bolt init:)
		(trigger init:)
		(theWindows init: gFtrInitializer snipePlane)
		(= local2 global402)
		(= local1 global401)
		(self setScript: enterRoom)
	)

	(method (lashNotify param1)
		(cond
			(local38
				(cond
					(local39
						(= local39 0)
						(gGame handsOff:)
						(gMessager say: 2 162 89 0 self 1500) ; "Pup, load your weapon!"
					)
					(
						(or
							(and (proc4_11 7) (== global149 1))
							(and (proc4_11 7) (proc4_11 26) (== global149 2))
						)
						(lashTimer dispose: delete:)
						(= local38 0)
						(gGame handsOff:)
						(gMessager say: 8 145 11 0 self 0) ; "Yes"
					)
					(
						(or
							(and (proc4_11 8) (== global149 1))
							(and (proc4_11 8) (proc4_11 26) (== global149 2))
						)
						(lashTimer dispose: delete:)
						(= local39 1)
						(gGame handsOff:)
						(gMessager say: 8 146 11 0 self 0) ; "No"
					)
					(else
						(lashTimer dispose: delete:)
						(= local39 0)
						(= local38 0)
						(gGame handsOff:)
						(gMessager say: 7 144 0 0 self 0) ; "Pup! The LASH is not a toy! Confine your comments to the situation at hand!"
					)
				)
			)
			(
				(or
					(and (proc4_11 43) (== global149 1))
					(and (proc4_11 60) (== global149 1))
					(and (proc4_11 77) (== global149 1))
				)
				(gGame handsOff:)
				(gMessager say: 2 116 87 0 self 1500) ; "Copy Highground One."
			)
			((and (proc4_11 26) (proc4_11 43) (== global149 2))
				(gGame handsOff:)
				(gMessager say: 2 116 86 0 self 1500) ; "Copy Highground One."
			)
			((and (proc4_11 26) (proc4_11 82) (== global149 2))
				(gGame handsOff:)
				(gMessager say: 2 116 88 0 self 1500) ; "Copy Highground One."
			)
			((and (proc4_11 26) (proc4_11 83) (== global149 2))
				(gGame handsOff:)
				(= local38 1)
				(gMessager say: 2 116 89 0 self 1500) ; "Twenty David to Highground One... Confirm yes or no... is weapon loaded?"
			)
			(
				(and
					(proc4_11 22)
					(proc4_11 80)
					(or (proc4_11 34) (proc4_11 35) (proc4_11 36) (proc4_11 37))
					(or
						(proc4_11 28)
						(proc4_11 29)
						(proc4_11 30)
						(proc4_11 31)
						(proc4_11 32)
					)
					(> global149 1)
					(< global149 5)
				)
				(gGame handsOff:)
				(if (gCast contains: eastman)
					(gMessager say: 2 116 95 0 self 1500) ; "Highground One reporting.... Hostage visible. Side One, level one, opening one."
				else
					(gMessager say: 2 116 90 0 self 1500) ; "Highground One reporting.... Negative on hostage."
				)
			)
			((and (proc4_11 22) (proc4_11 84) (== global149 2))
				(gGame handsOff:)
				(gMessager say: 2 116 96 0 self 1500) ; "Highground One reporting.... Negative on hostage."
			)
			((and (proc4_11 22) (proc4_11 85) (== global149 2))
				(gGame handsOff:)
				(gMessager say: 2 116 97 0 self 1500) ; "Highground One reporting.... Negative on hostage."
			)
			((and (proc4_11 22) (proc4_11 82) (== global149 2))
				(gGame handsOff:)
				(gMessager say: 2 116 98 0 self 1500) ; "Highground One reporting.... Negative on hostage."
			)
			((and (proc4_11 22) (proc4_11 83) (== global149 2))
				(gGame handsOff:)
				(gMessager say: 2 116 99 0 self 1500) ; "Copy Highground One."
			)
			((and (proc4_11 21) (proc4_11 80) (== global149 2))
				(gGame handsOff:)
				(if
					(and
						(not
							(((snipePlane casts:) at: 0) contains: uniformDude)
						)
						(not (((snipePlane casts:) at: 0) contains: fatDude))
					)
					(gMessager say: 2 116 101 0 self 1500) ; "Highground One reporting... negative on suspect."
				else
					(gMessager say: 2 116 107 0 self 1500) ; "Highground One reporting.... Hostage visible. Side One, level one, opening one."
				)
			)
			((and (proc4_11 26) (proc4_11 81) (== global149 2))
				(gGame handsOff:)
				(gMessager say: 2 116 108 0 self 1500) ; "Highground One to Twenty David - No movement side one / two."
			)
			((and (proc4_11 21) (proc4_11 84) (== global149 2))
				(gGame handsOff:)
				(gMessager say: 2 116 109 0 self 1500) ; "Highground One - report!"
			)
			((and (proc4_11 21) (proc4_11 85) (== global149 2))
				(gGame handsOff:)
				(gMessager say: 2 116 110 0 self 1500) ; "Highground One - report!"
			)
			(
				(and
					(proc4_11 21)
					(proc4_11 82)
					(or (proc4_11 80) (not (proc4_11 80)))
					(> global149 1)
					(< global149 6)
				)
				(gGame handsOff:)
				(cond
					(local34
						(gMessager say: 2 116 116 0 self 1500) ; "Highground One... Immediate threat! Weapon visible!"
					)
					(
						(or
							(((snipePlane casts:) at: 0) contains: uniformDude)
							(((snipePlane casts:) at: 0) contains: fatDude)
						)
						(gMessager say: 2 116 113 0 self 1500) ; "Highground One reporting.... Negative on weapons."
					)
					(else
						(gMessager say: 2 116 101 0 self 1500) ; "Highground One reporting... negative on suspect."
					)
				)
			)
			((and (proc4_11 21) (proc4_11 83) (== global149 2))
				(gGame handsOff:)
				(cond
					(local34
						(gMessager say: 2 116 114 0 self 1500) ; "Highground One... Immediate threat! Weapon visible!"
					)
					(
						(or
							(gCast contains: uniformDude)
							(gCast contains: fatDude)
						)
						(gMessager say: 2 116 115 0 self 1500) ; "Copy Highground One."
					)
					(else
						(gMessager say: 2 116 101 0 self 1500) ; "Highground One reporting... negative on suspect."
					)
				)
			)
			(else
				(super lashNotify: param1)
			)
		)
	)

	(method (cue)
		(cond
			(local39
				(self lashNotify:)
			)
			(local38
				(lashTimer setReal: lashTimer 10)
				(gGame handsOn:)
			)
			(else
				(gGame handsOn:)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(27
				(gGame handsOff:)
				(gMessager say: 1 2 80 0 self 1500) ; "Knock it off, Pup. Scope the building."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (handleEvent event)
		(cond
			(
				(and
					(& (event type:) evMOUSEBUTTON)
					(== (event message:) $001d)
					(not local13)
				)
				(= local13 1)
				(gNormalCursor view: 999)
				(gGame setCursor: gNormalCursor)
			)
			((and (& (event type:) evMOUSEBUTTON) (== (event message:) $001d) local13)
				(= local27 2)
				(gNormalCursor view: 996)
				(gGame setCursor: gNormalCursor 1 local11 local12)
				(= gMouseX local11)
				(= gMouseY local12)
				(= local13 0)
			)
		)
		(super handleEvent: event)
	)

	(method (dispose)
		(if (== (gNormalCursor view:) 996)
			(gNormalCursor view: 996)
		)
		(= global432 0)
		(SetFlag 83)
		(ClearFlag 15)
		(if (gPlanes contains: snipePlane)
			(snipePlane dispose:)
		)
		(Lock rsAUDIO 1501 0)
		(Load rsVIEW 55)
		(Lock rsVIEW 55 1)
		(windTimer dispose: delete:)
		(roomTimer dispose: delete:)
		(lashTimer dispose: delete:)
		((gThePlane bitmapCast:) dispose:)
		(gThePlane bitmap: 0)
		(gBackMusic fade: 0 2 21 1)
		(shotSound stop: dispose:)
		(super dispose: &rest)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(gMessager say: 1 2 5 0 self 1500) ; "Highground One to Twenty David, we're in position."
			)
			(1
				(windTimer setReal: windTimer (Random 20 40))
				(roomTimer setReal: roomTimer 10)
				(self dispose:)
			)
		)
	)
)

(instance reloadBullet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local40 (= local15 0))
				(gFxSound number: 46 setLoop: 0 play:)
				(bolt setLoop: 0 setCel: 0 setCycle: End self)
			)
			(1
				(bolt setLoop: 1 setCel: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance shootFirstTimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(theBlast dispose:)
				(gMessager say: 1 2 6 0 self 1500) ; "Compromised! Shots fired! Highground One to Twenty David - Compromised!"
			)
			(1
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gFxSound number: 1002 setLoop: 0 play: self)
			)
			(2
				(gFxSound number: 31610 setLoop: 0 play: self)
			)
			(3
				(SetFlag 304)
				(SetFlag 98)
				(SetFlag 94)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance missAnim2Left of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheDoits delete: (eastman dispose: yourself:))
				(theBlast dispose:)
				(gMessager say: 1 2 46 1 self 1500) ; "Cease fire!!"
			)
			(1
				(gTheDoits
					add:
						(uniformDude
							view: 15004
							setCel: 0
							setLoop: 2
							posn: 405 575
							init: ((snipePlane casts:) at: 0)
							setCycle: End self
							yourself:
						)
				)
				(gMessager sayRange: 1 2 46 2 3 self 1500) ; "Compromised! Highground One to Twenty David - Compromised!"
			)
			(2
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gTheDoits delete: (uniformDude dispose: yourself:))
				(gFxSound number: 1002 setLoop: 0 play: self)
			)
			(3
				(gFxSound number: 31610 setLoop: 0 play: self)
			)
			(4
				(SetFlag 100)
				(SetFlag 98)
				(SetFlag 93)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance missAnim2Right of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheDoits delete: (eastman dispose: yourself:))
				(theBlast dispose:)
				(gMessager say: 1 2 45 0 self 1500) ; "Cease fire! Cease fire!"
			)
			(1
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(2
				(SetFlag 98)
				(SetFlag 93)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance shootEast2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheDoits delete: (eastman dispose: yourself:))
				(theBlast dispose:)
				(if (IsFlag 83)
					(gMessager say: 1 2 44 1 self 1500) ; "Cease fire! Stop! Cease fire!!"
				else
					(gMessager sayRange: 1 2 12 1 3 self 1500) ; "Cease fire!! Stop! Stop! Cease fire!!"
				)
			)
			(1
				(if (IsFlag 83)
					(gMessager say: 1 2 44 2 self 1500) ; "What's happening? Highground One - Saunders report!"
				else
					(= cycles 1)
				)
			)
			(2
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(if (IsFlag 83)
					(gMessager say: 1 2 44 3 self 1500) ; "Highground One to Twenty David - weapon secure - officer in custody."
				else
					(gMessager say: 1 2 12 4 self 1500) ; "Highground One to Twenty David - weapon secured; officer in custody."
				)
			)
			(3
				(SetFlag 100)
				(SetFlag 98)
				(SetFlag 93)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance shootFat3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheDoits delete: (uniformDude dispose: yourself:))
				(gTheDoits delete: (fatDude dispose: yourself:))
				(theBlast dispose:)
			)
			(1
				(gMessager sayRange: 1 2 50 1 2 self 1500) ; "Highground One to Twenty David - target two neutralized!"
			)
			(2
				(gTheDoits
					add:
						(eastman
							view: 15004
							setLoop: 1
							setCel: 0
							posn: 405 575
							init: ((snipePlane casts:) at: 0)
							setCycle: End self
							yourself:
						)
				)
			)
			(3
				(gTheDoits delete: (eastman dispose: yourself:))
				(gMessager sayRange: 1 2 50 3 4 self 1500) ; "Highground One reporting... shots fired! Hostage down! Repeat - hostage down! Suspect not visible!"
			)
			(4
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gFxSound number: 1002 setLoop: 0 play: self)
			)
			(5
				(gFxSound number: 31610 setLoop: 0 play: self)
			)
			(6
				(SetFlag 100)
				(SetFlag 98)
				(SetFlag 93)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance shootUni3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheDoits delete: (uniformDude dispose: yourself:))
				(gTheDoits delete: (fatDude dispose: yourself:))
				(theBlast dispose:)
				(gMessager sayRange: 1 2 49 1 2 self 1500) ; "Highground One to Twenty David - target one neutralized!"
			)
			(1
				(gTheDoits
					add:
						(eastman
							view: 15004
							setLoop: 1
							setCel: 0
							posn: 405 575
							init: ((snipePlane casts:) at: 0)
							setCycle: End self
							yourself:
						)
				)
			)
			(2
				(gTheDoits delete: (eastman dispose: yourself:))
				(gMessager sayRange: 1 2 49 3 4 self 1500) ; "Highground One... shots fired! Hostage down! Repeat- hostage down! Suspect two not visible!"
			)
			(3
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gFxSound number: 1002 setLoop: 0 play: self)
			)
			(4
				(gFxSound number: 31610 setLoop: 0 play: self)
			)
			(5
				(SetFlag 100)
				(SetFlag 98)
				(SetFlag 93)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance missAnim3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheDoits delete: (uniformDude dispose: yourself:))
				(gTheDoits delete: (fatDude dispose: yourself:))
				(theBlast dispose:)
				(gMessager sayRange: 1 2 51 1 2 self 1500) ; "Compromised! Highground One to Twenty David - Compromised!"
			)
			(1
				(gTheDoits
					add:
						(eastman
							view: 15004
							setLoop: 1
							setCel: 0
							posn: 405 575
							init: ((snipePlane casts:) at: 0)
							setCycle: End self
							yourself:
						)
				)
			)
			(2
				(gTheDoits delete: (eastman dispose: yourself:))
				(gMessager sayRange: 1 2 51 3 4 self 1500) ; "Highground One reporting... Shots fired! Hostage down! Repeat, hostage down! Suspects not visible."
			)
			(3
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gFxSound number: 1002 setLoop: 0 play: self)
			)
			(4
				(gFxSound number: 31610 setLoop: 0 play: self)
			)
			(5
				(SetFlag 98)
				(SetFlag 93)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance shootUni4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheDoits delete: (uniformDude dispose: yourself:))
				(gTheDoits delete: (fatDude dispose: yourself:))
				(theBlast dispose:)
				(gMessager sayRange: 1 2 53 1 2 self 1500) ; "Highground One reporting... Target one neutralized!"
			)
			(1
				(gTheDoits
					add:
						(eastman
							view: 15004
							setLoop: 1
							setCel: 0
							posn: 405 575
							init: ((snipePlane casts:) at: 0)
							setCycle: End self
							yourself:
						)
				)
			)
			(2
				(gTheDoits delete: (eastman dispose: yourself:))
				(gMessager sayRange: 1 2 53 3 4 self 1500) ; "Highground One.. Shots fired! Hostage down. Repeat - hostage down! Suspect not visible!"
			)
			(3
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gFxSound number: 1002 setLoop: 0 play: self)
			)
			(4
				(gFxSound number: 31610 setLoop: 0 play: self)
			)
			(5
				(SetFlag 100)
				(SetFlag 98)
				(SetFlag 93)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance shootFat4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheDoits delete: (uniformDude dispose: yourself:))
				(gTheDoits delete: (fatDude dispose: yourself:))
				(theBlast dispose:)
				(gMessager sayRange: 1 2 54 1 2 self 1500) ; "Highground One reporting... Target two neutralized!"
			)
			(1
				(gTheDoits
					add:
						(eastman
							view: 15004
							setLoop: 1
							setCel: 0
							posn: 405 575
							init: ((snipePlane casts:) at: 0)
							setCycle: End self
							yourself:
						)
				)
			)
			(2
				(gTheDoits delete: (eastman dispose: yourself:))
				(gMessager sayRange: 1 2 54 3 4 self 1500) ; "Highground One reporting... Shots fired! Hostage down! Repeat- hostage down! Suspect not visible!"
			)
			(3
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gFxSound number: 1002 setLoop: 0 play: self)
			)
			(4
				(gFxSound number: 31610 setLoop: 0 play: self)
			)
			(5
				(SetFlag 100)
				(SetFlag 98)
				(SetFlag 93)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance shootMiss4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheDoits delete: (uniformDude dispose: yourself:))
				(gTheDoits delete: (fatDude dispose: yourself:))
				(theBlast dispose:)
				(if (> (local20 x:) 360)
					(gTheDoits
						add:
							(uniformDude
								view: 15005
								setLoop: 0
								setCel: 17
								posn: 370 596
								init: ((snipePlane casts:) at: 0)
								setCycle: CT 38 1 self
								yourself:
							)
					)
				else
					(gTheDoits
						add:
							(uniformDude
								view: 15015
								setLoop: 0
								setCel: 15
								posn: 300 596
								init: ((snipePlane casts:) at: 0)
								setCycle: CT 35 1 self
								yourself:
							)
					)
				)
				(gMessager sayRange: 1 2 55 1 2 self 1500) ; "Compromised! Highground One reporting....Compromised!"
			)
			(1)
			(2
				(gTheDoits
					add:
						(eastman
							view: 15004
							setLoop: 1
							setCel: 0
							posn: 405 575
							init: ((snipePlane casts:) at: 0)
							setCycle: End self
							yourself:
						)
				)
			)
			(3
				(gTheDoits delete: (uniformDude dispose: yourself:))
				(gTheDoits delete: (eastman dispose: yourself:))
				(gMessager sayRange: 1 2 55 3 4 self 1500) ; "Highground One... Shots fired! Hostage down! Repeat- hostage down. Suspects not visible!"
			)
			(4
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gFxSound number: 1002 setLoop: 0 play: self)
			)
			(5
				(gFxSound number: 31610 setLoop: 0 play: self)
			)
			(6
				(SetFlag 98)
				(SetFlag 93)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance shootUni5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheDoits delete: (uniformDude dispose: yourself:))
				(gTheDoits delete: (fatDude dispose: yourself:))
				(theBlast dispose:)
				(gMessager sayRange: 1 2 60 1 2 self 1500) ; "Compromised! Highground One reporting - Compromised!"
			)
			(1
				(gTheDoits
					add:
						(eastman
							view: 15004
							setLoop: 1
							setCel: 0
							posn: 405 575
							init: ((snipePlane casts:) at: 0)
							setCycle: End self
							yourself:
						)
				)
			)
			(2
				(gTheDoits delete: (eastman dispose: yourself:))
				(gMessager sayRange: 1 2 60 3 4 self 1500) ; "Highground One! Shots fired! Hostage down! Repeat- hostage down! Suspects not visible."
			)
			(3
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(4
				(SetFlag 98)
				(SetFlag 93)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance shootFat5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheDoits delete: (uniformDude dispose: yourself:))
				(gTheDoits delete: (fatDude dispose: yourself:))
				(theBlast dispose:)
				(gMessager sayRange: 1 2 59 1 2 self 1500) ; "Highground One reporting... Target two neutralized!"
			)
			(1
				(gTheDoits
					add:
						(eastman
							view: 15004
							setLoop: 1
							setCel: 0
							posn: 405 575
							init: ((snipePlane casts:) at: 0)
							setCycle: End self
							yourself:
						)
				)
			)
			(2
				(gTheDoits delete: (eastman dispose: yourself:))
				(gMessager sayRange: 1 2 59 3 4 self 1500) ; "Highground One reporting... Shots fired! Hostage down! Repeat- hostage down! Suspect one not visible!"
			)
			(3
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(4
				(SetFlag 98)
				(SetFlag 93)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance shootMiss5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheDoits delete: (uniformDude dispose: yourself:))
				(gTheDoits delete: (fatDude dispose: yourself:))
				(theBlast dispose:)
				(gMessager say: 1 2 60 1 self 1500) ; "Compromised! Highground One reporting - Compromised!"
				(gTheDoits
					add:
						(uniformDude
							view: 15005
							setLoop: 0
							setCel: 25
							posn: 370 596
							init: ((snipePlane casts:) at: 0)
							setCycle: ROsc 1 25 38 self
							yourself:
						)
				)
			)
			(1)
			(2
				(gTheDoits delete: (uniformDude dispose: yourself:))
				(gMessager say: 1 2 60 2 self 1500) ; "There was no green light! Report! Highground one report!"
			)
			(3
				(gTheDoits
					add:
						(eastman
							view: 15004
							setLoop: 1
							setCel: 0
							posn: 405 575
							init: ((snipePlane casts:) at: 0)
							setCycle: End self
							yourself:
						)
				)
			)
			(4
				(gTheDoits delete: (eastman dispose: yourself:))
				(gMessager sayRange: 1 2 60 3 4 self 1500) ; "Highground One! Shots fired! Hostage down! Repeat- hostage down! Suspects not visible."
			)
			(5
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(6
				(SetFlag 98)
				(SetFlag 93)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance shootUni6 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheDoits delete: (uniformDude dispose: yourself:))
				(theBlast dispose:)
				(gTheDoits
					add:
						(eastman
							view: 15003
							setLoop: 0
							setCel: 118
							posn: 465 608
							init: ((snipePlane casts:) at: 0)
							setCycle: End self
							yourself:
						)
				)
				(gMessager say: 1 2 63 0 self 1500) ; "Highground One reporting... Target hit. Threat neutralized."
			)
			(1
				(gTheDoits delete: (eastman dispose: yourself:))
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gFxSound number: 1002 setLoop: 0 play: self)
			)
			(2
				(gFxSound number: 31610 setLoop: 0 play: self)
			)
			(3
				(SetFlag 100)
				(SetFlag 98)
				(SetFlag 95)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance shootMiss6 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (> (local20 x:) 360)
					(uniformDude
						view: 15005
						setLoop: 0
						setCel: 17
						posn: 370 596
						setCycle: CT 38 1 self
					)
				else
					(uniformDude
						view: 15015
						setLoop: 0
						setCel: 15
						posn: 300 596
						setCycle: CT 35 1 self
					)
				)
				(theBlast dispose:)
				(gMessager sayRange: 1 2 64 1 2 self 1500) ; "Compromised! Highground One to Twenty David - Compromised!"
			)
			(1
				(gTheDoits
					add:
						(eastman
							view: 15004
							setLoop: 1
							setCel: 0
							posn: 405 575
							init: ((snipePlane casts:) at: 0)
							setCycle: End self
							yourself:
						)
				)
			)
			(2
				(gTheDoits delete: (eastman dispose: yourself:))
				(gMessager sayRange: 1 2 64 3 4 self 1500) ; "Highground One... Shots fired! Hostage down! Repeat- hostage down! Suspect not visible!"
			)
			(3
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gFxSound number: 1002 setLoop: 0 play: self)
			)
			(4
				(gFxSound number: 31610 setLoop: 0 play: self)
			)
			(5
				(SetFlag 98)
				(SetFlag 93)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance shootUni7 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheDoits delete: (uniformDude dispose: yourself:))
				(gTheDoits
					add:
						(eastman
							view: 15003
							setLoop: 0
							setCel: 118
							posn: 465 608
							init: ((snipePlane casts:) at: 0)
							setCycle: End self
							yourself:
						)
				)
				(theBlast dispose:)
				(gMessager say: 1 2 66 0 self 1500) ; "Target hit - Threat neutralized!"
			)
			(1
				(gTheDoits delete: (eastman dispose: yourself:))
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gFxSound number: 1002 setLoop: 0 play: self)
			)
			(2
				(gFxSound number: 31610 setLoop: 0 play: self)
			)
			(3
				(SetFlag 100)
				(SetFlag 98)
				(SetFlag 95)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance shootMiss7 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (> (local20 x:) 360)
					(uniformDude
						view: 15005
						setLoop: 0
						setCel: 17
						posn: 370 596
						setCycle: CT 38 1 self
					)
				else
					(uniformDude
						view: 15015
						setLoop: 0
						setCel: 15
						posn: 300 596
						setCycle: CT 35 1 self
					)
				)
				(gMessager sayRange: 1 2 67 1 2 self 1500) ; "Compromised! Highground One reporting... Compromised!"
			)
			(1
				(gTheDoits delete: (uniformDude dispose: yourself:))
				(gTheDoits
					add:
						(eastman
							view: 15004
							setLoop: 1
							setCel: 0
							posn: 405 575
							init: ((snipePlane casts:) at: 0)
							setCycle: End self
							yourself:
						)
				)
			)
			(2
				(gTheDoits delete: (eastman dispose: yourself:))
				(gMessager sayRange: 1 2 67 3 4 self 1500) ; "Highground One... Shots fired! Hostage down! Repeat- hostage down! Suspect not visible!"
			)
			(3
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gFxSound number: 1002 setLoop: 0 play: self)
			)
			(4
				(gFxSound number: 31610 setLoop: 0 play: self)
			)
			(5
				(SetFlag 98)
				(SetFlag 93)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance shootEast8 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheDoits delete: (eastman dispose: yourself:))
				(if (> (local20 x:) 360)
					(uniformDude
						view: 15005
						setLoop: 0
						setCel: 17
						posn: 370 596
						setCycle: CT 38 1
					)
				else
					(uniformDude
						view: 15015
						setLoop: 0
						setCel: 15
						posn: 300 596
						setCycle: CT 35 1
					)
				)
				(gMessager say: 1 2 70 0 self 1500) ; "Hostage down! Friendly fire! Suspect side one/two, level one..."
			)
			(1
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gFxSound number: 1002 setLoop: 0 play: self)
			)
			(2
				(gFxSound number: 31610 setLoop: 0 play: self)
			)
			(3
				(if (Random 0 1)
					(SetFlag 100)
				)
				(SetFlag 93)
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance shootUni8 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheDoits delete: (uniformDude dispose: yourself:))
				(if (> (local20 x:) 360)
					(eastman
						view: 15016
						setLoop: 0
						setCel: 10
						posn: 520 588
						setCycle: End
					)
				else
					(eastman
						view: 15006
						setLoop: 0
						setCel: 10
						posn: 365 591
						setCycle: End
					)
				)
				(theBlast dispose:)
				(gMessager say: 1 2 69 0 self 1500) ; "Target hit. Threat neutralized!"
			)
			(1
				(Palette 2 42 254 0) ; PalIntensity
				(gTheDoits delete: (eastman dispose: yourself:))
				(FrameOut)
				(gFxSound number: 3450 setLoop: 0 play: self)
			)
			(2
				(gEgo awardMedal: 4)
				(SetFlag 92)
				(SetFlag 304)
				(SetFlag 305)
				(SetFlag 102)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance shootMiss8 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheDoits delete: (eastman dispose: yourself:))
				(theBlast dispose:)
				(uniformDude
					view: 15005
					setLoop: 0
					setCel: 17
					posn: 370 596
					setCycle: CT 38 1 self
				)
				(gMessager say: 1 2 71 1 0 1500) ; "Target missed! Compromised!"
			)
			(1
				(gTheDoits delete: (uniformDude dispose: yourself:))
				(gTheDoits
					add:
						(eastman
							view: 15004
							setLoop: 1
							setCel: 0
							posn: 405 575
							init: ((snipePlane casts:) at: 0)
							setCycle: End self
							yourself:
						)
				)
			)
			(2
				(gTheDoits delete: (eastman dispose: yourself:))
				(gMessager sayRange: 1 2 71 2 3 self 1500) ; "Shots fired! Hostage down. Repeat - hostage down. Suspect not visible."
			)
			(3
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gFxSound number: 1002 setLoop: 0 play: self)
			)
			(4
				(gFxSound number: 31610 setLoop: 0 play: self)
			)
			(5
				(SetFlag 304)
				(SetFlag 102)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance shootEast9 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(theBlast dispose:)
				(gTheDoits delete: (eastman dispose: yourself:))
				(uniformDude
					view: 15015
					setLoop: 0
					setCel: 15
					posn: 300 596
					setCycle: CT 35 1 self
				)
				(gMessager say: 1 2 75 0 0 1500) ; "Hostage down! Friendly fire! Suspect side one/two, level one!"
			)
			(1
				(SetFlag 98)
				(SetFlag 93)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance shootMiss9 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (> (local20 x:) 360)
					(uniformDude
						view: 15005
						setLoop: 0
						setCel: 17
						posn: 370 596
						setCycle: End
					)
					(eastman
						view: 15016
						setLoop: 0
						setCel: 10
						posn: 520 588
						setCycle: End
					)
				else
					(uniformDude
						view: 15015
						setLoop: 0
						setCel: 15
						posn: 300 596
						setCycle: End
					)
					(eastman
						view: 15006
						setLoop: 0
						setCel: 10
						posn: 365 591
						setCycle: End
					)
				)
				(theBlast dispose:)
				(gMessager say: 1 2 76 0 self 1500) ; "Target missed! Compromised!"
			)
			(1
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gTheDoits delete: (uniformDude dispose: yourself:))
				(gTheDoits delete: (eastman dispose: yourself:))
				(gFxSound number: 1002 setLoop: 0 play: self)
			)
			(2
				(gFxSound number: 31610 setLoop: 0 play: self)
			)
			(3
				(SetFlag 304)
				(SetFlag 102)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance shootUni9 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheDoits delete: (uniformDude dispose: yourself:))
				(if (> (local20 x:) 360)
					(eastman
						view: 15016
						setLoop: 0
						setCel: 10
						posn: 520 588
						setCycle: End
					)
				else
					(eastman
						view: 15006
						setLoop: 0
						setCel: 10
						posn: 365 591
						setCycle: End
					)
				)
				(theBlast dispose:)
				(gMessager say: 1 2 74 0 self 1500) ; "Target hit. Suspect neutralized!"
			)
			(1
				(Palette 2 42 254 0) ; PalIntensity
				(gTheDoits delete: (eastman dispose: yourself:))
				(FrameOut)
				(gFxSound number: 3450 setLoop: 0 play: self)
			)
			(2
				(gEgo awardMedal: 4)
				(SetFlag 92)
				(SetFlag 304)
				(SetFlag 305)
				(SetFlag 102)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance ejectBullet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local15 1)
				(bolt setLoop: 1 setCel: 0 setCycle: CT 4 1 self)
			)
			(1
				(bolt setCycle: End self)
				(shotSound number: 46 setLoop: 0 play:)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance anim1 of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local35 1)
				(gTheDoits
					add:
						(eastman
							view: 15003
							setLoop: 0
							setCel: 0
							posn: 465 608
							init: ((snipePlane casts:) at: 0)
							setPri: 300
							setCycle: CT 13 1 self
							yourself:
						)
				)
			)
			(1
				(gMessager say: 1 2 41 0 0 1500) ; "Highground One reporting... Hostage visible - Side one, level one, opening one."
				(eastman setCycle: CT 113 1 self)
			)
			(2
				(gTheDoits delete: (eastman dispose: yourself:))
				(switch (Random 0 2)
					(1
						(= temp0 15)
					)
					(2
						(= temp0 20)
					)
					(else
						(= temp0 30)
					)
				)
				(roomTimer setReal: roomTimer temp0)
				(= local35 0)
				(++ local41)
				(self dispose:)
			)
		)
	)
)

(instance shootAnim1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheDoits delete: (eastman dispose: yourself:))
				(theBlast dispose:)
				(gMessager sayRange: 1 2 42 1 2 self 1500) ; "Cease fire! Stop, stop!! Cease fire!"
			)
			(1
				(gMessager say: 1 2 42 3 self 1500) ; "What's happening? Report Highground One!"
			)
			(2
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gMessager say: 1 2 42 4 self 1500) ; "Highground One to Twenty David - weapon secured - officer in custody."
			)
			(3
				(SetFlag 100)
				(SetFlag 98)
				(SetFlag 93)
				(Palette 2 42 254 0) ; PalIntensity
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance missAnim1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(theBlast dispose:)
				(gTheDoits
					add:
						(eastman
							view: 15004
							setLoop: 1
							setCel: 0
							posn: 405 575
							init: ((snipePlane casts:) at: 0)
							setCycle: End
							yourself:
						)
				)
				(gMessager say: 1 2 10 0 self 1500) ; "Cease fire!! Cease fire!"
			)
			(1
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gFxSound number: 1002 setLoop: 0 play: self)
			)
			(2
				(gFxSound number: 31610 setLoop: 0 play: self)
			)
			(3
				(SetFlag 100)
				(SetFlag 98)
				(SetFlag 93)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance anim2 of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local35 2)
				(gTheDoits
					add:
						(eastman
							view: 15003
							setLoop: 0
							setCel: (if (IsFlag 83) 0 else 115)
							posn: 465 608
							init: ((snipePlane casts:) at: 0)
							setPri: 300
							setCycle: CT 13 1 self
							yourself:
						)
				)
				(if (IsFlag 83)
					(eastman setCycle: CT 13 1 self)
				else
					(eastman setCycle: End self)
					(gMessager say: 1 2 11 0 0 1500) ; "Highground One reporting... Hostage visible - Side two, level one, opening seven."
				)
			)
			(1
				(if (IsFlag 83)
					(gMessager sayRange: 1 2 43 1 3 0 1500) ; "Highground One reporting... Hostage visible - Side one, level one, opening one."
					(eastman setCycle: CT 120 1 self)
				else
					(= cycles 1)
				)
			)
			(2
				(if (IsFlag 83)
					(gMessager say: 1 2 43 4 0 1500) ; "Highground One reporting... Hostage side two, level one, opening seven..."
					(eastman setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(3
				(gTheDoits delete: (eastman dispose: yourself:))
				(switch (Random 0 2)
					(1
						(= temp0 15)
					)
					(2
						(= temp0 20)
					)
					(else
						(= temp0 30)
					)
				)
				(roomTimer setReal: roomTimer temp0)
				(++ local41)
				(= local35 0)
				(self dispose:)
			)
		)
	)
)

(instance anim3 of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local35 3)
				(= local37 1)
				(gTheDoits
					add:
						(uniformDude
							view: 15011
							setLoop: 0
							setCel: 0
							posn: 302 597
							init: ((snipePlane casts:) at: 0)
							setPri: 300
							setCycle: CT 10 1 self
							yourself:
						)
				)
				(gTheDoits
					add:
						(fatDude
							view: 15011
							setLoop: 1
							setCel: 0
							posn: 302 597
							init: ((snipePlane casts:) at: 0)
							setPri: 300
							setCycle: End self
							yourself:
						)
				)
			)
			(1
				(uniformDude setCycle: End)
				(if local36
					(gMessager say: 1 2 47 0 0 1500) ; "Highground One reporting... Two suspects visible - Side two, level one, opening seven."
				else
					(gMessager say: 1 2 48 0 0 1500) ; "Highground One reporting .... two suspects are visible - Side two, level one, opening seven. Suspect one wearing brown uniform with brown baseball cap; looks like delivery person. Suspect two wearing fatigues; top and bottom. Also wearing baseball cap."
				)
			)
			(2
				(gTheDoits delete: (uniformDude dispose: yourself:))
				(gTheDoits delete: (fatDude dispose: yourself:))
				(switch (Random 0 2)
					(1
						(= temp0 15)
					)
					(2
						(= temp0 20)
					)
					(else
						(= temp0 30)
					)
				)
				(roomTimer setReal: roomTimer temp0)
				(++ local41)
				(= local35 0)
				(self dispose:)
			)
		)
	)
)

(instance anim4 of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local35 4)
				(gTheDoits
					add:
						(uniformDude
							view: 15038
							setLoop: 0
							setCel: 0
							cycleSpeed: 12
							posn: 362 596
							init: ((snipePlane casts:) at: 0)
							setPri: 300
							setCycle: End self
							yourself:
						)
						(fatDude
							view: 15038
							setLoop: 1
							setCel: 0
							cycleSpeed: 12
							posn: 362 596
							init: ((snipePlane casts:) at: 0)
							setPri: 300
							setCycle: CT 5 1 self
							yourself:
						)
				)
			)
			(1
				(fatDude setCycle: End)
				(gMessager say: 1 2 52 0 0 1500) ; "Highground One reporting... Two suspects visible - One/two corner. Both appear unarmed. Repeat - no weapons visible."
			)
			(2
				(gTheDoits delete: (uniformDude dispose: yourself:))
				(gTheDoits delete: (fatDude dispose: yourself:))
				(switch (Random 0 2)
					(1
						(= temp0 15)
					)
					(2
						(= temp0 20)
					)
					(else
						(= temp0 30)
					)
				)
				(roomTimer setReal: roomTimer temp0)
				(= local35 0)
				(++ local41)
				(self dispose:)
			)
		)
	)
)

(instance anim5 of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local35 5)
				(gTheDoits
					add:
						(uniformDude
							view: 15014
							setLoop: 0
							setCel: 0
							posn: 435 592
							init: ((snipePlane casts:) at: 0)
							setPri: 300
							setCycle: CT 10 1 self
							yourself:
						)
						(fatDude
							view: 15014
							setLoop: 1
							setCel: 0
							posn: 435 592
							init: ((snipePlane casts:) at: 0)
							setPri: 300
							setCycle: CT 10 1 self
							yourself:
						)
				)
			)
			(1
				(uniformDude setCycle: End self)
				(if local37
					(gMessager say: 1 2 56 0 self 1500) ; "Highground One reporting... Two suspects visible - Side one, level one, opening one."
				else
					(gMessager say: 1 2 57 0 self 1500) ; "Highground One reporting... Two suspects visible - Side one, level one, opening one. Suspect one wearing brown uniform with brown baseball cap; looks like a delivery person. Suspect two wearing fatigues; top and bottom. Also wearing a baseball cap."
				)
			)
			(2
				(gTheDoits delete: (uniformDude dispose: yourself:))
				(gTheDoits delete: (fatDude dispose: yourself:))
				(switch (Random 0 2)
					(1
						(= temp0 15)
					)
					(2
						(= temp0 20)
					)
					(else
						(= temp0 30)
					)
				)
				(roomTimer setReal: roomTimer temp0)
				(= local35 0)
				(self dispose:)
			)
		)
	)
)

(instance anim6 of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local35 6)
				(gTheDoits
					add:
						(uniformDude
							view: 15012
							setLoop: 0
							setCel: 0
							posn: 437 592
							init: ((snipePlane casts:) at: 0)
							setCycle: CT 12 1 self
							yourself:
						)
				)
			)
			(1
				(uniformDude setCycle: End self)
				(if (or local37 local36)
					(gMessager say: 1 2 61 0 0 1500) ; "Highground One reporting... Suspect one visible. Side one, level one, opening one. Appears to be rummaging through drawers."
				else
					(gMessager say: 1 2 62 0 0 1500) ; "Highground One reporting... Suspect visible side one, level one, opening one. Wearing brown uniform, brown baseball cap. Appears to rummaging through drawers."
				)
			)
			(2
				(gTheDoits delete: (uniformDude dispose: yourself:))
				(switch (Random 0 2)
					(1
						(= temp0 15)
					)
					(2
						(= temp0 20)
					)
					(else
						(= temp0 30)
					)
				)
				(roomTimer setReal: roomTimer temp0)
				(= local35 0)
				(++ local41)
				(self dispose:)
			)
		)
	)
)

(instance anim7 of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local35 7)
				(gTheDoits
					add:
						(uniformDude
							view: 15022
							setLoop: 0
							setCel: 0
							posn: 215 587
							init: ((snipePlane casts:) at: 0)
							setCycle: CT 10 1 self
							yourself:
						)
				)
			)
			(1
				(uniformDude setCycle: End self)
				(gMessager say: 1 2 65 0 0 1500) ; "Highground One reporting... Suspect - Side two, level one, opening seven. No weapon visible."
			)
			(2
				(gTheDoits delete: (uniformDude dispose: yourself:))
				(switch (Random 0 2)
					(1
						(= temp0 15)
					)
					(2
						(= temp0 20)
					)
					(else
						(= temp0 30)
					)
				)
				(roomTimer setReal: roomTimer temp0)
				(= local35 0)
				(++ local41)
				(self dispose:)
			)
		)
	)
)

(instance anim8 of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local35 8)
				(= local34 1)
				(gTheDoits
					add:
						(eastman
							view: 15000
							setLoop: 0
							setCel: 0
							posn: 430 599
							cycleSpeed: 6
							init: ((snipePlane casts:) at: 0)
							setCycle: End self
							yourself:
						)
						(uniformDude
							view: 15000
							setLoop: 1
							setCel: 0
							posn: 430 599
							cycleSpeed: 6
							init: ((snipePlane casts:) at: 0)
							setCycle: CT 10 1 self
							yourself:
						)
				)
			)
			(1
				(uniformDude setCycle: End)
				(gMessager say: 1 2 68 0 0 1500) ; "Highground One reporting.. Immediate threat! Weapon visible!"
			)
			(2
				(Load rsVIEW 15017)
				(= seconds 1)
			)
			(3
				(eastman
					view: 15017
					setCel: 0
					setLoop: 0
					cycleSpeed: 6
					setCycle: End self
				)
				(uniformDude
					view: 15017
					setCel: 0
					setLoop: 1
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(4)
			(5
				(Load rsVIEW 15039)
				(= seconds 1)
			)
			(6
				(eastman
					view: 15039
					cycleSpeed: 12
					setCel: 0
					setLoop: 0
					setCycle: End self
				)
				(uniformDude
					view: 15039
					cycleSpeed: 12
					setCel: 0
					setLoop: 1
					setCycle: End
				)
			)
			(7
				(gTheDoits delete: (uniformDude dispose: yourself:))
				(gTheDoits delete: (eastman dispose: yourself:))
				(gMessager say: 1 2 36 0 self 1500) ; "Highground One to Twenty David - Hostage down - not visible. Repeat- not visible. Suspect not visible. One /two corner, level one clear of suspect..."
			)
			(8
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gFxSound number: 1002 setLoop: 0 play: self)
			)
			(9
				(gFxSound number: 31610 setLoop: 0 play: self)
			)
			(10
				(SetFlag 304)
				(SetFlag 97)
				(SetFlag 93)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance anim9 of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local35 9)
				(= local34 1)
				(gTheDoits
					add:
						(uniformDude
							view: 15004
							setLoop: 0
							setCel: 0
							posn: 405 575
							init: ((snipePlane casts:) at: 0)
							setCycle: CT 10 1 self
							yourself:
						)
				)
			)
			(1
				(uniformDude setCycle: End self)
				(gMessager say: 1 2 73 0 0 1500) ; "Highground One reporting...Immediate threat! Weapon visible!"
			)
			(2
				(gTheDoits
					add:
						(eastman
							view: 15004
							setLoop: 1
							setCel: 0
							posn: 405 575
							init: ((snipePlane casts:) at: 0)
							setCycle: End
							yourself:
						)
				)
				(uniformDude setCel: 0 setLoop: 2 setCycle: End self)
			)
			(3
				(gTheDoits delete: (uniformDude dispose: yourself:))
				(gTheDoits delete: (eastman dispose: yourself:))
				(gMessager say: 1 2 36 0 self 1500) ; "Highground One to Twenty David - Hostage down - not visible. Repeat- not visible. Suspect not visible. One /two corner, level one clear of suspect..."
			)
			(4
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gFxSound number: 1002 setLoop: 0 play: self)
			)
			(5
				(gFxSound number: 31610 setLoop: 0 play: self)
			)
			(6
				(SetFlag 304)
				(SetFlag 97)
				(SetFlag 93)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance shootEastman of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheDoits
					add:
						(eastman
							view: 15004
							loop: 0
							cel: 0
							x: 395
							y: 579
							init: ((snipePlane casts:) at: 0)
							setCycle: End self
							yourself:
						)
				)
			)
			(1
				(eastman setLoop: 1 cel: 0 setCycle: End self)
			)
			(2
				(gTheDoits delete: (eastman dispose: yourself:))
				(self dispose:)
			)
		)
	)
)

(instance shootEastman2 of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheDoits
					add:
						(eastman
							view: 15004
							setLoop: 1
							cel: 0
							init:
							setCycle: End self
							yourself:
						)
				)
			)
			(1
				(gTheDoits delete: (eastman dispose: yourself:))
				(self dispose:)
			)
		)
	)
)

(instance windChanger of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local21 (windFlag loop:))
				(= local23 (windFlag view:))
				(= local6 (Random 1 5))
				(while (== local8 local7)
					(= local7 (Random 1 12))
				)
				(switch local7
					(1
						(= local24 15035)
					)
					(2
						(= local24 15034)
					)
					(3
						(= local24 15033)
					)
					(4
						(= local24 15032)
					)
					(5
						(= local24 15031)
					)
					(6
						(= local24 15030)
					)
					(7
						(= local24 15031)
					)
					(8
						(= local24 15032)
					)
					(9
						(= local24 15033)
					)
					(10
						(= local24 15034)
					)
					(11
						(= local24 15035)
					)
					(12
						(= local24 15036)
					)
				)
				(switch local6
					(6
						(if (> local7 6)
							(= local22 0)
						else
							(= local22 1)
						)
					)
					(5
						(if (> local7 6)
							(= local22 2)
						else
							(= local22 3)
						)
					)
					(4
						(if (> local7 6)
							(= local22 4)
						else
							(= local22 5)
						)
					)
					(3
						(if (> local7 6)
							(= local22 4)
						else
							(= local22 5)
						)
					)
					(2
						(if (> local7 6)
							(= local22 6)
						else
							(= local22 7)
						)
					)
					(1
						(if (> local7 6)
							(= local22 8)
						else
							(= local22 9)
						)
					)
				)
				(= cycles 1)
			)
			(1
				(if (> local22 local21)
					(if
						(or
							(and (mod local22 2) (not (mod local21 2)))
							(and (not (mod local22 2)) (mod local21 2))
						)
						(++ local21)
					else
						(+= local21 2)
					)
				)
				(if (< local22 local21)
					(if
						(or
							(and (mod local22 2) (not (mod local21 2)))
							(and (not (mod local22 2)) (mod local21 2))
						)
						(-- local21)
					else
						(-= local21 2)
					)
				)
				(if (> local24 local23)
					(++ local23)
				)
				(if (< local24 local23)
					(-- local23)
				)
				(windFlag view: local23 setLoop: local21 setCycle: Fwd)
				(= cycles 65)
			)
			(2
				(if (or (!= local21 local22) (!= local23 local24))
					(-= state 2)
				)
				(self changeState: (+ state 1) &rest)
			)
			(3
				(gMessager say: 1 2 2 local7 self 1500)
			)
			(4
				(gMessager say: 1 2 3 local6 self 1500)
			)
			(5
				(= local8 local7)
				(windTimer setReal: windTimer (Random 20 40))
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance firstTimeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 1 2 7 0 self 1500) ; "Twenty David to Highground One, what do you see?"
			)
			(1
				(++ local41)
				(roomTimer setReal: roomTimer 10)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance greenLightUnloaded of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager sayRange: 1 2 82 1 3 self 1500) ; "Pup, load your weapon!"
			)
			(1
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gMessager say: 1 2 82 4 self 1500) ; "Highground One prepare for removal. Highground Two... move to the one / four corner of building two."
			)
			(2
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance snipePlane of Plane
	(properties)

	(method (doit &tmp temp0 temp1 temp2)
		(if local27
			(-- local27)
			(return)
		)
		(if (and local14 (not local13))
			(= temp2 0)
			(= temp0 (- local11 gMouseX))
			(= temp1 (- local12 gMouseY))
			(cond
				((< local11 gMouseX)
					(= temp2 1)
					(self
						setRect:
							(- left (Abs temp0))
							top
							(- right (Abs temp0))
							bottom
					)
				)
				((> local11 gMouseX)
					(= temp2 1)
					(self
						setRect:
							(+ left (Abs temp0))
							top
							(+ right (Abs temp0))
							bottom
					)
				)
			)
			(cond
				((< local12 gMouseY)
					(= temp2 1)
					(self
						setRect:
							left
							(- top (Abs temp1))
							right
							(- bottom (Abs temp1))
					)
				)
				((> local12 gMouseY)
					(= temp2 1)
					(self
						setRect:
							left
							(+ top (Abs temp1))
							right
							(+ bottom (Abs temp1))
					)
				)
			)
			(if temp2
				(= local11 gMouseX)
				(= local12 gMouseY)
				(UpdatePlane self)
			)
		)
		(super doit:)
	)
)

(instance priView of View
	(properties
		x 136
		y 383
		view 15021
	)
)

(instance theBlast of View
	(properties
		x 212
		y 240
		view 1503
	)

	(method (init)
		(+= x (- (gThePlane left:) (snipePlane left:)))
		(+= y (- (gThePlane top:) (snipePlane top:)))
		(super init: ((snipePlane casts:) at: 0) &rest)
		(self setPri: 1002)
	)
)

(instance windWindow of View
	(properties
		x 4
		y 6
		view 15037
	)

	(method (handleEvent))
)

(instance windFlag of Prop
	(properties
		x 62
		y 79
		view 15033
		loop 5
	)

	(method (handleEvent))
)

(instance sideDial of Prop
	(properties
		x 438
		y 205
		view 1501
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setCel: global446)
	)

	(method (dispose)
		(= global446 cel)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (& (event type:) evMOUSEBUTTON))
			(if (> (event y:) (- y 58))
				(= scratch 1)
			else
				(= scratch 0)
			)
		)
		(super handleEvent: event)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (== argc 1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return
			(cond
				((or (& signal $0008) (not local13)) 0)
				((not onMeCheck)
					(IsOnMe temp0 temp1 self (& signal $1000))
				)
				(else
					(super onMe: temp0 temp1)
				)
			)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(29
				(= temp0 cel)
				(if local13
					(cond
						(scratch
							(if
								(and
									(< (snipePlane left:) 166)
									(!= temp0 (self lastCel:))
								)
								(++ local2)
								(++ global448)
								(if (>= temp0 (self lastCel:))
									(= temp0 0)
								else
									(++ temp0)
								)
								(self setCel: temp0)
								(snipePlane
									setRect:
										(+ (snipePlane left:) local16)
										(snipePlane top:)
										(+ (snipePlane right:) local16)
										(snipePlane bottom:)
										1
								)
							)
						)
						((and (> (snipePlane right:) 436) (!= temp0 0))
							(-- local2)
							(-- global448)
							(if (== temp0 0)
								(= temp0 (self lastCel:))
							else
								(-- temp0)
							)
							(self setCel: temp0)
							(snipePlane
								setRect:
									(- (snipePlane left:) local16)
									(snipePlane top:)
									(- (snipePlane right:) local16)
									(snipePlane bottom:)
									1
							)
						)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance topDial of Prop
	(properties
		x 266
		y 59
		view 1501
	)

	(method (init)
		(super init: &rest)
		(self setCel: global445)
	)

	(method (dispose)
		(= global445 cel)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (& (event type:) evMOUSEBUTTON))
			(if (< (event x:) (+ x 34))
				(= scratch 1)
			else
				(= scratch 0)
			)
			(super handleEvent: event)
		else
			(event claimed: 0)
			(return)
		)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (== argc 1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return
			(cond
				((or (& signal $0008) (not local13)) 0)
				((not onMeCheck)
					(IsOnMe temp0 temp1 self (& signal $1000))
				)
				(else
					(super onMe: temp0 temp1)
				)
			)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(29
				(= temp0 cel)
				(if local13
					(cond
						(scratch
							(if
								(and
									(< (snipePlane top:) 17)
									(!= temp0 (self lastCel:))
								)
								(++ local1)
								(++ global447)
								(if (>= temp0 (self lastCel:))
									(= temp0 0)
								else
									(++ temp0)
								)
								(self setCel: temp0)
								(snipePlane
									setRect:
										(snipePlane left:)
										(+ (snipePlane top:) local17)
										(snipePlane right:)
										(+ (snipePlane bottom:) local17)
										1
								)
							)
						)
						((and (> (snipePlane bottom:) 332) (!= temp0 0))
							(-- local1)
							(-- global447)
							(if (== temp0 0)
								(= temp0 (self lastCel:))
							else
								(-- temp0)
							)
							(self setCel: temp0)
							(snipePlane
								setRect:
									(snipePlane left:)
									(- (snipePlane top:) local17)
									(snipePlane right:)
									(- (snipePlane bottom:) local17)
									1
							)
						)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bolt of Prop
	(properties
		x 254
		y 388
		view 1502
		cycleSpeed 2
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (== argc 1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return
			(cond
				((or (& signal $0008) (not local13)) 0)
				((not onMeCheck)
					(IsOnMe temp0 temp1 self (& signal $1000))
				)
				(else
					(super onMe: temp0 temp1)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(27
				(if local15
					(bolt setScript: reloadBullet)
				else
					(gMessager say: 1 2 79 0 0 1500) ; "Pup, calm down. Your weapon is already loaded. Take it easy and breath nice and slow."
				)
			)
			(29
				(if (not local15)
					(self setScript: ejectBullet)
				else
					(shotSound number: 47 setLoop: 0 play:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bulletHole of Prop
	(properties
		view 15092
	)

	(method (init)
		(super init: ((snipePlane casts:) at: 0) &rest)
		(self setPri: 480)
	)
)

(instance uniformDude of Prop
	(properties)
)

(instance fatDude of Prop
	(properties)
)

(instance eastman of Prop
	(properties)
)

(instance trigger of Feature
	(properties
		y 480
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 262 359 285 291 348 291 372 359
					yourself:
				)
		)
	)

	(method (dispose)
		(super dispose: &rest)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (== argc 1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return
			(cond
				((not local13) 0)
				((not onMeCheck)
					(if
						(or
							(not (or nsLeft nsRight nsTop nsBottom))
							(and
								(<= nsLeft temp0 nsRight)
								(<= nsTop temp1 nsBottom)
							)
						)
						1
					else
						0
					)
				)
				((onMeCheck isKindOf: List)
					(onMeCheck firstTrue: #onMe temp0 temp1)
				)
				(else
					(onMeCheck onMe: temp0 temp1)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(27
				(if local15
					(bolt setScript: reloadBullet)
				else
					(if gTalkers
						(gTalkers eachElementDo: #dispose)
					)
					(gMessager say: 1 2 79 0 0 1500) ; "Pup, calm down. Your weapon is already loaded. Take it easy and breath nice and slow."
				)
			)
			(36
				(gMessager say: 1 2 84 0 0 1500) ; "Pup, the SR60 is chambered for a .308 round, not a forty-five."
			)
			(35
				(gMessager say: 1 2 85 0 0 1500) ; "Pup, the SR60 takes a .308 round, not a forty-five."
			)
			(29
				(= local28 0)
				(cond
					(local15
						(shotSound number: 48 setLoop: 0 play:)
						(if local34
							(gCurRoom setScript: greenLightUnloaded)
						else
							(gMessager say: 1 2 81 0 0 1500) ; "This is not the time to dry fire or practice your trigger pull. Load your weapon and wait for the green light."
						)
					)
					((and local13 (not local15))
						(bolt setScript: ejectBullet)
						(if gTalkers
							(gTalkers eachElementDo: #dispose)
						)
						(roomTimer dispose: delete:)
						(windTimer dispose: delete:)
						((= local20 (bulletHole new:))
							x: (+ 319 (- (gThePlane left:) (snipePlane left:)))
							y: (+ 179 (- (gThePlane top:) (snipePlane top:)))
						)
						(if (theWindows onMe: (local20 x:) (local20 y:))
							(local20 setLoop: 0 setCel: 1)
						else
							(local20 setLoop: 1 setCel: 0)
						)
						(local20
							init: ((snipePlane casts:) at: 0) gFtrInitializer
							cycleSpeed: 2
							setPri: 1001
							setCycle: End
						)
						(local20 x: (adjustForWind doit: (local20 x:)))
						(local20 y: (adjustForDistance doit: (local20 y:)))
						(theBlast init: ((snipePlane casts:) at: 0) gFtrInitializer)
						(UpdateScreenItem local20)
						(UpdateScreenItem theBlast)
						(FrameOut)
						(shotSound number: 45 setLoop: 0 play:)
						(= local40 1)
						(shotManager doit:)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance focusDial of Feature ; UNUSED
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 143 102 149 102 152 92 164 92 167 102 195 103 195 200 172 200 172 202 168 203 164 210 152 210 147 202 143 202
					yourself:
				)
		)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (== argc 1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return
			(cond
				((not local13) 0)
				((not onMeCheck)
					(if
						(or
							(not (or nsLeft nsRight nsTop nsBottom))
							(and
								(<= nsLeft temp0 nsRight)
								(<= nsTop temp1 nsBottom)
							)
						)
						1
					else
						0
					)
				)
				((onMeCheck isKindOf: List)
					(onMeCheck firstTrue: #onMe temp0 temp1)
				)
				(else
					(onMeCheck onMe: temp0 temp1)
				)
			)
		)
	)
)

(instance theWindows of Feature
	(properties)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (== argc 1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return
			(cond
				((not local13) 0)
				((not onMeCheck)
					(if
						(or
							(not (or nsLeft nsRight nsTop nsBottom))
							(and
								(<= nsLeft temp0 nsRight)
								(<= nsTop temp1 nsBottom)
							)
						)
						1
					else
						0
					)
				)
				((onMeCheck isKindOf: List)
					(onMeCheck firstTrue: #onMe temp0 temp1)
				)
				(else
					(onMeCheck onMe: temp0 temp1)
				)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 505 546 843 523 844 433 503 443
					yourself:
				)
				((Polygon new:)
					type: PNearestAccess
					init: 502 312 844 317 842 230 501 211
					yourself:
				)
				((Polygon new:)
					type: PNearestAccess
					init: 370 312 369 211 206 233 205 323
					yourself:
				)
				((Polygon new:)
					type: PNearestAccess
					init: 373 546 371 445 332 445 334 542
					yourself:
				)
				((Polygon new:)
					type: PNearestAccess
					init: 280 539 280 443 205 442 205 534
					yourself:
				)
		)
	)
)

(instance myTalkerStopCheck of Code
	(properties)

	(method (doit)
		(return 0)
	)
)

(instance firstTime of Code
	(properties)

	(method (doit)
		(switch local41
			(0
				(gCurRoom setScript: firstTimeScript)
			)
			(1
				(gCurRoom setScript: anim1)
			)
			(2
				(gCurRoom setScript: anim2)
			)
			(3
				(gCurRoom setScript: anim3)
			)
			(4
				(gCurRoom setScript: anim4)
			)
			(5
				(gCurRoom setScript: anim6)
			)
			(6
				(gCurRoom setScript: anim7)
			)
			(7
				(gCurRoom setScript: anim8)
			)
		)
	)
)

(instance crankUpAnimation of Code
	(properties)

	(method (doit)
		(switch (Random 1 9)
			(1
				(if (== local35 1)
					(self doit:)
				else
					(gCurRoom setScript: anim1)
				)
			)
			(2
				(if (== local35 2)
					(self doit:)
				else
					(gCurRoom setScript: anim2)
				)
			)
			(3
				(if (== local35 3)
					(self doit:)
				else
					(gCurRoom setScript: anim3)
				)
			)
			(4
				(if (== local35 4)
					(self doit:)
				else
					(gCurRoom setScript: anim4)
				)
			)
			(5
				(if (== local35 5)
					(self doit:)
				else
					(gCurRoom setScript: anim5)
				)
			)
			(6
				(if (== local35 6)
					(self doit:)
				else
					(gCurRoom setScript: anim6)
				)
			)
			(7
				(if (== local35 7)
					(self doit:)
				else
					(gCurRoom setScript: anim7)
				)
			)
			(8
				(if (== local35 8)
					(self doit:)
				else
					(gCurRoom setScript: anim8)
				)
			)
			(9
				(if (== local35 9)
					(self doit:)
				else
					(gCurRoom setScript: anim9)
				)
			)
		)
	)
)

(instance adjustForWind of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1 temp2 temp3)
		(= temp1 0)
		(= temp3 (= temp0 0))
		(if (mod local7 3)
			(= temp2 1)
		)
		(if (or (OneOf local7 6 12) (< local5 100) (< local6 5))
			(return (+ param1 (* global448 local16)))
		)
		(if (>= local5 100)
			(= temp0 (/ (* (/ local5 100) local6) 15))
			(if temp2
				(= temp3 (* temp0 3))
			else
				(= temp3 (* temp0 4))
			)
			(if (>= global448 0)
				(= temp0 (* (- (+ temp3 2) global448) local16))
			else
				(= temp0 (* (+ temp3 2 global448) local16))
			)
		)
		(return
			(if (OneOf local7 1 2 3 4 5)
				(+ param1 temp0)
			else
				(- param1 temp0)
			)
		)
	)
)

(instance adjustForDistance of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1)
		(= temp1 0)
		(switch local5
			(100
				(if (>= global447 0)
					(return (+ param1 (* (- 4 global447) local17)))
				else
					(return (+ param1 (* (+ 4 global447) local17)))
				)
			)
			(200
				(if (>= global447 0)
					(return (+ param1 (* (- 13 global447) local17)))
				else
					(return (+ param1 (* (+ 13 global447) local17)))
				)
			)
			(250
				(if (>= global447 0)
					(return (+ param1 (* (- 14 global447) local17)))
				else
					(return (+ param1 (* (+ 14 global447) local17)))
				)
			)
			(300
				(if (>= global447 0)
					(return (+ param1 (* (- 16 global447) local17)))
				else
					(return (+ param1 (* (+ 16 global447) local17)))
				)
			)
			(400
				(if (>= global447 0)
					(return (+ param1 (* (- 18 global447) local17)))
				else
					(return (+ param1 (* (+ 18 global447) local17)))
				)
			)
			(500
				(if (>= global447 0)
					(return (+ param1 (* (- 20 global447) local17)))
				else
					(return (+ param1 (* (+ 20 global447) local17)))
				)
			)
			(else
				(return (+ param1 temp1))
			)
		)
	)
)

(instance shotManager of Code
	(properties)

	(method (doit)
		(switch local35
			(0
				(gCurRoom setScript: shootFirstTimer)
			)
			(1
				(if (eastman onMe: (local20 x:) (local20 y:))
					(gCurRoom setScript: shootAnim1)
				else
					(gCurRoom setScript: missAnim1)
				)
			)
			(2
				(cond
					((eastman onMe: (local20 x:) (local20 y:))
						(gCurRoom setScript: shootEast2)
					)
					((> (eastman cel:) 120)
						(gCurRoom setScript: missAnim2Left)
					)
					(else
						(gCurRoom setScript: missAnim2Right)
					)
				)
			)
			(3
				(cond
					((fatDude onMe: (local20 x:) (local20 y:))
						(gCurRoom setScript: shootFat3)
					)
					((uniformDude onMe: (local20 x:) (local20 y:))
						(gCurRoom setScript: shootUni3)
					)
					(else
						(gCurRoom setScript: missAnim3)
					)
				)
			)
			(4
				(cond
					((uniformDude onMe: (local20 x:) (local20 y:))
						(gCurRoom setScript: shootUni4)
					)
					((fatDude onMe: (local20 x:) (local20 y:))
						(gCurRoom setScript: shootFat4)
					)
					(else
						(gCurRoom setScript: shootMiss4)
					)
				)
			)
			(5
				(cond
					((uniformDude onMe: (local20 x:) (local20 y:))
						(gCurRoom setScript: shootUni5)
					)
					((fatDude onMe: (local20 x:) (local20 y:))
						(gCurRoom setScript: shootFat5)
					)
					(else
						(gCurRoom setScript: shootMiss5)
					)
				)
			)
			(6
				(if (uniformDude onMe: (local20 x:) (local20 y:))
					(gCurRoom setScript: shootUni6)
				else
					(gCurRoom setScript: shootMiss6)
				)
			)
			(7
				(if (uniformDude onMe: (local20 x:) (local20 y:))
					(gCurRoom setScript: shootUni7)
				else
					(gCurRoom setScript: shootMiss7)
				)
			)
			(8
				(cond
					((eastman onMe: (local20 x:) (local20 y:))
						(gCurRoom setScript: shootEast8)
					)
					((uniformDude onMe: (local20 x:) (local20 y:))
						(gCurRoom setScript: shootUni8)
					)
					(else
						(gCurRoom setScript: shootMiss8)
					)
				)
			)
			(9
				(cond
					((eastman onMe: (local20 x:) (local20 y:))
						(gCurRoom setScript: shootEast9)
					)
					((uniformDude onMe: (local20 x:) (local20 y:))
						(gCurRoom setScript: shootUni9)
					)
					(else
						(gCurRoom setScript: shootMiss9)
					)
				)
			)
		)
	)
)

(instance windTimer of Timer
	(properties)

	(method (cue)
		(if (or (gCurRoom script:) (gTalkers size:))
			(self setReal: self (Random 20 40))
		else
			(gCurRoom setScript: windChanger)
			(self dispose: delete:)
		)
	)
)

(instance roomTimer of Timer
	(properties)

	(method (cue)
		(if (gCurRoom script:)
			(self setReal: self 5)
		else
			(if (IsFlag 83)
				(crankUpAnimation doit:)
			else
				(firstTime doit:)
			)
			(self dispose: delete:)
		)
	)
)

(instance lashTimer of Timer
	(properties)

	(method (cue)
		(if (gTalkers size:)
			(self setReal: self 5)
		else
			(if (not (gCurRoom script:))
				(gGame handsOff:)
				(gMessager say: 7 144 0 0 gCurRoom 0) ; "Pup! The LASH is not a toy! Confine your comments to the situation at hand!"
			)
			(self dispose: delete:)
		)
	)
)

(instance shotSound of Sound
	(properties)
)

