;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Jump)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm012 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance rm012 of Rm
	(properties
		picture 12
		style 0
		horizon 10
		east 9
	)

	(method (init &tmp [temp0 50])
		(self setLocales: 703)
		(gUser canInput: 1 canControl: 1)
		(if (== global132 4)
			(Load rsVIEW 22)
			(Load rsVIEW 258)
			(Load rsVIEW 260)
		)
		(if (== global132 5)
			(Load rsVIEW 23)
			(Load rsVIEW 259)
			(Load rsVIEW 261)
		)
		(if (== global132 3)
			(Load rsVIEW 17)
			(Load rsSOUND 45)
			(Load rsSCRIPT 991)
			(= local3 991)
		else
			(Load rsSOUND 74)
			(Load rsSOUND 75)
			(Load rsSOUND 76)
		)
		(if (or (== global132 4) (== global132 5))
			(Load rsSOUND 52)
			(Load rsSOUND 53)
		)
		(gEgo setStep: -1 1)
		(gLongSong priority: 0 loop: -1)
		(super init:)
		(self setScript: (if (== global132 3) railWalkScript else grabScript))
	)

	(method (dispose)
		(if (== global132 3)
			(DisposeScript 991)
		)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return)
		)
		(cond
			((& (event type:) $0040) ; direction
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
			((== (event type:) evMOUSEBUTTON)
				(if (and (not gHandsOff) (== (gUser controls:) 1))
					(gEgo setMotion: MoveTo (event x:) (gEgo y:))
					(event claimed: 1)
				)
			)
			((and (== (event type:) evSAID) (Said 'look,look>'))
				(cond
					((Said '/door,corridor,partition,pit[<west]')
						(Print 12 0) ; "There is some light coming from passages through the west wall."
					)
					((Said '[<at,around,in][/area]')
						(if (== global132 3)
							(Print 12 1) ; "You are standing on a narrow rail suspended high above the floor of the freighter. It's a long way down to the junk piles below. There are two passages to the west."
						else
							(Print 12 2) ; "You are riding below a narrow rail suspended high above the floor of the freighter. It's a long way down to the junk piles below."
						)
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
				(gEgo init:)
				(if (== gPrevRoomNum 13)
					(gEgo posn: 10 123)
				)
			)
			(1
				(gEgo
					view: 17
					setLoop: (gEgo loop:)
					cel: 0
					setMotion: 0
					illegalBits: 0
					setPri: (if (< (gEgo y:) 125) 8 else 9)
					setCycle: End self
				)
			)
			(2
				(gEgo setCycle: 0 setMotion: JumpTo (gEgo x:) 244 self)
				(gLongSong number: 45 loop: 1 play:)
			)
			(3
				(gEgo hide:)
				(= local4 (Print 12 3 #dispose)) ; "You stepped off the rail! You're dead again. Way to go. Haven't we taught you anything?"
				(= seconds 5)
			)
			(4
				(cls)
				(EgoDead 901 0 0 1) ; "It wouldn't be so bad, except for the sudden stop at the end.__Next time, don't get so close to the edge."
			)
		)
	)

	(method (doit)
		(if (and (not global100) (!= (gEgo onControl: 1) 16384))
			(self changeState: 1)
			(gUser canControl: 0 canInput: 0)
			(= global100 1)
		)
		(if (< (gEgo x:) 4)
			(gEgo setMotion: 0)
			(gCurRoom newRoom: 13)
		)
		(super doit:)
	)
)

(instance grabScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((== global132 5)
						(gEgo
							view: (if (== global135 3) 261 else 23)
							setPri: -1
							setStep: 2
							y: 88
						)
					)
					((== global132 4)
						(gEgo
							view: (if (== global135 3) 260 else 22)
							setPri: 9
							setStep: 3
							y: 116
						)
					)
				)
				(gEgo init: setCycle: Fwd)
				(if (< global148 4)
					(gEgo
						setMotion:
							MoveTo
							(if (== gPrevRoomNum 13) 400 else -40)
							(gEgo y:)
					)
				)
				(if (== gPrevRoomNum 13)
					(gUser prevDir: 3)
					(if (== global132 5)
						(gEgo x: (if (== global132 5) 98 else 4))
					else
						(gEgo x: 4)
					)
				)
				(if (== gPrevRoomNum 9)
					(gUser prevDir: 7)
				)
				(if (> global148 3)
					(gEgo
						view: (if (== global132 4) 22 else 23)
						loop: 2
						posn: global201 global202
					)
					(gUser canControl: 0)
					(gEgo setScript: clawScript)
				)
			)
		)
	)

	(method (doit)
		(if gHandsOff
			(return)
		)
		(cond
			((and (< global148 2) (not (gEgo mover:)))
				(cond
					((and (== global132 4) (!= (gEgo loop:) 0))
						(gEgo loop: 0)
					)
					((and (== global132 5) (!= (gEgo loop:) 1))
						(gEgo loop: 1)
					)
				)
				(if (gLongSong handle:)
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
								(not (gLongSong handle:))
							)
						)
						(gLongSong stop: number: 52 play:)
					)
					(
						(and
							(== (gEgo loop:) 1)
							(or
								(!= (gLongSong number:) 53)
								(not (gLongSong handle:))
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
								(not (gLongSong handle:))
							)
						)
						(gLongSong stop: number: 52 play:)
					)
					(
						(and
							(== (gEgo loop:) 0)
							(or
								(!= (gLongSong number:) 53)
								(not (gLongSong handle:))
							)
						)
						(gLongSong stop: number: 53 play:)
					)
				)
			)
		)
		(if (and (== global132 5) (< (gEgo x:) 95))
			(gEgo setMotion: 0)
			(gCurRoom newRoom: 13)
		)
		(if (and (== global132 4) (< (gEgo x:) 4))
			(gEgo setMotion: 0)
			(gCurRoom newRoom: 13)
		)
		(super doit:)
	)

	(method (handleEvent event &tmp [temp0 100])
		(super handleEvent: event)
		(if (or (!= (event type:) evSAID) global100 (event claimed:))
			(return)
		)
		(cond
			((Said 'look,look/grabber')
				(Print 12 4) ; "From your seat you see a handle, (presently being gripped by you) which controls Motion, and a button marked CLAW."
			)
			(
				(or
					(Said 'lower,lower/claw,claw[<grabber]')
					(Said 'use,press,press/claw,claw,button,button')
				)
				(cond
					((gEgo mover:)
						(Print 12 5) ; "You must stop the grabber before claw functions can be executed."
					)
					(
						(or
							(< (gEgo x:) 30)
							(and (== global132 5) (< (gEgo x:) 124))
						)
						(Print 12 6) ; "The claw can't operate here."
					)
					((and (!= global148 2) (!= global148 3))
						(= global159 1)
						(HandsOff)
						(gEgo setMotion: 0)
						(clunk number: 74 loop: 1 play:)
						(gEgo setScript: clawScript)
					)
					(else
						(Print 12 7) ; "That's already being done."
					)
				)
			)
			((Said '/chair[<grabber,machine]')
				(Print 12 8) ; "It looks like something that would cradle your posterior nicely."
			)
			((Said 'disembark,disembark[/grabber,machine,!*]')
				(Print 12 9) ; "That would be unwise."
			)
		)
	)
)

(instance clawScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gUser canControl: 0)
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
					((= local0 (Actor new:))
						name: {Claw }
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
					(if (> local1 212)
						(= global147 1)
					else
						(= global147 0)
					)
					(= global201 (gEgo x:))
					(= global202 (gEgo y:))
					(if (== global132 4)
						(gCurRoom newRoom: 3)
					else
						(gCurRoom newRoom: 2)
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

