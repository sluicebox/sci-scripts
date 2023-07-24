;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 34010)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm34v010 0
)

(local
	local0
)

(instance rm34v010 of ShiversRoom
	(properties
		picture 34010
	)

	(method (init)
		(cond
			((== global348 1)
				(self picture: 34010)
			)
			((== global348 2)
				(self picture: 34011)
			)
			((== global348 3)
				(self picture: 34012)
			)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(spButtonOn init: setCel: 3)
		(hsButton1 init:)
		(hsButton2 init:)
		(hsButton3 init:)
		(spFloorLight init:)
		(pWindow init: hide:)
		(spDoorWindow init: hide:)
		(super init: &rest)
		(if (IsFlag 43)
			(self setScript: sBong)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (!= newRoomNumber 34020) (!= newRoomNumber 34040)) ; rm34v020, rm34v040
			(gSounds interruptChain:)
			(gSounds stop: 23401)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 34040
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 34020
	)
)

(instance efExitForward of ExitFeature
	(properties)

	(method (init)
		(self createPoly: 27 13 216 13 218 142 22 142 26 13)
		(switch (- global348 1)
			(0
				(spDoor1 init: cel: 0)
			)
			(1
				(spDoor2 init: cel: 0)
			)
			(2
				(spDoor3 init: cel: 0)
			)
		)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)
)

(instance pWindow of Prop
	(properties
		priority 27
		fixPriority 1
		view 34010
	)

	(method (init)
		(cond
			((== global348 1)
				(self view: 34010)
			)
			((== global348 2)
				(self view: 34011)
			)
			((== global348 3)
				(self view: 34012)
			)
		)
		(super init: &rest)
	)
)

(instance spDoorWindow of ShiversProp
	(properties
		priority 26
		fixPriority 1
		cycleSpeed 18
	)

	(method (init)
		(cond
			((== global348 1)
				(self view: 34001 loop: 4)
			)
			((== global348 2)
				(self view: 34002 loop: 4)
			)
			((== global348 3)
				(self view: 34003 loop: 4)
			)
		)
		(super init: &rest)
	)
)

(instance spButtonOn of ShiversProp
	(properties)

	(method (init)
		(switch (- global348 1)
			(0
				(self view: 34001 loop: 3 cel: 0 setPri: 30)
			)
			(1
				(self view: 34002 loop: 3 cel: 1 setPri: 30)
			)
			(2
				(self view: 34003 loop: 3 cel: 2 setPri: 30)
			)
		)
		(super init: &rest)
	)
)

(instance hsButton3 of HotSpot
	(properties)

	(method (init)
		(self
			createPoly: 234 75 230 75 228 78 228 81 229 84 236 84 238 82 237 77 235 75
		)
		(super init: &rest)
	)

	(method (doVerb)
		(if (!= global348 3)
			(= local0 global348)
			(= global348 3)
			(spButtonOn setCel: 2)
			(gCurRoom setScript: sCloseDoor)
		)
	)
)

(instance hsButton2 of HotSpot
	(properties)

	(method (init)
		(self
			createPoly: 230 88 237 88 240 92 239 95 235 97 231 97 228 94 228 91 230 89
		)
		(super init: &rest)
	)

	(method (doVerb)
		(if (!= global348 2)
			(= local0 global348)
			(= global348 2)
			(spButtonOn setCel: 1)
			(gCurRoom setScript: sCloseDoor)
		)
	)
)

(instance hsButton1 of HotSpot
	(properties)

	(method (init)
		(self
			createPoly: 230 101 236 101 240 104 240 107 237 110 236 110 231 110 229 108 228 105 230 102
		)
		(super init: &rest)
	)

	(method (doVerb)
		(if (!= global348 1)
			(= local0 global348)
			(= global348 1)
			(spButtonOn setCel: 0)
			(gCurRoom setScript: sCloseDoor)
		)
	)
)

(instance spUpDownLight of ShiversProp
	(properties)

	(method (init)
		(cond
			((> global348 local0)
				(cond
					((== local0 1)
						(self view: 34001 loop: 2 cel: 0 setPri: 25)
					)
					((== local0 2)
						(self view: 34002 loop: 2 cel: 0 setPri: 25)
					)
					((== local0 3)
						(self view: 34003 loop: 2 cel: 0 setPri: 25)
					)
				)
			)
			((== local0 1)
				(self view: 34001 loop: 2 cel: 1 setPri: 25)
			)
			((== local0 2)
				(self view: 34002 loop: 2 cel: 1 setPri: 25)
			)
			((== local0 3)
				(self view: 34003 loop: 3 cel: 1 setPri: 25)
			)
		)
		(super init: &rest)
	)
)

(instance spFloorLight of ShiversProp
	(properties)

	(method (init)
		(switch (- global348 1)
			(0
				(self view: 34001 loop: 1 cel: 0 setPri: 30)
			)
			(1
				(self view: 34002 loop: 1 cel: 1 setPri: 30)
			)
			(2
				(self view: 34003 loop: 1 cel: 2 setPri: 30)
			)
		)
		(super init: &rest)
	)
)

(instance spDoor1 of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 34001
		cel 7
	)

	(method (doVerb)
		(gCurRoom newRoom: 10030) ; rm10v030
	)
)

(instance spDoor2 of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 34002
		cel 7
	)

	(method (doVerb)
		(gCurRoom newRoom: 27214) ; rm27v214
	)
)

(instance spDoor3 of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 34003
		cel 7
	)

	(method (doVerb)
		(gCurRoom newRoom: 33150) ; rm33v150
	)
)

