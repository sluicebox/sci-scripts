;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 435)
(include sci.sh)
(use Main)
(use rLab)
(use n401)
(use n913)
(use PolyPath)
(use Motion)
(use Actor)
(use System)

(public
	trapFloor 0
)

(instance trapFloor of LabRoom
	(properties
		north 400
		west 400
	)

	(method (init)
		(proc401_2)
		(super init: &rest)
		((ScriptID 30 0) initCrypt: 2) ; rLab
		((ScriptID 30 5) addToPic:) ; leftDoor
		((ScriptID 30 9) addToPic:) ; leftWing
		((ScriptID 30 8) addToPic:) ; bottomBlock
		(self setScript: fallTrapFloor)
	)
)

(instance fallTrapFloor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheIconBar disable: 6)
				(gEgo posn: 36 164 init: setMotion: PolyPath 120 164 self)
			)
			(1
				(= cycles 8)
			)
			(2
				(westHalfTrapFloor init: stopUpd:)
				(eastHalfTrapFloor init: stopUpd:)
				(eastTrapLedge init: stopUpd:)
				(westTrapLedge init: stopUpd:)
				(northTrapLedge init: stopUpd:)
				(= cycles 2)
			)
			(3
				(gGlobalSound stop:)
				(gGlobalSound2 number: 909 setLoop: 1 play: self)
			)
			(4
				(gGlobalSound number: 409 setLoop: -1 play:)
				(= cycles 4)
			)
			(5
				(if (IsFlag 1)
					(gMessager say: 1 0 30 0 self 400) ; "Alexander seems to have found the 'path' to the second level of the catacombs again."
				else
					(gMessager say: 1 0 29 1 self 400) ; "Zounds! A trap floor!"
				)
			)
			(6
				(gEgo
					setLoop: (gEgo cel:)
					normal: 0
					cycleSpeed: 1
					setCycle: Fwd
				)
				(= seconds 3)
			)
			(7
				(gGlobalSound stop:)
				(gGlobalSound2 number: 404 setLoop: 1 play:)
				(gEgo
					setCycle: 0
					setStep: 40 30
					setMotion: MoveTo (gEgo x:) 250 self
				)
			)
			(8
				(gTheIconBar enable: 6)
				(gCurRoom style: -32758 newRoom: 406)
			)
		)
	)
)

(instance westHalfTrapFloor of View
	(properties
		x 83
		y 159
		view 409
		priority 1
		signal 16400
	)
)

(instance eastHalfTrapFloor of View
	(properties
		x 233
		y 158
		view 409
		loop 1
		priority 1
		signal 16400
	)
)

(instance northTrapLedge of View
	(properties
		x 108
		y 148
		view 409
		loop 4
		priority 2
		signal 16400
	)
)

(instance eastTrapLedge of View
	(properties
		x 211
		y 141
		view 409
		loop 2
		priority 2
		signal 16400
	)
)

(instance westTrapLedge of View
	(properties
		x 104
		y 140
		view 409
		loop 3
		priority 2
		signal 16400
	)
)

