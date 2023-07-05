;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 411)
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
	rm411 0
)

(local
	local0
)

(instance rm411 of LabRoom
	(properties
		north 400
		east 400
		south 400
		west 400
	)

	(method (init)
		(super init:)
		(if (IsFlag 1)
			(switch ((ScriptID 30 0) prevEdgeHit:) ; rLab
				(1
					(proc401_1)
				)
				(3
					(proc401_0)
				)
				(4
					(proc401_3)
				)
				(2
					(proc401_2)
				)
			)
			(gCurRoom setScript: (ScriptID 30 1)) ; walkIn
		else
			(gGlobalSound number: 409 setLoop: -1 play:)
			(westHalfTrapFloor init: stopUpd:)
			(eastHalfTrapFloor init: stopUpd:)
			(eastTrapLedge init: stopUpd:)
			(westTrapLedge init: stopUpd:)
			(northTrapLedge init: stopUpd:)
			(gCurRoom setScript: dieAlready)
		)
		(switch ((ScriptID 30 0) prevEdgeHit:) ; rLab
			(1
				((ScriptID 30 0) initCrypt: 1) ; rLab
			)
			(3
				((ScriptID 30 0) initCrypt: 4) ; rLab
				((ScriptID 30 7) addToPic:) ; topDoor
				((ScriptID 30 8) addToPic:) ; bottomBlock
			)
			(4
				((ScriptID 30 0) initCrypt: 4) ; rLab
				((ScriptID 30 6) addToPic:) ; rightDoor
				((ScriptID 30 10) addToPic:) ; rightWing
				((ScriptID 30 8) addToPic:) ; bottomBlock
			)
			(2
				((ScriptID 30 0) initCrypt: 2) ; rLab
				((ScriptID 30 5) addToPic:) ; leftDoor
				((ScriptID 30 9) addToPic:) ; leftWing
				((ScriptID 30 8) addToPic:) ; bottomBlock
			)
		)
	)
)

(instance dieAlready of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheIconBar disable:)
				(switch ((ScriptID 30 0) prevEdgeHit:) ; rLab
					(4
						(gEgo posn: 282 164 loop: 1 init:)
					)
					(2
						(gEgo posn: 36 164 loop: 0 init:)
					)
					(3
						(gEgo posn: 158 135 loop: 2 init:)
					)
					(1
						(gEgo posn: 158 225 loop: 3 init:)
					)
				)
				(= seconds 2)
			)
			(1
				(if
					(and
						(== gPrevRoomNum 425)
						(not (IsFlag 1))
						(< ((ScriptID 30 0) timesGenieHasAppeared:) 4) ; rLab
					)
					(self cue:)
				else
					(gMessager say: 1 0 58 1 self 400) ; "As he walks through the doorway, Alexander gets a VERY bad feeling about this room."
				)
			)
			(2
				(switch ((ScriptID 30 0) prevEdgeHit:) ; rLab
					(4
						(gEgo setMotion: PolyPath 215 164 self)
					)
					(2
						(gEgo setMotion: PolyPath 108 164 self)
					)
					(3
						(gEgo setMotion: PolyPath 158 156 self)
					)
					(1
						(gEgo setMotion: PolyPath 158 185 self)
					)
				)
			)
			(3
				(if
					(and
						(== gPrevRoomNum 425)
						(not (IsFlag 1))
						(< ((ScriptID 30 0) timesGenieHasAppeared:) 4) ; rLab
					)
					(= local0 1)
					(gMessager say: 1 0 3 1 self 400) ; "That's odd. Where did she...."
				else
					(self cue:)
				)
			)
			(4
				(switch ((ScriptID 30 0) prevEdgeHit:) ; rLab
					(1
						(= temp0 3)
						(= temp1 0)
						(= temp2 0)
					)
					(3
						(= temp0 2)
						(= temp1 0)
						(= temp2 0)
					)
					(4
						(= temp0 1)
						(= temp1 -5)
						(= temp2 0)
					)
					(2
						(= temp0 0)
						(= temp1 7)
						(= temp2 2)
					)
				)
				(gEgo
					x: (+ (gEgo x:) temp1)
					y: (+ (gEgo y:) temp2)
					view: 4011
					normal: 0
					cycleSpeed: 6
					setLoop: temp0
					setCycle: CT 10 1 self
				)
			)
			(5
				(gEgo setCycle: End self)
			)
			(6
				(if local0
					(SetFlag 59)
					(gMessager say: 1 0 3 2 self 400) ; "GOOOOoooooooo?"
				else
					(gMessager say: 1 0 58 2 self 400) ; "!!!Remove this msg."
				)
			)
			(7
				(gGlobalSound number: 432 setLoop: 1 play: self)
			)
			(8
				(ClearFlag 59)
				(gGlobalSound number: 307 setLoop: 1 play:)
				(ShakeScreen 2 ssLEFTRIGHT)
				(= ticks 4)
			)
			(9
				(gCurRoom drawPic: 98 100)
				(gCast eachElementDo: #hide)
				(= cycles 4)
			)
			(10
				(EgoDead 7) ; "Don't just wander, Alexander! Let your conscience be your Guide."
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
		priority 3
		signal 16400
	)
)

(instance westTrapLedge of View
	(properties
		x 104
		y 140
		view 409
		loop 3
		priority 3
		signal 16400
	)
)

