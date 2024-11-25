;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Jump)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm10 0
)

(local
	local0
	local1
	local2
	local3
)

(instance grind of Sound
	(properties
		number 43
		priority 1
		loop -1
	)
)

(instance rm10 of Rm
	(properties
		picture 10
		style 0
		horizon 10
		east 11
		west 9
	)

	(method (init &tmp [temp0 50])
		(self setLocales: 703)
		(User canInput: 1 canControl: 0)
		(Load rsVIEW 750)
		(Load rsVIEW 20)
		(Load rsSOUND 42)
		(Load rsSOUND 43)
		(cond
			((== global132 4)
				(Load rsVIEW 22)
				(Load rsVIEW 258)
				(Load rsVIEW 260)
			)
			((== global132 5)
				(Load rsVIEW 23)
				(Load rsVIEW 259)
				(Load rsVIEW 261)
			)
			(else
				(Load rsSCRIPT 991)
				(= local3 991)
				(Load rsVIEW 0)
				(Load rsVIEW 17)
				(Load rsVIEW 24)
			)
		)
		(if (and (!= gPrevRoomNum 9) (!= gPrevRoomNum 11))
			(= global132 2)
		)
		(cond
			((== global132 3)
				(HandsOn)
				(gEgo init: setScript: railJump)
			)
			((== global132 2)
				(gEgo
					view: 750
					posn: 2 145
					setStep: 3 1
					setLoop: 1
					setCel: 2
					setPri: 8
					init:
					setCycle: 0
				)
			)
			((or (== global132 5) (== global132 4))
				(gEgo setScript: grabScript)
			)
		)
		(if (or (> global124 0) (== global132 2))
			(pile1 init:)
			(fallPile init:)
			(shredder init:)
			(gLongSong number: 42 loop: -1 priority: 0 play:)
		else
			(shredder init: addToPic:)
		)
		(super init:)
		(self setScript: rmScript)
	)

	(method (dispose)
		(if (== global132 3)
			(DisposeScript 991)
		)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (or (event claimed:) (> global100 1))
			(return)
		)
		(switch (event type:)
			(evMOUSEBUTTON
				(if (and (not gHandsOff) (== (User controls:) 1))
					(gEgo setMotion: MoveTo (event x:) (gEgo y:))
					(event claimed: 1)
				)
			)
			(evSAID
				(cond
					((Said 'look>')
						(cond
							((Said '/conveyer,belt')
								(if (== global124 0)
									(Print 10 0) ; "The conveyer belt (now empty) transports small piles of debris to the shredder at the end."
								else
									(Print 10 1) ; "Small piles of space junk make their way down the conveyer belt to a shredder."
								)
							)
							((Said '/iron,debris,scrap,heap')
								(if (gCast contains: shredder)
									(Print 10 2) ; "The debris here is portioned onto the conveyer which enters from the left. The small piles roll along until they interface with the shredder where, true to its name, all is shredded."
								else
									(Print 10 3) ; "It's way down there and not very pretty."
								)
							)
							((Said '/cruncher,blade,device')
								(if (== global124 0)
									(Print 10 4) ; "The shredder is a mean-looking device. When running, it mercilessly breaks debris down to many smaller pieces of debris."
								else
									(Print 10 5) ; "The shredder is a mean-looking device. It mercilessly breaks debris down to many smaller pieces of debris."
								)
							)
							((Said '/conduit')
								(Print 10 6) ; "A number of pipes run through the area. They are of no significance."
							)
							((Said '[<at,around,in][/area,!*]')
								(cond
									((== global132 3)
										(Print 10 7) ; "You are standing on a narrow rail suspended high above the floor of the freighter. A conveyer belt below leads to a grinder. Be careful - it's a long way down."
									)
									((== global132 2)
										(Print 10 8) ; "This conveyer is no place for sight-seeing."
									)
									(else
										(Print 10 9) ; "You are riding below a narrow rail suspended high above the floor of the freighter. A conveyer belt below leads to a shredder."
									)
								)
							)
						)
					)
					(
						(Said
							'climb,descend,(climb[<up,down,on,onto])/conduit,support[<iron]'
						)
						(Print 10 10) ; "You can't climb that."
					)
					((Said 'jump,leap,(get,climb<on,onto)[<off]/conveyer,belt')
						(if (== global132 2)
							(Print 10 11) ; "Right! Get real."
						else
							(Print 10 12) ; "Don't push it! You made it up here safely. Quit while you're ahead."
						)
					)
					((Said '(get<up),stand[<up][/belt,conveyer]')
						(if (== global132 2)
							(if (!= (gEgo view:) 0)
								(HandsOn)
								(gEgo
									view: 0
									setLoop: -1
									loop: 0
									setCycle: Walk
									setMotion: 0
									setStep: 3 1
								)
							else
								(Print 10 13) ; "Check again."
							)
						else
							(event claimed: 0)
							(return)
						)
					)
					((Said 'get/banister')
						(if (== global132 2)
							(Print 10 14) ; "It's not within your reach."
						else
							(Print 10 15) ; "While it might be tactilly stimulating, your cause won't be furthered."
						)
					)
					((Said 'jump,leap,climb[<onto,on,to,up,down]/conduit')
						(Print 10 16) ; "That doesn't look like a safe place to jump to."
					)
					((and (== global132 2) (Said 'climb<up,onto/banister'))
						(Print 10 14) ; "It's not within your reach."
					)
					(
						(Said
							'jump,leap[<to,onto,on,up,down,off][/banister,banister]'
						)
						(if (== global132 2)
							(if (== (gEgo view:) 0)
								(gEgo setScript: railJump)
							else
								(Print 10 17) ; "You can't from this position."
							)
						else
							(event claimed: 0)
							(return)
						)
					)
				)
			)
			($0040 ; direction
				(if (or gHandsOff (and (!= global132 4) (!= global132 5)))
					(return)
				)
				(switch (event message:)
					(JOY_UP
						(gEgo setMotion: 0)
						(event claimed: 1)
						(return)
					)
					(JOY_DOWN
						(gEgo setMotion: 0)
						(event claimed: 1)
						(return)
					)
					(JOY_UPLEFT
						(gEgo setMotion: 0)
						(event claimed: 1)
						(return)
					)
					(JOY_UPRIGHT
						(gEgo setMotion: 0)
						(event claimed: 1)
						(return)
					)
					(JOY_DOWNRIGHT
						(gEgo setMotion: 0)
						(event claimed: 1)
						(return)
					)
					(JOY_DOWNLEFT
						(gEgo setMotion: 0)
						(event claimed: 1)
						(return)
					)
				)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (!= global132 2)
			(gLongSong stop:)
			(super newRoom: newRoomNumber)
		)
	)
)

