;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 55)
(include sci.sh)
(use Main)
(use Interface)
(use Jump)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room55 0
)

(synonyms
	(path ledge)
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
)

(instance Room55 of Rm
	(properties
		picture 55
		style 16
		east 56
	)

	(method (init)
		(Load rsSCRIPT 991)
		(Load rsVIEW 4)
		(Load rsVIEW 44)
		(Load rsVIEW 41)
		(Load rsVIEW 518)
		(Load rsVIEW 18)
		(self setRegions: 600) ; MineReg
		(super init:)
		(= local0 0)
		(= gIndoors 1)
		(if (or (== gPrevRoomNum 28) (== gPrevRoomNum 0))
			(gEgo
				posn: 100 83
				view: 4
				loop: 0
				xStep: 4
				yStep: 1
				ignoreActors: 0
				illegalBits: -32768
				init:
			)
		else
			(gEgo
				posn: 290 150
				view: 4
				xStep: 4
				yStep: 1
				ignoreActors: 0
				illegalBits: -32768
				init:
			)
		)
		((= local10 (Prop new:))
			view: 518
			posn: 60 68
			setPri: 5
			cel: 2
			cycleSpeed: 1
			setLoop: 3
			init:
			stopUpd:
		)
		((= local11 (Prop new:))
			view: 518
			posn: 95 121
			setPri: 10
			cel: 1
			setLoop: 3
			init:
			stopUpd:
		)
		((= local12 (Prop new:))
			view: 518
			posn: 220 90
			cycleSpeed: 1
			setLoop: 3
			init:
			stopUpd:
		)
		((= local13 (Prop new:))
			view: 518
			posn: 245 49
			cel: 3
			setLoop: 3
			init:
			stopUpd:
		)
		(local10 setScript: sparkle)
		(if (== global102 1)
			(Load rsVIEW 284)
			(Load rsVIEW 285)
			(Load rsVIEW 282)
			((= local1 (Act new:))
				view: 282
				illegalBits: 0
				posn: 219 154
				setLoop: 0
				init:
				setScript: Watch
			)
			((= local3 (Act new:))
				view: 284
				illegalBits: 0
				posn: 188 129
				setCycle: Fwd
				init:
			)
			((= local4 (Act new:))
				view: 285
				illegalBits: 0
				posn: 200 75
				setLoop: 1
				setCycle: Fwd
				init:
			)
		else
			(Load rsVIEW 289)
			(Load rsVIEW 286)
			(Load rsVIEW 287)
			(gEgo illegalBits: -32764)
			((View new:) view: 287 loop: 2 cel: 0 posn: 213 130 addToPic:)
			((View new:) view: 286 loop: 5 cel: 0 posn: 233 130 addToPic:)
			((= local6 (Act new:))
				view: 287
				illegalBits: 0
				posn: 213 114
				setPri: 11
				setLoop: 0
				setCycle: Fwd
				cycleSpeed: 1
				ignoreActors: 1
				init:
			)
			((= local8 (Act new:))
				view: 286
				illegalBits: 0
				posn: 233 114
				setPri: 11
				setLoop: 3
				setCycle: Fwd
				cycleSpeed: 2
				ignoreActors: 1
				init:
			)
			((= local1 (Act new:))
				view: 289
				illegalBits: 0
				posn: 60 108
				setCycle: Walk
				init:
				ignoreActors: 1
			)
			(local1 setScript: SendOut)
		)
	)

	(method (doit)
		(if (== (gEgo script:) 0)
			(gEgo setPri: -1)
		)
		(if
			(and
				(& (gEgo onControl: 0) $0040)
				(!= (gEgo script:) Tripped)
			)
			(gCurRoom newRoom: 28)
		)
		(if
			(and
				(& (gEgo onControl: 1) $1000)
				(== local0 0)
				(== (gEgo script:) 0)
			)
			(gEgo setScript: WalkPath)
		)
		(if
			(and
				(or
					(& (gEgo onControl:) $0002)
					(& (gEgo onControl:) $1000)
				)
				(== local0 0)
				(== (gEgo script:) 0)
			)
			(gEgo setScript: WalkPath)
		)
		(if
			(and
				(& (gEgo onControl: 1) $0004)
				(== global102 1)
				(!= (gEgo script:) Tripped)
			)
			(gEgo setScript: Tripped)
		)
		(if (and (& (gEgo onControl:) $0010) (== (gEgo script:) 0))
			(gEgo setPri: 12)
			(if (or (>= (gEgo heading:) 180) (== (gEgo heading:) 0))
				(= local0 0)
				(gEgo illegalBits: -32768)
			else
				(= local0 1)
				(gEgo illegalBits: -28672)
			)
			(if (> (gEgo x:) 121)
				(gEgo setPri: -1)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 991)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 28)
			((ScriptID 600) keep: 0) ; MineReg
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (== (event type:) evSAID) (Said 'look>'))
				(cond
					((Said '/door')
						(Print 55 0) ; "It is a ramshackle wooden door."
					)
					((Said '<out[/(mine[<diamond]),(door[<mine])]')
						(Print 55 1) ; "You look out the open door of the diamond mine, but notice nothing."
					)
					((Said '[<around][/!*]')
						(Print 55 2) ; "Diamonds glitter and sparkle from the earthen walls of the Seven Dwarfs' diamond mine. Within it, you see the little men busily at work."
					)
					(
						(or
							(Said '<around')
							(Said '[<around]/room,mine<[diamond]')
						)
						(Print 55 2) ; "Diamonds glitter and sparkle from the earthen walls of the Seven Dwarfs' diamond mine. Within it, you see the little men busily at work."
					)
				)
			)
		)
	)
)

