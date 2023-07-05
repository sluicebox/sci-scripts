;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 603)
(include sci.sh)
(use Main)
(use n013)
(use verseScript)
(use RTEyeCycle)
(use PolyPath)
(use Rev)
(use Sound)
(use Motion)
(use System)

(public
	blewIt 0
	knockItOff 1
	incoming600 2
	incoming590 3
	walkToBoat 4
)

(local
	local0
	local1
	local2
	[local3 4] = [1601 94 1 0]
	[local7 5] = [1601 75 1 1 0]
	[local12 5] = [1601 97 1 0 0]
	[local17 5] = [1601 86 1 2 0]
)

(instance blewIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(self setScript: (ScriptID 5 1) self) ; blowinIt
			)
			(1
				(= ticks 90)
			)
			(2
				(Say 1601 92 self) ; "My men have good ears, but even they couldn't hear me winding the horn from this distance."
			)
			(3
				(gGame setScript: musicPlay)
				(= ticks 60)
			)
			(4
				(Say 1601 93 self) ; "Curse my foolishness. Now the monks have sounded the alarm. I'd best leave here at once."
			)
			(5
				(gEgo setMotion: PolyPath (gEgo x:) 245 self)
			)
			(6
				(gRgnMusic2 fade: 0 20 12 1)
				(gGame setScript: 0)
				(gCurRoom newRoom: 100)
			)
		)
	)
)

(instance knockItOff of Script
	(properties)

	(method (doit)
		(if (and (== ((ScriptID 601 3) cel:) 4) (!= (dieSound number:) 928)) ; robin
			(dieSound number: 928 play:)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 601 1) setMotion: 0) ; rgnBoat
				((ScriptID 601 2) ; monk
					setCel: 0
					setLoop: 0
					posn:
						(- ((ScriptID 601 2) x:) 2) ; monk
						(- ((ScriptID 601 2) y:) 3) ; monk
					setCycle: 0
				)
				(gSFX stop:)
				(= ticks 12)
			)
			(1
				((ScriptID 601 2) cycleSpeed: 6 setCycle: CT 2 1 self) ; monk
			)
			(2
				((ScriptID 601 2) setCycle: End self) ; monk
				(dieSound play:)
			)
			(3
				((ScriptID 601 3) cycleSpeed: 12 setCycle: End self) ; robin
			)
			(4
				(= ticks 30)
			)
			(5
				(if register
					(Converse 1 @local12 11 0 self) ; "I can't abide clodpates."
				else
					(Converse 1 @local3 11 0 self) ; "Some people never learn."
				)
			)
			(6
				(EgoDead)
			)
		)
	)
)

(instance incoming600 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 603)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 601 2) ; monk
					view: 21
					setLoop: 6
					setCel: 0
					setPri: 5
					xStep: 1
					yStep: 1
					posn: 203 128
					cycleSpeed: 18
					init:
				)
				(Face gEgo (ScriptID 601 2)) ; monk
				(= ticks 18)
			)
			(1
				((ScriptID 601 2) ; monk
					x: (- ((ScriptID 601 2) x:) 4) ; monk
					y: (+ ((ScriptID 601 2) y:) 3) ; monk
					setPri:
						(if (mod local0 2)
							(+ ((ScriptID 601 2) priority:) 1) ; monk
						else
							((ScriptID 601 2) priority:) ; monk
						)
				)
				(= ticks 18)
			)
			(2
				(if (< (++ local0) 6)
					(-= state 2)
				)
				(= ticks 18)
			)
			(3
				((ScriptID 601 2) setPri: -1 setCycle: End self) ; monk
			)
			(4
				((ScriptID 601 1) view: 21 loop: 3 cel: 2 posn: 178 132 init:) ; rgnBoat
				((ScriptID 601 2) view: 585 loop: 2 cel: 3 posn: 151 159 init:) ; monk
				(gEgo setMotion: PolyPath 113 164 self)
			)
			(5
				(gEgo setHeading: 45 self)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance incoming590 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 603)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 601 2) ; monk
					view: 21
					setLoop: 5
					setCel: 0
					setPri: 5
					xStep: 1
					yStep: 1
					posn: 59 126
					cycleSpeed: 18
					init:
				)
				(Face gEgo (ScriptID 601 2)) ; monk
				(= ticks 18)
			)
			(1
				((ScriptID 601 2) ; monk
					x: (+ ((ScriptID 601 2) x:) 4) ; monk
					setPri:
						(if (mod local0 2)
							(+ ((ScriptID 601 2) priority:) 1) ; monk
						else
							((ScriptID 601 2) priority:) ; monk
						)
				)
				(= ticks 18)
			)
			(2
				(if (< (++ local0) 6)
					(-= state 2)
				)
				(= ticks 18)
			)
			(3
				((ScriptID 601 2) setPri: -1 setCycle: End self) ; monk
			)
			(4
				((ScriptID 601 1) ; rgnBoat
					view: 21
					loop: 2
					cel: 2
					posn: 84 112
					setPri: ((ScriptID 601 2) priority:) ; monk
					signal: 16384
					init:
				)
				((ScriptID 601 2) view: 585 setLoop: 1 setCel: 3 posn: 100 137) ; monk
				(gEgo setMotion: PolyPath 135 145 self)
			)
			(5
				(gEgo setHeading: 315 self)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance walkToBoat of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== gCurRoomNum 590)
					(gEgo setMotion: PolyPath 131 144 self)
				else
					(gEgo setMotion: PolyPath 131 165 self)
				)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gTheIconBar disable: 5 4)
				(if (== gDisguiseNum 0) ; outlaw
					(self setScript: (ScriptID 601 8) self) ; stepInBoatAsOutlaw
				else
					(gEgo
						view: 19
						x: (if (== gCurRoomNum 590) 128 else 132)
						y: (if (== gCurRoomNum 590) 146 else 167)
						setLoop: (if (== gCurRoomNum 590) 0 else 1)
						setCel: 0
						setPri: (if (== gCurRoomNum 600) 10 else -1)
						cycleSpeed: 12
						setCycle: End self
					)
				)
			)
			(3
				(if (== gDisguiseNum 0) ; outlaw
					(client setScript: (ScriptID 601 9)) ; outlawAfterWisps
					(DisposeScript 603)
				else
					(client setScript: egoInMonkBoat)
				)
			)
		)
	)
)

