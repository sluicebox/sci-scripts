;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room64 0
)

(local
	local0
	local1
)

(instance Room64 of Rm
	(properties
		picture 64
	)

	(method (init)
		(= horizon 0)
		(super init:)
		(gAddToPics add: RDoor doit:)
		(LDoor setPri: 14 stopUpd: init:)
		(Fifi setPri: 10 stopUpd: setScript: Undressing init:)
		(lArm setPri: 11 init:)
	)

	(method (doit &tmp temp0 temp1)
		(if (== (rArm loop:) 7)
			(switch (rArm cel:)
				(0
					(= temp0 30)
					(= temp1 10)
				)
				(1
					(= temp0 12)
					(= temp1 7)
				)
				(2
					(= temp0 1)
					(= temp1 1)
				)
			)
			(nightie posn: (- (rArm x:) temp0) (+ (rArm y:) temp1))
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)
)

(instance Undressing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= gFifiState 64)
				(lArm cycleSpeed: 2 setCycle: End self)
			)
			(1
				(lArm cycleSpeed: 2 setCycle: Beg self)
			)
			(2
				(dress setPri: 12 setCycle: End self init:)
				(bra setPri: 12 stopUpd: init:)
				(panties setPri: 12 stopUpd: init:)
				(hose setLoop: 1 setPri: 12 stopUpd: init:)
				(rArm setPri: 12 stopUpd: init:)
				(lArm loop: 4 cel: 0 posn: 148 56 stopUpd:)
				(Fifi cel: 1 forceUpd:)
			)
			(3
				(= local0 gSpeed)
				(gGame setSpeed: 1)
				(dress
					setLoop: 3
					setCel: 0
					posn: 143 125
					yStep: 6
					setMotion: MoveTo 143 161 self
				)
			)
			(4
				(HandsOn)
				(dress setCel: -1 cycleSpeed: 2 setCycle: End self)
			)
			(5
				(gGame setSpeed: local0)
				(dress stopUpd:)
				(HandsOff)
				(if local1
					(= state 4)
				)
				(= cycles 1)
			)
			(6
				(panties loop: 2 posn: 134 91 forceUpd:)
				(hose
					loop: 1
					posn: 144 109
					startUpd:
					setCycle: Walk
					setMotion: MoveTo 146 155 self
				)
			)
			(7
				(hose stopUpd:)
				(rArm setCel: 1 forceUpd:)
				(lArm setCel: 1 forceUpd:)
				(panties startUpd: setCycle: End self)
			)
			(8
				(rArm setCel: 0 forceUpd:)
				(lArm setCel: 0 forceUpd:)
				(panties
					setLoop: 3
					setCel: 0
					posn: 135 141
					setMotion: MoveTo 135 155 self
				)
			)
			(9
				(rArm setCel: 2 forceUpd:)
				(lArm setCel: 2 forceUpd:)
				(panties setCycle: End self)
			)
			(10
				(panties stopUpd:)
				(lArm setCel: 0 forceUpd:)
				(bra setCycle: End self)
			)
			(11
				(rArm setCel: 0 forceUpd:)
				(bra
					setLoop: 5
					setCel: 0
					posn: 131 71
					startUpd:
					setMotion: MoveTo 131 110 self
				)
			)
			(12
				(bra setCycle: End self)
			)
			(13
				(bra stopUpd:)
				(rArm loop: 6 cel: 0 startUpd: setCycle: End self)
			)
			(14
				(HandsOff)
				(if local1
					(= state 5)
					(= cycles 1)
				else
					(nightie setPri: 12 init:)
					(= cycles 1)
				)
			)
			(15
				(rArm loop: 7 cel: 0 setCycle: End self)
				(nightie cel: (- (NumCels nightie) 1))
			)
			(16
				(rArm loop: 5)
				(rArm cel: (- (NumCels rArm) 1))
				(lArm startUpd: setCycle: End self)
			)
			(17
				(rArm setCycle: Beg)
				(lArm setCycle: Beg)
				(nightie posn: 149 56 setCycle: Beg)
				(= seconds 3)
			)
			(18
				(HandsOn)
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance DoorOpening of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LDoor setCycle: End self)
			)
			(1
				(if (!= (dress cel:) (- (NumCels dress) 1))
					(= state 0)
				else
					(Print 64 0 #at 62 140) ; "Pleeze, Mademoiselle! Shut zee door!"
				)
				(= cycles 1)
			)
			(2
				(LDoor setCycle: Beg self)
			)
			(3
				(= local1 0)
				(client setScript: 0)
			)
		)
	)
)

(instance RDoor of PV
	(properties
		y 131
		x 213
		view 164
		priority 14
		signal 16384
	)
)

(instance LDoor of Prop
	(properties
		y 131
		x 106
		view 164
		loop 1
		signal 16384
		cycleSpeed 1
	)

	(method (handleEvent event)
		(if
			(and
				(not local1)
				(User canInput:)
				(or (MousedOn self event 3) (Said 'open/door'))
			)
			(event claimed: 1)
			(= local1 1)
			(LDoor setScript: DoorOpening)
		)
	)
)

(instance Fifi of Prop
	(properties
		y 158
		x 145
		view 473
		signal 16384
	)
)

(instance lArm of Prop
	(properties
		y 56
		x 138
		view 473
		loop 1
		signal 16384
	)
)

(instance rArm of Prop
	(properties
		y 56
		x 138
		view 473
		loop 5
		signal 16384
	)
)

(instance nightie of Prop
	(properties
		y 68
		x 92
		view 473
		loop 8
		signal 16384
	)
)

(instance dress of Act
	(properties
		y 110
		x 158
		yStep 6
		view 473
		loop 2
		signal 16384
		cycleSpeed 2
	)
)

(instance bra of Act
	(properties
		y 71
		x 131
		yStep 6
		view 463
		loop 4
		signal 16384
	)
)

(instance panties of Act
	(properties
		y 109
		x 146
		yStep 6
		view 463
		signal 16384
	)
)

(instance hose of Act
	(properties
		y 109
		x 144
		yStep 6
		view 463
		signal 16384
	)
)