(instance SendOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(HandsOff)
				(Print 55 3) ; "You have encountered a group of small men working in this diamond mine. They're not too friendly, though, as one of them forcefully tells you to leave the premises!"
				(local1 setPri: -1 setMotion: MoveTo 92 89)
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 101 81 self
				)
			)
			(2
				(gEgo setMotion: MoveTo 74 81 self)
			)
			(3
				(HandsOn)
				(gEgo illegalBits: -32768)
				(gCurRoom newRoom: 28)
			)
		)
	)
)

(instance Tripped of Script
	(properties)

	(method (changeState newState &tmp [temp0 40])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					setPri: (if (> (gEgo y:) 115) 11 else 10)
					ignoreActors: 1
					view: 44
					setStep: 10 20
					setLoop: 2
					setCycle: Fwd
					setMotion:
						JumpTo
						(if (< (gEgo x:) 100)
							100
						else
							(+ (gEgo x:) 20)
						)
						149
						self
				)
			)
			(1
				(gEgo view: 18 setLoop: 1 cel: 0 setCycle: Fwd)
				(= seconds 5)
			)
			(2
				(gEgo view: 41 setLoop: 0 cel: 0 setCycle: End self)
			)
			(3
				(= local0 1)
				(gEgo
					view: 4
					setStep: 4 1
					setCycle: Walk
					setLoop: -1
					setPri: -1
					illegalBits: -28672
					ignoreActors: -1
				)
				(= state 0)
				(client setScript: 0)
				(HandsOn)
			)
		)
	)
)

(instance WalkPath of Script
	(properties)

	(method (doit)
		(cond
			(
				(and
					(or
						(& (gEgo onControl:) $0002)
						(& (gEgo onControl:) $1000)
					)
					(== local0 0)
				)
				(gEgo setPri: 13)
				(if (& (gEgo onControl: 0) $0008)
					(gEgo setScript: Tripped)
				)
			)
			((not (& (gEgo onControl: 1) $0010))
				(gEgo setPri: -1)
				(if (== (gEgo script:) WalkPath)
					(gEgo setScript: 0)
				)
			)
		)
	)
)

(instance Watch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local1 setCycle: End self)
			)
			(1
				(= seconds 5)
			)
			(2
				(local1 setCel: 0)
				(= seconds 10)
				(= state -1)
			)
		)
	)
)

(instance sparkle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (Random 1 4)
					(1
						(local10 setCycle: End self)
					)
					(2
						(local11 setCycle: End self)
					)
					(3
						(local12 setCycle: End self)
					)
					(4
						(local13 setCycle: End self)
					)
				)
			)
			(1
				(local10 stopUpd:)
				(local11 stopUpd:)
				(local12 stopUpd:)
				(local13 stopUpd:)
				(= state -1)
				(self cue:)
			)
		)
	)
)

