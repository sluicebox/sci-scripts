;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3486)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use BorderWindow)
(use Cel)
(use Button)
(use Sound)

(public
	threshLock 0
)

(local
	local0
)

(instance threshLock of P2Room
	(properties
		picture 800
		south 3485
	)

	(method (init)
		(super init: &rest)
		(butnA myCel: celA init:)
		(butnB myCel: celB init:)
		(butnC myCel: celC init:)
		(butnD myCel: celD init:)
		(butnE myCel: celE init:)
		(gGame handsOn: 1)
	)
)

(instance localBeep of Sound ; UNUSED
	(properties
		number 3486
	)
)

(class DoorKeyButton of Button
	(properties
		myCel -1
		celDelta 0
	)

	(method (handleEvent event)
		(if (> (event y:) 266)
			(= celDelta -1)
		else
			(= celDelta 1)
		)
		(super handleEvent: event)
	)

	(method (action &tmp temp0)
		(if (< (myCel y:) 0)
			(celA y: 103)
			(celB y: 103)
			(celC y: 103)
			(celD y: 103)
			(celE y: 103)
			(UpdateScreenItem celA)
			(UpdateScreenItem celB)
			(UpdateScreenItem celC)
			(UpdateScreenItem celD)
			(UpdateScreenItem celE)
		)
		(cond
			((> (= temp0 (+ (myCel cel:) celDelta)) 9)
				(= temp0 0)
			)
			((< temp0 0)
				(= temp0 9)
			)
		)
		(myCel cel: temp0)
		(UpdateScreenItem myCel)
		(gP2SoundFX play: 3486)
		(cond
			((not (butnA script:))
				(butnA setScript: timerScript)
			)
			((timerScript state:))
			(
				(and
					(== (celA cel:) 9)
					(== (celB cel:) 1)
					(== (celC cel:) 0)
					(== (celD cel:) 5)
					(== (celE cel:) 8)
				)
				(butnA setScript: toComputerRoomScript)
			)
			((>= (++ local0) 30)
				(= global209 6550)
				(gCurRoom newRoom: 999) ; poorSadDeadCrazyAlienSucker
			)
		)
	)

	(method (init)
		(super init: &rest)
		(myCel init:)
	)
)

(instance timerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 15)
			)
			(1
				(gGame handsOff:)
				(celA hide:)
				(celB hide:)
				(celC hide:)
				(celD hide:)
				(celE hide:)
				(= ticks 15)
			)
			(2
				(gP2SoundFX play: 3486)
				(celA show:)
				(celB show:)
				(celC show:)
				(celD show:)
				(celE show:)
				(= ticks 25)
			)
			(3
				(celA hide:)
				(celB hide:)
				(celC hide:)
				(celD hide:)
				(celE hide:)
				(= ticks 15)
			)
			(4
				(gP2SoundFX play: 3486)
				(celA show:)
				(celB show:)
				(celC show:)
				(celD show:)
				(celE show:)
				(= ticks 20)
			)
			(5
				(celA hide:)
				(celB hide:)
				(celC hide:)
				(celD hide:)
				(celE hide:)
				(= ticks 15)
			)
			(6
				(gP2SoundFX play: 3486)
				(celA show:)
				(celB show:)
				(celC show:)
				(celD show:)
				(celE show:)
				(= ticks 25)
			)
			(7
				(celA hide:)
				(celB hide:)
				(celC hide:)
				(celD hide:)
				(celE hide:)
				(= ticks 15)
			)
			(8
				(gP2SoundFX play: 3486)
				(celA show:)
				(celB show:)
				(celC show:)
				(celD show:)
				(celE show:)
				(= ticks 20)
			)
			(9
				(= global209 6550)
				(gCurRoom newRoom: 999) ; poorSadDeadCrazyAlienSucker
			)
		)
	)
)

(instance toComputerRoomScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(celA hide:)
				(celB hide:)
				(celC hide:)
				(celD hide:)
				(celE hide:)
				(= ticks 15)
			)
			(1
				(gP2SoundFX play: 3486)
				(celA show:)
				(celB show:)
				(celC show:)
				(celD show:)
				(celE show:)
				(= ticks 30)
			)
			(2
				(gP2SongPlyr start: 811)
				(SetFlag 733)
				(= global209 6441)
				(gCurRoom newRoom: 9000) ; threshCompRm
			)
		)
	)
)

(instance butnA of DoorKeyButton
	(properties
		x 170
		y 236
		view 800
	)
)

(instance celA of Cel
	(properties
		x 170
		y -103
		view 800
		loop 5
	)
)

(instance butnB of DoorKeyButton
	(properties
		x 232
		y 232
		view 800
		loop 1
	)
)

(instance celB of Cel
	(properties
		x 232
		y -103
		view 800
		loop 5
	)
)

(instance butnC of DoorKeyButton
	(properties
		x 298
		y 235
		view 800
		loop 2
	)
)

(instance celC of Cel
	(properties
		x 298
		y -103
		view 800
		loop 5
	)
)

(instance butnD of DoorKeyButton
	(properties
		x 364
		y 231
		view 800
		loop 3
	)
)

(instance celD of Cel
	(properties
		x 364
		y -103
		view 800
		loop 5
	)
)

(instance butnE of DoorKeyButton
	(properties
		x 430
		y 235
		view 800
		loop 4
	)
)

(instance celE of Cel
	(properties
		x 430
		y -103
		view 800
		loop 5
	)
)