(instance egoInMonkBoat of Script
	(properties)

	(method (doit)
		(if (gCast contains: (ScriptID 601 3)) ; robin
			(if (== gCurRoomNum 590)
				((ScriptID 601 3) ; robin
					priority: ((ScriptID 601 2) priority:) ; monk
					posn:
						(+ ((ScriptID 601 2) x:) 32) ; monk
						(+ ((ScriptID 601 2) y:) 9) ; monk
				)
				((ScriptID 601 1) ; rgnBoat
					priority: ((ScriptID 601 2) priority:) ; monk
					posn:
						(- ((ScriptID 601 2) x:) 16) ; monk
						(- ((ScriptID 601 2) y:) 25) ; monk
				)
				((ScriptID 601 2) setLoop: 1) ; monk
			else
				((ScriptID 601 3) ; robin
					priority: ((ScriptID 601 2) priority:) ; monk
					posn:
						(- ((ScriptID 601 2) x:) 25) ; monk
						(+ ((ScriptID 601 2) y:) 9) ; monk
				)
				((ScriptID 601 1) ; rgnBoat
					priority: ((ScriptID 601 2) priority:) ; monk
					posn:
						(+ ((ScriptID 601 2) x:) 27) ; monk
						(- ((ScriptID 601 2) y:) 27) ; monk
				)
				((ScriptID 601 2) setLoop: 2) ; monk
			)
		)
		(super doit:)
	)

	(method (init)
		(super init: &rest)
		((ScriptID 601 3) signal: (| ((ScriptID 601 3) signal:) $0010)) ; robin, robin
		((ScriptID 601 1) signal: (| ((ScriptID 601 1) signal:) $0010)) ; rgnBoat, rgnBoat
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTheIconBar disable: 5)
				(if (== global136 2)
					(Converse 2 @local17 8 0 11 3 self) ; "Was that an insult?"
				else
					(self cue:)
				)
			)
			(1
				(= temp1 (if (> gHowFast 0) 2 else 3))
				((ScriptID 601 2) setStep: temp1 temp1 setPri: -1) ; monk
				((ScriptID 601 3) ; robin
					view: (gEgo view:)
					signal: 16384
					loop: (gEgo loop:)
					cel: (gEgo cel:)
					x: (gEgo x:)
					y: (gEgo y:)
					init:
				)
				(= local2 1)
				(gEgo hide:)
				(= ticks 18)
			)
			(2
				(if (== global115 2)
					(Converse 1 @local7 11 0 self) ; "That's a fine ruby you wear upon your hand, Brother."
				else
					(self cue:)
				)
			)
			(3
				(gSFX play:)
				(switch gHowFast
					(0
						((ScriptID 601 2) setStep: 5 3) ; monk
					)
					(1
						((ScriptID 601 2) setStep: 3 2) ; monk
					)
					(else
						((ScriptID 601 2) setStep: 2 1) ; monk
					)
				)
				(if (== gCurRoomNum 590)
					((ScriptID 601 2) ; monk
						setCycle: Fwd
						setMotion: MoveTo 140 125 self
					)
				else
					((ScriptID 601 2) ; monk
						setCycle: Rev
						setMotion: MoveTo 180 137 self
					)
				)
			)
			(4
				(if (== gCurRoomNum 590)
					((ScriptID 601 2) setMotion: MoveTo 319 115 self) ; monk
				else
					((ScriptID 601 2) ; monk
						setCycle: Fwd
						setMotion: MoveTo 100 120 self
					)
				)
			)
			(5
				(if (== gCurRoomNum 590)
					(self cue:)
				else
					((ScriptID 601 2) setMotion: MoveTo 0 115 self) ; monk
				)
			)
			(6
				(HandsOn)
				(client setScript: 0)
				(gCurRoom newRoom: 610)
			)
		)
	)
)

(instance musicPlay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gRgnMusic2 number: 583 loop: 1 play: 75 self)
			)
			(1
				(if (== (gRgnMusic2 prevSignal:) -1)
					(= state -1)
					(self cue:)
				else
					(-- state)
					(= cycles 1)
				)
			)
		)
	)
)

(instance dieSound of Sound
	(properties
		flags 1
		number 588
	)
)

