;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm11 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance rm11 of Rm
	(properties
		picture 11
		style 0
		horizon 10
		west 10
	)

	(method (init &tmp [temp0 50])
		(self setLocales: 703)
		(HandsOn)
		(Load rsVIEW 25)
		(Load rsSOUND 75)
		(Load rsSOUND 76)
		(Load rsSOUND 74)
		(if (== global132 3)
			(Load rsVIEW 17)
			(Load rsSOUND 45)
			(Load rsSCRIPT 991)
			(= local4 991)
		else
			(Load rsVIEW 22)
			(Load rsVIEW 258)
			(Load rsVIEW 260)
			(Load rsVIEW 23)
			(Load rsVIEW 259)
			(Load rsVIEW 261)
			(Load rsSOUND 52)
			(Load rsSOUND 53)
		)
		(gLongSong priority: 0 loop: -1)
		(super init:)
		(if (== global132 3)
			(gEgo setScript: railWalkScript)
		else
			(gEgo setScript: grabScript)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
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
							((Said '[<at,around,in][/area,!*]')
								(if (== global132 3)
									(Print 11 0) ; "You are standing on a narrow rail suspended high above the floor at the far end of the freighter. It's a long way down to the junk piles below."
								else
									(Print 11 1) ; "You are riding below a narrow rail suspended high above the floor at the far end of the freighter. It's a long way down to the junk piles below."
								)
							)
							((Said '/device,artifact')
								(Print 11 2) ; "It's an impressive piece of machinery. Unfortunately you have no idea what it is. Perhaps it is what emitted that tractor beam that brought you here. Or maybe it's some sort of giant trash masher. Or maybe the artist just thought it would look really cool hanging there. Yea, that's it! At any rate, I wouldn't waste any time trying to mess with it."
							)
						)
					)
					((Said 'climb,jump/device')
						(Print 11 3) ; "Sure, you're a devil-may-care kinda guy. This one, however, is beyond even your athletic aptitude."
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
		(super newRoom: newRoomNumber)
	)
)

(instance railWalkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setPri: 9 init:)
			)
			(1
				(gEgo
					view: 17
					setLoop: (gEgo loop:)
					cel: 0
					setPri:
						(if (and (not local3) (< (gEgo y:) 125)) 8 else 9)
					setMotion: 0
					illegalBits: 0
					setCycle: End self
				)
			)
			(2
				(gEgo
					setStep: 1 15
					setMotion: MoveTo (gEgo x:) 244 self
					setCycle: 0
				)
				(gLongSong number: 45 loop: 1 play:)
			)
			(3
				(gEgo hide:)
				(= local5
					(if local3
						(Print 11 4 #dispose) ; "You step on a part of the track which is extremely narrow and greasy. It obviously wasn't designed for human foot travel. It's a quick drop to the unforgiving surface below."
					else
						(Print 11 5 #dispose) ; "You stepped off the rail! You're dead again. Way to go. Haven't we taught you anything?"
					)
				)
				(= seconds 5)
			)
			(4
				(cls)
				(EgoDead 901 0 0 1)
			)
		)
	)

	(method (doit)
		(if (and (not global100) (!= (gEgo onControl: 0) 16384))
			(self changeState: 1)
			(HandsOff)
			(= global100 1)
			(if (> (gEgo x:) 240)
				(= local3 1)
			)
		)
		(super doit:)
	)
)

