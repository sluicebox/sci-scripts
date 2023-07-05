;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use Interface)
(use ADRoom)
(use Print)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm100 0
)

(local
	local0
)

(instance rm100 of ADRoom
	(properties
		modNum 110
		picture 99
	)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(allOfIt init:)
		((ScriptID 895 1) get: 8) ; lockjaw, Fleas
		(self setScript: startScr)
	)

	(method (newRoom newRoomNumber)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(allOfIt dispose:)
		(gGame handsOn:)
		(gTheIconBar enable:)
		(gLongSong fade:)
		(super newRoom: newRoomNumber)
	)

	(method (cue)
		(switch (gLongSong prevSignal:)
			(10
				(sierraT show:)
			)
			(20
				(discoveryT show:)
			)
			(30
				(seriesT show:)
			)
			(else
				(startScr cue:)
			)
		)
	)
)

(instance startScr of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (> state 1)
			(Palette palANIMATE 112 127 -7 128 143 -5 144 159 -7 192 107 -5 96 111 -7)
		)
	)

	(method (handleEvent event)
		(if (and (OneOf (event type:) evMOUSEBUTTON evKEYBOARD evJOYDOWN) (not (event modifiers:)))
			(event claimed: 1)
			(if (< state 5)
				(gLongSong fade:)
				(allOfIt eachElementDo: #dispose)
				(self changeState: 6)
			)
		)
		(event claimed: 1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LoadMany rsVIEW 51 996)
				(Load rsVIEW 51)
				(gTheIconBar disable:)
				(gLongSong number: 1 setLoop: 1 play: gCurRoom)
				(smallGear init: hide:)
				(mediumGear init: hide:)
				(bigGear init: hide:)
				(sierraT init: hide:)
				(discoveryT init: hide:)
				(seriesT init: hide:)
				(logoLeft init:)
				(logoRight init:)
				(= ticks 5)
			)
			(1
				(gGame setCursor: 996 1)
				(if (IsFlag 165)
					(logoLeft xStep: 8 moveSpeed: 0)
					(logoRight xStep: 8 moveSpeed: 0)
					(smallGear cycleSpeed: 0 moveSpeed: 0)
					(mediumGear cycleSpeed: 0 moveSpeed: 0)
					(bigGear cycleSpeed: 0 moveSpeed: 0)
				else
					(logoLeft xStep: 3 moveSpeed: 0)
					(logoRight xStep: 3 moveSpeed: 0)
					(smallGear cycleSpeed: 2 moveSpeed: 1)
					(mediumGear cycleSpeed: 2 moveSpeed: 1)
					(bigGear cycleSpeed: 2 moveSpeed: 1)
				)
				(= ticks 19)
			)
			(2
				(logoLeft setMotion: MoveTo 140 169 self)
				(logoRight setMotion: MoveTo 140 169 self)
			)
			(3 0)
			(4
				(logoLeft setCel: 2 stopUpd:)
				(logoRight dispose:)
				(smallGear
					show:
					setCycle: Fwd
					setPri: 14
					setMotion: MoveTo 118 65
				)
				(mediumGear
					show:
					setCycle: Fwd
					setPri: 14
					setMotion: MoveTo 199 58
				)
				(= ticks 20)
			)
			(5
				(bigGear
					show:
					setCycle: Fwd
					setPri: 14
					setMotion: MoveTo 186 141
				)
			)
			(6
				(gGame setCursor: 999 1)
				(= cycles 1)
			)
			(7
				(gCurRoom drawPic: 99 10)
				(allOfIt eachElementDo: #dispose)
				(if (not global108)
					(= local0 110)
					(= gAct 1)
					(++ state)
				)
				(= seconds 3)
			)
			(8
				(= local0 0)
				(repeat
					(switch
						(Print
							addText: {Where to?}
							addButton: 0 {Teleport} 0 12
							addButton: 1 {StartGame} 0 26
							addButton: 2 {Restore} 0 40
							init:
						)
						(0
							(ClearFlag 77)
							(= local0 (GetNumber {Teleport to}))
						)
						(1
							(= local0 110)
							(= gAct 1)
						)
						(2
							(gGame restore:)
						)
					)
					(if local0
						(break)
					)
				)
				(= cycles 2)
			)
			(9
				(allOfIt dispose:)
				(gCurRoom newRoom: local0)
				(self dispose:)
			)
		)
	)
)

(instance logoLeft of Actor
	(properties
		x -100
		y 169
		z 100
		view 51
		priority 15
		signal 18448
		origStep 771
	)
)

(instance logoRight of Actor
	(properties
		x 380
		y 169
		z 100
		view 51
		cel 1
		priority 15
		signal 18448
		origStep 771
	)
)

(instance smallGear of Actor
	(properties
		x 138
		y 85
		view 51
		loop 1
		cel 3
		priority 15
		signal 18448
		origStep 257
	)
)

(instance mediumGear of Actor
	(properties
		x 167
		y 90
		view 51
		loop 2
		cel 3
		priority 15
		signal 18448
		origStep 257
	)
)

(instance bigGear of Actor
	(properties
		x 135
		y 90
		view 51
		loop 3
		cel 2
		priority 15
		signal 18448
		origStep 257
	)
)

(instance sierraT of View
	(properties
		x 211
		y 98
		view 51
		loop 4
		priority 15
		signal 16400
	)
)

(instance discoveryT of View
	(properties
		x 211
		y 98
		view 51
		loop 4
		cel 1
		priority 15
		signal 16400
	)
)

(instance seriesT of View
	(properties
		x 211
		y 98
		view 51
		loop 4
		cel 2
		priority 15
		signal 16400
	)
)

(instance allOfIt of List
	(properties)

	(method (init)
		(super init: &rest)
		(self
			add:
				logoRight
				logoLeft
				smallGear
				mediumGear
				bigGear
				sierraT
				discoveryT
				seriesT
		)
	)
)

