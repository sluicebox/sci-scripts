;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3)
(include sci.sh)
(use Main)
(use Print)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	titleScreen 0
)

(local
	local0
	local1
	local2
)

(instance titleScreen of Room
	(properties
		picture 0
		style 0
	)

	(method (init)
		(gThePlane setRect: 0 0 319 199 1)
		(gTheIconBar disable:)
		(Platform 0 2 1)
		(Load rsVIEW 3)
		(Load rsVIEW 23)
		(if (== gPrevRoomNum 779)
			(= picture 0)
			(super init: &rest)
			(self drawPic: 0 0 1)
		else
			(super init: &rest)
		)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(gDirectionHandler addToFront: self)
		(gGame setIntensity: 100 1)
		(gTheCursor hide:)
		(self setScript: doTitle)
	)

	(method (doVerb)
		(if (< (doTitle state:) 5)
			(gGlobalSound0 client: 0 stop:)
			(doTitle cycles: 0 seconds: 0 ticks: 0 state: 5 cue:)
		)
	)

	(method (dispose)
		(Platform 0 2 0)
		(gThePlane setRect: 0 0 319 152)
		(if (gPqFlags test: 133)
			(gTheIconBar curIcon: (gTheIconBar at: 0))
		)
		(gTheIconBar enable: show: 0)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(gDirectionHandler delete: self)
		(super dispose:)
	)
)

(instance leftCars of Prop
	(properties
		x 189
		y 165
		view 6
	)
)

(instance rightCars of Prop
	(properties
		x 290
		y 127
		view 4
	)
)

(instance openSeason of Prop
	(properties
		x 218
		y 78
		priority 14
		fixPriority 1
		view 3
		loop 6
		cycleSpeed 0
	)

	(method (init)
		(|= signal $4800)
		(super init: &rest)
	)
)

(instance sparkle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(client dispose:)
			)
		)
	)
)

(instance spark0 of Prop
	(properties
		x 86
		y 153
		z 1000
		priority 100
		fixPriority 1
		view 23
		loop 8
	)
)

(instance spark1 of Prop
	(properties
		x 185
		y 154
		z 1000
		priority 100
		fixPriority 1
		view 23
		loop 8
	)
)

(instance drive of Script
	(properties)

	(method (changeState)
		(client
			loop: (if (> register (client lastLoop:)) 0 else register)
			cel: 0
			setCycle: End self
		)
		(= register (+ (client loop:) 1))
	)
)