(instance newPileScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fallPile setCycle: End self)
			)
			(1
				(pile1
					setCel: (Random 0 1)
					posn: -32 145
					show:
					setMotion: MoveTo 175 145 self
				)
			)
			(2
				(pile1 hide:)
				(self changeState: 0)
			)
		)
	)
)

(instance rmScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== global132 2)
					(gEgo setMotion: MoveTo 184 145 self)
				)
			)
			(1
				(HandsOff)
				(= global100 1)
				(gEgo
					setStep: 5 5
					setPri: 9
					setCycle: 0
					setMotion: JumpTo 199 162 self
				)
			)
			(2
				(gEgo hide:)
				(grind play:)
				((= local0 (Prop new:))
					view: 20
					setLoop: 1
					posn: 203 176
					setPri: 15
					init:
					setCycle: Fwd
					ignoreActors: 1
				)
				(= seconds 3)
			)
			(3
				(local0 dispose:)
				(grind fade:)
				(= cycles 5)
			)
			(4
				(= local2 (Print 10 18 #dispose)) ; "Shredded like an Iran-Contra document, your many independent parts flutter to the bottom of the hopper. This is of little importance to you, what with your being dead and all."
				(= seconds 6)
			)
			(5
				(cls)
				(EgoDead 901 0 3 4)
			)
		)
	)

	(method (doit)
		(if (and (== global132 2) (> (gEgo x:) 174))
			(User canControl: 0 canInput: 0)
		)
		(if
			(and
				(== global100 0)
				(== (rmScript state:) 0)
				(== (gEgo view:) 0)
				(== global132 2)
			)
			(gEgo posn: (+ (gEgo x:) 3) (gEgo y:))
			(if (> (gEgo x:) 182)
				(rmScript changeState: 1)
				(return)
			)
			(if (or (< (gEgo y:) 141) (> (gEgo y:) 147))
				(gEgo setScript: faller)
				(return)
			)
		)
		(super doit:)
	)
)

