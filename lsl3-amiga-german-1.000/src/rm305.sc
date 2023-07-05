;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 305)
(include sci.sh)
(use Main)
(use n021)
(use AutoDoor)
(use Interface)
(use Language)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm305 0
)

(local
	[local0 2]
)

(instance rm305 of Rm
	(properties
		east 250
		west 350
	)

	(method (init)
		(= picture (LangSwitch 305 901))
		(super init:)
		(atpPalmTree1 init:)
		(atpPalmTree2 init:)
		(atpPalmTree3 init:)
		(atpPalmTree3a init:)
		(atpPalmTree4 init:)
		(atpPalmTree5 init:)
		(atpPalmTree6 init:)
		(atpPalmTree7 init:)
		(atpPalmTree8 init:)
		(atpPalmTree9 init:)
		(atpPalmTree10 init:)
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
			((Said 'look,look<in/cup')
				(Print 305 0) ; "There are so few windows for such a large building -- and none of them open!"
			)
			((Said 'look,look>')
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
					(SetFlag 22)
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

(instance atpPalmTree1 of PicView
	(properties
		x 143
		y 128
		loop 1
		priority 9
	)

	(method (init)
		(= view (LangSwitch 305 910))
		(super init:)
	)
)

(instance atpPalmTree2 of PicView
	(properties
		x 183
		y 131
		loop 1
		priority 9
	)

	(method (init)
		(= view (LangSwitch 305 910))
		(super init:)
	)
)

(instance atpPalmTree3 of PicView
	(properties
		x 225
		y 135
		loop 1
		priority 9
	)

	(method (init)
		(= view (LangSwitch 305 910))
		(super init:)
	)
)

(instance atpPalmTree3a of PicView
	(properties
		x 266
		y 139
		loop 1
		priority 9
	)

	(method (init)
		(= view (LangSwitch 305 910))
		(super init:)
	)
)

(instance atpPalmTree4 of PicView
	(properties
		x 311
		y 144
		loop 1
		priority 10
	)

	(method (init)
		(= view (LangSwitch 305 910))
		(super init:)
	)
)

(instance atpPalmTree5 of PicView
	(properties
		x 42
		y 161
		loop 1
		cel 1
		priority 13
		signal 16384
	)

	(method (init)
		(= view (LangSwitch 305 910))
		(super init:)
	)
)

(instance atpPalmTree6 of PicView
	(properties
		x 90
		y 169
		loop 1
		cel 1
		priority 14
		signal 16384
	)

	(method (init)
		(= view (LangSwitch 305 910))
		(super init:)
	)
)

(instance atpPalmTree7 of PicView
	(properties
		x 140
		y 175
		loop 1
		cel 1
		priority 15
		signal 16384
	)

	(method (init)
		(= view (LangSwitch 305 910))
		(super init:)
	)
)

(instance atpPalmTree8 of PicView
	(properties
		x 190
		y 180
		loop 1
		cel 1
		priority 15
		signal 16384
	)

	(method (init)
		(= view (LangSwitch 305 910))
		(super init:)
	)
)

(instance atpPalmTree9 of PicView
	(properties
		x 238
		y 185
		loop 1
		cel 1
		priority 15
		signal 16384
	)

	(method (init)
		(= view (LangSwitch 305 910))
		(super init:)
	)
)

(instance atpPalmTree10 of PicView
	(properties
		x 287
		y 192
		loop 1
		cel 1
		priority 15
		signal 16384
	)

	(method (init)
		(= view (LangSwitch 305 910))
		(super init:)
	)
)

(instance aSign of Prop
	(properties
		x 149
		y 60
		loop 2
	)

	(method (init)
		(= view (LangSwitch 305 910))
		(super init:)
	)
)

(instance aDoor of AutoDoor
	(properties
		x 93
		y 86
		entranceTo 350
	)

	(method (init)
		(= view (LangSwitch 305 910))
		(super init:)
		(self setPri: 5)
	)
)

