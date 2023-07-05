;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 215)
(include sci.sh)
(use Main)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	showerReg 0
)

(local
	local0
)

(instance showerReg of Rm
	(properties
		picture 71
		style 8
	)

	(method (init)
		(super init:)
		(HandsOff)
		(Load rsSOUND 8)
		(myMusic number: 7 loop: -1 play:)
		(spike setPri: 9 init: stopUpd: hide:)
		(door init: stopUpd:)
		(killer setLoop: 2 setPri: 4 init: stopUpd:)
		(water
			view: 271
			loop: 1
			cel: 0
			posn: 212 35
			setPri: 11
			setCycle: Fwd
			init:
		)
		(knife view: 271 setLoop: 3 cel: 0 posn: 62 83 init: stopUpd:)
		(hand view: 171 loop: 6 cel: 0 posn: 187 57 setPri: 11 init: stopUpd:)
		(shadow
			view: 171
			loop: 0
			cel: 0
			posn: 189 81
			setPri: 11
			init:
			setScript: showerUp
		)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
	)
)

(instance showerUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(shadow setCycle: End self)
			)
			(1
				(shadow cel: 0 loop: 1 cycleSpeed: 1 setCycle: End self)
			)
			(2
				(shadow cel: 0 loop: 2 setCycle: End self)
			)
			(3
				(door setCycle: End self)
				(spike show:)
				(shadow setLoop: 3 cel: 0 cycleSpeed: 0 setCycle: Fwd)
			)
			(4
				(killer setCycle: Walk setMotion: MoveTo 30 115 self)
			)
			(5
				(door setCycle: Beg self)
				(spike setCycle: Beg)
			)
			(6
				(door dispose:)
				(spike dispose:)
				(shadow
					loop: 2
					cel: (- (NumCels shadow) 1)
					cycleSpeed: 1
					setCycle: Beg self
				)
			)
			(7
				(shadow loop: 4 setCycle: End self)
			)
			(8
				(shadow loop: 5 cel: 0 cycleSpeed: 0 setCycle: Fwd)
				(= seconds 3)
			)
			(9
				(myMusic stop:)
				(myMusic number: 8 loop: 1 play:)
				(knife setCycle: End setMotion: MoveTo 187 107 self)
			)
			(10
				(knife dispose:)
				(hand setCycle: End self)
			)
			(11
				(if (< (++ local0) 4)
					(switch local0
						(1
							(blood1
								view: 171
								loop: 7
								setPri: 12
								posn: 187 77
								setCycle: End
								init:
							)
						)
						(2
							(blood2
								view: 171
								loop: 8
								setPri: 12
								posn: 197 87
								setCycle: End
								init:
							)
						)
						(3
							(blood3
								view: 171
								loop: 9
								setPri: 12
								posn: 177 97
								setCycle: End
								init:
							)
							(blood4
								view: 271
								loop: 6
								setPri: 12
								posn: 180 122
								cycleSpeed: 1
								setCycle: End
								init:
							)
						)
					)
					(= state 9)
					(shadow view: 271 loop: 5 cycleSpeed: 1 setCycle: End)
					(self cue:)
				else
					(self cue:)
				)
			)
			(12
				(drip
					view: 271
					loop: 7
					posn: 181 145
					setCycle: Fwd
					cycleSpeed: 1
					init:
				)
				(shadow setCycle: End self)
			)
			(12
				(= seconds 7)
			)
			(13
				(= global128 271)
				(= global129 9)
				(EgoDead 215 0) ; "Didn't Alfred teach you anything?!"
			)
		)
	)
)

(instance shadow of Act
	(properties)
)

(instance killer of Act
	(properties
		y 95
		view 271
	)
)

(instance knife of Act
	(properties)
)

(instance door of Prop
	(properties
		y 49
		view 271
	)
)

(instance spike of Prop
	(properties
		y 50
		view 271
		loop 4
	)
)

(instance water of Prop
	(properties)
)

(instance hand of Prop
	(properties)
)

(instance blood1 of Prop
	(properties)
)

(instance blood2 of Prop
	(properties)
)

(instance blood3 of Prop
	(properties)
)

(instance blood4 of Prop
	(properties)
)

(instance drip of Prop
	(properties)
)

(instance myMusic of Sound
	(properties)
)