(instance sBong of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(ClearFlag 43)
				(= seconds 1)
			)
			(1
				(= seconds 2)
			)
			(2
				(gSounds playChain: -1 -2 23402 -1)
				(gSounds adjChainVol: 90)
				(= cycles 1)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCloseDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(spUpDownLight init:)
				(gSounds play: 10501 0 30 0)
				(gSounds play: 10505 0 60 0)
				(switch (- local0 1)
					(0
						(spDoor1 cycleSpeed: 18 setCycle: End self)
					)
					(1
						(spDoor2 cycleSpeed: 18 setCycle: End self)
					)
					(2
						(spDoor3 cycleSpeed: 18 setCycle: End self)
					)
				)
				(= seconds 4)
			)
			(1
				(spDoorWindow show:)
				(spDoorWindow setCycle: End)
				(= seconds 4)
			)
			(2
				(proc951_9 10504)
				(gSounds play: 10504 -1 0 0)
				(gSounds fade: 10504 90 1 30 0 0)
				(switch (- local0 1)
					(0
						(spDoor1 hide: dispose:)
					)
					(1
						(spDoor2 hide: dispose:)
					)
					(2
						(spDoor3 hide: dispose:)
					)
				)
				(pWindow show:)
				(if (> (- global348 local0) 0)
					(pWindow loop: 0 cel: 0 cycleSpeed: 24 setCycle: End self)
				else
					(pWindow loop: 2 cel: 4 cycleSpeed: 24 setCycle: Beg self)
				)
			)
			(3
				(if (<= -1 (- global348 local0) 1)
					(gSounds fade: 10504 0 15 8 1 0)
				)
				(if (> (- global348 local0) 0)
					(pWindow loop: 1 cel: 0 cycleSpeed: 18 setCycle: End self)
				else
					(pWindow loop: 1 cel: 19 cycleSpeed: 18 setCycle: Beg self)
				)
			)
			(4
				(if (> (- global348 local0) 0)
					(pWindow loop: 2 cel: 0 cycleSpeed: 18 setCycle: End self)
				else
					(pWindow loop: 0 cel: 4 cycleSpeed: 18 setCycle: Beg self)
				)
			)
			(5
				(cond
					((== (- global348 local0) 2)
						(spFloorLight cel: 1)
						(gSounds play: 10509 0 30 0)
						(pWindow
							loop: 0
							cel: 0
							cycleSpeed: 18
							setCycle: End self
						)
					)
					((== (- global348 local0) -2)
						(spFloorLight cel: 1)
						(gSounds play: 10509 0 30 0)
						(pWindow
							loop: 2
							cel: 4
							cycleSpeed: 18
							setCycle: Beg self
						)
					)
					(else
						(self cue:)
					)
				)
			)
			(6
				(cond
					((== (- global348 local0) 2)
						(gSounds fade: 10504 0 10 30 1 0)
						(pWindow
							loop: 1
							cel: 0
							cycleSpeed: 18
							setCycle: End self
						)
					)
					((== (- global348 local0) -2)
						(gSounds fade: 10504 0 10 30 1 0)
						(pWindow
							loop: 1
							cel: 19
							cycleSpeed: 18
							setCycle: Beg self
						)
					)
					(else
						(self cue:)
					)
				)
			)
			(7
				(cond
					((== (- global348 local0) 2)
						(pWindow
							loop: 2
							cel: 0
							cycleSpeed: 24
							setCycle: End self
						)
					)
					((== (- global348 local0) -2)
						(pWindow
							loop: 0
							cel: 4
							cycleSpeed: 24
							setCycle: Beg self
						)
					)
					(else
						(self cue:)
					)
				)
			)
			(8
				(gSounds stop: 10504)
				(pWindow hide: dispose:)
				(spUpDownLight hide: dispose:)
				(switch (- global348 1)
					(0
						(spDoorWindow setCycle: Beg self init:)
						(spButtonOn init: setCel: 3)
						(gCurRoom drawPic: 34010)
						(spDoor1 init: hide:)
						(gSounds play: 10509 0 30 0)
						(spFloorLight init: cel: 0)
					)
					(1
						(spDoorWindow setCycle: Beg self init:)
						(spButtonOn init: setCel: 3)
						(gCurRoom drawPic: 34011)
						(spDoor2 init: hide:)
						(gSounds play: 10509 0 30 0)
						(spFloorLight init: cel: 1)
					)
					(2
						(spDoorWindow setCycle: Beg self init:)
						(spButtonOn init: setCel: 3)
						(gCurRoom drawPic: 34012)
						(spDoor3 init: hide:)
						(gSounds play: 10509 0 30 0)
						(spFloorLight init: cel: 2)
					)
				)
				(= seconds 4)
			)
			(9
				(gSounds stop: 10509)
				(switch (- global348 1)
					(0
						(spDoorWindow hide:)
						(gSounds play: 10503 0 30 0)
						(spDoor1 show: cycleSpeed: 18 setCycle: Beg self)
					)
					(1
						(spDoorWindow hide:)
						(gSounds play: 10503 0 30 0)
						(spDoor2 show: cycleSpeed: 18 setCycle: Beg self)
					)
					(2
						(spDoorWindow hide:)
						(gSounds play: 10503 0 30 0)
						(spDoor3 show: cycleSpeed: 18 setCycle: Beg self)
					)
				)
			)
			(10
				(= seconds 2)
			)
			(11
				(pWindow init: hide:)
				(spDoorWindow init: hide:)
				(ClearFlag 6)
				(efExitForward init: 3)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

