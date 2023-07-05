;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 525)
(include sci.sh)
(use Main)
(use Interface)
(use Jump)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm525 0
)

(local
	[local0 120]
	[local120 66]
)

(instance rm525 of Rm
	(properties
		picture 525
		horizon 1
	)

	(method (init)
		(Load rsVIEW 525)
		(Load rsSOUND 3)
		(Load rsSOUND 526)
		(Load rsSOUND 527)
		(Load rsSOUND 4)
		(HandsOff)
		(cls)
		(= gOldGameSpeed (gGame setSpeed: 6))
		(super init:)
		(gEgo
			view: 525
			setLoop: (if (== gEgoState 2) 4 else 0)
			setCel: 0
			setStep: 0 7
			setMotion: 0
			setCycle: (if (== gEgoState 2) Fwd else 0)
			posn: 142 13
			cycleSpeed: 1
			illegalBits: 0
			ignoreActors:
			init:
			put: 15 -1 ; Pantyhose
		)
		(self setScript: RoomScript)
	)
)

(instance RoomScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= gEgoState 2)
					(= cycles 10)
				else
					(gMusic number: 4 loop: 1 play:)
					(gEgo setMotion: MoveTo 144 18 self)
					(= state 19)
				)
			)
			(1
				(Print 525 0) ; "You lower yourself (an experience not wholly unfamiliar to you) over the sheer side of the canyon wall, your full weight supported only by a pair of run-filled pantyhose!"
				(Print 525 1 #at -1 144) ; "(How you wish you'd changed to a clean pair this morning!)"
				(= cycles 20)
			)
			(2
				(gMusic stop: number: 3 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gMusic stop: number: 526 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(5
				(gEgo setLoop: 1 setCel: 0 setCycle: End self)
			)
			(6
				(gEgo setCycle: Beg self)
			)
			(7
				(gEgo setLoop: 0 setCel: 255 setCycle: Beg self)
			)
			(8
				(gMusic stop: number: 527 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(9
				(gEgo setLoop: 1 setCel: 0 setCycle: End self)
			)
			(10
				(gEgo setLoop: 2 setCel: 0 setCycle: End self)
			)
			(11
				(gEgo setCycle: Beg self)
			)
			(12
				(gEgo setLoop: 1 setCel: 255 setCycle: Beg self)
			)
			(13
				(gEgo setLoop: 0 setCel: 255 setCycle: Beg self)
			)
			(14
				(gMusic stop: number: 527 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(15
				(gEgo setLoop: 1 setCel: 0 setCycle: End self)
			)
			(16
				(gEgo setLoop: 2 setCel: 0 setCycle: End self)
			)
			(17
				(gEgo setLoop: 3 setCel: 0 setCycle: End self)
			)
			(18
				(gEgo setLoop: 4 setPri: -1 posn: 143 114 setCycle: Fwd)
				(aHose ignoreActors: init:)
				(Print 525 2 #at -1 10 #draw) ; "Oh, no! Your pantyhose broke!!"
				(gMusic stop: number: 4 loop: 1 play:)
				(gCurRoom newRoom: 530)
			)
			(20
				(gEgo setMotion: theJump self)
			)
			(21
				(Print 525 3) ; "Ow!"
				(gEgo hide:)
				(gGame setScript: (ScriptID 40)) ; DyingScript
				((ScriptID 40) ; DyingScript
					caller: 814
					register: (Format @local0 525 4) ; "Really, Patti! Everyone likes to make a good impression, but...%"
					next: (Format @local120 525 5) ; "Busted Flat%"
				)
			)
		)
	)
)

(instance aHose of Prop
	(properties
		y 13
		x 142
		view 525
		loop 5
	)
)

(instance theJump of Jump
	(properties)

	(method (init)
		(super init: gEgo RoomScript)
		(self yStep: 1 y: 183)
	)
)

