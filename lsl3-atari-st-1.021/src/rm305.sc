;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 305)
(include sci.sh)
(use Main)
(use n021)
(use AutoDoor)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm305 0
)

(local
	[local0 307]
)

(instance rm305 of Rm
	(properties
		picture 305
		east 250
		west 350
	)

	(method (init)
		(super init:)
		(gAddToPics
			add: atpPalmTree1
			add: atpPalmTree2
			add: atpPalmTree3
			add: atpPalmTree3a
			add: atpPalmTree4
			add: atpPalmTree5
			add: atpPalmTree6
			add: atpPalmTree7
			add: atpPalmTree8
			add: atpPalmTree9
			add: atpPalmTree10
			doit:
		)
		(if (> gMachineSpeed 16)
			(aSign setPri: 12 setCycle: Fwd isExtra: 1 init:)
		)
		(aDoor init:)
		(self setScript: RoomScript)
		(if (== gPrevRoomNum 350)
			(gEgo posn: 78 144 loop: 0)
		else
			(gEgo posn: 313 161)
		)
		(NormalEgo)
		(gEgo init:)
	)
)

(instance RoomScript of Script
	(properties)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'look<in/cup')
				(Print 305 0) ; "There are so few windows for such a large building -- and none of them open!"
			)
			((Said 'look>')
				(cond
					((Said '/awning')
						(Print 305 1) ; "It's blindingly tasteless."
					)
					((Said '/palm,palm')
						(Print 305 2) ; "What?! Can it be true? Could "Natives, Inc." really use cardboard palm trees?"
					)
					((Said '[/building,area]')
						(Print 305 3) ; "You are outside "Natives, Inc.," home of the island's major (and only) corporation."
						(if (not gEgoIsPatti)
							(Print 305 4 #at -1 144) ; "(You've always been a big fan of steel buildings!)"
						)
					)
				)
			)
		)
	)

	(method (changeState newState)
		(ShowState self newState 1 2)
		(switch (= state newState)
			(0
				(if (== gEgoState 4)
					(SetFlag 22) ; beenIn250
					(= gEgoState 0)
					(= state 1)
					(= cycles 20)
				)
			)
			(1)
			(2
				(Print 305 5) ; "That was humiliating, Larry. You vow never to work for HIM again!"
			)
		)
	)
)

(instance atpPalmTree1 of PV
	(properties
		y 128
		x 143
		view 305
		loop 1
		priority 9
	)
)

(instance atpPalmTree2 of PV
	(properties
		y 131
		x 183
		view 305
		loop 1
		priority 9
	)
)

(instance atpPalmTree3 of PV
	(properties
		y 135
		x 225
		view 305
		loop 1
		priority 9
	)
)

(instance atpPalmTree3a of PV
	(properties
		y 139
		x 266
		view 305
		loop 1
		priority 9
	)
)

(instance atpPalmTree4 of PV
	(properties
		y 144
		x 311
		view 305
		loop 1
		priority 10
	)
)

(instance atpPalmTree5 of PV
	(properties
		y 161
		x 42
		view 305
		loop 1
		cel 1
		priority 13
		signal 16384
	)
)

(instance atpPalmTree6 of PV
	(properties
		y 169
		x 90
		view 305
		loop 1
		cel 1
		priority 14
		signal 16384
	)
)

(instance atpPalmTree7 of PV
	(properties
		y 175
		x 140
		view 305
		loop 1
		cel 1
		priority 15
		signal 16384
	)
)

(instance atpPalmTree8 of PV
	(properties
		y 180
		x 190
		view 305
		loop 1
		cel 1
		priority 15
		signal 16384
	)
)

(instance atpPalmTree9 of PV
	(properties
		y 185
		x 238
		view 305
		loop 1
		cel 1
		priority 15
		signal 16384
	)
)

(instance atpPalmTree10 of PV
	(properties
		y 192
		x 287
		view 305
		loop 1
		cel 1
		priority 15
		signal 16384
	)
)

(instance aSign of Prop
	(properties
		y 60
		x 149
		view 305
		loop 2
	)
)

(instance aDoor of AutoDoor
	(properties
		y 86
		x 93
		view 305
		entranceTo 350
	)

	(method (init)
		(super init:)
		(self setPri: 5)
	)
)

