;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3)
(include sci.sh)
(use Main)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	titleScreen 0
)

(instance titleScreen of Room
	(properties
		picture 0
		style 0
	)

	(method (init)
		(DoAudio 12 0) ; AudMixCheck
		(gThePlane setRect: 0 0 319 199 1)
		(gTheIconBar disable:)
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
		(gThePlane setRect: 0 0 319 152)
		(if (gPqFlags test: 133)
			(gTheIconBar curIcon: (gTheIconBar at: 0))
		)
		(gTheIconBar enable: show: 0)
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
		x 76
		y 163
		z 1000
		priority 100
		fixPriority 1
		view 23
		loop 8
	)
)

(instance spark1 of Prop
	(properties
		x 175
		y 164
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
					(gGlobalSound0 number: 1 setLoop: 1 play: self)
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
				(gMouseDownHandler delete: gCurRoom)
				(gKeyDownHandler delete: gCurRoom)
				(gDirectionHandler delete: gCurRoom)
				((View new:)
					view: 23
					loop: 9
					cel: 0
					fixPriority: 1
					priority: 0
					x: 65
					y: 2
					init:
				)
				(introItem init:)
				(playItem init:)
				(restoreItem init:)
				(creditsItem init:)
				(instructItem init:)
				(quitItem init:)
				(gTheCursor show:)
				(gGame setCursor: gTheArrowCursor)
				(gTheIconBar curIcon: (gTheIconBar useIconItem:))
			)
			(7
				(gCast eachElementDo: #dispose release:)
				(FrameOut)
				(= ticks 30)
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
				(gGlobalSound0 number: 997 setPri: 100 setLoop: 1 play:)
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
				(sFx init: number: 933 setLoop: 1 play: self)
			)
			(17
				(openSeason init: setCycle: CT 4 1 self)
			)
			(18
				(sFx init: number: 932 setLoop: 1 play: self)
				(openSeason setCycle: End self)
			)
			(19
				(= ticks 120)
			)
			(20
				(sFx number: 1008 setLoop: 1 play: self)
			)
			(21
				(sFx number: 1010 setLoop: 1 play: self)
			)
			(22
				(if (!= (gGlobalSound0 prevSignal:) -1)
					(gGlobalSound0 client: self)
				else
					(self cue:)
				)
			)
			(23
				(gGlobalSound0 stop: flags: 1 number: 0)
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

(instance introItem of CreditButtons
	(properties
		x 99
		y 36
		view 23
		loop 2
	)

	(method (doVerb)
		(doTitle cue:)
	)
)

(instance playItem of CreditButtons
	(properties
		x 99
		y 54
		view 23
		loop 3
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

(instance restoreItem of CreditButtons
	(properties
		x 99
		y 72
		view 23
		loop 4
	)

	(method (doVerb)
		(gGame restore:)
	)
)

(instance creditsItem of CreditButtons
	(properties
		x 99
		y 90
		view 23
		loop 5
	)

	(method (doVerb)
		((ScriptID 8) doit:) ; aboutCode
	)
)

(instance instructItem of CreditButtons
	(properties
		x 99
		y 108
		view 23
		loop 6
	)

	(method (doVerb)
		(gMessager sayPlain: 0 0 0 0 0 23)
	)
)

(instance quitItem of CreditButtons
	(properties
		x 99
		y 126
		view 23
		loop 7
	)

	(method (doVerb)
		(= gQuit 1)
	)
)

(instance sFx of Sound
	(properties
		flags 5
		priority 10
	)
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

