;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 43)
(include sci.sh)
(use Main)
(use jet)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm43 0
)

(local
	local0
	local1
	local2
)

(instance rm43 of Rm
	(properties
		picture 40
		style 0
	)

	(method (init)
		(Load rsVIEW 0)
		(Load rsVIEW 82)
		(Load rsVIEW 26)
		(Load rsVIEW 25)
		(Load rsPIC 49)
		(super init:)
		(self setLocales: 154)
		(if (!= gPrevRoomNum 42)
			(gEgo posn: 91 145)
		)
		(gEgo
			view: 0
			setStep: 3 2
			setLoop: -1
			setPri: -1
			ignoreActors:
			illegalBits: 0
			init:
		)
		((= global112 (Act new:))
			view: 20
			loop: 1
			posn: 272 1060
			ignoreActors:
			illegalBits: 0
			setCycle: Walk
			init:
		)
		((= local1 (Prop new:))
			view: 82
			posn: 271 55
			loop: 8
			cel: 0
			setPri: 0
			ignoreActors:
			cycleSpeed: 2
			init:
			stopUpd:
		)
		((= local2 (Prop new:))
			view: 82
			posn: 51 191
			loop: 2
			cel: 0
			ignoreActors:
			setPri: 15
			addToPic:
		)
		((= local0 (Act new:))
			view: 25
			posn: 317 1085
			ignoreActors:
			illegalBits: 0
			setCycle: Walk
			init:
		)
		((View new:)
			view: 84
			loop: 0
			cel: 3
			ignoreActors:
			posn: 263 75
			setPri: 1
			addToPic:
		)
		((View new:)
			view: 84
			loop: 1
			cel: 4
			ignoreActors:
			posn: 268 60
			setPri: 2
			addToPic:
		)
		(proc154_2)
		(HandsOff)
		(self setScript: StageFive)
	)
)

(instance StageFive of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(proc154_1 43 0)
				(proc154_1 43 1)
				(gEgo setMotion: MoveTo 245 73 self)
			)
			(2
				(local1 setCycle: End self)
			)
			(3
				(global112 posn: 270 55 setMotion: MoveTo 257 67 self)
			)
			(4
				(local1 setCycle: Beg)
				(proc154_1 43 2)
				(= seconds 2)
			)
			(5
				(proc154_1 43 3)
				(= seconds 3)
			)
			(6
				(global112 setScript: keithActions)
				(= cycles 6)
			)
			(7
				(gEgo setMotion: MoveTo 229 59 self)
			)
			(8
				(gEgo
					view: 82
					posn: 212 72
					setLoop: 3
					setCel: 0
					cycleSpeed: 1
					setMotion: 0
					setPri: 3
					setCycle: End self
				)
			)
			(9
				(= seconds 6)
			)
			(10
				(proc154_1 43 4)
				(= seconds 3)
			)
			(11
				(proc154_1 43 5)
				(global112 cue:)
				(gEgo setCycle: Beg self)
			)
			(12
				(gEgo view: 0 loop: 0 setPri: -1 cycleSpeed: 0 posn: 235 65)
				(local0 posn: 317 85 setMotion: MoveTo 281 70 self)
			)
			(13
				(local0 setMotion: MoveTo 263 65 self)
			)
			(14
				(proc154_1 43 6)
				(= seconds 2)
			)
			(15
				(= seconds 2)
			)
			(16
				(gEgo setMotion: MoveTo 245 65 self setCycle: Walk)
			)
			(17
				(proc154_1 43 7)
				(proc154_1 43 8)
				(PutItem 9) ; wire_clippers
				(PutItem 33) ; bomb_instructions
				(proc154_1 43 9)
				(= seconds 1)
			)
			(18
				(gEgo setMotion: MoveTo 336 85 self setCycle: Walk)
				(global112 cue:)
			)
			(19
				(gEgo hide:)
				(global112 hide:)
				(gCurRoom drawPic: 49)
				(gCast eachElementDo: #dispose)
				(RedrawCast)
				(if (IsFlag 94)
					(self changeState: 21)
				else
					(self cue:)
				)
			)
			(20
				(Print 43 10) ; "You and Keith leave the plane, and search around Steelton. You talk to the Steelton police and they are unable to help you."
				(Print 43 11) ; "You and Keith find that Colby has been murdered, but there are no clues."
				(Print 43 12) ; "Two days later, the Steelton police find Marie's body in a gutter, with multiple gun shot wounds to the head."
				(EgoDead 43 13) ; "It really would have been a good idea to call the Steelton police before you arrived - just like the Captain suggested."
			)
			(21
				(Print 43 14) ; "You and Keith leave the airplane, and are met at the airport by Officer Jarvis Pitman."
				(Print 43 15) ; "He provides you with transportation to the Police Station."
				(gCurRoom newRoom: 100)
			)
		)
	)
)

(instance keithActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(global112 setMotion: MoveTo 224 57 self)
			)
			(2
				(global112
					view: 82
					setPri: 0
					posn: 200 68
					setLoop: 4
					setCel: 0
					cycleSpeed: 1
					setCycle: End
				)
			)
			(3
				(= seconds 1)
			)
			(4
				(global112 setCycle: Beg self)
			)
			(5
				(global112
					view: 20
					loop: 0
					setPri: -1
					cycleSpeed: 0
					posn: 223 57
				)
			)
			(6
				(= cycles 4)
			)
			(7
				(global112 setMotion: MoveTo 323 88 setCycle: Walk)
			)
		)
	)
)

