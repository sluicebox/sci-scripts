;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 96)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Save)
(use Motion)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	rm096 0
)

(local
	[local0 2]
	local2
	local3
	[local4 50]
	[local54 40]
	[local94 40]
)

(instance rm096 of Rm
	(properties
		picture 100
	)

	(method (init)
		(TheMenuBar hide:)
		(SL disable:)
		(HandsOff)
		(= global103 1)
		(Load rsSOUND 8)
		(Load rsVIEW 100)
		(Load rsVIEW 101)
		(Load rsVIEW 93)
		(Load rsVIEW 94)
		(Load rsVIEW 16)
		(Load rsVIEW 19)
		(Load rsVIEW 21)
		(Load rsVIEW 23)
		(Load rsVIEW 25)
		(Load rsVIEW 27)
		(Load rsVIEW 29)
		(Load rsVIEW 31)
		(Load rsVIEW 33)
		(Load rsPIC 0)
		(super init:)
		(theSound play:)
		(self setScript: introScript)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if
			(and
				(!= (self script:) choiceScript)
				(or (== (event type:) evKEYBOARD) (== (event type:) evMOUSEBUTTON))
			)
			(if (== (event message:) KEY_F2)
				(event claimed: 0)
			else
				(= global103 1)
				(= global104 gNormalCursor)
				(gGame setCursor: global104)
				(introScript setScript: choiceScript)
			)
		)
	)
)

(instance introScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== (theSound prevSignal:) 10)
			(theSound prevSignal: 0)
			(= local3 1)
			(introScript cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch global131
					(0
						(gGame setSpeed: 4)
					)
					(1
						(gGame setSpeed: 7)
					)
					(2
						(gGame setSpeed: 8)
					)
				)
				(mu1 posn: -21 40 init: setMotion: MoveTo 153 26 self)
				(mu2 posn: 343 40 init: setMotion: MoveTo 172 26)
			)
			(1
				(= cycles 5)
			)
			(2
				(mu1 stopUpd:)
				(mu2 stopUpd:)
				(rider
					view: 93
					posn: 15 156
					setPri: 9
					init:
					setMotion: MoveTo 324 156
				)
				(wing init:)
			)
			(3
				(rider
					setLoop: 4
					cel: 0
					setCycle: End self
					setMotion: MoveTo 324 156
				)
			)
			(4
				(motherSign init:)
				(gooseSign init:)
				(rider
					setLoop: 0
					cel: 0
					setCycle: Fwd
					setMotion: MoveTo 324 156 self
				)
			)
			(5
				(rider
					view: 27
					setLoop: 0
					cel: 0
					posn: 19 167
					setMotion: MoveTo 500 167 self
				)
				(rope init:)
				(banner view: 100 setLoop: 2 setCel: 0 init:)
			)
			(6
				(rider
					view: 19
					cel: 0
					posn: 19 167
					setMotion: MoveTo 500 167 self
				)
				(banner view: 100 setLoop: 2 setCel: 1)
			)
			(7
				(rider
					view: 23
					cel: 0
					posn: 19 167
					setMotion: MoveTo 500 167 self
				)
				(banner view: 100 setLoop: 3 setCel: 0)
			)
			(8
				(rider
					view: 29
					cel: 0
					posn: 19 167
					setMotion: MoveTo 500 167 self
				)
				(banner view: 100 setLoop: 4 setCel: 0)
			)
			(9
				(rider
					view: 33
					cel: 0
					posn: 19 167
					setMotion: MoveTo 500 167 self
				)
				(banner view: 100 setLoop: 6 setCel: 0)
			)
			(10
				(rider
					view: 21
					cel: 0
					posn: 19 167
					setMotion: MoveTo 500 167 self
				)
				(banner view: 100 setLoop: 7 setCel: 0)
			)
			(11
				(= seconds 3)
			)
			(12
				(= local2 1)
				(= global103 1)
				(= global104 gNormalCursor)
				(gGame setCursor: global104)
				(gCurRoom setScript: choiceScript)
			)
		)
	)
)

(instance wing of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 16
			setLoop: (+ (rider loop:) 5)
			ignoreHorizon: 1
			ignoreActors: 1
			illegalBits: 0
		)
	)

	(method (doit)
		(self posn: (rider x:) (rider y:) setCel: (rider cel:))
		(super doit:)
	)
)

(instance rider of Act
	(properties)

	(method (init)
		(super init:)
		(self
			setLoop: 0
			setCel: 0
			setCycle: Fwd
			ignoreHorizon: 1
			ignoreActors: 1
			illegalBits: 0
			cycleSpeed: (if global131 1 else 0)
			setStep:
				(if global131
					4
					3
				else
					5
					4
				)
		)
	)
)

(instance mu1 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 100
			setLoop: 0
			setPri: 0
			ignoreActors: 1
			cycleSpeed: (if global131 1 else 0)
			setStep:
				(if global131
					4
					3
				else
					5
					4
				)
		)
	)
)

(instance mu2 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 100
			setLoop: 1
			setPri: 0
			ignoreActors: 1
			cycleSpeed: (if global131 1 else 0)
			setStep:
				(if global131
					4
					3
				else
					5
					4
				)
		)
	)
)

(instance banner of Act
	(properties)

	(method (init)
		(super init:)
		(self view: 100 ignoreActors: 1)
	)

	(method (doit)
		(self posn: (- (rider x:) 119) 170)
		(super doit:)
	)
)

(instance rope of Act
	(properties)

	(method (init)
		(super init:)
		(self view: 100 ignoreActors: 1 setLoop: 5)
	)

	(method (doit)
		(self setCel: (rider cel:) posn: (- (rider x:) 28) 174)
		(super doit:)
	)
)

(instance motherSign of View
	(properties
		y 73
		x 111
		view 101
	)

	(method (init)
		(super init:)
		(self addToPic:)
	)
)

(instance gooseSign of View
	(properties
		y 72
		x 222
		view 101
		loop 1
	)

	(method (init)
		(super init:)
		(self addToPic:)
	)
)

(instance twinkle of Sound ; UNUSED
	(properties
		number 2
		priority 10
	)
)

(instance choiceScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theSound fade:)
				(gCurRoom drawPic: 99 8)
				(Load rsFONT gSmallFont)
				(Load rsCURSOR gWaitCursor)
				(gGame setCursor: gNormalCursor (HaveMouse))
				(DeviceInfo diGET_DEVICE gCurSaveDir @local94)
				(DeviceInfo diGET_CURRENT_DEVICE @local54)
				(DeviceInfo diPATHS_EQUAL @local94 @local54)
				(if (DeviceInfo diIS_FLOPPY @local54)
					(Format @local4 96 0 @local54) ; "Please insert your SAVE GAME disk in drive %s."
					(DeviceInfo 4) ; CloseDevice
					(if
						(Print
							@local4
							#font
							0
							#button
							{OK}
							0
							#button
							{Change Directory}
							1
						)
						(GetDirectory gCurSaveDir)
					)
				else
					(= global139 1)
				)
				(if
					(= global197
						(GetSaveFiles (gGame name:) @global371 @global520)
					)
					(gCurRoom newRoom: 199) ; intro
				else
					(gCurRoom newRoom: 200)
				)
			)
		)
	)
)

(instance theSound of Sound
	(properties
		number 8
		priority 5
		loop 2
	)
)