(instance doTitle of Script
	(properties)

	(method (doit)
		(if (== (DoAudio audPOSITION 997 0 0 0 1) -1)
			(= local2 1)
		)
		(super doit: &rest)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(spark0 init:)
				(spark1 init:)
				(= cycles 2)
			)
			(1
				(if (== gPrevRoomNum 779)
					(= state 5)
					(self cue:)
				else
					(PalCycle 0 95 223 1 1) ; Start
					(gCurRoom drawPic: 10)
					(gGlobalSound0 number: 1 loop: 1 play: self)
				)
			)
			(2
				(= seconds 30)
			)
			(3
				(= seconds 30)
				(spark0 z: 0 setScript: (sparkle new:))
			)
			(4
				(spark1 z: 0 setScript: (sparkle new:))
				(= seconds 30)
			)
			(5
				(= seconds 0)
				(= ticks 160)
			)
			(6
				(PalCycle 4) ; Off
				(gTheCursor show:)
				(gGame setCursor: gTheArrowCursor)
				(gTheIconBar curIcon: (gTheIconBar useIconItem:))
				(= local0 (Print new:))
				(local0 x: 65 y: 10 margin: 0 skip: 0 back: (local0 skip:))
				((local0 addIcon: (if (IsHiRes) 2300 else 23) 9 0 0 0) state: 0)
				((local0
						addIcon:
							(if (IsHiRes) 2301 else 23)
							2
							0
							34
							(if (IsHiRes) 35 else 34)
					)
					value: 0
					state: 3
				)
				((local0
						addIcon:
							(if (IsHiRes) 2301 else 23)
							3
							0
							34
							(if (IsHiRes) 53 else 52)
					)
					value: 1
					state: 3
				)
				((local0
						addIcon:
							(if (IsHiRes) 2301 else 23)
							4
							0
							34
							(if (IsHiRes) 71 else 70)
					)
					value: 2
					state: 3
				)
				((local0
						addIcon:
							(if (IsHiRes) 2301 else 23)
							5
							0
							34
							(if (IsHiRes) 89 else 88)
					)
					value: 3
					state: 3
				)
				((local0
						addIcon:
							(if (IsHiRes) 2301 else 23)
							6
							0
							34
							(if (IsHiRes) 108 else 106)
					)
					value: 4
					state: 3
				)
				((local0
						addIcon:
							(if (IsHiRes) 2301 else 23)
							7
							0
							34
							(if (IsHiRes) 126 else 124)
					)
					value: 5
					state: 3
				)
				((local0 dialog:) mouseHiliting: 1)
				(switch (= local1 (local0 init:))
					(0
						(self cue:)
					)
					(1
						(gPqFlags set: 133)
						(gCast eachElementDo: #dispose release:)
						(gCurRoom drawPic: 0 0 1)
						(FrameOut)
						(gCurRoom newRoom: 100)
					)
					(2
						(gGame restore:)
						(self cue:)
					)
					(3
						(gGame setScript: (ScriptID 8 0) self) ; aboutScr
					)
					(4
						(if (and (not (gCurRoom picture:)) (== gCurRoomNum 3)) ; titleScreen
							(PalCycle 4) ; Off
							(PalVary 3) ; PalVaryKill
						)
						(gMessager say: 0 0 0 0 self 23) ; "SALES ORDER INFORMATION  To place a domestic order with Sierra On-Line, call \(800\) 757-7707 from 7:00 a.m. through 7:00 p.m. Pacific Time, Monday through Friday for convenient, person-to-person service. Or if you prefer, you may place your order via Fax \(206\) 562-4223. Please include your name, address, phone number, credit card number and expiration date."
					)
					(5
						(= gQuit 1)
					)
				)
			)
			(7
				(if (OneOf local1 3 4)
					(= state 5)
					(= cycles 2)
				else
					(gCast eachElementDo: #dispose release:)
					(FrameOut)
					(= ticks 30)
				)
			)
			(8
				(gGame fade: 100 0 10)
				(PalCycle 4) ; Off
				(gCurRoom drawPic: 0 0 1)
				(= cycles 2)
			)
			(9
				(Purge 3000)
				(gTheCursor hide:)
				(gGame setIntensity: 0)
				(gCurRoom drawPic: 3 0 1)
				(FrameOut)
				(leftCars init: cycleSpeed: 6 setCycle: Fwd)
				(rightCars init: cycleSpeed: 6 setScript: drive)
				(gGame fade: 0 100 10)
				(= seconds 3)
			)
			(10
				((= register (Prop new:))
					view: 3
					setLoop: 0
					cel: 0
					fixPriority: 1
					priority: 0
					x: 218
					y: 78
					init:
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(11
				(DoAudio audPLAY 997 0 0 0 1)
				(= local2 0)
				(register loop: 1 cel: 0 setCycle: End self)
			)
			(12
				(register loop: 2 cel: 0 setCycle: End self)
			)
			(13
				(register loop: 3 cel: 0 setCycle: End self)
			)
			(14
				(register loop: 4 cel: 0 setCycle: End self)
			)
			(15
				(register cycleSpeed: 5 loop: 5 cel: 0 setCycle: End self)
			)
			(16
				(= seconds 5)
			)
			(17
				(sFx number: 933 loop: 1 play: self)
			)
			(18
				(openSeason init: setCycle: CT 4 1 self)
			)
			(19
				(sFx number: 932 loop: 1 play: self)
			)
			(20
				(openSeason setCycle: End self)
			)
			(21
				(sFx number: 1008 loop: 1 play: self)
			)
			(22
				(sFx number: 1010 loop: 1 play: self)
			)
			(23
				(= ticks 60)
			)
			(24
				(if local2
					(= ticks 10)
				else
					(-- state)
					(= ticks 10)
				)
			)
			(25
				(DoAudio audSTOP 997 0 0 0 1)
				(gThePlane setRect: 0 0 319 152)
				(gGame fade: 100 0 10)
				(gCast eachElementDo: #dispose release:)
				(gCurRoom drawPic: 0 0 1)
				(FrameOut)
				(PalCycle 4) ; Off
				(gTheCursor show:)
				(gCurRoom newRoom: 100)
			)
		)
	)
)

(class CreditButtons of View
	(properties)

	(method (showHilight)
		(if (not cel)
			(= cel 1)
			(UpdateScreenItem self)
		)
	)

	(method (hideHilight)
		(if cel
			(= cel 0)
			(UpdateScreenItem self)
		)
	)

	(method (init)
		(super init: &rest)
		(gPrints addToFront: self)
	)

	(method (dispose)
		(gPrints delete: self)
		(super dispose:)
	)

	(method (isModeless)
		(return 1)
	)

	(method (handleEvent event &tmp [temp0 2])
		(cond
			((event claimed:)
				(self hideHilight:)
			)
			((self onMe: event)
				(gPrints eachElementDo: #perform hideHighlight)
				(event claimed: 1 type: (& (event type:) evMOUSEBUTTON))
				(if (event type:)
					(while (not ((event new:) type:))
						(event localize: (gCurRoom plane:))
						(if (self onMe: event)
							(self showHilight:)
						else
							(self hideHilight:)
						)
						(FrameOut)
					)
					(event new:)
					(if cel
						(self hideHilight:)
						(self doVerb:)
					)
				else
					(self showHilight:)
				)
			)
			(else
				(self hideHilight:)
			)
		)
	)
)

(instance hideHighlight of Code
	(properties)

	(method (doit param1)
		(if (param1 respondsTo: #hideHilight)
			(param1 hideHilight:)
		)
	)
)

(instance introItem of CreditButtons ; UNUSED
	(properties
		x 99
		y 36
		view 23
		loop 2
	)

	(method (init)
		(if (IsHiRes)
			(= view 2300)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(PalCycle 4) ; Off
		(doTitle cue:)
	)
)

(instance playItem of CreditButtons ; UNUSED
	(properties
		x 99
		y 54
		view 23
		loop 3
	)

	(method (init)
		(if (IsHiRes)
			(= view 2301)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(gPqFlags set: 133)
		(PalCycle 4) ; Off
		(gCast eachElementDo: #dispose release:)
		(gCurRoom drawPic: 0 0 1)
		(FrameOut)
		(gCurRoom newRoom: 100)
	)
)

(instance restoreItem of CreditButtons ; UNUSED
	(properties
		x 99
		y 72
		view 23
		loop 4
	)

	(method (init)
		(if (IsHiRes)
			(= view 2301)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(PalCycle 4) ; Off
		(gGame restore:)
	)
)

(instance creditsItem of CreditButtons ; UNUSED
	(properties
		x 99
		y 90
		view 23
		loop 5
	)

	(method (init)
		(if (IsHiRes)
			(= view 2301)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(PalCycle 4) ; Off
		(gGame setScript: (ScriptID 8 0)) ; aboutScr
	)
)

(instance instructItem of CreditButtons ; UNUSED
	(properties
		x 99
		y 108
		view 23
		loop 6
	)

	(method (init)
		(if (IsHiRes)
			(= view 2301)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(PalCycle 4) ; Off
		(gMessager sayPlain: 0 0 0 0 0 23)
	)
)

(instance quitItem of CreditButtons ; UNUSED
	(properties
		x 99
		y 126
		view 23
		loop 7
	)

	(method (init)
		(if (IsHiRes)
			(= view 2301)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(= gQuit 1)
	)
)

(instance sFx of Sound
	(properties)
)

(instance fadeDown of Script ; UNUSED
	(properties)

	(method (init)
		(super init: &rest)
		(= register 100)
	)

	(method (doit)
		(if register
			(-= register 5)
			(Palette 2 139 239 register) ; PalIntensity
		else
			(self dispose:)
		)
	)
)

