;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8)
(include sci.sh)
(use Main)
(use PQRoom)
(use Spin)
(use SwatFile)
(use Motion)
(use Actor)
(use System)

(public
	sierraLogo 0
)

(instance sierraLogo of PQRoom
	(properties
		picture 990
	)

	(method (init)
		(Load rsVIEW 990)
		(Load rsAUDIO 40 801)
		(gSwatInterface hideCursor: 1)
		(theLogo init:)
		(letterS init:)
		(letterI init:)
		(letterE init:)
		(letterR1 init:)
		(letterR2 init:)
		(letterA init:)
		(super init: &rest)
		Spin
		(self setScript: showLogo)
	)

	(method (newRoom newRoomNumber)
		(Palette 2 0 254 0) ; PalIntensity
		(FrameOut)
		(gCast eachElementDo: #dispose)
		(if (!= newRoomNumber 10) ; titleScreen
			(gSwatInterface hideCursor: 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance showLogo of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler addToFront: self)
	)

	(method (handleEvent event)
		(if (== (event message:) KEY_SPACE)
			(if (gBackMusic handle:)
				(gBackMusic stop:)
			)
			(if (SwatFile readIt: 2)
				(gCurRoom newRoom: 15) ; mainMenu
			else
				(gCurRoom newRoom: 10) ; titleScreen
			)
			(return 1)
		)
		(return 0)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(if (and (not state) (gBackMusic handle:) (>= (DoAudio audPOSITION) 210))
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gBackMusic number: 801 loop: 1 play:)
			)
			(1
				(patAllen
					view: 990
					loop: 1
					cel: 0
					posn: 185 299
					setPri: 30
					init:
					setCycle: CT 8 1 self
				)
			)
			(2
				(gFxSound number: 40 loop: 1 play:)
				(letterS setCycle: Spin 0 0)
				(patAllen setCycle: CT 12 1 self)
			)
			(3
				(gFxSound play:)
				(letterI setCycle: Spin 0 0)
				(patAllen setCycle: CT 17 1 self)
			)
			(4
				(gFxSound play:)
				(letterE setCycle: Spin 0 0)
				(patAllen setCycle: End self)
			)
			(5
				(patAllen setCycle: CT 17 -1 self)
			)
			(6
				(gFxSound play:)
				(letterR1 setCycle: Spin 0 0)
				(patAllen setCycle: CT 12 -1 self)
			)
			(7
				(gFxSound play:)
				(letterR2 setCycle: Spin 0 0)
				(patAllen setCycle: CT 8 -1 self)
			)
			(8
				(gFxSound play:)
				(letterA setCycle: Spin 0 0)
				(patAllen setCycle: Beg self)
			)
			(9
				(patAllen dispose:)
				(if (letterA cycler:)
					((letterA cycler:) caller: self)
				else
					(= cycles 4)
				)
			)
			(10
				(= seconds 4)
			)
			(11
				(if (SwatFile readIt: 2)
					(gCurRoom newRoom: 15) ; mainMenu
				else
					(gCurRoom newRoom: 10) ; titleScreen
				)
			)
		)
	)
)

(instance theLogo of View
	(properties
		x 208
		y 87
		priority 87
		fixPriority 1
		view 990
	)
)

(instance letterS of Prop
	(properties
		x 195
		y 375
		priority 400
		fixPriority 1
		view 990
		loop 2
		cycleSpeed 4
	)
)

(instance letterI of Prop
	(properties
		x 195
		y 375
		priority 400
		fixPriority 1
		view 990
		loop 3
		cycleSpeed 4
	)
)

(instance letterE of Prop
	(properties
		x 195
		y 375
		priority 400
		fixPriority 1
		view 990
		loop 4
		cycleSpeed 4
	)
)

(instance letterR1 of Prop
	(properties
		x 195
		y 375
		priority 400
		fixPriority 1
		view 990
		loop 5
		cycleSpeed 4
	)
)

(instance letterR2 of Prop
	(properties
		x 195
		y 375
		priority 400
		fixPriority 1
		view 990
		loop 6
		cycleSpeed 4
	)
)

(instance letterA of Prop
	(properties
		x 195
		y 375
		priority 400
		fixPriority 1
		view 990
		loop 7
		cycleSpeed 4
	)
)

(instance patAllen of Prop
	(properties
		priority 30
		fixPriority 1
		view 990
		loop 1
	)
)

