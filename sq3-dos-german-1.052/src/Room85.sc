;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 85)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room85 0
)

(local
	local0
	local1
	local2
)

(instance guard of Prop
	(properties)
)

(instance guard2 of Prop
	(properties)
)

(instance force of View
	(properties)
)

(instance blast of Act
	(properties)
)

(instance Room85 of Rm
	(properties
		picture 85
	)

	(method (init)
		(= north (= west (= south 80)))
		(Load rsVIEW 123)
		(Load rsVIEW 593)
		(Load rsVIEW 134)
		(Load rsVIEW 92)
		(super init:)
		(NormalEgo)
		(guard view: 124 loop: 4 cel: 0 posn: 132 153 init:)
		(guard2 view: 124 loop: 4 cel: 0 posn: 221 122 init:)
		(switch gPrevRoomNum
			(81
				(HandsOff)
				(gEgo view: 0 posn: 324 166 init:)
				(gCurRoom setScript: Actions)
			)
			(86
				(HandsOff)
				(gEgo view: 0 posn: 123 169 setPri: 4 init:)
				(gCurRoom setScript: Actions)
				(Actions changeState: 2)
			)
		)
		(if (gEgo has: 12) ; Coveralls
			(gEgo view: 113)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (>= (gEgo y:) 189) (<= (gEgo x:) 188))
			(++ local1)
		else
			(super newRoom: newRoomNumber)
		)
	)

	(method (doit)
		(super doit:)
		(if (!= gCurRoomNum gNewRoomNum)
			(return)
		)
		(if (== (Actions state:) 1)
			(if
				(and
					(not gHandsOff)
					(or
						(> (gEgo x:) 313)
						(and (> (gEgo y:) 186) (> (gEgo x:) 174))
					)
					(== (gEgo script:) 0)
				)
				(gEgo setScript: turnVisible)
			)
			(= local0 (gEgo onControl: 0))
			(-- global121)
			(if (and (== global120 1) (not gHandsOff) (<= global121 0))
				(gEgo setScript: turnVisible)
				(= global120 2)
			)
			(cond
				((& local0 $0004)
					(Actions changeState: 5)
				)
				((& local0 $1000)
					(Actions changeState: 6)
				)
				((& local0 $2000)
					(Actions changeState: 7)
				)
				((& local0 $0040)
					(gCurRoom setScript: walkDown)
				)
			)
			(if (== global105 0)
				(Actions changeState: 8)
			)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look,look>')
					(cond
						((Said '[<around,at,in][/area]')
							(Print 85 0) ; "You now stand invisible before the entrance to ScumSoft. Two mean looking guards stand watch. They've no doubt been instructed to shoot anything that moves so don't waste any more time gawking."
						)
						((Said '/guard')
							(Print 85 1) ; "The guards are armed and alert."
						)
						((Said '/beam')
							(Print 85 2) ; "There are several force field generators creating an impenetrable barrier guarding the area behind the ScumSoft entrance. The force fields themselves are invisible until activated by an intruder."
						)
						(else
							(Print 85 3) ; "Just use your eyes, ok?"
							(event claimed: 1)
						)
					)
				)
				((or (Said 'turn<off/belt') (Said 'deactivate/belt'))
					(Print 85 4) ; "That would be very dangerous."
				)
				(
					(or
						(Said 'kill,hit,talk,talk,kiss,kiss/guard,man,flunky')
						(Said 'get/gun')
					)
					(Print 85 5) ; "I wouldn't mess with these guys if I were you."
				)
				((Said 'turn<off/beam')
					(Print 85 6) ; "You have no way of doing that."
				)
			)
		)
	)
)