(instance railJump of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== global132 3)
					(if (== gPrevRoomNum 9)
						(gEgo x: 4)
					)
				else
					(HandsOff)
					(= global100 1)
					(gEgo
						setMotion: 0
						view: 24
						setLoop: 0
						cel: 0
						cycleSpeed: 1
						illegalBits: $8000
						setCycle: End self
					)
				)
			)
			(1
				(gEgo setLoop: 1 setCel: 0 setPri: 9 posn: (gEgo x:) 144)
				(= seconds 2)
			)
			(2
				(gEgo cycleSpeed: 2 setCycle: End self)
			)
			(3
				(gEgo setLoop: 2 setCel: 0 cycleSpeed: 3 setCycle: End self)
			)
			(4
				(gEgo
					setLoop: 3
					setCel: 0
					posn: (gEgo x:) 122
					setCycle: End self
				)
			)
			(5
				(gEgo
					view: 0
					posn: (+ (gEgo x:) 9) 123
					setLoop: -1
					loop: 1
					setCycle: Walk
					cycleSpeed: 0
					setDirection: 0
				)
				(HandsOn)
				(if (not global241)
					(= global241 1)
					(gGame changeScore: 10)
				)
				(= global132 3)
				(= global100 0)
			)
			(6
				(= global132 3)
			)
		)
	)

	(method (doit)
		(if (and (not global100) (!= (gEgo onControl: 0) 16384))
			(gEgo setScript: faller)
		)
		(super doit:)
	)
)

(instance faller of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global100 1)
				(gEgo
					view: 17
					setLoop: (gEgo loop:)
					cel: 0
					illegalBits: 0
					setCycle: End self
					setMotion: 0
					cycleSpeed: 2
				)
				(if (== global132 2)
					(gEgo setPri: (if (< (gEgo y:) 141) 4 else 10))
				else
					(gEgo setPri: (if (< (gEgo y:) 125) 8 else 9))
				)
			)
			(1
				(gEgo
					setStep: 1 15
					setMotion: MoveTo (gEgo x:) 244 self
					setCycle: 0
				)
				(gLongSong number: 45 loop: 1 priority: 15 play:)
			)
			(2
				(gEgo hide:)
				(= local2
					(if (== global132 2)
						(Print 10 19 #dispose) ; "You stepped off the conveyer. You're dead again. Way to go. Haven't we taught you anything?"
					else
						(Print 10 20 #dispose) ; "You stepped off the rail! You're dead again. Way to go. Haven't we taught you anything?"
					)
				)
				(= seconds 5)
			)
			(3
				(cls)
				(EgoDead 901 0 0 1)
			)
		)
	)

	(method (doit)
		(if (and (< (gEgo loop:) 11) (> (gEgo y:) 147))
			(gEgo setPri: 11)
		)
		(super doit:)
	)
)

(instance grabScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOn)
				(if (== gPrevRoomNum 9)
					(gEgo x: 4)
				)
				(if (== global132 5)
					(gEgo setStep: 2 setPri: 5)
				else
					(gEgo setPri: 14 setStep: 3)
				)
				(gEgo init: setCycle: Fwd)
				(if (< global148 4)
					(gEgo
						setMotion:
							MoveTo
							(if (== gPrevRoomNum 9) 400 else -50)
							(gEgo y:)
					)
					(User prevDir: (if (== gPrevRoomNum 9) 3 else 7))
				)
			)
		)
	)

	(method (handleEvent event &tmp [temp0 100])
		(super handleEvent: event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'look/grabber,control')
				(Print 10 21) ; "From your seat you see a handle, (presently being gripped by you) which controls motion, and a button marked CLAW."
			)
			(
				(or
					(Said 'lower/claw[<grabber]')
					(Said 'use,press,press/claw,button')
				)
				(Print 10 22) ; "Due to a series of pipelines directly below you, the claw is programmed not to work here."
			)
			((Said '/chair[<grabber,device]')
				(Print 10 23) ; "It looks like something that would cradle your posterior nicely."
			)
			((Said 'disembark[/grabber,device,!*]')
				(Print 10 24) ; "That would be unwise."
			)
		)
	)
)

(instance pile1 of Act
	(properties
		view 750
	)

	(method (init)
		(super init:)
		(self
			setCel: 1
			setLoop: 0
			ignoreActors: 1
			illegalBits: 0
			posn: -32 145
			setPri: 6
			setStep: 3 1
		)
	)
)

(instance fallPile of Prop
	(properties
		view 750
	)

	(method (init)
		(super init:)
		(self
			setLoop: 2
			cel: 0
			ignoreActors: 1
			posn: 187 159
			setPri: 10
			setScript: newPileScript
		)
	)
)

(instance shredder of Prop
	(properties
		view 20
	)

	(method (init)
		(super init:)
		(self ignoreActors: 1 posn: 204 169 setPri: 9 setCycle: Fwd)
	)
)