(instance grabScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== global132 5)
					(gEgo
						view: (if (== global135 3) 261 else 23)
						setPri: -1
						setStep: 2
						y: 88
					)
				else
					(gEgo
						view: (if (== global135 3) 260 else 22)
						setPri: 9
						setStep: 3
						y: 116
					)
				)
				(gEgo init: setCycle: Fwd)
				(if (< global148 4)
					(gEgo setMotion: MoveTo 400 (gEgo y:))
					(User prevDir: 3)
				)
				(if (> global148 3)
					(gEgo
						view: (if (== global132 4) 22 else 23)
						loop: 2
						posn: global201 global202
					)
					(HandsOff)
					(gCurRoom setScript: clawScript)
				)
			)
			(1
				(User canControl: 0 canInput: 1)
				(HandsOff)
				(gEgo
					view: 25
					setLoop: (if (!= global135 3) 2 else 5)
					illegalBits: 0
					x: 251
					y: 114
					setPri: -1
					setStep: 1 2
					setMotion: MoveTo 251 108 self
				)
			)
			(2
				(gEgo
					setLoop: (if (!= global135 3) 0 else 3)
					setStep: 6 2
					setMotion: MoveTo 179 84 self
				)
			)
			(3
				(gEgo
					view: (if (== global135 3) 261 else 23)
					setLoop: -1
					loop: 1
					setStep: 2 1
					posn: 103 88
					illegalBits: $8000
					setMotion: MoveTo -50 88
				)
				(HandsOn)
				(User prevDir: 7)
				(= global100 0)
				(= global132 5)
			)
			(4
				(User canControl: 0 canInput: 1)
				(HandsOff)
				(gEgo
					view: 25
					setLoop: (if (!= global135 3) 1 else 4)
					setStep: 6 2
					posn: 179 84
					setMotion: MoveTo 251 108 self
				)
			)
			(5
				(gEgo
					setLoop: (if (!= global135 3) 2 else 5)
					setStep: 1 2
					setMotion: MoveTo 251 114 self
				)
			)
			(6
				(gEgo
					view: (if (== global135 3) 260 else 22)
					setLoop: -1
					loop: 0
					setPri: 9
					setStep: 3 1
					posn: 248 116
					setMotion: MoveTo -1 116
					illegalBits: $8000
				)
				(HandsOn)
				(User prevDir: 7)
				(= global132 4)
				(= global100 0)
			)
		)
	)

	(method (doit)
		(if (not gHandsOff)
			(cond
				((not (gEgo mover:))
					(cond
						((and (== global132 4) (!= (gEgo loop:) 0))
							(gEgo loop: 0)
						)
						((and (== global132 5) (!= (gEgo loop:) 1))
							(gEgo loop: 1)
						)
					)
					(if (== (gLongSong state:) 3)
						(gLongSong stop:)
					)
				)
				((== global132 4)
					(cond
						(
							(and
								(== (gEgo loop:) 0)
								(or
									(!= (gLongSong number:) 52)
									(!= (gLongSong state:) 3)
								)
							)
							(gLongSong stop: number: 52 play:)
						)
						(
							(and
								(== (gEgo loop:) 1)
								(or
									(!= (gLongSong number:) 53)
									(!= (gLongSong state:) 3)
								)
							)
							(gLongSong stop: number: 53 play:)
						)
					)
				)
				((== global132 5)
					(cond
						(
							(and
								(== (gEgo loop:) 1)
								(or
									(!= (gLongSong number:) 52)
									(!= (gLongSong state:) 3)
								)
							)
							(gLongSong stop: number: 52 play:)
						)
						(
							(and
								(== (gEgo loop:) 0)
								(or
									(!= (gLongSong number:) 53)
									(!= (gLongSong state:) 3)
								)
							)
							(gLongSong stop: number: 53 play:)
						)
					)
				)
			)
		)
		(if (not global100)
			(if (and (== global132 4) (> (gEgo x:) 248))
				(= global100 1)
				(HandsOff)
				(self changeState: 1)
			)
			(if (and (== global132 5) (> (gEgo x:) 103))
				(= global100 1)
				(HandsOff)
				(self changeState: 4)
			)
		)
		(super doit:)
	)

	(method (handleEvent event &tmp [temp0 100])
		(super handleEvent: event)
		(if (or (!= (event type:) evSAID) global100 (event claimed:))
			(return)
		)
		(cond
			((Said 'look/grabber')
				(Print 11 6) ; "From your seat you see a handle, (presently being gripped by you) which controls Motion, and a button marked CLAW."
			)
			(
				(or
					(Said 'lower/claw[<grabber]')
					(Said 'use,press,press/claw,button')
				)
				(cond
					((gEgo mover:)
						(Print 11 7) ; "You must stop the grabber before claw functions can be executed."
					)
					((and (!= global148 2) (!= global148 3))
						(= global159 1)
						(HandsOff)
						(gEgo setMotion: 0)
						(clunk number: 74 loop: 1 play:)
						(gEgo setScript: clawScript)
					)
					(else
						(Print 11 8) ; "That's already being done."
					)
				)
			)
			((Said '/chair[<grabber,device]')
				(Print 11 9) ; "It looks like something that would cradle your posterior nicely."
			)
			((Said 'disembark[/grabber,device,!*]')
				(Print 11 10) ; "That would be unwise."
			)
		)
	)
)

(instance clawScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local1 (gEgo x:))
				(= local2
					(if (== global132 4)
						(+ (gEgo y:) 42)
					else
						(+ (gEgo y:) 22)
					)
				)
				(self changeState: 1)
			)
			(1
				(gEgo view: (if (== global132 4) 22 else 23) loop: 2)
				(if (not (gCast contains: local0))
					((= local0 (Act new:))
						name: {Claw}
						x: local1
						y: (if (> global148 3) 191 else local2)
						init:
					)
				else
					(= local1 (gEgo x:))
					(= local2
						(if (== global132 4)
							(+ (gEgo y:) 42)
						else
							(+ (gEgo y:) 22)
						)
					)
				)
				(local0
					view: (if (== global132 4) 258 else 259)
					setLoop: (if (== global135 3) 2 else 0)
					setStep: 1 (if (== global132 4) 2 else 1)
					setPri: (gEgo priority:)
					ignoreActors: 1
					illegalBits: 0
					setCycle: Fwd
					setMotion:
						MoveTo
						local1
						(if (> global148 3) local2 else 191)
						self
				)
			)
			(2
				(if (> global148 3)
					(gEgo
						view:
							(if (== global135 3)
								(+ (gEgo view:) 238)
							else
								(gEgo view:)
							)
						loop: 0
					)
					(local0 dispose:)
					(HandsOn)
					(= global159 0)
					(clunk number: (if (== global148 4) 75 else 76) play:)
					(if (== global148 4)
						(= global148 0)
					else
						(= global148 1)
					)
					(clawScript dispose:)
				else
					(if
						(or
							(and (== global132 4) (< local1 152))
							(and (== global132 5) (< local1 50))
						)
						(= global147 0)
					else
						(= global147 1)
					)
					(= global201 (gEgo x:))
					(= global202 (gEgo y:))
					(if (== global132 4)
						(gCurRoom newRoom: 8)
					else
						(gCurRoom newRoom: 7)
					)
				)
			)
		)
	)
)

(instance clunk of Sound
	(properties
		number 75
		priority 5
	)
)

