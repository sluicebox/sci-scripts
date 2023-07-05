;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 600)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use System)

(public
	rm600 0
)

(instance rm600 of Rm
	(properties
		picture 99
	)

	(method (init)
		(HandsOff)
		(SetFlag 3)
		(SetFlag 5)
		(SetFlag 4)
		(gMusic number: 600 loop: -1 play:)
		(super init:)
		(= gOldGameSpeed (gGame setSpeed: 3))
		(gEgo view: 601 setPri: 15 setLoop: 1 setStep: 22 12 init:)
		(self setScript: RoomScript)
	)
)

(instance RoomScript of Script
	(properties)

	(method (changeState newState)
		(gEgo
			posn: (Random 10 310) -40
			setMotion: MoveTo (Random 10 310) 224 RoomScript
		)
		(switch (= state newState)
			(2
				(Printf 600 0 global304 global305) ; ""%s I'm falling!!"%"
			)
			(4
				(Print 600 1) ; "Larry! What happened?"
			)
			(5
				(gEgo setLoop: 0)
			)
			(8
				(Print 600 2) ; "I don't know, Patti, but it feels like we just fell out of the game!!"
			)
			(9
				(Print 600 3) ; "The question is: where will we end up?"
			)
			(10
				(gGame setSpeed: gOldGameSpeed)
				(gMusic fade:)
				(gCurRoom newRoom: 610)
			)
		)
	)
)