(instance Actions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== global120 1)
					(gEgo view: 123)
				)
				(gEgo setMotion: MoveTo 303 166 self)
			)
			(1
				(HandsOn)
				(gCurRoom east: 80)
			)
			(2
				(gEgo
					setLoop: 0
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 159 129 self
				)
			)
			(3
				(gEgo setPri: -1 setMotion: MoveTo 204 150 self)
			)
			(4
				(NormalEgo)
				(self changeState: 1)
			)
			(5
				(HandsOff)
				(force
					view: 124
					setLoop: 1
					setCel: 0
					setPri: 1
					ignoreActors:
					posn: 253 116
					init:
					addToPic:
				)
				(gEgo view: 124 setLoop: 3 setCycle: Fwd)
				(= state 13)
				(= seconds 7)
			)
			(6
				(HandsOff)
				(force
					view: 124
					setLoop: 1
					setCel: 1
					setPri: 12
					ignoreActors:
					posn: 75 174
					init:
					addToPic:
				)
				(gEgo view: 124 setLoop: 3 setCycle: Fwd)
				(= state 13)
				(= seconds 7)
			)
			(7
				(HandsOff)
				(force
					view: 124
					setLoop: 1
					setCel: 2
					setPri: 14
					ignoreActors:
					posn: 99 187
					init:
					addToPic:
				)
				(gEgo view: 124 setLoop: 2 setCycle: Fwd)
				(= state 13)
				(= seconds 7)
			)
			(8
				(= seconds 1)
				(gEgo view: (if (gEgo has: 12) 113 else 0) loop: 2) ; Coveralls
			)
			(9
				(HandsOff)
				(RedrawCast)
				(gLongSong number: 44 loop: 1 priority: 2 play:)
				(cond
					((gEgo inRect: 24 41 125 184)
						(guard setLoop: 5 cel: 0 setCycle: End self)
						(= local2 guard)
					)
					((> (gEgo y:) 142)
						(guard setCycle: End self)
						(= local2 guard)
					)
					((gEgo inRect: 107 118 209 147)
						(guard2 setLoop: 5 cel: 0 setCycle: End self)
						(= local2 guard2)
					)
					(else
						(guard2 setCycle: End self)
						(= local2 guard2)
					)
				)
			)
			(10
				(HandsOff)
				(blast
					view: 593
					setLoop: (if (== (local2 loop:) 4) 6 else 7)
					cel: 0
					setCycle: End
					setStep: 30 10
					ignoreActors:
					illegalBits: 0
					setPri: (gEgo priority:)
					x:
						(if (== (local2 loop:) 4)
							(+ (local2 x:) 30)
						else
							(- (local2 x:) 30)
						)
					y: (- (local2 y:) 18)
					init:
				)
				(RedrawCast)
				(blast setMotion: MoveTo (gEgo x:) (- (gEgo y:) 18) self)
			)
			(11
				(blast dispose:)
				(gEgo
					setLoop: (if (gEgo has: 12) 5 else 2) ; Coveralls
					view: 92
					cel: 0
					setCycle: Fwd
				)
				(= seconds 7)
			)
			(12
				(EgoDead 901 0 7 99)
			)
			(14
				(Print 85 7) ; "Oh. No! You've stepped into an electrical force field and as a result you are fried to a crackly crunch. YOU'RE TOAST DUDE!"
				(self changeState: 16)
			)
			(16
				(EgoDead 901 0 11 18)
			)
		)
	)
)

(instance turnVisible of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0 view: 134 setLoop: 4 setCycle: Fwd)
				(RedrawCast)
				(= seconds 2)
			)
			(1
				(Print 85 8) ; "What's happening??!!"
				(gEgo setLoop: 3)
				(= seconds 2)
			)
			(2
				(Print 85 9) ; "Uh Oh! The terminator's invisibility belt is losing power!"
				(gEgo setLoop: 1)
				(= seconds 3)
			)
			(3
				(gEgo setCycle: 0 setCel: 0)
				(= global105 0)
			)
		)
	)
)

(instance walkDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setPri: 4
					setLoop: 1
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 123 169 self
				)
			)
			(1
				(gCurRoom newRoom: 86)
			)
		)
	)
)

